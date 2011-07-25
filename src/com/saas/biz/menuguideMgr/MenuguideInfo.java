package com.saas.biz.menuguideMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.menuguideDAO.MenuguideExt;
import com.saas.sys.bpm.BpmDefinitionDAO;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.log.Logger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class MenuguideInfo
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

  public ArrayList getLevelListByCustEntity(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    ArrayList localArrayList1 = new ArrayList();
    MenuguideExt localMenuguideExt = new MenuguideExt();
    localMenuguideExt.setParam(":VSUBSYS_CODE", paramString2);
    localMenuguideExt.setParam(":VMENU_ID", paramString3);
    localArrayList1 = localMenuguideExt.selByList("SEL_EXIST_BY_MENU");
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      HashMap localHashMap1 = (HashMap)localArrayList1.get(0);
      str1 = localHashMap1.get("bpm_id").toString();
      str4 = localHashMap1.get("note_name").toString();
      str5 = localHashMap1.get("note_desc").toString();
      str6 = localHashMap1.get("link_url").toString();
      str7 = localHashMap1.get("param_code").toString();
      BpmDefinitionDAO localBpmDefinitionDAO = new BpmDefinitionDAO();
      ArrayList localArrayList2 = new ArrayList();
      localBpmDefinitionDAO.setParam(":VTRADETYPECODE", str1);
      localArrayList2 = localBpmDefinitionDAO.selByList("SEL_BY_PK");
      if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      {
        HashMap localObject1 = (HashMap)localArrayList2.get(0);
        str2 = ((HashMap)localObject1).get("node_class").toString();
        str3 = ((HashMap)localObject1).get("node_method").toString();
      }
      Object localObject1 = null;
      try
      {
        localObject1 = Class.forName(str2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
      }
      Object localObject2 = ((Class)localObject1).newInstance();
      Method localMethod = null;
      Object localObject3 = null;
      Class[] arrayOfClass = { String.class, String.class };
      try
      {
        localMethod = localObject2.getClass().getDeclaredMethod(str3, arrayOfClass);
        localObject3 = localMethod.invoke(localObject2, new Object[] { paramString1, "0" });
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ArrayList localArrayList3 = new ArrayList();
      localArrayList3 = (ArrayList)localObject3;
      String str8 = "";
      if ((localArrayList3 != null) && (localArrayList3.size() > 0))
      {
        HashMap localHashMap2 = (HashMap)localArrayList3.get(0);
        str8 = localHashMap2.get("cust_id").toString();
      }
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("note_name", str4);
      localHashMap2.put("note_desc", str5);
      localHashMap2.put("link_url", str6);
      localHashMap2.put("obj_cust_id", str8);
      localHashMap2.put("param_code", str7);
      ArrayList localArrayList4 = new ArrayList();
      localArrayList4.add(localHashMap2);
      if ((localArrayList4 != null) && (localArrayList4.size() > 0))
        return localArrayList4;
      return null;
    }
    return (ArrayList)null;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.menuguideMgr.MenuguideInfo
 * JD-Core Version:    0.6.0
 */