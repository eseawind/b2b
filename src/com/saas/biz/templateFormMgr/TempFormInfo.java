package com.saas.biz.templateFormMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.templateFormDAO.TemplateExt;
import com.saas.biz.dao.templateFormDAO.TemplateFormDao;
import com.saas.biz.dao.templateItemDAO.TemplateItemExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class TempFormInfo
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

  public void addTemplateForm(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addTemplateForm方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ENTITY_TYPE");
    String str3 = paramBuffers.getString("FORM_ID");
    String str4 = paramBuffers.getString("FORM_NAME");
    String str5 = paramBuffers.getString("AREA_ID");
    String str6 = paramBuffers.getString("AREA_NAME");
    if ((str6 == null) || (str6.equals("")))
      str6 = "#";
    String str7 = paramBuffers.getString("AREA_NO");
    if ((str7 == null) || (str7.equals("")))
      str7 = "1";
    String str8 = paramBuffers.getString("FIELD_ID");
    String str9 = paramBuffers.getString("FIELD_NAME");
    String str10 = paramBuffers.getString("FIELD_TYPE");
    String str11 = paramBuffers.getString("FIELD_DESC");
    String str12 = paramBuffers.getString("DEFAULT_VALUE");
    String str13 = paramBuffers.getString("FIELD_NO");
    String str14 = paramBuffers.getString("REMARK2");
    String str15 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      TemplateFormDao localTemplateFormDao = new TemplateFormDao();
      localTemplateFormDao.setArea_id(str5);
      localTemplateFormDao.setCust_id(str1);
      localTemplateFormDao.setEntity_type(str2);
      localTemplateFormDao.setField_id(str8);
      localTemplateFormDao.setForm_id(str3);
      localTemplateFormDao.setForm_name(str4);
      localTemplateFormDao.setArea_name(str6);
      localTemplateFormDao.setArea_no(str7);
      localTemplateFormDao.setField_name(str9);
      localTemplateFormDao.setField_type(str10);
      localTemplateFormDao.setField_desc(str11);
      localTemplateFormDao.setDefault_value(str12);
      localTemplateFormDao.setField_no(str13);
      localTemplateFormDao.setRemark2(str14);
      localTemplateFormDao.setOper_user_id(str15);
      i = addTemplateForm(localTemplateFormDao);
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
    this.log.LOG_INFO("退出addTemplateForm方法...");
  }

  public int addTemplateForm(TemplateFormDao paramTemplateFormDao)
  {
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VAREA_ID", paramTemplateFormDao.getArea_id());
    localTemplateExt.setParam(":VCUST_ID", paramTemplateFormDao.getCust_id());
    localTemplateExt.setParam(":VENTITY_TYPE", paramTemplateFormDao.getEntity_type());
    localTemplateExt.setParam(":VFIELD_ID", paramTemplateFormDao.getField_id());
    localTemplateExt.setParam(":VFORM_ID", paramTemplateFormDao.getForm_id());
    localTemplateExt.setParam(":VFORM_NAME", paramTemplateFormDao.getForm_name());
    localTemplateExt.setParam(":VAREA_NAME", paramTemplateFormDao.getArea_name());
    localTemplateExt.setParam(":VAREA_NO", paramTemplateFormDao.getArea_no());
    localTemplateExt.setParam(":VFIELD_NAME", paramTemplateFormDao.getField_name());
    localTemplateExt.setParam(":VFIELD_TYPE", paramTemplateFormDao.getField_type());
    localTemplateExt.setParam(":VFIELD_DESC", paramTemplateFormDao.getField_desc());
    localTemplateExt.setParam(":VDEFAULT_VALUE", paramTemplateFormDao.getDefault_value());
    localTemplateExt.setParam(":VFIELD_NO", paramTemplateFormDao.getField_no());
    localTemplateExt.setParam(":VREMARK2", paramTemplateFormDao.getRemark2());
    localTemplateExt.setParam(":VOPER_USER_ID", paramTemplateFormDao.getOper_user_id());
    this.tradeQuery.executeBy(localTemplateExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void editTemplateFormField(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入editTemplateFormField方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("FIELD_ID");
    String str4 = paramBuffers.getString("FIELD_NAME");
    String str5 = paramBuffers.getString("FIELD_TYPE");
    String str6 = paramBuffers.getString("FIELD_DESC");
    String str7 = paramBuffers.getString("DEFAULT_VALUE");
    String str8 = paramBuffers.getString("FIELD_NO");
    String str9 = paramBuffers.getString("REMARK2");
    String str10 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      TemplateFormDao localTemplateFormDao = new TemplateFormDao();
      localTemplateFormDao.setCust_id(str1);
      localTemplateFormDao.setForm_id(str2);
      localTemplateFormDao.setField_id(str3);
      localTemplateFormDao.setField_name(str4);
      localTemplateFormDao.setField_type(str5);
      localTemplateFormDao.setField_desc(str6);
      localTemplateFormDao.setDefault_value(str7);
      localTemplateFormDao.setField_no(str8);
      localTemplateFormDao.setRemark2(str9);
      localTemplateFormDao.setOper_user_id(str10);
      i = editTemplateFormField(localTemplateFormDao);
    }
    catch (Exception localException)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "修改模板字段出错！");
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
    this.log.LOG_INFO("退出editTemplateFormField方法...");
  }

  public int editTemplateFormField(TemplateFormDao paramTemplateFormDao)
    throws SaasApplicationException
  {
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramTemplateFormDao.getCust_id());
    localTemplateExt.setParam(":VFORM_ID", paramTemplateFormDao.getForm_id());
    localTemplateExt.setParam(":VFIELD_ID", paramTemplateFormDao.getField_id());
    localTemplateExt.setParam(":VFIELD_NAME", paramTemplateFormDao.getField_name());
    localTemplateExt.setParam(":VFIELD_TYPE", paramTemplateFormDao.getField_type());
    localTemplateExt.setParam(":VFIELD_DESC", paramTemplateFormDao.getField_desc());
    localTemplateExt.setParam(":VDEFAULT_VALUE", paramTemplateFormDao.getDefault_value());
    localTemplateExt.setParam(":VFIELD_NO", paramTemplateFormDao.getField_no());
    localTemplateExt.setParam(":VREMARK2", paramTemplateFormDao.getRemark2());
    localTemplateExt.setParam(":VOPER_USER_ID", paramTemplateFormDao.getOper_user_id());
    this.tradeQuery.executeBy(localTemplateExt.insBy("UPDATE_BY_FIELD"));
    return 0;
  }

  public void editTemplateFormArea(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入editTemplateFormArea方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("AREA_ID");
    String str4 = paramBuffers.getString("AREA_NAME");
    String str5 = paramBuffers.getString("AREA_NO");
    if ((str5 == null) || (str5.equals("")))
      str5 = "1";
    String str6 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      TemplateFormDao localTemplateFormDao = new TemplateFormDao();
      localTemplateFormDao.setCust_id(str1);
      localTemplateFormDao.setForm_id(str2);
      localTemplateFormDao.setOper_user_id(str6);
      localTemplateFormDao.setArea_id(str3);
      localTemplateFormDao.setArea_name(str4);
      localTemplateFormDao.setArea_no(str5);
      i = editTemplateFormArea(localTemplateFormDao);
    }
    catch (Exception localException)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "修改模板字段出错！");
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
    this.log.LOG_INFO("退出editTemplateFormArea方法...");
  }

  public int editTemplateFormArea(TemplateFormDao paramTemplateFormDao)
    throws SaasApplicationException
  {
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramTemplateFormDao.getCust_id());
    localTemplateExt.setParam(":VFORM_ID", paramTemplateFormDao.getForm_id());
    localTemplateExt.setParam(":VAREA_NAME", paramTemplateFormDao.getArea_name());
    localTemplateExt.setParam(":VAREA_NO", paramTemplateFormDao.getArea_no());
    localTemplateExt.setParam(":VAREA_ID", paramTemplateFormDao.getArea_id());
    localTemplateExt.setParam(":VOPER_USER_ID", paramTemplateFormDao.getOper_user_id());
    this.tradeQuery.executeBy(localTemplateExt.insBy("UPDATE_BY_AREA"));
    return 0;
  }

  public ArrayList getTemplateFormById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VFORM_ID", paramString2);
    localArrayList = localTemplateExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public ArrayList getTemplateAreaField(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VFORM_ID", paramString2);
    ArrayList localArrayList2 = localTemplateExt.selByList("SEL_BY_GROUP");
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)localArrayList2.get(i);
        String str1 = "";
        if (localHashMap1.get("area_id") != null)
          str1 = localHashMap1.get("area_id").toString();
        String str2 = "";
        if (localHashMap1.get("area_name") != null)
          str2 = localHashMap1.get("area_name").toString();
        TemplateOject localTemplateOject = new TemplateOject();
        localTemplateOject.setArea_id(str1);
        localTemplateOject.setArea_name(str2);
        HashMap localHashMap2 = getFieldAndItems(paramString1, paramString2, str1);
        localTemplateOject.setMap(localHashMap2);
        localArrayList1.add(localTemplateOject);
      }
    return localArrayList1;
  }

  public HashMap<HashMap, ArrayList> getFieldAndItems(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VFORM_ID", paramString2);
    localTemplateExt.setParam(":VAREA_ID", paramString3);
    ArrayList localArrayList1 = localTemplateExt.selByList("SEL_BY_AREAID");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap2 = new HashMap();
        localHashMap2 = (HashMap)localArrayList1.get(i);
        String str = "";
        if (localHashMap2.get("field_id") != null)
          str = localHashMap2.get("field_id").toString();
        ArrayList localArrayList2 = getTeplateItmesByArea(paramString1, paramString2, str);
        localHashMap1.put(localHashMap2, localArrayList2);
      }
    return localHashMap1;
  }

  public ArrayList getTeplateItmesByArea(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramString1);
    localTemplateItemExt.setParam(":VFORM_ID", paramString2);
    localTemplateItemExt.setParam(":VFIELD_ID", paramString3);
    localArrayList = localTemplateItemExt.selByList("SEL_BY_FORM");
    return localArrayList;
  }

  public HashMap getTeplateAreaById(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VFORM_ID", paramString2);
    localTemplateExt.setParam(":VAREA_ID", paramString3);
    ArrayList localArrayList = localTemplateExt.selByList("SEL_BY_AREAID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getTemplateFormList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 20;
      TemplateExt localTemplateExt = new TemplateExt();
      localTemplateExt.setParam(":VCUST_ID", paramString);
      localArrayList = localTemplateExt.selByList("SEL_BY_LIST", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getTemplateSize(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    try
    {
      TemplateExt localTemplateExt = new TemplateExt();
      localTemplateExt.setParam(":VCUST_ID", paramString);
      localArrayList = localTemplateExt.selByList("SEL_BY_CT");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.log.LOG_INFO(localNumberFormatException.getMessage());
    }
    return i;
  }

  public ArrayList getTemplateListByType(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 20;
      TemplateExt localTemplateExt = new TemplateExt();
      localTemplateExt.setParam(":VCUST_ID", paramString1);
      localTemplateExt.setParam(":VENTITY_TYPE", paramString2);
      localArrayList = localTemplateExt.selByList("SEL_BY_TYPE_LIST", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public String getTemplateSelect(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VENTITY_TYPE", paramString2);
    localArrayList = localTemplateExt.selByList("SEL_BY_TYPE_LIST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("form_id").toString();
        String str3 = localHashMap.get("form_name").toString();
        str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>";
      }
    return str1;
  }

  public int getTemplateCountByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    try
    {
      TemplateExt localTemplateExt = new TemplateExt();
      localTemplateExt.setParam(":VCUST_ID", paramString1);
      localTemplateExt.setParam(":VENTITY_TYPE", paramString2);
      localArrayList = localTemplateExt.selByList("SEL_BY_TYPE_CT");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.log.LOG_INFO(localNumberFormatException.getMessage());
    }
    return i;
  }

  public void deleteTemplateForm(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteTemplateForm方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    try
    {
      i = deleteTemplateForm(str1, str2);
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
    this.log.LOG_INFO("退出deleteTemplateForm方法...");
  }

  public int deleteTemplateForm(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VFORM_ID", paramString2);
    this.tradeQuery.executeBy(localTemplateExt.insBy("DEL_BY_ID"));
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramString1);
    localTemplateItemExt.setParam(":VFORM_ID", paramString2);
    this.tradeQuery.executeBy(localTemplateItemExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public void deleteTemplateArea(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteTemplateArea方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("AREA_ID");
    try
    {
      i = deleteTemplateArea(str1, str2, str3);
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
    this.log.LOG_INFO("退出deleteTemplateArea方法...");
  }

  public int deleteTemplateArea(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VFORM_ID", paramString2);
    localTemplateExt.setParam(":VAREA_ID", paramString3);
    this.tradeQuery.executeBy(localTemplateExt.insBy("DEL_BY_AREA"));
    return 0;
  }

  public void deleteTemplateField(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteTemplateField方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("FIELD_ID");
    try
    {
      i = deleteTemplateField(str1, str2, str3);
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
    this.log.LOG_INFO("退出deleteTemplateField方法...");
  }

  public int deleteTemplateField(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VFORM_ID", paramString2);
    localTemplateExt.setParam(":VFIELD_ID", paramString3);
    this.tradeQuery.executeBy(localTemplateExt.insBy("DEL_BY_FILEDID"));
    return 0;
  }

  public ArrayList getTemplateFormByField(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VFORM_ID", paramString2);
    localTemplateExt.setParam(":VFIELD_ID", paramString3);
    localArrayList = localTemplateExt.selByList("SEL_BY_FORM");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.templateFormMgr.TempFormInfo
 * JD-Core Version:    0.6.0
 */