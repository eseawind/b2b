package com.saas.biz.newsMgr;

import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.newsDAO.NewsDAO;
import com.saas.biz.dao.newsDAO.NewsExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NewsInfo
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

  public void genNews(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genStockorder方法...");
    try
    {
      this.queryResult = genNews();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genStockorder方法...");
  }

  public ArrayList genNews()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_BY_ALL");
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList genNewsLimit(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_BY_ALL", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList getCommentByText(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    if (paramString2.equals("0"))
    {
      localNewsExt.setParam(":VTITLE", "%" + paramString1 + "%");
      localArrayList = localNewsExt.selByList("SEL_NEWS_CEPING_BY_TITLE", paramInt1, paramInt2);
    }
    else if (paramString2.equals("1"))
    {
      localNewsExt.setParam(":VCONTENT", "%" + paramString1 + "%");
      localArrayList = localNewsExt.selByList("SEL_NEWS_CEPING_BY_CONTENT", paramInt1, paramInt2);
    }
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public int getCommentByText(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    if (paramString2.equals("0"))
    {
      localNewsExt.setParam(":VTITLE", "%" + paramString1 + "%");
      localArrayList = localNewsExt.selByList("SEL_NEWS_CEPING_BY_TITLE");
    }
    else if (paramString2.equals("1"))
    {
      localNewsExt.setParam(":VCONTENT", "%" + paramString1 + "%");
      localArrayList = localNewsExt.selByList("SEL_NEWS_CEPING_BY_CONTENT");
    }
    if (localArrayList == null)
      return 0;
    return localArrayList.size();
  }

  public ArrayList genNewsLimit(String paramString, int paramInt)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入genNewsLimit方法...");
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_NEWS_TYPE", 0, paramInt);
    if (localArrayList == null)
      return null;
    this.log.LOG_INFO("退出genNewsLimit方法...");
    return localArrayList;
  }

  public ArrayList genNewsByUpClassId(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_NEWS_BY_CLASS_ID", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList genNewDisTest()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_LATEST_NEWS_DISTEST", 0, 4);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList genNewsByUpClassIdOther(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_NEWS_BY_CLASS_ID_OTHER", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList genNewsByToday(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_BY_TODAY", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList genNewsByLevel(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_BY_LEVEL", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public void genSpecNews(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genSpecNews方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = genSpecNews(str1);
      else
        this.queryResult = searchNews(str2, str1, "0");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genSpecNews方法...");
  }

  public ArrayList genSpecNews(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString);
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_SPEC_NEWS");
    return localArrayList;
  }

  public void addNewsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addNewsInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    NewsDAO localNewsDAO = new NewsDAO();
    localNewsDAO.setNews_id(paramBuffers.getString("NEWS_ID"));
    localNewsDAO.setNews_type(paramBuffers.getString("NEWS_TYPE"));
    localNewsDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localNewsDAO.setTitle(paramBuffers.getString("TITLE"));
    localNewsDAO.setContent(paramBuffers.getString("CONTENT"));
    localNewsDAO.setSubject_tag(paramBuffers.getString("SUBJECT_TAG"));
    localNewsDAO.setPublish_user_id(paramBuffers.getString("SESSION_USER_ID"));
    localNewsDAO.setAudit_user_id(paramBuffers.getString("SESSION_USER_ID"));
    try
    {
      i = addNewsInfo(localNewsDAO);
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
    this.log.LOG_INFO("退出addNewsInfo方法...");
  }

  public int addNewsInfo(NewsDAO paramNewsDAO)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = paramNewsDAO.getContent();
    str = localcommMethodMgr.setTextYin(str);
    localNewsExt.setParam(":VNEWS_ID", paramNewsDAO.getNews_id());
    localNewsExt.setParam(":VUP_NEW_ID", "");
    localNewsExt.setParam(":VNEWS_TYPE", paramNewsDAO.getNews_type());
    localNewsExt.setParam(":VCUST_ID", paramNewsDAO.getCust_id());
    localNewsExt.setParam(":VTITLE", paramNewsDAO.getTitle());
    localNewsExt.setParam(":VCONTENT", str);
    localNewsExt.setParam(":VATTACHMENT_TAG", "0");
    localNewsExt.setParam(":VVALIDITY", "0");
    localNewsExt.setParam(":VNEWS_CLASS", "0");
    localNewsExt.setParam(":VSUBJECT_TAG", paramNewsDAO.getSubject_tag());
    localNewsExt.setParam(":VPUBLISH_USER_ID", paramNewsDAO.getPublish_user_id());
    localNewsExt.setParam(":VAUDIT_USER_ID", paramNewsDAO.getAudit_user_id());
    localNewsExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localNewsExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("SPEC_ROOT_ID", paramNewsDAO.getNews_id());
    return 0;
  }

  public void addNewsZtInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addNewsInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    NewsDAO localNewsDAO = new NewsDAO();
    localNewsDAO.setNews_id(paramBuffers.getString("NEWS_ID"));
    localNewsDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localNewsDAO.setTitle(paramBuffers.getString("TITLE"));
    localNewsDAO.setContent(paramBuffers.getString("CONTENT"));
    localNewsDAO.setPublish_user_id(paramBuffers.getString("SESSION_USER_ID"));
    localNewsDAO.setAudit_user_id(paramBuffers.getString("SESSION_USER_ID"));
    try
    {
      i = addNewsZtInfo(localNewsDAO);
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
    this.log.LOG_INFO("退出addNewsInfo方法...");
  }

  public int addNewsZtInfo(NewsDAO paramNewsDAO)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_ID", paramNewsDAO.getNews_id());
    localNewsExt.setParam(":VUP_NEW_ID", "");
    localNewsExt.setParam(":VNEWS_TYPE", "0");
    localNewsExt.setParam(":VCUST_ID", paramNewsDAO.getCust_id());
    localNewsExt.setParam(":VTITLE", paramNewsDAO.getTitle());
    localNewsExt.setParam(":VCONTENT", paramNewsDAO.getContent());
    localNewsExt.setParam(":VATTACHMENT_TAG", "0");
    localNewsExt.setParam(":VVALIDITY", "0");
    localNewsExt.setParam(":VNEWS_CLASS", "0");
    localNewsExt.setParam(":VSUBJECT_TAG", "1");
    localNewsExt.setParam(":VPUBLISH_USER_ID", paramNewsDAO.getPublish_user_id());
    localNewsExt.setParam(":VAUDIT_USER_ID", paramNewsDAO.getAudit_user_id());
    localNewsExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localNewsExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void genZt(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genZt方法...");
    this.outBuffer = paramBuffers;
    try
    {
      this.queryResult = genZt();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genZt方法...");
  }

  public ArrayList genZt()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VSUBJECT_TAG", "0");
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_ZT");
    return localArrayList;
  }

  public void genZtList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genZt方法...");
    this.outBuffer = paramBuffers;
    try
    {
      this.queryResult = genZtList();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genZt方法...");
  }

  public ArrayList genZtList()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VSUBJECT_TAG", "1");
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_ZT");
    return localArrayList;
  }

  public void addZtsonnewsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addZtsonnewsInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("NEWS_ID");
    String str2 = paramBuffers.getString("ZTSONNEWS");
    try
    {
      i = addZtsonnewsInfo(str1, str2);
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
    this.log.LOG_INFO("退出addZtsonnewsInfo方法...");
  }

  public int addZtsonnewsInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VUP_NEW_ID", paramString1);
    localNewsExt.setParam(":VNEWS_ID", paramString2);
    this.tradeQuery.executeBy(localNewsExt.insBy("ADD_ZT_SON"));
    return 0;
  }

  public void genOneNews(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genOneNews方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("NEWS_ID");
    try
    {
      this.queryResult = genOneNews(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneNews方法...");
  }

  public ArrayList genOneNews(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_ONE_NEWS");
    return localArrayList;
  }

  public ArrayList genNewsByNewsType(String paramString, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_BY_NEWSTYPE", 0, paramInt);
    return localArrayList;
  }

  public void gennocheckinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入gennocheckinfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("QUERY_PARAM");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    try
    {
      if (str1.equals(""))
        this.queryResult = gennocheckinfo(str2);
      else
        this.queryResult = searchNews(str1, str2, "1");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出gennocheckinfo方法...");
  }

  public ArrayList gennocheckinfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString);
    localNewsExt.setParam(":VVALIDITY", "1");
    localArrayList = localNewsExt.selByList("SEL_BY_NOCHECK");
    return localArrayList;
  }

  public void updatenewsinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updatenewsinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    NewsDAO localNewsDAO = new NewsDAO();
    localNewsDAO.setNews_id(paramBuffers.getString("NEWS_ID"));
    localNewsDAO.setNews_type(paramBuffers.getString("NEWS_TYPE"));
    localNewsDAO.setTitle(paramBuffers.getString("TITLE"));
    localNewsDAO.setContent(paramBuffers.getString("CONTENT"));
    localNewsDAO.setPublish_user_id(paramBuffers.getString("SESSION_USER_ID"));
    try
    {
      i = updatenewsinfo(localNewsDAO);
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
    this.log.LOG_INFO("退出updatenewsinfo方法...");
  }

  public int updatenewsinfo(NewsDAO paramNewsDAO)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    localNewsExt.setParam(":VNEWS_ID", paramNewsDAO.getNews_id());
    localNewsExt.setParam(":VNEWS_TYPE", paramNewsDAO.getNews_type());
    localNewsExt.setParam(":VTITLE", paramNewsDAO.getTitle());
    localNewsExt.setParam(":VCONTENT", paramNewsDAO.getContent());
    localNewsExt.setParam(":VPUBLISH_USER_ID", paramNewsDAO.getPublish_user_id());
    this.tradeQuery.executeBy(localNewsExt.insBy("UPDATE_BY_ONE"));
    return 0;
  }

  public void delnewsinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delnewsinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("NEWS_ID");
    try
    {
      i = delnewsinfo(str);
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
    this.log.LOG_INFO("退出delnewsinfo方法...");
  }

  public int delnewsinfo(String paramString)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_ID", paramString);
    this.tradeQuery.executeBy(localNewsExt.insBy("DEL_BY_ONE"));
    return 0;
  }

  public void DeleteNewsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteNewsInfo方法...");
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
        i = delnewsinfo(str2);
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

  public String getCustAttachPath(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getAttachPath方法...");
    Attachinfo localAttachinfo = new Attachinfo();
    String str = "";
    str = localAttachinfo.getAttachPath(paramString1, paramString2, "0");
    this.log.LOG_INFO("退出getAttachPath方法...");
    return str;
  }

  public ArrayList genNewsPicture(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_BY_ROLLPICTURE", 0, paramInt);
    return localArrayList;
  }

  public ArrayList genNewsPictureByHq(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_BY_HQ_PICTURE", 0, paramInt);
    return localArrayList;
  }

  public void audnewsinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delnewsinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("NEWS_ID");
    try
    {
      i = audnewsinfo(str);
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
    this.log.LOG_INFO("退出delnewsinfo方法...");
  }

  public int audnewsinfo(String paramString)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_ID", paramString);
    localNewsExt.setParam(":VVALIDITY", "0");
    this.tradeQuery.executeBy(localNewsExt.insBy("AUD_BY_ONE"));
    return 0;
  }

  public ArrayList searchNews(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VTITLE", "%" + paramString1 + "%");
    localNewsExt.setParam(":VCUST_ID", paramString2);
    localNewsExt.setParam(":VVALIDITY", paramString3);
    localArrayList = localNewsExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public ArrayList getNewsListByCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString);
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_CUST", paramInt, 30);
    return localArrayList;
  }

  public int getNewsNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString);
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_CUST");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewsListBySearch(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localNewsExt.selByList("SEL_BY_KEYS", paramInt, 30);
    return localArrayList;
  }

  public int getNewsSearch(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localNewsExt.selByList("SEL_BY_KEYS");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewsCountByType(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 == 0)
      paramInt1 = 0;
    else
      paramInt1 = (paramInt1 - 1) * paramInt2;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localNewsExt.selByList("SEL_BY_KEYS", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getNewsCountByTypeCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TYPE_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getNewsByType(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TYPE_ID", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getNewsByPage(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TYPE_ID", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getNewsById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_ID");
    return localArrayList;
  }

  public ArrayList getNewCastById()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_NEWS_CAST");
    return localArrayList;
  }

  public ArrayList getAboutByType(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_ABOUT_TYPE");
    return localArrayList;
  }

  public int getNewsByTodayCount()
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TODAY_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getNewsListByCustId(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getNewsListByCustId方法...");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TYPE", paramInt, 20);
    return localArrayList;
  }

  public int getNewsListByCustId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getNewsListByCustIdCount方法...");
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TYPE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewsListByNewsTitle(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getNewsListByCustId方法...");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localNewsExt.setParam(":VNEWS_TITLE", "%" + paramString3 + "%");
    this.log.LOG_INFO(paramString3 + "=============================" + paramString2 + paramString1);
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TYPE_NEWS_TITLE", paramInt, 20);
    this.log.LOG_INFO("LIST===" + localArrayList);
    return localArrayList;
  }

  public int getNewsListByNewsTitle(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getNewsListByCustIdCount方法...");
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localNewsExt.setParam(":VNEWS_TITLE", "%" + paramString3 + "%");
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TYPE_NEWS_TITLE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getPeopleTalkByClassId(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 10;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_PEOPLE_TALK_BY_CLASS_ID", paramInt, 10);
    return localArrayList;
  }

  public int getPeopleTalkByClassId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_PEOPLE_TALK_BY_CLASS_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getPeopleInfoByKeyWord(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 10;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VKEY_WORD", "%" + paramString1 + "%");
    if (paramString2.equals("0"))
      localArrayList = localNewsExt.selByList("SEL_PEOPLE_BY_TITLE", paramInt, 10);
    else
      localArrayList = localNewsExt.selByList("SEL_PEOPLE_BY_CONTENT", paramInt, 10);
    return localArrayList;
  }

  public int getPeopleInfoByKeyWord(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VKEY_WORD", "%" + paramString1 + "%");
    if (paramString2.equals("0"))
      localArrayList = localNewsExt.selByList("SEL_PEOPLE_BY_TITLE");
    else
      localArrayList = localNewsExt.selByList("SEL_PEOPLE_BY_CONTENT");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewsInfoByDisTest(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -3);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VKEY_WORD", "%" + paramString1 + "%");
    if ((paramString2.equals("0")) && (paramString3.equals("0")))
      localArrayList = localNewsExt.selByList("SEL_BY_NEWS_BY_TITLE_ALL", paramInt1, paramInt2);
    if ((paramString2.equals("0")) && (paramString3.equals("1")))
      localArrayList = localNewsExt.selByList("SEL_BY_NEWS_BY_CONTENT_ALL", paramInt1, paramInt2);
    if ((paramString2.equals("1")) && (paramString3.equals("0")))
    {
      localNewsExt.setParam(":VPUBLISH_DATE", str);
      localArrayList = localNewsExt.selByList("SEL_BY_NEWS_BY_TITLE_NEW", paramInt1, paramInt2);
    }
    if ((paramString2.equals("1")) && (paramString3.equals("1")))
    {
      localNewsExt.setParam(":VPUBLISH_DATE", str);
      localArrayList = localNewsExt.selByList("SEL_BY_NEWS_BY_CONTENT_NEW", paramInt1, paramInt2);
    }
    return localArrayList;
  }

  public int getNewsInfoByDisTest(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -3);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VKEY_WORD", "%" + paramString1 + "%");
    if ((paramString2.equals("0")) && (paramString3.equals("0")))
      localArrayList = localNewsExt.selByList("SEL_BY_NEWS_BY_TITLE_ALL");
    if ((paramString2.equals("0")) && (paramString3.equals("1")))
      localArrayList = localNewsExt.selByList("SEL_BY_NEWS_BY_CONTENT_ALL");
    if ((paramString2.equals("1")) && (paramString3.equals("0")))
    {
      localNewsExt.setParam(":VPUBLISH_DATE", str);
      localArrayList = localNewsExt.selByList("SEL_BY_NEWS_BY_TITLE_NEW");
    }
    if ((paramString2.equals("1")) && (paramString3.equals("1")))
    {
      localNewsExt.setParam(":VPUBLISH_DATE", str);
      localArrayList = localNewsExt.selByList("SEL_BY_NEWS_BY_CONTENT_NEW");
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public String getNewsTitleById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_TITLE_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("title") != null)
        str = localHashMap.get("title").toString();
    }
    return str;
  }

  public ArrayList genAllNews(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_BY_ALL", paramInt1, paramInt2);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public int genAllNews()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_BY_ALL");
    if (((localArrayList != null ? 1 : 0) & (localArrayList.size() > 0 ? 1 : 0)) != 0)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewsCommendList(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 == 0)
      paramInt1 = 0;
    else
      paramInt1 = (paramInt1 - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_NEWS_INFO_BY_COMMEND", paramInt1, paramInt2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public int getNewsCommendList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_NEWS_INFO_BY_COMMEND");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList genAllNews(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_NEWS_TYPE", paramInt1, paramInt2);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList getInNewsCommendList(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 == 0)
      paramInt1 = 0;
    else
      paramInt1 = (paramInt1 - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_NEWS_BY_CMEND_TYPE", paramInt1, paramInt2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public int getInNewsCommendList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString);
    localArrayList = localNewsExt.selByList("SEL_NEWS_BY_CMEND_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewsListByCustIdCommend(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getNewsListByCustId方法...");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TYPE", paramInt, 20);
    return localArrayList;
  }

  public int getNewsListByCustIdCommend(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getNewsListByCustIdCount方法...");
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localNewsExt.setParam(":VVALIDITY", "0");
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_TYPE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewsListByCustIdAudi(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getNewsListByCustId方法...");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_AUDI", paramInt, 20);
    return localArrayList;
  }

  public int getNewsListByCustIdAudi(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getNewsListByCustIdCount方法...");
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_AUDI");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewsListByCustIdAuditing(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getNewsListByCustId方法...");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_AUD", paramInt, 20);
    return localArrayList;
  }

  public int getNewsListByCustIdAuditing(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString1);
    localNewsExt.setParam(":VNEWS_TYPE", paramString2);
    localArrayList = localNewsExt.selByList("SEL_BY_NEWS_AUD");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getInNewsCommendList(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_NEWS_BY_CMEND_TYPE_AGAIN", paramInt1, paramInt2);
    return localArrayList;
  }

  public void reloadNewsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入reloadNewsInfo方法...");
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
        i = reloadNewsInfo(str2);
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
    this.log.LOG_INFO("退出reloadNewsInfo方法...");
  }

  public int reloadNewsInfo(String paramString)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_ID", paramString);
    this.tradeQuery.executeBy(localNewsExt.insBy("RELOAD_NEWS_BY_NEWS_ID"));
    return 0;
  }

  public ArrayList genAllNewsByLikeName(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString1);
    localNewsExt.setParam(":VUSER_NAME", "%" + paramString2 + "%");
    localArrayList = localNewsExt.selByList("SEL_NEWS_TYPE_NAME", paramInt1, paramInt2);
    return localArrayList;
  }

  public int genAllNewsByLikeName(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VNEWS_TYPE", paramString1);
    localNewsExt.setParam(":VUSER_NAME", "%" + paramString2 + "%");
    localArrayList = localNewsExt.selByList("SEL_NEWS_TYPE_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList genAllNewsByCHID(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCH_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_NEWS_TYPE_CH_ID");
    return localArrayList;
  }

  public ArrayList NewsByCHIDandID(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCH_ID", paramString1);
    localNewsExt.setParam(":VNEWS_ID", paramString2);
    localArrayList = localNewsExt.selByList("SEL_NEWS_TYPE_CH_ID_AND_NEWS");
    return localArrayList;
  }

  public void addMemberNewsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addNewsInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    NewsDAO localNewsDAO = new NewsDAO();
    localNewsDAO.setNews_id(paramBuffers.getString("NEWS_ID"));
    localNewsDAO.setNews_type(paramBuffers.getString("NEWS_TYPE"));
    localNewsDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localNewsDAO.setTitle(paramBuffers.getString("TITLE"));
    localNewsDAO.setContent(paramBuffers.getString("CONTENT"));
    localNewsDAO.setSubject_tag(paramBuffers.getString("SUBJECT_TAG"));
    localNewsDAO.setPublish_user_id(paramBuffers.getString("SESSION_USER_ID"));
    localNewsDAO.setAudit_user_id(paramBuffers.getString("SESSION_USER_ID"));
    try
    {
      i = addMemberNewsInfo(localNewsDAO);
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
    this.log.LOG_INFO("退出addNewsInfo方法...");
  }

  public int addMemberNewsInfo(NewsDAO paramNewsDAO)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = paramNewsDAO.getContent();
    str = localcommMethodMgr.setTextYin(str);
    localNewsExt.setParam(":VNEWS_ID", paramNewsDAO.getNews_id());
    localNewsExt.setParam(":VUP_NEW_ID", "");
    localNewsExt.setParam(":VNEWS_TYPE", paramNewsDAO.getNews_type());
    localNewsExt.setParam(":VCUST_ID", paramNewsDAO.getCust_id());
    localNewsExt.setParam(":VTITLE", paramNewsDAO.getTitle());
    localNewsExt.setParam(":VCONTENT", str);
    localNewsExt.setParam(":VATTACHMENT_TAG", "0");
    localNewsExt.setParam(":VVALIDITY", "1");
    localNewsExt.setParam(":VNEWS_CLASS", "0");
    localNewsExt.setParam(":VSUBJECT_TAG", paramNewsDAO.getSubject_tag());
    localNewsExt.setParam(":VPUBLISH_USER_ID", paramNewsDAO.getPublish_user_id());
    localNewsExt.setParam(":VAUDIT_USER_ID", paramNewsDAO.getAudit_user_id());
    localNewsExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localNewsExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("SPEC_ROOT_ID", paramNewsDAO.getNews_id());
    return 0;
  }

  public ArrayList getMemberNewsList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_MEMBER_NEWS_TYPE", paramInt, 20);
    return localArrayList;
  }

  public int getMemberNewsList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localNewsExt.selByList("SEL_MEMBER_NEWS_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getMemberNewsListForAdmin(int paramInt)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_ADMIN_NEWS_TYPE", paramInt, 20);
    return localArrayList;
  }

  public int getMemberNewsListForAdmin()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localArrayList = localNewsExt.selByList("SEL_ADMIN_NEWS_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void updateMemberNewsinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateMemberNewsinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("NEWS_ID");
    try
    {
      i = updateMemberNewsinfo(str);
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
    this.log.LOG_INFO("退出updateMemberNewsinfo方法...");
  }

  public int updateMemberNewsinfo(String paramString)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    localNewsExt.setParam(":VNEWS_ID", paramString);
    this.tradeQuery.executeBy(localNewsExt.insBy("UPDATE_BY_ONE_MEMBER"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.newsMgr.NewsInfo
 * JD-Core Version:    0.6.0
 */