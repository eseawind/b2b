package com.saas.biz.indexMgr;

import com.buildhtml.Config;
import com.saas.biz.commen.MD5;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.custDAO.CustLevelDAO;
import com.saas.biz.dao.custDAO.CustLevelExt;
import com.saas.biz.dao.custDAO.CustomerDAO;
import com.saas.biz.dao.custDAO.CustomerExt;
import com.saas.biz.dao.userDAO.UserDAO;
import com.saas.biz.dao.userDAO.UserExt;
import com.saas.biz.dao.userdetailDAO.UserdetailDAO;
import com.saas.biz.dao.userdetailDAO.UserdetailExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class IndexInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
  Config config = new Config();
  private String regemail = this.config.regemail;
  private String examine = this.config.examine;
  commMethodMgr commen = new commMethodMgr();
  ArrayList queryResult = new ArrayList();
  String fbtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

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

  public void addCustinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCustinfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SCOPE");
    String str2 = paramBuffers.getString("CLASS_ID");
    String str3 = "";
    String str4 = paramBuffers.getString("CITY");
    if ((str4 == "请选择") || (str4.equals("请选择")))
      str4 = "";
    String str5 = paramBuffers.getString("CUST_AIM");
    String str6 = paramBuffers.getString("GROUP_MEMO");
    String str7 = paramBuffers.getString("CALLING_TYPE_CODE");
    String str8 = paramBuffers.getString("EMAIL");
    String str9 = paramBuffers.getString("COMPANY_ADDRESS");
    String str10 = paramBuffers.getString("CUST_NAME");
    String str11 = paramBuffers.getString("EPARCHY_CODE");
    if ((str11 == "请选择..") || (str11.equals("请选择..")))
      str11 = "";
    String str12 = paramBuffers.getString("FAX_NBR");
    String str13 = paramBuffers.getString("GROUP_CONTACT_PHONE");
    String str14 = paramBuffers.getString("JURISTIC");
    String str15 = paramBuffers.getString("PSPT_ADDR");
    String str16 = paramBuffers.getString("PSPT_ID");
    String str17 = paramBuffers.getString("PSPT_TYPE_CODE");
    String str18 = paramBuffers.getString("USER_COUNT");
    String str19 = paramBuffers.getString("WEBSITE");
    String str20 = paramBuffers.getString("DEVELOPE_CHANNEL");
    String str21 = paramBuffers.getString("PROVINCE");
    if ((str21 == "请选择..") || (str21.equals("请选择..")))
      str21 = "";
    CustomerDAO localCustomerDAO = new CustomerDAO();
    localCustomerDAO.setScope(str1);
    localCustomerDAO.setCity(str4);
    localCustomerDAO.setCust_aim(str5);
    localCustomerDAO.setGroup_memo(str6);
    localCustomerDAO.setCalling_type_code(str7);
    localCustomerDAO.setCompany_address(str9);
    localCustomerDAO.setCust_name(str10);
    localCustomerDAO.setEparchy_code(str11);
    localCustomerDAO.setFax_nbr(str12);
    localCustomerDAO.setGroup_contact_phone(str13);
    localCustomerDAO.setJuristic(str14);
    localCustomerDAO.setPspt_addr(str15);
    localCustomerDAO.setPspt_id(str16);
    localCustomerDAO.setPspt_type_code(str17);
    localCustomerDAO.setUser_count(str18);
    localCustomerDAO.setWebsite(str19);
    localCustomerDAO.setDevelope_channel(str20);
    localCustomerDAO.setProvince(str21);
    localCustomerDAO.setEmail(str8);
    localCustomerDAO.setClass_id(str2);
    try
    {
      i = addCustinfo(localCustomerDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "9业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addCustinfo方法...");
  }

  public void addCustinfoWeb(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCustinfo方法...");
    int i = -1;
    String str1 = paramBuffers.getStringWeb("SCOPE");
    String str2 = "";
    String str3 = paramBuffers.getStringWeb("CITY");
    if ((str3 == "请选择..") || (str3.equals("请选择..")))
      str3 = "";
    String str4 = paramBuffers.getStringWeb("CUST_AIM");
    String str5 = paramBuffers.getStringWeb("GROUP_MEMO");
    String str6 = paramBuffers.getStringWeb("CALLING_TYPE_CODE");
    String str7 = paramBuffers.getStringWeb("EMAIL");
    String str8 = paramBuffers.getStringWeb("COMPANY_ADDRESS");
    String str9 = paramBuffers.getStringWeb("CUST_NAME");
    String str10 = paramBuffers.getStringWeb("EPARCHY_CODE");
    if ((str10 == "请选择..") || (str10.equals("请选择..")))
      str10 = "";
    String str11 = paramBuffers.getStringWeb("FAX_NBR");
    String str12 = paramBuffers.getStringWeb("GROUP_CONTACT_PHONE");
    String str13 = paramBuffers.getStringWeb("JURISTIC");
    String str14 = paramBuffers.getStringWeb("PSPT_ADDR");
    String str15 = paramBuffers.getStringWeb("PSPT_ID");
    String str16 = paramBuffers.getStringWeb("PSPT_TYPE_CODE");
    String str17 = paramBuffers.getStringWeb("USER_COUNT");
    String str18 = paramBuffers.getStringWeb("WEBSITE");
    String str19 = paramBuffers.getStringWeb("DEVELOPE_CHANNEL");
    String str20 = paramBuffers.getStringWeb("PROVINCE");
    if ((str20 == "请选择..") || (str20.equals("请选择..")))
      str20 = "";
    try
    {
      CustomerDAO localCustomerDAO = new CustomerDAO();
      localCustomerDAO.setScope(str1);
      localCustomerDAO.setCity(str3);
      localCustomerDAO.setCust_aim(str4);
      localCustomerDAO.setGroup_memo(str5);
      localCustomerDAO.setCalling_type_code(str6);
      localCustomerDAO.setCompany_address(str8);
      localCustomerDAO.setCust_name(str9);
      localCustomerDAO.setEparchy_code(str10);
      localCustomerDAO.setFax_nbr(str11);
      localCustomerDAO.setGroup_contact_phone(str12);
      localCustomerDAO.setJuristic(str13);
      localCustomerDAO.setPspt_addr(str14);
      localCustomerDAO.setPspt_id(str15);
      localCustomerDAO.setPspt_type_code(str16);
      localCustomerDAO.setUser_count(str17);
      localCustomerDAO.setWebsite(str18);
      localCustomerDAO.setDevelope_channel(str19);
      localCustomerDAO.setProvince(str20);
      localCustomerDAO.setEmail(str7);
      i = addCustinfo(localCustomerDAO);
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
    this.log.LOG_INFO("退出addCustinfo方法...");
  }

  public int addCustinfo(CustomerDAO paramCustomerDAO)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str1 = "0";
    String str2 = localcommMethodMgr.GenTradeId();
    String str3 = localcommMethodMgr.GenShortTradeId();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_STATE", str1);
    localCustomerExt.setParam(":VCUST_ID", str2);
    localCustomerExt.setParam(":VCLASS_ID", paramCustomerDAO.getClass_id());
    localCustomerExt.setParam(":VSCOPE", paramCustomerDAO.getScope());
    localCustomerExt.setParam(":VCUST_AIM", paramCustomerDAO.getCust_aim());
    localCustomerExt.setParam(":VGROUP_MEMO", paramCustomerDAO.getGroup_memo());
    localCustomerExt.setParam(":VCALLING_TYPE_CODE", paramCustomerDAO.getCalling_type_code());
    localCustomerExt.setParam(":VCOMPANY_ADDRESS", paramCustomerDAO.getCompany_address());
    localCustomerExt.setParam(":VCUST_NAME", paramCustomerDAO.getCust_name());
    localCustomerExt.setParam(":VEPARCHY_CODE", paramCustomerDAO.getEparchy_code());
    localCustomerExt.setParam(":VFAX_NBR", paramCustomerDAO.getFax_nbr());
    localCustomerExt.setParam(":VGROUP_CONTACT_PHONE", paramCustomerDAO.getGroup_contact_phone());
    localCustomerExt.setParam(":VJURISTIC", paramCustomerDAO.getJuristic());
    localCustomerExt.setParam(":VCITY", paramCustomerDAO.getCity());
    localCustomerExt.setParam(":VCITY_CODE", paramCustomerDAO.getCity());
    localCustomerExt.setParam(":VPSPT_ADDR", paramCustomerDAO.getPspt_addr());
    localCustomerExt.setParam(":VPSPT_ID", paramCustomerDAO.getPspt_id());
    localCustomerExt.setParam(":VPSPT_TYPE_CODE", paramCustomerDAO.getPspt_type_code());
    localCustomerExt.setParam(":VUSER_COUNT", paramCustomerDAO.getUser_count());
    localCustomerExt.setParam(":VWEBSITE", paramCustomerDAO.getWebsite());
    localCustomerExt.setParam(":VDEVELOPE_CHANNEL", paramCustomerDAO.getDevelope_channel());
    localCustomerExt.setParam(":VDEVELOPE_MAN", "");
    localCustomerExt.setParam(":VPOST_CODE", "");
    localCustomerExt.setParam(":VPROVINCE", paramCustomerDAO.getProvince());
    localCustomerExt.setParam(":VEMAIL", paramCustomerDAO.getEmail());
    this.tradeQuery.executeBy(localCustomerExt.insBy("INS_BY_REGISTER"));
    this.outBuffer.setString("CUST_ID", str2);
    this.outBuffer.setString("ROOT_ID", str2);
    this.outBuffer.setString("WEB_ID", "1111111111");
    return 0;
  }

  public void addUserInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入setUserInfo方法...");
    int i = -1;
    try
    {
      UserDAO localUserDAO = new UserDAO();
      localUserDAO.setCust_id(paramBuffers.getString("CUST_ID"));
      if (paramBuffers.getString("USER_NAME").equals("autoCreatebySystem"))
      {
        String str1 = this.commen.GenShortTradeId();
        String str2 = this.commen.GenShortTradeId();
        localUserDAO.setUser_name(str1);
        localUserDAO.setPasswd(str2);
        this.outBuffer.setString("USER_NAME", str1);
        this.outBuffer.setString("PASSWD", str2);
      }
      else
      {
        localUserDAO.setUser_name(paramBuffers.getString("USER_NAME"));
        localUserDAO.setPasswd(paramBuffers.getString("PASSWD"));
      }
      localUserDAO.setPasswd_ques(paramBuffers.getString("PASSWD_QUES"));
      localUserDAO.setUser_type(paramBuffers.isFieldExist("USER_TYPE") ? paramBuffers.getString("USER_TYPE") : "1");
      localUserDAO.setPasswd_answer(paramBuffers.getString("PASSWD_ANSWER"));
      i = addUserInfo(localUserDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "333333333业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出setUserInfo方法...");
  }

  public int addUserInfo(UserDAO paramUserDAO)
    throws SaasApplicationException
  {
    String str1 = "1";
    String str2 = "3";
    if ((this.regemail.equals("1")) && (this.examine.equals("1")))
    {
      str1 = "0";
      str2 = "0";
    }
    if ((this.regemail.equals("0")) && (this.examine.equals("0")))
    {
      str1 = "1";
      str2 = "0";
    }
    if ((this.regemail.equals("1")) && (this.examine.equals("0")))
    {
      str1 = "0";
      str2 = "0";
    }
    if ((this.regemail.equals("0")) && (this.examine.equals("1")))
    {
      str1 = "1";
      str2 = "3";
    }
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str3 = localcommMethodMgr.GenTradeId();
    String str4 = "";
    String str5 = "";
    str4 = paramUserDAO.getPasswd();
    MD5 localMD5 = new MD5();
    str5 = localMD5.getMD5(str4.getBytes());
    String str6 = localcommMethodMgr.GenShortTradeId();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_STATE", str2);
    localUserExt.setParam(":VUSER_ID", str3);
    localUserExt.setParam(":VCUST_ID", paramUserDAO.getCust_id());
    localUserExt.setParam(":VUSER_NAME", paramUserDAO.getUser_name());
    localUserExt.setParam(":VPASSWD", str5);
    localUserExt.setParam(":VPASSWD_QUES", paramUserDAO.getPasswd_ques());
    localUserExt.setParam(":VPASSWD_ANSWER", paramUserDAO.getPasswd_answer());
    localUserExt.setParam(":VDEPART_CODE", paramUserDAO.getCust_id());
    localUserExt.setParam(":VWEB_LOGIN_TAG", str1);
    localUserExt.setParam(":VUSER_TYPE", paramUserDAO.getUser_type());
    localUserExt.setParam(":VRSRV_STR2", str6);
    this.tradeQuery.executeBy(localUserExt.insBy("INS_BY_REGISTER"));
    this.outBuffer.setString("USER_ID", str3);
    this.outBuffer.setString("RSRV_STR2", str6);
    return 0;
  }

  public void addUserDetailInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addUserDetailInfo方法...");
    int i = -1;
    try
    {
      String str = paramBuffers.getString("BIRTHDAY");
      if ((str == null) || (str.equals("")))
        str = this.fbtime;
      UserdetailDAO localUserdetailDAO = new UserdetailDAO();
      localUserdetailDAO.setCust_id(paramBuffers.getString("CUST_ID"));
      localUserdetailDAO.setUser_id(paramBuffers.getString("USER_ID"));
      localUserdetailDAO.setCust_name(paramBuffers.getString("CUST_NAME"));
      localUserdetailDAO.setSex(paramBuffers.getString("SEX"));
      localUserdetailDAO.setPspt_addr(paramBuffers.getString("PSPT_ADDR"));
      localUserdetailDAO.setPspt_id(paramBuffers.getString("PSPT_ID"));
      localUserdetailDAO.setPspt_type_code(paramBuffers.getString("PSPT_TYPE_CODE"));
      localUserdetailDAO.setBirthday(str);
      localUserdetailDAO.setFolk_code(paramBuffers.getString("FOLK_CODE"));
      localUserdetailDAO.setQq(paramBuffers.getString("QQ"));
      localUserdetailDAO.setBlog(paramBuffers.getString("BLOG"));
      localUserdetailDAO.setEmail(paramBuffers.getString("EMAIL"));
      localUserdetailDAO.setPost_addr(paramBuffers.getString("POST_ADDR"));
      localUserdetailDAO.setHome_addr(paramBuffers.getString("HOME_ADDR"));
      localUserdetailDAO.setWork_name(paramBuffers.getString("WORK_NAME"));
      localUserdetailDAO.setWork_depart(paramBuffers.getString("WORK_DEPART"));
      localUserdetailDAO.setJob(paramBuffers.getString("JOB"));
      localUserdetailDAO.setEducate_degree_code(paramBuffers.getString("EDUCATE_DEGREE_CODE"));
      localUserdetailDAO.setMarriage(paramBuffers.getString("MARRIAGE"));
      localUserdetailDAO.setContact_phone(paramBuffers.getString("GROUP_CONTACT_PHONE"));
      i = addUserDetailInfo(localUserdetailDAO);
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
    this.log.LOG_INFO("退出addUserDetailInfo方法...");
  }

  public int addUserDetailInfo(UserdetailDAO paramUserdetailDAO)
    throws SaasApplicationException
  {
    UserdetailExt localUserdetailExt = new UserdetailExt();
    localUserdetailExt.setParam(":VCUST_ID", paramUserdetailDAO.getCust_id());
    localUserdetailExt.setParam(":VUSER_ID", paramUserdetailDAO.getUser_id());
    localUserdetailExt.setParam(":VPSPT_TYPE_CODE", paramUserdetailDAO.getPspt_type_code());
    localUserdetailExt.setParam(":VCUST_NAME", paramUserdetailDAO.getCust_name());
    localUserdetailExt.setParam(":VSEX", paramUserdetailDAO.getSex());
    localUserdetailExt.setParam(":VBIRTHDAY", paramUserdetailDAO.getBirthday());
    localUserdetailExt.setParam(":VFOLK_CODE", paramUserdetailDAO.getFolk_code());
    localUserdetailExt.setParam(":VPSPT_ADDR", paramUserdetailDAO.getPspt_addr());
    localUserdetailExt.setParam(":VPSPT_ID", paramUserdetailDAO.getPspt_id());
    localUserdetailExt.setParam(":VPOST_ADDR", paramUserdetailDAO.getPost_addr());
    localUserdetailExt.setParam(":VQQ", paramUserdetailDAO.getQq());
    localUserdetailExt.setParam(":VBLOG", paramUserdetailDAO.getBlog());
    localUserdetailExt.setParam(":VEMAIL", paramUserdetailDAO.getEmail());
    localUserdetailExt.setParam(":VHOME_ADDR", paramUserdetailDAO.getHome_addr());
    localUserdetailExt.setParam(":VWORK_NAME", paramUserdetailDAO.getWork_name());
    localUserdetailExt.setParam(":VWORK_DEPART", paramUserdetailDAO.getWork_depart());
    localUserdetailExt.setParam(":VJOB", paramUserdetailDAO.getJob());
    localUserdetailExt.setParam(":VEDUCATE_DEGREE_CODE", paramUserdetailDAO.getEducate_degree_code());
    localUserdetailExt.setParam(":VMARRIAGE", paramUserdetailDAO.getMarriage());
    localUserdetailExt.setParam(":VCONTACT_PHONE", paramUserdetailDAO.getContact_phone());
    this.tradeQuery.executeBy(localUserdetailExt.insBy("INS_BY_REGISTER"));
    return 0;
  }

  public void addcust_levelInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addcust_levelInfo方法...");
    int i = -1;
    try
    {
      CustLevelDAO localCustLevelDAO = new CustLevelDAO();
      localCustLevelDAO.setCust_id(paramBuffers.getString("CUST_ID"));
      localCustLevelDAO.setCust_class(paramBuffers.getString("CUST_CLASS"));
      localCustLevelDAO.setCust_desc("新客户");
      localCustLevelDAO.setCust_oper_person(paramBuffers.getString("USER_ID"));
      i = addcust_levelInfo(localCustLevelDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "3业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addcust_levelInfo方法...");
  }

  public int addcust_levelInfo(CustLevelDAO paramCustLevelDAO)
    throws SaasApplicationException
  {
    CustLevelExt localCustLevelExt = new CustLevelExt();
    localCustLevelExt.setParam(":VCUST_ID", paramCustLevelDAO.getCust_id());
    localCustLevelExt.setParam(":VCUST_DESC", paramCustLevelDAO.getCust_desc());
    localCustLevelExt.setParam(":VCUST_CLASS", paramCustLevelDAO.getCust_class());
    localCustLevelExt.setParam(":VCUST_OPER_PERSON", paramCustLevelDAO.getCust_oper_person());
    this.log.LOG_INFO("SQL===" + localCustLevelExt.insBy("INS_BY_REGISTER"));
    this.tradeQuery.executeBy(localCustLevelExt.insBy("INS_BY_CUST_ID"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.indexMgr.IndexInfo
 * JD-Core Version:    0.6.0
 */