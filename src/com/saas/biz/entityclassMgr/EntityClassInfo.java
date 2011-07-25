package com.saas.biz.entityclassMgr;

import com.saas.biz.JavaScriptObject.CheckTreeObject;
import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.classDAO.ClassDAO;
import com.saas.biz.dao.classDAO.ClassExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import net.sf.json.JSONArray;

public class EntityClassInfo
{
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr comm = new commMethodMgr();
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

  public void addClassInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addClassInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ENTITY_TYPE");
    String str3 = paramBuffers.getString("CLASS_ID");
    String str4 = paramBuffers.getString("CLASS_NAME");
    String str5 = paramBuffers.getString("UP_CLASS_ID");
    String str6 = paramBuffers.getString("CLASS_LEVEL");
    String str7 = paramBuffers.getString("ONE_TAG");
    String str8 = paramBuffers.getString("CLASS_TYPE");
    String str9 = paramBuffers.getString("CLASS_DESC");
    String str10 = paramBuffers.getString("ENABLE_TAG");
    String str11 = paramBuffers.getString("SESSION_USER_ID");
    String str12 = paramBuffers.getString("REMARK");
    try
    {
      ClassDAO localClassDAO = new ClassDAO();
      localClassDAO.setClass_desc(str9);
      localClassDAO.setClass_id(str3);
      localClassDAO.setClass_level(str6);
      localClassDAO.setClass_name(str4);
      localClassDAO.setClass_type(str8);
      localClassDAO.setCust_id(str1);
      localClassDAO.setEnable_tag(str10);
      localClassDAO.setEntity_type(str2);
      localClassDAO.setUp_class_id(str5);
      localClassDAO.setOne_tag(str7);
      localClassDAO.setRemark(str12);
      localClassDAO.setOper_user_id(str11);
      i = addClassInfo(localClassDAO);
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
    this.log.LOG_INFO("退出addClassInfo方法...");
  }

