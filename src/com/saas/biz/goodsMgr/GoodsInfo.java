package com.saas.biz.goodsMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.goodsDAO.GoodsExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class GoodsInfo
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

  public void addGoodsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addGoodsInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("GOODS_ID");
    String str3 = paramBuffers.getString("GOODS_NAME");
    String str4 = paramBuffers.getString("GOODS_DESC");
    String str5 = paramBuffers.getString("GOODS_NO");
    String str6 = paramBuffers.getString("STORE_NO");
    String str7 = paramBuffers.getString("GOODS_TYPE");
    String str8 = paramBuffers.getString("STORE_TYPE");
    String str9 = paramBuffers.getString("FIX_TAG");
    String str10 = paramBuffers.getString("MAKER");
    String str11 = paramBuffers.getString("SRC");
    String str12 = paramBuffers.getString("START_DATE");
    String str13 = paramBuffers.getString("END_DATE");
    String str14 = paramBuffers.getString("QUO_NUM");
    String str15 = paramBuffers.getString("SESSION_USER_ID");
    String str16 = paramBuffers.getString("PUBLISH_DATE");
    String str17 = paramBuffers.getString("REMARK2");
    int j = checkGoods(str1, str2);
    try
    {
      if (j == 0)
        i = addGoodsInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
      else
        i = updateGoodsInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
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
    this.log.LOG_INFO("退出addGoodsInfo方法...");
  }

  public int addGoodsInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17)
    throws SaasApplicationException
  {
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString1);
    localGoodsExt.setParam(":VGOODS_ID", paramString2);
    localGoodsExt.setParam(":VGOODS_NAME", paramString3);
    localGoodsExt.setParam(":VGOODS_DESC", paramString4);
    localGoodsExt.setParam(":VGOODS_NO", paramString5);
    localGoodsExt.setParam(":VSTORE_NO", paramString6);
    localGoodsExt.setParam(":VGOODS_TYPE", paramString7);
    localGoodsExt.setParam(":VSTORE_TYPE", paramString8);
    localGoodsExt.setParam(":VFIX_TAG", paramString9);
    localGoodsExt.setParam(":VMAKER", paramString10);
    localGoodsExt.setParam(":VSRC", paramString11);
    localGoodsExt.setParam(":VSTART_DATE", paramString12);
    localGoodsExt.setParam(":VEND_DATE", paramString13);
    localGoodsExt.setParam(":VNOW_NUM", paramString14);
    localGoodsExt.setParam(":VUSER_ID", paramString15);
    localGoodsExt.setParam(":VPUBLISH_DATE", paramString16);
    localGoodsExt.setParam(":VREMARK", paramString17);
    this.tradeQuery.executeBy(localGoodsExt.insBy("INS_All_GOODS"));
    this.log.LOG_INFO("===========" + localGoodsExt.insBy("INS_All_GOODS") + "==================");
    return 0;
  }

  public int updateGoodsInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17)
    throws SaasApplicationException
  {
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString1);
    localGoodsExt.setParam(":VGOODS_ID", paramString2);
    localGoodsExt.setParam(":VGOODS_NAME", paramString3);
    localGoodsExt.setParam(":VGOODS_DESC", paramString4);
    localGoodsExt.setParam(":VGOODS_NO", paramString5);
    localGoodsExt.setParam(":VSTORE_NO", paramString6);
    localGoodsExt.setParam(":VGOODS_TYPE", paramString7);
    localGoodsExt.setParam(":VSTORE_TYPE", paramString8);
    localGoodsExt.setParam(":VFIX_TAG", paramString9);
    localGoodsExt.setParam(":VMAKER", paramString10);
    localGoodsExt.setParam(":VSRC", paramString11);
    localGoodsExt.setParam(":VSTART_DATE", paramString12);
    localGoodsExt.setParam(":VEND_DATE", paramString13);
    localGoodsExt.setParam(":VNOW_NUM", paramString14);
    localGoodsExt.setParam(":VUSER_ID", paramString15);
    localGoodsExt.setParam(":VPUBLISH_DATE", paramString16);
    localGoodsExt.setParam(":VREMARK", paramString17);
    this.tradeQuery.executeBy(localGoodsExt.insBy("UPDATE_All_GOODS"));
    return 0;
  }

  public int checkGoods(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString1);
    localGoodsExt.setParam(":VGOODS_ID", paramString2);
    localArrayList = localGoodsExt.selByList("SEL_GOODS_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public String getGoodsName(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localGoodsExt.selByList("SEL_GOODS_NAME_BY_ID");
    String str1 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("goods_name").toString();
        String str3 = localHashMap.get("goods_id").toString();
        str1 = str1 + "<option value=" + str3 + ">" + str2 + "</option>";
      }
    return str1;
  }

  public String getGoodsByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString1);
    localGoodsExt.setParam(":VGOODS_TYPE", paramString2);
    localArrayList = localGoodsExt.selByList("SEL_GOODS_BY_TYPE");
    String str1 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("goods_name").toString();
        String str3 = localHashMap.get("goods_id").toString();
        str1 = str1 + "<option value=" + str3 + ">" + str2 + "</option>";
      }
    return str1;
  }

  public ArrayList getGoodsListByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString1);
    localGoodsExt.setParam(":VGOODS_TYPE", paramString2);
    localArrayList = localGoodsExt.selByList("SEL_GOODS_BY_TYPE");
    return localArrayList;
  }

  public HashMap getOneGoods(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString1);
    localGoodsExt.setParam(":VGOODS_ID", paramString2);
    localArrayList = localGoodsExt.selByList("SEL_GOODS_BY_ID");
    HashMap localHashMap = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getGoodsNames(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localGoodsExt.selByList("SEL_GOODS_BY_CUST_ID");
    return localArrayList;
  }

  public ArrayList getById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localGoodsExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public ArrayList getAllGoods(int paramInt, String paramString)
    throws SaasApplicationException
  {
    GoodsExt localGoodsExt = new GoodsExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 20;
      localGoodsExt.setParam(":VCUST_ID", paramString);
      localArrayList = localGoodsExt.selByList("SEL_BY_ID", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getAllGoods(String paramString)
    throws SaasApplicationException
  {
    GoodsExt localGoodsExt = new GoodsExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localGoodsExt.setParam(":VCUST_ID", paramString);
      localArrayList = localGoodsExt.selByList("SEL_BY_ID");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void updateDoor(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateDoor方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("GOODS_ID");
    String str3 = paramBuffers.getString("MAX_DOOR");
    String str4 = paramBuffers.getString("MIN_DOOR");
    try
    {
      i = updateDoor(str1, str3, str4, str2);
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
    this.log.LOG_INFO("退出updateDoor方法...");
  }

  public int updateDoor(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    GoodsExt localGoodsExt = new GoodsExt();
    localGoodsExt.setParam(":VCUST_ID", paramString1);
    localGoodsExt.setParam(":VGOODS_ID", paramString4);
    localGoodsExt.setParam(":VMAX_DOOR", paramString2);
    localGoodsExt.setParam(":VMIN_DOOR", paramString3);
    this.tradeQuery.executeBy(localGoodsExt.insBy("UPDATE_GOODS_DOOR"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.goodsMgr.GoodsInfo
 * JD-Core Version:    0.6.0
 */