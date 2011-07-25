package com.saas.biz.condelMgr;

import com.saas.biz.dao.condelDAO.CondelExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CondelInfo
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

  public void addCondelInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCondelInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("DEL_ID");
    String str3 = paramBuffers.getString("CON_NO");
    String str4 = paramBuffers.getString("DEL_DATE");
    String str5 = paramBuffers.getString("DEL_REASON");
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
        i = addCondelInfo(str1, str2, str9, str4, str5, str6, str7, str8);
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

  public int addCondelInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws SaasApplicationException
  {
    CondelExt localCondelExt = new CondelExt();
    localCondelExt.setParam(":VCUST_ID", paramString1);
    localCondelExt.setParam(":VDEL_ID", paramString2);
    localCondelExt.setParam(":VCON_NO", paramString3);
    localCondelExt.setParam(":VDEL_DATE", paramString4);
    localCondelExt.setParam(":VDEL_REASON", paramString5);
    localCondelExt.setParam(":VPUBLISH_DATE", paramString6);
    localCondelExt.setParam(":VUSER_ID", paramString7);
    localCondelExt.setParam(":VREMARK", paramString8);
    this.tradeQuery.executeBy(localCondelExt.insBy("INS_BY_CON_DEL"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.condelMgr.CondelInfo
 * JD-Core Version:    0.6.0
 */