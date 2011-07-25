package com.saas.biz.commodityMgr;

import com.saas.biz.dao.commodityDAO.CommodityDAO;
import com.saas.biz.dao.commodityDAO.CommodityExt;
import com.saas.biz.dao.infoclassDAO.InfoClassExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CommodityInfo
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

  public void genCommodityList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genCommodityList方法...");
    String str = paramBuffers.getString("COMMODITY_ID");
    try
    {
      this.queryResult = genCommodityList(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genCommodityList方法...");
  }

  public ArrayList genCommodityList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCOMMODITY_ID", paramString);
    localArrayList = localCommodityExt.selByList("SEL_BY_PK");
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public void genAllCommodityList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genAllCommodityList方法...");
    String str = paramBuffers.getString("COMMODITY_ID");
    try
    {
      this.queryResult = genAllCommodityList();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genAllCommodityList方法...");
  }

  public ArrayList genAllCommodityList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CommodityExt localCommodityExt = new CommodityExt();
    localArrayList1 = localCommodityExt.selByList("SEL_BY_ALL");
    if (localArrayList1 == null)
      return null;
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      String str3 = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("commodity_id") != null)
        str2 = localHashMap1.get("commodity_id").toString();
      if (localHashMap1.get("commodity_name") != null)
        str1 = localHashMap1.get("commodity_name").toString();
      if (localHashMap1.get("publish_date") != null)
        str3 = localHashMap1.get("publish_date").toString();
      try
      {
        str1 = new String(str1.getBytes("GB2312"), "ISO8859_1");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
      localHashMap2.put("commodity_name", str1);
      localHashMap2.put("commodity_id", str2);
      localHashMap2.put("publish_date", str3);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public void genCustgoodsList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genCustgoodsList方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = genCustgoodsList(str1);
      else
        this.queryResult = searchCommodity(str2, str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genCustgoodsList方法...");
  }

  public ArrayList genCustgoodsList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCUST_ID", paramString);
    localCommodityExt.setParam(":VVALIDITY", "0");
    localArrayList = localCommodityExt.selByList("SEL_BY_CUSTID");
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public void addCommodityInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCommodityInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("PRODUCT_ID");
    CommodityDAO localCommodityDAO = new CommodityDAO();
    localCommodityDAO.setCommodity_id(paramBuffers.getString("COMMODITY_ID"));
    localCommodityDAO.setCust_id(paramBuffers.getString("CUST_ID"));
    localCommodityDAO.setCommodity_type(paramBuffers.getString("COMMODITY_TYPE"));
    localCommodityDAO.setCommodity_name(paramBuffers.getString("COMMODITY_NAME"));
    localCommodityDAO.setContent(paramBuffers.getString("CONTENT"));
    localCommodityDAO.setCommodity_brand(paramBuffers.getString("COMMODITY_BRAND"));
    localCommodityDAO.setCommodity_price(paramBuffers.getString("COMMODITY_PRICE"));
    localCommodityDAO.setPrice_type(paramBuffers.getString("PRICE_TYPE"));
    localCommodityDAO.setSale_price(paramBuffers.getString("SALE_PRICE"));
    localCommodityDAO.setCommodity_unit(paramBuffers.getString("COMMODITY_UNIT"));
    localCommodityDAO.setSale_market(paramBuffers.getString("SALE_MARKET"));
    localCommodityDAO.setPublish_user_id(paramBuffers.getString("SESSION_USER_ID"));
    localCommodityDAO.setAudit_user_id(paramBuffers.getString("SESSION_USER_ID"));
    try
    {
      i = addCommodityInfo(localCommodityDAO, str);
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
    this.log.LOG_INFO("退出addCommodityInfo方法...");
  }

  public int addCommodityInfo(CommodityDAO paramCommodityDAO, String paramString)
    throws SaasApplicationException
  {
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCUST_ID", paramCommodityDAO.getCust_id());
    localCommodityExt.setParam(":VCOMMODITY_ID", paramCommodityDAO.getCommodity_id());
    localCommodityExt.setParam(":VCOMMODITY_TYPE", paramCommodityDAO.getCommodity_type());
    localCommodityExt.setParam(":VCOMMODITY_NAME", paramCommodityDAO.getCommodity_name());
    localCommodityExt.setParam(":VCONTENT", paramCommodityDAO.getContent());
    localCommodityExt.setParam(":VCOMMODITY_CLASS", "0");
    localCommodityExt.setParam(":VCOMMODITY_BRAND", paramCommodityDAO.getCommodity_brand());
    localCommodityExt.setParam(":VCOMMODITY_PRICE", paramCommodityDAO.getCommodity_price());
    localCommodityExt.setParam(":VPRICE_TYPE", paramCommodityDAO.getPrice_type());
    localCommodityExt.setParam(":VSALE_PRICE", paramCommodityDAO.getSale_price());
    localCommodityExt.setParam(":VCOMMODITY_UNIT", paramCommodityDAO.getCommodity_unit());
    localCommodityExt.setParam(":VSALE_MARKET", paramCommodityDAO.getSale_market());
    localCommodityExt.setParam(":VATTACH_TAG", "0");
    localCommodityExt.setParam(":VPUBLISH_USER_ID", paramCommodityDAO.getPublish_user_id());
    localCommodityExt.setParam(":VVALIDITY", "0");
    localCommodityExt.setParam(":VAUDIT_USER_ID", paramCommodityDAO.getAudit_user_id());
    localCommodityExt.setParam(":VREMARK", "");
    localCommodityExt.setParam(":VPRODUCT_ID", paramString);
    this.log.LOG_INFO("数据初始化赋值完成...................");
    this.tradeQuery.executeBy(localCommodityExt.insBy("INS_BY_ALL"));
    ArrayList localArrayList = genRootId(paramString);
    this.outBuffer.setString("SPEC_ROOT_ID", paramCommodityDAO.getCommodity_id());
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("web_id") != null)
        this.outBuffer.setString("WEB_ID", localHashMap.get("web_id").toString());
      if (localHashMap.get("class_id") != null)
        this.outBuffer.setString("SPEC_CLASS_ID", localHashMap.get("class_id").toString());
      if (localHashMap.get("class_name") != null)
        this.outBuffer.setString("SPEC_CLASS_NAME", localHashMap.get("class_name").toString());
      if (localHashMap.get("class_id_grp") != null)
        this.outBuffer.setString("SPEC_CLASS_ID_GRP", localHashMap.get("class_id_grp").toString());
      if (localHashMap.get("class_name_grp") != null)
        this.outBuffer.setString("SPEC_CLASS_NAME_GRP", localHashMap.get("class_name_grp").toString());
    }
    else
    {
      this.outBuffer.setString("WEB_ID", "");
      this.outBuffer.setString("SPEC_CLASS_ID", "");
      this.outBuffer.setString("SPEC_CLASS_NAME", paramCommodityDAO.getCommodity_name());
      this.outBuffer.setString("SPEC_CLASS_ID_GRP", "");
      this.outBuffer.setString("SPEC_CLASS_NAME_GRP", "");
    }
    return 0;
  }

  public ArrayList genRootId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VROOT_ID", paramString);
    try
    {
      localArrayList = localInfoClassExt.selByList("SEL_BY_ID");
    }
    catch (Exception localException)
    {
      return null;
    }
    return localArrayList;
  }

  public void invalidCommodityInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入invalidCommodityInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("COMMODITY_ID");
    try
    {
      i = invalidCommodityInfo(str);
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
    this.log.LOG_INFO("进入invalidCommodityInfo方法...");
  }

  public int invalidCommodityInfo(String paramString)
    throws SaasApplicationException
  {
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCOMMODITY_ID", paramString);
    localCommodityExt.setParam(":VVALIDITY", "1");
    this.tradeQuery.executeBy(localCommodityExt.insBy("INVALID_BY_COMMODITY"));
    return 0;
  }

  public void commendCommodityInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入commendCommodityInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("COMMODITY_ID");
    try
    {
      i = commendCommodityInfo(str);
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
    this.log.LOG_INFO("进入commendCommodityInfo方法...");
  }

  public int commendCommodityInfo(String paramString)
    throws SaasApplicationException
  {
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCOMMODITY_ID", paramString);
    localCommodityExt.setParam(":VCOMMODITY_CLASS", "1");
    this.tradeQuery.executeBy(localCommodityExt.insBy("COMMEND_BY_ONE"));
    return 0;
  }

  public void upCommodityInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入upCommodityInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    CommodityDAO localCommodityDAO = new CommodityDAO();
    localCommodityDAO.setCommodity_id(paramBuffers.getString("COMMODITY_ID"));
    localCommodityDAO.setCommodity_type(paramBuffers.getString("COMMODITY_TYPE"));
    localCommodityDAO.setCommodity_name(paramBuffers.getString("COMMODITY_NAME"));
    localCommodityDAO.setContent(paramBuffers.getString("CONTENT"));
    localCommodityDAO.setCommodity_brand(paramBuffers.getString("COMMODITY_BRAND"));
    localCommodityDAO.setCommodity_price(paramBuffers.getString("COMMODITY_PRICE"));
    localCommodityDAO.setPrice_type(paramBuffers.getString("PRICE_TYPE"));
    localCommodityDAO.setSale_price(paramBuffers.getString("SALE_PRICE"));
    localCommodityDAO.setCommodity_unit(paramBuffers.getString("COMMODITY_UNIT"));
    localCommodityDAO.setSale_market(paramBuffers.getString("SALE_MARKET"));
    localCommodityDAO.setPublish_user_id(paramBuffers.getString("SESSION_USER_ID"));
    localCommodityDAO.setAudit_user_id(paramBuffers.getString("SESSION_USER_ID"));
    if (paramBuffers.getString("REATTACH_TAG") != "")
      localCommodityDAO.setAttach_tag("1");
    else
      localCommodityDAO.setAttach_tag("0");
    try
    {
      i = upCommodityInfo(localCommodityDAO);
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
    this.log.LOG_INFO("退出upCommodityInfo方法...");
  }

  public int upCommodityInfo(CommodityDAO paramCommodityDAO)
    throws SaasApplicationException
  {
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCOMMODITY_ID", paramCommodityDAO.getCommodity_id());
    localCommodityExt.setParam(":VCOMMODITY_TYPE", paramCommodityDAO.getCommodity_type());
    localCommodityExt.setParam(":VCOMMODITY_NAME", paramCommodityDAO.getCommodity_name());
    localCommodityExt.setParam(":VCONTENT", paramCommodityDAO.getContent());
    localCommodityExt.setParam(":VCOMMODITY_CLASS", "0");
    localCommodityExt.setParam(":VCOMMODITY_BRAND", paramCommodityDAO.getCommodity_brand());
    localCommodityExt.setParam(":VCOMMODITY_PRICE", paramCommodityDAO.getCommodity_price());
    localCommodityExt.setParam(":VPRICE_TYPE", paramCommodityDAO.getPrice_type());
    localCommodityExt.setParam(":VSALE_PRICE", paramCommodityDAO.getSale_price());
    localCommodityExt.setParam(":VCOMMODITY_UNIT", paramCommodityDAO.getCommodity_unit());
    localCommodityExt.setParam(":VSALE_MARKET", paramCommodityDAO.getSale_market());
    localCommodityExt.setParam(":VATTACH_TAG", paramCommodityDAO.getAttach_tag());
    localCommodityExt.setParam(":VPUBLISH_USER_ID", paramCommodityDAO.getPublish_user_id());
    localCommodityExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localCommodityExt.insBy("UPDATE_BY_ONE"));
    return 0;
  }

  public ArrayList searchCommodity(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCOMMODITY_NAME", "%" + paramString1 + "%");
    localCommodityExt.setParam(":VCUST_ID", paramString2);
    localCommodityExt.setParam(":VVALIDITY", "0");
    localArrayList = localCommodityExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public ArrayList genCustgoodsList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCUST_ID", paramString);
    localCommodityExt.setParam(":VVALIDITY", "0");
    localArrayList = localCommodityExt.selByList("SEL_BY_CUSTID", paramInt, 30);
    return localArrayList;
  }

  public int getCommodityNumer(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCUST_ID", paramString);
    localCommodityExt.setParam(":VVALIDITY", "0");
    localArrayList = localCommodityExt.selByList("SEL_BY_CUSTID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList genSpecComList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCUST_ID", paramString);
    localCommodityExt.setParam(":VVALIDITY", "0");
    localArrayList = localCommodityExt.selByList("SEL_BY_SPECIAL", paramInt, 30);
    return localArrayList;
  }

  public int getSpecCommodityNumer(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommodityExt localCommodityExt = new CommodityExt();
    localCommodityExt.setParam(":VCUST_ID", paramString);
    localCommodityExt.setParam(":VVALIDITY", "0");
    localArrayList = localCommodityExt.selByList("SEL_BY_SPECIAL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commodityMgr.CommodityInfo
 * JD-Core Version:    0.6.0
 */