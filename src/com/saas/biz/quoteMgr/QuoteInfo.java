package com.saas.biz.quoteMgr;

import com.saas.biz.dao.quoteDAO.QuoteExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class QuoteInfo
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

  public void addQuoteInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addQuoteInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("PREP_ID");
    String str4 = paramBuffers.getString("QUERY_ID");
    String str5 = paramBuffers.getString("PREP_NAME");
    String str6 = paramBuffers.getString("OBJ_CUST_ID");
    String str7 = paramBuffers.getString("OBJ_CUST_NAME");
    String str8 = paramBuffers.getString("PREP_OBJ_ID");
    String str9 = paramBuffers.getString("CONTACT_MAN");
    String str10 = paramBuffers.getString("CONTACT");
    String str11 = paramBuffers.getString("GIVE_DATE");
    String str12 = paramBuffers.getString("GIVE_ADDR");
    String str13 = paramBuffers.getString("SHIP_TYPE");
    String str14 = paramBuffers.getString("CURRENCY_CODE");
    String str15 = paramBuffers.getString("OFF_COUNT");
    String str16 = paramBuffers.getString("OFF_RATE");
    String str17 = paramBuffers.getString("SHIP_FEE");
    String str18 = paramBuffers.getString("TAX");
    String str19 = paramBuffers.getString("ALL_FEE");
    String str20 = paramBuffers.getString("PREP_COUNT");
    String str21 = paramBuffers.getString("PART_DELIVERY_TAG");
    String str22 = paramBuffers.getString("SESSION_USER_ID");
    String str23 = paramBuffers.getString("IN_DATE");
    String str24 = paramBuffers.getString("REMARK2");
    int i = -1;
    try
    {
      i = addQuoteInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24);
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
    this.log.LOG_INFO("退出addProduInfo方法...");
  }

  public int addQuoteInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24)
    throws SaasApplicationException
  {
    QuoteExt localQuoteExt = new QuoteExt();
    localQuoteExt.setParam(":VCUST_ID", paramString1);
    localQuoteExt.setParam(":VFORM_ID", paramString2);
    localQuoteExt.setParam(":VPREP_ID", paramString3);
    localQuoteExt.setParam(":VQUERY_ID", paramString4);
    localQuoteExt.setParam(":VPREP_NAME", paramString5);
    localQuoteExt.setParam(":VOBJ_CUST_ID", paramString6);
    localQuoteExt.setParam(":VOBJ_CUST_NAME", paramString7);
    localQuoteExt.setParam(":VPREP_OBJ_ID", paramString8);
    localQuoteExt.setParam(":VCONTACT_MAN", paramString9);
    localQuoteExt.setParam(":VCONTACT", paramString10);
    localQuoteExt.setParam(":VGIVE_DATE", paramString11);
    localQuoteExt.setParam(":VGIVE_ADDR", paramString12);
    localQuoteExt.setParam(":VSHIP_TYPE", paramString13);
    localQuoteExt.setParam(":VCURRENCY_CODE", paramString14);
    localQuoteExt.setParam(":VOFF_COUNT", paramString15);
    localQuoteExt.setParam(":VOFF_RATE", paramString16);
    localQuoteExt.setParam(":VSHIP_FEE", paramString17);
    localQuoteExt.setParam(":VTAX", paramString18);
    localQuoteExt.setParam(":VALL_FEE", paramString19);
    localQuoteExt.setParam(":VPREP_COUNT", paramString20);
    localQuoteExt.setParam(":VPART_DELIVERY_TAG", paramString21);
    localQuoteExt.setParam(":VOPER_USER_ID", paramString22);
    localQuoteExt.setParam(":VIN_DATE", paramString23);
    localQuoteExt.setParam(":VREMARK2", paramString24);
    localQuoteExt.setParam(":VOBJ_CUST_NAME", paramString7);
    this.tradeQuery.executeBy(localQuoteExt.insBy("INS_ONE_QUOTE"));
    this.log.LOG_INFO("开始执行SQL:=================" + localQuoteExt.insBy("INS_ONE_QUOTE"));
    return 0;
  }

  public void updateQuoteInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateQuoteInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("PREP_ID");
    String str4 = paramBuffers.getString("PREP_NAME");
    String str5 = paramBuffers.getString("OBJ_CUST_ID");
    String str6 = paramBuffers.getString("PREP_OBJ_ID");
    String str7 = paramBuffers.getString("CONTACT_MAN");
    String str8 = paramBuffers.getString("CONTACT");
    String str9 = paramBuffers.getString("GIVE_DATE");
    String str10 = paramBuffers.getString("GIVE_ADDR");
    String str11 = paramBuffers.getString("SHIP_TYPE");
    String str12 = paramBuffers.getString("CURRENCY_CODE");
    String str13 = paramBuffers.getString("OFF_COUNT");
    String str14 = paramBuffers.getString("OFF_RATE");
    String str15 = paramBuffers.getString("SHIP_FEE");
    String str16 = paramBuffers.getString("TAX");
    String str17 = paramBuffers.getString("ALL_FEE");
    String str18 = paramBuffers.getString("PREP_COUNT");
    String str19 = paramBuffers.getString("PART_DELIVERY_TAG");
    String str20 = paramBuffers.getString("IN_DATE");
    String str21 = paramBuffers.getString("REMARK2");
    int i = -1;
    try
    {
      i = updateQuoteInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21);
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
    this.log.LOG_INFO("退出updateQuoteInfo方法...");
  }

  public int updateQuoteInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21)
    throws SaasApplicationException
  {
    QuoteExt localQuoteExt = new QuoteExt();
    localQuoteExt.setParam(":VCUST_ID", paramString1);
    localQuoteExt.setParam(":VFORM_ID", paramString2);
    localQuoteExt.setParam(":VPREP_ID", paramString3);
    localQuoteExt.setParam(":VPREP_NAME", paramString4);
    localQuoteExt.setParam(":VOBJ_CUST_ID", paramString5);
    localQuoteExt.setParam(":VPREP_OBJ_ID", paramString6);
    localQuoteExt.setParam(":VCONTACT_MAN", paramString7);
    localQuoteExt.setParam(":VCONTACT", paramString8);
    localQuoteExt.setParam(":VGIVE_DATE", paramString9);
    localQuoteExt.setParam(":VGIVE_ADDR", paramString10);
    localQuoteExt.setParam(":VSHIP_TYPE", paramString11);
    localQuoteExt.setParam(":VCURRENCY_CODE", paramString12);
    localQuoteExt.setParam(":VOFF_COUNT", paramString13);
    localQuoteExt.setParam(":VOFF_RATE", paramString14);
    localQuoteExt.setParam(":VSHIP_FEE", paramString15);
    localQuoteExt.setParam(":VTAX", paramString16);
    localQuoteExt.setParam(":VALL_FEE", paramString17);
    localQuoteExt.setParam(":VPREP_COUNT", paramString18);
    localQuoteExt.setParam(":VPART_DELIVERY_TAG", paramString19);
    localQuoteExt.setParam(":VIN_DATE", paramString20);
    localQuoteExt.setParam(":VREMARK2", paramString21);
    this.tradeQuery.executeBy(localQuoteExt.insBy("UPDATE_ONE_QUOTE"));
    return 0;
  }

  public void delQuoteInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delQuoteInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PREP_ID");
    int i = -1;
    try
    {
      i = delQuoteInfo(str1, str2);
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
    this.log.LOG_INFO("退出delQuoteInfo方法...");
  }

  public int delQuoteInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    QuoteExt localQuoteExt = new QuoteExt();
    localQuoteExt.setParam(":VCUST_ID", paramString1);
    localQuoteExt.setParam(":VPREP_ID", paramString2);
    this.tradeQuery.executeBy(localQuoteExt.insBy("DEL_ONE_QUOTE"));
    return 0;
  }

  public ArrayList getOneQuote(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    QuoteExt localQuoteExt = new QuoteExt();
    localQuoteExt.setParam(":VCUST_ID", paramString1);
    localQuoteExt.setParam(":VPREP_ID", paramString2);
    localQuoteExt.setParam(":VFORM_ID", paramString3);
    localArrayList = localQuoteExt.selByList("SEL_ONE_QUOTE");
    return localArrayList;
  }

  public ArrayList getQuoteList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    QuoteExt localQuoteExt = new QuoteExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      localQuoteExt.setParam(":VCUST_ID", paramString1);
      localQuoteExt.setParam(":VQUERY_ID", paramString2);
      localArrayList = localQuoteExt.selByList("SEL_ALL_QUOTE", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public ArrayList getQuoteListAll(int paramInt, String paramString)
    throws SaasApplicationException
  {
    QuoteExt localQuoteExt = new QuoteExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      localQuoteExt.setParam(":VCUST_ID", paramString);
      localArrayList = localQuoteExt.selByList("SEL_ALL_QUOTE1", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getQuoteList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    QuoteExt localQuoteExt = new QuoteExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localQuoteExt.setParam(":VCUST_ID", paramString1);
      localQuoteExt.setParam(":VQUERY_ID", paramString2);
      localArrayList = localQuoteExt.selByList("SEL_ALL_QUOTE1");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public int getQuoteListAll(String paramString)
    throws SaasApplicationException
  {
    QuoteExt localQuoteExt = new QuoteExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localQuoteExt.setParam(":VCUST_ID", paramString);
      localArrayList = localQuoteExt.selByList("SEL_ALL_QUOTE1");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.quoteMgr.QuoteInfo
 * JD-Core Version:    0.6.0
 */