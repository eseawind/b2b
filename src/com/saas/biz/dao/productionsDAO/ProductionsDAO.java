package com.saas.biz.dao.productionsDAO;

import java.io.Serializable;

public class ProductionsDAO
  implements Serializable
{
  private static final long serialVersionUID = 1331862506078656761L;
  private Integer id;
  private String title;
  private String site;
  private String tel;
  private String factory;
  private String pic;
  private String comment;
  private String recorduser;
  private Integer part;
  private String pubtime;

  public ProductionsDAO()
  {
  }

  public ProductionsDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Integer paramInteger, String paramString8)
  {
    this.title = paramString1;
    this.site = paramString2;
    this.tel = paramString3;
    this.factory = paramString4;
    this.pic = paramString5;
    this.comment = paramString6;
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

  public String getTel()
  {
    return this.tel;
  }

  public void setTel(String paramString)
  {
    this.tel = paramString;
  }

  public String getFactory()
  {
    return this.factory;
  }

  public void setFactory(String paramString)
  {
    this.factory = paramString;
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
 * Qualified Name:     com.saas.biz.dao.productionsDAO.ProductionsDAO
 * JD-Core Version:    0.6.0
 */