package com.saas.biz.dao.quoteDAO;

import java.io.Serializable;

public class QuoteDAO
  implements Serializable
{
  private static final long serialVersionUID = 1843260551376308177L;
  private String cust_id;
  private String form_id;
  private String prep_id;
  private String query_id;
  private String prep_name;
  private String obj_cust_id;
  private String prep_obj_id;
  private String contact_man;
  private String contact;
  private String give_date;
  private String give_addr;
  private String ship_type;
  private String currency_code;
  private String off_count;
  private String off_rate;
  private String ship_fee;
  private String tax;
  private String all_fee;
  private String prep_count;
  private String part_delivery_tag;
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
  private String oper_user_id;
  private String in_date;
  private String remark2;

  public static long getSerialVersionUID()
  {
    return 1843260551376308177L;
  }

  public String getAll_fee()
  {
    return this.all_fee;
  }

  public void setAll_fee(String paramString)
  {
    this.all_fee = paramString;
  }

  public String getContact()
  {
    return this.contact;
  }

  public void setContact(String paramString)
  {
    this.contact = paramString;
  }

  public String getContact_man()
  {
    return this.contact_man;
  }

  public void setContact_man(String paramString)
  {
    this.contact_man = paramString;
  }

  public String getCurrency_code()
  {
    return this.currency_code;
  }

  public void setCurrency_code(String paramString)
  {
    this.currency_code = paramString;
  }

  public String getCust_id()
  {
    return this.cust_id;
  }

  public void setCust_id(String paramString)
  {
    this.cust_id = paramString;
  }

  public String getForm_id()
  {
    return this.form_id;
  }

  public void setForm_id(String paramString)
  {
    this.form_id = paramString;
  }

  public String getGive_addr()
  {
    return this.give_addr;
  }

  public void setGive_addr(String paramString)
  {
    this.give_addr = paramString;
  }

  public String getGive_date()
  {
    return this.give_date;
  }

  public void setGive_date(String paramString)
  {
    this.give_date = paramString;
  }

  public String getIn_date()
  {
    return this.in_date;
  }

  public void setIn_date(String paramString)
  {
    this.in_date = paramString;
  }

  public String getObj_cust_id()
  {
    return this.obj_cust_id;
  }

  public void setObj_cust_id(String paramString)
  {
    this.obj_cust_id = paramString;
  }

  public String getOff_count()
  {
    return this.off_count;
  }

  public void setOff_count(String paramString)
  {
    this.off_count = paramString;
  }

  public String getOff_rate()
  {
    return this.off_rate;
  }

  public void setOff_rate(String paramString)
  {
    this.off_rate = paramString;
  }

  public String getOper_user_id()
  {
    return this.oper_user_id;
  }

  public void setOper_user_id(String paramString)
  {
    this.oper_user_id = paramString;
  }

  public String getPart_delivery_tag()
  {
    return this.part_delivery_tag;
  }

  public void setPart_delivery_tag(String paramString)
  {
    this.part_delivery_tag = paramString;
  }

  public String getPrep_count()
  {
    return this.prep_count;
  }

  public void setPrep_count(String paramString)
  {
    this.prep_count = paramString;
  }

  public String getPrep_id()
  {
    return this.prep_id;
  }

  public void setPrep_id(String paramString)
  {
    this.prep_id = paramString;
  }

  public String getPrep_name()
  {
    return this.prep_name;
  }

  public void setPrep_name(String paramString)
  {
    this.prep_name = paramString;
  }

  public String getPrep_obj_id()
  {
    return this.prep_obj_id;
  }

  public void setPrep_obj_id(String paramString)
  {
    this.prep_obj_id = paramString;
  }

  public String getQuery_id()
  {
    return this.query_id;
  }

  public void setQuery_id(String paramString)
  {
    this.query_id = paramString;
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

  public String getShip_fee()
  {
    return this.ship_fee;
  }

  public void setShip_fee(String paramString)
  {
    this.ship_fee = paramString;
  }

  public String getShip_type()
  {
    return this.ship_type;
  }

  public void setShip_type(String paramString)
  {
    this.ship_type = paramString;
  }

  public String getTax()
  {
    return this.tax;
  }

  public void setTax(String paramString)
  {
    this.tax = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.quoteDAO.QuoteDAO
 * JD-Core Version:    0.6.0
 */