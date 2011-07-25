package com.saas.biz.entClassMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.entClassDAO.EntClassDAO;
import com.saas.biz.dao.entClassDAO.EntClassExt;
import com.saas.biz.entityclassMgr.EntityClassInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class EntClassInfo
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

  public void addEntClassInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEntClassInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CUST_ID");
    String str3 = paramBuffers.getString("ENTITY_TYPE");
    String str4 = paramBuffers.getString("E_CLASS_ID");
    String str5 = paramBuffers.getString("E_CLASS_NAME");
    String str6 = paramBuffers.getString("E_CLASS_ID_GRP");
    String str7 = paramBuffers.getString("E_CLASS_NAME_GRP");
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    EntClassDAO localEntClassDAO = new EntClassDAO();
    try
    {
      localEntClassDAO.setClass_id(str4);
      localEntClassDAO.setClass_id_grp(str6);
      localEntClassDAO.setClass_name(str5);
      localEntClassDAO.setClass_name_grp(str7);
      localEntClassDAO.setCust_id(str1);
      localEntClassDAO.setEntity_type(str3);
      localEntClassDAO.setEntity_id(str2);
      localEntClassDAO.setOper_user_id(str8);
      i = addEntClassInfo(localEntClassDAO);
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
    this.log.LOG_INFO("退出addEntClassInfo方法...");
  }

  public int addEntClassInfo(EntClassDAO paramEntClassDAO)
    throws SaasApplicationException
  {
    EntClassExt localEntClassExt = new EntClassExt();
    localEntClassExt.setParam(":VCLASS_ID", paramEntClassDAO.getClass_id());
    localEntClassExt.setParam(":VCLASS_ID_GRP", paramEntClassDAO.getClass_id_grp());
    localEntClassExt.setParam(":VCLASS_NAME", paramEntClassDAO.getClass_name());
    localEntClassExt.setParam(":VCLASS_NAME_GRP", paramEntClassDAO.getClass_name_grp());
    localEntClassExt.setParam(":VCUST_ID", paramEntClassDAO.getCust_id());
    localEntClassExt.setParam(":VENTITY_TYPE", paramEntClassDAO.getEntity_type());
    localEntClassExt.setParam(":VENTITY_ID", paramEntClassDAO.getEntity_id());
    localEntClassExt.setParam(":VOPER_USER_ID", paramEntClassDAO.getOper_user_id());
    this.tradeQuery.executeBy(localEntClassExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void addEntClassRank(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEntClassRank方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CUST_ID");
    String str3 = paramBuffers.getString("ENTITY_TYPE");
    String str4 = paramBuffers.getString("RELA_CLASS");
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    EntClassDAO localEntClassDAO = new EntClassDAO();
    try
    {
      Map localMap = getGroupClassById(str1, str4, str3);
      if ((localMap != null) && (localMap.size() > 0))
      {
        Map.Entry localEntry = (Map.Entry)localMap.entrySet().iterator().next();
        str6 = String.valueOf(localEntry.getKey());
        str7 = String.valueOf(localEntry.getValue());
      }
      localEntClassDAO.setClass_id(str4);
      localEntClassDAO.setClass_id_grp(str6);
      localEntClassDAO.setClass_name(str5);
      localEntClassDAO.setClass_name_grp(str7);
      localEntClassDAO.setCust_id(str1);
      localEntClassDAO.setEntity_type(str3);
      localEntClassDAO.setEntity_id(str2);
      localEntClassDAO.setOper_user_id(str8);
      i = addEntClassRank(localEntClassDAO);
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
    this.log.LOG_INFO("退出addEntClassRank方法...");
  }

  public int addEntClassRank(EntClassDAO paramEntClassDAO)
    throws SaasApplicationException
  {
    EntClassExt localEntClassExt = new EntClassExt();
    localEntClassExt.setParam(":VCLASS_ID", paramEntClassDAO.getClass_id());
    localEntClassExt.setParam(":VCLASS_ID_GRP", paramEntClassDAO.getClass_id_grp());
    localEntClassExt.setParam(":VCLASS_NAME", paramEntClassDAO.getClass_name());
    localEntClassExt.setParam(":VCLASS_NAME_GRP", paramEntClassDAO.getClass_name_grp());
    localEntClassExt.setParam(":VCUST_ID", paramEntClassDAO.getCust_id());
    localEntClassExt.setParam(":VENTITY_TYPE", paramEntClassDAO.getEntity_type());
    localEntClassExt.setParam(":VENTITY_ID", paramEntClassDAO.getEntity_id());
    localEntClassExt.setParam(":VOPER_USER_ID", paramEntClassDAO.getOper_user_id());
    this.tradeQuery.executeBy(localEntClassExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void addEntClassRankOpp(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEntClassRankOpp方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("USER_ID");
    String str3 = "2";
    String str4 = paramBuffers.getString("RELA_CLASS");
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    EntClassDAO localEntClassDAO = new EntClassDAO();
    try
    {
      Map localMap = getGroupClassById(str1, str4, str3);
      if ((localMap != null) && (localMap.size() > 0))
      {
        Map.Entry localEntry = (Map.Entry)localMap.entrySet().iterator().next();
        str6 = String.valueOf(localEntry.getKey());
        str7 = String.valueOf(localEntry.getValue());
      }
      localEntClassDAO.setClass_id(str4);
      localEntClassDAO.setClass_id_grp(str6);
      localEntClassDAO.setClass_name(str5);
      localEntClassDAO.setClass_name_grp(str7);
      localEntClassDAO.setCust_id(str1);
      localEntClassDAO.setEntity_type(str3);
      localEntClassDAO.setEntity_id(str2);
      localEntClassDAO.setOper_user_id(str8);
      i = addEntClassRankOpp(localEntClassDAO);
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
    this.log.LOG_INFO("退出addEntClassRankOpp方法...");
  }

  public void addEntClassInfoByClass(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEntClassInfoByClass方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    String str3 = paramBuffers.getString("GROUP_TYPE");
    String str4 = paramBuffers.getString("CLASS_ID");
    String str5 = paramBuffers.getString("USER_ID");
    String str6 = paramBuffers.getString("CLASS_NAME");
    String str7 = "";
    String str8 = "";
    EntClassDAO localEntClassDAO = new EntClassDAO();
    try
    {
      Map localMap = getGroupClassById(str1, str4, str3);
      if ((localMap != null) && (localMap.size() > 0))
      {
        Map.Entry localEntry = (Map.Entry)localMap.entrySet().iterator().next();
        str7 = String.valueOf(localEntry.getKey());
        str8 = String.valueOf(localEntry.getValue());
      }
      localEntClassDAO.setClass_id(str4);
      localEntClassDAO.setClass_id_grp(str7);
      localEntClassDAO.setClass_name(str6);
      localEntClassDAO.setClass_name_grp(str8);
      localEntClassDAO.setCust_id(str1);
      localEntClassDAO.setEntity_type(str3);
      localEntClassDAO.setEntity_id(str5);
      localEntClassDAO.setOper_user_id(str2);
      i = addEntClassRankOpp(localEntClassDAO);
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
    this.log.LOG_INFO("退出addEntClassRankOpp方法...");
  }

  public int addEntClassRankOpp(EntClassDAO paramEntClassDAO)
    throws SaasApplicationException
  {
    String str1 = paramEntClassDAO.getEntity_id();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      EntClassExt localEntClassExt = new EntClassExt();
      localEntClassExt.setParam(":VCLASS_ID", paramEntClassDAO.getClass_id());
      localEntClassExt.setParam(":VCLASS_ID_GRP", paramEntClassDAO.getClass_id_grp());
      localEntClassExt.setParam(":VCLASS_NAME", paramEntClassDAO.getClass_name());
      localEntClassExt.setParam(":VCLASS_NAME_GRP", paramEntClassDAO.getClass_name_grp());
      localEntClassExt.setParam(":VCUST_ID", paramEntClassDAO.getCust_id());
      localEntClassExt.setParam(":VENTITY_TYPE", paramEntClassDAO.getEntity_type());
      localEntClassExt.setParam(":VENTITY_ID", str2);
      localEntClassExt.setParam(":VOPER_USER_ID", paramEntClassDAO.getOper_user_id());
      this.tradeQuery.executeBy(localEntClassExt.insBy("UPDATE_BY_ALL"));
    }
    return 0;
  }

  public void updateEntClassRankOpp(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateEntClassRankOpp方法...");
    System.out.println("----------------------------------------------------");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("USER_ID");
    String str3 = "2";
    String str4 = paramBuffers.getString("RELA_CLASS");
    this.log.LOG_INFO("cust_id==================" + str1 + "entity_id============" + str2 + "class_id============" + str4);
    EntClassDAO localEntClassDAO = new EntClassDAO();
    try
    {
      localEntClassDAO.setClass_id(str4);
      localEntClassDAO.setCust_id(str1);
      localEntClassDAO.setEntity_type(str3);
      localEntClassDAO.setEntity_id(str2);
      i = updateEntClassRankOpp(localEntClassDAO);
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
    this.log.LOG_INFO("退出updateEntClassRankOpp方法...");
  }

  public int updateEntClassRankOpp(EntClassDAO paramEntClassDAO)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramEntClassDAO.getEntity_id();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      this.log.LOG_INFO("------------------------" + str2);
      localArrayList = getClassGrp(str2);
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      String str3 = "";
      String str4 = "";
      String str5 = "";
      String str6 = "";
      if (localHashMap.get("class_id") != null)
        str3 = localHashMap.get("class_id").toString();
      if (localHashMap.get("class_id_grp") != null)
        str4 = localHashMap.get("class_id_grp").toString();
      if (localHashMap.get("class_name") != null)
        str5 = localHashMap.get("class_name").toString();
      if (localHashMap.get("class_name_grp") != null)
        str6 = localHashMap.get("class_name_grp").toString();
      this.log.LOG_INFO("class_id============" + str3 + "=========class_id_grp===============" + str4 + "=========class_name===============" + str5 + "=========class_name_grp==========" + str6);
      EntClassExt localEntClassExt = new EntClassExt();
      localEntClassExt.setParam(":VCLASS_NAME_GRP", str6);
      localEntClassExt.setParam(":VCLASS_NAME", str5);
      localEntClassExt.setParam(":VCLASS_ID_GRP", str4);
      localEntClassExt.setParam(":VCLASS_ID", paramEntClassDAO.getClass_id());
      localEntClassExt.setParam(":VCUST_ID", paramEntClassDAO.getCust_id());
      localEntClassExt.setParam(":VENTITY_TYPE", paramEntClassDAO.getEntity_type());
      localEntClassExt.setParam(":VENTITY_ID", str2);
      this.log.LOG_INFO("====" + localEntClassExt.insBy("UPDATE_BY_OPP_RANK"));
      this.tradeQuery.executeBy(localEntClassExt.insBy("UPDATE_BY_OPP_RANK"));
    }
    return 0;
  }

  public void delEntClassInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delEntClassInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("ENTITY_ID");
    EntClassDAO localEntClassDAO = new EntClassDAO();
    try
    {
      localEntClassDAO.setCust_id(str1);
      localEntClassDAO.setEntity_id(str2);
      i = delEntClassInfo(localEntClassDAO);
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
    this.log.LOG_INFO("退出delEntClassInfo方法...");
  }

  public int delEntClassInfo(EntClassDAO paramEntClassDAO)
    throws SaasApplicationException
  {
    EntClassExt localEntClassExt = new EntClassExt();
    localEntClassExt.setParam(":VCUST_ID", paramEntClassDAO.getCust_id());
    localEntClassExt.setParam(":VENTITY_ID", paramEntClassDAO.getEntity_id());
    this.tradeQuery.executeBy(localEntClassExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public void delOppByRank(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delOppByRank方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CLASS_ID");
    String str3 = paramBuffers.getString("USER_ID");
    EntClassDAO localEntClassDAO = new EntClassDAO();
    try
    {
      this.log.LOG_INFO("--------" + str1 + "==============" + str2 + "````````````````[" + str3 + "]");
      localEntClassDAO.setCust_id(str1);
      localEntClassDAO.setClass_id(str2);
      localEntClassDAO.setEntity_id(str3);
      i = delOppByRank(localEntClassDAO);
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
    this.log.LOG_INFO("退出delOppByRank方法...");
  }

  public int delOppByRank(EntClassDAO paramEntClassDAO)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramEntClassDAO.getEntity_id();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      EntClassExt localEntClassExt = new EntClassExt();
      localEntClassExt.setParam(":VCUST_ID", paramEntClassDAO.getCust_id());
      localEntClassExt.setParam(":VCLASS_ID", paramEntClassDAO.getClass_id());
      localEntClassExt.setParam(":VENTITY_ID", str2);
      this.log.LOG_INFO("sql..." + str2);
      this.tradeQuery.executeBy(localEntClassExt.insBy("DEL_OPP_BY_RANK"));
    }
    return 0;
  }

  public List getEntClassInfoList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      EntClassExt localEntClassExt = new EntClassExt();
      localEntClassExt.setParam(":VCUST_ID", paramString);
      localArrayList = localEntClassExt.selByList("SEL_BY_CUST");
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return localArrayList;
  }

  public Map getEntClassInfoById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    try
    {
      EntClassExt localEntClassExt = new EntClassExt();
      localEntClassExt.setParam(":VENTITY_ID", paramString);
      ArrayList localArrayList = localEntClassExt.selByList("SEL_BY_ID");
      if ((localArrayList != null) && (localArrayList.size() > 0))
        localHashMap = (HashMap)localArrayList.get(0);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return localHashMap;
  }

  public ArrayList getClassGrp(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    EntClassExt localEntClassExt = new EntClassExt();
    localEntClassExt.setParam(":VENTITY_ID", paramString);
    localArrayList = localEntClassExt.selByList("SEL_BY_CLASSGRP");
    return localArrayList;
  }

  public Map getGroupClassById(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    Object localObject = new HashMap();
    localObject = new EntityClassInfo().getUpClassIdAndName(paramString2, paramString1, paramString3);
    return (Map)localObject;
  }

  public void deleteEntityClass(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteEntityClass方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_CUST_ID");
      String str2 = paramBuffers.getString("GROUP_TYPE");
      String str3 = paramBuffers.getString("CLASS_ID");
      String str4 = paramBuffers.getString("USER_ID");
      i = deleteEntityClass(str1, str2, str3, str4);
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
    this.log.LOG_INFO("退出deleteEntityClass方法...");
  }

  public int deleteEntityClass(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString4, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str1 = localStringTokenizer.nextToken();
      EntClassExt localEntClassExt = new EntClassExt();
      Map localMap = getUpClassIdWithName(paramString1, str1, paramString2);
      if ((localMap != null) && (localMap.size() > 0))
      {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (localMap.get("id") != null)
          str2 = localMap.get("id").toString();
        if (localMap.get("class_id_grp") != null)
          str3 = localMap.get("class_id_grp").toString();
        if (localMap.get("class_name_grp") != null)
          str4 = localMap.get("class_name_grp").toString();
        if (localMap.get("class_name") != null)
          str5 = localMap.get("class_name").toString();
        if (localMap.get("class_id") != null)
          str6 = localMap.get("class_id").toString();
        if ((paramString3 == str2) || (paramString3.equals(str2)))
        {
          localEntClassExt.setParam(":VCLASS_ID", str6);
          localEntClassExt.setParam(":VCUST_ID", paramString1);
          localEntClassExt.setParam(":VCLASS_ID_GRP", str3);
          localEntClassExt.setParam(":VCLASS_NAME_GRP", str4);
          localEntClassExt.setParam(":VCLASS_NAME", str5);
          localEntClassExt.setParam(":VENTITY_ID", str1);
          localEntClassExt.setParam(":VENTITY_TYPE", paramString2);
          this.tradeQuery.executeBy(localEntClassExt.insBy("UPDATE_BY_CLASS"));
        }
      }
    }
    return 0;
  }

  public Map getUpClassIdWithName(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("==删除分类特殊处理开始..........");
    HashMap localHashMap = new HashMap();
    Map localMap1 = getEntClassInfoById(paramString2);
    String str1 = "";
    if (localMap1.get("class_id") != null)
      str1 = localMap1.get("class_id").toString();
    Map localMap2 = new EntityClassInfo().getUpClassIdAndName(str1, paramString1, paramString3);
    if ((localMap2 != null) && (localMap2.size() > 0))
    {
      Map.Entry localEntry = (Map.Entry)localMap2.entrySet().iterator().next();
      String str2 = String.valueOf(localEntry.getKey());
      String str3 = String.valueOf(localEntry.getValue());
      String str4 = "";
      String str5 = "";
      int i = str2.lastIndexOf("|");
      if (i > -1)
        str2 = str2.substring(0, i);
      i = str2.lastIndexOf("|");
      if (i > -1)
        str4 = str2.substring(i + 1, str2.length());
      else
        str4 = str2;
      i = str3.lastIndexOf("|");
      if (i > -1)
        str3 = str3.substring(0, i);
      i = str3.lastIndexOf("|");
      if (i > -1)
        str5 = str3.substring(str3.lastIndexOf("|") + 1, str3.length());
      else
        str5 = str3;
      localHashMap.put("class_id_grp", str2);
      localHashMap.put("class_name_grp", str3);
      localHashMap.put("class_id", str4);
      localHashMap.put("id", str1);
      localHashMap.put("class_name", str5);
    }
    this.log.LOG_INFO("==删除分类特殊处理完成...........");
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.entClassMgr.EntClassInfo
 * JD-Core Version:    0.6.0
 */