package com.saas.biz.reportsMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.reportsDAO.ReportsDAO;
import com.saas.biz.dao.reportsDAO.ReportsExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ReportsInfo
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

  public void addReportInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportInfo方法...");
    int i = -1;
    ReportsDAO localReportsDAO = new ReportsDAO();
    String str1 = paramBuffers.getString("IDX");
    String str2 = paramBuffers.getString("CONTENT");
    String str3 = paramBuffers.getString("PART");
    String str4 = paramBuffers.getString("PATH");
    String str5 = paramBuffers.getString("RPART");
    String str6 = paramBuffers.getString("TITLE");
    String str7 = paramBuffers.getString("SESSION_USER_NAME");
    localReportsDAO.setId(str1);
    localReportsDAO.setContent(str2);
    localReportsDAO.setPart(str3);
    localReportsDAO.setPath(str4);
    localReportsDAO.setRpart(str5);
    localReportsDAO.setTitle(str6);
    localReportsDAO.setUser(str7);
    localReportsDAO.setXchecked(Integer.valueOf(0));
    i = addReportInfo(localReportsDAO);
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
    this.log.LOG_INFO("退出addReportInfo方法...");
  }

  public int addReportInfo(ReportsDAO paramReportsDAO)
  {
    ReportsExt localReportsExt = new ReportsExt();
    localReportsExt.setParam(":VID", paramReportsDAO.getId());
    localReportsExt.setParam(":VCONTENT", paramReportsDAO.getContent());
    localReportsExt.setParam(":VPART", paramReportsDAO.getPart());
    localReportsExt.setParam(":VPATH", paramReportsDAO.getPath());
    localReportsExt.setParam(":VRPART", paramReportsDAO.getRpart());
    localReportsExt.setParam(":VTITLE", paramReportsDAO.getTitle());
    localReportsExt.setParam(":VUSER", paramReportsDAO.getUser());
    localReportsExt.setParam(":VXCHECKED", paramReportsDAO.getXchecked());
    this.tradeQuery.executeBy(localReportsExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList getReportInfoByDepartCode(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ReportsExt localReportsExt = new ReportsExt();
    try
    {
      paramInt *= 20;
      localReportsExt.setParam(":VRPART", paramString1);
      localReportsExt.setParam(":VXCHECKED", paramString2);
      localArrayList = localReportsExt.selByList("SEL_BY_RPART", paramInt, 20);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return localArrayList;
  }

  public int getReportInfoByDepartCodeCT(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ReportsExt localReportsExt = new ReportsExt();
    int i = 0;
    try
    {
      localReportsExt.setParam(":VRPART", paramString1);
      localReportsExt.setParam(":VXCHECKED", paramString2);
      localArrayList = localReportsExt.selByList("SEL_BY_RPART_COUNT");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        if (localHashMap.get("ct") != null)
          i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return i;
  }

  public ArrayList getReportInfoByUser(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ReportsExt localReportsExt = new ReportsExt();
    try
    {
      localReportsExt.setParam(":VUSER", paramString1);
      localReportsExt.setParam(":VXCHECKED", paramString2);
      localArrayList = localReportsExt.selByList("SEL_BY_USER");
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return localArrayList;
  }

  public ArrayList getReportInfoById(String paramString)
    throws SaasApplicationException
  {
    ReportsExt localReportsExt = new ReportsExt();
    ArrayList localArrayList = new ArrayList();
    localReportsExt.setParam(":VID", paramString);
    localArrayList = localReportsExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public void updateReportInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateReportInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("REPORTID");
    String str2 = "1";
    i = updateReportInfo(str1, str2);
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
    this.log.LOG_INFO("退出updateReportInfo方法...");
  }

  public int updateReportInfo(String paramString1, String paramString2)
  {
    ReportsExt localReportsExt = new ReportsExt();
    localReportsExt.setParam(":VID", paramString1);
    localReportsExt.setParam(":VXCHECKED", paramString2);
    this.tradeQuery.executeBy(localReportsExt.insBy("UPDATE_BY_REPORTID"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.reportsMgr.ReportsInfo
 * JD-Core Version:    0.6.0
 */