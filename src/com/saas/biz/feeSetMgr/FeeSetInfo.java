package com.saas.biz.feeSetMgr;

import com.saas.biz.dao.feesetDAO.feesetExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.StringTokenizer;
import tools.util.DateUtils;

public class FeeSetInfo
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

  public void AddFeeSet(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入AddFeeSet方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("TRADE_ID");
      String str2 = paramBuffers.getString("LEVEL_ID");
      String str3 = paramBuffers.getString("LIMIT_TIME");
      String str4 = paramBuffers.getString("FEE");
      i = AddFeeSet(str1, str2, str3, str4);
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
    this.log.LOG_INFO("退出AddFeeSet方法...");
  }

  public int AddFeeSet(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    feesetExt localfeesetExt = new feesetExt();
    localfeesetExt.setParam(":VTRADE_ID", paramString1);
    localfeesetExt.setParam(":VLEVEL_ID", paramString2);
    localfeesetExt.setParam(":VLIMIT_TIME", paramString3);
    localfeesetExt.setParam(":VFEE", paramString4);
    this.tradeQuery.executeBy(localfeesetExt.insBy("IN_FEE_BY_ALL"));
    return 0;
  }

  public void UpdateFeeSet(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入UpdateFeeSet方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("TRADE_ID");
      String str2 = paramBuffers.getString("LEVEL_ID");
      String str3 = paramBuffers.getString("LIMIT_TIME");
      String str4 = paramBuffers.getString("FEE");
      i = UpdateFeeSet(str1, str2, str3, str4);
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
    this.log.LOG_INFO("退出UpdateFeeSet方法...");
  }

  public int UpdateFeeSet(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    feesetExt localfeesetExt = new feesetExt();
    localfeesetExt.setParam(":VTRADE_ID", paramString1);
    localfeesetExt.setParam(":VLEVEL_ID", paramString2);
    localfeesetExt.setParam(":VLIMIT_TIME", paramString3);
    localfeesetExt.setParam(":VFEE", paramString4);
    this.tradeQuery.executeBy(localfeesetExt.insBy("UPDATE_FEE_BY_ID"));
    return 0;
  }

  public void DeleteFeeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteFeeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = DeleteFeeInfo(str2);
      }
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
    this.log.LOG_INFO("退出DeleteSaleInfo方法...");
  }

  public int DeleteFeeInfo(String paramString)
    throws SaasApplicationException
  {
    feesetExt localfeesetExt = new feesetExt();
    localfeesetExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localfeesetExt.insBy("DEL_BY_TEADE_ID"));
    return 0;
  }

  public ArrayList getAllByNone(int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 10;
    ArrayList localArrayList = new ArrayList();
    feesetExt localfeesetExt = new feesetExt();
    localArrayList = localfeesetExt.selByList("SEL_BY_ALL_BY_NONE", paramInt, 10);
    return localArrayList;
  }

  public int getAllByNone()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    feesetExt localfeesetExt = new feesetExt();
    localArrayList = localfeesetExt.selByList("SEL_BY_ALL_BY_NONE");
    if (null != localArrayList)
      return localArrayList.size();
    return 0;
  }

  public ArrayList GetOneById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    feesetExt localfeesetExt = new feesetExt();
    localfeesetExt.setParam(":VTRADE_ID", paramString);
    localArrayList = localfeesetExt.selByList("SET_ONE_BY_ID");
    return localArrayList;
  }

  public ArrayList GetAllByLevel(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    feesetExt localfeesetExt = new feesetExt();
    localfeesetExt.setParam(":VLEVEL_ID", paramString);
    localArrayList = localfeesetExt.selByList("SET_ONE_BY_LEVEL_ID");
    return localArrayList;
  }

  public String getFee(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = GetOneById(paramString);
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("fee") != null)
        str = localHashMap.get("fee").toString();
    }
    return str;
  }

  public String getFeeMoneyTime(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = GetOneById(paramString);
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("limit_time") != null)
        str = localHashMap.get("limit_time").toString();
    }
    int i = 0;
    for (int j = 0; j < str.length(); j++)
    {
      if ((str.charAt(j) < '0') || (str.charAt(j) > '9'))
        continue;
      i = str.charAt(j) - '0' + i * 10;
    }
    if (str.indexOf("月") != -1)
      i *= 30;
    if (str.indexOf("年") != -1)
      i *= 365;
    if (str.indexOf("季度") != -1)
      i *= 120;
    str = i + "";
    return str;
  }

  public String getFeeTime(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = GetOneById(paramString);
    String str1 = "";
    String str2 = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("limit_time") != null)
        str1 = localHashMap.get("limit_time").toString();
    }
    int i = 0;
    for (int j = 0; j < str1.length(); j++)
    {
      if ((str1.charAt(j) < '0') || (str1.charAt(j) > '9'))
        continue;
      i = str1.charAt(j) - '0' + i * 10;
    }
    if (str1.indexOf("月") != -1)
      i *= 30;
    if (str1.indexOf("年") != -1)
      i *= 365;
    if (str1.indexOf("季度") != -1)
      i *= 120;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, i);
    String str3 = DateUtils.formateDateToNumber(localCalendar);
    return str3;
  }

  public String SetLimitTime(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = GetOneById(paramString);
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("limit_time") != null)
        str = localHashMap.get("limit_time").toString();
    }
    return str;
  }

  public int GetLimitTime(String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("退出GetLimitTime方法..." + paramString + "********************");
    ArrayList localArrayList = new ArrayList();
    feesetExt localfeesetExt = new feesetExt();
    String str1 = "";
    String str2 = "";
    int i ;
    for (  i = 0; i < paramString.length(); i++)
      if (paramString.charAt(i) != '*')
      {
        str1 = str1 + paramString.charAt(i);
      }
      else
      {
        i++;
        break;
      }
    for (int j = i; j < paramString.length(); j++)
      str2 = str2 + paramString.charAt(j);
    localfeesetExt.setParam(":VLEVEL_ID", str1);
    localfeesetExt.setParam(":VLIMIT_TIME", str2);
    localArrayList = localfeesetExt.selByList("SET_BY_LEVEL_ID_AND_TIME");
    if (null != localArrayList)
    {
      this.log.LOG_INFO("退出GetLimitTime方法..." + localArrayList.size() + "********************");
      return 1;
    }
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.feeSetMgr.FeeSetInfo
 * JD-Core Version:    0.6.0
 */