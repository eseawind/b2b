package com.saas.biz.roleMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.roleDAO.RoleDAO;
import com.saas.biz.dao.roleDAO.RoleExt;
import com.saas.biz.dao.userDAO.UserExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class RoleInfo
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

  public void addRoleInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addRoleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ROLE_NAME");
    String str3 = paramBuffers.getString("ROLE_CODE");
    String str4 = paramBuffers.getString("ROLE_TYPE");
    String str5 = paramBuffers.getString("ENABLE_TAG");
    String str6 = paramBuffers.getString("REMARK");
    RoleDAO localRoleDAO = new RoleDAO();
    localRoleDAO.setCust_id(str1);
    localRoleDAO.setRole_name(str2);
    localRoleDAO.setEnable_tag(str5);
    localRoleDAO.setRole_type(str4);
    localRoleDAO.setRole_code(str3);
    localRoleDAO.setRemark(str6);
    try
    {
      i = addRoleInfo(localRoleDAO);
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
    this.log.LOG_INFO("退出addRoleInfo方法...");
  }

  public int addRoleInfo(RoleDAO paramRoleDAO)
    throws SaasApplicationException
  {
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramRoleDAO.getCust_id());
    localRoleExt.setParam(":VROLE_NAME", paramRoleDAO.getRole_name());
    localRoleExt.setParam(":VENABLE_TAG", paramRoleDAO.getEnable_tag());
    localRoleExt.setParam(":VROLE_TYPE", paramRoleDAO.getRole_type());
    localRoleExt.setParam(":VROLE_CODE", paramRoleDAO.getRole_code());
    localRoleExt.setParam(":VREMARK", paramRoleDAO.getRemark());
    this.tradeQuery.executeBy(localRoleExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateRoleInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateRoleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ROLE_NAME");
    String str3 = paramBuffers.getString("ROLE_CODE");
    String str4 = paramBuffers.getString("ROLE_TYPE");
    String str5 = paramBuffers.getString("ENABLE_TAG");
    String str6 = paramBuffers.getString("REMARK");
    RoleDAO localRoleDAO = new RoleDAO();
    localRoleDAO.setCust_id(str1);
    localRoleDAO.setRole_name(str2);
    localRoleDAO.setEnable_tag(str5);
    localRoleDAO.setRole_type(str4);
    localRoleDAO.setRole_code(str3);
    localRoleDAO.setRemark(str6);
    try
    {
      i = updateRoleInfo(localRoleDAO);
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
    this.log.LOG_INFO("退出addRoleInfo方法...");
  }

  public int updateRoleInfo(RoleDAO paramRoleDAO)
    throws SaasApplicationException
  {
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramRoleDAO.getCust_id());
    localRoleExt.setParam(":VROLE_NAME", paramRoleDAO.getRole_name());
    localRoleExt.setParam(":VENABLE_TAG", paramRoleDAO.getEnable_tag());
    localRoleExt.setParam(":VROLE_TYPE", paramRoleDAO.getRole_type());
    localRoleExt.setParam(":VROLE_CODE", paramRoleDAO.getRole_code());
    localRoleExt.setParam(":VREMARK", paramRoleDAO.getRemark());
    this.tradeQuery.executeBy(localRoleExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public void delRoleInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delRoleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ROLE_CODE");
    try
    {
      i = delRoleInfo(str1, str2);
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
    this.log.LOG_INFO("退出delRoleInfo方法...");
  }

  public int delRoleInfo(String paramString1, String paramString2)
  {
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramString1);
    localRoleExt.setParam(":VROLE_CODE", paramString2);
    this.tradeQuery.executeBy(localRoleExt.insBy("DEL_BY_CUST"));
    return 0;
  }

  public ArrayList getRoleAll(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    ArrayList localArrayList = new ArrayList();
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramString);
    localArrayList = localRoleExt.selByList("SEL_ROLE_BY_ALL", paramInt, 20);
    return localArrayList;
  }

  public int getRoleAll(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramString);
    localArrayList = localRoleExt.selByList("SEL_ROLE_BY_ALL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public int ifRoleName(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramString2);
    localRoleExt.setParam(":VROLE_NAME", paramString1);
    localArrayList = localRoleExt.selByList("SEL_ROLE_IF");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 0;
    return 1;
  }

  public ArrayList getRoleInfoByCust_id(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramString);
    localRoleExt.setParam(":VENABLE_TAG", "0");
    localArrayList = localRoleExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getRoleCount(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramString1);
    localRoleExt.setParam(":VENABLE_TAG", paramString2);
    localArrayList = localRoleExt.selByList("SEL_BY_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getRoleInfoByCode(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramString1);
    localRoleExt.setParam(":VROLE_CODE", paramString2);
    localArrayList = localRoleExt.selByList("SEL_BY_CODE");
    return localArrayList;
  }

  public String getRoleInfoByRuleCode(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VROLE_CODE", paramString);
    localArrayList = localRoleExt.selByList("SEL_BY_RULE_CODE");
    String str = "";
    if (null != localArrayList)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("role_name") != null)
        str = localHashMap.get("role_name").toString();
    }
    return str;
  }

  public ArrayList getRoleInfoByCustId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramString);
    localRoleExt.setParam(":VENABLE_TAG", "0");
    localArrayList = localRoleExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList getRoleInfoByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleExt localRoleExt = new RoleExt();
    localRoleExt.setParam(":VCUST_ID", paramString1);
    localRoleExt.setParam(":VROLE_TYPE", paramString2);
    localArrayList = localRoleExt.selByList("SEL_BY_TYPE");
    this.log.LOG_INFO("cust_id==" + paramString1 + "==role_type==" + paramString2);
    return localArrayList;
  }

  public String getRoleNameById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getRoleInfoByCode(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      str = localHashMap.get("role_name").toString();
    }
    this.log.LOG_INFO("cust_id=" + paramString1 + "==role_code=" + paramString2);
    return str;
  }

  public String getRoleSelectByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "<option value=n>未设置角色</option>";
    ArrayList localArrayList = getRoleInfoByType(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      str1 = "";
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("role_name").toString();
        String str3 = localHashMap.get("role_code").toString();
        str1 = str1 + "<option value=" + str3 + ">" + str2 + "</option>";
      }
    }
    return str1;
  }

  public String getRoleNameByUser_id(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "未分配任何角色";
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VUSER_ID", paramString2);
    ArrayList localArrayList = localUserExt.selByList("SEL_BY_ONE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      String str2 = "";
      if (localHashMap.get("rsrv_str3") != null)
        str2 = localHashMap.get("rsrv_str3").toString();
      str1 = getRoleNameById(paramString1, str2);
    }
    return str1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.roleMgr.RoleInfo
 * JD-Core Version:    0.6.0
 */