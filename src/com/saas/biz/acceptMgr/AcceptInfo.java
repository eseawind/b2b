package com.saas.biz.acceptMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.acceptjobDAO.AcceptjobDAO;
import com.saas.biz.dao.acceptjobDAO.AcceptjobExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class AcceptInfo
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

  public void addAcceptInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("JOB_ID");
    String str2 = paramBuffers.getString("JOB_TYPE");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    String str4 = paramBuffers.getString("SESSION_CUST_ID");
    String str5 = "";
    String str6 = "0";
    String str7 = "";
    String str8 = "";
    String str9 = paramBuffers.getString("RSRV_STR3");
    String str10 = "";
    String str11 = "";
    String str12 = "";
    String str13 = "添加求职意向";
    this.log.LOG_INFO("*************************************************************" + str9);
    AcceptjobDAO localAcceptjobDAO = new AcceptjobDAO();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    localAcceptjobDAO.setTrade_id(localcommMethodMgr.GenTradeId());
    localAcceptjobDAO.setJob_id(str1);
    localAcceptjobDAO.setJob_type(str2);
    localAcceptjobDAO.setResume_id(str5);
    localAcceptjobDAO.setUser_id(str3);
    localAcceptjobDAO.setCust_id(str4);
    localAcceptjobDAO.setDeal_tag(str6);
    localAcceptjobDAO.setRsrv_str1(str7);
    localAcceptjobDAO.setRsrv_str2(str8);
    localAcceptjobDAO.setRsrv_str3(str9);
    localAcceptjobDAO.setRsrv_str4(str10);
    localAcceptjobDAO.setRsrv_str5(str11);
    localAcceptjobDAO.setRsrv_str6(str12);
    localAcceptjobDAO.setRemark(str13);
    try
    {
      i = addAcceptInfoSub(localAcceptjobDAO);
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

  public int addAcceptInfoSub(AcceptjobDAO paramAcceptjobDAO)
    throws SaasApplicationException
  {
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    localAcceptjobExt.setParam(":VTRADE_ID", paramAcceptjobDAO.getTrade_id());
    localAcceptjobExt.setParam(":VJOB_ID", paramAcceptjobDAO.getJob_id());
    localAcceptjobExt.setParam(":VJOB_TYPE", paramAcceptjobDAO.getJob_type());
    localAcceptjobExt.setParam(":VRESUME_ID", paramAcceptjobDAO.getResume_id());
    localAcceptjobExt.setParam(":VUSER_ID", paramAcceptjobDAO.getUser_id());
    localAcceptjobExt.setParam(":VCUST_ID", paramAcceptjobDAO.getCust_id());
    localAcceptjobExt.setParam(":VDEAL_TAG", "0");
    localAcceptjobExt.setParam(":VRSRV_STR1", paramAcceptjobDAO.getRsrv_str1());
    localAcceptjobExt.setParam(":VRSRV_STR2", paramAcceptjobDAO.getRsrv_str2());
    localAcceptjobExt.setParam(":VRSRV_STR3", paramAcceptjobDAO.getRsrv_str3());
    localAcceptjobExt.setParam(":VRSRV_STR4", paramAcceptjobDAO.getRsrv_str4());
    localAcceptjobExt.setParam(":VRSRV_STR5", paramAcceptjobDAO.getRsrv_str5());
    localAcceptjobExt.setParam(":VRSRV_STR6", paramAcceptjobDAO.getRsrv_str6());
    localAcceptjobExt.setParam(":VREMARK", paramAcceptjobDAO.getRemark());
    this.tradeQuery.executeBy(localAcceptjobExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void replyAcceptJob(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = this.inBuffer.getString("ROOT_ID");
    AcceptjobDAO localAcceptjobDAO = new AcceptjobDAO();
    localAcceptjobDAO.setTrade_id(str);
    localAcceptjobDAO.setRemark("回复应聘");
    try
    {
      i = replyAcceptJob(localAcceptjobDAO);
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

  public int replyAcceptJob(AcceptjobDAO paramAcceptjobDAO)
    throws SaasApplicationException
  {
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    localAcceptjobExt.setParam(":VTRADE_ID", paramAcceptjobDAO.getTrade_id());
    localAcceptjobExt.setParam(":VDEAL_TAG", "1");
    localAcceptjobExt.setParam(":VREMARK", paramAcceptjobDAO.getRemark());
    this.tradeQuery.executeBy(localAcceptjobExt.insBy("MODIFT_BY_REPLY"));
    return 0;
  }

  public void delAcceptJob(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = this.inBuffer.getString("TRADE_ID");
    try
    {
      i = delAcceptJob(str);
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

  public int delAcceptJob(String paramString)
    throws SaasApplicationException
  {
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    localAcceptjobExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localAcceptjobExt.insBy("DEL_BY_TRADE_ID"));
    return 0;
  }

  public ArrayList getAcceptedJobByCustId(String paramString, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    localAcceptjobExt.setParam(":VCUST_ID", paramString);
    if (paramInt2 > 0)
    {
      if (paramInt1 > 1)
      {
        paramInt1 = (paramInt1 - 1) * paramInt2;
        localArrayList = localAcceptjobExt.selByList("SEL_ACCEPTED_JOB_BY_CUST_ID", paramInt1, paramInt2);
      }
      else
      {
        localArrayList = localAcceptjobExt.selByList("SEL_ACCEPTED_JOB_BY_CUST_ID", 0, paramInt2);
      }
    }
    else
      localArrayList = localAcceptjobExt.selByList("SEL_ACCEPTED_JOB_BY_CUST_ID");
    return localArrayList;
  }

  public int getCountAcceptedJobByCustId(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    localAcceptjobExt.setParam(":VCUST_ID", paramString);
    localArrayList = localAcceptjobExt.selByList("SEL_COUNT_ACCEPTED_JOB_BY_CUST_ID");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("total").toString());
    }
    return i;
  }

  public AcceptjobDAO getAcceptJobById(String paramString)
  {
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    AcceptjobDAO localAcceptjobDAO = new AcceptjobDAO();
    localAcceptjobExt.setParam(":VTRADE_ID", paramString);
    localAcceptjobDAO = localAcceptjobExt.selByInfo("SEL_BY_ID");
    return localAcceptjobDAO;
  }

  public ArrayList getMyAcceptJob(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    localAcceptjobExt.setParam(":VUSER_ID", paramString1);
    if (paramString2.equals("-1"))
    {
      localArrayList = localAcceptjobExt.selByList("SEL_ALL_MY_ACCEPT_JOB", paramInt1, paramInt2);
    }
    else
    {
      localAcceptjobExt.setParam(":VDEAL_TAG", paramString2);
      localArrayList = localAcceptjobExt.selByList("SEL_MY_DEAL_TAG_ACCEPT_JOB", paramInt1, paramInt2);
    }
    return localArrayList;
  }

  public int getCountMyAcceptJob(String paramString1, String paramString2)
  {
    int i = 0;
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    ArrayList localArrayList = new ArrayList();
    localAcceptjobExt.setParam(":VUSER_ID", paramString1);
    if (paramString2.equals("-1"))
    {
      localArrayList = localAcceptjobExt.selByList("SEL_COUNT_MY_ACCEPT_JOB");
    }
    else
    {
      localAcceptjobExt.setParam(":VDEAL_TAG", paramString2);
      localArrayList = localAcceptjobExt.selByList("SEL_COUNT_MY_DEAL_TAG_ACCEPT_JOB");
    }
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("total").toString());
    }
    return i;
  }

  public void getAcceptList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getAcceptList方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("SESSION_CUST_ID");
    try
    {
      this.queryResult = getAcceptList(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getAcceptList方法...");
  }

  public ArrayList getAcceptList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    localAcceptjobExt.setParam(":VCUST_ID", paramString);
    localArrayList = localAcceptjobExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList getCustList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AcceptjobExt localAcceptjobExt = new AcceptjobExt();
    localAcceptjobExt.setParam(":VCUST_ID", paramString);
    localArrayList = localAcceptjobExt.selByList("SEL_CUSTOMER_BY_CUST_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.acceptMgr.AcceptInfo
 * JD-Core Version:    0.6.0
 */