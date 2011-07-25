package com.saas.biz.enquirydealMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.enquirytrackDAO.EnquirytrackDAO;
import com.saas.biz.dao.enquirytrackDAO.EnquirytrackExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EnquirydInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  commMethodMgr comm = new commMethodMgr();
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

  public void addEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = this.comm.GenTradeId();
    String str2 = paramBuffers.getString("CUST_ID");
    String str3 = paramBuffers.getString("USER_ID");
    String str4 = paramBuffers.getString("SALE_ID");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("SESSION_USER_ID");
    String str7 = paramBuffers.getString("DEAL_TAG");
    String str8 = paramBuffers.getString("RSRV_STR3");
    String str9 = paramBuffers.getString("RSRV_STR4");
    String str10 = paramBuffers.getString("RSRV_STR5");
    int i = -1;
    try
    {
      EnquirytrackDAO localEnquirytrackDAO = new EnquirytrackDAO();
      localEnquirytrackDAO.setCust_id(str2);
      localEnquirytrackDAO.setTrade_id(str1);
      localEnquirytrackDAO.setUser_id(str3);
      localEnquirytrackDAO.setSale_id(str4);
      localEnquirytrackDAO.setEnquiry_content(str5);
      localEnquirytrackDAO.setEnquiry_user(str6);
      localEnquirytrackDAO.setDeal_tag(str7);
      localEnquirytrackDAO.setRsrv_str3(str8);
      localEnquirytrackDAO.setRsrv_str4(str9);
      localEnquirytrackDAO.setRsrv_str5(str10);
      i = addEnquiryInfo(localEnquirytrackDAO);
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
    this.log.LOG_INFO("退出addEnquiryInfo方法...");
  }

  public int addEnquiryInfo(EnquirytrackDAO paramEnquirytrackDAO)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    String str = paramEnquirytrackDAO.getEnquiry_content();
    str = str.replaceAll("&", "&amp;");
    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;");
    str = str.replaceAll(" ", "&nbsp;");
    str = str.replaceAll("'", "&#39;");
    str = str.replaceAll("\"", "&quot;");
    str = str.replaceAll("\n", "<br>");
    localEnquirytrackExt.setParam(":VCUST_ID", paramEnquirytrackDAO.getCust_id());
    localEnquirytrackExt.setParam(":VTRADE_ID", paramEnquirytrackDAO.getTrade_id());
    localEnquirytrackExt.setParam(":VUSER_ID", paramEnquirytrackDAO.getUser_id());
    localEnquirytrackExt.setParam(":VSALE_ID", paramEnquirytrackDAO.getSale_id());
    localEnquirytrackExt.setParam(":VENQUIRY_CONTENT", str);
    localEnquirytrackExt.setParam(":VENQUIRY_USER", paramEnquirytrackDAO.getEnquiry_user());
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramEnquirytrackDAO.getDeal_tag());
    localEnquirytrackExt.setParam(":VRSRV_STR1", "0");
    localEnquirytrackExt.setParam(":VRSRV_STR3", paramEnquirytrackDAO.getRsrv_str3());
    localEnquirytrackExt.setParam(":VRSRV_STR4", paramEnquirytrackDAO.getRsrv_str4());
    localEnquirytrackExt.setParam(":VRSRV_STR5", paramEnquirytrackDAO.getRsrv_str5());
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("INS_BY_ENQURIY"));
    return 0;
  }

  public void addNewEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = this.comm.GenTradeId();
    String str2 = paramBuffers.getString("CUST_ID");
    String str3 = paramBuffers.getString("USER_ID");
    String str4 = paramBuffers.getString("SALE_ID");
    String str5 = paramBuffers.getString("MOUNT");
    String str6 = paramBuffers.getString("CUST_ADV_ID");
    String str7 = paramBuffers.getString("CONTENT");
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    String str9 = paramBuffers.getString("DEAL_TAG");
    String str10 = paramBuffers.getString("RSRV_STR3");
    String str11 = paramBuffers.getString("RSRV_STR4");
    String str12 = paramBuffers.getString("RSRV_STR5");
    int i = -1;
    try
    {
      EnquirytrackDAO localEnquirytrackDAO = new EnquirytrackDAO();
      localEnquirytrackDAO.setCust_id(str2);
      localEnquirytrackDAO.setTrade_id(str1);
      localEnquirytrackDAO.setUser_id(str3);
      localEnquirytrackDAO.setSale_id(str4);
      localEnquirytrackDAO.setEnquiry_content(str7);
      localEnquirytrackDAO.setEnquiry_user(str8);
      localEnquirytrackDAO.setDeal_tag(str9);
      localEnquirytrackDAO.setRsrv_str3(str10);
      localEnquirytrackDAO.setRsrv_str4(str11);
      localEnquirytrackDAO.setRsrv_str5(str12);
      i = addNewEnquiryInfo(localEnquirytrackDAO, str6, str5);
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
    this.log.LOG_INFO("退出addEnquiryInfo方法...");
  }

  public int addNewEnquiryInfo(EnquirytrackDAO paramEnquirytrackDAO, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramEnquirytrackDAO.getCust_id());
    localEnquirytrackExt.setParam(":VTRADE_ID", paramEnquirytrackDAO.getTrade_id());
    localEnquirytrackExt.setParam(":VUSER_ID", paramEnquirytrackDAO.getUser_id());
    localEnquirytrackExt.setParam(":VSALE_ID", paramEnquirytrackDAO.getSale_id());
    localEnquirytrackExt.setParam(":VENQUIRY_CONTENT", paramEnquirytrackDAO.getEnquiry_content());
    localEnquirytrackExt.setParam(":VENQUIRY_USER", paramEnquirytrackDAO.getEnquiry_user());
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramEnquirytrackDAO.getDeal_tag());
    localEnquirytrackExt.setParam(":VRSRV_STR1", "0");
    localEnquirytrackExt.setParam(":VRSRV_STR3", paramEnquirytrackDAO.getRsrv_str3());
    localEnquirytrackExt.setParam(":VRSRV_STR4", paramEnquirytrackDAO.getRsrv_str4());
    localEnquirytrackExt.setParam(":VRSRV_STR5", paramEnquirytrackDAO.getRsrv_str5());
    localEnquirytrackExt.setParam(":VATTPRICE", paramString1);
    localEnquirytrackExt.setParam(":VMOUNT", paramString2);
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("INS_BY_ENQURIY_NEW"));
    return 0;
  }

  public ArrayList getEnquriyInfoByTag(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString3);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_TAG", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getEnquriyInfoByDate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString3);
    localEnquirytrackExt.setParam(":VSTART_DATE", paramString4);
    localEnquirytrackExt.setParam(":VEND_DATE", paramString5);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_DATE", paramInt, 20);
    return localArrayList;
  }

  public int getEnquriyInfoNumberByDate(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString3);
    localEnquirytrackExt.setParam(":VSTART_DATE", paramString4);
    localEnquirytrackExt.setParam(":VEND_DATE", paramString5);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_DATE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnquriyInfoByKey(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString3);
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString4 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_KEY", paramInt, 20);
    return localArrayList;
  }

  public int getEnquriyInfoNumberByKey(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString3);
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString4 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_KEY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public int getEnquriyInfoByTag(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString3);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_TAG");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnquriyInfoByUser(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_USER", paramInt, 20);
    return localArrayList;
  }

  public int getEnquriyInfoByUser(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_USER");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnquriyInfoByUserDate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VSTART_DATE", paramString3);
    localEnquirytrackExt.setParam(":VEND_DATE", paramString4);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_USER_DATE", paramInt, 20);
    return localArrayList;
  }

  public int getEnquriyInfoByUserDate(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VSTART_DATE", paramString3);
    localEnquirytrackExt.setParam(":VEND_DATE", paramString4);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_USER_DATE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnquriyInfoByUserKey(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString3 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_USER_KEY", paramInt, 20);
    return localArrayList;
  }

  public int getEnquriyInfoByUserKey(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString3 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_USER_KEY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnquiryByMySelf(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_MYSELF", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getEnquiryByMySelfDate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VSTART_DATE", paramString3);
    localEnquirytrackExt.setParam(":VEND_DATE", paramString4);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_MYSELF_DATE", paramInt, 20);
    return localArrayList;
  }

  public int getEnquiryByMySelfDate(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VSTART_DATE", paramString3);
    localEnquirytrackExt.setParam(":VEND_DATE", paramString4);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_MYSELF_DATE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnquiryByMySelfKey(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString3 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_MYSELF_KEY", paramInt, 20);
    return localArrayList;
  }

  public int getEnquiryByMySelfKey(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString3 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_MYSELF_KEY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public int getEnquiryByMySelf(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_MYSELF");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void editEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入editEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("TRADE_ID");
    String str2 = paramBuffers.getString("RSRV_STR1");
    int i = -1;
    try
    {
      EnquirytrackDAO localEnquirytrackDAO = new EnquirytrackDAO();
      localEnquirytrackDAO.setTrade_id(str1);
      localEnquirytrackDAO.setRsrv_str1(str2);
      i = editEnquiryInfo(localEnquirytrackDAO);
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
    this.log.LOG_INFO("退出addEnquiryInfo方法...");
  }

  public int editEnquiryInfo(EnquirytrackDAO paramEnquirytrackDAO)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramEnquirytrackDAO.getTrade_id());
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramEnquirytrackDAO.getRsrv_str1());
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("EDIT_BY_ENQURIY"));
    return 0;
  }

  public void delEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    int i = -1;
    try
    {
      i = delEnquiryInfo(str);
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
    this.log.LOG_INFO("退出addEnquiryInfo方法...");
  }

  public int delEnquiryInfo(String paramString)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("DELETE_BY_TRADE"));
    return 0;
  }

  public void DeleteEnquiryInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = delEnquiryInfo(str2);
      }
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
  }

  public HashMap getEnquriyById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString);
    ArrayList localArrayList = localEnquirytrackExt.selByList("UPDATE_BY_ENQURIY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getEnquiryByList(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getEnquiryNewByList(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VSALE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_ENQUIRY_SALE_ID", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getEnquiryByList()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getEnquiryById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY_ID");
    return localArrayList;
  }

  public ArrayList getMax()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localArrayList = localEnquirytrackExt.selByList("SEL_MAX");
    return localArrayList;
  }

  public ArrayList getOffEnquiryByList(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localArrayList = localEnquirytrackExt.selByList("SEL_OFF_ENQ_BY", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getOffEnquiryByList()
    throws SaasApplicationException
  {
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    ArrayList localArrayList = localEnquirytrackExt.selByList("SEL_OFF_ENQ_BY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnquiryOffed(int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getEnquiryOffed(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getEnquiryOffed()
    throws SaasApplicationException
  {
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    ArrayList localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void CloseEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入CloseEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    int i = -1;
    try
    {
      i = CloseEnquiryInfo(str);
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
    this.log.LOG_INFO("退出CloseEnquiryInfo方法...");
  }

  public int CloseEnquiryInfo(String paramString)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("CLOSE_BY_TRADE"));
    return 0;
  }

  public void OpenEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入OpenEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    int i = -1;
    try
    {
      i = OpenEnquiryInfo(str);
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
    this.log.LOG_INFO("退出OpenEnquiryInfo方法...");
  }

  public int OpenEnquiryInfo(String paramString)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("OPEN_BY_TRADE"));
    return 0;
  }

  public ArrayList searchAdv(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VRSRV_STR3", "%" + paramString + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_SEARCHES", paramInt1, paramInt2);
    return localArrayList;
  }

  public int searchAdv(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VRSRV_STR3", "%" + paramString + "%");
    ArrayList localArrayList = localEnquirytrackExt.selByList("SEL_BY_SEARCHES");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnquiryList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getEnquiryList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnqList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VSALE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY_SALE", paramInt, 20);
    return localArrayList;
  }

  public int getEnqList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VSALE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_SALE_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getCustomerEnqList(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VSALE_ID", paramString1);
    localArrayList = localEnquirytrackExt.selByList("SEL_CUSTOMER_LEAVE", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getCustomerEnqCount(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VSALE_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_CUSTOMER_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public HashMap getEnquiryInfoById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    ArrayList localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getEnquiryByCart(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY_CART", paramInt, 20);
    return localArrayList;
  }

  public int getEnquiryByCart(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_BY_CART");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getEnquiryByCartAndSale(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString1);
    localEnquirytrackExt.setParam(":VNAME", "%" + paramString2 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_LIKE_NAME", paramInt, 20);
    return localArrayList;
  }

  public int getEnquiryByCartAndSale(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString1);
    localEnquirytrackExt.setParam(":VNAME", "%" + paramString2 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQ_LIKE_NAME");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getEnquriyInfoBySaleId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VSALE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_SALE_ID");
    return localArrayList;
  }

  public ArrayList getEnquriyInfoBySaleId(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VSALE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_SALE_ID", paramInt, 30);
    return localArrayList;
  }

  public int getNumEnquriyInfoBySaleId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VSALE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_SALE_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public void addLeaveInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = this.comm.GenTradeId();
    String str2 = paramBuffers.getString("CUST_ID");
    String str3 = paramBuffers.getString("USER_ID");
    String str4 = paramBuffers.getString("SALE_ID");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("SESSION_USER_ID");
    String str7 = paramBuffers.getString("DEAL_TAG");
    String str8 = paramBuffers.getString("RSRV_STR3");
    String str9 = paramBuffers.getString("RSRV_STR4");
    String str10 = paramBuffers.getString("RSRV_STR5");
    int i = -1;
    try
    {
      EnquirytrackDAO localEnquirytrackDAO = new EnquirytrackDAO();
      localEnquirytrackDAO.setCust_id(str2);
      localEnquirytrackDAO.setTrade_id(str1);
      localEnquirytrackDAO.setUser_id(str3);
      localEnquirytrackDAO.setSale_id(str4);
      localEnquirytrackDAO.setEnquiry_content(str5);
      localEnquirytrackDAO.setEnquiry_user(str6);
      localEnquirytrackDAO.setDeal_tag(str7);
      localEnquirytrackDAO.setRsrv_str3(str8);
      localEnquirytrackDAO.setRsrv_str4(str9);
      localEnquirytrackDAO.setRsrv_str5(str10);
      i = addLeaveInfo(localEnquirytrackDAO);
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
    this.log.LOG_INFO("退出addEnquiryInfo方法...");
  }

  public int addLeaveInfo(EnquirytrackDAO paramEnquirytrackDAO)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramEnquirytrackDAO.getCust_id());
    localEnquirytrackExt.setParam(":VTRADE_ID", paramEnquirytrackDAO.getTrade_id());
    localEnquirytrackExt.setParam(":VUSER_ID", paramEnquirytrackDAO.getUser_id());
    localEnquirytrackExt.setParam(":VSALE_ID", paramEnquirytrackDAO.getSale_id());
    localEnquirytrackExt.setParam(":VENQUIRY_CONTENT", paramEnquirytrackDAO.getEnquiry_content());
    localEnquirytrackExt.setParam(":VENQUIRY_USER", paramEnquirytrackDAO.getEnquiry_user());
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramEnquirytrackDAO.getDeal_tag());
    localEnquirytrackExt.setParam(":VRSRV_STR1", "0");
    localEnquirytrackExt.setParam(":VRSRV_STR3", paramEnquirytrackDAO.getRsrv_str3());
    localEnquirytrackExt.setParam(":VRSRV_STR4", paramEnquirytrackDAO.getRsrv_str4());
    localEnquirytrackExt.setParam(":VRSRV_STR5", paramEnquirytrackDAO.getRsrv_str5());
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("INS_BY_LEAVE"));
    return 0;
  }

  public ArrayList getEnquriyInfoByTagRsrv(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString1);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_TAR", paramInt, 20);
    return localArrayList;
  }

  public int getEnquriyInfoByTagRsrv(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString1);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_TAR");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLeaveEnquriyInfoByTag(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_LEAVE", paramInt, 20);
    return localArrayList;
  }

  public int getLeaveEnquriyInfoByTag(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_LEAVE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getEnquriyInfoByChid(String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getEnquriyInfoByChid方法...");
    this.log.LOG_INFO("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" + paramString);
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCH_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_CHID");
    return localArrayList;
  }

  public ArrayList getOffEnquriyInfoByChid(String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getEnquriyInfoByChid方法...");
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCH_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_OFF_BY_CHID");
    return localArrayList;
  }

  public void editEnquiry(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入editEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("TRADE_ID");
    String str2 = paramBuffers.getString("RSRV_STR1");
    int i = -1;
    try
    {
      EnquirytrackDAO localEnquirytrackDAO = new EnquirytrackDAO();
      localEnquirytrackDAO.setTrade_id(str1);
      localEnquirytrackDAO.setRsrv_str1(str2);
      i = editEnquiry(localEnquirytrackDAO);
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
    this.log.LOG_INFO("退出addEnquiryInfo方法...");
  }

  public int editEnquiry(EnquirytrackDAO paramEnquirytrackDAO)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramEnquirytrackDAO.getTrade_id());
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramEnquirytrackDAO.getRsrv_str1());
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("EDIT_ENQURIY_BY"));
    return 0;
  }

  public ArrayList getEnquriyInfoByKeyAdmin(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString3);
    localEnquirytrackExt.setParam(":VKEYWORD", "%" + paramString4 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_KEYWORD", paramInt, 20);
    return localArrayList;
  }

  public int getEnquriyInfoByKeyCount(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VRSRV_STR1", paramString3);
    localEnquirytrackExt.setParam(":VKEYWORD", "%" + paramString4 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_KEYWORD");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getEnquriyInfoByChid(String paramString, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCH_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_CHID", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList genSign(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VSALE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_SALEID");
    return localArrayList;
  }

  public ArrayList genSearch(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VRSRV_STR3", "%" + paramString + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_SEARCH_WORD");
    return localArrayList;
  }

  public HashMap getEnquriyByIdAdmin(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VENQUIRY_ID", paramString1);
    localEnquirytrackExt.setParam(":VUSER_ID", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_ONE_BY_ADMIN");
    if (null != localArrayList)
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public void DeleteEnquriyInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteEnquriyInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    this.log.LOG_INFO("进入DeleteEnquriyInfo方法...******" + str1);
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = DeleteEnquriyInfo(str2);
      }
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
    this.log.LOG_INFO("退出DeleteEnquriyInfo方法...");
  }

  public int DeleteEnquriyInfo(String paramString)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("DELETE_ENQURIY_BY_IDX"));
    return 0;
  }

  public void addEnquiryReport(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = this.comm.GenTradeId();
    String str2 = paramBuffers.getString("CUST_ID");
    String str3 = paramBuffers.getString("USER_ID");
    String str4 = paramBuffers.getString("SALE_ID");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("SESSION_USER_ID");
    String str7 = paramBuffers.getString("DEAL_TAG");
    String str8 = paramBuffers.getString("rsrv_str3");
    int i = -1;
    try
    {
      i = addEnquiryReport(str1, str2, str3, str4, str5, str6, str7, str8);
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
    this.log.LOG_INFO("退出addEnquiryInfo方法...");
  }

  public int addEnquiryReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString2);
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString1);
    localEnquirytrackExt.setParam(":VUSER_ID", paramString3);
    localEnquirytrackExt.setParam(":VSALE_ID", paramString4);
    localEnquirytrackExt.setParam(":VENQUIRY_CONTENT", paramString5);
    localEnquirytrackExt.setParam(":VENQUIRY_USER", paramString6);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString7);
    localEnquirytrackExt.setParam(":VRSRV_STR3", paramString8);
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("INS_BY_ENQURIY_REPORT"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.enquirydealMgr.EnquirydInfo
 * JD-Core Version:    0.6.0
 */