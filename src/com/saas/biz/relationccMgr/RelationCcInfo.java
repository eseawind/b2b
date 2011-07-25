package com.saas.biz.relationccMgr;

import com.saas.biz.dao.relationccDAO.RelationCcDAO;
import com.saas.biz.dao.relationccDAO.RelationCcExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RelationCcInfo
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

  public void addCustomerRelation(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addProductInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("RELA_CLASS");
    try
    {
      RelationCcDAO localRelationCcDAO = new RelationCcDAO();
      localRelationCcDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
      localRelationCcDAO.setObj_cust_id(paramBuffers.getString("CUST_ID"));
      localRelationCcDAO.setRelation_type_code(paramBuffers.getString("RELATION_TYPE_CODE"));
      localRelationCcDAO.setEnd_date("2050-12-30");
      localRelationCcDAO.setUpdate_staff_id(paramBuffers.getString("SESSION_USER_ID"));
      localRelationCcDAO.setRemark(paramBuffers.getString("USER_ID"));
      localRelationCcDAO.setRela_class(str);
      i = addCustomerRelation(localRelationCcDAO);
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
    this.log.LOG_INFO("退出addCustomerRelation方法...");
  }

  public int addCustomerRelation(RelationCcDAO paramRelationCcDAO)
    throws SaasApplicationException
  {
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramRelationCcDAO.getCust_id());
    localRelationCcExt.setParam(":VOBJ_CUST_ID", paramRelationCcDAO.getObj_cust_id());
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramRelationCcDAO.getRelation_type_code());
    localRelationCcExt.setParam(":VEND_DATE", paramRelationCcDAO.getEnd_date());
    localRelationCcExt.setParam(":VUPDATE_STAFF_ID", paramRelationCcDAO.getUpdate_staff_id());
    localRelationCcExt.setParam(":VRELA_CLASS", paramRelationCcDAO.getRela_class());
    localRelationCcExt.setParam(":VREMARK", paramRelationCcDAO.getRemark());
    this.tradeQuery.executeBy(localRelationCcExt.insBy("INS_BY_CUSTOMER"));
    return 0;
  }

  public ArrayList getRelationByCustId(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString);
    localArrayList = localRelationCcExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getRelationByCustId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString);
    localArrayList = localRelationCcExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public int getRelationNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString);
    localArrayList = localRelationCcExt.selByList("SEL_COUNT_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      int i = 0;
      if (localHashMap.get("ct") != null)
        i = Integer.parseInt(localHashMap.get("ct").toString());
      return i;
    }
    return 0;
  }

  public void updateCustomerRelation(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateCustomerRelation方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_CUST_ID");
      String str2 = paramBuffers.getString("OBJ_CUST_ID");
      String str3 = paramBuffers.getString("RELATION_TYPE_CODE");
      i = updateCustomerRelation(str1, str2, str3);
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
    this.log.LOG_INFO("退出updateCustomerRelation方法...");
  }

  public int updateCustomerRelation(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    RelationCcExt localRelationCcExt = new RelationCcExt();
    this.log.LOG_INFO("========[" + paramString1 + "]==========[" + paramString2 + "]===========[" + paramString3 + "]===============");
    localRelationCcExt.setParam(":VCUST_ID", paramString1.trim());
    localRelationCcExt.setParam(":VOBJ_CUST_ID", paramString2.trim());
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString3);
    this.tradeQuery.executeBy(localRelationCcExt.insBy("DEL_BY_OBJID"));
    return 0;
  }

  public void updateCustomerRelationByObjId(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateCustomerRelationByObjId方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_USER_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("OBJ_CUST_ID");
    String str4 = paramBuffers.getString("RELATION_TYPE_CODE");
    String str5 = paramBuffers.getString("RELA_CLASS");
    try
    {
      i = updateCustomerRelationByObjId(str3, str2, str1, str4, str5);
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
    this.log.LOG_INFO("退出updateCustomerRelationByObjId方法...");
  }

  public int updateCustomerRelationByObjId(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VOBJ_CUST_ID", paramString1);
    localRelationCcExt.setParam(":VCUST_ID", paramString2);
    localRelationCcExt.setParam(":VUPDATE_STAFF_ID", paramString3);
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString4);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString5);
    this.tradeQuery.executeBy(localRelationCcExt.insBy("UPDATE_BY_OBJID"));
    return 0;
  }

  public ArrayList getRelationByObjId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VOBJ_CUST_ID", paramString);
    localArrayList = localRelationCcExt.selByList("SEL_BY_OBJ_ID");
    return localArrayList;
  }

  public ArrayList getRelationByCustName(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VCUST_NAME", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_BY_RELA_NAME");
    return localArrayList;
  }

  public ArrayList getRelationByRelaType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_BY_RELA_CLASS_TYPE");
    return localArrayList;
  }

  public ArrayList getRelationPageByType(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_BY_RELA_CLASS_TYPE", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getDealerByType(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_DEALER_BY_TYPE", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getCustByRelationTypeCode(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_CUST_BY_RELATION_TYPE_CODE", paramInt, 20);
    return localArrayList;
  }

  public int getCustByRelationTypeCode(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_CUST_BY_RELATION_TYPE_CODE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public int getCustomerLevel(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString3);
    localArrayList = localRelationCcExt.selByList("SEL_BY_RELA_CT");
    this.log.LOG_INFO(":" + localRelationCcExt.insBy("SEL_BY_RELA_CT"));
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getRelationJSONByType(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_ALLOPP_BY_TYPE", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getAllOppPageByType(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getAllOppPageByType方法...");
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_ALLOPP_BY_TYPE", paramInt, 20);
    return localArrayList;
  }

  public int getAllOppByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_ALLOPP_BY_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getCustomerByRelaClass(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_BY_RELA_CLASS");
    return localArrayList;
  }

  public ArrayList getCoustomerById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString);
    localArrayList = localRelationCcExt.selByList("SEL_COU_BY_ID");
    return localArrayList;
  }

  public ArrayList getCoustomerByArea(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRSRV_STR1", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_BY_AREA");
    return localArrayList;
  }

  public ArrayList getCoustomerInfoByArea(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRSRV_STR1", paramString2);
    localRelationCcExt.setParam(":VCHANNELS_ID", paramString3);
    localArrayList = localRelationCcExt.selByList("SEL_BY_AREA_ID");
    return localArrayList;
  }

  public void updateCustomerRelationByArea(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateCustomerRelation方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CHANNELS_ID_GRP");
    String str3 = paramBuffers.getString("RSRV_STR1");
    try
    {
      i = updateCustomerRelationByArea(str1, str2, str3);
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
    this.log.LOG_INFO("退出updateCustomerRelation方法...");
  }

  public int updateCustomerRelationByArea(String paramString1, String paramString2, String paramString3)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString2, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken();
      RelationCcExt localRelationCcExt = new RelationCcExt();
      localRelationCcExt.setParam(":VCUST_ID", paramString1);
      localRelationCcExt.setParam(":VOBJ_CUST_ID", str);
      localRelationCcExt.setParam(":VRSRV_STR1", paramString3);
      this.tradeQuery.executeBy(localRelationCcExt.insBy("UP_OR_DEL"));
    }
    return 0;
  }

  public ArrayList getCustomerByRelaUpClass(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_BY_RELA_UP_CLASS");
    return localArrayList;
  }

  public ArrayList getCByRelaClass(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_BY_UP_CLASS");
    return localArrayList;
  }

  public int getRelationByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_BY_RELA_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public int getPageSizeByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString2);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString1);
    localArrayList = localRelationCcExt.selByList("SEL_BY_TYPE_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getSelfdefinition(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString);
    localArrayList = localRelationCcExt.selByList("SEL_BY_GROUP_TYPE");
    return localArrayList;
  }

  public ArrayList getRelationByCustNameLike(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    paramInt *= 20;
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VCUST_NAME", "%" + paramString2.trim() + "%");
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString3);
    ArrayList localArrayList = localRelationCcExt.selByList("SEL_BY_LIKE_CUST_NAME", paramInt, 20);
    return localArrayList;
  }

  public int getRelationByCustNameLike(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VCUST_NAME", "%" + paramString2.trim() + "%");
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString3);
    ArrayList localArrayList = localRelationCcExt.selByList("SEL_BY_LIKE_CUST_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getDealerByCustNameLike(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
    ArrayList localArrayList = localRelationCcExt.selByList("SEL_LIKE_CUST_NAME", paramInt, 20);
    return localArrayList;
  }

  public int getDealerByCustNameLike(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
    ArrayList localArrayList = localRelationCcExt.selByList("SEL_LIKE_CUST_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getRelaByNameLike(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
    ArrayList localArrayList = localRelationCcExt.selByList("SEL_LIKE_CUST_NAME", paramInt, 20);
    return localArrayList;
  }

  public int getRelaByNameLike(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VCUST_NAME", "%" + paramString2 + "%");
    ArrayList localArrayList = localRelationCcExt.selByList("SEL_LIKE_CUST_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void updateEntClassRankOpp(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateEntClassRankOpp方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("USER_ID");
    String str3 = "2";
    String str4 = paramBuffers.getString("RELA_CLASS");
    RelationCcDAO localRelationCcDAO = new RelationCcDAO();
    try
    {
      localRelationCcDAO.setRela_class(str4);
      localRelationCcDAO.setCust_id(str1);
      localRelationCcDAO.setRelation_type_code(str3);
      localRelationCcDAO.setObj_cust_id(str2);
      i = updateEntClassRankOpp(localRelationCcDAO);
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
    this.log.LOG_INFO("退出updateEntClassRankOpp方法...");
  }

  public int updateEntClassRankOpp(RelationCcDAO paramRelationCcDAO)
    throws SaasApplicationException
  {
    String str1 = paramRelationCcDAO.getObj_cust_id();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      RelationCcExt localRelationCcExt = new RelationCcExt();
      localRelationCcExt.setParam(":VCUST_ID", paramRelationCcDAO.getCust_id());
      localRelationCcExt.setParam(":VOBJ_CUST_ID", str2);
      localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramRelationCcDAO.getRelation_type_code());
      localRelationCcExt.setParam(":VRELA_CLASS", paramRelationCcDAO.getRela_class());
      this.tradeQuery.executeBy(localRelationCcExt.insBy("UPDATE_BY_OPP_RANK"));
    }
    return 0;
  }

  public int getPateSizeByType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_BY_TYPE_SIZE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public String getConcatByJson(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    int i = getPateSizeByType(paramString1, paramString2);
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localArrayList = localRelationCcExt.selByList("SEL_ALLOPP_BY_TYPE", paramInt, 10);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int j = 0; j < localArrayList.size(); j++)
      {
        JSONObject localJSONObject2 = new JSONObject();
        HashMap localHashMap = (HashMap)localArrayList.get(j);
        String str2 = localHashMap.get("obj_cust_id").toString();
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (localHashMap.get("cust_name") != null)
          str3 = localHashMap.get("cust_name").toString();
        if (localHashMap.get("group_contact_phone") != null)
          str5 = localHashMap.get("group_contact_phone").toString();
        if (localHashMap.get("email") != null)
          str4 = localHashMap.get("email").toString();
        if (localHashMap.get("start_date") != null)
        {
          str6 = localHashMap.get("start_date").toString();
          if (str6.length() > 10)
            str6 = str6.substring(0, 10);
        }
        localJSONObject2.put("id", str2);
        localJSONObject2.put("name", str3);
        localJSONObject2.put("email", str4);
        localJSONObject2.put("phone", str5);
        localJSONObject2.put("date", str6);
        localJSONArray.add(localJSONObject2);
      }
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("root", localJSONArray);
    localJSONObject1.put("totalCount", Integer.valueOf(i));
    str1 = localJSONObject1.toString();
    return str1;
  }

  public ArrayList getCustomerByRelaClassAgain(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    paramInt *= 20;
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString3);
    ArrayList localArrayList = localRelationCcExt.selByList("SEL_CUST_RELA_CLASS", paramInt, 20);
    return localArrayList;
  }

  public int getCustomerByRelaClassAgain(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    RelationCcExt localRelationCcExt = new RelationCcExt();
    localRelationCcExt.setParam(":VCUST_ID", paramString1);
    localRelationCcExt.setParam(":VRELA_CLASS", paramString2);
    localRelationCcExt.setParam(":VRELATION_TYPE_CODE", paramString3);
    ArrayList localArrayList = localRelationCcExt.selByList("SEL_CUST_RELA_CLASS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.relationccMgr.RelationCcInfo
 * JD-Core Version:    0.6.0
 */