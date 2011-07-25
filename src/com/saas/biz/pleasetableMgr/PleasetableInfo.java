package com.saas.biz.pleasetableMgr;

import com.saas.biz.commen.ParamethodMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.pleaseresultDAO.PleaseresultExt;
import com.saas.biz.dao.pleasetableDAO.PleasetableDAO;
import com.saas.biz.dao.pleasetableDAO.PleasetableExt;
import com.saas.biz.dao.tableitemDAO.TableitemExt;
import com.saas.biz.organizeMgr.OrganizeInfo;
import com.saas.biz.pleaseItemMgr.PleaseItemInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;

public class PleasetableInfo
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

  public void addPleaseTableInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addPleaseTableInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("RSRV_STR1");
    String str3 = paramBuffers.getString("TABLE_ID");
    String str4 = paramBuffers.getString("TABLE_NAME");
    String str5 = paramBuffers.getString("OWN_PROJECT");
    String str6 = paramBuffers.getString("P_TYPE");
    String str7 = paramBuffers.getString("ITEMS_NAME");
    String str8 = paramBuffers.getString("ITEMS_ID");
    String str9 = paramBuffers.getString("D_VALUE");
    String str10 = paramBuffers.getString("ENABLE_TAG");
    String str11 = paramBuffers.getString("D_CODE");
    String str12 = paramBuffers.getString("START_DATE");
    String str13 = paramBuffers.getString("END_DATE");
    String str14 = paramBuffers.getString("SESSION_USER_ID");
    String str15 = paramBuffers.getString("REMARK2");
    try
    {
      PleasetableDAO localPleasetableDAO = new PleasetableDAO();
      localPleasetableDAO.setCust_id(str1);
      localPleasetableDAO.setRsrv_str1(str2);
      localPleasetableDAO.setTable_id(str3);
      localPleasetableDAO.setTable_name(str4);
      localPleasetableDAO.setOwn_project(str5);
      localPleasetableDAO.setP_type(str6);
      localPleasetableDAO.setItems_id(str8);
      localPleasetableDAO.setD_value(str9);
      localPleasetableDAO.setItems_name(str7);
      localPleasetableDAO.setEnable_tag(str10);
      localPleasetableDAO.setDepart_code(str11);
      localPleasetableDAO.setStart_date(str12);
      localPleasetableDAO.setEnd_date(str13);
      localPleasetableDAO.setOper_user_id(str14);
      localPleasetableDAO.setRemark2(str15);
      i = addPleaseTableInfo(localPleasetableDAO);
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
    this.log.LOG_INFO("退出addPleaseTableInfo方法...");
  }

  public int addPleaseTableInfo(PleasetableDAO paramPleasetableDAO)
    throws SaasApplicationException
  {
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramPleasetableDAO.getCust_id());
    localPleasetableExt.setParam(":VRSRV_STR1", paramPleasetableDAO.getRsrv_str1());
    localPleasetableExt.setParam(":VTABLE_ID", paramPleasetableDAO.getTable_id());
    localPleasetableExt.setParam(":VTABLE_NAME", paramPleasetableDAO.getTable_name());
    localPleasetableExt.setParam(":VOWN_PROJECT", paramPleasetableDAO.getOwn_project());
    localPleasetableExt.setParam(":VP_TYPE", paramPleasetableDAO.getP_type());
    localPleasetableExt.setParam(":VITEMS_ID", paramPleasetableDAO.getItems_id());
    localPleasetableExt.setParam(":VD_VALUE", paramPleasetableDAO.getD_value());
    localPleasetableExt.setParam(":VITEMS_NAME", paramPleasetableDAO.getItems_name());
    localPleasetableExt.setParam(":VENABLE_TAG", paramPleasetableDAO.getEnable_tag());
    localPleasetableExt.setParam(":VDEPART_CODE", paramPleasetableDAO.getDepart_code());
    localPleasetableExt.setParam(":VSTART_DATE", paramPleasetableDAO.getStart_date());
    localPleasetableExt.setParam(":VEND_DATE", paramPleasetableDAO.getEnd_date());
    localPleasetableExt.setParam(":VOPER_USER_ID", paramPleasetableDAO.getOper_user_id());
    localPleasetableExt.setParam(":VREMARK2", paramPleasetableDAO.getRemark2());
    this.tradeQuery.executeBy(localPleasetableExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void deleteTableInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteTableInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("TABLE_ID");
    try
    {
      i = deleteTableInfo(str1, str2);
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
    this.log.LOG_INFO("退出deleteTableInfo方法...");
  }

  public int deleteTableInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramString1);
    localPleasetableExt.setParam(":VTABLE_ID", paramString2);
    TableitemExt localTableitemExt = new TableitemExt();
    localTableitemExt.setParam(":VCUST_ID", paramString1);
    localTableitemExt.setParam(":VTABLE_ID", paramString2);
    PleaseresultExt localPleaseresultExt = new PleaseresultExt();
    localPleaseresultExt.setParam(":VCUST_ID", paramString1);
    localPleaseresultExt.setParam(":VTABLE_ID", paramString2);
    this.tradeQuery.executeBy(localPleasetableExt.insBy("DEL_BY_TABLE"));
    this.tradeQuery.executeBy(localTableitemExt.insBy("DEL_BY_TABLE"));
    this.tradeQuery.executeBy(localPleaseresultExt.insBy("DEL_BY_TABLE"));
    return 0;
  }

  public ArrayList getPleaseByCust_id(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramString1);
    localPleasetableExt.setParam(":VENABLE_TAG", paramString2);
    ArrayList localArrayList = localPleasetableExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList getPleasePageByCust_id(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramString);
    localPleasetableExt.setParam(":VENABLE_TAG", "0");
    ArrayList localArrayList = localPleasetableExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getPageSize(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramString);
    localPleasetableExt.setParam(":VENABLE_TAG", "0");
    ArrayList localArrayList = localPleasetableExt.selByList("SEL_BY_CUST_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public Map<String, String> getPleasesByCust_id(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramString1);
    localPleasetableExt.setParam(":VENABLE_TAG", paramString2);
    ArrayList localArrayList = localPleasetableExt.selByList("SEL_BY_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(0);
        String str1 = localHashMap2.get("table_id").toString();
        String str2 = localHashMap2.get("table_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public Map<String, String> getPleasesByTableId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = getPleaseByTableId(paramString1, paramString2, paramString3);
    this.log.LOG_INFO("==" + localArrayList);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      String str1 = "";
      if (localHashMap2.get("table_id") != null)
      {
        str1 = localHashMap2.get("table_id").toString();
        localHashMap1.put("table_id", str1);
      }
      String str2 = "";
      if (localHashMap2.get("table_name") != null)
      {
        str2 = localHashMap2.get("table_name").toString();
        localHashMap1.put("table_name", str2);
      }
      String str3 = "";
      if (localHashMap2.get("own_project") != null)
      {
        str3 = localHashMap2.get("own_project").toString();
        localHashMap1.put("own_project", str3);
      }
      String str4 = "";
      String str5 = "";
      if (localHashMap2.get("p_type") != null)
      {
        str4 = localHashMap2.get("p_type").toString();
        HashMap localObject1 = new ParamethodMgr().getCompareInfoByCode("CRM", "p_type");
        if ((localObject1 != null) && (((HashMap)localObject1).size() > 0) && (((HashMap)localObject1).get(str4) != null))
          str5 = ((HashMap)localObject1).get(str4).toString();
        localHashMap1.put("p_type", str4);
        localHashMap1.put("type_name", str5);
      }
      Object localObject1 = "";
      if (localHashMap2.get("d_value") != null)
      {
        localObject1 = localHashMap2.get("d_value").toString();
        localHashMap1.put("d_value", localObject1);
      }
      String str6 = "";
      if (localHashMap2.get("enable_tag") != null)
      {
        str6 = localHashMap2.get("enable_tag").toString();
        localHashMap1.put("enable_tag", str6);
      }
      String str7 = "";
      String str8 = "";
      if (localHashMap2.get("depart_code") != null)
      {
        str7 = localHashMap2.get("depart_code").toString();
        HashMap localObject2 = new OrganizeInfo().getOrganizeByOrgId(str7);
        if ((localObject2 != null) && (((Map)localObject2).size() > 0) && (((Map)localObject2).get("org_name") != null))
          str8 = ((Map)localObject2).get("org_name").toString();
        localHashMap1.put("depart_code", str7);
        localHashMap1.put("depart_name", str8);
      }
      Object localObject2 = "";
      if (localHashMap2.get("start_date") != null)
      {
        localObject2 = localHashMap2.get("start_date").toString();
        if (((String)localObject2).length() > 10)
          localObject2 = ((String)localObject2).substring(0, 10);
        localHashMap1.put("start_date", localObject2);
      }
      String str9 = "";
      if (localHashMap2.get("end_date") != null)
      {
        str9 = localHashMap2.get("end_date").toString();
        if (str9.length() > 10)
          str9 = str9.substring(0, 10);
        localHashMap1.put("end_date", str9);
      }
    }
    this.log.LOG_INFO("--" + localHashMap1);
    return (Map<String, String>)(Map<String, String>)localHashMap1;
  }

  public ArrayList getPleaseByTableId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramString1);
    localPleasetableExt.setParam(":VTABLE_ID", paramString2);
    localPleasetableExt.setParam(":VENABLE_TAG", paramString3);
    ArrayList localArrayList = localPleasetableExt.selByList("SEL_BY_TABLE_ID");
    return localArrayList;
  }

  public Map<String, String> getImtemsByTable_id(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    try
    {
      PleasetableExt localPleasetableExt = new PleasetableExt();
      localPleasetableExt.setParam(":VCUST_ID", paramString1);
      localPleasetableExt.setParam(":VTABLE_ID", paramString2);
      localPleasetableExt.setParam(":VENABLE_TAG", paramString3);
      ArrayList localArrayList = localPleasetableExt.selByList("SEL_BY_ITEMS");
      if ((localArrayList != null) && (localArrayList.size() > 0))
        for (int i = 0; i < localArrayList.size(); i++)
        {
          HashMap localHashMap2 = (HashMap)localArrayList.get(i);
          String str1 = localHashMap2.get("items_id").toString();
          String str2 = localHashMap2.get("items_name").toString();
          localHashMap1.put(str1, str2);
        }
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localHashMap1;
  }

  public ArrayList getPleaseByTableName(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramString1);
    localPleasetableExt.setParam(":VTABLE_NAME", paramString2);
    localPleasetableExt.setParam(":VENABLE_TAG", paramString3);
    ArrayList localArrayList = localPleasetableExt.selByList("SEL_BY_TABLE_NAME");
    return localArrayList;
  }

  public Map<HashMap, ArrayList> getTableAndItemsById(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramString1);
    localPleasetableExt.setParam(":VTABLE_ID", paramString2);
    localPleasetableExt.setParam(":VENABLE_TAG", paramString3);
    ArrayList localArrayList1 = localPleasetableExt.selByList("SEL_BY_ITEMS");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList1.get(i);
        String str = localHashMap2.get("items_id").toString();
        ArrayList localArrayList2 = new PleaseItemInfo().getPleaseItemByItems(paramString2, str, paramString3);
        localHashMap1.put(localHashMap2, localArrayList2);
      }
    return localHashMap1;
  }

  public String getTypeByItems(String paramString1, String paramString2)
  {
    String str = "0";
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VITEMS_ID", paramString2);
    localPleasetableExt.setParam(":VTABLE_ID", paramString1);
    ArrayList localArrayList = localPleasetableExt.selByList("SEL_BY_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("rsrv_str1") != null)
        str = localHashMap.get("rsrv_str1").toString();
    }
    return str;
  }

  public HashMap getItemsName(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    PleasetableExt localPleasetableExt = new PleasetableExt();
    localPleasetableExt.setParam(":VCUST_ID", paramString2);
    localPleasetableExt.setParam(":VTABLE_ID", paramString1);
    localPleasetableExt.setParam(":VENABLE_TAG", "0");
    ArrayList localArrayList = localPleasetableExt.selByList("SEL_BY_ITEMS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = "";
        String str2 = "";
        if (localHashMap2.get("items_name") != null)
          str2 = localHashMap2.get("items_name").toString();
        if (localHashMap2.get("items_id") != null)
          str1 = localHashMap2.get("items_id").toString();
        if ((str1 == null) || (str1.equals("")) || (str2 == null) || (str2.equals("")))
          continue;
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.pleasetableMgr.PleasetableInfo
 * JD-Core Version:    0.6.0
 */