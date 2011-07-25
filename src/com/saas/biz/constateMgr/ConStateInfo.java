package com.saas.biz.constateMgr;

import com.saas.biz.dao.constateDAO.ConstateDAO;
import com.saas.biz.dao.constateDAO.ConstateExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class ConStateInfo
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

  public void addConstateInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addConstateInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = paramBuffers.getString("STATE_CODE");
    String str4 = paramBuffers.getString("START_DATE");
    String str5 = paramBuffers.getString("END_DATE");
    String str6 = paramBuffers.getString("STATE_CODE_DATE");
    String str7 = paramBuffers.getString("STATE_RESEAN");
    String str8 = paramBuffers.getString("OPER_DATE");
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("REMARK");
    try
    {
      ConstateDAO localConstateDAO = new ConstateDAO();
      localConstateDAO.setCust_id(str1);
      localConstateDAO.setCon_id(str2);
      localConstateDAO.setState_code(str3);
      localConstateDAO.setStart_date(str4);
      localConstateDAO.setEnd_date(str5);
      localConstateDAO.setState_code_date(str6);
      localConstateDAO.setState_resean(str7);
      localConstateDAO.setOper_date(str8);
      localConstateDAO.setUser_id(str9);
      localConstateDAO.setRemark(str10);
      i = addConstateInfo(localConstateDAO);
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
    this.log.LOG_INFO("退出addConstateInfo方法...");
  }

  public int addConstateInfo(ConstateDAO paramConstateDAO)
    throws SaasApplicationException
  {
    ConstateExt localConstateExt = new ConstateExt();
    localConstateExt.setParam(":VCUST_ID", paramConstateDAO.getCust_id());
    localConstateExt.setParam(":VCON_ID", paramConstateDAO.getCon_id());
    localConstateExt.setParam(":VSTATE_CODE", paramConstateDAO.getState_code());
    localConstateExt.setParam(":VSTART_DATE", paramConstateDAO.getStart_date());
    localConstateExt.setParam(":VEND_DATE", paramConstateDAO.getEnd_date());
    localConstateExt.setParam(":VSTATE_CODE_DATE", paramConstateDAO.getState_code_date());
    localConstateExt.setParam(":VSTATE_RESEAN", paramConstateDAO.getState_resean());
    localConstateExt.setParam(":VOPER_DATE", paramConstateDAO.getOper_date());
    localConstateExt.setParam(":VUSER_ID", paramConstateDAO.getUser_id());
    localConstateExt.setParam(":VREMARK", paramConstateDAO.getRemark());
    this.tradeQuery.executeBy(localConstateExt.insBy("INS_BY_CON_STATE"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.constateMgr.ConStateInfo
 * JD-Core Version:    0.6.0
 */