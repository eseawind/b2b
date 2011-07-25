package com.saas.biz.addproductMgr;

import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.JavaScriptObject.TreeObject;
import com.saas.biz.dao.addproductDAO.AddProductDAO;
import com.saas.biz.dao.addproductDAO.AddProductExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.json.JSONArray;

public class AddProductInfo
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

  public void addProductInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addProductInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CLASS_ID");
    String str3 = paramBuffers.getString("CLASS_NAME");
    String str4 = paramBuffers.getString("UP_CLASS_ID");
    String str5 = paramBuffers.getString("CLASS_LEVEL");
    String str6 = paramBuffers.getString("CLASS_TYPE");
    String str7 = paramBuffers.getString("CLASS_DESC");
    String str8 = paramBuffers.getString("ENABLE_TAG");
    String str9 = paramBuffers.getString("REMARK");
    try
    {
      AddProductDAO localAddProductDAO = new AddProductDAO();
      localAddProductDAO.setCust_id(str1);
      localAddProductDAO.setClass_id(str2);
      localAddProductDAO.setClass_name(str3);
      localAddProductDAO.setUp_class_id(str4);
      localAddProductDAO.setClass_level(str5);
      localAddProductDAO.setClass_type(str6);
      localAddProductDAO.setClass_desc(str7);
      localAddProductDAO.setEnable_tag(str8);
      localAddProductDAO.setRemark(str9);
      i = addProductInfo(localAddProductDAO);
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
    this.log.LOG_INFO("退出addProductInfo方法...");
  }

  public int addProductInfo(AddProductDAO paramAddProductDAO)
    throws SaasApplicationException
  {
    AddProductExt localAddProductExt = new AddProductExt();
    localAddProductExt.setParam(":VCUST_ID", paramAddProductDAO.getCust_id());
    localAddProductExt.setParam(":VCLASS_ID", paramAddProductDAO.getClass_id());
    localAddProductExt.setParam(":VCLASS_NAME", paramAddProductDAO.getClass_name());
    localAddProductExt.setParam(":VUP_CLASS_ID", paramAddProductDAO.getUp_class_id());
    localAddProductExt.setParam(":VCLASS_LEVEL", paramAddProductDAO.getClass_level());
    localAddProductExt.setParam(":VCLASS_TYPE", paramAddProductDAO.getClass_type());
    localAddProductExt.setParam(":VCLASS_DESC", paramAddProductDAO.getClass_desc());
    localAddProductExt.setParam(":VENABLE_TAG", paramAddProductDAO.getEnable_tag());
    localAddProductExt.setParam(":VREMARK", paramAddProductDAO.getRemark());
    this.tradeQuery.executeBy(localAddProductExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void modifyproductInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyproductInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("class_id");
    String str3 = paramBuffers.getString("class_name");
    String str4 = paramBuffers.getString("class_desc");
    String str5 = paramBuffers.getString("enable_tag");
    String str6 = paramBuffers.getString("remark");
    try
    {
      AddProductDAO localAddProductDAO = new AddProductDAO();
      localAddProductDAO.setCust_id(str1);
      localAddProductDAO.setClass_id(str2);
      localAddProductDAO.setClass_name(str3);
      localAddProductDAO.setClass_desc(str4);
      localAddProductDAO.setEnable_tag(str5);
      localAddProductDAO.setRemark(str6);
      i = modifyproductInfo(localAddProductDAO);
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
    this.log.LOG_INFO("退出modifyproductInfo方法...");
  }

  public int modifyproductInfo(AddProductDAO paramAddProductDAO)
    throws SaasApplicationException
  {
    AddProductExt localAddProductExt = new AddProductExt();
    localAddProductExt.setParam(":VCUST_ID", paramAddProductDAO.getCust_id());
    localAddProductExt.setParam(":VCLASS_ID", paramAddProductDAO.getClass_id());
    localAddProductExt.setParam(":VCLASS_NAME", paramAddProductDAO.getClass_name());
    localAddProductExt.setParam(":VCLASS_DESC", paramAddProductDAO.getClass_desc());
    localAddProductExt.setParam(":VENABLE_TAG", paramAddProductDAO.getEnable_tag());
    localAddProductExt.setParam(":VREMARK", paramAddProductDAO.getRemark());
    this.tradeQuery.executeBy(localAddProductExt.insBy("UP_PRODUCT_BY_ALL"));
    return 0;
  }

  public String getJsonDataForTree(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = paramString3;
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = getproductByUpId(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str2 = localHashMap.get("class_name").toString();
        String str3 = localHashMap.get("class_id").toString();
        localTreeObject.setIconCls(str1);
        localTreeObject.setId(str3);
        localTreeObject.setText(str2);
        TreeNode localTreeNode = isLeaf(paramString1, str3);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    return localJSONArray.toString();
  }

  public void deleteProductInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteProductInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CLASS_ID");
    try
    {
      AddProductDAO localAddProductDAO = new AddProductDAO();
      localAddProductDAO.setCust_id(str1);
      localAddProductDAO.setClass_id(str2);
      i = deleteProductInfo(localAddProductDAO);
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
    this.log.LOG_INFO("退出deleteProductInfo方法...");
  }

  public int deleteProductInfo(AddProductDAO paramAddProductDAO)
    throws SaasApplicationException
  {
    AddProductExt localAddProductExt = new AddProductExt();
    localAddProductExt.setParam(":VCUST_ID", paramAddProductDAO.getCust_id());
    localAddProductExt.setParam(":VCLASS_ID", paramAddProductDAO.getClass_id());
    this.tradeQuery.executeBy(localAddProductExt.insBy("DEL_PRODUCT_BY_ID"));
    return 0;
  }

  public JSONArray getChildrenNodes(String paramString1, String paramString2, ArrayList paramArrayList)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str1 = localHashMap.get("class_name").toString();
        String str2 = localHashMap.get("class_id").toString();
        localTreeObject.setId(str2);
        localTreeObject.setText(str1);
        TreeNode localTreeNode = isLeaf(paramString1, str2);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    return localJSONArray;
  }

  public TreeNode isLeaf(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = getproductByUpId(paramString1, paramString2);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getChildrenNodes(paramString1, paramString2, localArrayList);
      localTreeNode.setChildren(localJSONArray);
    }
    return localTreeNode;
  }

  public int checkChildren(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = getproductByUpId(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getproductByUpId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AddProductExt localAddProductExt = new AddProductExt();
    localAddProductExt.setParam(":VCUST_ID", paramString1);
    localAddProductExt.setParam(":VUP_CLASS_ID", paramString2);
    localArrayList = localAddProductExt.selByList("SEL_BY_UP_ID");
    return localArrayList;
  }

  public HashMap getproductById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    AddProductExt localAddProductExt = new AddProductExt();
    localAddProductExt.setParam(":VCUST_ID", paramString1);
    localAddProductExt.setParam(":VCLASS_ID", paramString2);
    localArrayList = localAddProductExt.selByList("SEL_BY_ID");
    localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.addproductMgr.AddProductInfo
 * JD-Core Version:    0.6.0
 */