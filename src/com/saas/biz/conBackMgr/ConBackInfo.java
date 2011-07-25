package com.saas.biz.conBackMgr;

import com.saas.biz.dao.conbackDAO.ConbackExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ConBackInfo
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

  public void addConbackInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addConbackInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("BACK_ID");
    String str3 = paramBuffers.getString("CON_NO");
    String str4 = paramBuffers.getString("BACK_DATE");
    String str5 = paramBuffers.getString("BACK_REASON");
    String str6 = paramBuffers.getString("PUBLISH_DATE");
    String str7 = paramBuffers.getString("SESSION_USER_ID");
    String str8 = paramBuffers.getString("REMARK");
    String str9 = "";
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str3, "|");
      while (localStringTokenizer.hasMoreTokens())
      {
        str9 = localStringTokenizer.nextToken();
        i = addConbackInfo(str1, str2, str9, str4, str5, str6, str7, str8);
      }
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
    this.log.LOG_INFO("退出addConuseInfo方法...");
  }

  public int addConbackInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws SaasApplicationException
  {
    ConbackExt localConbackExt = new ConbackExt();
    localConbackExt.setParam(":VCUST_ID", paramString1);
    localConbackExt.setParam(":VBACK_ID", paramString2);
    localConbackExt.setParam(":VCON_NO", paramString3);
    localConbackExt.setParam(":VBACK_DATE", paramString4);
    localConbackExt.setParam(":VBACK_REASON", paramString5);
    localConbackExt.setParam(":VPUBLISH_DATE", paramString6);
    localConbackExt.setParam(":VUSER_ID", paramString7);
    localConbackExt.setParam(":VREMARK", paramString8);
    this.tradeQuery.executeBy(localConbackExt.insBy("INS_BY_CON_BACK"));
    return 0;
  }

  public ArrayList getAllConback(String paramString)
    throws SaasApplicationException
  {
    ConbackExt localConbackExt = new ConbackExt();
    localConbackExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localConbackExt.selByList("SEL_ALL_CONBACK");
    return localArrayList;
  }

  public ArrayList getAllConBackConNo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ConbackExt localConbackExt = new ConbackExt();
    localConbackExt.setParam(":VCUST_ID", paramString1);
    localConbackExt.setParam(":VBACK_ID", paramString2);
    ArrayList localArrayList = localConbackExt.selByList("SEL_ALL_CONNO");
    return localArrayList;
  }

  public void DelConback(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入DelConback方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("BACK_ID");
    String str3 = paramBuffers.getString("CON_NO");
    String str4 = "";
    String str5 = "";
    try
    {
      StringTokenizer localStringTokenizer1 = new StringTokenizer(str3, "|");
      StringTokenizer localStringTokenizer2 = new StringTokenizer(str2, "|");
      while (localStringTokenizer1.hasMoreTokens())
      {
        str5 = localStringTokenizer2.nextToken();
        str4 = localStringTokenizer1.nextToken();
        i = DelConback(str1, str5, str4);
      }
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
    this.log.LOG_INFO("退出DelConList方法...");
  }

  public int DelConback(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ConbackExt localConbackExt = new ConbackExt();
    localConbackExt.setParam(":VCUST_ID", paramString1);
    localConbackExt.setParam(":VBACK_ID", paramString2);
    localConbackExt.setParam(":VCON_NO", paramString3);
    this.tradeQuery.executeBy(localConbackExt.insBy("DEL_CON_BACK"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.conBackMgr.ConBackInfo
 * JD-Core Version:    0.6.0
 */