package com.saas.biz.addMyInternetMgr;

import com.saas.biz.dao.addMyInternetDAO.AddMyInternetDAO;
import com.saas.biz.dao.addMyInternetDAO.AddMyInternetExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class AddMyInternetInfo
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

  public void AddMyInternet(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入AddMyInternet方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    String str3 = paramBuffers.getString("NAME");
    String str4 = paramBuffers.getString("POS_TYPE");
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    try
    {
      AddMyInternetDAO localAddMyInternetDAO = new AddMyInternetDAO();
      localAddMyInternetDAO.setCust_id(str1);
      localAddMyInternetDAO.setUser_id(str2);
      this.log.LOG_INFO("type..." + str4);
      if ((str4 == "1") || (str4.equals("1")))
        str5 = str3;
      localAddMyInternetDAO.setEmail(str5);
      if ((str4 == "2") || (str4.equals("2")))
        str6 = str3;
      localAddMyInternetDAO.setBlog(str6);
      if ((str4 == "3") || (str4.equals("3")))
        str7 = str3;
      localAddMyInternetDAO.setQQ(str7);
      if ((str4 == "4") || (str4.equals("4")))
        str8 = str3;
      localAddMyInternetDAO.setMSN(str8);
      if ((str4 == "5") || (str4.equals("5")))
        str9 = str3;
      localAddMyInternetDAO.setUserwww(str9);
      if ((str4 == "6") || (str4.equals("6")))
        str10 = str3;
      localAddMyInternetDAO.setCustwww(str10);
      i = AddInternet(localAddMyInternetDAO, str4);
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
    this.log.LOG_INFO("退出AddMyInternet方法...");
  }

  public int AddInternet(AddMyInternetDAO paramAddMyInternetDAO, String paramString)
    throws SaasApplicationException
  {
    AddMyInternetExt localAddMyInternetExt = new AddMyInternetExt();
    this.log.LOG_INFO("开始执行SQL:===:");
    localAddMyInternetExt.setParam(":VCUST_ID", paramAddMyInternetDAO.getCust_id());
    localAddMyInternetExt.setParam(":VUSER_ID", paramAddMyInternetDAO.getUser_id());
    localAddMyInternetExt.setParam(":VEMAIL", paramAddMyInternetDAO.getEmail());
    localAddMyInternetExt.setParam(":VBLOG", paramAddMyInternetDAO.getBlog());
    localAddMyInternetExt.setParam(":VQQ", paramAddMyInternetDAO.getQQ());
    localAddMyInternetExt.setParam(":VMSN", paramAddMyInternetDAO.getMSN());
    localAddMyInternetExt.setParam(":VUSERWWW", paramAddMyInternetDAO.getUserwww());
    localAddMyInternetExt.setParam(":VCUSTWWW", paramAddMyInternetDAO.getCustwww());
    ArrayList localArrayList = getById(paramAddMyInternetDAO.getCust_id(), paramAddMyInternetDAO.getUser_id());
    this.log.LOG_INFO("开始执行sList===:" + localArrayList);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      if ((paramString == "1") || (paramString.equals("1")))
        this.tradeQuery.executeBy(localAddMyInternetExt.insBy("UPDATE_BY_EMAIL"));
      else if ((paramString == "2") || (paramString.equals("2")))
        this.tradeQuery.executeBy(localAddMyInternetExt.insBy("UPDATE_BY_BLOG"));
      else if ((paramString == "3") || (paramString.equals("3")))
        this.tradeQuery.executeBy(localAddMyInternetExt.insBy("UPDATE_BY_QQ"));
      else if ((paramString == "4") || (paramString.equals("4")))
        this.tradeQuery.executeBy(localAddMyInternetExt.insBy("UPDATE_BY_MSN"));
      else if ((paramString == "5") || (paramString.equals("5")))
        this.tradeQuery.executeBy(localAddMyInternetExt.insBy("UPDATE_BY_USERWWW"));
      else if ((paramString == "6") || (paramString.equals("6")))
        this.tradeQuery.executeBy(localAddMyInternetExt.insBy("UPDATE_BY_CUSTWWW"));
      else
        return -1;
    }
    else
      this.tradeQuery.executeBy(localAddMyInternetExt.insBy("ADD_BY_ATTR"));
    return 0;
  }

  public ArrayList getById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AddMyInternetExt localAddMyInternetExt = new AddMyInternetExt();
    localAddMyInternetExt.setParam(":VCUST_ID", paramString1);
    localAddMyInternetExt.setParam(":VUSER_ID", paramString2);
    localArrayList = localAddMyInternetExt.selByList("SEL_BY_CUST_ID");
    return localArrayList;
  }

  public HashMap getattrById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    AddMyInternetExt localAddMyInternetExt = new AddMyInternetExt();
    localAddMyInternetExt.setParam(":VCUST_ID", paramString1);
    localAddMyInternetExt.setParam(":VUSER_ID", paramString2);
    localArrayList = localAddMyInternetExt.selByList("SEL_BY_CUST_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.addMyInternetMgr.AddMyInternetInfo
 * JD-Core Version:    0.6.0
 */