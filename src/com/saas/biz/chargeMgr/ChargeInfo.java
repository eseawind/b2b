package com.saas.biz.chargeMgr;

import com.saas.biz.dao.channelDAO.ChannelExt;
import com.saas.biz.dao.chargeDAO.ChargeDAO;
import com.saas.biz.dao.chargeDAO.ChargeExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import tools.util.DateUtils;

public class ChargeInfo
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

  public void addCharge(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCharge方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CHARGE_ID");
    String str2 = paramBuffers.getString("USER_ID");
    String str3 = paramBuffers.getString("CUST_ID");
    String str4 = paramBuffers.getString("BUYFORDAYS");
    String str5 = paramBuffers.getString("EXPIRE_DATE");
    String str6 = paramBuffers.getString("MONEY");
    String str7 = paramBuffers.getString("CHECK_ID");
    String str8 = paramBuffers.getString("ACCOUNT_ID");
    try
    {
      ChargeDAO localChargeDAO = new ChargeDAO();
      localChargeDAO.setCharge_id(str1);
      localChargeDAO.setUser_id(str2);
      localChargeDAO.setCust_id(str3);
      localChargeDAO.setBuyfordays(str4);
      localChargeDAO.setExpire_date(str5);
      localChargeDAO.setMoney(str6);
      localChargeDAO.setCheck_id(str7);
      localChargeDAO.setAccount_id(str8);
      localChargeDAO.setRsrv_str1("");
      localChargeDAO.setRsrv_str2("");
      localChargeDAO.setRsrv_str3("");
      localChargeDAO.setRsrv_str4("");
      i = addCharge(localChargeDAO);
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
    this.log.LOG_INFO("退出addChannel方法...");
  }

  public int addCharge(ChargeDAO paramChargeDAO)
    throws SaasApplicationException
  {
    ChargeExt localChargeExt = new ChargeExt();
    localChargeExt.setParam(":VCHARGE_ID", paramChargeDAO.getCharge_id());
    localChargeExt.setParam(":VUSER_ID", paramChargeDAO.getUser_id());
    localChargeExt.setParam(":VCUST_ID", paramChargeDAO.getCust_id());
    localChargeExt.setParam(":VEXPIRE_DATE", paramChargeDAO.getExpire_date());
    localChargeExt.setParam(":VMONEY", paramChargeDAO.getMoney());
    localChargeExt.setParam(":VACCOUNT_ID", paramChargeDAO.getAccount_id());
    localChargeExt.setParam(":VCHECK_ID", paramChargeDAO.getCheck_id());
    localChargeExt.setParam(":VBUYFORDAYS", paramChargeDAO.getBuyfordays());
    localChargeExt.setParam(":VRSRV_STR1", paramChargeDAO.getRsrv_str1());
    localChargeExt.setParam(":VRSRV_STR2", paramChargeDAO.getRsrv_str2());
    localChargeExt.setParam(":VRSRV_STR3", paramChargeDAO.getRsrv_str3());
    localChargeExt.setParam(":VRSRV_STR4", paramChargeDAO.getRsrv_str4());
    this.log.LOG_INFO("开始执行SQL:===:addCharge");
    this.tradeQuery.executeBy(localChargeExt.insBy("INS_BY_CHARGE"));
    return 0;
  }

  public ArrayList getChannelList()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_INFO");
    return localArrayList;
  }

  public int getChannelInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_INFO");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getChannel(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_BY_CH_ID");
    return localArrayList;
  }

  public ArrayList getChannelBySaveDir(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VSAVE_DIR", paramString);
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_BY_SAVE_DIR");
    return localArrayList;
  }

  public int getInfoByCustId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChargeExt localChargeExt = new ChargeExt();
    localChargeExt.setParam(":VCUST_ID", paramString);
    localArrayList = localChargeExt.selByList("SEL_CHARGE_BY_CUSTID");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getInfoByCustId(String paramString, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 0)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    ChargeExt localChargeExt = new ChargeExt();
    localChargeExt.setParam(":VCUST_ID", paramString);
    localArrayList = localChargeExt.selByList("SEL_CHARGE_BY_CUSTID", paramInt1, paramInt2);
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public String getCustEndDate(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ChargeExt localChargeExt = new ChargeExt();
    HashMap localHashMap = new HashMap();
    String str = "";
    localChargeExt.setParam(":VCUST_ID", paramString);
    localArrayList = localChargeExt.selByList("SEL_ENDDATE_BY_CUSTID");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      localHashMap = (HashMap)localArrayList.get(0);
      if (null != localHashMap.get("cust_end_date"))
        str = localHashMap.get("cust_end_date").toString();
    }
    return str;
  }

  public String calcExpireDate(int paramInt)
    throws SaasApplicationException
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (paramInt == 12)
      i = 365;
    else
      i = paramInt * 30;
    localCalendar.add(5, i);
    String str = DateUtils.formateDateToNumber(localCalendar);
    return str;
  }

  public void setendDate(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入setendDate方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("EXPIRE_DATE");
    i = setendDate(str1, str2);
    if (i != 0)
    {
      this.log.LOG_INFO("业务处理失败...");
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.log.LOG_INFO("业务处理成功...");
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出setendDate方法...");
  }

  public int setendDate(String paramString1, String paramString2)
  {
    ChargeExt localChargeExt = new ChargeExt();
    localChargeExt.setParam(":VCUST_ID", paramString1);
    localChargeExt.setParam(":VEND_DATE", paramString2);
    this.tradeQuery.executeBy(localChargeExt.insBy("UPDATE_ENDDATE_BY_CUSTID"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.chargeMgr.ChargeInfo
 * JD-Core Version:    0.6.0
 */