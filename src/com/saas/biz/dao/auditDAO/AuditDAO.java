package com.saas.biz.dao.auditDAO;

import java.io.Serializable;

public class AuditDAO
  implements Serializable
{
  private static final long serialVersionUID = -7104813773805307261L;
  private String trade_id;
  private String obj_id;
  private String cust_id;
  private String audit_user_id;
  private String audit_msg;
  private String audit_state;
  private String audit_date;
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
  private String remark2;

  public String getAudit_date()
  {
    return this.audit_date;
  }

  public void setAudit_date(String paramString)
  {
    this.audit_date = paramString;
  }

  public String getAudit_msg()
  {
    return this.audit_msg;
  }

  public void setAudit_msg(String paramString)
  {
    this.audit_msg = paramString;
  }

  public String getAudit_state()
  {
    return this.audit_state;
  }

  public void setAudit_state(String paramString)
  {
    this.audit_state = paramString;
  }

  public String getAudit_user_id()
  {
    return this.audit_user_id;
  }

  public void setAudit_user_id(String paramString)
  {
    this.audit_user_id = paramString;
  }

  public String getIn_date()
  {
    return this.in_date;
  }

  public void setIn_date(String paramString)
  {
    this.in_date = paramString;
  }

  public String getObj_id()
  {
    return this.obj_id;
  }

  public void setObj_id(String paramString)
  {
    this.obj_id = paramString;
  }

  public String getRemark2()
  {
    return this.remark2;
  }

  public void setRemark2(String paramString)
  {
    this.remark2 = paramString;
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

  public String getTrade_id()
  {
    return this.trade_id;
  }

  public void setTrade_id(String paramString)
  {
    this.trade_id = paramString;
  }

  public String getCust_id()
  {
    return this.cust_id;
  }

  public void setCust_id(String paramString)
  {
    this.cust_id = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.auditDAO.AuditDAO
 * JD-Core Version:    0.6.0
 */