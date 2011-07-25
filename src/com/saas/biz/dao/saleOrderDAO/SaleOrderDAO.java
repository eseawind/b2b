package com.saas.biz.dao.saleOrderDAO;

import java.io.Serializable;

public class SaleOrderDAO
  implements Serializable
{
  private static final long serialVersionUID = 5781506067422476326L;
  private String trade_id;
  private String product_id;
  private String order_num;
  private String game_role;
  private String order_addr;
  private String spec_need;
  private String contact;
  private String phone;
  private String email;
  private String qq;
  private String contact_addr;
  private String other_contact;
  private String rsrv_str1;
  private String rsrv_str2;
  private String rsrv_str3;
  private String rsrv_str4;
  private String rsrv_str5;
  private String in_date;
  private String remark;

  public String getContact()
  {
    return this.contact;
  }

  public void setContact(String paramString)
  {
    this.contact = paramString;
  }

  public String getContact_addr()
  {
    return this.contact_addr;
  }

  public void setContact_addr(String paramString)
  {
    this.contact_addr = paramString;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String paramString)
  {
    this.email = paramString;
  }

  public String getGame_role()
  {
    return this.game_role;
  }

  public void setGame_role(String paramString)
  {
    this.game_role = paramString;
  }

  public String getIn_date()
  {
    return this.in_date;
  }

  public void setIn_date(String paramString)
  {
    this.in_date = paramString;
  }

  public String getOrder_addr()
  {
    return this.order_addr;
  }

  public void setOrder_addr(String paramString)
  {
    this.order_addr = paramString;
  }

  public String getOrder_num()
  {
    return this.order_num;
  }

  public void setOrder_num(String paramString)
  {
    this.order_num = paramString;
  }

  public String getOther_contact()
  {
    return this.other_contact;
  }

  public void setOther_contact(String paramString)
  {
    this.other_contact = paramString;
  }

  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }

  public String getProduct_id()
  {
    return this.product_id;
  }

  public void setProduct_id(String paramString)
  {
    this.product_id = paramString;
  }

  public String getQq()
  {
    return this.qq;
  }

  public void setQq(String paramString)
  {
    this.qq = paramString;
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

  public String getSpec_need()
  {
    return this.spec_need;
  }

  public void setSpec_need(String paramString)
  {
    this.spec_need = paramString;
  }

  public String getTrade_id()
  {
    return this.trade_id;
  }

  public void setTrade_id(String paramString)
  {
    this.trade_id = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.saleOrderDAO.SaleOrderDAO
 * JD-Core Version:    0.6.0
 */