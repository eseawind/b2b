package com.saas.biz.creditMgr;

import com.saas.biz.dao.creditDAO.CreditDAO;
import com.saas.biz.dao.creditDAO.CreditExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class CreditInfo
{
  Dbtable tradeQuery = new Dbtable();
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

  public void addCreditInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCreditInfo方法...");
    this.outBuffer = paramBuffers;
    CreditDAO localCreditDAO = new CreditDAO();
    this.outBuffer = paramBuffers;
    localCreditDAO.setCredit_title(paramBuffers.getString("CREDIT_TITLE"));
    localCreditDAO.setCredit_id(paramBuffers.getString("CREDIT_ID"));
    localCreditDAO.setCredit_type(paramBuffers.getString("CREDIT_TYPE"));
    localCreditDAO.setCredit_desc(paramBuffers.getString("CREDIT_DESC"));
    localCreditDAO.setCredit_start_date(paramBuffers.getString("CREDIT_START_DATE"));
    localCreditDAO.setCredit_end_date(paramBuffers.getString("CREDIT_END_DATE"));
    localCreditDAO.setCredit_department(paramBuffers.getString("CREDIT_DEPARTMENT"));
    localCreditDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localCreditDAO.setCredit_publish_person(paramBuffers.getString("SESSION_USER_NAME"));
    int i = -1;
    try
    {
      i = addCreditInfo(localCreditDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "证书业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addCreditInfo方法...");
  }

  public int addCreditInfo(CreditDAO paramCreditDAO)
    throws SaasApplicationException
  {
    CreditExt localCreditExt = new CreditExt();
    localCreditExt.setParam(":VCREDIT_ID", paramCreditDAO.getCredit_id());
    localCreditExt.setParam(":VCUST_ID", paramCreditDAO.getCust_id());
    localCreditExt.setParam(":VAFFIX_ID", "0");
    localCreditExt.setParam(":VCREDIT_DEPARTMENT", paramCreditDAO.getCredit_department());
    localCreditExt.setParam(":VCREDIT_END_DATE", paramCreditDAO.getCredit_end_date());
    localCreditExt.setParam(":VCREDIT_START_DATE", paramCreditDAO.getCredit_start_date());
    localCreditExt.setParam(":VCREDIT_DESC", paramCreditDAO.getCredit_desc());
    localCreditExt.setParam(":VCREDIT_TYPE", paramCreditDAO.getCredit_type());
    localCreditExt.setParam(":VCREDIT_TITLE", paramCreditDAO.getCredit_title());
    localCreditExt.setParam(":VCREDIT_PUBLISH_PERSON", paramCreditDAO.getCredit_publish_person());
    localCreditExt.setParam(":VCREDIT_CLASS", "0");
    localCreditExt.setParam(":VCREDIT_VALIDITY", "0");
    localCreditExt.setParam(":VCREDIT_AUDIT_PERSON", "");
    localCreditExt.setParam(":VCREDIT_RSRV", "");
    this.log.LOG_INFO("参数完成..................");
    this.tradeQuery.executeBy(localCreditExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateCreditInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCreditInfo方法...");
    this.outBuffer = paramBuffers;
    CreditDAO localCreditDAO = new CreditDAO();
    this.outBuffer = paramBuffers;
    localCreditDAO.setCredit_title(paramBuffers.getString("CREDIT_TITLE"));
    localCreditDAO.setCredit_id(paramBuffers.getString("CREDIT_ID"));
    localCreditDAO.setCredit_type(paramBuffers.getString("CREDIT_TYPE"));
    localCreditDAO.setCredit_desc(paramBuffers.getString("CREDIT_DESC"));
    localCreditDAO.setCredit_start_date(paramBuffers.getString("CREDIT_START_DATE"));
    localCreditDAO.setCredit_end_date(paramBuffers.getString("CREDIT_END_DATE"));
    localCreditDAO.setCredit_department(paramBuffers.getString("CREDIT_DEPARTMENT"));
    localCreditDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localCreditDAO.setCredit_publish_person(paramBuffers.getString("SESSION_USER_NAME"));
    int i = -1;
    try
    {
      String str = paramBuffers.getString("CREDIT_ID");
      i = updateCreditInfo(localCreditDAO);
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
    this.log.LOG_INFO("退出addCreditInfo方法...");
  }

  public int updateCreditInfo(CreditDAO paramCreditDAO)
    throws SaasApplicationException
  {
    CreditExt localCreditExt = new CreditExt();
    localCreditExt.setParam(":VCREDIT_ID", paramCreditDAO.getCredit_id());
    localCreditExt.setParam(":VCUST_ID", paramCreditDAO.getCust_id());
    localCreditExt.setParam(":VAFFIX_ID", "0");
    localCreditExt.setParam(":VCREDIT_DEPARTMENT", paramCreditDAO.getCredit_department());
    localCreditExt.setParam(":VCREDIT_END_DATE", paramCreditDAO.getCredit_end_date());
    localCreditExt.setParam(":VCREDIT_START_DATE", paramCreditDAO.getCredit_start_date());
    localCreditExt.setParam(":VCREDIT_DESC", paramCreditDAO.getCredit_desc());
    localCreditExt.setParam(":VCREDIT_TYPE", paramCreditDAO.getCredit_type());
    localCreditExt.setParam(":VCREDIT_TITLE", paramCreditDAO.getCredit_title());
    localCreditExt.setParam(":VCREDIT_PUBLISH_PERSON", paramCreditDAO.getCredit_publish_person());
    localCreditExt.setParam(":VCREDIT_CLASS", "0");
    localCreditExt.setParam(":VCREDIT_VALIDITY", "0");
    localCreditExt.setParam(":VCREDIT_AUDIT_PERSON", "");
    localCreditExt.setParam(":VCREDIT_RSRV", "");
    this.log.LOG_INFO("参数完成..................");
    this.tradeQuery.executeBy(localCreditExt.insBy("UP_BY_CREDIT_ID"));
    return 0;
  }

  public void genCustCredit(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genCustCredit方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("SESSION_CUST_ID");
    try
    {
      this.queryResult = genCustCredit(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genCustCredit方法...");
  }

  public ArrayList genCustCredit(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CreditExt localCreditExt = new CreditExt();
    localCreditExt.setParam(":VCUST_ID", paramString);
    localCreditExt.setParam(":VCREDIT_VALIDITY", "0");
    localArrayList = localCreditExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public void genOneCredit(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genOneCredit方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("CREDIT_ID");
    try
    {
      this.queryResult = genOneCredit(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneCredit方法...");
  }

  public ArrayList genOneCredit(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CreditExt localCreditExt = new CreditExt();
    localCreditExt.setParam(":VCREDIT_ID", paramString);
    localArrayList = localCreditExt.selByList("SEL_BY_ONE");
    return localArrayList;
  }

  public void invalidinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入invalidinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("CREDIT_ID");
    try
    {
      i = invalidinfo(str);
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
    this.log.LOG_INFO("退出invalidinfo方法...");
  }

  public int invalidinfo(String paramString)
    throws SaasApplicationException
  {
    CreditExt localCreditExt = new CreditExt();
    localCreditExt.setParam(":VCREDIT_ID", paramString);
    this.tradeQuery.executeBy(localCreditExt.insBy("DEL_CREDIT_BY_ONE"));
    return 0;
  }

  public ArrayList getCustCredit(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    CreditExt localCreditExt = new CreditExt();
    localCreditExt.setParam(":VCUST_ID", paramString);
    localCreditExt.setParam(":VCREDIT_VALIDITY", "0");
    localArrayList = localCreditExt.selByList("SEL_BY_CUST", paramInt, 30);
    return localArrayList;
  }

  public int getCreditNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CreditExt localCreditExt = new CreditExt();
    localCreditExt.setParam(":VCUST_ID", paramString);
    localCreditExt.setParam(":VCREDIT_VALIDITY", "0");
    localArrayList = localCreditExt.selByList("SEL_BY_CUST");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.creditMgr.CreditInfo
 * JD-Core Version:    0.6.0
 */