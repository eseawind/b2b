package com.saas.biz.biddingMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.biddingDAO.BiddingDAO;
import com.saas.biz.dao.biddingDAO.BiddingExt;
import com.saas.biz.dao.enquirytrackDAO.EnquirytrackExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Biddinginfo
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

  public void genBidding(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genBidding方法...");
    try
    {
      this.queryResult = genBidding();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genBidding方法...");
  }

  public ArrayList genBidding()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    BiddingExt localBiddingExt = new BiddingExt();
    localArrayList1 = localBiddingExt.selByList("SEL_BY_ALL");
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("bidding_id") != null)
        str2 = localHashMap1.get("bidding_id").toString();
      if (localHashMap1.get("title") != null)
        str1 = localHashMap1.get("title").toString();
      try
      {
        str1 = new String(str1.getBytes("ISO8859_1"), "GB2312");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
      localHashMap2.put("title", str1);
      localHashMap2.put("bidding_id", str2);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public void genSpecBidding(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genBidding方法...");
    String str = paramBuffers.getString("CUST_ID");
    try
    {
      this.queryResult = genSpecBidding(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genBidding方法...");
  }

  public ArrayList genSpecBidding(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    BiddingExt localBiddingExt = new BiddingExt();
    localBiddingExt.setParam(":VCUST_ID", paramString);
    localArrayList1 = localBiddingExt.selByList("SEL_SPEC_BIDDING");
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("bidding_id") != null)
        str2 = localHashMap1.get("bidding_id").toString();
      if (localHashMap1.get("title") != null)
        str1 = localHashMap1.get("title").toString();
      try
      {
        str1 = new String(str1.getBytes("ISO8859_1"), "GB2312");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
      localHashMap2.put("title", str1);
      localHashMap2.put("bidding_id", str2);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public void genPKBidding(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genPKBidding方法...");
    String str = paramBuffers.getString("BIDDING_ID");
    try
    {
      this.queryResult = genPKBidding(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genPKBidding方法...");
  }

  public ArrayList genPKBidding(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    BiddingExt localBiddingExt = new BiddingExt();
    localBiddingExt.setParam(":VBIDDING_ID", paramString);
    localArrayList1 = localBiddingExt.selByList("SEL_BY_PK");
    return localArrayList1;
  }

  public void genBiddingList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genBiddingList方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = genBiddingList(str1);
      else
        this.queryResult = searchBidding(str2, str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genBiddingList方法...");
  }

  public ArrayList genBiddingList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    BiddingExt localBiddingExt = new BiddingExt();
    localBiddingExt.setParam(":VCUST_ID", paramString);
    localArrayList = localBiddingExt.selByList("SEL_SPEC_BIDDING");
    return localArrayList;
  }

  public void addBiddingInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addBiddingInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    BiddingDAO localBiddingDAO = new BiddingDAO();
    localBiddingDAO.setBidding_id(paramBuffers.getString("BIDDING_ID"));
    localBiddingDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
    localBiddingDAO.setTitle(paramBuffers.getString("TITLE"));
    localBiddingDAO.setBidding_no(paramBuffers.getString("BIDDING_NO"));
    localBiddingDAO.setOpen_date(paramBuffers.getString("OPEN_DATE"));
    localBiddingDAO.setAddr(paramBuffers.getString("ADDR"));
    localBiddingDAO.setContent(paramBuffers.getString("CONTENT"));
    localBiddingDAO.setPhone(paramBuffers.getString("PHONE"));
    localBiddingDAO.setAttach_tag(paramBuffers.getString("ATTACH_TAG"));
    localBiddingDAO.setPublish_person(paramBuffers.getString("SESSION_USER_ID"));
    localBiddingDAO.setAudit_person(paramBuffers.getString("SESSION_USER_ID"));
    if (paramBuffers.getString("ATTACH_TAG") != "")
      localBiddingDAO.setAttach_tag("1");
    else
      localBiddingDAO.setAttach_tag("0");
    try
    {
      i = addBiddingInfo(localBiddingDAO);
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
    this.log.LOG_INFO("退出addBiddingInfo方法...");
  }

  public int addBiddingInfo(BiddingDAO paramBiddingDAO)
    throws SaasApplicationException
  {
    BiddingExt localBiddingExt = new BiddingExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    localBiddingExt.setParam(":VBIDDING_ID", paramBiddingDAO.getBidding_id());
    localBiddingExt.setParam(":VCUST_ID", paramBiddingDAO.getCust_id());
    localBiddingExt.setParam(":VTITLE", paramBiddingDAO.getTitle());
    localBiddingExt.setParam(":VBIDDING_NO", paramBiddingDAO.getBidding_no());
    localBiddingExt.setParam(":VOPEN_DATE", paramBiddingDAO.getOpen_date());
    localBiddingExt.setParam(":VADDR", paramBiddingDAO.getAddr());
    localBiddingExt.setParam(":VCONTENT", paramBiddingDAO.getContent());
    localBiddingExt.setParam(":VPHONE", paramBiddingDAO.getPhone());
    localBiddingExt.setParam(":VATTACH_TAG", paramBiddingDAO.getAttach_tag());
    localBiddingExt.setParam(":VBIDDING_TYPE", "0");
    localBiddingExt.setParam(":VPUBLISH_PERSON", paramBiddingDAO.getPublish_person());
    localBiddingExt.setParam(":VAUDIT_PERSON", paramBiddingDAO.getAudit_person());
    localBiddingExt.setParam(":VVALIDITY", "0");
    localBiddingExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localBiddingExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("SPEC_ROOT_ID", paramBiddingDAO.getBidding_id());
    return 0;
  }

  public ArrayList searchBidding(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    EnquirytrackExt localEnquirytrackExt = new EnquirytrackExt();
    localEnquirytrackExt.setParam(":VTITLE", "%" + paramString1 + "%");
    localEnquirytrackExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localEnquirytrackExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public ArrayList getBiddingList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    BiddingExt localBiddingExt = new BiddingExt();
    localBiddingExt.setParam(":VCUST_ID", paramString);
    localArrayList = localBiddingExt.selByList("SEL_SPEC_BIDDING", paramInt, 30);
    return localArrayList;
  }

  public int getBiddingNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    BiddingExt localBiddingExt = new BiddingExt();
    localBiddingExt.setParam(":VCUST_ID", paramString);
    localArrayList = localBiddingExt.selByList("SEL_SPEC_BIDDING");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.biddingMgr.Biddinginfo
 * JD-Core Version:    0.6.0
 */