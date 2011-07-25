package com.saas.biz.goodsMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.goodsTypeDAO.GoodsTypeExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class GoodsTypeInfo
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

  public void addGoodsTypeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addGoodsTypeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("GOODS_ID");
    String str3 = paramBuffers.getString("STORE_TYPE");
    String str4 = paramBuffers.getString("MEAS_UNIT");
    String str5 = paramBuffers.getString("PER_UNIT_NUM");
    String str6 = paramBuffers.getString("PACK_UNIT");
    String str7 = paramBuffers.getString("LENGHT");
    String str8 = paramBuffers.getString("WIDTH");
    String str9 = paramBuffers.getString("HEIGHT");
    String str10 = paramBuffers.getString("VOLUME");
    String str11 = paramBuffers.getString("WEIGHT");
    String str12 = paramBuffers.getString("CAPACITY");
    String str13 = paramBuffers.getString("SHIP_TYPE");
    String str14 = paramBuffers.getString("SESSION_USER_ID");
    String str15 = paramBuffers.getString("PUBLISH_DATE");
    String str16 = paramBuffers.getString("REMARK2");
    GoodsInfo localGoodsInfo = new GoodsInfo();
    int j = localGoodsInfo.checkGoods(str1, str2);
    try
    {
      if (j == 0)
        i = addGoodsTypeInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
      i = 0;
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
    this.log.LOG_INFO("退出addGoodsTypeInfo方法...");
  }

  public int addGoodsTypeInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16)
    throws SaasApplicationException
  {
    GoodsTypeExt localGoodsTypeExt = new GoodsTypeExt();
    localGoodsTypeExt.setParam(":VCUST_ID", paramString1);
    localGoodsTypeExt.setParam(":VGOODS_ID", paramString2);
    localGoodsTypeExt.setParam(":VSTORE_TYPE", paramString3);
    localGoodsTypeExt.setParam(":VMEAS_UNIT", paramString4);
    localGoodsTypeExt.setParam(":VPER_UNIT_NUM", paramString5);
    localGoodsTypeExt.setParam(":VPACK_UNIT", paramString6);
    localGoodsTypeExt.setParam(":VLENGHT", paramString7);
    localGoodsTypeExt.setParam(":VWIDTH", paramString8);
    localGoodsTypeExt.setParam(":VHEIGHT", paramString9);
    localGoodsTypeExt.setParam(":VVOLUME", paramString10);
    localGoodsTypeExt.setParam(":VWEIGHT", paramString11);
    localGoodsTypeExt.setParam(":VCAPACITY", paramString12);
    localGoodsTypeExt.setParam(":VSHIP_TYPE", paramString13);
    localGoodsTypeExt.setParam(":VUSER_ID", paramString14);
    localGoodsTypeExt.setParam(":VPUBLISH_DATE", paramString15);
    localGoodsTypeExt.setParam(":VREMARK", paramString16);
    this.tradeQuery.executeBy(localGoodsTypeExt.insBy("INS_All_GOODS_TYPE"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.goodsMgr.GoodsTypeInfo
 * JD-Core Version:    0.6.0
 */