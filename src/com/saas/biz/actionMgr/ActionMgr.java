package com.saas.biz.actionMgr;

import com.saas.biz.dao.actionDAO.ActionInfoDAO;
import com.saas.biz.dao.actionDAO.ActionInfoExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ActionMgr
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
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

  public void addActionInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addActionInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("OWN_ID");
    String str3 = paramBuffers.getString("ENTITY_TYPE");
    String str4 = paramBuffers.getString("ENTITY_ID");
    String str5 = paramBuffers.getString("SUBJECT_TAG");
    String str6 = paramBuffers.getString("UP_INFO_ID");
    String str7 = paramBuffers.getString("RELA_ID");
    String str8 = paramBuffers.getString("SESSION_USER_ID");
    String str9 = paramBuffers.getString("ATTACH_PATH");
    String str10 = paramBuffers.getString("TITLE");
    String str11 = paramBuffers.getString("CONTENT");
    String str12 = paramBuffers.getString("INFO_DATE");
    String str13 = paramBuffers.getString("INFO_STATE");
    String str14 = paramBuffers.getString("REMARK");
    String str15 = paramBuffers.getString("RSRV_STR10");
    try
    {
      ActionInfoDAO localActionInfoDAO = new ActionInfoDAO();
      localActionInfoDAO.setOwn_id(str2);
      localActionInfoDAO.setCust_id(str1);
      localActionInfoDAO.setEntity_type(str3);
      localActionInfoDAO.setEntity_id(str4);
      localActionInfoDAO.setSubject_tag(str5);
      localActionInfoDAO.setRela_id(str7);
      localActionInfoDAO.setUp_info_id(str6);
      localActionInfoDAO.setAttach_path(str9);
      localActionInfoDAO.setPublish_user_id(str8);
      localActionInfoDAO.setTitle(str10);
      localActionInfoDAO.setContent(str11);
      localActionInfoDAO.setInfo_date(str12);
      localActionInfoDAO.setInfo_state(str13);
      localActionInfoDAO.setRemark(str14);
      localActionInfoDAO.setRsrv_str10(str15);
      i = addActionInfo(localActionInfoDAO);
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
    this.log.LOG_INFO("退出addActionInfo方法...");
  }

  public int addActionInfo(ActionInfoDAO paramActionInfoDAO)
    throws SaasApplicationException
  {
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VOWN_ID", paramActionInfoDAO.getOwn_id());
    localActionInfoExt.setParam(":VCUST_ID", paramActionInfoDAO.getCust_id());
    localActionInfoExt.setParam(":VENTITY_TYPE", paramActionInfoDAO.getEntity_type());
    localActionInfoExt.setParam(":VENTITY_ID", paramActionInfoDAO.getEntity_id());
    localActionInfoExt.setParam(":VSUBJECT_TAG", paramActionInfoDAO.getSubject_tag());
    localActionInfoExt.setParam(":VRELA_ID", paramActionInfoDAO.getRela_id());
    localActionInfoExt.setParam(":VUP_INFO_ID", paramActionInfoDAO.getUp_info_id());
    localActionInfoExt.setParam(":VATTACH_PATH", paramActionInfoDAO.getAttach_path());
    localActionInfoExt.setParam(":VPUBLISH_USER_ID", paramActionInfoDAO.getPublish_user_id());
    localActionInfoExt.setParam(":VTITLE", paramActionInfoDAO.getTitle());
    localActionInfoExt.setParam(":VCONTENT", paramActionInfoDAO.getContent());
    localActionInfoExt.setParam(":VINFO_DATE", paramActionInfoDAO.getInfo_date());
    localActionInfoExt.setParam(":VINFO_STATE", paramActionInfoDAO.getInfo_state());
    localActionInfoExt.setParam(":VREMARK", paramActionInfoDAO.getRemark());
    localActionInfoExt.setParam(":VRSRV_STR10", paramActionInfoDAO.getRsrv_str10());
    this.tradeQuery.executeBy(localActionInfoExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateActionInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateActionInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_CUST_ID");
      String str2 = paramBuffers.getString("OWN_ID");
      String str3 = paramBuffers.getString("ENTITY_TYPE");
      String str4 = paramBuffers.getString("ENTITY_ID");
      String str5 = paramBuffers.getString("SUBJECT_TAG");
      String str6 = paramBuffers.getString("TITLE");
      String str7 = paramBuffers.getString("CONTENT");
      String str8 = paramBuffers.getString("INFO_DATE");
      String str9 = paramBuffers.getString("REMARK");
      ActionInfoDAO localActionInfoDAO = new ActionInfoDAO();
      localActionInfoDAO.setCust_id(str1);
      localActionInfoDAO.setOwn_id(str2);
      localActionInfoDAO.setEntity_id(str4);
      localActionInfoDAO.setEntity_type(str3);
      localActionInfoDAO.setSubject_tag(str5);
      localActionInfoDAO.setTitle(str6);
      localActionInfoDAO.setInfo_date(str8);
      localActionInfoDAO.setContent(str7);
      localActionInfoDAO.setRemark(str9);
      i = updateActionInfo(localActionInfoDAO);
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
    this.log.LOG_INFO("退出updateActionInfo方法...");
  }

  public int updateActionInfo(ActionInfoDAO paramActionInfoDAO)
    throws SaasApplicationException
  {
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VCUST_ID", paramActionInfoDAO.getCust_id());
    localActionInfoExt.setParam(":VOWN_ID", paramActionInfoDAO.getOwn_id());
    localActionInfoExt.setParam(":VENTITY_ID", paramActionInfoDAO.getEntity_id());
    localActionInfoExt.setParam(":VENTITY_TYPE", paramActionInfoDAO.getEntity_type());
    localActionInfoExt.setParam(":VSUBJECT_TAG", paramActionInfoDAO.getSubject_tag());
    localActionInfoExt.setParam(":VTITLE", paramActionInfoDAO.getTitle());
    localActionInfoExt.setParam(":VINFO_DATE", paramActionInfoDAO.getInfo_date());
    localActionInfoExt.setParam(":VCONTENT", paramActionInfoDAO.getContent());
    localActionInfoExt.setParam(":VREMARK", paramActionInfoDAO.getRemark());
    this.tradeQuery.executeBy(localActionInfoExt.insBy("UPDAT_BY_ALL"));
    return 0;
  }

  public void deleteActionInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteActionInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_CUST_ID");
      String str2 = paramBuffers.getString("OWN_ID");
      String str3 = paramBuffers.getString("ENTITY_TYPE");
      String str4 = paramBuffers.getString("ENTITY_ID");
      ActionInfoDAO localActionInfoDAO = new ActionInfoDAO();
      localActionInfoDAO.setCust_id(str1);
      localActionInfoDAO.setOwn_id(str2);
      localActionInfoDAO.setEntity_id(str4);
      localActionInfoDAO.setEntity_type(str3);
      i = deleteActionInfo(localActionInfoDAO);
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
    this.log.LOG_INFO("退出deleteActionInfo方法...");
  }

  public int deleteActionInfo(ActionInfoDAO paramActionInfoDAO)
    throws SaasApplicationException
  {
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VCUST_ID", paramActionInfoDAO.getCust_id());
    localActionInfoExt.setParam(":VOWN_ID", paramActionInfoDAO.getOwn_id());
    localActionInfoExt.setParam(":VENTITY_ID", paramActionInfoDAO.getEntity_id());
    localActionInfoExt.setParam(":VENTITY_TYPE", paramActionInfoDAO.getEntity_type());
    this.tradeQuery.executeBy(localActionInfoExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public ArrayList getActionByIdx(String paramString)
    throws SaasApplicationException
  {
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VENTITY_ID", paramString);
    ArrayList localArrayList = localActionInfoExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public ArrayList getActionByPubId(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VCUST_ID", paramString1);
    localActionInfoExt.setParam(":VOWN_ID", paramString2);
    localActionInfoExt.setParam(":VPUBLISH_USER_ID", paramString3);
    ArrayList localArrayList = localActionInfoExt.selByList("SEL_BY_ACTION");
    return localArrayList;
  }

  public int getActionByCt(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VCUST_ID", paramString1);
    localActionInfoExt.setParam(":VOWN_ID", paramString2);
    localActionInfoExt.setParam(":VPUBLISH_USER_ID", paramString3);
    ArrayList localArrayList = localActionInfoExt.selByList("SEL_BY_ACTION_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getActionByOpp(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VCUST_ID", paramString1);
    localActionInfoExt.setParam(":VENTITY_TYPE", paramString2);
    ArrayList localArrayList = localActionInfoExt.selByList("SEL_ACTION_BY_OPP", paramInt, 20);
    return localArrayList;
  }

  public int getActionByOpp(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VCUST_ID", paramString1);
    localActionInfoExt.setParam(":VENTITY_TYPE", paramString2);
    ArrayList localArrayList = localActionInfoExt.selByList("SEL_ACTION_BY_OPP");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getActionByOppOO(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VCUST_ID", paramString1);
    localActionInfoExt.setParam(":VENTITY_TYPE", paramString2);
    localActionInfoExt.setParam(":VENTITY_ID", paramString4);
    localActionInfoExt.setParam(":VOWN_ID", paramString3);
    ArrayList localArrayList = localActionInfoExt.selByList("SEL_ACTION_BY_OPPOO");
    return localArrayList;
  }

  public ArrayList getNewAction(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ActionInfoExt localActionInfoExt = new ActionInfoExt();
    localActionInfoExt.setParam(":VCUST_ID", paramString1);
    localActionInfoExt.setParam(":VENTITY_TYPE", paramString2);
    ArrayList localArrayList = localActionInfoExt.selByList("SEL_NEW_ACTION_BY_ENTITY");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.actionMgr.ActionMgr
 * JD-Core Version:    0.6.0
 */