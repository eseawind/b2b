package com.saas.biz.studycommentsMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.studycommentsDAO.StudycommentsDAO;
import com.saas.biz.dao.studycommentsDAO.StudycommentsExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class StudyCommentsInfo
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

  public void addStudyCommInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("IDX");
    String str2 = paramBuffers.getString("COMMENTS");
    String str3 = paramBuffers.getString("DEPART_CODE");
    String str4 = paramBuffers.getString("SESSION_USER_NAME");
    StudycommentsDAO localStudycommentsDAO = new StudycommentsDAO();
    localStudycommentsDAO.setComments(str2);
    localStudycommentsDAO.setPart(str3);
    localStudycommentsDAO.setUser(str4);
    localStudycommentsDAO.setStudyid(str1);
    i = addStudyCommInfo(localStudycommentsDAO);
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

  public int addStudyCommInfo(StudycommentsDAO paramStudycommentsDAO)
  {
    StudycommentsExt localStudycommentsExt = new StudycommentsExt();
    localStudycommentsExt.setParam(":VSTUDYID", paramStudycommentsDAO.getStudyid());
    localStudycommentsExt.setParam(":VCOMMENTS", paramStudycommentsDAO.getComments());
    localStudycommentsExt.setParam(":VUSER", paramStudycommentsDAO.getUser());
    localStudycommentsExt.setParam(":VPART", paramStudycommentsDAO.getPart());
    this.tradeQuery.executeBy(localStudycommentsExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList getStudyCommByStudyId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    StudycommentsExt localStudycommentsExt = new StudycommentsExt();
    localStudycommentsExt.setParam(":VSTUDYID", paramString);
    localArrayList = localStudycommentsExt.selByList("SEL_BY_STUDYID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.studycommentsMgr.StudyCommentsInfo
 * JD-Core Version:    0.6.0
 */