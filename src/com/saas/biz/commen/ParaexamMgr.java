package com.saas.biz.commen;

import com.saas.biz.dao.JobDAO.JobExt;
import com.saas.biz.dao.examDAO.ParaexamExt;
import com.saas.biz.dao.parallDAO.EnterPriseExt;
import com.saas.biz.dao.parallDAO.ProduceExt;
import com.saas.biz.dao.parallDAO.StockOrderExt;
import com.saas.biz.dao.parallDAO.StoreExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ParaexamMgr
{
  Logger log = new Logger(this);
  ArrayList queryResult = new ArrayList();

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void paraexamList(Buffers paramBuffers)
  {
    String str = "";
    str = paramBuffers.getString("TABLE_FLAG");
    this.log.LOG_INFO("@@@@@@@@@@@@@@@@@@@@@@@" + str);
    this.log.LOG_INFO("进入paraexamList方法...");
    try
    {
      this.queryResult = paraexamList(str);
      this.log.LOG_INFO("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出paraexamList方法...");
  }

  public ArrayList paraexamList(String paramString)
    throws SaasApplicationException
  {
    if ((paramString == "") || (paramString == null))
      return null;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ParaexamExt localParaexamExt = new ParaexamExt();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    String str1;
    String str2;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (paramString.equals("1"))
    {
      localArrayList2 = localParaexamExt.selByList("SEL_BY_USER_ID");
      localObject1 = localArrayList2.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HashMap)((Iterator)localObject1).next();
        localObject3 = null;
        str1 = null;
        str2 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = new HashMap();
        if (((HashMap)localObject2).get("user_id") != null)
          localObject3 = ((HashMap)localObject2).get("user_id").toString();
        if (((HashMap)localObject2).get("cust_id") != null)
          str2 = ((HashMap)localObject2).get("cust_id").toString();
        if (((HashMap)localObject2).get("user_name") != null)
          str1 = ((HashMap)localObject2).get("user_name").toString();
        if (((HashMap)localObject2).get("user_state") != null)
          localObject4 = ((HashMap)localObject2).get("user_state").toString();
        if (((HashMap)localObject2).get("passwd") != null)
          localObject5 = ((HashMap)localObject2).get("passwd").toString();
        ((HashMap)localObject6).put("user_id", localObject3);
        ((HashMap)localObject6).put("user_name", str1);
        ((HashMap)localObject6).put("cust_id", str2);
        ((HashMap)localObject6).put("user_state", localObject4);
        ((HashMap)localObject6).put("passwd", localObject5);
        localArrayList1.add(localObject6);
      }
    }
    if (paramString.equals("2"))
    {
      localObject1 = new EnterPriseExt();
      localArrayList2 = ((EnterPriseExt)localObject1).selByList("SEL_BY_ENTERPRISE");
      if (localArrayList2 == null)
        return null;
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HashMap)((Iterator)localObject2).next();
        str1 = null;
        str2 = null;
        localObject4 = null;
        localObject5 = new HashMap();
        if (((HashMap)localObject3).get("cust_name") != null)
          str1 = ((HashMap)localObject3).get("cust_name").toString();
        if (((HashMap)localObject3).get("cust_type") != null)
          str2 = ((HashMap)localObject3).get("cust_type").toString();
        if (((HashMap)localObject3).get("cust_state") != null)
          localObject4 = ((HashMap)localObject3).get("cust_state").toString();
        ((HashMap)localObject5).put("cust_name", str1);
        ((HashMap)localObject5).put("cust_type", str2);
        ((HashMap)localObject5).put("cust_state", localObject4);
        localArrayList1.add(localObject5);
        this.log.LOG_INFO("cust_name<<<<<<<<<<<<<<" + str1);
        this.log.LOG_INFO("cust_type>>>>>>>>>" + str2);
      }
    }
    Object localObject7;
    String str4;
    String str5;
    HashMap localHashMap;
    if (paramString.equals("3"))
    {
      localObject1 = new StockOrderExt();
      localArrayList2 = ((StockOrderExt)localObject1).selByList("SEL_BY_STOCKORDERLIST");
      if (localArrayList2 == null)
        return null;
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HashMap)((Iterator)localObject2).next();
        str1 = null;
        str2 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
        localObject7 = null;
        str4 = null;
        str5 = null;
        localHashMap = new HashMap();
        if (((HashMap)localObject3).get("stock_id") != null)
          str1 = ((HashMap)localObject3).get("stock_id").toString();
        if (((HashMap)localObject3).get("cust_id") != null)
          localObject5 = ((HashMap)localObject3).get("cust_id").toString();
        if (((HashMap)localObject3).get("stock_type") != null)
          localObject4 = ((HashMap)localObject3).get("stock_type").toString();
        if (((HashMap)localObject3).get("title") != null)
          str2 = ((HashMap)localObject3).get("title").toString();
        if (((HashMap)localObject3).get("content") != null)
          localObject6 = ((HashMap)localObject3).get("content").toString();
        if (((HashMap)localObject3).get("stock_class") != null)
          localObject7 = ((HashMap)localObject3).get("stock_class").toString();
        if (((HashMap)localObject3).get("start_date") != null)
          str4 = ((HashMap)localObject3).get("start_date").toString();
        if (((HashMap)localObject3).get("end_date") != null)
          str5 = ((HashMap)localObject3).get("end_date").toString();
        localHashMap.put("stock_id", str1);
        localHashMap.put("cust_id", localObject5);
        localHashMap.put("stock_type", localObject4);
        localHashMap.put("title", str2);
        localHashMap.put("content", localObject6);
        localHashMap.put("stock_class", localObject7);
        localHashMap.put("start_date", str4);
        localHashMap.put("end_date", str5);
        localArrayList1.add(localHashMap);
      }
    }
    if (paramString.equals("4"))
    {
      localObject1 = new ProduceExt();
      localArrayList2 = ((ProduceExt)localObject1).selByList("SEL_BY_PRODUCT");
      this.log.LOG_INFO("hohooho...................");
      if (localArrayList2 == null)
        return null;
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        this.log.LOG_INFO("ooooooooooooooooooooooo...................");
        localObject3 = (HashMap)((Iterator)localObject2).next();
        str1 = null;
        str2 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
        localObject7 = null;
        str4 = null;
        str5 = null;
        localHashMap = new HashMap();
        if (((HashMap)localObject3).get("cust_id") != null)
          str1 = ((HashMap)localObject3).get("cust_id").toString();
        this.log.LOG_INFO("还有这里...................");
        if (((HashMap)localObject3).get("product_id") != null)
          str2 = ((HashMap)localObject3).get("product_id").toString();
        if (((HashMap)localObject3).get("product_type") != null)
          localObject4 = ((HashMap)localObject3).get("product_type").toString();
        if (((HashMap)localObject3).get("product_name") != null)
          localObject5 = ((HashMap)localObject3).get("product_name").toString();
        if (((HashMap)localObject3).get("product_class") != null)
          localObject6 = ((HashMap)localObject3).get("product_class").toString();
        if (((HashMap)localObject3).get("product_site") != null)
          localObject7 = ((HashMap)localObject3).get("product_site").toString();
        if (((HashMap)localObject3).get("product_abstract") != null)
          str4 = ((HashMap)localObject3).get("product_abstract").toString();
        if (((HashMap)localObject3).get("product_desc") != null)
          str5 = ((HashMap)localObject3).get("product_desc").toString();
        this.log.LOG_INFO("我来调试!...................");
        localHashMap.put("cust_id", str1);
        localHashMap.put("product_id", str2);
        localHashMap.put("product_type", localObject4);
        localHashMap.put("product_name", localObject5);
        localHashMap.put("product_class", localObject6);
        localHashMap.put("product_site", localObject7);
        localHashMap.put("product_abstract", str4);
        localHashMap.put("product_desc", str5);
        localArrayList1.add(localHashMap);
        this.log.LOG_INFO("11111111111111111111");
      }
    }
    if (paramString.equals("5"))
    {
      localObject1 = new JobExt();
      localArrayList2 = ((JobExt)localObject1).selByList("SEL_SPEC_JOBLIST");
      if (localArrayList2 == null)
        return null;
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HashMap)((Iterator)localObject2).next();
        str1 = "";
        str2 = "";
        localObject4 = new HashMap();
        if (((HashMap)localObject3).get("job_id") != null)
          str2 = ((HashMap)localObject3).get("job_id").toString();
        if (((HashMap)localObject3).get("title") != null)
          str1 = ((HashMap)localObject3).get("title").toString();
        try
        {
          str1 = new String(str1.getBytes("ISO8859_1"), "GB2312");
        }
        catch (Exception localException)
        {
          throw new RuntimeException(localException);
        }
        ((HashMap)localObject4).put("title", str1);
        ((HashMap)localObject4).put("jobId", str2);
        localArrayList1.add(localObject4);
      }
    }
    if (paramString.equals("6"))
    {
      localObject1 = new StoreExt();
      localArrayList2 = ((StoreExt)localObject1).selByList("SEL_BY_STORE");
      if (localArrayList2 == null)
        return null;
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HashMap)((Iterator)localObject2).next();
        str1 = null;
        str2 = null;
        localObject4 = null;
        String str3 = null;
        localObject6 = null;
        localObject7 = new HashMap();
        if (((HashMap)localObject3).get("cust_id") != null)
          str1 = ((HashMap)localObject3).get("cust_id").toString();
        if (((HashMap)localObject3).get("commodity_id") != null)
          str2 = ((HashMap)localObject3).get("commodity_id").toString();
        if (((HashMap)localObject3).get("commodity_type") != null)
          localObject4 = ((HashMap)localObject3).get("commodity_type").toString();
        if (((HashMap)localObject3).get("commodity_name") != null)
          str3 = ((HashMap)localObject3).get("commodity_name").toString();
        if (((HashMap)localObject3).get("commodity_price") != null)
          localObject6 = ((HashMap)localObject3).get("commodity_price").toString();
        ((HashMap)localObject7).put("cust_id", str1);
        ((HashMap)localObject7).put("commodity_id", str2);
        ((HashMap)localObject7).put("cust_id", localObject4);
        ((HashMap)localObject7).put("user_state", str3);
        ((HashMap)localObject7).put("passwd", localObject6);
        localArrayList1.add(localObject7);
      }
    }
    return (ArrayList)(ArrayList)(ArrayList)(ArrayList)(ArrayList)(ArrayList)(ArrayList)localArrayList1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.ParaexamMgr
 * JD-Core Version:    0.6.0
 */