package com.saas.biz.entitypropMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.entitypropDAO.EntitypropDAO;
import com.saas.biz.dao.entitypropDAO.EntitypropExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class EntitypropInfo
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

  public void addEntityInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEntityInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ENTITY_TYPE");
    String str3 = paramBuffers.getString("ATTR_CODE");
    String str4 = paramBuffers.getString("ATTR_NAME");
    String str5 = paramBuffers.getString("ATTR_DESC");
    String str6 = paramBuffers.getString("DEFAULT_VALUE");
    String str7 = paramBuffers.getString("ENABLE_TAG");
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    String str9 = paramBuffers.getString("REMARK");
    try
    {
      EntitypropDAO localEntitypropDAO = new EntitypropDAO();
      localEntitypropDAO.setAttr_code(str3);
      localEntitypropDAO.setCust_id(str1);
      localEntitypropDAO.setEnable_tag(str7);
      localEntitypropDAO.setEntity_type(str2);
      localEntitypropDAO.setAttr_name(str4);
      localEntitypropDAO.setDefault_value(str6);
      localEntitypropDAO.setAttr_desc(str5);
      localEntitypropDAO.setOper_user_id(str8);
      localEntitypropDAO.setRemark(str9);
      i = addEntityInfo(localEntitypropDAO);
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
    this.log.LOG_INFO("退出addEntityInfo方法...");
  }

  public int addEntityInfo(EntitypropDAO paramEntitypropDAO)
    throws SaasApplicationException
  {
    EntitypropExt localEntitypropExt = new EntitypropExt();
    localEntitypropExt.setParam(":VATTR_CODE", paramEntitypropDAO.getAttr_code());
    localEntitypropExt.setParam(":VCUST_ID", paramEntitypropDAO.getCust_id());
    localEntitypropExt.setParam(":VENABLE_TAG", paramEntitypropDAO.getEnable_tag());
    localEntitypropExt.setParam(":VENTITY_TYPE", paramEntitypropDAO.getEntity_type());
    localEntitypropExt.setParam(":VATTR_NAME", paramEntitypropDAO.getAttr_name());
    localEntitypropExt.setParam(":VATTR_CODE", paramEntitypropDAO.getAttr_code());
    localEntitypropExt.setParam(":VDEFAULT_VALUE", paramEntitypropDAO.getDefault_value());
    localEntitypropExt.setParam(":VATTR_DESC", paramEntitypropDAO.getAttr_desc());
    localEntitypropExt.setParam(":VOPER_USER_ID", paramEntitypropDAO.getOper_user_id());
    localEntitypropExt.setParam(":VREMARK", paramEntitypropDAO.getRemark());
    this.tradeQuery.executeBy(localEntitypropExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateEntityInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateEntityInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ENTITY_TYPE");
    String str3 = paramBuffers.getString("ATTR_CODE");
    String str4 = paramBuffers.getString("ATTR_NAME");
    String str5 = paramBuffers.getString("ATTR_DESC");
    String str6 = paramBuffers.getString("DEFAULT_VALUE");
    String str7 = paramBuffers.getString("ENABLE_TAG");
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    String str9 = paramBuffers.getString("REMARK");
    try
    {
      EntitypropDAO localEntitypropDAO = new EntitypropDAO();
      localEntitypropDAO.setAttr_code(str3);
      localEntitypropDAO.setCust_id(str1);
      localEntitypropDAO.setEnable_tag(str7);
      localEntitypropDAO.setEntity_type(str2);
      localEntitypropDAO.setAttr_name(str4);
      localEntitypropDAO.setDefault_value(str6);
      localEntitypropDAO.setAttr_desc(str5);
      localEntitypropDAO.setOper_user_id(str8);
      localEntitypropDAO.setRemark(str9);
      i = updateEntityInfo(localEntitypropDAO);
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
    this.log.LOG_INFO("退出updateEntityInfo方法...");
  }

  public int updateEntityInfo(EntitypropDAO paramEntitypropDAO)
    throws SaasApplicationException
  {
    EntitypropExt localEntitypropExt = new EntitypropExt();
    localEntitypropExt.setParam(":VATTR_CODE", paramEntitypropDAO.getAttr_code());
    localEntitypropExt.setParam(":VCUST_ID", paramEntitypropDAO.getCust_id());
    localEntitypropExt.setParam(":VENABLE_TAG", paramEntitypropDAO.getEnable_tag());
    localEntitypropExt.setParam(":VENTITY_TYPE", paramEntitypropDAO.getEntity_type());
    localEntitypropExt.setParam(":VATTR_NAME", paramEntitypropDAO.getAttr_name());
    localEntitypropExt.setParam(":VATTR_CODE", paramEntitypropDAO.getAttr_code());
    localEntitypropExt.setParam(":VDEFAULT_VALUE", paramEntitypropDAO.getDefault_value());
    localEntitypropExt.setParam(":VATTR_DESC", paramEntitypropDAO.getAttr_desc());
    localEntitypropExt.setParam(":VOPER_USER_ID", paramEntitypropDAO.getOper_user_id());
    localEntitypropExt.setParam(":VREMARK", paramEntitypropDAO.getRemark());
    this.tradeQuery.executeBy(localEntitypropExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public void deleteEntityInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteEntityInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ATTR_CODE");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      EntitypropDAO localEntitypropDAO = new EntitypropDAO();
      localEntitypropDAO.setCust_id(str1);
      localEntitypropDAO.setAttr_code(str2);
      localEntitypropDAO.setOper_user_id(str3);
      i = deleteEntityInfo(localEntitypropDAO);
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
    this.log.LOG_INFO("退出deleteEntityInfo方法...");
  }

  public int deleteEntityInfo(EntitypropDAO paramEntitypropDAO)
    throws SaasApplicationException
  {
    EntitypropExt localEntitypropExt = new EntitypropExt();
    localEntitypropExt.setParam(":VATTR_CODE", paramEntitypropDAO.getAttr_code());
    localEntitypropExt.setParam(":VCUST_ID", paramEntitypropDAO.getCust_id());
    localEntitypropExt.setParam(":VENABLE_TAG", "1");
    this.tradeQuery.executeBy(localEntitypropExt.insBy("DEL_BY_ALL"));
    return 0;
  }

  public ArrayList getEntityInfoByCustId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EntitypropExt localEntitypropExt = new EntitypropExt();
    localEntitypropExt.setParam(":VCUST_ID", paramString1);
    localEntitypropExt.setParam(":VENABLE_TAG", paramString2);
    localArrayList = localEntitypropExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList getEntityInfoByCode(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EntitypropExt localEntitypropExt = new EntitypropExt();
    localEntitypropExt.setParam(":VCUST_ID", paramString1);
    localEntitypropExt.setParam(":VATTR_CODE", paramString2);
    localArrayList = localEntitypropExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public ArrayList getEntityPageByCustId(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    EntitypropExt localEntitypropExt = new EntitypropExt();
    localEntitypropExt.setParam(":VCUST_ID", paramString1);
    localEntitypropExt.setParam(":VENABLE_TAG", paramString2);
    localArrayList = localEntitypropExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getEntityCount(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    EntitypropExt localEntitypropExt = new EntitypropExt();
    localEntitypropExt.setParam(":VCUST_ID", paramString1);
    localEntitypropExt.setParam(":VENABLE_TAG", paramString2);
    localArrayList = localEntitypropExt.selByList("SEL_BY_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.entitypropMgr.EntitypropInfo
 * JD-Core Version:    0.6.0
 */