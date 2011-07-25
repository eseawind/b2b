package com.saas.biz.filingMgr;

import com.saas.biz.dao.filingDAO.FilingDAO;
import com.saas.biz.dao.filingDAO.FilingExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class FilingInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
  ArrayList queryResult = new ArrayList();

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void addConFilingInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addConFilingInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FILING_ID");
    String str3 = paramBuffers.getString("FILING_NAME");
    String str4 = paramBuffers.getString("FILING_ADDRESS");
    String str5 = paramBuffers.getString("FILING_DATE");
    String str6 = paramBuffers.getString("FILING_DESC");
    String str7 = paramBuffers.getString("OPER_DATE");
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    String str9 = paramBuffers.getString("REMARK");
    try
    {
      FilingDAO localFilingDAO = new FilingDAO();
      localFilingDAO.setCust_id(str1);
      localFilingDAO.setFiling_id(str2);
      localFilingDAO.setFiling_name(str3);
      localFilingDAO.setFiling_address(str4);
      localFilingDAO.setFiling_date(str5);
      localFilingDAO.setFiling_desc(str6);
      localFilingDAO.setOper_date(str7);
      localFilingDAO.setUser_id(str8);
      localFilingDAO.setRemark(str9);
      i = addConFilingInfo(localFilingDAO);
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
    this.log.LOG_INFO("退出addConFilingInfo方法...");
  }

  public int addConFilingInfo(FilingDAO paramFilingDAO)
    throws SaasApplicationException
  {
    FilingExt localFilingExt = new FilingExt();
    localFilingExt.setParam(":VCUST_ID", paramFilingDAO.getCust_id());
    localFilingExt.setParam(":VFILING_ID", paramFilingDAO.getFiling_id());
    localFilingExt.setParam(":VFILING_NAME", paramFilingDAO.getFiling_name());
    localFilingExt.setParam(":VFILING_ADDRESS", paramFilingDAO.getFiling_address());
    localFilingExt.setParam(":VFILING_DATE", paramFilingDAO.getFiling_date());
    localFilingExt.setParam(":VFILING_DESC", paramFilingDAO.getFiling_desc());
    localFilingExt.setParam(":VOPER_DATE", paramFilingDAO.getOper_date());
    localFilingExt.setParam(":VUSER_ID", paramFilingDAO.getUser_id());
    localFilingExt.setParam(":VREMARK", paramFilingDAO.getRemark());
    this.tradeQuery.executeBy(localFilingExt.insBy("INS_BY_CON_FILING"));
    return 0;
  }

  public ArrayList getFilingList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    FilingExt localFilingExt = new FilingExt();
    localFilingExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localFilingExt.selByList("SEL_BY_KKK", paramInt, 20);
    return localArrayList;
  }

  public int getFilingList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    FilingExt localFilingExt = new FilingExt();
    localFilingExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localFilingExt.selByList("SEL_BY_KKK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void ModiFilingInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入ModiFilingInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FILING_ID");
    String str3 = paramBuffers.getString("FILING_NAME");
    String str4 = paramBuffers.getString("FILING_ADDRESS");
    String str5 = paramBuffers.getString("FILING_DATE");
    String str6 = paramBuffers.getString("FILING_DESC");
    String str7 = paramBuffers.getString("OPER_DATE");
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    String str9 = paramBuffers.getString("REMARK");
    try
    {
      FilingDAO localFilingDAO = new FilingDAO();
      localFilingDAO.setCust_id(str1);
      localFilingDAO.setFiling_id(str2);
      localFilingDAO.setFiling_name(str3);
      localFilingDAO.setFiling_address(str4);
      localFilingDAO.setFiling_date(str5);
      localFilingDAO.setFiling_desc(str6);
      localFilingDAO.setOper_date(str7);
      localFilingDAO.setUser_id(str8);
      localFilingDAO.setRemark(str9);
      i = ModiFilingInfo(localFilingDAO);
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
    this.log.LOG_INFO("退出ModiFilingInfo方法...");
  }

  public int ModiFilingInfo(FilingDAO paramFilingDAO)
    throws SaasApplicationException
  {
    FilingExt localFilingExt = new FilingExt();
    localFilingExt.setParam(":VCUST_ID", paramFilingDAO.getCust_id());
    localFilingExt.setParam(":VFILING_ID", paramFilingDAO.getFiling_id());
    localFilingExt.setParam(":VFILING_NAME", paramFilingDAO.getFiling_name());
    localFilingExt.setParam(":VFILING_ADDRESS", paramFilingDAO.getFiling_address());
    localFilingExt.setParam(":VFILING_DATE", paramFilingDAO.getFiling_date());
    localFilingExt.setParam(":VFILING_DESC", paramFilingDAO.getFiling_desc());
    localFilingExt.setParam(":VOPER_DATE", paramFilingDAO.getOper_date());
    localFilingExt.setParam(":VUSER_ID", paramFilingDAO.getUser_id());
    localFilingExt.setParam(":VREMARK", paramFilingDAO.getRemark());
    this.tradeQuery.executeBy(localFilingExt.insBy("UP_BY_CON_FILING"));
    return 0;
  }

  public ArrayList getListByTradeId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    FilingExt localFilingExt = new FilingExt();
    localFilingExt.setParam(":VCUST_ID", paramString1);
    localFilingExt.setParam(":VTRADE_ID", paramString2);
    ArrayList localArrayList = localFilingExt.selByList("SEL_BY_TRADE_ID");
    return localArrayList;
  }

  public ArrayList getValueById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    FilingExt localFilingExt = new FilingExt();
    localFilingExt.setParam(":VCUST_ID", paramString);
    localArrayList = localFilingExt.selByList("SEL_BY_KKK");
    return localArrayList;
  }

  public ArrayList getOneValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    FilingExt localFilingExt = new FilingExt();
    localFilingExt.setParam(":VCUST_ID", paramString1);
    localFilingExt.setParam(":VFILING_ID", paramString2);
    localArrayList = localFilingExt.selByList("SEL_ONE_BY_FILING_ID");
    return localArrayList;
  }

  public void DelFilingInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DelFilingInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FILING_ID");
    try
    {
      FilingDAO localFilingDAO = new FilingDAO();
      localFilingDAO.setCust_id(str1);
      localFilingDAO.setFiling_id(str2);
      i = DelFilingInfo(localFilingDAO);
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
    this.log.LOG_INFO("退出DelFilingInfo方法...");
  }

  public int DelFilingInfo(FilingDAO paramFilingDAO)
    throws SaasApplicationException
  {
    FilingExt localFilingExt = new FilingExt();
    localFilingExt.setParam(":VCUST_ID", paramFilingDAO.getCust_id());
    localFilingExt.setParam(":VFILING_ID", paramFilingDAO.getFiling_id());
    this.tradeQuery.executeBy(localFilingExt.insBy("DEL_BY_CON_FILING"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.filingMgr.FilingInfo
 * JD-Core Version:    0.6.0
 */