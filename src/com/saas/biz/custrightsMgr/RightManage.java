package com.saas.biz.custrightsMgr;

import com.saas.biz.dao.custrightsDAO.CustlevelownDAO;
import com.saas.biz.dao.custrightsDAO.CustlevelownExt;
import com.saas.biz.dao.custrightsDAO.CustlevelrightExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class RightManage
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

  public void genAllrights(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genAllrights方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str.equals(""))
        this.queryResult = genAllrights();
      else
        this.queryResult = searchRights(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genAllrights方法...");
  }

  public ArrayList genAllrights()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlevelrightExt localCustlevelrightExt = new CustlevelrightExt();
    localArrayList = localCustlevelrightExt.selByList("SEL_BY_ALL");
    return localArrayList;
  }

  public void genrights(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genrightname方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("RIGHT_CODE");
    try
    {
      this.queryResult = genrights(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genrightname方法...");
  }

  public ArrayList genrights(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlevelrightExt localCustlevelrightExt = new CustlevelrightExt();
    localCustlevelrightExt.setParam(":VRIGHT_CODE", paramString);
    localArrayList = localCustlevelrightExt.selByList("SEL_BY_ONE");
    return localArrayList;
  }

  public void changrights(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入changrights方法...");
    this.outBuffer = paramBuffers;
    CustlevelownDAO localCustlevelownDAO = new CustlevelownDAO();
    localCustlevelownDAO.setRight_code(paramBuffers.getString("RIGHT_CODE"));
    localCustlevelownDAO.setLimit_value(paramBuffers.getString("LIMIT_VALUE"));
    localCustlevelownDAO.setEnable_tag(paramBuffers.getString("ENABLE_TAG"));
    localCustlevelownDAO.setUpdate_staff_id(paramBuffers.getString("SESSION_USER_ID"));
    localCustlevelownDAO.setUpdate_depart_id(paramBuffers.getString("SESSION_CUST_ID"));
    localCustlevelownDAO.setCust_class(paramBuffers.getString("CUST_CLASS"));
    int i = -1;
    try
    {
      i = changrights(localCustlevelownDAO);
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
    this.log.LOG_INFO("退出changrights方法...");
  }

  public int changrights(CustlevelownDAO paramCustlevelownDAO)
    throws SaasApplicationException
  {
    CustlevelownExt localCustlevelownExt = new CustlevelownExt();
    String str1 = paramCustlevelownDAO.getCust_class();
    String str2 = paramCustlevelownDAO.getRight_code();
    localCustlevelownExt.setParam(":VCUST_CLASS", paramCustlevelownDAO.getCust_class());
    localCustlevelownExt.setParam(":VRIGHT_CODE", paramCustlevelownDAO.getRight_code());
    localCustlevelownExt.setParam(":VLIMIT_VALUE", paramCustlevelownDAO.getLimit_value());
    localCustlevelownExt.setParam(":VENABLE_TAG", paramCustlevelownDAO.getEnable_tag());
    localCustlevelownExt.setParam(":VUPDATE_STAFF_ID", paramCustlevelownDAO.getUpdate_staff_id());
    localCustlevelownExt.setParam(":VUPDATE_DEPART_ID", "");
    localCustlevelownExt.setParam(":VLIMIT_TYPE", "0");
    localCustlevelownExt.setParam(":VREMARK", "");
    if (checkrights(str1, str2) == 0)
      this.tradeQuery.executeBy(localCustlevelownExt.insBy("INS_BY_ALL"));
    else
      this.tradeQuery.executeBy(localCustlevelownExt.insBy("UPDATE_BY_IT"));
    return 0;
  }

  public int checkrights(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustlevelownExt localCustlevelownExt = new CustlevelownExt();
    ArrayList localArrayList = new ArrayList();
    localCustlevelownExt.setParam(":VCUST_CLASS", paramString1);
    localCustlevelownExt.setParam(":VRIGHT_CODE", paramString2);
    localArrayList = localCustlevelownExt.selByList("SEL_BY_IT");
    if (localArrayList == null)
      return 0;
    return 1;
  }

  public void genSendOrReceive(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genSendOrReceive方法...");
    this.outBuffer = paramBuffers;
    try
    {
      this.queryResult = genSendOrReceive();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genSendOrReceive方法...");
  }

  public ArrayList genSendOrReceive()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("right_name", "<a href=../crm/www/rights/addRights.jsp>权限分配</a>");
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("right_name", "<a href=../crm/www/rights/deleteRights.jsp>权限回收</a>");
    localArrayList.add(localHashMap1);
    localArrayList.add(localHashMap2);
    return localArrayList;
  }

  public ArrayList searchRights(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlevelrightExt localCustlevelrightExt = new CustlevelrightExt();
    localCustlevelrightExt.setParam(":VRIGHT_NAME", "%" + paramString + "%");
    localArrayList = localCustlevelrightExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public void addLimitValue(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入changrights方法...");
    this.outBuffer = paramBuffers;
    CustlevelownDAO localCustlevelownDAO = new CustlevelownDAO();
    localCustlevelownDAO.setCust_class(paramBuffers.getString("CUST_CLASS"));
    localCustlevelownDAO.setLimit_type(paramBuffers.getString("LIMIT_TYPE"));
    localCustlevelownDAO.setRight_code(paramBuffers.getString("RIGHT_CODE"));
    localCustlevelownDAO.setLimit_value(paramBuffers.getString("LIMIT_VALUE"));
    localCustlevelownDAO.setEnable_tag(paramBuffers.getString("ENABLE_TAG"));
    localCustlevelownDAO.setRemark(paramBuffers.getString("REMARK"));
    localCustlevelownDAO.setUpdate_staff_id(paramBuffers.getString("SESSION_USER_ID"));
    localCustlevelownDAO.setUpdate_depart_id(paramBuffers.getString("DEPART_CODE"));
    int i = -1;
    try
    {
      i = addLimitValue(localCustlevelownDAO);
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
    this.log.LOG_INFO("退出changrights方法...");
  }

  public int addLimitValue(CustlevelownDAO paramCustlevelownDAO)
    throws SaasApplicationException
  {
    CustlevelownExt localCustlevelownExt = new CustlevelownExt();
    String str1 = paramCustlevelownDAO.getCust_class();
    String str2 = paramCustlevelownDAO.getRight_code();
    String str3 = paramCustlevelownDAO.getLimit_type();
    localCustlevelownExt.setParam(":VCUST_CLASS", paramCustlevelownDAO.getCust_class());
    localCustlevelownExt.setParam(":VRIGHT_CODE", paramCustlevelownDAO.getRight_code());
    localCustlevelownExt.setParam(":VLIMIT_VALUE", paramCustlevelownDAO.getLimit_value());
    localCustlevelownExt.setParam(":VENABLE_TAG", paramCustlevelownDAO.getEnable_tag());
    localCustlevelownExt.setParam(":VUPDATE_STAFF_ID", paramCustlevelownDAO.getUpdate_staff_id());
    localCustlevelownExt.setParam(":VUPDATE_DEPART_ID", paramCustlevelownDAO.getUpdate_depart_id());
    localCustlevelownExt.setParam(":VLIMIT_TYPE", paramCustlevelownDAO.getLimit_type());
    localCustlevelownExt.setParam(":VREMARK", paramCustlevelownDAO.getRemark());
    if (checkright(str1, str2, str3) == 0)
      this.tradeQuery.executeBy(localCustlevelownExt.insBy("INS_BY_ALL"));
    else
      this.tradeQuery.executeBy(localCustlevelownExt.insBy("UPDATE_BY_IT"));
    return 0;
  }

  public ArrayList genAllrightsByClass(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlevelownExt localCustlevelownExt = new CustlevelownExt();
    localCustlevelownExt.setParam(":VCUST_CLASS", paramString);
    localArrayList = localCustlevelownExt.selByList("SEL_BY_CLASS_ID");
    return localArrayList;
  }

  public ArrayList genAllrightsByClass(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CustlevelownExt localCustlevelownExt = new CustlevelownExt();
    localCustlevelownExt.setParam(":VCUST_CLASS", paramString1);
    localCustlevelownExt.setParam(":VRIGHT_CODE", paramString2);
    localCustlevelownExt.setParam(":VLIMIT_TYPE", paramString3);
    localArrayList = localCustlevelownExt.selByList("SEL_BY_CLASS_CODE_TYPE");
    return localArrayList;
  }

  public int checkright(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    CustlevelownExt localCustlevelownExt = new CustlevelownExt();
    ArrayList localArrayList = new ArrayList();
    localCustlevelownExt.setParam(":VCUST_CLASS", paramString1);
    localCustlevelownExt.setParam(":VRIGHT_CODE", paramString2);
    localCustlevelownExt.setParam(":VLIMIT_TYPE", paramString3);
    localArrayList = localCustlevelownExt.selByList("SEL_BY_ITS");
    if (localArrayList == null)
      return 0;
    return 1;
  }

  public String getValueByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "";
    CustlevelownExt localCustlevelownExt = new CustlevelownExt();
    ArrayList localArrayList = new ArrayList();
    localCustlevelownExt.setParam(":VCUST_CLASS", paramString1);
    localCustlevelownExt.setParam(":VLIMIT_TYPE", paramString2);
    localArrayList = localCustlevelownExt.selByList("SEL_BY_TYPE_CLASS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("limit_value") != null)
        str = localHashMap.get("limit_value").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.custrightsMgr.RightManage
 * JD-Core Version:    0.6.0
 */