package com.saas.biz.valueResultMgr;

import com.saas.biz.dao.valueResultDAO.ValueResultDAO;
import com.saas.biz.dao.valueResultDAO.ValueResultExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class ValueResultInfo
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

  public void addResultList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addResultList方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("OBJ_CUST_ID");
    String str4 = paramBuffers.getString("VALUE_MONTH");
    String str5 = paramBuffers.getString("VALUE_DATE");
    String str6 = paramBuffers.getString("VALUE_NUM");
    String str7 = paramBuffers.getString("VALUE_DESC");
    String str8 = paramBuffers.getString("PAT_TAG");
    String str9 = paramBuffers.getString("PAY_DATE");
    String str10 = paramBuffers.getString("PAY_TYPE");
    String str11 = paramBuffers.getString("PAY_USER_ID");
    String str12 = paramBuffers.getString("SESSION_USER_ID");
    String str13 = paramBuffers.getString("IN_DATE");
    String str14 = paramBuffers.getString("REMARK");
    try
    {
      ValueResultDAO localValueResultDAO = new ValueResultDAO();
      localValueResultDAO.setCust_id(str1);
      localValueResultDAO.setChannels_type(str2);
      localValueResultDAO.setObj_cust_id(str3);
      localValueResultDAO.setValue_month(str4);
      localValueResultDAO.setValue_date(str5);
      localValueResultDAO.setValue_num(str6);
      localValueResultDAO.setValue_desc(str7);
      localValueResultDAO.setPat_tag(str8);
      localValueResultDAO.setPay_date(str9);
      localValueResultDAO.setPay_type(str10);
      localValueResultDAO.setPay_user_id(str11);
      localValueResultDAO.setOper_user_id(str12);
      localValueResultDAO.setIn_date(str13);
      localValueResultDAO.setRemark(str14);
      i = addResultList(localValueResultDAO);
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

  public int addResultList(ValueResultDAO paramValueResultDAO)
    throws SaasApplicationException
  {
    ValueResultExt localValueResultExt = new ValueResultExt();
    localValueResultExt.setParam(":VCUST_ID", paramValueResultDAO.getCust_id());
    localValueResultExt.setParam(":VCHANNELS_TYPE", paramValueResultDAO.getChannels_type());
    localValueResultExt.setParam(":VOBJ_CUST_ID", paramValueResultDAO.getObj_cust_id());
    localValueResultExt.setParam(":VVALUE_MONTH", paramValueResultDAO.getValue_month());
    localValueResultExt.setParam(":VVALUE_DATE", paramValueResultDAO.getValue_date());
    localValueResultExt.setParam(":VVALUE_NUM", paramValueResultDAO.getValue_num());
    localValueResultExt.setParam(":VVALUE_DESC", paramValueResultDAO.getValue_desc());
    localValueResultExt.setParam(":VPAT_TAG", paramValueResultDAO.getPat_tag());
    localValueResultExt.setParam(":VPAY_DATE", paramValueResultDAO.getPay_date());
    localValueResultExt.setParam(":VPAY_TYPE", paramValueResultDAO.getPay_type());
    localValueResultExt.setParam(":VPAY_USER_ID", paramValueResultDAO.getPay_user_id());
    localValueResultExt.setParam(":VOPER_USER_ID", paramValueResultDAO.getOper_user_id());
    localValueResultExt.setParam(":VIN_DATE", paramValueResultDAO.getIn_date());
    localValueResultExt.setParam(":VREMARK", paramValueResultDAO.getRemark());
    this.tradeQuery.executeBy(localValueResultExt.insBy("INS_BY_RESULT_LIST"));
    return 0;
  }

  public ArrayList getAllValueList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ValueResultExt localValueResultExt = new ValueResultExt();
    localValueResultExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localValueResultExt.selByList("SEL_BY_KKK", paramInt, 20);
    return localArrayList;
  }

  public int getAllValueList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ValueResultExt localValueResultExt = new ValueResultExt();
    localValueResultExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localValueResultExt.selByList("SEL_BY_KKK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void modifyResultList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyResultList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("OBJ_CUST_ID");
    String str4 = paramBuffers.getString("VALUE_MONTH");
    String str5 = paramBuffers.getString("VALUE_DATE");
    String str6 = paramBuffers.getString("VALUE_NUM");
    String str7 = paramBuffers.getString("VALUE_DESC");
    String str8 = paramBuffers.getString("PAT_TAG");
    String str9 = paramBuffers.getString("PAY_DATE");
    String str10 = paramBuffers.getString("PAY_TYPE");
    String str11 = paramBuffers.getString("PAY_USER_ID");
    String str12 = paramBuffers.getString("SESSION_USER_ID");
    String str13 = paramBuffers.getString("IN_DATE");
    String str14 = paramBuffers.getString("REMARK");
    try
    {
      ValueResultDAO localValueResultDAO = new ValueResultDAO();
      localValueResultDAO.setCust_id(str1);
      localValueResultDAO.setChannels_type(str2);
      localValueResultDAO.setObj_cust_id(str3);
      localValueResultDAO.setValue_month(str4);
      localValueResultDAO.setValue_date(str5);
      localValueResultDAO.setValue_num(str6);
      localValueResultDAO.setValue_desc(str7);
      localValueResultDAO.setPat_tag(str8);
      localValueResultDAO.setPay_date(str9);
      localValueResultDAO.setPay_type(str10);
      localValueResultDAO.setPay_user_id(str11);
      localValueResultDAO.setOper_user_id(str12);
      localValueResultDAO.setIn_date(str13);
      localValueResultDAO.setRemark(str14);
      i = modifyResultList(localValueResultDAO);
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
    this.log.LOG_INFO("退出modifyResultList方法...");
  }

  public int modifyResultList(ValueResultDAO paramValueResultDAO)
    throws SaasApplicationException
  {
    ValueResultExt localValueResultExt = new ValueResultExt();
    localValueResultExt.setParam(":VCUST_ID", paramValueResultDAO.getCust_id());
    localValueResultExt.setParam(":VCHANNELS_TYPE", paramValueResultDAO.getChannels_type());
    localValueResultExt.setParam(":VOBJ_CUST_ID", paramValueResultDAO.getObj_cust_id());
    localValueResultExt.setParam(":VVALUE_MONTH", paramValueResultDAO.getValue_month());
    localValueResultExt.setParam(":VVALUE_DATE", paramValueResultDAO.getValue_date());
    localValueResultExt.setParam(":VVALUE_NUM", paramValueResultDAO.getValue_num());
    localValueResultExt.setParam(":VVALUE_DESC", paramValueResultDAO.getValue_desc());
    localValueResultExt.setParam(":VPAT_TAG", paramValueResultDAO.getPat_tag());
    localValueResultExt.setParam(":VPAY_DATE", paramValueResultDAO.getPay_date());
    localValueResultExt.setParam(":VPAY_TYPE", paramValueResultDAO.getPay_type());
    localValueResultExt.setParam(":VPAY_USER_ID", paramValueResultDAO.getPay_user_id());
    localValueResultExt.setParam(":VOPER_USER_ID", paramValueResultDAO.getOper_user_id());
    localValueResultExt.setParam(":VIN_DATE", paramValueResultDAO.getIn_date());
    localValueResultExt.setParam(":VREMARK", paramValueResultDAO.getRemark());
    this.tradeQuery.executeBy(localValueResultExt.insBy("UP_VALUE_BY_ALL"));
    return 0;
  }

  public ArrayList getListByValueId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ValueResultExt localValueResultExt = new ValueResultExt();
    localValueResultExt.setParam(":VCUST_ID", paramString1);
    localValueResultExt.setParam(":VTEST_ID", paramString2);
    ArrayList localArrayList = localValueResultExt.selByList("SEL_BY_VALUE_ID");
    return localArrayList;
  }

  public ArrayList getValueById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ValueResultExt localValueResultExt = new ValueResultExt();
    localValueResultExt.setParam(":VCUST_ID", paramString);
    localArrayList = localValueResultExt.selByList("SEL_BY_KKK");
    return localArrayList;
  }

  public ArrayList getOneValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ValueResultExt localValueResultExt = new ValueResultExt();
    localValueResultExt.setParam(":VCUST_ID", paramString1);
    localValueResultExt.setParam(":VTEST_ID", paramString2);
    localArrayList = localValueResultExt.selByList("SEL_ONE_BY_TEST_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.valueResultMgr.ValueResultInfo
 * JD-Core Version:    0.6.0
 */