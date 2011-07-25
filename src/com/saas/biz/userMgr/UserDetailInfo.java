package com.saas.biz.userMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.userdetailDAO.UserdetailDAO;
import com.saas.biz.dao.userdetailDAO.UserdetailExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class UserDetailInfo
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

  public void addUserDetailInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addUserDetailInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("WORK_NAME");
    String str2 = paramBuffers.getString("HOME_ADDR");
    String str3 = paramBuffers.getString("QQ");
    String str4 = paramBuffers.getString("BLOG");
    String str5 = paramBuffers.getString("FOLK_CODE");
    String str6 = paramBuffers.getString("EDUCATE_DEGREE_CODE");
    String str7 = paramBuffers.getString("PHONE");
    String str8 = paramBuffers.getString("POST_ADDR");
    String str9 = paramBuffers.getString("JOB");
    String str10 = paramBuffers.getString("FAX_NBR");
    String str11 = paramBuffers.getString("PSPT_ID");
    String str12 = paramBuffers.getString("PSPT_TYPE_CODE");
    String str13 = paramBuffers.getString("PSPT_ADDR");
    String str14 = paramBuffers.getString("POST_CODE");
    String str15 = paramBuffers.getString("CUST_ID");
    String str16 = paramBuffers.getString("USER_ID");
    String str17 = paramBuffers.getString("CUST_NAME");
    String str18 = paramBuffers.getString("BIRTHDAY");
    String str19 = paramBuffers.getString("LOCAL_NATIVE_CODE");
    String str20 = paramBuffers.getString("EMAIL");
    String str21 = paramBuffers.getString("SEX");
    String str22 = paramBuffers.getString("MARRIAGE");
    String str23 = paramBuffers.getString("COMMUNITY_ID");
    try
    {
      UserdetailDAO localUserdetailDAO = new UserdetailDAO();
      localUserdetailDAO.setWork_name(str1);
      localUserdetailDAO.setPspt_id(str11);
      localUserdetailDAO.setPspt_addr(str13);
      localUserdetailDAO.setPspt_type_code(str12);
      localUserdetailDAO.setQq(str3);
      localUserdetailDAO.setHome_addr(str2);
      localUserdetailDAO.setBlog(str4);
      localUserdetailDAO.setFolk_code(str5);
      localUserdetailDAO.setFax(str10);
      localUserdetailDAO.setJob(str9);
      localUserdetailDAO.setEmail(str20);
      localUserdetailDAO.setEducate_degree_code(str6);
      localUserdetailDAO.setPhone(str7);
      localUserdetailDAO.setPost_addr(str8);
      localUserdetailDAO.setPost_code(str14);
      localUserdetailDAO.setUser_id(str16);
      localUserdetailDAO.setCust_id(str15);
      localUserdetailDAO.setCust_name(str17);
      localUserdetailDAO.setLocal_native_code(str19);
      localUserdetailDAO.setSex(str21);
      localUserdetailDAO.setBirthday(str18);
      localUserdetailDAO.setMarriage(str22);
      localUserdetailDAO.setCommunity_id(str23);
      i = addUserDetailInfo(localUserdetailDAO);
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
    this.log.LOG_INFO("退出addUserDetailInfo方法...");
  }

  public int addUserDetailInfo(UserdetailDAO paramUserdetailDAO)
    throws SaasApplicationException
  {
    UserdetailExt localUserdetailExt = new UserdetailExt();
    localUserdetailExt.setParam(":VWORK_NAME", paramUserdetailDAO.getWork_name());
    localUserdetailExt.setParam(":VQQ", paramUserdetailDAO.getQq());
    localUserdetailExt.setParam(":VPSPT_ADDR", paramUserdetailDAO.getPspt_addr());
    localUserdetailExt.setParam(":VBIRTHDAY", paramUserdetailDAO.getBirthday());
    localUserdetailExt.setParam(":VPSPT_TYPE_CODE", paramUserdetailDAO.getPspt_type_code());
    localUserdetailExt.setParam(":VPSPT_ID", paramUserdetailDAO.getPspt_id());
    localUserdetailExt.setParam(":VHOME_ADDR", paramUserdetailDAO.getHome_addr());
    localUserdetailExt.setParam(":VBLOG", paramUserdetailDAO.getBlog());
    localUserdetailExt.setParam(":VFOLK_CODE", paramUserdetailDAO.getFolk_code());
    localUserdetailExt.setParam(":VFAX", paramUserdetailDAO.getFax());
    localUserdetailExt.setParam(":VJOB", paramUserdetailDAO.getJob());
    localUserdetailExt.setParam(":VEDUCATE_DEGREE_CODE", paramUserdetailDAO.getEducate_degree_code());
    localUserdetailExt.setParam(":VPHONE", paramUserdetailDAO.getPhone());
    localUserdetailExt.setParam(":VPOST_ADDR", paramUserdetailDAO.getPost_addr());
    localUserdetailExt.setParam(":VPOST_CODE", paramUserdetailDAO.getPost_code());
    localUserdetailExt.setParam(":VUSER_ID", paramUserdetailDAO.getUser_id());
    localUserdetailExt.setParam(":VCUST_ID", paramUserdetailDAO.getCust_id());
    localUserdetailExt.setParam(":VCUST_NAME", paramUserdetailDAO.getCust_name());
    localUserdetailExt.setParam(":VEMAIL", paramUserdetailDAO.getEmail());
    localUserdetailExt.setParam(":VLOCAL_NATIVE_CODE", paramUserdetailDAO.getLocal_native_code());
    localUserdetailExt.setParam(":VSEX", paramUserdetailDAO.getSex());
    localUserdetailExt.setParam(":VMARRIAGE", paramUserdetailDAO.getMarriage());
    localUserdetailExt.setParam(":VCOMMUNITY_ID", paramUserdetailDAO.getCommunity_id());
    this.tradeQuery.executeBy(localUserdetailExt.insBy("INS_USERDETAIL_BY_CUST"));
    return 0;
  }

  public void updateUserDetailInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateUserDetailInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("COMMUNITY_ID");
    String str2 = paramBuffers.getString("BIRTHDAY");
    String str3 = paramBuffers.getString("WORK_NAME");
    String str4 = paramBuffers.getString("HOME_ADDR");
    String str5 = paramBuffers.getString("WORK_DEPART");
    String str6 = paramBuffers.getString("QQ");
    String str7 = paramBuffers.getString("BLOG");
    String str8 = paramBuffers.getString("FOLK_CODE");
    String str9 = paramBuffers.getString("EDUCATE_DEGREE_CODE");
    String str10 = paramBuffers.getString("PHONE");
    String str11 = paramBuffers.getString("POST_ADDR");
    String str12 = paramBuffers.getString("PSPT_ID");
    String str13 = paramBuffers.getString("PSPT_ADDR");
    String str14 = paramBuffers.getString("PSPT_TYPE_CODE");
    String str15 = paramBuffers.getString("PSPT_END_DATE");
    String str16 = paramBuffers.getString("JOB");
    String str17 = paramBuffers.getString("EMAIL");
    String str18 = paramBuffers.getString("FAX_NBR");
    String str19 = paramBuffers.getString("SEX");
    String str20 = paramBuffers.getString("POST_CODE");
    String str21 = paramBuffers.getString("CUST_ID");
    String str22 = paramBuffers.getString("USER_ID");
    String str23 = paramBuffers.getString("LOCAL_NATIVE_CODE");
    String str24 = paramBuffers.getString("MARRIAGE");
    try
    {
      i = updateUserDetailInfo(str15, str14, str13, str12, str1, str2, str3, str4, str6, str7, str8, str9, str10, str11, str16, str17, str18, str19, str20, str21, str22, str23, str24, str5);
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
    this.log.LOG_INFO("退出addUserDetailInfo方法...");
  }

  public int updateUserDetailInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24)
    throws SaasApplicationException
  {
    UserdetailExt localUserdetailExt = new UserdetailExt();
    localUserdetailExt.setParam(":VPSPT_TYPE_CODE", paramString2);
    localUserdetailExt.setParam(":VPSPT_END_DATE", paramString1);
    localUserdetailExt.setParam(":VPSPT_ADDR", paramString3);
    localUserdetailExt.setParam(":VPSPT_ID", paramString4);
    localUserdetailExt.setParam(":VCOMMUNITY_ID", paramString5);
    localUserdetailExt.setParam(":VBIRTHDAY", paramString6);
    localUserdetailExt.setParam(":VPSPT_TYPE_CODE", paramString6);
    localUserdetailExt.setParam(":VWORK_NAME", paramString7);
    localUserdetailExt.setParam(":VWORK_DEPART", paramString24);
    localUserdetailExt.setParam(":VQQ", paramString9);
    localUserdetailExt.setParam(":VEMAIL", paramString16);
    localUserdetailExt.setParam(":VHOME_ADDR", paramString8);
    localUserdetailExt.setParam(":VBLOG", paramString10);
    localUserdetailExt.setParam(":VFOLK_CODE", paramString11);
    localUserdetailExt.setParam(":VFAX", paramString17);
    localUserdetailExt.setParam(":VSEX", paramString18);
    localUserdetailExt.setParam(":VJOB", paramString15);
    localUserdetailExt.setParam(":VPHONE", paramString13);
    localUserdetailExt.setParam(":VPOST_ADDR", paramString14);
    localUserdetailExt.setParam(":VPOST_CODE", paramString19);
    localUserdetailExt.setParam(":VUSER_ID", paramString21);
    localUserdetailExt.setParam(":VCUST_ID", paramString20);
    localUserdetailExt.setParam(":VEDUCATE_DEGREE_CODE", paramString12);
    localUserdetailExt.setParam(":VMARRIAGE", paramString23);
    localUserdetailExt.setParam(":VLOCAL_NATIVE_CODE", paramString22);
    this.tradeQuery.executeBy(localUserdetailExt.insBy("UPDATE_USERDETAIL_BY_ID"));
    return 0;
  }

  public ArrayList getUserDetailByUserId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    UserdetailExt localUserdetailExt = new UserdetailExt();
    localUserdetailExt.setParam(":VUSER_ID", paramString1);
    localUserdetailExt.setParam(":VCUST_ID", paramString2);
    ArrayList localArrayList = localUserdetailExt.selByList("SEL_BY_USER_ID");
    return localArrayList;
  }

  public void addAdminDetailInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addAdminDetailInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PHONE");
    String str2 = paramBuffers.getString("CUST_ID");
    String str3 = paramBuffers.getString("USER_ID");
    String str4 = paramBuffers.getString("CUST_NAME");
    String str5 = paramBuffers.getString("BIRTHDAY");
    String str6 = paramBuffers.getString("EMAIL");
    String str7 = paramBuffers.getString("SEX");
    try
    {
      UserdetailDAO localUserdetailDAO = new UserdetailDAO();
      localUserdetailDAO.setEmail(str6);
      localUserdetailDAO.setPhone(str1);
      localUserdetailDAO.setUser_id(str3);
      localUserdetailDAO.setCust_id(str2);
      localUserdetailDAO.setCust_name(str4);
      localUserdetailDAO.setSex(str7);
      localUserdetailDAO.setBirthday(str5);
      i = addAdminDetailInfo(localUserdetailDAO);
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
    this.log.LOG_INFO("退出addAdminDetailInfo方法...");
  }

  public int addAdminDetailInfo(UserdetailDAO paramUserdetailDAO)
    throws SaasApplicationException
  {
    UserdetailExt localUserdetailExt = new UserdetailExt();
    localUserdetailExt.setParam(":VBIRTHDAY", paramUserdetailDAO.getBirthday());
    localUserdetailExt.setParam(":VPHONE", paramUserdetailDAO.getPhone());
    localUserdetailExt.setParam(":VUSER_ID", paramUserdetailDAO.getUser_id());
    localUserdetailExt.setParam(":VCUST_ID", paramUserdetailDAO.getCust_id());
    localUserdetailExt.setParam(":VCUST_NAME", paramUserdetailDAO.getCust_name());
    localUserdetailExt.setParam(":VEMAIL", paramUserdetailDAO.getEmail());
    localUserdetailExt.setParam(":VSEX", paramUserdetailDAO.getSex());
    this.tradeQuery.executeBy(localUserdetailExt.insBy("INS_BY_ADMIN_USER_DETAIL"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.userMgr.UserDetailInfo
 * JD-Core Version:    0.6.0
 */