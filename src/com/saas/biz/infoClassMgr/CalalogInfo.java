package com.saas.biz.infoClassMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.infoclassDAO.InfoClassExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class CalalogInfo
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

  public ArrayList getSaleInfoByClassGroup(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 0)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localInfoClassExt.selByList("SEL_SALE_BY_CLASS", paramInt1, paramInt2);
    return localArrayList;
  }

  public String getFristClassNum(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localInfoClassExt.selByList("SEL_INFO_NUM_BY_CLASS_ID_AUTO");
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      str = localHashMap.get("ct").toString();
    }
    return str;
  }

  public int getSaleInfoByClassCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localInfoClassExt.selByList("SEL_SALE_BY_CLASS_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getStockInfoByClassGroup(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 0)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localInfoClassExt.selByList("SEL_STOCK_BY_CLASS", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getStockInfoByClassCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localInfoClassExt.selByList("SEL_STOCK_BY_CLASS_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getEnterpriseInfoByClassGroup(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 0)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localInfoClassExt.selByList("SEL_CUSTOMER_BY_CLASS", paramInt1, paramInt2);
    return localArrayList;
  }

  public String getClassNameByRootId(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VROOT_ID", paramString);
    ArrayList localArrayList = localInfoClassExt.selByList("SEL_CLASSNAME_BY_ROOTID");
    if (null != localArrayList)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("class_name") != null)
        str = localHashMap.get("class_name").toString();
    }
    return str;
  }

  public int getEnterpriseInfoByClassCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localInfoClassExt.selByList("SEL_CUSTOMER_BY_CLASS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.infoClassMgr.CalalogInfo
 * JD-Core Version:    0.6.0
 */