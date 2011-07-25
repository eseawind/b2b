package com.saas.biz.userMgr;

import com.buildhtml.Config;
import com.saas.biz.commen.MD5;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.userDAO.UserDAO;
import com.saas.biz.dao.userDAO.UserExt;
import com.saas.biz.dao.userdetailDAO.UserdetailExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserInfo
{
  Logger log = new Logger(this);
  Config config = new Config();
  Buffers inBuffer;
  Buffers outBuffer;
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr commen = new commMethodMgr();
  private String regemail = this.config.regemail;
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

  public void addUserInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addUserInfo方法...");
    int i = -1;
    try
    {
      UserDAO localUserDAO = new UserDAO();
      localUserDAO.setPasswd(paramBuffers.getString("PASSWD"));
      localUserDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
      localUserDAO.setStaff_id(paramBuffers.getString("SESSION_USER_ID"));
      localUserDAO.setEparchy_code(paramBuffers.getString("EPARCHY_CODE"));
      localUserDAO.setCity_code(paramBuffers.getString("CITY_CODE"));
      localUserDAO.setDepart_code(paramBuffers.getString("DEPART_CODE"));
      localUserDAO.setPasswd_ques(paramBuffers.getString("PASSWD_QUES"));
      localUserDAO.setPasswd_answer(paramBuffers.getString("PASSWD_ANSWER"));
      localUserDAO.setWeb_login_tag(paramBuffers.getString("WEB_LOGIN_TAG"));
      localUserDAO.setDepart_code(paramBuffers.getString("DEPART_CODE"));
      localUserDAO.setUser_id(paramBuffers.getString("USER_ID"));
      localUserDAO.setUser_name(paramBuffers.getString("USER_NAME"));
      i = addUserInfo(localUserDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增用户业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增用户业务处理成功！");
    }
    this.log.LOG_INFO("退出addUserInfo方法...");
  }

  public int addUserInfo(UserDAO paramUserDAO)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VPASSWD", paramUserDAO.getPasswd());
    localUserExt.setParam(":VCUST_ID", paramUserDAO.getCust_id());
    localUserExt.setParam(":VEPARCHY_CODE", paramUserDAO.getEparchy_code());
    localUserExt.setParam(":VCITY_CODE", paramUserDAO.getCity_code());
    localUserExt.setParam(":VDEPART_CODE", paramUserDAO.getDepart_code());
    localUserExt.setParam(":VPASSWD_QUES", paramUserDAO.getPasswd_ques());
    localUserExt.setParam(":VPASSWD_ANSWER", paramUserDAO.getPasswd_answer());
    localUserExt.setParam(":VWEB_LOGIN_TAG", "1");
    localUserExt.setParam(":VDEPART_CODE", paramUserDAO.getDepart_code());
    localUserExt.setParam(":VUSER_ID", paramUserDAO.getUser_id());
    localUserExt.setParam(":VUSER_STATE", "0");
    localUserExt.setParam(":VSTAFF_ID", paramUserDAO.getStaff_id());
    localUserExt.setParam(":VUSER_NAME", paramUserDAO.getUser_name());
    this.tradeQuery.executeBy(localUserExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("USER_ID", paramUserDAO.getUser_id());
    this.outBuffer.setString("USER_NAME", paramUserDAO.getUser_name());
    this.log.LOG_INFO(" addUserInfo successful !");
    return 0;
  }

  public void addNewUserInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addNewUserInfo方法...");
    int i = -1;
    try
    {
      UserDAO localUserDAO = new UserDAO();
      localUserDAO.setPasswd(paramBuffers.getString("PASSWD"));
      localUserDAO.setRsrv_str1(paramBuffers.getString("PROVINCE"));
      localUserDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
      localUserDAO.setStaff_id(paramBuffers.getString("SESSION_USER_ID"));
      localUserDAO.setEparchy_code(paramBuffers.getString("EPARCHY_CODE"));
      localUserDAO.setCity_code(paramBuffers.getString("CITY_CODE"));
      localUserDAO.setDepart_code(paramBuffers.getString("ORG_DEPART_CODE"));
      localUserDAO.setPasswd_ques(paramBuffers.getString("PASSWD_QUES"));
      localUserDAO.setPasswd_answer(paramBuffers.getString("PASSWD_ANSWER"));
      localUserDAO.setWeb_login_tag(paramBuffers.getString("WEB_LOGIN_TAG"));
      localUserDAO.setUser_id(paramBuffers.getString("USER_ID"));
      localUserDAO.setUser_name(paramBuffers.getString("USER_NAME"));
      localUserDAO.setRsrv_str3(paramBuffers.getString("ROLE_CODE"));
      this.log.LOG_INFO("<<<<<<<<<<<<<<<<<<<<<<中国人中国人中国工人>>>>>>>>>>" + paramBuffers.getString("ROLE_CODE"));
      i = addNewUserInfo(localUserDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增用户业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增用户业务处理成功！");
    }
    this.log.LOG_INFO("退出addNewUserInfo方法...");
  }

  public int addNewUserInfo(UserDAO paramUserDAO)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    String str1 = "";
    String str2 = "";
    str1 = paramUserDAO.getPasswd();
    MD5 localMD5 = new MD5();
    str2 = localMD5.getMD5(str1.getBytes());
    localUserExt.setParam(":VPASSWD", str2);
    localUserExt.setParam(":VPROVINCE", paramUserDAO.getRsrv_str1());
    localUserExt.setParam(":VCUST_ID", paramUserDAO.getCust_id());
    localUserExt.setParam(":VEPARCHY_CODE", paramUserDAO.getEparchy_code());
    localUserExt.setParam(":VCITY", paramUserDAO.getCity_code());
    localUserExt.setParam(":VPASSWD_QUES", paramUserDAO.getPasswd_ques());
    localUserExt.setParam(":VPASSWD_ANSWER", paramUserDAO.getPasswd_answer());
    localUserExt.setParam(":VWEB_LOGIN_TAG", paramUserDAO.getWeb_login_tag());
    localUserExt.setParam(":VDEPART_CODE", paramUserDAO.getDepart_code());
    localUserExt.setParam(":VUSER_ID", paramUserDAO.getUser_id());
    localUserExt.setParam(":VUSER_STATE", "0");
    localUserExt.setParam(":VSTAFF_ID", paramUserDAO.getStaff_id());
    localUserExt.setParam(":VUSER_NAME", paramUserDAO.getUser_name());
    System.out.println("*****************************///////////////////////" + paramUserDAO.getUser_name() + "*********");
    localUserExt.setParam(":VRSRV_STR3", paramUserDAO.getRsrv_str3());
    this.tradeQuery.executeBy(localUserExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("USER_ID", paramUserDAO.getUser_id());
    this.outBuffer.setString("USER_NAME", paramUserDAO.getUser_name());
    this.log.LOG_INFO(" addUserInfo successful !");
    return 0;
  }

  public String getUserState(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_NAME_BY_IDS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("user_state") != null)
        str = localHashMap.get("user_state").toString();
    }
    return str;
  }

  public String getUserWebLoginTag(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_NAME_BY_IDS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("web_login_tag") != null)
        str = localHashMap.get("web_login_tag").toString();
    }
    return str;
  }

  public void genUserInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getCustInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("QUERY_PARAM");
    try
    {
      this.log.LOG_INFO("query_param.............." + str);
      if (str.equals(""))
        this.queryResult = genUserInfo();
      else
        this.queryResult = searchUser(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getCustInfo方法...");
  }

  public ArrayList genUserInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localArrayList = localUserExt.selByList("SEL_BY_ALL");
    return localArrayList;
  }

  public void genNoFreeUserInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genNoFreeUserInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str.equals(""))
        this.queryResult = genNoFreeUserInfo();
      else
        this.queryResult = searchUser(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getCustInfo方法...");
  }

  public ArrayList genNoFreeUserInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_STATE", "0");
    localArrayList = localUserExt.selByList("SEL_BY_NOFREE");
    return localArrayList;
  }

  public void genOneUserInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genOneUserInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("USER_ID");
    try
    {
      this.queryResult = genOneUserInfo(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneUserInfo方法...");
  }

  public ArrayList genOneUserInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_ONE");
    return localArrayList;
  }

  public ArrayList getCustName(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_USERID_FOR_CUST_NAME");
    return localArrayList;
  }

  public void updateOneUserInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateOneUserInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      UserDAO localUserDAO = new UserDAO();
      localUserDAO.setRsrv_str4(paramBuffers.getString("PROVINCE"));
      localUserDAO.setEparchy_code(paramBuffers.getString("EPARCHY_CODE"));
      localUserDAO.setCity_code(paramBuffers.getString("CITY_CODE"));
      localUserDAO.setDepart_code(paramBuffers.getString("ORG_DEPART_CODE"));
      localUserDAO.setPasswd_ques(paramBuffers.getString("PASSWD_QUES"));
      localUserDAO.setPasswd_answer(paramBuffers.getString("PASSWD_ANSWER"));
      localUserDAO.setUser_id(paramBuffers.getString("USER_ID"));
      i = updateOneUserInfo(localUserDAO);
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
  }

  public int updateOneUserInfo(UserDAO paramUserDAO)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramUserDAO.getUser_id());
    localUserExt.setParam(":VPROVINCE", paramUserDAO.getRsrv_str4());
    localUserExt.setParam(":VEPARCHY_CODE", paramUserDAO.getEparchy_code());
    localUserExt.setParam(":VCITY_CODE", paramUserDAO.getCity_code());
    localUserExt.setParam(":VDEPART_CODE", paramUserDAO.getDepart_code());
    localUserExt.setParam(":VPASSWD_QUES", paramUserDAO.getPasswd_ques());
    localUserExt.setParam(":VPASSWD_ANSWER", paramUserDAO.getPasswd_answer());
    this.tradeQuery.executeBy(localUserExt.insBy("UPDATE_BY_ONE"));
    return 0;
  }

  public void invalidOneUserInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateOneUserInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("USER_ID");
    String str2 = paramBuffers.getString("USER_STATE");
    try
    {
      i = invaildOneUserInfo(str1, str2);
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
  }

  public int invaildOneUserInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString1);
    localUserExt.setParam(":VUSER_STATE", paramString2);
    this.tradeQuery.executeBy(localUserExt.insBy("INVALID_BY_ONE"));
    return 0;
  }

  public void UserInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteUserInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("USER_ID");
    String str2 = paramBuffers.getString("USER_STATE");
    this.log.LOG_INFO("退出DeleteUserInfo方法..." + str1);
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str3 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str3 = localStringTokenizer.nextToken();
        i = invaildOneUserInfo(str3, str2);
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
    this.log.LOG_INFO("退出DeleteUserInfo方法...");
  }

  public ArrayList searchUser(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_NAME", "%" + paramString + "%");
    localArrayList = localUserExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public ArrayList getForCustByID(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_ID_FOR_CUST");
    return localArrayList;
  }

  public void getUserinfoByCust_id(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入getUserinfoByCust_id方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_NAME");
    try
    {
      if ((str2 == "admin") || (str2.equals("admin")))
        this.queryResult = genUserInfo();
      else
        this.queryResult = getUserinfoByCust_id(str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getUserinfoByCust_id方法...");
  }

  public ArrayList getUserinfoByCust_id(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString);
    localUserExt.setParam(":VUSER_STATE", "0");
    localArrayList = localUserExt.selByList("SEL_BY_CUST_ID");
    return localArrayList;
  }

  public ArrayList getUserinfoByCust_id(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString);
    localUserExt.setParam(":VUSER_STATE", "0");
    localArrayList = localUserExt.selByList("SEL_BY_CUST_ID", paramInt, 20);
    return localArrayList;
  }

  public Map getUserByCustId(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString);
    localUserExt.setParam(":VUSER_STATE", "0");
    ArrayList localArrayList = localUserExt.selByList("SEL_CUST_BY_IDX");
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

  public ArrayList getUserListByCust(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString1);
    localUserExt.setParam(":VUSER_STATE", paramString2);
    localArrayList = localUserExt.selByList("SEL_BY_CUST_ID", paramInt, 30);
    return localArrayList;
  }

  public int getUserNumber(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString1);
    localUserExt.setParam(":VUSER_STATE", paramString2);
    localArrayList = localUserExt.selByList("SEL_BY_CUST_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getUserListByUserState(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_STATE", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_USER_STATE_ORDER", paramInt, 30);
    return localArrayList;
  }

  public int getUserListByUserState(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_STATE", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_USER_STATE_ORDER");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getUserInfoByUserId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_DETAL_BY_ID");
    return localArrayList;
  }

  public ArrayList getcomName(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_DETAL_BY_USER_NAME");
    return localArrayList;
  }

  public ArrayList getcomNamebyId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_DETAL_BY_USER_ID");
    return localArrayList;
  }

  public String getUserNameById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_DETAL_BY_ID");
    String str = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localHashMap = (HashMap)localArrayList.get(0);
      str = localHashMap.get("user_name").toString();
    }
    return str;
  }

  public int getUserNameCount(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    int i = 0;
    localUserExt.setParam(":VUSER_NAME", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_NAME");
    if (localArrayList != null)
      return 1;
    return 0;
  }

  public int getUserNameExist(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_NAME", paramString.trim());
    localArrayList = localUserExt.selByList("SEL_BY_USERNAMEDOUBLE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public void userStaeMgr(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入userStaeMgr方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CUST_ID");
      String str2 = paramBuffers.getString("CUST_STATE");
      String str3 = paramBuffers.getString("SESSION_USER_ID");
      i = userStaeMgr(str1, str3, str2);
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
  }

  public int userStaeMgr(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString1);
    localUserExt.setParam(":VSTAFF_ID", paramString2);
    localUserExt.setParam(":VUSER_STATE", paramString3);
    this.tradeQuery.executeBy(localUserExt.insBy("USER_STATE_CHANGE"));
    return 0;
  }

  public void updateUserActiveation(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateUserActiveation方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str = paramBuffers.getString("user_id");
      i = updateUserActiveation(str);
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
    this.log.LOG_INFO("退出updateUserActiveation方法...");
  }

  public int updateUserActiveation(String paramString)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    this.tradeQuery.executeBy(localUserExt.insBy("UPDATE_ACTIVE"));
    return 0;
  }

  public String getCustIdByUserName(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_NAME", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      str = localHashMap.get("cust_id").toString();
    }
    return str;
  }

  public HashMap getUserInfByName(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_NAME", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public Map getPasswordByName(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_NAME", paramString.trim());
    localArrayList = localUserExt.selByList("SEL_BY_NAME");
    String str1 = "";
    String str2 = "";
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        localHashMap2 = (HashMap)localArrayList.get(i);
        if (localHashMap2.get("user_name") != null)
          str1 = localHashMap2.get("user_name").toString();
        if (localHashMap2.get("passwd") != null)
          str2 = localHashMap2.get("passwd").toString();
        localHashMap1.put("user_name", str1);
        localHashMap1.put("passwd", str2);
      }
    return localHashMap1;
  }

  public String getUserWeb_Log(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_ONE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("web_login_tag") != null)
        str = localHashMap.get("web_login_tag").toString();
      this.log.LOG_INFO("..." + localArrayList);
    }
    this.log.LOG_INFO("..." + str);
    return str;
  }

  public int getEmailAddrExist(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    UserdetailExt localUserdetailExt = new UserdetailExt();
    localUserdetailExt.setParam(":VEMAIL", paramString);
    ArrayList localArrayList = localUserdetailExt.selByList("SEL_BY_EMAIL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public String getUserJsonData(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString1);
    localUserExt.setParam(":VUSER_STATE", paramString2);
    localArrayList = localUserExt.selByList("SEL_BY_CUST_ID", paramInt, 10);
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = localHashMap.get("user_id").toString();
        if (localHashMap.get("user_name") != null)
          str2 = localHashMap.get("user_name").toString();
        if (localHashMap.get("phone") != null)
          str3 = localHashMap.get("phone").toString();
        if (localHashMap.get("home_addr") != null)
        {
          str4 = localHashMap.get("home_addr").toString();
          str4 = str4.replaceAll("<[^<>]+>", "");
          if (str4.length() > 20)
            str4 = str4.substring(0, 20) + "...";
        }
        if (localHashMap.get("birthday") != null)
        {
          str5 = localHashMap.get("birthday").toString();
          if (str5.length() > 10)
            str5 = str5.substring(0, 10);
        }
        if (localHashMap.get("email") != null)
          str6 = localHashMap.get("email").toString();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("id", str7);
        localJSONObject2.put("name", str2);
        localJSONObject2.put("phone", str3);
        localJSONObject2.put("addr", str4);
        localJSONObject2.put("email", str6);
        localJSONArray.add(localJSONObject2);
      }
    int i = getUserNumber(paramString1, "0");
    localJSONObject1.put("root", localJSONArray);
    localJSONObject1.put("totalCount", Integer.valueOf(i));
    str1 = localJSONObject1.toString();
    return str1;
  }

  public String searchRoleCode(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getUserinfoByCust_id(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("rsrv_str3") != null)
        str = localHashMap.get("rsrv_str3").toString();
      else
        str = "";
    }
    return str;
  }

  public void updateUsrRole(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateUsrRole方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("USER_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("CODE");
    try
    {
      i = updateUsrRole(str1, str2, str3);
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
    this.log.LOG_INFO("退出updateUsrRole方法...");
  }

  public int updateUsrRole(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString1);
    localUserExt.setParam(":VCUST_ID", paramString2);
    localUserExt.setParam(":VROLE_CODE", paramString3);
    this.log.LOG_INFO("==" + localUserExt.insBy("EIDT_TY_ROLE"));
    this.tradeQuery.executeBy(localUserExt.insBy("EIDT_TY_ROLE"));
    return 0;
  }

  public String getUserName(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_NAME_BY_IDS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("user_name") != null)
        str = localHashMap.get("user_name").toString();
    }
    return str;
  }

  public int getUserName(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    String str = "";
    MD5 localMD5 = new MD5();
    str = localMD5.getMD5(paramString2.getBytes());
    localUserExt.setParam(":VUSER_ID", paramString1);
    localUserExt.setParam(":VPASSWD", str);
    localArrayList = localUserExt.selByList("CHECK_USER_PASSWORD");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public void modifyOneUserPw(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入modifyOneUserPw方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PASSWORD");
    String str2 = paramBuffers.getString("USER_ID");
    String str3 = "";
    MD5 localMD5 = new MD5();
    str3 = localMD5.getMD5(str1.getBytes());
    this.log.LOG_INFO(str1 + "1111" + str1 + "4444" + str3);
    try
    {
      i = modifyOneUserPw(str3, str2);
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
  }

  public int modifyOneUserPw(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("BGEIN+++++++++++++++++++++");
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString2);
    localUserExt.setParam(":VPASSWD", paramString1);
    this.tradeQuery.executeBy(localUserExt.insBy("UPDATE_BY_ONE_PW"));
    this.log.LOG_INFO("END+++++++++++++++++++++");
    return 0;
  }

  public void DeluserStaeMgr(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入userStaeMgr方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str = paramBuffers.getString("CUST_ID");
      i = DeluserStaeMgr(str);
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
  }

  public int DeluserStaeMgr(String paramString)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString);
    this.tradeQuery.executeBy(localUserExt.insBy("STATE_DELETE_USER"));
    return 0;
  }

  public void DeleteUserInfo(Buffers paramBuffers)
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
        i = DeluserStaeMgr(str2);
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

  public ArrayList getUserListByUser(int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localArrayList = localUserExt.selByList("SEL_BY_USER_I_W", paramInt, 30);
    return localArrayList;
  }

  public int getUserListByUser()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localArrayList = localUserExt.selByList("SEL_BY_USER_I_W");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getUserListByUser(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString);
    localArrayList = localUserExt.selByList("SEL_BY_USER_I_T");
    return localArrayList;
  }

  public ArrayList getOneUser(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_NAME", "%" + paramString + "%");
    localArrayList = localUserExt.selByList("SEL_BY_USER_I_U", paramInt, 30);
    return localArrayList;
  }

  public int getOneUser(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_NAME", "%" + paramString + "%");
    localArrayList = localUserExt.selByList("SEL_BY_USER_I_U");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void addAdminInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addAdminInfo方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("PASSWORD");
      String str2 = paramBuffers.getString("USER_NAME");
      String str3 = paramBuffers.getString("USER_ID");
      String str4 = paramBuffers.getString("CUST_ID");
      String str5 = paramBuffers.getString("USER_STATE");
      String str6 = paramBuffers.getString("WEB_LOGIN_TAG");
      String str7 = "";
      MD5 localMD5 = new MD5();
      str7 = localMD5.getMD5(str1.getBytes());
      i = addAdminInfo(str7, str2, str3, str4, str5, str6);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增用户业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增用户业务处理成功！");
    }
    this.log.LOG_INFO("退出addAdminInfo方法...");
  }

  public int addAdminInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VPASSWORD", paramString1);
    localUserExt.setParam(":VCUST_ID", paramString4);
    localUserExt.setParam(":VWEB_LOGIN_TAG", paramString6);
    localUserExt.setParam(":VUSER_ID", paramString3);
    localUserExt.setParam(":VUSER_STATE", paramString5);
    localUserExt.setParam(":VUSER_NAME", paramString2);
    this.tradeQuery.executeBy(localUserExt.insBy("INS_BY_ADMIN_USER"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.userMgr.UserInfo
 * JD-Core Version:    0.6.0
 */