package com.saas.biz.testListMgr;

import com.saas.biz.dao.testListDAO.TestListDAO;
import com.saas.biz.dao.testListDAO.TestListExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class TestListInfo
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

  public void addTestList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addTestList方法...");
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
      TestListDAO localTestListDAO = new TestListDAO();
      localTestListDAO.setCust_id(str1);
      localTestListDAO.setChannels_type(str2);
      localTestListDAO.setObj_cust_id(str3);
      localTestListDAO.setTest_id(str4);
      localTestListDAO.setTest_month(str5);
      localTestListDAO.setTest_date(str6);
      localTestListDAO.setTest_value(str7);
      localTestListDAO.setTest_desc(str8);
      localTestListDAO.setEnable_tag(str9);
      localTestListDAO.setOper_user_id(str10);
      localTestListDAO.setIn_date(str11);
      localTestListDAO.setRemark(str12);
      i = addTestList(localTestListDAO);
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
    this.log.LOG_INFO("退出addTestList方法...");
  }

  public int addTestList(TestListDAO paramTestListDAO)
    throws SaasApplicationException
  {
    TestListExt localTestListExt = new TestListExt();
    localTestListExt.setParam(":VCUST_ID", paramTestListDAO.getCust_id());
    localTestListExt.setParam(":VCHANNELS_TYPE", paramTestListDAO.getChannels_type());
    localTestListExt.setParam(":VOBJ_CUST_ID", paramTestListDAO.getObj_cust_id());
    localTestListExt.setParam(":VTEST_ID", paramTestListDAO.getTest_id());
    localTestListExt.setParam(":VTEST_MONTH", paramTestListDAO.getTest_month());
    localTestListExt.setParam(":VTEST_DATE", paramTestListDAO.getTest_date());
    localTestListExt.setParam(":VTEST_VALUE", paramTestListDAO.getTest_value());
    localTestListExt.setParam(":VTEST_DESC", paramTestListDAO.getTest_desc());
    localTestListExt.setParam(":VENABLE_TAG", paramTestListDAO.getEnable_tag());
    localTestListExt.setParam(":VOPER_USER_ID", paramTestListDAO.getOper_user_id());
    localTestListExt.setParam(":VIN_DATE", paramTestListDAO.getIn_date());
    localTestListExt.setParam(":VREMARK", paramTestListDAO.getRemark());
    this.tradeQuery.executeBy(localTestListExt.insBy("INS_BY_VALUE_LIST"));
    return 0;
  }

  public ArrayList getAllTestList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    TestListExt localTestListExt = new TestListExt();
    localTestListExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localTestListExt.selByList("SEL_BY_KKK", paramInt, 20);
    return localArrayList;
  }

  public int getAllTestList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    TestListExt localTestListExt = new TestListExt();
    localTestListExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localTestListExt.selByList("SEL_BY_KKK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void modifyTestList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyTestList方法...");
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
      TestListDAO localTestListDAO = new TestListDAO();
      localTestListDAO.setCust_id(str1);
      localTestListDAO.setTest_id(str2);
      localTestListDAO.setTest_month(str3);
      localTestListDAO.setTest_date(str4);
      localTestListDAO.setTest_value(str5);
      localTestListDAO.setTest_desc(str6);
      localTestListDAO.setEnable_tag(str7);
      localTestListDAO.setOper_user_id(str8);
      localTestListDAO.setIn_date(str9);
      localTestListDAO.setRemark(str10);
      i = modifyTestList(localTestListDAO);
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
    this.log.LOG_INFO("退出modifyTestList方法...");
  }

  public int modifyTestList(TestListDAO paramTestListDAO)
    throws SaasApplicationException
  {
    TestListExt localTestListExt = new TestListExt();
    localTestListExt.setParam(":VCUST_ID", paramTestListDAO.getCust_id());
    localTestListExt.setParam(":VTEST_ID", paramTestListDAO.getTest_id());
    localTestListExt.setParam(":VTEST_MONTH", paramTestListDAO.getTest_month());
    localTestListExt.setParam(":VTEST_DATE", paramTestListDAO.getTest_date());
    localTestListExt.setParam(":VTEST_VALUE", paramTestListDAO.getTest_value());
    localTestListExt.setParam(":VTEST_DESC", paramTestListDAO.getTest_desc());
    localTestListExt.setParam(":VENABLE_TAG", paramTestListDAO.getEnable_tag());
    localTestListExt.setParam(":VOPER_USER_ID", paramTestListDAO.getOper_user_id());
    localTestListExt.setParam(":VIN_DATE", paramTestListDAO.getIn_date());
    localTestListExt.setParam(":VREMARK", paramTestListDAO.getRemark());
    this.tradeQuery.executeBy(localTestListExt.insBy("UP_TEST_BY_ALL"));
    return 0;
  }

  public ArrayList getListByValueId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    TestListExt localTestListExt = new TestListExt();
    localTestListExt.setParam(":VCUST_ID", paramString1);
    localTestListExt.setParam(":VTEST_ID", paramString2);
    ArrayList localArrayList = localTestListExt.selByList("SEL_BY_VALUE_ID");
    return localArrayList;
  }

  public ArrayList getValueById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TestListExt localTestListExt = new TestListExt();
    localTestListExt.setParam(":VCUST_ID", paramString);
    localArrayList = localTestListExt.selByList("SEL_BY_KKK");
    return localArrayList;
  }

  public ArrayList getOneTest(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TestListExt localTestListExt = new TestListExt();
    localTestListExt.setParam(":VCUST_ID", paramString1);
    localTestListExt.setParam(":VTEST_ID", paramString2);
    localArrayList = localTestListExt.selByList("SEL_ONE_BY_TEST_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.testListMgr.TestListInfo
 * JD-Core Version:    0.6.0
 */