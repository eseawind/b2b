package com.saas.biz.channelsTestMgr;

import com.saas.biz.dao.channelstestDAO.ChannelsTestDAO;
import com.saas.biz.dao.channelstestDAO.ChannelsTestExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ChannelsTestInfo
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

  public void addChannelsTest(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addChannelsTest方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_ID");
    String str3 = paramBuffers.getString("TEST_ID");
    String str4 = paramBuffers.getString("TEST_NAME");
    String str5 = paramBuffers.getString("TEST_CODE");
    String str6 = paramBuffers.getString("TEST_TYPE");
    String str7 = paramBuffers.getString("TEST_NUM");
    String str8 = paramBuffers.getString("TEST_RAGE");
    String str9 = paramBuffers.getString("TEST_CUST_ID");
    String str10 = paramBuffers.getString("START_DATE");
    String str11 = paramBuffers.getString("END_DATE");
    String str12 = paramBuffers.getString("CLASS_RAGE");
    String str13 = paramBuffers.getString("LEVEL_RAGE");
    String str14 = paramBuffers.getString("FIRST_TAG");
    String str15 = paramBuffers.getString("SESSION_USER_ID");
    String str16 = paramBuffers.getString("IN_DATE");
    String str17 = paramBuffers.getString("REMARK");
    try
    {
      ChannelsTestDAO localChannelsTestDAO = new ChannelsTestDAO();
      localChannelsTestDAO.setCust_id(str1);
      localChannelsTestDAO.setChannels_id(str2);
      localChannelsTestDAO.setTest_id(str3);
      localChannelsTestDAO.setTest_name(str4);
      localChannelsTestDAO.setTest_code(str5);
      localChannelsTestDAO.setTest_type(str6);
      localChannelsTestDAO.setTest_num(str7);
      localChannelsTestDAO.setTest_rage(str8);
      localChannelsTestDAO.setTest_cust_id(str9);
      localChannelsTestDAO.setStart_date(str10);
      localChannelsTestDAO.setEnd_date(str11);
      localChannelsTestDAO.setClass_rage(str12);
      localChannelsTestDAO.setLevel_rage(str13);
      localChannelsTestDAO.setFirst_tag(str14);
      localChannelsTestDAO.setOper_user_id(str15);
      localChannelsTestDAO.setIn_date(str16);
      localChannelsTestDAO.setRemark(str17);
      i = addChannelsTest(localChannelsTestDAO);
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
    this.log.LOG_INFO("退出addChannelsTest方法...");
  }

  public int addChannelsTest(ChannelsTestDAO paramChannelsTestDAO)
    throws SaasApplicationException
  {
    ChannelsTestExt localChannelsTestExt = new ChannelsTestExt();
    localChannelsTestExt.setParam(":VCUST_ID", paramChannelsTestDAO.getCust_id());
    localChannelsTestExt.setParam(":VCHANNELS_ID", paramChannelsTestDAO.getChannels_id());
    localChannelsTestExt.setParam(":VTEST_ID", paramChannelsTestDAO.getTest_id());
    localChannelsTestExt.setParam(":VTEST_NAME", paramChannelsTestDAO.getTest_name());
    localChannelsTestExt.setParam(":VTEST_CODE", paramChannelsTestDAO.getTest_code());
    localChannelsTestExt.setParam(":VTEST_TYPE", paramChannelsTestDAO.getTest_type());
    localChannelsTestExt.setParam(":VTEST_NUM", paramChannelsTestDAO.getTest_num());
    localChannelsTestExt.setParam(":VTEST_RAGE", paramChannelsTestDAO.getTest_rage());
    localChannelsTestExt.setParam(":VTEST_CUST_ID", paramChannelsTestDAO.getTest_cust_id());
    localChannelsTestExt.setParam(":VSTART_DATE", paramChannelsTestDAO.getStart_date());
    localChannelsTestExt.setParam(":VEND_DATE", paramChannelsTestDAO.getEnd_date());
    localChannelsTestExt.setParam(":VCLASS_RAGE", paramChannelsTestDAO.getClass_rage());
    localChannelsTestExt.setParam(":VLEVEL_RAGE", paramChannelsTestDAO.getLevel_rage());
    localChannelsTestExt.setParam(":VFIRST_TAG", paramChannelsTestDAO.getFirst_tag());
    localChannelsTestExt.setParam(":VOPER_USER_ID", paramChannelsTestDAO.getOper_user_id());
    localChannelsTestExt.setParam(":VIN_DATE", paramChannelsTestDAO.getIn_date());
    localChannelsTestExt.setParam(":VREMARK", paramChannelsTestDAO.getRemark());
    this.tradeQuery.executeBy(localChannelsTestExt.insBy("INS_BY_CHA_TEST"));
    return 0;
  }

  public ArrayList getListByTest(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ChannelsTestExt localChannelsTestExt = new ChannelsTestExt();
    localChannelsTestExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localChannelsTestExt.selByList("SEL_BY_TEST", paramInt, 20);
    return localArrayList;
  }

  public int getListByTestCt(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ChannelsTestExt localChannelsTestExt = new ChannelsTestExt();
    localChannelsTestExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localChannelsTestExt.selByList("SEL_TEST_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public void modifyChannelsTest(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyChannelsTest方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_ID");
    String str3 = paramBuffers.getString("TEST_ID");
    String str4 = paramBuffers.getString("TEST_NAME");
    String str5 = paramBuffers.getString("TEST_CODE");
    String str6 = paramBuffers.getString("TEST_TYPE");
    String str7 = paramBuffers.getString("TEST_NUM");
    String str8 = paramBuffers.getString("TEST_RAGE");
    String str9 = paramBuffers.getString("TEST_CUST_ID");
    String str10 = paramBuffers.getString("START_DATE");
    String str11 = paramBuffers.getString("END_DATE");
    String str12 = paramBuffers.getString("CLASS_RAGE");
    String str13 = paramBuffers.getString("LEVEL_RAGE");
    String str14 = paramBuffers.getString("FIRST_TAG");
    String str15 = paramBuffers.getString("SESSION_USER_ID");
    String str16 = paramBuffers.getString("IN_DATE");
    String str17 = paramBuffers.getString("REMARK");
    try
    {
      ChannelsTestDAO localChannelsTestDAO = new ChannelsTestDAO();
      localChannelsTestDAO.setCust_id(str1);
      localChannelsTestDAO.setChannels_id(str2);
      localChannelsTestDAO.setTest_id(str3);
      localChannelsTestDAO.setTest_name(str4);
      localChannelsTestDAO.setTest_code(str5);
      localChannelsTestDAO.setTest_type(str6);
      localChannelsTestDAO.setTest_num(str7);
      localChannelsTestDAO.setTest_rage(str8);
      localChannelsTestDAO.setTest_cust_id(str9);
      localChannelsTestDAO.setStart_date(str10);
      localChannelsTestDAO.setEnd_date(str11);
      localChannelsTestDAO.setClass_rage(str12);
      localChannelsTestDAO.setLevel_rage(str13);
      localChannelsTestDAO.setFirst_tag(str14);
      localChannelsTestDAO.setOper_user_id(str15);
      localChannelsTestDAO.setIn_date(str16);
      localChannelsTestDAO.setRemark(str17);
      i = modifyChannelsTest(localChannelsTestDAO);
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
    this.log.LOG_INFO("退出modifyChannelsTest方法...");
  }

  public int modifyChannelsTest(ChannelsTestDAO paramChannelsTestDAO)
    throws SaasApplicationException
  {
    ChannelsTestExt localChannelsTestExt = new ChannelsTestExt();
    localChannelsTestExt.setParam(":VCUST_ID", paramChannelsTestDAO.getCust_id());
    localChannelsTestExt.setParam(":VCHANNELS_ID", paramChannelsTestDAO.getChannels_id());
    localChannelsTestExt.setParam(":VTEST_ID", paramChannelsTestDAO.getTest_id());
    localChannelsTestExt.setParam(":VTEST_NAME", paramChannelsTestDAO.getTest_name());
    localChannelsTestExt.setParam(":VTEST_CODE", paramChannelsTestDAO.getTest_code());
    localChannelsTestExt.setParam(":VTEST_TYPE", paramChannelsTestDAO.getTest_type());
    localChannelsTestExt.setParam(":VTEST_NUM", paramChannelsTestDAO.getTest_num());
    localChannelsTestExt.setParam(":VTEST_RAGE", paramChannelsTestDAO.getTest_rage());
    localChannelsTestExt.setParam(":VTEST_CUST_ID", paramChannelsTestDAO.getTest_cust_id());
    localChannelsTestExt.setParam(":VSTART_DATE", paramChannelsTestDAO.getStart_date());
    localChannelsTestExt.setParam(":VEND_DATE", paramChannelsTestDAO.getEnd_date());
    localChannelsTestExt.setParam(":VCLASS_RAGE", paramChannelsTestDAO.getClass_rage());
    localChannelsTestExt.setParam(":VLEVEL_RAGE", paramChannelsTestDAO.getLevel_rage());
    localChannelsTestExt.setParam(":VFIRST_TAG", paramChannelsTestDAO.getFirst_tag());
    localChannelsTestExt.setParam(":VOPER_USER_ID", paramChannelsTestDAO.getOper_user_id());
    localChannelsTestExt.setParam(":VIN_DATE", paramChannelsTestDAO.getIn_date());
    localChannelsTestExt.setParam(":VREMARK", paramChannelsTestDAO.getRemark());
    this.tradeQuery.executeBy(localChannelsTestExt.insBy("UP_TEST_BY_ALL"));
    return 0;
  }

  public ArrayList getListByTestId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelsTestExt localChannelsTestExt = new ChannelsTestExt();
    localChannelsTestExt.setParam(":VCUST_ID", paramString1);
    localChannelsTestExt.setParam(":VTEST_ID", paramString2);
    ArrayList localArrayList = localChannelsTestExt.selByList("SEL_BY_TEST_ID");
    return localArrayList;
  }

  public ArrayList getTestById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelsTestExt localChannelsTestExt = new ChannelsTestExt();
    localChannelsTestExt.setParam(":VCUST_ID", paramString);
    localArrayList = localChannelsTestExt.selByList("SEL_BY_TEST");
    return localArrayList;
  }

  public void delChannelsTest(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delChannelsTest方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TEST_ID");
    try
    {
      ChannelsTestDAO localChannelsTestDAO = new ChannelsTestDAO();
      localChannelsTestDAO.setCust_id(str1);
      localChannelsTestDAO.setTest_id(str2);
      i = delChannelsTest(localChannelsTestDAO);
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
    this.log.LOG_INFO("退出delChannelsTest方法...");
  }

  public int delChannelsTest(ChannelsTestDAO paramChannelsTestDAO)
    throws SaasApplicationException
  {
    ChannelsTestExt localChannelsTestExt = new ChannelsTestExt();
    localChannelsTestExt.setParam(":VCUST_ID", paramChannelsTestDAO.getCust_id());
    localChannelsTestExt.setParam(":VTEST_ID", paramChannelsTestDAO.getTest_id());
    this.tradeQuery.executeBy(localChannelsTestExt.insBy("DEL_TEST_BY_ALL"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.channelsTestMgr.ChannelsTestInfo
 * JD-Core Version:    0.6.0
 */