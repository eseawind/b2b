package com.saas.biz.clickMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.clickDAO.ClickExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ClickInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();
  commMethodMgr comm = new commMethodMgr();

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

  public void addClick(Buffers paramBuffers)
  {
    this.inBuffer = paramBuffers;
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("ROOT_ID");
      String str2 = paramBuffers.getString("CLICK_TYPE");
      String str3 = paramBuffers.getString("CUST_ID");
      i = addClick(str3, str1, str2, "0");
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
    this.log.LOG_INFO("退出addClick方法...");
  }

  public int addClick(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ClickExt localClickExt = new ClickExt();
    localClickExt.setParam(":VROOT_ID", paramString2);
    localClickExt.setParam(":VCLICK_TYPE", paramString3);
    localClickExt.setParam(":VCLICK_COUNT", paramString4);
    localClickExt.setParam(":VCUST_ID", paramString1);
    this.tradeQuery.executeBy(localClickExt.insBy("INS_BY_CLICK"));
    return 0;
  }

  public int getClick(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ClickExt localClickExt = new ClickExt();
    localClickExt.setParam(":VROOT_ID", paramString);
    localArrayList = localClickExt.selByList("SEL_CLICKS_BY_ROOT_ID");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("count").toString());
    }
    return i;
  }

  public ArrayList getTopClick(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ClickExt localClickExt = new ClickExt();
    localClickExt.setParam(":VCLICK_TYPE", paramString);
    localArrayList = localClickExt.selByList("SEL_TOP_CLICK", 0, paramInt);
    return localArrayList;
  }

  public ArrayList getTopSearchWords(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClickExt localClickExt = new ClickExt();
    localArrayList = localClickExt.selByList("SEL_TOP_SEARCH_WORDS", 0, paramInt);
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.clickMgr.ClickInfo
 * JD-Core Version:    0.6.0
 */