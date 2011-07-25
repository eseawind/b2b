package com.saas.biz.rolerightMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.rolerightDAO.RoleRightDAO;
import com.saas.biz.dao.rolerightDAO.RoleRightExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class RolerightInfo
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

  public void addRightInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addRightInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SESSION_USER_ID");
    String str3 = paramBuffers.getString("ROLE_CODE");
    String str4 = paramBuffers.getString("MENU_ID");
    String str5 = paramBuffers.getString("START_DATE");
    String str6 = paramBuffers.getString("END_DATE");
    String str7 = paramBuffers.getString("REMARK");
    String str8 = paramBuffers.getString("RSRV_STR1");
    String str9 = paramBuffers.getString("RSRV_STR2");
    String str10 = paramBuffers.getString("RSRV_STR3");
    try
    {
      RoleRightDAO localRoleRightDAO = new RoleRightDAO();
      localRoleRightDAO.setCust_id(str1);
      localRoleRightDAO.setEnd_date(str6);
      localRoleRightDAO.setMenu_id(str4);
      localRoleRightDAO.setOper_user_id(str2);
      localRoleRightDAO.setRole_code(str3);
      localRoleRightDAO.setStart_date(str5);
      localRoleRightDAO.setRemark(str7);
      i = addRightInfo(localRoleRightDAO, str8, str9, str10);
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
    else if (i == -2)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "该菜单已经分配，业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addRightInfo方法...");
  }

  public int addRightInfo(RoleRightDAO paramRoleRightDAO, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = paramRoleRightDAO.getMenu_id();
    String str2 = paramRoleRightDAO.getCust_id();
    String str3 = paramRoleRightDAO.getRole_code();
    ArrayList localArrayList = getRoleRightByMenuId(str2, str3, str1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return -2;
    if ((str1 == paramString1) || (paramString1.equals(str1)))
    {
      addRoleRightInfo(paramRoleRightDAO);
    }
    else
    {
      Object localObject;
      if ((str1 == paramString2) || (paramString2.equals(str1)))
      {
        localArrayList = getRoleRightByMenuId(str2, str3, paramString1);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          addRoleRightInfo(paramRoleRightDAO);
        }
        else
        {
          addRoleRightInfo(paramRoleRightDAO);
          localObject = paramRoleRightDAO;
          ((RoleRightDAO)localObject).setMenu_id(paramString2);
          addRoleRightInfo((RoleRightDAO)localObject);
        }
      }
      else if ((str1 == paramString3) || (paramString3.equals(str1)))
      {
        localArrayList = getRoleRightByMenuId(str2, str3, paramString1);
        RoleRightDAO localRoleRightDAO1;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          localObject = getRoleRightByMenuId(str2, str3, paramString2);
          if ((localObject != null) && (((ArrayList)localObject).size() > 0))
          {
            addRoleRightInfo(paramRoleRightDAO);
          }
          else
          {
            localRoleRightDAO1 = paramRoleRightDAO;
            localRoleRightDAO1.setMenu_id(paramString2);
            addRoleRightInfo(paramRoleRightDAO);
            addRoleRightInfo(localRoleRightDAO1);
          }
        }
        else
        {
          localObject = getRoleRightByMenuId(str2, str3, paramString2);
          if ((localObject != null) && (((ArrayList)localObject).size() > 0))
          {
            addRoleRightInfo(paramRoleRightDAO);
            localRoleRightDAO1 = paramRoleRightDAO;
            localRoleRightDAO1.setMenu_id(paramString1);
            addRoleRightInfo(localRoleRightDAO1);
          }
          else
          {
            localRoleRightDAO1 = paramRoleRightDAO;
            localRoleRightDAO1.setMenu_id(paramString1);
            addRoleRightInfo(localRoleRightDAO1);
            RoleRightDAO localRoleRightDAO2 = paramRoleRightDAO;
            localRoleRightDAO2.setMenu_id(paramString2);
            addRoleRightInfo(localRoleRightDAO2);
            paramRoleRightDAO.setMenu_id(paramString3);
            addRoleRightInfo(paramRoleRightDAO);
          }
        }
      }
    }
    return 0;
  }

  public int addRoleRightInfo(RoleRightDAO paramRoleRightDAO)
  {
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramRoleRightDAO.getCust_id());
    localRoleRightExt.setParam(":VROLE_CODE", paramRoleRightDAO.getRole_code());
    localRoleRightExt.setParam(":VMENU_ID", paramRoleRightDAO.getMenu_id());
    localRoleRightExt.setParam(":VSTART_DATE", paramRoleRightDAO.getStart_date());
    localRoleRightExt.setParam(":VEND_DATE", paramRoleRightDAO.getEnd_date());
    localRoleRightExt.setParam(":VOPER_USER_ID", paramRoleRightDAO.getOper_user_id());
    localRoleRightExt.setParam(":VREMARK", paramRoleRightDAO.getRemark());
    this.tradeQuery.executeBy(localRoleRightExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void deleteRightInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteRightInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ROLE_CODE");
    String str3 = paramBuffers.getString("MENU_ID");
    try
    {
      RoleRightDAO localRoleRightDAO = new RoleRightDAO();
      localRoleRightDAO.setCust_id(str1);
      localRoleRightDAO.setMenu_id(str3);
      localRoleRightDAO.setRole_code(str2);
      i = deleteRightInfo(localRoleRightDAO);
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
    this.log.LOG_INFO("退出deleteRightInfo方法...");
  }

  public int deleteRightInfo(RoleRightDAO paramRoleRightDAO)
  {
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramRoleRightDAO.getCust_id());
    localRoleRightExt.setParam(":VROLE_CODE", paramRoleRightDAO.getRole_code());
    localRoleRightExt.setParam(":VMENU_ID", paramRoleRightDAO.getMenu_id());
    this.tradeQuery.executeBy(localRoleRightExt.insBy("DEL_BY_CODE"));
    return 0;
  }

  public ArrayList getRoleRightInfoByRole(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramString1);
    localRoleRightExt.setParam(":VROLE_CODE", paramString2);
    localArrayList = localRoleRightExt.selByList("DEL_BY_ROLE");
    return localArrayList;
  }

  public ArrayList getRoleRightByMenuId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramString1);
    localRoleRightExt.setParam(":VROLE_CODE", paramString2);
    localRoleRightExt.setParam(":VMENU_ID", paramString3);
    localArrayList = localRoleRightExt.selByList("SEL_BY_MENU");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.rolerightMgr.RolerightInfo
 * JD-Core Version:    0.6.0
 */