package com.saas.biz.productdistributionMgr;

import com.saas.biz.dao.productdistributionDAO.ProductDistributionDAO;
import com.saas.biz.dao.productdistributionDAO.ProductDistributionExt;
import com.saas.biz.goodsMgr.GoodsInfo;
import com.saas.biz.wareHouseMgr.wareHouseInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDistribution
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

  public void addProductDis(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addProductDis方法...");
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
    String str15 = paramBuffers.getString("USER_ID");
    String str16 = paramBuffers.getString("PUBLISH_DATE");
    String str17 = paramBuffers.getString("REMARK");
    try
    {
      ProductDistributionDAO localProductDistributionDAO = new ProductDistributionDAO();
      localProductDistributionDAO.setCust_id(str1);
      localProductDistributionDAO.setDis_id(str2);
      localProductDistributionDAO.setGoods_id(str3);
      localProductDistributionDAO.setHouse_id(str4);
      localProductDistributionDAO.setPos_id(str5);
      localProductDistributionDAO.setLast_pos(str6);
      localProductDistributionDAO.setLot_no(str7);
      localProductDistributionDAO.setMy_lot1(str8);
      localProductDistributionDAO.setMy_lot2(str9);
      localProductDistributionDAO.setMy_lot3(str10);
      localProductDistributionDAO.setLink_quo_id(str11);
      localProductDistributionDAO.setStore_vol(str12);
      localProductDistributionDAO.setState_code(str13);
      localProductDistributionDAO.setState_code_date(str14);
      localProductDistributionDAO.setUser_id(str15);
      localProductDistributionDAO.setPublish_date(str16);
      localProductDistributionDAO.setRemark(str17);
      i = addProductDis(localProductDistributionDAO);
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
    this.log.LOG_INFO("退出addProductDis方法...");
  }

  public int addProductDis(ProductDistributionDAO paramProductDistributionDAO)
    throws SaasApplicationException
  {
    ProductDistributionExt localProductDistributionExt = new ProductDistributionExt();
    localProductDistributionExt.setParam(":VCUST_ID", paramProductDistributionDAO.getCust_id());
    localProductDistributionExt.setParam(":VDIS_ID", paramProductDistributionDAO.getDis_id());
    localProductDistributionExt.setParam(":VGOODS_ID", paramProductDistributionDAO.getGoods_id());
    localProductDistributionExt.setParam(":VHOUSE_ID", paramProductDistributionDAO.getHouse_id());
    localProductDistributionExt.setParam(":VPOS_ID", paramProductDistributionDAO.getPos_id());
    localProductDistributionExt.setParam(":VLAST_POS", paramProductDistributionDAO.getLast_pos());
    localProductDistributionExt.setParam(":VLOT_NO", paramProductDistributionDAO.getLot_no());
    localProductDistributionExt.setParam(":VMY_LOT1", paramProductDistributionDAO.getMy_lot1());
    localProductDistributionExt.setParam(":VMY_LOT2", paramProductDistributionDAO.getMy_lot2());
    localProductDistributionExt.setParam(":VMY_LOT3", paramProductDistributionDAO.getMy_lot3());
    localProductDistributionExt.setParam(":VLINK_QUO_ID", paramProductDistributionDAO.getLink_quo_id());
    localProductDistributionExt.setParam(":VSTORE_VOL", paramProductDistributionDAO.getStore_vol());
    localProductDistributionExt.setParam(":VSTATE_CODE", paramProductDistributionDAO.getState_code());
    localProductDistributionExt.setParam(":VSTATE_CODE_DATE", paramProductDistributionDAO.getState_code_date());
    localProductDistributionExt.setParam(":VUSER_ID", paramProductDistributionDAO.getUser_id());
    localProductDistributionExt.setParam(":VPUBLISH_DATE", paramProductDistributionDAO.getPublish_date());
    localProductDistributionExt.setParam(":VREMARK", paramProductDistributionDAO.getRemark());
    this.tradeQuery.executeBy(localProductDistributionExt.insBy("INS_PRO_DIS_ALL"));
    return 0;
  }

  public void ModiProductDis(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入ModiProductDis方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("DIS_ID");
    String str3 = paramBuffers.getString("GOODS_ID");
    String str4 = paramBuffers.getString("HOUSE_ID");
    String str5 = paramBuffers.getString("POS_ID");
    String str6 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      ProductDistributionDAO localProductDistributionDAO = new ProductDistributionDAO();
      localProductDistributionDAO.setCust_id(str1);
      localProductDistributionDAO.setDis_id(str2);
      localProductDistributionDAO.setGoods_id(str3);
      localProductDistributionDAO.setHouse_id(str4);
      localProductDistributionDAO.setPos_id(str5);
      localProductDistributionDAO.setUser_id(str6);
      i = ModiProductDis(localProductDistributionDAO);
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
    this.log.LOG_INFO("退出ModiProductDis方法...");
  }

  public int ModiProductDis(ProductDistributionDAO paramProductDistributionDAO)
    throws SaasApplicationException
  {
    ProductDistributionExt localProductDistributionExt = new ProductDistributionExt();
    localProductDistributionExt.setParam(":VCUST_ID", paramProductDistributionDAO.getCust_id());
    localProductDistributionExt.setParam(":VDIS_ID", paramProductDistributionDAO.getDis_id());
    localProductDistributionExt.setParam(":VGOODS_ID", paramProductDistributionDAO.getGoods_id());
    localProductDistributionExt.setParam(":VHOUSE_ID", paramProductDistributionDAO.getHouse_id());
    localProductDistributionExt.setParam(":VPOS_ID", paramProductDistributionDAO.getPos_id());
    localProductDistributionExt.setParam(":VUSER_ID", paramProductDistributionDAO.getUser_id());
    this.tradeQuery.executeBy(localProductDistributionExt.insBy("UP_PRO_DIS_ALL"));
    return 0;
  }

  public HashMap getProtInfoById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductDistributionExt localProductDistributionExt = new ProductDistributionExt();
    localProductDistributionExt.setParam(":VCUST_ID", paramString1);
    localProductDistributionExt.setParam(":VGOODS_ID", paramString2);
    HashMap localHashMap = new HashMap();
    localArrayList = localProductDistributionExt.selByList("SEL_BY_GOODS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public HashMap getHousePos(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductDistributionExt localProductDistributionExt = new ProductDistributionExt();
    localProductDistributionExt.setParam(":VCUST_ID", paramString1);
    localProductDistributionExt.setParam(":VGOODS_ID", paramString2);
    HashMap localHashMap = new HashMap();
    localArrayList = localProductDistributionExt.selByList("SEL_HOUSE_POS_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductDistributionExt localProductDistributionExt = new ProductDistributionExt();
    localProductDistributionExt.setParam(":VCUST_ID", paramString1);
    localProductDistributionExt.setParam(":VGOODS_ID", paramString2);
    localArrayList = localProductDistributionExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public String getSelectHouse(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductDistributionExt localProductDistributionExt = new ProductDistributionExt();
    localProductDistributionExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductDistributionExt.selByList("SEL_HOUSE_BY_CUST_ID");
    HashMap localHashMap = new HashMap();
    WareHouseInfo localwareHouseInfo = new WareHouseInfo();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("house_id") != null)
        {
          str1 = localHashMap.get("house_id").toString();
          str2 = localwareHouseInfo.getHouseNameById(paramString, str1);
        }
        str3 = str3 + "<option value=" + str1 + ">" + str2 + "</option>";
      }
    return str3;
  }

  public Map getOneGoodsByHousePosId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductDistributionExt localProductDistributionExt = new ProductDistributionExt();
    localProductDistributionExt.setParam(":VCUST_ID", paramString1);
    localProductDistributionExt.setParam(":VHOUSE_ID", paramString2);
    localProductDistributionExt.setParam(":VPOS_ID", paramString3);
    localArrayList = localProductDistributionExt.selByList("SEL_GOODS_BY_HOUSE_POS_ID");
    String str1 = "";
    String str2 = "";
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    GoodsInfo localGoodsInfo = new GoodsInfo();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        localHashMap2 = (HashMap)localArrayList.get(i);
        if (localHashMap2.get("goods_id") != null)
          str1 = localHashMap2.get("goods_id").toString();
        localHashMap3 = localGoodsInfo.getOneGoods(paramString1, str1);
        if (localHashMap3.get("goods_name") != null)
          str2 = localHashMap3.get("goods_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.productdistributionMgr.ProductDistribution
 * JD-Core Version:    0.6.0
 */