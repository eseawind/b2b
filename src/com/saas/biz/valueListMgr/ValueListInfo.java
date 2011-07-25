package com.saas.biz.valueListMgr;

import com.saas.biz.dao.valueListDAO.ValueListDAO;
import com.saas.biz.dao.valueListDAO.ValueListExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class ValueListInfo
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

  public void addValueList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addValueList方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("OBJ_CUST_ID");
    String str4 = paramBuffers.getString("TEST_ID");
    String str5 = paramBuffers.getString("TEST_MONTH");
    String str6 = paramBuffers.getString("TEST_DATE");
    String str7 = paramBuffers.getString("TEST_VALUE");
    String str8 = paramBuffers.getString("TEST_DESC");
    String str9 = paramBuffers.getString("ENABLE_TAG");
    String str10 = paramBuffers.getString("SESSION_USER_ID");
    String str11 = paramBuffers.getString("IN_DATE");
    String str12 = paramBuffers.getString("REMARK");
    try
    {
      ValueListDAO localValueListDAO = new ValueListDAO();
      localValueListDAO.setCust_id(str1);
      localValueListDAO.setChannels_type(str2);
      localValueListDAO.setObj_cust_id(str3);
      localValueListDAO.setTest_id(str4);
      localValueListDAO.setTest_month(str5);
      localValueListDAO.setTest_date(str6);
      localValueListDAO.setTest_value(str7);
      localValueListDAO.setTest_desc(str8);
      localValueListDAO.setEnable_tag(str9);
      localValueListDAO.setOper_user_id(str10);
      localValueListDAO.setIn_date(str11);
      localValueListDAO.setRemark(str12);
      i = addValueList(localValueListDAO);
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
    this.log.LOG_INFO("退出addValueList方法...");
  }

  public int addValueList(ValueListDAO paramValueListDAO)
    throws SaasApplicationException
  {
    ValueListExt localValueListExt = new ValueListExt();
    localValueListExt.setParam(":VCUST_ID", paramValueListDAO.getCust_id());
    localValueListExt.setParam(":VCHANNELS_TYPE", paramValueListDAO.getChannels_type());
    localValueListExt.setParam(":VOBJ_CUST_ID", paramValueListDAO.getObj_cust_id());
    localValueListExt.setParam(":VTEST_ID", paramValueListDAO.getTest_id());
    localValueListExt.setParam(":VTEST_MONTH", paramValueListDAO.getTest_month());
    localValueListExt.setParam(":VTEST_DATE", paramValueListDAO.getTest_date());
    localValueListExt.setParam(":VTEST_VALUE", paramValueListDAO.getTest_value());
    localValueListExt.setParam(":VTEST_DESC", paramValueListDAO.getTest_desc());
    localValueListExt.setParam(":VENABLE_TAG", paramValueListDAO.getEnable_tag());
    localValueListExt.setParam(":VOPER_USER_ID", paramValueListDAO.getOper_user_id());
    localValueListExt.setParam(":VIN_DATE", paramValueListDAO.getIn_date());
    localValueListExt.setParam(":VREMARK", paramValueListDAO.getRemark());
    this.tradeQuery.executeBy(localValueListExt.insBy("INS_BY_VALUE_LIST"));
    return 0;
  }

  public ArrayList getAllValueList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ValueListExt localValueListExt = new ValueListExt();
    localValueListExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localValueListExt.selByList("SEL_BY_KKK", paramInt, 20);
    this.log.LOG_INFO("=================" + localArrayList + "=======================");
    return localArrayList;
  }

  public int getAllValueList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ValueListExt localValueListExt = new ValueListExt();
    localValueListExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localValueListExt.selByList("SEL_BY_KKK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void modifyValueList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyValueList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TEST_ID");
    String str3 = paramBuffers.getString("TEST_MONTH");
    String str4 = paramBuffers.getString("TEST_DATE");
    String str5 = paramBuffers.getString("TEST_VALUE");
    String str6 = paramBuffers.getString("TEST_DESC");
    String str7 = paramBuffers.getString("ENABLE_TAG");
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    String str9 = paramBuffers.getString("IN_DATE");
    String str10 = paramBuffers.getString("REMARK");
    try
    {
      ValueListDAO localValueListDAO = new ValueListDAO();
      localValueListDAO.setCust_id(str1);
      localValueListDAO.setTest_id(str2);
      localValueListDAO.setTest_month(str3);
      localValueListDAO.setTest_date(str4);
      localValueListDAO.setTest_value(str5);
      localValueListDAO.setTest_desc(str6);
      localValueListDAO.setEnable_tag(str7);
      localValueListDAO.setOper_user_id(str8);
      localValueListDAO.setIn_date(str9);
      localValueListDAO.setRemark(str10);
      i = modifyValueList(localValueListDAO);
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
    this.log.LOG_INFO("退出modifyValueList方法...");
  }

  public int modifyValueList(ValueListDAO paramValueListDAO)
    throws SaasApplicationException
  {
    ValueListExt localValueListExt = new ValueListExt();
    localValueListExt.setParam(":VCUST_ID", paramValueListDAO.getCust_id());
    localValueListExt.setParam(":VTEST_ID", paramValueListDAO.getTest_id());
    localValueListExt.setParam(":VTEST_MONTH", paramValueListDAO.getTest_month());
    localValueListExt.setParam(":VTEST_DATE", paramValueListDAO.getTest_date());
    localValueListExt.setParam(":VTEST_VALUE", paramValueListDAO.getTest_value());
    localValueListExt.setParam(":VTEST_DESC", paramValueListDAO.getTest_desc());
    localValueListExt.setParam(":VENABLE_TAG", paramValueListDAO.getEnable_tag());
    localValueListExt.setParam(":VOPER_USER_ID", paramValueListDAO.getOper_user_id());
    localValueListExt.setParam(":VIN_DATE", paramValueListDAO.getIn_date());
    localValueListExt.setParam(":VREMARK", paramValueListDAO.getRemark());
    this.tradeQuery.executeBy(localValueListExt.insBy("UP_VALUE_BY_ALL"));
    return 0;
  }

  public ArrayList getListByValueId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ValueListExt localValueListExt = new ValueListExt();
    localValueListExt.setParam(":VCUST_ID", paramString1);
    localValueListExt.setParam(":VTEST_ID", paramString2);
    ArrayList localArrayList = localValueListExt.selByList("SEL_BY_VALUE_ID");
    return localArrayList;
  }

  public ArrayList getValueById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ValueListExt localValueListExt = new ValueListExt();
    localValueListExt.setParam(":VCUST_ID", paramString);
    localArrayList = localValueListExt.selByList("SEL_BY_KKK");
    return localArrayList;
  }

  public ArrayList getOneValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ValueListExt localValueListExt = new ValueListExt();
    localValueListExt.setParam(":VCUST_ID", paramString1);
    localValueListExt.setParam(":VTEST_ID", paramString2);
    localArrayList = localValueListExt.selByList("SEL_ONE_BY_TEST_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.valueListMgr.ValueListInfo
 * JD-Core Version:    0.6.0
 */