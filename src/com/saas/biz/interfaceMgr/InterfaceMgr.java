package com.saas.biz.interfaceMgr;

import com.ahbay.commenMgr.InterfDataBaseCommMgr;
import com.ahbay.commenMgr.commMethodMgr;
import com.saas.biz.dao.custDAO.CustomerExt;
import com.saas.biz.dao.userDAO.UserDAO;
import com.saas.biz.dao.userDAO.UserExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

public class InterfaceMgr
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
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

  public ArrayList getInterfaceData(HttpServletRequest paramHttpServletRequest)
  {
    this.log.LOG_INFO("进入getInterfaceData方法...");
    ArrayList localArrayList = new ArrayList();
    String str1 = "";
    String str2 = "";
    String str3 = paramHttpServletRequest.getParameter("user_name");
    String str4 = paramHttpServletRequest.getParameter("passwd");
    String str5 = paramHttpServletRequest.getParameter("login_tag");
    if (paramHttpServletRequest.getParameter("tf_type") != null)
      str1 = paramHttpServletRequest.getParameter("tf_type");
    if (paramHttpServletRequest.getParameter("tf_id") != null)
      str2 = paramHttpServletRequest.getParameter("tf_id");
    try
    {
      localArrayList = getInterfaceData(str1, str2, str3, str4, str5);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    this.log.LOG_INFO("退出getInterfaceData方法...");
    return localArrayList;
  }

  public ArrayList getInterfaceData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    ArrayList localArrayList1 = new ArrayList();
    UserExt localUserExt = new UserExt();
    UserDAO localUserDAO = new UserDAO();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = localcommMethodMgr.GenTradeId();
    localUserExt.setParam(":VUSER_NAME", paramString3);
    localArrayList2 = localUserExt.selByList("SEL_BY_CHECK");
    try
    {
      Object localObject;
      if (!paramString5.equals("1"))
      {
        if ((localArrayList2 == null) || (localArrayList2.isEmpty()))
          throw new RuntimeException("用户名不存在！");
        localObject = localArrayList2.iterator();
        ((Iterator)localObject).hasNext();
        HashMap localHashMap1 = (HashMap)((Iterator)localObject).next();
        str1 = localHashMap1.get("user_id").toString();
        str2 = localHashMap1.get("user_name").toString();
        paramString4 = localHashMap1.get("passwd").toString();
        str3 = localHashMap1.get("cust_id").toString();
        str5 = localHashMap1.get("user_state").toString();
        str4 = localHashMap1.get("web_login_tag").toString();
        str6 = localHashMap1.get("cust_class").toString();
        if (localHashMap1.get("depart_code") != null)
          str8 = localHashMap1.get("depart_code").toString();
        localArrayList3 = genSpecCustInfo(str3);
        if (localArrayList3 != null)
        {
          Iterator localIterator = localArrayList3.iterator();
          localIterator.hasNext();
          HashMap localHashMap2 = (HashMap)localIterator.next();
          str7 = localHashMap2.get("cust_name").toString();
        }
        if (localUserDAO == null)
          throw new RuntimeException("用户名不存在！");
        if (!paramString4.trim().equalsIgnoreCase(paramString4))
          throw new RuntimeException("用户密码错误！");
        if (str5.toString().equals("1"))
          throw new RuntimeException("用户当前状态不允许登录！");
        if (str5.toString().equals("2"))
          throw new RuntimeException("用户当前状态不允许登录！");
        if (str4.toString().equals("0"))
          throw new RuntimeException("您的帐号还没有激活，不允许登录，请到注册时候填写的邮箱里收取激活邮件！");
      }
      if (paramString1.equals("1"))
      {
        localArrayList1 = getInfoPage(paramString2);
        localObject = new HashMap();
        ((HashMap)localObject).put("trade_type_code", "1009");
        ((HashMap)localObject).put("session_user_name", str2);
        ((HashMap)localObject).put("session_user_id", str1);
        ((HashMap)localObject).put("depart_code", str8);
        ((HashMap)localObject).put("path", str8);
        ((HashMap)localObject).put("xvisible", paramString2);
        localArrayList1.add(localObject);
      }
      else if (paramString1.equals("2"))
      {
        localArrayList1 = getInfoPage(paramString2);
        localObject = new HashMap();
        ((HashMap)localObject).put("trade_type_code", "1009");
        ((HashMap)localObject).put("session_user_name", str2);
        ((HashMap)localObject).put("session_user_id", str1);
        ((HashMap)localObject).put("depart_code", str8);
        ((HashMap)localObject).put("path", str8);
        ((HashMap)localObject).put("xvisible", paramString2);
        ((HashMap)localObject).put("id", str9);
        localArrayList1.add(localObject);
      }
      else if (paramString1.equals("3"))
      {
        localArrayList1 = getYpPage(paramString2);
        localObject = new HashMap();
        ((HashMap)localObject).put("trade_type_code", "1047");
        ((HashMap)localObject).put("session_user_name", paramString2);
        ((HashMap)localObject).put("session_user_id", str1);
        ((HashMap)localObject).put("session_cust_id", str3);
        ((HashMap)localObject).put("depart_code", str8);
        ((HashMap)localObject).put("cust_id", localcommMethodMgr.GenTradeId());
        ((HashMap)localObject).put("user_id", localcommMethodMgr.GenTradeId());
        ((HashMap)localObject).put("user_name", paramString2);
        ((HashMap)localObject).put("password", "111111");
        ((HashMap)localObject).put("pspt_type_code", "0");
        ((HashMap)localObject).put("web_login_tag", "0");
        ((HashMap)localObject).put("pspt_id", "0");
        ((HashMap)localObject).put("eparchy_code", "");
        ((HashMap)localObject).put("sex", "0");
        ((HashMap)localObject).put("passwd_ques", "");
        ((HashMap)localObject).put("passwd_answer", "");
        ((HashMap)localObject).put("qq", "");
        ((HashMap)localObject).put("home_addr", "");
        ((HashMap)localObject).put("work_depart", "");
        ((HashMap)localObject).put("educate_degree_code", "");
        ((HashMap)localObject).put("folk_code", "");
        ((HashMap)localObject).put("birthday", "");
        ((HashMap)localObject).put("pspt_addr", "");
        ((HashMap)localObject).put("country_code", "");
        ((HashMap)localObject).put("post_addr", "");
        ((HashMap)localObject).put("blog", "");
        ((HashMap)localObject).put("work_name", "");
        ((HashMap)localObject).put("job", "");
        ((HashMap)localObject).put("marriage", "");
        ((HashMap)localObject).put("cust_aim", "");
        ((HashMap)localObject).put("company_address", "");
        ((HashMap)localObject).put("fax_nbr", "");
        ((HashMap)localObject).put("user_count", "0");
        ((HashMap)localObject).put("group_contact_phone", "");
        ((HashMap)localObject).put("calling_type_code", "");
        ((HashMap)localObject).put("juristic", "");
        ((HashMap)localObject).put("bigsort", "");
        ((HashMap)localObject).put("salekeyword", "");
        ((HashMap)localObject).put("buykeyword", "");
        ((HashMap)localObject).put("group_memo", "");
        ((HashMap)localObject).put("website", "");
        ((HashMap)localObject).put("rsrv_str1", "0");
        ((HashMap)localObject).put("relation_type_code", "4");
        ((HashMap)localObject).put("relation_type_name", "潜在客户");
        ((HashMap)localObject).put("entity_type", "0");
        ((HashMap)localObject).put("e_class_id", "0");
        ((HashMap)localObject).put("e_class_name", "未分类客户");
        ((HashMap)localObject).put("e_class_id_grp", "");
        ((HashMap)localObject).put("e_class_name_grp", "");
        localArrayList1.add(localObject);
      }
      else if (paramString1.equals("4"))
      {
        localArrayList1 = getYpPage(paramString2);
        localObject = new HashMap();
        ((HashMap)localObject).put("trade_type_code", "1234");
        localArrayList1.add(localObject);
      }
      else if (paramString1.equals("5"))
      {
        localArrayList1 = getGyPage(paramString2);
        localObject = new HashMap();
        ((HashMap)localObject).put("trade_type_code", "1009");
        ((HashMap)localObject).put("session_user_name", str2);
        ((HashMap)localObject).put("session_user_id", str1);
        ((HashMap)localObject).put("depart_code", str8);
        ((HashMap)localObject).put("path", str8);
        ((HashMap)localObject).put("xvisible", paramString2);
        ((HashMap)localObject).put("id", str9);
        localArrayList1.add(localObject);
      }
      else if (paramString1.equals("6"))
      {
        localArrayList1 = getGyPage(paramString2);
        localObject = new HashMap();
        ((HashMap)localObject).put("trade_type_code", "1009");
        ((HashMap)localObject).put("session_user_name", str2);
        ((HashMap)localObject).put("session_user_id", str1);
        ((HashMap)localObject).put("depart_code", str8);
        ((HashMap)localObject).put("path", str8);
        ((HashMap)localObject).put("xvisible", paramString2);
        ((HashMap)localObject).put("id", str9);
        localArrayList1.add(localObject);
      }
      else if (paramString1.equals("7"))
      {
        localArrayList1 = getGyPage(paramString2);
        localObject = new HashMap();
        ((HashMap)localObject).put("trade_type_code", "1234");
        localArrayList1.add(localObject);
      }
      else if (paramString1.equals("8"))
      {
        localArrayList1 = getPricePage(paramString2);
        localObject = new HashMap();
        ((HashMap)localObject).put("trade_type_code", "1009");
        ((HashMap)localObject).put("session_user_name", str2);
        ((HashMap)localObject).put("session_user_id", str1);
        ((HashMap)localObject).put("depart_code", str8);
        ((HashMap)localObject).put("path", str8);
        ((HashMap)localObject).put("xvisible", paramString2);
        ((HashMap)localObject).put("id", str9);
        localArrayList1.add(localObject);
      }
      else if (paramString1.equals("9"))
      {
        localArrayList1 = getPricePage(paramString2);
        localObject = new HashMap();
        ((HashMap)localObject).put("trade_type_code", "1009");
        ((HashMap)localObject).put("session_user_name", str2);
        ((HashMap)localObject).put("session_user_id", str1);
        ((HashMap)localObject).put("depart_code", str8);
        ((HashMap)localObject).put("path", str8);
        ((HashMap)localObject).put("xvisible", paramString2);
        ((HashMap)localObject).put("id", str9);
        localArrayList1.add(localObject);
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return (ArrayList)localArrayList1;
  }

  public ArrayList getYpPage(String paramString)
  {
    InterfDataBaseCommMgr localInterfDataBaseCommMgr = new InterfDataBaseCommMgr();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    str = "select * from agriyp where id=" + paramString;
    localInterfDataBaseCommMgr.setStrQuery(str);
    localArrayList1 = localInterfDataBaseCommMgr.SelBizQuery();
    return localArrayList1;
  }

  public ArrayList getGyPage(String paramString)
  {
    InterfDataBaseCommMgr localInterfDataBaseCommMgr = new InterfDataBaseCommMgr();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    str = "select * from agriinfo where id=" + paramString;
    localInterfDataBaseCommMgr.setStrQuery(str);
    localArrayList1 = localInterfDataBaseCommMgr.SelBizQuery();
    return localArrayList1;
  }

  public ArrayList getQgPage(String paramString)
  {
    InterfDataBaseCommMgr localInterfDataBaseCommMgr = new InterfDataBaseCommMgr();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    str = "select * from agriinfo where id=" + paramString;
    localInterfDataBaseCommMgr.setStrQuery(str);
    localArrayList1 = localInterfDataBaseCommMgr.SelBizQuery();
    return localArrayList1;
  }

  public ArrayList getInfoPage(String paramString)
  {
    InterfDataBaseCommMgr localInterfDataBaseCommMgr = new InterfDataBaseCommMgr();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    str = "select * from agrinews where id=" + paramString;
    localInterfDataBaseCommMgr.setStrQuery(str);
    localArrayList1 = localInterfDataBaseCommMgr.SelBizQuery();
    return localArrayList1;
  }

  public ArrayList getPricePage(String paramString)
  {
    InterfDataBaseCommMgr localInterfDataBaseCommMgr = new InterfDataBaseCommMgr();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    str = "select * from agriprice where id=" + paramString;
    localInterfDataBaseCommMgr.setStrQuery(str);
    localArrayList1 = localInterfDataBaseCommMgr.SelBizQuery();
    return localArrayList1;
  }

  public ArrayList genSpecCustInfo(String paramString)
  {
    InterfDataBaseCommMgr localInterfDataBaseCommMgr = new InterfDataBaseCommMgr();
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localCustomerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustomerExt.selByList("SEL_SPEC_CUST");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.interfaceMgr.InterfaceMgr
 * JD-Core Version:    0.6.0
 */