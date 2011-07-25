package com.saas.biz.custMgr;

import com.saas.biz.AreaInfoMgr.AreaInfo;
import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.commen.MD5;
import com.saas.biz.commen.ParamethodMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.commen.config;
//import com.saas.biz.dao.JobDAO.JobExt;
import com.saas.biz.dao.custDAO.CustLevelDAO;
import com.saas.biz.dao.custDAO.CustLevelExt;
import com.saas.biz.dao.custDAO.CustomerDAO;
import com.saas.biz.dao.custDAO.CustomerExt;
import com.saas.biz.dao.newsDAO.NewsExt;
import com.saas.biz.dao.parallDAO.BidExt;
import com.saas.biz.dao.parallDAO.ProduceExt;
import com.saas.biz.dao.parallDAO.SaleInfoExt;
import com.saas.biz.dao.parallDAO.StockOrderExt;
import com.saas.biz.dao.prcreditDAO.ParacreditExt;
//import com.saas.biz.dao.repositoryDAO.RepositoryExt;
import com.saas.biz.dao.userDAO.UserExt;
import com.saas.biz.userMgr.UserInfo;
import com.saas.biz.verifyMgr.VerifyInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Custinfo
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

  public String getAreaNameByCustId(String paramString)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    AreaInfo localAreaInfo = new AreaInfo();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST");
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("province") != null)
        str1 = localHashMap.get("province").toString();
      str2 = localAreaInfo.getAreaName(str1);
    }
    return str2;
  }

  public void resetCustNameby(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addcustinfo方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CUST_ID");
      String str2 = paramBuffers.getString("CUST_NAME");
      String str3 = paramBuffers.getString("CUST_AIM");
      String str4 = paramBuffers.getString("EPARCHY_CODE");
      String str5 = paramBuffers.getString("CITY_CODE");
      String str6 = paramBuffers.getString("PROVINCE");
      i = resetCustNameby(str1, str2, str3, str4, str5, str6);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "reset客户name业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "reset客户name业务处理成功！");
    }
    this.log.LOG_INFO("退出addcustinfo方法...");
  }

  public int resetCustNameby(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    if ((null == paramString3) || (paramString3.equals("")))
    {
      localCustomerExt.setParam(":VCUST_NAME", paramString2);
      localCustomerExt.setParam(":VCUST_ID", paramString1);
      localCustomerExt.setParam(":VEPARCHY_CODE", paramString4);
      localCustomerExt.setParam(":VCITY_CODE", paramString5);
      localCustomerExt.setParam(":VPROVINCE", paramString6);
      this.tradeQuery.executeBy(localCustomerExt.insBy("RESET_CUST_NAME"));
      return 0;
    }
    localCustomerExt.setParam(":VCUST_NAME", paramString2);
    localCustomerExt.setParam(":VCUST_AIM", paramString3);
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VEPARCHY_CODE", paramString4);
    localCustomerExt.setParam(":VCITY_CODE", paramString5);
    localCustomerExt.setParam(":VPROVINCE", paramString6);
    this.tradeQuery.executeBy(localCustomerExt.insBy("RESET_CUST_NAME_AIM"));
    return 0;
  }

  public boolean checkcustName(String paramString)
  {
	  boolean i = false;
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", paramString);
    ArrayList localArrayList = localCustomerExt.selByList("CHECK_CUSTOMER_BY_NAME");
    if (localArrayList.size() >= 1)
    {
      i = true;
      return i;
    }
    return i;
  }

  public String getCustNameByUserId(String paramString)
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_USERID_FOR_CUST_NAME");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_name") != null)
        str = localHashMap.get("cust_name").toString();
    }
    return str;
  }

  public void addCustinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addcustinfo方法...");
    int i = -1;
    try
    {
      CustomerDAO localCustomerDAO = new CustomerDAO();
      localCustomerDAO.setAll_emp_count(paramBuffers.getString("ALL_EMP_COUNT"));
      localCustomerDAO.setCalling_area_code(paramBuffers.getString("CALLING_AREA_CODE"));
      localCustomerDAO.setChina_emp_count(paramBuffers.getString("CHINA_EMP_COUNT"));
      localCustomerDAO.setCity(paramBuffers.getString("CITY"));
      localCustomerDAO.setClass_id(paramBuffers.getString("CLASS_ID"));
      localCustomerDAO.setClient_status(paramBuffers.getString("CLIENT_STATUS"));
      localCustomerDAO.setCompany_address(paramBuffers.getString("COMPANY_ADDRESS"));
      localCustomerDAO.setCust_name(paramBuffers.getString("CUST_NAME"));
      localCustomerDAO.setDevelope_channel(paramBuffers.getString("DEVELOPE_CHANNEL"));
      localCustomerDAO.setDevelope_man(paramBuffers.getString("DEVELOPE_MAN"));
      localCustomerDAO.setEmail(paramBuffers.getString("EMAIL"));
      localCustomerDAO.setEnterprise_scope(paramBuffers.getString("ENTERPRISE_SCOPE"));
      localCustomerDAO.setEnterprise_type_code(paramBuffers.getString("ENTERPRISE_TYPE_CODE"));
      localCustomerDAO.setFax_nbr(paramBuffers.getString("FAX_NBR"));
      localCustomerDAO.setGroup_attr(paramBuffers.getString("GROUP_ATTR"));
      localCustomerDAO.setGroup_contact_phone(paramBuffers.getString("GROUP_CONTACT_PHONE"));
      localCustomerDAO.setJuristic(paramBuffers.getString("JURISTIC"));
      localCustomerDAO.setJuristic_type_code(paramBuffers.getString("JURISTIC_TYPE_CODE"));
      localCustomerDAO.setLocal_emp_count(paramBuffers.getString("LOCAL_EMP_COUNT"));
      localCustomerDAO.setPost_code(paramBuffers.getString("POST_CODE"));
      localCustomerDAO.setPspt_addr(paramBuffers.getString("PSPT_ADDR"));
      localCustomerDAO.setPspt_id(paramBuffers.getString("PSPT_ID"));
      localCustomerDAO.setPspt_type_code(paramBuffers.getString("PSPT_TYPE_CODE"));
      localCustomerDAO.setUser_count(paramBuffers.getString("USER_COUNT"));
      localCustomerDAO.setWebsite(paramBuffers.getString("WEBSITE"));
      localCustomerDAO.setEnterprise_size_code(paramBuffers.getString("ENTERPRISE_SIZE_CODE"));
      localCustomerDAO.setProvince(paramBuffers.getString("PROVINCE"));
      localCustomerDAO.setCust_aim(paramBuffers.getString("CUST_AIM"));
      localCustomerDAO.setGroup_memo(paramBuffers.getString("GROUP_MEMO"));
      localCustomerDAO.setScope(paramBuffers.getString("SCOPE"));
      localCustomerDAO.setReg_money(paramBuffers.getString("REG_MONEY"));
      localCustomerDAO.setCust_id(paramBuffers.getString("CUST_ID"));
      i = addCustinfo(localCustomerDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增客户业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增客户业务处理成功！");
    }
    this.log.LOG_INFO("退出addcustinfo方法...");
  }

  public int addCustinfo(CustomerDAO paramCustomerDAO)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str1 = localcommMethodMgr.GenTradeId();
    String str2 = localcommMethodMgr.GenTradeId();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VALL_EMP_COUNT", paramCustomerDAO.getAll_emp_count());
    localCustomerExt.setParam(":VCALLING_AREA_CODE", paramCustomerDAO.getCalling_area_code());
    localCustomerExt.setParam(":VCALLING_TYPE_CODE", "");
    localCustomerExt.setParam(":VCHINA_EMP_COUNT", paramCustomerDAO.getChina_emp_count());
    localCustomerExt.setParam(":VCITY", paramCustomerDAO.getCity());
    localCustomerExt.setParam(":VCITY_CODE", "");
    localCustomerExt.setParam(":VCLASS_ID", paramCustomerDAO.getClass_id());
    localCustomerExt.setParam(":VCLIENT_STATUS", "");
    localCustomerExt.setParam(":VCOMPANY_ADDRESS", paramCustomerDAO.getCompany_address());
    localCustomerExt.setParam(":VCUST_NAME", paramCustomerDAO.getCust_name());
    localCustomerExt.setParam(":VDEVELOPE_CHANNEL", paramCustomerDAO.getDevelope_channel());
    localCustomerExt.setParam(":VDEVELOPE_MAN", paramCustomerDAO.getDevelope_man());
    localCustomerExt.setParam(":VEMAIL", paramCustomerDAO.getEmail());
    localCustomerExt.setParam(":VPROVINCE", paramCustomerDAO.getProvince());
    localCustomerExt.setParam(":VENTERPRISE_TYPE_CODE", paramCustomerDAO.getEnterprise_type_code());
    localCustomerExt.setParam(":VENTERPRISE_SCOPE", paramCustomerDAO.getEnterprise_scope());
    localCustomerExt.setParam(":VENTERPRISE_SIZE_CODE", paramCustomerDAO.getEnterprise_size_code());
    localCustomerExt.setParam(":VEPARCHY_CODE", "");
    localCustomerExt.setParam(":VFAX_NBR", paramCustomerDAO.getFax_nbr());
    localCustomerExt.setParam(":VGROUP_ATTR", paramCustomerDAO.getGroup_attr());
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", paramCustomerDAO.getGroup_contact_phone());
    localCustomerExt.setParam(":VJURISTIC", paramCustomerDAO.getJuristic());
    localCustomerExt.setParam(":VJURISTIC_TYPE_CODE", paramCustomerDAO.getJuristic_type_code());
    localCustomerExt.setParam(":VLOCAL_EMP_COUNT", paramCustomerDAO.getLocal_emp_count());
    localCustomerExt.setParam(":VPOST_CODE", paramCustomerDAO.getPost_code());
    localCustomerExt.setParam(":VPSPT_ADDR", paramCustomerDAO.getPspt_addr());
    localCustomerExt.setParam(":VPSPT_ID", paramCustomerDAO.getPspt_id());
    localCustomerExt.setParam(":VPSPT_TYPE_CODE", paramCustomerDAO.getPspt_type_code());
    localCustomerExt.setParam(":VUSER_COUNT", paramCustomerDAO.getUser_count());
    localCustomerExt.setParam(":VWEBSITE", paramCustomerDAO.getWebsite());
    localCustomerExt.setParam(":VJURISTIC_CUST_ID", str2);
    localCustomerExt.setParam(":VCUST_AIM", paramCustomerDAO.getCust_aim());
    localCustomerExt.setParam(":VSCOPE", paramCustomerDAO.getScope());
    localCustomerExt.setParam(":VGROUP_MEMO", paramCustomerDAO.getGroup_memo());
    localCustomerExt.setParam(":VREG_MONEY", paramCustomerDAO.getReg_money());
    localCustomerExt.setParam(":VCUST_ID", paramCustomerDAO.getCust_id());
    this.tradeQuery.executeBy(localCustomerExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("CUST_ID", paramCustomerDAO.getCust_id());
    this.outBuffer.setString("SPEC_ROOT_ID", paramCustomerDAO.getCust_id());
    return 0;
  }

  public void addAdminCustinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addAdminCustinfo方法...");
    int i = -1;
    try
    {
      CustomerDAO localCustomerDAO = new CustomerDAO();
      localCustomerDAO.setCompany_address(paramBuffers.getString("COMPANY_ADDRESS"));
      localCustomerDAO.setCust_name(paramBuffers.getString("CUST_NAME"));
      localCustomerDAO.setEmail(paramBuffers.getString("EMAIL"));
      localCustomerDAO.setGroup_contact_phone(paramBuffers.getString("GROUP_CONTACT_PHONE"));
      localCustomerDAO.setWebsite(paramBuffers.getString("WEBSITE"));
      localCustomerDAO.setCust_aim(paramBuffers.getString("CUST_AIM"));
      localCustomerDAO.setCust_id(paramBuffers.getString("CUST_ID"));
      String str1 = paramBuffers.getString("CUST_STATE");
      String str2 = paramBuffers.getString("CUST_TYPE");
      i = addAdminCustinfo(localCustomerDAO, str1, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增客户业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增客户业务处理成功！");
    }
    this.log.LOG_INFO("退出addcustinfo方法...");
  }

  public int addAdminCustinfo(CustomerDAO paramCustomerDAO, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCOMPANY_ADDRESS", paramCustomerDAO.getCompany_address());
    localCustomerExt.setParam(":VCUST_STATE", paramString1);
    localCustomerExt.setParam(":VCUST_TYPE", paramString2);
    localCustomerExt.setParam(":VCUST_NAME", paramCustomerDAO.getCust_name());
    localCustomerExt.setParam(":VEMAIL", paramCustomerDAO.getEmail());
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", paramCustomerDAO.getGroup_contact_phone());
    localCustomerExt.setParam(":VWEBSITE", paramCustomerDAO.getWebsite());
    localCustomerExt.setParam(":VCUST_AIM", paramCustomerDAO.getCust_aim());
    localCustomerExt.setParam(":VCUST_ID", paramCustomerDAO.getCust_id());
    this.tradeQuery.executeBy(localCustomerExt.insBy("INS_BY_ADMIN_CUST"));
    return 0;
  }

  public void addCompanyName(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addcustinfo方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_CUST_ID");
      String str2 = paramBuffers.getString("CUST_NAME");
      i = addCompanyName(str1, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增客户业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增客户业务处理成功！");
    }
    this.log.LOG_INFO("退出addcustinfo方法...");
  }

  public int addCompanyName(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VJURISTIC_TYPE_CODE", paramString2);
    this.tradeQuery.executeBy(localCustomerExt.insBy("INS_BY_COMPANY_NAME"));
    return 0;
  }

  public ArrayList FindCompanyName(String paramString)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_LIST_BY_CUST_BY");
    return localArrayList;
  }

  public void addCustLevel(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCustLevel方法...");
    int i = -1;
    try
    {
      CustLevelDAO localCustLevelDAO = new CustLevelDAO();
      localCustLevelDAO.setCust_id(paramBuffers.getString("cust_id"));
      localCustLevelDAO.setCust_oper_person(paramBuffers.getString("SESSION_CUST_ID"));
      i = addCustLevel(localCustLevelDAO);
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
    this.log.LOG_INFO("退出addCustLevel方法...");
  }

  public int addCustLevel(CustLevelDAO paramCustLevelDAO)
    throws SaasApplicationException
  {
    String str1 = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
    String str2 = "20500101";
    CustLevelExt localCustLevelExt = new CustLevelExt();
    localCustLevelExt.setParam(":VCUST_ID", paramCustLevelDAO.getCust_id());
    localCustLevelExt.setParam(":VCUST_CLASS", "1");
    localCustLevelExt.setParam(":VCUST_OPER_PERSON", paramCustLevelDAO.getCust_oper_person());
    localCustLevelExt.setParam(":VCUST_START_DATE", str1);
    localCustLevelExt.setParam(":VCUST_OPER_DATE", str1);
    localCustLevelExt.setParam(":VCUST_END_DATE", str2);
    localCustLevelExt.setParam(":VCUST_DESC", "新用户");
    this.tradeQuery.executeBy(localCustLevelExt.insBy("INS_BY_ALLCLASS"));
    return 0;
  }

  public void genCustInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genCustInfo方法...");
    try
    {
      this.queryResult = genCustInfo();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genCustInfo方法...");
  }

  public ArrayList genCustInfo()
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    CustomerExt localCustomerExt1 = new CustomerExt();
    CustomerExt localCustomerExt2 = new CustomerExt();
    localArrayList1 = localCustomerExt1.selByList("SEL_BY_ALL");
    if (localArrayList1 == null)
      return null;
    String str1 = "3";
    localCustomerExt2.setParam(":VCUST_STATE", str1);
    localArrayList2 = localCustomerExt2.selByList("SEL_SPEC_CUST_STATE");
    if (localArrayList2 == null)
      return null;
    Iterator localIterator = localArrayList1.iterator();
    HashMap localHashMap1;
    String str2;
    String str3;
    String str4;
    Object localObject;
    while (localIterator.hasNext())
    {
      localHashMap1 = (HashMap)localIterator.next();
      str2 = "";
      str3 = "";
      str4 = "";
      localObject = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("cust_id") != null)
        str3 = localHashMap1.get("cust_id").toString();
      if (localHashMap1.get("cust_name") != null)
        str2 = localHashMap1.get("cust_name").toString();
      if (localHashMap1.get("scope") != null)
        str4 = localHashMap1.get("scope").toString();
      str4 = localcommMethodMgr.splitStr(str4, 117);
      if (localHashMap1.get("cust_state") != null)
        localObject = localHashMap1.get("cust_state").toString();
      localHashMap2.put("cust_name", str2);
      localHashMap2.put("cust_id", str3);
      localHashMap2.put("scope", str4);
      localArrayList4.add(localHashMap2);
    }
    localIterator = localArrayList2.iterator();
    while (localIterator.hasNext())
    {
      localHashMap1 = (HashMap)localIterator.next();
      str2 = "";
      str3 = "";
      str4 = "";
      localObject = new HashMap();
      if (localHashMap1.get("cust_id") != null)
        str3 = localHashMap1.get("cust_id").toString();
      if (localHashMap1.get("cust_name") != null)
        str2 = localHashMap1.get("cust_name").toString();
      if (localHashMap1.get("scope") != null)
        str4 = localHashMap1.get("scope").toString();
      str4 = localcommMethodMgr.splitStr(str4, 117);
      ((HashMap)localObject).put("custName_state", str2);
      ((HashMap)localObject).put("cust_id", str3);
      ((HashMap)localObject).put("scope_state", str4);
      localArrayList5.add(localObject);
    }
    localArrayList3.add(0, localArrayList4);
    localArrayList3.add(1, localArrayList5);
    return (ArrayList)localArrayList3;
  }

  public void genSpecCustInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genSpecCustInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("CUST_ID");
    try
    {
      this.queryResult = genSpecCustInfo(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genSpecCustInfo方法...");
  }

  public ArrayList genSpecCustInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST");
    return localArrayList;
  }

  public void CustInfoList(Buffers paramBuffers)
  {
    String str1 = "";
    String str2 = "";
    str1 = paramBuffers.getString("TABLE_FLAG");
    str2 = paramBuffers.getString("CUST_ID");
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入CustInfoList方法...");
    try
    {
      this.queryResult = CustInfoAllList(str1, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出CustInfoList方法...");
  }

  public int getListByName(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VNAME", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_LIST_BY_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getCListByName(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_LIST_BYNAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getCListByName(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 *= paramInt2;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_LIST_BYNAME", paramInt1, paramInt2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList CustInfoAllList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if ((paramString1 == "") || (paramString1 == null))
      return null;
    if (paramString1.equals("3"))
      paramString1 = "2";
    if (paramString1.equals("4"))
      paramString1 = "1";
    ArrayList localArrayList = new ArrayList();
    Attachinfo localAttachinfo = new Attachinfo();
    String str1 = "";
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    Object localObject6;
    String str7;
    Object localObject7;
    Object localObject8;
    if (paramString1.equals("1"))
    {
      localObject1 = new ArrayList();
      localObject2 = new ParacreditExt();
      ((ParacreditExt)localObject2).setParam(":VCUST_ID", paramString2);
      localObject1 = ((ParacreditExt)localObject2).selByList("SEL_BY_CREDIT");
      if (localObject1 == null)
      {
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("cust_id", paramString2);
        localArrayList.add(localObject3);
        return localArrayList;
      }
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (HashMap)((Iterator)localObject3).next();
        localObject5 = "";
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        str6 = "";
        localObject6 = "";
        str7 = "";
        localObject7 = "";
        localObject8 = new HashMap();
        if (((HashMap)localObject4).get("credit_id") != null)
          localObject5 = ((HashMap)localObject4).get("credit_id").toString();
        if (((HashMap)localObject4).get("cust_id") != null)
          str3 = ((HashMap)localObject4).get("cust_id").toString();
        if (((HashMap)localObject4).get("credit_type") != null)
          str4 = ((HashMap)localObject4).get("credit_type").toString();
        if (((HashMap)localObject4).get("credit_title") != null)
          str5 = ((HashMap)localObject4).get("credit_title").toString();
        if (((HashMap)localObject4).get("credit_desc") != null)
          str6 = ((HashMap)localObject4).get("credit_desc").toString();
        if (((HashMap)localObject4).get("affix_id") != null)
        {
          localObject6 = ((HashMap)localObject4).get("affix_id").toString();
          str1 = "<img border=0 src=" + getCustAttachPath((String)localObject6, "C") + ">";
        }
        if (((HashMap)localObject4).get("publish_date") != null)
          localObject7 = ((HashMap)localObject4).get("publish_date").toString();
        if (((HashMap)localObject4).get("cust_name") != null)
          str2 = ((HashMap)localObject4).get("cust_name").toString();
        ((HashMap)localObject8).put("credit_id", localObject5);
        ((HashMap)localObject8).put("cust_id", str3);
        ((HashMap)localObject8).put("credit_type", str4);
        ((HashMap)localObject8).put("credit_title", str5);
        ((HashMap)localObject8).put("credit_desc", str6);
        ((HashMap)localObject8).put("affix_id", localObject6);
        ((HashMap)localObject8).put("publish_date", localObject7);
        ((HashMap)localObject8).put("cust_name", str2);
        ((HashMap)localObject8).put("pic_path", str1);
        this.log.LOG_INFO("strImagePath..." + str1);
        localArrayList.add(localObject8);
      }
    }
    if (paramString1.equals("2"))
    {
      localObject1 = new NewsExt();
      localObject2 = new ArrayList();
      ((NewsExt)localObject1).setParam(":VCUST_ID", paramString2);
      localObject2 = ((NewsExt)localObject1).selByList("SEL_BY_NEWS");
      if (localObject2 == null)
      {
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("cust_id", paramString2);
        localArrayList.add(localObject3);
        return localArrayList;
      }
      localObject3 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (HashMap)((Iterator)localObject3).next();
        localObject5 = "";
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        str6 = "";
        localObject6 = "";
        str7 = "";
        localObject7 = new HashMap();
        if (((HashMap)localObject4).get("news_id") != null)
          localObject5 = ((HashMap)localObject4).get("news_id").toString();
        if (((HashMap)localObject4).get("news_type") != null)
          str3 = ((HashMap)localObject4).get("news_type").toString();
        if (((HashMap)localObject4).get("cust_id") != null)
          str4 = ((HashMap)localObject4).get("cust_id").toString();
        if (((HashMap)localObject4).get("title") != null)
          str5 = ((HashMap)localObject4).get("title").toString();
        if (((HashMap)localObject4).get("content") != null)
          str6 = ((HashMap)localObject4).get("content").toString();
        if (((HashMap)localObject4).get("attachment_tag") != null)
          localObject6 = ((HashMap)localObject4).get("attachment_tag").toString();
        if (((HashMap)localObject4).get("validity") != null)
          str7 = ((HashMap)localObject4).get("validity").toString();
        if (((HashMap)localObject4).get("cust_name") != null)
          str2 = ((HashMap)localObject4).get("cust_name").toString();
        ((HashMap)localObject7).put("news_id", localObject5);
        ((HashMap)localObject7).put("news_type", str3);
        ((HashMap)localObject7).put("cust_id", str4);
        ((HashMap)localObject7).put("title", str5);
        ((HashMap)localObject7).put("content", str6);
        ((HashMap)localObject7).put("attachment_tag", localObject6);
        ((HashMap)localObject7).put("validity", str7);
        ((HashMap)localObject7).put("cust_name", str2);
        localArrayList.add(localObject7);
      }
    }
    Object localObject9;
    Object localObject10;
    if (paramString1.equals("5"))
    {
      localObject1 = new ArrayList();
      localObject2 = new SaleInfoExt();
      ((SaleInfoExt)localObject2).setParam(":VSALE_UNIT", paramString2);
      localObject1 = ((SaleInfoExt)localObject2).selByList("SEL_BY_SALE_CUST");
      if (localObject1 == null)
      {
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("cust_id", paramString2);
        localArrayList.add(localObject3);
        return localArrayList;
      }
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (HashMap)((Iterator)localObject3).next();
        localObject5 = "";
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        str6 = "";
        localObject6 = "";
        str7 = "";
        localObject7 = "";
        localObject8 = "";
        localObject9 = "";
        localObject10 = "";
        String str8 = "";
        String str9 = "";
        String str10 = "";
        String str11 = "";
        String str12 = "";
        HashMap localHashMap = new HashMap();
        if (((HashMap)localObject4).get("sale_id") != null)
          localObject5 = ((HashMap)localObject4).get("sale_id").toString();
        if (((HashMap)localObject4).get("sale_unit") != null)
          str3 = ((HashMap)localObject4).get("sale_unit").toString();
        if (((HashMap)localObject4).get("sale_type") != null)
          str4 = ((HashMap)localObject4).get("sale_type").toString();
        if (((HashMap)localObject4).get("sale_class") != null)
          localObject6 = ((HashMap)localObject4).get("sale_class").toString();
        if (((HashMap)localObject4).get("sale_addr") != null)
          str7 = ((HashMap)localObject4).get("sale_addr").toString();
        if (((HashMap)localObject4).get("attach_tag") != null)
          localObject7 = ((HashMap)localObject4).get("attach_tag").toString();
        if (((HashMap)localObject4).get("start_date") != null)
          localObject8 = ((HashMap)localObject4).get("start_date").toString();
        if (((HashMap)localObject4).get("end_date") != null)
          localObject9 = ((HashMap)localObject4).get("end_date").toString();
        if (((HashMap)localObject4).get("publish_date") != null)
          localObject10 = ((HashMap)localObject4).get("publish_date").toString().substring(0, 10);
        if (((HashMap)localObject4).get("publish_user_id") != null)
          str8 = ((HashMap)localObject4).get("publish_user_id").toString();
        if (((HashMap)localObject4).get("title") != null)
          str5 = ((HashMap)localObject4).get("title").toString();
        if (((HashMap)localObject4).get("audit_date") != null)
          str9 = ((HashMap)localObject4).get("audit_date").toString();
        if (((HashMap)localObject4).get("validity") != null)
          str10 = ((HashMap)localObject4).get("validity").toString();
        if (((HashMap)localObject4).get("audit_user_id") != null)
          str11 = ((HashMap)localObject4).get("audit_user_id").toString();
        if (((HashMap)localObject4).get("content") != null)
          str6 = ((HashMap)localObject4).get("content").toString();
        if (((HashMap)localObject4).get("remark") != null)
          str12 = ((HashMap)localObject4).get("remark").toString();
        if (((HashMap)localObject4).get("cust_name") != null)
          str2 = ((HashMap)localObject4).get("cust_name").toString();
        localHashMap.put("sale_id", localObject5);
        localHashMap.put("cust_id", str3);
        localHashMap.put("sale_type", str4);
        localHashMap.put("title", str5);
        localHashMap.put("sale_class", localObject6);
        localHashMap.put("content", str6);
        localHashMap.put("sale_addr", str7);
        localHashMap.put("attach_tag", localObject7);
        localHashMap.put("start_date", localObject8);
        localHashMap.put("end_date", localObject9);
        localHashMap.put("publish_date", localObject10);
        localHashMap.put("publish_user_id", str8);
        localHashMap.put("audit_date", str9);
        localHashMap.put("validity", str10);
        localHashMap.put("audit_user_id", str11);
        localHashMap.put("remark", str12);
        localHashMap.put("cust_name", str2);
        localArrayList.add(localHashMap);
      }
    }
    if (paramString1.equals("6"))
    {
      localObject1 = new ArrayList();
   //   localObject2 = new RepositoryExt();
  //    ((RepositoryExt)localObject2).setParam(":VCUST_ID", paramString2);
  //    localObject1 = ((RepositoryExt)localObject2).selByList("SEL_BY_REPOSITORY");
      if (localObject1 == null)
      {
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("cust_id", paramString2);
        localArrayList.add(localObject3);
        return localArrayList;
      }
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (HashMap)((Iterator)localObject3).next();
        localObject5 = "";
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        str6 = "";
        localObject6 = new HashMap();
        if (((HashMap)localObject4).get("repository_id") != null)
          str5 = ((HashMap)localObject4).get("repository_id").toString();
        if (((HashMap)localObject4).get("title") != null)
          localObject5 = ((HashMap)localObject4).get("title").toString();
        if (((HashMap)localObject4).get("cust_id") != null)
          str3 = ((HashMap)localObject4).get("cust_id").toString();
        if (((HashMap)localObject4).get("affix_number") != null)
          str6 = ((HashMap)localObject4).get("affix_number").toString();
        if (str6 != "0")
          str1 = "<img border=0 src=" + getCustAttachPath(str5, "R") + ">";
        if (((HashMap)localObject4).get("cust_name") != null)
          str4 = ((HashMap)localObject4).get("cust_name").toString();
        if (((HashMap)localObject4).get("content") != null)
          str2 = this.commen.splitStr(((HashMap)localObject4).get("content").toString(), 200);
        ((HashMap)localObject6).put("title", localObject5);
        ((HashMap)localObject6).put("cust_name", str4);
        ((HashMap)localObject6).put("repositoryId", str5);
        ((HashMap)localObject6).put("cust_id", str3);
        ((HashMap)localObject6).put("affix_number", str6);
        ((HashMap)localObject6).put("pic_path", str1);
        ((HashMap)localObject6).put("content", str2);
        localArrayList.add(localObject6);
      }
    }
    if (paramString1.equals("7"))
    {
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = new BidExt();
      ((BidExt)localObject3).setParam(":VCUST_ID", paramString2);
      localObject1 = ((BidExt)localObject3).selByList("SEL_BY_BIDDING_CUST");
      if (localObject1 == null)
      {
        localObject4 = new HashMap();
        ((HashMap)localObject4).put("cust_id", paramString2);
        localArrayList.add(localObject4);
        return localArrayList;
      }
      localObject4 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (HashMap)((Iterator)localObject4).next();
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        str6 = "";
        localObject6 = "";
        str7 = "";
        localObject7 = "";
        localObject8 = "";
        localObject9 = "";
        localObject10 = new HashMap();
        if (((HashMap)localObject5).get("bidding_id") != null)
          str4 = ((HashMap)localObject5).get("bidding_id").toString();
        if (((HashMap)localObject5).get("cust_id") != null)
          str2 = ((HashMap)localObject5).get("cust_id").toString();
        if (((HashMap)localObject5).get("title") != null)
          str5 = ((HashMap)localObject5).get("title").toString();
        if (((HashMap)localObject5).get("bidding_no") != null)
          str6 = ((HashMap)localObject5).get("bidding_no").toString();
        if (((HashMap)localObject5).get("open_date") != null)
          localObject6 = ((HashMap)localObject5).get("open_date").toString();
        if (((HashMap)localObject5).get("addr") != null)
          str7 = ((HashMap)localObject5).get("addr").toString();
        if (((HashMap)localObject5).get("content") != null)
          localObject7 = this.commen.splitStr(((HashMap)localObject5).get("content").toString(), 200);
        if (((HashMap)localObject5).get("attach_tag") != null)
          localObject8 = ((HashMap)localObject5).get("attach_tag").toString();
        if (localObject8 != "0")
          str1 = "<img border=0 src=" + getCustAttachPath(str4, "B") + ">";
        if (((HashMap)localObject5).get("publish_date") != null)
          localObject9 = ((HashMap)localObject5).get("publish_date").toString();
        if (((HashMap)localObject5).get("publish_date") != null)
          localObject9 = ((HashMap)localObject5).get("publish_date").toString();
        if (((HashMap)localObject5).get("cust_name") != null)
          str3 = ((HashMap)localObject5).get("cust_name").toString();
        ((HashMap)localObject10).put("bidding_id", str4);
        ((HashMap)localObject10).put("cust_id", str2);
        ((HashMap)localObject10).put("title", str5);
        ((HashMap)localObject10).put("bidding_no", str6);
        ((HashMap)localObject10).put("open_date", localObject6);
        ((HashMap)localObject10).put("addr", str7);
        ((HashMap)localObject10).put("content", localObject7);
        ((HashMap)localObject10).put("attach_tag", localObject8);
        ((HashMap)localObject10).put("publish_date", localObject9);
        ((HashMap)localObject10).put("cust_name", str3);
        ((HashMap)localObject10).put("pic_path", str1);
        localArrayList.add(localObject10);
      }
    }
    if (paramString1.equals("8"))
    {
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = new ProduceExt();
      ((ProduceExt)localObject3).setParam(":VCUST_ID", paramString2);
      localObject1 = ((ProduceExt)localObject3).selByList("SEL_BY_PRODUCT_CUST");
      if (localObject1 == null)
      {
        localObject4 = new HashMap();
        ((HashMap)localObject4).put("cust_id", paramString2);
        localArrayList.add(localObject4);
        return localArrayList;
      }
      localObject4 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (HashMap)((Iterator)localObject4).next();
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        str6 = "";
        localObject6 = "";
        str7 = "";
        localObject7 = "";
        localObject8 = null;
        localObject9 = "";
        localObject10 = new HashMap();
        if (((HashMap)localObject5).get("cust_id") != null)
          str2 = ((HashMap)localObject5).get("cust_id").toString();
        if (((HashMap)localObject5).get("product_id") != null)
          str4 = ((HashMap)localObject5).get("product_id").toString();
        if (((HashMap)localObject5).get("product_type") != null)
          str5 = ((HashMap)localObject5).get("product_type").toString();
        if (((HashMap)localObject5).get("product_name") != null)
          str6 = ((HashMap)localObject5).get("product_name").toString();
        if (((HashMap)localObject5).get("product_class") != null)
          localObject6 = ((HashMap)localObject5).get("product_class").toString();
        if (((HashMap)localObject5).get("product_site") != null)
          str7 = ((HashMap)localObject5).get("product_site").toString();
        if (((HashMap)localObject5).get("attach_tag") != null)
          localObject9 = ((HashMap)localObject5).get("attach_tag").toString();
        if (localObject9 != "0")
          str1 = "<img border=0 src=" + getCustAttachPath(str4, "P") + ">";
        if (((HashMap)localObject5).get("product_abstract") != null)
          localObject7 = ((HashMap)localObject5).get("product_abstract").toString();
        if (((HashMap)localObject5).get("product_desc") != null)
          localObject8 = ((HashMap)localObject5).get("product_desc").toString();
        if (((HashMap)localObject5).get("cust_name") != null)
          str3 = ((HashMap)localObject5).get("cust_name").toString();
        ((HashMap)localObject10).put("cust_id", str2);
        ((HashMap)localObject10).put("product_id", str4);
        ((HashMap)localObject10).put("product_type", str5);
        ((HashMap)localObject10).put("product_name", str6);
        ((HashMap)localObject10).put("product_class", localObject6);
        ((HashMap)localObject10).put("product_site", str7);
        ((HashMap)localObject10).put("product_abstract", localObject7);
        ((HashMap)localObject10).put("product_desc", localObject8);
        ((HashMap)localObject10).put("cust_name", str3);
        ((HashMap)localObject10).put("pic_path", str1);
        localArrayList.add(localObject10);
      }
    }
    if (paramString1.equals("9"))
    {
      localObject1 = new ArrayList();
      localObject2 = new StockOrderExt();
      ((StockOrderExt)localObject2).setParam(":VCUST_ID", paramString2);
      localObject1 = ((StockOrderExt)localObject2).selByList("SEL_BY_STOCKORDER");
      if (localObject1 == null)
      {
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("cust_id", paramString2);
        localArrayList.add(localObject3);
        return localArrayList;
      }
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (HashMap)((Iterator)localObject3).next();
        localObject5 = "";
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        str6 = "";
        localObject6 = "";
        str7 = "";
        localObject7 = "";
        localObject8 = "";
        localObject9 = new HashMap();
        if (((HashMap)localObject4).get("stock_id") != null)
          localObject5 = ((HashMap)localObject4).get("stock_id").toString();
        if (((HashMap)localObject4).get("cust_id") != null)
          str5 = ((HashMap)localObject4).get("cust_id").toString();
        if (((HashMap)localObject4).get("stock_type") != null)
          str4 = ((HashMap)localObject4).get("stock_type").toString();
        if (((HashMap)localObject4).get("title") != null)
          str3 = ((HashMap)localObject4).get("title").toString();
        if (((HashMap)localObject4).get("content") != null)
          str6 = ((HashMap)localObject4).get("content").toString();
        if (((HashMap)localObject4).get("stock_class") != null)
          localObject6 = ((HashMap)localObject4).get("stock_class").toString();
        if (((HashMap)localObject4).get("start_date") != null)
          str7 = ((HashMap)localObject4).get("start_date").toString();
        if (((HashMap)localObject4).get("end_date") != null)
          localObject7 = ((HashMap)localObject4).get("end_date").toString();
        if (((HashMap)localObject4).get("publish_date") != null)
          localObject8 = ((HashMap)localObject4).get("publish_date").toString().substring(0, 10);
        if (((HashMap)localObject4).get("cust_name") != null)
          str2 = ((HashMap)localObject4).get("cust_name").toString();
        ((HashMap)localObject9).put("stock_id", localObject5);
        ((HashMap)localObject9).put("cust_id", str5);
        ((HashMap)localObject9).put("stock_type", str4);
        ((HashMap)localObject9).put("title", str3);
        ((HashMap)localObject9).put("content", str6);
        ((HashMap)localObject9).put("stock_class", localObject6);
        ((HashMap)localObject9).put("start_date", str7);
        ((HashMap)localObject9).put("end_date", localObject7);
        ((HashMap)localObject9).put("publish_date", localObject8);
        ((HashMap)localObject9).put("cust_name", str2);
        localArrayList.add(localObject9);
      }
    }
    if (paramString1.equals("10"))
    {
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
   //   localObject3 = new JobExt();
   //   ((JobExt)localObject3).setParam(":VCUST_ID", paramString2);
   //   localObject1 = ((JobExt)localObject3).selByList("SEL_BY_JOBCUST");
      if (localObject1 == null)
      {
        localObject4 = new HashMap();
        ((HashMap)localObject4).put("cust_id", paramString2);
        localArrayList.add(localObject4);
        return localArrayList;
      }
      localObject4 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (HashMap)((Iterator)localObject4).next();
        str2 = "";
        str3 = "";
        str4 = "";
        str5 = "";
        str6 = "";
        localObject6 = "";
        str7 = "";
        localObject7 = "";
        localObject8 = "";
        localObject9 = new HashMap();
        if (((HashMap)localObject5).get("cust_id") != null)
          str2 = ((HashMap)localObject5).get("cust_id").toString();
        if (((HashMap)localObject5).get("job_id") != null)
          localObject6 = ((HashMap)localObject5).get("job_id").toString();
        if (((HashMap)localObject5).get("title") != null)
          str3 = ((HashMap)localObject5).get("title").toString();
        if (((HashMap)localObject5).get("job_unit") != null)
          str5 = ((HashMap)localObject5).get("job_unit").toString();
        if (((HashMap)localObject5).get("validity") != null)
          str7 = ((HashMap)localObject5).get("validity").toString();
        if (((HashMap)localObject5).get("job_addr") != null)
          localObject7 = ((HashMap)localObject5).get("job_addr").toString();
        if (((HashMap)localObject5).get("request") != null)
          localObject8 = ((HashMap)localObject5).get("request").toString();
        if (((HashMap)localObject5).get("job_type") != null)
          str6 = ((HashMap)localObject5).get("job_type").toString();
        if (((HashMap)localObject5).get("cust_name") != null)
          str4 = ((HashMap)localObject5).get("cust_name").toString();
        ((HashMap)localObject9).put("cust_id", str2);
        ((HashMap)localObject9).put("cust_name", str4);
        ((HashMap)localObject9).put("job_id", localObject6);
        ((HashMap)localObject9).put("title", str3);
        ((HashMap)localObject9).put("job_unit", str5);
        ((HashMap)localObject9).put("validity", str7);
        ((HashMap)localObject9).put("job_addr", localObject7);
        ((HashMap)localObject9).put("request", localObject8);
        ((HashMap)localObject9).put("job_type", str6);
        localArrayList.add(localObject9);
      }
    }
    return (ArrayList)(ArrayList)(ArrayList)(ArrayList)(ArrayList)(ArrayList)(ArrayList)(ArrayList)(ArrayList)(ArrayList)localArrayList;
  }

  public void getCustInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getCustInfo方法...");
    String str = paramBuffers.getString("CUST_ID");
    this.outBuffer = paramBuffers;
    try
    {
      this.queryResult = getCustInfo(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getCustInfo方法...");
  }

  public ArrayList getCustInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList1 = localCustomerExt.selByList("SEL_SPEC_CUST");
    return localArrayList1;
  }

  public ArrayList getCustInfoBydefinition(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", "%" + paramString3 + "%");
    localCustomerExt.setParam(":VPROVINCE", "%" + paramString4 + "%");
    localCustomerExt.setParam(":VEPARCHY_CODE", "%" + paramString5 + "%");
    localCustomerExt.setParam(":VCITY_CODE", "%" + paramString6 + "%");
    localArrayList = localCustomerExt.selByList("SEL_CUST_BYDEFINITION", paramInt, 20);
    return localArrayList;
  }

  public int getCustInfoBydefinition(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    int i = 0;
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", "%" + paramString3 + "%");
    localCustomerExt.setParam(":VPROVINCE", "%" + paramString4 + "%");
    localCustomerExt.setParam(":VEPARCHY_CODE", "%" + paramString5 + "%");
    localCustomerExt.setParam(":VCITY_CODE", "%" + paramString6 + "%");
    localArrayList = localCustomerExt.selByList("SEL_CUST_PAGE_BYDEFINITION");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("tt").toString());
    }
    return i;
  }

  public void getAllCust(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getAllCust方法...");
    this.outBuffer = paramBuffers;
    try
    {
      this.queryResult = getAllCust();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getAllCust方法...");
  }

  public ArrayList getAllCust()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList1 = localCustomerExt.selByList("SEL_ALL_CUST");
    return localArrayList1;
  }

  public int getAllCustLinkInfoList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList1 = localCustomerExt.selByList("SEL_ALL_CUST");
    if (localArrayList1 != null)
      return localArrayList1.size();
    return 0;
  }

  public ArrayList getAllCustLinkInfoList(int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList1 = localCustomerExt.selByList("SEL_ALL_CUST", paramInt, 20);
    return localArrayList1;
  }

  public ArrayList getAllCustLinkInfoListByKey(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList1 = localCustomerExt.selByList("SEL_LIKE_CUSTNAME", paramInt, 20);
    return localArrayList1;
  }

  public int getAllCustLinkInfoListByKey(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList1 = localCustomerExt.selByList("SEL_LIKE_CUSTNAME");
    if (localArrayList1 != null)
      return localArrayList1.size();
    return 0;
  }

  public void getCustList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getCustList方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("QUERY_PARAM");
    this.log.LOG_INFO("QUERY_PARAM..................." + str);
    try
    {
      if (str.equals(""))
        this.queryResult = getCustList();
      else
        this.queryResult = searchCust(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getCustList方法...");
  }

  public ArrayList getCustList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", "0");
    localArrayList1 = localCustomerExt.selByList("SEL_BY_ALL");
    return localArrayList1;
  }

  public ArrayList getCustList(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    paramInt1 *= paramInt2;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", "0");
    localArrayList1 = localCustomerExt.selByList("SEL_BY_ALL", paramInt1, paramInt2);
    return localArrayList1;
  }

  public void setCustPassd(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getCustList方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("PASSWORD");
    MD5 localMD5 = new MD5();
    str2 = localMD5.getMD5(str2.getBytes());
    this.log.LOG_INFO("CUST_ID..................." + str1);
    try
    {
      if (!str1.equals(""))
        setCustPassd(str1, str2);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
  }

  public int setCustPassd(String paramString1, String paramString2)
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VPASSWD", paramString2);
    this.tradeQuery.executeBy(localCustomerExt.insBy("UPDATE_CUST_PWD"));
    return 0;
  }

  public ArrayList getCustomerList(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", "0");
    localArrayList1 = localCustomerExt.selByList("SEL_NEW_REG_ENTERPRISE", 0, paramInt);
    return localArrayList1;
  }

  public void getNoFreeList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getNoFreeList方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str.equals(""))
        this.queryResult = getNoFreeList();
      else
        this.queryResult = searchCust(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getNoFreeList方法...");
  }

  public ArrayList getNoFreeList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", "1");
    localArrayList1 = localCustomerExt.selByList("SEL_BY_ALL");
    return localArrayList1;
  }

  public void CustNoFree(Buffers paramBuffers)
    throws SaasApplicationException
  {
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    this.outBuffer = paramBuffers;
    int i = -1;
    this.log.LOG_INFO("进入CustNoFree方法.....");
    try
    {
      i = CustNoFree(str1, str2);
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
    this.log.LOG_INFO("退出CustNoFree方法...");
  }

  public int CustNoFree(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    changUserState(paramString1, "0", paramString2);
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_STATE", "0");
    this.tradeQuery.executeBy(localCustomerExt.insBy("STATE_CHANGE"));
    return 0;
  }

  public void updateCustInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateCustInfo方法...");
    String str = paramBuffers.getString("CUST_ID");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      CustomerDAO localCustomerDAO = new CustomerDAO();
      localCustomerDAO.setCust_id(paramBuffers.getString("CUST_ID"));
      localCustomerDAO.setAll_emp_count(paramBuffers.getString("ALL_EMP_COUNT"));
      localCustomerDAO.setCalling_area_code(paramBuffers.getString("CALLING_AREA_CODE"));
      localCustomerDAO.setCalling_type_code(paramBuffers.getString("CALLING_TYPE_CODE"));
      localCustomerDAO.setChina_emp_count(paramBuffers.getString("CHINA_EMP_COUNT"));
      localCustomerDAO.setCity(paramBuffers.getString("CITY"));
      localCustomerDAO.setClass_id(paramBuffers.getString("CLASS_ID"));
      localCustomerDAO.setCompany_address(paramBuffers.getString("COMPANY_ADDRESS"));
      localCustomerDAO.setCust_name(paramBuffers.getString("CUST_NAME"));
      localCustomerDAO.setDevelope_channel(paramBuffers.getString("DEVELOPE_CHANNEL"));
      localCustomerDAO.setDevelope_man(paramBuffers.getString("DEVELOPE_MAN"));
      localCustomerDAO.setEmail(paramBuffers.getString("EMAIL"));
      localCustomerDAO.setEnterprise_type_code(paramBuffers.getString("ENTERPRISE_TYPE_CODE"));
      localCustomerDAO.setFax_nbr(paramBuffers.getString("FAX_NBR"));
      localCustomerDAO.setGroup_attr(paramBuffers.getString("GROUP_ATTR"));
      localCustomerDAO.setGroup_contact_phone(paramBuffers.getString("GROUP_CONTACT_PHONE"));
      localCustomerDAO.setJuristic(paramBuffers.getString("JURISTIC"));
      localCustomerDAO.setJuristic_type_code(paramBuffers.getString("JURISTIC_TYPE_CODE"));
      localCustomerDAO.setLocal_emp_count(paramBuffers.getString("LOCAL_EMP_COUNT"));
      localCustomerDAO.setPost_code(paramBuffers.getString("POST_CODE"));
      localCustomerDAO.setPspt_addr(paramBuffers.getString("PSPT_ADDR"));
      localCustomerDAO.setPspt_id(paramBuffers.getString("PSPT_ID"));
      localCustomerDAO.setPspt_type_code(paramBuffers.getString("PSPT_TYPE_CODE"));
      localCustomerDAO.setUser_count(paramBuffers.getString("USER_COUNT"));
      localCustomerDAO.setWebsite(paramBuffers.getString("WEBSITE"));
      localCustomerDAO.setEnterprise_size_code(paramBuffers.getString("ENTERPRISE_SIZE_CODE"));
      localCustomerDAO.setProvince(paramBuffers.getString("PROVINCE"));
      localCustomerDAO.setGroup_memo(paramBuffers.getString("GROUP_MEMO"));
      localCustomerDAO.setCust_aim(paramBuffers.getString("CUST_AIM"));
      localCustomerDAO.setReg_money(paramBuffers.getString("REG_MONEY"));
      localCustomerDAO.setScope(paramBuffers.getString("SCOPE"));
      i = updateCustInfo(localCustomerDAO);
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
    this.log.LOG_INFO("退出updateCustInfo方法...");
  }

  public int updateCustInfo(CustomerDAO paramCustomerDAO)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramCustomerDAO.getCust_id());
    localCustomerExt.setParam(":VALL_EMP_COUNT", paramCustomerDAO.getAll_emp_count());
    localCustomerExt.setParam(":VCALLING_AREA_CODE", paramCustomerDAO.getCalling_area_code());
    localCustomerExt.setParam(":VCALLING_TYPE_CODE", paramCustomerDAO.getCalling_type_code());
    localCustomerExt.setParam(":VCHINA_EMP_COUNT", paramCustomerDAO.getChina_emp_count());
    localCustomerExt.setParam(":VCITY", paramCustomerDAO.getCity());
    localCustomerExt.setParam(":VCITY_CODE", "");
    localCustomerExt.setParam(":VCLASS_ID", paramCustomerDAO.getClass_id());
    localCustomerExt.setParam(":VCOMPANY_ADDRESS", paramCustomerDAO.getCompany_address());
    localCustomerExt.setParam(":VCUST_NAME", paramCustomerDAO.getCust_name());
    localCustomerExt.setParam(":VDEVELOPE_CHANNEL", paramCustomerDAO.getDevelope_channel());
    localCustomerExt.setParam(":VDEVELOPE_MAN", paramCustomerDAO.getDevelope_man());
    localCustomerExt.setParam(":VEMAIL", paramCustomerDAO.getEmail());
    localCustomerExt.setParam(":VPROVINCE", paramCustomerDAO.getProvince());
    localCustomerExt.setParam(":VENTERPRISE_TYPE_CODE", paramCustomerDAO.getEnterprise_type_code());
    localCustomerExt.setParam(":VENTERPRISE_SCOPE", "");
    localCustomerExt.setParam(":VENTERPRISE_SIZE_CODE", paramCustomerDAO.getEnterprise_size_code());
    localCustomerExt.setParam(":VEPARCHY_CODE", "");
    localCustomerExt.setParam(":VFAX_NBR", paramCustomerDAO.getFax_nbr());
    localCustomerExt.setParam(":VGROUP_ATTR", paramCustomerDAO.getGroup_attr());
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", paramCustomerDAO.getGroup_contact_phone());
    localCustomerExt.setParam(":VJURISTIC", paramCustomerDAO.getJuristic());
    localCustomerExt.setParam(":VJURISTIC_TYPE_CODE", paramCustomerDAO.getJuristic_type_code());
    localCustomerExt.setParam(":VLOCAL_EMP_COUNT", paramCustomerDAO.getLocal_emp_count());
    localCustomerExt.setParam(":VPOST_CODE", paramCustomerDAO.getPost_code());
    localCustomerExt.setParam(":VPSPT_ADDR", paramCustomerDAO.getPspt_addr());
    localCustomerExt.setParam(":VPSPT_ID", paramCustomerDAO.getPspt_id());
    localCustomerExt.setParam(":VPSPT_TYPE_CODE", paramCustomerDAO.getPspt_type_code());
    localCustomerExt.setParam(":VUSER_COUNT", paramCustomerDAO.getUser_count());
    localCustomerExt.setParam(":VWEBSITE", paramCustomerDAO.getWebsite());
    localCustomerExt.setParam(":VGROUP_MEMO", paramCustomerDAO.getGroup_memo());
    localCustomerExt.setParam(":VCUST_AIM", paramCustomerDAO.getCust_aim());
    localCustomerExt.setParam(":VREG_MONEY", paramCustomerDAO.getReg_money());
    localCustomerExt.setParam(":VSCOPE", paramCustomerDAO.getScope());
    this.tradeQuery.executeBy(localCustomerExt.insBy("UPDATE_BY_INFO"));
    return 0;
  }

  public void updateCustById(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateCustById方法...");
    String str = paramBuffers.getString("CUST_ID");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      CustomerDAO localCustomerDAO = new CustomerDAO();
      localCustomerDAO.setCust_id(paramBuffers.getString("CUST_ID"));
      localCustomerDAO.setAll_emp_count(paramBuffers.getString("ALL_EMP_COUNT"));
      localCustomerDAO.setCalling_area_code(paramBuffers.getString("CALLING_AREA_CODE"));
      localCustomerDAO.setCalling_type_code(paramBuffers.getString("CALLING_TYPE_CODE"));
      localCustomerDAO.setChina_emp_count(paramBuffers.getString("CHINA_EMP_COUNT"));
      localCustomerDAO.setCity(paramBuffers.getString("CITY"));
      localCustomerDAO.setCity_code(paramBuffers.getString("CITY_CODE"));
      localCustomerDAO.setClass_id(paramBuffers.getString("CLASS_ID"));
      localCustomerDAO.setClient_status(paramBuffers.getString("CLIENT_STATUS"));
      localCustomerDAO.setCompany_address(paramBuffers.getString("COMPANY_ADDRESS"));
      localCustomerDAO.setCust_name(paramBuffers.getString("CUST_NAME"));
      localCustomerDAO.setDevelope_channel(paramBuffers.getString("DEVELOPE_CHANNEL"));
      localCustomerDAO.setDevelope_man(paramBuffers.getString("DEVELOPE_MAN"));
      localCustomerDAO.setEmail(paramBuffers.getString("EMAIL"));
      localCustomerDAO.setEnterprise_scope(paramBuffers.getString("ENTERPRISE_SCOPE"));
      localCustomerDAO.setEnterprise_type_code(paramBuffers.getString("ENTERPRISE_TYPE_CODE"));
      localCustomerDAO.setEparchy_code(paramBuffers.getString("EPARCHY_CODE"));
      localCustomerDAO.setFax_nbr(paramBuffers.getString("FAX_NBR"));
      localCustomerDAO.setGroup_attr(paramBuffers.getString("GROUP_ATTR"));
      localCustomerDAO.setGroup_contact_phone(paramBuffers.getString("GROUP_CONTACT_PHONE"));
      localCustomerDAO.setJuristic(paramBuffers.getString("JURISTIC"));
      localCustomerDAO.setJuristic_type_code(paramBuffers.getString("JURISTIC_TYPE_CODE"));
      localCustomerDAO.setLocal_emp_count(paramBuffers.getString("LOCAL_EMP_COUNT"));
      localCustomerDAO.setPost_code(paramBuffers.getString("POST_CODE"));
      localCustomerDAO.setPspt_addr(paramBuffers.getString("PSPT_ADDR"));
      localCustomerDAO.setPspt_id(paramBuffers.getString("PSPT_ID"));
      localCustomerDAO.setPspt_type_code(paramBuffers.getString("PSPT_TYPE_CODE"));
      localCustomerDAO.setUser_count(paramBuffers.getString("USER_COUNT"));
      localCustomerDAO.setWebsite(paramBuffers.getString("WEBSITE"));
      localCustomerDAO.setEnterprise_size_code(paramBuffers.getString("ENTERPRISE_SIZE_CODE"));
      localCustomerDAO.setProvince(paramBuffers.getString("PROVINCE"));
      localCustomerDAO.setGroup_memo(paramBuffers.getString("GROUP_MEMO"));
      localCustomerDAO.setCust_aim(paramBuffers.getString("CUST_AIM"));
      localCustomerDAO.setReg_money(paramBuffers.getString("REG_MONEY"));
      localCustomerDAO.setScope(paramBuffers.getString("SCOPE"));
      i = updateCustById(localCustomerDAO);
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
    this.log.LOG_INFO("退出updateCustById方法...");
  }

  public int updateCustById(CustomerDAO paramCustomerDAO)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入2222222222updateCustById2222222222222方法...");
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramCustomerDAO.getCust_id());
    localCustomerExt.setParam(":VALL_EMP_COUNT", paramCustomerDAO.getAll_emp_count());
    localCustomerExt.setParam(":VCALLING_AREA_CODE", paramCustomerDAO.getCalling_area_code());
    localCustomerExt.setParam(":VCALLING_TYPE_CODE", paramCustomerDAO.getCalling_type_code());
    localCustomerExt.setParam(":VCHINA_EMP_COUNT", paramCustomerDAO.getChina_emp_count());
    localCustomerExt.setParam(":VCITY", paramCustomerDAO.getCity());
    localCustomerExt.setParam(":VCITY_CODE", paramCustomerDAO.getCity_code());
    localCustomerExt.setParam(":VCLASS_ID", paramCustomerDAO.getClass_id());
    localCustomerExt.setParam(":VCOMPANY_ADDRESS", paramCustomerDAO.getCompany_address());
    localCustomerExt.setParam(":VCUST_NAME", paramCustomerDAO.getCust_name());
    localCustomerExt.setParam(":VDEVELOPE_CHANNEL", paramCustomerDAO.getDevelope_channel());
    localCustomerExt.setParam(":VDEVELOPE_MAN", paramCustomerDAO.getDevelope_man());
    localCustomerExt.setParam(":VEMAIL", paramCustomerDAO.getEmail());
    localCustomerExt.setParam(":VPROVINCE", paramCustomerDAO.getProvince());
    localCustomerExt.setParam(":VENTERPRISE_TYPE_CODE", paramCustomerDAO.getEnterprise_type_code());
    localCustomerExt.setParam(":VENTERPRISE_SCOPE", paramCustomerDAO.getEnterprise_scope());
    localCustomerExt.setParam(":VENTERPRISE_SIZE_CODE", paramCustomerDAO.getEnterprise_size_code());
    localCustomerExt.setParam(":VEPARCHY_CODE", paramCustomerDAO.getEparchy_code());
    localCustomerExt.setParam(":VCLIENT_STATUS", paramCustomerDAO.getClient_status());
    localCustomerExt.setParam(":VFAX_NBR", paramCustomerDAO.getFax_nbr());
    localCustomerExt.setParam(":VGROUP_ATTR", paramCustomerDAO.getGroup_attr());
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", paramCustomerDAO.getGroup_contact_phone());
    localCustomerExt.setParam(":VJURISTIC", paramCustomerDAO.getJuristic());
    localCustomerExt.setParam(":VJURISTIC_TYPE_CODE", paramCustomerDAO.getJuristic_type_code());
    localCustomerExt.setParam(":VLOCAL_EMP_COUNT", paramCustomerDAO.getLocal_emp_count());
    localCustomerExt.setParam(":VPOST_CODE", paramCustomerDAO.getPost_code());
    localCustomerExt.setParam(":VPSPT_ADDR", paramCustomerDAO.getPspt_addr());
    localCustomerExt.setParam(":VPSPT_ID", paramCustomerDAO.getPspt_id());
    localCustomerExt.setParam(":VPSPT_TYPE_CODE", paramCustomerDAO.getPspt_type_code());
    localCustomerExt.setParam(":VUSER_COUNT", paramCustomerDAO.getUser_count());
    localCustomerExt.setParam(":VWEBSITE", paramCustomerDAO.getWebsite());
    localCustomerExt.setParam(":VGROUP_MEMO", paramCustomerDAO.getGroup_memo());
    localCustomerExt.setParam(":VCUST_AIM", paramCustomerDAO.getCust_aim());
    localCustomerExt.setParam(":VREG_MONEY", paramCustomerDAO.getReg_money());
    localCustomerExt.setParam(":VSCOPE", paramCustomerDAO.getScope());
    this.tradeQuery.executeBy(localCustomerExt.insBy("UPDATE_BY_CUST_ID"));
    this.log.LOG_INFO("退出2222222222updateCustById2222222222222方法...");
    return 0;
  }

  public String getCustAttachPath(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Attachinfo localAttachinfo = new Attachinfo();
    String str = localAttachinfo.getAttachPath(paramString1, paramString2, "0");
    return str;
  }

  public void CustStateFree(Buffers paramBuffers)
    throws SaasApplicationException
  {
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    this.outBuffer = paramBuffers;
    int i = -1;
    this.log.LOG_INFO("进入CustStateFree方法.....");
    try
    {
      i = CustStateFree(str1, str2);
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
    this.log.LOG_INFO("退出CustStateFree方法...");
  }

  public int CustStateFree(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    changUserState(paramString1, "1", paramString2);
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_STATE", "1");
    this.tradeQuery.executeBy(localCustomerExt.insBy("STATE_CHANGE"));
    return 0;
  }

  public void CustStateLogout(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    int i = -1;
    this.log.LOG_INFO("进入CustStateLogout方法.....");
    try
    {
      i = CustStateLogout(str1, str2);
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
    this.log.LOG_INFO("退出CustStateLogout方法...");
  }

  public int CustStateLogout(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    changUserState(paramString1, "2", paramString2);
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_STATE", "2");
    this.tradeQuery.executeBy(localCustomerExt.insBy("STATE_CHANGE"));
    return 0;
  }

  public void CustCommend(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("CUST_ID");
    int i = -1;
    this.log.LOG_INFO("进入CustCommend方法.....");
    try
    {
      i = CustCommend(str);
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
    this.log.LOG_INFO("退出CustCommend方法...");
  }

  public int CustCommend(String paramString)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localCustomerExt.setParam(":VCUST_STATE", "3");
    this.tradeQuery.executeBy(localCustomerExt.insBy("STATE_CHANGE"));
    return 0;
  }

  public void changUserState(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_USER_ID");
    int i = -1;
    this.log.LOG_INFO("进入changUserState方法.....");
    String str2 = paramBuffers.getString("CUST_ID");
    String str3 = paramBuffers.getString("CUST_STATE");
    String str4 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      i = changUserState(str2, str3, str4);
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
    this.log.LOG_INFO("退出changUserState方法...");
  }

  public int changUserState(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入changUserState.....方法");
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString1);
    localUserExt.setParam(":VUSER_STATE", paramString2);
    localUserExt.setParam(":VSTAFF_ID", paramString3);
    this.tradeQuery.executeBy(localUserExt.insBy("USER_STATE_CHANGE"));
    this.log.LOG_INFO("退出changUserState.....方法");
    return 0;
  }

  public void searchCust(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入searchCust方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("SALER_NAME");
    try
    {
      this.queryResult = searchCust(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出searchCust方法...");
  }

  public ArrayList searchCust(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList = localCustomerExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public void getCustomerByCustIdOrAdmin(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getCustomerByCustIdOrAdmin方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_NAME");
    try
    {
      if ((str2 == "admin") || (str2.equals("admin")))
      {
        this.log.LOG_INFO("超级管理员............");
        this.queryResult = getAllCust();
      }
      else
      {
        this.log.LOG_INFO("进入普通客户..............");
        this.queryResult = getCustInfo(str1);
      }
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getCustomerByCustIdOrAdmin方法...");
  }

  public String getCustomerNameById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = genSpecCustInfo(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      str = localHashMap.get("cust_name").toString();
    }
    return str;
  }

  public String getCustomerTrueNameById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = genSpecCustInfo(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_aim") != "")
        str = localHashMap.get("cust_aim").toString();
    }
    return str;
  }

  public void updateCustomerTypeById(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("CUST_CLASS");
    int i = -1;
    this.log.LOG_INFO("进入updateCustomerTypeById方法.....");
    try
    {
      i = updateCustomerTypeById(str1, str2);
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
    this.log.LOG_INFO("退出updateCustomerTypeById方法...");
  }

  public int updateCustomerTypeById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_TYPE", paramString2);
    this.tradeQuery.executeBy(localCustomerExt.insBy("UPDATE_TYPE_CLASS"));
    return 0;
  }

  public void getCustListByResume(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getCustList方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("QUERY_PARAM");
    this.log.LOG_INFO("QUERY_PARAM..................." + str);
    try
    {
      if (str.equals(""))
        this.queryResult = getCustListByResume();
      else
        this.queryResult = searchCust(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getCustList方法...");
  }

  public ArrayList getCustListByResume()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList1 = localCustomerExt.selByList("SEL_BY_RESUME");
    return localArrayList1;
  }

  public ArrayList getPromotionCustList(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_PROMOTION_CUSTLIST", 0, paramInt);
    return localArrayList;
  }

  public ArrayList getCustListByCode(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VDEVELOPE_MAN", paramString);
    localArrayList1 = localCustomerExt.selByList("SEL_BY_CODE");
    return localArrayList1;
  }

  public ArrayList getCustListByDev(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VDEVELOPE_CHANNEL", paramString);
    localArrayList1 = localCustomerExt.selByList("SEL_BY_DEV");
    return localArrayList1;
  }

  public ArrayList getCustListByAll(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", "0");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    localArrayList1 = localCustomerExt.selByList("SEL_SPEC_CUST_STATE", paramInt, 30);
    return localArrayList1;
  }

  public ArrayList getCustListByLevel(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", "0");
    localArrayList = localCustomerExt.selByList("SEL_CUST_BYLEVEL", 0, paramInt);
    return localArrayList;
  }

  public int getCustListNumber()
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", "0");
    localArrayList = localCustomerExt.selByList("SEL_CUST_COUNT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("root_id").toString());
    }
    return i;
  }

  public ArrayList getCustomByStockSeach(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString.trim() + "%");
    localArrayList1 = localCustomerExt.selByList("SEL_CUST_STOCK");
    return localArrayList1;
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
      if (localHashMap.get("cust_name") != null)
        str = localHashMap.get("cust_name").toString();
    }
    return str;
  }

  public String getPhoneById(String paramString)
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
      if (localHashMap.get("group_contact_phone") != null)
        str = localHashMap.get("group_contact_phone").toString();
    }
    return str;
  }

  public ArrayList getCustListBySearch(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localCustomerExt.selByList("SEL_BY_KEYS", paramInt, 30);
    return localArrayList;
  }

  public int getCustSearch(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localCustomerExt.selByList("SEL_BY_KEYS");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getCustomerByCust_ID(int paramInt)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    CustomerExt localCustomerExt = new CustomerExt();
    ArrayList localArrayList = localCustomerExt.selByList("SEL_CUST_ID", paramInt, 20);
    return localArrayList;
  }

  public int getCustomerCountByCust()
    throws SaasApplicationException
  {
    int i = 0;
    CustomerExt localCustomerExt = new CustomerExt();
    ArrayList localArrayList = localCustomerExt.selByList("SEL_COUNT_BY_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getCustListByState(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", paramString);
    localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST_STATE", paramInt, 20);
    return localArrayList;
  }

  public int getCustListByState(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", paramString);
    localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST_STATE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public int getCustStateNumber(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUST_STATE_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getCustListByStateKey(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", paramString1);
    if (!"".equals(paramString2.trim()))
    {
      localCustomerExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
      localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST_STATE_KEY", paramInt, 20);
    }
    else if (!"".equals(paramString3.trim()))
    {
      localCustomerExt.setParam(":VCUST_CLASS", paramString3);
      localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST_STATE_TYPE", paramInt, 20);
    }
    else
    {
      localCustomerExt.setParam(":VSTART_DATE", paramString4.trim());
      localCustomerExt.setParam(":VEND_DATE", paramString5.trim());
      localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST_STATE_DATE", paramInt, 20);
    }
    return localArrayList;
  }

  public int getCustListByStateKey(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", paramString1);
    if (!"".equals(paramString2.trim()))
    {
      localCustomerExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
      localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST_STATE_KEY");
    }
    else if (!"".equals(paramString3.trim()))
    {
      localCustomerExt.setParam(":VCUST_CLASS", paramString3);
      localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST_STATE_TYPE");
    }
    else
    {
      localCustomerExt.setParam(":VSTART_DATE", paramString4.trim());
      localCustomerExt.setParam(":VEND_DATE", paramString5.trim());
      localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST_STATE_DATE");
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void customerStateMgr(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.outBuffer = paramBuffers;
    int i = -1;
    this.log.LOG_INFO("进入customerStateMgr方法.....");
    try
    {
      String str1 = paramBuffers.getString("CUST_ID");
      String str2 = paramBuffers.getString("CUST_STATE");
      i = customerStateMgr(str1, str2);
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
    this.log.LOG_INFO("退出customerStateMgr方法...");
  }

  public int customerStateMgr(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_STATE", paramString2);
    this.tradeQuery.executeBy(localCustomerExt.insBy("STATE_CHANGE"));
    return 0;
  }

  public void deleteCustByRelation(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.outBuffer = paramBuffers;
    int i = -1;
    this.log.LOG_INFO("进入deleteCustByRelation方法.....");
    try
    {
      String str1 = paramBuffers.getString("OBJ_CUST_ID");
      String str2 = paramBuffers.getString("USER_ID");
      String str3 = "2";
      i = deleteCustByRelation(str1, str2, str3);
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
    this.log.LOG_INFO("退出deleteCustByRelation方法...");
  }

  public int deleteCustByRelation(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str = new UserInfo().getUserWeb_Log(paramString2);
    if ((str == "1") || (str.equals("1")))
      return -1;
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_STATE", paramString3);
    this.tradeQuery.executeBy(localCustomerExt.insBy("STATE_CHANGE"));
    return 0;
  }

  public void updateCustinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateCustinfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("CUST_NAME");
    String str3 = paramBuffers.getString("CUST_AIM");
    String str4 = paramBuffers.getString("FAX_NBR");
    String str5 = paramBuffers.getString("GROUP_CONTACT_PHONE");
    String str6 = paramBuffers.getString("COMPANY_ADDRESS");
    String str7 = paramBuffers.getString("JURISTIC");
    String str8 = paramBuffers.getString("GROUP_MEMO");
    String str9 = paramBuffers.getString("SCOPE");
    String str10 = paramBuffers.getString("WEBSITE");
    String str11 = paramBuffers.getString("USER_COUNT");
    String str12 = paramBuffers.getString("PROVINCE");
    String str13 = paramBuffers.getString("EPARCHY_CODE");
    try
    {
      i = updateCustinfo(str1, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
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
    this.log.LOG_INFO("退出addcustinfo方法...");
  }

  public int updateCustinfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_AIM", paramString2);
    localCustomerExt.setParam(":VFAX_NBR", paramString3);
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", paramString4);
    localCustomerExt.setParam(":VCOMPANY_ADDRESS", paramString5);
    localCustomerExt.setParam(":VJURISTIC", paramString6);
    localCustomerExt.setParam(":VGROUP_MEMO", paramString7);
    localCustomerExt.setParam(":VSCOPE", paramString8);
    localCustomerExt.setParam(":VWEBSITE", paramString9);
    localCustomerExt.setParam(":VUSER_COUNT", paramString10);
    localCustomerExt.setParam(":VPROVINCE", paramString11);
    localCustomerExt.setParam(":VEPARCHY_CODE", paramString12);
    this.tradeQuery.executeBy(localCustomerExt.insBy("UPDATE_CUST_INFO"));
    return 0;
  }

  public int checkCustName(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    this.log.LOG_INFO("99999999999999999..." + paramString + "99999999999999999");
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", paramString);
    ArrayList localArrayList = localCustomerExt.selByList("SEL_BY_CHECK_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    this.log.LOG_INFO("99999999999999999..." + i + "...99999999999999999");
    return i;
  }

  public String getCustChannal(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("develope_channel") != null)
        str = localHashMap.get("develope_channel").toString();
    }
    return str;
  }

  public ArrayList getCustomerByNewsId(String paramString)
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VNEWS_ID", paramString);
    ArrayList localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_BY_NEWS_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getCustomerByCustId(String paramString)
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_BY_CUST_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public String getStepByCustId(String paramString)
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    int i = 0;
    int j = 0;
    int k = 0;
    ParamethodMgr localParamethodMgr = new ParamethodMgr();
    VerifyInfo localVerifyInfo = new VerifyInfo();
    ArrayList localArrayList = getCustomerByCustId(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localObject = (HashMap)localArrayList.get(0);
      if (((HashMap)localObject).get("cust_aim") != null)
        str2 = ((HashMap)localObject).get("cust_aim").toString();
      if (((HashMap)localObject).get("company_address") != null)
        str3 = ((HashMap)localObject).get("company_address").toString();
      if (((HashMap)localObject).get("website") != null)
        str4 = ((HashMap)localObject).get("website").toString();
    }
    str5 = localParamethodMgr.getBankAccouId(paramString);
    str6 = localVerifyInfo.getVerifyStatusByCId(paramString);
    if ((str2.equals("")) || (str3.equals("")) || (str4.equals("")))
      i = 1;
    if ((null == str6) || (!str6.equals("1")))
      j = 1;
    if (str5.equals(""))
      k = 1;
    Object localObject = new config();
    ((config)localObject).init();
    String str7 = ((config)localObject).getString("examine");
    if (str7.equals("1"))
    {
      if (i != 0)
      {
        str1 = "<td align=\"center\"><img src=\"images/button1_01.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\">\t<img style=\"cursor:hand\" src=\"images/button2_02.jpg\" border=\"0\" align=\"absbottom\" onClick=\"slectTab(1)\"/></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\"><img style=\"cursor:hand\" src=\"images/button2_03.jpg\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"left\"><img  src=\"images/button3_04.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/button_wc.jpg\" border=\"0\" align=\"absbottom\"></td>";
        return str1;
      }
      if (j != 0)
      {
        str1 = "<td align=\"center\"><img src=\"images/button1_01.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\">\t<img style=\"cursor:hand\" src=\"images/button2_02.jpg\" border=\"0\" align=\"absbottom\" onClick=\"slectTab(1)\"/></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\"><img style=\"cursor:hand\" src=\"images/button2_03.jpg\" border=\"0\" align=\"absbottom\" onClick=\"slectTab(2)\"/></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"left\"><img  src=\"images/button3_04.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/button_wc.jpg\" border=\"0\" align=\"absbottom\"></td>";
        return str1;
      }
      if ((i == 0) && (j == 0) && (k != 0))
      {
        str1 = "<td align=\"center\"><img src=\"images/button1_01.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\">\t<img  src=\"images/button1_02.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\"><img  src=\"images/button1_03.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"left\"><img style=\"cursor:hand\" src=\"images/button2_04.jpg\" border=\"0\" align=\"absbottom\" onClick=\"slectTab(3)\" /></td><td align=\"center\"><img src=\"images/button_wc.jpg\" border=\"0\" align=\"absbottom\"></td>";
        return str1;
      }
      if ((i == 0) && (j == 0) && (k == 0))
      {
        str1 = "<td align=\"center\"><img src=\"images/button1_01.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\">\t<img  src=\"images/button1_02.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\"><img  src=\"images/button1_03.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"left\"><img  src=\"images/button1_04.jpg\" border=\"0\" align=\"absbottom\"  /></td><td align=\"center\"><img src=\"images/button_wc.jpg\" border=\"0\" align=\"absbottom\"></td>";
        return str1;
      }
    }
    else
    {
      if (i != 0)
      {
        str1 = "<td align=\"center\"><img src=\"images/button1_01.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\">\t<img style=\"cursor:hand\" src=\"images/button2_02.jpg\" border=\"0\" align=\"absbottom\" onClick=\"slectTab(1)\"/></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"left\"><img  src=\"images/button3_04.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/button_wc.jpg\" border=\"0\" align=\"absbottom\"></td>";
        return str1;
      }
      if (j != 0)
      {
        str1 = "<td align=\"center\"><img src=\"images/button1_01.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\">\t<img style=\"cursor:hand\" src=\"images/button2_02.jpg\" border=\"0\" align=\"absbottom\" onClick=\"slectTab(1)\"/></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"left\"><img  src=\"images/button3_04.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/button_wc.jpg\" border=\"0\" align=\"absbottom\"></td>";
        return str1;
      }
      if ((i == 0) && (j == 0) && (k != 0))
      {
        str1 = "<td align=\"center\"><img src=\"images/button1_01.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\">\t<img  src=\"images/button1_02.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"left\"><img style=\"cursor:hand\" src=\"images/button2_04.jpg\" border=\"0\" align=\"absbottom\" onClick=\"slectTab(3)\" /></td><td align=\"center\"><img src=\"images/button_wc.jpg\" border=\"0\" align=\"absbottom\"></td>";
        return str1;
      }
      if ((i == 0) && (j == 0) && (k == 0))
      {
        str1 = "<td align=\"center\"><img src=\"images/button1_01.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"center\">\t<img  src=\"images/button1_02.jpg\" border=\"0\" align=\"absbottom\" /></td><td align=\"center\"><img src=\"images/to.gif\" border=\"0\" align=\"absbottom\"/></td><td align=\"left\"><img  src=\"images/button1_04.jpg\" border=\"0\" align=\"absbottom\"  /></td><td align=\"center\"><img src=\"images/button_wc.jpg\" border=\"0\" align=\"absbottom\"></td>";
        return str1;
      }
    }
    return (String)"";
  }

  public String getTabByCustId(String paramString)
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    int i = 0;
    int j = 0;
    int k = 0;
    ParamethodMgr localParamethodMgr = new ParamethodMgr();
    VerifyInfo localVerifyInfo = new VerifyInfo();
    ArrayList localArrayList = getCustomerByCustId(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localObject = (HashMap)localArrayList.get(0);
      if (((HashMap)localObject).get("cust_aim") != null)
        str2 = ((HashMap)localObject).get("cust_aim").toString();
      if (((HashMap)localObject).get("company_address") != null)
        str3 = ((HashMap)localObject).get("company_address").toString();
      if (((HashMap)localObject).get("website") != null)
        str4 = ((HashMap)localObject).get("website").toString();
    }
    str5 = localParamethodMgr.getBankAccouId(paramString);
    str6 = localVerifyInfo.getVerifyStatusByCId(paramString);
    this.log.LOG_INFO(localArrayList.size() + "7777" + str6 + str2 + "44444" + str3 + "55555555555" + str4 + "+++++++++++++++++++++++++");
    if ((str2.equals("")) || (str3.equals("")) || (str4.equals("")))
      i = 1;
    if ((null == str6) || (!str6.equals("1")))
      j = 1;
    if (str5.equals(""))
      k = 1;
    if (i != 0)
      return "1";
    Object localObject = new config();
    ((config)localObject).init();
    String str7 = ((config)localObject).getString("examine");
    if (str7.equals("1"))
    {
      if (j != 0)
        return "2";
    }
    else if (j != 0)
      return "3";
    if ((i == 0) && (j == 0) && (k != 0))
      return "3";
    if ((i == 0) && (j == 0) && (k == 0))
      return "4";
    return (String)"0";
  }

  public String getCustCompany(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_aim") != null)
        str = localHashMap.get("cust_aim").toString();
    }
    return str;
  }

  public ArrayList getCustDefinit(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCLASS_ID", paramString2);
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    localArrayList = localCustomerExt.selByList("SEL_CUST_DEFINIT", paramInt, 20);
    return localArrayList;
  }

  public int getCustDefinit(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCLASS_ID", paramString2);
    localArrayList = localCustomerExt.selByList("SEL_CUST_PAGE_DEFINIT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("rr").toString());
    }
    return i;
  }

  public ArrayList getCallingType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCALLINGTYPE", paramString2);
    localArrayList1 = localCustomerExt.selByList("SEL_CUST_BY_CALLINGTYPE");
    return localArrayList1;
  }

  public ArrayList getOppByClassId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCLASS_ID", paramString2);
    localCustomerExt.setParam(":VENTITY_TYPE", paramString3);
    localArrayList = localCustomerExt.selByList("SEL_OPP_BY_CLASSID");
    return localArrayList;
  }

  public ArrayList getOppJoinByClassId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCLASS_ID", paramString2);
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VENTITY_TYPE", paramString3);
    localArrayList = localCustomerExt.selByList("SEL_OPP_JOIN_BY_CLASSID");
    return localArrayList;
  }

  public int getOppByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VRELA_CLASS", paramString2);
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localArrayList = localCustomerExt.selByList("SEL_OPP_BY_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getOppByType(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VRELA_CLASS", paramString2);
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localArrayList = localCustomerExt.selByList("SEL_OPP_BY_TYPE", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getOppJoinByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VRELA_CLASS", paramString2);
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localArrayList = localCustomerExt.selByList("SEL_OPP_JOIN_BY_TYPE");
    return localArrayList;
  }

  public ArrayList getOppView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", "%" + paramString3 + "%");
    localCustomerExt.setParam(":VPROVINCE", "%" + paramString4 + "%");
    localCustomerExt.setParam(":VEPARCHY_CODE", "%" + paramString5 + "%");
    localCustomerExt.setParam(":VCITY_CODE", "%" + paramString6 + "%");
    localArrayList = localCustomerExt.selByList("SEL_OPP_VIEW", paramInt, 20);
    return localArrayList;
  }

  public int getOppView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    int i = 0;
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", "%" + paramString3 + "%");
    localCustomerExt.setParam(":VPROVINCE", "%" + paramString4 + "%");
    localCustomerExt.setParam(":VEPARCHY_CODE", "%" + paramString5 + "%");
    localCustomerExt.setParam(":VCITY_CODE", "%" + paramString6 + "%");
    localArrayList = localCustomerExt.selByList("SEL_OPP_PAGE_VIEW");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("tt").toString());
    }
    return i;
  }

  public String getAllCustList()
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    StringBuffer localStringBuffer = new StringBuffer("<option value=\"0\">请选择客户</option>");
    String str1 = "";
    String str2 = "";
    localArrayList = localCustomerExt.selByList("SEL_BY_ALL_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        str1 = localHashMap.get("cust_id").toString();
        str2 = localHashMap.get("cust_name").toString();
        localStringBuffer.append("<option value=\"" + str1 + "\">" + str2 + "</option>");
      }
    return localStringBuffer.toString();
  }

  public ArrayList getOppByDefinit(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCLASS_ID", paramString2);
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    localArrayList = localCustomerExt.selByList("SEL_OPP_DEFINIT", paramInt, 20);
    return localArrayList;
  }

  public String getAdminCustId()
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_ADMIN_ID");
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      str = localHashMap.get("cust_id").toString();
    }
    return str;
  }

  public int getOppByDefinit(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VCLASS_ID", paramString2);
    localArrayList = localCustomerExt.selByList("SEL_OPP_PAGE_DEFINIT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("rr").toString());
    }
    return i;
  }

  public ArrayList getIncludeJspByCustId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VRELATION_TYPE_CODE", paramString2);
    localArrayList = localCustomerExt.selByList("SEL_INCLUDE_JSP");
    return localArrayList;
  }

  public ArrayList getCustById()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_NEWS_CAST");
    return localArrayList;
  }

  public String getCustClassById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CLASSES_BY_CUST_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_class") != null)
        str = localHashMap.get("cust_class").toString();
    }
    return str;
  }

  public ArrayList getCustNewById(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_NEWS_CUST_NAME", paramInt1, paramInt2);
    return localArrayList;
  }

  public String gentCustNameById(String paramString)
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
      if (localHashMap.get("scope") != null)
        str = localHashMap.get("scope").toString();
    }
    return str;
  }

  public ArrayList getMaxCustByNo()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_MAX_LEVEL");
    return localArrayList;
  }

  public ArrayList getSearchCustomerInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString3.trim() + "%");
    localCustomerExt.setParam(":VPROV", "%" + paramString1.trim() + "%");
    localCustomerExt.setParam(":VCITY", "%" + paramString2.trim() + "%");
    localCustomerExt.setParam(":VGROUP_ID", paramString4);
    if ((paramString4 == "0") || (paramString4.equals("0")))
      localArrayList = localCustomerExt.selByList("SEL_BY_SEARCH_CUST", paramInt1, paramInt2);
    else
      localArrayList = localCustomerExt.selByList("SEL_BY_GROUP_CUST", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getSearchCustomerCount(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString3.trim() + "%");
    localCustomerExt.setParam(":VPROV", "%" + paramString1.trim() + "%");
    localCustomerExt.setParam(":VCITY", "%" + paramString2.trim() + "%");
    localCustomerExt.setParam(":VGROUP_ID", paramString4);
    if ((paramString4 == "0") || (paramString4.equals("0")))
      localArrayList = localCustomerExt.selByList("SEL_BY_SEARCH_CUST_CT");
    else
      localArrayList = localCustomerExt.selByList("SEL_BY_SEARCH_GROUP_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public String getCustName(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList1 = localCustomerExt.selByList("SEL_SPEC_CUST");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList1.get(0);
      if (localHashMap.get("cust_name") != null)
        str = localHashMap.get("cust_name").toString();
    }
    return str;
  }

  public String getCustClassName(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUST_CLASS_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("class_name") != null)
        str = localHashMap.get("class_name").toString();
    }
    return str;
  }

  public ArrayList getCustomerInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_INFO");
    return localArrayList;
  }

  public ArrayList getCustomerCustType(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUST_TYPE");
    return localArrayList;
  }

  public ArrayList getCustomerListByCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", paramString);
    ArrayList localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_LIST_BY_ORDER_BY", paramInt, 20);
    return localArrayList;
  }

  public int getCustomerListByCust(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", paramString);
    ArrayList localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_LIST_BY_ORDER_BY_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getCustomerListLikeCust(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", paramString1);
    localCustomerExt.setParam(":VKEY", "%" + paramString2 + "%");
    ArrayList localArrayList = localCustomerExt.selByList("SEL_CUST_LIST_LIKE_ORDER_BY", paramInt, 20);
    return localArrayList;
  }

  public int getCustomerListLikeCust(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", paramString1);
    localCustomerExt.setParam(":VKEY", "%" + paramString2 + "%");
    ArrayList localArrayList = localCustomerExt.selByList("SEL_CUST_LIST_LIKE_ORDER_BY_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getAllCustOrderClass(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_ALL_BY_CLASS", paramInt1, paramInt2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getListByNamePage(String paramString, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VNAME", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUSTOMER_LIST_BY_NAME", paramInt1, paramInt2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public int getAllCustOrderClass()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_ALL_BY_CLASS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getOneCustAndClass(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_ONE_BY_CLASS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getOneCustAndClassById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_ONE_BY_CUST_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getCommendCustAndClass(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_CUST_BY_CMEND_TYPE", paramInt1, paramInt2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public int getCommendCustAndClass()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_CUST_BY_CMEND_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void CustStateDelete(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("CUST_ID");
    int i = -1;
    this.log.LOG_INFO("进入CustStateLogout方法.....");
    try
    {
      i = CustStateDelete(str);
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
    this.log.LOG_INFO("退出CustStateLogout方法...");
  }

  public void DeleteCustInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = CustStateDelete(str2);
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

  public int CustStateDelete(String paramString)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    this.tradeQuery.executeBy(localCustomerExt.insBy("STATE_DELETE_CUSTOMER"));
    return 0;
  }

  public ArrayList getOneCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList = localCustomerExt.selByList("SELECT_CUSTOMER_NUMBER", paramInt, 20);
    return localArrayList;
  }

  public int getOneCust(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList = localCustomerExt.selByList("SELECT_CUSTOMER_NUMBER");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getOneCustD(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList = localCustomerExt.selByList("SELECT_CUSTOMER_NUMBER_D", paramInt, 30);
    return localArrayList;
  }

  public int getOneCustD(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList = localCustomerExt.selByList("SELECT_CUSTOMER_NUMBER_D");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getOneCustJD(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList = localCustomerExt.selByList("SELECT_CUSTOMER_NUMBER_JD", paramInt, 30);
    return localArrayList;
  }

  public int getOneCustJD(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList = localCustomerExt.selByList("SELECT_CUSTOMER_NUMBER_JD");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getOneCustDel(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList = localCustomerExt.selByList("SELECT_CUSTOMER_NUMBER_DEL", paramInt, 30);
    return localArrayList;
  }

  public int getOneCustDel(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_NAME", "%" + paramString + "%");
    localArrayList = localCustomerExt.selByList("SELECT_CUSTOMER_NUMBER_DEL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getCustInfoByTypeCityPro(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VGROUP_ID", paramString1);
    localCustomerExt.setParam(":VCITY", paramString2);
    localCustomerExt.setParam(":VPROV", paramString3);
    localArrayList = localCustomerExt.selByList("SEL_CUST_BYTYPECITYPRO", paramInt, 20);
    return localArrayList;
  }

  public int getCustInfoByTypeCityPro(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VGROUP_ID", paramString1);
    localCustomerExt.setParam(":VCITY", paramString2);
    localCustomerExt.setParam(":VPROV", paramString3);
    localArrayList = localCustomerExt.selByList("SEL_CUST_BYTYPECITYPRO");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public String getCustTypeById(String paramString)
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
      if (localHashMap.get("cust_type") != null)
        str = localHashMap.get("cust_type").toString();
    }
    return str;
  }

  public ArrayList getCustInfoLinkInfoList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList1 = localCustomerExt.selByList("SEL_CUST_BY_LINK_LIST");
    return localArrayList1;
  }

  public void updateCustEmail(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateCustEmail方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CUST_ID");
      String str2 = paramBuffers.getString("EMAIL");
      i = updateCustEmail(str1, str2);
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
    this.log.LOG_INFO("退出updateCustEmail方法...");
  }

  public int updateCustEmail(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString1);
    localCustomerExt.setParam(":VEMAIL", paramString2);
    this.tradeQuery.executeBy(localCustomerExt.insBy("UPDATE_CUST_EMAIL"));
    return 0;
  }

  public ArrayList getCustInfoLinkInfoMap(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList1 = localCustomerExt.selByList("SEL_CUST_BY_LINK_LIST_FOR_DWR");
    return localArrayList1;
  }

  public ArrayList GetYearAndArea(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    if (paramInt == 1)
      localArrayList1 = localCustomerExt.selByList("SEL_CUST_FOR_ONE_MONTH");
    if (paramInt == 2)
      localArrayList1 = localCustomerExt.selByList("SEL_CUST_FOR_TWO_MONTH");
    if (paramInt == 3)
      localArrayList1 = localCustomerExt.selByList("SEL_CUST_FOR_HALF_YEAR");
    if (paramInt == 4)
      localArrayList1 = localCustomerExt.selByList("SEL_CUST_FOR_ONE_YEAR");
    return localArrayList1;
  }

  public ArrayList getCustStateByUser(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VSTATE_CODE", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUST_LIST_USER_ORDER_BY", paramInt, 20);
    return localArrayList;
  }

  public int getCustStateByUserCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VSTATE_CODE", paramString);
    localArrayList = localCustomerExt.selByList("SEL_CUST_COUNT_USER_ORDER_BY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.custMgr.Custinfo
 * JD-Core Version:    0.6.0
 */