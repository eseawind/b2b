package com.saas.biz.userMgr;

import com.saas.biz.commen.MD5;
import com.saas.biz.commen.config;
import com.saas.biz.dao.custDAO.CustomerExt;
import com.saas.biz.dao.tcustmerDAO.TcustmerExt;
import com.saas.biz.dao.userDAO.UserDAO;
import com.saas.biz.dao.userDAO.UserExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class UserCheckMgr
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;

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

  public void CheckLogin(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入CheckLogin方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    config localconfig = new config();
    localconfig.init();
    String str1 = localconfig.getString("checkloginimage");
    String str2 = paramBuffers.getString("USER_NAME").trim();
    String str3 = paramBuffers.getString("PASSWD").trim();
    String str4 = "";
    String str5 = "";
    String str6 = "";
    MD5 localMD5 = new MD5();
    str6 = localMD5.getMD5(str3.getBytes());
    if (str1.equals("1"))
    {
      str4 = paramBuffers.getString("USERRAND").trim();
      str5 = paramBuffers.getString("RANDOMCODE").trim();
      this.log.LOG_INFO("userrand=" + str4 + "randomcode=" + str5);
      if (str4.equalsIgnoreCase(str5))
      {
        try
        {
          i = CheckLogin(str2, str6);
        }
        catch (SaasApplicationException localSaasApplicationException1)
        {
          this.log.LOG_INFO(localSaasApplicationException1.getMessage());
        }
        if (i != 0)
        {
          this.outBuffer.setInt("RESULT_LOGIN_CODE", i);
          this.outBuffer.setInt("RESULT_CODE", -1);
        }
        else
        {
          this.outBuffer.setInt("RESULT_CODE", 0);
          this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
        }
      }
      else
      {
        this.outBuffer.setInt("RESULT_CODE", -1);
        this.outBuffer.setString("RESULT_INFO", "校验码输入错误，请返回重新输入！");
      }
    }
    else
    {
      try
      {
        i = CheckLogin(str2, str6);
      }
      catch (SaasApplicationException localSaasApplicationException2)
      {
        this.log.LOG_INFO(localSaasApplicationException2.getMessage());
      }
      if (i != 0)
      {
        this.outBuffer.setInt("RESULT_LOGIN_CODE", i);
        this.outBuffer.setInt("RESULT_CODE", -1);
      }
      else
      {
        this.outBuffer.setInt("RESULT_CODE", 0);
        this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
      }
    }
    this.log.LOG_INFO("退出CheckLogin方法...");
  }

  private int CheckLogin(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    UserDAO localUserDAO = new UserDAO();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    int i=0;
    for (  i = 0; (i < paramString1.length()) && (paramString1.charAt(i) != '@'); i++);
    if (  i >= paramString1.length())
    {
      if (checktCustInfo(paramString1, paramString2) == 0)
      {
        this.outBuffer.setString("RESULT_INFO", paramString1);
        return 10;
      }
      if (checktCustInfo(paramString1, paramString2) == -2)
      {
        Object localObject = "用户密码错误！";
        this.outBuffer.setString("RESULT_INFO", (String)localObject);
        return 11;
      }
      localUserExt.setParam(":VUSER_NAME", paramString1);
      localArrayList1 = localUserExt.selByList("SEL_BY_CHECK");
    }
    else
    {
      localUserExt.setParam(":VUSER_NAME", paramString1);
      localArrayList1 = localUserExt.selByList("SEL_BY_CHECK_EMAIL");
    }
    if ((localArrayList1 == null) || (localArrayList1.isEmpty()))
    {
      this.outBuffer.setString("RESULT_INFO", "用户名不存在，请与管理员联系！");
      return 9;
    }
    Object localObject = localArrayList1.iterator();
    ((Iterator)localObject).hasNext();
    HashMap localHashMap1 = (HashMap)((Iterator)localObject).next();
    str1 = localHashMap1.get("user_id").toString();
    if (localHashMap1.get("rsrv_str3") != null)
      str8 = localHashMap1.get("rsrv_str3").toString();
    if (localHashMap1.get("user_type") != null)
      str9 = localHashMap1.get("user_type").toString();
    if (localHashMap1.get("cust_type") != null)
      str12 = localHashMap1.get("cust_type").toString();
    str2 = localHashMap1.get("user_name").toString();
    str10 = localHashMap1.get("passwd").toString();
    str3 = localHashMap1.get("cust_id").toString();
    str5 = localHashMap1.get("user_state").toString();
    str4 = localHashMap1.get("web_login_tag").toString();
    str6 = localHashMap1.get("cust_class").toString();
    if (localHashMap1.get("depart_code") != null)
      str11 = localHashMap1.get("depart_code").toString();
    localArrayList2 = genSpecCustInfo(str3);
    if (localArrayList2 != null)
    {
      Iterator localIterator = localArrayList2.iterator();
      localIterator.hasNext();
      HashMap localHashMap2 = (HashMap)localIterator.next();
      str7 = localHashMap2.get("cust_name").toString();
    }
    if (localUserDAO == null)
      return 10;
    if (!str10.trim().equalsIgnoreCase(paramString2))
    {
      this.outBuffer.setString("RESULT_INFO", "用户密码错误！");
      return 11;
    }
    if (str5.toString().equals("1"))
    {
      this.outBuffer.setString("RESULT_INFO", "用户当前状态不允许登录！");
      return 12;
    }
    if (str5.toString().equals("2"))
    {
      this.outBuffer.setString("RESULT_INFO", "用户当前状态不允许登录！");
      return 13;
    }
    if (str4.toString().equals("0"))
    {
      this.outBuffer.setString("RESULT_INFO", "您的帐号还没有激活，不允许登录，请到注册时候填写的邮箱里收取激活邮件！");
      return 14;
    }
    if (str5.toString().equals("3"))
    {
      this.outBuffer.setString("RESULT_INFO", "您的帐号还没通过管理员审批通过，不允许登陆！");
      return 15;
    }
    this.outBuffer.setString("SESSION_CUST_TYPE", str12);
    this.outBuffer.setString("SESSION_USER_ID", str1);
    this.outBuffer.setString("SESSION_CUST_ID", str3);
    this.outBuffer.setString("SESSION_USER_NAME", paramString1);
    this.outBuffer.setString("SESSION_CUST_CLASS", str6);
    this.outBuffer.setString("DEPART_CODE", str11);
    this.outBuffer.setString("SESSION_ROLE_CODE", str8);
    this.outBuffer.setString("SESSION_USER_TYPE", str9);
    this.outBuffer.setString("SESSION_CUST_NAME", URLEncoder.encode(str7));
    this.outBuffer.setSessionField("SESSION_USER_ID");
    this.outBuffer.setSessionField("SESSION_CUST_ID");
    this.outBuffer.setSessionField("SESSION_USER_NAME");
    this.outBuffer.setSessionField("SESSION_CUST_CLASS");
    this.outBuffer.setSessionField("DEPART_CODE");
    this.outBuffer.setSessionField("SESSION_CUST_NAME");
    this.outBuffer.setSessionField("SESSION_ROLE_CODE");
    this.outBuffer.setSessionField("SESSION_USER_TYPE");
    this.outBuffer.setSessionField("SESSION_CUST_TYPE");
    return 0;
  }

  public void beforeUserLoading(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入beforeUserLoading方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("USER_NAME").trim();
    String str2 = paramBuffers.getString("PASSWD").trim();
    String str3 = "";
    MD5 localMD5 = new MD5();
    str3 = localMD5.getMD5(str2.getBytes());
    try
    {
      i = beforeUserLoading(str1, str3);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_LOGIN_CODE", i);
      this.outBuffer.setInt("RESULT_CODE", -1);
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出beforeUserLoading方法...");
  }

  private int beforeUserLoading(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    UserDAO localUserDAO = new UserDAO();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    if (checktCustInfo(paramString1, paramString2) == 0)
    {
      this.outBuffer.setString("RESULT_INFO", paramString1);
      return 10;
    }
    if (checktCustInfo(paramString1, paramString2) == -2)
    {
      Object localObject = "用户密码错误！";
      this.outBuffer.setString("RESULT_INFO", (String)localObject);
      return 11;
    }
    localUserExt.setParam(":VUSER_NAME", paramString1);
    localArrayList1 = localUserExt.selByList("SEL_BY_CHECK");
    if ((localArrayList1 == null) || (localArrayList1.isEmpty()))
    {
      this.outBuffer.setString("RESULT_INFO", "用户名不存在，请与管理员联系！");
      return 9;
    }
    Object localObject = localArrayList1.iterator();
    ((Iterator)localObject).hasNext();
    HashMap localHashMap1 = (HashMap)((Iterator)localObject).next();
    str1 = localHashMap1.get("user_id").toString();
    if (localHashMap1.get("rsrv_str3") != null)
      str7 = localHashMap1.get("rsrv_str3").toString();
    if (localHashMap1.get("user_type") != null)
      str8 = localHashMap1.get("user_type").toString();
    if (localHashMap1.get("cust_type") != null)
      str12 = localHashMap1.get("cust_type").toString();
    str11 = localHashMap1.get("user_name").toString();
    str9 = localHashMap1.get("passwd").toString();
    str2 = localHashMap1.get("cust_id").toString();
    str4 = localHashMap1.get("user_state").toString();
    str3 = localHashMap1.get("web_login_tag").toString();
    str5 = localHashMap1.get("cust_class").toString();
    if (localHashMap1.get("depart_code") != null)
      str10 = localHashMap1.get("depart_code").toString();
    localArrayList2 = genSpecCustInfo(str2);
    if (localArrayList2 != null)
    {
      Iterator localIterator = localArrayList2.iterator();
      localIterator.hasNext();
      HashMap localHashMap2 = (HashMap)localIterator.next();
      str6 = localHashMap2.get("cust_name").toString();
    }
    if (localUserDAO == null)
      return 10;
    if (!str9.trim().equalsIgnoreCase(paramString2))
    {
      this.outBuffer.setString("RESULT_INFO", "用户密码错误！");
      return 11;
    }
    if (str4.toString().equals("1"))
    {
      this.outBuffer.setString("RESULT_INFO", "用户当前状态不允许登录！");
      return 12;
    }
    if (str4.toString().equals("2"))
    {
      this.outBuffer.setString("RESULT_INFO", "用户当前状态不允许登录！");
      return 13;
    }
    if (str3.toString().equals("0"))
    {
      this.outBuffer.setString("RESULT_INFO", "您的帐号还没有激活，不允许登录，请到注册时候填写的邮箱里收取激活邮件！");
      return 14;
    }
    this.outBuffer.setString("SESSION_USER_ID", str1);
    this.outBuffer.setString("SESSION_CUST_ID", str2);
    this.outBuffer.setString("SESSION_USER_NAME", paramString1);
    this.outBuffer.setString("SESSION_CUST_CLASS", str5);
    this.outBuffer.setString("DEPART_CODE", str10);
    this.outBuffer.setString("SESSION_ROLE_CODE", str7);
    this.outBuffer.setString("SESSION_USER_TYPE", str8);
    this.outBuffer.setString("SESSION_CUST_NAME", URLEncoder.encode(str6));
    this.outBuffer.setString("SESSION_CUST_TYPE", str12);
    this.outBuffer.setSessionField("SESSION_USER_ID");
    this.outBuffer.setSessionField("SESSION_CUST_ID");
    this.outBuffer.setSessionField("SESSION_USER_NAME");
    this.outBuffer.setSessionField("SESSION_CUST_CLASS");
    this.outBuffer.setSessionField("DEPART_CODE");
    this.outBuffer.setSessionField("SESSION_CUST_NAME");
    this.outBuffer.setSessionField("SESSION_ROLE_CODE");
    this.outBuffer.setSessionField("SESSION_USER_TYPE");
    this.outBuffer.setSessionField("SESSION_CUST_TYPE");
    return 0;
  }

  public boolean Exists(String paramString)
  {
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_NAME", paramString);
    ArrayList localArrayList = localUserExt.selByList("SEL_BY_CHECK");
    return (localArrayList == null) || (localArrayList.size() == 0);
  }

  public HashMap Exists(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    UserExt localUserExt = new UserExt();
    HashMap localHashMap = new HashMap();
    localUserExt.setParam(":VUSER_NAME", paramString1);
    ArrayList localArrayList = localUserExt.selByList("SEL_BY_CHECK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
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

  public int checktCustInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    String str = "";
    TcustmerExt localTcustmerExt = new TcustmerExt();
    localTcustmerExt.setParam(":VUSER_NAME", paramString1);
    localTcustmerExt.setParam(":VCUST_STATE", Character.valueOf('0'));
    localArrayList = localTcustmerExt.selByList("SEL_BY_USER");
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      Iterator localIterator = localArrayList.iterator();
      localIterator.hasNext();
      HashMap localHashMap = (HashMap)localIterator.next();
      str = localHashMap.get("password").toString();
      if (!str.equals(paramString2))
        return -2;
      return 0;
    }
    return -1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.userMgr.UserCheckMgr
 * JD-Core Version:    0.6.0
 */