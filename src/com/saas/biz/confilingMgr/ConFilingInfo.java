package com.saas.biz.confilingMgr;

import com.saas.biz.dao.confilingDAO.ConFilingDAO;
import com.saas.biz.dao.confilingDAO.ConFilingExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ConFilingInfo
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

  public int getFilingNoMaxValue(String paramString)
  {
    int i = 0;
    ConFilingExt localConFilingExt = new ConFilingExt();
    ArrayList localArrayList = new ArrayList();
    localConFilingExt.setParam(":VCUST_ID", paramString);
    localArrayList = localConFilingExt.selByList("SEL_FILING_NO_MAX_VALUE");
    HashMap localHashMap = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ct") != null)
        i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public void addConFilingInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addConFilingInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = paramBuffers.getString("FILING_ID");
    int j = getFilingNoMaxValue(str1) + 1;
    String str4 = String.valueOf(j);
    String str5 = paramBuffers.getString("FILE_NAME");
    String str6 = paramBuffers.getString("FILE_DESC");
    String str7 = paramBuffers.getString("MEDIA");
    String str8 = paramBuffers.getString("OPER_DATE");
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("REMARK");
    try
    {
      ConFilingDAO localConFilingDAO = new ConFilingDAO();
      localConFilingDAO.setCust_id(str1);
      localConFilingDAO.setCon_id(str2);
      localConFilingDAO.setFiling_id(str3);
      localConFilingDAO.setFiling_no(str4);
      localConFilingDAO.setFile_name(str5);
      localConFilingDAO.setFile_desc(str6);
      localConFilingDAO.setMedia(str7);
      localConFilingDAO.setOper_date(str8);
      localConFilingDAO.setUser_id(str9);
      localConFilingDAO.setRemark(str10);
      i = addConFilingInfo(localConFilingDAO);
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
    this.log.LOG_INFO("退出addConFilingInfo方法...");
  }

  public int addConFilingInfo(ConFilingDAO paramConFilingDAO)
    throws SaasApplicationException
  {
    ConFilingExt localConFilingExt = new ConFilingExt();
    localConFilingExt.setParam(":VCUST_ID", paramConFilingDAO.getCust_id());
    localConFilingExt.setParam(":VCON_ID", paramConFilingDAO.getCon_id());
    localConFilingExt.setParam(":VFILING_ID", paramConFilingDAO.getFiling_id());
    localConFilingExt.setParam(":VFILING_NO", paramConFilingDAO.getFiling_no());
    localConFilingExt.setParam(":VFILE_NAME", paramConFilingDAO.getFile_name());
    localConFilingExt.setParam(":VFILE_DESC", paramConFilingDAO.getFile_desc());
    localConFilingExt.setParam(":VMEDIA", paramConFilingDAO.getMedia());
    localConFilingExt.setParam(":VOPER_DATE", paramConFilingDAO.getOper_date());
    localConFilingExt.setParam(":VUSER_ID", paramConFilingDAO.getUser_id());
    localConFilingExt.setParam(":VREMARK", paramConFilingDAO.getRemark());
    this.tradeQuery.executeBy(localConFilingExt.insBy("INS_BY_CON_FILING"));
    return 0;
  }

  public ArrayList getConFilingList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ConFilingExt localConFilingExt = new ConFilingExt();
    localConFilingExt.setParam(":VCUST_ID", paramString1);
    localConFilingExt.setParam(":VCON_ID", paramString2);
    ArrayList localArrayList = localConFilingExt.selByList("SEL_BY_CON_LIST", paramInt, 20);
    return localArrayList;
  }

  public int getConFilingList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ConFilingExt localConFilingExt = new ConFilingExt();
    localConFilingExt.setParam(":VCUST_ID", paramString1);
    localConFilingExt.setParam(":VCON_ID", paramString2);
    ArrayList localArrayList = localConFilingExt.selByList("SEL_BY_CON_LIST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void ModiConFilingInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入ModiConFilingInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = paramBuffers.getString("FILING_ID");
    String str4 = paramBuffers.getString("FILING_NO");
    String str5 = paramBuffers.getString("FILE_NAME");
    String str6 = paramBuffers.getString("FILE_DESC");
    String str7 = paramBuffers.getString("MEDIA");
    String str8 = paramBuffers.getString("OPER_DATE");
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("REMARK");
    try
    {
      ConFilingDAO localConFilingDAO = new ConFilingDAO();
      localConFilingDAO.setCust_id(str1);
      localConFilingDAO.setCon_id(str2);
      localConFilingDAO.setFiling_id(str3);
      localConFilingDAO.setFiling_no(str4);
      localConFilingDAO.setFile_name(str5);
      localConFilingDAO.setFile_desc(str6);
      localConFilingDAO.setMedia(str7);
      localConFilingDAO.setOper_date(str8);
      localConFilingDAO.setUser_id(str9);
      localConFilingDAO.setRemark(str10);
      i = ModiConFilingInfo(localConFilingDAO);
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
    this.log.LOG_INFO("退出ModiConFilingInfo方法...");
  }

  public int ModiConFilingInfo(ConFilingDAO paramConFilingDAO)
    throws SaasApplicationException
  {
    ConFilingExt localConFilingExt = new ConFilingExt();
    localConFilingExt.setParam(":VCUST_ID", paramConFilingDAO.getCust_id());
    localConFilingExt.setParam(":VCON_ID", paramConFilingDAO.getCon_id());
    localConFilingExt.setParam(":VFILING_ID", paramConFilingDAO.getFiling_id());
    localConFilingExt.setParam(":VFILING_NO", paramConFilingDAO.getFiling_no());
    localConFilingExt.setParam(":VFILE_NAME", paramConFilingDAO.getFile_name());
    localConFilingExt.setParam(":VFILE_DESC", paramConFilingDAO.getFile_desc());
    localConFilingExt.setParam(":VMEDIA", paramConFilingDAO.getMedia());
    localConFilingExt.setParam(":VOPER_DATE", paramConFilingDAO.getOper_date());
    localConFilingExt.setParam(":VUSER_ID", paramConFilingDAO.getUser_id());
    localConFilingExt.setParam(":VREMARK", paramConFilingDAO.getRemark());
    this.tradeQuery.executeBy(localConFilingExt.insBy("UP_BY_CON_FILING"));
    return 0;
  }

  public ArrayList getListByTradeId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ConFilingExt localConFilingExt = new ConFilingExt();
    localConFilingExt.setParam(":VCUST_ID", paramString1);
    localConFilingExt.setParam(":VTRADE_ID", paramString2);
    ArrayList localArrayList = localConFilingExt.selByList("SEL_BY_TRADE_ID");
    return localArrayList;
  }

  public ArrayList getValueById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ConFilingExt localConFilingExt = new ConFilingExt();
    localConFilingExt.setParam(":VCUST_ID", paramString);
    localArrayList = localConFilingExt.selByList("SEL_BY_KKK");
    return localArrayList;
  }

  public ArrayList getOneValue(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ConFilingExt localConFilingExt = new ConFilingExt();
    localConFilingExt.setParam(":VCUST_ID", paramString1);
    localConFilingExt.setParam(":VCON_ID", paramString2);
    localConFilingExt.setParam(":VFILING_NO", paramString3);
    localArrayList = localConFilingExt.selByList("SEL_BY_CON_LISTING");
    return localArrayList;
  }

  public void DelConFilingInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DelConFilingInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    try
    {
      ConFilingDAO localConFilingDAO = new ConFilingDAO();
      localConFilingDAO.setCust_id(str1);
      localConFilingDAO.setCon_id(str2);
      i = DelConFilingInfo(localConFilingDAO);
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
    this.log.LOG_INFO("退出DelConFilingInfo方法...");
  }

  public int DelConFilingInfo(ConFilingDAO paramConFilingDAO)
    throws SaasApplicationException
  {
    ConFilingExt localConFilingExt = new ConFilingExt();
    localConFilingExt.setParam(":VCUST_ID", paramConFilingDAO.getCust_id());
    localConFilingExt.setParam(":VCON_ID", paramConFilingDAO.getCon_id());
    this.tradeQuery.executeBy(localConFilingExt.insBy("DEL_BY_CON_FILING"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.confilingMgr.ConFilingInfo
 * JD-Core Version:    0.6.0
 */