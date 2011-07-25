package com.saas.biz.levelMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.levelDAO.LevelDAO;
import com.saas.biz.dao.levelDAO.LevelExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class LevelInfo
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

  public void addLevelInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addLevelInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ENTITY_TYPE");
    String str3 = paramBuffers.getString("LEVEL_CODE");
    String str4 = paramBuffers.getString("LEVEL_NAME");
    String str5 = paramBuffers.getString("START_DATE");
    String str6 = paramBuffers.getString("END_DATE");
    String str7 = paramBuffers.getString("SESSION_USER_ID");
    String str8 = paramBuffers.getString("REMARK");
    try
    {
      LevelDAO localLevelDAO = new LevelDAO();
      localLevelDAO.setCust_id(str1);
      localLevelDAO.setLevel_name(str4);
      localLevelDAO.setEntity_type(str2);
      localLevelDAO.setLevel_code(str3);
      localLevelDAO.setStart_date(str5);
      localLevelDAO.setEnd_date(str6);
      localLevelDAO.setRemark(str8);
      localLevelDAO.setOper_user_id(str7);
      i = addLevelInfo(localLevelDAO);
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
    this.log.LOG_INFO("退出addLevelInfo方法...");
  }

  public int addLevelInfo(LevelDAO paramLevelDAO)
    throws SaasApplicationException
  {
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramLevelDAO.getCust_id());
    localLevelExt.setParam(":VLEVEL_NAME", paramLevelDAO.getLevel_name());
    localLevelExt.setParam(":VENTITY_TYPE", paramLevelDAO.getEntity_type());
    localLevelExt.setParam(":VLEVEL_CODE", paramLevelDAO.getLevel_code());
    localLevelExt.setParam(":VSTART_DATE", paramLevelDAO.getStart_date());
    localLevelExt.setParam(":VEND_DATE", paramLevelDAO.getEnd_date());
    localLevelExt.setParam(":VREMARK", paramLevelDAO.getRemark());
    localLevelExt.setParam(":VOPER_USER_ID", paramLevelDAO.getOper_user_id());
    this.tradeQuery.executeBy(localLevelExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateLevelInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateLevelInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ENTITY_TYPE");
    String str3 = paramBuffers.getString("LEVEL_CODE");
    String str4 = paramBuffers.getString("LEVEL_NAME");
    String str5 = paramBuffers.getString("START_DATE");
    String str6 = paramBuffers.getString("END_DATE");
    String str7 = paramBuffers.getString("SESSION_USER_ID");
    String str8 = paramBuffers.getString("REMARK");
    try
    {
      LevelDAO localLevelDAO = new LevelDAO();
      localLevelDAO.setCust_id(str1);
      localLevelDAO.setLevel_name(str4);
      localLevelDAO.setEntity_type(str2);
      localLevelDAO.setLevel_code(str3);
      localLevelDAO.setStart_date(str5);
      localLevelDAO.setEnd_date(str6);
      localLevelDAO.setRemark(str8);
      localLevelDAO.setOper_user_id(str7);
      i = updateLevelInfo(localLevelDAO);
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
    this.log.LOG_INFO("退出updateLevelInfo方法...");
  }

  public int updateLevelInfo(LevelDAO paramLevelDAO)
    throws SaasApplicationException
  {
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramLevelDAO.getCust_id());
    localLevelExt.setParam(":VLEVEL_NAME", paramLevelDAO.getLevel_name());
    localLevelExt.setParam(":VENTITY_TYPE", paramLevelDAO.getEntity_type());
    localLevelExt.setParam(":VLEVEL_CODE", paramLevelDAO.getLevel_code());
    localLevelExt.setParam(":VSTART_DATE", paramLevelDAO.getStart_date());
    localLevelExt.setParam(":VEND_DATE", paramLevelDAO.getEnd_date());
    localLevelExt.setParam(":VREMARK", paramLevelDAO.getRemark());
    localLevelExt.setParam(":VOPER_USER_ID", paramLevelDAO.getOper_user_id());
    this.tradeQuery.executeBy(localLevelExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public void delLevelInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delLevelInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("LEVEL_CODE");
    try
    {
      i = delLevelInfo(str1, str2);
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
    this.log.LOG_INFO("退出delLevelInfo方法...");
  }

  public int delLevelInfo(String paramString1, String paramString2)
  {
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramString1);
    localLevelExt.setParam(":VLEVEL_CODE", paramString2);
    this.tradeQuery.executeBy(localLevelExt.insBy("DEL_BY_CUST"));
    return 0;
  }

  public ArrayList getLevelInfoByCust_id(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLevelExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getLevelInfoByCust_id(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLevelExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public int getLevelCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramString);
    localArrayList = localLevelExt.selByList("SEL_BY_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getLevelByEnitity(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramString1);
    localLevelExt.setParam(":VENTITY_TYPE", paramString2);
    localArrayList = localLevelExt.selByList("SEL_BY_ENTITY");
    return localArrayList;
  }

  public ArrayList getLevelByLevelName(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramString1);
    localLevelExt.setParam(":VLEVEL_NAME", paramString2);
    localArrayList = localLevelExt.selByList("SEL_BY_NAME");
    return localArrayList;
  }

  public ArrayList getLevelInfoByCode(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramString1);
    localLevelExt.setParam(":VLEVEL_CODE", paramString2);
    localArrayList = localLevelExt.selByList("SEL_BY_CODE");
    return localArrayList;
  }

  public ArrayList getLevelListByCustEntity(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramString1);
    localLevelExt.setParam(":VENTITY_TYPE", paramString2);
    localArrayList = localLevelExt.selByList("SEL_BY_ENTITY");
    return localArrayList;
  }

  public ArrayList getOppLevelByCustEntity(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    LevelExt localLevelExt = new LevelExt();
    localLevelExt.setParam(":VCUST_ID", paramString1);
    localLevelExt.setParam(":VENTITY_TYPE", "2");
    localArrayList = localLevelExt.selByList("SEL_BY_ENTITY");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.levelMgr.LevelInfo
 * JD-Core Version:    0.6.0
 */