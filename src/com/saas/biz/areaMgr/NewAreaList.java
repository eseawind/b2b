package com.saas.biz.areaMgr;

import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.JavaScriptObject.TreeObject;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.newareaDAO.NewAareaExt;
import com.saas.biz.dao.newareaDAO.NewareaDAO;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.json.JSONArray;

public class NewAreaList
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

  public void addNewAreaInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addNewAreaInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("CHANNELS_ID");
    String str4 = paramBuffers.getString("CHANNELS_NAME");
    String str5 = paramBuffers.getString("UP_CHANNELS_ID");
    String str6 = paramBuffers.getString("CHANNELS_LEVEL");
    String str7 = paramBuffers.getString("CHANNELS_DESC");
    String str8 = paramBuffers.getString("ENABLE_TAG");
    String str9 = paramBuffers.getString("REMARK");
    try
    {
      NewareaDAO localNewareaDAO = new NewareaDAO();
      localNewareaDAO.setCust_id(str1);
      localNewareaDAO.setChannels_type(str2);
      localNewareaDAO.setChannels_id(str3);
      localNewareaDAO.setChannels_name(str4);
      localNewareaDAO.setUp_channels_id(str5);
      localNewareaDAO.setChannels_level(str6);
      localNewareaDAO.setChannels_desc(str7);
      localNewareaDAO.setEnable_tag(str8);
      localNewareaDAO.setRemark(str9);
      i = addNewAreaInfo(localNewareaDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增片区业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增片区业务处理成功！");
    }
    this.log.LOG_INFO("退出addNewAreaInfo方法...");
  }

  public int addNewAreaInfo(NewareaDAO paramNewareaDAO)
    throws SaasApplicationException
  {
    NewAareaExt localNewAareaExt = new NewAareaExt();
    localNewAareaExt.setParam(":VCUST_ID", paramNewareaDAO.getCust_id());
    localNewAareaExt.setParam(":VCHANNELS_TYPE", paramNewareaDAO.getChannels_type());
    localNewAareaExt.setParam(":VCHANNELS_ID", paramNewareaDAO.getChannels_id());
    localNewAareaExt.setParam(":VCHANNELS_NAME", paramNewareaDAO.getChannels_name());
    localNewAareaExt.setParam(":VUP_CHANNELS_ID", paramNewareaDAO.getUp_channels_id());
    localNewAareaExt.setParam(":VCHANNELS_LEVEL", paramNewareaDAO.getChannels_level());
    localNewAareaExt.setParam(":VCHANNELS_DESC", paramNewareaDAO.getChannels_desc());
    localNewAareaExt.setParam(":VENABLE_TAG", paramNewareaDAO.getEnable_tag());
    localNewAareaExt.setParam(":VREMARK", paramNewareaDAO.getRemark());
    this.tradeQuery.executeBy(localNewAareaExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void addAreaInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addAreaInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = this.commen.GenTradeId();
    String str4 = paramBuffers.getString("AREA_NAME");
    String str5 = paramBuffers.getString("CHANNELS_ID");
    String str6 = "1";
    String str7 = "";
    String str8 = "0";
    String str9 = "片区设置";
    try
    {
      NewareaDAO localNewareaDAO = new NewareaDAO();
      localNewareaDAO.setCust_id(str1);
      localNewareaDAO.setChannels_type(str2);
      localNewareaDAO.setChannels_id(str3);
      localNewareaDAO.setChannels_name(str4);
      localNewareaDAO.setUp_channels_id(str5);
      localNewareaDAO.setChannels_level(str6);
      localNewareaDAO.setChannels_desc(str7);
      localNewareaDAO.setEnable_tag(str8);
      localNewareaDAO.setRemark(str9);
      i = addNewAreaInfo(localNewareaDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增片区业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增片区业务处理成功！");
    }
    this.log.LOG_INFO("退出addNewAreaInfo方法...");
  }

  public void modifyAreaInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyAreaInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("CHANNELS_ID");
    String str4 = paramBuffers.getString("CHANNELS_NAME");
    String str5 = paramBuffers.getString("CHANNELS_DESC");
    String str6 = paramBuffers.getString("ENABLE_TAG");
    String str7 = paramBuffers.getString("REMARK");
    try
    {
      NewareaDAO localNewareaDAO = new NewareaDAO();
      localNewareaDAO.setCust_id(str1);
      localNewareaDAO.setChannels_id(str3);
      localNewareaDAO.setChannels_name(str4);
      localNewareaDAO.setChannels_desc(str5);
      localNewareaDAO.setEnable_tag(str6);
      localNewareaDAO.setChannels_type(str2);
      localNewareaDAO.setRemark(str7);
      i = modifyAreaInfo(localNewareaDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "新增片区业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "新增片区业务处理成功！");
    }
    this.log.LOG_INFO("退出modifyAreaInfo方法...");
  }

  public int modifyAreaInfo(NewareaDAO paramNewareaDAO)
    throws SaasApplicationException
  {
    NewAareaExt localNewAareaExt = new NewAareaExt();
    localNewAareaExt.setParam(":VCUST_ID", paramNewareaDAO.getCust_id());
    localNewAareaExt.setParam(":VCHANNELS_ID", paramNewareaDAO.getChannels_id());
    localNewAareaExt.setParam(":VCHANNELS_NAME", paramNewareaDAO.getChannels_name());
    localNewAareaExt.setParam(":VCHANNELS_DESC", paramNewareaDAO.getChannels_desc());
    localNewAareaExt.setParam(":VENABLE_TAG", paramNewareaDAO.getEnable_tag());
    localNewAareaExt.setParam(":VCHANNELS_TYPE", paramNewareaDAO.getChannels_type());
    localNewAareaExt.setParam(":VREMARK", paramNewareaDAO.getRemark());
    this.tradeQuery.executeBy(localNewAareaExt.insBy("UP_BY_ALL"));
    return 0;
  }

  public void deleteAreaInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteAreaInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_ID");
    try
    {
      NewareaDAO localNewareaDAO = new NewareaDAO();
      localNewareaDAO.setCust_id(str1);
      localNewareaDAO.setChannels_id(str2);
      i = deleteAreaInfo(localNewareaDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "删除片区业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "删除片区业务处理成功！");
    }
    this.log.LOG_INFO("退出deleteAreaInfo方法...");
  }

  public int deleteAreaInfo(NewareaDAO paramNewareaDAO)
    throws SaasApplicationException
  {
    NewAareaExt localNewAareaExt = new NewAareaExt();
    localNewAareaExt.setParam(":VCUST_ID", paramNewareaDAO.getCust_id());
    localNewAareaExt.setParam(":VCHANNELS_ID", paramNewareaDAO.getChannels_id());
    this.tradeQuery.executeBy(localNewAareaExt.insBy("DEL_BY_ALL"));
    return 0;
  }

  public ArrayList getInfoByUpId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewAareaExt localNewAareaExt = new NewAareaExt();
    localNewAareaExt.setParam(":VCUST_ID", paramString1);
    localNewAareaExt.setParam(":VUP_CHANNELS_ID", paramString2);
    localArrayList = localNewAareaExt.selByList("SEL_BY_UP_ID");
    return localArrayList;
  }

  public ArrayList getInfoById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewAareaExt localNewAareaExt = new NewAareaExt();
    localNewAareaExt.setParam(":VCUST_ID", paramString1);
    localNewAareaExt.setParam(":VCHANNELS_ID", paramString2);
    localArrayList = localNewAareaExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public ArrayList getInfoByChannelsId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NewAareaExt localNewAareaExt = new NewAareaExt();
    localNewAareaExt.setParam(":VCUST_ID", paramString1);
    localNewAareaExt.setParam(":VCHANNELS_ID", paramString2);
    localArrayList = localNewAareaExt.selByList("SEL_BY_CHANNELS_ID");
    return localArrayList;
  }

  public HashMap getAreaById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    NewAareaExt localNewAareaExt = new NewAareaExt();
    localNewAareaExt.setParam(":VCUST_ID", paramString1);
    localNewAareaExt.setParam(":VCHANNELS_ID", paramString2);
    localArrayList = localNewAareaExt.selByList("SEL_BY_ID");
    localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public String getJsonDataForTree(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = paramString3;
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = getInfoByUpId(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str2 = localHashMap.get("channels_name").toString();
        String str3 = localHashMap.get("channels_id").toString();
        localTreeObject.setIconCls(str1);
        localTreeObject.setId(str3);
        localTreeObject.setText(str2);
        TreeNode localTreeNode = isLeaf(paramString1, str3);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    return localJSONArray.toString();
  }

  public JSONArray getChildrenNodes(String paramString1, String paramString2, ArrayList paramArrayList)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str1 = localHashMap.get("channels_name").toString();
        String str2 = localHashMap.get("channels_id").toString();
        localTreeObject.setId(str2);
        localTreeObject.setText(str1);
        TreeNode localTreeNode = isLeaf(paramString1, str2);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    return localJSONArray;
  }

  public TreeNode isLeaf(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = getInfoByUpId(paramString1, paramString2);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getChildrenNodes(paramString1, paramString2, localArrayList);
      localTreeNode.setChildren(localJSONArray);
    }
    return localTreeNode;
  }

  public int checkChildren(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = getInfoByUpId(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.areaMgr.NewAreaList
 * JD-Core Version:    0.6.0
 */