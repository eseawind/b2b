package com.saas.biz.newproductattrMgr;

import com.saas.biz.dao.newproductattrDAO.NewProductAttrDAO;
import com.saas.biz.dao.newproductattrDAO.NewProductattrExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NewProductAttrInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
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

  public void AddNewProductAttr(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入NewProductAttr方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PRODUCT_ID");
    this.log.LOG_INFO("product_id======" + str1);
    String str2 = paramBuffers.getString("PRODUCT_CLASS");
    String str3 = "";
    String str4 = "1";
    String str5 = paramBuffers.getString("RSRV_STR1");
    String str6 = "0";
    String str7 = "添加产品属性值";
    try
    {
      NewProductAttrDAO localNewProductAttrDAO = new NewProductAttrDAO();
      localNewProductAttrDAO.setProduct_id(str1);
      localNewProductAttrDAO.setRsrv_str1(str5);
      localNewProductAttrDAO.setProduct_class(str2);
      localNewProductAttrDAO.setAttr_desc(str3);
      localNewProductAttrDAO.setAttr_no(str4);
      localNewProductAttrDAO.setEnable_tag(str6);
      localNewProductAttrDAO.setRemark(str7);
      i = AddNewProductAttr(localNewProductAttrDAO);
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
    this.log.LOG_INFO("退出NewProductAttr方法...");
  }

  public int AddNewProductAttr(NewProductAttrDAO paramNewProductAttrDAO)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("开始执行SQL:===:");
    String str1 = paramNewProductAttrDAO.getRsrv_str1();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      String str3 = str2.substring(0, str2.indexOf("&"));
      String str4 = str2.substring(str2.indexOf("&") + 1, str2.indexOf("#"));
      String str5 = str2.substring(str2.indexOf("#") + 1, str2.length());
      this.log.LOG_INFO("=============" + str2 + "====" + str3 + "====" + str5);
      NewProductattrExt localNewProductattrExt = new NewProductattrExt();
      localNewProductattrExt.setParam(":VPRODUCT_ID", paramNewProductAttrDAO.getProduct_id());
      localNewProductattrExt.setParam(":VPRODUCT_CLASS", paramNewProductAttrDAO.getProduct_class());
      localNewProductattrExt.setParam(":VATTR_ID", str4);
      localNewProductattrExt.setParam(":VATTR_NAME", str3);
      localNewProductattrExt.setParam(":VATTR_DESC", paramNewProductAttrDAO.getAttr_desc());
      localNewProductattrExt.setParam(":VATTR_NO", paramNewProductAttrDAO.getAttr_no());
      localNewProductattrExt.setParam(":VATTR_VALUE", str5);
      localNewProductattrExt.setParam(":VENABLE_TAG", paramNewProductAttrDAO.getEnable_tag());
      localNewProductattrExt.setParam(":VREMARK", paramNewProductAttrDAO.getRemark());
      this.log.LOG_INFO("开始执行SQL:===:" + localNewProductattrExt.insBy("ADD_BY_ATTR"));
      this.tradeQuery.executeBy(localNewProductattrExt.insBy("ADD_BY_ATTR"));
    }
    return 0;
  }

  public ArrayList getProductById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewProductattrExt localNewProductattrExt = new NewProductattrExt();
    localNewProductattrExt.setParam(":VPRODUCT_ID", paramString);
    localArrayList = localNewProductattrExt.selByList("SEL_BY_PRODUCT_ID");
    return localArrayList;
  }

  public void modifyproductattrInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyproductattrInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CLASS_ID");
    String str3 = paramBuffers.getString("ATTR_ID");
    String str4 = paramBuffers.getString("ATTR_NAME");
    String str5 = paramBuffers.getString("ATTR_NO");
    String str6 = paramBuffers.getString("DEFAULT_VALUE");
    String str7 = paramBuffers.getString("ATTR_DESC");
    String str8 = paramBuffers.getString("REMARK");
    try
    {
      NewProductAttrDAO localNewProductAttrDAO = new NewProductAttrDAO();
      localNewProductAttrDAO.setRemark(str8);
      i = modifyproductattrInfo(localNewProductAttrDAO);
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
    this.log.LOG_INFO("退出modifyproductattrInfo方法...");
  }

  public int modifyproductattrInfo(NewProductAttrDAO paramNewProductAttrDAO)
    throws SaasApplicationException
  {
    NewProductattrExt localNewProductattrExt = new NewProductattrExt();
    localNewProductattrExt.setParam(":VREMARK", paramNewProductAttrDAO.getRemark());
    this.tradeQuery.executeBy(localNewProductattrExt.insBy("UP_PRODUCTATTR_BY_ID"));
    return 0;
  }

  public void deleteProductAttrInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteProductAttrInfo方法...");
    int i = -1;
    String str = paramBuffers.getString("PRODUCT_ID");
    try
    {
      NewProductAttrDAO localNewProductAttrDAO = new NewProductAttrDAO();
      localNewProductAttrDAO.setProduct_id(str);
      i = deleteProductAttrInfo(localNewProductAttrDAO);
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
    this.log.LOG_INFO("退出deleteProductAttrInfo方法...");
  }

  public int deleteProductAttrInfo(NewProductAttrDAO paramNewProductAttrDAO)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("开始执行SQL:===:");
    NewProductattrExt localNewProductattrExt = new NewProductattrExt();
    localNewProductattrExt.setParam(":VPRODUCT_ID", paramNewProductAttrDAO.getProduct_id());
    this.log.LOG_INFO("开始执行SQL:===:" + localNewProductattrExt.insBy("DEL_PRODUCTATTR_BY_ID"));
    this.tradeQuery.executeBy(localNewProductattrExt.insBy("DEL_PRODUCTATTR_BY_ID"));
    return 0;
  }

  public void delProductAttrInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteProductAttrInfo方法...");
    int i = -1;
    String str = paramBuffers.getString("PRODUCT_ID");
    try
    {
      NewProductAttrDAO localNewProductAttrDAO = new NewProductAttrDAO();
      localNewProductAttrDAO.setProduct_id(str);
      i = delProductAttrInfo(localNewProductAttrDAO);
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
    this.log.LOG_INFO("退出deleteProductAttrInfo方法...");
  }

  public int delProductAttrInfo(NewProductAttrDAO paramNewProductAttrDAO)
    throws SaasApplicationException
  {
    NewProductattrExt localNewProductattrExt = new NewProductattrExt();
    localNewProductattrExt.setParam(":VPRODUCT_ID", paramNewProductAttrDAO.getProduct_id());
    this.tradeQuery.executeBy(localNewProductattrExt.insBy("DEL_PRO_ATTR_BY_ID"));
    return 0;
  }

  public HashMap getattrById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    NewProductattrExt localNewProductattrExt = new NewProductattrExt();
    localNewProductattrExt.setParam(":VCUST_ID", paramString1);
    localNewProductattrExt.setParam(":VATTR_ID", paramString2);
    localArrayList = localNewProductattrExt.selByList("SEL_BY_ATTR_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public void modiProductAttr(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入modiProductAttr方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PRODUCT_ID");
    String str2 = paramBuffers.getString("RSRV_STR1");
    String str3 = "修改产品属性值";
    try
    {
      NewProductAttrDAO localNewProductAttrDAO = new NewProductAttrDAO();
      localNewProductAttrDAO.setProduct_id(str1);
      localNewProductAttrDAO.setRsrv_str1(str2);
      localNewProductAttrDAO.setRemark(str3);
      i = modiProductAttr(localNewProductAttrDAO);
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
      this.outBuffer.setString("RESULT_INFO", "业务处理成功3333333333333！");
    }
    this.log.LOG_INFO("退出modiProductAttr方法...");
  }

  public int modiProductAttr(NewProductAttrDAO paramNewProductAttrDAO)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("开始执行SQL:===:");
    String str1 = paramNewProductAttrDAO.getRsrv_str1();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      String str3 = str2.substring(0, str2.indexOf("&"));
      String str4 = str2.substring(str2.indexOf("&") + 1, str2.indexOf("#"));
      String str5 = str2.substring(str2.indexOf("#") + 1, str2.length());
      NewProductattrExt localNewProductattrExt = new NewProductattrExt();
      localNewProductattrExt.setParam(":VPRODUCT_ID", paramNewProductAttrDAO.getProduct_id());
      localNewProductattrExt.setParam(":VATTR_ID", str4);
      localNewProductattrExt.setParam(":VATTR_NAME", str3);
      localNewProductattrExt.setParam(":VATTR_VALUE", str5);
      localNewProductattrExt.setParam(":VREMARK", paramNewProductAttrDAO.getRemark());
      this.log.LOG_INFO("开始执行SQL:===:" + localNewProductattrExt.insBy("UPDATR_BY_ATTR"));
      this.tradeQuery.executeBy(localNewProductattrExt.insBy("UPDATR_BY_ATTR"));
    }
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.newproductattrMgr.NewProductAttrInfo
 * JD-Core Version:    0.6.0
 */