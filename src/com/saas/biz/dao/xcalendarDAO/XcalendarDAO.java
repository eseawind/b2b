package com.saas.biz.dao.xcalendarDAO;

import java.io.Serializable;

public class XcalendarDAO
  implements Serializable
{
  private static final long serialVersionUID = 5735090055852292671L;
  private Integer id;
  private String title;
  private String content;
  private String begtime;
  private String endtime;
  private Integer checked;
  private String user;
  private String recorduser;
  private String part;
  private String pubtime;

  public XcalendarDAO()
  {
  }

  public XcalendarDAO(String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.title = paramString1;
    this.content = paramString2;
    this.begtime = paramString3;
    this.endtime = paramString4;
    this.checked = paramInteger;
    this.user = paramString5;
    this.recorduser = paramString6;
    this.part = paramString7;
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

  public String getContent()
  {
    return this.content;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public String getBegtime()
  {
    return this.begtime;
  }

  public void setBegtime(String paramString)
  {
    this.begtime = paramString;
  }

  public String getEndtime()
  {
    return this.endtime;
  }

  public void setEndtime(String paramString)
  {
    this.endtime = paramString;
  }

  public Integer getChecked()
  {
    return this.checked;
  }

  public void setChecked(Integer paramInteger)
  {
    this.checked = paramInteger;
  }

  public String getUser()
  {
    return this.user;
  }

  public void setUser(String paramString)
  {
    this.user = paramString;
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
 * Qualified Name:     com.saas.biz.dao.xcalendarDAO.XcalendarDAO
 * JD-Core Version:    0.6.0
 */