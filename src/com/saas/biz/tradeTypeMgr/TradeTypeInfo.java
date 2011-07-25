package com.saas.biz.tradeTypeMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.bpm.TradeTypeExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class TradeTypeInfo
{
  Logger log = new Logger(this);
  commMethodMgr commen = new commMethodMgr();
  ArrayList queryResult = new ArrayList();
  Buffers inBuffer;
  Buffers outBuffer;
  Dbtable tradeQuery = new Dbtable();

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void delTradeTypeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delTradeTypeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("TRADE_TYPE_CODE1");
    try
    {
      i = delTradeTypeInfo(str);
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
    this.log.LOG_INFO("退出delTradeTypeInfo方法...");
  }

  public int delTradeTypeInfo(String paramString)
    throws SaasApplicationException
  {
    TradeTypeExt localTradeTypeExt = new TradeTypeExt();
    localTradeTypeExt.setParam(":VTRADE_TYPE_CODE", paramString);
    this.tradeQuery.executeBy(localTradeTypeExt.insBy("DEL_TRADETYPE_BY_TRADE_TYPE_CODE"));
    return 0;
  }

  public void addTradeTypeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addTradeTypeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_TYPE_CODE2");
    String str2 = paramBuffers.getString("TRADE_NAME");
    String str3 = paramBuffers.getString("BPM_ID");
    String str4 = paramBuffers.getString("JUDGE_RIGHTS");
    String str5 = paramBuffers.getString("TRADE_KIND");
    String str6 = paramBuffers.getString("CANCEL_TAG");
    String str7 = paramBuffers.getString("TRANSE_TYPE");
    String str8 = paramBuffers.getString("ENABLE_TAG");
    String str9 = paramBuffers.getString("SUCCEED_FWD");
    String str10 = paramBuffers.getString("ERROR_FWD");
    String str11 = paramBuffers.getString("START_DATE");
    String str12 = paramBuffers.getString("END_DATE");
    String str13 = paramBuffers.getString("RSRV_STR1_A");
    String str14 = paramBuffers.getString("RSRV_STR2_A");
    String str15 = paramBuffers.getString("RSRV_STR3_A");
    String str16 = paramBuffers.getString("RSRV_STR4_A");
    String str17 = paramBuffers.getString("RSRV_STR5_A");
    String str18 = paramBuffers.getString("RSRV_STR6_A");
    String str19 = paramBuffers.getString("RSRV_STR7_A");
    String str20 = paramBuffers.getString("RSRV_STR8_A");
    String str21 = paramBuffers.getString("RSRV_STR9_A");
    String str22 = paramBuffers.getString("RSRV_STR0_A");
    String str23 = paramBuffers.getString("REMARK_A");
    try
    {
      i = addTradeTypeInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23);
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
    this.log.LOG_INFO("退出addTradeTypeInfo方法...");
  }

  public int addTradeTypeInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23)
    throws SaasApplicationException
  {
    TradeTypeExt localTradeTypeExt = new TradeTypeExt();
    localTradeTypeExt.setParam(":VTRADE_TYPE_CODE", paramString1);
    localTradeTypeExt.setParam(":VTRADE_NAME", paramString2);
    localTradeTypeExt.setParam(":VBPM_ID", paramString3);
    localTradeTypeExt.setParam(":VJUDGE_RIGHTS", paramString4);
    localTradeTypeExt.setParam(":VTRADE_KIND", paramString5);
    localTradeTypeExt.setParam(":VCANCEL_TAG", paramString6);
    localTradeTypeExt.setParam(":VTRANSE_TYPE", paramString7);
    localTradeTypeExt.setParam(":VENABLE_TAG", paramString8);
    localTradeTypeExt.setParam(":VSUCCEED_FWD", paramString9);
    localTradeTypeExt.setParam(":VERROR_FWD", paramString10);
    localTradeTypeExt.setParam(":VSTART_DATE", paramString11);
    localTradeTypeExt.setParam(":VEND_DATE", paramString12);
    localTradeTypeExt.setParam(":VRSRV_STR1", paramString13);
    localTradeTypeExt.setParam(":VRSRV_STR2", paramString14);
    localTradeTypeExt.setParam(":VRSRV_STR3", paramString15);
    localTradeTypeExt.setParam(":VRSRV_STR4", paramString16);
    localTradeTypeExt.setParam(":VRSRV_STR5", paramString17);
    localTradeTypeExt.setParam(":VRSRV_STR6", paramString18);
    localTradeTypeExt.setParam(":VRSRV_STR7", paramString19);
    localTradeTypeExt.setParam(":VRSRV_STR8", paramString20);
    localTradeTypeExt.setParam(":VRSRV_STR9", paramString21);
    localTradeTypeExt.setParam(":VRSRV_STR0", paramString22);
    localTradeTypeExt.setParam(":VREMARK", paramString23);
    ArrayList localArrayList = new ArrayList();
    localArrayList = getOneTradeType(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      this.tradeQuery.executeBy(localTradeTypeExt.insBy("UPDATE_TRADETYPE_INFO"));
    else
      this.tradeQuery.executeBy(localTradeTypeExt.insBy("INS_TRADETYPE_INFO"));
    return 0;
  }

  public ArrayList getOneTradeType(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TradeTypeExt localTradeTypeExt = new TradeTypeExt();
    localTradeTypeExt.setParam(":VTRADETYPECODE", paramString);
    localArrayList = localTradeTypeExt.selByList("SEL_BY_PK");
    return localArrayList;
  }

  public void updateTradeTypeInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addTradeTypeInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_TYPE_CODE2");
    String str2 = paramBuffers.getString("TRADE_NAME");
    String str3 = paramBuffers.getString("BPM_ID");
    String str4 = paramBuffers.getString("JUDGE_RIGHTS");
    String str5 = paramBuffers.getString("TRADE_KIND");
    String str6 = paramBuffers.getString("CANCEL_TAG");
    String str7 = paramBuffers.getString("TRANSE_TYPE");
    String str8 = paramBuffers.getString("ENABLE_TAG");
    String str9 = paramBuffers.getString("SUCCEED_FWD");
    String str10 = paramBuffers.getString("ERROR_FWD");
    String str11 = paramBuffers.getString("START_DATE");
    String str12 = paramBuffers.getString("END_DATE");
    String str13 = paramBuffers.getString("RSRV_STR1_A");
    String str14 = paramBuffers.getString("RSRV_STR2_A");
    String str15 = paramBuffers.getString("RSRV_STR3_A");
    String str16 = paramBuffers.getString("RSRV_STR4_A");
    String str17 = paramBuffers.getString("RSRV_STR5_A");
    String str18 = paramBuffers.getString("RSRV_STR6_A");
    String str19 = paramBuffers.getString("RSRV_STR7_A");
    String str20 = paramBuffers.getString("RSRV_STR8_A");
    String str21 = paramBuffers.getString("RSRV_STR9_A");
    String str22 = paramBuffers.getString("RSRV_STR0_A");
    String str23 = paramBuffers.getString("REMARK_A");
    try
    {
      i = updateTradeTypeInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23);
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
    this.log.LOG_INFO("退出addTradeTypeInfo方法...");
  }

  public int updateTradeTypeInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23)
    throws SaasApplicationException
  {
    TradeTypeExt localTradeTypeExt = new TradeTypeExt();
    localTradeTypeExt.setParam(":VTRADE_TYPE_CODE", paramString1);
    localTradeTypeExt.setParam(":VTRADE_NAME", paramString2);
    localTradeTypeExt.setParam(":VBPM_ID", paramString3);
    localTradeTypeExt.setParam(":VJUDGE_RIGHTS", paramString4);
    localTradeTypeExt.setParam(":VTRADE_KIND", paramString5);
    localTradeTypeExt.setParam(":VCANCEL_TAG", paramString6);
    localTradeTypeExt.setParam(":VTRANSE_TYPE", paramString7);
    localTradeTypeExt.setParam(":VENABLE_TAG", paramString8);
    localTradeTypeExt.setParam(":VSUCCEED_FWD", paramString9);
    localTradeTypeExt.setParam(":VERROR_FWD", paramString10);
    localTradeTypeExt.setParam(":VSTART_DATE", paramString11);
    localTradeTypeExt.setParam(":VEND_DATE", paramString12);
    localTradeTypeExt.setParam(":VRSRV_STR1", paramString13);
    localTradeTypeExt.setParam(":VRSRV_STR2", paramString14);
    localTradeTypeExt.setParam(":VRSRV_STR3", paramString15);
    localTradeTypeExt.setParam(":VRSRV_STR4", paramString16);
    localTradeTypeExt.setParam(":VRSRV_STR5", paramString17);
    localTradeTypeExt.setParam(":VRSRV_STR6", paramString18);
    localTradeTypeExt.setParam(":VRSRV_STR7", paramString19);
    localTradeTypeExt.setParam(":VRSRV_STR8", paramString20);
    localTradeTypeExt.setParam(":VRSRV_STR9", paramString21);
    localTradeTypeExt.setParam(":VRSRV_STR0", paramString22);
    localTradeTypeExt.setParam(":VREMARK", paramString23);
    ArrayList localArrayList = new ArrayList();
    localArrayList = getOneTradeType(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      this.tradeQuery.executeBy(localTradeTypeExt.insBy("UPDATE_TRADETYPE_INFO"));
    else
      this.tradeQuery.executeBy(localTradeTypeExt.insBy("INS_TRADETYPE_INFO"));
    return 0;
  }

  public String getOneTradeName(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TradeTypeExt localTradeTypeExt = new TradeTypeExt();
    localTradeTypeExt.setParam(":VTRADETYPECODE", paramString);
    localArrayList = localTradeTypeExt.selByList("SEL_BY_PK");
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("trade_name") != null)
        str = localHashMap.get("trade_name").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.tradeTypeMgr.TradeTypeInfo
 * JD-Core Version:    0.6.0
 */