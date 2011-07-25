package com.saas.biz.voteitemsMgr;

import com.saas.biz.dao.voteitemsDAO.VoteitemsDAO;
import com.saas.biz.dao.voteitemsDAO.VoteitemsExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class VoteitemsInfo
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

  public void addvoteitemsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addvoteitemsInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      VoteitemsDAO localVoteitemsDAO = new VoteitemsDAO();
      localVoteitemsDAO.setItem_id(paramBuffers.getString("ITEM_ID"));
      localVoteitemsDAO.setVote_id(paramBuffers.getString("VOTE_ID"));
      localVoteitemsDAO.setTitle(paramBuffers.getString("TITLE"));
      localVoteitemsDAO.setItem_no(paramBuffers.getString("ITEM_NO"));
      i = addvoteitemsInfo(localVoteitemsDAO);
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
  }

  public int addvoteitemsInfo(VoteitemsDAO paramVoteitemsDAO)
    throws SaasApplicationException
  {
    VoteitemsExt localVoteitemsExt = new VoteitemsExt();
    localVoteitemsExt.setParam(":VVOTE_ID", paramVoteitemsDAO.getVote_id());
    localVoteitemsExt.setParam(":VITEM_ID", paramVoteitemsDAO.getItem_id());
    localVoteitemsExt.setParam(":VTITLE", paramVoteitemsDAO.getTitle());
    localVoteitemsExt.setParam(":VITEM_NO", paramVoteitemsDAO.getItem_no());
    localVoteitemsExt.setParam(":VVOTE_COUNT", Integer.valueOf(0));
    localVoteitemsExt.setParam(":VRSRV_STR1", "");
    localVoteitemsExt.setParam(":VRSRV_STR2", "");
    localVoteitemsExt.setParam(":VRSRV_STR3", "");
    localVoteitemsExt.setParam(":VRSRV_NUM4", Integer.valueOf(0));
    localVoteitemsExt.setParam(":VRSRV_NUM5", Integer.valueOf(0));
    localVoteitemsExt.setParam(":VRSRV_STR6", "");
    localVoteitemsExt.setParam(":VRSRV_STR7", "");
    localVoteitemsExt.setParam(":VRSRV_STR8", "");
    localVoteitemsExt.setParam(":VRSRV_STR9", "");
    localVoteitemsExt.setParam(":VRSRV_STR10", "");
    localVoteitemsExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localVoteitemsExt.insBy("INS_BY_ALL"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.voteitemsMgr.VoteitemsInfo
 * JD-Core Version:    0.6.0
 */