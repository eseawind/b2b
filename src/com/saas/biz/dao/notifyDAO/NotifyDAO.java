package com.saas.biz.dao.notifyDAO;

import java.io.Serializable;

public class NotifyDAO
  implements Serializable
{
  private static final long serialVersionUID = -4106226838171407605L;
  private String id;
  private String title;
  private String content;
  private String path;
  private String user;
  private String part;
  private String pubtime;
  private Integer checked;
  private String xvisible;

  public NotifyDAO()
  {
  }

  public NotifyDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Integer paramInteger, String paramString7)
  {
    this.title = paramString1;
    this.content = paramString2;
    this.path = paramString3;
    this.user = paramString4;
    this.part = paramString5;
    this.pubtime = paramString6;
    this.checked = paramInteger;
    this.xvisible = paramString7;
  }

  public String getId()
  {
    return this.id;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
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

  public Integer getChecked()
  {
    return this.checked;
  }

  public void setChecked(Integer paramInteger)
  {
    this.checked = paramInteger;
  }

  public String getXvisible()
  {
    return this.xvisible;
  }

  public void setXvisible(String paramString)
  {
    this.xvisible = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.notifyDAO.NotifyDAO
 * JD-Core Version:    0.6.0
 */