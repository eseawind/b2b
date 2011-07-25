package com.saas.biz.shoptaskMgr;

import com.saas.biz.carMgr.CarInfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.custMgr.Custinfo;
import com.saas.biz.dao.shoptaskDAO.ShoptaskExt;
import com.saas.biz.motorcadeMgr.MotorCadeInfo;
import com.saas.biz.shopneedMgr.ShopneedInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ShoptaskInfo
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

  public void addShoptask(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addShoptask方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SHOPO_ID");
    String str3 = paramBuffers.getString("TASK_TITLE");
    String str4 = paramBuffers.getString("TASK_OBJ_ID");
    String str5 = paramBuffers.getString("STATE_CODE");
    String str6 = paramBuffers.getString("STATE_CODE_DATE");
    String str7 = paramBuffers.getString("SESSION_USER_ID");
    String str8 = paramBuffers.getString("PUBLISH_DATE");
    String str9 = paramBuffers.getString("REMARK");
    String str10 = "";
    ShopneedInfo localShopneedInfo = new ShopneedInfo();
    StringTokenizer localStringTokenizer = new StringTokenizer(str2, "|");
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str11 = localcommMethodMgr.GenTradeId();
    int i = -1;
    try
    {
      while (localStringTokenizer.hasMoreTokens())
      {
        str10 = localStringTokenizer.nextToken();
        ArrayList localArrayList = localShopneedInfo.getOneShopNeed(str1, str10);
        String str12 = "";
        String str13 = "";
        String str14 = "";
        String str15 = "";
        String str16 = "";
        String str17 = "";
        String str18 = "";
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          HashMap localHashMap = (HashMap)localArrayList.get(0);
          if (localHashMap.get("pre_date") != null)
            str12 = localHashMap.get("pre_date").toString();
          if (localHashMap.get("act_date") != null)
            str13 = localHashMap.get("act_date").toString();
          if (localHashMap.get("from_addr") != null)
            str14 = localHashMap.get("from_addr").toString();
          if (localHashMap.get("to_addr") != null)
            str15 = localHashMap.get("to_addr").toString();
          if (localHashMap.get("ship_type") != null)
            str16 = localHashMap.get("ship_type").toString();
          if (localHashMap.get("need_num") != null)
            str17 = localHashMap.get("need_num").toString();
          if (localHashMap.get("unit") != null)
            str18 = localHashMap.get("unit").toString();
        }
        i = addShoptask(str1, str10, str11, str3, str4, str12, str13, str14, str15, str16, str17, str18, str5, str6, str7, str8, str9);
      }
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
    this.log.LOG_INFO("退出addShoptask方法...");
  }

  public int addShoptask(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17)
    throws SaasApplicationException
  {
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    localShoptaskExt.setParam(":VCUST_ID", paramString1);
    localShoptaskExt.setParam(":VSHOPO_ID", paramString2);
    localShoptaskExt.setParam(":VTASK_ID", paramString3);
    localShoptaskExt.setParam(":VTASK_TITLE", paramString4);
    localShoptaskExt.setParam(":VTASK_OBJ_ID", paramString5);
    localShoptaskExt.setParam(":VPRE_DATE", paramString6);
    localShoptaskExt.setParam(":VACT_DATE", paramString7);
    localShoptaskExt.setParam(":VFROM_ADDR", paramString8);
    localShoptaskExt.setParam(":VTO_ADDR", paramString9);
    localShoptaskExt.setParam(":VSHIP_TYPE", paramString10);
    localShoptaskExt.setParam(":VTASK_NUM", paramString11);
    localShoptaskExt.setParam(":VUNIT", paramString12);
    localShoptaskExt.setParam(":VSTATE_CODE", paramString13);
    localShoptaskExt.setParam(":VSTATE_CODE_DATE", paramString14);
    localShoptaskExt.setParam(":VUSER_ID", paramString15);
    localShoptaskExt.setParam(":VPUBLISH_DATE", paramString16);
    localShoptaskExt.setParam(":VREMARK", paramString17);
    this.tradeQuery.executeBy(localShoptaskExt.insBy("INS_SHOPTASK_ALL"));
    return 0;
  }

  public void updateShoptask(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入updateShoptask方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SHOPO_ID");
    String str3 = paramBuffers.getString("TASK_ID");
    String str4 = paramBuffers.getString("TASK_TITLE");
    String str5 = "";
    str5 = getOneShopTaskTitle(str1, str4);
    String str6 = paramBuffers.getString("TASK_OBJ_ID");
    String str7 = paramBuffers.getString("REMARK");
    int i = -1;
    String str8 = "";
    StringTokenizer localStringTokenizer = new StringTokenizer(str2, "|");
    try
    {
      while (localStringTokenizer.hasMoreTokens())
      {
        str8 = localStringTokenizer.nextToken();
        i = updateShoptask(str1, str8, str3, str5, str6, str7);
      }
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
    this.log.LOG_INFO("退出updateShoptask方法...");
  }

  public int updateShoptask(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    localShoptaskExt.setParam(":VCUST_ID", paramString1);
    localShoptaskExt.setParam(":VSHOPO_ID", paramString2);
    localShoptaskExt.setParam(":VTASK_ID", paramString3);
    localShoptaskExt.setParam(":VTASK_TITLE", paramString4);
    localShoptaskExt.setParam(":VTASK_OBJ_ID", paramString5);
    localShoptaskExt.setParam(":VREMARK", paramString6);
    this.tradeQuery.executeBy(localShoptaskExt.insBy("UPDATE_SHOPTASK"));
    return 0;
  }

  public void delOneShoptask(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delOneShoptask方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TASK_ID");
    String str3 = paramBuffers.getString("NEED_ID");
    StringTokenizer localStringTokenizer = new StringTokenizer(str3, "|");
    String str4 = "";
    int i = -1;
    try
    {
      while (localStringTokenizer.hasMoreTokens())
      {
        str4 = localStringTokenizer.nextToken();
        i = delOneShoptask(str1, str2, str4);
      }
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
    this.log.LOG_INFO("退出delOneShoptask方法...");
  }

  public int delOneShoptask(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    localShoptaskExt.setParam(":VCUST_ID", paramString1);
    localShoptaskExt.setParam(":VTASK_ID", paramString2);
    localShoptaskExt.setParam(":VNEED_ID", paramString3);
    this.tradeQuery.executeBy(localShoptaskExt.insBy("DEL_ONE_SHOPTASK"));
    return 0;
  }

  public void delOnlyShoptask(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delOneShoptask方法...");
    this.outBuffer = paramBuffers;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TASK_ID");
    int i = -1;
    try
    {
      i = delOnlyShoptask(str1, str2);
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
    this.log.LOG_INFO("退出delOneShoptask方法...");
  }

  public int delOnlyShoptask(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    localShoptaskExt.setParam(":VCUST_ID", paramString1);
    localShoptaskExt.setParam(":VTASK_ID", paramString2);
    this.tradeQuery.executeBy(localShoptaskExt.insBy("DEL_ONLY_SHOPTASK"));
    return 0;
  }

  public ArrayList getAllShoptaskByCustId(String paramString1, int paramInt, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    try
    {
      paramInt *= 20;
      localShoptaskExt.setParam(":VCUST_ID", paramString1);
      localShoptaskExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localShoptaskExt.selByList("SEL_ALL_SHOPTASK", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getAllShoptaskByCustId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    try
    {
      localShoptaskExt.setParam(":VCUST_ID", paramString1);
      localShoptaskExt.setParam(":VSTATE_CODE", paramString2);
      localArrayList = localShoptaskExt.selByList("SEL_ALL_SHOPTASK");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getOneShopTask(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    try
    {
      paramInt *= 20;
      localShoptaskExt.setParam(":VCUST_ID", paramString1);
      localShoptaskExt.setParam(":VTASK_ID", paramString2);
      localArrayList = localShoptaskExt.selByList("SEL_ONE_SHOPTASK", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public String getOneShopTaskTitle(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    HashMap localHashMap = new HashMap();
    localShoptaskExt.setParam(":VCUST_ID", paramString1);
    localShoptaskExt.setParam(":VTASK_ID", paramString2);
    localArrayList = localShoptaskExt.selByList("SEL_ONE_SHOPTASK");
    String str = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("tast_title") != null)
        str = localHashMap.get("tast_title").toString();
    }
    return str;
  }

  public HashMap getDwrOneShopTask(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Custinfo localCustinfo = new Custinfo();
    CarInfo localCarInfo = new CarInfo();
    MotorCadeInfo localMotorCadeInfo = new MotorCadeInfo();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    try
    {
      localShoptaskExt.setParam(":VCUST_ID", paramString1);
      localShoptaskExt.setParam(":VTASK_ID", paramString2);
      localArrayList = localShoptaskExt.selByList("SEL_ONE_SHOPTASK");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    HashMap localHashMap2 = new HashMap();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localHashMap1 = (HashMap)localArrayList.get(0);
      if (localHashMap1.get("task_obj_id") != null)
        str1 = localHashMap1.get("task_obj_id").toString();
      if (localHashMap1.get("remark") != null)
        str2 = localHashMap1.get("remark").toString();
      localHashMap2.put("task_obj_id", str1);
      localHashMap2.put("remark", str2);
      String str4 = "[|]";
      String[] arrayOfString = str1.split(str4);
      if (arrayOfString[0].equals("1"))
        str3 = "客户:" + localCustinfo.getCustNameById(arrayOfString[1]);
      else if (arrayOfString[0].equals("2"))
        str3 = "车队名称:" + localMotorCadeInfo.getMotorCadeNameById(arrayOfString[1]);
      else if (arrayOfString[0].equals("3"))
        str3 = "车辆车牌号:" + localCarInfo.getCarTagNoById(arrayOfString[1]);
      localHashMap2.put("task_obj_id1", str3);
    }
    return localHashMap2;
  }

  public int getOneShopTask(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    try
    {
      localShoptaskExt.setParam(":VCUST_ID", paramString1);
      localShoptaskExt.setParam(":VTASK_ID", paramString2);
      localArrayList = localShoptaskExt.selByList("SEL_ONE_SHOPTASK");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public String getSelectByCustId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoptaskExt localShoptaskExt = new ShoptaskExt();
    try
    {
      localShoptaskExt.setParam(":VCUST_ID", paramString);
      localArrayList = localShoptaskExt.selByList("SEL_SELECT_BY_CUST_ID");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    HashMap localHashMap = new HashMap();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("task_title") != null)
          str1 = localHashMap.get("task_title").toString();
        if (localHashMap.get("task_id") != null)
          str2 = localHashMap.get("task_id").toString();
        str3 = str3 + "<option value=" + str2 + ">" + str1 + "</option>";
      }
    return str3;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.shoptaskMgr.ShoptaskInfo
 * JD-Core Version:    0.6.0
 */