package com.saas.biz.saleOrderMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.formStateDAO.FormStateExt;
import com.saas.biz.dao.saleFormDAO.SaleFormExt;
import com.saas.biz.dao.templateFormDAO.TemplateExt;
import com.saas.biz.dao.templateItemDAO.TemplateItemExt;
import com.saas.biz.formStateMgr.FormAreaEnity;
import com.saas.biz.formStateMgr.FormFieldEntity;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SaleOrderInfo
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

  public void addSaleOrder(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCustinfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    String str4 = paramBuffers.getString("QUO_NAME");
    String str5 = paramBuffers.getString("ITEM_ID");
    String str6 = paramBuffers.getString("FIELD_VALUE");
    String str7 = paramBuffers.getString("SESSION_USER_ID");
    String str8 = paramBuffers.getString("REMARK2");
    try
    {
      i = addSaleOrder(str1, str2, str3, str4, str5, str6, str7, str8);
    }
    catch (Exception localException)
    {
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
    this.log.LOG_INFO("退出addCustinfo方法...");
  }

  public int addSaleOrder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString6, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str1 = localStringTokenizer.nextToken();
      String str2 = str1.substring(0, str1.indexOf("&"));
      String str3 = str1.substring(str1.indexOf("&") + 1, str1.length());
      SaleFormExt localSaleFormExt = new SaleFormExt();
      localSaleFormExt.setParam(":VCUST_ID", paramString1);
      localSaleFormExt.setParam(":VFIELD_ID", str2);
      localSaleFormExt.setParam(":VQUO_NAME", paramString4);
      localSaleFormExt.setParam(":VFIELD_VALUE", str3);
      localSaleFormExt.setParam(":VQUO_ID", paramString3);
      localSaleFormExt.setParam(":VITEM_ID", paramString5);
      localSaleFormExt.setParam(":VFORM_ID", paramString2);
      localSaleFormExt.setParam(":VOPER_USER_ID", paramString7);
      localSaleFormExt.setParam(":VREMARK2", paramString8);
      localSaleFormExt.setParam(":VITEM_VALUE", "");
      this.tradeQuery.executeBy(localSaleFormExt.insBy("INS_BY_ALL"));
    }
    return 0;
  }

  public void addSaleOrderItem(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addSaleOrderItem方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    String str4 = paramBuffers.getString("QUO_NAME");
    String str5 = paramBuffers.getString("ITEM_ID");
    String str6 = paramBuffers.getString("FIELD_ID");
    String str7 = paramBuffers.getString("ITEM_VALUE");
    String str8 = paramBuffers.getString("FIELD_VALUE");
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("REMARK2");
    try
    {
      i = addSaleOrderItem(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }
    catch (Exception localException)
    {
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
    this.log.LOG_INFO("退出addSaleOrderItem方法...");
  }

  public int addSaleOrderItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    SaleFormExt localSaleFormExt = new SaleFormExt();
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFIELD_ID", paramString6);
    localSaleFormExt.setParam(":VFIELD_VALUE", paramString8);
    localSaleFormExt.setParam(":VQUO_ID", paramString3);
    localSaleFormExt.setParam(":VITEM_ID", paramString5);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localSaleFormExt.setParam(":VITEM_VALUE", paramString7);
    localSaleFormExt.setParam(":VQUO_ID", paramString3);
    localSaleFormExt.setParam(":VQUO_NAME", paramString4);
    localSaleFormExt.setParam(":VOPER_USER_ID", paramString9);
    localSaleFormExt.setParam(":VREMARK2", paramString10);
    this.tradeQuery.executeBy(localSaleFormExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList getSaleOrderList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    SaleFormExt localSaleFormExt = new SaleFormExt();
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localArrayList = localSaleFormExt.selByList("SEL_BY_FORM", paramInt, 20);
    return localArrayList;
  }

  public int getSaleOrderCount(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    SaleFormExt localSaleFormExt = new SaleFormExt();
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localArrayList = localSaleFormExt.selByList("SEL_BY_FORM_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getOrderDetailByList(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    SaleFormExt localSaleFormExt = new SaleFormExt();
    ArrayList localArrayList = new ArrayList();
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localSaleFormExt.setParam(":VQUO_ID", paramString3);
    localArrayList = localSaleFormExt.selByList("SEL_BY_QU_ID");
    return localArrayList;
  }

  public ArrayList<FormAreaEnity> getOrderInfoById(String paramString1, String paramString2, String paramString3)
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
        FormAreaEnity localFormAreaEnity = new FormAreaEnity();
        HashMap localHashMap = (HashMap)localArrayList2.get(i);
        String str1 = "";
        if (localHashMap.get("area_id") != null)
          str1 = localHashMap.get("area_id").toString();
        String str2 = "";
        if (localHashMap.get("area_name") != null)
          str2 = localHashMap.get("area_name").toString();
        localFormAreaEnity.setArea_id(str1);
        localFormAreaEnity.setArea_name(str2);
        ArrayList localArrayList3 = getFieldByAreaId(paramString1, paramString2, str1, paramString3);
        localFormAreaEnity.setField(localArrayList3);
        localArrayList1.add(localFormAreaEnity);
      }
    return localArrayList1;
  }

  public ArrayList<FormFieldEntity> getFieldByAreaId(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VCUST_ID", paramString1);
    localTemplateExt.setParam(":VFORM_ID", paramString2);
    localTemplateExt.setParam(":VAREA_ID", paramString3);
    ArrayList localArrayList2 = localTemplateExt.selByList("SEL_BY_AREAID");
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        FormFieldEntity localFormFieldEntity = new FormFieldEntity();
        HashMap localHashMap1 = new HashMap();
        localHashMap1 = (HashMap)localArrayList2.get(i);
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (localHashMap1.get("field_id") != null)
          str1 = localHashMap1.get("field_id").toString();
        if (localHashMap1.get("field_name") != null)
          str2 = localHashMap1.get("field_name").toString();
        if (localHashMap1.get("field_type") != null)
          str3 = localHashMap1.get("field_type").toString();
        ArrayList localArrayList3 = new ArrayList();
        if ((str3 == "0") || (str3.equals("0")))
        {
          localArrayList3 = getOrderFormValue(paramString1, paramString2, str1, paramString4);
        }
        else if ((str3 == "1") || (str3.equals("1")))
        {
          localArrayList3 = getItemByFieldId(paramString1, paramString2, str1, paramString4);
        }
        else if ((str3 == "2") || (str3.equals("2")))
        {
          ArrayList localArrayList4 = getItemByFieldId(paramString1, paramString2, str1, paramString4);
          if ((localArrayList4 != null) && (localArrayList4.size() > 0))
          {
            HashMap localHashMap2 = (HashMap)localArrayList4.get(0);
            if (localHashMap2.get("field_value") != null)
              str4 = localHashMap2.get("field_value").toString();
            localArrayList3 = getItemByFieldId(paramString1, paramString2, str1, str4);
          }
        }
        else if (((str3 == "3") || (str3.equals("3"))) && (localHashMap1.get("default_value") != null))
        {
          str4 = localHashMap1.get("default_value").toString();
        }
        localFormFieldEntity.setField_id(str1);
        localFormFieldEntity.setField_name(str2);
        localFormFieldEntity.setField_type(str3);
        localFormFieldEntity.setFiled_value(str4);
        localFormFieldEntity.setList(localArrayList3);
        localArrayList1.add(localFormFieldEntity);
      }
    return localArrayList1;
  }

  public ArrayList getItemByFieldId(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    SaleFormExt localSaleFormExt = new SaleFormExt();
    ArrayList localArrayList = new ArrayList();
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localSaleFormExt.setParam(":VFIELD_ID", paramString3);
    localSaleFormExt.setParam(":VQUO_ID", paramString4);
    localArrayList = localSaleFormExt.selByList("SEL_BY_FIELD");
    return localArrayList;
  }

  public ArrayList getValueList(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleFormExt localSaleFormExt = new SaleFormExt();
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localSaleFormExt.setParam(":VQUO_ID", paramString3);
    localArrayList = localSaleFormExt.selByList("SEL_BY_ITEM");
    this.log.equals("===" + localArrayList);
    return localArrayList;
  }

  public HashMap getOrderById(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    SaleFormExt localSaleFormExt = new SaleFormExt();
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localSaleFormExt.setParam(":VQUO_ID", paramString3);
    localArrayList = localSaleFormExt.selByList("SEL_BY_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getOrderFormValue(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    SaleFormExt localSaleFormExt = new SaleFormExt();
    ArrayList localArrayList = new ArrayList();
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localSaleFormExt.setParam(":VFIELD_ID", paramString3);
    localSaleFormExt.setParam(":VQUO_ID", paramString4);
    localArrayList = localSaleFormExt.selByList("SEL_BY_FIELD_ID");
    return localArrayList;
  }

  public String getTemplateItemById(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramString1);
    localTemplateItemExt.setParam(":VFORM_ID", paramString2);
    localTemplateItemExt.setParam(":VITEM_ID", paramString3);
    localArrayList = localTemplateItemExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("item_name") != null)
        str = localHashMap.get("item_name").toString();
    }
    return str;
  }

  public void delSaleOrder(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delSaleOrder方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    try
    {
      i = delSaleOrder(str1, str2, str3);
    }
    catch (Exception localException)
    {
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
    this.log.LOG_INFO("退出delSaleOrder方法...");
  }

  public int delSaleOrder(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    SaleFormExt localSaleFormExt = new SaleFormExt();
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localSaleFormExt.setParam(":VQUO_ID", paramString3);
    this.tradeQuery.executeBy(localSaleFormExt.insBy("DEL_BY_ID"));
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VCUST_ID", paramString1);
    localFormStateExt.setParam(":VSERVER_ID", paramString3);
    this.tradeQuery.executeBy(localFormStateExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public String getItemSelectedByFieldId(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    String str1 = "<select name=" + paramString5 + " id=" + paramString6 + ">";
    String str2 = "";
    String str3 = "";
    ArrayList localArrayList = getTemplateItemByFieldId(paramString1, paramString2, paramString3);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str4 = "";
        String str5 = "";
        if (localHashMap.get("item_id") != null)
          str4 = localHashMap.get("item_id").toString();
        if (localHashMap.get("item_name") != null)
          str5 = localHashMap.get("item_name").toString();
        if ((paramString4 == str4) || (paramString4.equals(str4)))
          str2 = "selected";
        else
          str2 = "";
        str3 = str3 + "<option value=" + str4 + " " + str2 + ">" + str5 + "</option>";
      }
    str1 = str1 + str3 + "</select>";
    return str1;
  }

  public ArrayList getTemplateItemByFieldId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TemplateItemExt localTemplateItemExt = new TemplateItemExt();
    localTemplateItemExt.setParam(":VCUST_ID", paramString1);
    localTemplateItemExt.setParam(":VFIELD_ID", paramString3);
    localTemplateItemExt.setParam(":VFORM_ID", paramString2);
    localArrayList = localTemplateItemExt.selByList("SEL_ITEM_BY_FIELD");
    return localArrayList;
  }

  public void eidtSaleOrder(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入eidtSaleOrder方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("FIELD_NAME");
    String str4 = paramBuffers.getString("REMARK2");
    try
    {
      i = eidtSaleOrder(str1, str2, str3, str4);
    }
    catch (Exception localException)
    {
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
    this.log.LOG_INFO("退出eidtSaleOrder方法...");
  }

  public int eidtSaleOrder(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString3, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str1 = localStringTokenizer.nextToken();
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      str2 = str1.substring(0, str1.indexOf("@"));
      str3 = str1.substring(str1.indexOf("@") + 1, str1.indexOf("&"));
      str4 = str1.substring(str1.indexOf("&") + 1, str1.indexOf(","));
      str5 = str1.substring(str1.indexOf(",") + 1, str1.indexOf("$"));
      String str6 = str1.substring(str1.indexOf("$") + 1, str1.length());
      SaleFormExt localSaleFormExt;
      if ((str6 == "2") || (str6.equals("2")))
      {
        localSaleFormExt = new SaleFormExt();
        localSaleFormExt.setParam(":VCUST_ID", paramString1);
        localSaleFormExt.setParam(":VFORM_ID", paramString2);
        localSaleFormExt.setParam(":VQUO_ID", str3);
        localSaleFormExt.setParam(":VFIELD_ID", str4);
        localSaleFormExt.setParam(":VITEM_VALUE", str2);
        localSaleFormExt.setParam(":VITEM_ID", str5);
        localSaleFormExt.setParam(":VREMARK2", paramString4);
        this.tradeQuery.executeBy(localSaleFormExt.insBy("UPDATE_BY_ITEMVALUE"));
      }
      else if ((str6 == "0") || (str6.equals("0")))
      {
        localSaleFormExt = new SaleFormExt();
        localSaleFormExt.setParam(":VCUST_ID", paramString1);
        localSaleFormExt.setParam(":VFORM_ID", paramString2);
        localSaleFormExt.setParam(":VQUO_ID", str3);
        localSaleFormExt.setParam(":VFIELD_ID", str4);
        localSaleFormExt.setParam(":VITEM_ID", str5);
        localSaleFormExt.setParam(":VFIELD_VALUE", str2);
        localSaleFormExt.setParam(":VREMARK2", paramString4);
        this.tradeQuery.executeBy(localSaleFormExt.insBy("UPDATE_BY_FIELD"));
      }
      else
      {
        localSaleFormExt = new SaleFormExt();
        localSaleFormExt.setParam(":VCUST_ID", paramString1);
        localSaleFormExt.setParam(":VFORM_ID", paramString2);
        localSaleFormExt.setParam(":VQUO_ID", str3);
        localSaleFormExt.setParam(":VFIELD_ID", str4);
        localSaleFormExt.setParam(":VITEM_ID", str5);
        localSaleFormExt.setParam(":VFIELD_VALUE", str2);
        localSaleFormExt.setParam(":VREMARK2", paramString4);
        this.tradeQuery.executeBy(localSaleFormExt.insBy("UPDATE_BY_ITEM"));
      }
    }
    return 0;
  }

  public String getFieldTypeByField(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    SaleFormExt localSaleFormExt = new SaleFormExt();
    String str = "";
    localSaleFormExt.setParam(":VCUST_ID", paramString1);
    localSaleFormExt.setParam(":VFORM_ID", paramString2);
    localSaleFormExt.setParam(":VFILED_ID", paramString3);
    ArrayList localArrayList = localSaleFormExt.selByList("SEL_BY_FILEDID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("field_type") != null)
        str = localHashMap.get("field_type").toString();
    }
    return str;
  }

  public ArrayList getOrderListByState(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getOrderListByState方法");
    paramInt *= 20;
    ArrayList localArrayList1 = new ArrayList();
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VCUST_ID", paramString1);
    localFormStateExt.setParam(":VSTATE1", paramString2);
    localFormStateExt.setParam(":VSTATE2", paramString3);
    localFormStateExt.setParam(":VSTATE3", paramString4);
    ArrayList localArrayList2 = localFormStateExt.selByList("SEL_BY_STATE", paramInt, 20);
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)localArrayList2.get(i);
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        HashMap localHashMap2 = new HashMap();
        if (localHashMap1.get("quo_id") != null)
          str2 = localHashMap1.get("quo_id").toString();
        if (localHashMap1.get("state_code") != null)
          str1 = localHashMap1.get("state_code").toString();
        HashMap localHashMap3 = getOrderFormAdd(str2, paramString1);
        if ((localHashMap3 != null) && (localHashMap3.size() > 0))
        {
          if (localHashMap3.get("form_name") != null)
            str3 = localHashMap3.get("form_name").toString();
          if (localHashMap3.get("entity_type") != null)
            str4 = localHashMap3.get("entity_type").toString();
          if (localHashMap3.get("quo_name") != null)
            str5 = localHashMap3.get("quo_name").toString();
          if (localHashMap3.get("form_id") != null)
            str6 = localHashMap3.get("form_id").toString();
        }
        localHashMap2.put("quo_id", str2);
        localHashMap2.put("state_code", str1);
        localHashMap2.put("form_name", str3);
        localHashMap2.put("form_id", str6);
        localHashMap2.put("entity_type", str4);
        localHashMap2.put("quo_name", str5);
        localArrayList1.add(localHashMap2);
      }
    this.log.LOG_INFO("退出getOrderListByState方法");
    return localArrayList1;
  }

  public HashMap getOrderFormAdd(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getOrderFormAdd方法");
    SaleFormExt localSaleFormExt = new SaleFormExt();
    localSaleFormExt.setParam(":VQUO_ID", paramString1);
    ArrayList localArrayList = localSaleFormExt.selByList("SEL_BY_ID");
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      if (localHashMap2.get("form_id") != null)
        str3 = localHashMap2.get("form_id").toString();
      if (localHashMap2.get("quo_name") != null)
        str4 = localHashMap2.get("quo_name").toString();
      HashMap localHashMap3 = getFormNameByName(str3, paramString2);
      if ((localHashMap3 != null) && (localHashMap3.size() > 0))
      {
        if (localHashMap3.get("name") != null)
          str1 = localHashMap3.get("name").toString();
        if (localHashMap3.get("type") != null)
          str2 = localHashMap3.get("type").toString();
      }
    }
    localHashMap1.put("form_name", str1);
    localHashMap1.put("entity_type", str2);
    localHashMap1.put("quo_name", str4);
    localHashMap1.put("form_id", str3);
    this.log.LOG_INFO("退出getOrderFormAdd方法");
    return localHashMap1;
  }

  public HashMap getFormNameByName(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getFormNameByName方法");
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    TemplateExt localTemplateExt = new TemplateExt();
    localTemplateExt.setParam(":VFORM_ID", paramString1);
    localTemplateExt.setParam(":VCUST_ID", paramString2);
    ArrayList localArrayList = localTemplateExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      if (localHashMap2.get("form_name") != null)
        str1 = localHashMap2.get("form_name").toString();
      if (localHashMap2.get("entity_type") != null)
        str2 = localHashMap2.get("entity_type").toString();
      localHashMap1.put("type", str2);
      localHashMap1.put("name", str1);
    }
    this.log.LOG_INFO("退出getFormNameByName方法");
    return localHashMap1;
  }

  public int getOrderCountByState(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VCUST_ID", paramString1);
    localFormStateExt.setParam(":VSTATE1", paramString2);
    localFormStateExt.setParam(":VSTATE2", paramString3);
    localFormStateExt.setParam(":VSTATE3", paramString4);
    localArrayList = localFormStateExt.selByList("SEL_BY_STATE_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.saleOrderMgr.SaleOrderInfo
 * JD-Core Version:    0.6.0
 */