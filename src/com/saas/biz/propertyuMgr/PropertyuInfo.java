package com.saas.biz.propertyuMgr;

import com.saas.biz.commen.ParamethodMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.commenDAO.CommparaExt;
import com.saas.biz.dao.propertyuDAO.PropertyuDAO;
import com.saas.biz.dao.propertyuDAO.PropertyuExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class PropertyuInfo
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

  public void addDefaultUserProperty(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addDefaultUserProperty方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("USER_ID");
    String str2 = this.comm.GenTradeId();
    String str3 = "0";
    String str4 = "0";
    String str5 = "";
    String str6 = "";
    String str7 = "0";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    String str13 = "";
    String str14 = "";
    String str15 = "新会员注册";
    try
    {
      PropertyuDAO localPropertyuDAO = new PropertyuDAO();
      localPropertyuDAO.setUser_id(str1);
      localPropertyuDAO.setAcct_id(str2);
      localPropertyuDAO.setCount_type(str6);
      localPropertyuDAO.setProperty_type(str3);
      localPropertyuDAO.setProperty_value(str4);
      localPropertyuDAO.setCount_unit(str5);
      localPropertyuDAO.setEnable_tag(str7);
      localPropertyuDAO.setRsrv_str1(str8);
      localPropertyuDAO.setRsrv_str2(str9);
      localPropertyuDAO.setRsrv_str3(str10);
      localPropertyuDAO.setRsrv_str7(str11);
      localPropertyuDAO.setRsrv_str8(str12);
      localPropertyuDAO.setRsrv_str9(str13);
      localPropertyuDAO.setRsrv_str10(str14);
      localPropertyuDAO.setRemark(str15);
      i = addDefaultUserProperty(localPropertyuDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "6业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addDefaultUserProperty方法...");
  }

  public int addDefaultUserProperty(PropertyuDAO paramPropertyuDAO)
    throws SaasApplicationException
  {
    PropertyuExt localPropertyuExt = new PropertyuExt();
    HashMap localHashMap = this.param.getSystemParameter("B2B", "101", "1", "7");
    if ((localHashMap != null) && (localHashMap.size() > 0) && (localHashMap.get("para_code3") != null))
      paramPropertyuDAO.setProperty_value(localHashMap.get("para_code3").toString());
    localPropertyuExt.setParam(":VUSER_ID", paramPropertyuDAO.getUser_id());
    localPropertyuExt.setParam(":VACCT_ID", paramPropertyuDAO.getAcct_id());
    localPropertyuExt.setParam(":VCOUNT_TYPE", paramPropertyuDAO.getCount_type());
    localPropertyuExt.setParam(":VPROPERTY_TYPE", paramPropertyuDAO.getProperty_type());
    localPropertyuExt.setParam(":VPROPERTY_VALUE", paramPropertyuDAO.getProperty_value());
    localPropertyuExt.setParam(":VCOUNT_UNIT", paramPropertyuDAO.getCount_unit());
    localPropertyuExt.setParam(":VENABLE_TAG", paramPropertyuDAO.getEnable_tag());
    localPropertyuExt.setParam(":VRSRV_STR1", paramPropertyuDAO.getRsrv_str1());
    localPropertyuExt.setParam(":VRSRV_STR2", paramPropertyuDAO.getRsrv_str2());
    localPropertyuExt.setParam(":VRSRV_STR3", paramPropertyuDAO.getRsrv_str3());
    localPropertyuExt.setParam(":VRSRV_STR7", paramPropertyuDAO.getRsrv_str7());
    localPropertyuExt.setParam(":VRSRV_STR8", paramPropertyuDAO.getRsrv_str8());
    localPropertyuExt.setParam(":VRSRV_STR9", paramPropertyuDAO.getRsrv_str9());
    localPropertyuExt.setParam(":VRSRV_STR10", paramPropertyuDAO.getRsrv_str10());
    localPropertyuExt.setParam(":VREMARK", paramPropertyuDAO.getRemark());
    this.tradeQuery.executeBy(localPropertyuExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("PROPERTY_VALUE", paramPropertyuDAO.getProperty_value());
    this.outBuffer.setString("PROPERTY_TYPE", paramPropertyuDAO.getProperty_type());
    this.outBuffer.setString("REMARK", paramPropertyuDAO.getRemark());
    return 0;
  }

  public void addPropertyByPublishNotValidity(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_USER_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_CLASS");
    String str3 = paramBuffers.getString("INFO_TYPE");
    String str4 = "";
    String str5 = "0";
    String str6 = "0";
    String str7 = "";
    String str8 = "";
    String str9 = "0";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    String str13 = "";
    String str14 = "";
    String str15 = "";
    String str16 = "";
    String str17 = "会员发布不用审核信息";
    try
    {
      PropertyuDAO localPropertyuDAO = new PropertyuDAO();
      HashMap localHashMap = getUserPropertyByUserId(str1, str5);
      if ((localHashMap != null) && (localHashMap.size() > 0))
      {
        str6 = localHashMap.get("property_value").toString();
        str4 = localHashMap.get("acct_id").toString();
      }
      localPropertyuDAO.setUser_id(str1);
      localPropertyuDAO.setAcct_id(str4);
      localPropertyuDAO.setCount_type(str8);
      localPropertyuDAO.setProperty_type(str5);
      localPropertyuDAO.setProperty_value(str6);
      localPropertyuDAO.setCount_unit(str7);
      localPropertyuDAO.setEnable_tag(str9);
      localPropertyuDAO.setRsrv_str1(str10);
      localPropertyuDAO.setRsrv_str2(str11);
      localPropertyuDAO.setRsrv_str3(str12);
      localPropertyuDAO.setRsrv_str7(str13);
      localPropertyuDAO.setRsrv_str8(str14);
      localPropertyuDAO.setRsrv_str9(str15);
      localPropertyuDAO.setRsrv_str10(str16);
      localPropertyuDAO.setRemark(str17);
      i = addPropertyByPublish(localPropertyuDAO, str2, str3);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    else
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    this.log.LOG_INFO("退出addPropertyByPublish方法...");
  }

  public void addPropertyByPublish(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addPropertyByPublish方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PUBLISH_USER_ID");
    String str2 = "";
    String str3 = "0";
    String str4 = "0";
    String str5 = "";
    String str6 = "";
    String str7 = "0";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    String str13 = "";
    String str14 = "";
    String str15 = "会员发布信息审核通过";
    String str16 = paramBuffers.getString("SESSION_CUST_CLASS");
    String str17 = paramBuffers.getString("INFO_TYPE");
    String str18 = paramBuffers.getString("INFO_STATE");
    try
    {
      PropertyuDAO localPropertyuDAO = new PropertyuDAO();
      HashMap localHashMap = getUserPropertyByUserId(str1, str3);
      if ((localHashMap != null) && (localHashMap.size() > 0))
      {
        str4 = localHashMap.get("property_value").toString();
        str2 = localHashMap.get("acct_id").toString();
      }
      localPropertyuDAO.setUser_id(str1);
      localPropertyuDAO.setAcct_id(str2);
      localPropertyuDAO.setCount_type(str6);
      localPropertyuDAO.setProperty_type(str3);
      localPropertyuDAO.setProperty_value(str4);
      localPropertyuDAO.setCount_unit(str5);
      localPropertyuDAO.setEnable_tag(str7);
      localPropertyuDAO.setRsrv_str1(str8);
      localPropertyuDAO.setRsrv_str2(str9);
      localPropertyuDAO.setRsrv_str3(str10);
      localPropertyuDAO.setRsrv_str7(str11);
      localPropertyuDAO.setRsrv_str8(str12);
      localPropertyuDAO.setRsrv_str9(str13);
      localPropertyuDAO.setRsrv_str10(str14);
      localPropertyuDAO.setRemark(str15);
      if ((str18 == "1") || (str18.equals("1")))
        i = addPropertyByPublish(localPropertyuDAO, str16, str17);
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
    this.log.LOG_INFO("退出addPropertyByPublish方法...");
  }

  public int addPropertyByPublish(PropertyuDAO paramPropertyuDAO, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    PropertyuExt localPropertyuExt = new PropertyuExt();
    this.log.LOG_INFO(paramPropertyuDAO.getProperty_value() + "==cust_class=" + paramString1 + "=========info_type===" + paramString2);
    HashMap localHashMap = this.param.getSystemParameter("B2B", "101", paramString1, paramString2);
    if ((localHashMap != null) && (localHashMap.size() > 0) && (localHashMap.get("para_code3") != null))
    {
      Integer localInteger = Integer.valueOf(0);
      try
      {
        localInteger = Integer.valueOf(Integer.parseInt(paramPropertyuDAO.getProperty_value()));
      }
      catch (Exception localException)
      {
        localInteger = Integer.valueOf(1);
      }
      localInteger = Integer.valueOf(localInteger.intValue() + Integer.parseInt(localHashMap.get("para_code3").toString()));
      paramPropertyuDAO.setProperty_value(localInteger.toString());
    }
    localPropertyuExt.setParam(":VUSER_ID", paramPropertyuDAO.getUser_id());
    localPropertyuExt.setParam(":VACCT_ID", paramPropertyuDAO.getAcct_id());
    localPropertyuExt.setParam(":VCOUNT_TYPE", paramPropertyuDAO.getCount_type());
    localPropertyuExt.setParam(":VPROPERTY_TYPE", paramPropertyuDAO.getProperty_type());
    localPropertyuExt.setParam(":VPROPERTY_VALUE", paramPropertyuDAO.getProperty_value());
    localPropertyuExt.setParam(":VCOUNT_UNIT", paramPropertyuDAO.getCount_unit());
    localPropertyuExt.setParam(":VENABLE_TAG", paramPropertyuDAO.getEnable_tag());
    localPropertyuExt.setParam(":VRSRV_STR1", paramPropertyuDAO.getRsrv_str1());
    localPropertyuExt.setParam(":VRSRV_STR2", paramPropertyuDAO.getRsrv_str2());
    localPropertyuExt.setParam(":VRSRV_STR3", paramPropertyuDAO.getRsrv_str3());
    localPropertyuExt.setParam(":VRSRV_STR7", paramPropertyuDAO.getRsrv_str7());
    localPropertyuExt.setParam(":VRSRV_STR8", paramPropertyuDAO.getRsrv_str8());
    localPropertyuExt.setParam(":VRSRV_STR9", paramPropertyuDAO.getRsrv_str9());
    localPropertyuExt.setParam(":VRSRV_STR10", paramPropertyuDAO.getRsrv_str10());
    localPropertyuExt.setParam(":VREMARK", paramPropertyuDAO.getRemark());
    this.tradeQuery.executeBy(localPropertyuExt.insBy("UPDATE_BY_ALL"));
    this.outBuffer.setString("PROPERTY_VALUE", paramPropertyuDAO.getProperty_value());
    this.outBuffer.setString("PROPERTY_TYPE", paramPropertyuDAO.getProperty_type());
    this.outBuffer.setString("REMARK", paramPropertyuDAO.getRemark());
    return 0;
  }

  public boolean getValidityInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
	  boolean i = false;
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_PARA_CODE2");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code3") != null)
      {
        String str = localHashMap.get("para_code3").toString();
        if ((str == "1") || (str.equals("1")))
          i = true;
        else
          i = false;
      }
    }
    return i;
  }

  public void userLoadProperty(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入userLoadProperty方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = this.comm.GenTradeId();
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    String str3 = paramBuffers.getString("LOGIN");
    String str4 = "0";
    String str5 = "0";
    String str6 = "";
    String str7 = "";
    String str8 = "0";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    String str13 = "";
    String str14 = "";
    String str15 = "";
    String str16 = "会员登录";
    String str17 = paramBuffers.getString("SESSION_CUST_CLASS");
    try
    {
      PropertyuDAO localPropertyuDAO = new PropertyuDAO();
      localPropertyuDAO.setUser_id(str2);
      localPropertyuDAO.setCount_type(str7);
      localPropertyuDAO.setProperty_type(str4);
      localPropertyuDAO.setProperty_value(str5);
      localPropertyuDAO.setCount_unit(str6);
      localPropertyuDAO.setEnable_tag(str8);
      localPropertyuDAO.setRsrv_str1(str9);
      localPropertyuDAO.setRsrv_str2(str10);
      localPropertyuDAO.setRsrv_str3(str11);
      localPropertyuDAO.setRsrv_str7(str12);
      localPropertyuDAO.setRsrv_str8(str13);
      localPropertyuDAO.setRsrv_str9(str14);
      localPropertyuDAO.setRsrv_str10(str15);
      localPropertyuDAO.setRemark(str16);
      if ((str3 == "0") || (str3.equals("0")))
      {
        HashMap localHashMap = getUserPropertyByUserId(str2, str4);
        if ((localHashMap != null) && (localHashMap.size() > 0))
        {
          if (localHashMap.get("acct_id") != null)
          {
            str1 = localHashMap.get("acct_id").toString();
            localPropertyuDAO.setAcct_id(str1);
            str5 = localHashMap.get("property_value").toString();
            localPropertyuDAO.setProperty_value(str5);
            i = userLoadProperty(localPropertyuDAO, str17);
          }
        }
        else
        {
          localPropertyuDAO.setAcct_id(str1);
          i = addDefaultUserProperty(localPropertyuDAO);
        }
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
      this.outBuffer.setString("RESULT_INFO", "33333333333业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出userLoadProperty方法...");
  }

  public int userLoadProperty(PropertyuDAO paramPropertyuDAO, String paramString)
    throws SaasApplicationException
  {
    PropertyuExt localPropertyuExt = new PropertyuExt();
    HashMap localHashMap = this.param.getSystemParameter("B2B", "101", paramString, "0");
    if ((localHashMap != null) && (localHashMap.size() > 0) && (localHashMap.get("para_code3") != null))
    {
      Integer localInteger = Integer.valueOf(Integer.parseInt(paramPropertyuDAO.getProperty_value()));
      localInteger = Integer.valueOf(localInteger.intValue() + Integer.parseInt(localHashMap.get("para_code3").toString()));
      paramPropertyuDAO.setProperty_value(localInteger.toString());
    }
    localPropertyuExt.setParam(":VUSER_ID", paramPropertyuDAO.getUser_id());
    localPropertyuExt.setParam(":VACCT_ID", paramPropertyuDAO.getAcct_id());
    localPropertyuExt.setParam(":VCOUNT_TYPE", paramPropertyuDAO.getCount_type());
    localPropertyuExt.setParam(":VPROPERTY_TYPE", paramPropertyuDAO.getProperty_type());
    localPropertyuExt.setParam(":VPROPERTY_VALUE", paramPropertyuDAO.getProperty_value());
    localPropertyuExt.setParam(":VCOUNT_UNIT", paramPropertyuDAO.getCount_unit());
    localPropertyuExt.setParam(":VENABLE_TAG", paramPropertyuDAO.getEnable_tag());
    localPropertyuExt.setParam(":VRSRV_STR1", paramPropertyuDAO.getRsrv_str1());
    localPropertyuExt.setParam(":VRSRV_STR2", paramPropertyuDAO.getRsrv_str2());
    localPropertyuExt.setParam(":VRSRV_STR3", paramPropertyuDAO.getRsrv_str3());
    localPropertyuExt.setParam(":VRSRV_STR7", paramPropertyuDAO.getRsrv_str7());
    localPropertyuExt.setParam(":VRSRV_STR8", paramPropertyuDAO.getRsrv_str8());
    localPropertyuExt.setParam(":VRSRV_STR9", paramPropertyuDAO.getRsrv_str9());
    localPropertyuExt.setParam(":VRSRV_STR10", paramPropertyuDAO.getRsrv_str10());
    localPropertyuExt.setParam(":VREMARK", paramPropertyuDAO.getRemark());
    this.tradeQuery.executeBy(localPropertyuExt.insBy("UPDATE_BY_ALL"));
    this.outBuffer.setString("PROPERTY_VALUE", paramPropertyuDAO.getProperty_value());
    this.outBuffer.setString("PROPERTY_TYPE", paramPropertyuDAO.getProperty_type());
    this.outBuffer.setString("REMARK", paramPropertyuDAO.getRemark());
    return 0;
  }

  public String getUserPropertyValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "0";
    HashMap localHashMap = getUserPropertyByUserId(paramString1, paramString2);
    if ((localHashMap != null) && (localHashMap.size() > 0) && (localHashMap.get("property_value") != null))
      str = localHashMap.get("property_value").toString();
    return str;
  }

  public HashMap getUserPropertyByUserId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    PropertyuExt localPropertyuExt = new PropertyuExt();
    HashMap localHashMap = new HashMap();
    localPropertyuExt.setParam(":VUSER_ID", paramString1);
    localPropertyuExt.setParam(":VPROPERTY_TYPE", paramString2);
    ArrayList localArrayList = localPropertyuExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getUserPropertyByAll(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    PropertyuExt localPropertyuExt = new PropertyuExt();
    localPropertyuExt.setParam(":VPROPERTY_TYPE", paramString);
    ArrayList localArrayList = localPropertyuExt.selByList("SEL_BY_ALL", paramInt, 30);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public int getUserPropertyByAllNum(String paramString)
    throws SaasApplicationException
  {
    PropertyuExt localPropertyuExt = new PropertyuExt();
    localPropertyuExt.setParam(":VPROPERTY_TYPE", paramString);
    ArrayList localArrayList = localPropertyuExt.selByList("SEL_BY_ALL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void updatePropertyByAcct(Buffers paramBuffers)
    throws SaasApplicationException
  {
    PropertyuDAO localPropertyuDAO = new PropertyuDAO();
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    String str1 = "";
    String str2 = "0";
    str1 = paramBuffers.getString("acct_id");
    str2 = paramBuffers.getString("property_value");
    localPropertyuDAO.setAcct_id(str1);
    localPropertyuDAO.setProperty_value(str2);
    updatePropertyByAcct(localPropertyuDAO);
  }

  public void updatePropertyByAcct(PropertyuDAO paramPropertyuDAO)
    throws SaasApplicationException
  {
    PropertyuExt localPropertyuExt = new PropertyuExt();
    localPropertyuExt.setParam(":VACCT_ID", paramPropertyuDAO.getAcct_id());
    localPropertyuExt.setParam(":VPROPERTY_VALUE", paramPropertyuDAO.getProperty_value());
    this.tradeQuery.executeBy(localPropertyuExt.insBy("UPDATE_BY_ACCT"));
  }

  public void updateUserPropertyValue(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addPropertyByPublish方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("user_id");
      String str2 = paramBuffers.getString("property_value");
      i = updateUserPropertyValue(str1, str2);
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

  public int updateUserPropertyValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    PropertyuExt localPropertyuExt = new PropertyuExt();
    localPropertyuExt.setParam(":VUSER_ID", paramString1);
    localPropertyuExt.setParam(":VPROPERTY_VALUE", paramString2);
    this.tradeQuery.executeBy(localPropertyuExt.insBy("UPDATE_ACTIVE_U"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.propertyuMgr.PropertyuInfo
 * JD-Core Version:    0.6.0
 */