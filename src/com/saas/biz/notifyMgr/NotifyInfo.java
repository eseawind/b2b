package com.saas.biz.notifyMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.notifyDAO.NotifyDAO;
import com.saas.biz.dao.notifyDAO.NotifyExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class NotifyInfo
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

  public void addNotifyInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportsDelivery方法...");
    int i = -1;
    String str1 = this.commen.GenTradeId();
    String str2 = paramBuffers.getString("TITLE");
    String str3 = paramBuffers.getString("CONTENT");
    String str4 = paramBuffers.getString("SESSION_USER_NAME");
    String str5 = paramBuffers.getString("DEPART_CODE");
    String str6 = paramBuffers.getString("PATH");
    String str7 = paramBuffers.getString("SESSION_CUST_ID");
    NotifyDAO localNotifyDAO = new NotifyDAO();
    localNotifyDAO.setId(str1);
    localNotifyDAO.setTitle(str2);
    localNotifyDAO.setContent(str3);
    localNotifyDAO.setUser(str4);
    localNotifyDAO.setPart(str5);
    localNotifyDAO.setXvisible(str7);
    localNotifyDAO.setPath(str6);
    try
    {
      i = addNotifyInfo(localNotifyDAO);
    }
    catch (Exception localException)
    {
      i = -1;
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
    this.log.LOG_INFO("退出addReportsDelivery方法...");
  }

  public int addNotifyInfo(NotifyDAO paramNotifyDAO)
    throws SaasApplicationException
  {
    NotifyExt localNotifyExt = new NotifyExt();
    localNotifyExt.setParam(":VID", paramNotifyDAO.getId());
    localNotifyExt.setParam(":VTITLE", paramNotifyDAO.getTitle());
    localNotifyExt.setParam(":VCONTENT", paramNotifyDAO.getContent());
    localNotifyExt.setParam(":VPATH", paramNotifyDAO.getPath());
    localNotifyExt.setParam(":VUSER", paramNotifyDAO.getUser());
    localNotifyExt.setParam(":VPART", paramNotifyDAO.getPart());
    localNotifyExt.setParam(":VCHECKED", "0");
    localNotifyExt.setParam(":VVALIDITY", paramNotifyDAO.getXvisible());
    this.tradeQuery.executeBy(localNotifyExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void deleteNotifyInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportsDelivery方法...");
    int i = -1;
    String str = paramBuffers.getString("ID");
    try
    {
      i = deleteNotifyInfo(str);
    }
    catch (Exception localException)
    {
      i = -1;
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
    this.log.LOG_INFO("退出addReportsDelivery方法...");
  }

  public int deleteNotifyInfo(String paramString)
    throws SaasApplicationException
  {
    NotifyExt localNotifyExt = new NotifyExt();
    localNotifyExt.setParam(":VID", paramString);
    this.tradeQuery.executeBy(localNotifyExt.insBy("DELETE_BY_ID"));
    return 0;
  }

  public ArrayList getNotifyByPart(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    NotifyExt localNotifyExt = new NotifyExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 20;
      localNotifyExt.setParam(":VPART", paramString1);
      localNotifyExt.setParam(":VCHECKED", "0");
      localNotifyExt.setParam(":VXVISIBLE", paramString2);
      localArrayList = localNotifyExt.selByList("SEL_BY_PART", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getNotifyByPartCT(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    NotifyExt localNotifyExt = new NotifyExt();
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    try
    {
      localNotifyExt.setParam(":VPART", paramString1);
      localNotifyExt.setParam(":VCHECKED", "0");
      localNotifyExt.setParam(":VXVISIBLE", paramString2);
      localArrayList = localNotifyExt.selByList("SEL_BY_PART_COUNT");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        if (localHashMap.get("ct") != null)
          i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return i;
  }

  public ArrayList getNotifyById(String paramString)
    throws SaasApplicationException
  {
    NotifyExt localNotifyExt = new NotifyExt();
    ArrayList localArrayList = new ArrayList();
    localNotifyExt.setParam(":VID", paramString);
    localArrayList = localNotifyExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public String getNotifyContentById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    NotifyExt localNotifyExt = new NotifyExt();
    ArrayList localArrayList = new ArrayList();
    localNotifyExt.setParam(":VID", paramString);
    localArrayList = localNotifyExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("content") != null)
        str = localHashMap.get("content").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.notifyMgr.NotifyInfo
 * JD-Core Version:    0.6.0
 */