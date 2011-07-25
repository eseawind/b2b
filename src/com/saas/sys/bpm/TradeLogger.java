package com.saas.sys.bpm;

import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbcommit;
import com.saas.sys.dbm.Dbexecute;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.log.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

public class TradeLogger
  implements TradeLoggerIntf
{
  Logger log = new Logger(this);
  Buffers outBuffer = new Buffers();
  Dbcommit commit;
  Dbexecute exec;
  TradeInit tradeInit;

  public ArrayList ExecTradeLogger(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入主控业务方法...");
    this.commit = new Dbcommit();
    this.exec = new Dbexecute();
    Buffers localBuffers = new Buffers();
    if (paramBuffers.getString("TRADE_TYPE_CODE") == "")
      throw new RuntimeException("业务类型域字段未赋值！");
    localBuffers = paramBuffers;
    ArrayList localArrayList1 = new ArrayList();
    this.log.LOG_INFO("********获取业务类型参数开始*********************");
    TradeTypeDAO localTradeTypeDAO = new TradeTypeDAO();
    localTradeTypeDAO.setParam(":VTRADETYPECODE", "1901");
    localTradeTypeDAO = localTradeTypeDAO.selByInfo("SEL_BY_PK");
    if (localTradeTypeDAO == null)
      throw new RuntimeException("日志类业务类型未定义【1901】！");
    this.log.LOG_INFO("********获取业务类型参数结束*********************");
    this.log.LOG_INFO("********获取业务流程定义开始*********************");
    BpmDefinitionDAO localBpmDefinitionDAO = new BpmDefinitionDAO();
    ArrayList localArrayList2 = new ArrayList();
    localBpmDefinitionDAO.setParam(":VTRADETYPECODE", "1901");
    localArrayList2 = localBpmDefinitionDAO.selByList("SEL_BY_PK");
    int i = 0;
    if (localArrayList2 == null)
      throw new RuntimeException("业务流程未定义！");
    this.log.LOG_INFO("********获取业务流程定义结束*********************");
    this.commit.getConnect();
    this.exec.setConnectionHandle(this.commit.getConnectionHandle());
    try
    {
      String str = "";
      Iterator localIterator = localArrayList2.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap = (HashMap)localIterator.next();
        Class localClass = Class.forName(localHashMap.get("node_class").toString().trim());
        Object localObject = localClass.newInstance();
        this.log.LOG_INFO("********输入参数开始*********************");
        paramBuffers.list();
        this.log.LOG_INFO("********输入参数结束*********************");
        Method localMethod = localObject.getClass().getDeclaredMethod(localHashMap.get("node_method").toString().trim(), new Class[] { Buffers.class });
        this.log.LOG_INFO("********[开始执行原子业务方法<" + localMethod.getName() + ">]*********************");
        localMethod.invoke(localObject, new Object[] { paramBuffers });
        this.log.LOG_INFO("********原子业务方法执行完毕*********************");
        str = localClass.getDeclaredField(localHashMap.get("out_query").toString().trim()).getName();
        Dbtable localDbtable = (Dbtable)PropertyUtils.getProperty(localObject, str);
        this.log.LOG_INFO("********获取原子业务方法输出QUERY*********************");
        this.exec.addTable(localDbtable);
        this.log.LOG_INFO(this.exec.getQuery() + "fieldName:" + str);
        this.exec.execBizQuery();
        this.log.LOG_INFO("********获取原子业务方法输出BUFFER*********************");
        str = localClass.getDeclaredField(localHashMap.get("out_buffer").toString().trim()).getName();
        localBuffers = (Buffers)PropertyUtils.getProperty(localObject, str);
        this.log.LOG_INFO("********[结束执行原子业务方法<" + localMethod.getName() + ">]*********************");
        this.log.LOG_INFO("********输出参数开始*********************");
        localBuffers.list();
        this.log.LOG_INFO("********输出参数结束*********************");
        if (localBuffers.getInt("RESULT_CODE") == -1)
          break;
        paramBuffers = localBuffers;
      }
      if (localBuffers.getInt("RESULT_CODE") != -1)
      {
        this.commit.tradeCommit();
        localBuffers.setString("SUCCEED_FWD", paramBuffers.getString("SUCCEED_FWD"));
      }
      else
      {
        localBuffers.setString("ERROR_FWD", paramBuffers.getString("ERROR_FWD"));
      }
      this.log.LOG_INFO("--------[全部业务流程处理完毕!]--------");
      this.log.LOG_INFO("********输出参数开始*********************");
      localBuffers.list();
      this.log.LOG_INFO("********输出参数结束*********************");
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
      throw new RuntimeException("JAVABEAN的域字段未找到：" + localNoSuchFieldException);
    }
    this.log.LOG_INFO("退出主控业务方法...");
    return localArrayList1;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.bpm.TradeLogger
 * JD-Core Version:    0.6.0
 */