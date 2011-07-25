package com.saas.biz.commen;

import com.saas.biz.dao.commenDAO.EnttypeExt;
import com.saas.biz.dao.parallDAO.BidExt;
import com.saas.biz.dao.parallDAO.EnterPriseExt;
import com.saas.biz.dao.parallDAO.ProduceExt;
import com.saas.biz.dao.parallDAO.SaleInfoExt;
import com.saas.biz.dao.parallDAO.StockOrderExt;
import com.saas.biz.dao.parallDAO.StoreExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AllMethodMgr
{
  Logger log = new Logger(this);
  commMethodMgr commen = new commMethodMgr();
  ArrayList queryResult = new ArrayList();

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void AllList(Buffers paramBuffers)
  {
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap = new HashMap();
    this.log.LOG_INFO("进入paraexamList方法...");
    try
    {
      ArrayList localArrayList2 = StoreListInfo();
      ArrayList localArrayList3 = EnterpriseList();
      ArrayList localArrayList4 = StockOrderList();
      ArrayList localArrayList5 = ProduceList();
      ArrayList localArrayList6 = BiddingList();
      ArrayList localArrayList7 = SaleList();
      ArrayList localArrayList8 = EntArrayList();
      localArrayList1.add(0, localArrayList2);
      localArrayList1.add(1, localArrayList3);
      localArrayList1.add(2, localArrayList4);
      localArrayList1.add(3, localArrayList5);
      localArrayList1.add(4, localArrayList6);
      localArrayList1.add(5, localArrayList7);
      localArrayList1.add(6, localArrayList8);
      this.queryResult = localArrayList1;
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出paraexamList方法...");
  }

  public ArrayList StoreListInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    StoreExt localStoreExt = new StoreExt();
    localArrayList2 = localStoreExt.selByList("SEL_BY_STORE");
    if (localArrayList2 == null)
      return null;
    Iterator localIterator = localArrayList2.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
      String str5 = null;
      String str6 = null;
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("cust_id") != null)
        str1 = localHashMap1.get("cust_id").toString();
      if (localHashMap1.get("commodity_id") != null)
        str2 = localHashMap1.get("commodity_id").toString();
      if (localHashMap1.get("commodity_type") != null)
        str3 = localHashMap1.get("commodity_type").toString();
      if (localHashMap1.get("commodity_name") != null)
        str4 = localHashMap1.get("commodity_name").toString();
      if (str4.length() >= 24)
        str4 = this.commen.splitStr(str4, 24);
      if (localHashMap1.get("commodity_price") != null)
        str5 = localHashMap1.get("commodity_price").toString();
      if (localHashMap1.get("publish_date") != null)
        str6 = localHashMap1.get("publish_date").toString().substring(0, 10);
      localHashMap2.put("cust_id", str1);
      localHashMap2.put("commodity_id", str2);
      localHashMap2.put("commodity_type", str3);
      localHashMap2.put("commodity_name", str4);
      localHashMap2.put("commodity_price", str5);
      localHashMap2.put("publish_date", str6);
      localArrayList1.add(localHashMap2);
    }
    return localArrayList1;
  }

  public ArrayList EnterpriseList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    EnterPriseExt localEnterPriseExt = new EnterPriseExt();
    localArrayList1 = localEnterPriseExt.selByList("SEL_BY_ENTERPRISE");
    if (localArrayList1 == null)
      return null;
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("cust_id") != null)
        str4 = localHashMap1.get("cust_id").toString();
      if (localHashMap1.get("cust_name") != null)
      {
        str1 = localHashMap1.get("cust_name").toString();
        if (str1.length() >= 22)
          str1 = this.commen.splitStr(str1, 22);
      }
      if (localHashMap1.get("cust_type") != null)
        str2 = localHashMap1.get("cust_type").toString();
      if (localHashMap1.get("cust_state") != null)
        str3 = localHashMap1.get("cust_state").toString();
      localHashMap2.put("cust_id", str4);
      localHashMap2.put("cust_name", str1);
      localHashMap2.put("cust_type", str2);
      localHashMap2.put("cust_state", str3);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public ArrayList StockOrderList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    StockOrderExt localStockOrderExt = new StockOrderExt();
    localArrayList1 = localStockOrderExt.selByList("SEL_BY_STOCKORDERLIST");
    if (localArrayList1 == null)
      return null;
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
      String str5 = null;
      String str6 = null;
      String str7 = null;
      String str8 = null;
      String str9 = null;
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("stock_id") != null)
        str1 = localHashMap1.get("stock_id").toString();
      if (localHashMap1.get("cust_id") != null)
        str4 = localHashMap1.get("cust_id").toString();
      if (localHashMap1.get("stock_type") != null)
        str3 = localHashMap1.get("stock_type").toString();
      if (localHashMap1.get("title") != null)
        str2 = localHashMap1.get("title").toString();
      if (localHashMap1.get("content") != null)
        str5 = localHashMap1.get("content").toString();
      if (localHashMap1.get("stock_class") != null)
        str6 = localHashMap1.get("stock_class").toString();
      if (localHashMap1.get("start_date") != null)
        str7 = localHashMap1.get("start_date").toString();
      if (localHashMap1.get("end_date") != null)
        str8 = localHashMap1.get("end_date").toString();
      if (localHashMap1.get("publish_date") != null)
        str9 = localHashMap1.get("publish_date").toString().substring(0, 10);
      localHashMap2.put("stock_id", str1);
      localHashMap2.put("cust_id", str4);
      localHashMap2.put("stock_type", str3);
      localHashMap2.put("title", str2);
      localHashMap2.put("content", str5);
      localHashMap2.put("stock_class", str6);
      localHashMap2.put("start_date", str7);
      localHashMap2.put("end_date", str8);
      localHashMap2.put("publish_date", str9);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public ArrayList ProduceList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ProduceExt localProduceExt = new ProduceExt();
    localArrayList1 = localProduceExt.selByList("SEL_BY_PRODUCT");
    if (localArrayList1 == null)
      return null;
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
      String str5 = null;
      String str6 = null;
      String str7 = null;
      String str8 = null;
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("cust_id") != null)
        str1 = localHashMap1.get("cust_id").toString();
      if (localHashMap1.get("product_id") != null)
        str2 = localHashMap1.get("product_id").toString();
      if (localHashMap1.get("product_type") != null)
        str3 = localHashMap1.get("product_type").toString();
      if (localHashMap1.get("product_name") != null)
        str4 = localHashMap1.get("product_name").toString();
      if (localHashMap1.get("product_class") != null)
        str5 = localHashMap1.get("product_class").toString();
      if (localHashMap1.get("product_site") != null)
        str6 = localHashMap1.get("product_site").toString();
      if (localHashMap1.get("product_abstract") != null)
        str7 = localHashMap1.get("product_abstract").toString();
      if (localHashMap1.get("product_desc") != null)
        str8 = localHashMap1.get("product_desc").toString();
      localHashMap2.put("cust_id", str1);
      localHashMap2.put("product_id", str2);
      localHashMap2.put("product_type", str3);
      localHashMap2.put("product_name", str4);
      localHashMap2.put("product_class", str5);
      localHashMap2.put("product_site", str6);
      localHashMap2.put("product_abstract", str7);
      localHashMap2.put("product_desc", str8);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public ArrayList BiddingList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    BidExt localBidExt = new BidExt();
    localArrayList1 = localBidExt.selByList("SEL_BY_BIDDING");
    if (localArrayList1 == null)
      return null;
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
      String str5 = null;
      String str6 = null;
      String str7 = null;
      String str8 = null;
      String str9 = null;
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("bidding_id") != null)
        str2 = localHashMap1.get("bidding_id").toString();
      if (localHashMap1.get("cust_id") != null)
        str1 = localHashMap1.get("cust_id").toString();
      if (localHashMap1.get("title") != null)
        str3 = localHashMap1.get("title").toString();
      if (localHashMap1.get("bidding_no") != null)
        str4 = localHashMap1.get("bidding_no").toString();
      if (localHashMap1.get("open_date") != null)
        str5 = localHashMap1.get("open_date").toString();
      if (localHashMap1.get("addr") != null)
        str6 = localHashMap1.get("addr").toString();
      if (localHashMap1.get("content") != null)
        str7 = localHashMap1.get("content").toString();
      if (localHashMap1.get("attach_tag") != null)
        str8 = localHashMap1.get("attach_tag").toString();
      if (localHashMap1.get("publish_date") != null)
        str9 = localHashMap1.get("publish_date").toString().substring(0, 10);
      localHashMap2.put("bidding_id", str2);
      localHashMap2.put("cust_id", str1);
      localHashMap2.put("title", str3);
      localHashMap2.put("bidding_no", str4);
      localHashMap2.put("open_date", str5);
      localHashMap2.put("addr", str6);
      localHashMap2.put("content", str7);
      localHashMap2.put("attach_tag", str8);
      localHashMap2.put("publish_date", str9);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public ArrayList SaleList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    SaleInfoExt localSaleInfoExt = new SaleInfoExt();
    localArrayList2 = localSaleInfoExt.selByList("SEL_BY_SALE");
    if (localArrayList2 == null)
      return null;
    Iterator localIterator = localArrayList2.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
      String str5 = null;
      String str6 = null;
      String str7 = null;
      String str8 = null;
      String str9 = null;
      String str10 = null;
      String str11 = null;
      String str12 = null;
      String str13 = null;
      String str14 = null;
      String str15 = null;
      String str16 = null;
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("sale_id") != null)
        str1 = localHashMap1.get("sale_id").toString();
      if (localHashMap1.get("sale_unit") != null)
        str2 = localHashMap1.get("sale_unit").toString();
      if (localHashMap1.get("sale_type") != null)
        str3 = localHashMap1.get("sale_type").toString();
      if (localHashMap1.get("sale_class") != null)
        str6 = localHashMap1.get("sale_class").toString();
      if (localHashMap1.get("sale_addr") != null)
        str7 = localHashMap1.get("sale_addr").toString();
      if (localHashMap1.get("attach_tag") != null)
        str8 = localHashMap1.get("attach_tag").toString();
      if (localHashMap1.get("start_date") != null)
        str9 = localHashMap1.get("start_date").toString();
      if (localHashMap1.get("end_date") != null)
        str10 = localHashMap1.get("end_date").toString();
      if (localHashMap1.get("publish_date") != null)
        str11 = localHashMap1.get("publish_date").toString().substring(0, 10);
      if (localHashMap1.get("publish_user_id") != null)
        str12 = localHashMap1.get("publish_user_id").toString();
      if (localHashMap1.get("title") != null)
        str4 = localHashMap1.get("title").toString();
      if (localHashMap1.get("audit_date") != null)
        str13 = localHashMap1.get("audit_date").toString();
      if (localHashMap1.get("validity") != null)
        str14 = localHashMap1.get("validity").toString();
      if (localHashMap1.get("audit_user_id") != null)
        str15 = localHashMap1.get("audit_user_id").toString();
      if (localHashMap1.get("content") != null)
        str5 = localHashMap1.get("content").toString();
      if (localHashMap1.get("remark") != null)
        str16 = localHashMap1.get("remark").toString();
      localHashMap2.put("sale_id", str1);
      localHashMap2.put("sale_unit", str2);
      localHashMap2.put("sale_type", str3);
      localHashMap2.put("title", str4);
      localHashMap2.put("content", str5);
      localHashMap2.put("sale_class", str6);
      localHashMap2.put("content", str5);
      localHashMap2.put("sale_addr", str7);
      localHashMap2.put("attach_tag", str8);
      localHashMap2.put("start_date", str9);
      localHashMap2.put("end_date", str10);
      localHashMap2.put("publish_date", str11);
      localHashMap2.put("publish_user_id", str12);
      localHashMap2.put("audit_date", str13);
      localHashMap2.put("validity", str14);
      localHashMap2.put("audit_user_id", str15);
      localHashMap2.put("remark", str16);
      localArrayList1.add(localHashMap2);
    }
    return localArrayList1;
  }

  public ArrayList EntArrayList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    localArrayList1 = GetArrayList("1", "000000000000000");
    if (localArrayList1 == null)
      return null;
    Iterator localIterator1 = localArrayList1.iterator();
    while (localIterator1.hasNext())
    {
      HashMap localHashMap2 = (HashMap)localIterator1.next();
      String str2 = "";
      String str3 = "";
      str2 = localHashMap2.get("ent_id").toString();
      str3 = localHashMap2.get("ent_name").toString();
      str1 = "<div id=leftSortMenu><div class=menuLeft></div><div class=menuMiddle>" + str3;
      str1 = str1 + "</div><div class=menuRight></div></div>";
      localArrayList2 = GetArrayList("2", str2);
      if (localArrayList2 != null)
      {
        Iterator localIterator2 = localArrayList2.iterator();
        while (localIterator2.hasNext())
        {
          HashMap localHashMap3 = (HashMap)localIterator2.next();
          String str4 = "";
          String str5 = "";
          str4 = localHashMap3.get("ent_id").toString();
          str5 = localHashMap3.get("ent_name").toString();
          str1 = str1 + "<div id=leftSortBody><h1><img src=images/chinannn_f.gif>" + str5 + "</h1>";
          localArrayList3 = GetArrayList("3", str4);
          if (localArrayList3 != null)
          {
            Iterator localIterator3 = localArrayList3.iterator();
            while (localIterator3.hasNext())
            {
              HashMap localHashMap4 = (HashMap)localIterator3.next();
              String str6 = "";
              String str7 = "";
              str6 = localHashMap4.get("ent_id").toString();
              str7 = localHashMap4.get("ent_name").toString();
              str1 = str1 + str7 + "|";
            }
          }
          str1 = str1 + "</div>";
        }
      }
      localArrayList4.add(str1);
    }
    return localArrayList4;
  }

  public ArrayList GetArrayList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    EnttypeExt localEnttypeExt = new EnttypeExt();
    ArrayList localArrayList = new ArrayList();
    localEnttypeExt.setParam(":VENT_LEVEL", paramString1);
    localEnttypeExt.setParam(":VUP_ENT_ID", paramString2);
    localEnttypeExt.setParam(":VENT_TYPE", "0");
    localArrayList = localEnttypeExt.selByList("SEL_BY_LEVEL");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.AllMethodMgr
 * JD-Core Version:    0.6.0
 */