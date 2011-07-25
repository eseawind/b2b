package com.saas.biz.dao.ondutyDAO;

import java.io.Serializable;

public class OndutyDAO
  implements Serializable
{
  private static final long serialVersionUID = -1740654967943528325L;
  private Integer id;
  private String zt;
  private String reason;
  private String user;
  private String part;
  private String pubtime;
  private Integer checked;

  public OndutyDAO()
  {
  }

  public OndutyDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Integer paramInteger)
  {
    this.zt = paramString1;
    this.reason = paramString2;
    this.user = paramString3;
    this.part = paramString4;
    this.pubtime = paramString5;
    this.checked = paramInteger;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getZt()
  {
    return this.zt;
  }

  public void setZt(String paramString)
  {
    this.zt = paramString;
  }

  public String getReason()
  {
    return this.reason;
  }

  public void setReason(String paramString)
  {
    this.reason = paramString;
  }

  public String getUser()
  {
    return this.user;
  }

  public void setUser(String paramString)
  {
    this.user = paramString;
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

  public Integer getChecked()
  {
    return this.checked;
  }

  public void setChecked(Integer paramInteger)
  {
    this.checked = paramInteger;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.ondutyDAO.OndutyDAO
 * JD-Core Version:    0.6.0
 */