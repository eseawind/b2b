package com.saas.biz.advertiseMgr;

import com.saas.biz.dao.advertiseDAO.AdvertiseExt;
import com.saas.biz.dao.attachDAO.AttachExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AdvertiseInfo
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

  public void addadvertiseInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addadvertiseInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("CUST_ADV_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("ADV_ID");
    String str4 = paramBuffers.getString("CH_ID");
    String str5 = paramBuffers.getString("ADV_NAME");
    String str6 = paramBuffers.getString("TIME_LIMIT");
    String str7 = paramBuffers.getString("START_DATE");
    String str8 = paramBuffers.getString("END_DATE");
    String str9 = paramBuffers.getString("N_CONTENT");
    String str10 = paramBuffers.getString("P_CONTENT");
    int i = -1;
    try
    {
      i = addadvertiseInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10);
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

  public int addadvertiseInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
    throws SaasApplicationException
  {
    AdvertiseExt localAdvertiseExt = new AdvertiseExt();
    localAdvertiseExt.setParam(":VCUST_ADV_ID", paramString1);
    localAdvertiseExt.setParam(":VCUST_ID", paramString2);
    localAdvertiseExt.setParam(":VADV_ID", paramString3);
    localAdvertiseExt.setParam(":VCH_ID", paramString4);
    localAdvertiseExt.setParam(":VADV_NAME", paramString5);
    localAdvertiseExt.setParam(":VTIME_LIMIT", paramString6);
    localAdvertiseExt.setParam(":VSTART_DATE", paramString7);
    localAdvertiseExt.setParam(":VEND_DATE", paramString8);
    localAdvertiseExt.setParam(":VN_CONTENT", paramString9);
    localAdvertiseExt.setParam(":VP_CONTENT", paramString10);
    this.tradeQuery.executeBy(localAdvertiseExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateadvertiseInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateadvertiseInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("CUST_ADV_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("ADV_ID");
    String str4 = paramBuffers.getString("CH_ID");
    String str5 = paramBuffers.getString("ADV_NAME");
    String str6 = paramBuffers.getString("TIME_LIMIT");
    String str7 = paramBuffers.getString("START_DATE");
    String str8 = paramBuffers.getString("END_DATE");
    String str9 = paramBuffers.getString("N_CONTENT");
    String str10 = paramBuffers.getString("P_CONTENT");
    int i = -1;
    try
    {
      i = updateadvertiseInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10);
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

  public int updateadvertiseInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
    throws SaasApplicationException
  {
    AdvertiseExt localAdvertiseExt = new AdvertiseExt();
    localAdvertiseExt.setParam(":VCUST_ADV_ID", paramString1);
    localAdvertiseExt.setParam(":VCUST_ID", paramString2);
    localAdvertiseExt.setParam(":VADV_ID", paramString3);
    localAdvertiseExt.setParam(":VCH_ID", paramString4);
    localAdvertiseExt.setParam(":VADV_NAME", paramString5);
    localAdvertiseExt.setParam(":VTIME_LIMIT", paramString6);
    localAdvertiseExt.setParam(":VSTART_DATE", paramString7);
    localAdvertiseExt.setParam(":VEND_DATE", paramString8);
    localAdvertiseExt.setParam(":VN_CONTENT", paramString9);
    localAdvertiseExt.setParam(":VP_CONTENT", paramString10);
    this.tradeQuery.executeBy(localAdvertiseExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public ArrayList genCustAdvertise(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AdvertiseExt localAdvertiseExt = new AdvertiseExt();
    localAdvertiseExt.setParam(":VCUST_ID", paramString);
    localArrayList = localAdvertiseExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList genOneAdvertise(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AdvertiseExt localAdvertiseExt = new AdvertiseExt();
    localAdvertiseExt.setParam(":VADV_ID", paramString);
    localArrayList = localAdvertiseExt.selByList("SEL_BY_ONE");
    return localArrayList;
  }

  public void deloneinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deloneinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("ADV_ID");
    try
    {
      i = deloneinfo(str);
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
    this.log.LOG_INFO("退出deloneinfo方法...");
  }

  public void DeleteOneInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("ADV_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = deloneinfo(str2);
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

  public int deloneinfo(String paramString)
    throws SaasApplicationException
  {
    AdvertiseExt localAdvertiseExt = new AdvertiseExt();
    localAdvertiseExt.setParam(":VADV_ID", paramString);
    this.tradeQuery.executeBy(localAdvertiseExt.insBy("DEL_BY_ONE"));
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VROOT_ID", paramString);
    this.tradeQuery.executeBy(localAttachExt.insBy("DELETE_BY_ROOT"));
    return 0;
  }

  public ArrayList genCustAdvertise(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    AdvertiseExt localAdvertiseExt = new AdvertiseExt();
    localAdvertiseExt.setParam(":VCUST_ID", paramString);
    localArrayList = localAdvertiseExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getAdvertNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AdvertiseExt localAdvertiseExt = new AdvertiseExt();
    localAdvertiseExt.setParam(":VCUST_ID", paramString);
    localArrayList = localAdvertiseExt.selByList("SEL_BY_CUST");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int checkCustAdvId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AdvertiseExt localAdvertiseExt = new AdvertiseExt();
    localAdvertiseExt.setParam(":VCUST_ADV_ID", paramString);
    localArrayList = localAdvertiseExt.selByList("SEL_BY_CUST_ADV_ID");
    if (localArrayList != null)
      return 1;
    return 0;
  }

  public ArrayList getInfoByCustAdvId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AdvertiseExt localAdvertiseExt = new AdvertiseExt();
    localAdvertiseExt.setParam(":VCUST_ADV_ID", paramString);
    localArrayList = localAdvertiseExt.selByList("SEL_BY_CUST_ADV_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.advertiseMgr.AdvertiseInfo
 * JD-Core Version:    0.6.0
 */