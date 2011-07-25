package com.saas.biz.productclassMgr;

import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.JavaScriptObject.TreeObject;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.commen.config;
import com.saas.biz.dao.productclassDAO.ProductclassDAO;
import com.saas.biz.dao.productclassDAO.ProductclassExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;

public class Productclass
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();
  commMethodMgr comm = new commMethodMgr();

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

  public String getInfoId()
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    return str;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void addClassInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addClassInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CLASS_NAME");
    String str2 = new String(str1);
    String[] arrayOfString = str2.split(",");
    this.log.LOG_INFO(str1 + "********");
    try
    {
      for (int j = 0; j < arrayOfString.length; j++)
      {
        ProductclassDAO localProductclassDAO = new ProductclassDAO();
        localProductclassDAO.setClass_level(paramBuffers.getString("CLASS_LEVEL"));
        localProductclassDAO.setClass_name(arrayOfString[j]);
        localProductclassDAO.setClass_type(paramBuffers.getString("CLASS_TYPE"));
        localProductclassDAO.setEnable_tag(paramBuffers.getString("ENABLE_TAG"));
        localProductclassDAO.setUp_class_id(paramBuffers.getString("UP_CLASS_ID"));
        localProductclassDAO.setClass_desc(paramBuffers.getString("CLASS_DESC"));
        localProductclassDAO.setRsrv_str1("");
        i = addClassInfo(localProductclassDAO);
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
    this.log.LOG_INFO("退出addClassInfo方法...");
  }

  public int testStr()
  {
    String str = "td_b_productclass where up_class_id=\"000000000000000\"";
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VSQL", str);
    localArrayList = localProductclassExt.selByList("SEL_CLASS_UBANTU");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public int addClassInfo(ProductclassDAO paramProductclassDAO)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    localProductclassExt.setParam(":VCLASS_LEVEL", paramProductclassDAO.getClass_level());
    localProductclassExt.setParam(":VCLASS_NAME", paramProductclassDAO.getClass_name());
    localProductclassExt.setParam(":VCLASS_TYPE", paramProductclassDAO.getClass_type());
    localProductclassExt.setParam(":VUP_CLASS_ID", paramProductclassDAO.getUp_class_id());
    localProductclassExt.setParam(":VENABLE_TAG", paramProductclassDAO.getEnable_tag());
    localProductclassExt.setParam(":VCLASS_DESC", paramProductclassDAO.getClass_desc());
    localProductclassExt.setParam(":VCLASS_ID", str);
    localProductclassExt.setParam(":VRSRV_STR1", paramProductclassDAO.getRsrv_str1());
    localProductclassExt.setParam(":VRSRV_STR2", "");
    localProductclassExt.setParam(":VRSRV_STR3", "");
    localProductclassExt.setParam(":VRSRV_STR4", "");
    localProductclassExt.setParam(":VRSRV_STR5", "");
    localProductclassExt.setParam(":VRSRV_STR6", "");
    localProductclassExt.setParam(":VRSRV_STR7", "");
    localProductclassExt.setParam(":VRSRV_STR8", "");
    localProductclassExt.setParam(":VRSRV_STR9", "");
    localProductclassExt.setParam(":VRSRV_STR10", "");
    localProductclassExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localProductclassExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public String getProdtClassByUpId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    String str1 = "";
    HashMap localHashMap1 = new HashMap();
    String str2 = "";
    String str3 = "";
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_TYPE", paramString2);
    localArrayList = localProductclassExt.selByList("SEL_CLASS_BY_UP");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        if (localHashMap2.get("class_name") != null)
          str3 = localHashMap2.get("class_name").toString();
        if (localHashMap2.get("class_id") != null)
          str2 = localHashMap2.get("class_id").toString();
        str1 = "<input type=\"checkbox\"  name=\"src\" id=\"src\" onclick=\"test1(this)\"  value=\"" + str2 + "\"/>" + str3 + "&nbsp;&nbsp;";
        localStringBuffer.append(str1);
      }
    return localStringBuffer.toString();
  }

  public String getPdtClassByUpId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    Object localObject = "";
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_TYPE", paramString2);
    localArrayList = localProductclassExt.selByList("SEL_CLASS_BY_UP");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        if (localHashMap2.get("class_name") != null)
          str2 = localHashMap2.get("class_name").toString();
        if (localHashMap2.get("class_id") != null)
          str1 = localHashMap2.get("class_id").toString();
        if (i != localArrayList.size() - 1)
          localObject = str2 + ",";
        else
          localObject = str2;
        localStringBuffer.append((String)localObject);
      }
    else
      localStringBuffer.append("没有子分类!");
    return (String)localStringBuffer.toString();
  }

  public String getImgTypeup()
  {
    config localconfig = new config();
    ArrayList localArrayList = new ArrayList();
    localArrayList = localconfig.getLogProperties();
    String str = "";
    for (int i = 0; i < localArrayList.size(); i++)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(i);
      if ((localHashMap.get("name") == null) || (!"imageext".equals(localHashMap.get("name").toString())))
        continue;
      System.out.println(localHashMap.get("name").toString());
      System.out.println(localHashMap.get("value").toString());
      str = localHashMap.get("value").toString();
    }
    return str;
  }

  private ArrayList getClsById(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_BY_CLASSID");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public void addNewsClassInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addClassInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    ProductclassDAO localProductclassDAO = new ProductclassDAO();
    localProductclassDAO.setClass_level(paramBuffers.getString("CLASS_LEVEL"));
    localProductclassDAO.setClass_name(paramBuffers.getString("CLASS_NAME"));
    localProductclassDAO.setClass_type(paramBuffers.getString("CLASS_TYPE"));
    localProductclassDAO.setEnable_tag(paramBuffers.getString("ENABLE_TAG"));
    localProductclassDAO.setUp_class_id(paramBuffers.getString("UP_CLASS_ID"));
    localProductclassDAO.setClass_desc(paramBuffers.getString("CLASS_DESC"));
    localProductclassDAO.setRsrv_str1(paramBuffers.getString("RSRV_STR1"));
    try
    {
      i = addClassInfo(localProductclassDAO);
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
    this.log.LOG_INFO("退出addClassInfo方法...");
  }

  public void delByClassId(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delByClassId方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("CLASS_ID");
    try
    {
      i = delByClassId(str);
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
    this.log.LOG_INFO("退出delByClassId方法...");
  }

  public int delByClassId(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    this.tradeQuery.executeBy(localProductclassExt.insBy("DEL_BY_CLASSID"));
    return 0;
  }

  public ArrayList genClassByRsrv_str1(String paramString, int paramInt)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("enter in the (genClassByRsrv_str1)...");
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    localProductclassExt.setParam(":VRSRV_STR1", paramString);
    this.log.LOG_INFO("SQL=" + localProductclassExt.selByList("SEL_CLASS_BYRSRV_STR1", 0, paramInt));
    localArrayList = localProductclassExt.selByList("SEL_CLASS_BYRSRV_STR1", 0, paramInt);
    if ((localArrayList == null) || (localArrayList.size() <= 0))
      localArrayList = null;
    this.log.LOG_INFO("out of the (genClassByRsrv_str1)...");
    return localArrayList;
  }

  public ArrayList genClassNameByRsrv_str1(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    localProductclassExt.setParam(":VRSRV_STR1", paramString);
    localArrayList = localProductclassExt.selByList("SEL_CLASSNAME_BYRSRV_STR1");
    if ((localArrayList == null) || (localArrayList.size() <= 0))
      localArrayList = null;
    return localArrayList;
  }

  public void genUpclassByClassId(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genUpclassByClassId方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("CLASS_ID");
    try
    {
      this.queryResult = genUpclassByClassId(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genUpclassByClassId方法...");
  }

  public boolean isExsit(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_TYPE", paramString2);
    localArrayList = localProductclassExt.selByList("SEL_CLASS_BY_UP");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        if ((localHashMap2.get("class_name") != null) && (paramString3.equals(localHashMap2.get("class_name").toString())))
          return true;
      }
    this.log.LOG_INFO("not exist the sepcil name...");
    return false;
  }

  public ArrayList genUpclassByClassId(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_CLASSUP_BYDOWN");
    if ((localArrayList == null) || (localArrayList.size() <= 0))
      localArrayList = null;
    return localArrayList;
  }

  public void genDownclassByClassId(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genDownclassByClassId方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("CLASS_ID");
    try
    {
      this.queryResult = genDownclassByClassId(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genDownclassByClassId方法...");
  }

  public ArrayList genDownclassByClassId(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_CLASSDOWN_BYUP");
    if ((localArrayList == null) || (localArrayList.size() <= 0))
      localArrayList = null;
    return localArrayList;
  }

  public Map getProductClassByUpId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_TYPE", paramString2);
    localArrayList = localProductclassExt.selByList("SEL_CLASS_BY_UP");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("class_name") != null)
          str2 = localHashMap.get("class_name").toString();
        if (localHashMap.get("class_id") != null)
          str1 = localHashMap.get("class_id").toString();
        localLinkedHashMap.put(str1, str2);
      }
    return localLinkedHashMap;
  }

  public Map getclassByClassId(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_BY_CLASSID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      if (localHashMap2.get("class_name") != null)
        str1 = localHashMap2.get("class_name").toString();
      if (localHashMap2.get("class_desc") != null)
        str2 = localHashMap2.get("class_desc").toString();
    }
    localHashMap1.put("class_name", str1);
    localHashMap1.put("class_desc", str2);
    return localHashMap1;
  }

  public String getJsonDataForTree(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = paramString3;
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = getInfoByUpId(paramString2, paramString1);
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
        TreeNode localTreeNode = isLeaf(str3, paramString1);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    return localJSONArray.toString();
  }

  public ArrayList getInfoByUpId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", paramString2);
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localArrayList = localProductclassExt.selByList("SEL_CLASS_BY_UP");
    return localArrayList;
  }

  public TreeNode isLeaf(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = getInfoByUpId(paramString1, paramString2);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getChildrenNodes(paramString1, localArrayList, paramString2);
      localTreeNode.setChildren(localJSONArray);
    }
    return localTreeNode;
  }

  public JSONArray getChildrenNodes(String paramString1, ArrayList paramArrayList, String paramString2)
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
        TreeNode localTreeNode = isLeaf(str2, paramString2);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    return localJSONArray;
  }

  public int getProductClassCount(int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_BY_CLASSID_CT", paramInt1, paramInt2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public int checkChildren(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_BY_UP");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void deleteClassInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteClassInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CLASS_ID");
    String str2 = paramBuffers.getString("TYPE");
    String str3;
    if (str2.equals("1"))
      try
      {
        StringTokenizer localStringTokenizer1 = new StringTokenizer(str1, "|");
        str3 = "";
        while (localStringTokenizer1.hasMoreTokens())
        {
          str3 = localStringTokenizer1.nextToken();
          i = deleteClassInfo(str3);
        }
      }
      catch (SaasApplicationException localSaasApplicationException1)
      {
        this.log.LOG_INFO(localSaasApplicationException1.getMessage());
      }
    else
      try
      {
        StringTokenizer localStringTokenizer2 = new StringTokenizer(str1, "|");
        str3 = "";
        while (localStringTokenizer2.hasMoreTokens())
        {
          str3 = localStringTokenizer2.nextToken();
          i = deleteClassInfoNO(str3);
        }
      }
      catch (SaasApplicationException localSaasApplicationException2)
      {
        this.log.LOG_INFO(localSaasApplicationException2.getMessage());
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
    this.log.LOG_INFO("退出deleteClassInfo方法...");
  }

  public int deleteClassInfo(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    this.tradeQuery.executeBy(localProductclassExt.insBy("DELETE_BY_ID"));
    return 0;
  }

  public int deleteClassInfoNO(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    this.tradeQuery.executeBy(localProductclassExt.insBy("DELETE_BY_ID_NO"));
    return 0;
  }

  public void updateByClassId(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateByClassId方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CLASS_ID");
    String str2 = paramBuffers.getString("CLASS_NAME");
    String str3 = paramBuffers.getString("CLASS_DESC");
    try
    {
      i = updateByClassId(str1, str2, str3);
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
    this.log.LOG_INFO("退出updateByClassId方法...");
  }

  public int updateByClassId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_NAME", paramString2);
    localProductclassExt.setParam(":VCLASS_DESC", paramString3);
    this.tradeQuery.executeBy(localProductclassExt.insBy("UPDATE_CLASS_BY_ID"));
    return 0;
  }

  public ArrayList genClassNameByClassId(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_NAME_BY_ID");
    if ((localArrayList == null) || (localArrayList.size() <= 0))
      localArrayList = null;
    return localArrayList;
  }

  public ArrayList getClassInfoByTypeLevel(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", paramString1);
    localProductclassExt.setParam(":VCLASS_LEVEL", paramString2);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CLASS_BY_LEVEL");
    return localArrayList;
  }

  public Map getClassTypeLevels()
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", "3");
    localProductclassExt.setParam(":VCLASS_LEVEL", "1");
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CLASS_BY_LEVEL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = "";
        String str2 = "";
        if (localHashMap2.get("class_id") != null)
          str1 = localHashMap2.get("class_id").toString();
        if (localHashMap2.get("class_name") != null)
          str2 = localHashMap2.get("class_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public String getSelectedByComm(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = getClassInfoByTypeLevel(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("class_id").toString();
        String str3 = localHashMap.get("class_name").toString();
        str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>";
      }
    return str1;
  }

  public ArrayList getClassInfoByUpClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", paramString1);
    localProductclassExt.setParam(":VUP_ClASS_ID", paramString2);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_BY_CLASS_TYPE");
    return localArrayList;
  }

  public String getClassInfoByUpClassTT(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", paramString);
    localProductclassExt.setParam(":VPARAM_CODE", "class_type");
    ArrayList localArrayList = localProductclassExt.selByList("SEL_BY_PARA_TYPE_NAME");
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code2") != null)
        str = localHashMap.get("para_code2").toString();
    }
    return str;
  }

  public ArrayList getClassInfoByUpClassId(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", paramString1);
    localProductclassExt.setParam(":VUP_ClASS_ID", paramString2);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_BY_CLASS_TYPE", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getClassInfoByUpClassId(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_ClASS_ID", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_SMALL_CLASS_BY_UP_CLASS_ID");
    return localArrayList;
  }

  public ArrayList getFirstClassLevel(int paramInt)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", "2");
    localProductclassExt.setParam(":VUP_ClASS_ID", "000000000000000");
    ArrayList localArrayList = localProductclassExt.selByList("SEL_BY_CLASS_TYPE", 0, paramInt);
    return localArrayList;
  }

  public String getCalalogInfo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getCalalogInfo方法...");
    String str1 = "";
    ArrayList localArrayList = getClassInfoByUpId(paramString2, paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      String str2 = "";
      if (localHashMap.get("up_class_id") != null)
        str2 = localHashMap.get("up_class_id").toString();
      str1 = getCalalogUrl(paramString1, paramString2, paramString3) + str1;
      if ((str2 == "000000000000000") || (str2.equals("000000000000000")))
        return str1;
      str1 = getCalalogInfo(paramString1, str2, paramString3) + str1;
    }
    this.log.LOG_INFO(".............." + str1);
    return str1;
  }

  public String getCalalogUrl(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getCalalogUrl方法...");
    String str1 = "";
    ArrayList localArrayList = getClassInfoByUpId(paramString2, paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      String str2 = "";
      if (localHashMap.get("class_name") != null)
        str2 = localHashMap.get("class_name").toString();
      if (localHashMap.get("class_id") != null)
        paramString2 = localHashMap.get("class_id").toString();
      str1 = "<a href=" + paramString3 + paramString2 + ">" + str2 + "</a>&nbsp;<img src=/images/lujian.gif border=0>" + str1;
    }
    return str1;
  }

  public ArrayList getClassInfoByUpId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getClassInfoByUpId方法...");
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_TYPE", paramString2);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CLASS_BY_LEAVE");
    return localArrayList;
  }

  public ArrayList getClassByUpId()
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CLASS_BY");
    return localArrayList;
  }

  public String getClassNameById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CLASS_NAME_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("class_name") != null)
        str = localHashMap.get("class_name").toString();
    }
    return str;
  }

  public String getClassUpIdById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CLASS_NAME_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("up_class_id") != null)
        str = localHashMap.get("up_class_id").toString();
    }
    return str;
  }

  public ArrayList getClassByUpIds()
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CLASS_BYS");
    return localArrayList;
  }

  public ArrayList getClassByUpClassId(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localProductclassExt.setParam(":VTYPE", paramString2);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CLASS_BYS_BY_UP_ID", paramInt, 20);
    return localArrayList;
  }

  public int getClassByUpClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localProductclassExt.setParam(":VTYPE", paramString2);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CLASS_BYS_BY_UP_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getClassInfoByClassType(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_BY_ONLY_CLASS_TYPE");
    return localArrayList;
  }

  public void UpdateRsrv(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入UpdateRsrv方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CLASS_ID");
    String str2 = paramBuffers.getString("RSRV_STR2");
    try
    {
      StringTokenizer localStringTokenizer1 = new StringTokenizer(str1, "|");
      StringTokenizer localStringTokenizer2 = new StringTokenizer(str2, "|");
      String str3 = "";
      String str4 = "";
      while (localStringTokenizer1.hasMoreTokens())
      {
        str3 = localStringTokenizer1.nextToken();
        str4 = localStringTokenizer2.nextToken();
        i = UpdateRsrv(str3, str4);
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
    this.log.LOG_INFO("退出UpdateRsrv方法...");
  }

  public int UpdateRsrv(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString1);
    localProductclassExt.setParam(":VRSRV_STR2", paramString2);
    this.tradeQuery.executeBy(localProductclassExt.insBy("UPDATE_RSRV_BY_ID"));
    return 0;
  }

  public void UpdateUpClassId(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入UpdateUpClassId方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CLASS_ID");
    String str2 = paramBuffers.getString("FEE");
    this.log.LOG_INFO("退出UpdateUpClassId方法..." + str2 + "89999999999" + str1);
    try
    {
      i = UpdateUpClassId(str1, str2);
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
    this.log.LOG_INFO("退出UpdateUpClassId方法...");
  }

  public int UpdateUpClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_ID", paramString2);
    this.tradeQuery.executeBy(localProductclassExt.insBy("UPDATE_UP_CLASS_UP_BY_ID"));
    return 0;
  }

  public ArrayList getClassInfoByUpClassIdPage(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_ClASS_ID", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_SMALL_CLASS_BY_UP_CLASS_ID", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList UpSon(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_CLASSDOWN_BY");
    return localArrayList;
  }

  public Boolean checkSon(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_CLASSDOWN_BYUP");
    if (localArrayList == null)
      return Boolean.valueOf(false);
    return Boolean.valueOf(true);
  }

  public void copyClassType(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入copyClassType方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("all_class_id");
    String str2 = paramBuffers.getString("to_class_type");
    String str3 = paramBuffers.getString("from_class_type");
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    String str4 = "";
    try
    {
      while (localStringTokenizer.hasMoreTokens())
      {
        str4 = localStringTokenizer.nextToken();
        i = copyCircleKind(str4, str3, str2, "1", "000000000000000");
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
    this.log.LOG_INFO("退出copyClassType方法...");
  }

  public int copyCircleKind(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    int i = -1;
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str1 = localcommMethodMgr.GenTradeId();
    i = copyClassType(str1, getClassNameById(paramString1), paramString4, paramString3, paramString5);
    if (checkSon(paramString1).booleanValue())
    {
      ArrayList localArrayList = UpSon(paramString1);
      if ((localArrayList != null) && (localArrayList.size() > 0))
        for (int j = 0; j < localArrayList.size(); j++)
        {
          HashMap localHashMap = (HashMap)localArrayList.get(j);
          String str2 = "";
          String str3 = "";
          if (localHashMap.get("class_id") != null)
            str2 = localHashMap.get("class_id").toString();
          if (localHashMap.get("class_level") != null)
            str3 = localHashMap.get("class_level").toString();
          copyCircleKind(str2, paramString2, paramString3, str3, str1);
        }
    }
    return 0;
  }

  public int copyClassType(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_LEVEL", paramString3);
    localProductclassExt.setParam(":VCLASS_NAME", paramString2);
    localProductclassExt.setParam(":VCLASS_TYPE", paramString4);
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString5);
    localProductclassExt.setParam(":VENABLE_TAG", "0");
    localProductclassExt.setParam(":VCLASS_DESC", paramString2);
    localProductclassExt.setParam(":VRSRV_STR1", "");
    localProductclassExt.setParam(":VRSRV_STR2", "");
    localProductclassExt.setParam(":VRSRV_STR3", "");
    localProductclassExt.setParam(":VRSRV_STR4", "");
    localProductclassExt.setParam(":VRSRV_STR5", "");
    localProductclassExt.setParam(":VRSRV_STR6", "");
    localProductclassExt.setParam(":VRSRV_STR7", "");
    localProductclassExt.setParam(":VRSRV_STR8", "");
    localProductclassExt.setParam(":VRSRV_STR9", "");
    localProductclassExt.setParam(":VRSRV_STR10", "");
    localProductclassExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localProductclassExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public String getInfoClassIdByClassName(String paramString)
    throws SaasApplicationException
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    localProductclassExt.setParam(":VCLASS_NAME", paramString);
    localArrayList = localProductclassExt.selByList("SEL_BY_CLASS_NAME");
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("class_id") != null)
        str = localHashMap.get("class_id").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.productclassMgr.Productclass
 * JD-Core Version:    0.6.0
 */