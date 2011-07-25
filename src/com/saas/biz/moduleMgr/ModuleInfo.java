package com.saas.biz.moduleMgr;

import com.saas.biz.dao.moduleDAO.ModuleDAO;
import com.saas.biz.dao.moduleDAO.ModuleExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class ModuleInfo
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

  public void addModuleInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addNewsInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    ModuleDAO localModuleDAO = new ModuleDAO();
    localModuleDAO.setModule_id(paramBuffers.getString("MODULE_ID"));
    localModuleDAO.setModule_name(paramBuffers.getString("MODULE_NAME"));
    localModuleDAO.setModule_file(paramBuffers.getString("MODULE_FILE"));
    localModuleDAO.setModule_dir(paramBuffers.getString("MODULE_DIR"));
    localModuleDAO.setModule_type(paramBuffers.getString("MODULE_TYPE"));
    try
    {
      i = addModuleInfo(localModuleDAO);
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
    this.log.LOG_INFO("退出addNewsInfo方法...");
  }

  public int addModuleInfo(ModuleDAO paramModuleDAO)
    throws SaasApplicationException
  {
    ModuleExt localModuleExt = new ModuleExt();
    localModuleExt.setParam(":VMODULE_ID", paramModuleDAO.getModule_id());
    localModuleExt.setParam(":VMODULE_NAME", paramModuleDAO.getModule_name());
    localModuleExt.setParam(":VMODULE_FILE", paramModuleDAO.getModule_file());
    localModuleExt.setParam(":VMODULE_DIR", paramModuleDAO.getModule_dir());
    localModuleExt.setParam(":VMODULE_TYPE", paramModuleDAO.getModule_type());
    localModuleExt.setParam(":VRSRV_STR1", "");
    localModuleExt.setParam(":VRSRV_STR2", "");
    localModuleExt.setParam(":VRSRV_STR3", "");
    localModuleExt.setParam(":VRSRV_STR4", "");
    localModuleExt.setParam(":VRSRV_STR5", "");
    localModuleExt.setParam(":VRSRV_STR6", "");
    localModuleExt.setParam(":VRSRV_STR7", "");
    localModuleExt.setParam(":VRSRV_STR8", "");
    localModuleExt.setParam(":VRSRV_STR9", "");
    localModuleExt.setParam(":VRSRV_STR0", "");
    localModuleExt.setParam(":VIN_STAFF_ID", "");
    localModuleExt.setParam(":VIN_DATE", "");
    localModuleExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localModuleExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void delmoduleinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delnewsinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("MODULE_ID");
    try
    {
      i = delmoduleinfo(str);
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
    this.log.LOG_INFO("退出delnewsinfo方法...");
  }

  public int delmoduleinfo(String paramString)
    throws SaasApplicationException
  {
    ModuleExt localModuleExt = new ModuleExt();
    localModuleExt.setParam(":VMODULE_ID", paramString);
    this.tradeQuery.executeBy(localModuleExt.insBy("DEL_BY_ONE"));
    return 0;
  }

  public int getNewsSearch(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ModuleExt localModuleExt = new ModuleExt();
    localModuleExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localModuleExt.selByList("SEL_BY_KEYS");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public void addModuleInfos(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addModuleInfos方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    ModuleDAO localModuleDAO = new ModuleDAO();
    localModuleDAO.setModule_id(paramBuffers.getString("MODULE_ID"));
    localModuleDAO.setModule_name(paramBuffers.getString("MODULE_NAME"));
    localModuleDAO.setModule_file(paramBuffers.getString("MODULE_FILE"));
    localModuleDAO.setModule_dir(paramBuffers.getString("MODULE_DIR"));
    localModuleDAO.setModule_type(paramBuffers.getString("MODULE_TYPE"));
    localModuleDAO.setRsrv_str1(paramBuffers.getString("RSRV_STR1"));
    localModuleDAO.setRsrv_str2(paramBuffers.getString("RSRV_STR2"));
    localModuleDAO.setRsrv_str3(paramBuffers.getString("RSRV_STR3"));
    localModuleDAO.setRsrv_str4(paramBuffers.getString("RSRV_STR4"));
    localModuleDAO.setRsrv_str5(paramBuffers.getString("RSRV_STR5"));
    localModuleDAO.setRsrv_str6(paramBuffers.getString("RSRV_STR6"));
    localModuleDAO.setRsrv_str7(paramBuffers.getString("RSRV_STR7"));
    localModuleDAO.setRsrv_str8(paramBuffers.getString("RSRV_STR8"));
    localModuleDAO.setRsrv_str9(paramBuffers.getString("RSRV_STR9"));
    localModuleDAO.setRsrv_str0(paramBuffers.getString("RSRV_STR0"));
    localModuleDAO.setIn_staff_id(paramBuffers.getString("IN_STAFF_ID"));
    localModuleDAO.setRemark(paramBuffers.getString("REMARK"));
    try
    {
      i = addModuleInfos(localModuleDAO);
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
    this.log.LOG_INFO("退出addModuleInfos方法...");
  }

  public int addModuleInfos(ModuleDAO paramModuleDAO)
    throws SaasApplicationException
  {
    ModuleExt localModuleExt = new ModuleExt();
    String str = paramModuleDAO.getModule_id();
    localModuleExt.setParam(":VMODULE_ID", paramModuleDAO.getModule_id());
    localModuleExt.setParam(":VMODULE_NAME", paramModuleDAO.getModule_name());
    localModuleExt.setParam(":VMODULE_FILE", paramModuleDAO.getModule_file());
    localModuleExt.setParam(":VMODULE_DIR", paramModuleDAO.getModule_dir());
    localModuleExt.setParam(":VMODULE_TYPE", paramModuleDAO.getModule_type());
    localModuleExt.setParam(":VRSRV_STR1", paramModuleDAO.getRsrv_str1());
    localModuleExt.setParam(":VRSRV_STR2", paramModuleDAO.getRsrv_str2());
    localModuleExt.setParam(":VRSRV_STR3", paramModuleDAO.getRsrv_str3());
    localModuleExt.setParam(":VRSRV_STR4", paramModuleDAO.getRsrv_str4());
    localModuleExt.setParam(":VRSRV_STR5", paramModuleDAO.getRsrv_str5());
    localModuleExt.setParam(":VRSRV_STR6", paramModuleDAO.getRsrv_str6());
    localModuleExt.setParam(":VRSRV_STR7", paramModuleDAO.getRsrv_str7());
    localModuleExt.setParam(":VRSRV_STR8", paramModuleDAO.getRsrv_str8());
    localModuleExt.setParam(":VRSRV_STR9", paramModuleDAO.getRsrv_str9());
    localModuleExt.setParam(":VRSRV_STR0", paramModuleDAO.getRsrv_str0());
    localModuleExt.setParam(":VIN_STAFF_ID", paramModuleDAO.getIn_staff_id());
    localModuleExt.setParam(":VREMARK", paramModuleDAO.getRemark());
    if (checkright(str) == 0)
      this.tradeQuery.executeBy(localModuleExt.insBy("INS_MOD_BY_ALL"));
    else
      this.tradeQuery.executeBy(localModuleExt.insBy("UPDATE_MOD_BY_ALL"));
    return 0;
  }

  public int checkright(String paramString)
    throws SaasApplicationException
  {
    ModuleExt localModuleExt = new ModuleExt();
    ArrayList localArrayList = new ArrayList();
    localModuleExt.setParam(":VMODULE_ID", paramString);
    localArrayList = localModuleExt.selByList("SEL_BY_PK");
    if (localArrayList == null)
      return 0;
    return 1;
  }

  public ArrayList getModuleInfo(String paramString)
    throws SaasApplicationException
  {
    ModuleExt localModuleExt = new ModuleExt();
    ArrayList localArrayList = new ArrayList();
    localModuleExt.setParam(":VMODULE_ID", paramString);
    localArrayList = localModuleExt.selByList("SEL_BY_PK");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.moduleMgr.ModuleInfo
 * JD-Core Version:    0.6.0
 */