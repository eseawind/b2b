package com.saas.biz.userclassMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.userclassDAO.UserclassExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class UserclassMgr
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

  public ArrayList genUserClass()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserclassExt localUserclassExt = new UserclassExt();
    localUserclassExt.setParam(":VENABLE_TAG", "0");
    localArrayList = localUserclassExt.selByList("SEL_BY_ALL");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.userclassMgr.UserclassMgr
 * JD-Core Version:    0.6.0
 */