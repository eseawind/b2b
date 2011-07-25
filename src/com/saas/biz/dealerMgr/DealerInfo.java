package com.saas.biz.dealerMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.dealerDAO.DealerExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class DealerInfo
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

  public void addDealerInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addDealerInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("OBJ_CUST_ID");
    String str3 = paramBuffers.getString("COMPANY_ADDRESS");
    String str4 = paramBuffers.getString("FIELD_STATUS");
    String str5 = paramBuffers.getString("BRANCH_STORE_NUMBER");
    String str6 = paramBuffers.getString("SERVICE_CONDITION");
    String str7 = paramBuffers.getString("M_SALES_VOLUME");
    String str8 = paramBuffers.getString("Y_SALES_VOLUME");
    String str9 = paramBuffers.getString("ACT_BRAND");
    String str10 = paramBuffers.getString("INVENTORY_MGR");
    String str11 = paramBuffers.getString("BACK_CONDITION");
    String str12 = paramBuffers.getString("FINANCIAL_MGR");
    String str13 = paramBuffers.getString("COOPERATE");
    String str14 = paramBuffers.getString("TRANSPORT_CAPACITY");
    String str15 = paramBuffers.getString("STAFF_POPULATION");
    String str16 = paramBuffers.getString("SESSION_USER_ID");
    String str17 = paramBuffers.getString("IN_DATE");
    String str18 = paramBuffers.getString("REMARK");
    int j = 0;
    j = checkDealer(str1, str2);
    try
    {
      if (j == 0)
        i = addDealerInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18);
      else
        i = updateDealerInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18);
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
    this.log.LOG_INFO("退出addDealerInfo方法...");
  }

  public int addDealerInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
    throws SaasApplicationException
  {
    DealerExt localDealerExt = new DealerExt();
    localDealerExt.setParam(":VCUST_ID", paramString1);
    localDealerExt.setParam(":VOBJ_CUST_ID", paramString2);
    localDealerExt.setParam(":VCOMPANY_ADDRESS", paramString3);
    localDealerExt.setParam(":VFIELD_STATUS", paramString4);
    localDealerExt.setParam(":VBRANCH_STORE_NUMBER", paramString5);
    localDealerExt.setParam(":VSERVICE_CONDITION", paramString6);
    localDealerExt.setParam(":VM_SALES_VOLUME", paramString7);
    localDealerExt.setParam(":VY_SALES_VOLUME", paramString8);
    localDealerExt.setParam(":VACT_BRAND", paramString9);
    localDealerExt.setParam(":VINVENTORY_MGR", paramString10);
    localDealerExt.setParam(":VBACK_CONDITION", paramString11);
    localDealerExt.setParam(":VFINANCIAL_MGR", paramString12);
    localDealerExt.setParam(":VCOOPERATE", paramString13);
    localDealerExt.setParam(":VTRANSPORT_CAPACITY", paramString14);
    localDealerExt.setParam(":VSTAFF_POPULATION", paramString15);
    localDealerExt.setParam(":VOPER_USER_ID", paramString16);
    localDealerExt.setParam(":VIN_DATE", paramString17);
    localDealerExt.setParam(":VREMARK", paramString18);
    this.tradeQuery.executeBy(localDealerExt.insBy("INS_ALL_DEALER"));
    return 0;
  }

  public int updateDealerInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
    throws SaasApplicationException
  {
    DealerExt localDealerExt = new DealerExt();
    localDealerExt.setParam(":VCUST_ID", paramString1);
    localDealerExt.setParam(":VOBJ_CUST_ID", paramString2);
    localDealerExt.setParam(":VCOMPANY_ADDRESS", paramString3);
    localDealerExt.setParam(":VFIELD_STATUS", paramString4);
    localDealerExt.setParam(":VBRANCH_STORE_NUMBER", paramString5);
    localDealerExt.setParam(":VSERVICE_CONDITION", paramString6);
    localDealerExt.setParam(":VM_SALES_VOLUME", paramString7);
    localDealerExt.setParam(":VY_SALES_VOLUME", paramString8);
    localDealerExt.setParam(":VACT_BRAND", paramString9);
    localDealerExt.setParam(":VINVENTORY_MGR", paramString10);
    localDealerExt.setParam(":VBACK_CONDITION", paramString11);
    localDealerExt.setParam(":VFINANCIAL_MGR", paramString12);
    localDealerExt.setParam(":VCOOPERATE", paramString13);
    localDealerExt.setParam(":VTRANSPORT_CAPACITY", paramString14);
    localDealerExt.setParam(":VSTAFF_POPULATION", paramString15);
    localDealerExt.setParam(":VOPER_USER_ID", paramString16);
    localDealerExt.setParam(":VIN_DATE", paramString17);
    localDealerExt.setParam(":VREMARK", paramString18);
    this.tradeQuery.executeBy(localDealerExt.insBy("UPDATE_ALL_DEALER"));
    return 0;
  }

  public int checkDealer(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    DealerExt localDealerExt = new DealerExt();
    localDealerExt.setParam(":VCUST_ID", paramString1);
    localDealerExt.setParam(":VOBJ_CUST_ID", paramString2);
    localArrayList = localDealerExt.selByList("SEL_ONE_DEALER_CHECK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public HashMap getOneDealer(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    DealerExt localDealerExt = new DealerExt();
    HashMap localHashMap = new HashMap();
    localDealerExt.setParam(":VCUST_ID", paramString1);
    localDealerExt.setParam(":VOBJ_CUST_ID", paramString2);
    localArrayList = localDealerExt.selByList("SEL_ONE_DEALER_CHECK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dealerMgr.DealerInfo
 * JD-Core Version:    0.6.0
 */