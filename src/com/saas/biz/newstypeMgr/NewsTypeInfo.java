package com.saas.biz.newstypeMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.newstypeDAO.NewstypeExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class NewsTypeInfo
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

  public void addNewsType(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportsDelivery方法...");
    int i = -1;
    String str1 = paramBuffers.getString("TYPE");
    String str2 = paramBuffers.getString("REMARK");
    try
    {
      i = addNewsType(str1, str2);
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

  public int addNewsType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    NewstypeExt localNewstypeExt = new NewstypeExt();
    localNewstypeExt.setParam(":VID", this.commen.GenTradeId());
    localNewstypeExt.setParam(":VXTYPE", paramString1);
    localNewstypeExt.setParam(":VREMARK", paramString2);
    this.tradeQuery.executeBy(localNewstypeExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void deleteNewsType(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportsDelivery方法...");
    int i = -1;
    String str = paramBuffers.getString("ID");
    try
    {
      i = deleteNewsType(str);
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

  public int deleteNewsType(String paramString)
    throws SaasApplicationException
  {
    NewstypeExt localNewstypeExt = new NewstypeExt();
    localNewstypeExt.setParam(":VID", paramString);
    this.tradeQuery.executeBy(localNewstypeExt.insBy("DELETE_BY_ID"));
    return 0;
  }

  public ArrayList getNewsTypeAll()
    throws SaasApplicationException
  {
    NewstypeExt localNewstypeExt = new NewstypeExt();
    ArrayList localArrayList = new ArrayList();
    localArrayList = localNewstypeExt.selByList("SEL_BY_ALL");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.newstypeMgr.NewsTypeInfo
 * JD-Core Version:    0.6.0
 */