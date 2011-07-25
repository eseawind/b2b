package com.saas.biz.www.manage.itemsMgr;

import com.saas.biz.dao.itemsDAO.LmxxbDAO;
import com.saas.biz.dao.itemsDAO.LmxxbExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemsQuery
{
  Logger log = new Logger(this);
  ArrayList queryResult = new ArrayList();

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void genAddItemsList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genAddItemsList方法...");
    String str1 = paramBuffers.getString("STAFF_ID");
    String str2 = paramBuffers.getString("LMJB");
    String str3 = paramBuffers.getString("SJLMBS");
    try
    {
      this.queryResult = genAddItemsList(str1, str2, str3);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genAddItemsList方法...");
  }

  public ArrayList genAddItemsList(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LmxxbExt localLmxxbExt = new LmxxbExt();
    int i = new Integer(paramString2).intValue() + 1;
    String str = "";
    if (((paramString3.equalsIgnoreCase("")) || (paramString3.equalsIgnoreCase("null"))) && (!paramString1.equalsIgnoreCase("admin")))
    {
      localLmxxbExt.setParam(":VLMJB", new Integer(i));
      localLmxxbExt.setParam(":VSTAFFID", paramString1);
      localArrayList = localLmxxbExt.selByList("SEL_BY_CLASS_STAFF");
    }
    else if (paramString1.equalsIgnoreCase("admin"))
    {
      localLmxxbExt.setParam(":VLMJB", new Integer(i));
      localArrayList = localLmxxbExt.selByList("SEL_BY_ADMIN");
    }
    if (!paramString3.equalsIgnoreCase(""))
    {
      localLmxxbExt.setParam(":VLMJB", new Integer(i));
      localLmxxbExt.setParam(":VSJLMBS", paramString3);
      localArrayList = localLmxxbExt.selByList("SEL_BY_UPITEM");
    }
    return localArrayList;
  }

  public void genAddItemsInterf(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genAddItemsInterf方法...");
    String str1 = paramBuffers.getString("LMJB");
    String str2 = paramBuffers.getString("SJLMBS");
    try
    {
      this.queryResult = genAddItemsInterf(str1, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genAddItemsInterf方法...");
  }

  public ArrayList genAddItemsInterf(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LmxxbExt localLmxxbExt = new LmxxbExt();
    LmxxbDAO localLmxxbDAO = new LmxxbDAO();
    localLmxxbExt.setParam(":VLMBS", paramString2);
    localLmxxbDAO = localLmxxbExt.selByInfo("SEL_BY_PK");
    if (localLmxxbDAO == null)
      return null;
    int i = new Integer(paramString1).intValue() + 1;
    paramString1 = String.valueOf(i);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sjlmmc", localLmxxbDAO.getLmmc());
    localHashMap.put("sjlmbs", localLmxxbDAO.getLmbs());
    localHashMap.put("lmjb", paramString1);
    localArrayList.add(localHashMap);
    return localArrayList;
  }

  public void genModifyItemsInterf(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genModifyItemsInterf方法...");
    String str1 = paramBuffers.getString("LMJB");
    String str2 = paramBuffers.getString("LMBS");
    try
    {
      this.queryResult = genModifyItemsInterf(str1, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genModifyItemsInterf方法...");
  }

  public ArrayList genModifyItemsInterf(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LmxxbExt localLmxxbExt = new LmxxbExt();
    LmxxbDAO localLmxxbDAO = new LmxxbDAO();
    localLmxxbExt.setParam(":VLMBS", paramString2);
    localLmxxbDAO = localLmxxbExt.selByInfo("SEL_BY_PK");
    if (localLmxxbDAO == null)
      return null;
    localArrayList.add(localLmxxbDAO);
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.www.manage.itemsMgr.ItemsQuery
 * JD-Core Version:    0.6.0
 */