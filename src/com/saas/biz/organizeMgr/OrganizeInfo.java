package com.saas.biz.organizeMgr;

import com.saas.biz.JavaScriptObject.CheckTreeObject;
import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.custDAO.CustomerExt;
import com.saas.biz.dao.organizeDAO.OrganizeDAO;
import com.saas.biz.dao.organizeDAO.OrganizeExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;

public class OrganizeInfo
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

  public void addOrganizeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addOrganizeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ORG_ID");
    String str3 = paramBuffers.getString("ORG_NAME");
    String str4 = paramBuffers.getString("UP_ORG_ID");
    String str5 = paramBuffers.getString("ORG_CLASS");
    String str6 = paramBuffers.getString("ORG_TYPE");
    String str7 = paramBuffers.getString("ORG_DESC");
    String str8 = paramBuffers.getString("REMARK");
    try
    {
      OrganizeDAO localOrganizeDAO = new OrganizeDAO();
      localOrganizeDAO.setCust_id(str1);
      localOrganizeDAO.setOrg_id(str2);
      localOrganizeDAO.setOrg_class(str5);
      localOrganizeDAO.setOrg_desc(str7);
      localOrganizeDAO.setOrg_type(str6);
      localOrganizeDAO.setOrg_name(str3);
      localOrganizeDAO.setUp_org_id(str4);
      localOrganizeDAO.setRemark(str8);
      i = addOrganizeInfo(localOrganizeDAO);
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
    this.log.LOG_INFO("退出addOrganizeInfo方法...");
  }

  public int addOrganizeInfo(OrganizeDAO paramOrganizeDAO)
    throws SaasApplicationException
  {
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VCUST_ID", paramOrganizeDAO.getCust_id());
    localOrganizeExt.setParam(":VORG_ID", paramOrganizeDAO.getOrg_id());
    localOrganizeExt.setParam(":VORG_NAME", paramOrganizeDAO.getOrg_name());
    localOrganizeExt.setParam(":VUP_ORG_ID", paramOrganizeDAO.getUp_org_id());
    localOrganizeExt.setParam(":VORG_CLASS", paramOrganizeDAO.getOrg_class());
    localOrganizeExt.setParam(":VORG_TYPE", paramOrganizeDAO.getOrg_type());
    localOrganizeExt.setParam(":VORG_DESC", paramOrganizeDAO.getOrg_desc());
    localOrganizeExt.setParam(":VREMARK", paramOrganizeDAO.getRemark());
    this.tradeQuery.executeBy(localOrganizeExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("ORG_ID", paramOrganizeDAO.getOrg_id());
    return 0;
  }

  public void creatNewOrg(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入creatNewOrg方法...");
    int i = -1;
    try
    {
      String str = paramBuffers.getString("CUST_ID");
      OrganizeDAO localOrganizeDAO = new OrganizeDAO();
      localOrganizeDAO.setCust_id(str);
      localOrganizeDAO.setOrg_id(str);
      localOrganizeDAO.setOrg_class("1");
      localOrganizeDAO.setOrg_desc("软件管理中心");
      localOrganizeDAO.setOrg_type("0");
      localOrganizeDAO.setOrg_name("软件管理中心");
      localOrganizeDAO.setUp_org_id("000000000000000");
      localOrganizeDAO.setRemark("新用户");
      i = addOrganizeInfo(localOrganizeDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "7业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出creatNewOrg方法...");
  }

  public void updateOrganizeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateOrganizeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ORG_ID");
    String str3 = paramBuffers.getString("ORG_NAME");
    String str4 = paramBuffers.getString("ORG_DESC");
    String str5 = paramBuffers.getString("REMARK");
    try
    {
      OrganizeDAO localOrganizeDAO = new OrganizeDAO();
      localOrganizeDAO.setCust_id(str1);
      localOrganizeDAO.setOrg_id(str2);
      localOrganizeDAO.setOrg_desc(str4);
      localOrganizeDAO.setOrg_name(str3);
      localOrganizeDAO.setRemark(str5);
      i = updateOrganizeInfo(localOrganizeDAO);
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
    this.log.LOG_INFO("退出updateOrganizeInfo方法...");
  }

  public int updateOrganizeInfo(OrganizeDAO paramOrganizeDAO)
    throws SaasApplicationException
  {
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VCUST_ID", paramOrganizeDAO.getCust_id());
    localOrganizeExt.setParam(":VORG_ID", paramOrganizeDAO.getOrg_id());
    localOrganizeExt.setParam(":VORG_NAME", paramOrganizeDAO.getOrg_name());
    localOrganizeExt.setParam(":VORG_DESC", paramOrganizeDAO.getOrg_desc());
    localOrganizeExt.setParam(":VREMARK", paramOrganizeDAO.getRemark());
    this.tradeQuery.executeBy(localOrganizeExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public void delOrganizeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delOrganizeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("ORG_ID");
    try
    {
      i = delOrganizeInfo(str);
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
    this.log.LOG_INFO("退出delOrganizeInfo方法...");
  }

  public void DeleteOrganizeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteOrganizeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("ORG_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        if ((str2.equals("")) || (str2 == null))
          continue;
        i = delOrganizeInfo(str2);
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
    this.log.LOG_INFO("退出DeleteOrganizeInfo方法...");
  }

  public int delOrganizeInfo(String paramString)
    throws SaasApplicationException
  {
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VORG_ID", paramString);
    this.tradeQuery.executeBy(localOrganizeExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public ArrayList getOrgnaizeByCust_id(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VCUST_ID", paramString);
    localArrayList = localOrganizeExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList getAllOrgnaize()
  {
    ArrayList localArrayList = new ArrayList();
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localArrayList = localOrganizeExt.selByList("SEL_BY_ALL");
    return localArrayList;
  }

  public ArrayList getOrgnaizeByOrg_id(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VORG_ID", paramString);
    localArrayList = localOrganizeExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public HashMap getOrgnaizeByOrg_id1(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VORG_ID", paramString);
    localArrayList = localOrganizeExt.selByList("SEL_BY_ID");
    String str1 = "";
    String str2 = "";
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        localHashMap1 = (HashMap)localArrayList.get(i);
        if (localHashMap1.get("org_desc") != null)
          str1 = localHashMap1.get("org_desc").toString();
        if (localHashMap1.get("remark") != null)
          str2 = localHashMap1.get("remark").toString();
        localHashMap2.put(str1, str2);
      }
    return localHashMap2;
  }

  public ArrayList getUpOrganizeInfo(String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("cust_id=" + paramString);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      OrganizeExt localOrganizeExt = new OrganizeExt();
      localOrganizeExt.setParam(":VCUST_ID", paramString);
      localArrayList1 = localOrganizeExt.selByList("SEL_BY_UP");
      HashMap localHashMap1;
      String str;
      Object localObject;
      if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      {
        for (int i = 0; i < localArrayList1.size(); i++)
        {
          localHashMap1 = (HashMap)localArrayList1.get(i);
          str = localHashMap1.get("org_id").toString();
          localObject = localHashMap1.get("org_name").toString();
          HashMap localHashMap2 = new HashMap();
          localHashMap2.put("org_id", str);
          localHashMap2.put("org_name", localObject);
          localArrayList2.add(localHashMap2);
        }
      }
      else
      {
        CustomerExt localCustomerExt = new CustomerExt();
        localCustomerExt.setParam(":VCUST_ID", paramString);
        localArrayList1 = localCustomerExt.selByList("SEL_SPEC_CUST");
        if ((localArrayList1 != null) && (localArrayList1.size() > 0))
        {
          localHashMap1 = (HashMap)localArrayList1.get(0);
          str = localHashMap1.get("cust_name").toString();
          localObject = new HashMap();
          ((HashMap)localObject).put("org_id", "000000000000000");
          ((HashMap)localObject).put("org_name", str);
          localArrayList2.add(localObject);
        }
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return (ArrayList)localArrayList2;
  }

  public HashMap getOrganizeByUpId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VCUST_ID", paramString1);
    localOrganizeExt.setParam(":VUP_ORG_ID", paramString2);
    localArrayList = localOrganizeExt.selByList("SEL_BY_UP_ORG");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = localHashMap2.get("org_id").toString();
        String str2 = localHashMap2.get("org_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public List getOrganizeByUpIdMap(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      OrganizeExt localOrganizeExt = new OrganizeExt();
      localOrganizeExt.setParam(":VCUST_ID", paramString1);
      localOrganizeExt.setParam(":VUP_ORG_ID", paramString2);
      localArrayList1 = localOrganizeExt.selByList("SEL_BY_UP_ORG");
      if ((localArrayList1 != null) && (localArrayList1.size() > 0))
        for (int i = 0; i < localArrayList1.size(); i++)
        {
          HashMap localHashMap1 = (HashMap)localArrayList1.get(i);
          String str1 = localHashMap1.get("org_id").toString();
          String str2 = localHashMap1.get("org_name").toString();
          HashMap localHashMap2 = new HashMap();
          localHashMap2.put(str1, str2);
          localArrayList2.add(localHashMap2);
        }
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList2;
  }

  public int checkChildren(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = getOrganizeByUpId(paramString1, paramString2);
    int i = 0;
    if ((localHashMap != null) && (localHashMap.size() > 0))
      i = 1;
    return i;
  }

  public ArrayList getOrganizeByUpIdList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    i *= 20;
    ArrayList localArrayList = new ArrayList();
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VCUST_ID", paramString1);
    localOrganizeExt.setParam(":VUP_ORG_ID", paramString2);
    localArrayList = localOrganizeExt.selByList("SEL_BY_UP_ORG", i, 20);
    return localArrayList;
  }

  public ArrayList getOrganizeByUpIdList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VCUST_ID", paramString1);
    localOrganizeExt.setParam(":VUP_ORG_ID", paramString2);
    localArrayList = localOrganizeExt.selByList("SEL_BY_UP_ORG", paramInt, 30);
    return localArrayList;
  }

  public int getOrganizeByUpIdCount(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VCUST_ID", paramString1);
    localOrganizeExt.setParam(":VUP_ORG_ID", paramString2);
    localArrayList = localOrganizeExt.selByList("SEL_BY_UP_ORG");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public HashMap getOrganizeByOrgId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    OrganizeExt localOrganizeExt = new OrganizeExt();
    localOrganizeExt.setParam(":VORG_ID", paramString);
    localArrayList = localOrganizeExt.selByList("SEL_BY_ID");
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      if (localHashMap2.get("org_name") != null)
        str1 = localHashMap2.get("org_name").toString();
      if (localHashMap2.get("org_desc") != null)
        str2 = localHashMap2.get("org_desc").toString();
      if (localHashMap2.get("remark") != null)
        str3 = localHashMap2.get("remark").toString();
    }
    localHashMap1.put("org_id", paramString);
    localHashMap1.put("org_name", str1);
    localHashMap1.put("org_desc", str2);
    localHashMap1.put("remark", str3);
    return localHashMap1;
  }

  public String getOrgnaizeById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getOrgnaizeByOrg_id(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("org_name") != null)
        str = localHashMap.get("org_name").toString();
    }
    return str;
  }

  public String getCustTrueNameById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_name") != null)
        str = localHashMap.get("cust_name").toString();
    }
    return str;
  }

  public String getCustNameById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_aim") != null)
        str = localHashMap.get("cust_aim").toString();
    }
    return str;
  }

  public String getJsonDataForTree(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    this.log.LOG_INFO("进入getJsonDataForTree方法 cust_id=" + paramString1 + "       up_org_id=" + paramString2);
    localStringBuffer1.append("[");
    String str1 = "";
    String str2 = "";
    String str3 = "";
    ArrayList localArrayList = getOrganizeByUpIdList(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        str2 = localHashMap.get("org_name").toString();
        str3 = localHashMap.get("org_id").toString();
        localStringBuffer1.append("{text:'" + str2 + "',id:'" + str3 + "',iconCls:'" + paramString3 + "',");
        boolean bool = hasNextNode(paramString1, str3);
        if (bool)
        {
          localStringBuffer1.append("leaf:false,children:[");
          StringBuffer localStringBuffer2 = new StringBuffer();
          String str4 = getChildrenJsonData(localStringBuffer2, paramString1, str3, paramString3);
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

  public String getChildrenJsonData(StringBuffer paramStringBuffer, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    ArrayList localArrayList = getOrganizeByUpIdList(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        str2 = localHashMap.get("org_name").toString();
        str3 = localHashMap.get("org_id").toString();
        paramStringBuffer.append("{text:'" + str2 + "',id:'" + str3 + "',iconCls:'" + paramString3 + "',");
        boolean bool = hasNextNode(paramString1, str3);
        if (bool)
        {
          paramStringBuffer.append("leaf:false,children:[");
          StringBuffer localStringBuffer = new StringBuffer();
          String str4 = getChildrenJsonData(localStringBuffer, paramString1, str3, paramString3);
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

  public boolean hasNextNode(String paramString1, String paramString2)
    throws SaasApplicationException
  {
	  boolean i = false;
    ArrayList localArrayList = getOrganizeByUpIdList(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = true;
    return i;
  }

  public String getJSONCheckBoxTreeData(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    String str1 = "";
    ArrayList localArrayList = getOrganizeByUpIdList(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("org_name").toString();
        String str3 = localHashMap.get("org_id").toString();
        CheckTreeObject localCheckTreeObject = new CheckTreeObject();
        localCheckTreeObject.setText(str2);
        localCheckTreeObject.setId(str3);
        localCheckTreeObject.setChecked(false);
        TreeNode localTreeNode = isLeaf(paramString1, 0, str3);
        localCheckTreeObject.setDepth(0);
        localCheckTreeObject.setIconCls(paramString3);
        localCheckTreeObject.setLeaf(localTreeNode.isLeaf());
        localCheckTreeObject.setChildren(localTreeNode.getChildren());
        localJSONArray.add(localCheckTreeObject);
      }
      str1 = localJSONArray.toString();
    }
    return str1;
  }

  public JSONArray getChildrenNodes(String paramString1, String paramString2, int paramInt, ArrayList paramArrayList)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        CheckTreeObject localCheckTreeObject = new CheckTreeObject();
        String str1 = localHashMap.get("org_name").toString();
        String str2 = localHashMap.get("org_id").toString();
        localCheckTreeObject.setId(str2);
        localCheckTreeObject.setText(str1);
        localCheckTreeObject.setDepth(paramInt);
        TreeNode localTreeNode = isLeaf(paramString1, paramInt, str2);
        localCheckTreeObject.setChildren(localTreeNode.getChildren());
        localCheckTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localCheckTreeObject);
      }
    return localJSONArray;
  }

  public TreeNode isLeaf(String paramString1, int paramInt, String paramString2)
    throws SaasApplicationException
  {
    paramInt += 1;
    ArrayList localArrayList = getOrganizeByUpIdList(paramString1, paramString2);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getChildrenNodes(paramString1, paramString2, paramInt, localArrayList);
      localTreeNode.setChildren(localJSONArray);
    }
    return localTreeNode;
  }

  public String getSelectOrg(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    try
    {
      OrganizeExt localOrganizeExt = new OrganizeExt();
      localOrganizeExt.setParam(":VCUST_ID", paramString);
      localArrayList = localOrganizeExt.selByList("SEL_BY_CUST");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        localHashMap = (HashMap)localArrayList.get(i);
        str1 = localHashMap.get("org_id").toString();
        str2 = localHashMap.get("org_name").toString();
        str3 = str3 + "<option value=" + str1 + ">" + str2 + "</option>";
      }
    return str3;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.organizeMgr.OrganizeInfo
 * JD-Core Version:    0.6.0
 */