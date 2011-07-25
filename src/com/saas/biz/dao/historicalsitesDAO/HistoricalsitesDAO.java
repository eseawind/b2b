package com.saas.biz.dao.historicalsitesDAO;

import java.io.Serializable;

public class HistoricalsitesDAO
  implements Serializable
{
  private static final long serialVersionUID = -3518014687841327773L;
  private Integer id;
  private String title;
  private String site;
  private String address;
  private String class_;
  private String honor;
  private String line;
  private String connman;
  private String tel;
  private String pic;
  private String comment;
  private String recorduser;
  private Integer part;
  private String pubtime;

  public HistoricalsitesDAO()
  {
  }

  public HistoricalsitesDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Integer paramInteger, String paramString12)
  {
    this.title = paramString1;
    this.site = paramString2;
    this.address = paramString3;
    this.class_ = paramString4;
    this.honor = paramString5;
    this.line = paramString6;
    this.connman = paramString7;
    this.tel = paramString8;
    this.pic = paramString9;
    this.comment = paramString10;
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

  public String getSite()
  {
    return this.site;
  }

  public void setSite(String paramString)
  {
    this.site = paramString;
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public String getClass_()
  {
    return this.class_;
  }

  public void setClass_(String paramString)
  {
    this.class_ = paramString;
  }

  public String getHonor()
  {
    return this.honor;
  }

  public void setHonor(String paramString)
  {
    this.honor = paramString;
  }

  public String getLine()
  {
    return this.line;
  }

  public void setLine(String paramString)
  {
    this.line = paramString;
  }

  public String getConnman()
  {
    return this.connman;
  }

  public void setConnman(String paramString)
  {
    this.connman = paramString;
  }

  public String getTel()
  {
    return this.tel;
  }

  public void setTel(String paramString)
  {
    this.tel = paramString;
  }

  public String getPic()
  {
    return this.pic;
  }

  public void setPic(String paramString)
  {
    this.pic = paramString;
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
 * Qualified Name:     com.saas.biz.dao.historicalsitesDAO.HistoricalsitesDAO
 * JD-Core Version:    0.6.0
 */