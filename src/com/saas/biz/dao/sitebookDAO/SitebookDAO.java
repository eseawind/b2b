package com.saas.biz.dao.sitebookDAO;

import java.io.Serializable;

public class SitebookDAO
  implements Serializable
{
  private static final long serialVersionUID = 6458559625374171952L;
  private Integer id;
  private String website;
  private String comment;
  private Integer xshare;
  private String recorduser;
  private String part;
  private String pubtime;
  private String user;

  public SitebookDAO()
  {
  }

  public SitebookDAO(String paramString1, String paramString2, Integer paramInteger, String paramString3, String paramString4, String paramString5)
  {
    this.website = paramString1;
    this.comment = paramString2;
    this.xshare = paramInteger;
    this.recorduser = paramString3;
    this.part = paramString4;
    this.user = paramString5;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public Integer getXshare()
  {
    return this.xshare;
  }

  public void setXshare(Integer paramInteger)
  {
    this.xshare = paramInteger;
  }

  public String getRecorduser()
  {
    return this.recorduser;
  }

  public void setRecorduser(String paramString)
  {
    this.recorduser = paramString;
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

  public String getComment()
  {
    return this.comment;
  }

  public void setComment(String paramString)
  {
    this.comment = paramString;
  }

  public String getUser()
  {
    return this.user;
  }

  public void setUser(String paramString)
  {
    this.user = paramString;
  }

  public String getWebsite()
  {
    return this.website;
  }

  public void setWebsite(String paramString)
  {
    this.website = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.sitebookDAO.SitebookDAO
 * JD-Core Version:    0.6.0
 */