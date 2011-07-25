package com.saas.biz.CollectionsMgr;

import com.saas.biz.dao.CollectionDAO.CollectionDAO;
import com.saas.biz.dao.CollectionDAO.CollectionExt;
import com.saas.biz.userMgr.UserCheckMgr;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class CollectionsInfo
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

  public void addCollectionsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCollectionsInfo方法...");
    this.outBuffer = paramBuffers;
    CollectionDAO localCollectionDAO = new CollectionDAO();
    int i = -1;
    try
    {
      HashMap localHashMap = new UserCheckMgr().Exists(paramBuffers.getString("USER_NAME"), paramBuffers.getString("PASSWD"));
      this.log.LOG_INFO("33333333333333333333");
      if ((localHashMap != null) && (localHashMap.size() > 0))
      {
        String str1 = localHashMap.get("cust_id").toString();
        String str2 = localHashMap.get("user_id").toString();
        String str3 = paramBuffers.getString("LINK_NAME");
        String str4 = paramBuffers.getString("LINK");
        String str5 = paramBuffers.getString("LINK_TYPE");
        String str6 = paramBuffers.getString("LINK_DESC");
        this.log.LOG_INFO("11111111111111111111111111111");
        i = addCollectionsInfo(str1, str2, str3, str4, str5, str6);
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
  }

  public int addCollectionsInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入addCollectionsInfo22222方法...");
    CollectionExt localCollectionExt = new CollectionExt();
    localCollectionExt.setParam(":VCUST_ID", paramString1);
    localCollectionExt.setParam(":VUSER_ID", paramString2);
    localCollectionExt.setParam(":VLINK_NAME", paramString3);
    localCollectionExt.setParam(":VLINK", paramString4);
    localCollectionExt.setParam(":VLINK_TYPE", paramString5);
    localCollectionExt.setParam(":VLINK_CLASS", "");
    localCollectionExt.setParam(":VLINK_DESC", paramString6);
    localCollectionExt.setParam(":VLINK_NO", "");
    localCollectionExt.setParam(":VFROM_WEB", "");
    localCollectionExt.setParam(":VRSRV_STR1", "");
    localCollectionExt.setParam(":VRSRV_STR2", "");
    localCollectionExt.setParam(":VRSRV_STR3", "");
    localCollectionExt.setParam(":VRSRV_STR4", "");
    localCollectionExt.setParam(":VRSRV_STR5", "");
    localCollectionExt.setParam(":VRSRV_STR6", "");
    localCollectionExt.setParam(":VRSRV_STR7", "");
    localCollectionExt.setParam(":VRSRV_STR8", "");
    localCollectionExt.setParam(":VRSRV_STR9", "");
    localCollectionExt.setParam(":VRSRV_STR10", "");
    localCollectionExt.setParam(":VOPER_USER_ID", paramString2);
    localCollectionExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localCollectionExt.insBy("INS_BY_ALL"));
    this.log.LOG_INFO("退出addCollectionsInfo22222方法...");
    return 0;
  }

  public ArrayList genCustCollections(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CollectionExt localCollectionExt = new CollectionExt();
    localCollectionExt.setParam(":VCUST_ID", paramString1);
    localCollectionExt.setParam(":VLINK_TYPE", paramString2);
    localArrayList = localCollectionExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList searchCust(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CollectionExt localCollectionExt = new CollectionExt();
    localCollectionExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCollectionExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.CollectionsMgr.CollectionsInfo
 * JD-Core Version:    0.6.0
 */