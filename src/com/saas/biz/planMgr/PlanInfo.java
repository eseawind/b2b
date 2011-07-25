package com.saas.biz.planMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.planDAO.PlanDAO;
import com.saas.biz.dao.planDAO.PlanExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PlanInfo
  implements Serializable
{
  private static final long serialVersionUID = -445596947327132342L;
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

  public void addPlanInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addPlanInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PLAN_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("DEPART_ID");
    String str4 = paramBuffers.getString("PLANNER_ID");
    String str5 = paramBuffers.getString("PLANNER_NAME");
    String str6 = paramBuffers.getString("TITLE");
    String str7 = paramBuffers.getString("CONTENT");
    String str8 = paramBuffers.getString("START_DATE");
    String str9 = paramBuffers.getString("END_DATE");
    String str10 = paramBuffers.getString("PRIORITYS");
    String str11 = paramBuffers.getString("SECURITY");
    String str12 = paramBuffers.getString("RSRV_STR1");
    String str13 = paramBuffers.getString("RSRV_STR2");
    String str14 = paramBuffers.getString("RSRV_STR3");
    String str15 = paramBuffers.getString("RSRV_STR4");
    String str16 = paramBuffers.getString("RSRV_STR5");
    String str17 = paramBuffers.getString("RSRV_STR6");
    String str18 = paramBuffers.getString("RSRV_STR7");
    String str19 = paramBuffers.getString("RSRV_STR8");
    String str20 = paramBuffers.getString("RSRV_STR9");
    String str21 = paramBuffers.getString("RSRV_STR10");
    String str22 = paramBuffers.getString("PLAN_STATE");
    String str23 = paramBuffers.getString("PLAN_TYPE");
    String str24 = paramBuffers.getString("REMARK");
    String str25 = paramBuffers.getString("PLAN_CLASS");
    String str26 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      PlanDAO localPlanDAO = new PlanDAO();
      localPlanDAO.setPlan_id(str1);
      localPlanDAO.setCust_id(str2);
      localPlanDAO.setDepart_code(str3);
      localPlanDAO.setPlanner_id(str4);
      localPlanDAO.setPlanner_name(str5);
      localPlanDAO.setTitle(str6);
      localPlanDAO.setStart_date(str8);
      localPlanDAO.setEnd_date(str9);
      localPlanDAO.setPrioritys(str10);
      localPlanDAO.setSecurity(str11);
      localPlanDAO.setContent(str7);
      localPlanDAO.setPlan_type(str23);
      localPlanDAO.setPlan_class(str25);
      localPlanDAO.setRsrv_str1(str12);
      localPlanDAO.setRsrv_str2(str13);
      localPlanDAO.setRsrv_str3(str14);
      localPlanDAO.setRsrv_str4(str15);
      localPlanDAO.setRsrv_str5(str16);
      localPlanDAO.setRsrv_str6(str17);
      localPlanDAO.setRsrv_str7(str18);
      localPlanDAO.setRsrv_str8(str19);
      localPlanDAO.setRsrv_str9(str20);
      localPlanDAO.setRsrv_str10(str21);
      localPlanDAO.setPlan_state(str22);
      localPlanDAO.setRemark(str24);
      localPlanDAO.setOper_user_id(str26);
      i = addPlanInfo(localPlanDAO);
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
    this.log.LOG_INFO("退出addPlanInfo方法...");
  }

  public int addPlanInfo(PlanDAO paramPlanDAO)
    throws SaasApplicationException
  {
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VPLAN_ID", paramPlanDAO.getPlan_id());
    localPlanExt.setParam(":VCUST_ID", paramPlanDAO.getCust_id());
    localPlanExt.setParam(":VDEPART_CODE", paramPlanDAO.getDepart_code());
    localPlanExt.setParam(":VPLANNER_ID", paramPlanDAO.getPlanner_id());
    localPlanExt.setParam(":VPLANNER_NAME", paramPlanDAO.getPlanner_name());
    localPlanExt.setParam(":VTITLE", paramPlanDAO.getTitle());
    localPlanExt.setParam(":VSTART_DATE", paramPlanDAO.getStart_date());
    localPlanExt.setParam(":VEND_DATE", paramPlanDAO.getEnd_date());
    localPlanExt.setParam(":VPRIORITYS", paramPlanDAO.getPrioritys());
    localPlanExt.setParam(":VSECURITY", paramPlanDAO.getSecurity());
    localPlanExt.setParam(":VCONTENT", paramPlanDAO.getContent());
    localPlanExt.setParam(":VPLAN_CLASS", paramPlanDAO.getPlan_class());
    localPlanExt.setParam(":VRSRV_STR1", paramPlanDAO.getRsrv_str1());
    localPlanExt.setParam(":VRSRV_STR2", paramPlanDAO.getRsrv_str2());
    localPlanExt.setParam(":VRSRV_STR3", paramPlanDAO.getRsrv_str3());
    localPlanExt.setParam(":VRSRV_STR4", paramPlanDAO.getRsrv_str4());
    localPlanExt.setParam(":VRSRV_STR5", paramPlanDAO.getRsrv_str5());
    localPlanExt.setParam(":VPLAN_TYPE", paramPlanDAO.getPlan_type());
    localPlanExt.setParam(":VRSRV_STR6", paramPlanDAO.getRsrv_str6());
    localPlanExt.setParam(":VRSRV_STR7", paramPlanDAO.getRsrv_str7());
    localPlanExt.setParam(":VRSRV_STR8", paramPlanDAO.getRsrv_str8());
    localPlanExt.setParam(":VRSRV_STR9", paramPlanDAO.getRsrv_str9());
    localPlanExt.setParam(":VRSRV_STR10", paramPlanDAO.getRsrv_str10());
    localPlanExt.setParam(":VREMARK", paramPlanDAO.getRemark());
    localPlanExt.setParam(":VPLAN_STATE", paramPlanDAO.getPlan_state());
    localPlanExt.setParam(":VOPER_USER_ID", paramPlanDAO.getOper_user_id());
    this.tradeQuery.executeBy(localPlanExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void eidPlanInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入eidPlanInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PLAN_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("DEPART_ID");
    String str4 = paramBuffers.getString("PLANNER_ID");
    String str5 = paramBuffers.getString("PLANNER_NAME");
    String str6 = paramBuffers.getString("TITLE");
    String str7 = paramBuffers.getString("CONTENT");
    String str8 = paramBuffers.getString("START_DATE");
    String str9 = paramBuffers.getString("END_DATE");
    String str10 = paramBuffers.getString("PRIORITYS");
    String str11 = paramBuffers.getString("SECURITY");
    String str12 = paramBuffers.getString("RSRV_STR1");
    String str13 = paramBuffers.getString("RSRV_STR2");
    String str14 = paramBuffers.getString("RSRV_STR3");
    String str15 = paramBuffers.getString("RSRV_STR4");
    String str16 = paramBuffers.getString("RSRV_STR5");
    String str17 = paramBuffers.getString("RSRV_STR6");
    String str18 = paramBuffers.getString("RSRV_STR7");
    String str19 = paramBuffers.getString("RSRV_STR8");
    String str20 = paramBuffers.getString("RSRV_STR9");
    String str21 = paramBuffers.getString("RSRV_STR10");
    String str22 = paramBuffers.getString("PLAN_STATE");
    String str23 = paramBuffers.getString("PLAN_TYPE");
    String str24 = paramBuffers.getString("REMARK");
    String str25 = paramBuffers.getString("PLAN_CLASS");
    String str26 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      PlanDAO localPlanDAO = new PlanDAO();
      localPlanDAO.setPlan_id(str1);
      localPlanDAO.setCust_id(str2);
      localPlanDAO.setDepart_code(str3);
      localPlanDAO.setPlanner_id(str4);
      localPlanDAO.setPlanner_name(str5);
      localPlanDAO.setTitle(str6);
      localPlanDAO.setStart_date(str8);
      localPlanDAO.setEnd_date(str9);
      localPlanDAO.setPrioritys(str10);
      localPlanDAO.setSecurity(str11);
      localPlanDAO.setContent(str7);
      localPlanDAO.setPlan_type(str23);
      localPlanDAO.setPlan_class(str25);
      localPlanDAO.setRsrv_str1(str12);
      localPlanDAO.setRsrv_str2(str13);
      localPlanDAO.setRsrv_str3(str14);
      localPlanDAO.setRsrv_str4(str15);
      localPlanDAO.setRsrv_str5(str16);
      localPlanDAO.setRsrv_str6(str17);
      localPlanDAO.setRsrv_str7(str18);
      localPlanDAO.setRsrv_str8(str19);
      localPlanDAO.setRsrv_str9(str20);
      localPlanDAO.setRsrv_str10(str21);
      localPlanDAO.setPlan_state(str22);
      localPlanDAO.setRemark(str24);
      localPlanDAO.setOper_user_id(str26);
      i = eidPlanInfo(localPlanDAO);
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
    this.log.LOG_INFO("退出eidPlanInfo方法...");
  }

  public int eidPlanInfo(PlanDAO paramPlanDAO)
    throws SaasApplicationException
  {
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VPLAN_ID", paramPlanDAO.getPlan_id());
    localPlanExt.setParam(":VCUST_ID", paramPlanDAO.getCust_id());
    localPlanExt.setParam(":VDEPART_CODE", paramPlanDAO.getDepart_code());
    localPlanExt.setParam(":VPLANNER_ID", paramPlanDAO.getPlanner_id());
    localPlanExt.setParam(":VPLANNER_NAME", paramPlanDAO.getPlanner_name());
    localPlanExt.setParam(":VTITLE", paramPlanDAO.getTitle());
    localPlanExt.setParam(":VSTART_DATE", paramPlanDAO.getStart_date());
    localPlanExt.setParam(":VEND_DATE", paramPlanDAO.getEnd_date());
    localPlanExt.setParam(":VPRIORITYS", paramPlanDAO.getPrioritys());
    localPlanExt.setParam(":VSECURITY", paramPlanDAO.getSecurity());
    localPlanExt.setParam(":VCONTENT", paramPlanDAO.getContent());
    localPlanExt.setParam(":VPLAN_CLASS", paramPlanDAO.getPlan_class());
    localPlanExt.setParam(":VRSRV_STR1", paramPlanDAO.getRsrv_str1());
    localPlanExt.setParam(":VRSRV_STR2", paramPlanDAO.getRsrv_str2());
    localPlanExt.setParam(":VRSRV_STR3", paramPlanDAO.getRsrv_str3());
    localPlanExt.setParam(":VRSRV_STR4", paramPlanDAO.getRsrv_str4());
    localPlanExt.setParam(":VRSRV_STR5", paramPlanDAO.getRsrv_str5());
    localPlanExt.setParam(":VPLAN_TYPE", paramPlanDAO.getPlan_type());
    localPlanExt.setParam(":VRSRV_STR6", paramPlanDAO.getRsrv_str6());
    localPlanExt.setParam(":VRSRV_STR7", paramPlanDAO.getRsrv_str7());
    localPlanExt.setParam(":VRSRV_STR8", paramPlanDAO.getRsrv_str8());
    localPlanExt.setParam(":VRSRV_STR9", paramPlanDAO.getRsrv_str9());
    localPlanExt.setParam(":VRSRV_STR10", paramPlanDAO.getRsrv_str10());
    localPlanExt.setParam(":VREMARK", paramPlanDAO.getRemark());
    localPlanExt.setParam(":VPLAN_STATE", paramPlanDAO.getPlan_state());
    localPlanExt.setParam(":VOPER_USER_ID", paramPlanDAO.getOper_user_id());
    this.tradeQuery.executeBy(localPlanExt.insBy("EDIT_BY_ALL"));
    return 0;
  }

  public void deletePlanInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deletePlanInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PLAN_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      PlanDAO localPlanDAO = new PlanDAO();
      localPlanDAO.setPlan_id(str1);
      localPlanDAO.setCust_id(str2);
      localPlanDAO.setOper_user_id(str3);
      i = deletePlanInfo(localPlanDAO);
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
    this.log.LOG_INFO("退出deletePlanInfo方法...");
  }

  public int deletePlanInfo(PlanDAO paramPlanDAO)
    throws SaasApplicationException
  {
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VPLAN_ID", paramPlanDAO.getPlan_id());
    localPlanExt.setParam(":VCUST_ID", paramPlanDAO.getCust_id());
    localPlanExt.setParam(":VOPER_USER_ID", paramPlanDAO.getOper_user_id());
    this.tradeQuery.executeBy(localPlanExt.insBy("DEL_BY_ALL"));
    return 0;
  }

  public ArrayList getPlanListByState(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    paramInt *= 20;
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VOPER_USER_ID", paramString1);
    localPlanExt.setParam(":VSTATE1", paramString2);
    localPlanExt.setParam(":VSTATE2", paramString3);
    localPlanExt.setParam(":VSTATE3", paramString4);
    ArrayList localArrayList = localPlanExt.selByList("SEL_REGECT_NEW", paramInt, 20);
    return localArrayList;
  }

  public int getPlanCountByState(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    int i = 0;
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VOPER_USER_ID", paramString1);
    localPlanExt.setParam(":VSTATE1", paramString2);
    localPlanExt.setParam(":VSTATE2", paramString3);
    localPlanExt.setParam(":VSTATE3", paramString4);
    ArrayList localArrayList = localPlanExt.selByList("SEL_REGECT_NEW_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getPlanListByOwn(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VOPER_USER_ID", paramString);
    ArrayList localArrayList = localPlanExt.selByList("SEL_PLNA_OWN", paramInt, 20);
    return localArrayList;
  }

  public int getPlanCountByOwn(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VOPER_USER_ID", paramString);
    ArrayList localArrayList = localPlanExt.selByList("SEL_PLAN_BY_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public void updatePlanState(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updatePlanState方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    String str3 = paramBuffers.getString("PLAN_ID");
    String str4 = paramBuffers.getString("PLAN_STATE");
    try
    {
      i = updatePlanState(str3, str4, str1, str2);
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
    this.log.LOG_INFO("退出updatePlanState方法...");
  }

  public int updatePlanState(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VPLAN_ID", paramString1);
    localPlanExt.setParam(":VPLAN_STATE", paramString2);
    localPlanExt.setParam(":VCUST_ID", paramString3);
    localPlanExt.setParam(":VOPER_USER_ID", paramString4);
    this.tradeQuery.executeBy(localPlanExt.insBy("UPDATE_BY_STATE"));
    return 0;
  }

  public HashMap getPlanInfoById(String paramString)
    throws SaasApplicationException
  {
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VPLAN_ID", paramString);
    ArrayList localArrayList = localPlanExt.selByList("SEL_BY_ID");
    HashMap localHashMap = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getPlanByAudit(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VDEPART", paramString1);
    localPlanExt.setParam(":VPLAN_STATE", paramString2);
    ArrayList localArrayList = localPlanExt.selByList("SEL_BY_DEPART", paramInt, 20);
    return localArrayList;
  }

  public int getPlanByAuditCt(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    PlanExt localPlanExt = new PlanExt();
    localPlanExt.setParam(":VDEPART", paramString1);
    localPlanExt.setParam(":VPLAN_STATE", paramString2);
    ArrayList localArrayList = localPlanExt.selByList("SEL_DEPART_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.planMgr.PlanInfo
 * JD-Core Version:    0.6.0
 */