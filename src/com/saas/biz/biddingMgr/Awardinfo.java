package com.saas.biz.biddingMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.awardDAO.AwardDAO;
import com.saas.biz.dao.awardDAO.AwardExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class Awardinfo
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

  public void addAwardInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addAwardInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    AwardDAO localAwardDAO = new AwardDAO();
    localAwardDAO.setBidding_id(paramBuffers.getString("BIDDING_ID"));
    localAwardDAO.setHit_content(paramBuffers.getString("HIT_CONTENT"));
    localAwardDAO.setHit_custname(paramBuffers.getString("HIT_CUSTNAME"));
    try
    {
      i = addAwardInfo(localAwardDAO);
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
    this.log.LOG_INFO("退出addAwardInfo方法...");
  }

  public int addAwardInfo(AwardDAO paramAwardDAO)
    throws SaasApplicationException
  {
    AwardExt localAwardExt = new AwardExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    localAwardExt.setParam(":VTRADE_ID", str);
    localAwardExt.setParam(":VBIDDING_ID", paramAwardDAO.getBidding_id());
    localAwardExt.setParam(":VHIT_CONTENT", paramAwardDAO.getHit_content());
    localAwardExt.setParam(":VHIT_CUSTNAME", paramAwardDAO.getHit_custname());
    localAwardExt.setParam(":VRSRV_STR1", "");
    localAwardExt.setParam(":VRSRV_STR2", "");
    localAwardExt.setParam(":VRSRV_STR3", "");
    localAwardExt.setParam(":VRSRV_STR4", "");
    localAwardExt.setParam(":VRSRV_STR5", "");
    localAwardExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localAwardExt.insBy("INS_BY_ALL"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.biddingMgr.Awardinfo
 * JD-Core Version:    0.6.0
 */