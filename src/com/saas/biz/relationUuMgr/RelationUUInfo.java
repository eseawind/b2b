package com.saas.biz.relationUuMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.relationuuDAO.RelationuuDAO;
import com.saas.biz.dao.relationuuDAO.RelationuuExt;
import com.saas.biz.dao.userDAO.UserExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RelationUUInfo
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

  public void addRelationUU(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addRelationUU方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      RelationuuDAO localRelationuuDAO = new RelationuuDAO();
      String str1 = paramBuffers.getString("RELATION_UU_CODE");
      String str2 = paramBuffers.getString("USER_ID");
      String str3 = paramBuffers.getString("SESSION_USER_ID");
      String str4 = paramBuffers.getString("END_DATE");
      localRelationuuDAO.setEnd_date(str4);
      localRelationuuDAO.setRelation_type_code(str1);
      localRelationuuDAO.setUser_id_a(str2);
      localRelationuuDAO.setUser_id_b(str3);
      i = addRelationUU(localRelationuuDAO);
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
    this.log.LOG_INFO("退出addRelationUU方法...");
  }

  public int addRelationUU(RelationuuDAO paramRelationuuDAO)
    throws SaasApplicationException
  {
    String str1 = paramRelationuuDAO.getRelation_type_code();
    String str2 = paramRelationuuDAO.getUser_id_b();
    String str3 = paramRelationuuDAO.getUser_id_a();
    String str4 = "0";
    boolean bool = checkUserRelation(str1, str2, str4);
    if (bool)
    {
      paramRelationuuDAO.setRole_code_b("1");
      saveRelationUU(paramRelationuuDAO);
    }
    else
    {
      paramRelationuuDAO.setRole_code_b("0");
      paramRelationuuDAO.setUser_id_a(this.comm.GenTradeId());
      saveRelationUU(paramRelationuuDAO);
      RelationuuDAO localRelationuuDAO = new RelationuuDAO();
      localRelationuuDAO.setRole_code_b("1");
      localRelationuuDAO.setEnd_date(paramRelationuuDAO.getEnd_date());
      localRelationuuDAO.setRelation_type_code(paramRelationuuDAO.getRelation_type_code());
      localRelationuuDAO.setUser_id_a(str3);
      localRelationuuDAO.setUser_id_b(paramRelationuuDAO.getUser_id_b());
      saveRelationUU(localRelationuuDAO);
    }
    return 0;
  }

  public int saveRelationUU(RelationuuDAO paramRelationuuDAO)
    throws SaasApplicationException
  {
    boolean bool = checkExistRelation(paramRelationuuDAO.getRelation_type_code(), paramRelationuuDAO.getUser_id_a(), paramRelationuuDAO.getRole_code_b());
    RelationuuExt localRelationuuExt;
    if (bool)
    {
      localRelationuuExt = new RelationuuExt();
      localRelationuuExt.setParam(":VUSER_ID_A", paramRelationuuDAO.getUser_id_a());
      localRelationuuExt.setParam(":VUSER_ID_B", paramRelationuuDAO.getUser_id_b());
      localRelationuuExt.setParam(":VRELATION_TYPE_CODE", paramRelationuuDAO.getRelation_type_code());
      localRelationuuExt.setParam(":VROLE_CODE_B", paramRelationuuDAO.getRole_code_b());
      localRelationuuExt.setParam(":VEND_DATE", paramRelationuuDAO.getEnd_date());
      this.tradeQuery.executeBy(localRelationuuExt.insBy("UPDATE_BY_ALL"));
    }
    else
    {
      localRelationuuExt = new RelationuuExt();
      localRelationuuExt.setParam(":VUSER_ID_A", paramRelationuuDAO.getUser_id_a());
      localRelationuuExt.setParam(":VUSER_ID_B", paramRelationuuDAO.getUser_id_b());
      localRelationuuExt.setParam(":VRELATION_TYPE_CODE", paramRelationuuDAO.getRelation_type_code());
      localRelationuuExt.setParam(":VROLE_CODE_B", paramRelationuuDAO.getRole_code_b());
      localRelationuuExt.setParam(":VEND_DATE", paramRelationuuDAO.getEnd_date());
      this.tradeQuery.executeBy(localRelationuuExt.insBy("INS_BY_ALL"));
    }
    return 0;
  }

  public boolean checkUserRelation(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入检测建立关系开始..." + paramString1 + "|" + paramString2 + "|" + paramString3);
    boolean i = false;
    RelationuuExt localRelationuuExt = new RelationuuExt();
    localRelationuuExt.setParam(":VUSER_ID_B", paramString2);
    localRelationuuExt.setParam(":VRELATION_TYPE_CODE", paramString1);
    localRelationuuExt.setParam(":VROLE_CODE_B", paramString3);
    ArrayList localArrayList = localRelationuuExt.selByList("SEL_BY_CHECK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = true;
    this.log.LOG_INFO("退出检测建立关系开始..." + paramString2 + paramString1);
    return i;
  }

  public boolean checkExistRelation(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入checkExistRelation开始...");
    boolean i = false;
    RelationuuExt localRelationuuExt = new RelationuuExt();
    localRelationuuExt.setParam(":VUSER_ID_A", paramString2);
    localRelationuuExt.setParam(":VRELATION_TYPE_CODE", paramString1);
    localRelationuuExt.setParam(":VROLE_CODE_B", paramString3);
    ArrayList localArrayList = localRelationuuExt.selByList("SEL_BY_CHECK_CON");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = true;
    this.log.LOG_INFO("退出checkExistRelation...");
    return i;
  }

  public ArrayList getContactList(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    RelationuuExt localRelationuuExt = new RelationuuExt();
    localRelationuuExt.setParam(":VUSER_ID", paramString1);
    localRelationuuExt.setParam(":VROLE_CODE_B", paramString2);
    localRelationuuExt.setParam(":VRELATION_TYPE_CODE", "0");
    localArrayList = localRelationuuExt.selByList("SEL_BY_USER", paramInt, 20);
    return localArrayList;
  }

  public int getContactSum(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    RelationuuExt localRelationuuExt = new RelationuuExt();
    localRelationuuExt.setParam(":VUSER_ID", paramString1);
    localRelationuuExt.setParam(":VROLE_CODE_B", paramString2);
    localArrayList = localRelationuuExt.selByList("SEL_BY_USER_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public String getJsonStore(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    RelationuuExt localRelationuuExt = new RelationuuExt();
    localRelationuuExt.setParam(":VUSER_ID", paramString1);
    localRelationuuExt.setParam(":VROLE_CODE_B", paramString2);
    localRelationuuExt.setParam(":VRELATION_TYPE_CODE", "0");
    localArrayList = localRelationuuExt.selByList("SEL_BY_USER", paramInt2, paramInt1);
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i = getContactSum(paramString1, paramString2);
    localJSONObject1.put("totalCount", Integer.valueOf(i));
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int j = 0; j < localArrayList.size(); j++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(j);
        String str2 = localHashMap.get("cust_id").toString();
        String str3 = localHashMap.get("cust_name").toString();
        String str4 = "";
        if (localHashMap.get("phone") != null)
          str4 = localHashMap.get("phone").toString();
        String str5 = "";
        if (localHashMap.get("home_addr") != null)
          str5 = localHashMap.get("home_addr").toString();
        String str6 = "";
        if (localHashMap.get("email") != null)
          str6 = localHashMap.get("email").toString();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("id", str2);
        localJSONObject2.put("name", str3);
        localJSONObject2.put("phone", str4);
        localJSONObject2.put("addr", str5);
        localJSONObject2.put("email", str6);
        localJSONArray.add(localJSONObject2);
      }
    localJSONObject1.put("root", localJSONArray);
    str1 = localJSONObject1.toString();
    return str1;
  }

  public Map getUserByCustId(String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("cust_id=====" + paramString);
    HashMap localHashMap1 = new HashMap();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString);
    localUserExt.setParam(":VUSER_STATE", "0");
    ArrayList localArrayList = localUserExt.selByList("SEL_CUST_BY_IDX");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = localHashMap2.get("user_id").toString();
        String str2 = localHashMap2.get("user_name").toString();
        localHashMap1.put(str1, str2);
      }
    this.log.LOG_INFO("======" + localHashMap1);
    return localHashMap1;
  }

  public Map getContactUserByCustId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("cust_id=====" + paramString1 + "user_id==" + paramString2);
    HashMap localHashMap1 = new HashMap();
    UserExt localUserExt = new UserExt();
    localUserExt.setParam(":VCUST_ID", paramString1);
    localUserExt.setParam(":VUSER_STATE", "0");
    ArrayList localArrayList = localUserExt.selByList("SEL_CUST_BY_IDX");
    List localList = getContactByList(paramString2, "1");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = localHashMap2.get("user_id").toString();
        String str2 = localHashMap2.get("user_name").toString();
        if (localList.contains(str1))
          continue;
        localHashMap1.put(str1, str2);
      }
    this.log.LOG_INFO("======" + localHashMap1);
    return localHashMap1;
  }

  public List<String> getContactByList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = getContactList(paramString1, paramString2);
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList2.get(i);
        String str = localHashMap.get("user_id").toString();
        localArrayList1.add(str);
      }
    return localArrayList1;
  }

  public ArrayList getContactList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationuuExt localRelationuuExt = new RelationuuExt();
    localRelationuuExt.setParam(":VUSER_ID", paramString1);
    localRelationuuExt.setParam(":VROLE_CODE_B", paramString2);
    localRelationuuExt.setParam(":VRELATION_TYPE_CODE", "0");
    localArrayList = localRelationuuExt.selByList("SEL_BY_USER");
    return localArrayList;
  }

  public ArrayList getNewContactList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RelationuuExt localRelationuuExt = new RelationuuExt();
    localRelationuuExt.setParam(":VUSER_ID", paramString1);
    localRelationuuExt.setParam(":VROLE_CODE_B", paramString2);
    localRelationuuExt.setParam(":VRELATION_TYPE_CODE", "0");
    localArrayList = localRelationuuExt.selByList("SEL_NEW_CONTACT_BY_FIVE");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.relationUuMgr.RelationUUInfo
 * JD-Core Version:    0.6.0
 */