package com.saas.biz.goodsTrackMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.goodsTrackDAO.GoodsTrackExt;
import com.saas.biz.goodsMgr.GoodsInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class GoodsTrackInfo
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

  public void addGoodsTrackInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addGoodsTrackInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("GOODS_ID");
    String str3 = paramBuffers.getString("TRADE_ID");
    String str4 = paramBuffers.getString("QUO_NUM");
    String str5 = paramBuffers.getString("PUBLISH_DATE");
    String str6 = paramBuffers.getString("SESSION_USER_ID");
    String str7 = paramBuffers.getString("PUBLISH_DATE");
    String str8 = paramBuffers.getString("REMARK2");
    GoodsInfo localGoodsInfo = new GoodsInfo();
    try
    {
      i = addGoodsTrackInfo(str1, str2, str3, str4, str5, str6, str7, str8);
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
    this.log.LOG_INFO("退出addGoodsTrackInfo方法...");
  }

  public int addGoodsTrackInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws SaasApplicationException
  {
    GoodsTrackExt localGoodsTrackExt = new GoodsTrackExt();
    localGoodsTrackExt.setParam(":VCUST_ID", paramString1);
    localGoodsTrackExt.setParam(":VGOODS_ID", paramString2);
    localGoodsTrackExt.setParam(":VTRADE_ID", paramString3);
    localGoodsTrackExt.setParam(":VTRADE_NUM", paramString4);
    localGoodsTrackExt.setParam(":VTRADE_DATE", paramString5);
    localGoodsTrackExt.setParam(":VUSER_ID", paramString6);
    localGoodsTrackExt.setParam(":VPUBLISH_DATE", paramString7);
    localGoodsTrackExt.setParam(":VREMARK", paramString8);
    this.tradeQuery.executeBy(localGoodsTrackExt.insBy("INS_All_GOODS_TRACK"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.goodsTrackMgr.GoodsTrackInfo
 * JD-Core Version:    0.6.0
 */