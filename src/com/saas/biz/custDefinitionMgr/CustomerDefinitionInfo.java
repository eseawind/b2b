package com.saas.biz.custDefinitionMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.custDefinitionDAO.CustDefinitionDAO;
import com.saas.biz.dao.custDefinitionDAO.CustDefinitionExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerDefinitionInfo
  implements Serializable
{
  private static final long serialVersionUID = 1072594656114902775L;
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

  public void addCustomerParameter(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCustomerParameter方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("SUBSYS_CODE");
    String str3 = paramBuffers.getString("DEPART_GROUP");
    String str4 = paramBuffers.getString("ROLE_GROUP");
    String str5 = paramBuffers.getString("LEVE_GROUP");
    String str6 = paramBuffers.getString("TYPE_GROUP");
    String str7 = paramBuffers.getString("PARA_CODE1");
    String str8 = paramBuffers.getString("PARA_CODE2");
    String str9 = paramBuffers.getString("PARA_CODE3");
    String str10 = paramBuffers.getString("PARA_CODE4");
    String str11 = paramBuffers.getString("PARA_CODE5");
    String str12 = paramBuffers.getString("PARA_CODE6");
    String str13 = paramBuffers.getString("PARA_CODE7");
    String str14 = paramBuffers.getString("PARA_CODE8");
    String str15 = paramBuffers.getString("PARA_CODE9");
    String str16 = paramBuffers.getString("PARA_CODE10");
    String str17 = paramBuffers.getString("START_DATE");
    String str18 = paramBuffers.getString("END_DATE");
    String str19 = paramBuffers.getString("REMARK");
    String str20 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      CustDefinitionDAO localCustDefinitionDAO = new CustDefinitionDAO();
      localCustDefinitionDAO.setCust_id(str1);
      localCustDefinitionDAO.setSubsys_code(str2);
      localCustDefinitionDAO.setDepart_group(str3);
      localCustDefinitionDAO.setRole_group(str4);
      localCustDefinitionDAO.setLeve_group(str5);
      localCustDefinitionDAO.setType_group(str6);
      localCustDefinitionDAO.setPara_code1(str7);
      localCustDefinitionDAO.setPara_code2(str8);
      localCustDefinitionDAO.setPara_code3(str9);
      localCustDefinitionDAO.setPara_code4(str10);
      localCustDefinitionDAO.setPara_code5(str11);
      localCustDefinitionDAO.setPara_code6(str12);
      localCustDefinitionDAO.setPara_code7(str13);
      localCustDefinitionDAO.setPara_code8(str14);
      localCustDefinitionDAO.setPara_code9(str15);
      localCustDefinitionDAO.setPara_code10(str16);
      localCustDefinitionDAO.setStart_date(str17);
      localCustDefinitionDAO.setEnd_date(str18);
      localCustDefinitionDAO.setRemark(str19);
      localCustDefinitionDAO.setOper_user_id(str20);
      ArrayList localArrayList = checkCustomerDefinition(str1, str2);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        String str21 = "";
        if (localHashMap.get("id") != null)
        {
          str21 = localHashMap.get("id").toString();
          localCustDefinitionDAO.setId(str21);
          i = editCustomerParameter(localCustDefinitionDAO);
        }
      }
      else
      {
        i = addCustomerParameter(localCustDefinitionDAO);
      }
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
    this.log.LOG_INFO("退出addCustomerParameter方法...");
  }

  public int addCustomerParameter(CustDefinitionDAO paramCustDefinitionDAO)
    throws SaasApplicationException
  {
    CustDefinitionExt localCustDefinitionExt = new CustDefinitionExt();
    localCustDefinitionExt.setParam(":VCUST_ID", paramCustDefinitionDAO.getCust_id());
    localCustDefinitionExt.setParam(":VSUBSYS_CODE", paramCustDefinitionDAO.getSubsys_code());
    localCustDefinitionExt.setParam(":VDEPART_GROUP", paramCustDefinitionDAO.getDepart_group());
    localCustDefinitionExt.setParam(":VROLE_GROUP", paramCustDefinitionDAO.getRole_group());
    localCustDefinitionExt.setParam(":VLEVE_GROUP", paramCustDefinitionDAO.getLeve_group());
    localCustDefinitionExt.setParam(":VTYPE_GROUP", paramCustDefinitionDAO.getType_group());
    localCustDefinitionExt.setParam(":VPARA_CODE1", paramCustDefinitionDAO.getPara_code1());
    localCustDefinitionExt.setParam(":VPARA_CODE2", paramCustDefinitionDAO.getPara_code2());
    localCustDefinitionExt.setParam(":VPARA_CODE3", paramCustDefinitionDAO.getPara_code3());
    localCustDefinitionExt.setParam(":VPARA_CODE4", paramCustDefinitionDAO.getPara_code4());
    localCustDefinitionExt.setParam(":VPARA_CODE5", paramCustDefinitionDAO.getPara_code5());
    localCustDefinitionExt.setParam(":VPARA_CODE6", paramCustDefinitionDAO.getPara_code6());
    localCustDefinitionExt.setParam(":VPARA_CODE7", paramCustDefinitionDAO.getPara_code7());
    localCustDefinitionExt.setParam(":VPARA_CODE8", paramCustDefinitionDAO.getPara_code8());
    localCustDefinitionExt.setParam(":VPARA_CODE9", paramCustDefinitionDAO.getPara_code9());
    localCustDefinitionExt.setParam(":VPARA_CODE10", paramCustDefinitionDAO.getPara_code10());
    localCustDefinitionExt.setParam(":VSTART_DATE", paramCustDefinitionDAO.getStart_date());
    localCustDefinitionExt.setParam(":VEND_DATE", paramCustDefinitionDAO.getEnd_date());
    localCustDefinitionExt.setParam(":VREMARK", paramCustDefinitionDAO.getRemark());
    localCustDefinitionExt.setParam(":VOPER_USER_ID", paramCustDefinitionDAO.getOper_user_id());
    this.tradeQuery.executeBy(localCustDefinitionExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void editCustomerParameter(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入editCustomerParameter方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("SUBSYS_CODE");
    String str4 = paramBuffers.getString("DEPART_GROUP");
    String str5 = paramBuffers.getString("ROLE_GROUP");
    String str6 = paramBuffers.getString("LEVE_GROUP");
    String str7 = paramBuffers.getString("TYPE_GROUP");
    String str8 = paramBuffers.getString("PARA_CODE1");
    String str9 = paramBuffers.getString("PARA_CODE2");
    String str10 = paramBuffers.getString("PARA_CODE3");
    String str11 = paramBuffers.getString("PARA_CODE4");
    String str12 = paramBuffers.getString("PARA_CODE5");
    String str13 = paramBuffers.getString("PARA_CODE6");
    String str14 = paramBuffers.getString("PARA_CODE7");
    String str15 = paramBuffers.getString("PARA_CODE8");
    String str16 = paramBuffers.getString("PARA_CODE9");
    String str17 = paramBuffers.getString("PARA_CODE10");
    String str18 = paramBuffers.getString("START_DATE");
    String str19 = paramBuffers.getString("END_DATE");
    String str20 = paramBuffers.getString("REMARK");
    String str21 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      CustDefinitionDAO localCustDefinitionDAO = new CustDefinitionDAO();
      localCustDefinitionDAO.setId(str1);
      localCustDefinitionDAO.setCust_id(str2);
      localCustDefinitionDAO.setSubsys_code(str3);
      localCustDefinitionDAO.setDepart_group(str4);
      localCustDefinitionDAO.setRole_group(str5);
      localCustDefinitionDAO.setLeve_group(str6);
      localCustDefinitionDAO.setType_group(str7);
      localCustDefinitionDAO.setPara_code1(str8);
      localCustDefinitionDAO.setPara_code2(str9);
      localCustDefinitionDAO.setPara_code3(str10);
      localCustDefinitionDAO.setPara_code4(str11);
      localCustDefinitionDAO.setPara_code5(str12);
      localCustDefinitionDAO.setPara_code6(str13);
      localCustDefinitionDAO.setPara_code7(str14);
      localCustDefinitionDAO.setPara_code8(str15);
      localCustDefinitionDAO.setPara_code9(str16);
      localCustDefinitionDAO.setPara_code10(str17);
      localCustDefinitionDAO.setStart_date(str18);
      localCustDefinitionDAO.setEnd_date(str19);
      localCustDefinitionDAO.setRemark(str20);
      localCustDefinitionDAO.setOper_user_id(str21);
      i = editCustomerParameter(localCustDefinitionDAO);
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
    this.log.LOG_INFO("退出editCustomerParameter方法...");
  }

  public int editCustomerParameter(CustDefinitionDAO paramCustDefinitionDAO)
    throws SaasApplicationException
  {
    CustDefinitionExt localCustDefinitionExt = new CustDefinitionExt();
    localCustDefinitionExt.setParam(":VID", paramCustDefinitionDAO.getId());
    localCustDefinitionExt.setParam(":VCUST_ID", paramCustDefinitionDAO.getCust_id());
    localCustDefinitionExt.setParam(":VSUBSYS_CODE", paramCustDefinitionDAO.getSubsys_code());
    localCustDefinitionExt.setParam(":VDEPART_GROUP", paramCustDefinitionDAO.getDepart_group());
    localCustDefinitionExt.setParam(":VROLE_GROUP", paramCustDefinitionDAO.getRole_group());
    localCustDefinitionExt.setParam(":VLEVE_GROUP", paramCustDefinitionDAO.getLeve_group());
    localCustDefinitionExt.setParam(":VTYPE_GROUP", paramCustDefinitionDAO.getType_group());
    localCustDefinitionExt.setParam(":VPARA_CODE1", paramCustDefinitionDAO.getPara_code1());
    localCustDefinitionExt.setParam(":VPARA_CODE2", paramCustDefinitionDAO.getPara_code2());
    localCustDefinitionExt.setParam(":VPARA_CODE3", paramCustDefinitionDAO.getPara_code3());
    localCustDefinitionExt.setParam(":VPARA_CODE4", paramCustDefinitionDAO.getPara_code4());
    localCustDefinitionExt.setParam(":VPARA_CODE5", paramCustDefinitionDAO.getPara_code5());
    localCustDefinitionExt.setParam(":VPARA_CODE6", paramCustDefinitionDAO.getPara_code6());
    localCustDefinitionExt.setParam(":VPARA_CODE7", paramCustDefinitionDAO.getPara_code7());
    localCustDefinitionExt.setParam(":VPARA_CODE8", paramCustDefinitionDAO.getPara_code8());
    localCustDefinitionExt.setParam(":VPARA_CODE9", paramCustDefinitionDAO.getPara_code9());
    localCustDefinitionExt.setParam(":VPARA_CODE10", paramCustDefinitionDAO.getPara_code10());
    localCustDefinitionExt.setParam(":VSTART_DATE", paramCustDefinitionDAO.getStart_date());
    localCustDefinitionExt.setParam(":VEND_DATE", paramCustDefinitionDAO.getEnd_date());
    localCustDefinitionExt.setParam(":VREMARK", paramCustDefinitionDAO.getRemark());
    localCustDefinitionExt.setParam(":VOPER_USER_ID", paramCustDefinitionDAO.getOper_user_id());
    this.tradeQuery.executeBy(localCustDefinitionExt.insBy("EDIT_BY_ALL"));
    return 0;
  }

  public void delCustomerParameter(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delCustomerParameter方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ID");
    try
    {
      i = delCustomerParameter(str1, str2);
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
    this.log.LOG_INFO("退出delCustomerParameter方法...");
  }

  public int delCustomerParameter(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustDefinitionExt localCustDefinitionExt = new CustDefinitionExt();
    localCustDefinitionExt.setParam(":VCUST_ID", paramString1);
    localCustDefinitionExt.setParam(":VID", paramString2);
    this.tradeQuery.executeBy(localCustDefinitionExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public ArrayList getCustomerDefinitionByCust(String paramString)
    throws SaasApplicationException
  {
    CustDefinitionExt localCustDefinitionExt = new CustDefinitionExt();
    localCustDefinitionExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localCustDefinitionExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public ArrayList getCustomerDefinitionById(String paramString)
    throws SaasApplicationException
  {
    CustDefinitionExt localCustDefinitionExt = new CustDefinitionExt();
    localCustDefinitionExt.setParam(":VID", paramString);
    ArrayList localArrayList = localCustDefinitionExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public ArrayList checkCustomerDefinition(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustDefinitionExt localCustDefinitionExt = new CustDefinitionExt();
    localCustDefinitionExt.setParam(":VCUST_ID", paramString1);
    localCustDefinitionExt.setParam(":VSUBSYS_CODE", paramString2);
    ArrayList localArrayList = localCustDefinitionExt.selByList("SEL_BY_SYSCODE");
    return localArrayList;
  }

  public HashMap getAuditMap(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    ArrayList localArrayList = getCustomerDefinitionByCust(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str6 = "";
        String str7 = "";
        String str8 = "";
        String str9 = "";
        String str10 = "";
        if (localHashMap2.get("subsys_code") != null)
          str6 = localHashMap2.get("subsys_code").toString();
        if (localHashMap2.get("depart_group") != null)
          str7 = localHashMap2.get("depart_group").toString();
        if (localHashMap2.get("role_group") != null)
          str8 = localHashMap2.get("role_group").toString();
        if (localHashMap2.get("leve_group") != null)
          str9 = localHashMap2.get("leve_group").toString();
        if (localHashMap2.get("type_group") != null)
          str10 = localHashMap2.get("type_group").toString();
        str1 = str1 + str6 + "|";
        str2 = str2 + str7 + "|";
        str3 = str3 + str8 + "|";
        str4 = str4 + str9 + "|";
        str5 = str5 + str10 + "|";
      }
    localHashMap1.put("order_code", str1);
    return localHashMap1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.custDefinitionMgr.CustomerDefinitionInfo
 * JD-Core Version:    0.6.0
 */