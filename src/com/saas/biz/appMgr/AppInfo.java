package com.saas.biz.appMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.aPPDAO.AppExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class AppInfo
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

  public void addAppInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addAppInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("APP_ID");
    String str4 = paramBuffers.getString("APP_NO");
    String str5 = paramBuffers.getString("GOODS_ID");
    String str6 = paramBuffers.getString("RESOURCE_ID");
    String str7 = paramBuffers.getString("AIM_ID");
    String str8 = paramBuffers.getString("OBJ_USER_ID");
    String str9 = paramBuffers.getString("OBJ_USER_NAME");
    String str10 = paramBuffers.getString("APP_TYPE");
    String str11 = paramBuffers.getString("APP_DATE");
    String str12 = paramBuffers.getString("STATE_CODE");
    String str13 = paramBuffers.getString("STATE_CODE_DATE");
    String str14 = paramBuffers.getString("SESSION_USER_ID");
    String str15 = paramBuffers.getString("PUBLISH_DATE");
    String str16 = paramBuffers.getString("REMARK");
    try
    {
      i = addAppInfo(str2, str1, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
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
    this.log.LOG_INFO("退出addAppInfo方法...");
  }

  public int addAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16)
    throws SaasApplicationException
  {
    AppExt localAppExt = new AppExt();
    localAppExt.setParam(":VFORM_ID", paramString1);
    localAppExt.setParam(":VCUST_ID", paramString2);
    localAppExt.setParam(":VAPP_ID", paramString3);
    localAppExt.setParam(":VAPP_NO", paramString4);
    localAppExt.setParam(":VGOODS_ID", paramString5);
    localAppExt.setParam(":VRESOURCE_ID", paramString6);
    localAppExt.setParam(":VAIM_ID", paramString7);
    localAppExt.setParam(":VOBJ_USER_ID", paramString8);
    localAppExt.setParam(":VOBJ_USER_NAME", paramString9);
    localAppExt.setParam(":VAPP_TYPE", paramString10);
    localAppExt.setParam(":VAPP_DATE", paramString11);
    localAppExt.setParam(":VSTATE_CODE", paramString12);
    localAppExt.setParam(":VSTATE_CODE_DATE", paramString13);
    localAppExt.setParam(":VUSER_ID", paramString14);
    localAppExt.setParam(":VPUBLISH_DATE", paramString15);
    localAppExt.setParam(":VREMARK", paramString16);
    this.tradeQuery.executeBy(localAppExt.insBy("INS_All_APP"));
    return 0;
  }

  public void updateAppInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateAppInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("APP_ID");
    String str3 = paramBuffers.getString("APP_NO");
    String str4 = paramBuffers.getString("GOODS_ID");
    String str5 = paramBuffers.getString("RESOURCE_ID");
    String str6 = paramBuffers.getString("AIM_ID");
    String str7 = paramBuffers.getString("OBJ_USER_ID");
    String str8 = paramBuffers.getString("OBJ_USER_NAME");
    String str9 = paramBuffers.getString("APP_TYPE");
    String str10 = paramBuffers.getString("APP_DATE");
    String str11 = paramBuffers.getString("STATE_CODE");
    String str12 = paramBuffers.getString("STATE_CODE_DATE");
    String str13 = paramBuffers.getString("SESSION_USER_ID");
    String str14 = paramBuffers.getString("PUBLISH_DATE");
    String str15 = paramBuffers.getString("REMARK");
    try
    {
      i = updateAppInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15);
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
    this.log.LOG_INFO("退出updateAppInfo方法...");
  }

  public int updateAppInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
    throws SaasApplicationException
  {
    AppExt localAppExt = new AppExt();
    localAppExt.setParam(":VCUST_ID", paramString1);
    localAppExt.setParam(":VAPP_ID", paramString2);
    localAppExt.setParam(":VAPP_NO", paramString3);
    localAppExt.setParam(":VGOODS_ID", paramString4);
    localAppExt.setParam(":VRESOURCE_ID", paramString5);
    localAppExt.setParam(":VAIM_ID", paramString6);
    localAppExt.setParam(":VOBJ_USER_ID", paramString7);
    localAppExt.setParam(":VOBJ_USER_NAME", paramString8);
    localAppExt.setParam(":VAPP_TYPE", paramString9);
    localAppExt.setParam(":VAPP_DATE", paramString10);
    localAppExt.setParam(":VSTATE_CODE", paramString11);
    localAppExt.setParam(":VSTATE_CODE_DATE", paramString12);
    localAppExt.setParam(":VUSER_ID", paramString13);
    localAppExt.setParam(":VPUBLISH_DATE", paramString14);
    localAppExt.setParam(":VREMARK", paramString15);
    this.tradeQuery.executeBy(localAppExt.insBy("UPDATE_All_APP"));
    return 0;
  }

  public void delAppInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delAppInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("APP_ID");
    try
    {
      i = delAppInfo(str1, str2);
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
    this.log.LOG_INFO("退出delAppInfo方法...");
  }

  public int delAppInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    AppExt localAppExt = new AppExt();
    localAppExt.setParam(":VCUST_ID", paramString1);
    localAppExt.setParam(":VAPP_ID", paramString2);
    this.tradeQuery.executeBy(localAppExt.insBy("DEL_ONE_APP"));
    return 0;
  }

  public ArrayList getAllApp(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    AppExt localAppExt = new AppExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 20;
      localAppExt.setParam(":VCUST_ID", paramString1);
      localAppExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localAppExt.selByList("SEL_ALL_APP", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getAllApp(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    AppExt localAppExt = new AppExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localAppExt.setParam(":VCUST_ID", paramString1);
      localAppExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localAppExt.selByList("SEL_ALL_APP");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public HashMap getOneApp(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    AppExt localAppExt = new AppExt();
    localAppExt.setParam(":VCUST_ID", paramString1);
    localAppExt.setParam(":VAPP_ID", paramString2);
    localArrayList = localAppExt.selByList("SEL_ONE_APP");
    HashMap localHashMap = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.appMgr.AppInfo
 * JD-Core Version:    0.6.0
 */