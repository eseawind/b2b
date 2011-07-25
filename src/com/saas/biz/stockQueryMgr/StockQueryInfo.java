package com.saas.biz.stockQueryMgr;

import com.saas.biz.dao.stockQueryDAO.StockQueryExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class StockQueryInfo
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

  public void addStockQueryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addStockQueryInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUERY_ID");
    String str4 = paramBuffers.getString("TITLE");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("SALE_USER_ID");
    String str7 = paramBuffers.getString("Q_DATE");
    String str8 = paramBuffers.getString("Q_TYPE");
    String str9 = paramBuffers.getString("OBJ_CUST_ID");
    String str10 = paramBuffers.getString("CONTACT_ID");
    String str11 = paramBuffers.getString("Q_CUST_PHONE");
    String str12 = paramBuffers.getString("PRE_PRICE");
    String str13 = paramBuffers.getString("SESSION_USER_ID");
    String str14 = paramBuffers.getString("IN_DATE");
    String str15 = paramBuffers.getString("REMARK");
    String str16 = paramBuffers.getString("OBJ_CUST_NAME");
    String str17 = paramBuffers.getString("CONTACT_MAN");
    String str18 = paramBuffers.getString("SALE_USER_NAME");
    int i = -1;
    try
    {
      i = addStockQueryInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18);
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
    this.log.LOG_INFO("退出addStockQueryInfo方法...");
  }

  public int addStockQueryInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
    throws SaasApplicationException
  {
    StockQueryExt localStockQueryExt = new StockQueryExt();
    localStockQueryExt.setParam(":VCUST_ID", paramString1);
    localStockQueryExt.setParam(":VFORM_ID", paramString2);
    localStockQueryExt.setParam(":VQUERY_ID", paramString3);
    localStockQueryExt.setParam(":VTITLE", paramString4);
    localStockQueryExt.setParam(":VCONTENT", paramString5);
    localStockQueryExt.setParam(":VQ_USER_ID", paramString6);
    localStockQueryExt.setParam(":VQ_DATE", paramString7);
    localStockQueryExt.setParam(":VQ_TYPE", paramString8);
    localStockQueryExt.setParam(":VQ_CUST_ID", paramString9);
    localStockQueryExt.setParam(":VQ_CUST_CON", paramString10);
    localStockQueryExt.setParam(":VQ_CUST_PHONE", paramString11);
    localStockQueryExt.setParam(":VPRE_PRICE", paramString12);
    localStockQueryExt.setParam(":VOPER_USER_ID", paramString13);
    localStockQueryExt.setParam(":VIN_DATE", paramString14);
    localStockQueryExt.setParam(":VREMARK", paramString15);
    localStockQueryExt.setParam(":VCUST_NAME", paramString16);
    localStockQueryExt.setParam(":VCONTACT_NAME", paramString17);
    localStockQueryExt.setParam(":VUSER_NAME", paramString18);
    this.tradeQuery.executeBy(localStockQueryExt.insBy("INS_STOCK_QUERY_ALL"));
    return 0;
  }

  public void updateStockQueryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateStockQueryInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUERY_ID");
    String str4 = paramBuffers.getString("TITLE");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("SALE_USER_ID");
    String str7 = paramBuffers.getString("Q_DATE");
    String str8 = paramBuffers.getString("Q_TYPE");
    String str9 = paramBuffers.getString("OBJ_CUST_ID");
    String str10 = paramBuffers.getString("CONTACT_ID");
    String str11 = paramBuffers.getString("Q_CUST_PHONE");
    String str12 = paramBuffers.getString("PRE_PRICE");
    String str13 = paramBuffers.getString("SESSION_USER_ID");
    String str14 = paramBuffers.getString("IN_DATE");
    String str15 = paramBuffers.getString("REMARK");
    String str16 = paramBuffers.getString("OBJ_CUST_NAME");
    String str17 = paramBuffers.getString("CONTACT_MAN");
    String str18 = paramBuffers.getString("SALE_USER_NAME");
    int i = -1;
    try
    {
      i = updateStockQueryInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18);
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
    this.log.LOG_INFO("退出updateStockQueryInfo方法...");
  }

  public int updateStockQueryInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
    throws SaasApplicationException
  {
    StockQueryExt localStockQueryExt = new StockQueryExt();
    localStockQueryExt.setParam(":VCUST_ID", paramString1);
    localStockQueryExt.setParam(":VFORM_ID", paramString2);
    localStockQueryExt.setParam(":VQUERY_ID", paramString3);
    localStockQueryExt.setParam(":VTITLE", paramString4);
    localStockQueryExt.setParam(":VCONTENT", paramString5);
    localStockQueryExt.setParam(":VQ_USER_ID", paramString6);
    localStockQueryExt.setParam(":VQ_DATE", paramString7);
    localStockQueryExt.setParam(":VQ_TYPE", paramString8);
    localStockQueryExt.setParam(":VQ_CUST_ID", paramString9);
    localStockQueryExt.setParam(":VQ_CUST_CON", paramString10);
    localStockQueryExt.setParam(":VQ_CUST_PHONE", paramString11);
    localStockQueryExt.setParam(":VPRE_PRICE", paramString12);
    localStockQueryExt.setParam(":VOPER_USER_ID", paramString13);
    localStockQueryExt.setParam(":VIN_DATE", paramString14);
    localStockQueryExt.setParam(":VREMARK", paramString15);
    localStockQueryExt.setParam(":VCUST_NAME", paramString16);
    localStockQueryExt.setParam(":VCONTACT_NAME", paramString17);
    localStockQueryExt.setParam(":VUSER_NAME", paramString18);
    this.tradeQuery.executeBy(localStockQueryExt.insBy("UPDATE_STOCK_QUERY_ALL"));
    return 0;
  }

  public void delStockQuery(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delStockQuery方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_ID");
    String str3 = paramBuffers.getString("FORM_ID");
    int i = -1;
    try
    {
      i = delStockQuery(str1, str2, str3);
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
    this.log.LOG_INFO("退出delStockQuery方法...");
  }

  public int delStockQuery(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    StockQueryExt localStockQueryExt = new StockQueryExt();
    localStockQueryExt.setParam(":VCUST_ID", paramString1);
    localStockQueryExt.setParam(":VQUERY_ID", paramString2);
    localStockQueryExt.setParam(":VFORM_ID", paramString3);
    this.tradeQuery.executeBy(localStockQueryExt.insBy("DEL_ONE_STOCKQUERY"));
    return 0;
  }

  public ArrayList getOneStockQuery(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    StockQueryExt localStockQueryExt = new StockQueryExt();
    localStockQueryExt.setParam(":VCUST_ID", paramString1);
    localStockQueryExt.setParam(":VQUERY_ID", paramString2);
    localArrayList = localStockQueryExt.selByList("SEL_ONE_BY_QUO_ID");
    return localArrayList;
  }

  public ArrayList getStockQueryList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    StockQueryExt localStockQueryExt = new StockQueryExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 20;
      localStockQueryExt.setParam(":VCUST_ID", paramString);
      localArrayList = localStockQueryExt.selByList("SEL_ALL_STOCKQUERY", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getStockQueryList(String paramString)
    throws SaasApplicationException
  {
    StockQueryExt localStockQueryExt = new StockQueryExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localStockQueryExt.setParam(":VCUST_ID", paramString);
      localArrayList = localStockQueryExt.selByList("SEL_ALL_STOCKQUERY");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.stockQueryMgr.StockQueryInfo
 * JD-Core Version:    0.6.0
 */