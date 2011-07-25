package com.saas.biz.dao.applyinfoDAO;

public class ApplyinfoDAO
{
  private Integer id;
  private String type;
  private String title;
  private String site;
  private String hy;
  private String price;
  private String connman;
  private String address;
  private String mail;
  private String tel;
  private String phone;
  private String comment;
  private String recorduser;
  private Integer part;
  private String pubtime;

  public ApplyinfoDAO()
  {
  }

  public ApplyinfoDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, Integer paramInteger, String paramString13)
  {
    this.type = paramString1;
    this.title = paramString2;
    this.site = paramString3;
    this.hy = paramString4;
    this.price = paramString5;
    this.connman = paramString6;
    this.address = paramString7;
    this.mail = paramString8;
    this.tel = paramString9;
    this.phone = paramString10;
    this.comment = paramString11;
    this.recorduser = paramString12;
    this.part = paramInteger;
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

  public String getSite()
  {
    return this.site;
  }

  public void setSite(String paramString)
  {
    this.site = paramString;
  }

  public String getHy()
  {
    return this.hy;
  }

  public void setHy(String paramString)
  {
    this.hy = paramString;
  }

  public String getPrice()
  {
    return this.price;
  }

  public void setPrice(String paramString)
  {
    this.price = paramString;
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

  public String getMail()
  {
    return this.mail;
  }

  public void setMail(String paramString)
  {
    this.mail = paramString;
  }

  public String getTel()
  {
    return this.tel;
  }

  public void setTel(String paramString)
  {
    this.tel = paramString;
  }

  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String paramString)
  {
    this.phone = paramString;
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
 * Qualified Name:     com.saas.biz.dao.applyinfoDAO.ApplyinfoDAO
 * JD-Core Version:    0.6.0
 */