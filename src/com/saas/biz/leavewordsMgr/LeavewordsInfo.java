package com.saas.biz.leavewordsMgr;

import com.saas.biz.dao.leavewordsDAO.LeavewordsDAO;
import com.saas.biz.dao.leavewordsDAO.LeavewordsExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LeavewordsInfo
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

  public void genOneleavewords(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genOneleavewords方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    String str = "";
    str = paramBuffers.getString("TRADE_ID");
    try
    {
      this.queryResult = genOneleavewords(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneleavewords方法...");
  }

  public ArrayList genOneleavewords(String paramString)
    throws SaasApplicationException
  {
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VTRADE_ID", paramString);
    return localLeavewordsExt.selByList("SEL_BY_PK");
  }

  public void addleavewords(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    String str1 = paramBuffers.getString("ROOT_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("TITLE");
    String str4 = paramBuffers.getString("CONTENT");
    String str5 = paramBuffers.getString("WORD_TYPE");
    String str6 = paramBuffers.getString("CUST_ID");
    String str7 = paramBuffers.getString("USER_ID");
    String str8 = paramBuffers.getString("USER_NAME");
    String str9 = paramBuffers.getString("PHONE");
    String str10 = paramBuffers.getString("EMAIL");
    String str11 = paramBuffers.getString("WORD_STATUS");
    String str12 = paramBuffers.getString("RSRV_STR1");
    int i = -1;
    try
    {
      LeavewordsDAO localLeavewordsDAO = new LeavewordsDAO();
      localLeavewordsDAO.setTrade_id(str2);
      localLeavewordsDAO.setRoot_id(str1);
      localLeavewordsDAO.setTitle(str3);
      localLeavewordsDAO.setContent(str4);
      localLeavewordsDAO.setWord_type(str5);
      localLeavewordsDAO.setCust_id(str6);
      localLeavewordsDAO.setUser_id(str7);
      localLeavewordsDAO.setUser_name(str8);
      localLeavewordsDAO.setPhone(str9);
      localLeavewordsDAO.setEmail(str10);
      localLeavewordsDAO.setWord_status(str11);
      localLeavewordsDAO.setRsrv_str1(str12);
      i = addleavewords(localLeavewordsDAO);
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
    this.log.LOG_INFO("退出addleavewords方法...");
  }

  public int addleavewords(LeavewordsDAO paramLeavewordsDAO)
    throws SaasApplicationException
  {
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VTRADE_ID", paramLeavewordsDAO.getTrade_id());
    localLeavewordsExt.setParam(":VROOT_ID", paramLeavewordsDAO.getRoot_id());
    localLeavewordsExt.setParam(":VTITLE", paramLeavewordsDAO.getTitle());
    localLeavewordsExt.setParam(":VCONTENT", paramLeavewordsDAO.getContent());
    localLeavewordsExt.setParam(":VWORD_TYPE", paramLeavewordsDAO.getWord_type());
    localLeavewordsExt.setParam(":VCUST_ID", paramLeavewordsDAO.getCust_id());
    localLeavewordsExt.setParam(":VUSER_ID", paramLeavewordsDAO.getUser_id());
    localLeavewordsExt.setParam(":VUSER_NAME", paramLeavewordsDAO.getUser_name());
    localLeavewordsExt.setParam(":VPHONE", paramLeavewordsDAO.getPhone());
    localLeavewordsExt.setParam(":VEMAIL", paramLeavewordsDAO.getEmail());
    localLeavewordsExt.setParam(":VWORD_STATUS", paramLeavewordsDAO.getWord_status());
    localLeavewordsExt.setParam(":VRSRV_STR1", paramLeavewordsDAO.getRsrv_str1());
    this.tradeQuery.executeBy(localLeavewordsExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void genLeavewords(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genLeavewords方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("SESSION_CUST_ID");
    try
    {
      this.queryResult = genLeavewords(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genLeavewords方法...");
  }

  public ArrayList genLeavewords(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VROOT_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_BY_ROOT_IDS");
    return localArrayList;
  }

  public void anLeavewords(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入anLeavewords方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("TRADE_ID");
    this.log.LOG_INFO("前面trade_id........." + str1);
    String str2 = paramBuffers.getString("RSRV_STR3");
    int i = -1;
    try
    {
      i = anLeavewords(str1, str2);
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
    this.log.LOG_INFO("退出anLeavewords方法...");
  }

  public int anLeavewords(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VTRADE_ID", paramString1);
    localLeavewordsExt.setParam(":VRSRV_STR3", paramString2);
    this.log.LOG_INFO("后面trade_id........." + paramString1);
    this.tradeQuery.executeBy(localLeavewordsExt.insBy("AN_BY_LIUYAN"));
    return 0;
  }

  public void delLeavewords(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    int i = -1;
    try
    {
      i = delLeavewords(str);
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

  public int delLeavewords(String paramString)
    throws SaasApplicationException
  {
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localLeavewordsExt.insBy("DEL_BY_LIUYAN"));
    return 0;
  }

  public ArrayList getLeavelListBySend(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_BY_ROOT_ID", paramInt, 30);
    return localArrayList;
  }

  public ArrayList getLeavelListByTradeId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_BY_TRADE_ID_LIST");
    return localArrayList;
  }

  public int getLeaveNumberBySend(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_BY_ROOT_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLeavelListBySendDate(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString1);
    localLeavewordsExt.setParam(":VSTART_DATE", paramString2);
    localLeavewordsExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localLeavewordsExt.selByList("SEL_BY_ROOT_ID_DATE", paramInt, 30);
    return localArrayList;
  }

  public int getLeaveNumberBySendDate(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString1);
    localLeavewordsExt.setParam(":VSTART_DATE", paramString2);
    localLeavewordsExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localLeavewordsExt.selByList("SEL_BY_ROOT_ID_DATE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLeavelListBySendKey(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString1);
    localLeavewordsExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localLeavewordsExt.selByList("SEL_BY_ROOT_ID_KEY", paramInt, 30);
    return localArrayList;
  }

  public int getLeaveNumberBySendKey(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString1);
    localLeavewordsExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localLeavewordsExt.selByList("SEL_BY_ROOT_ID_KEY");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLeavelListByMy(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VUSER_NAME", paramString1);
    localLeavewordsExt.setParam(":VWORD_TYPE", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_MY", paramInt, 30);
    return localArrayList;
  }

  public ArrayList getLeavelListByOut(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_MY_NEW", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getLeavelListByOut(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_MY_NEW");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLeavelListByIn(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_IN_NEW", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getLeavelListByIn(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_IN_NEW");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getLeaveNumberByMy2(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VWORD_TYPE", paramString1);
    localLeavewordsExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_MY_USER");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLeavelListByMy2(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VWORD_TYPE", paramString1);
    localLeavewordsExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_MY_USER", paramInt, 20);
    return localArrayList;
  }

  public int getLeaveNumberByMy(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VUSER_NAME", paramString1);
    localLeavewordsExt.setParam(":VWORD_TYPE", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_MY");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getLeaveNumberByRootId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString1);
    localLeavewordsExt.setParam(":VROOT_ID", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_CUST_ID_ROOT_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLeaveNumberByRootId(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString1);
    localLeavewordsExt.setParam(":VROOT_ID", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_CUST_ID_ROOT_ID", paramInt, 20);
    return localArrayList;
  }

  public int getLeaveByAllRootId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VROOT_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_LEVEL_BY_ROOT_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLeaveByAllRootId(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VROOT_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_LEVEL_BY_ROOT_ID", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getLeavelListByMyID(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VWORD_TYPE", paramString1);
    localLeavewordsExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_MY_USER_WO", paramInt, 30);
    return localArrayList;
  }

  public int getLeaveNumberByMyID(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VWORD_TYPE", paramString1);
    localLeavewordsExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_MY_USER_WO");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getLeaveByTradeId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VTRADE_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_BY_RADE_ID");
    return localArrayList;
  }

  public ArrayList getLeaveByRootId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VROOT_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_LEVEL_BY_ROOT_ID");
    return localArrayList;
  }

  public void updateStatus(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delLeavewords方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("UPDATE_TRADE_ID");
    String str2 = paramBuffers.getString("WORD_STATUS");
    int i = -1;
    try
    {
      i = updateStatus(str1, str2);
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
    this.log.LOG_INFO("退出delLeavewords方法...");
  }

  public int updateStatus(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VTRADE_ID", paramString1);
    localLeavewordsExt.setParam(":VWORD_STATUS", paramString2);
    this.tradeQuery.executeBy(localLeavewordsExt.insBy("UPDATE_BY_RADE_ID"));
    return 0;
  }

  public void DeleteLeavewordInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = delLeavewords(str2);
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
  }

  public ArrayList getLeaveMemberByRootId(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString1);
    localLeavewordsExt.setParam(":VROOT_ID", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_CUST_ID_ROOT_ID_MEM", paramInt, 20);
    return localArrayList;
  }

  public int getLeaveMemberByRootId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString1);
    localLeavewordsExt.setParam(":VROOT_ID", paramString2);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_CUST_ID_ROOT_ID_MEM");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public void DelMemberSend(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_ID");
    int i = -1;
    try
    {
      i = DelMemberSend(str);
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
    this.log.LOG_INFO("退出addleavewords方法...");
  }

  public int DelMemberSend(String paramString)
    throws SaasApplicationException
  {
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localLeavewordsExt.insBy("DEL_MEMBER_SEND"));
    return 0;
  }

  public ArrayList getLeavelListByMember(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_IN_MEM", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getLeavelListByMember(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LeavewordsExt localLeavewordsExt = new LeavewordsExt();
    localLeavewordsExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLeavewordsExt.selByList("SEL_LEAVEL_IN_MEM");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.leavewordsMgr.LeavewordsInfo
 * JD-Core Version:    0.6.0
 */