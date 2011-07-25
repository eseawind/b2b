package com.saas.biz.objectattrMgr;

import com.saas.biz.dao.objectattrDAO.ObjectattrExt;
import com.saas.biz.dao.productattrDAO.ProductattrExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Objectattrinfo
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

  public void addObjectattrInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addObjectattrInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("STR_ATTR");
    String str2 = paramBuffers.getString("SPEC_ROOT_ID");
    try
    {
      i = addObjectattrInfo(str1, str2);
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
    this.log.LOG_INFO("退出addObjectattrInfo方法...");
  }

  public int addObjectattrInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramString1.equals(""))
      return 0;
    String[] arrayOfString1 = strToStrArrayManager(paramString1, "|");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      ObjectattrExt localObjectattrExt = new ObjectattrExt();
      String str1 = arrayOfString1[i];
      this.log.LOG_INFO("nameAvaule............................" + str1);
      String[] arrayOfString2 = strToStrArrayManager(str1, ":");
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      ProductattrExt localProductattrExt = new ProductattrExt();
      ArrayList localArrayList = new ArrayList();
      String str6 = arrayOfString2[0];
      String str7 = arrayOfString2[1];
      this.log.LOG_INFO("tempname..........." + str6);
      localProductattrExt.setParam(":VRSRV_STR4", str6);
      localArrayList = localProductattrExt.selByList("SEL_BY_NAME");
      Iterator localIterator = localArrayList.iterator();
      HashMap localHashMap = (HashMap)localIterator.next();
      str2 = localHashMap.get("attr_id").toString();
      str3 = localHashMap.get("attr_name").toString();
      this.log.LOG_INFO("attr_name..............." + str3);
      if (localHashMap.get("attr_desc") != null)
        str4 = localHashMap.get("attr_desc").toString();
      if (localHashMap.get("attr_no") != null)
        str5 = localHashMap.get("attr_no").toString();
      localObjectattrExt.setParam(":VROOT_ID", paramString2);
      localObjectattrExt.setParam(":VATTR_ID", str2);
      localObjectattrExt.setParam(":VCLASS_TYPE", "0");
      localObjectattrExt.setParam(":VATTR_NAME", str3);
      localObjectattrExt.setParam(":VATTR_DESC", str4);
      localObjectattrExt.setParam(":VATTR_NO", str5);
      localObjectattrExt.setParam(":VATTR_VALUE", str7);
      localObjectattrExt.setParam(":VRSRV_STR1", "");
      localObjectattrExt.setParam(":VRSRV_STR2", "");
      localObjectattrExt.setParam(":VRSRV_STR3", "");
      localObjectattrExt.setParam(":VRSRV_STR4", "");
      localObjectattrExt.setParam(":VRSRV_STR5", "");
      localObjectattrExt.setParam(":VRSRV_STR6", "");
      localObjectattrExt.setParam(":VRSRV_STR7", "");
      localObjectattrExt.setParam(":VRSRV_STR8", "");
      localObjectattrExt.setParam(":VRSRV_STR9", "");
      localObjectattrExt.setParam(":VRSRV_STR10", "");
      localObjectattrExt.setParam(":VREMARK", "");
      this.tradeQuery.executeBy(localObjectattrExt.insBy("INS_BY_ALL"));
    }
    return 0;
  }

  private static String[] strToStrArrayManager(String paramString1, String paramString2)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, paramString2);
    String[] arrayOfString = new String[localStringTokenizer.countTokens()];
    for (int i = 0; localStringTokenizer.hasMoreTokens(); i++)
      arrayOfString[i] = localStringTokenizer.nextToken().trim();
    return arrayOfString;
  }

  public void getProductProperty(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入getProductProperty方法...");
    String str = paramBuffers.getString("PRODUCT_ID");
    try
    {
      this.queryResult = getProductProperty(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getProductProperty方法...");
  }

  public ArrayList getProductProperty(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ObjectattrExt localObjectattrExt = new ObjectattrExt();
    localObjectattrExt.setParam(":VROOT_ID", paramString);
    localArrayList = localObjectattrExt.selByList("SEL_PROPERTY_BY_IDX");
    return localArrayList;
  }

  public void updateObjectAttrInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateObjectAttrInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    Integer localInteger = Integer.valueOf(Integer.parseInt(paramBuffers.getString("RSRV_NUM1")));
    if (localInteger.intValue() > 0)
      for (int i = 0; i < localInteger.intValue(); i++)
      {
        String str1 = paramBuffers.getString("RSRV_STR" + i);
        String str2 = paramBuffers.getString("RSRV_IDX" + i);
        try
        {
          updateObjectAttrInfo(str1, str2);
        }
        catch (SaasApplicationException localSaasApplicationException)
        {
          this.log.LOG_INFO("更新产品属性出现异常..." + i);
        }
      }
    this.log.LOG_INFO("退出updateObjectAttrInfo方法...");
  }

  public void updateObjectAttrInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ObjectattrExt localObjectattrExt = new ObjectattrExt();
    localObjectattrExt.setParam(":VATTR_ID", paramString2);
    localObjectattrExt.setParam(":VATTR_VALUE", paramString1);
    this.tradeQuery.executeBy(localObjectattrExt.insBy("UPDATE_PROPERTY_BY_IDX"));
  }

  public void addProductAttribute(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addProductAttribute方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    Integer localInteger = Integer.valueOf(Integer.parseInt(paramBuffers.getString("RSRV_NUM1")));
    String str1 = paramBuffers.getString("ROOT_ID");
    if (localInteger.intValue() > 0)
      for (int i = 0; i < localInteger.intValue(); i++)
      {
        String str2 = paramBuffers.getString("RSRV_STR" + i);
        String str3 = paramBuffers.getString("RSRV_IDX" + i);
        try
        {
          String str4 = getProductAttrName(str3);
          addProductAttribute(str2, str3, str1, str4);
        }
        catch (SaasApplicationException localSaasApplicationException)
        {
          this.log.LOG_INFO("更新产品属性出现异常..." + i);
        }
      }
    this.log.LOG_INFO("退出addProductAttribute方法...");
  }

  public void addProductAttribute(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ObjectattrExt localObjectattrExt = new ObjectattrExt();
    localObjectattrExt.setParam(":VROOT_ID", paramString3);
    localObjectattrExt.setParam(":VATTR_ID", paramString2);
    localObjectattrExt.setParam(":VCLASS_TYPE", "0");
    localObjectattrExt.setParam(":VATTR_NAME", paramString4);
    localObjectattrExt.setParam(":VATTR_DESC", "");
    localObjectattrExt.setParam(":VATTR_NO", "0");
    localObjectattrExt.setParam(":VATTR_VALUE", paramString1);
    localObjectattrExt.setParam(":VRSRV_STR1", "");
    localObjectattrExt.setParam(":VRSRV_STR2", "");
    localObjectattrExt.setParam(":VRSRV_STR3", "");
    localObjectattrExt.setParam(":VRSRV_STR4", "");
    localObjectattrExt.setParam(":VRSRV_STR5", "");
    localObjectattrExt.setParam(":VRSRV_STR6", "");
    localObjectattrExt.setParam(":VRSRV_STR7", "");
    localObjectattrExt.setParam(":VRSRV_STR8", "");
    localObjectattrExt.setParam(":VRSRV_STR9", "");
    localObjectattrExt.setParam(":VRSRV_STR10", "");
    localObjectattrExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localObjectattrExt.insBy("INS_BY_ALL"));
  }

  public String getProductAttrName(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ProductattrExt localProductattrExt = new ProductattrExt();
    ArrayList localArrayList = new ArrayList();
    localProductattrExt.setParam(":VATTR_ID", paramString);
    localArrayList = localProductattrExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("attr_name") != null)
        str = localHashMap.get("attr_name").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.objectattrMgr.Objectattrinfo
 * JD-Core Version:    0.6.0
 */