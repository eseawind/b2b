package com.saas.biz.ondutyMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.ondutyDAO.OndutyExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class OndutyInfo
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

  public void addOndutyInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addOndutyInfo方法...");
    String str1 = paramBuffers.getString("ZT");
    String str2 = paramBuffers.getString("REASON");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    String str4 = paramBuffers.getString("DEPART_CODE");
    int i = -1;
    try
    {
      i = addOndutyInfo(str1, str2, str3, str4);
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
    this.log.LOG_INFO("退出addOndutyInfo方法...");
  }

  public int addOndutyInfo(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    OndutyExt localOndutyExt = new OndutyExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    localOndutyExt.setParam(":VID", str);
    localOndutyExt.setParam(":VZT", paramString1);
    localOndutyExt.setParam(":VREASON", paramString2);
    localOndutyExt.setParam(":VUSER", paramString3);
    localOndutyExt.setParam(":VPART", paramString4);
    localOndutyExt.setParam(":VCHECKED", "1");
    this.tradeQuery.executeBy(localOndutyExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList getOndutyList(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OndutyExt localOndutyExt = new OndutyExt();
    try
    {
      paramInt *= 20;
      localOndutyExt.setParam(":VUSER", paramString1);
      localOndutyExt.setParam(":VSTART_DATE", paramString2);
      localOndutyExt.setParam(":VEND_DATE", paramString3);
      localArrayList = localOndutyExt.selByList("SEL_BY_USER", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getDateQueryCount(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OndutyExt localOndutyExt = new OndutyExt();
    int i = 0;
    try
    {
      localOndutyExt.setParam(":VUSER", paramString1);
      localOndutyExt.setParam(":VSTART_DATE", paramString2);
      localOndutyExt.setParam(":VEND_DATE", paramString3);
      localArrayList = localOndutyExt.selByList("SEL_BY_USER_CT");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        if (localHashMap.get("ct") != null)
          i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return i;
  }

  public ArrayList getDepOndutyList(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OndutyExt localOndutyExt = new OndutyExt();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      localOndutyExt.setParam(":VPART", paramString1);
      localOndutyExt.setParam(":VSTART_DATE", paramString2);
      localOndutyExt.setParam(":VEND_DATE", paramString3);
      localArrayList = localOndutyExt.selByList("SEL_BY_DEP", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getDepOndutyCount(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OndutyExt localOndutyExt = new OndutyExt();
    this.log.LOG_INFO("start_date==" + paramString2 + "end_date==" + paramString3);
    int i = 0;
    try
    {
      localOndutyExt.setParam(":VPART", paramString1);
      localOndutyExt.setParam(":VSTART_DATE", paramString2);
      localOndutyExt.setParam(":VEND_DATE", paramString3);
      localArrayList = localOndutyExt.selByList("SEL_BY_DEP_CT");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        if (localHashMap.get("ct") != null)
          i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.ondutyMgr.OndutyInfo
 * JD-Core Version:    0.6.0
 */