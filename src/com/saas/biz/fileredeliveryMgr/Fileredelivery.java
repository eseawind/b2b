package com.saas.biz.fileredeliveryMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.fileredeliveryDao.FileredeliveryExt;
import com.saas.biz.departMgr.DepartInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Fileredelivery
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr commen = new commMethodMgr();
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

  public void addFileDelivery(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportsDelivery方法...");
    int i = -1;
    String str1 = paramBuffers.getString("TITLE");
    String str2 = paramBuffers.getString("IDX");
    String str3 = paramBuffers.getString("CONTENT");
    String str4 = paramBuffers.getString("SESSION_USER_NAME");
    String str5 = paramBuffers.getString("PART");
    String str6 = paramBuffers.getString("RPART");
    String str7 = paramBuffers.getString("PATH");
    try
    {
      i = addFileDelivery(str2, str1, str3, str4, str5, str6, str7);
    }
    catch (Exception localException)
    {
      i = -1;
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
    this.log.LOG_INFO("退出addReportsDelivery方法...");
  }

  public int addFileDelivery(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    throws SaasApplicationException
  {
    Object localObject1;
    if ((paramString6 == "all") || (paramString6.equals("all")))
    {
      localObject1 = new HashMap();
      localObject1 = new DepartInfo().getDepartByParentCode(paramString5);
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          Object localObject2 = localEntry.getKey();
          FileredeliveryExt localFileredeliveryExt = new FileredeliveryExt();
          localFileredeliveryExt.setParam(":VID", paramString1);
          localFileredeliveryExt.setParam(":VCONTENT", paramString3);
          localFileredeliveryExt.setParam(":VTITLE", paramString2);
          localFileredeliveryExt.setParam(":VPATH", paramString7);
          localFileredeliveryExt.setParam(":VPART", paramString5);
          localFileredeliveryExt.setParam(":VUSER", paramString4);
          localFileredeliveryExt.setParam(":VRPART", localObject2);
          localFileredeliveryExt.setParam(":VXCHECKED", "0");
          this.tradeQuery.executeBy(localFileredeliveryExt.insBy("INS_BY_ALL"));
        }
      }
    }
    else
    {
      localObject1 = new FileredeliveryExt();
      ((FileredeliveryExt)localObject1).setParam(":VID", this.commen.GenTradeId());
      ((FileredeliveryExt)localObject1).setParam(":VCONTENT", paramString3);
      ((FileredeliveryExt)localObject1).setParam(":VTITLE", paramString2);
      ((FileredeliveryExt)localObject1).setParam(":VPATH", paramString7);
      ((FileredeliveryExt)localObject1).setParam(":VPART", paramString5);
      ((FileredeliveryExt)localObject1).setParam(":VUSER", paramString4);
      ((FileredeliveryExt)localObject1).setParam(":VRPART", paramString6);
      ((FileredeliveryExt)localObject1).setParam(":VXCHECKED", "0");
      this.tradeQuery.executeBy(((FileredeliveryExt)localObject1).insBy("INS_BY_ALL"));
    }
    return 0;
  }

  public ArrayList getFilesDeliveryByPart(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      FileredeliveryExt localFileredeliveryExt = new FileredeliveryExt();
      localFileredeliveryExt.setParam(":VRPART", paramString);
      localFileredeliveryExt.setParam(":VXCHECKED", "0");
      localArrayList = localFileredeliveryExt.selByList("SEL_BY_RPART", paramInt, 20);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return localArrayList;
  }

  public int getFilesDeliveryByPartCT(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      FileredeliveryExt localFileredeliveryExt = new FileredeliveryExt();
      localFileredeliveryExt.setParam(":VRPART", paramString);
      localFileredeliveryExt.setParam(":VXCHECKED", "0");
      localArrayList = localFileredeliveryExt.selByList("SEL_BY_RPART_COUNT");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        if (localHashMap.get("ct") != null)
          i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return i;
  }

  public ArrayList getFileDeliveryById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      FileredeliveryExt localFileredeliveryExt = new FileredeliveryExt();
      localFileredeliveryExt.setParam(":VID", paramString);
      localFileredeliveryExt.setParam(":VXCHECKED", "0");
      localArrayList = localFileredeliveryExt.selByList("SEL_BY_ID");
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.fileredeliveryMgr.Fileredelivery
 * JD-Core Version:    0.6.0
 */