package com.saas.biz.rightMgr;

import com.saas.biz.commen.ParamethodMgr;
import com.saas.biz.custMgr.CustClass;
import com.saas.biz.custrightsMgr.RightManage;
import com.saas.biz.dao.productDAO.ProductExt;
import com.saas.biz.dao.stockorderDAO.StockorderExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class CheckTrade
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  String checkMsg = "";
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

  public void checkBeforeTrade(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入checkBeforeTrade方法...");
    this.outBuffer = paramBuffers;
    if (paramBuffers.getString("TRADE_TYPE_CODE").equals("0123"))
      return;
    if (paramBuffers.getString("TRADE_TYPE_CODE").equals("0810"))
      return;
    if (paramBuffers.getString("TRADE_TYPE_CODE").equals("1304"))
      return;
    if (paramBuffers.getString("TRADE_TYPE_CODE").equals("1308"))
      return;
    if (paramBuffers.getString("SESSION_CUST_ID") == null)
      return;
    if (paramBuffers.getString("SESSION_CUST_ID").equals(""))
      return;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    ArrayList localArrayList1 = new ArrayList();
    ParamethodMgr localParamethodMgr = new ParamethodMgr();
    ArrayList localArrayList2 = localParamethodMgr.getCompareInfoByAttr("121");
    String str2 = "";
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList2.get(0);
      if (localHashMap.get("para_code1") != null)
        str2 = localHashMap.get("para_code1").toString();
    }
    int i = 100;
    int j = 100;
    String str3 = "";
    String str4 = "";
    Object localObject;
    if (paramBuffers.getString("TRADE_TYPE_CODE").equals("0233"))
    {
      localObject = new StockorderExt();
      ((StockorderExt)localObject).setParam(":VCUST_ID", str1);
      if (str2.equals("0"))
        localArrayList1 = ((StockorderExt)localObject).selByList("SEL_STOCK_ORDER_DAY");
      if (str2.equals("1"))
        localArrayList1 = ((StockorderExt)localObject).selByList("SEL_STOCK_ORDER_MONTH");
      if (str2.equals("2"))
        localArrayList1 = ((StockorderExt)localObject).selByList("SEL_STOCK_ORDER_BY_CUST_ID");
      str3 = new RightManage().getValueByType("6", "4");
      str4 = new RightManage().getValueByType("2", "4");
      if (!str3.equals(""))
        i = Integer.parseInt(str3);
      if (!str4.equals(""))
        j = Integer.parseInt(str4);
      this.checkMsg = "对不起,您发布的采购信息超过了限定条数！";
    }
    if (paramBuffers.getString("TRADE_TYPE_CODE").equals("1226"))
    {
      localObject = new ProductExt();
      ((ProductExt)localObject).setParam(":VCUST_ID", str1);
      if (str2.equals("0"))
        localArrayList1 = ((ProductExt)localObject).selByList("SEL_PRODUCT_BY_DAY");
      if (str2.equals("1"))
        localArrayList1 = ((ProductExt)localObject).selByList("SEL_PRODUCT_BY_MONTH");
      if (str2.equals("2"))
        localArrayList1 = ((ProductExt)localObject).selByList("SEL_PRODUCT_BY_CUST_ID");
      i = 20;
      j = 10;
      this.checkMsg = "对不起,您发布的产品信息超过了限定条数！";
    }
    int k = 0;
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      k = localArrayList1.size();
    CustClass localCustClass = new CustClass();
    String str5 = "";
    try
    {
      str5 = localCustClass.getCustClassById(str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    int m = 0;
    if (str5.equals("6"))
      m = i;
    else if (str5.equals("2"))
      m = j;
    int n = -1;
    if (m > 0)
    {
      if ((k >= 0) && (k < m))
      {
        this.outBuffer.setInt("RESULT_CODE", 0);
        this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
      }
      else if (n != 0)
      {
        this.outBuffer.setInt("RESULT_CODE", -1);
        this.outBuffer.setString("RESULT_INFO", this.checkMsg);
      }
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出checkBeforeTrade方法...");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.rightMgr.CheckTrade
 * JD-Core Version:    0.6.0
 */