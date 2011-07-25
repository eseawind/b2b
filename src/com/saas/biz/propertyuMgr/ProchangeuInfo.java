package com.saas.biz.propertyuMgr;

import com.saas.biz.commen.ParamethodMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.prochangeuDAO.ProchangeuDAO;
import com.saas.biz.dao.prochangeuDAO.ProchangeuExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ProchangeuInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr comm = new commMethodMgr();
  ParamethodMgr param = new ParamethodMgr();
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

  public void addDefaultProchange(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addDefaultProchange方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("USER_ID");
    String str2 = paramBuffers.getString("PROPERTY_TYPE");
    String str3 = paramBuffers.getString("PROPERTY_VALUE");
    String str4 = paramBuffers.getString("PROPERTY_VALUE");
    String str5 = this.comm.GenSysdate("1");
    String str6 = "0";
    String str7 = "";
    String str8 = "system";
    String str9 = str5;
    String str10 = "";
    String str11 = "";
    String str12 = "";
    String str13 = "";
    String str14 = "";
    String str15 = "";
    String str16 = "";
    String str17 = paramBuffers.getString("REMARK");
    try
    {
      ProchangeuDAO localProchangeuDAO = new ProchangeuDAO();
      localProchangeuDAO.setUser_id(str1);
      localProchangeuDAO.setProperty_type(str2);
      localProchangeuDAO.setProperty_value(str3);
      localProchangeuDAO.setChange_date(str5);
      localProchangeuDAO.setChange_value(str4);
      localProchangeuDAO.setRemark(str17);
      localProchangeuDAO.setOld_value(str6);
      localProchangeuDAO.setChange_reason(str7);
      localProchangeuDAO.setRsrv_str10(str16);
      localProchangeuDAO.setChange_user_id(str8);
      localProchangeuDAO.setOper_date(str9);
      localProchangeuDAO.setRsrv_str1(str10);
      localProchangeuDAO.setRsrv_str2(str11);
      localProchangeuDAO.setRsrv_str3(str12);
      localProchangeuDAO.setRsrv_str7(str13);
      localProchangeuDAO.setRsrv_str8(str14);
      localProchangeuDAO.setRsrv_str9(str15);
      i = addDefaultProchange(localProchangeuDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "5业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addDefaultProchange方法...");
  }

  public void addDefaultProchangeAgain(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addDefaultProchange方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("USER_ID");
    String str2 = paramBuffers.getString("PROPERTY_TYPE");
    String str3 = paramBuffers.getString("PROPERTY_VALUE");
    String str4 = paramBuffers.getString("CHANGE_VALUE");
    String str5 = this.comm.GenSysdate("1");
    String str6 = paramBuffers.getString("OLD_VALUE");
    String str7 = paramBuffers.getString("CHANGE_REASON");
    String str8 = "system";
    String str9 = str5;
    String str10 = "";
    String str11 = "";
    String str12 = "";
    String str13 = "";
    String str14 = "";
    String str15 = "";
    String str16 = "";
    String str17 = paramBuffers.getString("REMARK");
    try
    {
      ProchangeuDAO localProchangeuDAO = new ProchangeuDAO();
      localProchangeuDAO.setUser_id(str1);
      localProchangeuDAO.setProperty_type(str2);
      localProchangeuDAO.setProperty_value(str3);
      localProchangeuDAO.setChange_date(str5);
      localProchangeuDAO.setChange_value(str4);
      localProchangeuDAO.setRemark(str17);
      localProchangeuDAO.setOld_value(str6);
      localProchangeuDAO.setChange_reason(str7);
      localProchangeuDAO.setRsrv_str10(str16);
      localProchangeuDAO.setChange_user_id(str8);
      localProchangeuDAO.setOper_date(str9);
      localProchangeuDAO.setRsrv_str1(str10);
      localProchangeuDAO.setRsrv_str2(str11);
      localProchangeuDAO.setRsrv_str3(str12);
      localProchangeuDAO.setRsrv_str7(str13);
      localProchangeuDAO.setRsrv_str8(str14);
      localProchangeuDAO.setRsrv_str9(str15);
      i = addDefaultProchange(localProchangeuDAO);
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
    this.log.LOG_INFO("退出addDefaultProchange方法...");
  }

  public int addDefaultProchange(ProchangeuDAO paramProchangeuDAO)
    throws SaasApplicationException
  {
    ProchangeuExt localProchangeuExt = new ProchangeuExt();
    localProchangeuExt.setParam(":VUSER_ID", paramProchangeuDAO.getUser_id());
    localProchangeuExt.setParam(":VPROPERTY_TYPE", paramProchangeuDAO.getProperty_type());
    localProchangeuExt.setParam(":VPROPERTY_VALUE", paramProchangeuDAO.getProperty_value());
    localProchangeuExt.setParam(":VCHANGE_DATE", paramProchangeuDAO.getChange_date());
    localProchangeuExt.setParam(":VCHANGE_VALUE", paramProchangeuDAO.getChange_value());
    localProchangeuExt.setParam(":VREMARK", paramProchangeuDAO.getRemark());
    localProchangeuExt.setParam(":VOLD_VALUE", paramProchangeuDAO.getOld_value());
    localProchangeuExt.setParam(":VCHANGE_REASON", paramProchangeuDAO.getChange_reason());
    localProchangeuExt.setParam(":VRSRV_STR10", paramProchangeuDAO.getRsrv_str10());
    localProchangeuExt.setParam(":VCHANGE_USER_ID", paramProchangeuDAO.getChange_user_id());
    localProchangeuExt.setParam(":VOPER_DATE", paramProchangeuDAO.getOper_date());
    localProchangeuExt.setParam(":VRSRV_STR1", paramProchangeuDAO.getRsrv_str1());
    localProchangeuExt.setParam(":VRSRV_STR2", paramProchangeuDAO.getRsrv_str2());
    localProchangeuExt.setParam(":VRSRV_STR3", paramProchangeuDAO.getRsrv_str3());
    localProchangeuExt.setParam(":VRSRV_STR7", paramProchangeuDAO.getRsrv_str7());
    localProchangeuExt.setParam(":VRSRV_STR8", paramProchangeuDAO.getRsrv_str8());
    localProchangeuExt.setParam(":VRSRV_STR9", paramProchangeuDAO.getRsrv_str9());
    this.tradeQuery.executeBy(localProchangeuExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateProchange(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入updateProchange方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("LOGIN");
    try
    {
      if ((str1 == "0") || (str1.equals("0")))
      {
        String str2 = paramBuffers.getString("SESSION_USER_ID");
        String str3 = paramBuffers.getString("PROPERTY_TYPE");
        String str4 = paramBuffers.getString("PROPERTY_VALUE");
        String str5 = paramBuffers.getString("PROPERTY_VALUE");
        String str6 = this.comm.GenSysdate("1");
        String str7 = "0";
        HashMap localHashMap = getUserOldProperty(str2, str3);
        if (localHashMap.get("property_value") != null)
          str7 = localHashMap.get("property_value").toString();
        String str8 = "6";
        String str9 = "loading";
        String str10 = str6;
        String str11 = "";
        String str12 = "";
        String str13 = "";
        String str14 = "";
        String str15 = "";
        String str16 = "";
        String str17 = "";
        String str18 = paramBuffers.getString("REMARK");
        ProchangeuDAO localProchangeuDAO = new ProchangeuDAO();
        localProchangeuDAO.setUser_id(str2);
        localProchangeuDAO.setProperty_type(str3);
        localProchangeuDAO.setProperty_value(str4);
        localProchangeuDAO.setChange_date(str6);
        localProchangeuDAO.setChange_value(str5);
        localProchangeuDAO.setRemark(str18);
        localProchangeuDAO.setOld_value(str7);
        localProchangeuDAO.setChange_reason(str8);
        localProchangeuDAO.setRsrv_str10(str17);
        localProchangeuDAO.setChange_user_id(str9);
        localProchangeuDAO.setOper_date(str10);
        localProchangeuDAO.setRsrv_str1(str11);
        localProchangeuDAO.setRsrv_str2(str12);
        localProchangeuDAO.setRsrv_str3(str13);
        localProchangeuDAO.setRsrv_str7(str14);
        localProchangeuDAO.setRsrv_str8(str15);
        localProchangeuDAO.setRsrv_str9(str16);
        i = addDefaultProchange(localProchangeuDAO);
      }
      else
      {
        i = 0;
      }
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "222222业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addDefaultProchange方法...");
  }

  public void updateProchangeByPublish(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入updateProchangeByPublish方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("INFO_TYPE");
    String str2 = paramBuffers.getString("INFO_STATE");
    try
    {
      boolean bool = new PropertyuInfo().getValidityInfo("106", str1);
      if (bool)
      {
        if ((str2 == "1") || (str2.equals("1")))
        {
          String str3 = paramBuffers.getString("PUBLISH_USER_ID");
          String str4 = paramBuffers.getString("PROPERTY_TYPE");
          String str5 = paramBuffers.getString("PROPERTY_VALUE");
          String str6 = paramBuffers.getString("PROPERTY_VALUE");
          String str7 = this.comm.GenSysdate("1");
          String str8 = "0";
          HashMap localHashMap = getUserOldProperty(str3, str4);
          if (localHashMap.get("property_value") != null)
            str8 = localHashMap.get("property_value").toString();
          String str9 = "1";
          String str10 = "validity";
          String str11 = str7;
          String str12 = "";
          String str13 = "";
          String str14 = "";
          String str15 = "";
          String str16 = "";
          String str17 = "";
          String str18 = "";
          String str19 = paramBuffers.getString("REMARK");
          ProchangeuDAO localProchangeuDAO = new ProchangeuDAO();
          localProchangeuDAO.setUser_id(str3);
          localProchangeuDAO.setProperty_type(str4);
          localProchangeuDAO.setProperty_value(str5);
          localProchangeuDAO.setChange_date(str7);
          localProchangeuDAO.setChange_value(str6);
          localProchangeuDAO.setRemark(str19);
          localProchangeuDAO.setOld_value(str8);
          localProchangeuDAO.setChange_reason(str9);
          localProchangeuDAO.setRsrv_str10(str18);
          localProchangeuDAO.setChange_user_id(str10);
          localProchangeuDAO.setOper_date(str11);
          localProchangeuDAO.setRsrv_str1(str12);
          localProchangeuDAO.setRsrv_str2(str13);
          localProchangeuDAO.setRsrv_str3(str14);
          localProchangeuDAO.setRsrv_str7(str15);
          localProchangeuDAO.setRsrv_str8(str16);
          localProchangeuDAO.setRsrv_str9(str17);
          i = addDefaultProchange(localProchangeuDAO);
        }
        else
        {
          i = 0;
        }
      }
      else
        i = 0;
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
    this.log.LOG_INFO("退出updateProchangeByPublish方法...");
  }

  public void checkUserLoading(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入checkUserLoading方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_USER_ID");
    String str2 = "6";
    try
    {
      i = checkUserLoading(str1, str2);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "1111业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出checkUserLoading方法...");
  }

  public int checkUserLoading(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProchangeuExt localProchangeuExt = new ProchangeuExt();
    localProchangeuExt.setParam(":VUSER_ID", paramString1);
    localProchangeuExt.setParam(":VOPER_DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    localProchangeuExt.setParam(":VCHANGE_REASON", paramString2);
    ArrayList localArrayList = localProchangeuExt.selByList("SEL_BY_DATE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      this.outBuffer.setString("LOGIN", "1");
    else
      this.outBuffer.setString("LOGIN", "0");
    return 0;
  }

  public HashMap getUserOldProperty(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ProchangeuExt localProchangeuExt = new ProchangeuExt();
    localProchangeuExt.setParam(":VUSER_ID", paramString1);
    localProchangeuExt.setParam(":VPROPERTY_TYPE", paramString2);
    ArrayList localArrayList = localProchangeuExt.selByList("SEL_BY_MAX");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.propertyuMgr.ProchangeuInfo
 * JD-Core Version:    0.6.0
 */