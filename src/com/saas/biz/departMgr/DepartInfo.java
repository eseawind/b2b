package com.saas.biz.departMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.custMgr.Custinfo;
import com.saas.biz.dao.departDAO.DepartDAO;
import com.saas.biz.dao.departDAO.DepartExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DepartInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
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

  public void addDepartInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addDepartInfo方法...");
    int i = -1;
    DepartDAO localDepartDAO = new DepartDAO();
    String str1 = paramBuffers.getString("DEPART_ID");
    String str2 = paramBuffers.getString("DEPART_NAME");
    String str3 = paramBuffers.getString("PARENT_DEPART_ID");
    String str4 = paramBuffers.getString("DEPART_LEVEL");
    String str5 = paramBuffers.getString("REMARK");
    localDepartDAO.setDepart_id(str1);
    localDepartDAO.setDepart_name(str2);
    localDepartDAO.setParent_depart_code(str3);
    localDepartDAO.setDepart_level(str4);
    localDepartDAO.setValidflag("0");
    localDepartDAO.setRemark(str5);
    i = addDepartInfo(localDepartDAO);
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
    this.log.LOG_INFO("退出addDepartInfo方法...");
  }

  public int addDepartInfo(DepartDAO paramDepartDAO)
  {
    DepartExt localDepartExt = new DepartExt();
    String str = this.commen.GenTradeId();
    localDepartExt.setParam(":VDEPART_CODE", str);
    localDepartExt.setParam(":VDEPART_ID", paramDepartDAO.getDepart_id());
    localDepartExt.setParam(":VDEPART_NAME", paramDepartDAO.getDepart_name());
    localDepartExt.setParam(":VPARENT_DEPART_CODE", paramDepartDAO.getParent_depart_code());
    localDepartExt.setParam(":VDEPART_LEVEL", paramDepartDAO.getDepart_level());
    localDepartExt.setParam(":VVALIDFLAG", paramDepartDAO.getValidflag());
    localDepartExt.setParam(":VREMARK", paramDepartDAO.getRemark());
    this.tradeQuery.executeBy(localDepartExt.insBy("INS_BY_DEPART"));
    return 0;
  }

  public void updateDepartInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addDepartInfo方法...");
    int i = -1;
    DepartDAO localDepartDAO = new DepartDAO();
    String str1 = paramBuffers.getString("DEPART_ID");
    String str2 = paramBuffers.getString("RSRV_STR1");
    String str3 = paramBuffers.getString("DEPART_NAME");
    String str4 = paramBuffers.getString("REMARK");
    localDepartDAO.setDepart_id(str1);
    localDepartDAO.setDepart_code(str3);
    localDepartDAO.setDepart_name(str2);
    localDepartDAO.setRemark(str4);
    i = updateDepartInfo(localDepartDAO);
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
    this.log.LOG_INFO("退出addDepartInfo方法...");
  }

  public int updateDepartInfo(DepartDAO paramDepartDAO)
  {
    DepartExt localDepartExt = new DepartExt();
    localDepartExt.setParam(":VDEPART_CODE", paramDepartDAO.getDepart_code());
    localDepartExt.setParam(":VDEPART_ID", paramDepartDAO.getDepart_id());
    localDepartExt.setParam(":VDEPART_NAME", paramDepartDAO.getDepart_name());
    localDepartExt.setParam(":VREMARK", paramDepartDAO.getRemark());
    this.tradeQuery.executeBy(localDepartExt.insBy("UPDATE_BY_DEPART"));
    return 0;
  }

  public void deleteDepartInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addDepartInfo方法...");
    int i = -1;
    DepartDAO localDepartDAO = new DepartDAO();
    String str1 = paramBuffers.getString("DEPART_NAME");
    String str2 = paramBuffers.getString("REMARK");
    localDepartDAO.setDepart_code(str1);
    localDepartDAO.setRemark(str2);
    i = deleteDepartInfo(localDepartDAO);
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
    this.log.LOG_INFO("退出addDepartInfo方法...");
  }

  public int deleteDepartInfo(DepartDAO paramDepartDAO)
  {
    DepartExt localDepartExt = new DepartExt();
    localDepartExt.setParam(":VDEPART_CODE", paramDepartDAO.getDepart_code());
    localDepartExt.setParam(":VREMARK", paramDepartDAO.getRemark());
    localDepartExt.setParam(":VVALIDFLAG", "1");
    this.tradeQuery.executeBy(localDepartExt.insBy("DELETE_BY_CODE"));
    return 0;
  }

  public Map getDepartByParentCode(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    DepartExt localDepartExt = new DepartExt();
    localDepartExt.setParam(":VPARENT_DEPART_CODE", paramString);
    localDepartExt.setParam(":VVALIDFLAG", "0");
    ArrayList localArrayList = localDepartExt.selByList("SEL_BY_PARENT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = "";
        String str2 = "";
        if (localHashMap2.get("depart_code") != null)
          str1 = localHashMap2.get("depart_code").toString();
        if (localHashMap2.get("depart_name") != null)
          str2 = localHashMap2.get("depart_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public Map getDepartByDepartCode(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    try
    {
      DepartExt localDepartExt = new DepartExt();
      localDepartExt.setParam(":VDEPART_CODE", paramString2);
      localDepartExt.setParam(":VVALIDFLAG", "0");
      localArrayList = localDepartExt.selByList("SEL_PARENT_CODE");
      Object localObject;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        for (int i = 0; i < localArrayList.size(); i++)
        {
          localObject = (HashMap)localArrayList.get(i);
          String str1 = "";
          String str2 = "";
          if (((HashMap)localObject).get("depart_code") != null)
            str1 = ((HashMap)localObject).get("depart_code").toString();
          if (((HashMap)localObject).get("depart_name") != null)
            str2 = ((HashMap)localObject).get("depart_name").toString();
          localHashMap.put(str1, str2);
        }
      }
      else
      {
        Custinfo localCustinfo = new Custinfo();
        localObject = localCustinfo.getCustNameById(paramString1);
        localHashMap.put(paramString1, localObject);
        this.log.LOG_INFO("departMap====");
      }
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return (Map)localHashMap;
  }

  public Map getDepartByDepartId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    try
    {
      DepartExt localDepartExt = new DepartExt();
      localDepartExt.setParam(":VDEPART_CODE", paramString);
      localDepartExt.setParam(":VVALIDFLAG", "0");
      localArrayList = localDepartExt.selByList("SEL_BY_CODE");
      if ((localArrayList != null) && (localArrayList.size() > 0))
        for (int i = 0; i < localArrayList.size(); i++)
        {
          HashMap localHashMap2 = (HashMap)localArrayList.get(i);
          String str1 = "";
          String str2 = "";
          String str3 = "";
          if (localHashMap2.get("depart_id") != null)
            str1 = localHashMap2.get("depart_id").toString();
          if (localHashMap2.get("depart_name") != null)
            str2 = localHashMap2.get("depart_name").toString();
          if (localHashMap2.get("remark") != null)
            str3 = localHashMap2.get("remark").toString();
          localHashMap1.put("depart_id", str1);
          localHashMap1.put("depart_name", str2);
          localHashMap1.put("remark", str3);
        }
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return localHashMap1;
  }

  public String checkHasChildren(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = (HashMap)getDepartByParentCode(paramString);
    String str = "0";
    if ((localHashMap != null) && (localHashMap.size() > 0))
      str = "1";
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.departMgr.DepartInfo
 * JD-Core Version:    0.6.0
 */