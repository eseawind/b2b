package com.saas.biz.groupInfoMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.custMgr.Custinfo;
import com.saas.biz.dao.custDAO.CustomerExt;
import com.saas.biz.dao.groupDAO.GroupInfoDAO;
import com.saas.biz.dao.groupDAO.GroupInfoExt;
import com.saas.biz.entityclassMgr.EntityClassInfo;
import com.saas.biz.relationUuMgr.RelationUUInfo;
import com.saas.biz.relationccMgr.RelationCcInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class GroupInfo
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

  public void addGroupInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addGroupInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    String str3 = paramBuffers.getString("GROUP_TYPE");
    String str4 = paramBuffers.getString("CLASS_ID");
    String str5 = paramBuffers.getString("CLASS_NAME");
    String str6 = paramBuffers.getString("USER_ID");
    String str7 = paramBuffers.getString("SESSION_USER_ID");
    String str8 = paramBuffers.getString("ENTITY_TYPE");
    try
    {
      GroupInfoDAO localGroupInfoDAO = new GroupInfoDAO();
      localGroupInfoDAO.setClass_id(str4);
      localGroupInfoDAO.setClass_name(str5);
      localGroupInfoDAO.setCust_id(str1);
      localGroupInfoDAO.setOper_user_id(str7);
      localGroupInfoDAO.setOwn_id(str2);
      localGroupInfoDAO.setGroup_type(str3);
      i = addGroupInfo(localGroupInfoDAO, str6, str8);
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
    this.log.LOG_INFO("退出addGroupInfo方法...");
  }

  public int addGroupInfo(GroupInfoDAO paramGroupInfoDAO, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, "|");
    String str1 = "";
    String str2 = "";
    Map localMap = new EntityClassInfo().getUpClassIdAndName(paramGroupInfoDAO.getClass_id(), paramGroupInfoDAO.getCust_id(), paramString2);
    Object localObject;
    if ((localMap != null) && (localMap.size() > 0))
    {
      localObject = (Map.Entry)localMap.entrySet().iterator().next();
      str1 = String.valueOf(((Map.Entry)localObject).getKey());
      str2 = String.valueOf(((Map.Entry)localObject).getValue());
    }
    while (localStringTokenizer.hasMoreElements())
    {
      localObject = String.valueOf(localStringTokenizer.nextElement());
      if (!checkConcateExist(paramGroupInfoDAO.getClass_id(), paramGroupInfoDAO.getCust_id(), (String)localObject, paramGroupInfoDAO.getOwn_id(), paramGroupInfoDAO.getGroup_type()))
      {
        GroupInfoExt localGroupInfoExt = new GroupInfoExt();
        localGroupInfoExt.setParam(":VCUST_ID", paramGroupInfoDAO.getCust_id());
        localGroupInfoExt.setParam(":VOWN_ID", paramGroupInfoDAO.getOwn_id());
        localGroupInfoExt.setParam(":VGROUP_TYPE", paramGroupInfoDAO.getGroup_type());
        localGroupInfoExt.setParam(":VCLASS_ID", paramGroupInfoDAO.getClass_id());
        localGroupInfoExt.setParam(":VCLASS_NAME", paramGroupInfoDAO.getClass_name());
        localGroupInfoExt.setParam(":VCLASS_ID_GRP", str1);
        localGroupInfoExt.setParam(":VCLASS_NAME_GRP", str2);
        localGroupInfoExt.setParam(":VUSER_ID", localObject);
        localGroupInfoExt.setParam(":VOPER_USER_ID", paramGroupInfoDAO.getOper_user_id());
        this.tradeQuery.executeBy(localGroupInfoExt.insBy("INS_BY_ALL"));
      }
    }
    return 0;
  }

  public boolean checkConcateExist(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    boolean bool = false;
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCLASS_ID", paramString1);
    localGroupInfoExt.setParam(":VCUST_ID", paramString2);
    localGroupInfoExt.setParam(":VUSER_ID", paramString3);
    localGroupInfoExt.setParam(":VOWN_ID", paramString4);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString5);
    ArrayList localArrayList = localGroupInfoExt.selByList("SEL_BY_CHECKS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      bool = true;
    this.log.LOG_INFO("检测重复记录开始..." + bool);
    return bool;
  }

  public Map<String, String> getGroupUserByClass(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCLASS_ID", paramString3);
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VOWN_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString4);
    ArrayList localArrayList = localGroupInfoExt.selByList("SEL_USER_BY_CLASS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = localHashMap2.get("user_id").toString();
        String str2 = localHashMap2.get("user_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public Map<String, String> getGroupCustByClass(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCLASS_ID", paramString3);
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VOWN_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString4);
    ArrayList localArrayList = localGroupInfoExt.selByList("SEL_CUST_BY_CLASS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = localHashMap2.get("user_id").toString();
        String str2 = localHashMap2.get("cust_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public Map<String, String> getGroupMemByList(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    Custinfo localCustinfo = new Custinfo();
    localGroupInfoExt.setParam(":VCLASS_ID", paramString3);
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VOWN_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString4);
    ArrayList localArrayList1 = localGroupInfoExt.selByList("SEL_CUST_BY_CLASS");
    ArrayList localArrayList2 = new RelationCcInfo().getRelationByCustId(paramString1);
    ArrayList localArrayList3 = new ArrayList();
    int i;
    HashMap localHashMap2;
    String str1;
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (i = 0; i < localArrayList1.size(); i++)
      {
        localHashMap2 = (HashMap)localArrayList1.get(i);
        str1 = localHashMap2.get("user_id").toString();
        localArrayList3.add(str1);
      }
    String str2;
    if ((localArrayList3 != null) && (localArrayList3.size() > 0))
    {
      if ((localArrayList2 != null) && (localArrayList2.size() > 0))
        for (i = 0; i < localArrayList2.size(); i++)
        {
          localHashMap2 = (HashMap)localArrayList2.get(i);
          str1 = localHashMap2.get("obj_cust_id").toString();
          str2 = localCustinfo.getCustNameById(localHashMap2.get("obj_cust_id").toString());
          if (localArrayList3.contains(str1))
            continue;
          localHashMap1.put(str1, str2);
        }
    }
    else
      for (i = 0; i < localArrayList2.size(); i++)
      {
        localHashMap2 = (HashMap)localArrayList2.get(i);
        str1 = localHashMap2.get("obj_cust_id").toString();
        str2 = localCustinfo.getCustNameById(localHashMap2.get("obj_cust_id").toString());
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public List customerByCustId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new RelationCcInfo().getRelationByCustId(paramString);
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList2.get(i);
        String str = localHashMap.get("obj_cust_id").toString();
        localArrayList1.add(str);
      }
    return localArrayList1;
  }

  public Map<String, String> getContactMemByList(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    Custinfo localCustinfo = new Custinfo();
    localGroupInfoExt.setParam(":VCLASS_ID", paramString3);
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VOWN_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString4);
    ArrayList localArrayList1 = localGroupInfoExt.selByList("SEL_USER_BY_CLASS");
    ArrayList localArrayList2 = new RelationUUInfo().getContactList(paramString2, "1");
    ArrayList localArrayList3 = new ArrayList();
    int i;
    HashMap localHashMap2;
    String str1;
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (i = 0; i < localArrayList1.size(); i++)
      {
        localHashMap2 = (HashMap)localArrayList1.get(i);
        str1 = localHashMap2.get("user_id").toString();
        localArrayList3.add(str1);
      }
    String str2;
    if ((localArrayList3 != null) && (localArrayList3.size() > 0))
    {
      if ((localArrayList2 != null) && (localArrayList2.size() > 0))
        for (i = 0; i < localArrayList2.size(); i++)
        {
          localHashMap2 = (HashMap)localArrayList2.get(i);
          str1 = localHashMap2.get("user_id").toString();
          str2 = localCustinfo.getCustNameById(localHashMap2.get("cust_id").toString());
          if (localArrayList3.contains(str1))
            continue;
          localHashMap1.put(str1, str2);
        }
    }
    else if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (i = 0; i < localArrayList2.size(); i++)
      {
        localHashMap2 = (HashMap)localArrayList2.get(i);
        str1 = localHashMap2.get("user_id").toString();
        str2 = localCustinfo.getCustNameById(localHashMap2.get("cust_id").toString());
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public String getJsonDataByType(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = "";
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VCLASS_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString3);
    localArrayList = localGroupInfoExt.selByList("SEL_BY_JSON");
    this.log.LOG_INFO("===" + localArrayList);
    localStringBuffer.append("{'data':[");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (localHashMap.get("cust_id") != null)
          str2 = localHashMap.get("cust_id").toString();
        if (localHashMap.get("cust_name") != null)
          str3 = localHashMap.get("cust_name").toString();
        if (localHashMap.get("group_contact_phone") != null)
          str4 = localHashMap.get("group_contact_phone").toString();
        localStringBuffer.append("{'id':'" + str2 + "','name':'" + str3 + "','tel':'" + str4 + "'},");
      }
    localStringBuffer.append("{}]}");
    str1 = localStringBuffer.toString();
    this.log.LOG_INFO(str1);
    return str1;
  }

  public ArrayList getGroupString(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VCLASS_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString3);
    localArrayList = localGroupInfoExt.selByList("SEL_BY_JOIN");
    return localArrayList;
  }

  public ArrayList getGroupForJoin(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VCLASS_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString3);
    localArrayList = localGroupInfoExt.selByList("SEL_BY_NO_JOIN");
    return localArrayList;
  }

  public ArrayList getGroupCusString(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    int i = Integer.parseInt(paramString1);
    try
    {
      if (i == 0)
        i = 0;
      else
        i = (i - 1) * 20;
    }
    catch (Exception localException)
    {
    }
    ArrayList localArrayList = new ArrayList();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCUST_ID", paramString2);
    localGroupInfoExt.setParam(":VCLASS_ID", paramString3);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString4);
    localArrayList = localGroupInfoExt.selByList("SEL_BY_JOIN", i, 20);
    return localArrayList;
  }

  public int getGroupCusString(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VCLASS_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString3);
    localArrayList = localGroupInfoExt.selByList("SEL_BY_JOIN");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getPageByType(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    int i = Integer.parseInt(paramString4);
    try
    {
      if (i == 0)
        i = 0;
      else
        i = (i - 1) * 20;
    }
    catch (Exception localException)
    {
    }
    ArrayList localArrayList = new ArrayList();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VCLASS_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString3);
    localArrayList = localGroupInfoExt.selByList("SEL_BY_JOIN", i, 20);
    return localArrayList;
  }

  public int getPageGroupString(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VCLASS_ID", paramString2);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString3);
    localArrayList = localGroupInfoExt.selByList("SEL_BY_JSON_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
      return i;
    }
    return i;
  }

  public ArrayList getGroupByContact(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VUSER_ID", paramString2);
    localGroupInfoExt.setParam(":VCLASS_ID", paramString3);
    localGroupInfoExt.setParam(":VRELATION_TYPE_CODE", paramString5);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString4);
    localArrayList = localGroupInfoExt.selByList("SEL_BY_CONTACT");
    return localArrayList;
  }

  public ArrayList getContactForJoin(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    GroupInfoExt localGroupInfoExt = new GroupInfoExt();
    localGroupInfoExt.setParam(":VCUST_ID", paramString1);
    localGroupInfoExt.setParam(":VUSER_ID", paramString2);
    localGroupInfoExt.setParam(":VCLASS_ID", paramString3);
    localGroupInfoExt.setParam(":VRELATION_TYPE_CODE", paramString5);
    localGroupInfoExt.setParam(":VGROUP_TYPE", paramString4);
    ArrayList localArrayList2 = localGroupInfoExt.selByList("SEL_BY_JOIN_CNT");
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)localArrayList2.get(i);
        String str = "";
        if (localHashMap1.get("cust_id") == null)
          continue;
        str = localHashMap1.get("cust_id").toString();
        HashMap localHashMap2 = getCustomerInfo(str);
        if ((localHashMap2 == null) || (localHashMap2.isEmpty()))
          continue;
        localArrayList1.add(localHashMap2);
      }
    return localArrayList1;
  }

  public HashMap getCustomerInfo(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localCustomerExt.selByList("SEL_BY_GROUP_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public void deleteGroupByClass(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteGroupByClass方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_CUST_ID");
      String str2 = paramBuffers.getString("SESSION_USER_ID");
      String str3 = paramBuffers.getString("GROUP_TYPE");
      String str4 = paramBuffers.getString("CLASS_ID");
      String str5 = paramBuffers.getString("USER_ID");
      i = deleteGroupByClass(str1, str2, str3, str4, str5);
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
    this.log.LOG_INFO("退出deleteGroupByClass方法...");
  }

  public int deleteGroupByClass(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString5, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken();
      GroupInfoExt localGroupInfoExt = new GroupInfoExt();
      localGroupInfoExt.setParam(":VCLASS_ID", paramString4);
      localGroupInfoExt.setParam(":VCUST_ID", paramString1);
      localGroupInfoExt.setParam(":VOWN_ID", paramString2);
      localGroupInfoExt.setParam(":VUSER_ID", str);
      localGroupInfoExt.setParam(":VGROUP_TYPE", paramString3);
      this.tradeQuery.executeBy(localGroupInfoExt.insBy("DEL_BY_ALL"));
    }
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.groupInfoMgr.GroupInfo
 * JD-Core Version:    0.6.0
 */