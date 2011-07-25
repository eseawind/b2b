package com.saas.biz.prePriceMgr;

import com.saas.biz.dao.prePriceDAO.PrePriceExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class PrePriceInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();

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

  public void addPrePriceInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addPrePriceInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUO_ID");
    String str3 = paramBuffers.getString("PRE_ID");
    String str4 = paramBuffers.getString("PRE_FEE");
    String str5 = paramBuffers.getString("CURRENCY_CODE");
    String str6 = paramBuffers.getString("PAY_TYPE");
    String str7 = paramBuffers.getString("TAX");
    String str8 = paramBuffers.getString("REMAIN_FEE");
    String str9 = paramBuffers.getString("START_DATE");
    String str10 = paramBuffers.getString("END_DATE");
    String str11 = paramBuffers.getString("BILL_NO");
    String str12 = paramBuffers.getString("PRE_USER_ID");
    String str13 = paramBuffers.getString("PRE_USER_NAME");
    String str14 = paramBuffers.getString("SESSION_USER_ID");
    String str15 = paramBuffers.getString("IN_DATE");
    String str16 = paramBuffers.getString("REMARK2");
    try
    {
      i = addPrePriceInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
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
    this.log.LOG_INFO("退出addPrePriceInfo方法...");
  }

  public int addPrePriceInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16)
    throws SaasApplicationException
  {
    PrePriceExt localPrePriceExt = new PrePriceExt();
    localPrePriceExt.setParam(":VCUST_ID", paramString1);
    localPrePriceExt.setParam(":VQUO_ID", paramString2);
    localPrePriceExt.setParam(":VPRE_ID", paramString3);
    localPrePriceExt.setParam(":VPRE_FEE", paramString4);
    localPrePriceExt.setParam(":VCURRENCY_CODE", paramString5);
    localPrePriceExt.setParam(":VPAY_TYPE", paramString6);
    localPrePriceExt.setParam(":VTAX", paramString7);
    localPrePriceExt.setParam(":VREMAIN_FEE", paramString8);
    localPrePriceExt.setParam(":VSTART_DATE", paramString9);
    localPrePriceExt.setParam(":VEND_DATE", paramString10);
    localPrePriceExt.setParam(":VBILL_NO", paramString11);
    localPrePriceExt.setParam(":VPRE_USER_ID", paramString12);
    localPrePriceExt.setParam(":VPRE_USER_NAME", paramString13);
    localPrePriceExt.setParam(":VOPER_USER_ID", paramString14);
    localPrePriceExt.setParam(":VIN_DATE", paramString15);
    localPrePriceExt.setParam(":VREMARK2", paramString16);
    this.tradeQuery.executeBy(localPrePriceExt.insBy("INS_ONE_PREPRICE"));
    return 0;
  }

  public void updatePrePrice(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updatePrePrice方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUO_ID");
    String str3 = paramBuffers.getString("PRE_ID");
    String str4 = paramBuffers.getString("PRE_FEE");
    String str5 = paramBuffers.getString("CURRENCY_CODE");
    String str6 = paramBuffers.getString("PAY_TYPE");
    String str7 = paramBuffers.getString("TAX");
    String str8 = paramBuffers.getString("REMAIN_FEE");
    String str9 = paramBuffers.getString("START_DATE");
    String str10 = paramBuffers.getString("END_DATE");
    String str11 = paramBuffers.getString("BILL_NO");
    String str12 = paramBuffers.getString("PRE_USER_ID");
    String str13 = paramBuffers.getString("PRE_USER_NAME");
    String str14 = paramBuffers.getString("SESSION_USER_ID");
    String str15 = paramBuffers.getString("IN_DATE");
    String str16 = paramBuffers.getString("REMARK2");
    try
    {
      i = updatePrePrice(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
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
    this.log.LOG_INFO("退出updatePrePrice方法...");
  }

  public int updatePrePrice(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16)
    throws SaasApplicationException
  {
    PrePriceExt localPrePriceExt = new PrePriceExt();
    localPrePriceExt.setParam(":VCUST_ID", paramString1);
    localPrePriceExt.setParam(":VQUO_ID", paramString2);
    localPrePriceExt.setParam(":VPRE_ID", paramString3);
    localPrePriceExt.setParam(":VPRE_FEE", paramString4);
    localPrePriceExt.setParam(":VCURRENCY_CODE", paramString5);
    localPrePriceExt.setParam(":VPAY_TYPE", paramString6);
    localPrePriceExt.setParam(":VTAX", paramString7);
    localPrePriceExt.setParam(":VREMAIN_FEE", paramString8);
    localPrePriceExt.setParam(":VSTART_DATE", paramString9);
    localPrePriceExt.setParam(":VEND_DATE", paramString10);
    localPrePriceExt.setParam(":VBILL_NO", paramString11);
    localPrePriceExt.setParam(":VPRE_USER_ID", paramString12);
    localPrePriceExt.setParam(":VPRE_USER_NAME", paramString13);
    localPrePriceExt.setParam(":VOPER_USER_ID", paramString14);
    localPrePriceExt.setParam(":VIN_DATE", paramString15);
    localPrePriceExt.setParam(":VREMARK2", paramString16);
    this.tradeQuery.executeBy(localPrePriceExt.insBy("UPDATE_ONE_PREPRICE"));
    return 0;
  }

  public void delPrePrice(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delPrePrice方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUO_ID");
    String str3 = paramBuffers.getString("PRE_ID");
    try
    {
      i = delPrePrice(str1, str2, str3);
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
    this.log.LOG_INFO("退出delPrePrice方法...");
  }

  public int delPrePrice(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    PrePriceExt localPrePriceExt = new PrePriceExt();
    localPrePriceExt.setParam(":VCUST_ID", paramString1);
    localPrePriceExt.setParam(":VQUO_ID", paramString2);
    localPrePriceExt.setParam(":VPRE_ID", paramString3);
    this.tradeQuery.executeBy(localPrePriceExt.insBy("DEL_ONE_PREPRICE"));
    return 0;
  }

  public ArrayList getAllPrePriceByState(String paramString1, String paramString2, int paramInt, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    PrePriceExt localPrePriceExt = new PrePriceExt();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      localPrePriceExt.setParam(":VCUST_ID", paramString1);
      localPrePriceExt.setParam(":VQUO_ID", paramString3);
      localPrePriceExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localPrePriceExt.selByList("SEL_ALL_PREPRICE", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getAllPrePriceByState(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    PrePriceExt localPrePriceExt = new PrePriceExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localPrePriceExt.setParam(":VCUST_ID", paramString1);
      localPrePriceExt.setParam(":VQUO_ID", paramString3);
      localPrePriceExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localPrePriceExt.selByList("SEL_ALL_PREPRICE");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getOnePrePrice(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    PrePriceExt localPrePriceExt = new PrePriceExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localPrePriceExt.setParam(":VCUST_ID", paramString1);
      localPrePriceExt.setParam(":VSTATE_CODE", paramString2);
      localPrePriceExt.setParam(":VPRE_ID", paramString3);
      localArrayList = localPrePriceExt.selByList("SEL_ONE_PREPRICE");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.prePriceMgr.PrePriceInfo
 * JD-Core Version:    0.6.0
 */