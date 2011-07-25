package com.saas.biz.feeRecorMgr;

import com.saas.biz.dao.feeRecordDAO.feeRecordExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class FeeRecordInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;

  public Buffers getInBuffer()
  {
    return this.inBuffer;
  }

  public void setInBuffer(Buffers paramBuffers)
  {
    this.inBuffer = paramBuffers;
  }

  public Logger getLog()
  {
    return this.log;
  }

  public void setLog(Logger paramLogger)
  {
    this.log = paramLogger;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public void AddFeeRecordSet(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入AddFeeRecordSet方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("TRADE_ID");
      String str2 = paramBuffers.getString("CUST_ID");
      String str3 = paramBuffers.getString("PUBLISH_USER_ID");
      String str4 = paramBuffers.getString("LEVEL_ID");
      String str5 = paramBuffers.getString("LIMIT_TIME");
      String str6 = paramBuffers.getString("FEE");
      i = AddFeeRecordSet(str1, str4, str5, str6, str2, str3);
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
    this.log.LOG_INFO("退出AddFeeRecordSet方法...");
  }

  public int AddFeeRecordSet(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    feeRecordExt localfeeRecordExt = new feeRecordExt();
    localfeeRecordExt.setParam(":VTRADE_ID", paramString1);
    localfeeRecordExt.setParam(":VLEVEL_ID", paramString2);
    localfeeRecordExt.setParam(":VLIMIT_TIME", paramString3);
    localfeeRecordExt.setParam(":VCUST_ID", paramString5);
    localfeeRecordExt.setParam(":VPUBLISH_USER_ID", paramString6);
    localfeeRecordExt.setParam(":VFEE", paramString4);
    this.tradeQuery.executeBy(localfeeRecordExt.insBy("IN_FEE_BY_ALL"));
    return 0;
  }

  public ArrayList getAllByNone(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    feeRecordExt localfeeRecordExt = new feeRecordExt();
    ArrayList localArrayList = new ArrayList();
    localfeeRecordExt.setParam(":VCUST_ID", paramString);
    localArrayList = localfeeRecordExt.selByList("SEL_BY_ALL_BY_NONE", paramInt, 20);
    return localArrayList;
  }

  public int getAllByNone(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    feeRecordExt localfeeRecordExt = new feeRecordExt();
    localfeeRecordExt.setParam(":VCUST_ID", paramString);
    localArrayList = localfeeRecordExt.selByList("SEL_BY_ALL_BY_NONE");
    if (null != localArrayList)
      return localArrayList.size();
    return 0;
  }

  public ArrayList AddmingetAll(int paramInt)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    feeRecordExt localfeeRecordExt = new feeRecordExt();
    ArrayList localArrayList = new ArrayList();
    localArrayList = localfeeRecordExt.selByList("SEL_BY_ALL_BY_ADMIN", paramInt, 20);
    return localArrayList;
  }

  public int AddmingetAll()
    throws SaasApplicationException
  {
    feeRecordExt localfeeRecordExt = new feeRecordExt();
    ArrayList localArrayList = new ArrayList();
    localArrayList = localfeeRecordExt.selByList("SEL_BY_ALL_BY_ADMIN");
    if (null != localArrayList)
      return localArrayList.size();
    return 0;
  }

  public void UpdateCustTime(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入UpdateCustTime方法...");
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("LIMIT_TIME");
    String str3 = paramBuffers.getString("LEVEL_ID");
    try
    {
      i = UpdateCustTime(str1, str2, str3);
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
    this.log.LOG_INFO("退出UpdateCustTime方法...");
  }

  public int UpdateCustTime(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    feeRecordExt localfeeRecordExt = new feeRecordExt();
    localfeeRecordExt.setParam(":VCUST_ID", paramString1);
    localfeeRecordExt.setParam(":VCUST_END_TIME", paramString2);
    localfeeRecordExt.setParam(":VLEVEL_ID", paramString3);
    this.tradeQuery.executeBy(localfeeRecordExt.insBy("UPDATE_CUST_TIME"));
    return 0;
  }

  public ArrayList getAllByCust_id(String paramString)
    throws SaasApplicationException
  {
    feeRecordExt localfeeRecordExt = new feeRecordExt();
    ArrayList localArrayList = new ArrayList();
    localfeeRecordExt.setParam(":VCUST_ID", paramString);
    localArrayList = localfeeRecordExt.selByList("SEL_ALL_BY_CUST_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.feeRecorMgr.FeeRecordInfo
 * JD-Core Version:    0.6.0
 */