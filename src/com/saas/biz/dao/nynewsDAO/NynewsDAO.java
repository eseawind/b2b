package com.saas.biz.dao.nynewsDAO;

import java.io.Serializable;

public class NynewsDAO
  implements Serializable
{
  private static final long serialVersionUID = -4313597195677462584L;
  private Integer id;
  private String type;
  private String title;
  private String content;
  private String sites;
  private String pubtime;

  public NynewsDAO()
  {
  }

  public NynewsDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.type = paramString1;
    this.title = paramString2;
    this.content = paramString3;
    this.sites = paramString4;
    this.pubtime = paramString5;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getType()
  {
    return this.type;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
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

  public String getSites()
  {
    return this.sites;
  }

  public void setSites(String paramString)
  {
    this.sites = paramString;
  }

  public String getPubtime()
  {
    return this.pubtime;
  }

  public void setPubtime(String paramString)
  {
    this.pubtime = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.nynewsDAO.NynewsDAO
 * JD-Core Version:    0.6.0
 */