package com.saas.biz.saleMgr;

import com.saas.biz.dao.saleDAO.SaleExt;
import com.saas.biz.propertyuMgr.PropertyuInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SupplyInfo
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

  public ArrayList getSupplyInfoList(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    PropertyuInfo localPropertyuInfo = new PropertyuInfo();
    boolean bool = localPropertyuInfo.getValidityInfo("106", paramString);
    if (!bool)
      localArrayList = getSaleInfoList(paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getLastSupplyInfo(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_BY_LIMIT", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList getSaleInfoList(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    paramInt1 *= paramInt2;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_BY_VIEW", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getSaleInfoCount()
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_BY_VIEW");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getNewSaleInfoList(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    paramInt1 *= paramInt2;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_NEW_BY_VIEW", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getNewSaleInfoCount()
    throws SaasApplicationException
  {
    Calendar localCalendar = Calendar.getInstance();
    String str1 = this.formate.format(localCalendar.getTime());
    localCalendar.add(2, 1);
    String str2 = this.formate.format(localCalendar.getTime());
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSTART_DATE", str1);
    localSaleExt.setParam(":VEND_DATE", str2);
    localArrayList = localSaleExt.selByList("SEL_NEW_VIEW_COUNT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public HashMap getSaleInfoById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_VIEW_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getSupplyCompareById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken();
      HashMap localHashMap = getSupplyInfoById(str);
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }

  public HashMap getSupplyInfoById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_SALEINF_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getProductByLike(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
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
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPRODUCT_NAME", "%" + paramString1 + "%");
    localSaleExt.setParam(":VPRO", "%" + paramString2 + "%");
    localSaleExt.setParam(":VCITY", "%" + paramString3 + "%");
    localSaleExt.setParam(":VDATE_SCOPE", str);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_LIKE", paramInt, 10);
    return localArrayList;
  }

  public int getProductByLike(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    if ("".equals(paramString1))
      paramString1 = "%";
    if ("".equals(paramString2))
      paramString2 = "%";
    if ("".equals(paramString3))
      paramString3 = "%";
    if ("".equals(paramString4))
      paramString4 = "-365";
    localCalendar.add(5, Integer.parseInt(paramString4) - Integer.parseInt(paramString4) * 2);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPRODUCT_NAME", "%" + paramString1 + "%");
    localSaleExt.setParam(":VPRO", "%" + paramString2 + "%");
    localSaleExt.setParam(":VCITY", "%" + paramString3 + "%");
    localSaleExt.setParam(":VDATE_SCOPE", str);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_LIKE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getProductByEqual(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 10;
    else
      paramInt = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, Integer.parseInt("-" + paramString4));
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPRODUCT_NAME", paramString1);
    localSaleExt.setParam(":VPRO", paramString2);
    localSaleExt.setParam(":VCITY", paramString3);
    localSaleExt.setParam(":VDATE_SCOPE", str);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_EQUAL", paramInt, 20);
    return localArrayList;
  }

  public int getProductByEqual(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, Integer.parseInt(paramString4));
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPRODUCT_NAME", paramString1);
    localSaleExt.setParam(":VPRO", paramString2);
    localSaleExt.setParam(":VCITY", paramString3);
    localSaleExt.setParam(":VDATE_SCOPE", str);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_EQUAL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getSelectProductByOne(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSelectProductByOne方法...");
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 10;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPROV", "%" + paramString1 + "%");
    localSaleExt.setParam(":VPART", paramString2);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_ONE", paramInt, 10);
    return localArrayList;
  }

  public int getSelectProductByOne(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("Count进入getSelectProductByOne方法...");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPROV", "%" + paramString1 + "%");
    localSaleExt.setParam(":VPART", paramString2);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_ONE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getSelectProductByTwo(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSelectProductByTwo方法...");
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 10;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPROV", "%" + paramString1 + "%");
    localSaleExt.setParam(":VKEY", "%" + paramString2 + "%");
    localSaleExt.setParam(":VPART", paramString3);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_TWO", paramInt, 10);
    return localArrayList;
  }

  public int getSelectProductByTwo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("Count进入getSelectProductByTwo方法...");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPROV", "%" + paramString1 + "%");
    localSaleExt.setParam(":VKEY", "%" + paramString2 + "%");
    localSaleExt.setParam(":VPART", paramString3);
    this.log.LOG_INFO("part=================" + paramString3);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_TWO");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getSelectProductByThree(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSelectProductByThree方法...");
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 10;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPROV", "%" + paramString1 + "%");
    localSaleExt.setParam(":VCITY", "%" + paramString2 + "%");
    localSaleExt.setParam(":VPART", paramString3);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_THREE", paramInt, 10);
    return localArrayList;
  }

  public int getSelectProductByThree(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("Count进入getSelectProductByThree方法...");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPROV", "%" + paramString1 + "%");
    localSaleExt.setParam(":VCITY", "%" + paramString2 + "%");
    localSaleExt.setParam(":VPART", paramString3);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_THREE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getSelectProductNoFour(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSelectProductNoFour方法...");
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 10;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPROV", "%" + paramString1.trim() + "%");
    localSaleExt.setParam(":VCITY", "%" + paramString2.trim() + "%");
    localSaleExt.setParam(":VKEY", "%" + paramString3.trim() + "%");
    localSaleExt.setParam(":VPART", paramString4);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_NO_FOUR", paramInt, 10);
    return localArrayList;
  }

  public int getSelectProductNoFour(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("count进入getSelectProductNoFour方法...");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VPROV", "%" + paramString1.trim() + "%");
    localSaleExt.setParam(":VCITY", "%" + paramString2.trim() + "%");
    localSaleExt.setParam(":VKEY", "%" + paramString3.trim() + "%");
    localSaleExt.setParam(":VPART", paramString4);
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_NO_FOUR");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getOtherInfoByCust(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VCUST_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_OTHER_BY_CUST");
    return localArrayList;
  }

  public ArrayList getSearchSaleInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSearchSaleInfo方法");
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt3);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VKEY", "%" + paramString1 + "%");
    localSaleExt.setParam(":VPRO", "%" + paramString2 + "%");
    localSaleExt.setParam(":VCITY", "%" + paramString3 + "%");
    localSaleExt.setParam(":VDATE", str);
    localSaleExt.setParam(":VSALE_TYPE", paramString4);
    if ((paramString2.equals("")) && (paramString3.equals("")) && (paramInt3 != 365))
      localArrayList = localSaleExt.selByList("SEL_NO_PRO_CITYSALE", paramInt1, paramInt2);
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localSaleExt.selByList("SEL_NO_CITYSALE", paramInt1, paramInt2);
    else if ((paramInt3 == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localSaleExt.selByList("SEL_NO_DATESALE", paramInt1, paramInt2);
    else if ((!paramString3.equals("")) && (!paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localSaleExt.selByList("SEL_SAL_BY_ALL", paramInt1, paramInt2);
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt3 == 365))
      localArrayList = localSaleExt.selByList("SEL_SAL_BY_PRO", paramInt1, paramInt2);
    else
      localArrayList = localSaleExt.selByList("SEL_BY_KEYSALE", paramInt1, paramInt2);
    this.log.LOG_INFO("退出getSearchSaleInfo方法");
    return localArrayList;
  }

  public int getSearchSaleInfo(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
    throws SaasApplicationException
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VKEY", "%" + paramString1 + "%");
    localSaleExt.setParam(":VPRO", "%" + paramString2 + "%");
    localSaleExt.setParam(":VCITY", "%" + paramString3 + "%");
    localSaleExt.setParam(":VDATE", str);
    localSaleExt.setParam(":VSALE_TYPE", paramString4);
    if ((paramString2.equals("")) && (paramInt != 365))
      localArrayList = localSaleExt.selByList("SEL_NO_PRO_CITYSALE");
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt != 365))
      localArrayList = localSaleExt.selByList("SEL_NO_CITYSALE");
    else if ((paramInt == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localSaleExt.selByList("SEL_NO_DATESALE");
    else if ((!paramString3.equals("")) && (!paramString2.equals("")) && (paramInt != 365))
      localArrayList = localSaleExt.selByList("SEL_SAL_BY_ALL");
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt == 365))
      localArrayList = localSaleExt.selByList("SEL_SAL_BY_PRO");
    else
      localArrayList = localSaleExt.selByList("SEL_BY_KEYSALE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getSearchSaleList(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSearchSaleList方法");
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt3);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VKEY", paramString1);
    localSaleExt.setParam(":VPRO", paramString2);
    localSaleExt.setParam(":VCITY", paramString3);
    localSaleExt.setParam(":VDATE", str);
    localSaleExt.setParam(":VSALE_TYPE", paramString4);
    if ((paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localSaleExt.selByList("SEL_NO_PRO_CITYSALES", paramInt1, paramInt2);
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localSaleExt.selByList("SEL_NO_CITYSALES", paramInt1, paramInt2);
    else if ((paramInt3 == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localSaleExt.selByList("SEL_NO_DATESALES", paramInt1, paramInt2);
    else
      localArrayList = localSaleExt.selByList("SEL_BY_KEYSALES", paramInt1, paramInt2);
    this.log.LOG_INFO("退出getSearchSaleList方法");
    return localArrayList;
  }

  public int getSearchSaleList(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
    throws SaasApplicationException
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VKEY", paramString1);
    localSaleExt.setParam(":VPRO", paramString2);
    localSaleExt.setParam(":VCITY", paramString3);
    localSaleExt.setParam(":VDATE", str);
    localSaleExt.setParam(":VSALE_TYPE", paramString4);
    if ((paramString2.equals("")) && (paramInt != 365))
      localArrayList = localSaleExt.selByList("SEL_NO_PRO_CITYSALES");
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt != 365))
      localArrayList = localSaleExt.selByList("SEL_NO_CITYSALES");
    else if ((paramInt == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localSaleExt.selByList("SEL_NO_DATESALES");
    else
      localArrayList = localSaleExt.selByList("SEL_BY_KEYSALES");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList genAdminList(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("genAdminList...");
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_ADMIN", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList genAdminListArea(String paramString, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("genAdminList...");
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VAREA", "%" + paramString + "%");
    localArrayList = localSaleExt.selByList("SEL_AREA_PRODUCT_BY_ADMIN", paramInt1, paramInt2);
    return localArrayList;
  }

  public int genAdminListArea(String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("genAdminList...");
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VAREA", "%" + paramString + "%");
    localArrayList = localSaleExt.selByList("SEL_AREA_PRODUCT_BY_ADMIN");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int genAdminList()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_PRODUCT_BY_ADMIN");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.saleMgr.SupplyInfo
 * JD-Core Version:    0.6.0
 */