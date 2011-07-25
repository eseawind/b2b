package com.saas.biz.ProcessMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.ProcessDAO.ProcessDAO;
import com.saas.biz.dao.ProcessDAO.ProcessExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ProcessInfo
{
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr comm = new commMethodMgr();
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

  public void addProcessInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addProcessInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("CATEGORY_ID");
    String str3 = paramBuffers.getString("CATEGORY_TITLE");
    String str4 = paramBuffers.getString("CATEGORY_TYPE");
    String str5 = paramBuffers.getString("CATEGORY_ABSTRACT");
    str5 = this.comm.setTextYin(str5);
    String str6 = paramBuffers.getString("CATEGORY_DESC");
    str6 = this.comm.setTextYin(str6);
    String str7 = paramBuffers.getString("CATEGORY_ADDR");
    String str8 = paramBuffers.getString("CATEGORY_UNIT");
    String str9 = paramBuffers.getString("START_DATE");
    String str10 = paramBuffers.getString("END_DATE");
    String str11 = paramBuffers.getString("SESSION_USER_ID");
    String str12 = "";
    String str13 = paramBuffers.getString("REMARK");
    try
    {
      ProcessDAO localProcessDAO = new ProcessDAO();
      localProcessDAO.setCust_id(str1);
      localProcessDAO.setCategory_id(str2);
      localProcessDAO.setCategory_title(str3);
      localProcessDAO.setCategory_type(str4);
      localProcessDAO.setCategory_abstract(str5);
      localProcessDAO.setCategory_desc(str6);
      localProcessDAO.setCategory_addr(str7);
      localProcessDAO.setCategory_unit(str8);
      localProcessDAO.setStart_date(str9);
      localProcessDAO.setEnd_date(str10);
      localProcessDAO.setPublish_user_id(str11);
      localProcessDAO.setPublish_date(str12);
      localProcessDAO.setRemark(str13);
      i = addProcessInfo(localProcessDAO);
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
    this.log.LOG_INFO("退出addProcessInfo方法...");
  }

  public int addProcessInfo(ProcessDAO paramProcessDAO)
    throws SaasApplicationException
  {
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCUST_ID", paramProcessDAO.getCust_id());
    localProcessExt.setParam(":VCATEGORY_ID", paramProcessDAO.getCategory_id());
    localProcessExt.setParam(":VCATEGORY_TITLE", paramProcessDAO.getCategory_title());
    localProcessExt.setParam(":VCATEGORY_TYPE", paramProcessDAO.getCategory_type());
    localProcessExt.setParam(":VCATEGORY_ABSTRACT", paramProcessDAO.getCategory_abstract());
    localProcessExt.setParam(":VCATEGORY_DESC", paramProcessDAO.getCategory_desc());
    localProcessExt.setParam(":VCATEGORY_ADDR", paramProcessDAO.getCategory_addr());
    localProcessExt.setParam(":VCATEGORY_UNIT", paramProcessDAO.getCategory_unit());
    localProcessExt.setParam(":VSTART_DATE", paramProcessDAO.getStart_date());
    localProcessExt.setParam(":VEND_DATE", paramProcessDAO.getEnd_date());
    localProcessExt.setParam(":VPUBLISH_USER_ID", paramProcessDAO.getPublish_user_id());
    localProcessExt.setParam(":VREMARK", paramProcessDAO.getRemark());
    this.tradeQuery.executeBy(localProcessExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void genProcess(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genProcess方法...");
    try
    {
      this.queryResult = genProcess();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genProcess方法...");
  }

  public ArrayList genProcess()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localArrayList1 = localProcessExt.selByList("SEL_BY_ALL");
    for (int i = 0; i < localArrayList1.size(); i++)
    {
      HashMap localHashMap1 = (HashMap)localArrayList1.get(i);
      String str1 = "";
      String str2 = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("category_id") != null)
        str2 = localHashMap1.get("category_id").toString();
      if (localHashMap1.get("category_title") != null)
        str1 = localHashMap1.get("category_title").toString();
      localHashMap2.put("category_title", str1);
      localHashMap2.put("category_id", str2);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public ArrayList genProcsss()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localArrayList1 = localProcessExt.selByList("SEL_BY_ALL");
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("category_id") != null)
        str2 = localHashMap1.get("category_id").toString();
      if (localHashMap1.get("category_title") != null)
        str1 = localHashMap1.get("category_title").toString();
      localHashMap1.put("category_title", str1);
      localHashMap1.put("category_id", str2);
      localArrayList2.add(localHashMap2);
    }
    return localArrayList2;
  }

  public ArrayList searchProcess(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCATEGORY_TITLE", "%" + paramString1 + "%");
    localProcessExt.setParam(":VCATEGORY_UNIT", paramString2);
    localArrayList = localProcessExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public ArrayList searchProcessBykey(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCUST_ID", paramString1);
    localProcessExt.setParam(":VCONTENT", "%" + paramString2 + "%");
    localArrayList = localProcessExt.selByList("SEL_BY_SEARCH_PROCESS");
    return localArrayList;
  }

  public void genSpecProcess(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genSpecProcess方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = genSpecProcess(str1);
      else
        this.queryResult = searchProcess(str2, str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genSpecProcess方法...");
  }

  public ArrayList genSpecProcess(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCATEGORY_UNIT", paramString);
    localArrayList = localProcessExt.selByList("SEL_SPEC_PROCESS");
    return localArrayList;
  }

  public void genOneProcess(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入genOneProcess方法...");
    String str = paramBuffers.getString("CATEGORY_ID");
    try
    {
      this.queryResult = genOneProcess(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneProcess方法...");
  }

  public ArrayList genOneProcess(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCATEGORY_ID", paramString);
    localArrayList = localProcessExt.selByList("SEL_ONE_PROCESS");
    return localArrayList;
  }

  public ArrayList gentProcessByCust_id(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProcessExt.selByList("SEL_SPEC_CUST_ID", paramInt, 30);
    return localArrayList;
  }

  public int getProcessListNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProcessExt.selByList("SEL_SPEC_CUST_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getOffProcessListNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProcessExt.selByList("SEL_OFF_SPEC_CUST_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public void changprocessinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入changprocessinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    ProcessDAO localProcessDAO = new ProcessDAO();
    localProcessDAO.setCust_id(paramBuffers.getString("CUST_ID"));
    localProcessDAO.setCategory_id(paramBuffers.getString("CATEGORY_ID"));
    localProcessDAO.setCategory_title(paramBuffers.getString("CATEGORY_TITLE"));
    localProcessDAO.setCategory_type(paramBuffers.getString("CATEGORY_TYPE"));
    localProcessDAO.setCategory_unit(paramBuffers.getString("CATEGORY_UNIT"));
    localProcessDAO.setCategory_abstract(paramBuffers.getString("CATEGORY_ABSTRACT"));
    localProcessDAO.setCategory_desc(paramBuffers.getString("CATEGORY_DESC"));
    localProcessDAO.setCategory_addr(paramBuffers.getString("CATEGORY_ADDR"));
    localProcessDAO.setStart_date(paramBuffers.getString("START_DATE"));
    localProcessDAO.setEnd_date(paramBuffers.getString("END_DATE"));
    localProcessDAO.setRemark(paramBuffers.getString("REMARK"));
    int i = -1;
    try
    {
      i = changprocessinfo(localProcessDAO);
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
    this.log.LOG_INFO("退出addprocessInfo方法...");
  }

  public int changprocessinfo(ProcessDAO paramProcessDAO)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入changprocessinfo方法...");
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCUST_ID", paramProcessDAO.getCust_id());
    localProcessExt.setParam(":VCATEGORY_ID", paramProcessDAO.getCategory_id());
    localProcessExt.setParam(":VCATEGORY_TITLE", paramProcessDAO.getCategory_title());
    localProcessExt.setParam(":VCATEGORY_TYPE", paramProcessDAO.getCategory_type());
    localProcessExt.setParam(":VCATEGORY_UNIT", paramProcessDAO.getCategory_unit());
    localProcessExt.setParam(":VCATEGORY_ABSTRACT", paramProcessDAO.getCategory_abstract());
    localProcessExt.setParam(":VCATEGORY_DESC", paramProcessDAO.getCategory_desc());
    localProcessExt.setParam(":VCATEGORY_ADDR", paramProcessDAO.getCategory_addr());
    localProcessExt.setParam(":VSTART_DATE", paramProcessDAO.getStart_date());
    localProcessExt.setParam(":VEND_DATE", paramProcessDAO.getEnd_date());
    localProcessExt.setParam(":VREMARK", paramProcessDAO.getRemark());
    this.tradeQuery.executeBy(localProcessExt.insBy("UPDATE_BY_ONE"));
    this.log.LOG_INFO("退出changprocessinfo方法..." + localProcessExt.insBy("UPDATE_BY_ONE"));
    return 0;
  }

  public void delprocessinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入delprocessinfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("CATEGORY_ID");
    try
    {
      i = delprocessinfo(str1, str2);
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
    this.log.LOG_INFO("退出delprocessinfo方法...");
  }

  public int delprocessinfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCUST_ID", paramString1);
    localProcessExt.setParam(":VCATEGORY_ID", paramString2);
    this.tradeQuery.executeBy(localProcessExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public ArrayList genProcessByType(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCATEGORY_TYPE", paramString);
    localArrayList = localProcessExt.selByList("SEL_BY_CATEGORYTYPE");
    return localArrayList;
  }

  public ArrayList getProcessByType(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localArrayList = localProcessExt.selByList("SEL_BY_CATEGORY_TYPE", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getCountsBycategory_type()
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localArrayList = localProcessExt.selByList("SEL_BY_VCATEGORY_TYPE_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList gentProcessByCust_idDate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCUST_ID", paramString1);
    paramInt *= 30;
    localProcessExt.setParam(":VSTART_DATE", paramString2);
    localProcessExt.setParam(":VEND_DATE", paramString3);
    if (paramString4 != "")
    {
      localProcessExt.setParam(":VCONTENT", "%" + paramString4 + "%");
      localArrayList = localProcessExt.selByList("SEL_SPEC_CUST_ID_DATE_KEY", paramInt, 30);
    }
    else
    {
      localArrayList = localProcessExt.selByList("SEL_SPEC_CUST_ID_DATE", paramInt, 30);
    }
    return localArrayList;
  }

  public int gentProcessByCust_idDateNum(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcessExt localProcessExt = new ProcessExt();
    localProcessExt.setParam(":VCUST_ID", paramString1);
    localProcessExt.setParam(":VSTART_DATE", paramString2);
    localProcessExt.setParam(":VEND_DATE", paramString3);
    if (paramString4 != "")
    {
      localProcessExt.setParam(":VCONTENT", "%" + paramString4 + "%");
      localArrayList = localProcessExt.selByList("SEL_SPEC_CUST_ID_DATE_KEY");
      if (localArrayList != null)
        return localArrayList.size();
      return 0;
    }
    localArrayList = localProcessExt.selByList("SEL_SPEC_CUST_ID_DATE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.ProcessMgr.ProcessInfo
 * JD-Core Version:    0.6.0
 */