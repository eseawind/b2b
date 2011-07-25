package com.saas.biz.cmdStateMgr;

import com.saas.biz.dao.cmdStateDAO.CmdStateDAO;
import com.saas.biz.dao.cmdStateDAO.CmdStateExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class CmdStateInfo
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

  public void addCmdInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCmdInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CMD_ID");
    String str3 = paramBuffers.getString("STATE_CODE");
    String str4 = paramBuffers.getString("START_DATE");
    String str5 = paramBuffers.getString("END_DATE");
    String str6 = paramBuffers.getString("STATE_CODE_DATE");
    String str7 = paramBuffers.getString("STATE_RESEAN");
    String str8 = paramBuffers.getString("NOW_ADDR");
    String str9 = paramBuffers.getString("OPER_DATE");
    String str10 = paramBuffers.getString("SESSION_USER_ID");
    String str11 = paramBuffers.getString("REMARK");
    try
    {
      CmdStateDAO localCmdStateDAO = new CmdStateDAO();
      localCmdStateDAO.setCust_id(str1);
      localCmdStateDAO.setCmd_id(str2);
      localCmdStateDAO.setState_code(str3);
      localCmdStateDAO.setStart_date(str4);
      localCmdStateDAO.setEnd_date(str5);
      localCmdStateDAO.setState_code_date(str6);
      localCmdStateDAO.setState_resean(str7);
      localCmdStateDAO.setNow_addr(str8);
      localCmdStateDAO.setOper_date(str9);
      localCmdStateDAO.setUser_id(str10);
      localCmdStateDAO.setRemark(str11);
      i = addCmdInfo(localCmdStateDAO);
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
    this.log.LOG_INFO("退出addCmdInfo方法...");
  }

  public int addCmdInfo(CmdStateDAO paramCmdStateDAO)
    throws SaasApplicationException
  {
    CmdStateExt localCmdStateExt = new CmdStateExt();
    localCmdStateExt.setParam(":VCUST_ID", paramCmdStateDAO.getCust_id());
    localCmdStateExt.setParam(":VCMD_ID", paramCmdStateDAO.getCmd_id());
    localCmdStateExt.setParam(":VSTATE_CODE", paramCmdStateDAO.getState_code());
    localCmdStateExt.setParam(":VSTART_DATE", paramCmdStateDAO.getStart_date());
    localCmdStateExt.setParam(":VEND_DATE", paramCmdStateDAO.getEnd_date());
    localCmdStateExt.setParam(":VSTATE_CODE_DATE", paramCmdStateDAO.getState_code_date());
    localCmdStateExt.setParam(":VSTATE_RESEAN", paramCmdStateDAO.getState_resean());
    localCmdStateExt.setParam(":VNOW_ADDR", paramCmdStateDAO.getNow_addr());
    localCmdStateExt.setParam(":VOPER_DATE", paramCmdStateDAO.getOper_date());
    localCmdStateExt.setParam(":VUSER_ID", paramCmdStateDAO.getUser_id());
    localCmdStateExt.setParam(":VREMARK", paramCmdStateDAO.getRemark());
    this.tradeQuery.executeBy(localCmdStateExt.insBy("INS_BY_CMD"));
    return 0;
  }

  public ArrayList getCmdStateList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    CmdStateExt localCmdStateExt = new CmdStateExt();
    localCmdStateExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localCmdStateExt.selByList("SEL_BY_STATE", paramInt, 20);
    return localArrayList;
  }

  public int getCmdStateList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    CmdStateExt localCmdStateExt = new CmdStateExt();
    localCmdStateExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localCmdStateExt.selByList("SEL_BY_STATE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void modifyFixList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyFixList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CMD_ID");
    String str3 = paramBuffers.getString("STATE_CODE");
    String str4 = paramBuffers.getString("START_DATE");
    String str5 = paramBuffers.getString("END_DATE");
    String str6 = paramBuffers.getString("STATE_CODE_DATE");
    String str7 = paramBuffers.getString("STATE_RESEAN");
    String str8 = paramBuffers.getString("NOW_ADDR");
    String str9 = paramBuffers.getString("OPER_DATE");
    String str10 = paramBuffers.getString("SESSION_USER_ID");
    String str11 = paramBuffers.getString("REMARK");
    try
    {
      CmdStateDAO localCmdStateDAO = new CmdStateDAO();
      localCmdStateDAO.setCust_id(str1);
      localCmdStateDAO.setCmd_id(str2);
      localCmdStateDAO.setState_code(str3);
      localCmdStateDAO.setStart_date(str4);
      localCmdStateDAO.setEnd_date(str5);
      localCmdStateDAO.setState_code_date(str6);
      localCmdStateDAO.setState_resean(str7);
      localCmdStateDAO.setNow_addr(str8);
      localCmdStateDAO.setOper_date(str9);
      localCmdStateDAO.setUser_id(str10);
      localCmdStateDAO.setRemark(str11);
      i = modifyFixList(localCmdStateDAO);
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
    this.log.LOG_INFO("退出modifyFixList方法...");
  }

  public int modifyFixList(CmdStateDAO paramCmdStateDAO)
    throws SaasApplicationException
  {
    CmdStateExt localCmdStateExt = new CmdStateExt();
    localCmdStateExt.setParam(":VCUST_ID", paramCmdStateDAO.getCust_id());
    localCmdStateExt.setParam(":VCMD_ID", paramCmdStateDAO.getCmd_id());
    localCmdStateExt.setParam(":VSTATE_CODE", paramCmdStateDAO.getState_code());
    localCmdStateExt.setParam(":VSTART_DATE", paramCmdStateDAO.getStart_date());
    localCmdStateExt.setParam(":VEND_DATE", paramCmdStateDAO.getEnd_date());
    localCmdStateExt.setParam(":VSTATE_CODE_DATE", paramCmdStateDAO.getState_code_date());
    localCmdStateExt.setParam(":VSTATE_RESEAN", paramCmdStateDAO.getState_resean());
    localCmdStateExt.setParam(":VNOW_ADDR", paramCmdStateDAO.getNow_addr());
    localCmdStateExt.setParam(":VOPER_DATE", paramCmdStateDAO.getOper_date());
    localCmdStateExt.setParam(":VUSER_ID", paramCmdStateDAO.getUser_id());
    localCmdStateExt.setParam(":VREMARK", paramCmdStateDAO.getRemark());
    this.tradeQuery.executeBy(localCmdStateExt.insBy("UP_CMD_BY_ALL"));
    return 0;
  }

  public ArrayList getListByTradeId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CmdStateExt localCmdStateExt = new CmdStateExt();
    localCmdStateExt.setParam(":VCUST_ID", paramString1);
    localCmdStateExt.setParam(":VTRADE_ID", paramString2);
    ArrayList localArrayList = localCmdStateExt.selByList("SEL_BY_TRADE_ID");
    return localArrayList;
  }

  public ArrayList getValueById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CmdStateExt localCmdStateExt = new CmdStateExt();
    localCmdStateExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCmdStateExt.selByList("SEL_BY_KKK");
    return localArrayList;
  }

  public ArrayList getOneValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CmdStateExt localCmdStateExt = new CmdStateExt();
    localCmdStateExt.setParam(":VCUST_ID", paramString1);
    localCmdStateExt.setParam(":VTEST_ID", paramString2);
    localArrayList = localCmdStateExt.selByList("SEL_ONE_BY_TEST_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.cmdStateMgr.CmdStateInfo
 * JD-Core Version:    0.6.0
 */