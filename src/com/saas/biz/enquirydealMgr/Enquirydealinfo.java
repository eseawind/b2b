package com.saas.biz.enquirydealMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.enquirydealDAO.EnquirydealDAO;
import com.saas.biz.dao.enquirydealDAO.EnquirydealExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Enquirydealinfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  commMethodMgr comm = new commMethodMgr();
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

  public void addEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str1 = this.comm.GenTradeId();
    String str2 = paramBuffers.getString("ENQUIRY_ID");
    String str3 = paramBuffers.getString("CONTENT");
    String str4 = paramBuffers.getString("DEAL_TAG");
    String str5 = paramBuffers.getString("SESSION_USER_ID");
    int i = -1;
    try
    {
      EnquirydealDAO localEnquirydealDAO = new EnquirydealDAO();
      localEnquirydealDAO.setTrade_id(str1);
      localEnquirydealDAO.setEnquiry_id(str2);
      localEnquirydealDAO.setDeal_content(str3);
      localEnquirydealDAO.setDeal_tag(str4);
      localEnquirydealDAO.setDeal_user(str5);
      i = addEnquiryInfo(localEnquirydealDAO);
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
    this.log.LOG_INFO("退出addEnquiryInfo方法...");
  }

  public int addEnquiryInfo(EnquirydealDAO paramEnquirydealDAO)
    throws SaasApplicationException
  {
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    localEnquirydealExt.setParam(":VTRADE_ID", paramEnquirydealDAO.getTrade_id());
    localEnquirydealExt.setParam(":VENQUIRY_ID", paramEnquirydealDAO.getEnquiry_id());
    localEnquirydealExt.setParam(":VDEAL_CONTENT", paramEnquirydealDAO.getDeal_content());
    localEnquirydealExt.setParam(":VDEAL_TAG", paramEnquirydealDAO.getDeal_tag());
    localEnquirydealExt.setParam(":VDEAL_USER", paramEnquirydealDAO.getDeal_user());
    this.tradeQuery.executeBy(localEnquirydealExt.insBy("INS_BY_DEAL"));
    return 0;
  }

  public void delEnquiryInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delEnquiryInfo方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    int i = -1;
    try
    {
      i = delEnquiryInfo(str);
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
    this.log.LOG_INFO("退出addEnquiryInfo方法...");
  }

  public int delEnquiryInfo(String paramString)
    throws SaasApplicationException
  {
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    localEnquirydealExt.setParam(":VENQUIRY_ID", paramString);
    this.tradeQuery.executeBy(localEnquirydealExt.insBy("DELETE_BY_ENQUIRY"));
    return 0;
  }

  public void addEnquiry(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addEnquiry方法...");
    this.outBuffer = paramBuffers;
    String str1 = this.comm.GenTradeId();
    String str2 = paramBuffers.getString("ENQUIRY_ID");
    String str3 = paramBuffers.getString("DEAL_CONTENT");
    String str4 = paramBuffers.getString("DEAL_TAG");
    String str5 = paramBuffers.getString("DEAL_USER");
    int i = -1;
    try
    {
      EnquirydealDAO localEnquirydealDAO = new EnquirydealDAO();
      localEnquirydealDAO.setTrade_id(str1);
      localEnquirydealDAO.setEnquiry_id(str2);
      localEnquirydealDAO.setDeal_content(str3);
      localEnquirydealDAO.setDeal_tag(str4);
      localEnquirydealDAO.setDeal_user(str5);
      i = addEnquiry(localEnquirydealDAO);
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
    this.log.LOG_INFO("退出addEnquiry方法...");
  }

  public int addEnquiry(EnquirydealDAO paramEnquirydealDAO)
    throws SaasApplicationException
  {
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    String str = paramEnquirydealDAO.getDeal_content();
    str = str.replaceAll("&", "&amp;");
    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;");
    str = str.replaceAll(" ", "&nbsp;");
    str = str.replaceAll("'", "&#39;");
    str = str.replaceAll("\"", "&quot;");
    str = str.replaceAll("\n", "<br>");
    localEnquirydealExt.setParam(":VTRADE_ID", paramEnquirydealDAO.getTrade_id());
    localEnquirydealExt.setParam(":VENQUIRY_ID", paramEnquirydealDAO.getEnquiry_id());
    localEnquirydealExt.setParam(":VDEAL_CONTENT", str);
    localEnquirydealExt.setParam(":VDEAL_TAG", paramEnquirydealDAO.getDeal_tag());
    localEnquirydealExt.setParam(":VDEAL_USER", paramEnquirydealDAO.getDeal_user());
    this.tradeQuery.executeBy(localEnquirydealExt.insBy("INS_BY_DEAL"));
    return 0;
  }

  public void delEnquiryDeal(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delEnquiryDeal方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    int i = -1;
    try
    {
      i = delEnquiryDeal(str);
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
    this.log.LOG_INFO("退出delEnquiryDeal方法...");
  }

  public int delEnquiryDeal(String paramString)
    throws SaasApplicationException
  {
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    localEnquirydealExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localEnquirydealExt.insBy("DELETE_BY_ID"));
    return 0;
  }

  public ArrayList SchrepoitoryById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    localEnquirydealExt.setParam(":VENQUIRY_ID", paramString);
    localArrayList = localEnquirydealExt.selByList("SEL_BY_REP_ID");
    return localArrayList;
  }

  public ArrayList getEnquriyDealById(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    localEnquirydealExt.setParam(":VENQUIRY_ID", paramString1);
    localEnquirydealExt.setParam(":VENQUIRY_USER", paramString2);
    localEnquirydealExt.setParam(":VDEAL_TAG", paramString3);
    localArrayList = localEnquirydealExt.selByList("SEL_BY_ENQUIRY_ID", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getEnquriyDealCountById(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    localEnquirydealExt.setParam(":VENQUIRY_ID", paramString1);
    localEnquirydealExt.setParam(":VENQUIRY_USER", paramString2);
    localEnquirydealExt.setParam(":VDEAL_TAG", paramString3);
    localArrayList = localEnquirydealExt.selByList("SEL_BY_ENQUIRY_ID_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public int getEnquriyCountById(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    localEnquirydealExt.setParam(":VENQUIRY_ID", paramString);
    localArrayList = localEnquirydealExt.selByList("GET_BY_ENQUIRY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getEnquriyInfoById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    localEnquirydealExt.setParam(":VENQUIRY_ID", paramString);
    localArrayList = localEnquirydealExt.selByList("GET_BY_ENQUIRY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public void DeleteEnquriyAncInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteEnquriyInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SALE_ID");
    this.log.LOG_INFO("进入DeleteEnquriyAncInfo方法...******" + str1);
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = DeleteEnquriyAncInfo(str2);
      }
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
    this.log.LOG_INFO("退出DeleteEnquriyAncInfo方法...");
  }

  public int DeleteEnquriyAncInfo(String paramString)
    throws SaasApplicationException
  {
    EnquirydealExt localEnquirydealExt = new EnquirydealExt();
    localEnquirydealExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localEnquirydealExt.insBy("DELETE_ANSER_BY_IDX"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.enquirydealMgr.Enquirydealinfo
 * JD-Core Version:    0.6.0
 */