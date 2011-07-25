package com.saas.biz.custstoreMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.custstoreDAO.CuststoreExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class CuststoreInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
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

  public void addCuststoreInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCuststoreInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("STORE_ID");
    try
    {
      if (str2.equals(""))
        i = 0;
      else
        i = addCuststoreInfo(str1, str2);
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
    this.log.LOG_INFO("退出addCuststoreInfo方法...");
  }

  public int addCuststoreInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CuststoreExt localCuststoreExt = new CuststoreExt();
    localCuststoreExt.setParam(":VCUST_ID", paramString1);
    localCuststoreExt.setParam(":VSTORE_ID", paramString2);
    this.tradeQuery.executeBy(localCuststoreExt.insBy("INS_ALL_CUSTSTORE"));
    return 0;
  }

  public void updateCuststoreInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCuststoreInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("STORE_ID");
    this.log.LOG_INFO("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" + str1 + str2);
    try
    {
      i = updateCuststoreInfo(str1, str2);
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
    this.log.LOG_INFO("退出addCuststoreInfo方法...");
  }

  public int updateCuststoreInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CuststoreExt localCuststoreExt = new CuststoreExt();
    localCuststoreExt.setParam(":VCUST_ID", paramString1);
    localCuststoreExt.setParam(":VSTORE_ID", paramString2);
    this.tradeQuery.executeBy(localCuststoreExt.insBy("UPDATE_ALL_CUSTSTORE"));
    return 0;
  }

  public HashMap getOneCuststore(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    CuststoreExt localCuststoreExt = new CuststoreExt();
    HashMap localHashMap = new HashMap();
    localCuststoreExt.setParam(":VSTORE_ID", paramString);
    localArrayList = localCuststoreExt.selByList("SEL_ONE_CUSTSTORE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public void delCuststoreInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delCustPublicInfo方法...");
    int i = -1;
    String str = paramBuffers.getString("STORE_ID");
    try
    {
      i = delCuststoreInfo(str);
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
    this.log.LOG_INFO("退出delCustPublicInfo方法...");
  }

  public int delCuststoreInfo(String paramString)
    throws SaasApplicationException
  {
    CuststoreExt localCuststoreExt = new CuststoreExt();
    localCuststoreExt.setParam(":VSTORE_ID", paramString);
    this.tradeQuery.executeBy(localCuststoreExt.insBy("DEL_ONE_CUSTSTORE"));
    return 0;
  }

  public ArrayList getAllCuststore(int paramInt)
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CuststoreExt localCuststoreExt = new CuststoreExt();
    localArrayList = localCuststoreExt.selByList("SEL_ALL_CUSTSTORE", paramInt, 20);
    return localArrayList;
  }

  public int getAllCuststore()
  {
    ArrayList localArrayList = new ArrayList();
    CuststoreExt localCuststoreExt = new CuststoreExt();
    localArrayList = localCuststoreExt.selByList("SEL_ALL_CUSTSTORE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllCuststoreLike(int paramInt, String paramString)
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CuststoreExt localCuststoreExt = new CuststoreExt();
    localCuststoreExt.setParam(":VSTORE_ID", "%" + paramString + "%");
    localArrayList = localCuststoreExt.selByList("SEL_ALL_CUSTSTORE_LIKE", paramInt, 20);
    return localArrayList;
  }

  public int getAllCuststoreLike(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    CuststoreExt localCuststoreExt = new CuststoreExt();
    localCuststoreExt.setParam(":VSTORE_ID", "%" + paramString + "%");
    localArrayList = localCuststoreExt.selByList("SEL_ALL_CUSTSTORE_LIKE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.custstoreMgr.CuststoreInfo
 * JD-Core Version:    0.6.0
 */