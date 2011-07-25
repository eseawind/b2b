package com.saas.biz.formStateMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.formStateDAO.FormStateDAO;
import com.saas.biz.dao.formStateDAO.FormStateExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class FormStateInfo
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

  public void addFormStateInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addFormStateInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUO_ID");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    String str4 = paramBuffers.getString("GIVE_DATE");
    String str5 = paramBuffers.getString("STATE_CODE");
    try
    {
      FormStateDAO localFormStateDAO = new FormStateDAO();
      localFormStateDAO.setCust_id(str1);
      localFormStateDAO.setServer_id(str2);
      localFormStateDAO.setState_code(str5);
      localFormStateDAO.setEnd_date(str4);
      localFormStateDAO.setStaff_id(str3);
      i = addFormStateInfo(localFormStateDAO);
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
    this.log.LOG_INFO("退出addFormStateInfo方法...");
  }

  public int addFormStateInfo(FormStateDAO paramFormStateDAO)
    throws SaasApplicationException
  {
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VCUST_ID", paramFormStateDAO.getCust_id());
    localFormStateExt.setParam(":VQUO_ID", paramFormStateDAO.getServer_id());
    localFormStateExt.setParam(":VUSER_ID", paramFormStateDAO.getStaff_id());
    localFormStateExt.setParam(":VSTATE_CODE", paramFormStateDAO.getState_code());
    localFormStateExt.setParam(":VSTATE_RESEAN", "");
    localFormStateExt.setParam(":VEND_DATE", paramFormStateDAO.getEnd_date());
    localFormStateExt.setParam(":VSTART_DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    localFormStateExt.setParam(":VSTATE_CODE_DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    localFormStateExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localFormStateExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateFormStateInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateFormStateInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SALE_QUO_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    String str3 = paramBuffers.getString("SESSION_CUST_ID");
    String str4 = paramBuffers.getString("STATE_CODE");
    String str5 = paramBuffers.getString("BACK_TYPE");
    String str6 = paramBuffers.getString("GIVE_DATE");
    try
    {
      str5 = str5.equals("0") ? "退货" : "换货";
      FormStateDAO localFormStateDAO = new FormStateDAO();
      localFormStateDAO.setServer_id(str1);
      localFormStateDAO.setState_code(str4);
      localFormStateDAO.setStaff_id(str2);
      localFormStateDAO.setEnd_date(str6);
      localFormStateDAO.setCust_id(str3);
      localFormStateDAO.setState_resean(str5);
      i = updateFormStateInfo(localFormStateDAO);
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
    this.log.LOG_INFO("退出addFormStateInfo方法...");
  }

  public int updateFormStateInfo(FormStateDAO paramFormStateDAO)
    throws SaasApplicationException
  {
    FormStateExt localFormStateExt1 = new FormStateExt();
    String str = getStateId(paramFormStateDAO.getServer_id(), paramFormStateDAO.getCust_id());
    localFormStateExt1.setParam(":VQUO_ID", paramFormStateDAO.getServer_id());
    localFormStateExt1.setParam(":VCUST_ID", paramFormStateDAO.getCust_id());
    localFormStateExt1.setParam(":VID", str);
    this.tradeQuery.executeBy(localFormStateExt1.insBy("UPDATE_BY_ALL"));
    FormStateExt localFormStateExt2 = new FormStateExt();
    localFormStateExt2.setParam(":VCUST_ID", paramFormStateDAO.getCust_id());
    localFormStateExt2.setParam(":VQUO_ID", paramFormStateDAO.getServer_id());
    localFormStateExt2.setParam(":VUSER_ID", paramFormStateDAO.getStaff_id());
    localFormStateExt2.setParam(":VSTATE_CODE", paramFormStateDAO.getState_code());
    localFormStateExt2.setParam(":VSTATE_RESEAN", paramFormStateDAO.getState_resean());
    localFormStateExt2.setParam(":VEND_DATE", paramFormStateDAO.getEnd_date());
    localFormStateExt2.setParam(":VSTART_DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    localFormStateExt2.setParam(":VSTATE_CODE_DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    localFormStateExt2.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localFormStateExt2.insBy("INS_BY_ALL"));
    return 0;
  }

  public String getStateId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "1";
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VQUO_ID", paramString1);
    localFormStateExt.setParam(":VCUST_ID", paramString2);
    ArrayList localArrayList = localFormStateExt.selByList("SEL_BY_MAX");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("id") != null)
        str = localHashMap.get("id").toString();
    }
    return str;
  }

  public void updateStateInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateStateInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SALE_QUO_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    String str3 = paramBuffers.getString("SESSION_CUST_ID");
    String str4 = paramBuffers.getString("STATE_CODE");
    String str5 = paramBuffers.getString("STATE_RESEAN");
    String str6 = paramBuffers.getString("END_DATE");
    try
    {
      FormStateDAO localFormStateDAO = new FormStateDAO();
      localFormStateDAO.setServer_id(str1);
      localFormStateDAO.setState_code(str4);
      localFormStateDAO.setStaff_id(str2);
      localFormStateDAO.setEnd_date(str6);
      localFormStateDAO.setCust_id(str3);
      localFormStateDAO.setState_resean(str5);
      i = updateFormStateInfo(localFormStateDAO);
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
    this.log.LOG_INFO("退出updateStateInfo方法...");
  }

  public ArrayList getOrderFormStateList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VCUST_ID", paramString);
    localArrayList = localFormStateExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getOrderFormStateCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VCUST_ID", paramString);
    localArrayList = localFormStateExt.selByList("SEL_BY_CUST_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public void updateBeforeProcur(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateBeforeProcur方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("LINK_QUO_ID");
    try
    {
      i = updateBeforeProcur(str1, str2);
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
    this.log.LOG_INFO("退出updateBeforeProcur方法...");
  }

  public int updateBeforeProcur(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VCUST_ID", paramString1);
    localFormStateExt.setParam(":VQUO_ID", paramString2);
    this.tradeQuery.executeBy(localFormStateExt.insBy("UPDATE_BEFORE_PROCUR"));
    return 0;
  }

  public ArrayList getOrderListById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VCUST_ID", paramString1);
    localFormStateExt.setParam(":VQUO_ID", paramString2);
    localArrayList = localFormStateExt.selByList("SEL_BY_LIST");
    return localArrayList;
  }

  public void delSomeState(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delSomeState方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUO_ID");
    try
    {
      i = delSomeState(str1, str2);
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
    this.log.LOG_INFO("退出delSomeState方法...");
  }

  public int delSomeState(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    FormStateExt localFormStateExt = new FormStateExt();
    localFormStateExt.setParam(":VCUST_ID", paramString1);
    localFormStateExt.setParam(":VQUO_ID", paramString2);
    this.tradeQuery.executeBy(localFormStateExt.insBy("DEL_SOME_STATE"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.formStateMgr.FormStateInfo
 * JD-Core Version:    0.6.0
 */