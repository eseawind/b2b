package com.saas.biz.dao.entClassDAO;

import java.io.Serializable;

public class EntClassDAO
  implements Serializable
{
  private static final long serialVersionUID = -3280422753173115234L;
  private String cust_id;
  private String entity_type;
  private String entity_id;
  private String class_id;
  private String class_name;
  private String class_id_grp;
  private String class_name_grp;
  private String rsrv_str1;
  private String rsrv_str2;
  private String rsrv_str3;
  private String rsrv_str4;
  private String rsrv_str5;
  private String rsrv_str6;
  private String oper_user_id;
  private String in_date;
  private String remark;

  public String getClass_id()
  {
    return this.class_id;
  }

  public void setClass_id(String paramString)
  {
    this.class_id = paramString;
  }

  public String getClass_id_grp()
  {
    return this.class_id_grp;
  }

  public void setClass_id_grp(String paramString)
  {
    this.class_id_grp = paramString;
  }

  public String getClass_name()
  {
    return this.class_name;
  }

  public void setClass_name(String paramString)
  {
    this.class_name = paramString;
  }

  public String getClass_name_grp()
  {
    return this.class_name_grp;
  }

  public void setClass_name_grp(String paramString)
  {
    this.class_name_grp = paramString;
  }

  public String getCust_id()
  {
    return this.cust_id;
  }

  public void setCust_id(String paramString)
  {
    this.cust_id = paramString;
  }

  public String getEntity_id()
  {
    return this.entity_id;
  }

  public void setEntity_id(String paramString)
  {
    this.entity_id = paramString;
  }

  public String getEntity_type()
  {
    return this.entity_type;
  }

  public void setEntity_type(String paramString)
  {
    this.entity_type = paramString;
  }

  public String getIn_date()
  {
    return this.in_date;
  }

  public void setIn_date(String paramString)
  {
    this.in_date = paramString;
  }

  public String getOper_user_id()
  {
    return this.oper_user_id;
  }

  public void setOper_user_id(String paramString)
  {
    this.oper_user_id = paramString;
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
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.entClassDAO.EntClassDAO
 * JD-Core Version:    0.6.0
 */