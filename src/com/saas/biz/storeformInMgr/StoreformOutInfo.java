package com.saas.biz.storeformInMgr;

import com.saas.biz.dao.storeformOutDAO.StoreformOutExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class StoreformOutInfo
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

  public void addStoreformOut(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addStoreformOut方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("HOUSE_ID");
    String str2 = paramBuffers.getString("POS_ID");
    String str3 = str1 + "|" + str2;
    String str4 = paramBuffers.getString("SESSION_CUST_ID");
    String str5 = paramBuffers.getString("FORM_ID");
    String str6 = paramBuffers.getString("QUO_ID");
    String str7 = paramBuffers.getString("LINK_QUO_ID");
    String str8 = paramBuffers.getString("QUO_NAME");
    String str9 = paramBuffers.getString("QUO_NO");
    String str10 = paramBuffers.getString("QUO_NUM");
    String str11 = paramBuffers.getString("GOODS_ID");
    String str12 = paramBuffers.getString("GOODS_NAME");
    String str13 = paramBuffers.getString("GOODS_DESC");
    String str14 = paramBuffers.getString("GOODS_NO");
    String str15 = paramBuffers.getString("STORE_NO");
    String str16 = paramBuffers.getString("GOODS_TYPE");
    String str17 = paramBuffers.getString("STORE_TYPE");
    String str18 = paramBuffers.getString("OBJ_CUST");
    String str19 = paramBuffers.getString("MEAS_UNIT");
    String str20 = paramBuffers.getString("PER_UNIT_NUM");
    String str21 = paramBuffers.getString("PACK_UNIT");
    String str22 = paramBuffers.getString("LENGHT");
    String str23 = paramBuffers.getString("WIDTH");
    String str24 = paramBuffers.getString("HEIGHT");
    String str25 = paramBuffers.getString("VOLUME");
    String str26 = paramBuffers.getString("WEIGHT");
    String str27 = paramBuffers.getString("CAPACITY");
    String str28 = paramBuffers.getString("SHIP_TYPE");
    String str29 = paramBuffers.getString("SHIP_DATE");
    String str30 = paramBuffers.getString("SESSION_USER_ID");
    String str31 = paramBuffers.getString("IN_DATE");
    String str32 = paramBuffers.getString("REMARK2");
    int i = -1;
    try
    {
      i = addStoreformOut(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32);
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
    this.log.LOG_INFO("退出addStoreformOut方法...");
  }

  public int addStoreformOut(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30)
    throws SaasApplicationException
  {
    StoreformOutExt localStoreformOutExt = new StoreformOutExt();
    localStoreformOutExt.setParam(":VSTORE_POS", paramString1);
    localStoreformOutExt.setParam(":VCUST_ID", paramString2);
    localStoreformOutExt.setParam(":VFORM_ID", paramString3);
    localStoreformOutExt.setParam(":VQUO_ID", paramString4);
    localStoreformOutExt.setParam(":VLINK_QUO_ID", paramString5);
    localStoreformOutExt.setParam(":VQUO_NAME", paramString6);
    localStoreformOutExt.setParam(":VQUO_NO", paramString7);
    localStoreformOutExt.setParam(":VQUO_NUM", paramString8);
    localStoreformOutExt.setParam(":VGOODS_ID", paramString9);
    localStoreformOutExt.setParam(":VGOODS_NAME", paramString10);
    localStoreformOutExt.setParam(":VGOODS_DESC", paramString11);
    localStoreformOutExt.setParam(":VGOODS_NO", paramString12);
    localStoreformOutExt.setParam(":VSTORE_NO", paramString13);
    localStoreformOutExt.setParam(":VGOODS_TYPE", paramString14);
    localStoreformOutExt.setParam(":VSTORE_TYPE", paramString15);
    localStoreformOutExt.setParam(":VOBJ_CUST", paramString16);
    localStoreformOutExt.setParam(":VMEAS_UNIT", paramString17);
    localStoreformOutExt.setParam(":VPER_UNIT_NUM", paramString18);
    localStoreformOutExt.setParam(":VPACK_UNIT", paramString19);
    localStoreformOutExt.setParam(":VLENGHT", paramString20);
    localStoreformOutExt.setParam(":VWIDTH", paramString21);
    localStoreformOutExt.setParam(":VHEIGHT", paramString22);
    localStoreformOutExt.setParam(":VVOLUME", paramString23);
    localStoreformOutExt.setParam(":VWEIGHT", paramString24);
    localStoreformOutExt.setParam(":VCAPACITY", paramString25);
    localStoreformOutExt.setParam(":VSHIP_TYPE", paramString26);
    localStoreformOutExt.setParam(":VSHIP_DATE", paramString27);
    localStoreformOutExt.setParam(":VOPER_USER_ID", paramString28);
    localStoreformOutExt.setParam(":VIN_DATE", paramString29);
    localStoreformOutExt.setParam(":VREMARK2", paramString30);
    this.tradeQuery.executeBy(localStoreformOutExt.insBy("INS_STOREFORM_OUT_ALL"));
    return 0;
  }

  public ArrayList getAllStoreFormOut(String paramString, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StoreformOutExt localStoreformOutExt = new StoreformOutExt();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      localStoreformOutExt.setParam(":VCUST_ID", paramString);
      localArrayList = localStoreformOutExt.selByList("SEL_BY_CUST", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getAllStoreFormOut(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    StoreformOutExt localStoreformOutExt = new StoreformOutExt();
    try
    {
      localStoreformOutExt.setParam(":VCUST_ID", paramString);
      localArrayList = localStoreformOutExt.selByList("SEL_BY_CUST");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.storeformInMgr.StoreformOutInfo
 * JD-Core Version:    0.6.0
 */