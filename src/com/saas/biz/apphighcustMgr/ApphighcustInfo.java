package com.saas.biz.apphighcustMgr;

import com.saas.biz.dao.highCustDao.AppCustInfoDao;
import com.saas.biz.dao.highCustDao.AppCustInfoExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class ApphighcustInfo
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

  public void addHighCustInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addadvertiseInfo方法...");
    this.outBuffer = paramBuffers;
    AppCustInfoDao localAppCustInfoDao = new AppCustInfoDao();
    localAppCustInfoDao.setTrade_id(paramBuffers.getString("TRADE_ID"));
    localAppCustInfoDao.setCust_id(paramBuffers.getString("CUST_ID"));
    localAppCustInfoDao.setApp_level(paramBuffers.getString("APP_LEVEL"));
    localAppCustInfoDao.setUser_id(paramBuffers.getString("USER_ID"));
    localAppCustInfoDao.setPass_or_not(paramBuffers.getString("PASS_OR_NOT"));
    localAppCustInfoDao.setNow_class_type(paramBuffers.getString("NOW_CLASS_TYPE"));
    int i = -1;
    try
    {
      i = addHighCustInfo(localAppCustInfoDao);
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

  public int addHighCustInfo(AppCustInfoDao paramAppCustInfoDao)
    throws SaasApplicationException
  {
    AppCustInfoExt localAppCustInfoExt = new AppCustInfoExt();
    localAppCustInfoExt.setParam(":VTRADE_ID", paramAppCustInfoDao.getTrade_id());
    localAppCustInfoExt.setParam(":VCUST_ID", paramAppCustInfoDao.getCust_id());
    localAppCustInfoExt.setParam(":VAPP_LEVEL", paramAppCustInfoDao.getApp_level());
    localAppCustInfoExt.setParam(":VUSER_ID", paramAppCustInfoDao.getUser_id());
    localAppCustInfoExt.setParam(":VPASS_OR_NOT", paramAppCustInfoDao.getPass_or_not());
    localAppCustInfoExt.setParam(":VNOW_CLASS_TYPE", paramAppCustInfoDao.getNow_class_type());
    this.tradeQuery.executeBy(localAppCustInfoExt.insBy("INS_BY_ALL_HIGH_CUST"));
    return 0;
  }

  public ArrayList getAllApp(int paramInt)
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    AppCustInfoExt localAppCustInfoExt = new AppCustInfoExt();
    localArrayList = localAppCustInfoExt.selByList("SEL_ALL_APP", paramInt, 20);
    return localArrayList;
  }

  public int getAllApp()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    AppCustInfoExt localAppCustInfoExt = new AppCustInfoExt();
    localArrayList = localAppCustInfoExt.selByList("SEL_ALL_APP");
    if (null != localArrayList)
      i = localArrayList.size();
    return i;
  }

  public void updateCustClass(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateCustClass方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("TRADE_ID");
      String str2 = paramBuffers.getString("NOW_CLASS_TYPE");
      i = updateCustClassT(str1, str2);
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
    this.log.LOG_INFO("退出updateCustClass方法...");
  }

  public int updateCustClassT(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    AppCustInfoExt localAppCustInfoExt = new AppCustInfoExt();
    localAppCustInfoExt.setParam(":VTRADE_ID", paramString1);
    localAppCustInfoExt.setParam(":VNOW_CLASS_TYPE", paramString2);
    this.tradeQuery.executeBy(localAppCustInfoExt.insBy("UPDATE_CUST_CLASS"));
    return 0;
  }

  public ArrayList getByKey(int paramInt, String paramString)
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    AppCustInfoExt localAppCustInfoExt = new AppCustInfoExt();
    localAppCustInfoExt.setParam(":VCUST_AIM", "%" + paramString + "%");
    localArrayList = localAppCustInfoExt.selByList("SEL_ALL_APP_KEY", paramInt, 20);
    return localArrayList;
  }

  public int getByKey(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    AppCustInfoExt localAppCustInfoExt = new AppCustInfoExt();
    localAppCustInfoExt.setParam(":VCUST_AIM", "%" + paramString + "%");
    localArrayList = localAppCustInfoExt.selByList("SEL_ALL_APP_KEY");
    if (null != localArrayList)
      return localArrayList.size();
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.apphighcustMgr.ApphighcustInfo
 * JD-Core Version:    0.6.0
 */