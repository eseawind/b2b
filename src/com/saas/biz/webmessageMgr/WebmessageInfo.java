package com.saas.biz.webmessageMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.webmessageDAO.WebmessageDAO;
import com.saas.biz.dao.webmessageDAO.WebmessageExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class WebmessageInfo
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

  public void addWebMessageInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addWebMessageInfo方法...");
    this.outBuffer = paramBuffers;
    WebmessageDAO localWebmessageDAO = new WebmessageDAO();
    localWebmessageDAO.setAccept_user_id(paramBuffers.getString("USER_ID"));
    localWebmessageDAO.setUser_id(paramBuffers.getString("SESSION_USER_ID"));
    localWebmessageDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localWebmessageDAO.setSend_date(paramBuffers.getString("SEND_DATE"));
    localWebmessageDAO.setTitle(paramBuffers.getString("TITLE"));
    localWebmessageDAO.setContent(paramBuffers.getString("CONTENT"));
    int i = -1;
    try
    {
      i = addWebMessageInfo(localWebmessageDAO);
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
    this.log.LOG_INFO("退出addWebMessageInfo方法...");
  }

  public int addWebMessageInfo(WebmessageDAO paramWebmessageDAO)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    WebmessageExt localWebmessageExt = new WebmessageExt();
    String str = localcommMethodMgr.GenTradeId();
    localWebmessageExt.setParam(":VTRADE_ID", str);
    localWebmessageExt.setParam(":VACCEPT_USER_ID", paramWebmessageDAO.getAccept_user_id());
    localWebmessageExt.setParam(":VCUST_ID", paramWebmessageDAO.getCust_id());
    localWebmessageExt.setParam(":VUSER_ID", paramWebmessageDAO.getUser_id());
    localWebmessageExt.setParam(":VTITLE", paramWebmessageDAO.getTitle());
    localWebmessageExt.setParam(":VCONTENT", paramWebmessageDAO.getContent());
    localWebmessageExt.setParam(":VSEND_DATE", paramWebmessageDAO.getSend_date());
    localWebmessageExt.setParam(":VDELAY_TAG", "0");
    localWebmessageExt.setParam(":VREAD_TAG", "0");
    localWebmessageExt.setParam(":VRSRV_STR1", "");
    localWebmessageExt.setParam(":VRSRV_STR2", "");
    localWebmessageExt.setParam(":VRSRV_STR3", "");
    localWebmessageExt.setParam(":VRSRV_STR6", "");
    localWebmessageExt.setParam(":VRSRV_STR7", "");
    localWebmessageExt.setParam(":VRSRV_STR8", "");
    localWebmessageExt.setParam(":VRSRV_STR9", "");
    localWebmessageExt.setParam(":VRSRV_STR10", "");
    localWebmessageExt.setParam(":VRSRV_NUM4", "");
    localWebmessageExt.setParam(":VRSRV_NUM5", "");
    localWebmessageExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localWebmessageExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void genUserinformation(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genUserinformation方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_USER_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = genUserinformation(str1);
      else
        this.queryResult = searchMessage(str2, str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genUserinformation方法...");
  }

  public ArrayList genUserinformation(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    WebmessageExt localWebmessageExt = new WebmessageExt();
    localWebmessageExt.setParam(":VACCEPT_USER_ID", paramString);
    localArrayList = localWebmessageExt.selByList("SEL_BY_USER");
    return localArrayList;
  }

  public void genOneinformation(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genOneinformation方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    try
    {
      this.queryResult = genOneinformation(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneinformation方法...");
  }

  public ArrayList genOneinformation(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    WebmessageExt localWebmessageExt = new WebmessageExt();
    localWebmessageExt.setParam(":VTRADE_ID", paramString);
    localArrayList = localWebmessageExt.selByList("SEL_BY_ONE");
    return localArrayList;
  }

  public void readinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入readinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    WebmessageDAO localWebmessageDAO = new WebmessageDAO();
    localWebmessageDAO.setTrade_id(paramBuffers.getString("TRADE_ID"));
    localWebmessageDAO.setAccept_user_id(paramBuffers.getString("USER_ID"));
    localWebmessageDAO.setUser_id(paramBuffers.getString("SESSION_USER_ID"));
    localWebmessageDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localWebmessageDAO.setSend_date(paramBuffers.getString("RESEND_DATE"));
    localWebmessageDAO.setTitle(paramBuffers.getString("RETITLE"));
    localWebmessageDAO.setContent(paramBuffers.getString("RECONTENT"));
    try
    {
      i = readinfo(localWebmessageDAO);
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
    this.log.LOG_INFO("退出readinfo方法...");
  }

  public int readinfo(WebmessageDAO paramWebmessageDAO)
    throws SaasApplicationException
  {
    WebmessageExt localWebmessageExt1 = new WebmessageExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    WebmessageExt localWebmessageExt2 = new WebmessageExt();
    localWebmessageExt1.setParam(":VTRADE_ID", paramWebmessageDAO.getTrade_id());
    localWebmessageExt1.setParam(":VREAD_TAG", "0");
    this.tradeQuery.executeBy(localWebmessageExt1.insBy("READ_BY_ONE"));
    String str = localcommMethodMgr.GenTradeId();
    localWebmessageExt2.setParam(":VTRADE_ID", str);
    localWebmessageExt2.setParam(":VACCEPT_USER_ID", paramWebmessageDAO.getAccept_user_id());
    localWebmessageExt2.setParam(":VCUST_ID", paramWebmessageDAO.getCust_id());
    localWebmessageExt2.setParam(":VUSER_ID", paramWebmessageDAO.getUser_id());
    localWebmessageExt2.setParam(":VTITLE", paramWebmessageDAO.getTitle());
    localWebmessageExt2.setParam(":VCONTENT", paramWebmessageDAO.getContent());
    localWebmessageExt2.setParam(":VSEND_DATE", paramWebmessageDAO.getSend_date());
    localWebmessageExt2.setParam(":VDELAY_TAG", "0");
    localWebmessageExt2.setParam(":VREAD_TAG", "0");
    localWebmessageExt2.setParam(":VRSRV_STR1", "");
    localWebmessageExt2.setParam(":VRSRV_STR2", "");
    localWebmessageExt2.setParam(":VRSRV_STR3", "");
    localWebmessageExt2.setParam(":VRSRV_STR6", "");
    localWebmessageExt2.setParam(":VRSRV_STR7", "");
    localWebmessageExt2.setParam(":VRSRV_STR8", "");
    localWebmessageExt2.setParam(":VRSRV_STR9", "");
    localWebmessageExt2.setParam(":VRSRV_STR10", "");
    localWebmessageExt2.setParam(":VRSRV_NUM4", "");
    localWebmessageExt2.setParam(":VRSRV_NUM5", "");
    localWebmessageExt2.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localWebmessageExt2.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList searchMessage(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    WebmessageExt localWebmessageExt = new WebmessageExt();
    localWebmessageExt.setParam(":VTITLE", "%" + paramString1 + "%");
    localWebmessageExt.setParam(":VACCEPT_USER_ID", paramString2);
    localArrayList = localWebmessageExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.webmessageMgr.WebmessageInfo
 * JD-Core Version:    0.6.0
 */