package com.saas.biz.channelsValueMgr;

import com.saas.biz.dao.channelsValueDAO.ChannelsValueDAO;
import com.saas.biz.dao.channelsValueDAO.ChannelsValueExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ChannelsValueInfo
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

  public void addChannelsValue(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addChannelsValue方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_ID");
    String str3 = paramBuffers.getString("VALUE_ID");
    String str4 = paramBuffers.getString("VALUE_NAME");
    String str5 = paramBuffers.getString("VALUE_CODE");
    String str6 = paramBuffers.getString("VALUE_TYPE");
    String str7 = paramBuffers.getString("VALUE_NUM");
    String str8 = paramBuffers.getString("VALUE_RAGE");
    String str9 = paramBuffers.getString("VALUE_CUST_ID");
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
      ChannelsValueDAO localChannelsValueDAO = new ChannelsValueDAO();
      localChannelsValueDAO.setCust_id(str1);
      localChannelsValueDAO.setChannels_id(str2);
      localChannelsValueDAO.setValue_id(str3);
      localChannelsValueDAO.setValue_name(str4);
      localChannelsValueDAO.setValue_code(str5);
      localChannelsValueDAO.setValue_type(str6);
      localChannelsValueDAO.setValue_num(str7);
      localChannelsValueDAO.setValue_rage(str8);
      localChannelsValueDAO.setValue_cust_id(str9);
      localChannelsValueDAO.setStart_date(str10);
      localChannelsValueDAO.setEnd_date(str11);
      localChannelsValueDAO.setClass_rage(str12);
      localChannelsValueDAO.setLevel_rage(str13);
      localChannelsValueDAO.setFirst_tag(str14);
      localChannelsValueDAO.setOper_user_id(str15);
      localChannelsValueDAO.setIn_date(str16);
      localChannelsValueDAO.setRemark(str17);
      i = addChannelsValue(localChannelsValueDAO);
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
    this.log.LOG_INFO("退出addChannelsValue方法...");
  }

  public int addChannelsValue(ChannelsValueDAO paramChannelsValueDAO)
    throws SaasApplicationException
  {
    ChannelsValueExt localChannelsValueExt = new ChannelsValueExt();
    localChannelsValueExt.setParam(":VCUST_ID", paramChannelsValueDAO.getCust_id());
    localChannelsValueExt.setParam(":VCHANNELS_ID", paramChannelsValueDAO.getChannels_id());
    localChannelsValueExt.setParam(":VVALUE_ID", paramChannelsValueDAO.getValue_id());
    localChannelsValueExt.setParam(":VVALUE_NAME", paramChannelsValueDAO.getValue_name());
    localChannelsValueExt.setParam(":VVALUE_CODE", paramChannelsValueDAO.getValue_code());
    localChannelsValueExt.setParam(":VVALUE_TYPE", paramChannelsValueDAO.getValue_type());
    localChannelsValueExt.setParam(":VVALUE_NUM", paramChannelsValueDAO.getValue_num());
    localChannelsValueExt.setParam(":VVALUE_RAGE", paramChannelsValueDAO.getValue_rage());
    localChannelsValueExt.setParam(":VVALUE_CUST_ID", paramChannelsValueDAO.getValue_cust_id());
    localChannelsValueExt.setParam(":VSTART_DATE", paramChannelsValueDAO.getStart_date());
    localChannelsValueExt.setParam(":VEND_DATE", paramChannelsValueDAO.getEnd_date());
    localChannelsValueExt.setParam(":VCLASS_RAGE", paramChannelsValueDAO.getClass_rage());
    localChannelsValueExt.setParam(":VLEVEL_RAGE", paramChannelsValueDAO.getLevel_rage());
    localChannelsValueExt.setParam(":VFIRST_TAG", paramChannelsValueDAO.getFirst_tag());
    localChannelsValueExt.setParam(":VOPER_USER_ID", paramChannelsValueDAO.getOper_user_id());
    localChannelsValueExt.setParam(":VIN_DATE", paramChannelsValueDAO.getIn_date());
    localChannelsValueExt.setParam(":VREMARK", paramChannelsValueDAO.getRemark());
    this.tradeQuery.executeBy(localChannelsValueExt.insBy("INS_BY_CHA_VALUE"));
    return 0;
  }

  public ArrayList getListByValue(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ChannelsValueExt localChannelsValueExt = new ChannelsValueExt();
    localChannelsValueExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localChannelsValueExt.selByList("SEL_BY_VALUE", paramInt, 20);
    return localArrayList;
  }

  public int getListByValueCt(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ChannelsValueExt localChannelsValueExt = new ChannelsValueExt();
    localChannelsValueExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localChannelsValueExt.selByList("SEL_VLAUE_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public void modifyChannelsValue(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyChannelsValue方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_ID");
    String str3 = paramBuffers.getString("VALUE_ID");
    String str4 = paramBuffers.getString("VALUE_NAME");
    String str5 = paramBuffers.getString("VALUE_CODE");
    String str6 = paramBuffers.getString("VALUE_TYPE");
    String str7 = paramBuffers.getString("VALUE_NUM");
    String str8 = paramBuffers.getString("VALUE_RAGE");
    String str9 = paramBuffers.getString("VALUE_CUST_ID");
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
      ChannelsValueDAO localChannelsValueDAO = new ChannelsValueDAO();
      localChannelsValueDAO.setCust_id(str1);
      localChannelsValueDAO.setChannels_id(str2);
      localChannelsValueDAO.setValue_id(str3);
      localChannelsValueDAO.setValue_name(str4);
      localChannelsValueDAO.setValue_code(str5);
      localChannelsValueDAO.setValue_type(str6);
      localChannelsValueDAO.setValue_num(str7);
      localChannelsValueDAO.setValue_rage(str8);
      localChannelsValueDAO.setValue_cust_id(str9);
      localChannelsValueDAO.setStart_date(str10);
      localChannelsValueDAO.setEnd_date(str11);
      localChannelsValueDAO.setClass_rage(str12);
      localChannelsValueDAO.setLevel_rage(str13);
      localChannelsValueDAO.setFirst_tag(str14);
      localChannelsValueDAO.setOper_user_id(str15);
      localChannelsValueDAO.setIn_date(str16);
      localChannelsValueDAO.setRemark(str17);
      i = modifyChannelsValue(localChannelsValueDAO);
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
    this.log.LOG_INFO("退出modifyChannelsValue方法...");
  }

  public int modifyChannelsValue(ChannelsValueDAO paramChannelsValueDAO)
    throws SaasApplicationException
  {
    ChannelsValueExt localChannelsValueExt = new ChannelsValueExt();
    localChannelsValueExt.setParam(":VCUST_ID", paramChannelsValueDAO.getCust_id());
    localChannelsValueExt.setParam(":VCHANNELS_ID", paramChannelsValueDAO.getChannels_id());
    localChannelsValueExt.setParam(":VVALUE_ID", paramChannelsValueDAO.getValue_id());
    localChannelsValueExt.setParam(":VVALUE_NAME", paramChannelsValueDAO.getValue_name());
    localChannelsValueExt.setParam(":VVALUE_CODE", paramChannelsValueDAO.getValue_code());
    localChannelsValueExt.setParam(":VVALUE_TYPE", paramChannelsValueDAO.getValue_type());
    localChannelsValueExt.setParam(":VVALUE_NUM", paramChannelsValueDAO.getValue_num());
    localChannelsValueExt.setParam(":VVALUE_RAGE", paramChannelsValueDAO.getValue_rage());
    localChannelsValueExt.setParam(":VVALUE_CUST_ID", paramChannelsValueDAO.getValue_cust_id());
    localChannelsValueExt.setParam(":VSTART_DATE", paramChannelsValueDAO.getStart_date());
    localChannelsValueExt.setParam(":VEND_DATE", paramChannelsValueDAO.getEnd_date());
    localChannelsValueExt.setParam(":VCLASS_RAGE", paramChannelsValueDAO.getClass_rage());
    localChannelsValueExt.setParam(":VLEVEL_RAGE", paramChannelsValueDAO.getLevel_rage());
    localChannelsValueExt.setParam(":VFIRST_TAG", paramChannelsValueDAO.getFirst_tag());
    localChannelsValueExt.setParam(":VOPER_USER_ID", paramChannelsValueDAO.getOper_user_id());
    localChannelsValueExt.setParam(":VIN_DATE", paramChannelsValueDAO.getIn_date());
    localChannelsValueExt.setParam(":VREMARK", paramChannelsValueDAO.getRemark());
    this.tradeQuery.executeBy(localChannelsValueExt.insBy("UP_VALUE_BY_ALL"));
    return 0;
  }

  public ArrayList getListByValueId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelsValueExt localChannelsValueExt = new ChannelsValueExt();
    localChannelsValueExt.setParam(":VCUST_ID", paramString1);
    localChannelsValueExt.setParam(":VTEST_ID", paramString2);
    ArrayList localArrayList = localChannelsValueExt.selByList("SEL_BY_VALUE_ID");
    return localArrayList;
  }

  public ArrayList getListByValueById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelsValueExt localChannelsValueExt = new ChannelsValueExt();
    localChannelsValueExt.setParam(":VCUST_ID", paramString1);
    localChannelsValueExt.setParam(":VVALUE_ID", paramString2);
    ArrayList localArrayList = localChannelsValueExt.selByList("SEL_BY_VALUE_ID");
    return localArrayList;
  }

  public void delChannelsValue(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delChannelsValue方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("VALUE_ID");
    try
    {
      ChannelsValueDAO localChannelsValueDAO = new ChannelsValueDAO();
      localChannelsValueDAO.setCust_id(str1);
      localChannelsValueDAO.setValue_id(str2);
      i = delChannelsValue(localChannelsValueDAO);
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
    this.log.LOG_INFO("退出delChannelsValue方法...");
  }

  public int delChannelsValue(ChannelsValueDAO paramChannelsValueDAO)
    throws SaasApplicationException
  {
    ChannelsValueExt localChannelsValueExt = new ChannelsValueExt();
    localChannelsValueExt.setParam(":VCUST_ID", paramChannelsValueDAO.getCust_id());
    localChannelsValueExt.setParam(":VVALUE_ID", paramChannelsValueDAO.getValue_id());
    this.tradeQuery.executeBy(localChannelsValueExt.insBy("DEL_VALUE_BY_ALL"));
    return 0;
  }

  public ArrayList getValueById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelsValueExt localChannelsValueExt = new ChannelsValueExt();
    localChannelsValueExt.setParam(":VCUST_ID", paramString);
    localArrayList = localChannelsValueExt.selByList("SEL_BY_VALUE");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.channelsValueMgr.ChannelsValueInfo
 * JD-Core Version:    0.6.0
 */