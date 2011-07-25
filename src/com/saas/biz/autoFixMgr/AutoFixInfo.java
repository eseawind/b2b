package com.saas.biz.autoFixMgr;

import com.saas.biz.dao.autoFixDAO.AutoFixDAO;
import com.saas.biz.dao.autoFixDAO.AutoFixExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class AutoFixInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
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

  public void addFixInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addFixInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("AUTO_ID");
    String str3 = paramBuffers.getString("TRADE_ID");
    String str4 = paramBuffers.getString("FIX_TITLE");
    String str5 = paramBuffers.getString("FIX_TYPE");
    String str6 = paramBuffers.getString("FIX");
    String str7 = paramBuffers.getString("FEE");
    String str8 = paramBuffers.getString("PAY_TYPE");
    String str9 = paramBuffers.getString("BILL_NO");
    String str10 = paramBuffers.getString("FIX_ADDR");
    String str11 = paramBuffers.getString("FIX_MAN");
    String str12 = paramBuffers.getString("OPER_DATE");
    String str13 = paramBuffers.getString("SESSION_USER_ID");
    String str14 = paramBuffers.getString("REMARK");
    try
    {
      AutoFixDAO localAutoFixDAO = new AutoFixDAO();
      localAutoFixDAO.setCust_id(str1);
      localAutoFixDAO.setAuto_id(str2);
      localAutoFixDAO.setTrade_id(str3);
      localAutoFixDAO.setFix_title(str4);
      localAutoFixDAO.setFix_type(str5);
      localAutoFixDAO.setFix(str6);
      localAutoFixDAO.setFee(str7);
      localAutoFixDAO.setPay_type(str8);
      localAutoFixDAO.setBill_no(str9);
      localAutoFixDAO.setFix_addr(str10);
      localAutoFixDAO.setFix_man(str11);
      localAutoFixDAO.setOper_date(str12);
      localAutoFixDAO.setUser_id(str13);
      localAutoFixDAO.setRemark(str14);
      i = addFixInfo(localAutoFixDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
    this.log.LOG_INFO("退出addFixInfo方法...");
  }

  public int addFixInfo(AutoFixDAO paramAutoFixDAO)
    throws SaasApplicationException
  {
    AutoFixExt localAutoFixExt = new AutoFixExt();
    localAutoFixExt.setParam(":VCUST_ID", paramAutoFixDAO.getCust_id());
    localAutoFixExt.setParam(":VAUTO_ID", paramAutoFixDAO.getAuto_id());
    localAutoFixExt.setParam(":VTRADE_ID", paramAutoFixDAO.getTrade_id());
    localAutoFixExt.setParam(":VFIX_TITLE", paramAutoFixDAO.getFix_title());
    localAutoFixExt.setParam(":VFIX_TYPE", paramAutoFixDAO.getFix_type());
    localAutoFixExt.setParam(":VFIX", paramAutoFixDAO.getFix());
    localAutoFixExt.setParam(":VFEE", paramAutoFixDAO.getFee());
    localAutoFixExt.setParam(":VPAY_TYPE", paramAutoFixDAO.getPay_type());
    localAutoFixExt.setParam(":VBILL_NO", paramAutoFixDAO.getBill_no());
    localAutoFixExt.setParam(":VFIX_ADDR", paramAutoFixDAO.getFix_addr());
    localAutoFixExt.setParam(":VFIX_MAN", paramAutoFixDAO.getFix_man());
    localAutoFixExt.setParam(":VOPER_DATE", paramAutoFixDAO.getOper_date());
    localAutoFixExt.setParam(":VUSER_ID", paramAutoFixDAO.getUser_id());
    localAutoFixExt.setParam(":VREMARK", paramAutoFixDAO.getRemark());
    this.tradeQuery.executeBy(localAutoFixExt.insBy("INS_BY_AUTO"));
    return 0;
  }

  public ArrayList getAutoFixList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    AutoFixExt localAutoFixExt = new AutoFixExt();
    localAutoFixExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localAutoFixExt.selByList("SEL_BY_DDD", paramInt, 20);
    return localArrayList;
  }

  public int getAutoFixList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    AutoFixExt localAutoFixExt = new AutoFixExt();
    localAutoFixExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localAutoFixExt.selByList("SEL_BY_DDD");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void modifyFixList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyFixList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("FIX_TITLE");
    String str4 = paramBuffers.getString("FIX_TYPE");
    String str5 = paramBuffers.getString("FIX");
    String str6 = paramBuffers.getString("FEE");
    String str7 = paramBuffers.getString("PAY_TYPE");
    String str8 = paramBuffers.getString("BILL_NO");
    String str9 = paramBuffers.getString("FIX_ADDR");
    String str10 = paramBuffers.getString("FIX_MAN");
    String str11 = paramBuffers.getString("OPER_DATE");
    String str12 = paramBuffers.getString("SESSION_USER_ID");
    String str13 = paramBuffers.getString("REMARK");
    try
    {
      AutoFixDAO localAutoFixDAO = new AutoFixDAO();
      localAutoFixDAO.setCust_id(str1);
      localAutoFixDAO.setTrade_id(str2);
      localAutoFixDAO.setFix_title(str3);
      localAutoFixDAO.setFix_type(str4);
      localAutoFixDAO.setFix(str5);
      localAutoFixDAO.setFee(str6);
      localAutoFixDAO.setPay_type(str7);
      localAutoFixDAO.setBill_no(str8);
      localAutoFixDAO.setFix_addr(str9);
      localAutoFixDAO.setFix_man(str10);
      localAutoFixDAO.setOper_date(str11);
      localAutoFixDAO.setUser_id(str12);
      localAutoFixDAO.setRemark(str13);
      i = modifyFixList(localAutoFixDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
    this.log.LOG_INFO("退出modifyFixList方法...");
  }

  public int modifyFixList(AutoFixDAO paramAutoFixDAO)
    throws SaasApplicationException
  {
    AutoFixExt localAutoFixExt = new AutoFixExt();
    localAutoFixExt.setParam(":VCUST_ID", paramAutoFixDAO.getCust_id());
    localAutoFixExt.setParam(":VTRADE_ID", paramAutoFixDAO.getTrade_id());
    localAutoFixExt.setParam(":VFIX_TITLE", paramAutoFixDAO.getFix_title());
    localAutoFixExt.setParam(":VFIX_TYPE", paramAutoFixDAO.getFix_type());
    localAutoFixExt.setParam(":VFIX", paramAutoFixDAO.getFix());
    localAutoFixExt.setParam(":VFEE", paramAutoFixDAO.getFee());
    localAutoFixExt.setParam(":VPAY_TYPE", paramAutoFixDAO.getPay_type());
    localAutoFixExt.setParam(":VBILL_NO", paramAutoFixDAO.getBill_no());
    localAutoFixExt.setParam(":VFIX_ADDR", paramAutoFixDAO.getFix_addr());
    localAutoFixExt.setParam(":VFIX_MAN", paramAutoFixDAO.getFix_man());
    localAutoFixExt.setParam(":VOPER_DATE", paramAutoFixDAO.getOper_date());
    localAutoFixExt.setParam(":VUSER_ID", paramAutoFixDAO.getUser_id());
    localAutoFixExt.setParam(":VREMARK", paramAutoFixDAO.getRemark());
    this.tradeQuery.executeBy(localAutoFixExt.insBy("UP_AUTO_BY_ALL"));
    return 0;
  }

  public ArrayList getListByTradeId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    AutoFixExt localAutoFixExt = new AutoFixExt();
    localAutoFixExt.setParam(":VCUST_ID", paramString1);
    localAutoFixExt.setParam(":VTRADE_ID", paramString2);
    ArrayList localArrayList = localAutoFixExt.selByList("SEL_BY_TRADE_ID");
    return localArrayList;
  }

  public ArrayList getValueById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AutoFixExt localAutoFixExt = new AutoFixExt();
    localAutoFixExt.setParam(":VCUST_ID", paramString);
    localArrayList = localAutoFixExt.selByList("SEL_BY_KKK");
    return localArrayList;
  }

  public ArrayList getOneValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AutoFixExt localAutoFixExt = new AutoFixExt();
    localAutoFixExt.setParam(":VCUST_ID", paramString1);
    localAutoFixExt.setParam(":VTEST_ID", paramString2);
    localArrayList = localAutoFixExt.selByList("SEL_ONE_BY_TEST_ID");
    return localArrayList;
  }

  public void DelFixList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入DelFixList方法...");
    int i = -1;
    String str = paramBuffers.getString("TRADE_ID");
    try
    {
      AutoFixDAO localAutoFixDAO = new AutoFixDAO();
      localAutoFixDAO.setTrade_id(str);
      i = DelFixList(localAutoFixDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
    this.log.LOG_INFO("退出DelFixList方法...");
  }

  public int DelFixList(AutoFixDAO paramAutoFixDAO)
    throws SaasApplicationException
  {
    AutoFixExt localAutoFixExt = new AutoFixExt();
    localAutoFixExt.setParam(":VTRADE_ID", paramAutoFixDAO.getTrade_id());
    this.tradeQuery.executeBy(localAutoFixExt.insBy("DEL_AUTO_BY_ID"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.autoFixMgr.AutoFixInfo
 * JD-Core Version:    0.6.0
 */