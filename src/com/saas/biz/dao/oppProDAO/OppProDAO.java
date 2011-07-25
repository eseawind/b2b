package com.saas.biz.dao.oppProDAO;

import java.io.Serializable;

public class OppProDAO
  implements Serializable
{
  private static final long serialVersionUID = -1740654967943528325L;
  private String cust_id;
  private String proj_name;
  private String proj_id;
  private String title;
  private String content;
  private String start_date;
  private String end_date;
  private String own_cust_id;
  private String own_cust_name;
  private String user_id;
  private String state_code;
  private String rsrv_str1;
  private String rsrv_str2;
  private String rsrv_str3;
  private String rsrv_str4;
  private String rsrv_str5;
  private String rsrv_str6;
  private String rsrv_str7;
  private String rsrv_str8;
  private String rsrv_str9;
  private String rsrv_str10;
  private String in_date;
  private String remark;

  public static long getSerialVersionUID()
  {
    return -1740654967943528325L;
  }

  public String getContent()
  {
    return this.content;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public String getCust_id()
  {
    return this.cust_id;
  }

  public void setCust_id(String paramString)
  {
    this.cust_id = paramString;
  }

  public String getEnd_date()
  {
    return this.end_date;
  }

  public void setEnd_date(String paramString)
  {
    this.end_date = paramString;
  }

  public String getIn_date()
  {
    return this.in_date;
  }

  public void setIn_date(String paramString)
  {
    this.in_date = paramString;
  }

  public String getOwn_cust_id()
  {
    return this.own_cust_id;
  }

  public void setOwn_cust_id(String paramString)
  {
    this.own_cust_id = paramString;
  }

  public String getOwn_cust_name()
  {
    return this.own_cust_name;
  }

  public void setOwn_cust_name(String paramString)
  {
    this.own_cust_name = paramString;
  }

  public String getProj_id()
  {
    return this.proj_id;
  }

  public void setProj_id(String paramString)
  {
    this.proj_id = paramString;
  }

  public String getProj_name()
  {
    return this.proj_name;
  }

  public void setProj_name(String paramString)
  {
    this.proj_name = paramString;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public String getRsrv_str1()
  {
    return this.rsrv_str1;
  }

  public void setRsrv_str1(String paramString)
  {
    this.rsrv_str1 = paramString;
  }

  public String getRsrv_str10()
  {
    return this.rsrv_str10;
  }

  public void setRsrv_str10(String paramString)
  {
    this.rsrv_str10 = paramString;
  }

  public String getRsrv_str2()
  {
    return this.rsrv_str2;
  }

  public void setRsrv_str2(String paramString)
  {
    this.rsrv_str2 = paramString;
  }

  public String getRsrv_str3()
  {
    return this.rsrv_str3;
  }

  public void setRsrv_str3(String paramString)
  {
    this.rsrv_str3 = paramString;
  }

  public String getRsrv_str4()
  {
    return this.rsrv_str4;
  }

  public void setRsrv_str4(String paramString)
  {
    this.rsrv_str4 = paramString;
  }

  public String getRsrv_str5()
  {
    return this.rsrv_str5;
  }

  public void setRsrv_str5(String paramString)
  {
    this.rsrv_str5 = paramString;
  }

  public String getRsrv_str6()
  {
    return this.rsrv_str6;
  }

  public void setRsrv_str6(String paramString)
  {
    this.rsrv_str6 = paramString;
  }

  public String getRsrv_str7()
  {
    return this.rsrv_str7;
  }

  public void setRsrv_str7(String paramString)
  {
    this.rsrv_str7 = paramString;
  }

  public String getRsrv_str8()
  {
    return this.rsrv_str8;
  }

  public void setRsrv_str8(String paramString)
  {
    this.rsrv_str8 = paramString;
  }

  public String getRsrv_str9()
  {
    return this.rsrv_str9;
  }

  public void setRsrv_str9(String paramString)
  {
    this.rsrv_str9 = paramString;
  }

  public String getStart_date()
  {
    return this.start_date;
  }

  public void setStart_date(String paramString)
  {
    this.start_date = paramString;
  }

  public String getState_code()
  {
    return this.state_code;
  }

  public void setState_code(String paramString)
  {
    this.state_code = paramString;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public String getUser_id()
  {
    return this.user_id;
  }

  public void setUser_id(String paramString)
  {
    this.user_id = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.oppProDAO.OppProDAO
 * JD-Core Version:    0.6.0
 */