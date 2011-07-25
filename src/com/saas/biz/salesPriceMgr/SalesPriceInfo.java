package com.saas.biz.salesPriceMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.salesPriceDAO.SalesPriceDAO;
import com.saas.biz.dao.salesPriceDAO.SalesPriceExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SalesPriceInfo
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

  public void addSaleOnePrice(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addSaleOnePrice方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PRICE_CODE");
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
      SalesPriceDAO localSalesPriceDAO = new SalesPriceDAO();
      localSalesPriceDAO.setCust_id(str1);
      localSalesPriceDAO.setPrice_code(str2);
      localSalesPriceDAO.setProduct_id(str3);
      localSalesPriceDAO.setSale_obj_id(str4);
      localSalesPriceDAO.setPrice_type(str5);
      localSalesPriceDAO.setFix_type(str6);
      localSalesPriceDAO.setPrice(str7);
      localSalesPriceDAO.setPrice_desc(str8);
      localSalesPriceDAO.setStart_date(str9);
      localSalesPriceDAO.setEnt_date(str10);
      localSalesPriceDAO.setIn_date(str11);
      localSalesPriceDAO.setOper_user_id(str12);
      localSalesPriceDAO.setRemark(str13);
      i = addSaleOnePrice(localSalesPriceDAO);
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
    this.log.LOG_INFO("退出addSaleOnePrice方法...");
  }

  public int addSaleOnePrice(SalesPriceDAO paramSalesPriceDAO)
    throws SaasApplicationException
  {
    String str1 = "";
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str2 = paramSalesPriceDAO.getProduct_id();
    StringTokenizer localStringTokenizer = new StringTokenizer(str2, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      str1 = localcommMethodMgr.GenTradeId();
      String str3 = localStringTokenizer.nextToken();
      SalesPriceExt localSalesPriceExt = new SalesPriceExt();
      localSalesPriceExt.setParam(":VCUST_ID", paramSalesPriceDAO.getCust_id());
      localSalesPriceExt.setParam(":VTRADE_ID", str1);
      localSalesPriceExt.setParam(":VPRICE_CODE", paramSalesPriceDAO.getPrice_code());
      localSalesPriceExt.setParam(":VPRODUCT_ID", str3);
      localSalesPriceExt.setParam(":VSALE_OBJ_ID", paramSalesPriceDAO.getSale_obj_id());
      localSalesPriceExt.setParam(":VPRICE_TYPE", paramSalesPriceDAO.getPrice_type());
      localSalesPriceExt.setParam(":VFIX_TYPE", paramSalesPriceDAO.getFix_type());
      localSalesPriceExt.setParam(":VPRICE", paramSalesPriceDAO.getPrice());
      localSalesPriceExt.setParam(":VPRICE_DESC", paramSalesPriceDAO.getPrice_desc());
      localSalesPriceExt.setParam(":VSTART_DATE", paramSalesPriceDAO.getStart_date());
      localSalesPriceExt.setParam(":VENT_DATE", paramSalesPriceDAO.getEnt_date());
      localSalesPriceExt.setParam(":VIN_DATE", paramSalesPriceDAO.getIn_date());
      localSalesPriceExt.setParam(":VOPER_USER_ID", paramSalesPriceDAO.getOper_user_id());
      localSalesPriceExt.setParam(":VREMARK", paramSalesPriceDAO.getRemark());
      this.tradeQuery.executeBy(localSalesPriceExt.insBy("INS_PRO_PRI_ID"));
    }
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.salesPriceMgr.SalesPriceInfo
 * JD-Core Version:    0.6.0
 */