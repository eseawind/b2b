package com.saas.biz.shopOrderMgr;

import com.saas.biz.dao.shoporderDAO.ShoporderExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class ShopOrderInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
  ArrayList queryResult = new ArrayList();

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void addShopOrder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addShopOrder方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("SHOPO_ID");
    String str4 = paramBuffers.getString("SHOPO_TITLE");
    String str5 = paramBuffers.getString("NEED_ID");
    String str6 = paramBuffers.getString("SHOPO_NO");
    String str7 = paramBuffers.getString("PRE_DATE");
    String str8 = paramBuffers.getString("ACT_DATE");
    String str9 = paramBuffers.getString("FROM_ADDR");
    String str10 = paramBuffers.getString("TO_ADDR");
    String str11 = paramBuffers.getString("SHIP_TYPE");
    String str12 = paramBuffers.getString("SHOPO_NUM");
    String str13 = paramBuffers.getString("UNIT");
    String str14 = paramBuffers.getString("STATE_CODE");
    String str15 = paramBuffers.getString("STATE_CODE_DATE");
    String str16 = paramBuffers.getString("SESSION_USER_ID");
    String str17 = paramBuffers.getString("PUBLISH_DATE");
    String str18 = paramBuffers.getString("REMARK");
    int i = -1;
    try
    {
      i = addShopOrder(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18);
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
    this.log.LOG_INFO("退出addShopOrder方法...");
  }

  public int addShopOrder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
    throws SaasApplicationException
  {
    ShoporderExt localShoporderExt = new ShoporderExt();
    localShoporderExt.setParam(":VCUST_ID", paramString1);
    localShoporderExt.setParam(":VFORM_ID", paramString2);
    localShoporderExt.setParam(":VSHOPO_ID", paramString3);
    localShoporderExt.setParam(":VSHOPO_TITLE", paramString4);
    localShoporderExt.setParam(":VQUO_ID", paramString5);
    localShoporderExt.setParam(":VSHOPO_NO", paramString6);
    localShoporderExt.setParam(":VPRE_DATE", paramString7);
    localShoporderExt.setParam(":VACT_DATE", paramString8);
    localShoporderExt.setParam(":VFROM_ADDR", paramString9);
    localShoporderExt.setParam(":VTO_ADDR", paramString10);
    localShoporderExt.setParam(":VSHIP_TYPE", paramString11);
    localShoporderExt.setParam(":VSHOPO_NUM", paramString12);
    localShoporderExt.setParam(":VUNIT", paramString13);
    localShoporderExt.setParam(":VSTATE_CODE", paramString14);
    localShoporderExt.setParam(":VSTATE_CODE_DATE", paramString15);
    localShoporderExt.setParam(":VUSER_ID", paramString16);
    localShoporderExt.setParam(":VPUBLISH_DATE", paramString17);
    localShoporderExt.setParam(":VREMARK", paramString18);
    this.tradeQuery.executeBy(localShoporderExt.insBy("INS_SHOPORDER_ALL"));
    return 0;
  }

  public void updateShopOrder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateShopOrder方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SHOPO_ID");
    String str3 = paramBuffers.getString("SHOPO_TITLE");
    String str4 = paramBuffers.getString("SHOPO_NO");
    String str5 = paramBuffers.getString("PRE_DATE");
    String str6 = paramBuffers.getString("FROM_ADDR");
    String str7 = paramBuffers.getString("TO_ADDR");
    String str8 = paramBuffers.getString("SHIP_TYPE");
    String str9 = paramBuffers.getString("SHOPO_NUM");
    String str10 = paramBuffers.getString("UNIT");
    String str11 = paramBuffers.getString("SESSION_USER_ID");
    String str12 = paramBuffers.getString("PUBLISH_DATE");
    String str13 = paramBuffers.getString("REMARK");
    int i = -1;
    try
    {
      i = updateShopOrder(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
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
    this.log.LOG_INFO("退出updateShopOrder方法...");
  }

  public int updateShopOrder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
    throws SaasApplicationException
  {
    ShoporderExt localShoporderExt = new ShoporderExt();
    localShoporderExt.setParam(":VCUST_ID", paramString1);
    localShoporderExt.setParam(":VSHOPO_ID", paramString2);
    localShoporderExt.setParam(":VSHOPO_TITLE", paramString3);
    localShoporderExt.setParam(":VSHOPO_NO", paramString4);
    localShoporderExt.setParam(":VPRE_DATE", paramString5);
    localShoporderExt.setParam(":VFROM_ADDR", paramString6);
    localShoporderExt.setParam(":VTO_ADDR", paramString7);
    localShoporderExt.setParam(":VSHIP_TYPE", paramString8);
    localShoporderExt.setParam(":VSHOPO_NUM", paramString9);
    localShoporderExt.setParam(":VUNIT", paramString10);
    localShoporderExt.setParam(":VUSER_ID", paramString11);
    localShoporderExt.setParam(":VPUBLISH_DATE", paramString12);
    localShoporderExt.setParam(":VREMARK", paramString13);
    this.tradeQuery.executeBy(localShoporderExt.insBy("UPDATE_SHOPORDER"));
    return 0;
  }

  public void delOneShopOrder(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delOneShopOrder方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SHOPO_ID");
    int i = -1;
    try
    {
      i = delOneShopOrder(str1, str2);
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
    this.log.LOG_INFO("退出delOneShopneed方法...");
  }

  public int delOneShopOrder(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ShoporderExt localShoporderExt = new ShoporderExt();
    localShoporderExt.setParam(":VCUST_ID", paramString1);
    localShoporderExt.setParam(":VSHOPO_ID", paramString2);
    this.tradeQuery.executeBy(localShoporderExt.insBy("DEL_ONE_SHOPORDER"));
    return 0;
  }

  public ArrayList getListByTradeId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ShoporderExt localShoporderExt = new ShoporderExt();
    localShoporderExt.setParam(":VCUST_ID", paramString1);
    localShoporderExt.setParam(":VSHOPO_ID", paramString2);
    ArrayList localArrayList = localShoporderExt.selByList("SEL_BY_SHOP_ID");
    return localArrayList;
  }

  public ArrayList getListByIdd(String paramString)
    throws SaasApplicationException
  {
    ShoporderExt localShoporderExt = new ShoporderExt();
    localShoporderExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localShoporderExt.selByList("SEL_BY_SHOP_DD");
    return localArrayList;
  }

  public ArrayList getCommandList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ShoporderExt localShoporderExt = new ShoporderExt();
    localShoporderExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localShoporderExt.selByList("SEL_BY_SHOP_DD", paramInt, 20);
    return localArrayList;
  }

  public int getCommandList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ShoporderExt localShoporderExt = new ShoporderExt();
    localShoporderExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localShoporderExt.selByList("SEL_BY_SHOP_DD");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.shopOrderMgr.ShopOrderInfo
 * JD-Core Version:    0.6.0
 */