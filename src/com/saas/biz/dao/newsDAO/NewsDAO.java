package com.saas.biz.dao.newsDAO;

public class NewsDAO
{
  public String news_id;
  public String news_type;
  public String cust_id;
  public String title;
  public String content;
  public String attachment_tag;
  public String validity;
  public String news_class;
  public String subject_tag;
  public String publish_user_id;
  public String publish_date;
  public String audit_user_id;
  public String audit_date;
  public String remark;

  public void NewsDAO()
  {
  }

  public String getAttachment_tag()
  {
    return this.attachment_tag;
  }

  public String getSubject_tag()
  {
    return this.subject_tag;
  }

  public void setSubject_tag(String paramString)
  {
    this.subject_tag = paramString;
  }

  public void setAttachment_tag(String paramString)
  {
    this.attachment_tag = paramString;
  }

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

  public String getNews_class()
  {
    return this.news_class;
  }

  public void setNews_class(String paramString)
  {
    this.news_class = paramString;
  }

  public String getNews_id()
  {
    return this.news_id;
  }

  public void setNews_id(String paramString)
  {
    this.news_id = paramString;
  }

  public String getNews_type()
  {
    return this.news_type;
  }

  public void setNews_type(String paramString)
  {
    this.news_type = paramString;
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
 * Qualified Name:     com.saas.biz.dao.newsDAO.NewsDAO
 * JD-Core Version:    0.6.0
 */