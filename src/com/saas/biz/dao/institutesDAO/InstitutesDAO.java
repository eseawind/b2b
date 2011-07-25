package com.saas.biz.dao.institutesDAO;

import java.io.Serializable;

public class InstitutesDAO
  implements Serializable
{
  private static final long serialVersionUID = -7260659258314793768L;
  private Integer id;
  private String name;
  private String comment;
  private String manuser;
  private String address;
  private String tel;
  private String connuser;
  private String recorduser;
  private Integer part;
  private String pubtime;

  public InstitutesDAO()
  {
  }

  public InstitutesDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Integer paramInteger, String paramString8)
  {
    this.name = paramString1;
    this.comment = paramString2;
    this.manuser = paramString3;
    this.address = paramString4;
    this.tel = paramString5;
    this.connuser = paramString6;
    this.recorduser = paramString7;
    this.part = paramInteger;
    this.pubtime = paramString8;
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

  public String getManuser()
  {
    return this.manuser;
  }

  public void setManuser(String paramString)
  {
    this.manuser = paramString;
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

  public String getConnuser()
  {
    return this.connuser;
  }

  public void setConnuser(String paramString)
  {
    this.connuser = paramString;
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
 * Qualified Name:     com.saas.biz.dao.institutesDAO.InstitutesDAO
 * JD-Core Version:    0.6.0
 */