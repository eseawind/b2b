package com.saas.biz.infoMsg;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.careDAO.CareExt;
import com.saas.biz.dao.enquirytrackDAO.EnquirytrackExt;
import com.saas.biz.dao.leavewordsDAO.LeavewordsExt;
import com.saas.biz.dao.letterDAO.LetterExt;
import com.saas.biz.dao.newsDAO.NewsExt;
import com.saas.biz.dao.notifyDAO.NotifyExt;
import com.saas.biz.dao.saleDAO.SaleExt;
import com.saas.biz.dao.stockorderDAO.StockorderExt;
import com.saas.biz.dao.studyDAO.StudyExt;
import com.saas.biz.dao.xcalendarDAO.XcalendarExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class InfoMsg
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

  public String getItineraryByUser(String paramString, int paramInt)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "/oa/itineraryMgr/itineraryInfoView.jsp?menu_id=nWXFw1LmN178Q32&id=";
    ArrayList localArrayList = new ArrayList();
    XcalendarExt localXcalendarExt = new XcalendarExt();
    localXcalendarExt.setParam(":VUSER", paramString);
    localArrayList = localXcalendarExt.selByList("SEL_BY_USER", 0, paramInt);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = localHashMap.get("title").toString();
        if (str3.length() > 26)
          str3 = str3.substring(0, 26);
        String str4 = localHashMap.get("id").toString();
        str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + str4 + ">" + str3 + "</a><br>" + str1;
      }
    return str1;
  }

  public String getNoticeByPart(String paramString1, int paramInt, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "/oa/notificationMgr/viewNotifyIndex.jsp?menu_id=7t2wv641B7773gR&id=";
    NotifyExt localNotifyExt = new NotifyExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localNotifyExt.setParam(":VPART", paramString1);
      localNotifyExt.setParam(":VCHECKED", "0");
      localNotifyExt.setParam(":VXVISIBLE", paramString2);
      localArrayList = localNotifyExt.selByList("SEL_BY_PART", 0, paramInt);
      if ((localArrayList != null) && (localArrayList.size() > 0))
        for (int i = 0; i < localArrayList.size(); i++)
        {
          HashMap localHashMap = (HashMap)localArrayList.get(i);
          String str3 = localHashMap.get("title").toString();
          if (str3.length() > 26)
            str3 = str3.substring(0, 26);
          String str4 = localHashMap.get("id").toString();
          str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + str4 + ">" + str3 + "</a><br>" + str1;
        }
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return str1;
  }

  public String getLetterBy(String paramString, int paramInt)
  {
    String str1 = "";
    String str2 = "/oa/shortmessageMgr/showletter.jsp?menu_id=FI107GG54H36ihr&id=";
    ArrayList localArrayList = new ArrayList();
    LetterExt localLetterExt = new LetterExt();
    localLetterExt.setParam(":VRPART", paramString);
    localArrayList = localLetterExt.selByList("SEL_BY_RPART", 0, paramInt);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = localHashMap.get("title").toString();
        if (str3.length() > 26)
          str3 = str3.substring(0, 26);
        String str4 = localHashMap.get("id").toString();
        str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + str4 + ">" + str3 + "</a><br>" + str1;
      }
    return str1;
  }

  public String getStudyInfoByPartOrUser(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "/oa/study/viewStudyInfo.jsp?menu_id=zshi1fk1CC81S11p&id=";
    ArrayList localArrayList = new ArrayList();
    StudyExt localStudyExt = new StudyExt();
    localStudyExt.setParam(":VUSER", paramString1);
    localStudyExt.setParam(":VPART", paramString2);
    localArrayList = localStudyExt.selByList("SEL_BY_USERORPART", 0, paramInt);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = localHashMap.get("title").toString();
        if (str3.length() > 26)
          str3 = str3.substring(0, 26);
        String str4 = localHashMap.get("id").toString();
        str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + str4 + ">" + str3 + "</a><br>" + str1;
      }
    return str1;
  }

  public String getCareByCust(String paramString, int paramInt)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "/careMgr/indexRemind.jsp?menu_id=2J0V4n2mMp080X0G85BH";
    ArrayList localArrayList = new ArrayList();
    CareExt localCareExt = new CareExt();
    localCareExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCareExt.selByList("SEL_BY_CUST", 0, paramInt);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = localHashMap.get("title").toString();
        if (str3.length() > 26)
          str3 = str3.substring(0, 26);
        str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + ">" + str3 + "</a><br>" + str1;
      }
    return str1;
  }

  public String getNewsByCust(String paramString, int paramInt)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "/newsMgr/viewNewsInfo.jsp?news_id=";
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString);
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_CUST", 0, paramInt);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = localHashMap.get("title").toString();
        if (str3.length() > 26)
          str3 = str3.substring(0, 26);
        String str4 = localHashMap.get("news_id").toString();
        str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + str4 + " target=blank>" + str3 + "</a><br>" + str1;
      }
    return str1;
  }

  public String getSaleInfoByCust(String paramString, int paramInt)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "/saleMgr/viewSaleInfo.jsp?sale_id=";
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString);
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE", 0, paramInt);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = localHashMap.get("title").toString();
        if (str3.length() > 26)
          str3 = str3.substring(0, 26);
        String str4 = localHashMap.get("sale_id").toString();
        str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + str4 + " target=blank>" + str3 + "</a><br>" + str1;
      }
    return str1;
  }

  public String getStockListByCust(String paramString, int paramInt)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "/stockMgr/viewStockInfo.jsp?stock_id=";
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    localStockorderExt.setParam(":VVALIDITY", "0");
    localArrayList = localStockorderExt.selByList("SEL_CUST_STOCKORDER", 0, paramInt);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = localHashMap.get("title").toString();
        if (str3.length() > 26)
          str3 = str3.substring(0, 26);
        String str4 = localHashMap.get("stock_id").toString();
        str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + str4 + " target=blank>" + str3 + "</a><br>" + str1;
      }
    return str1;
  }

  public String getLeavewordByCust(String paramString, int paramInt)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "/leaveMgr/viewLeaveInfo.jsp?trade_id=";
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localLeavewordsExt.setParam(":VWORD_TYPE", "4");
    localArrayList = localLeavewordsExt.selByList("SEL_BY_NEW_LEVEL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = "";
        if (localHashMap.get("content") != null)
        {
          str3 = localHashMap.get("content").toString();
          if (str3.length() > 26)
            str3 = str3.substring(0, 26);
        }
        String str4 = localHashMap.get("trade_id").toString();
        str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + str4 + " target=blank>" + str3 + "</a><br>" + str1;
      }
    return str1;
  }

  public String getEnquiryByCust(String paramString, int paramInt)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "/enquiryMgr/viewEnquiryInfo.jsp?sale_id=";
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTRADE", paramString);
    localArrayList = localEnquirytrackExt.selByList("SEL_SPEC_ENQUIRY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = "";
        if ((localHashMap.get("title") != null) && (!localHashMap.get("title").equals("")))
          str3 = localHashMap.get("title").toString();
        if (str3.length() > 26)
          str3 = str3.substring(0, 26);
        String str4 = localHashMap.get("sale_id").toString();
        str1 = "&nbsp;&nbsp;&nbsp;&nbsp;<a href=" + str2 + str4 + " target=blank>" + str3 + "</a><br>" + str1;
      }
    return str1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.infoMsg.InfoMsg
 * JD-Core Version:    0.6.0
 */