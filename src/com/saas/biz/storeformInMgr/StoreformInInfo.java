package com.saas.biz.storeformInMgr;

import com.saas.biz.dao.storeformInDAO.StoreformInExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class StoreformInInfo
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

  public void addStoreformIn(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addStoreformIn方法...");
    this.outBuffer = paramBuffers;
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
    String str14 = paramBuffers.getString("IN_REASON");
    String str15 = paramBuffers.getString("STORE_TYPE");
    String str16 = paramBuffers.getString("FIX_TAG");
    String str17 = paramBuffers.getString("OBJ_CUST");
    String str18 = paramBuffers.getString("SRC");
    String str19 = paramBuffers.getString("START_DATE");
    String str20 = paramBuffers.getString("END_DATE");
    String str21 = paramBuffers.getString("MEAS_UNIT");
    String str22 = paramBuffers.getString("PER_UNIT_NUM");
    String str23 = paramBuffers.getString("PACK_UNIT");
    String str24 = paramBuffers.getString("LENGHT");
    String str25 = paramBuffers.getString("WIDTH");
    String str26 = paramBuffers.getString("HEIGHT");
    String str27 = paramBuffers.getString("VOLUME");
    String str28 = paramBuffers.getString("WEIGHT");
    String str29 = paramBuffers.getString("CAPACITY");
    String str30 = paramBuffers.getString("SHIP_TYPE");
    String str31 = paramBuffers.getString("SHIP_DATE");
    String str32 = paramBuffers.getString("SESSION_USER_ID");
    String str33 = paramBuffers.getString("IN_DATE");
    String str34 = paramBuffers.getString("REMARK2");
    int i = -1;
    int j = checkGoods(str1, str8);
    try
    {
      if (j == 0)
        i = insertStoreformIn(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34);
      else
        i = updateStoreformIn(str1, str8, str7);
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
    this.log.LOG_INFO("退出addStoreformIn方法...");
  }

  public int insertStoreformIn(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34)
    throws SaasApplicationException
  {
    StoreformInExt localStoreformInExt = new StoreformInExt();
    localStoreformInExt.setParam(":VCUST_ID", paramString1);
    localStoreformInExt.setParam(":VFORM_ID", paramString2);
    localStoreformInExt.setParam(":VQUO_ID", paramString3);
    localStoreformInExt.setParam(":VLINK_QUO_ID", paramString4);
    localStoreformInExt.setParam(":VQUO_NAME", paramString5);
    localStoreformInExt.setParam(":VQUO_NO", paramString6);
    localStoreformInExt.setParam(":VQUO_NUM", paramString7);
    localStoreformInExt.setParam(":VGOODS_ID", paramString8);
    localStoreformInExt.setParam(":VGOODS_NAME", paramString9);
    localStoreformInExt.setParam(":VGOODS_DESC", paramString10);
    localStoreformInExt.setParam(":VGOODS_NO", paramString11);
    localStoreformInExt.setParam(":VSTORE_NO", paramString12);
    localStoreformInExt.setParam(":VGOODS_TYPE", paramString13);
    localStoreformInExt.setParam(":VIN_REASON", paramString14);
    localStoreformInExt.setParam(":VSTORE_TYPE", paramString15);
    localStoreformInExt.setParam(":VFIX_TAG", paramString16);
    localStoreformInExt.setParam(":VOBJ_CUST", paramString17);
    localStoreformInExt.setParam(":VSRC", paramString18);
    localStoreformInExt.setParam(":VSTART_DATE", paramString19);
    localStoreformInExt.setParam(":VEND_DATE", paramString20);
    localStoreformInExt.setParam(":VMEAS_UNIT", paramString21);
    localStoreformInExt.setParam(":VPER_UNIT_NUM", paramString22);
    localStoreformInExt.setParam(":VPACK_UNIT", paramString23);
    localStoreformInExt.setParam(":VLENGHT", paramString24);
    localStoreformInExt.setParam(":VWIDTH", paramString25);
    localStoreformInExt.setParam(":VHEIGHT", paramString26);
    localStoreformInExt.setParam(":VVOLUME", paramString27);
    localStoreformInExt.setParam(":VWEIGHT", paramString28);
    localStoreformInExt.setParam(":VCAPACITY", paramString29);
    localStoreformInExt.setParam(":VSHIP_TYPE", paramString30);
    localStoreformInExt.setParam(":VSHIP_DATE", paramString31);
    localStoreformInExt.setParam(":VOPER_USER_ID", paramString32);
    localStoreformInExt.setParam(":VIN_DATE", paramString33);
    localStoreformInExt.setParam(":VREMARK2", paramString34);
    this.tradeQuery.executeBy(localStoreformInExt.insBy("INS_STOREFORM_IN_ALL"));
    return 0;
  }

  public int updateStoreformIn(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    StoreformInExt localStoreformInExt = new StoreformInExt();
    localStoreformInExt.setParam(":VCUST_ID", paramString1);
    localStoreformInExt.setParam(":VGOODS_ID", paramString2);
    localStoreformInExt.setParam(":VQUO_NUM", paramString3);
    this.tradeQuery.executeBy(localStoreformInExt.insBy("UPDATE_STOREFORM_IN_ALL"));
    return 0;
  }

  public HashMap getOneStoreformIn(String paramString1, String paramString2)
  {
    StoreformInExt localStoreformInExt = new StoreformInExt();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    localStoreformInExt.setParam(":VCUST_ID", paramString1);
    localStoreformInExt.setParam(":VGOODS_ID", paramString2);
    localArrayList = localStoreformInExt.selByList("SEL_GOODS_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public int checkGoods(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    StoreformInExt localStoreformInExt = new StoreformInExt();
    localStoreformInExt.setParam(":VCUST_ID", paramString1);
    localStoreformInExt.setParam(":VGOODS_ID", paramString2);
    localArrayList = localStoreformInExt.selByList("SEL_GOODS_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public ArrayList getGoodsListByCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    StoreformInExt localStoreformInExt = new StoreformInExt();
    localStoreformInExt.setParam(":VCUST_ID", paramString);
    localArrayList = localStoreformInExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getGoodsCountByCust(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    StoreformInExt localStoreformInExt = new StoreformInExt();
    localStoreformInExt.setParam(":VCUST_ID", paramString);
    localArrayList = localStoreformInExt.selByList("SEL_BY_COUNT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.storeformInMgr.StoreformInInfo
 * JD-Core Version:    0.6.0
 */