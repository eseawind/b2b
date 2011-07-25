package com.saas.biz.goodsGetuseMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.goodsGetuseDAO.GoodsGetuseExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class GoodsGetuseInfo
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

  public void addGoodsGetuseInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addGoodsGetuseInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    String str4 = paramBuffers.getString("QUO_NAME");
    String str5 = paramBuffers.getString("GOODS_ID");
    String str6 = paramBuffers.getString("QUO_CODE");
    String str7 = paramBuffers.getString("GET_TIME");
    String str8 = paramBuffers.getString("OBJ_USER_ID");
    String str9 = paramBuffers.getString("OBJ_USER_NAME");
    String str10 = paramBuffers.getString("REASON");
    String str11 = paramBuffers.getString("QUO_NUM");
    String str12 = paramBuffers.getString("SESSION_USER_ID");
    String str13 = paramBuffers.getString("IN_DATE");
    String str14 = paramBuffers.getString("REMARK2");
    try
    {
      i = addGoodsGetuseInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
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
    this.log.LOG_INFO("退出addGoodsGetuseInfo方法...");
  }

  public int addGoodsGetuseInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
    throws SaasApplicationException
  {
    GoodsGetuseExt localGoodsGetuseExt = new GoodsGetuseExt();
    localGoodsGetuseExt.setParam(":VCUST_ID", paramString1);
    localGoodsGetuseExt.setParam(":VFORM_ID", paramString2);
    localGoodsGetuseExt.setParam(":VQUO_ID", paramString3);
    localGoodsGetuseExt.setParam(":VQUO_NAME", paramString4);
    localGoodsGetuseExt.setParam(":VGOODS_ID", paramString5);
    localGoodsGetuseExt.setParam(":VQUO_CODE", paramString6);
    localGoodsGetuseExt.setParam(":VGET_TIME", paramString7);
    localGoodsGetuseExt.setParam(":VOBJ_USER_ID", paramString8);
    localGoodsGetuseExt.setParam(":VOBJ_USER_NAME", paramString9);
    localGoodsGetuseExt.setParam(":VREASON", paramString10);
    localGoodsGetuseExt.setParam(":VQUO_NUM", paramString11);
    localGoodsGetuseExt.setParam(":VOPER_USER_ID", paramString12);
    localGoodsGetuseExt.setParam(":VIN_DATE", paramString13);
    localGoodsGetuseExt.setParam(":VREMARK2", paramString14);
    this.tradeQuery.executeBy(localGoodsGetuseExt.insBy("INS_All_GOODS_GETUSE"));
    return 0;
  }

  public void updateGoodsGetuseInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateGoodsGetuseInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    String str4 = paramBuffers.getString("QUO_NAME");
    String str5 = paramBuffers.getString("GOODS_ID");
    String str6 = paramBuffers.getString("QUO_CODE");
    String str7 = paramBuffers.getString("GET_TIME");
    String str8 = paramBuffers.getString("OBJ_USER_ID");
    String str9 = paramBuffers.getString("OBJ_USER_NAME");
    String str10 = paramBuffers.getString("REASON");
    String str11 = paramBuffers.getString("QUO_NUM");
    String str12 = paramBuffers.getString("SESSION_USER_ID");
    String str13 = paramBuffers.getString("IN_DATE");
    String str14 = paramBuffers.getString("REMARK2");
    try
    {
      i = updateGoodsGetuseInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
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
    this.log.LOG_INFO("退出updateGoodsGetuseInfo方法...");
  }

  public int updateGoodsGetuseInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
    throws SaasApplicationException
  {
    GoodsGetuseExt localGoodsGetuseExt = new GoodsGetuseExt();
    localGoodsGetuseExt.setParam(":VCUST_ID", paramString1);
    localGoodsGetuseExt.setParam(":VFORM_ID", paramString2);
    localGoodsGetuseExt.setParam(":VQUO_ID", paramString3);
    localGoodsGetuseExt.setParam(":VQUO_NAME", paramString4);
    localGoodsGetuseExt.setParam(":VGOODS_ID", paramString5);
    localGoodsGetuseExt.setParam(":VQUO_CODE", paramString6);
    localGoodsGetuseExt.setParam(":VGET_TIME", paramString7);
    localGoodsGetuseExt.setParam(":VOBJ_USER_ID", paramString8);
    localGoodsGetuseExt.setParam(":VOBJ_USER_NAME", paramString9);
    localGoodsGetuseExt.setParam(":VREASON", paramString10);
    localGoodsGetuseExt.setParam(":VQUO_NUM", paramString11);
    localGoodsGetuseExt.setParam(":VOPER_USER_ID", paramString12);
    localGoodsGetuseExt.setParam(":VIN_DATE", paramString13);
    localGoodsGetuseExt.setParam(":VREMARK2", paramString14);
    this.tradeQuery.executeBy(localGoodsGetuseExt.insBy("UPDATE_All_GOODS_GETUSE"));
    return 0;
  }

  public void delGoodsGetuseInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delGoodsGetuseInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    try
    {
      i = delGoodsGetuseInfo(str1, str2, str3);
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
    this.log.LOG_INFO("退出delGoodsGetuseInfo方法...");
  }

  public int delGoodsGetuseInfo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    GoodsGetuseExt localGoodsGetuseExt = new GoodsGetuseExt();
    localGoodsGetuseExt.setParam(":VCUST_ID", paramString1);
    localGoodsGetuseExt.setParam(":VFORM_ID", paramString2);
    localGoodsGetuseExt.setParam(":VQUO_ID", paramString3);
    this.tradeQuery.executeBy(localGoodsGetuseExt.insBy("DEL_All_GOODS_GETUSE"));
    return 0;
  }

  public ArrayList getAllGoodsGetuse(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("=========" + paramInt);
    GoodsGetuseExt localGoodsGetuseExt = new GoodsGetuseExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 20;
      this.log.LOG_INFO("=================================");
      localGoodsGetuseExt.setParam(":VCUST_ID", paramString1);
      localGoodsGetuseExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localGoodsGetuseExt.selByList("SEL_ALL_GOODS_GETUSE", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getAllGoodsGetuse(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    GoodsGetuseExt localGoodsGetuseExt = new GoodsGetuseExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localGoodsGetuseExt.setParam(":VCUST_ID", paramString1);
      localGoodsGetuseExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localGoodsGetuseExt.selByList("SEL_ALL_GOODS_GETUSE");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public HashMap getOneGoodsGetuse(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    GoodsGetuseExt localGoodsGetuseExt = new GoodsGetuseExt();
    localGoodsGetuseExt.setParam(":VCUST_ID", paramString1);
    localGoodsGetuseExt.setParam(":VFORM_ID", paramString2);
    localGoodsGetuseExt.setParam(":VQUO_ID", paramString3);
    localArrayList = localGoodsGetuseExt.selByList("SEL_GOODS_GETUSE_BY_ID");
    HashMap localHashMap = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.goodsGetuseMgr.GoodsGetuseInfo
 * JD-Core Version:    0.6.0
 */