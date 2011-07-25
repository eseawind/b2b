package com.saas.biz.dao.forinfoDAO;

import java.io.Serializable;

public class ForinfoDAO
  implements Serializable
{
  private static final long serialVersionUID = 5542846085523829206L;
  private Integer id;
  private String title;
  private String scale;
  private String brief;
  private String content;
  private String wholeprice;
  private String type;
  private String unit;
  private String tel;
  private String fax;
  private String email;
  private String recorduser;
  private Integer part;
  private String pubtime;

  public ForinfoDAO()
  {
  }

  public ForinfoDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Integer paramInteger, String paramString12)
  {
    this.title = paramString1;
    this.scale = paramString2;
    this.brief = paramString3;
    this.content = paramString4;
    this.wholeprice = paramString5;
    this.type = paramString6;
    this.unit = paramString7;
    this.tel = paramString8;
    this.fax = paramString9;
    this.email = paramString10;
    this.recorduser = paramString11;
    this.part = paramInteger;
    this.pubtime = paramString12;
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

  public String getScale()
  {
    return this.scale;
  }

  public void setScale(String paramString)
  {
    this.scale = paramString;
  }

  public String getBrief()
  {
    return this.brief;
  }

  public void setBrief(String paramString)
  {
    this.brief = paramString;
  }

  public String getContent()
  {
    return this.content;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public String getWholeprice()
  {
    return this.wholeprice;
  }

  public void setWholeprice(String paramString)
  {
    this.wholeprice = paramString;
  }

  public String getType()
  {
    return this.type;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public String getUnit()
  {
    return this.unit;
  }

  public void setUnit(String paramString)
  {
    this.unit = paramString;
  }

  public String getTel()
  {
    return this.tel;
  }

  public void setTel(String paramString)
  {
    this.tel = paramString;
  }

  public String getFax()
  {
    return this.fax;
  }

  public void setFax(String paramString)
  {
    this.fax = paramString;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String paramString)
  {
    this.email = paramString;
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
 * Qualified Name:     com.saas.biz.dao.forinfoDAO.ForinfoDAO
 * JD-Core Version:    0.6.0
 */