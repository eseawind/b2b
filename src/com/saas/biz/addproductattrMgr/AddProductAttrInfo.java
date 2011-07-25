package com.saas.biz.addproductattrMgr;

import com.saas.biz.dao.addproductattrDAO.AddProductAttrDAO;
import com.saas.biz.dao.addproductattrDAO.AddProductAttrExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class AddProductAttrInfo
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

  public void AddProductAttr(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入AddProductAttr方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CLASS_ID");
    String str3 = paramBuffers.getString("ATTR_ID");
    String str4 = paramBuffers.getString("ATTR_NAME");
    String str5 = paramBuffers.getString("ATTR_DESC");
    String str6 = paramBuffers.getString("ATTR_NO");
    String str7 = paramBuffers.getString("DEFAULT_TAG");
    String str8 = paramBuffers.getString("DEFAULT_VALUE");
    String str9 = paramBuffers.getString("ENABLE_TAG");
    String str10 = paramBuffers.getString("REMARK");
    try
    {
      AddProductAttrDAO localAddProductAttrDAO = new AddProductAttrDAO();
      localAddProductAttrDAO.setCust_id(str1);
      localAddProductAttrDAO.setClass_id(str2);
      localAddProductAttrDAO.setAttr_id(str3);
      localAddProductAttrDAO.setAttr_name(str4);
      localAddProductAttrDAO.setAttr_desc(str5);
      localAddProductAttrDAO.setAttr_no(str6);
      localAddProductAttrDAO.setDefault_tag(str7);
      localAddProductAttrDAO.setDefault_value(str8);
      localAddProductAttrDAO.setEnable_tag(str9);
      localAddProductAttrDAO.setRemark(str10);
      i = AddProductAttr(localAddProductAttrDAO);
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
    this.log.LOG_INFO("退出AddProductAttr方法...");
  }

  public int AddProductAttr(AddProductAttrDAO paramAddProductAttrDAO)
    throws SaasApplicationException
  {
    AddProductAttrExt localAddProductAttrExt = new AddProductAttrExt();
    this.log.LOG_INFO("开始执行SQL:===:");
    localAddProductAttrExt.setParam(":VCUST_ID", paramAddProductAttrDAO.getCust_id());
    localAddProductAttrExt.setParam(":VCLASS_ID", paramAddProductAttrDAO.getClass_id());
    localAddProductAttrExt.setParam(":VATTR_ID", paramAddProductAttrDAO.getAttr_id());
    localAddProductAttrExt.setParam(":VATTR_NAME", paramAddProductAttrDAO.getAttr_name());
    localAddProductAttrExt.setParam(":VATTR_DESC", paramAddProductAttrDAO.getAttr_desc());
    localAddProductAttrExt.setParam(":VATTR_NO", paramAddProductAttrDAO.getAttr_no());
    localAddProductAttrExt.setParam(":VDEFAULT_TAG", paramAddProductAttrDAO.getDefault_tag());
    localAddProductAttrExt.setParam(":VDEFAULT_VALUE", paramAddProductAttrDAO.getDefault_value());
    localAddProductAttrExt.setParam(":VENABLE_TAG", paramAddProductAttrDAO.getEnable_tag());
    localAddProductAttrExt.setParam(":VREMARK", paramAddProductAttrDAO.getRemark());
    this.log.LOG_INFO("开始执行SQL:===:" + localAddProductAttrExt.insBy("ADD_BY_ATTR"));
    this.tradeQuery.executeBy(localAddProductAttrExt.insBy("ADD_BY_ATTR"));
    return 0;
  }

  public ArrayList getProductById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AddProductAttrExt localAddProductAttrExt = new AddProductAttrExt();
    localAddProductAttrExt.setParam(":VCUST_ID", paramString1);
    localAddProductAttrExt.setParam(":VCLASS_ID", paramString2);
    localArrayList = localAddProductAttrExt.selByList("SEL_BY_CLASS_ID");
    return localArrayList;
  }

  public void modifyproductattrInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyproductattrInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ATTR_ID");
    String str3 = paramBuffers.getString("ATTR_NAME");
    String str4 = paramBuffers.getString("ATTR_NO");
    String str5 = paramBuffers.getString("DEFAULT_VALUE");
    String str6 = paramBuffers.getString("ATTR_DESC");
    String str7 = paramBuffers.getString("REMARK");
    try
    {
      AddProductAttrDAO localAddProductAttrDAO = new AddProductAttrDAO();
      localAddProductAttrDAO.setCust_id(str1);
      localAddProductAttrDAO.setAttr_id(str2);
      localAddProductAttrDAO.setAttr_name(str3);
      localAddProductAttrDAO.setAttr_no(str4);
      localAddProductAttrDAO.setDefault_value(str5);
      localAddProductAttrDAO.setAttr_desc(str6);
      localAddProductAttrDAO.setRemark(str7);
      i = modifyproductattrInfo(localAddProductAttrDAO);
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

  public int modifyproductattrInfo(AddProductAttrDAO paramAddProductAttrDAO)
    throws SaasApplicationException
  {
    AddProductAttrExt localAddProductAttrExt = new AddProductAttrExt();
    this.log.LOG_INFO("开始执行SQL:===:");
    localAddProductAttrExt.setParam(":VCUST_ID", paramAddProductAttrDAO.getCust_id());
    localAddProductAttrExt.setParam(":VATTR_ID", paramAddProductAttrDAO.getAttr_id());
    localAddProductAttrExt.setParam(":VATTR_NAME", paramAddProductAttrDAO.getAttr_name());
    localAddProductAttrExt.setParam(":VATTR_NO", paramAddProductAttrDAO.getAttr_no());
    localAddProductAttrExt.setParam(":VDEFAULT_VALUE", paramAddProductAttrDAO.getDefault_value());
    localAddProductAttrExt.setParam(":VATTR_DESC", paramAddProductAttrDAO.getAttr_desc());
    localAddProductAttrExt.setParam(":VREMARK", paramAddProductAttrDAO.getRemark());
    this.log.LOG_INFO("开始执行SQL:===:" + localAddProductAttrExt.insBy("UP_PRODUCTATTR_BY_ID"));
    this.tradeQuery.executeBy(localAddProductAttrExt.insBy("UP_PRODUCTATTR_BY_ID"));
    return 0;
  }

  public void deleteProductAttrInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteProductAttrInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ATTR_ID");
    try
    {
      AddProductAttrDAO localAddProductAttrDAO = new AddProductAttrDAO();
      localAddProductAttrDAO.setCust_id(str1);
      localAddProductAttrDAO.setAttr_id(str2);
      i = deleteProductAttrInfo(localAddProductAttrDAO);
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

  public int deleteProductAttrInfo(AddProductAttrDAO paramAddProductAttrDAO)
    throws SaasApplicationException
  {
    AddProductAttrExt localAddProductAttrExt = new AddProductAttrExt();
    localAddProductAttrExt.setParam(":VCUST_ID", paramAddProductAttrDAO.getCust_id());
    localAddProductAttrExt.setParam(":VATTR_ID", paramAddProductAttrDAO.getAttr_id());
    this.tradeQuery.executeBy(localAddProductAttrExt.insBy("DEL_PRODUCTATTR_BY_ID"));
    return 0;
  }

  public HashMap getattrById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    AddProductAttrExt localAddProductAttrExt = new AddProductAttrExt();
    localAddProductAttrExt.setParam(":VCUST_ID", paramString1);
    localAddProductAttrExt.setParam(":VATTR_ID", paramString2);
    localArrayList = localAddProductAttrExt.selByList("SEL_BY_ATTR_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.addproductattrMgr.AddProductAttrInfo
 * JD-Core Version:    0.6.0
 */