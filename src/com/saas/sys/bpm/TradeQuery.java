package com.saas.sys.bpm;

import com.saas.sys.buffer.Buffers;
import com.saas.sys.log.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

public class TradeQuery
  implements TradeQueryIntf
{
  Logger log = new Logger(this);
  Buffers outBuffer = new Buffers();

  public ArrayList ExecTradeQuery(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入主控业务方法...");
    if (paramBuffers.getString("TRADE_TYPE_CODE") == "")
      throw new RuntimeException("业务类型域字段未赋值！");
    ArrayList localArrayList1 = new ArrayList();
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("********获取业务类型参数开始*********************");
    TradeTypeDAO localTradeTypeDAO = new TradeTypeDAO();
    localTradeTypeDAO.setParam(":VTRADETYPECODE", paramBuffers.getString("TRADE_TYPE_CODE"));
    localTradeTypeDAO = localTradeTypeDAO.selByInfo("SEL_BY_PK");
    if (localTradeTypeDAO == null)
      throw new RuntimeException("业务类型未定义！");
    this.log.LOG_INFO("********获取业务类型参数结束*********************");
    this.log.LOG_INFO("********获取业务流程定义开始*********************");
    BpmDefinitionDAO localBpmDefinitionDAO = new BpmDefinitionDAO();
    ArrayList localArrayList2 = new ArrayList();
    localBpmDefinitionDAO.setParam(":VTRADETYPECODE", paramBuffers.getString("TRADE_TYPE_CODE"));
    localArrayList2 = localBpmDefinitionDAO.selByList("SEL_BY_PK");
    int i = 0;
    if (localArrayList2 == null)
      throw new RuntimeException("业务流程未定义！");
    this.log.LOG_INFO("********获取业务流程定义结束*********************");
    try
    {
      String str = "";
      Iterator localIterator = localArrayList2.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap = (HashMap)localIterator.next();
        Class localClass = Class.forName(localHashMap.get("node_class").toString());
        ArrayList localArrayList3 = new ArrayList();
        Object localObject = localClass.newInstance();
        this.log.LOG_INFO("********输入参数开始*********************");
        paramBuffers.list();
        this.log.LOG_INFO("********输入参数结束*********************");
        Method localMethod = localObject.getClass().getDeclaredMethod(localHashMap.get("node_method").toString(), new Class[] { Buffers.class });
        this.log.LOG_INFO("********[开始执行原子业务方法<" + localMethod.getName() + ">]*********************");
        localMethod.invoke(localObject, new Object[] { paramBuffers });
        this.log.LOG_INFO("********原子业务方法执行完毕*********************");
        str = localClass.getDeclaredField(localHashMap.get("out_query").toString()).getName();
        this.log.LOG_INFO("********<" + localHashMap.get("out_query").toString() + ">*********************");
        if (localHashMap.get("rsrv_str5").toString().equalsIgnoreCase("1"))
        {
          localArrayList3 = (ArrayList)PropertyUtils.getProperty(localObject, str);
          str = localClass.getDeclaredField(localHashMap.get("out_buffer").toString().trim()).getName();
          this.outBuffer = ((Buffers)PropertyUtils.getProperty(localObject, str));
          localArrayList1.add(i, localArrayList3);
          paramBuffers = this.outBuffer;
        }
        else
        {
          localArrayList1 = (ArrayList)PropertyUtils.getProperty(localObject, str);
        }
        i += 1;
        this.log.LOG_INFO("********获取原子业务方法输出ArrayList*********************");
        this.log.LOG_INFO("********[结束执行原子业务方法<" + localMethod.getName() + ">]*********************");
      }
      if (this.outBuffer.getInt("RESULT_CODE") != -1)
        this.outBuffer.setString("SUCCEED_FWD", localTradeTypeDAO.getSucceed_fwd());
      else
        this.outBuffer.setString("ERROR_FWD", localTradeTypeDAO.getError_fwd());
      this.log.LOG_INFO("********输入参数开始*********************");
      this.outBuffer.list();
      this.log.LOG_INFO("********输入参数结束*********************");
      this.log.LOG_INFO("--------[全部业务流程处理完毕!]--------");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException("调用类未找到：" + localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException(localInvocationTargetException.getTargetException());
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException("调用方法未找到：" + localNoSuchMethodException);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
    this.log.LOG_INFO("退出主控业务方法...");
    return localArrayList1;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.bpm.TradeQuery
 * JD-Core Version:    0.6.0
 */