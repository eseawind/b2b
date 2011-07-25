package com.saas.biz.serverMgr;

import com.saas.biz.commen.ParamethodMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.commenDAO.CommparaExt;
import com.saas.biz.dao.serverDAO.ServerDAO;
import com.saas.biz.dao.serverDAO.ServerExt;
import com.saas.biz.dao.userDAO.UserExt;
import com.saas.biz.userMgr.UserInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ServerInfo
{
  Dbtable tradeQuery = new Dbtable();
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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

  public void addServerInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addServerInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    ServerDAO localServerDAO = new ServerDAO();
    try
    {
      String str1 = paramBuffers.getString("V_RCVNAME");
      String str2 = new UserInfo().getCustIdByUserName(str1);
      HashMap localHashMap = new HashMap();
      localHashMap.put("b2b", paramBuffers.getString("B2B"));
      localHashMap.put("com", paramBuffers.getString("COM"));
      localHashMap.put("oa", paramBuffers.getString("OA"));
      localHashMap.put("bss", paramBuffers.getString("BSS"));
      localHashMap.put("hrm", paramBuffers.getString("HRM"));
      localHashMap.put("crm", paramBuffers.getString("CRM"));
      String str3 = paramBuffers.getString("SERVER_NAME");
      String str4 = "";
      String str5 = paramBuffers.getString("V_AMOUNT");
      String str6 = paramBuffers.getString("V_RCVEMAIL");
      String str7 = paramBuffers.getString("V_ORDEREMAIL");
      localServerDAO.setCust_id(str2);
      localServerDAO.setRsrv_str7(str3);
      localServerDAO.setRsrv_str9(str6);
      localServerDAO.setRsrv_str10(str7);
      localServerDAO.setStaff_id(str4);
      localServerDAO.setRemark(str5);
      i = addServerInfo(localServerDAO, localHashMap);
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
    this.log.LOG_INFO("退出addServerInfo方法...");
  }

  public int addServerInfo(ServerDAO paramServerDAO, HashMap paramHashMap)
    throws SaasApplicationException
  {
    String str1 = paramServerDAO.getRsrv_str7();
    ArrayList localArrayList1 = new ArrayList();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    String str2 = "3";
    while (localStringTokenizer.hasMoreTokens())
      localArrayList1.add(localStringTokenizer.nextToken());
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str4 = paramHashMap.get(str3).toString();
      String str5 = localSimpleDateFormat.format(new Date());
      String str6 = "";
      String str7 = localSimpleDateFormat.format(new Date());
      boolean bool = true;
      int i = 0;
      ServerDAO localServerDAO = new ServerDAO();
      localServerDAO.setCust_id(paramServerDAO.getCust_id());
      localServerDAO.setServer_id(str3);
      localServerDAO.setRemark(paramServerDAO.getRemark());
      localServerDAO.setStaff_id(paramServerDAO.getStaff_id());
      if ((str3 == "b2b") || (str3.equals("b2b")))
      {
        i = Integer.parseInt(str4) * 3;
        str2 = "5";
      }
      else if ((str3 == "bss") || (str3.equals("bss")))
      {
        i = Integer.parseInt(str4) * 1;
        str2 = "2";
      }
      else if ((str3 == "oa") || (str3.equals("oa")))
      {
        i = Integer.parseInt(str4) * 1;
        str2 = "3";
      }
      else if ((str3 == "com") || (str3.equals("com")))
      {
        i = Integer.parseInt(str4) * 3;
        str2 = "4";
      }
      else if ((str3 == "crm") || (str3.equals("crm")))
      {
        i = Integer.parseInt(str4) * 3;
        str2 = "6";
      }
      else if ((str3 == "hrm") || (str3.equals("hrm")))
      {
        i = Integer.parseInt(str4) * 1;
        str2 = "7";
      }
      ArrayList localArrayList2 = getServerByID(paramServerDAO.getCust_id(), str3);
      Object localObject;
      if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      {
        bool = false;
        localObject = (HashMap)localArrayList2.get(0);
        String str8 = ((HashMap)localObject).get("end_date").toString();
        try
        {
          Date localDate = localSimpleDateFormat.parse(str8);
          Calendar localCalendar = Calendar.getInstance();
          localCalendar.setTime(localDate);
          localCalendar.add(2, i);
          str6 = localSimpleDateFormat.format(localCalendar.getTime());
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
        }
      }
      else
      {
        localObject = Calendar.getInstance();
        ((Calendar)localObject).add(2, i);
        str6 = localSimpleDateFormat.format(((Calendar)localObject).getTime());
      }
      localServerDAO.setStart_date(str5);
      localServerDAO.setEnd_date(str6);
      localServerDAO.setState_code_date(str7);
      localServerDAO.setState_code(str2);
      localServerDAO.setRsrv_str9(paramServerDAO.getRsrv_str9());
      localServerDAO.setRsrv_str10(paramServerDAO.getRsrv_str10());
      saveOrUpdateServer(localServerDAO, bool);
    }
    return 0;
  }

  public int saveOrUpdateServer(ServerDAO paramServerDAO, boolean paramBoolean)
    throws SaasApplicationException
  {
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VCUST_ID", paramServerDAO.getCust_id());
    localServerExt.setParam(":VSERVER_ID", paramServerDAO.getServer_id());
    localServerExt.setParam(":VSTART_DATE", paramServerDAO.getStart_date());
    localServerExt.setParam(":VEND_DATE", paramServerDAO.getEnd_date());
    localServerExt.setParam(":VSTAFF_ID", paramServerDAO.getStaff_id());
    localServerExt.setParam(":VSTATE_CODE", paramServerDAO.getState_code());
    localServerExt.setParam(":VREMARK", paramServerDAO.getRemark());
    localServerExt.setParam(":VRSRV_STR9", paramServerDAO.getRsrv_str9());
    localServerExt.setParam(":VRSRV_STR10", paramServerDAO.getRsrv_str10());
    localServerExt.setParam(":VRSRV_STR5", "s");
    if (paramBoolean)
    {
      this.log.LOG_INFO("service save ...");
      this.tradeQuery.executeBy(localServerExt.insBy("INS_BY_ALL"));
    }
    else
    {
      this.log.LOG_INFO("service update ...");
      this.tradeQuery.executeBy(localServerExt.insBy("UPDATE_BY_ALL"));
    }
    return 0;
  }

  public void addRegServerInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addRegServerInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    ServerDAO localServerDAO = new ServerDAO();
    String str1 = paramBuffers.getString("CUST_ID");
    this.log.LOG_INFO("cust_id==" + str1);
    String str2 = paramBuffers.getString("USER_ID");
    this.log.LOG_INFO("staff_id==" + str2);
    String str3 = paramBuffers.getString("CUST_CLASS");
    this.log.LOG_INFO("cust_class==" + str3);
    try
    {
      localServerDAO.setCust_id(str1);
      localServerDAO.setState_code("3");
      localServerDAO.setStaff_id(str2);
      i = addRegServerInfo(localServerDAO, str3);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "1业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addRegServerInfo方法...");
  }

  public int addRegServerInfo(ServerDAO paramServerDAO, String paramString)
    throws SaasApplicationException
  {
    ParamethodMgr localParamethodMgr = new ParamethodMgr();
    String str1 = localParamethodMgr.getParaCode3ByParaCode1("1", paramString);
    String str2 = paramServerDAO.getCust_id();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str3 = localStringTokenizer.nextToken();
      ArrayList localArrayList = getServerByID(str2, str3);
      if ((localArrayList == null) || (localArrayList.size() <= 0))
      {
        ServerExt localServerExt = new ServerExt();
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar localCalendar = Calendar.getInstance();
        String str4 = localSimpleDateFormat.format(localCalendar.getTime());
        localCalendar.add(2, 2);
        String str5 = localSimpleDateFormat.format(localCalendar.getTime());
        localServerExt.setParam(":VCUST_ID", paramServerDAO.getCust_id());
        localServerExt.setParam(":VSERVER_ID", str3);
        localServerExt.setParam(":VSTART_DATE", str4);
        localServerExt.setParam(":VEND_DATE", str5);
        localServerExt.setParam(":VSTAFF_ID", paramServerDAO.getStaff_id());
        localServerExt.setParam(":VSTATE_CODE", paramServerDAO.getState_code());
        localServerExt.setParam(":VREMARK", "免费注册试用");
        localServerExt.setParam(":VRSRV_STR9", "");
        localServerExt.setParam(":VRSRV_STR10", "");
        localServerExt.setParam(":VRSRV_STR5", "s");
        this.tradeQuery.executeBy(localServerExt.insBy("INS_BY_ALL"));
      }
    }
    return 0;
  }

  public ArrayList getServerByCode6(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString);
    ArrayList localArrayList2 = localCommparaExt.selByList("SEL_BY_ATTR");
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)localArrayList2.get(i);
        String str1 = "";
        String str2 = "";
        String str3 = "";
        if (localHashMap1.get("para_code6") == null)
          continue;
        str1 = localHashMap1.get("para_code6").toString();
        if ((str1 != "1") && (!str1.equals("1")))
          continue;
        str3 = localHashMap1.get("para_code1").toString();
        str2 = localHashMap1.get("para_code2").toString();
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("serverId", str3);
        localHashMap2.put("serverName", str2);
        localArrayList1.add(localHashMap2);
      }
    return localArrayList1;
  }

  public void delServerInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delServerInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    ServerDAO localServerDAO = new ServerDAO();
    try
    {
      String str1 = paramBuffers.getString("CUST_ID");
      String str2 = paramBuffers.getString("B2B");
      String str3 = paramBuffers.getString("COM");
      String str4 = paramBuffers.getString("OA");
      String str5 = paramBuffers.getString("BSS");
      String str6 = paramBuffers.getString("HRM");
      String str7 = paramBuffers.getString("CRM");
      String str8 = paramBuffers.getString("SERVER_NAME");
      String str9 = paramBuffers.getString("SESSION_USER_ID");
      String str10 = paramBuffers.getString("V_AMOUNT");
      localServerDAO.setCust_id(str1);
      localServerDAO.setRsrv_str1(str2);
      localServerDAO.setRsrv_str2(str3);
      localServerDAO.setRsrv_str3(str4);
      localServerDAO.setRsrv_str4(str5);
      localServerDAO.setRsrv_str5(str6);
      localServerDAO.setRsrv_str6(str7);
      localServerDAO.setRsrv_str7(str8);
      localServerDAO.setStaff_id(str9);
      localServerDAO.setRemark(str10);
      i = delServerInfo(localServerDAO);
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
    this.log.LOG_INFO("退出delServerInfo方法...");
  }

  public int delServerInfo(ServerDAO paramServerDAO)
    throws SaasApplicationException
  {
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VSERVER_ID", paramServerDAO.getServer_id());
    localServerExt.setParam(":VSTART_DATE", paramServerDAO.getStart_date());
    localServerExt.setParam(":VEND_DATE", paramServerDAO.getEnd_date());
    localServerExt.setParam(":VSTAFF_ID", paramServerDAO.getStaff_id());
    localServerExt.setParam(":VSTATE_CODE", paramServerDAO.getState_code());
    localServerExt.setParam(":VREMARK", paramServerDAO.getRemark());
    this.tradeQuery.executeBy(localServerExt.insBy("DEL_BY_IDX"));
    return 0;
  }

  public ArrayList getServersByIdx(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VSERVER_ID", paramString);
    localArrayList = localServerExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public ArrayList getServersByCustId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VCUST_ID", paramString1);
    localServerExt.setParam(":VSTATE_CODE", paramString2);
    localArrayList = localServerExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList getServerByID(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VCUST_ID", paramString1);
    localServerExt.setParam(":VSERVER_ID", paramString2);
    localArrayList = localServerExt.selByList("SEL_BY_PK");
    return localArrayList;
  }

  public void checkUserServer(String paramString)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localServerExt.selByList("SEL_CHECK_SERVER");
    String str1 = "";
    try
    {
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        String str2 = localHashMap.get("state_code").toString();
        if ((str2.equals("3")) || (str2.equals("3")))
        {
          this.log.LOG_INFO("正常");
        }
        else
        {
          if ((str2 == "1") || (str2.equals("1")))
          {
            str1 = "服务欠费，帐号被封锁！请续交费用！";
            throw new RuntimeException(str1);
          }
          if ((str2 == "2") || (str2 == "2"))
          {
            str1 = "对不起，该帐号已被注销！请与管理员联系！";
            throw new RuntimeException(str1);
          }
        }
      }
      else
      {
        str1 = "不可预知的错误，请刷新页面后，重试！";
        throw new RuntimeException(str1);
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(str1);
    }
  }

  public void updateOrDelete(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delServerInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CONTRACT_NO");
      int j = paramBuffers.getInt("RESULT_CODE");
      String str2 = paramBuffers.getString("ACCOUNT_MONEY");
      String str3 = paramBuffers.getString("ACCOUNT_NAME");
      String str4 = paramBuffers.getString("SESSION_CUST_ID");
      String str5 = paramBuffers.getString("SESSION_USER_ID");
      i = updateOrDelete(str4, j, str2, str1, str3, str5);
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
    this.log.LOG_INFO("退出delServerInfo方法...");
  }

  public int updateOrDelete(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    this.log.LOG_INFO(paramString1 + "}{" + paramInt + "}{" + paramString3 + "}");
    if (paramInt == 20)
    {
      ArrayList localArrayList1 = getServerByID(paramString1, paramString3);
      ArrayList localArrayList2 = getCustSerevicByCustId(paramString1);
      if ((localArrayList2 != null) && (localArrayList2.size() > 0))
        for (int i = 0; i < localArrayList2.size(); i++)
        {
          HashMap localHashMap1 = (HashMap)localArrayList2.get(i);
          String str1 = "";
          String str2 = "";
          if (localHashMap1.get("server_id") != null)
            str1 = localHashMap1.get("server_id").toString();
          if (localHashMap1.get("end_date") != null)
          {
            str2 = localHashMap1.get("end_date").toString();
            if (str2.length() > 10)
              str2 = str2.substring(0, 10);
          }
          if ((localArrayList1 == null) || (localArrayList1.size() <= 0))
            continue;
          for (int j = 0; j < localArrayList1.size(); j++)
          {
            HashMap localHashMap2 = (HashMap)localArrayList1.get(j);
            String str3 = "";
            String str4 = "";
            if (localHashMap2.get("rsrv_str10") != null)
              str3 = localHashMap2.get("rsrv_str10").toString();
            if (localHashMap2.get("end_date") != null)
            {
              str4 = localHashMap2.get("end_date").toString();
              if (str4.length() > 10)
                str4 = str4.substring(0, 10);
            }
            if ((str3 != str1) && (!str3.equalsIgnoreCase(str1)))
              continue;
            ServerExt localServerExt2 = new ServerExt();
            localServerExt2.setParam(":VCUST_ID", paramString1);
            localServerExt2.setParam(":VSERVER_ID", str1);
            String str5 = getDayMinusSResutlt(str2, this.format.format(new Date()));
            str5 = getDateFormateAddDAY(str4, Integer.parseInt(str5));
            this.tradeQuery.executeBy(localServerExt2.insBy("DEL_BY_CUST_ID"));
            ServerExt localServerExt3 = new ServerExt();
            localServerExt3.setParam(":VCUST_ID", paramString1);
            localServerExt3.setParam(":VSTATE_CODE", "4");
            localServerExt3.setParam(":VSERVER_ID", paramString3);
            localServerExt3.setParam(":VEND_DATE", str5);
            this.tradeQuery.executeBy(localServerExt3.insBy("UPDATE_BY_WEB"));
          }
        }
      ServerExt localServerExt1 = new ServerExt();
      localServerExt1.setParam(":VSERVER_ID", paramString3);
      localServerExt1.setParam(":VCUST_ID", paramString1);
      localServerExt1.setParam(":VSTATE_CODE", "4");
      localServerExt1.setParam(":VRSRV_STR5", "w");
      this.tradeQuery.executeBy(localServerExt1.insBy("EDIT_BY_WEB"));
    }
    return 0;
  }

  public HashMap getCustIdByUserName(String paramString)
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

  public ArrayList getCustSerevicByCustId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VCUST_ID", paramString);
    localArrayList = localServerExt.selByList("SEL_BY_STR5");
    return localArrayList;
  }

  public void addManualServerInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addManualServerInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    ServerDAO localServerDAO = new ServerDAO();
    String str1 = paramBuffers.getString("VALUE_ID");
    String str2 = paramBuffers.getString("VALUE_NUM");
    String str3 = paramBuffers.getString("OBJ_CUST_ID");
    String str4 = paramBuffers.getString("SESSION_USER_ID");
    String str5 = paramBuffers.getString("ACCOUNT_ID");
    try
    {
      localServerDAO.setCust_id(str3);
      localServerDAO.setState_code("0");
      localServerDAO.setStaff_id(str4);
      localServerDAO.setRsrv_str1(str1);
      localServerDAO.setRsrv_str2(str2);
      localServerDAO.setRemark("会员手工缴费.");
      localServerDAO.setRsrv_str9(str5);
      localServerDAO.setRsrv_str10(str2);
      localServerDAO.setRsrv_str5("s");
      i = addManualServerInfo(localServerDAO);
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
    this.log.LOG_INFO("退出addManualServerInfo方法...");
  }

  public int addManualServerInfo(ServerDAO paramServerDAO)
    throws SaasApplicationException
  {
    String str1 = paramServerDAO.getRsrv_str1();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    int i = 1;
    String str2 = paramServerDAO.getCust_id();
    while (localStringTokenizer.hasMoreTokens())
    {
      String str3 = localStringTokenizer.nextToken();
      String str4 = str3.substring(0, str3.indexOf("&"));
      String str5 = str3.substring(str3.indexOf("&") + 1, str3.length());
      this.log.LOG_INFO("服务名:s1=" + str4);
      this.log.LOG_INFO("服务月数:s2=" + str5);
      ArrayList localArrayList = getServerByID(str2, str4.toUpperCase());
      Object localObject1;
      Object localObject2;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localObject1 = (HashMap)localArrayList.get(0);
        localObject2 = ((HashMap)localObject1).get("server_id").toString();
        String str6 = ((HashMap)localObject1).get("start_date").toString();
        String str7 = "0";
        if ((((HashMap)localObject1).get("rsrv_str9") != null) && (!str7.equals("")))
          str7 = ((HashMap)localObject1).get("rsrv_str9").toString();
        if (str6.length() > 10)
          str6 = str6.substring(0, 10);
        String str8 = ((HashMap)localObject1).get("end_date").toString();
        if (str8.length() > 10)
          str8 = str8.substring(0, 10);
        if (((String)localObject2).equalsIgnoreCase(str4))
        {
          this.log.LOG_INFO("s2====" + str5);
          this.log.LOG_INFO("rsrv_str9====" + str7);
          str8 = getDateFormateByString(str8, Integer.parseInt(str5));
          ServerExt localServerExt = new ServerExt();
          str7 = Integer.parseInt(str7) + Integer.parseInt(str5) + "";
          localServerExt.setParam(":VCUST_ID", str2);
          localServerExt.setParam(":VSERVER_ID", localObject2);
          localServerExt.setParam(":VSTART_DATE", str6);
          localServerExt.setParam(":VEND_DATE", str8);
          localServerExt.setParam(":VSTAFF_ID", paramServerDAO.getStaff_id());
          localServerExt.setParam(":VSTATE_CODE", paramServerDAO.getState_code());
          localServerExt.setParam(":VREMARK", paramServerDAO.getRemark());
          localServerExt.setParam(":VRSRV_STR9", str7);
          localServerExt.setParam(":VRSRV_STR10", paramServerDAO.getRsrv_str10());
          localServerExt.setParam(":VRSRV_STR5", paramServerDAO.getRsrv_str5());
          this.tradeQuery.executeBy(localServerExt.insBy("UPDATE_BY_ALL"));
        }
      }
      else
      {
        localObject1 = getDateFormateByString(new SimpleDateFormat("yyyy-MM-dd").format(new Date()), Integer.parseInt(str5));
        localObject2 = new ServerExt();
        ((ServerExt)localObject2).setParam(":VCUST_ID", str2);
        ((ServerExt)localObject2).setParam(":VSERVER_ID", str4.toUpperCase());
        ((ServerExt)localObject2).setParam(":VSTART_DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        ((ServerExt)localObject2).setParam(":VEND_DATE", localObject1);
        ((ServerExt)localObject2).setParam(":VSTAFF_ID", paramServerDAO.getStaff_id());
        ((ServerExt)localObject2).setParam(":VSTATE_CODE", paramServerDAO.getState_code());
        ((ServerExt)localObject2).setParam(":VREMARK", paramServerDAO.getRemark());
        ((ServerExt)localObject2).setParam(":VRSRV_STR9", str5);
        ((ServerExt)localObject2).setParam(":VRSRV_STR10", paramServerDAO.getRsrv_str10());
        ((ServerExt)localObject2).setParam(":VRSRV_STR5", paramServerDAO.getRsrv_str5());
        this.tradeQuery.executeBy(((ServerExt)localObject2).insBy("INS_BY_ALL"));
      }
    }
    return 0;
  }

  public void addWebServerInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addWebServerInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    ServerDAO localServerDAO = new ServerDAO();
    String str1 = paramBuffers.getString("VALUE_ID");
    String str2 = paramBuffers.getString("VALUE_NUM");
    String str3 = paramBuffers.getString("OBJ_CUST_ID");
    String str4 = paramBuffers.getString("SESSION_USER_ID");
    String str5 = paramBuffers.getString("ACCOUNT_ID");
    try
    {
      localServerDAO.setCust_id(str3);
      localServerDAO.setState_code("4");
      localServerDAO.setStaff_id(str4);
      localServerDAO.setRsrv_str1(str1);
      localServerDAO.setRsrv_str2(str2);
      localServerDAO.setRemark("会员网上缴费.");
      localServerDAO.setRsrv_str9(str5);
      localServerDAO.setRsrv_str5("w");
      i = addWebServerInfo(localServerDAO);
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
    this.log.LOG_INFO("退出addWebServerInfo方法...");
  }

  public int addWebServerInfo(ServerDAO paramServerDAO)
    throws SaasApplicationException
  {
    String str1 = paramServerDAO.getRsrv_str1();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    String str2 = paramServerDAO.getCust_id();
    while (localStringTokenizer.hasMoreTokens())
    {
      String str3 = localStringTokenizer.nextToken();
      String str4 = str3.substring(0, str3.indexOf("&"));
      String str5 = str3.substring(str3.indexOf("&") + 1, str3.length());
      String str6 = getDateFormateByString(new SimpleDateFormat("yyyy-MM-dd").format(new Date()), Integer.parseInt(str5));
      ServerExt localServerExt = new ServerExt();
      localServerExt.setParam(":VCUST_ID", str2);
      localServerExt.setParam(":VSERVER_ID", paramServerDAO.getRsrv_str9());
      localServerExt.setParam(":VSTART_DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
      localServerExt.setParam(":VEND_DATE", str6);
      localServerExt.setParam(":VSTAFF_ID", paramServerDAO.getStaff_id());
      localServerExt.setParam(":VSTATE_CODE", paramServerDAO.getState_code());
      localServerExt.setParam(":VREMARK", paramServerDAO.getRemark());
      localServerExt.setParam(":VRSRV_STR9", str5);
      localServerExt.setParam(":VRSRV_STR10", str4.toUpperCase());
      localServerExt.setParam(":VRSRV_STR5", paramServerDAO.getRsrv_str5());
      this.tradeQuery.executeBy(localServerExt.insBy("INS_BY_ALL"));
    }
    return 0;
  }

  public ArrayList getServerListByCustId(String paramString)
    throws SaasApplicationException
  {
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localServerExt.selByList("SEL_CHECK_SERVER");
    return localArrayList;
  }

  public String getDateFormateByString(String paramString, int paramInt)
    throws SaasApplicationException
  {
    String str = "";
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date();
    try
    {
      localDate = localSimpleDateFormat.parse(paramString);
    }
    catch (ParseException localParseException)
    {
      this.log.LOG_INFO("modth=>>>>>>>>" + paramInt);
    }
    localCalendar.setTime(localDate);
    localCalendar.add(2, paramInt);
    str = localSimpleDateFormat.format(localCalendar.getTime());
    this.log.LOG_INFO("返回时间=====>" + str);
    return str;
  }

  public String getDateFormateAddDAY(String paramString, int paramInt)
    throws SaasApplicationException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date();
    try
    {
      localDate = localSimpleDateFormat.parse(paramString);
      localCalendar.setTime(localDate);
      localCalendar.add(5, paramInt);
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return localSimpleDateFormat.format(localCalendar.getTime());
  }

  public String getDayMinusSResutlt(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str = "";
    try
    {
      Date localDate1 = localSimpleDateFormat.parse(paramString1);
      Date localDate2 = localSimpleDateFormat.parse(paramString2);
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTime(localDate1);
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime(localDate2);
      str = "" + Math.abs((localCalendar2.getTimeInMillis() - localCalendar1.getTimeInMillis()) / 86400000L);
    }
    catch (ParseException localParseException)
    {
      this.log.LOG_INFO("时间类型出错...");
    }
    return str;
  }

  public ArrayList getUseServerListByCust(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VCUST_ID", paramString1);
    localServerExt.setParam(":VSTATE_CODE", paramString2);
    localArrayList = localServerExt.selByList("SEL_BY_USER_SERVER");
    return localArrayList;
  }

  public String getCustServerSelect(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VCUST_ID", paramString1);
    localServerExt.setParam(":VSTATE_CODE", paramString2);
    localServerExt.setParam(":VSTATE_CODE1", paramString3);
    localServerExt.setParam(":VPARAM_ATTR", paramString4);
    localArrayList = localServerExt.selByList("SEL_BY_PARAM_SERVER");
    this.log.LOG_INFO("===" + localArrayList);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("para_code1").toString();
        String str3 = localHashMap.get("para_code1").toString();
        str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>";
      }
    return str1;
  }

  public void eidtServerInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入eidtServerInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("OBJ_CUST_ID");
    try
    {
      i = eidtServerInfo(str);
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
    this.log.LOG_INFO("退出eidtServerInfo方法...");
  }

  public int eidtServerInfo(String paramString)
    throws SaasApplicationException
  {
    ServerExt localServerExt = new ServerExt();
    localServerExt.setParam(":VCUST_ID", paramString);
    this.tradeQuery.executeBy(localServerExt.insBy("EDIT_CUST_SERVER"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.serverMgr.ServerInfo
 * JD-Core Version:    0.6.0
 */