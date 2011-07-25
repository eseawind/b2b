package com.saas.biz.storeOutMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.storeOutDAO.StoreOutDAO;
import com.saas.biz.dao.storeOutDAO.StoreOutExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class StoreOutInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
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

  public void addStoreOutInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addStoreOutInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    String str4 = paramBuffers.getString("LINK_QUO_ID");
    String str5 = paramBuffers.getString("QUO_NAME");
    String str6 = paramBuffers.getString("QUO_NO");
    String str7 = paramBuffers.getString("QUO_NUM");
    String str8 = paramBuffers.getString("GOODS_ID");
    String str9 = paramBuffers.getString("GOODS_NAME");
    String str10 = paramBuffers.getString("GOODS_DESC");
    String str11 = paramBuffers.getString("GOODS_NO");
    String str12 = paramBuffers.getString("STORE_NO");
    String str13 = paramBuffers.getString("GOODS_TYPE");
    String str14 = paramBuffers.getString("STORE_TYPE");
    String str15 = paramBuffers.getString("OBJ_CUST");
    String str16 = paramBuffers.getString("MEAS_UNIT");
    String str17 = paramBuffers.getString("PER_UNIT_NUM");
    String str18 = paramBuffers.getString("PACK_UNIT");
    String str19 = paramBuffers.getString("LENGHT");
    String str20 = paramBuffers.getString("WIDTH");
    String str21 = paramBuffers.getString("HEIGHT");
    String str22 = paramBuffers.getString("VOLUME");
    String str23 = paramBuffers.getString("WEIGHT");
    String str24 = paramBuffers.getString("SHIP_TYPE");
    String str25 = paramBuffers.getString("SHIP_DATE");
    String str26 = paramBuffers.getString("SESSION_USER_ID");
    String str27 = paramBuffers.getString("REMARK2");
    try
    {
      StoreOutDAO localStoreOutDAO = new StoreOutDAO();
      localStoreOutDAO.setCust_id(str1);
      localStoreOutDAO.setForm_id(str2);
      localStoreOutDAO.setQuo_id(str3);
      localStoreOutDAO.setLink_quo_id(str4);
      localStoreOutDAO.setQuo_name(str5);
      localStoreOutDAO.setQuo_no(str6);
      localStoreOutDAO.setQuo_num(str7);
      localStoreOutDAO.setGoods_id(str8);
      localStoreOutDAO.setGoods_name(str9);
      localStoreOutDAO.setGoods_desc(str10);
      localStoreOutDAO.setGoods_no(str11);
      localStoreOutDAO.setStore_no(str12);
      localStoreOutDAO.setGoods_type(str13);
      localStoreOutDAO.setStore_type(str14);
      localStoreOutDAO.setObj_cust(str15);
      localStoreOutDAO.setMeas_unit(str16);
      localStoreOutDAO.setPer_unit_num(str17);
      localStoreOutDAO.setPack_unit(str18);
      localStoreOutDAO.setLenght(str19);
      localStoreOutDAO.setWidth(str20);
      localStoreOutDAO.setHeight(str21);
      localStoreOutDAO.setVolume(str22);
      localStoreOutDAO.setWeight(str23);
      localStoreOutDAO.setShip_type(str24);
      localStoreOutDAO.setShip_date(str25);
      localStoreOutDAO.setOper_user_id(str26);
      localStoreOutDAO.setRemark2(str27);
      i = addStoreOutInfo(localStoreOutDAO);
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
    this.log.LOG_INFO("退出addReportInfo方法...");
  }

  public int addStoreOutInfo(StoreOutDAO paramStoreOutDAO)
  {
    StoreOutExt localStoreOutExt = new StoreOutExt();
    localStoreOutExt.setParam(":VCUST_ID", paramStoreOutDAO.getCust_id());
    localStoreOutExt.setParam(":VFORM_ID", paramStoreOutDAO.getForm_id());
    localStoreOutExt.setParam(":VQUO_ID", paramStoreOutDAO.getQuo_id());
    localStoreOutExt.setParam(":VLINK_QUO_ID", paramStoreOutDAO.getLink_quo_id());
    localStoreOutExt.setParam(":VQUO_NAME", paramStoreOutDAO.getQuo_name());
    localStoreOutExt.setParam(":VQUO_NO", paramStoreOutDAO.getQuo_no());
    localStoreOutExt.setParam(":VQUO_NUM", paramStoreOutDAO.getQuo_num());
    localStoreOutExt.setParam(":VGOODS_ID", paramStoreOutDAO.getGoods_id());
    localStoreOutExt.setParam(":VGOODS_NAME", paramStoreOutDAO.getGoods_name());
    localStoreOutExt.setParam(":VGOODS_DESC", paramStoreOutDAO.getGoods_desc());
    localStoreOutExt.setParam(":VGOODS_NO", paramStoreOutDAO.getGoods_no());
    localStoreOutExt.setParam(":VSTORE_NO", paramStoreOutDAO.getStore_no());
    localStoreOutExt.setParam(":VGOODS_TYPE", paramStoreOutDAO.getGoods_type());
    localStoreOutExt.setParam(":VSTORE_TYPE", paramStoreOutDAO.getStore_type());
    localStoreOutExt.setParam(":VOBJ_CUST", paramStoreOutDAO.getObj_cust());
    localStoreOutExt.setParam(":VMEAS_UNIT", paramStoreOutDAO.getMeas_unit());
    localStoreOutExt.setParam(":VPER_UNIT_NUM", paramStoreOutDAO.getPer_unit_num());
    localStoreOutExt.setParam(":VPACK_UNIT", paramStoreOutDAO.getPack_unit());
    localStoreOutExt.setParam(":VLENGHT", paramStoreOutDAO.getLenght());
    localStoreOutExt.setParam(":VWIDTH", paramStoreOutDAO.getWidth());
    localStoreOutExt.setParam(":VHEIGHT", paramStoreOutDAO.getHeight());
    localStoreOutExt.setParam(":VVOLUME", paramStoreOutDAO.getVolume());
    localStoreOutExt.setParam(":VWEIGHT", paramStoreOutDAO.getWeight());
    localStoreOutExt.setParam(":VSHIP_TYPE", paramStoreOutDAO.getShip_type());
    localStoreOutExt.setParam(":VSHIP_DATE", paramStoreOutDAO.getShip_date());
    localStoreOutExt.setParam(":VOPER_USER_ID", paramStoreOutDAO.getOper_user_id());
    localStoreOutExt.setParam(":VREMARK2", paramStoreOutDAO.getRemark2());
    this.tradeQuery.executeBy(localStoreOutExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void editStoreOutInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入editStoreOutInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    String str4 = paramBuffers.getString("LINK_QUO_ID");
    String str5 = paramBuffers.getString("QUO_NAME");
    String str6 = paramBuffers.getString("QUO_NO");
    String str7 = paramBuffers.getString("QUO_NUM");
    String str8 = paramBuffers.getString("GOODS_ID");
    String str9 = paramBuffers.getString("GOODS_NAME");
    String str10 = paramBuffers.getString("GOODS_DESC");
    String str11 = paramBuffers.getString("GOODS_NO");
    String str12 = paramBuffers.getString("STORE_NO");
    String str13 = paramBuffers.getString("GOODS_TYPE");
    String str14 = paramBuffers.getString("STORE_TYPE");
    String str15 = paramBuffers.getString("OBJ_CUST");
    String str16 = paramBuffers.getString("MEAS_UNIT");
    String str17 = paramBuffers.getString("PER_UNIT_NUM");
    String str18 = paramBuffers.getString("PACK_UNIT");
    String str19 = paramBuffers.getString("LENGHT");
    String str20 = paramBuffers.getString("WIDTH");
    String str21 = paramBuffers.getString("HEIGHT");
    String str22 = paramBuffers.getString("VOLUME");
    String str23 = paramBuffers.getString("WEIGHT");
    String str24 = paramBuffers.getString("SHIP_TYPE");
    String str25 = paramBuffers.getString("SHIP_DATE");
    String str26 = paramBuffers.getString("SESSION_USER_ID");
    String str27 = paramBuffers.getString("REMARK2");
    try
    {
      StoreOutDAO localStoreOutDAO = new StoreOutDAO();
      localStoreOutDAO.setCust_id(str1);
      localStoreOutDAO.setForm_id(str2);
      localStoreOutDAO.setQuo_id(str3);
      localStoreOutDAO.setLink_quo_id(str4);
      localStoreOutDAO.setQuo_name(str5);
      localStoreOutDAO.setQuo_no(str6);
      localStoreOutDAO.setQuo_num(str7);
      localStoreOutDAO.setGoods_id(str8);
      localStoreOutDAO.setGoods_name(str9);
      localStoreOutDAO.setGoods_desc(str10);
      localStoreOutDAO.setGoods_no(str11);
      localStoreOutDAO.setStore_no(str12);
      localStoreOutDAO.setGoods_type(str13);
      localStoreOutDAO.setStore_type(str14);
      localStoreOutDAO.setObj_cust(str15);
      localStoreOutDAO.setMeas_unit(str16);
      localStoreOutDAO.setPer_unit_num(str17);
      localStoreOutDAO.setPack_unit(str18);
      localStoreOutDAO.setLenght(str19);
      localStoreOutDAO.setWidth(str20);
      localStoreOutDAO.setHeight(str21);
      localStoreOutDAO.setVolume(str22);
      localStoreOutDAO.setWeight(str23);
      localStoreOutDAO.setShip_type(str24);
      localStoreOutDAO.setShip_date(str25);
      localStoreOutDAO.setOper_user_id(str26);
      localStoreOutDAO.setRemark2(str27);
      i = editStoreOutInfo(localStoreOutDAO);
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
    this.log.LOG_INFO("退出editStoreOutInfo方法...");
  }

  public int editStoreOutInfo(StoreOutDAO paramStoreOutDAO)
  {
    StoreOutExt localStoreOutExt = new StoreOutExt();
    localStoreOutExt.setParam(":VCUST_ID", paramStoreOutDAO.getCust_id());
    localStoreOutExt.setParam(":VFORM_ID", paramStoreOutDAO.getForm_id());
    localStoreOutExt.setParam(":VQUO_ID", paramStoreOutDAO.getQuo_id());
    localStoreOutExt.setParam(":VLINK_QUO_ID", paramStoreOutDAO.getLink_quo_id());
    localStoreOutExt.setParam(":VQUO_NAME", paramStoreOutDAO.getQuo_name());
    localStoreOutExt.setParam(":VQUO_NO", paramStoreOutDAO.getQuo_no());
    localStoreOutExt.setParam(":VQUO_NUM", paramStoreOutDAO.getQuo_num());
    localStoreOutExt.setParam(":VGOODS_ID", paramStoreOutDAO.getGoods_id());
    localStoreOutExt.setParam(":VGOODS_NAME", paramStoreOutDAO.getGoods_name());
    localStoreOutExt.setParam(":VGOODS_DESC", paramStoreOutDAO.getGoods_desc());
    localStoreOutExt.setParam(":VGOODS_NO", paramStoreOutDAO.getGoods_no());
    localStoreOutExt.setParam(":VSTORE_NO", paramStoreOutDAO.getStore_no());
    localStoreOutExt.setParam(":VGOODS_TYPE", paramStoreOutDAO.getGoods_type());
    localStoreOutExt.setParam(":VSTORE_TYPE", paramStoreOutDAO.getStore_type());
    localStoreOutExt.setParam(":VOBJ_CUST", paramStoreOutDAO.getObj_cust());
    localStoreOutExt.setParam(":VMEAS_UNIT", paramStoreOutDAO.getMeas_unit());
    localStoreOutExt.setParam(":VPER_UNIT_NUM", paramStoreOutDAO.getPer_unit_num());
    localStoreOutExt.setParam(":VPACK_UNIT", paramStoreOutDAO.getPack_unit());
    localStoreOutExt.setParam(":VLENGHT", paramStoreOutDAO.getLenght());
    localStoreOutExt.setParam(":VWIDTH", paramStoreOutDAO.getWidth());
    localStoreOutExt.setParam(":VHEIGHT", paramStoreOutDAO.getHeight());
    localStoreOutExt.setParam(":VVOLUME", paramStoreOutDAO.getVolume());
    localStoreOutExt.setParam(":VWEIGHT", paramStoreOutDAO.getWeight());
    localStoreOutExt.setParam(":VSHIP_TYPE", paramStoreOutDAO.getShip_type());
    localStoreOutExt.setParam(":VSHIP_DATE", paramStoreOutDAO.getShip_date());
    localStoreOutExt.setParam(":VOPER_USER_ID", paramStoreOutDAO.getOper_user_id());
    localStoreOutExt.setParam(":VREMARK2", paramStoreOutDAO.getRemark2());
    this.tradeQuery.executeBy(localStoreOutExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public void delStoreOutInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入editStoreOutInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("GOODS_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    try
    {
      i = delStoreOutInfo(str1, str2, str3);
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
    this.log.LOG_INFO("退出editStoreOutInfo方法...");
  }

  public int delStoreOutInfo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    StoreOutExt localStoreOutExt = new StoreOutExt();
    localStoreOutExt.setParam(":VCUST_ID", paramString1);
    localStoreOutExt.setParam(":VGOODS_ID", paramString2);
    localStoreOutExt.setParam(":VQUO_ID", paramString3);
    this.tradeQuery.executeBy(localStoreOutExt.insBy("DEL_BY_ALL"));
    return 0;
  }

  public ArrayList getStoreOutInfo(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    StoreOutExt localStoreOutExt = new StoreOutExt();
    localStoreOutExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localStoreOutExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getStoreOutSize(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    StoreOutExt localStoreOutExt = new StoreOutExt();
    localStoreOutExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localStoreOutExt.selByList("SEL_SIZE_BY_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public String getStoreOutJSON(int paramInt, String paramString)
    throws SaasApplicationException
  {
    String str = "";
    return str;
  }

  public HashMap getStoreOutInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    StoreOutExt localStoreOutExt = new StoreOutExt();
    localStoreOutExt.setParam(":VCUST_ID", paramString1);
    localStoreOutExt.setParam(":VQUO_ID", paramString2);
    ArrayList localArrayList = localStoreOutExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.storeOutMgr.StoreOutInfo
 * JD-Core Version:    0.6.0
 */