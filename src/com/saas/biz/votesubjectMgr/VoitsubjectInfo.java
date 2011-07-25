package com.saas.biz.votesubjectMgr;

import com.saas.biz.dao.voteitemsDAO.VoteitemsExt;
import com.saas.biz.dao.votesubjectDAO.VotesubjectDAO;
import com.saas.biz.dao.votesubjectDAO.VotesubjectExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class VoitsubjectInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void addvotesubjectInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addvoitsubjectInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      VotesubjectDAO localVotesubjectDAO = new VotesubjectDAO();
      localVotesubjectDAO.setVote_class(paramBuffers.getString("VOTE_CLASS"));
      localVotesubjectDAO.setVote_id(paramBuffers.getString("VOTE_ID"));
      localVotesubjectDAO.setSubject_name(paramBuffers.getString("SUBJECT_NAME"));
      localVotesubjectDAO.setStart_date(paramBuffers.getString("START_DATE"));
      localVotesubjectDAO.setEnd_date(paramBuffers.getString("END_DATE"));
      localVotesubjectDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
      localVotesubjectDAO.setUser_id(paramBuffers.getString("SESSION_USER_ID"));
      localVotesubjectDAO.setChecked_tag(paramBuffers.getString("CHECKED_TAG"));
      localVotesubjectDAO.setVote_type(paramBuffers.getString("VOTE_TYPE"));
      localVotesubjectDAO.setVote_range(paramBuffers.getString("VOTE_RANGE"));
      localVotesubjectDAO.setOwn_range(paramBuffers.getString("OWN_RANGE"));
      i = addvotesubjectInfo(localVotesubjectDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
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
    this.log.LOG_INFO("退出addvoitsubjectInfo方法...");
  }

  public int addvotesubjectInfo(VotesubjectDAO paramVotesubjectDAO)
    throws SaasApplicationException
  {
    VotesubjectExt localVotesubjectExt = new VotesubjectExt();
    localVotesubjectExt.setParam(":VVOTE_CLASS", paramVotesubjectDAO.getVote_class());
    localVotesubjectExt.setParam(":VVOTE_ID", paramVotesubjectDAO.getVote_id());
    localVotesubjectExt.setParam(":VSUBJECT_NAME", paramVotesubjectDAO.getSubject_name());
    localVotesubjectExt.setParam(":VSTART_DATE", paramVotesubjectDAO.getStart_date());
    localVotesubjectExt.setParam(":VEND_DATE", paramVotesubjectDAO.getEnd_date());
    localVotesubjectExt.setParam(":VCUST_ID", paramVotesubjectDAO.getCust_id());
    localVotesubjectExt.setParam(":VUSER_ID", paramVotesubjectDAO.getUser_id());
    localVotesubjectExt.setParam(":VCHECKED_TAG", paramVotesubjectDAO.getChecked_tag());
    localVotesubjectExt.setParam(":VVOTE_TYPE", paramVotesubjectDAO.getVote_type());
    localVotesubjectExt.setParam(":VVOTE_RANGE", paramVotesubjectDAO.getVote_range());
    localVotesubjectExt.setParam(":VOWN_RANGE", paramVotesubjectDAO.getOwn_range());
    localVotesubjectExt.setParam(":VVOTE_COUNT", Integer.valueOf(0));
    localVotesubjectExt.setParam(":VRSRV_STR1", "");
    localVotesubjectExt.setParam(":VRSRV_STR2", "");
    localVotesubjectExt.setParam(":VRSRV_STR3", "");
    localVotesubjectExt.setParam(":VRSRV_NUM4", Integer.valueOf(0));
    localVotesubjectExt.setParam(":VRSRV_NUM5", Integer.valueOf(0));
    localVotesubjectExt.setParam(":VRSRV_STR6", "");
    localVotesubjectExt.setParam(":VRSRV_STR7", "");
    localVotesubjectExt.setParam(":VRSRV_STR8", "");
    localVotesubjectExt.setParam(":VRSRV_STR9", "");
    localVotesubjectExt.setParam(":VRSRV_STR10", "");
    localVotesubjectExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localVotesubjectExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void genCustvote(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genCustvote方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = genCustvote(str1);
      else
        this.queryResult = searchVote(str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genCustvote方法...");
  }

  public ArrayList genCustvote(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    VotesubjectExt localVotesubjectExt = new VotesubjectExt();
    localVotesubjectExt.setParam(":VCUST_ID", paramString);
    localArrayList = localVotesubjectExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public void genOnevote(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genOnevote方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("VOTE_ID");
    try
    {
      this.queryResult = genOnevote(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOnevote方法...");
  }

  public ArrayList genOnevote(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    VotesubjectExt localVotesubjectExt = new VotesubjectExt();
    localVotesubjectExt.setParam(":VVOTE_ID", paramString);
    localArrayList = localVotesubjectExt.selByList("SEL_BY_ONE");
    return localArrayList;
  }

  public ArrayList searchVote(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    VotesubjectExt localVotesubjectExt = new VotesubjectExt();
    localVotesubjectExt.setParam(":VSUBJECT_NAME", "%" + paramString + "%");
    localArrayList = localVotesubjectExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public void changvotesubjectInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入changvotesubjectInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      VotesubjectDAO localVotesubjectDAO = new VotesubjectDAO();
      localVotesubjectDAO.setVote_class(paramBuffers.getString("VOTE_CLASS"));
      localVotesubjectDAO.setVote_id(paramBuffers.getString("VOTE_ID"));
      localVotesubjectDAO.setSubject_name(paramBuffers.getString("SUBJECT_NAME"));
      localVotesubjectDAO.setStart_date(paramBuffers.getString("START_DATE"));
      localVotesubjectDAO.setEnd_date(paramBuffers.getString("END_DATE"));
      localVotesubjectDAO.setChecked_tag(paramBuffers.getString("CHECKED_TAG"));
      localVotesubjectDAO.setVote_type(paramBuffers.getString("VOTE_TYPE"));
      localVotesubjectDAO.setVote_range(paramBuffers.getString("VOTE_RANGE"));
      localVotesubjectDAO.setOwn_range(paramBuffers.getString("OWN_RANGE"));
      i = changvotesubjectInfo(localVotesubjectDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
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
    this.log.LOG_INFO("退出changvotesubjectInfo方法...");
  }

  public int changvotesubjectInfo(VotesubjectDAO paramVotesubjectDAO)
    throws SaasApplicationException
  {
    VotesubjectExt localVotesubjectExt = new VotesubjectExt();
    localVotesubjectExt.setParam(":VVOTE_CLASS", paramVotesubjectDAO.getVote_class());
    localVotesubjectExt.setParam(":VVOTE_ID", paramVotesubjectDAO.getVote_id());
    localVotesubjectExt.setParam(":VSUBJECT_NAME", paramVotesubjectDAO.getSubject_name());
    localVotesubjectExt.setParam(":VSTART_DATE", paramVotesubjectDAO.getStart_date());
    localVotesubjectExt.setParam(":VEND_DATE", paramVotesubjectDAO.getEnd_date());
    localVotesubjectExt.setParam(":VCHECKED_TAG", paramVotesubjectDAO.getChecked_tag());
    localVotesubjectExt.setParam(":VVOTE_TYPE", paramVotesubjectDAO.getVote_type());
    localVotesubjectExt.setParam(":VVOTE_RANGE", paramVotesubjectDAO.getVote_range());
    localVotesubjectExt.setParam(":VOWN_RANGE", paramVotesubjectDAO.getOwn_range());
    this.tradeQuery.executeBy(localVotesubjectExt.insBy("UPDATE_BY_ID"));
    return 0;
  }

  public void delvotesubjectInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delvotesubjectInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str = paramBuffers.getString("VOTE_ID");
      i = delvotesubjectInfo(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
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
    this.log.LOG_INFO("退出delvotesubjectInfo方法...");
  }

  public int delvotesubjectInfo(String paramString)
    throws SaasApplicationException
  {
    VotesubjectExt localVotesubjectExt = new VotesubjectExt();
    localVotesubjectExt.setParam(":VVOTE_ID", paramString);
    this.tradeQuery.executeBy(localVotesubjectExt.insBy("DEL_BY_ID"));
    delitems(paramString);
    return 0;
  }

  public int delitems(String paramString)
    throws SaasApplicationException
  {
    VoteitemsExt localVoteitemsExt = new VoteitemsExt();
    localVoteitemsExt.setParam(":VVOTE_ID", paramString);
    this.tradeQuery.executeBy(localVoteitemsExt.insBy("DEL_BY_ID"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.votesubjectMgr.VoitsubjectInfo
 * JD-Core Version:    0.6.0
 */