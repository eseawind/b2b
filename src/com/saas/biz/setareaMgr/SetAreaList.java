package com.saas.biz.setareaMgr;

import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.JavaScriptObject.TreeObject;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.setareaDAO.SetAreaDAO;
import com.saas.biz.dao.setareaDAO.SetAreaExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;

public class SetAreaList
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

  public void setAreaInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入setAreaInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("CHANNELS_ID");
    String str4 = paramBuffers.getString("AREA_CODE");
    String str5 = paramBuffers.getString("AREA_NAME");
    String str6 = paramBuffers.getString("EXC_TAG");
    String str7 = paramBuffers.getString("OPER_USER_ID");
    String str8 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String str9 = paramBuffers.getString("REMARK2");
    try
    {
      SetAreaDAO localSetAreaDAO = new SetAreaDAO();
      localSetAreaDAO.setCust_id(str1);
      localSetAreaDAO.setChannels_type(str2);
      localSetAreaDAO.setChannels_id(str3);
      localSetAreaDAO.setArea_code(str4);
      localSetAreaDAO.setArea_name(str5);
      localSetAreaDAO.setExc_tag(str6);
      localSetAreaDAO.setOper_user_id(str7);
      localSetAreaDAO.setIn_date(str8);
      localSetAreaDAO.setRemark2(str9);
      i = setAreaInfo(localSetAreaDAO);
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
    this.log.LOG_INFO("退出setAreaInfo方法...");
  }

  public int setAreaInfo(SetAreaDAO paramSetAreaDAO)
    throws SaasApplicationException
  {
    SetAreaExt localSetAreaExt = new SetAreaExt();
    localSetAreaExt.setParam(":VCUST_ID", paramSetAreaDAO.getCust_id());
    localSetAreaExt.setParam(":VCHANNELS_TYPE", paramSetAreaDAO.getChannels_type());
    localSetAreaExt.setParam(":VCHANNELS_ID", paramSetAreaDAO.getChannels_id());
    localSetAreaExt.setParam(":VAREA_CODE", paramSetAreaDAO.getArea_code());
    localSetAreaExt.setParam(":VAREA_NAME", paramSetAreaDAO.getArea_name());
    localSetAreaExt.setParam(":VEXC_TAG", paramSetAreaDAO.getExc_tag());
    localSetAreaExt.setParam(":VOPER_USER_ID", paramSetAreaDAO.getOper_user_id());
    localSetAreaExt.setParam(":VIN_DATE", paramSetAreaDAO.getIn_date());
    localSetAreaExt.setParam(":VREMARK2", paramSetAreaDAO.getRemark2());
    this.tradeQuery.executeBy(localSetAreaExt.insBy("SET_AREA_INFO"));
    return 0;
  }

  public void delArea(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delArea方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("CHANNELS_ID");
    String str4 = paramBuffers.getString("AREA_CODE");
    String str5 = paramBuffers.getString("AREA_NAME");
    String str6 = paramBuffers.getString("EXC_TAG");
    String str7 = paramBuffers.getString("OPER_USER_ID");
    String str8 = paramBuffers.getString("IN_DATE");
    String str9 = paramBuffers.getString("REMARK2");
    try
    {
      SetAreaDAO localSetAreaDAO = new SetAreaDAO();
      localSetAreaDAO.setCust_id(str1);
      localSetAreaDAO.setChannels_type(str2);
      localSetAreaDAO.setChannels_id(str3);
      localSetAreaDAO.setArea_code(str4);
      localSetAreaDAO.setArea_name(str5);
      localSetAreaDAO.setExc_tag(str6);
      localSetAreaDAO.setOper_user_id(str7);
      localSetAreaDAO.setIn_date(str8);
      localSetAreaDAO.setRemark2(str9);
      i = delArea(localSetAreaDAO);
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
    this.log.LOG_INFO("退出delArea方法...");
  }

  public int delArea(SetAreaDAO paramSetAreaDAO)
    throws SaasApplicationException
  {
    SetAreaExt localSetAreaExt = new SetAreaExt();
    localSetAreaExt.setParam(":VCUST_ID", paramSetAreaDAO.getCust_id());
    localSetAreaExt.setParam(":VCHANNELS_TYPE", paramSetAreaDAO.getChannels_type());
    localSetAreaExt.setParam(":VCHANNELS_ID", paramSetAreaDAO.getChannels_id());
    localSetAreaExt.setParam(":VAREA_CODE", paramSetAreaDAO.getArea_code());
    localSetAreaExt.setParam(":VAREA_NAME", paramSetAreaDAO.getArea_name());
    localSetAreaExt.setParam(":VEXC_TAG", paramSetAreaDAO.getExc_tag());
    localSetAreaExt.setParam(":VOPER_USER_ID", paramSetAreaDAO.getOper_user_id());
    localSetAreaExt.setParam(":VIN_DATE", paramSetAreaDAO.getIn_date());
    localSetAreaExt.setParam(":VREMARK2", paramSetAreaDAO.getRemark2());
    this.tradeQuery.executeBy(localSetAreaExt.insBy("DEL_BY_AREA"));
    return 0;
  }

  public void delAreaAll(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delArea方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_TYPE");
    String str3 = paramBuffers.getString("CHANNELS_ID");
    String str4 = paramBuffers.getString("OPER_USER_ID");
    try
    {
      SetAreaDAO localSetAreaDAO = new SetAreaDAO();
      localSetAreaDAO.setChannels_id(str3);
      localSetAreaDAO.setCust_id(str1);
      localSetAreaDAO.setChannels_type(str2);
      localSetAreaDAO.setOper_user_id(str4);
      i = delAreaAll(localSetAreaDAO);
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
    this.log.LOG_INFO("退出delArea方法...");
  }

  public int delAreaAll(SetAreaDAO paramSetAreaDAO)
    throws SaasApplicationException
  {
    String str1 = paramSetAreaDAO.getOper_user_id();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      SetAreaExt localSetAreaExt = new SetAreaExt();
      localSetAreaExt.setParam(":VCUST_ID", paramSetAreaDAO.getCust_id());
      localSetAreaExt.setParam(":VCHANNELS_TYPE", paramSetAreaDAO.getChannels_type());
      localSetAreaExt.setParam(":VCHANNELS_ID", paramSetAreaDAO.getChannels_id());
      localSetAreaExt.setParam(":VAREA_CODE", str2);
      this.tradeQuery.executeBy(localSetAreaExt.insBy("DEL_BY_ALL"));
    }
    return 0;
  }

  public ArrayList getInfoByUpId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SetAreaExt localSetAreaExt = new SetAreaExt();
    localSetAreaExt.setParam(":VCUST_ID", paramString1);
    localSetAreaExt.setParam(":VUP_CHANNELS_ID", paramString2);
    localArrayList = localSetAreaExt.selByList("SEL_BY_UP_ID");
    return localArrayList;
  }

  public ArrayList getInfoById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SetAreaExt localSetAreaExt = new SetAreaExt();
    localSetAreaExt.setParam(":VCUST_ID", paramString1);
    localSetAreaExt.setParam(":VCHANNELS_ID", paramString2);
    localArrayList = localSetAreaExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public HashMap getAreaById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    SetAreaExt localSetAreaExt = new SetAreaExt();
    localSetAreaExt.setParam(":VCUST_ID", paramString1);
    localSetAreaExt.setParam(":VCHANNELS_ID", paramString2);
    localArrayList = localSetAreaExt.selByList("SEL_BY_ID");
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
 * Qualified Name:     com.saas.biz.setareaMgr.SetAreaList
 * JD-Core Version:    0.6.0
 */