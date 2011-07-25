package com.saas.biz.userrightMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.rightsDAO.MenuinfoExt;
import com.saas.biz.dao.rightsDAO.RightinfoExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class UserrightMgr
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

  public void addMenuRight(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addMenuRight方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_USER_ID");
      String str2 = paramBuffers.getString("MENU_ID");
      String str3 = paramBuffers.getString("CLASS_CODE");
      String str4 = paramBuffers.getString("MENU_CLASS");
      i = addMenuRight(str2, str3, str1, str4);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i == -1)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "该菜单已经分配！");
    }
    else if (i == -2)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "上级菜单没有分配，请先分配！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addMenuRight方法...");
  }

  public int addMenuRight(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    RightinfoExt localRightinfoExt = new RightinfoExt();
    int i = 0;
    if (paramString4.equals("1"))
    {
      i = checkExitMenu(paramString1, paramString2);
    }
    else
    {
      i = checkMenuRight(paramString1, paramString2);
      if (i == 0)
        i = checkExitMenu(paramString1, paramString2);
    }
    if (i == 0)
    {
      localRightinfoExt.setParam(":VMENU_ID", paramString1);
      localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
      localRightinfoExt.setParam(":VIN_STAFF_ID", paramString3);
      localRightinfoExt.setParam(":VREMARK", "");
      this.tradeQuery.executeBy(localRightinfoExt.insBy("INS_BY_ALL"));
    }
    return i;
  }

  public int checkExitMenu(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VMENU_ID", paramString1);
    localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
    localArrayList = localRightinfoExt.selByList("SEL_BY_MENU");
    if (localArrayList == null)
      return 0;
    return -1;
  }

  public int checkMenuRight(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    int i = -1;
    String str = "";
    localMenuinfoExt.setParam(":VMENU_ID", paramString1);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_PK");
    Iterator localIterator = localArrayList.iterator();
    HashMap localHashMap = (HashMap)localIterator.next();
    if (localHashMap.get("up_menu_id") != null)
      str = localHashMap.get("up_menu_id").toString();
    i = checkExitMenu(str, paramString2);
    if (i == 0)
      i = -2;
    else
      i = 0;
    return i;
  }

  public ArrayList genUserMenu(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入genUserMenu方法．．．．．．．．．．．．．");
    ArrayList localArrayList = new ArrayList();
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VMENU_CLASS", paramString1);
    localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
    localArrayList = localRightinfoExt.selByList("SEL_BY_CLASS");
    this.log.LOG_INFO("退出genUserMenu方法．．．．．．．．．．．．．");
    return localArrayList;
  }

  public ArrayList genDownUserMenu(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入genDownUserMenu方法．．．．．．．．．．．．．");
    ArrayList localArrayList = new ArrayList();
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VUP_MENU_ID", paramString1);
    localRightinfoExt.setParam(":VMENU_CLASS", paramString2);
    localRightinfoExt.setParam(":VCUST_CLASS", paramString3);
    localArrayList = localRightinfoExt.selByList("SEL_BY_CLASSDOWN");
    this.log.LOG_INFO("退出genDownUserMenu方法．．．．．．．．．．．．．");
    return localArrayList;
  }

  public void callBackRights(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入callBackRights方法...");
    int i = -1;
    String str1 = paramBuffers.getString("MENU_ID");
    String str2 = paramBuffers.getString("CLASS_CODE");
    String str3 = paramBuffers.getString("MENU_CLASS");
    try
    {
      i = callBackRights(str1, str3, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i == -1)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败,请先将下级菜单权限删除！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出callBackRights方法...");
  }

  public int callBackRights(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = new Integer(paramString2).intValue();
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    if (i < 4)
    {
      RightinfoExt localRightinfoExt = new RightinfoExt();
      localRightinfoExt.setParam(":VUP_MENU_ID", paramString1);
      localRightinfoExt.setParam(":VMENU_CLASS", paramString2);
      localRightinfoExt.setParam(":VCUST_CLASS", paramString3);
      localArrayList = localRightinfoExt.selByList("SEL_BY_CLASSDOWN");
      if (localArrayList == null)
        j = delRights(paramString1, paramString3);
      else
        return -1;
    }
    else
    {
      j = delRights(paramString1, paramString3);
    }
    return j;
  }

  public int delRights(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VMENU_ID", paramString1);
    localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
    this.tradeQuery.executeBy(localRightinfoExt.insBy("DEL_BY_ONE"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.userrightMgr.UserrightMgr
 * JD-Core Version:    0.6.0
 */