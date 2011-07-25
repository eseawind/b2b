package com.saas.biz.rightMgr;

import com.saas.biz.dao.rightsDAO.RightinfoDAO;
import com.saas.biz.dao.rightsDAO.RightinfoExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class RightInfo
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

  public void addRightInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入addRightInfo方法...");
    int i = -1;
    try
    {
      String str1 = "";
      String str2 = "";
      Calendar localCalendar = Calendar.getInstance();
      str1 = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime()).toString();
      localCalendar.add(1, 50);
      str2 = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime()).toString();
      String str3 = paramBuffers.getString("CLASS_CODE");
      String str4 = paramBuffers.getString("MENU_ID");
      RightinfoDAO localRightinfoDAO = new RightinfoDAO();
      localRightinfoDAO.setCustClass(str3);
      localRightinfoDAO.setMenuId(str4);
      localRightinfoDAO.setStartDate(str1);
      localRightinfoDAO.setInDate(str1);
      localRightinfoDAO.setEndDate(str2);
      i = addRightInfo(localRightinfoDAO);
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
    this.log.LOG_INFO("退出addRightInfo方法...");
  }

  public int addRightInfo(RightinfoDAO paramRightinfoDAO)
    throws SaasApplicationException
  {
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VCUST_CLASS", paramRightinfoDAO.getCustClass());
    localRightinfoExt.setParam(":VMENU_ID", paramRightinfoDAO.getMenuId());
    localRightinfoExt.setParam(":VSTART_DATE", paramRightinfoDAO.getStartDate());
    localRightinfoExt.setParam(":VEND_DATE", paramRightinfoDAO.getEndDate());
    localRightinfoExt.setParam(":VIN_DATE", paramRightinfoDAO.getInDate());
    this.tradeQuery.executeBy(localRightinfoExt.insBy("DEL_BY_ONE"));
    this.tradeQuery.executeBy(localRightinfoExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void deleteRight(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteRight方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CLASS_CODE");
      String str2 = paramBuffers.getString("MENU_ID");
      i = deleteRightInfo(str2, str1);
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
    this.log.LOG_INFO("退出deleteRight方法...");
  }

  public void deleteRightInfoByMenuIdx(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteRightInfoByMenuIdx方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("CLASS_CODE");
      String str2 = paramBuffers.getString("MENU_ID");
      i = deleteRightInfo(str2, str1);
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
    this.log.LOG_INFO("退出deleteRightInfoByMenuIdx方法...");
  }

  public int deleteRightInfoByIdx(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入deleteRightInfoByIdx方法.......");
    try
    {
      RightinfoExt localRightinfoExt = new RightinfoExt();
      localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
      localRightinfoExt.setParam(":VMENU_ID", paramString1);
      this.tradeQuery.executeBy(localRightinfoExt.insBy("DEL_BY_ONE"));
      this.log.LOG_INFO("开始删除菜单.......");
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO("删除菜单权限出错......");
      return -1;
    }
    this.log.LOG_INFO("退出deleteRightInfoByIdx方法.......");
    return 0;
  }

  public ArrayList getRightInfoByMenuId(String paramString)
    throws SaasApplicationException
  {
    RightinfoExt localRightinfoExt = new RightinfoExt();
    ArrayList localArrayList = new ArrayList();
    localRightinfoExt.setParam(":VMENU_ID", paramString);
    try
    {
      localArrayList = localRightinfoExt.selByList("SEL_BY_MENUIDX");
    }
    catch (Exception localException)
    {
      return null;
    }
    return localArrayList;
  }

  private int deleteRightInfo(String paramString1, String paramString2)
  {
    this.log.LOG_INFO("进入deleteRightInfo方法.......");
    try
    {
      deleteRightInfoByIdx(paramString1, paramString2);
      this.log.LOG_INFO("删除" + paramString1 + "=====" + paramString2 + "成功.......");
      ArrayList localArrayList = getDownMenuByUP(paramString1, paramString2);
      if ((localArrayList != null) && (localArrayList.size() > 0))
        for (int i = 0; i < localArrayList.size(); i++)
        {
          HashMap localHashMap = (HashMap)localArrayList.get(i);
          String str1 = localHashMap.get("menu_id").toString();
          String str2 = localHashMap.get("cust_class").toString();
          deleteRightInfo(str1, str2);
        }
    }
    catch (Exception localException)
    {
      return -1;
    }
    return 0;
  }

  public ArrayList getDownMenuByUP(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入获取下级菜单........");
    RightinfoExt localRightinfoExt = new RightinfoExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
      localRightinfoExt.setParam(":VMENU_ID", paramString1);
      localArrayList = localRightinfoExt.selByList("SEL_MENUDOWN_BY_UP");
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO("获取下级菜单失败........");
      return null;
    }
    this.log.LOG_INFO("退出获取下级菜单........" + localArrayList);
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.rightMgr.RightInfo
 * JD-Core Version:    0.6.0
 */