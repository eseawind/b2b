package com.saas.biz.commen;

import com.saas.biz.dao.commenDAO.CommparaDAO;
import com.saas.biz.dao.commenDAO.CommparaExt;
import com.saas.biz.dao.commenDAO.ParainfoExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class ParamethodMgr
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();
  commMethodMgr comm = new commMethodMgr();

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

  public void paraInfoList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入paraInfoList方法...");
    String str = paramBuffers.getString("CUST_TYPE");
    try
    {
      this.queryResult = paraInfoList(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出paraInfoList方法...");
  }

  public ArrayList paraInfoList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ParainfoExt localParainfoExt = new ParainfoExt();
    localParainfoExt.setParam(":VCUST_TYPE", paramString);
    localArrayList2 = localParainfoExt.selByList("SEL_BY_CUST_ID");
    Iterator localIterator = localArrayList2.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      HashMap localHashMap2 = new HashMap();
      if (localHashMap1.get("cust_name") != null)
        str1 = localHashMap1.get("cust_name").toString();
      try
      {
        str1 = new String(str1.getBytes("ISO8859_1"), "GB2312");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
      if (localHashMap1.get("cust_id") != null)
        str2 = localHashMap1.get("cust_id").toString();
      this.log.LOG_INFO("cust_id>>>>>" + str2);
      this.log.LOG_INFO("cust_name>>>>>" + str1);
      localHashMap2.put("cust_name", str1);
      localHashMap2.put("cust_id", str2);
      localArrayList1.add(localHashMap2);
    }
    return localArrayList1;
  }

  public String getParamMoneyByValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getCompareInfoByAttr(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if ((localHashMap.get("para_code1") != null) && (localHashMap.get("para_code1").equals(paramString2)))
          return str = localHashMap.get("para_code4").toString();
      }
    return str;
  }

  public ArrayList getCompareInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString1);
    localCommparaExt.setParam(":VPARAM_CODE", paramString2);
    localArrayList = localCommparaExt.selByList("SEL_BY_CODE");
    return localArrayList;
  }

  public ArrayList getCompareInfoByCode1(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString1);
    localCommparaExt.setParam(":VPARAM_CODE", paramString2);
    localCommparaExt.setParam(":VPARA_CODE1", paramString3);
    localArrayList = localCommparaExt.selByList("SEL_BY_CODE1");
    return localArrayList;
  }

  public String getBankAccouId(String paramString)
  {
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCommparaExt.selByList("SEL_EXIST_ACCOUNT");
    String str = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code23") != null)
        str = localHashMap.get("para_code23").toString();
    }
    return str;
  }

  public ArrayList getCompareInfoByAttr(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString);
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR");
    return localArrayList;
  }

  public ArrayList getCompareInfoByNotIN(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR_NOT_IN");
    return localArrayList;
  }

  public ArrayList getCompareInfoByAttrF(String paramString, int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString);
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getCompareInfoByAttrAndCode1(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localCommparaExt.setParam(":VPARA_CODE", paramString2);
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR_AND_CODE");
    return localArrayList;
  }

  public String getParaCode2ByParaCode1(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localArrayList = localCommparaExt.selByList("SEL_PARA_CODE2");
    String str = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code2") != null)
        str = localHashMap.get("para_code2").toString();
    }
    return str;
  }

  public String getParaCode2ByParam_code(String paramString)
    throws SaasApplicationException
  {
    String str1 = "";
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_CODE", paramString);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_PARA_CODE2_BY_CODE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        if (localHashMap.get("para_code2") != null)
          str2 = localHashMap.get("para_code2").toString();
        str1 = str1 + "<option value=" + str2 + ">" + str2 + "</option>";
      }
    return str1;
  }

  public Map getParaCode3ByParam_code(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_CODE", paramString);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_PARA_CODE2_BY_CODE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str = "";
        if (localHashMap2.get("para_code2") != null)
          str = localHashMap2.get("para_code2").toString();
        localHashMap1.put(str, str);
      }
    return localHashMap1;
  }

  public String getCustImgByParaCode1(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localArrayList = localCommparaExt.selByList("SEL_PARA_CODE2");
    HashMap localHashMap = (HashMap)localArrayList.get(0);
    String str = "";
    if (localHashMap.get("para_code4") != null)
      str = localHashMap.get("para_code4").toString();
    return str;
  }

  public String getParaCode3ByParaCode1(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("getParaCode3ByParaCode1方法开始...");
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localArrayList = localCommparaExt.selByList("SEL_PARA_CODE2");
    HashMap localHashMap = (HashMap)localArrayList.get(0);
    String str = "";
    if (localHashMap.get("para_code3") != null)
      str = localHashMap.get("para_code3").toString();
    this.log.LOG_INFO("getParaCode3ByParaCode1方法结束..." + str);
    return str;
  }

  public String getParaCode6ByParaCode1(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("getParaCode3ByParaCode1方法开始...");
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localArrayList = localCommparaExt.selByList("SEL_PARA_CODE2");
    HashMap localHashMap = (HashMap)localArrayList.get(0);
    String str = "";
    if (localHashMap.get("para_code6") != null)
      str = localHashMap.get("para_code6").toString();
    this.log.LOG_INFO("getParaCode3ByParaCode1方法结束..." + str);
    return str;
  }

  public String getJspBySubCode(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localArrayList = localCommparaExt.selByList("SEL_PARA_CODE2");
    HashMap localHashMap = (HashMap)localArrayList.get(0);
    String str = "";
    if (localHashMap.get("para_code7") != null)
      str = localHashMap.get("para_code7").toString();
    return str;
  }

  public String getParaCode5ByCustcClass(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = getCompareInfoByAttr(paramString1);
    String str1 = "";
    String str2 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("para_code1") != null)
          str1 = localHashMap.get("para_code1").toString();
        if (((!str1.equals(paramString2)) && (str1 != paramString2)) || (localHashMap.get("para_code5") == null))
          continue;
        str2 = localHashMap.get("para_code5").toString();
      }
    return str2;
  }

  public String getSelectItems(String paramString)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = getCompareInfoByAttr(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        String str3 = "";
        if (localHashMap.get("para_code1") != null)
          str2 = localHashMap.get("para_code1").toString();
        if (localHashMap.get("para_code2") != null)
          str3 = localHashMap.get("para_code2").toString();
        str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>";
      }
    return str1;
  }

  public String getSelectItemttt(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = getCompareInfoByAttr(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        String str3 = "";
        if (localHashMap.get("para_code1") != null)
          str2 = localHashMap.get("para_code1").toString();
        if (localHashMap.get("para_code2") != null)
          str3 = localHashMap.get("para_code2").toString();
        if (paramString2.equals(str2))
          str1 = str1 + "<option selected value=" + str2 + ">" + str3 + "</option>";
        else
          str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>";
      }
    return str1;
  }

  public String getPermissions(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getCompareInfoByAttr(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if ((localHashMap.get("para_code1") == null) || (!localHashMap.get("para_code3").equals(paramString2)))
          continue;
        str = localHashMap.get("para_code1").toString();
      }
    return str;
  }

  public String getItemsBySelected(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = getCompareInfoByAttr(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str3 = "";
        String str4 = "";
        if (localHashMap.get("para_code1") != null)
        {
          str3 = localHashMap.get("para_code1").toString();
          if ((str3.equals(paramString2)) || (str3 == paramString2))
            str2 = "selected";
          else
            str2 = "";
        }
        if (localHashMap.get("para_code2") != null)
          str4 = localHashMap.get("para_code2").toString();
        str1 = str1 + "<option value=" + str3 + "  " + str2 + ">" + str4 + "</option>";
      }
    return str1;
  }

  public String getParamNameByValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getCompareInfoByAttr(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if ((localHashMap.get("para_code1") != null) && (localHashMap.get("para_code1").equals(paramString2)))
          return str = localHashMap.get("para_code2").toString();
      }
    return str;
  }

  public String getParamListByValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    localArrayList = getCompareInfoByAttr(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if ((localHashMap.get("para_code1") != null) && (localHashMap.get("para_code1").equals(paramString2)))
          return str = localHashMap.get("para_code3").toString();
      }
    return str;
  }

  public HashMap getCompareInfoByCode(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = getCompareInfo(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap2 = (HashMap)localIterator.next();
        String str1 = "";
        String str2 = "";
        if (localHashMap2.get("para_code1") != null)
          str1 = localHashMap2.get("para_code1").toString();
        if (localHashMap2.get("para_code2") != null)
          str2 = localHashMap2.get("para_code2").toString();
        localHashMap1.put(str1, str2);
      }
    }
    return localHashMap1;
  }

  public String getParam_attrMax(String paramString)
    throws SaasApplicationException
  {
    String str = "0";
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_BY_SYS_MAX");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("mx") != null)
      {
        int i = Integer.parseInt(localHashMap.get("mx").toString()) + 1;
        str = String.valueOf(i);
      }
    }
    return str;
  }

  public String getParam_CodeMax(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "0";
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString1);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString2);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_BY_CODE_MAX");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("mx") != null)
      {
        int i = Integer.parseInt(localHashMap.get("mx").toString()) + 1;
        str = String.valueOf(i);
      }
    }
    return str;
  }

  public void saveOrUpdateComparam(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入saveOrUpdateComparam方法...");
    this.outBuffer = paramBuffers;
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("XTYPE");
    String str2 = paramBuffers.getString("SUBSYS_CODE");
    String str3 = paramBuffers.getString("PARAM_ATTR");
    String str4 = paramBuffers.getString("PARAM_CODE");
    String str5 = paramBuffers.getString("PARAM_NAME");
    String str6 = paramBuffers.getString("PARA_CODE1");
    String str7 = paramBuffers.getString("PARA_CODE2");
    String str8 = "default!";
    if ((paramBuffers.getString("PARA_CODE3") != null) && (!paramBuffers.getString("PARA_CODE3").equals("")))
      str8 = paramBuffers.getString("PARA_CODE3");
    String str9 = paramBuffers.getString("PARA_CODE4");
    String str10 = paramBuffers.getString("PARA_CODE5");
    String str11 = paramBuffers.getString("PARA_CODE6");
    String str12 = paramBuffers.getString("PARA_CODE7");
    String str13 = paramBuffers.getString("PARA_CODE8");
    String str14 = paramBuffers.getString("PARA_CODE9");
    String str15 = paramBuffers.getString("PARA_CODE10");
    String str16 = paramBuffers.getString("PARA_CODE11");
    String str17 = paramBuffers.getString("PARA_CODE12");
    String str18 = paramBuffers.getString("PARA_CODE13");
    String str19 = paramBuffers.getString("PARA_CODE14");
    String str20 = paramBuffers.getString("PARA_CODE15");
    String str21 = paramBuffers.getString("PARA_CODE16");
    String str22 = paramBuffers.getString("PARA_CODE17");
    String str23 = paramBuffers.getString("PARA_CODE18");
    String str24 = paramBuffers.getString("PARA_CODE19");
    String str25 = paramBuffers.getString("PARA_CODE20");
    String str26 = paramBuffers.getString("PARA_CODE21");
    String str27 = paramBuffers.getString("PARA_CODE22");
    String str28 = paramBuffers.getString("PARA_CODE23");
    String str29 = paramBuffers.getString("PARA_CODE24");
    String str30 = paramBuffers.getString("PARA_CODE25");
    String str31 = paramBuffers.getString("PARA_CODE26");
    String str32 = paramBuffers.getString("PARA_CODE27");
    String str33 = paramBuffers.getString("PARA_CODE28");
    String str34 = paramBuffers.getString("PARA_CODE29");
    String str35 = paramBuffers.getString("PARA_CODE30");
    String str36 = paramBuffers.getString("START_DATE");
    String str37 = paramBuffers.getString("END_DATE");
    String str38 = paramBuffers.getString("REMARK");
    String str39 = paramBuffers.getString("SESSION_USER_ID");
    String str40 = this.comm.GenSysdate("1");
    try
    {
      CommparaDAO localCommparaDAO = new CommparaDAO();
      localCommparaDAO.setSubsys_code(str2);
      localCommparaDAO.setParam_code(str4);
      localCommparaDAO.setParam_name(str5);
      localCommparaDAO.setParam_attr(str3);
      localCommparaDAO.setStart_date(str36);
      localCommparaDAO.setPara_code1(str6);
      localCommparaDAO.setPara_code4(str9);
      localCommparaDAO.setPara_code5(str10);
      localCommparaDAO.setPara_code6(str11);
      localCommparaDAO.setPara_code7(str12);
      localCommparaDAO.setPara_code8(str13);
      localCommparaDAO.setPara_code9(str14);
      localCommparaDAO.setPara_code10(str15);
      localCommparaDAO.setPara_code11(str16);
      localCommparaDAO.setPara_code12(str17);
      localCommparaDAO.setPara_code13(str18);
      localCommparaDAO.setPara_code14(str19);
      localCommparaDAO.setPara_code15(str20);
      localCommparaDAO.setPara_code16(str21);
      localCommparaDAO.setPara_code17(str22);
      localCommparaDAO.setPara_code18(str23);
      localCommparaDAO.setPara_code19(str24);
      localCommparaDAO.setPara_code20(str25);
      localCommparaDAO.setPara_code2(str7);
      localCommparaDAO.setPara_code21(str26);
      localCommparaDAO.setPara_code22(str27);
      localCommparaDAO.setPara_code23(str28);
      localCommparaDAO.setPara_code24(str29);
      localCommparaDAO.setPara_code25(str30);
      localCommparaDAO.setPara_code26(str31);
      localCommparaDAO.setPara_code27(str32);
      localCommparaDAO.setPara_code28(str33);
      localCommparaDAO.setPara_code29(str34);
      localCommparaDAO.setPara_code3(str8);
      localCommparaDAO.setPara_code30(str35);
      localCommparaDAO.setEnd_date(str37);
      localCommparaDAO.setUpdate_staff_id(str39);
      localCommparaDAO.setUpdate_time(str40);
      localCommparaDAO.setRemark(str38);
      i = saveOrUpdateComparam(localCommparaDAO, str1);
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
    this.log.LOG_INFO("退出saveOrUpdateComparam方法...");
  }

  public int saveOrUpdateComparam(CommparaDAO paramCommparaDAO, String paramString)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramCommparaDAO.getSubsys_code());
    localCommparaExt.setParam(":VPARAM_ATTR", paramCommparaDAO.getParam_attr());
    localCommparaExt.setParam(":VPARAM_CODE", paramCommparaDAO.getParam_code());
    localCommparaExt.setParam(":VPARAM_NAME", paramCommparaDAO.getParam_name());
    localCommparaExt.setParam(":VPARA_CODE1", paramCommparaDAO.getPara_code1());
    localCommparaExt.setParam(":VPARA_CODE2", paramCommparaDAO.getPara_code2());
    localCommparaExt.setParam(":VPARA_CODE3", paramCommparaDAO.getPara_code3());
    localCommparaExt.setParam(":VPARA_CODE4", paramCommparaDAO.getPara_code4());
    localCommparaExt.setParam(":VPARA_CODE5", paramCommparaDAO.getPara_code5());
    localCommparaExt.setParam(":VPARA_CODE6", paramCommparaDAO.getPara_code6());
    localCommparaExt.setParam(":VPARA_CODE7", paramCommparaDAO.getPara_code7());
    localCommparaExt.setParam(":VPARA_CODE8", paramCommparaDAO.getPara_code8());
    localCommparaExt.setParam(":VPARA_CODE9", paramCommparaDAO.getPara_code9());
    localCommparaExt.setParam(":VPARA_CODE10", paramCommparaDAO.getPara_code10());
    localCommparaExt.setParam(":VPARA_CODE11", paramCommparaDAO.getPara_code11());
    localCommparaExt.setParam(":VPARA_CODE12", paramCommparaDAO.getPara_code12());
    localCommparaExt.setParam(":VPARA_CODE13", paramCommparaDAO.getPara_code13());
    localCommparaExt.setParam(":VPARA_CODE14", paramCommparaDAO.getPara_code14());
    localCommparaExt.setParam(":VPARA_CODE15", paramCommparaDAO.getPara_code15());
    localCommparaExt.setParam(":VPARA_CODE16", paramCommparaDAO.getPara_code16());
    localCommparaExt.setParam(":VPARA_CODE17", paramCommparaDAO.getPara_code17());
    localCommparaExt.setParam(":VPARA_CODE18", paramCommparaDAO.getPara_code18());
    localCommparaExt.setParam(":VPARA_CODE19", paramCommparaDAO.getPara_code19());
    localCommparaExt.setParam(":VPARA_CODE20", paramCommparaDAO.getPara_code20());
    localCommparaExt.setParam(":VPARA_CODE21", paramCommparaDAO.getPara_code21());
    localCommparaExt.setParam(":VPARA_CODE22", paramCommparaDAO.getPara_code22());
    localCommparaExt.setParam(":VPARA_CODE23", paramCommparaDAO.getPara_code23());
    localCommparaExt.setParam(":VPARA_CODE24", paramCommparaDAO.getPara_code24());
    localCommparaExt.setParam(":VPARA_CODE25", paramCommparaDAO.getPara_code25());
    localCommparaExt.setParam(":VPARA_CODE26", paramCommparaDAO.getPara_code26());
    localCommparaExt.setParam(":VPARA_CODE27", paramCommparaDAO.getPara_code27());
    localCommparaExt.setParam(":VPARA_CODE28", paramCommparaDAO.getPara_code28());
    localCommparaExt.setParam(":VPARA_CODE29", paramCommparaDAO.getPara_code29());
    localCommparaExt.setParam(":VPARA_CODE30", paramCommparaDAO.getPara_code30());
    localCommparaExt.setParam(":VSTART_DATE", paramCommparaDAO.getStart_date());
    localCommparaExt.setParam(":VEND_DATE", paramCommparaDAO.getEnd_date());
    localCommparaExt.setParam(":VREMARK", paramCommparaDAO.getRemark());
    localCommparaExt.setParam(":VUPDATE_STAFF_ID", paramCommparaDAO.getUpdate_staff_id());
    localCommparaExt.setParam(":VUPDATE_TIME", paramCommparaDAO.getUpdate_time());
    if (paramCommparaDAO.getPara_code10().equals("oldone"))
    {
      localCommparaExt.setParam(":VCUST_ID", paramCommparaDAO.getPara_code24());
      this.tradeQuery.executeBy(localCommparaExt.insBy("EDIT_BY_ALL_CUST_ID"));
      return 0;
    }
    if (paramCommparaDAO.getPara_code10().equals("newone"))
    {
      this.tradeQuery.executeBy(localCommparaExt.insBy("INS_BY_ALL"));
      return 0;
    }
    boolean bool = paramString.equals("1");
    if (bool)
    {
      this.tradeQuery.executeBy(localCommparaExt.insBy("EDIT_BY_ALL"));
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      this.log.LOG_INFO(paramCommparaDAO.getPara_code2() + "----------" + paramCommparaDAO.getPara_code5() + "7777777777777777777777777");
      localArrayList = localCommparaExt.selByList("SEL_BY_CHECKCODE25");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.tradeQuery.executeBy(localCommparaExt.insBy("EDIT_BY_ALL25"));
        return 0;
      }
      this.tradeQuery.executeBy(localCommparaExt.insBy("INS_BY_ALL"));
      return 0;
    }
    return 0;
  }

  public void updateParame(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SUBSYS_CODE");
    String str2 = paramBuffers.getString("PARAM_ATTR");
    String str3 = paramBuffers.getString("PARAM_CODE");
    String str4 = paramBuffers.getString("PARAM_NAME");
    String str5 = paramBuffers.getString("PARA_CODE3");
    String str6 = paramBuffers.getString("PARA_CODE1");
    CommparaDAO localCommparaDAO = new CommparaDAO();
    localCommparaDAO.setSubsys_code(str1);
    localCommparaDAO.setParam_code(str3);
    localCommparaDAO.setParam_name(str4);
    localCommparaDAO.setParam_attr(str2);
    localCommparaDAO.setPara_code3(str5);
    localCommparaDAO.setPara_code1(str6);
    i = updateParame(localCommparaDAO);
  }

  public int updateParame(CommparaDAO paramCommparaDAO)
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramCommparaDAO.getSubsys_code());
    localCommparaExt.setParam(":VPARAM_ATTR", paramCommparaDAO.getParam_attr());
    localCommparaExt.setParam(":VPARAM_CODE", paramCommparaDAO.getParam_code());
    localCommparaExt.setParam(":VPARAM_NAME", paramCommparaDAO.getParam_name());
    localCommparaExt.setParam(":VPARA_CODE3", paramCommparaDAO.getPara_code3());
    localCommparaExt.setParam(":VPARA_CODE1", paramCommparaDAO.getPara_code1());
    this.tradeQuery.executeBy(localCommparaExt.insBy("UPDATE_BY_ALL_FOR_CODE"));
    return 0;
  }

  public void removeComparam(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入removeComparam方法...");
    this.outBuffer = paramBuffers;
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SUBSYS_CODE");
    String str2 = paramBuffers.getString("PARAM_ATTR");
    String str3 = paramBuffers.getString("PARA_CODE1");
    String str4 = paramBuffers.getString("PARA_CODE4");
    try
    {
      CommparaDAO localCommparaDAO = new CommparaDAO();
      localCommparaDAO.setSubsys_code(str1);
      localCommparaDAO.setPara_code1(str3);
      localCommparaDAO.setParam_attr(str2);
      localCommparaDAO.setPara_code4(str4);
      i = removeComparam(localCommparaDAO);
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
    this.log.LOG_INFO("退出saveOrUpdateComparam方法...");
  }

  public int removeComparam(CommparaDAO paramCommparaDAO)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramCommparaDAO.getSubsys_code());
    localCommparaExt.setParam(":VPARA_CODE1", paramCommparaDAO.getPara_code1());
    localCommparaExt.setParam(":VPARAM_ATTR", paramCommparaDAO.getParam_attr());
    localCommparaExt.setParam(":VPARA_CODE4", paramCommparaDAO.getPara_code4());
    this.tradeQuery.executeBy(localCommparaExt.insBy("DEL_BY_CODE"));
    return 0;
  }

  public HashMap getCommparamByCode4(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    HashMap localHashMap = new HashMap();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString1);
    localCommparaExt.setParam(":VPARA_CODE1", paramString3);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString2);
    localCommparaExt.setParam(":VPARA_CODE4", paramString4);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_BY_CODE4");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public boolean checkWealth(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    boolean i =false;
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString1);
    localCommparaExt.setParam(":VPARA_CODE6", paramString4);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString2);
    localCommparaExt.setParam(":VPARA_CODE4", paramString3);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_BY_CHECKCODE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = true;
    return i;
  }

  public HashMap getSystemParameter(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString1);
    localCommparaExt.setParam(":VPARA_CODE6", paramString4);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString2);
    localCommparaExt.setParam(":VPARA_CODE4", paramString3);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_BY_CHECKCODE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getComparamListByCode(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_PARA_CODE2");
    return localArrayList;
  }

  public ArrayList getComparamListByCodeByALL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE1", paramString5);
    localCommparaExt.setParam(":VPARA_CODE2", paramString4);
    localCommparaExt.setParam(":VPARAS_CODE", paramString1);
    localCommparaExt.setParam(":VPARAP_CODE1", paramString3);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString2);
    localCommparaExt.setParam(":VPARAP_NAME", paramString6);
    ArrayList localArrayList = localCommparaExt.selByList("SEL_PARA_BY_ALL_PARAM");
    return localArrayList;
  }

  public ArrayList getallCompareInfoByCode(int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARA", paramInt, 20);
    return localArrayList;
  }

  public int getallCompareInfoByCodeA()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARA");
    if ((localArrayList.size() > 0) && (localArrayList != null))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getallCompareInfoByCode2(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE", paramString);
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARAT", paramInt, 20);
    return localArrayList;
  }

  public int getallCompareInfoByCodeA2(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE", paramString);
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARAT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getallCompareInfoByPARAM_ATTR(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_KEY", paramString);
    localArrayList = localCommparaExt.selByList("SEL_PARA_CODE8");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getMaxPARA_CODE1(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString);
    localArrayList = localCommparaExt.selByList("SEL_MAX_PARA_CODE1");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getallCompareInfoBySearch(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", "%" + paramString1 + "%");
    localCommparaExt.setParam(":VPARAM_NAME", "%" + paramString2 + "%");
    localCommparaExt.setParam(":VPARAM_CODE", "%" + paramString3 + "%");
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARA_SEARCH", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getallCompareInfoBySearchANC(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", "%" + paramString1 + "%");
    localCommparaExt.setParam(":VPARAM_NAME", "%" + paramString2 + "%");
    localCommparaExt.setParam(":VPARAM_CODE", "%" + paramString3 + "%");
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARA_SEARCH_ANC", paramInt, 20);
    return localArrayList;
  }

  public int getallCompareInfoBySearchANC(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", "%" + paramString1 + "%");
    localCommparaExt.setParam(":VPARAM_NAME", "%" + paramString2 + "%");
    localCommparaExt.setParam(":VPARAM_CODE", "%" + paramString3 + "%");
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARA_SEARCH_ANC");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getallCompareInfoBySearchANC2(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", "%" + paramString1 + "%");
    localCommparaExt.setParam(":VPARAM_NAME", "%" + paramString2 + "%");
    localCommparaExt.setParam(":VPARAM_CODE", paramString3);
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARA_SEARCH_ANCT", paramInt, 20);
    return localArrayList;
  }

  public int getallCompareInfoBySearchANC2(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", "%" + paramString1 + "%");
    localCommparaExt.setParam(":VPARAM_NAME", "%" + paramString2 + "%");
    localCommparaExt.setParam(":VPARAM_CODE", paramString3);
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARA_SEARCH_ANCT");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getallCompareInfoBySearch(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", "%" + paramString1 + "%");
    localCommparaExt.setParam(":VPARAM_NAME", "%" + paramString2 + "%");
    localCommparaExt.setParam(":VPARAM_CODE", "%" + paramString3 + "%");
    localArrayList = localCommparaExt.selByList("SEL_ALL_COMMPARA_SEARCH");
    if ((localArrayList.size() > 0) && (localArrayList != null))
      return localArrayList.size();
    return 0;
  }

  public HashMap getPagetUrlByCode(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = getCompareInfoByAttr(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = localHashMap2.get("para_code1").toString();
        String str2 = localHashMap2.get("para_code7").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public String getCustServerSelect(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VCUST_ID", paramString1);
    localCommparaExt.setParam(":VSTATE_CODE", paramString2);
    localCommparaExt.setParam(":VSTATE_CODE1", paramString3);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString4);
    localArrayList = localCommparaExt.selByList("SEL_BY_PARAM_SERVER");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("para_code1").toString();
        String str3 = localHashMap.get("para_code1").toString();
        str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>";
      }
    return str1;
  }

  public int getAdvertiseNumber(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = getComparamListByCode(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code3") != null)
        i = Integer.parseInt(localHashMap.get("para_code3").toString());
    }
    return i;
  }

  public void updateSysSwitch(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateSysSwitch方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_ATTR");
    String str2 = paramBuffers.getString("PARA_CODE1");
    if (str2.equals("1"))
      str2 = "0";
    else
      str2 = "1";
    try
    {
      i = updateSysSwitch(str1, str2);
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
    this.log.LOG_INFO("退出updateSysSwitch方法...");
  }

  public int updateSysSwitch(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    this.tradeQuery.executeBy(localCommparaExt.insBy("UPDATE_SYS_SWITCH"));
    return 0;
  }

  public void delCommpara(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delCommpara方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_ATTR");
    String str2 = paramBuffers.getString("CUST_NAME");
    String str3 = paramBuffers.getString("SUBSYS_CODE");
    String str4 = paramBuffers.getString("PARAM_CODE");
    try
    {
      i = delCommpara(str1, str2, str3, str4);
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
    this.log.LOG_INFO("退出delCommpara方法...");
  }

  public int delCommpara(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_SCODE", paramString3);
    localCommparaExt.setParam(":VPARAM_PCODE", paramString4);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localCommparaExt.setParam(":VCUST_NAME", paramString2);
    this.tradeQuery.executeBy(localCommparaExt.insBy("DEL_SYS_SWITCH"));
    return 0;
  }

  public int updateCommpara(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35, String paramString36)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localCommparaExt.setParam(":VPARAM_CODE", paramString2);
    localCommparaExt.setParam(":VPARAM_NAME", paramString3);
    localCommparaExt.setParam(":VPARA_CODE1", paramString4);
    localCommparaExt.setParam(":VPARA_CODE2", paramString5);
    localCommparaExt.setParam(":VPARA_CODE3", paramString6);
    localCommparaExt.setParam(":VPARA_CODE4", paramString7);
    localCommparaExt.setParam(":VPARA_CODE5", paramString8);
    localCommparaExt.setParam(":VPARA_CODE6", paramString9);
    localCommparaExt.setParam(":VPARA_CODE7", paramString10);
    localCommparaExt.setParam(":VPARA_CODE8", paramString11);
    localCommparaExt.setParam(":VPARA_CODE9", paramString12);
    localCommparaExt.setParam(":VPARA_CODE10", paramString13);
    localCommparaExt.setParam(":VPARA_CODE11", paramString14);
    localCommparaExt.setParam(":VPARA_CODE12", paramString15);
    localCommparaExt.setParam(":VPARA_CODE13", paramString16);
    localCommparaExt.setParam(":VPARA_CODE14", paramString17);
    localCommparaExt.setParam(":VPARA_CODE15", paramString18);
    localCommparaExt.setParam(":VPARA_CODE16", paramString19);
    localCommparaExt.setParam(":VPARA_CODE17", paramString20);
    localCommparaExt.setParam(":VPARA_CODE18", paramString21);
    localCommparaExt.setParam(":VPARA_CODE19", paramString22);
    localCommparaExt.setParam(":VPARA_CODE20", paramString23);
    localCommparaExt.setParam(":VPARA_CODE21", paramString24);
    localCommparaExt.setParam(":VPARA_CODE22", paramString25);
    localCommparaExt.setParam(":VPARA_CODE23", paramString26);
    localCommparaExt.setParam(":VPARA_CODE24", paramString27);
    localCommparaExt.setParam(":VPARA_CODE25", paramString28);
    localCommparaExt.setParam(":VPARA_CODE26", paramString29);
    localCommparaExt.setParam(":VPARA_CODE27", paramString30);
    localCommparaExt.setParam(":VPARA_CODE28", paramString31);
    localCommparaExt.setParam(":VPARA_CODE29", paramString32);
    localCommparaExt.setParam(":VPARA_CODE30", paramString33);
    localCommparaExt.setParam(":VSTART_DATE", paramString34);
    localCommparaExt.setParam(":VEND_DATE", paramString35);
    localCommparaExt.setParam(":VREMARK", paramString36);
    this.tradeQuery.executeBy(localCommparaExt.insBy("UPDATE_SYS_COMMPARA"));
    return 0;
  }

  public void updateCommpara(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateCommpara方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_CODE");
    String str2 = paramBuffers.getString("PARAM_ATTR");
    String str3 = paramBuffers.getString("PARAM_NAME");
    String str4 = paramBuffers.getString("PARA_CODE1");
    String str5 = paramBuffers.getString("PARA_CODE2");
    String str6 = paramBuffers.getString("PARA_CODE3");
    String str7 = paramBuffers.getString("PARA_CODE4");
    String str8 = paramBuffers.getString("PARA_CODE5");
    String str9 = paramBuffers.getString("PARA_CODE6");
    String str10 = paramBuffers.getString("PARA_CODE7");
    String str11 = paramBuffers.getString("PARA_CODE8");
    String str12 = paramBuffers.getString("PARA_CODE9");
    String str13 = paramBuffers.getString("PARA_CODE10");
    String str14 = paramBuffers.getString("PARA_CODE11");
    String str15 = paramBuffers.getString("PARA_CODE12");
    String str16 = paramBuffers.getString("PARA_CODE13");
    String str17 = paramBuffers.getString("PARA_CODE14");
    String str18 = paramBuffers.getString("PARA_CODE15");
    String str19 = paramBuffers.getString("PARA_CODE16");
    String str20 = paramBuffers.getString("PARA_CODE17");
    String str21 = paramBuffers.getString("PARA_CODE18");
    String str22 = paramBuffers.getString("PARA_CODE19");
    String str23 = paramBuffers.getString("PARA_CODE20");
    String str24 = paramBuffers.getString("PARA_CODE21");
    String str25 = paramBuffers.getString("PARA_CODE22");
    String str26 = paramBuffers.getString("PARA_CODE23");
    String str27 = paramBuffers.getString("PARA_CODE24");
    String str28 = paramBuffers.getString("PARA_CODE25");
    String str29 = paramBuffers.getString("PARA_CODE26");
    String str30 = paramBuffers.getString("PARA_CODE27");
    String str31 = paramBuffers.getString("PARA_CODE28");
    String str32 = paramBuffers.getString("PARA_CODE29");
    String str33 = paramBuffers.getString("PARA_CODE30");
    String str34 = paramBuffers.getString("START_DATE");
    String str35 = paramBuffers.getString("END_DATE");
    String str36 = paramBuffers.getString("REMARK");
    try
    {
      i = updateCommpara(str2, str1, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36);
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
    this.log.LOG_INFO("退出updateCommpara方法...");
  }

  public ArrayList getallCompareInfoByCodeForPara(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString1);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString2);
    localCommparaExt.setParam(":VPARA_CODE1", paramString3);
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR_ZL");
    return localArrayList;
  }

  public int updateCommparaForLevel(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localCommparaExt.setParam(":VPARA_CODE6", paramString3);
    this.tradeQuery.executeBy(localCommparaExt.insBy("UPDATE_SYS_COMMPARA_FOR_LEVEL"));
    return 0;
  }

  public void updateCommparaForLevel(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateCommpara方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_ATTR");
    String str2 = paramBuffers.getString("PARA_CODE1");
    String str3 = paramBuffers.getString("PARA_CODE6");
    try
    {
      i = updateCommparaForLevel(str1, str2, str3);
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
    this.log.LOG_INFO("退出updateCommpara方法...");
  }

  public void setLevelByParamattr(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入setLevelByParamattr方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_ATTR");
    String str2 = paramBuffers.getString("PARA_CODE");
    String str3 = paramBuffers.getString("PARA_CODE5");
    try
    {
      i = updateLevelByParacode(str1, str2, str3);
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
    this.log.LOG_INFO("退出setLevelByParamattr方法...");
  }

  public int updateLevelByParacode(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localCommparaExt.setParam(":VPARA_CODE5", paramString3);
    this.tradeQuery.executeBy(localCommparaExt.insBy("UPDATE_SYS_COMMPARA_FOR_LEVEL_PARA_CODE5"));
    return 0;
  }

  public String getPara_code5ByParam_arrt(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    String str = "";
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localArrayList = localCommparaExt.selByList("SEL_PARA_CODE5_BY_PARAM_ATTR");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code5") != null)
        str = localHashMap.get("para_code5").toString();
    }
    return str;
  }

  public String getPara_code6ByParam_arrt(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    String str = "";
    localCommparaExt.setParam(":VPARAM_ATTR", paramString1);
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localArrayList = localCommparaExt.selByList("SEL_PARA_CODE5_BY_PARAM_ATTR");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code6") != null)
        str = localHashMap.get("para_code6").toString();
    }
    return str;
  }

  public void addPARA_CODE(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addvoteInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      CommparaDAO localCommparaDAO = new CommparaDAO();
      localCommparaDAO.setSubsys_code(paramBuffers.getString("SUBSYS_CODE"));
      localCommparaDAO.setParam_attr(paramBuffers.getString("PARAM_ATTR"));
      localCommparaDAO.setParam_code(paramBuffers.getString("PARAM_CODE"));
      localCommparaDAO.setParam_name(paramBuffers.getString("PARAM_NAME"));
      localCommparaDAO.setPara_code1(paramBuffers.getString("PARA_CODE1"));
      localCommparaDAO.setPara_code2(paramBuffers.getString("PARA_CODE2"));
      i = addPARA_CODE(localCommparaDAO);
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
  }

  public int addPARA_CODE(CommparaDAO paramCommparaDAO)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramCommparaDAO.getSubsys_code());
    localCommparaExt.setParam(":VPARAM_ATTR", paramCommparaDAO.getParam_attr());
    localCommparaExt.setParam(":VPARAM_CODE", paramCommparaDAO.getParam_code());
    localCommparaExt.setParam(":VPARAM_NAME", paramCommparaDAO.getParam_name());
    localCommparaExt.setParam(":VPARA_CODE1", paramCommparaDAO.getPara_code1());
    localCommparaExt.setParam(":VPARA_CODE2", paramCommparaDAO.getPara_code2());
    localCommparaExt.setParam(":VSTART_DATE", "2006-01-01 00:00:00");
    localCommparaExt.setParam(":VEND_DATE", "2056-01-01 00:00:00");
    this.tradeQuery.executeBy(localCommparaExt.insBy("INS_BY_SOME"));
    return 0;
  }

  public void updatePARA_CODE(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addvoteInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SUBSYS_CODE");
      String str2 = paramBuffers.getString("PARAM_ATTR");
      String str3 = paramBuffers.getString("PARA_CODE1_V");
      String str4 = paramBuffers.getString("PARAM_CODE_V");
      String str5 = paramBuffers.getString("PARA_CODE1_I");
      String str6 = paramBuffers.getString("PARAM_CODE_I");
      this.log.LOG_INFO("------------------------------------" + str1);
      this.log.LOG_INFO("------------------------------------" + str2);
      this.log.LOG_INFO("------------------------------------" + str3);
      this.log.LOG_INFO("------------------------------------" + str4);
      this.log.LOG_INFO("------------------------------------" + str5);
      this.log.LOG_INFO("------------------------------------" + str6);
      i = updatePARA_CODE(str1, str2, str3, str4);
      i = updatePARA_CODE(str1, str2, str5, str6);
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
  }

  public int updatePARA_CODE(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString1);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString2);
    localCommparaExt.setParam(":VPARA_CODE1", paramString3);
    localCommparaExt.setParam(":VPARAM_CODE", paramString4);
    this.tradeQuery.executeBy(localCommparaExt.insBy("UPDATE_BY_SOME"));
    return 0;
  }

  public String getRadioItems(String paramString)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = getCompareInfoByAttr(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        String str3 = "";
        if (localHashMap.get("para_code1") != null)
          str2 = localHashMap.get("para_code1").toString();
        if (localHashMap.get("para_code2") != null)
          str3 = localHashMap.get("para_code2").toString();
        if (i == 0)
          str1 = "<input name='m_type' type='radio' checked value=" + str2 + ">" + str3;
        else
          str1 = str1 + "<input name='m_type' type='radio' value=" + str2 + ">" + str3;
      }
    return str1;
  }

  public String getRadioItemsForUpdate(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = getCompareInfoByAttr(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        String str3 = "";
        if (localHashMap.get("para_code1") != null)
          str2 = localHashMap.get("para_code1").toString();
        if (localHashMap.get("para_code2") != null)
          str3 = localHashMap.get("para_code2").toString();
        if (str2.equals(paramString2))
          str1 = str1 + "<input name='m_type' type='radio' checked value=" + str2 + ">" + str3;
        else
          str1 = str1 + "<input name='m_type' type='radio' value=" + str2 + ">" + str3;
      }
    return str1;
  }

  public void DeleteInfoByPara_Code(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteInfoByPara_Code方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PARA_CODE1");
    String str2 = paramBuffers.getString("SUBSYS_CODE");
    String str3 = paramBuffers.getString("PARAM_ATTR");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str4 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str4 = localStringTokenizer.nextToken();
        i = DeleteInfoByPara_Code(str4, str2, str3);
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
    this.log.LOG_INFO("退出updatevoteInfo方法...");
  }

  public int DeleteInfoByPara_Code(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VPARA_CODE1", paramString1);
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString3);
    this.tradeQuery.executeBy(localCommparaExt.insBy("DELETE_BY_SOME"));
    return 0;
  }

  public void updateCommparaForIntegralRule(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateCommparaForIntegralRule方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SUBSYS_CODE");
    String str2 = paramBuffers.getString("PARAM_ATTR");
    String str3 = paramBuffers.getString("PARA_CODE1");
    String str4 = paramBuffers.getString("PARA_CODE2");
    try
    {
      i = updateCommparaForIntegralRule(str1, str2, str3, str4);
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
    this.log.LOG_INFO("退出updateCommparaForIntegralRule方法...");
  }

  public int updateCommparaForIntegralRule(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString1);
    localCommparaExt.setParam(":VPARAM_ATTR", paramString2);
    localCommparaExt.setParam(":VPARA_CODE1", paramString3);
    localCommparaExt.setParam(":VPARA_CODE2", paramString4);
    this.tradeQuery.executeBy(localCommparaExt.insBy("UPDATE_SYS_COMMPARA_INTEGRALRULE"));
    return 0;
  }

  public String getParaCode1ByParamArrt(String paramString)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    String str = "";
    localCommparaExt.setParam(":VPARAM_ATTR", paramString);
    localArrayList = localCommparaExt.selByList("SEL_PARA_CODE1_BY_PARAM_ATTR");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code1") != null)
        str = localHashMap.get("para_code1").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.ParamethodMgr
 * JD-Core Version:    0.6.0
 */