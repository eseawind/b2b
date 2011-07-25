package com.saas.biz.conTractMgr;

import com.saas.biz.dao.contractDAO.ContractDAO;
import com.saas.biz.dao.contractDAO.ContractExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ConTractInfo
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

  public static String getConNo(String paramString1, String paramString2)
  {
    Calendar localCalendar = Calendar.getInstance();
    String str1 = new SimpleDateFormat("yyyyMMdd").format(localCalendar.getTime());
    String str2 = "";
    for (int i = 1; i <= Integer.parseInt(paramString2); i++)
      str2 = str2 + paramString1 + "-" + str1 + "-" + i + "|";
    return str2;
  }

  public void addConTractInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addConTractInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = paramBuffers.getString("CON_NAME");
    String str4 = paramBuffers.getString("OBJ_CUST_NAME");
    String str5 = paramBuffers.getString("PROJ_NAME");
    String str6 = paramBuffers.getString("STATE_CODE");
    String str7 = paramBuffers.getString("CON_CLASS");
    String str8 = paramBuffers.getString("CO_CLASS");
    String str9 = paramBuffers.getString("STATE_CODE_DATE");
    String str10 = paramBuffers.getString("CON_TYPE");
    String str11 = paramBuffers.getString("CON_EXCUT_WAY");
    String str12 = paramBuffers.getString("FARE_WAY");
    String str13 = paramBuffers.getString("PAY_TYPE");
    String str14 = paramBuffers.getString("CURRENCY");
    String str15 = paramBuffers.getString("CON_SIGN_FARE");
    String str16 = paramBuffers.getString("CON_FARE");
    String str17 = paramBuffers.getString("SIGN_DATE");
    String str18 = paramBuffers.getString("CON_OBJECT");
    String str19 = paramBuffers.getString("START_DATE");
    String str20 = paramBuffers.getString("END_DATE");
    String str21 = paramBuffers.getString("CON_DESC");
    String str22 = paramBuffers.getString("PUBLISH_DATE");
    String str23 = paramBuffers.getString("SESSION_USER_ID");
    String str24 = paramBuffers.getString("REMARK");
    String str25 = "";
    String str26 = "";
    str25 = getConNo(str8, "1");
    try
    {
      ContractDAO localContractDAO = new ContractDAO();
      localContractDAO.setCust_id(str1);
      localContractDAO.setCon_id(str2);
      localContractDAO.setCon_name(str3);
      localContractDAO.setObj_cust_name(str4);
      localContractDAO.setProj_name(str5);
      localContractDAO.setState_code(str6);
      localContractDAO.setCon_class(str7);
      localContractDAO.setState_code_date(str9);
      localContractDAO.setCon_type(str10);
      localContractDAO.setCon_excut_way(str11);
      localContractDAO.setFare_way(str12);
      localContractDAO.setPay_type(str13);
      localContractDAO.setCurrency(str14);
      localContractDAO.setCon_sign_fare(str15);
      localContractDAO.setCon_fare(str16);
      localContractDAO.setSign_date(str17);
      localContractDAO.setCon_object(str18);
      localContractDAO.setStart_date(str19);
      localContractDAO.setEnd_date(str20);
      localContractDAO.setCon_desc(str21);
      localContractDAO.setPublish_date(str22);
      localContractDAO.setUser_id(str23);
      localContractDAO.setRemark(str24);
      StringTokenizer localStringTokenizer = new StringTokenizer(str25, "|");
      while (localStringTokenizer.hasMoreTokens())
      {
        str26 = localStringTokenizer.nextToken();
        localContractDAO.setCon_no(str26);
        i = addConTractInfo(localContractDAO);
      }
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
    this.log.LOG_INFO("退出addConTractInfo方法...");
  }

  public int addConTractInfo(ContractDAO paramContractDAO)
    throws SaasApplicationException
  {
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramContractDAO.getCust_id());
    localContractExt.setParam(":VCON_ID", paramContractDAO.getCon_id());
    localContractExt.setParam(":VCON_NO", paramContractDAO.getCon_no());
    localContractExt.setParam(":VCON_NAME", paramContractDAO.getCon_name());
    localContractExt.setParam(":VOBJ_CUST_NAME", paramContractDAO.getObj_cust_name());
    localContractExt.setParam(":VPROJ_NAME", paramContractDAO.getProj_name());
    localContractExt.setParam(":VSTATE_CODE", paramContractDAO.getState_code());
    localContractExt.setParam(":VCON_CLASS", paramContractDAO.getCon_class());
    localContractExt.setParam(":VSTATE_CODE_DATE", paramContractDAO.getState_code_date());
    localContractExt.setParam(":VCON_TYPE", paramContractDAO.getCon_type());
    localContractExt.setParam(":VCON_EXCUT_WAY", paramContractDAO.getCon_excut_way());
    localContractExt.setParam(":VFARE_WAY", paramContractDAO.getFare_way());
    localContractExt.setParam(":VPAY_TYPE", paramContractDAO.getPay_type());
    localContractExt.setParam(":VCURRENCY", paramContractDAO.getCurrency());
    localContractExt.setParam(":VCON_SIGN_FARE", paramContractDAO.getCon_sign_fare());
    localContractExt.setParam(":VCON_FARE", paramContractDAO.getCon_fare());
    localContractExt.setParam(":VSIGN_DATE", paramContractDAO.getSign_date());
    localContractExt.setParam(":VCON_OBJECT", paramContractDAO.getCon_object());
    localContractExt.setParam(":VSTART_DATE", paramContractDAO.getStart_date());
    localContractExt.setParam(":VEND_DATE", paramContractDAO.getEnd_date());
    localContractExt.setParam(":VCON_DESC", paramContractDAO.getCon_desc());
    localContractExt.setParam(":VPUBLISH_DATE", paramContractDAO.getPublish_date());
    localContractExt.setParam(":VUSER_ID", paramContractDAO.getUser_id());
    localContractExt.setParam(":VREMARK", paramContractDAO.getRemark());
    this.tradeQuery.executeBy(localContractExt.insBy("INS_BY_CON_TRACT"));
    return 0;
  }

  public ArrayList getConTractList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString1);
    localContractExt.setParam(":VSTATE_CODE", paramString2);
    ArrayList localArrayList = localContractExt.selByList("SEL_BY_CONT", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getWarnConTractList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString1);
    localContractExt.setParam(":VSTATE_CODE", paramString2);
    ArrayList localArrayList = localContractExt.selByList("SEL_WARE_BY_CONT");
    return localArrayList;
  }

  public int getConTractList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString1);
    localContractExt.setParam(":VSTATE_CODE", paramString2);
    ArrayList localArrayList = localContractExt.selByList("SEL_BY_CONT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void modifyConTractList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyConTractList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = paramBuffers.getString("CON_NAME");
    String str4 = paramBuffers.getString("OBJ_CUST_NAME");
    String str5 = paramBuffers.getString("PROJ_NAME");
    String str6 = paramBuffers.getString("STATE_CODE");
    String str7 = paramBuffers.getString("CON_CLASS");
    String str8 = paramBuffers.getString("STATE_CODE_DATE");
    String str9 = paramBuffers.getString("CON_TYPE");
    String str10 = paramBuffers.getString("CON_EXCUT_WAY");
    String str11 = paramBuffers.getString("FARE_WAY");
    String str12 = paramBuffers.getString("PAY_TYPE");
    String str13 = paramBuffers.getString("CURRENCY");
    String str14 = paramBuffers.getString("CON_SIGN_FARE");
    String str15 = paramBuffers.getString("CON_FARE");
    String str16 = paramBuffers.getString("SIGN_DATE");
    String str17 = paramBuffers.getString("CON_OBJECT");
    String str18 = paramBuffers.getString("START_DATE");
    String str19 = paramBuffers.getString("END_DATE");
    String str20 = paramBuffers.getString("CON_DESC");
    String str21 = paramBuffers.getString("PUBLISH_DATE");
    String str22 = paramBuffers.getString("SESSION_USER_ID");
    String str23 = paramBuffers.getString("REMARK");
    try
    {
      ContractDAO localContractDAO = new ContractDAO();
      localContractDAO.setCust_id(str1);
      localContractDAO.setCon_id(str2);
      localContractDAO.setCon_name(str3);
      localContractDAO.setObj_cust_name(str4);
      localContractDAO.setProj_name(str5);
      localContractDAO.setState_code(str6);
      localContractDAO.setCon_class(str7);
      localContractDAO.setState_code_date(str8);
      localContractDAO.setCon_type(str9);
      localContractDAO.setCon_excut_way(str10);
      localContractDAO.setFare_way(str11);
      localContractDAO.setPay_type(str12);
      localContractDAO.setCurrency(str13);
      localContractDAO.setCon_sign_fare(str14);
      localContractDAO.setCon_fare(str15);
      localContractDAO.setSign_date(str16);
      localContractDAO.setCon_object(str17);
      localContractDAO.setStart_date(str18);
      localContractDAO.setEnd_date(str19);
      localContractDAO.setCon_desc(str20);
      localContractDAO.setPublish_date(str21);
      localContractDAO.setUser_id(str22);
      localContractDAO.setRemark(str23);
      i = modifyConTractList(localContractDAO);
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
    this.log.LOG_INFO("退出modifyConTractList方法...");
  }

  public int modifyConTractList(ContractDAO paramContractDAO)
    throws SaasApplicationException
  {
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramContractDAO.getCust_id());
    localContractExt.setParam(":VCON_ID", paramContractDAO.getCon_id());
    localContractExt.setParam(":VCON_NAME", paramContractDAO.getCon_name());
    localContractExt.setParam(":VOBJ_CUST_NAME", paramContractDAO.getObj_cust_name());
    localContractExt.setParam(":VPROJ_NAME", paramContractDAO.getProj_name());
    localContractExt.setParam(":VSTATE_CODE", paramContractDAO.getState_code());
    localContractExt.setParam(":VCON_CLASS", paramContractDAO.getCon_class());
    localContractExt.setParam(":VSTATE_CODE_DATE", paramContractDAO.getState_code_date());
    localContractExt.setParam(":VCON_TYPE", paramContractDAO.getCon_type());
    localContractExt.setParam(":VCON_EXCUT_WAY", paramContractDAO.getCon_excut_way());
    localContractExt.setParam(":VFARE_WAY", paramContractDAO.getFare_way());
    localContractExt.setParam(":VPAY_TYPE", paramContractDAO.getPay_type());
    localContractExt.setParam(":VCURRENCY", paramContractDAO.getCurrency());
    localContractExt.setParam(":VCON_SIGN_FARE", paramContractDAO.getCon_sign_fare());
    localContractExt.setParam(":VCON_FARE", paramContractDAO.getCon_fare());
    localContractExt.setParam(":VSIGN_DATE", paramContractDAO.getSign_date());
    localContractExt.setParam(":VCON_OBJECT", paramContractDAO.getCon_object());
    localContractExt.setParam(":VSTART_DATE", paramContractDAO.getStart_date());
    localContractExt.setParam(":VEND_DATE", paramContractDAO.getEnd_date());
    localContractExt.setParam(":VCON_DESC", paramContractDAO.getCon_desc());
    localContractExt.setParam(":VPUBLISH_DATE", paramContractDAO.getPublish_date());
    localContractExt.setParam(":VUSER_ID", paramContractDAO.getUser_id());
    localContractExt.setParam(":VREMARK", paramContractDAO.getRemark());
    this.tradeQuery.executeBy(localContractExt.insBy("UP_CON_BY_TRACT"));
    return 0;
  }

  public void DelConList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入DelConList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    try
    {
      ContractDAO localContractDAO = new ContractDAO();
      localContractDAO.setCust_id(str1);
      localContractDAO.setCon_id(str2);
      i = DelConList(localContractDAO);
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
    this.log.LOG_INFO("退出DelConList方法...");
  }

  public int DelConList(ContractDAO paramContractDAO)
    throws SaasApplicationException
  {
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramContractDAO.getCust_id());
    localContractExt.setParam(":VCON_ID", paramContractDAO.getCon_id());
    this.tradeQuery.executeBy(localContractExt.insBy("DEL_CON_BY_TRACT"));
    return 0;
  }

  public ArrayList getListByConId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString1);
    localContractExt.setParam(":VCON_ID", paramString2);
    ArrayList localArrayList = localContractExt.selByList("SEL_BY_CON_ID");
    return localArrayList;
  }

  public String getEndDateByConId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString1);
    localContractExt.setParam(":VCON_ID", paramString2);
    ArrayList localArrayList = localContractExt.selByList("SEL_BY_CON_ID");
    String str = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("end_date") != null)
        str = localHashMap.get("end_date").toString();
    }
    return str;
  }

  public ArrayList getConStateList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localContractExt.selByList("SEL_BY_CON_STATE", paramInt, 20);
    return localArrayList;
  }

  public int getConStateList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localContractExt.selByList("SEL_BY_CON_STATE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getConStateList1(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString1);
    localContractExt.setParam(":VSTATE_CODE", paramString2);
    ArrayList localArrayList = localContractExt.selByList("SEL_BY_CONSTATE", paramInt, 20);
    return localArrayList;
  }

  public int getConStateList1(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString1);
    localContractExt.setParam(":VSTATE_CODE", paramString2);
    ArrayList localArrayList = localContractExt.selByList("SEL_BY_CONSTATE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void modifyConStateList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyConStateList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = paramBuffers.getString("STATE_CODE");
    String str4 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      ContractDAO localContractDAO = new ContractDAO();
      localContractDAO.setCust_id(str1);
      localContractDAO.setCon_id(str2);
      localContractDAO.setState_code(str3);
      localContractDAO.setUser_id(str4);
      i = modifyConStateList(localContractDAO);
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
    this.log.LOG_INFO("退出modifyConTractList方法...");
  }

  public int modifyConStateList(ContractDAO paramContractDAO)
    throws SaasApplicationException
  {
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramContractDAO.getCust_id());
    localContractExt.setParam(":VCON_ID", paramContractDAO.getCon_id());
    localContractExt.setParam(":VSTATE_CODE", paramContractDAO.getState_code());
    localContractExt.setParam(":VUSER_ID", paramContractDAO.getUser_id());
    this.tradeQuery.executeBy(localContractExt.insBy("UP_CON_BY_STATE"));
    return 0;
  }

  public ArrayList getContractByView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString3);
    localContractExt.setParam(":VCON_NAME", "%" + paramString4 + "%");
    localContractExt.setParam(":VSTATE_CODE", "%" + paramString5 + "%");
    localContractExt.setParam(":VCON_TYPE", "%" + paramString6 + "%");
    localContractExt.setParam(":VCON_EXCUT_WAY", "%" + paramString7 + "%");
    localContractExt.setParam(":VCON_CLASS", "%" + paramString8 + "%");
    localContractExt.setParam(":VSIGN_DATE", "%" + paramString1 + "%");
    localContractExt.setParam(":VSIGN_DATE_T", "%" + paramString2 + "%");
    localContractExt.setParam(":VCON_OBJECT", "%" + paramString9 + "%");
    localArrayList = localContractExt.selByList("SEL_CONTRACT_BY_VIEW", paramInt, 20);
    return localArrayList;
  }

  public int getContractByView(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ContractExt localContractExt = new ContractExt();
    localContractExt.setParam(":VCUST_ID", paramString3);
    localContractExt.setParam(":VCON_NAME", "%" + paramString4 + "%");
    localContractExt.setParam(":VSTATE_CODE", "%" + paramString5 + "%");
    localContractExt.setParam(":VCON_TYPE", "%" + paramString6 + "%");
    localContractExt.setParam(":VCON_EXCUT_WAY", "%" + paramString7 + "%");
    localContractExt.setParam(":VCON_CLASS", "%" + paramString8 + "%");
    localContractExt.setParam(":VSIGN_DATE", "%" + paramString1 + "%");
    localContractExt.setParam(":VSIGN_DATE_T", "%" + paramString2 + "%");
    localContractExt.setParam(":VCON_OBJECT", "%" + paramString9 + "%");
    localArrayList = localContractExt.selByList("SEL_CONTRACT_BY_VIEW");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.conTractMgr.ConTractInfo
 * JD-Core Version:    0.6.0
 */