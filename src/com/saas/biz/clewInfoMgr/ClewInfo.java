package com.saas.biz.clewInfoMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.clewInfoDAO.ClewInfoDAO;
import com.saas.biz.dao.clewInfoDAO.ClewInfoExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ClewInfo
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

  public void addClewInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addClewInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CLEW_ID");
    String str3 = paramBuffers.getString("ENTITY_TYPE");
    String str4 = paramBuffers.getString("TITLE");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("CL_CUST_NAME");
    String str7 = paramBuffers.getString("CL_CUST_ID");
    String str8 = paramBuffers.getString("CL_CONTACT");
    String str9 = paramBuffers.getString("CL_CONTACTMAN");
    String str10 = paramBuffers.getString("CL_ADDR");
    String str11 = paramBuffers.getString("CL_PER");
    String str12 = paramBuffers.getString("CL_PAY");
    String str13 = paramBuffers.getString("STATE_CODE");
    String str14 = paramBuffers.getString("GET_MODE");
    String str15 = paramBuffers.getString("GET_USER_NAME");
    String str16 = paramBuffers.getString("GET_USER_ID");
    String str17 = paramBuffers.getString("SESSION_USER_ID");
    String str18 = paramBuffers.getString("REMARK2");
    try
    {
      ClewInfoDAO localClewInfoDAO = new ClewInfoDAO();
      localClewInfoDAO.setCl_addr(str10);
      localClewInfoDAO.setCl_contact(str8);
      localClewInfoDAO.setCust_id(str1);
      localClewInfoDAO.setClew_id(str2);
      localClewInfoDAO.setEntity_type(str3);
      localClewInfoDAO.setTitle(str4);
      localClewInfoDAO.setContent(str5);
      localClewInfoDAO.setCl_cust_name(str6);
      localClewInfoDAO.setCl_cust_id(str7);
      localClewInfoDAO.setCl_contactman(str9);
      localClewInfoDAO.setCl_pay(str12);
      localClewInfoDAO.setCl_per(str11);
      localClewInfoDAO.setState_code(str13);
      localClewInfoDAO.setGet_mode(str14);
      localClewInfoDAO.setGet_user_id(str16);
      localClewInfoDAO.setGet_user_name(str15);
      localClewInfoDAO.setOper_user_id(str17);
      localClewInfoDAO.setRemark2(str18);
      i = addClewInfo(localClewInfoDAO);
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
    this.log.LOG_INFO("退出addClewInfo方法...");
  }

  public int addClewInfo(ClewInfoDAO paramClewInfoDAO)
    throws SaasApplicationException
  {
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    try
    {
      localClewInfoExt.setParam(":VCUST_ID", paramClewInfoDAO.getCust_id());
      localClewInfoExt.setParam(":VCLEW_ID", paramClewInfoDAO.getClew_id());
      localClewInfoExt.setParam(":VENTITY_TYPE", paramClewInfoDAO.getEntity_type());
      localClewInfoExt.setParam(":VTITLE", paramClewInfoDAO.getTitle());
      localClewInfoExt.setParam(":VCONTENT", paramClewInfoDAO.getContent());
      localClewInfoExt.setParam(":VCL_CUST_NAME", paramClewInfoDAO.getCl_cust_name());
      localClewInfoExt.setParam(":VCL_CUST_ID", paramClewInfoDAO.getCl_cust_id());
      localClewInfoExt.setParam(":VCL_CONTACT", paramClewInfoDAO.getCl_contact());
      localClewInfoExt.setParam(":VCL_CONTACTMAN", paramClewInfoDAO.getCl_contactman());
      localClewInfoExt.setParam(":VCL_ADDR", paramClewInfoDAO.getCl_addr());
      localClewInfoExt.setParam(":VCL_PER", paramClewInfoDAO.getCl_per());
      localClewInfoExt.setParam(":VCL_PAY", paramClewInfoDAO.getCl_pay());
      localClewInfoExt.setParam(":VSTATE_CODE", paramClewInfoDAO.getState_code());
      localClewInfoExt.setParam(":VGET_MODE", paramClewInfoDAO.getGet_mode());
      localClewInfoExt.setParam(":VGET_USER_NAME", paramClewInfoDAO.getGet_user_name());
      localClewInfoExt.setParam(":VGET_USER_ID", paramClewInfoDAO.getGet_user_id());
      localClewInfoExt.setParam(":VOPER_USER_ID", paramClewInfoDAO.getOper_user_id());
      localClewInfoExt.setParam(":VREMARK2", paramClewInfoDAO.getRemark2());
      this.tradeQuery.executeBy(localClewInfoExt.insBy("INS_BY_ALL"));
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return 0;
  }

  public void updateClewInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateClewInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CLEW_ID");
    String str3 = paramBuffers.getString("ENTITY_TYPE");
    String str4 = paramBuffers.getString("TITLE");
    String str5 = paramBuffers.getString("CONTENT");
    String str6 = paramBuffers.getString("CL_CUST_NAME");
    String str7 = paramBuffers.getString("CL_CUST_ID");
    String str8 = paramBuffers.getString("CL_CONTACT");
    String str9 = paramBuffers.getString("CL_CONTACTMAN");
    String str10 = paramBuffers.getString("CL_ADDR");
    String str11 = paramBuffers.getString("CL_PER");
    String str12 = paramBuffers.getString("CL_PAY");
    String str13 = paramBuffers.getString("STATE_CODE");
    String str14 = paramBuffers.getString("GET_MODE");
    String str15 = paramBuffers.getString("GET_USER_NAME");
    String str16 = paramBuffers.getString("GET_USER_ID");
    String str17 = paramBuffers.getString("SESSION_USER_ID");
    String str18 = paramBuffers.getString("REMARK2");
    try
    {
      ClewInfoDAO localClewInfoDAO = new ClewInfoDAO();
      localClewInfoDAO.setCl_addr(str10);
      localClewInfoDAO.setCl_contact(str8);
      localClewInfoDAO.setCust_id(str1);
      localClewInfoDAO.setClew_id(str2);
      localClewInfoDAO.setEntity_type(str3);
      localClewInfoDAO.setTitle(str4);
      localClewInfoDAO.setContent(str5);
      localClewInfoDAO.setCl_cust_name(str6);
      localClewInfoDAO.setCl_cust_id(str7);
      localClewInfoDAO.setCl_contactman(str9);
      localClewInfoDAO.setCl_pay(str12);
      localClewInfoDAO.setCl_per(str11);
      localClewInfoDAO.setState_code(str13);
      localClewInfoDAO.setGet_mode(str14);
      localClewInfoDAO.setGet_user_id(str16);
      localClewInfoDAO.setGet_user_name(str15);
      localClewInfoDAO.setOper_user_id(str17);
      localClewInfoDAO.setRemark2(str18);
      i = updateClewInfo(localClewInfoDAO);
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
    this.log.LOG_INFO("退出updateClewInfo方法...");
  }

  public int updateClewInfo(ClewInfoDAO paramClewInfoDAO)
    throws SaasApplicationException
  {
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    try
    {
      localClewInfoExt.setParam(":VCUST_ID", paramClewInfoDAO.getCust_id());
      localClewInfoExt.setParam(":VCLEW_ID", paramClewInfoDAO.getClew_id());
      localClewInfoExt.setParam(":VENTITY_TYPE", paramClewInfoDAO.getEntity_type());
      localClewInfoExt.setParam(":VTITLE", paramClewInfoDAO.getTitle());
      localClewInfoExt.setParam(":VCONTENT", paramClewInfoDAO.getContent());
      localClewInfoExt.setParam(":VCL_CUST_NAME", paramClewInfoDAO.getCl_cust_name());
      localClewInfoExt.setParam(":VCL_CUST_ID", paramClewInfoDAO.getCl_cust_id());
      localClewInfoExt.setParam(":VCL_CONTACT", paramClewInfoDAO.getCl_contact());
      localClewInfoExt.setParam(":VCL_CONTACTMAN", paramClewInfoDAO.getCl_contactman());
      localClewInfoExt.setParam(":VCL_ADDR", paramClewInfoDAO.getCl_addr());
      localClewInfoExt.setParam(":VCL_PER", paramClewInfoDAO.getCl_per());
      localClewInfoExt.setParam(":VCL_PAY", paramClewInfoDAO.getCl_pay());
      localClewInfoExt.setParam(":VSTATE_CODE", paramClewInfoDAO.getState_code());
      localClewInfoExt.setParam(":VGET_MODE", paramClewInfoDAO.getGet_mode());
      localClewInfoExt.setParam(":VGET_USER_NAME", paramClewInfoDAO.getGet_user_name());
      localClewInfoExt.setParam(":VGET_USER_ID", paramClewInfoDAO.getGet_user_id());
      localClewInfoExt.setParam(":VOPER_USER_ID", paramClewInfoDAO.getOper_user_id());
      localClewInfoExt.setParam(":VREMARK2", paramClewInfoDAO.getRemark2());
      this.tradeQuery.executeBy(localClewInfoExt.insBy("UP_BY_ID"));
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return 0;
  }

  public void delClewInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delClewInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str = paramBuffers.getString("CLEW_ID");
      i = delClewInfo(str);
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
    this.log.LOG_INFO("退出delClewInfo方法...");
  }

  public int delClewInfo(String paramString)
    throws SaasApplicationException
  {
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    localClewInfoExt.setParam(":VCLEW_ID", paramString);
    this.tradeQuery.executeBy(localClewInfoExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public void changeClewInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入changeClewInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CLEW_ID");
      String str2 = paramBuffers.getString("STATE_CODE");
      i = changeClewInfo(str1, str2);
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
    this.log.LOG_INFO("退出changeClewInfo方法...");
  }

  public int changeClewInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    localClewInfoExt.setParam(":VCLEW_ID", paramString1);
    localClewInfoExt.setParam(":VSTATE_CODE", paramString2);
    this.tradeQuery.executeBy(localClewInfoExt.insBy("CHANGE_BY_ID"));
    return 0;
  }

  public ArrayList getClewInfoByCust(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    localClewInfoExt.setParam(":VCUST_ID", paramString);
    localArrayList = localClewInfoExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList getClewPageByCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    localClewInfoExt.setParam(":VCUST_ID", paramString);
    localArrayList = localClewInfoExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getClewPageSizeByCust(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    localClewInfoExt.setParam(":VCUST_ID", paramString);
    localArrayList = localClewInfoExt.selByList("SEL_BY_SIZE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public int getClewPageSizeBySale(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    localClewInfoExt.setParam(":VCUST_ID", paramString);
    localArrayList = localClewInfoExt.selByList("SEL_SALE_SIZE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getClewPageByState(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    localClewInfoExt.setParam(":VCUST_ID", paramString1);
    localClewInfoExt.setParam(":VSTATE_CODE", paramString2);
    localArrayList = localClewInfoExt.selByList("SEL_BY_STATE", paramInt, 20);
    return localArrayList;
  }

  public int getClewPagesByState(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    localClewInfoExt.setParam(":VCUST_ID", paramString1);
    localClewInfoExt.setParam(":VSTATE_CODE", paramString2);
    localArrayList = localClewInfoExt.selByList("SEL_STATE_SIZE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getClewInfoById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ClewInfoExt localClewInfoExt = new ClewInfoExt();
    localClewInfoExt.setParam(":VCLEW_ID", paramString);
    localArrayList = localClewInfoExt.selByList("SEL_BY_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.clewInfoMgr.ClewInfo
 * JD-Core Version:    0.6.0
 */