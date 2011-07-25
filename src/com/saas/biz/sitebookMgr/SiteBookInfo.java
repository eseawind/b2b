package com.saas.biz.sitebookMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.sitebookDAO.SitebookDAO;
import com.saas.biz.dao.sitebookDAO.SitebookExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SiteBookInfo
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

  public void addSiteBookInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addSiteBookInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("WEBSITE");
    String str2 = paramBuffers.getString("COMMENT");
    Integer localInteger = Integer.valueOf(Integer.parseInt(paramBuffers.getString("XSHARE")));
    String str3 = paramBuffers.getString("RECORDUSER");
    String str4 = paramBuffers.getString("SESSION_USER_NAME");
    String str5 = paramBuffers.getString("DEPART_CODE");
    try
    {
      SitebookDAO localSitebookDAO = new SitebookDAO(str1, str2, localInteger, str3, str5, str4);
      i = addSiteBookInfo(localSitebookDAO);
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
    this.log.LOG_INFO("退出addSiteBookInfo方法...");
  }

  public int addSiteBookInfo(SitebookDAO paramSitebookDAO)
    throws SaasApplicationException
  {
    SitebookExt localSitebookExt = new SitebookExt();
    localSitebookExt.setParam(":VWEBSITE", paramSitebookDAO.getWebsite());
    localSitebookExt.setParam(":VPART", paramSitebookDAO.getPart());
    localSitebookExt.setParam(":VCOMMENT", paramSitebookDAO.getComment());
    localSitebookExt.setParam(":VXSHARE", paramSitebookDAO.getXshare());
    localSitebookExt.setParam(":VUSER", paramSitebookDAO.getUser());
    localSitebookExt.setParam(":VRECORDUSER", paramSitebookDAO.getRecorduser());
    this.tradeQuery.executeBy(localSitebookExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateSiteBookInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateSiteBookInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("ID");
    String str2 = paramBuffers.getString("WEBSITE");
    String str3 = paramBuffers.getString("COMMENT");
    Integer localInteger = Integer.valueOf(Integer.parseInt(paramBuffers.getString("XSHARE")));
    String str4 = paramBuffers.getString("RECORDUSER");
    try
    {
      SitebookDAO localSitebookDAO = new SitebookDAO();
      localSitebookDAO.setId(Integer.valueOf(Integer.parseInt(str1)));
      localSitebookDAO.setComment(str3);
      localSitebookDAO.setWebsite(str2);
      localSitebookDAO.setRecorduser(str4);
      localSitebookDAO.setXshare(localInteger);
      i = updateSiteBookInfo(localSitebookDAO);
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
    this.log.LOG_INFO("退出updateSiteBookInfo方法...");
  }

  public int updateSiteBookInfo(SitebookDAO paramSitebookDAO)
    throws SaasApplicationException
  {
    SitebookExt localSitebookExt = new SitebookExt();
    localSitebookExt.setParam(":VID", paramSitebookDAO.getId());
    localSitebookExt.setParam(":VWEBSITE", paramSitebookDAO.getWebsite());
    localSitebookExt.setParam(":VCOMMENT", paramSitebookDAO.getComment());
    localSitebookExt.setParam(":VXSHARE", paramSitebookDAO.getXshare());
    localSitebookExt.setParam(":VRECORDUSER", paramSitebookDAO.getRecorduser());
    this.tradeQuery.executeBy(localSitebookExt.insBy("UPDATE_BY_ID"));
    return 0;
  }

  public void deleteSiteBookInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteSiteBookInfo方法...");
    int i = -1;
    String str = paramBuffers.getString("ID");
    try
    {
      i = deleteSiteBookInfo(str);
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
    this.log.LOG_INFO("退出deleteSiteBookInfo方法...");
  }

  public int deleteSiteBookInfo(String paramString)
    throws SaasApplicationException
  {
    SitebookExt localSitebookExt = new SitebookExt();
    localSitebookExt.setParam(":VID", paramString);
    this.tradeQuery.executeBy(localSitebookExt.insBy("DELETE_BY_ID"));
    return 0;
  }

  public ArrayList getSiteBookByUser(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SitebookExt localSitebookExt = new SitebookExt();
    localSitebookExt.setParam(":VUSER", paramString);
    localArrayList = localSitebookExt.selByList("SEL_BY_USER");
    return localArrayList;
  }

  public ArrayList getSiteBookById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SitebookExt localSitebookExt = new SitebookExt();
    localSitebookExt.setParam(":VID", paramString);
    localArrayList = localSitebookExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public Map getSiteBookByMap(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = getSiteBookById(paramString);
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      str1 = localHashMap2.get("website").toString();
      str2 = localHashMap2.get("comment").toString();
      str3 = localHashMap2.get("recorduser").toString();
    }
    localHashMap1.put("website", str1);
    localHashMap1.put("comment", str2);
    localHashMap1.put("recorduser", str3);
    return localHashMap1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.sitebookMgr.SiteBookInfo
 * JD-Core Version:    0.6.0
 */