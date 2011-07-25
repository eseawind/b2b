package com.saas.biz.pleaseResultMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.pleaseresultDAO.PleaseresultDAO;
import com.saas.biz.dao.pleaseresultDAO.PleaseresultExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class PleaseResultInfo
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

  public void addPleaseResultInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addPleaseResultInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    String str2 = paramBuffers.getString("CUST_ID");
    String str3 = paramBuffers.getString("TABLE_ID");
    String str4 = paramBuffers.getString("TABLE_NAME");
    String str5 = paramBuffers.getString("ITEMS_ID");
    String str6 = paramBuffers.getString("DEFAULT_VALUE");
    String str7 = paramBuffers.getString("NUM_VALUE");
    String str8 = paramBuffers.getString("ENABLE_TAG");
    String str9 = paramBuffers.getString("RES_NAME");
    String str10 = paramBuffers.getString("RES_USER_ID");
    String str11 = paramBuffers.getString("RES_DATE");
    String str12 = paramBuffers.getString("RES_ADDR");
    String str13 = paramBuffers.getString("RES_TYPE");
    String str14 = paramBuffers.getString("USER_NAME");
    String str15 = paramBuffers.getString("USER_ID");
    String str16 = paramBuffers.getString("CONTENT");
    String str17 = paramBuffers.getString("SESSION_USER_ID");
    String str18 = paramBuffers.getString("REMARK2");
    try
    {
      StringTokenizer localStringTokenizer1 = new StringTokenizer(str5, "|");
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      StringTokenizer localStringTokenizer2 = new StringTokenizer(str7, "|");
      while (localStringTokenizer2.hasMoreTokens())
        localArrayList1.add(localStringTokenizer2.nextToken());
      StringTokenizer localStringTokenizer3 = new StringTokenizer(str6, ",");
      while (localStringTokenizer3.hasMoreTokens())
        localArrayList2.add(localStringTokenizer3.nextToken());
      for (int j = 0; localStringTokenizer1.hasMoreTokens(); j++)
      {
        String str19 = localStringTokenizer1.nextToken();
        PleaseresultDAO localPleaseresultDAO = new PleaseresultDAO();
        localPleaseresultDAO.setTrade_id(str1);
        localPleaseresultDAO.setCust_id(str2);
        localPleaseresultDAO.setTable_id(str3);
        localPleaseresultDAO.setTable_name(str4);
        localPleaseresultDAO.setItems_id(str19);
        localPleaseresultDAO.setRe_value((String)localArrayList2.get(j));
        localPleaseresultDAO.setNum_value((String)localArrayList1.get(j));
        localPleaseresultDAO.setEnable_tag(str8);
        localPleaseresultDAO.setRes_name(str9);
        localPleaseresultDAO.setRes_user_id(str10);
        localPleaseresultDAO.setRes_date(str11);
        localPleaseresultDAO.setRes_addr(str12);
        localPleaseresultDAO.setRes_type(str13);
        localPleaseresultDAO.setUser_id(str15);
        localPleaseresultDAO.setUser_name(str14);
        localPleaseresultDAO.setRes_content(str16);
        localPleaseresultDAO.setOper_user_id(str17);
        localPleaseresultDAO.setRemark2(str18);
        i = addPleaseResultInfo(localPleaseresultDAO);
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
    this.log.LOG_INFO("退出addPleaseResultInfo方法...");
  }

  public int addPleaseResultInfo(PleaseresultDAO paramPleaseresultDAO)
    throws SaasApplicationException
  {
    PleaseresultExt localPleaseresultExt = new PleaseresultExt();
    localPleaseresultExt.setParam(":VTRADE_ID", paramPleaseresultDAO.getTrade_id());
    localPleaseresultExt.setParam(":VCUST_ID", paramPleaseresultDAO.getCust_id());
    localPleaseresultExt.setParam(":VTABLE_ID", paramPleaseresultDAO.getTable_id());
    localPleaseresultExt.setParam(":VTABLE_NAME", paramPleaseresultDAO.getTable_name());
    localPleaseresultExt.setParam(":VITEMS_ID", paramPleaseresultDAO.getItems_id());
    localPleaseresultExt.setParam(":VRE_VALUE", paramPleaseresultDAO.getRe_value());
    localPleaseresultExt.setParam(":VNUM_VALUE", paramPleaseresultDAO.getNum_value());
    localPleaseresultExt.setParam(":VENABLE_TAG", paramPleaseresultDAO.getEnable_tag());
    localPleaseresultExt.setParam(":VRES_NAME", paramPleaseresultDAO.getRes_name());
    localPleaseresultExt.setParam(":VRES_USER_ID", paramPleaseresultDAO.getRes_user_id());
    localPleaseresultExt.setParam(":VRES_DATE", paramPleaseresultDAO.getRes_date());
    localPleaseresultExt.setParam(":VRES_ADDR", paramPleaseresultDAO.getRes_addr());
    localPleaseresultExt.setParam(":VRES_TYPE", paramPleaseresultDAO.getRes_type());
    localPleaseresultExt.setParam(":VUSER_ID", paramPleaseresultDAO.getUser_id());
    localPleaseresultExt.setParam(":VUSER_NAME", paramPleaseresultDAO.getUser_name());
    localPleaseresultExt.setParam(":VRES_CONTENT", paramPleaseresultDAO.getRes_content());
    localPleaseresultExt.setParam(":VOPER_USER_ID", paramPleaseresultDAO.getOper_user_id());
    localPleaseresultExt.setParam(":VREMARK2", paramPleaseresultDAO.getRemark2());
    this.tradeQuery.executeBy(localPleaseresultExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void editPleaseResultInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入editPleaseResultInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("TABLE_ID");
    String str4 = paramBuffers.getString("TABLE_NAME");
    String str5 = paramBuffers.getString("ITEMS_ID");
    String str6 = paramBuffers.getString("DEFAULT_VALUE");
    String str7 = paramBuffers.getString("NUM_VALUE");
    String str8 = paramBuffers.getString("ENABLE_TAG");
    String str9 = paramBuffers.getString("RES_NAME");
    String str10 = paramBuffers.getString("RES_USER_ID");
    String str11 = paramBuffers.getString("RES_DATE");
    String str12 = paramBuffers.getString("RES_ADDR");
    String str13 = paramBuffers.getString("RES_TYPE");
    String str14 = paramBuffers.getString("USER_NAME");
    String str15 = paramBuffers.getString("USER_ID");
    String str16 = paramBuffers.getString("CONTENT");
    String str17 = paramBuffers.getString("SESSION_USER_ID");
    String str18 = paramBuffers.getString("REMARK2");
    try
    {
      StringTokenizer localStringTokenizer1 = new StringTokenizer(str5, "|");
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      StringTokenizer localStringTokenizer2 = new StringTokenizer(str7, "|");
      while (localStringTokenizer2.hasMoreTokens())
        localArrayList1.add(localStringTokenizer2.nextToken());
      StringTokenizer localStringTokenizer3 = new StringTokenizer(str6, ",");
      while (localStringTokenizer3.hasMoreTokens())
        localArrayList2.add(localStringTokenizer3.nextToken());
      for (int j = 0; localStringTokenizer1.hasMoreTokens(); j++)
      {
        String str19 = localStringTokenizer1.nextToken();
        PleaseresultDAO localPleaseresultDAO = new PleaseresultDAO();
        localPleaseresultDAO.setTrade_id(str2);
        localPleaseresultDAO.setCust_id(str1);
        localPleaseresultDAO.setTable_id(str3);
        localPleaseresultDAO.setTable_name(str4);
        localPleaseresultDAO.setItems_id(str19);
        localPleaseresultDAO.setRe_value((String)localArrayList2.get(j));
        localPleaseresultDAO.setNum_value((String)localArrayList1.get(j));
        localPleaseresultDAO.setEnable_tag(str8);
        localPleaseresultDAO.setRes_name(str9);
        localPleaseresultDAO.setRes_user_id(str10);
        localPleaseresultDAO.setRes_date(str11);
        localPleaseresultDAO.setRes_addr(str12);
        localPleaseresultDAO.setRes_type(str13);
        localPleaseresultDAO.setUser_id(str15);
        localPleaseresultDAO.setUser_name(str14);
        localPleaseresultDAO.setRes_content(str16);
        localPleaseresultDAO.setOper_user_id(str17);
        localPleaseresultDAO.setRemark2(str18);
        i = editPleaseResultInfo(localPleaseresultDAO);
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
    this.log.LOG_INFO("退出editPleaseResultInfo方法...");
  }

  public int editPleaseResultInfo(PleaseresultDAO paramPleaseresultDAO)
    throws SaasApplicationException
  {
    PleaseresultExt localPleaseresultExt = new PleaseresultExt();
    localPleaseresultExt.setParam(":VTRADE_ID", paramPleaseresultDAO.getTrade_id());
    localPleaseresultExt.setParam(":VCUST_ID", paramPleaseresultDAO.getCust_id());
    localPleaseresultExt.setParam(":VTABLE_ID", paramPleaseresultDAO.getTable_id());
    localPleaseresultExt.setParam(":VTABLE_NAME", paramPleaseresultDAO.getTable_name());
    localPleaseresultExt.setParam(":VITEMS_ID", paramPleaseresultDAO.getItems_id());
    localPleaseresultExt.setParam(":VRE_VALUE", paramPleaseresultDAO.getRe_value());
    localPleaseresultExt.setParam(":VNUM_VALUE", paramPleaseresultDAO.getNum_value());
    localPleaseresultExt.setParam(":VENABLE_TAG", paramPleaseresultDAO.getEnable_tag());
    localPleaseresultExt.setParam(":VRES_NAME", paramPleaseresultDAO.getRes_name());
    localPleaseresultExt.setParam(":VRES_USER_ID", paramPleaseresultDAO.getRes_user_id());
    localPleaseresultExt.setParam(":VRES_DATE", paramPleaseresultDAO.getRes_date());
    localPleaseresultExt.setParam(":VRES_ADDR", paramPleaseresultDAO.getRes_addr());
    localPleaseresultExt.setParam(":VRES_TYPE", paramPleaseresultDAO.getRes_type());
    localPleaseresultExt.setParam(":VUSER_ID", paramPleaseresultDAO.getUser_id());
    localPleaseresultExt.setParam(":VUSER_NAME", paramPleaseresultDAO.getUser_name());
    localPleaseresultExt.setParam(":VRES_CONTENT", paramPleaseresultDAO.getRes_content());
    localPleaseresultExt.setParam(":VOPER_USER_ID", paramPleaseresultDAO.getOper_user_id());
    localPleaseresultExt.setParam(":VREMARK2", paramPleaseresultDAO.getRemark2());
    this.tradeQuery.executeBy(localPleaseresultExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public ArrayList getResultListByItems(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    PleaseresultExt localPleaseresultExt = new PleaseresultExt();
    localPleaseresultExt.setParam(":VCUST_ID", paramString3);
    localPleaseresultExt.setParam(":VITEMS_ID", paramString1);
    localPleaseresultExt.setParam(":VTABLE_ID", paramString2);
    localPleaseresultExt.setParam(":VENABLE_TAG", "0");
    ArrayList localArrayList = localPleaseresultExt.selByList("SEL_BY_ITEMS");
    return localArrayList;
  }

  public ArrayList getResultByTradeId(String paramString)
    throws SaasApplicationException
  {
    PleaseresultExt localPleaseresultExt = new PleaseresultExt();
    localPleaseresultExt.setParam(":VTRADE_ID", paramString);
    ArrayList localArrayList = localPleaseresultExt.selByList("SEL_BY_TRADE_ID");
    return localArrayList;
  }

  public Map getResultByMap(String paramString)
    throws SaasApplicationException
  {
    Object localObject = new HashMap();
    PleaseresultExt localPleaseresultExt = new PleaseresultExt();
    localPleaseresultExt.setParam(":VITEMS_ID", paramString);
    ArrayList localArrayList = localPleaseresultExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localObject = (Map)localArrayList.get(0);
    return (Map)localObject;
  }

  public ArrayList getResultItems(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    PleaseresultExt localPleaseresultExt = new PleaseresultExt();
    localPleaseresultExt.setParam(":VCUST_ID", paramString2);
    localPleaseresultExt.setParam(":VTABLE_ID", paramString1);
    localArrayList = localPleaseresultExt.selByList("SEL_RES_ITEMS", paramInt, 20);
    return localArrayList;
  }

  public int getResultItemCt(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    PleaseresultExt localPleaseresultExt = new PleaseresultExt();
    localPleaseresultExt.setParam(":VCUST_ID", paramString2);
    localPleaseresultExt.setParam(":VTABLE_ID", paramString1);
    ArrayList localArrayList = localPleaseresultExt.selByList("SEL_RESULT_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.pleaseResultMgr.PleaseResultInfo
 * JD-Core Version:    0.6.0
 */