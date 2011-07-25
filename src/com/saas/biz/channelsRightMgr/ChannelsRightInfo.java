package com.saas.biz.channelsRightMgr;

import com.saas.biz.dao.channelsrightDAO.ChannelsRightDAO;
import com.saas.biz.dao.channelsrightDAO.ChannelsRightExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ChannelsRightInfo
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

  public void addChannelsRight(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addChannelsRight方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_ID");
    String str3 = paramBuffers.getString("RIGHT_ID");
    String str4 = paramBuffers.getString("RIGHT_NAME");
    String str5 = paramBuffers.getString("RIGHT_CODE");
    String str6 = paramBuffers.getString("RIGHT_TYPE");
    String str7 = paramBuffers.getString("RIGHT_VALUE");
    String str8 = paramBuffers.getString("RIGHT_RAGE");
    String str9 = paramBuffers.getString("RIGHT_CUST_ID");
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
      ChannelsRightDAO localChannelsRightDAO = new ChannelsRightDAO();
      localChannelsRightDAO.setCust_id(str1);
      localChannelsRightDAO.setChannels_id(str2);
      localChannelsRightDAO.setRight_id(str3);
      localChannelsRightDAO.setRight_name(str4);
      localChannelsRightDAO.setRight_code(str5);
      localChannelsRightDAO.setRight_type(str6);
      localChannelsRightDAO.setRight_value(str7);
      localChannelsRightDAO.setRight_rage(str8);
      localChannelsRightDAO.setRight_cust_id(str9);
      localChannelsRightDAO.setStart_date(str10);
      localChannelsRightDAO.setEnd_date(str11);
      localChannelsRightDAO.setClass_rage(str12);
      localChannelsRightDAO.setLevel_rage(str13);
      localChannelsRightDAO.setFirst_tag(str14);
      localChannelsRightDAO.setOper_user_id(str15);
      localChannelsRightDAO.setIn_date(str16);
      localChannelsRightDAO.setRemark(str17);
      i = addChannelsRight(localChannelsRightDAO);
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
    this.log.LOG_INFO("退出addChannelsRight方法...");
  }

  public int addChannelsRight(ChannelsRightDAO paramChannelsRightDAO)
    throws SaasApplicationException
  {
    ChannelsRightExt localChannelsRightExt = new ChannelsRightExt();
    localChannelsRightExt.setParam(":VCUST_ID", paramChannelsRightDAO.getCust_id());
    localChannelsRightExt.setParam(":VCHANNELS_ID", paramChannelsRightDAO.getChannels_id());
    localChannelsRightExt.setParam(":VRIGHT_ID", paramChannelsRightDAO.getRight_id());
    localChannelsRightExt.setParam(":VRIGHT_NAME", paramChannelsRightDAO.getRight_name());
    localChannelsRightExt.setParam(":VRIGHT_CODE", paramChannelsRightDAO.getRight_code());
    localChannelsRightExt.setParam(":VRIGHT_TYPE", paramChannelsRightDAO.getRight_type());
    localChannelsRightExt.setParam(":VRIGHT_VALUE", paramChannelsRightDAO.getRight_value());
    localChannelsRightExt.setParam(":VRIGHT_RAGE", paramChannelsRightDAO.getRight_rage());
    localChannelsRightExt.setParam(":VRIGHT_CUST_ID", paramChannelsRightDAO.getRight_cust_id());
    localChannelsRightExt.setParam(":VSTART_DATE", paramChannelsRightDAO.getStart_date());
    localChannelsRightExt.setParam(":VEND_DATE", paramChannelsRightDAO.getEnd_date());
    localChannelsRightExt.setParam(":VCLASS_RAGE", paramChannelsRightDAO.getClass_rage());
    localChannelsRightExt.setParam(":VLEVEL_RAGE", paramChannelsRightDAO.getLevel_rage());
    localChannelsRightExt.setParam(":VFIRST_TAG", paramChannelsRightDAO.getFirst_tag());
    localChannelsRightExt.setParam(":VOPER_USER_ID", paramChannelsRightDAO.getOper_user_id());
    localChannelsRightExt.setParam(":VIN_DATE", paramChannelsRightDAO.getIn_date());
    localChannelsRightExt.setParam(":VREMARK", paramChannelsRightDAO.getRemark());
    this.tradeQuery.executeBy(localChannelsRightExt.insBy("INS_BY_CHA_RIG"));
    return 0;
  }

  public ArrayList getListByRight(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ChannelsRightExt localChannelsRightExt = new ChannelsRightExt();
    localChannelsRightExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localChannelsRightExt.selByList("SEL_BY_RIGHT", paramInt, 20);
    return localArrayList;
  }

  public int getListByRightCt(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ChannelsRightExt localChannelsRightExt = new ChannelsRightExt();
    localChannelsRightExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localChannelsRightExt.selByList("SEL_RIGHT_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public void modifyChannelsRig(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyChannelsRig方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_ID");
    String str3 = paramBuffers.getString("RIGHT_ID");
    String str4 = paramBuffers.getString("RIGHT_NAME");
    String str5 = paramBuffers.getString("RIGHT_CODE");
    String str6 = paramBuffers.getString("RIGHT_TYPE");
    String str7 = paramBuffers.getString("RIGHT_VALUE");
    String str8 = paramBuffers.getString("RIGHT_RAGE");
    String str9 = paramBuffers.getString("RIGHT_CUST_ID");
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
      ChannelsRightDAO localChannelsRightDAO = new ChannelsRightDAO();
      localChannelsRightDAO.setCust_id(str1);
      localChannelsRightDAO.setChannels_id(str2);
      localChannelsRightDAO.setRight_id(str3);
      localChannelsRightDAO.setRight_name(str4);
      localChannelsRightDAO.setRight_code(str5);
      localChannelsRightDAO.setRight_type(str6);
      localChannelsRightDAO.setRight_value(str7);
      localChannelsRightDAO.setRight_rage(str8);
      localChannelsRightDAO.setRight_cust_id(str9);
      localChannelsRightDAO.setStart_date(str10);
      localChannelsRightDAO.setEnd_date(str11);
      localChannelsRightDAO.setClass_rage(str12);
      localChannelsRightDAO.setLevel_rage(str13);
      localChannelsRightDAO.setFirst_tag(str14);
      localChannelsRightDAO.setOper_user_id(str15);
      localChannelsRightDAO.setIn_date(str16);
      localChannelsRightDAO.setRemark(str17);
      i = modifyChannelsRig(localChannelsRightDAO);
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
    this.log.LOG_INFO("退出modifyChannelsRig方法...");
  }

  public int modifyChannelsRig(ChannelsRightDAO paramChannelsRightDAO)
    throws SaasApplicationException
  {
    ChannelsRightExt localChannelsRightExt = new ChannelsRightExt();
    localChannelsRightExt.setParam(":VCUST_ID", paramChannelsRightDAO.getCust_id());
    localChannelsRightExt.setParam(":VCHANNELS_ID", paramChannelsRightDAO.getChannels_id());
    localChannelsRightExt.setParam(":VRIGHT_ID", paramChannelsRightDAO.getRight_id());
    localChannelsRightExt.setParam(":VRIGHT_NAME", paramChannelsRightDAO.getRight_name());
    localChannelsRightExt.setParam(":VRIGHT_CODE", paramChannelsRightDAO.getRight_code());
    localChannelsRightExt.setParam(":VRIGHT_TYPE", paramChannelsRightDAO.getRight_type());
    localChannelsRightExt.setParam(":VRIGHT_VALUE", paramChannelsRightDAO.getRight_value());
    localChannelsRightExt.setParam(":VRIGHT_RAGE", paramChannelsRightDAO.getRight_rage());
    localChannelsRightExt.setParam(":VRIGHT_CUST_ID", paramChannelsRightDAO.getRight_cust_id());
    localChannelsRightExt.setParam(":VSTART_DATE", paramChannelsRightDAO.getStart_date());
    localChannelsRightExt.setParam(":VEND_DATE", paramChannelsRightDAO.getEnd_date());
    localChannelsRightExt.setParam(":VCLASS_RAGE", paramChannelsRightDAO.getClass_rage());
    localChannelsRightExt.setParam(":VLEVEL_RAGE", paramChannelsRightDAO.getLevel_rage());
    localChannelsRightExt.setParam(":VFIRST_TAG", paramChannelsRightDAO.getFirst_tag());
    localChannelsRightExt.setParam(":VOPER_USER_ID", paramChannelsRightDAO.getOper_user_id());
    localChannelsRightExt.setParam(":VIN_DATE", paramChannelsRightDAO.getIn_date());
    localChannelsRightExt.setParam(":VREMARK", paramChannelsRightDAO.getRemark());
    this.tradeQuery.executeBy(localChannelsRightExt.insBy("UP_RIG_BY_ALL"));
    return 0;
  }

  public ArrayList getListByRightId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelsRightExt localChannelsRightExt = new ChannelsRightExt();
    localChannelsRightExt.setParam(":VCUST_ID", paramString1);
    localChannelsRightExt.setParam(":VRIGHT_ID", paramString2);
    ArrayList localArrayList = localChannelsRightExt.selByList("SEL_BY_RIGHT_ID");
    return localArrayList;
  }

  public void delChannelsRig(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delChannelsRig方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("RIGHT_ID");
    try
    {
      ChannelsRightDAO localChannelsRightDAO = new ChannelsRightDAO();
      localChannelsRightDAO.setCust_id(str1);
      localChannelsRightDAO.setRight_id(str2);
      i = delChannelsRig(localChannelsRightDAO);
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
    this.log.LOG_INFO("退出delChannelsRig方法...");
  }

  public int delChannelsRig(ChannelsRightDAO paramChannelsRightDAO)
    throws SaasApplicationException
  {
    ChannelsRightExt localChannelsRightExt = new ChannelsRightExt();
    localChannelsRightExt.setParam(":VCUST_ID", paramChannelsRightDAO.getCust_id());
    localChannelsRightExt.setParam(":VRIGHT_ID", paramChannelsRightDAO.getRight_id());
    this.tradeQuery.executeBy(localChannelsRightExt.insBy("DEL_RIG_BY_ALL"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.channelsRightMgr.ChannelsRightInfo
 * JD-Core Version:    0.6.0
 */