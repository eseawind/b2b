package com.saas.biz.rawMaterialsMgr;

import com.saas.biz.dao.rawmaterialsDAO.RawMaterialsDAO;
import com.saas.biz.dao.rawmaterialsDAO.RawMaterialsExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class RawMaterialsInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
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

  public void addRawInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addRawInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PRODUCT_ID");
    String str3 = paramBuffers.getString("RAW_ID");
    String str4 = paramBuffers.getString("RAW_NAME");
    String str5 = paramBuffers.getString("RAW_NUM");
    String str6 = paramBuffers.getString("RAW_PRICE");
    String str7 = paramBuffers.getString("RAW_SITE");
    String str8 = paramBuffers.getString("RAW_DESC");
    String str9 = paramBuffers.getString("UNIT");
    String str10 = paramBuffers.getString("SESSION_USER_ID");
    String str11 = paramBuffers.getString("PUBLISH_DATE");
    String str12 = paramBuffers.getString("REMARK");
    try
    {
      RawMaterialsDAO localRawMaterialsDAO = new RawMaterialsDAO();
      localRawMaterialsDAO.setCust_id(str1);
      localRawMaterialsDAO.setProduct_id(str2);
      localRawMaterialsDAO.setRaw_id(str3);
      localRawMaterialsDAO.setRaw_name(str4);
      localRawMaterialsDAO.setRaw_num(str5);
      localRawMaterialsDAO.setRaw_price(str6);
      localRawMaterialsDAO.setRaw_site(str7);
      localRawMaterialsDAO.setRaw_desc(str8);
      localRawMaterialsDAO.setUnit(str9);
      localRawMaterialsDAO.setUser_id(str10);
      localRawMaterialsDAO.setPublish_date(str11);
      localRawMaterialsDAO.setRemark(str12);
      i = addRawInfo(localRawMaterialsDAO);
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
    this.log.LOG_INFO("退出addRawInfo方法...");
  }

  public int addRawInfo(RawMaterialsDAO paramRawMaterialsDAO)
    throws SaasApplicationException
  {
    RawMaterialsExt localRawMaterialsExt = new RawMaterialsExt();
    localRawMaterialsExt.setParam(":VCUST_ID", paramRawMaterialsDAO.getCust_id());
    localRawMaterialsExt.setParam(":VPRODUCT_ID", paramRawMaterialsDAO.getProduct_id());
    localRawMaterialsExt.setParam(":VRAW_ID", paramRawMaterialsDAO.getRaw_id());
    localRawMaterialsExt.setParam(":VRAW_NAME", paramRawMaterialsDAO.getRaw_name());
    localRawMaterialsExt.setParam(":VRAW_NUM", paramRawMaterialsDAO.getRaw_num());
    localRawMaterialsExt.setParam(":VRAW_PRICE", paramRawMaterialsDAO.getRaw_price());
    localRawMaterialsExt.setParam(":VRAW_SITE", paramRawMaterialsDAO.getRaw_site());
    localRawMaterialsExt.setParam(":VRAW_DESC", paramRawMaterialsDAO.getRaw_desc());
    localRawMaterialsExt.setParam(":VUNIT", paramRawMaterialsDAO.getUnit());
    localRawMaterialsExt.setParam(":VUSER_ID", paramRawMaterialsDAO.getUser_id());
    localRawMaterialsExt.setParam(":VPUBLISH_DATE", paramRawMaterialsDAO.getPublish_date());
    localRawMaterialsExt.setParam(":VREMARK", paramRawMaterialsDAO.getRemark());
    this.tradeQuery.executeBy(localRawMaterialsExt.insBy("INS_BY_RAW"));
    return 0;
  }

  public void modifyRawList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyRawList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("RAW_ID");
    String str3 = paramBuffers.getString("RAW_NAME");
    String str4 = paramBuffers.getString("RAW_NUM");
    String str5 = paramBuffers.getString("RAW_PRICE");
    String str6 = paramBuffers.getString("RAW_SITE");
    String str7 = paramBuffers.getString("RAW_DESC");
    String str8 = paramBuffers.getString("UNIT");
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("PUBLISH_DATE");
    String str11 = paramBuffers.getString("REMARK");
    try
    {
      RawMaterialsDAO localRawMaterialsDAO = new RawMaterialsDAO();
      localRawMaterialsDAO.setCust_id(str1);
      localRawMaterialsDAO.setRaw_id(str2);
      localRawMaterialsDAO.setRaw_name(str3);
      localRawMaterialsDAO.setRaw_num(str4);
      localRawMaterialsDAO.setRaw_price(str5);
      localRawMaterialsDAO.setRaw_site(str6);
      localRawMaterialsDAO.setRaw_desc(str7);
      localRawMaterialsDAO.setUnit(str8);
      localRawMaterialsDAO.setUser_id(str9);
      localRawMaterialsDAO.setPublish_date(str10);
      localRawMaterialsDAO.setRemark(str11);
      i = modifyRawList(localRawMaterialsDAO);
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
    this.log.LOG_INFO("退出modifyRawList方法...");
  }

  public int modifyRawList(RawMaterialsDAO paramRawMaterialsDAO)
    throws SaasApplicationException
  {
    RawMaterialsExt localRawMaterialsExt = new RawMaterialsExt();
    localRawMaterialsExt.setParam(":VCUST_ID", paramRawMaterialsDAO.getCust_id());
    localRawMaterialsExt.setParam(":VRAW_ID", paramRawMaterialsDAO.getRaw_id());
    localRawMaterialsExt.setParam(":VRAW_NAME", paramRawMaterialsDAO.getRaw_name());
    localRawMaterialsExt.setParam(":VRAW_NUM", paramRawMaterialsDAO.getRaw_num());
    localRawMaterialsExt.setParam(":VRAW_PRICE", paramRawMaterialsDAO.getRaw_price());
    localRawMaterialsExt.setParam(":VRAW_SITE", paramRawMaterialsDAO.getRaw_site());
    localRawMaterialsExt.setParam(":VRAW_DESC", paramRawMaterialsDAO.getRaw_desc());
    localRawMaterialsExt.setParam(":VUNIT", paramRawMaterialsDAO.getUnit());
    localRawMaterialsExt.setParam(":VUSER_ID", paramRawMaterialsDAO.getUser_id());
    localRawMaterialsExt.setParam(":VPUBLISH_DATE", paramRawMaterialsDAO.getPublish_date());
    localRawMaterialsExt.setParam(":VREMARK", paramRawMaterialsDAO.getRemark());
    this.tradeQuery.executeBy(localRawMaterialsExt.insBy("UP_BY_RAW"));
    return 0;
  }

  public void DelRawList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入DelRawList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("RAW_ID");
    try
    {
      RawMaterialsDAO localRawMaterialsDAO = new RawMaterialsDAO();
      localRawMaterialsDAO.setCust_id(str1);
      localRawMaterialsDAO.setRaw_id(str2);
      i = DelRawList(localRawMaterialsDAO);
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
    this.log.LOG_INFO("退出DelRawList方法...");
  }

  public int DelRawList(RawMaterialsDAO paramRawMaterialsDAO)
    throws SaasApplicationException
  {
    RawMaterialsExt localRawMaterialsExt = new RawMaterialsExt();
    localRawMaterialsExt.setParam(":VCUST_ID", paramRawMaterialsDAO.getCust_id());
    localRawMaterialsExt.setParam(":VRAW_ID", paramRawMaterialsDAO.getRaw_id());
    this.tradeQuery.executeBy(localRawMaterialsExt.insBy("DEL_BY_RAW"));
    return 0;
  }

  public ArrayList getRawMList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    RawMaterialsExt localRawMaterialsExt = new RawMaterialsExt();
    localRawMaterialsExt.setParam(":VCUST_ID", paramString1);
    localRawMaterialsExt.setParam(":VPRODUCT_ID", paramString2);
    ArrayList localArrayList = localRawMaterialsExt.selByList("SEL_BY_PRO_ID", paramInt, 20);
    return localArrayList;
  }

  public int getRawMList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    RawMaterialsExt localRawMaterialsExt = new RawMaterialsExt();
    localRawMaterialsExt.setParam(":VCUST_ID", paramString1);
    localRawMaterialsExt.setParam(":VPRODUCT_ID", paramString2);
    ArrayList localArrayList = localRawMaterialsExt.selByList("SEL_BY_PRO_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getListByRaw(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    RawMaterialsExt localRawMaterialsExt = new RawMaterialsExt();
    localRawMaterialsExt.setParam(":VCUST_ID", paramString1);
    localRawMaterialsExt.setParam(":VRAW_ID", paramString2);
    ArrayList localArrayList = localRawMaterialsExt.selByList("SEL_BY_RAW_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.rawMaterialsMgr.RawMaterialsInfo
 * JD-Core Version:    0.6.0
 */