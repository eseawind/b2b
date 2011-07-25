package com.saas.biz.oppProMgr;

import com.saas.biz.dao.oppProDAO.OppProExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class OppProInfo
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

  public void addOppProInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addOppProInfo方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PROJ_NAME");
    String str3 = paramBuffers.getString("PROJ_ID");
    String str4 = paramBuffers.getString("TITLE");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("START_DATE");
    String str7 = paramBuffers.getString("END_DATE");
    String str8 = paramBuffers.getString("OWN_CUST_ID");
    String str9 = paramBuffers.getString("OWN_CUST_NAME");
    String str10 = paramBuffers.getString("USER_ID");
    String str11 = paramBuffers.getString("USER_NAME");
    this.log.LOG_INFO("user_name=======" + str11);
    String str12 = paramBuffers.getString("IN_DATE");
    String str13 = paramBuffers.getString("REMARK");
    String str14 = paramBuffers.getString("STATE_CODE");
    int i = -1;
    try
    {
      i = addOppProInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str14, str13);
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
    this.log.LOG_INFO("退出addOppProInfo方法...");
  }

  public int addOppProInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
    throws SaasApplicationException
  {
    OppProExt localOppProExt = new OppProExt();
    localOppProExt.setParam(":VCUST_ID", paramString1);
    localOppProExt.setParam(":VPROJ_NAME", paramString2);
    localOppProExt.setParam(":VPROJ_ID", paramString3);
    localOppProExt.setParam(":VTITLE", paramString4);
    localOppProExt.setParam(":VCONTENT", paramString5);
    localOppProExt.setParam(":VSTART_DATE", paramString6);
    localOppProExt.setParam(":VEND_DATE", paramString7);
    localOppProExt.setParam(":VOWN_CUST_ID", paramString8);
    localOppProExt.setParam(":VOWN_CUST_NAME", paramString9);
    localOppProExt.setParam(":VUSER_ID", paramString10);
    localOppProExt.setParam(":VUSER_NAME", paramString11);
    localOppProExt.setParam(":VIN_DATE", paramString12);
    localOppProExt.setParam(":VSTATE_CODE", paramString13);
    localOppProExt.setParam(":VREMARK", paramString14);
    this.tradeQuery.executeBy(localOppProExt.insBy("INS_OPP_PRO"));
    return 0;
  }

  public void updateOppPro(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateOppPro方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PROJ_NAME");
    String str3 = paramBuffers.getString("PROJ_ID");
    String str4 = paramBuffers.getString("TITLE");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("START_DATE");
    String str7 = paramBuffers.getString("OWN_CUST_ID");
    String str8 = paramBuffers.getString("OWN_CUST_NAME");
    String str9 = paramBuffers.getString("USER_ID");
    String str10 = paramBuffers.getString("USER_NAME");
    String str11 = paramBuffers.getString("IN_DATE");
    String str12 = paramBuffers.getString("REMARK");
    int i = -1;
    try
    {
      i = updateOppPro(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
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
    this.log.LOG_INFO("退出updateOppPro方法...");
  }

  public int updateOppPro(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
    throws SaasApplicationException
  {
    OppProExt localOppProExt = new OppProExt();
    localOppProExt.setParam(":VCUST_ID", paramString1);
    localOppProExt.setParam(":VPROJ_NAME", paramString2);
    localOppProExt.setParam(":VPROJ_ID", paramString3);
    localOppProExt.setParam(":VTITLE", paramString4);
    localOppProExt.setParam(":VCONTENT", paramString5);
    localOppProExt.setParam(":VSTART_DATE", paramString6);
    localOppProExt.setParam(":VOWN_CUST_ID", paramString7);
    localOppProExt.setParam(":VOWN_CUST_NAME", paramString8);
    localOppProExt.setParam(":VUSER_ID", paramString9);
    localOppProExt.setParam(":VUSER_NAME", paramString10);
    localOppProExt.setParam(":VIN_DATE", paramString11);
    localOppProExt.setParam(":VREMARK", paramString12);
    this.tradeQuery.executeBy(localOppProExt.insBy("UPDATE_OPP_PRO"));
    return 0;
  }

  public ArrayList getOppProList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    OppProExt localOppProExt = new OppProExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 20;
      localOppProExt.setParam(":VCUST_ID", paramString);
      localArrayList = localOppProExt.selByList("SEL_BY_OPP_PRO", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getOppProList(String paramString)
    throws SaasApplicationException
  {
    OppProExt localOppProExt = new OppProExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localOppProExt.setParam(":VCUST_ID", paramString);
      localArrayList = localOppProExt.selByList("SEL_BY_OPP_PRO");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void delOppPro(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delOppPro方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_CUST_ID");
      String str2 = paramBuffers.getString("PROJ_ID");
      i = delOppPro(str1, str2);
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
    this.log.LOG_INFO("退出delOppPro方法...");
  }

  public int delOppPro(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProExt localOppProExt = new OppProExt();
    localOppProExt.setParam(":VCUST_ID", paramString1);
    localOppProExt.setParam(":VPROJ_ID", paramString2);
    this.tradeQuery.executeBy(localOppProExt.insBy("DEL_BY_OPP_PRO"));
    return 0;
  }

  public ArrayList getOppProList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProExt localOppProExt = new OppProExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localOppProExt.setParam(":VCUST_ID", paramString1);
      localOppProExt.setParam(":VPROJ_ID", paramString2);
      localArrayList = localOppProExt.selByList("SEL_OPP_BY_PROJ_ID");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.oppProMgr.OppProInfo
 * JD-Core Version:    0.6.0
 */