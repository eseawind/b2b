package com.saas.biz.custpersonMgr;

import com.saas.biz.dao.custpersonDAO.CustPersonDAO;
import com.saas.biz.dao.custpersonDAO.CustPersonExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class CustPersonInfo
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

  public void addCustPerInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCustPerInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("USER_ID");
    String str3 = paramBuffers.getString("PSPT_TYPE_CODE");
    String str4 = paramBuffers.getString("PSPT_ID");
    String str5 = paramBuffers.getString("PSPT_END_DATE");
    String str6 = paramBuffers.getString("PSPT_ADDR");
    String str7 = paramBuffers.getString("CUST_NAME");
    String str8 = paramBuffers.getString("SEX");
    String str9 = paramBuffers.getString("BIRTHDAY");
    String str10 = paramBuffers.getString("LOCAL_NATIVE_CODE");
    String str11 = paramBuffers.getString("POPULATION");
    String str12 = paramBuffers.getString("FOLK_CODE");
    String str13 = paramBuffers.getString("PHONE");
    String str14 = paramBuffers.getString("POST_CODE");
    String str15 = paramBuffers.getString("POST_ADDR");
    String str16 = paramBuffers.getString("FAX");
    String str17 = paramBuffers.getString("QQ");
    String str18 = paramBuffers.getString("BLOG");
    String str19 = paramBuffers.getString("EMAIL");
    String str20 = paramBuffers.getString("CONTACT_NAME");
    String str21 = paramBuffers.getString("CONTACT_PHONE");
    String str22 = paramBuffers.getString("HOME_ADDR");
    String str23 = paramBuffers.getString("WORK_NAME");
    String str24 = paramBuffers.getString("WORK_DEPART");
    String str25 = paramBuffers.getString("JOB");
    String str26 = paramBuffers.getString("JOB_TYPE_CODE");
    String str27 = paramBuffers.getString("EDUCATE_DEGREE_CODE");
    String str28 = paramBuffers.getString("MARRIAGE");
    String str29 = paramBuffers.getString("COMMUNITY_ID");
    String str30 = paramBuffers.getString("REMARK");
    try
    {
      CustPersonDAO localCustPersonDAO = new CustPersonDAO();
      localCustPersonDAO.setCust_id(str1);
      localCustPersonDAO.setUser_id(str2);
      localCustPersonDAO.setPspt_type_code(str3);
      localCustPersonDAO.setPspt_id(str4);
      localCustPersonDAO.setPspt_end_date(str5);
      localCustPersonDAO.setPspt_addr(str6);
      localCustPersonDAO.setCust_name(str7);
      localCustPersonDAO.setSex(str8);
      localCustPersonDAO.setBirthday(str9);
      localCustPersonDAO.setLocal_native_code(str10);
      localCustPersonDAO.setPopulation(str11);
      localCustPersonDAO.setFolk_code(str12);
      localCustPersonDAO.setPhone(str13);
      localCustPersonDAO.setPost_code(str14);
      localCustPersonDAO.setPost_addr(str15);
      localCustPersonDAO.setFax(str16);
      localCustPersonDAO.setQq(str17);
      localCustPersonDAO.setBlog(str18);
      localCustPersonDAO.setEmail(str19);
      localCustPersonDAO.setContact_name(str20);
      localCustPersonDAO.setContact_phone(str21);
      localCustPersonDAO.setHome_addr(str22);
      localCustPersonDAO.setWork_name(str23);
      localCustPersonDAO.setWork_depart(str24);
      localCustPersonDAO.setJob(str25);
      localCustPersonDAO.setJob_type_code(str26);
      localCustPersonDAO.setEducate_degree_code(str27);
      localCustPersonDAO.setMarriage(str28);
      localCustPersonDAO.setCommunity_id(str29);
      localCustPersonDAO.setRemark(str30);
      i = addCustPerInfo(localCustPersonDAO);
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
    this.log.LOG_INFO("退出addCustPerInfo方法...");
  }

  public int addCustPerInfo(CustPersonDAO paramCustPersonDAO)
    throws SaasApplicationException
  {
    CustPersonExt localCustPersonExt = new CustPersonExt();
    localCustPersonExt.setParam(":VCUST_ID", paramCustPersonDAO.getCust_id());
    localCustPersonExt.setParam(":VUSER_ID", paramCustPersonDAO.getUser_id());
    localCustPersonExt.setParam(":VPSPT_TYPE_CODE", paramCustPersonDAO.getPspt_type_code());
    localCustPersonExt.setParam(":VPSPT_ID", paramCustPersonDAO.getPspt_id());
    localCustPersonExt.setParam(":VPSPT_END_DATE", paramCustPersonDAO.getPspt_end_date());
    localCustPersonExt.setParam(":VPSPT_ADDR", paramCustPersonDAO.getPspt_addr());
    localCustPersonExt.setParam(":VCUST_NAME", paramCustPersonDAO.getCust_name());
    localCustPersonExt.setParam(":VSEX", paramCustPersonDAO.getSex());
    localCustPersonExt.setParam(":VBIRTHDAY", paramCustPersonDAO.getBirthday());
    localCustPersonExt.setParam(":VLOCAL_NATIVE_CODE", paramCustPersonDAO.getLocal_native_code());
    localCustPersonExt.setParam(":VPOPULATION", paramCustPersonDAO.getPopulation());
    localCustPersonExt.setParam(":VFOLK_CODE", paramCustPersonDAO.getFolk_code());
    localCustPersonExt.setParam(":VPHONE", paramCustPersonDAO.getPhone());
    localCustPersonExt.setParam(":VPOST_CODE", paramCustPersonDAO.getPost_code());
    localCustPersonExt.setParam(":VPOST_ADDR", paramCustPersonDAO.getPost_addr());
    localCustPersonExt.setParam(":VFAX", paramCustPersonDAO.getFax());
    localCustPersonExt.setParam(":VQQ", paramCustPersonDAO.getQq());
    localCustPersonExt.setParam(":VBLOG", paramCustPersonDAO.getBlog());
    localCustPersonExt.setParam(":VEMAIL", paramCustPersonDAO.getEmail());
    localCustPersonExt.setParam(":VCONTACT_NAME", paramCustPersonDAO.getContact_name());
    localCustPersonExt.setParam(":VCONTACT_PHONE", paramCustPersonDAO.getContact_phone());
    localCustPersonExt.setParam(":VHOME_ADDR", paramCustPersonDAO.getHome_addr());
    localCustPersonExt.setParam(":VWORK_NAME", paramCustPersonDAO.getWork_name());
    localCustPersonExt.setParam(":VWORK_DEPART", paramCustPersonDAO.getWork_depart());
    localCustPersonExt.setParam(":VJOB", paramCustPersonDAO.getJob());
    localCustPersonExt.setParam(":VJOB_TYPE_CODE", paramCustPersonDAO.getJob_type_code());
    localCustPersonExt.setParam(":VEDUCATE_DEGREE_CODE", paramCustPersonDAO.getEducate_degree_code());
    localCustPersonExt.setParam(":VMARRIAGE", paramCustPersonDAO.getMarriage());
    localCustPersonExt.setParam(":VCOMMUNITY_ID", paramCustPersonDAO.getCommunity_id());
    localCustPersonExt.setParam(":VREMARK", paramCustPersonDAO.getRemark());
    this.log.LOG_INFO("SQL======" + localCustPersonExt.insBy("INS_BY_CUST_PERSON"));
    this.tradeQuery.executeBy(localCustPersonExt.insBy("INS_BY_CUST_PERSON"));
    return 0;
  }

  public String getUserNameByUserId(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    CustPersonExt localCustPersonExt = new CustPersonExt();
    localCustPersonExt.setParam(":VCUST_ID", paramString);
    localArrayList = localCustPersonExt.selByList("SEL_BY_CUSTID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("cust_name") != null)
        str = localHashMap.get("cust_name").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.custpersonMgr.CustPersonInfo
 * JD-Core Version:    0.6.0
 */