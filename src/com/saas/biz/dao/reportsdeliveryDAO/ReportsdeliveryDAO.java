package com.saas.biz.dao.reportsdeliveryDAO;

import java.io.Serializable;

public class ReportsdeliveryDAO
  implements Serializable
{
  private static final long serialVersionUID = -5204927478210648188L;
  private String id;
  private String title;
  private String content;
  private String path;
  private String rpart;
  private String user;
  private String part;
  private String pubtime;
  private Integer xchecked;

  public ReportsdeliveryDAO()
  {
  }

  public ReportsdeliveryDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Integer paramInteger)
  {
    this.title = paramString1;
    this.content = paramString2;
    this.path = paramString3;
    this.rpart = paramString4;
    this.user = paramString5;
    this.part = paramString6;
    this.pubtime = paramString7;
    this.xchecked = paramInteger;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public String getContent()
  {
    return this.content;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public String getPath()
  {
    return this.path;
  }

  public void setPath(String paramString)
  {
    this.path = paramString;
  }

  public String getRpart()
  {
    return this.rpart;
  }

  public void setRpart(String paramString)
  {
    this.rpart = paramString;
  }

  public String getUser()
  {
    return this.user;
  }

  public void setUser(String paramString)
  {
    this.user = paramString;
  }

  public String getPart()
  {
    return this.part;
  }

  public void setPart(String paramString)
  {
    this.part = paramString;
  }

  public String getPubtime()
  {
    return this.pubtime;
  }

  public void setPubtime(String paramString)
  {
    this.pubtime = paramString;
  }

  public String getId()
  {
    return this.id;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public Integer getXchecked()
  {
    return this.xchecked;
  }

  public void setXchecked(Integer paramInteger)
  {
    this.xchecked = paramInteger;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.reportsdeliveryDAO.ReportsdeliveryDAO
 * JD-Core Version:    0.6.0
 */