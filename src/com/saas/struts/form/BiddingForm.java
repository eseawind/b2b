package com.saas.struts.form;

import org.apache.struts.action.ActionForm;

public class BiddingForm extends ActionForm
{
  private String bidding_id;
  private String cust_id;
  private String title;
  private String bidding_no;
  private String open_date;
  private String addr;
  private String content;
  private String phone;
  private String attach_tag;
  private String bidding_type;
  private String publish_person;
  private String publish_date;
  private String audit_person;
  private String audit_date;
  private String validity;
  private String remark;

  public String getAddr()
  {
    return this.addr;
  }

  public void setAddr(String paramString)
  {
    this.addr = paramString;
  }

  public String getAttach_tag()
  {
    return this.attach_tag;
  }

  public void setAttach_tag(String paramString)
  {
    this.attach_tag = paramString;
  }

  public String getAudit_date()
  {
    return this.audit_date;
  }

  public void setAudit_date(String paramString)
  {
    this.audit_date = paramString;
  }

  public String getAudit_person()
  {
    return this.audit_person;
  }

  public void setAudit_person(String paramString)
  {
    this.audit_person = paramString;
  }

  public String getBidding_id()
  {
    return this.bidding_id;
  }

  public void setBidding_id(String paramString)
  {
    this.bidding_id = paramString;
  }

  public String getBidding_no()
  {
    return this.bidding_no;
  }

  public void setBidding_no(String paramString)
  {
    this.bidding_no = paramString;
  }

  public String getBidding_type()
  {
    return this.bidding_type;
  }

  public void setBidding_type(String paramString)
  {
    this.bidding_type = paramString;
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

  public String getOpen_date()
  {
    return this.open_date;
  }

  public void setOpen_date(String paramString)
  {
    this.open_date = paramString;
  }

  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }

  public String getPublish_date()
  {
    return this.publish_date;
  }

  public void setPublish_date(String paramString)
  {
    this.publish_date = paramString;
  }

  public String getPublish_person()
  {
    return this.publish_person;
  }

  public void setPublish_person(String paramString)
  {
    this.publish_person = paramString;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public String getValidity()
  {
    return this.validity;
  }

  public void setValidity(String paramString)
  {
    this.validity = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.form.BiddingForm
 * JD-Core Version:    0.6.0
 */