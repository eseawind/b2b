package com.saas.struts.form;

import org.apache.struts.action.ActionForm;

public class StockOrderForm extends ActionForm
{
  private String stock_id;
  private String cust_id;
  private String stock_type;
  private String title;
  private String content;
  private String stock_addr;
  private String stock_class;
  private String start_date;
  private String end_date;
  private String publish_date;
  private String publish_user_id;
  private String validity;
  private String audit_date;
  private String audit_user_id;
  private String remark;

  public String getAudit_date()
  {
    return this.audit_date;
  }

  public void setAudit_date(String paramString)
  {
    this.audit_date = paramString;
  }

  public String getAudit_user_id()
  {
    return this.audit_user_id;
  }

  public void setAudit_user_id(String paramString)
  {
    this.audit_user_id = paramString;
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

  public String getPublish_date()
  {
    return this.publish_date;
  }

  public void setPublish_date(String paramString)
  {
    this.publish_date = paramString;
  }

  public String getPublish_user_id()
  {
    return this.publish_user_id;
  }

  public void setPublish_user_id(String paramString)
  {
    this.publish_user_id = paramString;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public String getStart_date()
  {
    return this.start_date;
  }

  public void setStart_date(String paramString)
  {
    this.start_date = paramString;
  }

  public String getStock_addr()
  {
    return this.stock_addr;
  }

  public void setStock_addr(String paramString)
  {
    this.stock_addr = paramString;
  }

  public String getStock_class()
  {
    return this.stock_class;
  }

  public void setStock_class(String paramString)
  {
    this.stock_class = paramString;
  }

  public String getStock_id()
  {
    return this.stock_id;
  }

  public void setStock_id(String paramString)
  {
    this.stock_id = paramString;
  }

  public String getStock_type()
  {
    return this.stock_type;
  }

  public void setStock_type(String paramString)
  {
    this.stock_type = paramString;
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
 * Qualified Name:     com.saas.struts.form.StockOrderForm
 * JD-Core Version:    0.6.0
 */