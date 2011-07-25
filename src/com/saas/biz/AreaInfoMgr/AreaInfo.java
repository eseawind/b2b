package com.saas.biz.AreaInfoMgr;

import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.JavaScriptObject.TreeObject;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.areaDAO.AreaDAO;
import com.saas.biz.dao.areaDAO.AreaExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;

public class AreaInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
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

  public void addAreaInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addAreaInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("AREA_NAME");
      String str2 = paramBuffers.getString("PARENT_AREA_CODE");
      AreaDAO localAreaDAO = new AreaDAO();
      localAreaDAO.setArea_code(getFourRandNum());
      localAreaDAO.setArea_name(str1);
      localAreaDAO.setParent_area_code(str2);
      i = addAreaInfo(localAreaDAO);
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
    this.log.LOG_INFO("退出addAreaInfo方法...");
  }

  public Map getCountry()
  {
    HashMap localHashMap1 = new HashMap();
    AreaExt localAreaExt = new AreaExt();
    ArrayList localArrayList = localAreaExt.selByList("SEL_COUNTRY_BY_ORDER");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = "";
        String str2 = "";
        if (localHashMap2.get("area_code") != null)
          str1 = localHashMap2.get("area_code").toString();
        if (localHashMap2.get("area_name") != null)
          str2 = localHashMap2.get("area_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public int addAreaInfo(AreaDAO paramAreaDAO)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VAREA_CODE", paramAreaDAO.getArea_code());
    localAreaExt.setParam(":VAREA_NAME", paramAreaDAO.getArea_name());
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramAreaDAO.getParent_area_code());
    this.tradeQuery.executeBy(localAreaExt.insBy("INS_BY_CONTACT"));
    return 0;
  }

  public void deleteArraInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteArraInfo方法...");
    int i = -1;
    try
    {
      String str = paramBuffers.getString("AREA_CODE");
      i = deleteArraInfo(str);
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
    this.log.LOG_INFO("退出addAreaInfo方法...");
  }

  public void DeleteAreaInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("AREA_CODE");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = deleteArraInfo(str2);
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
    this.log.LOG_INFO("退出DeleteSaleInfo方法...");
  }

  public int deleteArraInfo(String paramString)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VAREA_CODE", paramString);
    this.tradeQuery.executeBy(localAreaExt.insBy("DELETE_BY_AREA_CODE"));
    return 0;
  }

  public void updateArraInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateArraInfo方法...");
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("AREA_NAME");
      String str2 = paramBuffers.getString("AREA_CODE");
      i = updateArraInfo(str2, str1);
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
    this.log.LOG_INFO("退出updateArraInfo方法...");
  }

  public int updateArraInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VAREA_CODE", paramString1);
    localAreaExt.setParam(":VAREA_NAME", paramString2);
    this.tradeQuery.executeBy(localAreaExt.insBy("UPDATE_BY_AREA_CODE"));
    return 0;
  }

  public Map getCountryAllByCode(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VUSER_AREA_CODE", paramString);
    ArrayList localArrayList = localAreaExt.selByList("SEL_COUNTRY_BY_CODE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = "";
        String str2 = "";
        if (localHashMap2.get("area_code") != null)
          str1 = localHashMap2.get("area_code").toString();
        if (localHashMap2.get("area_name") != null)
          str2 = localHashMap2.get("area_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public Map getAreaByParent(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramString);
    ArrayList localArrayList = localAreaExt.selByList("SEL_BY_PARENT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = "";
        String str2 = "";
        if (localHashMap2.get("area_code") != null)
          str1 = localHashMap2.get("area_code").toString();
        if (localHashMap2.get("area_name") != null)
          str2 = localHashMap2.get("area_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public ArrayList getAreaByParent2(int paramInt, String paramString)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    paramInt *= 20;
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramString);
    ArrayList localArrayList = localAreaExt.selByList("SEL_BY_PARENT", paramInt, 20);
    return localArrayList;
  }

  public int getAreaByParent2(String paramString)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramString);
    ArrayList localArrayList = localAreaExt.selByList("SEL_BY_PARENT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAreaByParentAndName(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    paramInt *= 20;
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramString1);
    localAreaExt.setParam(":VPARENT_AREA_NAME", "%" + paramString2 + "%");
    ArrayList localArrayList = localAreaExt.selByList("SEL_BY_PARENT_AND_NAME", paramInt, 20);
    return localArrayList;
  }

  public int getAreaByParentAndName(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramString1);
    localAreaExt.setParam(":VPARENT_AREA_NAME", "%" + paramString2 + "%");
    ArrayList localArrayList = localAreaExt.selByList("SEL_BY_PARENT_AND_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public String getAreaName(String paramString)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramString);
    ArrayList localArrayList = localAreaExt.selByList("SEL_BY_ID_FOR_NAME");
    String str = new String();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      str = localHashMap.get("area_name").toString();
    }
    return str;
  }

  public String getAreaId(String paramString)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VAREANMAE", paramString);
    ArrayList localArrayList = localAreaExt.selByList("SEL_ID_BY_NAME");
    String str = new String();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("area_code") != null)
        str = localHashMap.get("area_code").toString();
    }
    return str;
  }

  public ArrayList getArea(String paramString)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramString);
    ArrayList localArrayList = localAreaExt.selByList("SEL_BY_ID_FOR_NAME");
    return localArrayList;
  }

  public ArrayList getAreaByParentByCMS(String paramString)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramString);
    ArrayList localArrayList = localAreaExt.selByList("SEL_BY_PARENT");
    return localArrayList;
  }

  public String getCountrySelect(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = getInfoByUpId(paramString);
    String str1 = "";
    for (int i = 0; i < localArrayList.size(); i++)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(i);
      String str2 = "";
      String str3 = "";
      if (localHashMap.get("area_code") != null)
        str2 = localHashMap.get("area_code").toString();
      if (localHashMap.get("area_name") != null)
        str3 = localHashMap.get("area_name").toString();
      str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>";
    }
    return str1;
  }

  public String getItemsBySelected(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = getInfoByUpId(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = "";
        String str4 = "";
        if (localHashMap.get("area_code") != null)
        {
          str3 = localHashMap.get("area_code").toString();
          if ((str3.equals(paramString2)) || (str3 == paramString2))
            str2 = "selected";
          else
            str2 = "";
        }
        if (localHashMap.get("area_name") != null)
          str4 = localHashMap.get("area_name").toString();
        str1 = str1 + "<option value=" + str3 + "  " + str2 + ">" + str4 + "</option>";
      }
    return str1;
  }

  public ArrayList getCity(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPROVINCE", paramString);
    localArrayList = localAreaExt.selByList("SEL_BY_CITY_QU");
    this.log.LOG_INFO("getCity===========end");
    return localArrayList;
  }

  public ArrayList getAll()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AreaExt localAreaExt = new AreaExt();
    localArrayList = localAreaExt.selByList("SEL_BY_CITY_ALL");
    this.log.LOG_INFO("===" + localArrayList.size());
    return localArrayList;
  }

  public ArrayList getQu(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPROVINCE", paramString1);
    localAreaExt.setParam(":VQU", paramString2);
    localArrayList = localAreaExt.selByList("SEL_BY_CITY_QU_NEW");
    this.log.LOG_INFO("getQu===========end");
    return localArrayList;
  }

  public int upAreaInfo()
    throws SaasApplicationException
  {
    this.log.LOG_INFO("==begin.........");
    ArrayList localArrayList1 = getAll();
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)localArrayList1.get(i);
        String str1 = localHashMap1.get("rsvalue1").toString();
        ArrayList localArrayList2 = getCity(str1);
        if ((localArrayList2 == null) || (localArrayList2.size() <= 0))
          continue;
        for (int j = 1; j < localArrayList2.size(); j++)
        {
          HashMap localHashMap2 = (HashMap)localArrayList2.get(j);
          String str2 = localHashMap2.get("remark").toString();
          String str3 = localHashMap2.get("area_code").toString();
          ArrayList localArrayList3 = getQu(str1, str2);
          if ((localArrayList3 == null) || (localArrayList3.size() <= 0))
            continue;
          for (int k = 1; k < localArrayList3.size(); k++)
          {
            HashMap localHashMap3 = (HashMap)localArrayList3.get(k);
            String str4 = localHashMap3.get("area_code").toString();
            AreaExt localAreaExt = new AreaExt();
            localAreaExt.setParam(":VPARENT_AREA_CODE", str3);
            localAreaExt.setParam(":VAREA_CODE", str4);
            this.tradeQuery.executeBy(localAreaExt.insBy("UPDATE_BY_CONTACT"));
          }
        }
      }
    return 0;
  }

  public static void main(String[] paramArrayOfString)
    throws SaasApplicationException
  {
    AreaInfo localAreaInfo = new AreaInfo();
    int i = localAreaInfo.upAreaInfo();
    System.out.println(i);
  }

  public void upAreaInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入upAreaInfo方法...");
    int i = -1;
    try
    {
      i = upAreaInfo();
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
    this.log.LOG_INFO("退出upAreaInfo方法...");
  }

  public ArrayList getInfoByUpId(String paramString)
    throws SaasApplicationException
  {
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPARENT_AREA_CODE", paramString);
    ArrayList localArrayList = localAreaExt.selByList("SEL_BY_PARENT");
    return localArrayList;
  }

  public String getJsonDataForTree(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = paramString2;
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = getInfoByUpId(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str2 = localHashMap.get("area_name").toString();
        String str3 = localHashMap.get("area_code").toString();
        localTreeObject.setIconCls(str1);
        localTreeObject.setId(str3);
        localTreeObject.setText(str2);
        TreeNode localTreeNode = isLeaf(str3);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    return localJSONArray.toString();
  }

  public JSONArray getChildrenNodes(String paramString, ArrayList paramArrayList)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str1 = localHashMap.get("area_name").toString();
        String str2 = localHashMap.get("area_code").toString();
        localTreeObject.setId(str2);
        localTreeObject.setText(str1);
        TreeNode localTreeNode = isLeaf(str2);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    return localJSONArray;
  }

  public TreeNode isLeaf(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = getInfoByUpId(paramString);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getChildrenNodes(paramString, localArrayList);
      localTreeNode.setChildren(localJSONArray);
    }
    return localTreeNode;
  }

  public String getAreaNameByCode(String paramString)
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VAREACODE", paramString);
    localArrayList = localAreaExt.selByList("SEL_AREANAME_BY_CODE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("area_name") != null)
        str = localHashMap.get("area_name").toString();
    }
    return str;
  }

  public String getProvinceList(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VPROVINCE", paramString);
    localArrayList = localAreaExt.selByList("SEL_AREA_BY_PRO");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("area_name") != null)
        str = localHashMap.get("area_name").toString();
    }
    return str;
  }

  public String getCityList(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    AreaExt localAreaExt = new AreaExt();
    localAreaExt.setParam(":VCITY", paramString);
    localArrayList = localAreaExt.selByList("SEL_AREA_BY_CITY");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("area_name") != null)
        str = localHashMap.get("area_name").toString();
    }
    return str;
  }

  public String getFourRandNum()
    throws SaasApplicationException
  {
    String str1 = "";
    Random localRandom = new Random();
    int i = localRandom.nextInt(10000);
    String str2 = "";
    if (i != 0)
    {
      str2 = getAreaName(String.valueOf(i));
      if (str2.equals(""))
        str1 = String.valueOf(i);
      else
        str1 = getFourRandNum();
    }
    return str1;
  }

  public ArrayList getAreaExistCustomer()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AreaExt localAreaExt = new AreaExt();
    localArrayList = localAreaExt.selByList("SEL_ALL_AREA_EXIST_CUSTOMER");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.AreaInfoMgr.AreaInfo
 * JD-Core Version:    0.6.0
 */