package com.saas.biz.reportcommentsMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.reportcommentsDAO.ReportcommentsDAO;
import com.saas.biz.dao.reportcommentsDAO.ReportcommentsExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class Reportcomments
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

  public void addReportComments(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportComments方法...");
    int i = -1;
    ReportcommentsDAO localReportcommentsDAO = new ReportcommentsDAO();
    String str1 = paramBuffers.getString("REPORTID");
    String str2 = paramBuffers.getString("CONTENT");
    String str3 = paramBuffers.getString("SESSION_USER_NAME");
    String str4 = paramBuffers.getString("PART");
    localReportcommentsDAO.setComments(str2);
    localReportcommentsDAO.setReportid(str1);
    localReportcommentsDAO.setUser(str3);
    localReportcommentsDAO.setPart(str4);
    i = addReportComments(localReportcommentsDAO);
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
    this.log.LOG_INFO("退出addReportComments方法...");
  }

  public int addReportComments(ReportcommentsDAO paramReportcommentsDAO)
  {
    ReportcommentsExt localReportcommentsExt = new ReportcommentsExt();
    localReportcommentsExt.setParam(":VREPORTID", paramReportcommentsDAO.getReportid());
    localReportcommentsExt.setParam(":VUSER", paramReportcommentsDAO.getUser());
    localReportcommentsExt.setParam(":VPART", paramReportcommentsDAO.getPart());
    localReportcommentsExt.setParam(":VCOMMENTS", paramReportcommentsDAO.getComments());
    this.tradeQuery.executeBy(localReportcommentsExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList getReportCommentByReportId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ReportcommentsExt localReportcommentsExt = new ReportcommentsExt();
    localReportcommentsExt.setParam(":VREPORTID", paramString);
    localArrayList = localReportcommentsExt.selByList("SEL_BY_REPORTID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.reportcommentsMgr.Reportcomments
 * JD-Core Version:    0.6.0
 */