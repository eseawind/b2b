package com.saas.biz.stockorderMgr;

import com.saas.biz.dao.stockorderDAO.StockorderExt;
import com.saas.biz.propertyuMgr.PropertyuInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class StockInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();
  SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");

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

  public ArrayList getStockInfoList(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    PropertyuInfo localPropertyuInfo = new PropertyuInfo();
    boolean bool = localPropertyuInfo.getValidityInfo("106", paramString);
    if (bool)
      localArrayList = getStockInfoByList(paramInt1, paramInt2);
    else
      localArrayList = getStockInfoByList(paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getStockInfoByList(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    StockorderExt localStockorderExt = new StockorderExt();
    ArrayList localArrayList = localStockorderExt.selByList("SEL_BY_VIEW", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getStockInfoByCount()
    throws SaasApplicationException
  {
    StockorderExt localStockorderExt = new StockorderExt();
    ArrayList localArrayList = localStockorderExt.selByList("SEL_BY_VIEW_COUNT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewStockInfoByList(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    Calendar localCalendar = Calendar.getInstance();
    String str1 = this.formate.format(localCalendar.getTime());
    localCalendar.add(2, 1);
    String str2 = this.formate.format(localCalendar.getTime());
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTART_DATE", str1);
    localStockorderExt.setParam(":VEND_DATE", str2);
    ArrayList localArrayList = localStockorderExt.selByList("SEL_NEW_BY_VIEW", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getNewStockInfoByCount()
    throws SaasApplicationException
  {
    Calendar localCalendar = Calendar.getInstance();
    String str1 = this.formate.format(localCalendar.getTime());
    localCalendar.add(2, 1);
    String str2 = this.formate.format(localCalendar.getTime());
    int i = 0;
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTART_DATE", str1);
    localStockorderExt.setParam(":VEND_DATE", str2);
    ArrayList localArrayList = localStockorderExt.selByList("SEL_NEW_BY_VIEW_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public HashMap getStockInfoById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTOCK_ID", paramString);
    ArrayList localArrayList = localStockorderExt.selByList("SEL_VIEW_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getProductByStock(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getProductByStock方法");
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 10;
    else
      paramInt = 0;
    Calendar localCalendar = Calendar.getInstance();
    if ("".equals(paramString1))
      paramString1 = "%";
    if ("".equals(paramString2))
      paramString2 = "%";
    if ("".equals(paramString3))
      paramString3 = "%";
    if ("".equals(paramString4))
      paramString4 = "365";
    localCalendar.add(5, Integer.parseInt(paramString4) - Integer.parseInt(paramString4) * 2);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    this.log.LOG_INFO("=========================stock_key=" + paramString1 + "=============pro=" + paramString2 + "=========city=" + paramString3 + "==========date_scope1=" + str);
    localStockorderExt.setParam(":VSTOCK_KEY", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VPRO", "%" + paramString2 + "%");
    localStockorderExt.setParam(":VCITY", "%" + paramString3 + "%");
    localStockorderExt.setParam(":VDATE", str);
    localArrayList = localStockorderExt.selByList("SEL_PRODUCT_BY_STOCK", paramInt, 10);
    this.log.LOG_INFO("退出getProductByStock方法");
    return localArrayList;
  }

  public int getProductByStock(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    int i = 0;
    StockorderExt localStockorderExt = new StockorderExt();
    Calendar localCalendar = Calendar.getInstance();
    if ("".equals(paramString1))
      paramString1 = "%";
    if ("".equals(paramString2))
      paramString2 = "%";
    if ("".equals(paramString3))
      paramString3 = "%";
    if ("".equals(paramString4))
      paramString4 = "365";
    localCalendar.add(5, Integer.parseInt(paramString4) - Integer.parseInt(paramString4) * 2);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    localStockorderExt.setParam(":VSTOCK_KEY", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VPRO", "%" + paramString2 + "%");
    localStockorderExt.setParam(":VCITY", "%" + paramString3 + "%");
    localStockorderExt.setParam(":VDATE", str);
    ArrayList localArrayList = localStockorderExt.selByList("SEL_PRODUCT_BY_STOCK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getProductByStockOffCity(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getProductByStock方法");
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 10;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTOCK_KEY", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VPRO", "%" + paramString2 + "%");
    localStockorderExt.setParam(":VPART", paramString3);
    localArrayList = localStockorderExt.selByList("SEL_PRODUCT_BY_STOCK_CT", paramInt, 10);
    this.log.LOG_INFO("退出getProductByStock方法");
    return localArrayList;
  }

  public int getProductByStockOffCity(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VSTOCK_KEY", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VPRO", "%" + paramString2 + "%");
    localStockorderExt.setParam(":VPART", paramString3);
    ArrayList localArrayList = localStockorderExt.selByList("SEL_PRODUCT_BY_STOCK_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getProductByStockOffKey(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getProductByStock方法");
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 10;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VPRO", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VPART", paramString2);
    localArrayList = localStockorderExt.selByList("SEL_PRODUCT_BY_NO_KEY", paramInt, 10);
    this.log.LOG_INFO("退出getProductByStock方法");
    return localArrayList;
  }

  public int getProductByStockOffKey(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VPRO", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VPART", paramString2);
    ArrayList localArrayList = localStockorderExt.selByList("SEL_PRODUCT_BY_NO_KEY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getProductByOff(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getProductByStock方法");
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 10;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VPRO", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VCITY", "%" + paramString2 + "%");
    localStockorderExt.setParam(":VPART", paramString3);
    localArrayList = localStockorderExt.selByList("SEL_PRODUCT_NO_KEY", paramInt, 10);
    this.log.LOG_INFO("退出getProductByStock方法");
    return localArrayList;
  }

  public int getProductByOff(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VPRO", "%" + paramString1 + "%");
    localStockorderExt.setParam(":VCITY", "%" + paramString2 + "%");
    localStockorderExt.setParam(":VPART", paramString3);
    ArrayList localArrayList = localStockorderExt.selByList("SEL_PRODUCT_NO_KEY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getOtherInfoByCust(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StockorderExt localStockorderExt = new StockorderExt();
    localStockorderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localStockorderExt.selByList("SEL_OTHER_BY_CUST_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.stockorderMgr.StockInfo
 * JD-Core Version:    0.6.0
 */