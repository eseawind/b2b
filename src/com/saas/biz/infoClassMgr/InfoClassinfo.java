package com.saas.biz.infoClassMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.infoclassDAO.InfoClassDAO;
import com.saas.biz.dao.infoclassDAO.InfoClassExt;
import com.saas.biz.dao.productclassDAO.ProductclassExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class InfoClassinfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr commen = new commMethodMgr();
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

  public void addinfoclass(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addinfoclass方法...");
    int i = -1;
    try
    {
      InfoClassDAO localInfoClassDAO = new InfoClassDAO();
      localInfoClassDAO.setRoot_id(paramBuffers.getString("SPEC_ROOT_ID"));
      localInfoClassDAO.setClass_id(paramBuffers.isFieldExist("SPEC_CLASS_ID") ? paramBuffers.getString("SPEC_CLASS_ID") : "");
      localInfoClassDAO.setClass_name(paramBuffers.isFieldExist("SPEC_CLASS_NAME") ? paramBuffers.getString("SPEC_CLASS_NAME") : "");
      localInfoClassDAO.setClass_id_grp(paramBuffers.isFieldExist("SPEC_CLASS_ID_GRP") ? paramBuffers.getString("SPEC_CLASS_ID_GRP") : "");
      localInfoClassDAO.setClass_name_grp(paramBuffers.isFieldExist("SPEC_CLASS_NAME_GRP") ? paramBuffers.getString("SPEC_CLASS_NAME_GRP") : "");
      localInfoClassDAO.setWeb_id(paramBuffers.isFieldExist("WEB_ID") ? paramBuffers.getString("WEB_ID") : "");
      i = addinfoclass(localInfoClassDAO);
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
    this.log.LOG_INFO("退出addinfoclass方法...");
  }

  public int addinfoclass(InfoClassDAO paramInfoClassDAO)
    throws SaasApplicationException
  {
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VROOT_ID", paramInfoClassDAO.getRoot_id());
    localInfoClassExt.setParam(":VCLASS_ID", paramInfoClassDAO.getClass_id());
    localInfoClassExt.setParam(":VCLASS_NAME", paramInfoClassDAO.getClass_name());
    localInfoClassExt.setParam(":VCLASS_ID_GRP", paramInfoClassDAO.getClass_id_grp());
    localInfoClassExt.setParam(":VCLASS_NAME_GRP", paramInfoClassDAO.getClass_name_grp());
    localInfoClassExt.setParam(":VWEB_ID", paramInfoClassDAO.getWeb_id());
    localInfoClassExt.setParam(":VINFO_TYPE", "0");
    localInfoClassExt.setParam(":VRSRV_STR1", "");
    localInfoClassExt.setParam(":VRSRV_STR2", "");
    localInfoClassExt.setParam(":VRSRV_STR3", "");
    localInfoClassExt.setParam(":VRSRV_STR4", "");
    localInfoClassExt.setParam(":VRSRV_STR5", "");
    localInfoClassExt.setParam(":VRSRV_STR6", "");
    localInfoClassExt.setParam(":VREMARK", "");
    this.log.LOG_INFO("info数据初始化赋值完成..........");
    this.tradeQuery.executeBy(localInfoClassExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void addinfoclassByType(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addinfoclassByType方法...");
    int i = -1;
    String str1 = paramBuffers.getString("ROOT_ID");
    String str2 = paramBuffers.getString("CLASS_ID");
    try
    {
      ArrayList localArrayList = getClassInfoListById(str2);
      String str3 = "";
      String str4 = "";
      String str5 = "";
      String str6 = "000000000000000";
      String str7 = "";
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        if (localHashMap.get("class_id") != null)
          str4 = localHashMap.get("class_id").toString();
        if (localHashMap.get("class_name") != null)
          str3 = localHashMap.get("class_name").toString();
        if (localHashMap.get("up_class_id") != null)
          str5 = localHashMap.get("up_class_id").toString();
      }
      HashMap localHashMap = getClassIdAndName(str5, str4, str3);
      if ((localHashMap != null) && (localHashMap.size() > 0))
      {
        if (localHashMap.get("id") != null)
          str6 = localHashMap.get("id").toString();
        if (localHashMap.get("name") != null)
          str7 = localHashMap.get("name").toString();
      }
      InfoClassDAO localInfoClassDAO = new InfoClassDAO();
      localInfoClassDAO.setRoot_id(str1);
      localInfoClassDAO.setClass_id(str2);
      localInfoClassDAO.setClass_name(str3);
      localInfoClassDAO.setClass_id_grp(str6);
      localInfoClassDAO.setClass_name_grp(str7);
      i = addinfoclassByType(localInfoClassDAO);
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
    this.log.LOG_INFO("退出addinfoclassByType方法...");
  }

  public int addinfoclassByType(InfoClassDAO paramInfoClassDAO)
    throws SaasApplicationException
  {
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VROOT_ID", paramInfoClassDAO.getRoot_id());
    localInfoClassExt.setParam(":VCLASS_ID", paramInfoClassDAO.getClass_id());
    localInfoClassExt.setParam(":VCLASS_NAME", paramInfoClassDAO.getClass_name());
    localInfoClassExt.setParam(":VCLASS_ID_GRP", paramInfoClassDAO.getClass_id_grp());
    localInfoClassExt.setParam(":VCLASS_NAME_GRP", paramInfoClassDAO.getClass_name_grp());
    localInfoClassExt.setParam(":VWEB_ID", "00000000000000");
    localInfoClassExt.setParam(":VINFO_TYPE", "0");
    localInfoClassExt.setParam(":VRSRV_STR1", "");
    localInfoClassExt.setParam(":VRSRV_STR2", "");
    localInfoClassExt.setParam(":VRSRV_STR3", "");
    localInfoClassExt.setParam(":VRSRV_STR4", "");
    localInfoClassExt.setParam(":VRSRV_STR5", "");
    localInfoClassExt.setParam(":VRSRV_STR6", "");
    localInfoClassExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localInfoClassExt.insBy("INS_BY_ALL"));
    this.log.LOG_INFO("addinfoclassByType =============================== DDDDDDDDDDDDDDDDDDDDDDDDDD");
    return 0;
  }

  public String getProductNameByIdx(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ProductclassExt localProductclassExt = new ProductclassExt();
    ArrayList localArrayList = new ArrayList();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_BY_CLASSID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("class_name") != null)
        str = localHashMap.get("class_name").toString();
    }
    return str;
  }

  public void delClassInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delClassInfo方法...");
    int i = -1;
    String str = paramBuffers.getString("ROOT_ID");
    try
    {
      i = delClassInfo(str);
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
    this.log.LOG_INFO("退出delClassInfo方法...");
  }

  public int delClassInfo(String paramString)
    throws SaasApplicationException
  {
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VROOT_ID", paramString);
    this.tradeQuery.executeBy(localInfoClassExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public void DeleteclassInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("ROOT_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = delClassInfo(str2);
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
    this.log.LOG_INFO("退出DeleteSaleInfo方法...");
  }

  public HashMap getClassIdAndName(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    HashMap localHashMap2 = getClassInfoById(paramString1);
    String str3 = "";
    String str4 = "";
    if ((localHashMap2 != null) && (localHashMap2.size() > 0))
    {
      if (localHashMap2.get("id") != null)
        str3 = localHashMap2.get("id").toString();
      if (localHashMap2.get("name") != null)
        str4 = localHashMap2.get("name").toString();
    }
    str1 = "000000000000000|" + str3 + "|" + paramString2;
    str2 = "000000000000000|" + str4 + "|" + paramString3;
    localHashMap1.put("id", str1);
    localHashMap1.put("name", str2);
    return localHashMap1;
  }

  public HashMap getClassInfoById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = getClassInfoListById(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      String str3 = "";
      String str4 = "";
      String str5 = "";
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      if (localHashMap2.get("class_id") != null)
        str3 = localHashMap2.get("class_id").toString();
      if (localHashMap2.get("class_name") != null)
        str4 = localHashMap2.get("class_name").toString();
      if (localHashMap2.get("up_class_id") != null)
        str5 = localHashMap2.get("up_class_id").toString();
      str1 = str3 + "|" + str1;
      str2 = str4 + "|" + str2;
      HashMap localHashMap3 = getClassInfoById(str5);
      if ((localHashMap3 != null) && (localHashMap3.size() > 0))
      {
        String str6 = "";
        String str7 = "";
        if (localHashMap3.get("id") != null)
          str6 = localHashMap3.get("id").toString();
        if (localHashMap3.get("name") != null)
          str7 = localHashMap3.get("name").toString();
        str1 = str6 + "|" + str1;
        str2 = str7 + "|" + str2;
      }
    }
    localHashMap1.put("id", str1);
    localHashMap1.put("name", str2);
    return localHashMap1;
  }

  public ArrayList getClassInfoListById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_CLASSUP_BYDOWN");
    return localArrayList;
  }

  public ArrayList getUpClassInfoListById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString);
    localArrayList = localProductclassExt.selByList("SEL_BY_UP");
    return localArrayList;
  }

  public String getProductTypeById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    InfoClassExt localInfoClassExt = new InfoClassExt();
    ArrayList localArrayList = new ArrayList();
    localInfoClassExt.setParam(":VROOT_ID", paramString);
    localArrayList = localInfoClassExt.selByList("SEL_BY_PRODUCT_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("class_name") != null)
        str = localHashMap.get("class_name").toString();
    }
    return str;
  }

  public void updateinfoclass(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateinfoclass方法...");
    int i = -1;
    String str1 = paramBuffers.getString("ROOT_ID");
    String str2 = paramBuffers.getString("CLASS_ID");
    Object localObject1 = paramBuffers.getString("CLASS_NAME");
    Object localObject2 = paramBuffers.getString("CLASS_ID_GRP");
    Object localObject3 = "";
    try
    {
      ArrayList localArrayList = getClassInfoListById(str2);
      String str3 = "";
      String str4 = "";
      String str5 = "";
      String str6 = "000000000000000";
      String str7 = "";
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
       HashMap localHashMap = (HashMap)localArrayList.get(0);
        if (localHashMap.get("class_id") != null)
          str4 = localHashMap.get("class_id").toString();
        if (localHashMap.get("class_name") != null)
          str3 = localHashMap.get("class_name").toString();
        if (localHashMap.get("up_class_id") != null)
          str5 = localHashMap.get("up_class_id").toString();
      }
      localObject1 = str3;
      HashMap localHashMap = getClassIdAndName(str5, str4, str3);
      if ((localHashMap != null) && (localHashMap.size() > 0))
      {
        if (localHashMap.get("id") != null)
        {
          str6 = localHashMap.get("id").toString();
          localObject2 = str6;
        }
        if (localHashMap.get("name") != null)
        {
          str7 = localHashMap.get("name").toString();
          localObject3 = str7;
        }
      }
    }
    catch (SaasApplicationException localSaasApplicationException1)
    {
      this.log.LOG_INFO(localSaasApplicationException1.getMessage());
    }
    try
    {
      i = updateinfoclass(str1, str2, (String)localObject1, (String)localObject2, (String)localObject3);
    }
    catch (SaasApplicationException localSaasApplicationException2)
    {
      this.log.LOG_INFO(localSaasApplicationException2.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败1111111111111！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出updateinfoclass方法...");
  }

  public int updateinfoclass(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    InfoClassExt localInfoClassExt = new InfoClassExt();
    localInfoClassExt.setParam(":VROOT_ID", paramString1);
    localInfoClassExt.setParam(":VCLASS_ID", paramString2);
    localInfoClassExt.setParam(":VCLASS_NAME", paramString3);
    localInfoClassExt.setParam(":VCLASS_ID_GRP", paramString4);
    localInfoClassExt.setParam(":VCLASS_NAME_GRP", paramString5);
    this.tradeQuery.executeBy(localInfoClassExt.insBy("UPDATE_CLASS_NAME"));
    return 0;
  }

  public String getInfoClassByInfoId(String paramString)
    throws SaasApplicationException
  {
    InfoClassExt localInfoClassExt = new InfoClassExt();
    ArrayList localArrayList = new ArrayList();
    localInfoClassExt.setParam(":VROOT_ID", paramString);
    localArrayList = localInfoClassExt.selByList("SEL_BY_PRODUCT_ID");
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("class_id_grp") != null)
        str = localHashMap.get("class_id_grp").toString();
    }
    return str;
  }

  public String getInfoClassIdByClassName(String paramString)
    throws SaasApplicationException
  {
    InfoClassExt localInfoClassExt = new InfoClassExt();
    ArrayList localArrayList = new ArrayList();
    localInfoClassExt.setParam(":VCLASS_NAME", paramString);
    localArrayList = localInfoClassExt.selByList("SEL_BY_CLASS_NAME");
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
 * Qualified Name:     com.saas.biz.infoClassMgr.InfoClassinfo
 * JD-Core Version:    0.6.0
 */