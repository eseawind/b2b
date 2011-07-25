package com.saas.biz.salePriceMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.salePriceDAO.SalePriceDAO;
import com.saas.biz.dao.salePriceDAO.SalePriceExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SalePriceInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();
  commMethodMgr comm = new commMethodMgr();

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

  public void addSalePrice(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addSalePrice方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("PRODUCT_ID");
    String str4 = paramBuffers.getString("SALE_OBJ_ID");
    String str5 = paramBuffers.getString("PRICE_TYPE");
    String str6 = paramBuffers.getString("FIX_TYPE");
    String str7 = paramBuffers.getString("PRICE");
    String str8 = paramBuffers.getString("PRICE_DESC");
    String str9 = paramBuffers.getString("START_DATE");
    String str10 = paramBuffers.getString("ENT_DATE");
    String str11 = paramBuffers.getString("IN_DATE");
    String str12 = paramBuffers.getString("SESSION_USER_ID");
    String str13 = paramBuffers.getString("REMARK");
    try
    {
      SalePriceDAO localSalePriceDAO = new SalePriceDAO();
      localSalePriceDAO.setCust_id(str1);
      localSalePriceDAO.setTrade_id(str2);
      localSalePriceDAO.setProduct_id(str3);
      localSalePriceDAO.setSale_obj_id(str4);
      localSalePriceDAO.setPrice_type(str5);
      localSalePriceDAO.setFix_type(str6);
      localSalePriceDAO.setPrice(str7);
      localSalePriceDAO.setPrice_desc(str8);
      localSalePriceDAO.setStart_date(str9);
      localSalePriceDAO.setEnt_date(str10);
      localSalePriceDAO.setIn_date(str11);
      localSalePriceDAO.setOper_user_id(str12);
      localSalePriceDAO.setRemark(str13);
      i = addSalePrice(localSalePriceDAO);
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
    this.log.LOG_INFO("退出addSalePrice方法...");
  }

  public int addSalePrice(SalePriceDAO paramSalePriceDAO)
    throws SaasApplicationException
  {
    SalePriceExt localSalePriceExt = new SalePriceExt();
    localSalePriceExt.setParam(":VCUST_ID", paramSalePriceDAO.getCust_id());
    localSalePriceExt.setParam(":VTRADE_ID", paramSalePriceDAO.getTrade_id());
    localSalePriceExt.setParam(":VPRODUCT_ID", paramSalePriceDAO.getProduct_id());
    localSalePriceExt.setParam(":VSALE_OBJ_ID", paramSalePriceDAO.getSale_obj_id());
    localSalePriceExt.setParam(":VPRICE_TYPE", paramSalePriceDAO.getPrice_type());
    localSalePriceExt.setParam(":VFIX_TYPE", paramSalePriceDAO.getFix_type());
    localSalePriceExt.setParam(":VPRICE", paramSalePriceDAO.getPrice());
    localSalePriceExt.setParam(":VPRICE_DESC", paramSalePriceDAO.getPrice_desc());
    localSalePriceExt.setParam(":VSTART_DATE", paramSalePriceDAO.getStart_date());
    localSalePriceExt.setParam(":VENT_DATE", paramSalePriceDAO.getEnt_date());
    localSalePriceExt.setParam(":VIN_DATE", paramSalePriceDAO.getIn_date());
    localSalePriceExt.setParam(":VOPER_USER_ID", paramSalePriceDAO.getOper_user_id());
    localSalePriceExt.setParam(":VREMARK", paramSalePriceDAO.getRemark());
    this.tradeQuery.executeBy(localSalePriceExt.insBy("INS_PRO_PRI_ALL"));
    return 0;
  }

  public void ModiPrice(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入ModiPrice方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PRODUCT_ID");
    String str3 = paramBuffers.getString("SALE_OBJ_ID");
    String str4 = paramBuffers.getString("PRICE_TYPE");
    String str5 = paramBuffers.getString("FIX_TYPE");
    String str6 = paramBuffers.getString("PRICE");
    String str7 = paramBuffers.getString("PRICE_DESC");
    String str8 = paramBuffers.getString("START_DATE");
    String str9 = paramBuffers.getString("ENT_DATE");
    String str10 = paramBuffers.getString("IN_DATE");
    String str11 = paramBuffers.getString("SESSION_USER_ID");
    String str12 = paramBuffers.getString("REMARK");
    try
    {
      SalePriceDAO localSalePriceDAO = new SalePriceDAO();
      localSalePriceDAO.setCust_id(str1);
      localSalePriceDAO.setProduct_id(str2);
      localSalePriceDAO.setSale_obj_id(str3);
      localSalePriceDAO.setPrice_type(str4);
      localSalePriceDAO.setFix_type(str5);
      localSalePriceDAO.setPrice(str6);
      localSalePriceDAO.setPrice_desc(str7);
      localSalePriceDAO.setStart_date(str8);
      localSalePriceDAO.setEnt_date(str9);
      localSalePriceDAO.setIn_date(str10);
      localSalePriceDAO.setOper_user_id(str11);
      localSalePriceDAO.setRemark(str12);
      i = ModiPrice(localSalePriceDAO);
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
    this.log.LOG_INFO("退出ModiPrice方法...");
  }

  public int ModiPrice(SalePriceDAO paramSalePriceDAO)
    throws SaasApplicationException
  {
    SalePriceExt localSalePriceExt = new SalePriceExt();
    localSalePriceExt.setParam(":VCUST_ID", paramSalePriceDAO.getCust_id());
    localSalePriceExt.setParam(":VPRODUCT_ID", paramSalePriceDAO.getProduct_id());
    localSalePriceExt.setParam(":VSALE_OBJ_ID", paramSalePriceDAO.getSale_obj_id());
    localSalePriceExt.setParam(":VPRICE_TYPE", paramSalePriceDAO.getPrice_type());
    localSalePriceExt.setParam(":VFIX_TYPE", paramSalePriceDAO.getFix_type());
    localSalePriceExt.setParam(":VPRICE", paramSalePriceDAO.getPrice());
    localSalePriceExt.setParam(":VPRICE_DESC", paramSalePriceDAO.getPrice_desc());
    localSalePriceExt.setParam(":VSTART_DATE", paramSalePriceDAO.getStart_date());
    localSalePriceExt.setParam(":VENT_DATE", paramSalePriceDAO.getEnt_date());
    localSalePriceExt.setParam(":VIN_DATE", paramSalePriceDAO.getIn_date());
    localSalePriceExt.setParam(":VOPER_USER_ID", paramSalePriceDAO.getOper_user_id());
    localSalePriceExt.setParam(":VREMARK", paramSalePriceDAO.getRemark());
    this.tradeQuery.executeBy(localSalePriceExt.insBy("UP_PRO_PRI_ALL"));
    return 0;
  }

  public void addEntirePrice(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEntirePrice方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("PRICE_CODE");
    String str4 = paramBuffers.getString("PRODUCT_ID");
    String str5 = paramBuffers.getString("SALE_OBJ_ID");
    String str6 = paramBuffers.getString("PRICE_TYPE");
    String str7 = paramBuffers.getString("FIX_TYPE");
    String str8 = paramBuffers.getString("PRICE");
    String str9 = paramBuffers.getString("PRICE_DESC");
    String str10 = paramBuffers.getString("START_DATE");
    String str11 = paramBuffers.getString("ENT_DATE");
    String str12 = paramBuffers.getString("IN_DATE");
    String str13 = paramBuffers.getString("SESSION_USER_ID");
    String str14 = paramBuffers.getString("REMARK");
    try
    {
      SalePriceDAO localSalePriceDAO = new SalePriceDAO();
      localSalePriceDAO.setCust_id(str1);
      localSalePriceDAO.setTrade_id(str2);
      localSalePriceDAO.setPrice_code(str3);
      localSalePriceDAO.setProduct_id(str4);
      localSalePriceDAO.setSale_obj_id(str5);
      localSalePriceDAO.setPrice_type(str6);
      localSalePriceDAO.setFix_type(str7);
      localSalePriceDAO.setPrice(str8);
      localSalePriceDAO.setPrice_desc(str9);
      localSalePriceDAO.setStart_date(str10);
      localSalePriceDAO.setEnt_date(str11);
      localSalePriceDAO.setIn_date(str12);
      localSalePriceDAO.setOper_user_id(str13);
      localSalePriceDAO.setRemark(str14);
      i = addEntirePrice(localSalePriceDAO);
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
    this.log.LOG_INFO("退出addEntirePrice方法...");
  }

  public int addEntirePrice(SalePriceDAO paramSalePriceDAO)
    throws SaasApplicationException
  {
    String str1 = paramSalePriceDAO.getProduct_id();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      SalePriceExt localSalePriceExt = new SalePriceExt();
      localSalePriceExt.setParam(":VCUST_ID", paramSalePriceDAO.getCust_id());
      localSalePriceExt.setParam(":VTRADE_ID", paramSalePriceDAO.getTrade_id());
      localSalePriceExt.setParam(":VPRICE_CODE", paramSalePriceDAO.getPrice_code());
      localSalePriceExt.setParam(":VPRODUCT_ID", str2);
      localSalePriceExt.setParam(":VSALE_OBJ_ID", paramSalePriceDAO.getSale_obj_id());
      localSalePriceExt.setParam(":VPRICE_TYPE", paramSalePriceDAO.getPrice_type());
      localSalePriceExt.setParam(":VFIX_TYPE", paramSalePriceDAO.getFix_type());
      localSalePriceExt.setParam(":VPRICE", paramSalePriceDAO.getPrice());
      localSalePriceExt.setParam(":VPRICE_DESC", paramSalePriceDAO.getPrice_desc());
      localSalePriceExt.setParam(":VSTART_DATE", paramSalePriceDAO.getStart_date());
      localSalePriceExt.setParam(":VENT_DATE", paramSalePriceDAO.getEnt_date());
      localSalePriceExt.setParam(":VIN_DATE", paramSalePriceDAO.getIn_date());
      localSalePriceExt.setParam(":VOPER_USER_ID", paramSalePriceDAO.getOper_user_id());
      localSalePriceExt.setParam(":VREMARK", paramSalePriceDAO.getRemark());
      this.tradeQuery.executeBy(localSalePriceExt.insBy("INS_PRO_PRI_ID"));
    }
    return 0;
  }

  public ArrayList getById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("cust_id=" + paramString1 + "==fix_type" + paramString2);
    ArrayList localArrayList = new ArrayList();
    SalePriceExt localSalePriceExt = new SalePriceExt();
    localSalePriceExt.setParam(":VCUST_ID", paramString1);
    localSalePriceExt.setParam(":VFIX_TYPE", paramString2);
    this.log.LOG_INFO("" + localSalePriceExt.insBy("SEL_BY_FIX_TYPE"));
    localArrayList = localSalePriceExt.selByList("SEL_BY_FIX_TYPE");
    return localArrayList;
  }

  public String getPriceJsonData(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    SalePriceExt localSalePriceExt = new SalePriceExt();
    localSalePriceExt.setParam(":VCUST_ID", paramString1);
    localSalePriceExt.setParam(":VFIX_TYPE", paramString2);
    localArrayList = localSalePriceExt.selByList("SEL_BY_FIX_TYPE", paramInt, 10);
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = localHashMap.get("trade_id").toString();
        if (localHashMap.get("goods_name") != null)
          str2 = localHashMap.get("goods_name").toString();
        if (localHashMap.get("product_id") != null)
          str3 = localHashMap.get("product_id").toString();
        if (localHashMap.get("price") != null)
          str4 = localHashMap.get("price").toString();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("id", str5);
        localJSONObject2.put("goods_name", str2);
        localJSONObject2.put("product_id", str3);
        localJSONObject2.put("price", str4);
        localJSONArray.add(localJSONObject2);
      }
    int i = getPriceNumber(paramString1, "0");
    localJSONObject1.put("root", localJSONArray);
    localJSONObject1.put("totalCount", Integer.valueOf(i));
    str1 = localJSONObject1.toString();
    return str1;
  }

  public int getPriceNumber(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SalePriceExt localSalePriceExt = new SalePriceExt();
    localSalePriceExt.setParam(":VCUST_ID", paramString1);
    localSalePriceExt.setParam(":VFIX_TYPE", paramString2);
    localArrayList = localSalePriceExt.selByList("SEL_BY_FIX_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getCodeBy(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SalePriceExt localSalePriceExt = new SalePriceExt();
    localSalePriceExt.setParam(":VCUST_ID", paramString1);
    localSalePriceExt.setParam(":VFIX_TYPE", paramString2);
    localArrayList = localSalePriceExt.selByList("SEL_BY_CODE");
    return localArrayList;
  }

  public HashMap getOneGoods(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    SalePriceExt localSalePriceExt = new SalePriceExt();
    localSalePriceExt.setParam(":VCUST_ID", paramString1);
    localSalePriceExt.setParam(":VPRODUCT_ID", paramString2);
    localArrayList = localSalePriceExt.selByList("SEL_GOODS_BY_ID");
    HashMap localHashMap = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getMoreGoods(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    SalePriceExt localSalePriceExt = new SalePriceExt();
    localSalePriceExt.setParam(":VCUST_ID", paramString1);
    localSalePriceExt.setParam(":VPRICE_CODE", paramString2);
    localArrayList = localSalePriceExt.selByList("SEL_PRO_BY_CODE");
    return localArrayList;
  }

  public void ModiMorePrice(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入ModiMorePrice方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PRICE_CODE");
    String str3 = paramBuffers.getString("SALE_OBJ_ID");
    String str4 = paramBuffers.getString("PRICE_TYPE");
    String str5 = paramBuffers.getString("PRICE");
    String str6 = paramBuffers.getString("PRICE_DESC");
    String str7 = paramBuffers.getString("START_DATE");
    String str8 = paramBuffers.getString("ENT_DATE");
    String str9 = paramBuffers.getString("IN_DATE");
    String str10 = paramBuffers.getString("REMARK");
    try
    {
      SalePriceDAO localSalePriceDAO = new SalePriceDAO();
      localSalePriceDAO.setCust_id(str1);
      localSalePriceDAO.setPrice_code(str2);
      localSalePriceDAO.setSale_obj_id(str3);
      localSalePriceDAO.setPrice_type(str4);
      localSalePriceDAO.setPrice(str5);
      localSalePriceDAO.setPrice_desc(str6);
      localSalePriceDAO.setStart_date(str7);
      localSalePriceDAO.setEnt_date(str8);
      localSalePriceDAO.setIn_date(str9);
      localSalePriceDAO.setRemark(str10);
      i = ModiMorePrice(localSalePriceDAO);
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
    this.log.LOG_INFO("退出ModiMorePrice方法...");
  }

  public int ModiMorePrice(SalePriceDAO paramSalePriceDAO)
    throws SaasApplicationException
  {
    SalePriceExt localSalePriceExt = new SalePriceExt();
    localSalePriceExt.setParam(":VCUST_ID", paramSalePriceDAO.getCust_id());
    localSalePriceExt.setParam(":VPRICE_CODE", paramSalePriceDAO.getPrice_code());
    localSalePriceExt.setParam(":VSALE_OBJ_ID", paramSalePriceDAO.getSale_obj_id());
    localSalePriceExt.setParam(":VPRICE_TYPE", paramSalePriceDAO.getPrice_type());
    localSalePriceExt.setParam(":VPRICE", paramSalePriceDAO.getPrice());
    localSalePriceExt.setParam(":VPRICE_DESC", paramSalePriceDAO.getPrice_desc());
    localSalePriceExt.setParam(":VSTART_DATE", paramSalePriceDAO.getStart_date());
    localSalePriceExt.setParam(":VENT_DATE", paramSalePriceDAO.getEnt_date());
    localSalePriceExt.setParam(":VIN_DATE", paramSalePriceDAO.getIn_date());
    localSalePriceExt.setParam(":VREMARK", paramSalePriceDAO.getRemark());
    this.tradeQuery.executeBy(localSalePriceExt.insBy("UP_MORE_PRI_ALL"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.salePriceMgr.SalePriceInfo
 * JD-Core Version:    0.6.0
 */