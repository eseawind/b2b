package com.saas.biz.oaNewsMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.oaNewsDAO.NewsDAO;
import com.saas.biz.dao.oaNewsDAO.NewsExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class OaNewsInfo
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

  public void addOaNews(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addOaNews方法...");
    int i = -1;
    String str1 = paramBuffers.getString("XTYPE");
    String str2 = paramBuffers.getString("CONTENT");
    String str3 = paramBuffers.getString("TITLE");
    String str4 = paramBuffers.getString("SESSION_USER_NAME");
    String str5 = paramBuffers.getString("DEPART_CODE");
    String str6 = paramBuffers.getString("XVISIBLE");
    try
    {
      NewsDAO localNewsDAO = new NewsDAO(str1, str3, str2, str4, str5, str6);
      i = addOaNews(localNewsDAO);
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
    this.log.LOG_INFO("退出addOaNews方法...");
  }

  public int addOaNews(NewsDAO paramNewsDAO)
    throws SaasApplicationException
  {
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VXTYPE", paramNewsDAO.getXtype());
    localNewsExt.setParam(":VCONTENT", paramNewsDAO.getContent());
    localNewsExt.setParam(":VTITLE", paramNewsDAO.getTitle());
    localNewsExt.setParam(":VPART", paramNewsDAO.getPart());
    localNewsExt.setParam(":VUSER", paramNewsDAO.getUser());
    localNewsExt.setParam(":VXVISIBLE", paramNewsDAO.getXvisible());
    this.tradeQuery.executeBy(localNewsExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList getNewsInfoByPart(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VPART", paramString);
    localArrayList = localNewsExt.selByList("SEL_BY_PART");
    return localArrayList;
  }

  public ArrayList getNewsPageInfoByPart(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      localNewsExt.setParam(":VPART", paramString);
      localArrayList = localNewsExt.selByList("SEL_BY_PAGE", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getNewsPageInfoByPartCT(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    NewsExt localNewsExt = new NewsExt();
    try
    {
      localNewsExt.setParam(":VPART", paramString);
      localArrayList = localNewsExt.selByList("SEL_BY_PAGE_CT");
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

  public ArrayList getNewsInfoById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewsExt localNewsExt = new NewsExt();
    localNewsExt.setParam(":VID", paramString);
    localArrayList = localNewsExt.selByList("SEL_BY_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.oaNewsMgr.OaNewsInfo
 * JD-Core Version:    0.6.0
 */