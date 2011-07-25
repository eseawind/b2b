package com.saas.biz.dao.patentsDAO;

import java.io.Serializable;

public class PatentsDAO
  implements Serializable
{
  private static final long serialVersionUID = 6148147107687349095L;
  private Integer id;
  private String title;
  private String connman;
  private String address;
  private String tel;
  private String comment;
  private String recorduser;
  private Integer part;
  private String pubtime;

  public PatentsDAO()
  {
  }

  public PatentsDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Integer paramInteger, String paramString7)
  {
    this.title = paramString1;
    this.connman = paramString2;
    this.address = paramString3;
    this.tel = paramString4;
    this.comment = paramString5;
    this.recorduser = paramString6;
    this.part = paramInteger;
    this.pubtime = paramString7;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public String getConnman()
  {
    return this.connman;
  }

  public void setConnman(String paramString)
  {
    this.connman = paramString;
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public String getTel()
  {
    return this.tel;
  }

  public void setTel(String paramString)
  {
    this.tel = paramString;
  }

  public String getComment()
  {
    return this.comment;
  }

  public void setComment(String paramString)
  {
    this.comment = paramString;
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
 * Qualified Name:     com.saas.biz.dao.patentsDAO.PatentsDAO
 * JD-Core Version:    0.6.0
 */