  public int addClassInfo(ClassDAO paramClassDAO)
  {
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VCLASS_DESC", paramClassDAO.getClass_desc());
    localClassExt.setParam(":VCLASS_ID", paramClassDAO.getClass_id());
    localClassExt.setParam(":VCLASS_LEVEL", paramClassDAO.getClass_level());
    localClassExt.setParam(":VCLASS_NAME", paramClassDAO.getClass_name());
    localClassExt.setParam(":VCLASS_TYPE", paramClassDAO.getClass_type());
    localClassExt.setParam(":VCUST_ID", paramClassDAO.getCust_id());
    localClassExt.setParam(":VENABLE_TAG", paramClassDAO.getEnable_tag());
    localClassExt.setParam(":VENTITY_TYPE", paramClassDAO.getEntity_type());
    localClassExt.setParam(":VUP_CLASS_ID", paramClassDAO.getUp_class_id());
    localClassExt.setParam(":VONE_TAG", paramClassDAO.getOne_tag());
    localClassExt.setParam(":VREMARK", paramClassDAO.getRemark());
    localClassExt.setParam(":VOPER_USER_ID", paramClassDAO.getOper_user_id());
    this.tradeQuery.executeBy(localClassExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateClassInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateClassInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ENTITY_TYPE");
    String str3 = paramBuffers.getString("CLASS_ID");
    String str4 = paramBuffers.getString("CLASS_NAME");
    String str5 = paramBuffers.getString("UP_CLASS_ID");
    String str6 = paramBuffers.getString("CLASS_LEVEL");
    String str7 = paramBuffers.getString("ONE_TAG");
    String str8 = paramBuffers.getString("CLASS_TYPE");
    String str9 = paramBuffers.getString("CLASS_DESC");
    String str10 = paramBuffers.getString("ENABLE_TAG");
    String str11 = paramBuffers.getString("SESSION_USER_ID");
    String str12 = paramBuffers.getString("REMARK");
    try
    {
      ClassDAO localClassDAO = new ClassDAO();
      localClassDAO.setClass_desc(str9);
      localClassDAO.setClass_id(str3);
      localClassDAO.setClass_level(str6);
      localClassDAO.setClass_name(str4);
      localClassDAO.setClass_type(str8);
      localClassDAO.setCust_id(str1);
      localClassDAO.setEnable_tag(str10);
      localClassDAO.setEntity_type(str2);
      localClassDAO.setUp_class_id(str5);
      localClassDAO.setOne_tag(str7);
      localClassDAO.setRemark(str12);
      localClassDAO.setOper_user_id(str11);
      i = updateClassInfo(localClassDAO);
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
    this.log.LOG_INFO("退出updateClassInfo方法...");
  }

  public int updateClassInfo(ClassDAO paramClassDAO)
  {
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VCLASS_DESC", paramClassDAO.getClass_desc());
    localClassExt.setParam(":VCLASS_ID", paramClassDAO.getClass_id());
    localClassExt.setParam(":VCLASS_LEVEL", paramClassDAO.getClass_level());
    localClassExt.setParam(":VCLASS_NAME", paramClassDAO.getClass_name());
    localClassExt.setParam(":VCLASS_TYPE", paramClassDAO.getClass_type());
    localClassExt.setParam(":VCUST_ID", paramClassDAO.getCust_id());
    localClassExt.setParam(":VENABLE_TAG", paramClassDAO.getEnable_tag());
    localClassExt.setParam(":VENTITY_TYPE", paramClassDAO.getEntity_type());
    localClassExt.setParam(":VUP_CLASS_ID", paramClassDAO.getUp_class_id());
    localClassExt.setParam(":VONE_TAG", paramClassDAO.getOne_tag());
    localClassExt.setParam(":VREMARK", paramClassDAO.getRemark());
    localClassExt.setParam(":VOPER_USER_ID", paramClassDAO.getOper_user_id());
    this.tradeQuery.executeBy(localClassExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public void delClassInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delClassInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CLASS_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    try
    {
      ClassDAO localClassDAO = new ClassDAO();
      localClassDAO.setClass_id(str1);
      localClassDAO.setCust_id(str2);
      i = delClassInfo(localClassDAO);
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
    this.log.LOG_INFO("退出addClassInfo方法...");
  }

  public int delClassInfo(ClassDAO paramClassDAO)
  {
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VCLASS_ID", paramClassDAO.getClass_id());
    localClassExt.setParam(":VCUST_ID", paramClassDAO.getCust_id());
    this.tradeQuery.executeBy(localClassExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public ArrayList getClassInfoByClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VCLASS_ID", paramString2);
    localClassExt.setParam(":VCUST_ID", paramString1);
    localArrayList = localClassExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public Map getClassInfoByIdx(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    localArrayList = getClassInfoByClassId(paramString1, paramString2);
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      str1 = localHashMap2.get("entity_type").toString();
      str2 = localHashMap2.get("class_name").toString();
      str3 = localHashMap2.get("one_tag").toString();
      str4 = localHashMap2.get("class_type").toString();
      str5 = localHashMap2.get("class_desc").toString();
      str6 = localHashMap2.get("enable_tag").toString();
      str7 = localHashMap2.get("remark").toString();
    }
    localHashMap1.put("entity_type", str1);
    localHashMap1.put("class_name", str2);
    localHashMap1.put("one_tag", str3);
    localHashMap1.put("class_type", str4);
    localHashMap1.put("class_desc", str5);
    localHashMap1.put("enable_tag", str6);
    localHashMap1.put("remark", str7);
    return localHashMap1;
  }

  public Map getClassInfoByUpClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VUP_CLASS_ID", paramString2);
    localClassExt.setParam(":VCUST_ID", paramString1);
    localArrayList = localClassExt.selByList("SEL_BY_UPID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str1 = localHashMap.get("class_id").toString();
        String str2 = localHashMap.get("class_name").toString();
        localLinkedHashMap.put(str1, str2);
      }
    return localLinkedHashMap;
  }

  public Map getClassByUpClassAndEntity(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VUP_CLASS_ID", paramString2);
    localClassExt.setParam(":VCUST_ID", paramString1);
    localClassExt.setParam(":VENTITY_TYPE", paramString3);
    localArrayList = localClassExt.selByList("SEL_BY_ENTITY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str1 = localHashMap.get("class_id").toString();
        String str2 = localHashMap.get("class_name").toString();
        localLinkedHashMap.put(str1, str2);
      }
    return localLinkedHashMap;
  }

  public ArrayList getEntityByUpClassAndEntity(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VUP_CLASS_ID", paramString2);
    localClassExt.setParam(":VCUST_ID", paramString1);
    localClassExt.setParam(":VENTITY_TYPE", paramString3);
    localArrayList = localClassExt.selByList("SEL_BY_ENTITY");
    return localArrayList;
  }

  public ArrayList getEntityByUpClassMap(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VUP_CLASS_ID", paramString2);
    localClassExt.setParam(":VCUST_ID", paramString1);
    localClassExt.setParam(":VENTITY_TYPE", paramString3);
    ArrayList localArrayList2 = localClassExt.selByList("SEL_BY_ENTITY");
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)localArrayList2.get(i);
        String str1 = localHashMap1.get("class_id").toString();
        String str2 = localHashMap1.get("class_name").toString();
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put(str1, str2);
        localArrayList1.add(localHashMap2);
      }
    return localArrayList1;
  }

  public Map getUpClassIdAndName(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    Object localObject = new HashMap();
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = getUpClassByDown(paramString1, paramString2, paramString3);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      String str3 = localHashMap.get("class_id").toString();
      String str4 = localHashMap.get("class_name").toString();
      String str5 = localHashMap.get("up_class_id").toString();
      str1 = str4 + str1;
      str2 = str3 + str2;
      localObject = getClassNameAndId(str5, paramString2, paramString3, str1, str2);
    }
    return (Map)localObject;
  }

  public ArrayList getUpClassByDown(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VCLASS_ID", paramString1);
    localClassExt.setParam(":VCUST_ID", paramString2);
    localClassExt.setParam(":VENTITY_TYPE", paramString3);
    ArrayList localArrayList = localClassExt.selByList("SEL_BY_DOWN");
    return localArrayList;
  }

  public Map<String, String> getClassNameAndId(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ArrayList localArrayList = getUpClassByDown(paramString1, paramString2, paramString3);
    HashMap localHashMap1 = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      String str1 = localHashMap2.get("class_id").toString();
      String str2 = localHashMap2.get("class_name").toString();
      String str3 = localHashMap2.get("up_class_id").toString();
      paramString4 = str2 + "|" + paramString4;
      paramString5 = str1 + "|" + paramString5;
      Map localMap = getClassNameAndId(str3, paramString2, paramString3, paramString4, paramString5);
      Map.Entry localEntry = (Map.Entry)localMap.entrySet().iterator().next();
      paramString5 = String.valueOf(localEntry.getKey());
      paramString4 = String.valueOf(localEntry.getValue());
    }
    localHashMap1.put(paramString5, paramString4);
    return localHashMap1;
  }

