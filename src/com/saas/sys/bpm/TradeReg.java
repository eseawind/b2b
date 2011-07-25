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

public class TradeReg
  implements TradeRegIntf
{
  Logger log = new Logger(this);
  Dbcommit commit;
  Dbexecute exec;
  TradeInit tradeInit;
  String check_trade_type_code = "1901";
  String check_tag = "0";

  public Buffers TradeRegInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入主控业务方法...");
    if (paramBuffers.getString("TRADE_TYPE_CODE") == "")
      throw new RuntimeException("业务类型域字段未赋值！");
    this.commit = new Dbcommit();
    this.exec = new Dbexecute();
    Buffers localBuffers = new Buffers();
    this.log.LOG_INFO("********获取业务类型参数开始*********************");
    TradeTypeDAO localTradeTypeDAO = new TradeTypeDAO();
    if ((this.check_tag.equals("1")) || (this.check_tag == "1"))
      localTradeTypeDAO.setParam(":VTRADETYPECODE", this.check_trade_type_code);
    else
      localTradeTypeDAO.setParam(":VTRADETYPECODE", paramBuffers.getString("TRADE_TYPE_CODE"));
    localTradeTypeDAO = localTradeTypeDAO.selByInfo("SEL_BY_PK");
    if (localTradeTypeDAO == null)
      throw new RuntimeException("业务类型未定义【" + paramBuffers.getString("TRADE_TYPE_CODE") + "】！");
    this.log.LOG_INFO("********获取业务类型参数结束*********************");
    BpmDefinitionDAO localBpmDefinitionDAO = new BpmDefinitionDAO();
    ArrayList localArrayList = new ArrayList();
    this.log.LOG_INFO("********获取业务流程定义开始*********************");
    if ((this.check_tag.equals("1")) || (this.check_tag == "1"))
      localBpmDefinitionDAO.setParam(":VTRADETYPECODE", this.check_trade_type_code);
    else
      localBpmDefinitionDAO.setParam(":VTRADETYPECODE", paramBuffers.getString("TRADE_TYPE_CODE"));
    localBpmDefinitionDAO.setParam(":VRSRV_STR6", "0");
    localArrayList = localBpmDefinitionDAO.selByList("SEL_BY_TYPE");
    if (localArrayList == null)
      throw new RuntimeException("业务流程未定义【" + paramBuffers.getString("TRADE_TYPE_CODE") + "】！");
    this.log.LOG_INFO("********获取业务流程定义结束*********************");
    this.commit.getConnect();
    this.exec.setConnectionHandle(this.commit.getConnectionHandle());
    try
    {
      String str = "";
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap = (HashMap)localIterator.next();
        Class localClass = Class.forName(localHashMap.get("node_class").toString().trim());
        Object localObject1 = localClass.newInstance();
        this.log.LOG_INFO("********输入参数开始*********************");
        paramBuffers.list();
        this.log.LOG_INFO("********输入参数结束*********************");
        Method localMethod = localObject1.getClass().getDeclaredMethod(localHashMap.get("node_method").toString().trim(), new Class[] { Buffers.class });
        this.log.LOG_INFO("********[开始执行原子业务方法<" + localMethod.getName() + ">]*********************");
        localMethod.invoke(localObject1, new Object[] { paramBuffers });
        this.log.LOG_INFO("********原子业务方法执行完毕*********************");
        str = localClass.getDeclaredField(localHashMap.get("out_query").toString().trim()).getName();
        Dbtable localDbtable = (Dbtable)PropertyUtils.getProperty(localObject1, str);
        this.log.LOG_INFO("********获取原子业务方法输出QUERY*********************");
        this.exec.addTable(localDbtable);
        this.exec.execBizQuery();
        this.log.LOG_INFO("********获取原子业务方法输出BUFFER*********************");
        str = localClass.getDeclaredField(localHashMap.get("out_buffer").toString().trim()).getName();
        localBuffers = (Buffers)PropertyUtils.getProperty(localObject1, str);
        this.log.LOG_INFO("********[结束执行原子业务方法<" + localMethod.getName() + ">]*********************");
        this.log.LOG_INFO("********输出参数开始*********************");
        localBuffers.list();
        this.log.LOG_INFO("********输出参数结束*********************");
        if (localBuffers.getInt("RESULT_CODE") == -1)
          break;
        paramBuffers = localBuffers;
        localMethod = null;
        localObject1 = null;
        localClass = null;
      }
      if (localBuffers.getInt("RESULT_CODE") != -1)
      {
        this.commit.tradeCommit();
        localBuffers.setString("SUCCEED_FWD", localTradeTypeDAO.getSucceed_fwd());
        this.commit.closeConn();
      }
      else
      {
        this.commit.rollback();
        localBuffers.setString("ERROR_FWD", localTradeTypeDAO.getError_fwd());
        this.commit.closeConn();
      }
      this.log.LOG_INFO("--------[全部业务流程处理完毕!]--------");
      this.log.LOG_INFO("********输出参数开始*********************");
      localBuffers.list();
      this.log.LOG_INFO("********输出参数结束*********************");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      this.commit.rollback();
      throw new RuntimeException("调用类未找到：" + localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      this.commit.rollback();
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      this.commit.rollback();
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      this.commit.rollback();
      throw new RuntimeException(localInvocationTargetException.getTargetException());
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      this.commit.rollback();
      throw new RuntimeException("调用方法未找到：" + localNoSuchMethodException);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      this.commit.rollback();
      throw new RuntimeException(localNoSuchFieldException);
    }
    finally
    {
      this.commit.closeConn();
    }
    this.log.LOG_INFO("退出主控业务方法...");
    return localBuffers;
  }

  public String getCheck_tag()
  {
    return this.check_tag;
  }

  public void setCheck_tag(String paramString)
  {
    this.check_tag = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.bpm.TradeReg
 * JD-Core Version:    0.6.0
 */