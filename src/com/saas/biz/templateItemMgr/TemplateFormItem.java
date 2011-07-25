package com.saas.biz.templateItemMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.templateItemDAO.TemplateItemDAO;
import com.saas.biz.dao.templateItemDAO.TemplateItemExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class TemplateFormItem
{
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

  public void addTemplateItem(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addTemplateItem方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("FIELD_ID");
    String str4 = paramBuffers.getString("ITEM_ID");
    String str5 = paramBuffers.getString("ITEM_NAME");
    String str6 = paramBuffers.getString("ITEM_DESC");
    String str7 = paramBuffers.getString("DEFAULT_VALUE");
    String str8 = paramBuffers.getString("ITEM_NO");
    if ((str8 == null) || (str8.equals("")))
      str8 = "1";
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("REMARK2");
    try
    {
      TemplateItemDAO localTemplateItemDAO = new TemplateItemDAO();
      localTemplateItemDAO.setCust_id(str1);
      localTemplateItemDAO.setField_id(str3);
      localTemplateItemDAO.setForm_id(str2);
      localTemplateItemDAO.setItem_id(str4);
      localTemplateItemDAO.setItem_name(str5);
      localTemplateItemDAO.setItem_desc(str6);
      localTemplateItemDAO.setDefault_value(str7);
      localTemplateItemDAO.setItem_no(str8);
      localTemplateItemDAO.setOper_user_id(str9);
      localTemplateItemDAO.setRemark2(str10);
      i = addTemplateItem(localTemplateItemDAO);
    }
    catch (Exception localException)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "提取表单数据出错！");
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
    this.log.LOG_INFO("退出addTemplateItem方法...");
  }

  public int addTemplateItem(TemplateItemDAO paramTemplateItemDAO)
  {
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramTemplateItemDAO.getCust_id());
    localTemplateItemExt.setParam(":VFIELD_ID", paramTemplateItemDAO.getField_id());
    localTemplateItemExt.setParam(":VFORM_ID", paramTemplateItemDAO.getForm_id());
    localTemplateItemExt.setParam(":VITEM_ID", paramTemplateItemDAO.getItem_id());
    localTemplateItemExt.setParam(":VITEM_NAME", paramTemplateItemDAO.getItem_name());
    localTemplateItemExt.setParam(":VITEM_DESC", paramTemplateItemDAO.getItem_desc());
    localTemplateItemExt.setParam(":VDEFAULT_VALUE", paramTemplateItemDAO.getDefault_value());
    localTemplateItemExt.setParam(":VITEM_NO", paramTemplateItemDAO.getItem_no());
    localTemplateItemExt.setParam(":VOPER_USER_ID", paramTemplateItemDAO.getOper_user_id());
    localTemplateItemExt.setParam(":VREMARK2", paramTemplateItemDAO.getRemark2());
    this.tradeQuery.executeBy(localTemplateItemExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void editTemplateItem(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入editTemplateItem方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("ITEM_ID");
    String str4 = paramBuffers.getString("ITEM_NAME");
    String str5 = paramBuffers.getString("ITEM_DESC");
    String str6 = paramBuffers.getString("DEFAULT_VALUE");
    String str7 = paramBuffers.getString("ITEM_NO");
    if ((str7 == null) || (str7.equals("")))
      str7 = "1";
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    String str9 = paramBuffers.getString("REMARK2");
    try
    {
      TemplateItemDAO localTemplateItemDAO = new TemplateItemDAO();
      localTemplateItemDAO.setCust_id(str1);
      localTemplateItemDAO.setForm_id(str2);
      localTemplateItemDAO.setItem_id(str3);
      localTemplateItemDAO.setItem_name(str4);
      localTemplateItemDAO.setItem_desc(str5);
      localTemplateItemDAO.setDefault_value(str6);
      localTemplateItemDAO.setItem_no(str7);
      localTemplateItemDAO.setOper_user_id(str8);
      localTemplateItemDAO.setRemark2(str9);
      i = editTemplateItem(localTemplateItemDAO);
    }
    catch (Exception localException)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "提取表单数据出错！");
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
    this.log.LOG_INFO("退出addTemplateItem方法...");
  }

  public int editTemplateItem(TemplateItemDAO paramTemplateItemDAO)
  {
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramTemplateItemDAO.getCust_id());
    localTemplateItemExt.setParam(":VFORM_ID", paramTemplateItemDAO.getForm_id());
    localTemplateItemExt.setParam(":VITEM_ID", paramTemplateItemDAO.getItem_id());
    localTemplateItemExt.setParam(":VITEM_NAME", paramTemplateItemDAO.getItem_name());
    localTemplateItemExt.setParam(":VITEM_DESC", paramTemplateItemDAO.getItem_desc());
    localTemplateItemExt.setParam(":VDEFAULT_VALUE", paramTemplateItemDAO.getDefault_value());
    localTemplateItemExt.setParam(":VITEM_NO", paramTemplateItemDAO.getItem_no());
    localTemplateItemExt.setParam(":VOPER_USER_ID", paramTemplateItemDAO.getOper_user_id());
    localTemplateItemExt.setParam(":VREMARK2", paramTemplateItemDAO.getRemark2());
    this.tradeQuery.executeBy(localTemplateItemExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public ArrayList getTeplateItmesByArea(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramString1);
    localTemplateItemExt.setParam(":VFIELD_ID", paramString2);
    localArrayList = localTemplateItemExt.selByList("SEL_BY_FIELD");
    return localArrayList;
  }

  public void delTemplateItem(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delTemplateItem方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("ITEM_ID");
    try
    {
      TemplateItemDAO localTemplateItemDAO = new TemplateItemDAO();
      localTemplateItemDAO.setCust_id(str1);
      localTemplateItemDAO.setForm_id(str2);
      localTemplateItemDAO.setItem_id(str3);
      i = delTemplateItem(localTemplateItemDAO);
    }
    catch (Exception localException)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "提取表单数据出错！");
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
    this.log.LOG_INFO("退出addTemplateItem方法...");
  }

  public int delTemplateItem(TemplateItemDAO paramTemplateItemDAO)
  {
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramTemplateItemDAO.getCust_id());
    localTemplateItemExt.setParam(":VFORM_ID", paramTemplateItemDAO.getForm_id());
    localTemplateItemExt.setParam(":VITEM_ID", paramTemplateItemDAO.getItem_id());
    this.tradeQuery.executeBy(localTemplateItemExt.insBy("DEL_BY_ITEMID"));
    return 0;
  }

  public void deleteItemByArea(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteItemByArea方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("AREA_ID");
    try
    {
      i = deleteItemByArea(str1, str2, str3);
    }
    catch (Exception localException)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "提取表单数据出错！");
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
    this.log.LOG_INFO("退出deleteItemByArea方法...");
  }

  public int deleteItemByArea(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramString1);
    localTemplateItemExt.setParam(":VFORM_ID", paramString2);
    localTemplateItemExt.setParam(":VAREA_ID", paramString3);
    this.tradeQuery.executeBy(localTemplateItemExt.insBy("DEL_BY_AREA"));
    return 0;
  }

  public void deleteItemByField(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteItemByField方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("FIELD_ID");
    try
    {
      i = deleteItemByField(str1, str2, str3);
    }
    catch (Exception localException)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "提取表单数据出错！");
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
    this.log.LOG_INFO("退出deleteItemByArea方法...");
  }

  public int deleteItemByField(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramString1);
    localTemplateItemExt.setParam(":VFORM_ID", paramString2);
    localTemplateItemExt.setParam(":VFIELD_ID", paramString3);
    this.tradeQuery.executeBy(localTemplateItemExt.insBy("DEL_BY_AREA"));
    return 0;
  }

  public ArrayList getTemplateItemById(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramString1);
    localTemplateItemExt.setParam(":VFORM_ID", paramString2);
    localTemplateItemExt.setParam(":VITEM_ID", paramString3);
    localArrayList = localTemplateItemExt.selByList("SEL_BY_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.templateItemMgr.TemplateFormItem
 * JD-Core Version:    0.6.0
 */