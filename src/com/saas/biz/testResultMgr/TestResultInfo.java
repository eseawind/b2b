package com.saas.biz.testResultMgr;

import com.saas.biz.dao.testResultDAO.TestResultDAO;
import com.saas.biz.dao.testResultDAO.TestResultExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class TestResultInfo
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

  public void addTestResultList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addTestResultList方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("OBJ_CUST_ID");
    String str4 = paramBuffers.getString("TEST_MONTH");
    String str5 = paramBuffers.getString("TEST_DATE");
    String str6 = paramBuffers.getString("TEST_VALUE");
    String str7 = paramBuffers.getString("TEST_DESC");
    String str8 = paramBuffers.getString("ENABLE_TAG");
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("IN_DATE");
    String str11 = paramBuffers.getString("REMARK");
    try
    {
      TestResultDAO localTestResultDAO = new TestResultDAO();
      localTestResultDAO.setCust_id(str1);
      localTestResultDAO.setChannels_type(str2);
      localTestResultDAO.setObj_cust_id(str3);
      localTestResultDAO.setTest_month(str4);
      localTestResultDAO.setTest_date(str5);
      localTestResultDAO.setTest_value(str6);
      localTestResultDAO.setTest_desc(str7);
      localTestResultDAO.setEnable_tag(str8);
      localTestResultDAO.setOper_user_id(str9);
      localTestResultDAO.setIn_date(str10);
      localTestResultDAO.setRemark(str11);
      i = addTestResultList(localTestResultDAO);
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
    this.log.LOG_INFO("退出addTestResultList方法...");
  }

  public int addTestResultList(TestResultDAO paramTestResultDAO)
    throws SaasApplicationException
  {
    TestResultExt localTestResultExt = new TestResultExt();
    localTestResultExt.setParam(":VCUST_ID", paramTestResultDAO.getCust_id());
    localTestResultExt.setParam(":VCHANNELS_TYPE", paramTestResultDAO.getChannels_type());
    localTestResultExt.setParam(":VOBJ_CUST_ID", paramTestResultDAO.getObj_cust_id());
    localTestResultExt.setParam(":VTEST_MONTH", paramTestResultDAO.getTest_month());
    localTestResultExt.setParam(":VTEST_DATE", paramTestResultDAO.getTest_date());
    localTestResultExt.setParam(":VTEST_VALUE", paramTestResultDAO.getTest_value());
    localTestResultExt.setParam(":VTEST_DESC", paramTestResultDAO.getTest_desc());
    localTestResultExt.setParam(":VENABLE_TAG", paramTestResultDAO.getEnable_tag());
    localTestResultExt.setParam(":VOPER_USER_ID", paramTestResultDAO.getOper_user_id());
    localTestResultExt.setParam(":VIN_DATE", paramTestResultDAO.getIn_date());
    localTestResultExt.setParam(":VREMARK", paramTestResultDAO.getRemark());
    this.tradeQuery.executeBy(localTestResultExt.insBy("INS_BY_RESULT"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.testResultMgr.TestResultInfo
 * JD-Core Version:    0.6.0
 */