  public String getJsonDataForTree(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("[");
    String str1 = "";
    String str2 = "";
    String str3 = "";
    ArrayList localArrayList = getEntityByUpClassAndEntity(paramString1, paramString2, paramString4);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        str2 = localHashMap.get("class_name").toString();
        str3 = localHashMap.get("class_id").toString();
        localStringBuffer1.append("{text:'" + str2 + "',id:'" + str3 + "',iconCls:'" + paramString3 + "',");
        boolean bool = hasNextNode(paramString1, str3, paramString4);
        if (bool)
        {
          localStringBuffer1.append("leaf:false,children:[");
          StringBuffer localStringBuffer2 = new StringBuffer();
          String str4 = getChildrenJsonData(localStringBuffer2, paramString1, str3, paramString3, paramString4);
          localStringBuffer1.append(str4);
          localStringBuffer1.append("]},");
        }
        else
        {
          localStringBuffer1.append("leaf:true},");
        }
      }
      localStringBuffer1.deleteCharAt(localStringBuffer1.lastIndexOf(","));
      localStringBuffer1.append("]");
      str1 = localStringBuffer1.toString();
    }
    return str1;
  }

  public String getChildrenJsonData(StringBuffer paramStringBuffer, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    ArrayList localArrayList = getEntityByUpClassAndEntity(paramString1, paramString2, paramString4);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        str2 = localHashMap.get("class_name").toString();
        str3 = localHashMap.get("class_id").toString();
        paramStringBuffer.append("{text:'" + str2 + "',id:'" + str3 + "',iconCls:'" + paramString3 + "',");
        boolean bool = hasNextNode(paramString1, str3, paramString4);
        if (bool)
        {
          paramStringBuffer.append("leaf:false,children:[");
          StringBuffer localStringBuffer = new StringBuffer();
          String str4 = getChildrenJsonData(localStringBuffer, paramString1, str3, paramString3, paramString4);
          paramStringBuffer.append(str4);
          paramStringBuffer.append("]},");
        }
        else
        {
          paramStringBuffer.append("leaf:true},");
        }
      }
      paramStringBuffer.deleteCharAt(paramStringBuffer.lastIndexOf(","));
      str1 = paramStringBuffer.toString();
    }
    return str1;
  }

  public boolean hasNextNode(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    boolean i = false;
    ArrayList localArrayList = getEntityByUpClassAndEntity(paramString1, paramString2, paramString3);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = true;
    return i;
  }

  public String getJSONCheckBoxTreeData(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    String str1 = "";
    ArrayList localArrayList = getEntityByUpClassAndEntity(paramString1, paramString2, paramString3);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("class_name").toString();
        String str3 = localHashMap.get("class_id").toString();
        CheckTreeObject localCheckTreeObject = new CheckTreeObject();
        localCheckTreeObject.setText(str2);
        localCheckTreeObject.setId(str3);
        localCheckTreeObject.setChecked(false);
        TreeNode localTreeNode = isLeaf(paramString1, 0, str3, paramString3);
        localCheckTreeObject.setDepth(0);
        localCheckTreeObject.setIconCls(paramString4);
        localCheckTreeObject.setLeaf(localTreeNode.isLeaf());
        localCheckTreeObject.setChildren(localTreeNode.getChildren());
        localJSONArray.add(localCheckTreeObject);
      }
      str1 = localJSONArray.toString();
    }
    return str1;
  }

  public JSONArray getChildrenNodes(String paramString1, String paramString2, int paramInt, ArrayList paramArrayList, String paramString3)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        CheckTreeObject localCheckTreeObject = new CheckTreeObject();
        String str1 = localHashMap.get("class_name").toString();
        String str2 = localHashMap.get("class_id").toString();
        localCheckTreeObject.setId(str2);
        localCheckTreeObject.setText(str1);
        localCheckTreeObject.setDepth(paramInt);
        TreeNode localTreeNode = isLeaf(paramString1, paramInt, str2, paramString3);
        localCheckTreeObject.setChildren(localTreeNode.getChildren());
        localCheckTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localCheckTreeObject);
      }
    return localJSONArray;
  }

  public TreeNode isLeaf(String paramString1, int paramInt, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    paramInt += 1;
    ArrayList localArrayList = getEntityByUpClassAndEntity(paramString1, paramString2, paramString3);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getChildrenNodes(paramString1, paramString2, paramInt, localArrayList, paramString3);
      localTreeNode.setChildren(localJSONArray);
    }
    return localTreeNode;
  }

  public ArrayList getAllClassByEntityType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VCUST_ID", paramString1);
    localClassExt.setParam(":VENTITY_TYPE", paramString2);
    localArrayList = localClassExt.selByList("SEL_ALL_BY_ENTITY_TYPE");
    return localArrayList;
  }

  public ArrayList getAllOppEntityType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ClassExt localClassExt = new ClassExt();
    localClassExt.setParam(":VCUST_ID", paramString1);
    localClassExt.setParam(":VENTITY_TYPE", "2");
    localArrayList = localClassExt.selByList("SEL_ALL_BY_ENTITY_TYPE");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.entityclassMgr.EntityClassInfo
 * JD-Core Version:    0.6.0
 */