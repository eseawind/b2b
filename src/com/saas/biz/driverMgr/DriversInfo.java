package com.saas.biz.driverMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.driverDao.DriverDao;
import com.saas.biz.dao.driverDao.DriverExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class DriversInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr commen = new commMethodMgr();
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

  public void addDriverInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addDriverInfo方法...");
    int i = -1;
    try
    {
      DriverDao localDriverDao = new DriverDao();
      localDriverDao.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
      localDriverDao.setDriver_id(paramBuffers.getString("DRIVER_ID"));
      localDriverDao.setDriver_name(paramBuffers.getString("DRIVER_NAME"));
      localDriverDao.setAuto_id(paramBuffers.getString("AUTO_ID"));
      localDriverDao.setDriver_no(paramBuffers.getString("DRIVER_NO"));
      localDriverDao.setIn_date(paramBuffers.getString("IN_DATE"));
      localDriverDao.setDriver_year(paramBuffers.getString("DRIVER_YEAR"));
      localDriverDao.setBirthday(paramBuffers.getString("BIRTHDAY"));
      localDriverDao.setFrom_addr(paramBuffers.getString("FROM_ADDR"));
      localDriverDao.setContact_addr(paramBuffers.getString("CONTACT_ADDR"));
      localDriverDao.setContact_phone(paramBuffers.getString("CONTACT_PHONE"));
      localDriverDao.setEdu_pre(paramBuffers.getString("EDU_PRE"));
      localDriverDao.setUser_tag(paramBuffers.getString("USER_TAG"));
      localDriverDao.setUser_id(paramBuffers.getString("USER_ID"));
      localDriverDao.setCheck_date(paramBuffers.getString("CHECK_DATE"));
      localDriverDao.setState_code(paramBuffers.getString("STATE_CODE"));
      localDriverDao.setState_code_date(paramBuffers.getString("STATE_CODE_DATE"));
      localDriverDao.setOper_date(paramBuffers.getString("OPER_DATE"));
      localDriverDao.setOper_user_id(paramBuffers.getString("OPER_USER_ID"));
      localDriverDao.setRemark(paramBuffers.getString("REMARK"));
      i = addDriverInfo(localDriverDao);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增驾驶员资料业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增驾驶员资料业务处理成功！");
    }
    this.log.LOG_INFO("退出addDriverInfo方法...");
  }

  public int addDriverInfo(DriverDao paramDriverDao)
    throws SaasApplicationException
  {
    DriverExt localDriverExt = new DriverExt();
    localDriverExt.setParam(":VCUST_ID", paramDriverDao.getCust_id());
    localDriverExt.setParam(":VDRIVER_ID", paramDriverDao.getDriver_id());
    localDriverExt.setParam(":VDRIVER_NAME", paramDriverDao.getDriver_name());
    localDriverExt.setParam(":VAUTO_ID", paramDriverDao.getAuto_id());
    localDriverExt.setParam(":VDRIVER_NO", paramDriverDao.getDriver_no());
    localDriverExt.setParam(":VIN_DATE", paramDriverDao.getIn_date());
    localDriverExt.setParam(":VDRIVER_YEAR", paramDriverDao.getDriver_year());
    localDriverExt.setParam(":VBIRTHDAY", paramDriverDao.getBirthday());
    localDriverExt.setParam(":VFROM_ADDR", paramDriverDao.getFrom_addr());
    localDriverExt.setParam(":VCONTACT_ADDR", paramDriverDao.getContact_addr());
    localDriverExt.setParam(":VCONTACT_PHONE", paramDriverDao.getContact_phone());
    localDriverExt.setParam(":VEDU_PRE", paramDriverDao.getEdu_pre());
    localDriverExt.setParam(":VUSER_TAG", paramDriverDao.getUser_tag());
    localDriverExt.setParam(":VUSER_ID", paramDriverDao.getUser_id());
    localDriverExt.setParam(":VCHECK_DATE", paramDriverDao.getCheck_date());
    localDriverExt.setParam(":VSTATE_CODE", paramDriverDao.getState_code());
    localDriverExt.setParam(":VSTATE_CODE_DATE", paramDriverDao.getState_code_date());
    localDriverExt.setParam(":VOPER_DATE", paramDriverDao.getOper_date());
    localDriverExt.setParam(":VOPER_USER_ID", paramDriverDao.getOper_user_id());
    localDriverExt.setParam(":VREMARK", paramDriverDao.getRemark());
    this.tradeQuery.executeBy(localDriverExt.insBy("INS_BY_ALL"));
    this.log.LOG_INFO(" addUserInfo successful !");
    return 0;
  }

  public void updateDriverInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateDriverInfo方法...");
    int i = -1;
    try
    {
      DriverDao localDriverDao = new DriverDao();
      localDriverDao.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
      localDriverDao.setDriver_id(paramBuffers.getString("DRIVER_ID"));
      localDriverDao.setDriver_name(paramBuffers.getString("DRIVER_NAME"));
      localDriverDao.setAuto_id(paramBuffers.getString("AUTO_ID"));
      localDriverDao.setDriver_no(paramBuffers.getString("DRIVER_NO"));
      localDriverDao.setIn_date(paramBuffers.getString("IN_DATE"));
      localDriverDao.setDriver_year(paramBuffers.getString("DRIVER_YEAR"));
      localDriverDao.setBirthday(paramBuffers.getString("BIRTHDAY"));
      localDriverDao.setFrom_addr(paramBuffers.getString("FROM_ADDR"));
      localDriverDao.setContact_addr(paramBuffers.getString("CONTACT_ADDR"));
      localDriverDao.setContact_phone(paramBuffers.getString("CONTACT_PHONE"));
      localDriverDao.setEdu_pre(paramBuffers.getString("EDU_PRE"));
      localDriverDao.setUser_tag(paramBuffers.getString("USER_TAG"));
      localDriverDao.setUser_id(paramBuffers.getString("USER_ID"));
      localDriverDao.setCheck_date(paramBuffers.getString("CHECK_DATE"));
      localDriverDao.setState_code(paramBuffers.getString("STATE_CODE"));
      localDriverDao.setState_code_date(paramBuffers.getString("STATE_CODE_DATE"));
      localDriverDao.setOper_date(paramBuffers.getString("OPER_DATE"));
      localDriverDao.setOper_user_id(paramBuffers.getString("OPER_USER_ID"));
      localDriverDao.setRemark(paramBuffers.getString("REMARK"));
      i = updateDriverInfo(localDriverDao);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增驾驶员资料业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增驾驶员资料业务处理成功！");
    }
    this.log.LOG_INFO("退出updateDriverInfo方法...");
  }

  public int updateDriverInfo(DriverDao paramDriverDao)
    throws SaasApplicationException
  {
    DriverExt localDriverExt = new DriverExt();
    localDriverExt.setParam(":VCUST_ID", paramDriverDao.getCust_id());
    localDriverExt.setParam(":VDRIVER_ID", paramDriverDao.getDriver_id());
    localDriverExt.setParam(":VDRIVER_NAME", paramDriverDao.getDriver_name());
    localDriverExt.setParam(":VAUTO_ID", paramDriverDao.getAuto_id());
    localDriverExt.setParam(":VDRIVER_NO", paramDriverDao.getDriver_no());
    localDriverExt.setParam(":VIN_DATE", paramDriverDao.getIn_date());
    localDriverExt.setParam(":VDRIVER_YEAR", paramDriverDao.getDriver_year());
    localDriverExt.setParam(":VBIRTHDAY", paramDriverDao.getBirthday());
    localDriverExt.setParam(":VFROM_ADDR", paramDriverDao.getFrom_addr());
    localDriverExt.setParam(":VCONTACT_ADDR", paramDriverDao.getContact_addr());
    localDriverExt.setParam(":VCONTACT_PHONE", paramDriverDao.getContact_phone());
    localDriverExt.setParam(":VEDU_PRE", paramDriverDao.getEdu_pre());
    localDriverExt.setParam(":VUSER_TAG", paramDriverDao.getUser_tag());
    localDriverExt.setParam(":VUSER_ID", paramDriverDao.getUser_id());
    localDriverExt.setParam(":VCHECK_DATE", paramDriverDao.getCheck_date());
    localDriverExt.setParam(":VSTATE_CODE", paramDriverDao.getState_code());
    localDriverExt.setParam(":VSTATE_CODE_DATE", paramDriverDao.getState_code_date());
    localDriverExt.setParam(":VOPER_DATE", "");
    localDriverExt.setParam(":VOPER_USER_ID", paramDriverDao.getOper_user_id());
    localDriverExt.setParam(":VREMARK", paramDriverDao.getRemark());
    this.tradeQuery.executeBy(localDriverExt.insBy("UPDATE_BY_ALL"));
    this.log.LOG_INFO(" addUserInfo successful !");
    return 0;
  }

  public ArrayList getDriverByCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    DriverExt localDriverExt = new DriverExt();
    localDriverExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localDriverExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getriverCountByCust(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    DriverExt localDriverExt = new DriverExt();
    localDriverExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localDriverExt.selByList("SEL_COUNT_BY_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public void delDriverInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delDriverInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("DRIVER_ID");
    try
    {
      DriverDao localDriverDao = new DriverDao();
      localDriverDao.setCust_id(str1);
      localDriverDao.setDriver_id(str2);
      i = delDriverInfo(localDriverDao);
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
    this.log.LOG_INFO("退出delDriverInfo方法...");
  }

  public int delDriverInfo(DriverDao paramDriverDao)
    throws SaasApplicationException
  {
    DriverExt localDriverExt = new DriverExt();
    localDriverExt.setParam(":VCUST_ID", paramDriverDao.getCust_id());
    localDriverExt.setParam(":VDRIVER_ID", paramDriverDao.getDriver_id());
    this.tradeQuery.executeBy(localDriverExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public HashMap getDriverById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    DriverExt localDriverExt = new DriverExt();
    localDriverExt.setParam(":VDRIVER_ID", paramString);
    ArrayList localArrayList = localDriverExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.driverMgr.DriversInfo
 * JD-Core Version:    0.6.0
 */