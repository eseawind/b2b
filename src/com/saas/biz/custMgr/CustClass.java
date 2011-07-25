package com.saas.biz.custMgr;

import com.saas.biz.commen.ParamethodMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.custDAO.CustLevelExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class CustClass
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();
  commMethodMgr comm = new commMethodMgr();

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void addCustClass(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCustClass方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CUST_ID");
      String str2 = paramBuffers.getString("SESSION_USER_ID");
      String str3 = paramBuffers.getString("START_DATE");
      String str4 = paramBuffers.getString("END_DATE");
      String str5 = paramBuffers.getString("REMARK");
      String str6 = paramBuffers.getString("CUST_CLASS");
      i = addCustClass(str1, str2, str3, str4, str5, str6);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addCustClass方法...");
  }

  public int addCustClass(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    CustLevelExt localCustLevelExt = new CustLevelExt();
    rightoutdate(paramString1);
    localCustLevelExt.setParam(":VCUST_ID", paramString1);
    localCustLevelExt.setParam(":VCUST_OPER_PERSON", paramString2);
    localCustLevelExt.setParam(":VSTART_DATE", paramString3);
    localCustLevelExt.setParam(":VEND_DATE", paramString4);
    localCustLevelExt.setParam(":VCUST_CLASS", paramString6);
    localCustLevelExt.setParam(":VREMARK", paramString5);
    this.tradeQuery.executeBy(localCustLevelExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateCustClass(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCustClass方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CUST_ID");
      String str2 = paramBuffers.getString("SESSION_USER_ID");
      String str3 = paramBuffers.getString("CUST_CLASS");
      String str4 = paramBuffers.getString("START_DATE");
      String str5 = paramBuffers.getString("END_DATE");
      this.log.LOG_INFO(str3 + "***********" + str4);
      this.log.LOG_INFO("***********" + str5);
      i = updateCustClass(str1, str3, str4, str5, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addCustClass方法...");
  }

  public int updateCustClass(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    CustLevelExt localCustLevelExt = new CustLevelExt();
    localCustLevelExt.setParam(":VOPER_CUST_ID", paramString5);
    localCustLevelExt.setParam(":VCUST_ID", paramString1);
    localCustLevelExt.setParam(":VSTART_DATE", paramString3);
    localCustLevelExt.setParam(":VEND_DATE", paramString4);
    localCustLevelExt.setParam(":VCUST_CLASS", paramString2);
    this.tradeQuery.executeBy(localCustLevelExt.insBy("UPDATE_CUST_CLASS"));
    return 0;
  }

  public void updateCustClassT(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCustClass方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CUST_ID");
      String str2 = paramBuffers.getString("CUST_CLASS");
      i = updateCustClassT(str1, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addCustClass方法...");
  }

  public int updateCustClassT(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustLevelExt localCustLevelExt = new CustLevelExt();
    localCustLevelExt.setParam(":VCUST_ID", paramString1);
    localCustLevelExt.setParam(":VCUST_CLASS", paramString2);
    this.tradeQuery.executeBy(localCustLevelExt.insBy("UPDATE_CUST_CLASS_T"));
    return 0;
  }

  public void genOneright(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genOneright方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("CUST_ID");
    try
    {
      this.queryResult = genOneright(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneright方法...");
  }

  public ArrayList genOneright(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustLevelExt localCustLevelExt = new CustLevelExt();
    localCustLevelExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustLevelExt.selByList("SEL_BY_ONE");
    return localArrayList;
  }

  public int rightoutdate(String paramString)
    throws SaasApplicationException
  {
    CustLevelExt localCustLevelExt = new CustLevelExt();
    localCustLevelExt.setParam(":VCUST_ID", paramString);
    this.tradeQuery.executeBy(localCustLevelExt.insBy("UPDATE_BY_CUST"));
    return 0;
  }

  public String cust_Class_Name(String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_DEBUG("进入cust_Class_Name方法");
    String str1 = "未知(请与管理员联系)";
    ArrayList localArrayList = genOneright(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      String str2 = "";
      if (localHashMap.get("cust_class") != null)
      {
        ParamethodMgr localParamethodMgr = new ParamethodMgr();
        str2 = localHashMap.get("cust_class").toString();
        str1 = localParamethodMgr.getParamNameByValue("14", str2);
      }
    }
    this.log.LOG_DEBUG("退出cust_Class_Name方法" + str1);
    return str1;
  }

  public String cust_Class_ID(String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_DEBUG("进入cust_Class_ID方法");
    String str = "";
    ArrayList localArrayList = genOneright(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_class") != null)
      {
        ParamethodMgr localParamethodMgr = new ParamethodMgr();
        str = localHashMap.get("cust_class").toString();
      }
    }
    this.log.LOG_DEBUG("退出cust_Class_Name方法" + str);
    return str;
  }

  public String cust_Class_Value(String paramString)
    throws SaasApplicationException
  {
    String str1 = "未知(请与管理员联系)";
    ArrayList localArrayList = genOneright(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      String str2 = "";
      if (localHashMap.get("cust_class") != null)
      {
        ParamethodMgr localParamethodMgr = new ParamethodMgr();
        str2 = localHashMap.get("cust_class").toString();
        str1 = localParamethodMgr.getParamListByValue("14", str2);
      }
    }
    return str1;
  }

  public String getCustClassById(String paramString)
    throws SaasApplicationException
  {
    String str = "1";
    ArrayList localArrayList = genOneright(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_class") != null)
        str = localHashMap.get("cust_class").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.custMgr.CustClass
 * JD-Core Version:    0.6.0
 */