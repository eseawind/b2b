package com.saas.biz.stockorderMgr;

import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.dao.stockorderDAO.StockorderDAO;
import com.saas.biz.dao.stockorderDAO.StockorderExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Stockorderinfo
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

  public void genStockorder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genStockorder方法...");
    try
    {
      this.queryResult = genStockorder();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genStockorder方法...");
  }

  public ArrayList genStockorder()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localArrayList1 = localStockorderExt.selByList("SEL_BY_ALL");
    if (localArrayList1 == null)
      return null;
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("stock_id") != null)
        str2 = localHashMap1.get("stock_id").toString();
      if (localHashMap1.get("title") != null)
        str1 = localHashMap1.get("title").toString();
      localHashMap2.put("title", str1);
      localHashMap2.put("stockId", str2);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public ArrayList genStockorderLimit(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localArrayList = localStockorderExt.selByList("SEL_BY_LIMIT", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList genStockEmergency(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localArrayList = localStockorderExt.selByList("SEL_BY_EMERGENCY", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList genStockByToday(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localArrayList = localStockorderExt.selByList("SEL_BY_TODAY", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public String getCustAttachPath(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Attachinfo localAttachinfo = new Attachinfo();
    String str = localAttachinfo.getAttachPath(paramString1, paramString2, "0");
    return str;
  }

  public void genSpecStockorder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genSpecStockorder方法...");
    String str = paramBuffers.getString("CUST_ID");
    try
    {
      this.queryResult = genSpecStockorder("cust_id");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genSpecStockorder方法...");
  }

  public ArrayList genSpecStockorder(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    localArrayList1 = localStockorderExt.selByList("SEL_SPEC_STOCKORDER");
    if (localArrayList1 == null)
      return null;
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("stock_id") != null)
        str2 = localHashMap1.get("stock_id").toString();
      if (localHashMap1.get("title") != null)
        str1 = localHashMap1.get("title").toString();
      try
      {
        str1 = new String(str1.getBytes("ISO8859_1"), "GB2312");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
      localHashMap2.put("title", str1);
      localHashMap2.put("stockId", str2);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public void genPKStockorder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genPKStockorder方法...");
    String str = paramBuffers.getString("STOCK_ID");
    try
    {
      this.queryResult = genPKStockorder("STOCK_ID");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genPKStockorder方法...");
  }

  public ArrayList genPKStockorder(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTOCK_ID", paramString);
    localArrayList1 = localStockorderExt.selByList("SEL_BY_PK");
    if (localArrayList1 == null)
      return null;
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("stock_id") != null)
        str2 = localHashMap1.get("stock_id").toString();
      if (localHashMap1.get("title") != null)
        str1 = localHashMap1.get("title").toString();
      try
      {
        str1 = new String(str1.getBytes("ISO8859_1"), "GB2312");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
      localHashMap2.put("title", str1);
      localHashMap2.put("stock_id", str2);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public void addAddstockorder(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addstockorder方法...");
    int i = -1;
    StockorderDAO localStockorderDAO = new StockorderDAO();
    localStockorderDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localStockorderDAO.setTitle(paramBuffers.getString("TITLE"));
    localStockorderDAO.setContent(paramBuffers.getString("CONTENT"));
    localStockorderDAO.setStock_addr(paramBuffers.getString("STOCK_ADDR"));
    localStockorderDAO.setStock_id(paramBuffers.getString("STOCK_ID"));
    localStockorderDAO.setStart_date(paramBuffers.getString("START_DATE"));
    localStockorderDAO.setEnd_date(paramBuffers.getString("END_DATE"));
    localStockorderDAO.setPublish_user_id(paramBuffers.getString("SESSION_USER_ID"));
    try
    {
      i = addStockorderinfo(localStockorderDAO);
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
    this.log.LOG_INFO("退出addstockorder方法...");
  }

  public int addStockorderinfo(StockorderDAO paramStockorderDAO)
    throws SaasApplicationException
  {
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTOCK_ID", paramStockorderDAO.getStock_id());
    localStockorderExt.setParam(":VCUST_ID", paramStockorderDAO.getCust_id());
    localStockorderExt.setParam(":VTITLE", paramStockorderDAO.getTitle());
    localStockorderExt.setParam(":VCONTENT", paramStockorderDAO.getContent());
    localStockorderExt.setParam(":VSTOCK_ADDR", paramStockorderDAO.getStock_addr());
    localStockorderExt.setParam(":VSTOCK_CLASS", "0");
    localStockorderExt.setParam(":VSTART_DATE", paramStockorderDAO.getStart_date());
    localStockorderExt.setParam(":VEND_DATE", paramStockorderDAO.getEnd_date());
    localStockorderExt.setParam(":VSTOCK_TYPE", "0");
    localStockorderExt.setParam(":VPUBLISH_USER_ID", paramStockorderDAO.getPublish_user_id());
    localStockorderExt.setParam(":VVALIDITY", "0");
    this.tradeQuery.executeBy(localStockorderExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("ROOT_ID", paramStockorderDAO.getStock_id());
    return 0;
  }

  public void genCustStockorder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genCustStockorder方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = genCustStockorder(str1);
      else
        this.queryResult = searchStockorder(str2, str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genCustStockorderr方法...");
  }

  public ArrayList genCustStockorder(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    localStockorderExt.setParam(":VVALIDITY", "0");
    localArrayList = localStockorderExt.selByList("SEL_CUST_STOCKORDER");
    return localArrayList;
  }

  public ArrayList searchStockorder(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VTITLE", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VCUST_ID", paramString2);
    localStockorderExt.setParam(":VVALIDITY", "0");
    localArrayList = localStockorderExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public void changstockorder(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入changstockorder方法...");
    int i = -1;
    try
    {
      StockorderDAO localStockorderDAO = new StockorderDAO();
      localStockorderDAO.setTitle(paramBuffers.getString("TITLE"));
      localStockorderDAO.setContent(paramBuffers.getString("CONTENT"));
      localStockorderDAO.setStock_addr(paramBuffers.getString("STOCK_ADDR"));
      localStockorderDAO.setStock_id(paramBuffers.getString("STOCK_ID"));
      localStockorderDAO.setStart_date(paramBuffers.getString("START_DATE"));
      localStockorderDAO.setEnd_date(paramBuffers.getString("END_DATE"));
      i = changstockorder(localStockorderDAO);
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
    this.log.LOG_INFO("退出changstockorder方法...");
  }

  public int changstockorder(StockorderDAO paramStockorderDAO)
    throws SaasApplicationException
  {
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTOCK_ID", paramStockorderDAO.getStock_id());
    localStockorderExt.setParam(":VTITLE", paramStockorderDAO.getTitle());
    localStockorderExt.setParam(":VCONTENT", paramStockorderDAO.getContent());
    localStockorderExt.setParam(":VSTOCK_ADDR", paramStockorderDAO.getStock_addr());
    localStockorderExt.setParam(":VSTART_DATE", paramStockorderDAO.getStart_date());
    localStockorderExt.setParam(":VEND_DATE", paramStockorderDAO.getEnd_date());
    this.tradeQuery.executeBy(localStockorderExt.insBy("UPDATE_BY_STOCKORDER"));
    return 0;
  }

  public void genOneStockorder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genOneStockorder方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("STOCK_ID");
    try
    {
      this.queryResult = genOneStockorder(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneStockorder方法...");
  }

  public ArrayList genOneStockorder(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTOCK_ID", paramString);
    localArrayList = localStockorderExt.selByList("SEL_BY_PK");
    return localArrayList;
  }

  public void delStockorder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delStockorder方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("STOCK_ID");
    int i = -1;
    try
    {
      i = delStockorder(str);
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
    this.log.LOG_INFO("退出delStockorder方法...");
  }

  public void DeleteStockInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteStockInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("STOCK_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = delStockorder(str2);
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
    this.log.LOG_INFO("退出DeleteStockInfo方法...");
  }

  public int delStockorder(String paramString)
    throws SaasApplicationException
  {
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTOCK_ID", paramString);
    this.tradeQuery.executeBy(localStockorderExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public void deleteStockorder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delStockorder方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("CUST_ID");
    int i = -1;
    try
    {
      i = deleteStockorder(str);
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
    this.log.LOG_INFO("退出delStockorder方法...");
  }

  public void DeletestockInfoTW(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = deleteStockorder(str2);
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

  public int deleteStockorder(String paramString)
    throws SaasApplicationException
  {
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    this.tradeQuery.executeBy(localStockorderExt.insBy("STATE_DELETE_STOCK"));
    return 0;
  }

  public ArrayList getStockListByAll(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    localStockorderExt.setParam(":VVALIDITY", "0");
    localArrayList = localStockorderExt.selByList("SEL_CUST_STOCKORDER", paramInt, 30);
    return localArrayList;
  }

  public ArrayList getALLStockListByAll(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    localStockorderExt.setParam(":VVALIDITY", "0");
    localArrayList = localStockorderExt.selByList("SEL_ALL_CUST_STOCKORDER", paramInt, 30);
    return localArrayList;
  }

  public ArrayList getStockListMemberByAll(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    localArrayList = localStockorderExt.selByList("SEL_ALL_MEMBER_CUST_STOCKORDER", paramInt, 30);
    return localArrayList;
  }

  public int getStockListMemberByAll(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localStockorderExt.selByList("SEL_ALL_MEMBER_CUST_STOCKORDER");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getStockListByKey(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString1);
    localStockorderExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    localArrayList = localStockorderExt.selByList("SEARCH_KEY_CUST_STOCKORDER", paramInt, 30);
    return localArrayList;
  }

  public ArrayList getStockMemberListByKey(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString1);
    localStockorderExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    localArrayList = localStockorderExt.selByList("SEARCH_KEY_CUST_STOCKORDER_BY_CUSTID", paramInt, 30);
    return localArrayList;
  }

  public ArrayList getStockListByDate(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("--------------------------startTime==============" + paramString2);
    this.log.LOG_INFO("--------------------------endTime==============" + paramString3);
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString1);
    localStockorderExt.setParam(":VSTART_TIME", paramString2);
    localStockorderExt.setParam(":VEND_TIME", paramString3);
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    localStockorderExt.setParam(":VVALIDITY", "0");
    localArrayList = localStockorderExt.selByList("SEARCH_DATE_CUST_STOCKORDER", paramInt, 30);
    return localArrayList;
  }

  public int getStockListNumberByTime(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VVALIDITY", "0");
    localStockorderExt.setParam(":VCUST_ID", paramString1);
    localStockorderExt.setParam(":VSTART_TIME", paramString2);
    localStockorderExt.setParam(":VEND_TIME", paramString3);
    localArrayList = localStockorderExt.selByList("SEARCH_DATE_CUST_STOCKORDER");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getStockListNumberByKey(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VVALIDITY", "0");
    localStockorderExt.setParam(":VCUST_ID", paramString1);
    localStockorderExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localStockorderExt.selByList("SEARCH_KEY_CUST_STOCKORDER_BY_CUSTID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getStockListMemberByKey(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VVALIDITY", "0");
    localStockorderExt.setParam(":VCUST_ID", paramString1);
    localStockorderExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localStockorderExt.selByList("SEARCH_KEY_CUST_STOCKORDER");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getStockListNumber(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localStockorderExt.selByList("SEL_STOCK_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public int getOffStockListNumber(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VVALIDITY", "0");
    localStockorderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localStockorderExt.selByList("SEL_CUST_OFF_STOCK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getStockListBySearch(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localStockorderExt.selByList("SEL_BY_KEYS", paramInt, 30);
    return localArrayList;
  }

  public int getStockSearch(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localStockorderExt.selByList("SEL_BY_KEYS");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getStockToday()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localArrayList = localStockorderExt.selByList("SEL_BY_TODAY_COUNT");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getStockListBy()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VVALIDITY", "0");
    localArrayList = localStockorderExt.selByList("SEL_CUST_NEW_STOCK");
    return localArrayList;
  }

  public void reloadStockInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入reloadStockInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("STOCK_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = reloadStockInfo(str2);
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

  public int reloadStockInfo(String paramString)
    throws SaasApplicationException
  {
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTOCK_ID", paramString);
    this.tradeQuery.executeBy(localStockorderExt.insBy("RELOAD_STOCK_BY_STOCK_ID"));
    return 0;
  }

  public ArrayList getSearchStockInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSearchStockInfo方法");
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt3);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VKEY", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VPRO", "%" + paramString2 + "%");
    localStockorderExt.setParam(":VCITY", "%" + paramString3 + "%");
    localStockorderExt.setParam(":VDATE", str);
    if ((paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localStockorderExt.selByList("SEL_NO_PRO_CITY", paramInt1, paramInt2);
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localStockorderExt.selByList("SEL_NO_CITY", paramInt1, paramInt2);
    else if ((paramInt3 == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localStockorderExt.selByList("SEL_NO_DATE", paramInt1, paramInt2);
    else
      localArrayList = localStockorderExt.selByList("SEL_BY_KEY", paramInt1, paramInt2);
    this.log.LOG_INFO("退出getSearchStockInfo方法");
    return localArrayList;
  }

  public int getSearchStockInfo(String paramString1, String paramString2, String paramString3, int paramInt)
    throws SaasApplicationException
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VKEY", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VPRO", "%" + paramString2 + "%");
    localStockorderExt.setParam(":VCITY", "%" + paramString3 + "%");
    localStockorderExt.setParam(":VDATE", str);
    if ((paramString2.equals("")) && (paramInt != 365))
      localArrayList = localStockorderExt.selByList("SEL_NO_PRO_CITY");
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt != 365))
      localArrayList = localStockorderExt.selByList("SEL_NO_CITY");
    else if ((paramInt == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localStockorderExt.selByList("SEL_NO_DATE");
    else
      localArrayList = localStockorderExt.selByList("SEL_BY_KEY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getSearchStockList(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSearchStockList方法");
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt3);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VKEY", paramString1);
    localStockorderExt.setParam(":VPRO", paramString2);
    localStockorderExt.setParam(":VCITY", paramString3);
    localStockorderExt.setParam(":VDATE", str);
    if ((paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localStockorderExt.selByList("SEL_NO_PRO_CITYSS", paramInt1, paramInt2);
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localStockorderExt.selByList("SEL_NO_CITYSS", paramInt1, paramInt2);
    else if ((paramInt3 == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localStockorderExt.selByList("SEL_NO_DATESS", paramInt1, paramInt2);
    else
      localArrayList = localStockorderExt.selByList("SEL_BY_KEYSS", paramInt1, paramInt2);
    this.log.LOG_INFO("退出getSearchStockList方法");
    return localArrayList;
  }

  public int getSearchStockList(String paramString1, String paramString2, String paramString3, int paramInt)
    throws SaasApplicationException
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VKEY", paramString1);
    localStockorderExt.setParam(":VPRO", paramString2);
    localStockorderExt.setParam(":VCITY", paramString3);
    localStockorderExt.setParam(":VDATE", str);
    if ((paramString2.equals("")) && (paramInt != 365))
      localArrayList = localStockorderExt.selByList("SEL_NO_PRO_CITYSS");
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt != 365))
      localArrayList = localStockorderExt.selByList("SEL_NO_CITYSS");
    else if ((paramInt == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localStockorderExt.selByList("SEL_NO_DATESS");
    else
      localArrayList = localStockorderExt.selByList("SEL_BY_KEYSS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.stockorderMgr.Stockorderinfo
 * JD-Core Version:    0.6.0
 */