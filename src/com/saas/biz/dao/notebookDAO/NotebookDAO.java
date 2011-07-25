package com.saas.biz.dao.notebookDAO;

import java.io.Serializable;

public class NotebookDAO
  implements Serializable
{
  private static final long serialVersionUID = -4595326785815234789L;
  private Integer id;
  private String name;
  private Integer sex;
  private String xphone;
  private String hometel;
  private String officetel;
  private String address;
  private String unit;
  private String email;
  private String qq;
  private String msn;
  private String yahoo;
  private Integer relationship;
  private String recorduser;
  private String part;
  private String pubtime;

  public NotebookDAO()
  {
  }

  public NotebookDAO(String paramString1, Integer paramInteger1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, Integer paramInteger2, String paramString11, String paramString12, String paramString13)
  {
    this.name = paramString1;
    this.sex = paramInteger1;
    this.xphone = paramString2;
    this.hometel = paramString3;
    this.officetel = paramString4;
    this.address = paramString5;
    this.unit = paramString6;
    this.email = paramString7;
    this.qq = paramString8;
    this.msn = paramString9;
    this.yahoo = paramString10;
    this.relationship = paramInteger2;
    this.recorduser = paramString11;
    this.part = paramString12;
    this.pubtime = paramString13;
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

  public Integer getSex()
  {
    return this.sex;
  }

  public void setSex(Integer paramInteger)
  {
    this.sex = paramInteger;
  }

  public String getXphone()
  {
    return this.xphone;
  }

  public void setXphone(String paramString)
  {
    this.xphone = paramString;
  }

  public String getHometel()
  {
    return this.hometel;
  }

  public void setHometel(String paramString)
  {
    this.hometel = paramString;
  }

  public String getOfficetel()
  {
    return this.officetel;
  }

  public void setOfficetel(String paramString)
  {
    this.officetel = paramString;
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public String getUnit()
  {
    return this.unit;
  }

  public void setUnit(String paramString)
  {
    this.unit = paramString;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String paramString)
  {
    this.email = paramString;
  }

  public String getQq()
  {
    return this.qq;
  }

  public void setQq(String paramString)
  {
    this.qq = paramString;
  }

  public String getMsn()
  {
    return this.msn;
  }

  public void setMsn(String paramString)
  {
    this.msn = paramString;
  }

  public String getYahoo()
  {
    return this.yahoo;
  }

  public void setYahoo(String paramString)
  {
    this.yahoo = paramString;
  }

  public Integer getRelationship()
  {
    return this.relationship;
  }

  public void setRelationship(Integer paramInteger)
  {
    this.relationship = paramInteger;
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
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.notebookDAO.NotebookDAO
 * JD-Core Version:    0.6.0
 */