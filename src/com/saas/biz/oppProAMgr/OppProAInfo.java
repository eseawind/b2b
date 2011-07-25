package com.saas.biz.oppProAMgr;

import com.saas.biz.dao.oppProADAO.OppProAExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class OppProAInfo
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

  public void addOppProAInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addOppProAInfo方法...");
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("PROJ_ID");
    String str3 = paramBuffers.getString("ITEM_ID");
    String str4 = paramBuffers.getString("OPP_CUST_ID");
    String str5 = paramBuffers.getString("TITLE");
    String str6 = paramBuffers.getString("CONTENT");
    String str7 = paramBuffers.getString("SCORE");
    String str8 = paramBuffers.getString("LEVEL");
    String str9 = paramBuffers.getString("REMARK");
    int i = -1;
    try
    {
      i = addOppProAInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9);
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
    this.log.LOG_INFO("退出addOppProAInfo方法...");
  }

  public int addOppProAInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    localOppProAExt.setParam(":VCUST_ID", paramString1);
    localOppProAExt.setParam(":VPROJ_ID", paramString2);
    localOppProAExt.setParam(":VITEM_ID", paramString3);
    localOppProAExt.setParam(":VOPP_CUST_ID", paramString4);
    localOppProAExt.setParam(":VTITLE", paramString5);
    localOppProAExt.setParam(":VCONTENT", paramString6);
    localOppProAExt.setParam(":VSCORE", paramString7);
    localOppProAExt.setParam(":VLEVEL", paramString8);
    localOppProAExt.setParam(":VREMARK", paramString9);
    this.tradeQuery.executeBy(localOppProAExt.insBy("INS_OPP_PRO_A"));
    return 0;
  }

  public void updateOppProA(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateOppProA方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ITEM_ID");
    String str3 = paramBuffers.getString("OPP_CUST_ID");
    String str4 = paramBuffers.getString("TITLE");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("SCORE");
    String str7 = paramBuffers.getString("LEVEL");
    String str8 = paramBuffers.getString("REMARK");
    int i = -1;
    try
    {
      i = updateOppProA(str1, str2, str3, str4, str5, str6, str7, str8);
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
    this.log.LOG_INFO("退出updateOppProA方法...");
  }

  public int updateOppProA(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    localOppProAExt.setParam(":VCUST_ID", paramString1);
    localOppProAExt.setParam(":VITEM_ID", paramString2);
    localOppProAExt.setParam(":VOPP_CUST_ID", paramString3);
    localOppProAExt.setParam(":VTITLE", paramString4);
    localOppProAExt.setParam(":VCONTENT", paramString5);
    localOppProAExt.setParam(":VSCORE", paramString6);
    localOppProAExt.setParam(":VLEVEL", paramString7);
    localOppProAExt.setParam(":VREMARK", paramString8);
    this.tradeQuery.executeBy(localOppProAExt.insBy("UPDATE_OPP_PROA"));
    return 0;
  }

  public ArrayList getOppProList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      localOppProAExt.setParam(":VCUST_ID", paramString2);
      localOppProAExt.setParam(":VPROJ_ID", paramString1);
      localArrayList = localOppProAExt.selByList("SEL_OPPPROA_BY_PROJ_ID", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public ArrayList getOppProAByItemId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localOppProAExt.setParam(":VCUST_ID", paramString2);
      localOppProAExt.setParam(":VITEM_ID", paramString1);
      localArrayList = localOppProAExt.selByList("SEL_OPP_PROA_BY_ITEM_ID");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public void delOppProA(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delOppProA方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_CUST_ID");
      String str2 = paramBuffers.getString("ITEM_ID");
      i = delOppPro(str1, str2);
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
    this.log.LOG_INFO("退出delOppProA方法...");
  }

  public int delOppPro(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    localOppProAExt.setParam(":VCUST_ID", paramString1);
    localOppProAExt.setParam(":VITEM_ID", paramString2);
    this.tradeQuery.executeBy(localOppProAExt.insBy("DEL_BY_OPP_PRO_A"));
    return 0;
  }

  public ArrayList getOppProAList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      localOppProAExt.setParam(":VCUST_ID", paramString1);
      localOppProAExt.setParam(":VPROJ_ID", paramString2);
      localArrayList = localOppProAExt.selByList("SEL_OPPA_BY_PROJ_ID", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getOppProAList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localOppProAExt.setParam(":VCUST_ID", paramString1);
      localOppProAExt.setParam(":VPROJ_ID", paramString2);
      localArrayList = localOppProAExt.selByList("SEL_OPPA_BY_PROJ_ID");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getOppList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    this.log.LOG_INFO("=========" + paramInt);
    this.log.LOG_INFO("=========" + paramString1);
    this.log.LOG_INFO("=========" + paramString2);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 3;
      localOppProAExt.setParam(":VCUST_ID", paramString1);
      localOppProAExt.setParam(":VPROJ_ID", paramString2);
      localArrayList = localOppProAExt.selByList("SEL_OPP_LIST_PAGE", paramInt, 4);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getOppList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localOppProAExt.setParam(":VCUST_ID", paramString1);
      localOppProAExt.setParam(":VPROJ_ID", paramString2);
      localArrayList = localOppProAExt.selByList("SEL_OPP_LIST_PAGE");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getOppTitleList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localOppProAExt.setParam(":VCUST_ID", paramString1);
      localOppProAExt.setParam(":VOPP_CUST_ID", paramString2);
      localArrayList = localOppProAExt.selByList("SEL_OPP_TITLE");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public ArrayList getProAByItemIdList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    OppProAExt localOppProAExt = new OppProAExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localOppProAExt.setParam(":VCUST_ID", paramString1);
      localOppProAExt.setParam(":VITEM_ID", paramString2);
      localArrayList = localOppProAExt.selByList("SEL_OPP_BY_ITEM_ID");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.oppProAMgr.OppProAInfo
 * JD-Core Version:    0.6.0
 */