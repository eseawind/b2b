package com.saas.biz.verifyMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.commen.config;
import com.saas.biz.dao.custDAO.CustLevelExt;
import com.saas.biz.dao.verifyDAO.VerifyDAO;
import com.saas.biz.dao.verifyDAO.VerifyExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class VerifyInfo
{
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr comm = new commMethodMgr();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();

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

  public void addVerifyInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addVerifyInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("VERIFY_ID");
    String str3 = paramBuffers.getString("VERIFY_TYPE");
    String str4 = paramBuffers.getString("VERIFY_STATUS");
    String str5 = paramBuffers.getString("VERIFY_NAME");
    String str6 = paramBuffers.getString("REQ_DESC");
    String str7 = paramBuffers.getString("REQ_DATE");
    String str8 = paramBuffers.getString("OPER_DATE");
    String str9 = paramBuffers.getString("OPER_USER");
    String str10 = paramBuffers.getString("REMARK");
    try
    {
      VerifyDAO localVerifyDAO = new VerifyDAO();
      localVerifyDAO.setCust_id(str1);
      localVerifyDAO.setVerify_id(str2);
      localVerifyDAO.setVerify_type(str3);
      localVerifyDAO.setVerify_status(str4);
      localVerifyDAO.setVerify_name(str5);
      localVerifyDAO.setReq_desc(str6);
      localVerifyDAO.setReq_date(str7);
      localVerifyDAO.setOper_date(str8);
      localVerifyDAO.setOper_user(str9);
      localVerifyDAO.setRemark(str10);
      i = addVerifyInfo(localVerifyDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
    this.log.LOG_INFO("退出addVerinfoInfo方法...");
  }

  public int addVerifyInfo(VerifyDAO paramVerifyDAO)
    throws SaasApplicationException
  {
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VCUST_ID", paramVerifyDAO.getCust_id());
    localVerifyExt.setParam(":VERIFY_ID", paramVerifyDAO.getVerify_id());
    localVerifyExt.setParam(":VERIFY_TYPE", paramVerifyDAO.getVerify_type());
    localVerifyExt.setParam(":VERIFY_STATUS", paramVerifyDAO.getVerify_status());
    localVerifyExt.setParam(":VERIFY_NAME", paramVerifyDAO.getVerify_name());
    localVerifyExt.setParam(":VREQ_DESC", paramVerifyDAO.getReq_desc());
    localVerifyExt.setParam(":VREQ_DATE", paramVerifyDAO.getReq_date());
    localVerifyExt.setParam(":VOPER_DATE", paramVerifyDAO.getOper_date());
    localVerifyExt.setParam(":VOPER_USER", paramVerifyDAO.getOper_user());
    localVerifyExt.setParam(":VREMARK", paramVerifyDAO.getRemark());
    this.tradeQuery.executeBy(localVerifyExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateVerifyInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addVerifyInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("VERIFY_ID");
    String str3 = paramBuffers.getString("VERIFY_NAME");
    String str4 = paramBuffers.getString("VERIFY_STATUS");
    String str5 = paramBuffers.getString("REMARK");
    try
    {
      VerifyDAO localVerifyDAO = new VerifyDAO();
      localVerifyDAO.setCust_id(str1);
      localVerifyDAO.setVerify_id(str2);
      localVerifyDAO.setVerify_status(str4);
      localVerifyDAO.setVerify_name(str3);
      localVerifyDAO.setRemark(str5);
      i = updateVerifyInfo(localVerifyDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
    this.log.LOG_INFO("退出addVerinfoInfo方法...");
  }

  public String getVerifyStatusByCId(String paramString)
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VCUST_ID", paramString);
    localArrayList = localVerifyExt.selByList("GET_VERSTATUS_BY_ID");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (null != localHashMap.get("verify_status"))
        str = localHashMap.get("verify_status").toString();
    }
    return str;
  }

  public String getVerifyIdByCustId(String paramString)
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VCUST_ID", paramString);
    localArrayList = localVerifyExt.selByList("GET_VERSTATUS_BY_ID");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (null != localHashMap.get("verify_id"))
        str = localHashMap.get("verify_id").toString();
    }
    return str;
  }

  public int updateVerifyInfo(VerifyDAO paramVerifyDAO)
    throws SaasApplicationException
  {
    String str = paramVerifyDAO.getVerify_status();
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VCUST_ID", paramVerifyDAO.getCust_id());
    localVerifyExt.setParam(":VERIFY_ID", paramVerifyDAO.getVerify_id());
    localVerifyExt.setParam(":VERIFY_STATUS", str);
    localVerifyExt.setParam(":VERIFY_NAME", paramVerifyDAO.getVerify_name());
    localVerifyExt.setParam(":VREMARK", paramVerifyDAO.getRemark());
    this.tradeQuery.executeBy(localVerifyExt.insBy("UPDATE_VERIFY_STATUS"));
    if ((str == "1") || (str.equals("1")))
    {
      CustLevelExt localCustLevelExt = new CustLevelExt();
      localCustLevelExt.setParam(":VCUST_ID", paramVerifyDAO.getCust_id());
      localCustLevelExt.setParam(":VEND_DATE", "2050-01-01");
      localCustLevelExt.setParam(":VCUST_CLASS", "2");
      this.tradeQuery.executeBy(localCustLevelExt.insBy("COPY_UPDATE_CUST_CLASSS"));
    }
    return 0;
  }

  public void addVerifyTwo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addVerifyInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    int j = -1;
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str1 = localcommMethodMgr.GenTradeId();
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = getVerifyIdByCustId(str2);
    config localconfig = new config();
    localconfig.init();
    String str4 = localconfig.getString("examine");
    try
    {
      if ((str3.equals("")) && (str4.equals("0")))
      {
        i = addVerifyTwo(str2, str1);
        j = InsertVerifyInfoTwo(str2);
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if ((i != 0) && (j != 0))
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addVerinfoInfo方法...");
  }

  public int addVerifyTwo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VCUST_ID", paramString1);
    localVerifyExt.setParam(":VERIFY_ID", paramString2);
    localVerifyExt.setParam(":VERIFY_TYPE", "0");
    localVerifyExt.setParam(":VERIFY_STATUS", "1");
    localVerifyExt.setParam(":VERIFY_NAME", "默认通过");
    localVerifyExt.setParam(":VREQ_DESC", "默认通过");
    localVerifyExt.setParam(":VOPER_USER", "");
    localVerifyExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localVerifyExt.insBy("INS_BY_ALL_TACIT"));
    return 0;
  }

  public int InsertVerifyInfoTwo(String paramString)
    throws SaasApplicationException
  {
    CustLevelExt localCustLevelExt = new CustLevelExt();
    localCustLevelExt.setParam(":VCUST_ID", paramString);
    localCustLevelExt.setParam(":VEND_DATE", "2050-01-01");
    localCustLevelExt.setParam(":VCUST_CLASS", "2");
    this.tradeQuery.executeBy(localCustLevelExt.insBy("COPY_UPDATE_CUST_CLASSS"));
    return 0;
  }

  public boolean ifCertifed(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VCUST_ID", paramString);
    localArrayList = localVerifyExt.selByList("SEL_STATUS_BY_CUSTID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (1 == Integer.parseInt(localHashMap.get("verify_type").toString()))
        return true;
    }
    return false;
  }

  public ArrayList genCustVerifyByCust_id(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt > 0)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VERIFY_STATUS", paramString);
    localArrayList = localVerifyExt.selByList("SEL_BY_STATUS", paramInt, 30);
    return localArrayList;
  }

  public ArrayList genVerifyByCust_id(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VCUST_ID", paramString);
    localArrayList = localVerifyExt.selByList("SEL_BY_CUST_ID_VEF");
    return localArrayList;
  }

  public int getVerifyNumber(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VERIFY_STATUS", paramString);
    localArrayList = localVerifyExt.selByList("SEL_BY_STATUS_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public void genOneVerify(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genCustAdvertise方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("VERIFY_ID");
    try
    {
      this.queryResult = genOneVerify(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genCustAdvertise方法...");
  }

  public ArrayList genOneVerify(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    VerifyExt localVerifyExt = new VerifyExt();
    localVerifyExt.setParam(":VERIFY_ID", paramString);
    localArrayList = localVerifyExt.selByList("SEL_BY_ONE");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.verifyMgr.VerifyInfo
 * JD-Core Version:    0.6.0
 */