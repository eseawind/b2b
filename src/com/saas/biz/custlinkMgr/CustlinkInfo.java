package com.saas.biz.custlinkMgr;

import com.saas.biz.dao.custlinkDAO.CustlinkDAO;
import com.saas.biz.dao.custlinkDAO.CustlinkExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class CustlinkInfo
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

  public void addCustLinkInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCustLinkInfo方法...");
    this.outBuffer = paramBuffers;
    CustlinkDAO localCustlinkDAO = new CustlinkDAO();
    this.outBuffer = paramBuffers;
    localCustlinkDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localCustlinkDAO.setLink_name(paramBuffers.getString("LINK_NAME"));
    localCustlinkDAO.setLink_no(paramBuffers.getString("LINK_NO"));
    localCustlinkDAO.setLink_url(paramBuffers.getString("LINK_URL"));
    localCustlinkDAO.setLink_type(paramBuffers.getString("LINK_TYPE"));
    localCustlinkDAO.setRsrv_str3(paramBuffers.getString("RSRV_STR3"));
    int i = -1;
    try
    {
      i = addCustLinkInfo(localCustlinkDAO);
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
  }

  public int addCustLinkInfo(CustlinkDAO paramCustlinkDAO)
    throws SaasApplicationException
  {
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VCUST_ID", paramCustlinkDAO.getCust_id());
    localCustlinkExt.setParam(":VLINK_NAME", paramCustlinkDAO.getLink_name());
    localCustlinkExt.setParam(":VLINK_NO", paramCustlinkDAO.getLink_no());
    localCustlinkExt.setParam(":VLINK_URL", paramCustlinkDAO.getLink_url());
    localCustlinkExt.setParam(":VLINK_TYPE", paramCustlinkDAO.getLink_type());
    localCustlinkExt.setParam(":VRSRV_STR1", "");
    localCustlinkExt.setParam(":VRSRV_STR2", "");
    localCustlinkExt.setParam(":VRSRV_STR3", paramCustlinkDAO.getRsrv_str3());
    localCustlinkExt.setParam(":VRSRV_STR4", "");
    localCustlinkExt.setParam(":VRSRV_STR5", "");
    localCustlinkExt.setParam(":VRSRV_STR6", "");
    localCustlinkExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localCustlinkExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateCustLinkInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateCustLinkInfo方法...");
    this.outBuffer = paramBuffers;
    CustlinkDAO localCustlinkDAO = new CustlinkDAO();
    this.outBuffer = paramBuffers;
    localCustlinkDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localCustlinkDAO.setLink_name(paramBuffers.getString("LINK_NAME"));
    localCustlinkDAO.setLink_no(paramBuffers.getString("LINK_NO"));
    localCustlinkDAO.setLink_url(paramBuffers.getString("LINK_URL"));
    localCustlinkDAO.setLink_type(paramBuffers.getString("LINK_TYPE"));
    localCustlinkDAO.setRsrv_str3(paramBuffers.getString("RSRV_STR3"));
    int i = -1;
    try
    {
      i = updateCustLinkInfo(localCustlinkDAO);
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
  }

  public int updateCustLinkInfo(CustlinkDAO paramCustlinkDAO)
    throws SaasApplicationException
  {
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VCUST_ID", paramCustlinkDAO.getCust_id());
    localCustlinkExt.setParam(":VLINK_NAME", paramCustlinkDAO.getLink_name());
    localCustlinkExt.setParam(":VLINK_NO", paramCustlinkDAO.getLink_no());
    localCustlinkExt.setParam(":VLINK_URL", paramCustlinkDAO.getLink_url());
    localCustlinkExt.setParam(":VLINK_TYPE", paramCustlinkDAO.getLink_type());
    localCustlinkExt.setParam(":VRSRV_STR3", paramCustlinkDAO.getRsrv_str3());
    this.tradeQuery.executeBy(localCustlinkExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public void genCustCustlink(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genCustCustlink方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("QUERY_PARAM");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    try
    {
      if (str1.equals(""))
        this.queryResult = genCustCustlink(str2);
      else
        this.queryResult = searchLink(str1, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genCustCustlink方法...");
  }

  public ArrayList genCustCustlink(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustlinkExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public void genOneCustlink(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genOneCustlink方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("LINK_NO");
    try
    {
      this.queryResult = genOneCustlink(str2, str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneCustlink方法...");
  }

  public ArrayList genOneCustlink(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VLINK_NO", paramString1);
    localCustlinkExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localCustlinkExt.selByList("SEL_BY_ONE");
    return localArrayList;
  }

  public void deloneinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deloneinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("LINK_NO");
    try
    {
      i = deloneinfo(str2, str1);
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
    this.log.LOG_INFO("退出deloneinfo方法...");
  }

  public int deloneinfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VLINK_NO", paramString1);
    localCustlinkExt.setParam(":VCUST_ID", paramString2);
    this.tradeQuery.executeBy(localCustlinkExt.insBy("DEL_BY_ONE"));
    return 0;
  }

  public ArrayList searchLink(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VLINK_NAME", "%" + paramString1 + "%");
    localCustlinkExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localCustlinkExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public ArrayList getCustLinkListByAll(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustlinkExt.selByList("SEL_BY_CUST", paramInt, 30);
    return localArrayList;
  }

  public int getLinkNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustlinkExt.selByList("SEL_BY_CUST");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getCustFriendlyExists(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VCUST_ID", paramString1);
    localCustlinkExt.setParam(":VLINK_NAME", paramString2);
    localCustlinkExt.setParam(":VLINK_URL", paramString3);
    localArrayList = localCustlinkExt.selByList("SEL_BY_EXIST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getLinkListByPage(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlinkExt localCustlinkExt = new CustlinkExt();
    localCustlinkExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustlinkExt.selByList("SEL_BY_CUST", paramInt1, paramInt2);
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.custlinkMgr.CustlinkInfo
 * JD-Core Version:    0.6.0
 */