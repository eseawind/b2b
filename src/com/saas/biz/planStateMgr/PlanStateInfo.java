package com.saas.biz.planStateMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.planStateDAO.PlanStateDAO;
import com.saas.biz.dao.planStateDAO.PlanStateExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PlanStateInfo
  implements Serializable
{
  private static final long serialVersionUID = -445596947327132342L;
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  String sys_Date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  ArrayList queryResult = new ArrayList();
  commMethodMgr comm = new commMethodMgr();

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

  public void addPlanStateInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入AddPlanStateInfo方法...");
    String str1 = this.comm.GenTradeId();
    String str2 = paramBuffers.getString("PLAN_ID");
    String str3 = paramBuffers.getString("SESSION_CUST_ID");
    String str4 = paramBuffers.getString("PLAN_STATE");
    String str5 = paramBuffers.getString("START_DATE");
    String str6 = paramBuffers.getString("END_DATE");
    String str7 = this.sys_Date;
    String str8 = paramBuffers.getString("STATE_RESEAN");
    String str9 = paramBuffers.getString("RSRV_STR1");
    String str10 = paramBuffers.getString("RSRV_STR2");
    String str11 = paramBuffers.getString("RSRV_STR3");
    String str12 = paramBuffers.getString("RSRV_STR4");
    String str13 = paramBuffers.getString("RSRV_STR5");
    String str14 = paramBuffers.getString("RSRV_STR6");
    String str15 = paramBuffers.getString("RSRV_STR7");
    String str16 = paramBuffers.getString("RSRV_STR8");
    String str17 = paramBuffers.getString("RSRV_STR9");
    String str18 = paramBuffers.getString("RSRV_STR10");
    String str19 = this.sys_Date;
    String str20 = paramBuffers.getString("SESSION_USER_ID");
    String str21 = paramBuffers.getString("REMARK");
    int i = -1;
    try
    {
      PlanStateDAO localPlanStateDAO = new PlanStateDAO();
      localPlanStateDAO.setTrade_id(str1);
      localPlanStateDAO.setCust_id(str3);
      localPlanStateDAO.setPlan_id(str2);
      localPlanStateDAO.setPlan_state(str4);
      localPlanStateDAO.setStart_date(str5);
      localPlanStateDAO.setEnd_date(str6);
      localPlanStateDAO.setState_code_date(str7);
      localPlanStateDAO.setState_resean(str8);
      localPlanStateDAO.setRsrv_str1(str9);
      localPlanStateDAO.setRsrv_str2(str10);
      localPlanStateDAO.setRsrv_str3(str11);
      localPlanStateDAO.setRsrv_str4(str12);
      localPlanStateDAO.setRsrv_str5(str13);
      localPlanStateDAO.setRsrv_str6(str14);
      localPlanStateDAO.setRsrv_str7(str15);
      localPlanStateDAO.setRsrv_str8(str16);
      localPlanStateDAO.setRsrv_str9(str17);
      localPlanStateDAO.setRsrv_str10(str18);
      localPlanStateDAO.setUser_id(str20);
      localPlanStateDAO.setOper_date(str19);
      localPlanStateDAO.setRemark(str21);
      i = addPlanStateInfo(localPlanStateDAO);
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
    this.log.LOG_INFO("退出AddPlanStateInfo方法...");
  }

  public int addPlanStateInfo(PlanStateDAO paramPlanStateDAO)
  {
    PlanStateExt localPlanStateExt = new PlanStateExt();
    localPlanStateExt.setParam(":VCUST_ID", paramPlanStateDAO.getCust_id());
    localPlanStateExt.setParam(":VTRADE_ID", paramPlanStateDAO.getTrade_id());
    localPlanStateExt.setParam(":VPLAN_ID", paramPlanStateDAO.getPlan_id());
    localPlanStateExt.setParam(":VPLAN_STATE", paramPlanStateDAO.getPlan_state());
    localPlanStateExt.setParam(":VSTART_DATE", paramPlanStateDAO.getStart_date());
    localPlanStateExt.setParam(":VEND_DATE", paramPlanStateDAO.getEnd_date());
    localPlanStateExt.setParam(":VSTATE_CODE_DATE", paramPlanStateDAO.getState_code_date());
    localPlanStateExt.setParam(":VSTATE_RESEAN", paramPlanStateDAO.getState_resean());
    localPlanStateExt.setParam(":VRSRV_STR1", paramPlanStateDAO.getRsrv_str1());
    localPlanStateExt.setParam(":VRSRV_STR2", paramPlanStateDAO.getRsrv_str2());
    localPlanStateExt.setParam(":VRSRV_STR3", paramPlanStateDAO.getRsrv_str3());
    localPlanStateExt.setParam(":VRSRV_STR4", paramPlanStateDAO.getRsrv_str4());
    localPlanStateExt.setParam(":VRSRV_STR5", paramPlanStateDAO.getRsrv_str5());
    localPlanStateExt.setParam(":VRSRV_STR6", paramPlanStateDAO.getRsrv_str6());
    localPlanStateExt.setParam(":VRSRV_STR7", paramPlanStateDAO.getRsrv_str7());
    localPlanStateExt.setParam(":VRSRV_STR8", paramPlanStateDAO.getRsrv_str8());
    localPlanStateExt.setParam(":VRSRV_STR9", paramPlanStateDAO.getRsrv_str9());
    localPlanStateExt.setParam(":VRSRV_STR10", paramPlanStateDAO.getRsrv_str10());
    localPlanStateExt.setParam(":VUSER_ID", paramPlanStateDAO.getUser_id());
    localPlanStateExt.setParam(":VREMARK", paramPlanStateDAO.getRemark());
    localPlanStateExt.setParam(":VOPER_DATE", paramPlanStateDAO.getOper_date());
    this.tradeQuery.executeBy(localPlanStateExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void eidtPlanStateInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入eidtPlanStateInfo方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PLAN_ID");
    String str3 = paramBuffers.getString("PLAN_STATE");
    String str4 = paramBuffers.getString("STATE_RESEAN");
    String str5 = paramBuffers.getString("SESSION_USER_ID");
    String str6 = paramBuffers.getString("REMARK");
    int i = -1;
    try
    {
      PlanStateDAO localPlanStateDAO = new PlanStateDAO();
      localPlanStateDAO.setCust_id(str1);
      localPlanStateDAO.setPlan_id(str2);
      localPlanStateDAO.setPlan_state(str3);
      localPlanStateDAO.setUser_id(str5);
      localPlanStateDAO.setState_resean(str4);
      localPlanStateDAO.setRemark(str6);
      i = eidtPlanStateInfo(localPlanStateDAO);
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
    this.log.LOG_INFO("退出eidtPlanStateInfo方法...");
  }

  public int eidtPlanStateInfo(PlanStateDAO paramPlanStateDAO)
    throws SaasApplicationException
  {
    PlanStateExt localPlanStateExt = new PlanStateExt();
    localPlanStateExt.setParam(":VCUST_ID", paramPlanStateDAO.getCust_id());
    localPlanStateExt.setParam(":VPLAN_ID", paramPlanStateDAO.getPlan_id());
    localPlanStateExt.setParam(":VPLAN_STATE", paramPlanStateDAO.getPlan_state());
    localPlanStateExt.setParam(":VUSER_ID", paramPlanStateDAO.getUser_id());
    localPlanStateExt.setParam(":VSTATE_RESEAN", paramPlanStateDAO.getState_resean());
    localPlanStateExt.setParam(":VREMARK", paramPlanStateDAO.getRemark());
    this.tradeQuery.executeBy(localPlanStateExt.insBy("EDIT_BY_ALL"));
    return 0;
  }

  public void deletePlanStateInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deletePlanStateInfo方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PLAN_ID");
    int i = -1;
    try
    {
      PlanStateDAO localPlanStateDAO = new PlanStateDAO();
      localPlanStateDAO.setCust_id(str1);
      localPlanStateDAO.setPlan_id(str2);
      i = deletePlanStateInfo(localPlanStateDAO);
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
    this.log.LOG_INFO("退出deletePlanStateInfo方法...");
  }

  public int deletePlanStateInfo(PlanStateDAO paramPlanStateDAO)
    throws SaasApplicationException
  {
    PlanStateExt localPlanStateExt = new PlanStateExt();
    localPlanStateExt.setParam(":VCUST_ID", paramPlanStateDAO.getCust_id());
    localPlanStateExt.setParam(":VPLAN_ID", paramPlanStateDAO.getPlan_id());
    this.tradeQuery.executeBy(localPlanStateExt.insBy("DEL_BY_ALL"));
    return 0;
  }

  public void updatePlanState(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updatePlanState方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PLAN_ID");
    String str2 = paramBuffers.getString("PLAN_STATE");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    String str4 = paramBuffers.getString("STATE_RESEAN");
    try
    {
      i = updatePlanState(str1, str2, str3, str4);
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
    PlanStateExt localPlanStateExt = new PlanStateExt();
    localPlanStateExt.setParam(":VPLAN_ID", paramString1);
    localPlanStateExt.setParam(":VPLAN_STATE", paramString2);
    localPlanStateExt.setParam(":VOPER_USER_ID", paramString3);
    localPlanStateExt.setParam(":VSTATE_RESEAN", paramString4);
    this.tradeQuery.executeBy(localPlanStateExt.insBy("UPDATE_BY_STATE"));
    this.tradeQuery.executeBy(localPlanStateExt.insBy("INS_BY_STATE"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.planStateMgr.PlanStateInfo
 * JD-Core Version:    0.6.0
 */