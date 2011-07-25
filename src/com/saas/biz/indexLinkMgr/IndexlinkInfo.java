package com.saas.biz.indexLinkMgr;

import com.saas.biz.commen.Charset;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.indexLinkDAO.IndexLinkDAO;
import com.saas.biz.dao.indexLinkDAO.IndexLinkExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class IndexlinkInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();
  commMethodMgr commen = new commMethodMgr();
  Charset charset = new Charset();

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

  public void getIndexLinkInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getIndexLinkInfo方法...");
    this.outBuffer = paramBuffers;
    try
    {
      this.queryResult = getIndexLinkInfo();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getIndexLinkInfo方法...");
  }

  public ArrayList getIndexLinkInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localArrayList = localIndexLinkExt.selByList("SEL_INDEXLINK_ALL");
    return localArrayList;
  }

  public void getGradeOneLinkInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getGradeOneLinkInfo方法...");
    this.outBuffer = paramBuffers;
    try
    {
      this.queryResult = getGradeOneLinkInfo();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getGradeOneLinkInfo方法...");
  }

  public ArrayList getGradeOneLinkInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localIndexLinkExt.setParam(":VLINK_TYPE", "0");
    localArrayList = localIndexLinkExt.selByList("SEL_INDEXLINK_ONE");
    return localArrayList;
  }

  public void getOneLinkInfoAndDowns(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getOneLinkInfoAndDowns方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("LINK_ID");
    try
    {
      this.queryResult = getOneLinkInfoAndDowns(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getOneLinkInfoAndDowns方法...");
  }

  public ArrayList getOneLinkInfoAndDowns(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localIndexLinkExt.setParam(":VLINK_ID", paramString);
    localArrayList1 = localIndexLinkExt.selByList("SEL_INDEXLINK_BY_ID");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap1 = (HashMap)localIterator.next();
        ArrayList localArrayList3 = getDownLinkInfoByupLink(localHashMap1.get("link_id").toString());
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put(localHashMap1, localArrayList3);
        localArrayList2.add(localHashMap2);
      }
    }
    return localArrayList2;
  }

  public void getDownLinkInfoByupLink(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getDownLinkInfoByupLink方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("LINK_ID");
    try
    {
      this.queryResult = getDownLinkInfoByupLink(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getDownLinkInfoByupLink方法...");
  }

  public ArrayList getDownLinkInfoByupLink(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localIndexLinkExt.setParam(":VUP_LINK_ID", paramString);
    localArrayList = localIndexLinkExt.selByList("SEL_INDEXLINK_BY_UP");
    return localArrayList;
  }

  public ArrayList getDefaultIndexLinkInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2 = getGradeOneLinkInfo();
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      Iterator localIterator = localArrayList2.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap1 = (HashMap)localIterator.next();
        ArrayList localArrayList3 = getDownLinkInfoByupLink(localHashMap1.get("link_id").toString());
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put(localHashMap1, localArrayList3);
        localArrayList1.add(localHashMap2);
      }
    }
    return localArrayList1;
  }

  public void addIndexLinkInfoUp(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addIndexLinkInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    IndexLinkDAO localIndexLinkDAO = new IndexLinkDAO();
    localIndexLinkDAO.setLink_id(str);
    localIndexLinkDAO.setLink_name(paramBuffers.getString("LINK_NAME"));
    localIndexLinkDAO.setLink_no(paramBuffers.getString("LINK_NO"));
    localIndexLinkDAO.setWeb_id("111111111111111");
    localIndexLinkDAO.setLink_type(paramBuffers.getString("LINK_TYPE"));
    localIndexLinkDAO.setLink_desc(paramBuffers.getString("LINK_DESC"));
    localIndexLinkDAO.setLink_url(paramBuffers.getString("LINK_URL"));
    localIndexLinkDAO.setUp_link_id("000000000000000");
    try
    {
      i = addIndexLinkInfoUp(localIndexLinkDAO);
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
    this.log.LOG_INFO("退出addIndexLinkInfo方法...");
  }

  public int addIndexLinkInfoUp(IndexLinkDAO paramIndexLinkDAO)
    throws SaasApplicationException
  {
    try
    {
      IndexLinkExt localIndexLinkExt = new IndexLinkExt();
      localIndexLinkExt.setParam(":VLINK_ID", paramIndexLinkDAO.getLink_id());
      localIndexLinkExt.setParam(":VLINK_NAME", paramIndexLinkDAO.getLink_name());
      localIndexLinkExt.setParam(":VLINK_NO", paramIndexLinkDAO.getLink_no());
      localIndexLinkExt.setParam(":VWEB_ID", paramIndexLinkDAO.getWeb_id());
      localIndexLinkExt.setParam(":VLINK_TYPE", paramIndexLinkDAO.getLink_type());
      localIndexLinkExt.setParam(":VLINK_DESC", paramIndexLinkDAO.getLink_desc());
      localIndexLinkExt.setParam(":VLINK_URL", paramIndexLinkDAO.getLink_url());
      localIndexLinkExt.setParam(":VUP_LINK_ID", paramIndexLinkDAO.getUp_link_id());
      this.tradeQuery.executeBy(localIndexLinkExt.insBy("INS_INDEXLINK_ONE"));
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return 0;
  }

  public void addIndexLinkInfoDown(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addIndexLinkInfoDown方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    IndexLinkDAO localIndexLinkDAO = new IndexLinkDAO();
    localIndexLinkDAO.setLink_id(str);
    localIndexLinkDAO.setLink_name(paramBuffers.getString("LINK_NAME"));
    localIndexLinkDAO.setLink_no(paramBuffers.getString("LINK_NO"));
    localIndexLinkDAO.setWeb_id("111111111111111");
    localIndexLinkDAO.setLink_desc(paramBuffers.getString("LINK_DESC"));
    localIndexLinkDAO.setLink_type(paramBuffers.getString("LINK_TYPE"));
    localIndexLinkDAO.setLink_url(paramBuffers.getString("LINK_URL"));
    localIndexLinkDAO.setUp_link_id(paramBuffers.getString("GRP_ID"));
    try
    {
      i = addIndexLinkInfoDown(localIndexLinkDAO);
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
    this.log.LOG_INFO("退出addIndexLinkInfoDown方法...");
  }

  public int addIndexLinkInfoDown(IndexLinkDAO paramIndexLinkDAO)
    throws SaasApplicationException
  {
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localIndexLinkExt.setParam(":VLINK_ID", paramIndexLinkDAO.getLink_id());
    localIndexLinkExt.setParam(":VLINK_NAME", paramIndexLinkDAO.getLink_name());
    this.log.LOG_INFO(paramIndexLinkDAO.getLink_name());
    localIndexLinkExt.setParam(":VLINK_NO", paramIndexLinkDAO.getLink_no());
    localIndexLinkExt.setParam(":VWEB_ID", paramIndexLinkDAO.getWeb_id());
    localIndexLinkExt.setParam(":VLINK_TYPE", paramIndexLinkDAO.getLink_type());
    localIndexLinkExt.setParam(":VLINK_DESC", paramIndexLinkDAO.getLink_desc());
    this.log.LOG_INFO(paramIndexLinkDAO.getLink_desc());
    localIndexLinkExt.setParam(":VLINK_URL", paramIndexLinkDAO.getLink_url());
    localIndexLinkExt.setParam(":VUP_LINK_ID", paramIndexLinkDAO.getUp_link_id());
    this.tradeQuery.executeBy(localIndexLinkExt.insBy("INS_INDEXLINK_ONE"));
    return 0;
  }

  public void deleteIndexLinkInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteIndexLinkInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("LINK_ID");
    try
    {
      i = deleteIndexLinkInfo(str);
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
    this.log.LOG_INFO("退出deleteIndexLinkInfo方法...");
  }

  public int deleteIndexLinkInfo(String paramString)
    throws SaasApplicationException
  {
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localIndexLinkExt.setParam(":VLINK_ID", paramString);
    this.tradeQuery.executeBy(localIndexLinkExt.insBy("DELETE_INDEX_BY_IDX"));
    return 0;
  }

  public void updateLinkInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateLinkInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("LINK_NAME");
    String str2 = paramBuffers.getString("LINK_NO");
    String str3 = paramBuffers.getString("LINK_TYPE");
    String str4 = paramBuffers.getString("LINK_DESC");
    String str5 = paramBuffers.getString("LINK_URL");
    String str6 = paramBuffers.getString("LINK_ID");
    try
    {
      i = updateLinkInfo(str1, str2, str3, str4, str5, str6);
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
    this.log.LOG_INFO("退出addIndexLinkInfo方法...");
  }

  public int updateLinkInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    try
    {
      IndexLinkExt localIndexLinkExt = new IndexLinkExt();
      localIndexLinkExt.setParam(":VLINK_ID", paramString6);
      localIndexLinkExt.setParam(":VLINK_NAME", paramString1);
      localIndexLinkExt.setParam(":VLINK_NO", paramString2);
      localIndexLinkExt.setParam(":VLINK_TYPE", paramString3);
      localIndexLinkExt.setParam(":VLINK_DESC", paramString4);
      localIndexLinkExt.setParam(":VLINK_URL", paramString5);
      this.tradeQuery.executeBy(localIndexLinkExt.insBy("UPDATE_BY_ID"));
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return 0;
  }

  public ArrayList getLinkListByAll(int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localArrayList = localIndexLinkExt.selByList("SEL_BY_All", paramInt, 30);
    return localArrayList;
  }

  public int getLinkNumber()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localArrayList = localIndexLinkExt.selByList("SEL_BY_All");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLinkInfoById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localIndexLinkExt.setParam(":VLINK_ID", paramString);
    localArrayList = localIndexLinkExt.selByList("SEL_INDEXLINK_BY_ID");
    return localArrayList;
  }

  public ArrayList getLinkListByPage(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    IndexLinkExt localIndexLinkExt = new IndexLinkExt();
    localArrayList = localIndexLinkExt.selByList("SEL_BY_All", paramInt1, paramInt2);
    return localArrayList;
  }

  public void DeleteLinkInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteLinkInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("LINK_ID");
    this.log.LOG_INFO("进入DeleteLinkInfo方法...******" + str1);
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = deleteIndexLinkInfo(str2);
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
    this.log.LOG_INFO("退出Deletelinkinfo方法...");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.indexLinkMgr.IndexlinkInfo
 * JD-Core Version:    0.6.0
 */