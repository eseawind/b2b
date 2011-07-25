package com.saas.biz.validityMgr;

import com.saas.biz.commen.ParamethodMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.validityDAO.ValidityDAO;
import com.saas.biz.dao.validityDAO.ValidityExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ValidityInfo
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

  public ValidityDAO checkValidityInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str1 = this.comm.GenTradeId();
    String str2 = "0";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = this.comm.GenSysdate("1");
    String str12 = "新添加信息";
    ValidityDAO localValidityDAO = new ValidityDAO();
    try
    {
      localValidityDAO.setCust_id(paramString1);
      localValidityDAO.setTrade_id(str1);
      localValidityDAO.setQuo_id(paramString2);
      localValidityDAO.setInfo_type(paramString3);
      localValidityDAO.setInfo_state(str2);
      localValidityDAO.setAudit_desc(str3);
      localValidityDAO.setRsrv_str1(str4);
      localValidityDAO.setRsrv_str2(str5);
      localValidityDAO.setRsrv_str3(str6);
      localValidityDAO.setRsrv_str4(str7);
      localValidityDAO.setRsrv_str5(str8);
      localValidityDAO.setRsrv_str8(str9);
      localValidityDAO.setRsrv_str9(str10);
      localValidityDAO.setRsrv_str10(paramString4);
      localValidityDAO.setOper_date(str11);
      localValidityDAO.setOper_user_id(paramString5);
      localValidityDAO.setRemark(str12);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return localValidityDAO;
  }

  public void addValiditInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addValiditInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_TYPE_CODE");
    try
    {
      if ((str1.equals("0123")) || (str1.equals("0810")) || (str1.equals("1308")))
      {
        i = 0;
      }
      else
      {
        String str2 = paramBuffers.getString("SESSION_CUST_ID");
        String str3 = paramBuffers.getString("SESSION_USER_ID");
        i = addValiditInfo(str2, str3, str1);
      }
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addValiditInfo方法...");
  }

  public int addValiditInfo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    ParamethodMgr localParamethodMgr = new ParamethodMgr();
    ArrayList localArrayList = localParamethodMgr.getCompareInfoByAttr("106");
    this.log.LOG_INFO("进入审核机制addValiditInfo方法");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("para_code1") != null)
          str5 = localHashMap.get("para_code1").toString();
        if (localHashMap.get("para_code3") != null)
          str1 = localHashMap.get("para_code3").toString();
        if (localHashMap.get("para_code4") != null)
          str2 = localHashMap.get("para_code4").toString();
        if (((str1 != "1") && (!str1.equals("1"))) || ((paramString3 != str2) && (!str2.equals(paramString3))))
          continue;
        if (localHashMap.get("para_code5") != null)
        {
          str3 = localHashMap.get("para_code5").toString();
          str3 = str3.toUpperCase();
        }
        if (localHashMap.get("para_code6") != null)
        {
          str4 = localHashMap.get("para_code6").toString();
          str4 = str4.toUpperCase();
        }
        str3 = this.outBuffer.getString(str3);
        str4 = this.outBuffer.getString(str4);
        ValidityInfo localValidityInfo = new ValidityInfo();
        ValidityDAO localValidityDAO = localValidityInfo.checkValidityInfo(paramString1, str3, str5, str4, paramString2);
        addOrEditValiditInfo(localValidityDAO, "0");
      }
    this.log.LOG_INFO("退出审核机制addValiditInfo方法");
    return 0;
  }

  public void editValiditInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入editValiditInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    String str4 = paramBuffers.getString("INFO_TYPE");
    String str5 = paramBuffers.getString("STATUS");
    String str6 = paramBuffers.getString("AUDIT_DESC");
    String str7 = paramBuffers.getString("RSRV_STR1");
    String str8 = paramBuffers.getString("RSRV_STR2");
    String str9 = paramBuffers.getString("RSRV_STR3");
    String str10 = paramBuffers.getString("RSRV_STR4");
    String str11 = paramBuffers.getString("RSRV_STR5");
    String str12 = paramBuffers.getString("RSRV_STR8");
    String str13 = paramBuffers.getString("RSRV_STR9");
    String str14 = paramBuffers.getString("RSRV_STR10");
    String str15 = this.comm.GenSysdate("1");
    String str16 = paramBuffers.getString("SESSION_USER_ID");
    String str17 = paramBuffers.getString("REMARK");
    try
    {
      ValidityDAO localValidityDAO = new ValidityDAO();
      localValidityDAO.setCust_id(str1);
      localValidityDAO.setTrade_id(str2);
      localValidityDAO.setQuo_id(str3);
      localValidityDAO.setInfo_type(str4);
      localValidityDAO.setInfo_state(str5);
      localValidityDAO.setAudit_desc(str6);
      localValidityDAO.setRsrv_str1(str7);
      localValidityDAO.setRsrv_str2(str8);
      localValidityDAO.setRsrv_str3(str9);
      localValidityDAO.setRsrv_str4(str10);
      localValidityDAO.setRsrv_str5(str11);
      localValidityDAO.setRsrv_str8(str12);
      localValidityDAO.setRsrv_str9(str13);
      localValidityDAO.setRsrv_str10(str14);
      localValidityDAO.setOper_date(str15);
      localValidityDAO.setOper_user_id(str16);
      localValidityDAO.setRemark(str17);
      i = addOrEditValiditInfo(localValidityDAO, "1");
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
    this.log.LOG_INFO("退出editValiditInfo方法...");
  }

  public int addOrEditValiditInfo(ValidityDAO paramValidityDAO, String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入addOrEditValiditInfo方法");
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_ID", paramValidityDAO.getCust_id());
    localValidityExt.setParam(":VTRADE_ID", paramValidityDAO.getTrade_id());
    localValidityExt.setParam(":VQUO_ID", paramValidityDAO.getQuo_id());
    localValidityExt.setParam(":VINFO_TYPE", paramValidityDAO.getInfo_type());
    localValidityExt.setParam(":VSTATUS", paramValidityDAO.getInfo_state());
    localValidityExt.setParam(":VAUDIT_DESC", paramValidityDAO.getAudit_desc());
    localValidityExt.setParam(":VRSRV_STR1", paramValidityDAO.getRsrv_str1());
    localValidityExt.setParam(":VRSRV_STR2", paramValidityDAO.getRsrv_str2());
    localValidityExt.setParam(":VRSRV_STR3", paramValidityDAO.getRsrv_str3());
    localValidityExt.setParam(":VRSRV_STR4", paramValidityDAO.getRsrv_str4());
    localValidityExt.setParam(":VRSRV_STR5", paramValidityDAO.getRsrv_str5());
    localValidityExt.setParam(":VRSRV_STR8", paramValidityDAO.getRsrv_str8());
    localValidityExt.setParam(":VRSRV_STR9", paramValidityDAO.getRsrv_str9());
    localValidityExt.setParam(":VRSRV_STR10", paramValidityDAO.getRsrv_str10());
    localValidityExt.setParam(":VOPER_DATE", paramValidityDAO.getOper_date());
    localValidityExt.setParam(":VOPER_USER_ID", paramValidityDAO.getOper_user_id());
    localValidityExt.setParam(":VREMARK", paramValidityDAO.getRemark());
    if ((paramString == "0") || (paramString.equals("0")))
    {
      this.log.LOG_INFO("进入新增方法...");
      this.tradeQuery.executeBy(localValidityExt.insBy("INS_BY_ALL"));
    }
    else
    {
      this.log.LOG_INFO("进入修改方法...");
      this.tradeQuery.executeBy(localValidityExt.insBy("EIDT_BY_ALL"));
    }
    this.log.LOG_INFO("退出addOrEditValiditInfo方法");
    return 0;
  }

  public boolean checkValidityInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ParamethodMgr localParamethodMgr = new ParamethodMgr();
    boolean i = false;
    ArrayList localArrayList = localParamethodMgr.getComparamListByCode(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      String str = "";
      if (localHashMap.get("para_code3") != null)
        str = localHashMap.get("para_code3").toString();
      if ((str == "1") || (str.equals("1")))
        i = true;
    }
    return i;
  }

  public ArrayList getValidityList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VINFO_TYPE", paramString1);
    localValidityExt.setParam(":VSTATE", paramString2);
    ArrayList localArrayList = localValidityExt.selByList("SEL_BY_STATE", paramInt, 20);
    return localArrayList;
  }

  public int getValidityCount(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VINFO_TYPE", paramString1);
    localValidityExt.setParam(":VSTATE", paramString2);
    ArrayList localArrayList = localValidityExt.selByList("SEL_BY_STATE_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getNewsById(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    localArrayList = localValidityExt.selByList("SEL_NEWS_BY_ID", paramInt, 20);
    return localArrayList;
  }

  public int getNewsById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    ArrayList localArrayList = localValidityExt.selByList("SEL_NEWS_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getAdvertiseById(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    localArrayList = localValidityExt.selByList("SEL_ADVERTISE_BY_ID", paramInt, 20);
    return localArrayList;
  }

  public int getAdvertiseById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    ArrayList localArrayList = localValidityExt.selByList("SEL_ADVERTISE_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getSaleById(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    localArrayList = localValidityExt.selByList("SEL_SALE_BY_ID", paramInt, 20);
    return localArrayList;
  }

  public int getSaleById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    ArrayList localArrayList = localValidityExt.selByList("SEL_SALE_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getStockorderById(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    localArrayList = localValidityExt.selByList("SEL_STOCKORDER_BY_ID", paramInt, 20);
    return localArrayList;
  }

  public int getStockorderById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    ArrayList localArrayList = localValidityExt.selByList("SEL_STOCKORDER_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getCategoryById(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    localArrayList = localValidityExt.selByList("SEL_CATEGORY_BY_ID", paramInt, 20);
    return localArrayList;
  }

  public int getCategoryById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    ArrayList localArrayList = localValidityExt.selByList("SEL_CATEGORY_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getJobById(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    localArrayList = localValidityExt.selByList("SEL_JOB_BY_ID", paramInt, 20);
    return localArrayList;
  }

  public int getJobById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_CLASS", paramString1);
    localValidityExt.setParam(":VINFO_TYPE", paramString2);
    ArrayList localArrayList = localValidityExt.selByList("SEL_JOB_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void AuditVList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入AuditVList方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("INFO_STATE");
    String str4 = paramBuffers.getString("AUDIT_DESC");
    String str5 = paramBuffers.getString("SESSION_USER_ID");
    String str6 = paramBuffers.getString("OPER_DATE");
    String str7 = paramBuffers.getString("REMARK");
    try
    {
      ValidityDAO localValidityDAO = new ValidityDAO();
      localValidityDAO.setCust_id(str1);
      localValidityDAO.setTrade_id(str2);
      localValidityDAO.setInfo_state(str3);
      localValidityDAO.setAudit_desc(str4);
      localValidityDAO.setOper_user_id(str5);
      localValidityDAO.setOper_date(str6);
      localValidityDAO.setRemark(str7);
      i = AuditVList(localValidityDAO);
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
    this.log.LOG_INFO("退出AuditVList方法...");
  }

  public int AuditVList(ValidityDAO paramValidityDAO)
    throws SaasApplicationException
  {
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_ID", paramValidityDAO.getCust_id());
    localValidityExt.setParam(":VTRADE_ID", paramValidityDAO.getTrade_id());
    localValidityExt.setParam(":VINFO_STATE", paramValidityDAO.getInfo_state());
    localValidityExt.setParam(":VAUDIT_DESC", paramValidityDAO.getAudit_desc());
    localValidityExt.setParam(":VOPER_USER_ID", paramValidityDAO.getOper_user_id());
    localValidityExt.setParam(":VOPER_DATE", paramValidityDAO.getOper_date());
    localValidityExt.setParam(":VREMARK", paramValidityDAO.getRemark());
    this.tradeQuery.executeBy(localValidityExt.insBy("UP_BY_AUDIT_V"));
    return 0;
  }

  public ArrayList getJobById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VQUO_ID", paramString);
    localArrayList = localValidityExt.selByList("SEL_INFO_BY_QUO_ID");
    return localArrayList;
  }

  public HashMap getById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VQUO_ID", paramString);
    localArrayList = localValidityExt.selByList("SEL_INFO_BY_QUO_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public void DelVList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DelVList方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("NEWS_ID");
    this.log.LOG_INFO("quo_id=" + str);
    try
    {
      ValidityDAO localValidityDAO = new ValidityDAO();
      localValidityDAO.setQuo_id(str);
      i = DelVList(localValidityDAO);
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
    this.log.LOG_INFO("退出DelVList方法...");
  }

  public void DeletVListInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("NEWS_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        ValidityDAO localValidityDAO = new ValidityDAO();
        localValidityDAO.setQuo_id(str2);
        i = DelVList(localValidityDAO);
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
    this.log.LOG_INFO("退出DeleteSaleInfo方法...");
  }

  public int DelVList(ValidityDAO paramValidityDAO)
    throws SaasApplicationException
  {
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VQUO_ID", paramValidityDAO.getQuo_id());
    this.log.LOG_INFO("SQL=" + localValidityExt.insBy("DEL_BY_AUDIT_V"));
    this.tradeQuery.executeBy(localValidityExt.insBy("DEL_BY_AUDIT_V"));
    return 0;
  }

  public void addValiditInfoAgain(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addValiditInfoAgain方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    String str4 = paramBuffers.getString("INFO_TYPE");
    String str5 = paramBuffers.getString("INFO_STATE");
    try
    {
      i = addValiditInfoAgain(str1, str2, str3, str4, str5);
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
    this.log.LOG_INFO("退出editValiditInfo方法...");
  }

  public int addValiditInfoAgain(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入addValiditInfoAgain方法");
    ValidityExt localValidityExt = new ValidityExt();
    localValidityExt.setParam(":VCUST_ID", paramString1);
    localValidityExt.setParam(":VTRADE_ID", paramString2);
    localValidityExt.setParam(":VQUO_ID", paramString3);
    localValidityExt.setParam(":VINFO_TYPE", paramString4);
    localValidityExt.setParam(":VSTATUS", paramString5);
    this.tradeQuery.executeBy(localValidityExt.insBy("INS_BY_ALL_AGAIN"));
    this.log.LOG_INFO("退出addValiditInfoAgain方法");
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.validityMgr.ValidityInfo
 * JD-Core Version:    0.6.0
 */