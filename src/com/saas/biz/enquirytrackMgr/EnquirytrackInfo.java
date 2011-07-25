package com.saas.biz.enquirytrackMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.enquirytrackDAO.EnquirytrackExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class EnquirytrackInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
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

  public void addEnquirytrackInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入addEnquirytrackInfo方法...");
    String str1 = paramBuffers.getString("SALE_ID");
    String str2 = paramBuffers.getString("PUBLISH_USER_ID");
    String str3 = paramBuffers.getString("SESSION_CUST_ID");
    String str4 = paramBuffers.getString("ENQUIRY_CONTENT");
    String str5 = paramBuffers.getString("SESSION_USER_ID");
    String str6 = paramBuffers.getString("DEAL_TAG");
    int i = -1;
    try
    {
      i = addEnquirytrackInfo(str2, str3, str4, str1, str5, str6);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "请在24小时之内不能重复提交！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addEnquirytrackInfo方法...");
  }

  public int addEnquirytrackInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    int i = searchEnquiry1(paramString2, paramString1, paramString4, paramString5, paramString6);
    if (i != -1)
    {
      EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
      commMethodMgr localcommMethodMgr = new commMethodMgr();
      String str = localcommMethodMgr.GenTradeId();
      localEnquirytrackExt.setParam(":VSALE_ID", paramString4);
      localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
      localEnquirytrackExt.setParam(":VCUST_ID", paramString2);
      localEnquirytrackExt.setParam(":VTRADE_ID", str);
      localEnquirytrackExt.setParam(":VENQUIRY_CONTENT", paramString3);
      localEnquirytrackExt.setParam(":VDEAL_TAG", paramString6);
      localEnquirytrackExt.setParam(":VENQUIRY_USER", paramString5);
      this.tradeQuery.executeBy(localEnquirytrackExt.insBy("INS_BY_ALL"));
      this.log.LOG_INFO("cust_id.........." + paramString2);
      return 0;
    }
    return -1;
  }

  public int searchEnquiry1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString1);
    localEnquirytrackExt.setParam(":VUSER_ID", paramString2);
    localEnquirytrackExt.setParam(":VSALE_ID", paramString3);
    localEnquirytrackExt.setParam(":VENQUIRY_USER", paramString4);
    localEnquirytrackExt.setParam(":VENQUIRY_DATE", str);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString5);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_ENQUIRY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return -1;
    return 0;
  }

  public void getEnquiryList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getEnquiryList方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("SESSION_CUST_ID");
    try
    {
      this.queryResult = getEnquiryList(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getEnquiryList方法...");
  }

  public ArrayList getEnquiryList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_SALE");
    return localArrayList;
  }

  public void getCustEnquiryList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getCustEnquiryList方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = getCustEnquiryList(str1);
      else
        this.queryResult = searchEnquiry(str2, str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getCustEnquiryList方法...");
  }

  public ArrayList getCustEnquiryList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public String getCustEnquiryBySaleId(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VSALE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_SPEC_SALE_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("enquiry_user") != null)
        str = localHashMap.get("enquiry_user").toString();
    }
    return str;
  }

  public void getEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    try
    {
      this.queryResult = getEnquiryInfo(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getEnquiryInfo方法...");
  }

  public ArrayList getEnquiryInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_TRADE");
    return localArrayList;
  }

  public void anEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入anEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    int i = -1;
    try
    {
      i = anEnquiryInfo(str);
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

  public int anEnquiryInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_TRADE");
    return 0;
  }

  public ArrayList searchEnquiry(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTITLE", "%" + paramString1 + "%");
    localEnquirytrackExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public void UpdateEnquiryInfoByTrade(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入UpdateEnquiryInfoByTrade方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("enquiry_id");
    String str2 = paramBuffers.getString("deal_tag");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    int i = -1;
    try
    {
      i = UpdateEnquiryInfoByTrade(str1, str2, str3);
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
    this.log.LOG_INFO("退出UpdateEnquiryInfoByTrade方法...");
  }

  public int UpdateEnquiryInfoByTrade(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", paramString2);
    localEnquirytrackExt.setParam(":VDEAL_USER", paramString3);
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("UPDATE_ENQURIY_BY_ID"));
    return 0;
  }

  public ArrayList getStockListByUser(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_STOCK", paramInt, 30);
    return localArrayList;
  }

  public int getStockNumberByUser(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_STOCK");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getStockListByUserDate(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", "2");
    localEnquirytrackExt.setParam(":VSTART_DATE", paramString2);
    localEnquirytrackExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_STOCK_DATE", paramInt, 30);
    return localArrayList;
  }

  public int getStockNumberByUserDate(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", "2");
    localEnquirytrackExt.setParam(":VSTART_DATE", paramString2);
    localEnquirytrackExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_STOCK_DATE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getStockListByUserKey(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", "2");
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_STOCK_KEY", paramInt, 30);
    return localArrayList;
  }

  public int getStockNumberByUserKey(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", "2");
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_STOCK_KEY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getSaleListBySendKey(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", "2");
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_STOCK_KEY", paramInt, 30);
    return localArrayList;
  }

  public int getSaleNumberBySendKey(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString1);
    localEnquirytrackExt.setParam(":VDEAL_TAG", "2");
    localEnquirytrackExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_STOCK_KEY");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getStockListBySend(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_STOCK_SEND", paramInt, 30);
    return localArrayList;
  }

  public int getStockNumberBySend(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_STOCK_SEND");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getSaleListByUser(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_SALE", paramInt, 30);
    return localArrayList;
  }

  public int getSaleNumberByUser(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VCUST_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_SALE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getSaleListBySend(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_SEND", paramInt, 30);
    return localArrayList;
  }

  public int getSaleNumberBySend(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VUSER_ID", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_ENQUIRY_SEND");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getGarbageListByUser(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VDEAL_USER", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_GARBAGE", paramInt, 30);
    return localArrayList;
  }

  public int getGarbageNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VDEAL_USER", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_GARBAGE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public void deleteEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    int i = -1;
    try
    {
      i = deleteEnquiryInfo(str);
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
    this.log.LOG_INFO("退出deleteEnquiryInfo方法...");
  }

  public int deleteEnquiryInfo(String paramString)
    throws SaasApplicationException
  {
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localEnquirytrackExt.insBy("DELETE_BY_TRADE"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.enquirytrackMgr.EnquirytrackInfo
 * JD-Core Version:    0.6.0
 */