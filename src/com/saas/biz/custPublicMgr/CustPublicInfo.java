package com.saas.biz.custPublicMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.custPublicDAO.CustPublicExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CustPublicInfo
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

  public void addCustPublicInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addCustPublicInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("OBJ_CUST_ID");
    String str3 = paramBuffers.getString("PARAM_ID");
    String str4 = paramBuffers.getString("PARAM_NAME");
    String str5 = paramBuffers.getString("PARAM_VALUE");
    String str6 = paramBuffers.getString("SESSION_USER_ID");
    String str7 = paramBuffers.getString("IN_DATE");
    String str8 = paramBuffers.getString("REMARK");
    String str9 = "";
    String[] arrayOfString = str4.split(str9);
    if (arrayOfString[1].equals("|"))
    {
      i = 0;
    }
    else
    {
      String str10 = "";
      StringTokenizer localStringTokenizer1 = new StringTokenizer(str3, "|");
      for (int j = getMaxParamNo(str1, str2); localStringTokenizer1.hasMoreTokens(); j++)
      {
        localStringTokenizer1.nextToken();
        str10 = str10 + String.valueOf(j) + "|";
      }
      int k = 0;
      StringTokenizer localStringTokenizer2 = new StringTokenizer(str3, "|");
      StringTokenizer localStringTokenizer3 = new StringTokenizer(str4, "|");
      StringTokenizer localStringTokenizer4 = new StringTokenizer(str5, "|");
      StringTokenizer localStringTokenizer5 = new StringTokenizer(str10, "|");
      String str11 = "";
      String str12 = "";
      String str13 = "";
      String str14 = "";
      while (localStringTokenizer2.hasMoreTokens())
      {
        str11 = localStringTokenizer2.nextToken();
        str12 = localStringTokenizer3.nextToken();
        str13 = localStringTokenizer4.nextToken();
        str14 = localStringTokenizer5.nextToken();
        k = checkCustPublic(str1, str2, str11);
        try
        {
          if (k == 0)
            i = addCustPublicInfo(str1, str2, str11, str14, str12, str13, str6, str7, str8);
          else
            i = updateCustPublicInfo(str1, str2, str11, str14, str12, str13, str6, str7, str8);
        }
        catch (Exception localException)
        {
          this.log.LOG_INFO(localException.getMessage());
        }
      }
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
    this.log.LOG_INFO("退出addCustPublicInfo方法...");
  }

  public int addCustPublicInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    throws SaasApplicationException
  {
    CustPublicExt localCustPublicExt = new CustPublicExt();
    localCustPublicExt.setParam(":VCUST_ID", paramString1);
    localCustPublicExt.setParam(":VOBJ_CUST_ID", paramString2);
    localCustPublicExt.setParam(":VPARAM_ID", paramString3);
    localCustPublicExt.setParam(":VPARAM_NO", paramString4);
    localCustPublicExt.setParam(":VPARAM_NAME", paramString5);
    localCustPublicExt.setParam(":VPARAM_VALUE", paramString6);
    localCustPublicExt.setParam(":VOPER_USER_ID", paramString7);
    localCustPublicExt.setParam(":VIN_DATE", paramString8);
    localCustPublicExt.setParam(":VREMARK", paramString9);
    this.tradeQuery.executeBy(localCustPublicExt.insBy("INS_ALL_CUSTPUBLIC"));
    return 0;
  }

  public int updateCustPublicInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    throws SaasApplicationException
  {
    CustPublicExt localCustPublicExt = new CustPublicExt();
    localCustPublicExt.setParam(":VCUST_ID", paramString1);
    localCustPublicExt.setParam(":VOBJ_CUST_ID", paramString2);
    localCustPublicExt.setParam(":VPARAM_ID", paramString3);
    localCustPublicExt.setParam(":VPARAM_NO", paramString4);
    localCustPublicExt.setParam(":VPARAM_NAME", paramString5);
    localCustPublicExt.setParam(":VPARAM_VALUE", paramString6);
    localCustPublicExt.setParam(":VOPER_USER_ID", paramString7);
    localCustPublicExt.setParam(":VIN_DATE", paramString8);
    localCustPublicExt.setParam(":VREMARK", paramString9);
    this.tradeQuery.executeBy(localCustPublicExt.insBy("UPDATE_ALL_CUSTPUBLIC"));
    return 0;
  }

  public int checkCustPublic(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    CustPublicExt localCustPublicExt = new CustPublicExt();
    localCustPublicExt.setParam(":VCUST_ID", paramString1);
    localCustPublicExt.setParam(":VOBJ_CUST_ID", paramString2);
    localCustPublicExt.setParam(":VPARAM_ID", paramString3);
    localArrayList = localCustPublicExt.selByList("SEL_ONE_CUSTPUBLIC_CHECK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public HashMap getOneCustPublic(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    CustPublicExt localCustPublicExt = new CustPublicExt();
    HashMap localHashMap = new HashMap();
    localCustPublicExt.setParam(":VCUST_ID", paramString1);
    localCustPublicExt.setParam(":VOBJ_CUST_ID", paramString2);
    localArrayList = localCustPublicExt.selByList("SEL_ONE_CUSTPUBLIC_CHECK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getServalCustPublic(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    CustPublicExt localCustPublicExt = new CustPublicExt();
    localCustPublicExt.setParam(":VCUST_ID", paramString1);
    localCustPublicExt.setParam(":VOBJ_CUST_ID", paramString2);
    localArrayList = localCustPublicExt.selByList("SEL_SERVAL_CUSTPUBLIC_CHECK");
    return localArrayList;
  }

  public void delCustPublicInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delCustPublicInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PARAM_ID");
    try
    {
      i = delCustPublicInfo(str1, str2);
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
    this.log.LOG_INFO("退出delCustPublicInfo方法...");
  }

  public int delCustPublicInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustPublicExt localCustPublicExt = new CustPublicExt();
    localCustPublicExt.setParam(":VCUST_ID", paramString1);
    localCustPublicExt.setParam(":VPARAM_ID", paramString2);
    this.tradeQuery.executeBy(localCustPublicExt.insBy("DEL_ONE_CUSTPUBLIC"));
    return 0;
  }

  public int getMaxParamNo(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    CustPublicExt localCustPublicExt = new CustPublicExt();
    HashMap localHashMap = new HashMap();
    int i = 0;
    localCustPublicExt.setParam(":VCUST_ID", paramString1);
    localCustPublicExt.setParam(":VOBJ_CUST_ID", paramString2);
    localArrayList = localCustPublicExt.selByList("SEL_MAX_PARAM_NO");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ct") != null)
        i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i + 1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.custPublicMgr.CustPublicInfo
 * JD-Core Version:    0.6.0
 */