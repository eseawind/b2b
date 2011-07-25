package com.saas.biz.pricerankMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.priceRankDAO.PriceRankDAO;
import com.saas.biz.dao.priceRankDAO.PriceRankExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import tools.util.StringUtil;

public class PriceRankInfo
{
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr comm = new commMethodMgr();
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

  public ArrayList getRankByChId(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VCH_ID", paramString);
    localArrayList = localPriceRankExt.selByList("SELECT_RANK_BY_CHID");
    return localArrayList;
  }

  public void addpriceRankInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addpriceRankInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("RANKPRICE_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    String str4 = paramBuffers.getString("KEYWORD");
    String str5 = paramBuffers.getString("CH_ID");
    String str6 = paramBuffers.getString("START_DATE");
    String str7 = paramBuffers.getString("END_DATE");
    String str8 = paramBuffers.getString("PRICE");
    String str9 = paramBuffers.getString("TITLE");
    String str10 = paramBuffers.getString("LINK");
    String str11 = paramBuffers.getString("CONTENT");
    String str12 = paramBuffers.getString("RSRV_STR6");
    String str13 = paramBuffers.getString("RSRV_STR7");
    String str14 = paramBuffers.getString("IFCHECKED");
    String str15 = paramBuffers.getString("PUBLISH_DATE");
    String str16 = paramBuffers.getString("REMARK");
    try
    {
      PriceRankDAO localPriceRankDAO = new PriceRankDAO();
      localPriceRankDAO.setRankprice_id(str1);
      localPriceRankDAO.setCust_id(str2);
      localPriceRankDAO.setUser_id(str3);
      localPriceRankDAO.setKeywork(str4);
      localPriceRankDAO.setCh_id(str5);
      localPriceRankDAO.setStart_date(str6);
      localPriceRankDAO.setEnd_date(str7);
      localPriceRankDAO.setPrice(str8);
      localPriceRankDAO.setTitle(str9);
      localPriceRankDAO.setLink(str10);
      localPriceRankDAO.setContent(str11);
      localPriceRankDAO.setRsrv_str6(str12);
      localPriceRankDAO.setRsrv_str7(str13);
      localPriceRankDAO.setIfchecked(str14);
      localPriceRankDAO.setPublish_date(str15);
      localPriceRankDAO.setRemark(str16);
      i = addpriceRankInfo(localPriceRankDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
    this.log.LOG_INFO("退出addpriceRankInfo方法...");
  }

  public int addpriceRankInfo(PriceRankDAO paramPriceRankDAO)
    throws SaasApplicationException
  {
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VRANKPRICE_ID", paramPriceRankDAO.getRankprice_id());
    localPriceRankExt.setParam(":VCUST_ID", paramPriceRankDAO.getCust_id());
    localPriceRankExt.setParam(":VUSER_ID", paramPriceRankDAO.getUser_id());
    localPriceRankExt.setParam(":VKEYWORD", paramPriceRankDAO.getKeyword());
    localPriceRankExt.setParam(":VCH_ID", paramPriceRankDAO.getCh_id());
    localPriceRankExt.setParam(":VSTART_DATE", paramPriceRankDAO.getStart_date());
    localPriceRankExt.setParam(":VEND_DATE", paramPriceRankDAO.getEnd_date());
    localPriceRankExt.setParam(":VPRICE", paramPriceRankDAO.getPrice());
    localPriceRankExt.setParam(":VTITLE", paramPriceRankDAO.getTitle());
    localPriceRankExt.setParam(":VLINK", paramPriceRankDAO.getLink());
    localPriceRankExt.setParam(":VCONTENT", paramPriceRankDAO.getContent());
    localPriceRankExt.setParam(":VRSRV_STR6", paramPriceRankDAO.getRsrv_str6());
    localPriceRankExt.setParam(":VRSRV_STR7", paramPriceRankDAO.getRsrv_str7());
    localPriceRankExt.setParam(":VIFCHECKED", paramPriceRankDAO.getIfchecked());
    localPriceRankExt.setParam(":VPUBLISH_DATE", paramPriceRankDAO.getPublish_date());
    localPriceRankExt.setParam(":VREMARK", paramPriceRankDAO.getRemark());
    this.tradeQuery.executeBy(localPriceRankExt.insBy("ADD_RANK_PRICE"));
    return 0;
  }

  public boolean checkInfo(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VCUST_ID", paramString1);
    localPriceRankExt.setParam(":VCH_ID", paramString2);
    localPriceRankExt.setParam(":VKEYWORD", paramString3);
    localArrayList = localPriceRankExt.selByList("CHECK_RANK_KEYWORD");
    return (null == localArrayList) || (localArrayList.size() <= 0);
  }

  public ArrayList getApplication(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localArrayList = localPriceRankExt.selByList("SEL_APPLICATION_KEYWORD", paramInt1, paramInt2);
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public void updateIfchecked(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateIfchecked方法...");
    int i = -1;
    String str1 = paramBuffers.getString("RANKPRICE_ID");
    String str2 = paramBuffers.getString("REMARK");
    String str3 = paramBuffers.getString("IFCHECKED");
    try
    {
      i = updateIfchecked(str1, str3, str2);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
    this.log.LOG_INFO("退出updateIfchecked方法...");
  }

  public int updateIfchecked(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VRANKPRICE_ID", paramString1);
    localPriceRankExt.setParam(":VIFCHECKED", paramString2);
    localPriceRankExt.setParam(":VREMARK", paramString3);
    this.tradeQuery.executeBy(localPriceRankExt.insBy("UPDATE_RANK_PRICE"));
    return 0;
  }

  public ArrayList getRankByRankId(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VRANKPRICE_ID", paramString);
    localArrayList = localPriceRankExt.selByList("VIEW_RANK_INFO_BYID");
    return localArrayList;
  }

  public int getApplication()
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localArrayList = localPriceRankExt.selByList("SEL_APPLICATION_KEYWORD");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getSearchRank(String paramString1, String paramString2)
  {
    paramString1 = StringUtil.trim(paramString1);
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VKEYWORD", "%" + paramString1 + "%");
    localPriceRankExt.setParam(":VKEYWD", paramString1);
    localPriceRankExt.setParam(":VCH_ID", paramString2);
    localArrayList = localPriceRankExt.selByList("SELECT_ORDER_BY_PRICE");
    return localArrayList;
  }

  public int getSearchRankn(String paramString1, String paramString2)
  {
    paramString1 = StringUtil.trim(paramString1);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VKEYWORD", "%" + paramString1 + "%");
    localPriceRankExt.setParam(":VKEYWD", paramString1);
    localPriceRankExt.setParam(":VCH_ID", paramString2);
    localArrayList = localPriceRankExt.selByList("SELECT_ORDER_BY_PRICE");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return (int)Math.ceil(localArrayList.size() / 3.0D);
    return 0;
  }

  public ArrayList getPriceRankByChId(String paramString1, String paramString2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VCH_ID", paramString1);
    localPriceRankExt.setParam(":VCHECKED", paramString2);
    localArrayList = localPriceRankExt.selByList("SEL_PRICERANK_BY_CHID", 0, paramInt);
    if (paramString1.equals("all"))
      localArrayList = localPriceRankExt.selByList("SEL_ALL_PRICERANK", 0, paramInt);
    return localArrayList;
  }

  public ArrayList getPriceRankByCust(String paramString, int paramInt)
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VCUST_ID", paramString);
    localArrayList = localPriceRankExt.selByList("SEL_PRICERANK_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getPriceRankByCust(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VCUST_ID", paramString);
    localArrayList = localPriceRankExt.selByList("SEL_PRICERANK_BY_CUST");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void deletepriceRankInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("rankprice_id");
    try
    {
      PriceRankDAO localPriceRankDAO = new PriceRankDAO();
      localPriceRankDAO.setRankprice_id(str);
      i = deletepriceRankInfo(localPriceRankDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
  }

  public int deletepriceRankInfo(PriceRankDAO paramPriceRankDAO)
  {
    PriceRankExt localPriceRankExt = new PriceRankExt();
    this.log.LOG_INFO(paramPriceRankDAO.getRsrv_str6() + "9999999999999999994949");
    localPriceRankExt.setParam(":VRANKPRICE_ID", paramPriceRankDAO.getRankprice_id());
    this.tradeQuery.executeBy(localPriceRankExt.insBy("DEL_PRICERANK_BY_CUST"));
    return 0;
  }

  public ArrayList getPriceRankBy6(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VRANKPRICE_ID", paramString);
    localArrayList = localPriceRankExt.selByList("SEL_PRICERANK_BY_R6");
    return localArrayList;
  }

  public void updatepriceRankInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updatepriceRankInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("RANKPRICE_ID");
    String str2 = paramBuffers.getString("KEYWORD");
    String str3 = paramBuffers.getString("CH_ID");
    String str4 = paramBuffers.getString("START_DATE");
    String str5 = paramBuffers.getString("END_DATE");
    String str6 = paramBuffers.getString("PRICE");
    this.log.LOG_INFO("555555" + paramBuffers.getString("PRICE") + "*898989898989898989898");
    String str7 = paramBuffers.getString("TITLE");
    String str8 = paramBuffers.getString("LINK");
    String str9 = paramBuffers.getString("CONTENT");
    String str10 = paramBuffers.getString("RSRV_STR6");
    String str11 = paramBuffers.getString("RSRV_STR7");
    String str12 = paramBuffers.getString("IFCHECKED");
    String str13 = paramBuffers.getString("PUBLISH_DATE");
    String str14 = paramBuffers.getString("REMARK");
    try
    {
      PriceRankDAO localPriceRankDAO = new PriceRankDAO();
      localPriceRankDAO.setRankprice_id(str1);
      localPriceRankDAO.setKeywork(str2);
      localPriceRankDAO.setCh_id(str3);
      localPriceRankDAO.setStart_date(str4);
      localPriceRankDAO.setEnd_date(str5);
      localPriceRankDAO.setPrice(str6);
      localPriceRankDAO.setTitle(str7);
      localPriceRankDAO.setLink(str8);
      localPriceRankDAO.setContent(str9);
      localPriceRankDAO.setRsrv_str6(str10);
      localPriceRankDAO.setRsrv_str7(str11);
      localPriceRankDAO.setIfchecked(str12);
      localPriceRankDAO.setPublish_date(str13);
      localPriceRankDAO.setRemark(str14);
      i = updatepriceRankInfo(localPriceRankDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
    this.log.LOG_INFO("退出updatepriceRankInfo方法...");
  }

  public int updatepriceRankInfo(PriceRankDAO paramPriceRankDAO)
    throws SaasApplicationException
  {
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VRANKPRICE_ID", paramPriceRankDAO.getRankprice_id());
    localPriceRankExt.setParam(":VKEYWORD", paramPriceRankDAO.getKeyword());
    localPriceRankExt.setParam(":VCH_ID", paramPriceRankDAO.getCh_id());
    localPriceRankExt.setParam(":VSTART_DATE", paramPriceRankDAO.getStart_date());
    localPriceRankExt.setParam(":VEND_DATE", paramPriceRankDAO.getEnd_date());
    localPriceRankExt.setParam(":VPRICE", paramPriceRankDAO.getPrice());
    this.log.LOG_INFO("9999" + paramPriceRankDAO.getPrice() + "555555");
    localPriceRankExt.setParam(":VTITLE", paramPriceRankDAO.getTitle());
    localPriceRankExt.setParam(":VLINK", paramPriceRankDAO.getLink());
    localPriceRankExt.setParam(":VCONTENT", paramPriceRankDAO.getContent());
    localPriceRankExt.setParam(":VRSRV_STR6", paramPriceRankDAO.getRsrv_str6());
    localPriceRankExt.setParam(":VRSRV_STR7", paramPriceRankDAO.getRsrv_str7());
    localPriceRankExt.setParam(":VIFCHECKED", paramPriceRankDAO.getIfchecked());
    localPriceRankExt.setParam(":VPUBLISH_DATE", paramPriceRankDAO.getPublish_date());
    localPriceRankExt.setParam(":VREMARK", paramPriceRankDAO.getRemark());
    this.tradeQuery.executeBy(localPriceRankExt.insBy("UPDATE_RANK_PRICE_O"));
    return 0;
  }

  public int checkInfo_KEY(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VPRICE", paramString);
    localArrayList = localPriceRankExt.selByList("CHECK_RANK_VPRICE");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public int checkInfo_Key_price(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VPRICE", paramString2);
    localPriceRankExt.setParam(":VKEYWORD", paramString1);
    localArrayList = localPriceRankExt.selByList("SEL_ALL_BY_KEYWORD_PRICE");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public int updatecheckInfo_KEY(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VPRICE", paramString2);
    localArrayList = localPriceRankExt.selByList("CHECK_RANK_VPRICE");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public String getBiaoW(String paramString1, String paramString2)
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    PriceRankExt localPriceRankExt = new PriceRankExt();
    localPriceRankExt.setParam(":VKEYWORD", "%" + paramString1 + "%");
    localPriceRankExt.setParam(":VCH_ID", paramString2);
    localArrayList = localPriceRankExt.selByList("SEL_BW_FOR_CUST_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_id") != null)
        str = localHashMap.get("cust_id").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.pricerankMgr.PriceRankInfo
 * JD-Core Version:    0.6.0
 */