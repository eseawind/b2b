package com.saas.biz.auditMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.auditDAO.AuditDAO;
import com.saas.biz.dao.auditDAO.AuditExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class AuditInfo
  implements Serializable
{
  private static final long serialVersionUID = -1068963390961818245L;
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
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

  public void addAuditInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addAuditInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("OBJ_ID");
    String str4 = paramBuffers.getString("SESSION_USER_ID");
    String str5 = paramBuffers.getString("AUDIT_MSG");
    String str6 = paramBuffers.getString("AUDIT_STATE");
    String str7 = paramBuffers.getString("AUDIT_DATE");
    String str8 = paramBuffers.getString("REMARK2");
    try
    {
      AuditDAO localAuditDAO = new AuditDAO();
      localAuditDAO.setAudit_date(str7);
      localAuditDAO.setCust_id(str1);
      localAuditDAO.setTrade_id(str2);
      localAuditDAO.setObj_id(str3);
      localAuditDAO.setAudit_user_id(str4);
      localAuditDAO.setAudit_msg(str5);
      localAuditDAO.setAudit_state(str6);
      localAuditDAO.setRemark2(str8);
      i = addAuditInfo(localAuditDAO);
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
    this.log.LOG_INFO("退出addAuditInfo方法...");
  }

  public int addAuditInfo(AuditDAO paramAuditDAO)
    throws SaasApplicationException
  {
    AuditExt localAuditExt = new AuditExt();
    localAuditExt.setParam(":VTRADE_ID", paramAuditDAO.getTrade_id());
    localAuditExt.setParam(":VCUST_ID", paramAuditDAO.getCust_id());
    localAuditExt.setParam(":VOBJ_ID", paramAuditDAO.getObj_id());
    localAuditExt.setParam(":VAUDIT_USER_ID", paramAuditDAO.getAudit_user_id());
    localAuditExt.setParam(":VAUDIT_MSG", paramAuditDAO.getAudit_msg());
    localAuditExt.setParam(":VAUDIT_STATE", paramAuditDAO.getAudit_state());
    localAuditExt.setParam(":VAUDIT_DATE", paramAuditDAO.getAudit_date());
    localAuditExt.setParam(":VREMARK", paramAuditDAO.getRemark2());
    this.tradeQuery.executeBy(localAuditExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void delAuditInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delAuditInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    try
    {
      AuditDAO localAuditDAO = new AuditDAO();
      localAuditDAO.setCust_id(str1);
      localAuditDAO.setTrade_id(str2);
      i = addAuditInfo(localAuditDAO);
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
    this.log.LOG_INFO("退出delAuditInfo方法...");
  }

  public int delAuditInfo(AuditDAO paramAuditDAO)
    throws SaasApplicationException
  {
    AuditExt localAuditExt = new AuditExt();
    localAuditExt.setParam(":VTRADE_ID", paramAuditDAO.getTrade_id());
    localAuditExt.setParam(":VCUST_ID", localAuditExt.getCust_id());
    this.tradeQuery.executeBy(localAuditExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public ArrayList getAuditListByCust(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    AuditExt localAuditExt = new AuditExt();
    localAuditExt.setParam(":VCUST_ID", paramString1);
    localAuditExt.setParam(":VOJB_ID", paramString2);
    ArrayList localArrayList = localAuditExt.selByList("SEL_BY_OBJ", paramInt, 20);
    return localArrayList;
  }

  public int getAuditCountByCust(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    AuditExt localAuditExt = new AuditExt();
    localAuditExt.setParam(":VCUST_ID", paramString1);
    localAuditExt.setParam(":VOJB_ID", paramString2);
    ArrayList localArrayList = localAuditExt.selByList("SEL_BY_OBJ_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getAuditListByCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    AuditExt localAuditExt = new AuditExt();
    localAuditExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localAuditExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getAuditCountByCust(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    AuditExt localAuditExt = new AuditExt();
    localAuditExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localAuditExt.selByList("SEL_BY_CUST_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.auditMgr.AuditInfo
 * JD-Core Version:    0.6.0
 */