package com.saas.biz.dealerAddAreaMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.dealerAddDAO.DealerAddDAO;
import com.saas.biz.dao.dealerAddDAO.DealerExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DealerAddAreaList
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr commen = new commMethodMgr();
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

  public void dealeraddAreaInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入dealeraddAreaInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("CHANNELS_ID");
    String str4 = paramBuffers.getString("CHANNLES_NAME");
    String str5 = paramBuffers.getString("CHANNELS_ID_GRP");
    String str6 = paramBuffers.getString("CHANNELS_NAME_GRP");
    String str7 = paramBuffers.getString("SESSION_USER_ID");
    String str8 = "";
    try
    {
      DealerAddDAO localDealerAddDAO = new DealerAddDAO();
      localDealerAddDAO.setCust_id(str1);
      localDealerAddDAO.setChannels_type(str2);
      localDealerAddDAO.setChannels_id(str3);
      localDealerAddDAO.setChannels_name(str4);
      localDealerAddDAO.setChannels_id_grp(str5);
      localDealerAddDAO.setChannels_name_grp(str6);
      localDealerAddDAO.setOper_user_id(str7);
      localDealerAddDAO.setRemark(str8);
      i = dealeraddAreaInfo(localDealerAddDAO);
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
    this.log.LOG_INFO("退出dealeraddAreaInfo方法...");
  }

  public int dealeraddAreaInfo(DealerAddDAO paramDealerAddDAO)
    throws SaasApplicationException
  {
    String str1 = paramDealerAddDAO.getChannels_id_grp();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      DealerExt localDealerExt = new DealerExt();
      localDealerExt.setParam(":VCUST_ID", paramDealerAddDAO.getCust_id());
      localDealerExt.setParam(":VCHANNELS_TYPE", paramDealerAddDAO.getChannels_type());
      localDealerExt.setParam(":VCH_CUST_ID", str2);
      localDealerExt.setParam(":VCHANNELS_ID", paramDealerAddDAO.getChannels_id());
      localDealerExt.setParam(":VCHANNELS_NAME", paramDealerAddDAO.getChannels_name());
      localDealerExt.setParam(":VCHANNELS_ID_GRP", "");
      localDealerExt.setParam(":VCHANNELS_NAME_GRP", "");
      localDealerExt.setParam(":VOPER_USER_ID", paramDealerAddDAO.getOper_user_id());
      localDealerExt.setParam(":VREMARK", paramDealerAddDAO.getRemark());
      this.tradeQuery.executeBy(localDealerExt.insBy("DEALER_INS_BY_AREA"));
    }
    return 0;
  }

  public void deldealerAreaInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deldealerAreaInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("CHANNELS_ID");
    String str4 = paramBuffers.getString("CHANNLES_NAME");
    String str5 = paramBuffers.getString("CHANNELS_ID_GRP");
    String str6 = paramBuffers.getString("CHANNELS_NAME_GRP");
    String str7 = paramBuffers.getString("SESSION_USER_ID");
    String str8 = "";
    try
    {
      DealerAddDAO localDealerAddDAO = new DealerAddDAO();
      localDealerAddDAO.setCust_id(str1);
      localDealerAddDAO.setChannels_type(str2);
      localDealerAddDAO.setChannels_id(str3);
      localDealerAddDAO.setChannels_name(str4);
      localDealerAddDAO.setChannels_id_grp(str5);
      localDealerAddDAO.setChannels_name_grp(str6);
      localDealerAddDAO.setOper_user_id(str7);
      localDealerAddDAO.setRemark(str8);
      i = deldealerAreaInfo(localDealerAddDAO);
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
    this.log.LOG_INFO("退出dealeraddAreaInfo方法...");
  }

  public int deldealerAreaInfo(DealerAddDAO paramDealerAddDAO)
    throws SaasApplicationException
  {
    String str1 = paramDealerAddDAO.getChannels_id_grp();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      DealerExt localDealerExt = new DealerExt();
      localDealerExt.setParam(":VCUST_ID", paramDealerAddDAO.getCust_id());
      localDealerExt.setParam(":VCHANNELS_TYPE", paramDealerAddDAO.getChannels_type());
      localDealerExt.setParam(":VCH_CUST_ID", str2);
      localDealerExt.setParam(":VCHANNELS_ID", paramDealerAddDAO.getChannels_id());
      localDealerExt.setParam(":VCHANNELS_NAME", paramDealerAddDAO.getChannels_name());
      localDealerExt.setParam(":VCHANNELS_ID_GRP", "");
      localDealerExt.setParam(":VCHANNELS_NAME_GRP", "");
      localDealerExt.setParam(":VOPER_USER_ID", paramDealerAddDAO.getOper_user_id());
      localDealerExt.setParam(":VREMARK", paramDealerAddDAO.getRemark());
      this.tradeQuery.executeBy(localDealerExt.insBy("DEL_DEALER_BY_AREA"));
    }
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dealerAddAreaMgr.DealerAddAreaList
 * JD-Core Version:    0.6.0
 */