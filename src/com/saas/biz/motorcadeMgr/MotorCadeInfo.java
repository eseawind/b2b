package com.saas.biz.motorcadeMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.motorcadeDAO.MotorCadeDao;
import com.saas.biz.dao.motorcadeDAO.MotorCadeExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MotorCadeInfo
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

  public void addMotorCadeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addMotorCadeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TEAM_ID");
    String str3 = paramBuffers.getString("TEAM_NAME");
    String str4 = paramBuffers.getString("TEAM_NO");
    String str5 = paramBuffers.getString("AUTO_NUM");
    String str6 = paramBuffers.getString("CREATE_DATE");
    String str7 = paramBuffers.getString("SHIP_RAGE");
    String str8 = paramBuffers.getString("OWN_USER_ID");
    String str9 = paramBuffers.getString("CONTACT");
    String str10 = paramBuffers.getString("CONTACT_PHPNE");
    String str11 = paramBuffers.getString("SALE_MAN");
    String str12 = paramBuffers.getString("SHIP_NUM");
    String str13 = paramBuffers.getString("SHIP_TYPE");
    String str14 = paramBuffers.getString("STATE_CODE");
    String str15 = this.comm.GenSysdate("1");
    String str16 = paramBuffers.getString("RSRV_STR1");
    String str17 = paramBuffers.getString("RSRV_STR2");
    String str18 = paramBuffers.getString("RSRV_STR3");
    String str19 = paramBuffers.getString("RSRV_STR4");
    String str20 = paramBuffers.getString("RSRV_STR5");
    String str21 = paramBuffers.getString("RSRV_STR8");
    String str22 = paramBuffers.getString("RSRV_STR9");
    String str23 = paramBuffers.getString("RSRV_STR10");
    String str24 = str15;
    String str25 = paramBuffers.getString("SESSION_USER_ID");
    String str26 = paramBuffers.getString("REMARK");
    try
    {
      MotorCadeDao localMotorCadeDao = new MotorCadeDao();
      localMotorCadeDao.setContact(str9);
      localMotorCadeDao.setCust_id(str1);
      localMotorCadeDao.setTeam_id(str2);
      localMotorCadeDao.setCreate_date(str6);
      localMotorCadeDao.setShip_num(str12);
      localMotorCadeDao.setSale_man(str11);
      localMotorCadeDao.setTeam_name(str3);
      localMotorCadeDao.setTeam_no(str4);
      localMotorCadeDao.setShip_rage(str7);
      localMotorCadeDao.setContact_phpne(str10);
      localMotorCadeDao.setAuto_num(str5);
      localMotorCadeDao.setRemark(str26);
      localMotorCadeDao.setState_code_date(str15);
      localMotorCadeDao.setState_code(str14);
      localMotorCadeDao.setOwn_user_id(str8);
      localMotorCadeDao.setShip_type(str13);
      localMotorCadeDao.setOper_date(str24);
      localMotorCadeDao.setRsrv_str1(str16);
      localMotorCadeDao.setRsrv_str2(str17);
      localMotorCadeDao.setRsrv_str4(str19);
      localMotorCadeDao.setRsrv_str3(str18);
      localMotorCadeDao.setRsrv_str8(str21);
      localMotorCadeDao.setRsrv_str9(str22);
      localMotorCadeDao.setRsrv_str5(str20);
      localMotorCadeDao.setRsrv_str10(str23);
      localMotorCadeDao.setUser_id(str25);
      i = addMotorCadeInfo(localMotorCadeDao);
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
    this.log.LOG_INFO("退出addMotorCadeInfo方法...");
  }

  public int addMotorCadeInfo(MotorCadeDao paramMotorCadeDao)
    throws SaasApplicationException
  {
    MotorCadeExt localMotorCadeExt = new MotorCadeExt();
    localMotorCadeExt.setParam(":VCONTACT", paramMotorCadeDao.getContact());
    localMotorCadeExt.setParam(":VCUST_ID", paramMotorCadeDao.getCust_id());
    localMotorCadeExt.setParam(":VTEAM_ID", paramMotorCadeDao.getTeam_id());
    localMotorCadeExt.setParam(":VCREATE_DATE", paramMotorCadeDao.getCreate_date());
    localMotorCadeExt.setParam(":VSHIP_NUM", paramMotorCadeDao.getShip_num());
    localMotorCadeExt.setParam(":VSALE_MAN", paramMotorCadeDao.getSale_man());
    localMotorCadeExt.setParam(":VTEAM_NAME", paramMotorCadeDao.getTeam_name());
    localMotorCadeExt.setParam(":VTEAM_NO", paramMotorCadeDao.getTeam_no());
    localMotorCadeExt.setParam(":VSHIP_RAGE", paramMotorCadeDao.getShip_rage());
    localMotorCadeExt.setParam(":VCONTACT_PHPNE", paramMotorCadeDao.getContact_phpne());
    localMotorCadeExt.setParam(":VAUTO_NUM", paramMotorCadeDao.getAuto_num());
    localMotorCadeExt.setParam(":VREMARK", paramMotorCadeDao.getRemark());
    localMotorCadeExt.setParam(":VSTATE_CODE_DATE", paramMotorCadeDao.getState_code_date());
    localMotorCadeExt.setParam(":VSTATE_CODE", paramMotorCadeDao.getState_code());
    localMotorCadeExt.setParam(":VOWN_USER_ID", paramMotorCadeDao.getOwn_user_id());
    localMotorCadeExt.setParam(":VSHIP_TYPE", paramMotorCadeDao.getShip_type());
    localMotorCadeExt.setParam(":VOPER_DATE", paramMotorCadeDao.getOper_date());
    localMotorCadeExt.setParam(":VRSRV_STR1", paramMotorCadeDao.getRsrv_str1());
    localMotorCadeExt.setParam(":VRSRV_STR2", paramMotorCadeDao.getRsrv_str2());
    localMotorCadeExt.setParam(":VRSRV_STR4", paramMotorCadeDao.getRsrv_str4());
    localMotorCadeExt.setParam(":VRSRV_STR3", paramMotorCadeDao.getRsrv_str3());
    localMotorCadeExt.setParam(":VRSRV_STR8", paramMotorCadeDao.getRsrv_str8());
    localMotorCadeExt.setParam(":VRSRV_STR9", paramMotorCadeDao.getRsrv_str9());
    localMotorCadeExt.setParam(":VRSRV_STR5", paramMotorCadeDao.getRsrv_str5());
    localMotorCadeExt.setParam(":VRSRV_STR10", paramMotorCadeDao.getRsrv_str10());
    localMotorCadeExt.setParam(":VUSER_ID", paramMotorCadeDao.getUser_id());
    this.tradeQuery.executeBy(localMotorCadeExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void editMotorCadeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入editMotorCadeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TEAM_ID");
    String str3 = paramBuffers.getString("TEAM_NAME");
    String str4 = paramBuffers.getString("TEAM_NO");
    String str5 = paramBuffers.getString("AUTO_NUM");
    String str6 = paramBuffers.getString("CREATE_DATE");
    String str7 = paramBuffers.getString("SHIP_RAGE");
    String str8 = paramBuffers.getString("OWN_USER_ID");
    String str9 = paramBuffers.getString("CONTACT");
    String str10 = paramBuffers.getString("CONTACT_PHPNE");
    String str11 = paramBuffers.getString("SALE_MAN");
    String str12 = paramBuffers.getString("SHIP_NUM");
    String str13 = paramBuffers.getString("SHIP_TYPE");
    String str14 = paramBuffers.getString("STATE_CODE");
    String str15 = this.comm.GenSysdate("1");
    String str16 = paramBuffers.getString("RSRV_STR1");
    String str17 = paramBuffers.getString("RSRV_STR2");
    String str18 = paramBuffers.getString("RSRV_STR3");
    String str19 = paramBuffers.getString("RSRV_STR4");
    String str20 = paramBuffers.getString("RSRV_STR5");
    String str21 = paramBuffers.getString("RSRV_STR8");
    String str22 = paramBuffers.getString("RSRV_STR9");
    String str23 = paramBuffers.getString("RSRV_STR10");
    String str24 = str15;
    String str25 = paramBuffers.getString("SESSION_USER_ID");
    String str26 = paramBuffers.getString("REMARK");
    try
    {
      MotorCadeDao localMotorCadeDao = new MotorCadeDao();
      localMotorCadeDao.setContact(str9);
      localMotorCadeDao.setCust_id(str1);
      localMotorCadeDao.setTeam_id(str2);
      localMotorCadeDao.setCreate_date(str6);
      localMotorCadeDao.setShip_num(str12);
      localMotorCadeDao.setSale_man(str11);
      localMotorCadeDao.setTeam_name(str3);
      localMotorCadeDao.setTeam_no(str4);
      localMotorCadeDao.setShip_rage(str7);
      localMotorCadeDao.setContact_phpne(str10);
      localMotorCadeDao.setAuto_num(str5);
      localMotorCadeDao.setRemark(str26);
      localMotorCadeDao.setState_code_date(str15);
      localMotorCadeDao.setState_code(str14);
      localMotorCadeDao.setOwn_user_id(str8);
      localMotorCadeDao.setShip_type(str13);
      localMotorCadeDao.setOper_date(str24);
      localMotorCadeDao.setRsrv_str1(str16);
      localMotorCadeDao.setRsrv_str2(str17);
      localMotorCadeDao.setRsrv_str4(str19);
      localMotorCadeDao.setRsrv_str3(str18);
      localMotorCadeDao.setRsrv_str8(str21);
      localMotorCadeDao.setRsrv_str9(str22);
      localMotorCadeDao.setRsrv_str5(str20);
      localMotorCadeDao.setRsrv_str10(str23);
      localMotorCadeDao.setUser_id(str25);
      i = editMotorCadeInfo(localMotorCadeDao);
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
    this.log.LOG_INFO("退出editMotorCadeInfo方法...");
  }

  public int editMotorCadeInfo(MotorCadeDao paramMotorCadeDao)
    throws SaasApplicationException
  {
    MotorCadeExt localMotorCadeExt = new MotorCadeExt();
    localMotorCadeExt.setParam(":VCONTACT", paramMotorCadeDao.getContact());
    localMotorCadeExt.setParam(":VCUST_ID", paramMotorCadeDao.getCust_id());
    localMotorCadeExt.setParam(":VTEAM_ID", paramMotorCadeDao.getTeam_id());
    localMotorCadeExt.setParam(":VCREATE_DATE", paramMotorCadeDao.getCreate_date());
    localMotorCadeExt.setParam(":VSHIP_NUM", paramMotorCadeDao.getShip_num());
    localMotorCadeExt.setParam(":VSALE_MAN", paramMotorCadeDao.getSale_man());
    localMotorCadeExt.setParam(":VTEAM_NAME", paramMotorCadeDao.getTeam_name());
    localMotorCadeExt.setParam(":VTEAM_NO", paramMotorCadeDao.getTeam_no());
    localMotorCadeExt.setParam(":VSHIP_RAGE", paramMotorCadeDao.getShip_rage());
    localMotorCadeExt.setParam(":VCONTACT_PHPNE", paramMotorCadeDao.getContact_phpne());
    localMotorCadeExt.setParam(":VAUTO_NUM", paramMotorCadeDao.getAuto_num());
    localMotorCadeExt.setParam(":VREMARK", paramMotorCadeDao.getRemark());
    localMotorCadeExt.setParam(":VSTATE_CODE_DATE", paramMotorCadeDao.getState_code_date());
    localMotorCadeExt.setParam(":VSTATE_CODE", paramMotorCadeDao.getState_code());
    localMotorCadeExt.setParam(":VOWN_USER_ID", paramMotorCadeDao.getOwn_user_id());
    localMotorCadeExt.setParam(":VSHIP_TYPE", paramMotorCadeDao.getShip_type());
    localMotorCadeExt.setParam(":VOPER_DATE", paramMotorCadeDao.getOper_date());
    localMotorCadeExt.setParam(":VRSRV_STR1", paramMotorCadeDao.getRsrv_str1());
    localMotorCadeExt.setParam(":VRSRV_STR2", paramMotorCadeDao.getRsrv_str2());
    localMotorCadeExt.setParam(":VRSRV_STR4", paramMotorCadeDao.getRsrv_str4());
    localMotorCadeExt.setParam(":VRSRV_STR3", paramMotorCadeDao.getRsrv_str3());
    localMotorCadeExt.setParam(":VRSRV_STR8", paramMotorCadeDao.getRsrv_str8());
    localMotorCadeExt.setParam(":VRSRV_STR9", paramMotorCadeDao.getRsrv_str9());
    localMotorCadeExt.setParam(":VRSRV_STR5", paramMotorCadeDao.getRsrv_str5());
    localMotorCadeExt.setParam(":VRSRV_STR10", paramMotorCadeDao.getRsrv_str10());
    localMotorCadeExt.setParam(":VUSER_ID", paramMotorCadeDao.getUser_id());
    this.tradeQuery.executeBy(localMotorCadeExt.insBy("EDIT_BY_ALL"));
    return 0;
  }

  public void delMotorCadeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delMotorCadeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TEAM_ID");
    try
    {
      MotorCadeDao localMotorCadeDao = new MotorCadeDao();
      localMotorCadeDao.setCust_id(str1);
      localMotorCadeDao.setTeam_id(str2);
      i = delMotorCadeInfo(localMotorCadeDao);
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
    this.log.LOG_INFO("退出delMotorCadeInfo方法...");
  }

  public int delMotorCadeInfo(MotorCadeDao paramMotorCadeDao)
    throws SaasApplicationException
  {
    MotorCadeExt localMotorCadeExt = new MotorCadeExt();
    localMotorCadeExt.setParam(":VCUST_ID", paramMotorCadeDao.getCust_id());
    localMotorCadeExt.setParam(":VTEAM_ID", paramMotorCadeDao.getTeam_id());
    this.tradeQuery.executeBy(localMotorCadeExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public ArrayList getMororCadeByCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    MotorCadeExt localMotorCadeExt = new MotorCadeExt();
    localMotorCadeExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localMotorCadeExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getMororCadeCountByCust(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    MotorCadeExt localMotorCadeExt = new MotorCadeExt();
    localMotorCadeExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localMotorCadeExt.selByList("SEL_COUNT_BY_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public HashMap getMotorCadeById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    MotorCadeExt localMotorCadeExt = new MotorCadeExt();
    localMotorCadeExt.setParam(":VTEAM_ID", paramString);
    ArrayList localArrayList = localMotorCadeExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public String getMotorCadeNameById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    HashMap localHashMap = getMotorCadeById(paramString);
    if (localHashMap.get("team_name") != null)
      str = localHashMap.get("team_name").toString();
    return str;
  }

  public String getCarTeamByJson(int paramInt, String paramString)
    throws SaasApplicationException
  {
    String str1 = "";
    int i = getMororCadeCountByCust(paramString);
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    MotorCadeExt localMotorCadeExt = new MotorCadeExt();
    localMotorCadeExt.setParam(":VCUST_ID", paramString);
    localArrayList = localMotorCadeExt.selByList("SEL_BY_CUST", paramInt, 10);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int j = 0; j < localArrayList.size(); j++)
      {
        JSONObject localJSONObject2 = new JSONObject();
        HashMap localHashMap = (HashMap)localArrayList.get(j);
        String str2 = localHashMap.get("team_id").toString();
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (localHashMap.get("team_name") != null)
          str3 = localHashMap.get("team_name").toString();
        if (localHashMap.get("team_no") != null)
          str4 = localHashMap.get("team_no").toString();
        if (localHashMap.get("auto_num") != null)
          str5 = localHashMap.get("auto_num").toString();
        if (localHashMap.get("create_date") != null)
        {
          str6 = localHashMap.get("create_date").toString();
          if (str6.length() > 10)
            str6 = str6.substring(0, 10);
        }
        localJSONObject2.put("id", str2);
        localJSONObject2.put("team_name", str3);
        localJSONObject2.put("team_no", str4);
        localJSONObject2.put("auto_num", str5);
        localJSONObject2.put("date", str6);
        localJSONArray.add(localJSONObject2);
      }
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("root", localJSONArray);
    localJSONObject1.put("totalCount", Integer.valueOf(i));
    str1 = localJSONObject1.toString();
    return str1;
  }

  public ArrayList getCarAndTeamById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MotorCadeExt localMotorCadeExt = new MotorCadeExt();
    localMotorCadeExt.setParam(":VCUST_ID", paramString);
    localArrayList = localMotorCadeExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.motorcadeMgr.MotorCadeInfo
 * JD-Core Version:    0.6.0
 */