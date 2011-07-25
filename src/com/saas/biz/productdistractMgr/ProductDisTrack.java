package com.saas.biz.productdistractMgr;

import com.saas.biz.dao.productdistrackDAO.ProductDisTrackDAO;
import com.saas.biz.dao.productdistrackDAO.ProductDisTrackExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class ProductDisTrack
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

  public void addProductDisTrack(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addProductDisTrack方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("DIS_ID");
    String str3 = paramBuffers.getString("GOODS_ID");
    String str4 = paramBuffers.getString("HOUSE_ID");
    String str5 = paramBuffers.getString("POS_ID");
    String str6 = paramBuffers.getString("LAST_POS");
    String str7 = paramBuffers.getString("LOT_NO");
    String str8 = paramBuffers.getString("MY_LOT1");
    String str9 = paramBuffers.getString("MY_LOT2");
    String str10 = paramBuffers.getString("MY_LOT3");
    String str11 = paramBuffers.getString("LINK_QUO_ID");
    String str12 = paramBuffers.getString("STORE_VOL");
    String str13 = paramBuffers.getString("STATE_CODE");
    String str14 = paramBuffers.getString("STATE_CODE_DATE");
    String str15 = paramBuffers.getString("SESSION_USER_ID");
    String str16 = paramBuffers.getString("PUBLISH_DATE");
    String str17 = paramBuffers.getString("REMARK");
    try
    {
      ProductDisTrackDAO localProductDisTrackDAO = new ProductDisTrackDAO();
      localProductDisTrackDAO.setCust_id(str1);
      localProductDisTrackDAO.setDis_id(str2);
      localProductDisTrackDAO.setGoods_id(str3);
      localProductDisTrackDAO.setHouse_id(str4);
      localProductDisTrackDAO.setPos_id(str5);
      localProductDisTrackDAO.setLast_pos(str6);
      localProductDisTrackDAO.setLot_no(str7);
      localProductDisTrackDAO.setMy_lot1(str8);
      localProductDisTrackDAO.setMy_lot2(str9);
      localProductDisTrackDAO.setMy_lot3(str10);
      localProductDisTrackDAO.setLink_quo_id(str11);
      localProductDisTrackDAO.setStore_vol(str12);
      localProductDisTrackDAO.setState_code(str13);
      localProductDisTrackDAO.setState_code_date(str14);
      localProductDisTrackDAO.setUser_id(str15);
      localProductDisTrackDAO.setPublish_date(str16);
      localProductDisTrackDAO.setRemark(str17);
      i = addProductDisTrack(localProductDisTrackDAO);
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
    this.log.LOG_INFO("退出addProductDisTrack方法...");
  }

  public int addProductDisTrack(ProductDisTrackDAO paramProductDisTrackDAO)
    throws SaasApplicationException
  {
    ProductDisTrackExt localProductDisTrackExt = new ProductDisTrackExt();
    localProductDisTrackExt.setParam(":VCUST_ID", paramProductDisTrackDAO.getCust_id());
    localProductDisTrackExt.setParam(":VDIS_ID", paramProductDisTrackDAO.getDis_id());
    localProductDisTrackExt.setParam(":VGOODS_ID", paramProductDisTrackDAO.getGoods_id());
    localProductDisTrackExt.setParam(":VHOUSE_ID", paramProductDisTrackDAO.getHouse_id());
    localProductDisTrackExt.setParam(":VPOS_ID", paramProductDisTrackDAO.getPos_id());
    localProductDisTrackExt.setParam(":VLAST_POS", paramProductDisTrackDAO.getLast_pos());
    localProductDisTrackExt.setParam(":VLOT_NO", paramProductDisTrackDAO.getLot_no());
    localProductDisTrackExt.setParam(":VMY_LOT1", paramProductDisTrackDAO.getMy_lot1());
    localProductDisTrackExt.setParam(":VMY_LOT2", paramProductDisTrackDAO.getMy_lot2());
    localProductDisTrackExt.setParam(":VMY_LOT3", paramProductDisTrackDAO.getMy_lot3());
    localProductDisTrackExt.setParam(":VLINK_QUO_ID", paramProductDisTrackDAO.getLink_quo_id());
    localProductDisTrackExt.setParam(":VSTORE_VOL", paramProductDisTrackDAO.getStore_vol());
    localProductDisTrackExt.setParam(":VSTATE_CODE", paramProductDisTrackDAO.getState_code());
    localProductDisTrackExt.setParam(":VSTATE_CODE_DATE", paramProductDisTrackDAO.getState_code_date());
    localProductDisTrackExt.setParam(":VUSER_ID", paramProductDisTrackDAO.getUser_id());
    localProductDisTrackExt.setParam(":VPUBLISH_DATE", paramProductDisTrackDAO.getPublish_date());
    localProductDisTrackExt.setParam(":VREMARK", paramProductDisTrackDAO.getRemark());
    this.tradeQuery.executeBy(localProductDisTrackExt.insBy("INS_PRO_DIS_TRACK"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.productdistractMgr.ProductDisTrack
 * JD-Core Version:    0.6.0
 */