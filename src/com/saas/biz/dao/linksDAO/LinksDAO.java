package com.saas.biz.dao.linksDAO;

import java.io.Serializable;

public class LinksDAO
  implements Serializable
{
  private static final long serialVersionUID = -8098779217879559794L;
  private Integer id;
  private String name;
  private String comment;
  private String pic;
  private String recorduser;
  private Integer part;
  private String pubtime;

  public LinksDAO()
  {
  }

  public LinksDAO(String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger, String paramString5)
  {
    this.name = paramString1;
    this.comment = paramString2;
    this.pic = paramString3;
    this.recorduser = paramString4;
    this.part = paramInteger;
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

  public String getName()
  {
    return this.name;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public String getComment()
  {
    return this.comment;
  }

  public void setComment(String paramString)
  {
    this.comment = paramString;
  }

  public String getPic()
  {
    return this.pic;
  }

  public void setPic(String paramString)
  {
    this.pic = paramString;
  }

  public String getRecorduser()
  {
    return this.recorduser;
  }

  public void setRecorduser(String paramString)
  {
    this.recorduser = paramString;
  }

  public Integer getPart()
  {
    return this.part;
  }

  public void setPart(Integer paramInteger)
  {
    this.part = paramInteger;
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
 * Qualified Name:     com.saas.biz.dao.linksDAO.LinksDAO
 * JD-Core Version:    0.6.0
 */