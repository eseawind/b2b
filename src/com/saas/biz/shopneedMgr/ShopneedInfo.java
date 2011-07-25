package com.saas.biz.shopneedMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.shopneedDAO.ShopneedExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ShopneedInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr commen = new commMethodMgr();
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

  public void addShopneed(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addShopneed方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("NEED_ID");
    String str4 = paramBuffers.getString("NEED_TITLE");
    String str5 = paramBuffers.getString("QUO_ID");
    String str6 = paramBuffers.getString("NEED_NO");
    String str7 = paramBuffers.getString("PRE_DATE");
    String str8 = paramBuffers.getString("ACT_DATE");
    String str9 = paramBuffers.getString("FROM_ADDR");
    String str10 = paramBuffers.getString("TO_ADDR");
    String str11 = paramBuffers.getString("LOG_TYPE");
    String str12 = paramBuffers.getString("SHIP_TYPE");
    String str13 = paramBuffers.getString("NEED_NUM");
    String str14 = paramBuffers.getString("UNIT");
    String str15 = paramBuffers.getString("STATE_CODE");
    String str16 = paramBuffers.getString("STATE_CODE_DATE");
    String str17 = paramBuffers.getString("SESSION_USER_ID");
    String str18 = paramBuffers.getString("PUBLISH_DATE");
    String str19 = paramBuffers.getString("REMARK");
    int i = -1;
    try
    {
      i = addShopneed(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19);
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
    this.log.LOG_INFO("退出addShopneed方法...");
  }

  public int addShopneed(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19)
    throws SaasApplicationException
  {
    ShopneedExt localShopneedExt = new ShopneedExt();
    localShopneedExt.setParam(":VCUST_ID", paramString1);
    localShopneedExt.setParam(":VFORM_ID", paramString2);
    localShopneedExt.setParam(":VNEED_ID", paramString3);
    localShopneedExt.setParam(":VNEED_TITLE", paramString4);
    localShopneedExt.setParam(":VQUO_ID", paramString5);
    localShopneedExt.setParam(":VNEED_NO", paramString6);
    localShopneedExt.setParam(":VPRE_DATE", paramString7);
    localShopneedExt.setParam(":VACT_DATE", paramString8);
    localShopneedExt.setParam(":VFROM_ADDR", paramString9);
    localShopneedExt.setParam(":VTO_ADDR", paramString10);
    localShopneedExt.setParam(":VLOG_TYPE", paramString11);
    localShopneedExt.setParam(":VSHIP_TYPE", paramString12);
    localShopneedExt.setParam(":VNEED_NUM", paramString13);
    localShopneedExt.setParam(":VUNIT", paramString14);
    localShopneedExt.setParam(":VSTATE_CODE", paramString15);
    localShopneedExt.setParam(":VSTATE_CODE_DATE", paramString16);
    localShopneedExt.setParam(":VUSER_ID", paramString17);
    localShopneedExt.setParam(":VPUBLISH_DATE", paramString18);
    localShopneedExt.setParam(":VREMARK", paramString19);
    this.tradeQuery.executeBy(localShopneedExt.insBy("INS_SHOPNEED_ALL"));
    return 0;
  }

  public void updateShopneed(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateShopneed方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("NEED_ID");
    String str4 = paramBuffers.getString("NEED_TITLE");
    String str5 = paramBuffers.getString("QUO_ID");
    String str6 = paramBuffers.getString("NEED_NO");
    String str7 = paramBuffers.getString("PRE_DATE");
    String str8 = paramBuffers.getString("ACT_DATE");
    String str9 = paramBuffers.getString("FROM_ADDR");
    String str10 = paramBuffers.getString("TO_ADDR");
    String str11 = paramBuffers.getString("LOG_TYPE");
    String str12 = paramBuffers.getString("SHIP_TYPE");
    String str13 = paramBuffers.getString("NEED_NUM");
    String str14 = paramBuffers.getString("UNIT");
    String str15 = paramBuffers.getString("STATE_CODE");
    String str16 = paramBuffers.getString("STATE_CODE_DATE");
    String str17 = paramBuffers.getString("SESSION_USER_ID");
    String str18 = paramBuffers.getString("PUBLISH_DATE");
    String str19 = paramBuffers.getString("REMARK");
    int i = -1;
    try
    {
      i = updateShopneed(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19);
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
    this.log.LOG_INFO("退出updateShopneed方法...");
  }

  public int updateShopneed(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19)
    throws SaasApplicationException
  {
    ShopneedExt localShopneedExt = new ShopneedExt();
    localShopneedExt.setParam(":VCUST_ID", paramString1);
    localShopneedExt.setParam(":VFORM_ID", paramString2);
    localShopneedExt.setParam(":VNEED_ID", paramString3);
    localShopneedExt.setParam(":VNEED_TITLE", paramString4);
    localShopneedExt.setParam(":VQUO_ID", paramString5);
    localShopneedExt.setParam(":VNEED_NO", paramString6);
    localShopneedExt.setParam(":VPRE_DATE", paramString7);
    localShopneedExt.setParam(":VACT_DATE", paramString8);
    localShopneedExt.setParam(":VFROM_ADDR", paramString9);
    localShopneedExt.setParam(":VTO_ADDR", paramString10);
    localShopneedExt.setParam(":VLOG_TYPE", paramString11);
    localShopneedExt.setParam(":VSHIP_TYPE", paramString12);
    localShopneedExt.setParam(":VNEED_NUM", paramString13);
    localShopneedExt.setParam(":VUNIT", paramString14);
    localShopneedExt.setParam(":VSTATE_CODE", paramString15);
    localShopneedExt.setParam(":VSTATE_CODE_DATE", paramString16);
    localShopneedExt.setParam(":VUSER_ID", paramString17);
    localShopneedExt.setParam(":VPUBLISH_DATE", paramString18);
    localShopneedExt.setParam(":VREMARK", paramString19);
    this.tradeQuery.executeBy(localShopneedExt.insBy("UPDATE_SHOPNEED"));
    return 0;
  }

  public void delOneShopneed(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delOneShopneed方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("NEED_ID");
    int i = -1;
    try
    {
      i = delOneShopneed(str1, str2);
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

  public int delOneShopneed(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ShopneedExt localShopneedExt = new ShopneedExt();
    localShopneedExt.setParam(":VCUST_ID", paramString1);
    localShopneedExt.setParam(":VNEED_ID", paramString2);
    this.tradeQuery.executeBy(localShopneedExt.insBy("DEL_ONE_SHOPNEED"));
    return 0;
  }

  public ArrayList getAllShopneedByCustId(String paramString1, int paramInt, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShopneedExt localShopneedExt = new ShopneedExt();
    try
    {
      paramInt *= 20;
      localShopneedExt.setParam(":VCUST_ID", paramString1);
      localShopneedExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localShopneedExt.selByList("SEL_ALL_SHOPNEED", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getAllShopneedByCustId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ShopneedExt localShopneedExt = new ShopneedExt();
    try
    {
      localShopneedExt.setParam(":VCUST_ID", paramString1);
      localShopneedExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localShopneedExt.selByList("SEL_ALL_SHOPNEED");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getOneShopNeed(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShopneedExt localShopneedExt = new ShopneedExt();
    localShopneedExt.setParam(":VCUST_ID", paramString1);
    localShopneedExt.setParam(":VNEED_ID", paramString2);
    localArrayList = localShopneedExt.selByList("SEL_ONE_SHOPNEED");
    return localArrayList;
  }

  public ArrayList getOneShopNeedAndState(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShopneedExt localShopneedExt = new ShopneedExt();
    localShopneedExt.setParam(":VCUST_ID", paramString1);
    localShopneedExt.setParam(":VNEED_ID", paramString2);
    localShopneedExt.setParam(":VSTATE_CODE", paramString3);
    localArrayList = localShopneedExt.selByList("SEL_ONE_SHOPNEED_STATE_CODE");
    return localArrayList;
  }

  public void updateShopneedStateCode(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateShopneedStateCode方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("NEED_ID");
    String str3 = paramBuffers.getString("CODE");
    String str4 = paramBuffers.getString("STATE_CODE_DATE");
    StringTokenizer localStringTokenizer = new StringTokenizer(str2, "|");
    String str5 = "";
    int i = -1;
    try
    {
      while (localStringTokenizer.hasMoreTokens())
      {
        str5 = localStringTokenizer.nextToken();
        i = updateShopneedStateCode(str1, str5, str3, str4);
      }
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
    this.log.LOG_INFO("退出updateShopneedStateCode方法...");
  }

  public int updateShopneedStateCode(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ShopneedExt localShopneedExt = new ShopneedExt();
    localShopneedExt.setParam(":VCUST_ID", paramString1);
    localShopneedExt.setParam(":VNEED_ID", paramString2);
    localShopneedExt.setParam(":VSTATE_CODE", paramString3);
    localShopneedExt.setParam(":VSTATE_CODE_DATE", paramString4);
    this.tradeQuery.executeBy(localShopneedExt.insBy("UPDATE_NEED_CODE"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.shopneedMgr.ShopneedInfo
 * JD-Core Version:    0.6.0
 */