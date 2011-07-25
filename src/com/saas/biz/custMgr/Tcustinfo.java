package com.saas.biz.custMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.tcustmerDAO.TcustmerDAO;
import com.saas.biz.dao.tcustmerDAO.TcustmerExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class Tcustinfo
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

  public void addtCustinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addtCustinfo方法...");
    int i = -1;
    try
    {
      TcustmerDAO localTcustmerDAO = new TcustmerDAO();
      localTcustmerDAO.setUser_name(paramBuffers.getString("USER_NAME"));
      localTcustmerDAO.setCust_name(paramBuffers.getString("CUST_NAME"));
      localTcustmerDAO.setPassword(paramBuffers.getString("PASSWORD"));
      localTcustmerDAO.setEmail(paramBuffers.getString("EMAIL"));
      localTcustmerDAO.setContact_phone(paramBuffers.getString("CONTACT_PHONE"));
      i = addtCustinfo(localTcustmerDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增临时客户业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增临时客户业务处理成功！");
    }
    this.log.LOG_INFO("退出addtCustinfo方法...");
  }

  public int addtCustinfo(TcustmerDAO paramTcustmerDAO)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    TcustmerExt localTcustmerExt = new TcustmerExt();
    localTcustmerExt.setParam(":VCUST_ID", str);
    localTcustmerExt.setParam(":VUSER_NAME", paramTcustmerDAO.getUser_name());
    localTcustmerExt.setParam(":VCUST_NAME", paramTcustmerDAO.getCust_name());
    localTcustmerExt.setParam(":VPASSWORD", paramTcustmerDAO.getPassword());
    localTcustmerExt.setParam(":VEMAIL", paramTcustmerDAO.getEmail());
    localTcustmerExt.setParam(":VCONTACT_PHONE", paramTcustmerDAO.getContact_phone());
    this.tradeQuery.executeBy(localTcustmerExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList gettCustInfo(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "";
    TcustmerExt localTcustmerExt = new TcustmerExt();
    localTcustmerExt.setParam(":VUSER_NAME", paramString);
    localTcustmerExt.setParam(":VCUST_STATE", Character.valueOf('0'));
    localArrayList = localTcustmerExt.selByList("SEL_BY_USER");
    return localArrayList;
  }

  public void uptCustinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入uptCustinfo方法...");
    int i = -1;
    try
    {
      String str = "";
      str = paramBuffers.getString("USER_NAME");
      i = uptCustinfo(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "更新临时客户状态业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "更新临时客户状态业务处理成功！");
    }
    this.log.LOG_INFO("退出uptCustinfo方法...");
  }

  public int uptCustinfo(String paramString)
    throws SaasApplicationException
  {
    TcustmerExt localTcustmerExt = new TcustmerExt();
    localTcustmerExt.setParam(":VUSER_NAME", paramString);
    localTcustmerExt.setParam(":VCUST_STATE", "1");
    this.tradeQuery.executeBy(localTcustmerExt.insBy("UP_BY_REG"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.custMgr.Tcustinfo
 * JD-Core Version:    0.6.0
 */