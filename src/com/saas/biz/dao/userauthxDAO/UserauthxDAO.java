package com.saas.biz.dao.userauthxDAO;

import java.io.Serializable;

public class UserauthxDAO
  implements Serializable
{
  private static final long serialVersionUID = -3066322103066022599L;
  private Integer id;
  private String user;
  private String programname;
  private Integer authid;
  private String grantbyuser;
  private Integer part;
  private String pubtime;

  public UserauthxDAO()
  {
  }

  public UserauthxDAO(Integer paramInteger1, String paramString1, String paramString2, Integer paramInteger2, String paramString3, Integer paramInteger3, String paramString4)
  {
    this.id = paramInteger1;
    this.user = paramString1;
    this.programname = paramString2;
    this.authid = paramInteger2;
    this.grantbyuser = paramString3;
    this.part = paramInteger3;
    this.pubtime = paramString4;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getUser()
  {
    return this.user;
  }

  public void setUser(String paramString)
  {
    this.user = paramString;
  }

  public String getProgramname()
  {
    return this.programname;
  }

  public void setProgramname(String paramString)
  {
    this.programname = paramString;
  }

  public Integer getAuthid()
  {
    return this.authid;
  }

  public void setAuthid(Integer paramInteger)
  {
    this.authid = paramInteger;
  }

  public String getGrantbyuser()
  {
    return this.grantbyuser;
  }

  public void setGrantbyuser(String paramString)
  {
    this.grantbyuser = paramString;
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

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (paramObject == null)
      return false;
    if (!(paramObject instanceof UserauthxDAO))
      return false;
    UserauthxDAO localUserauthxDAO = (UserauthxDAO)paramObject;
    return ((getId() == localUserauthxDAO.getId()) || ((getId() != null) && (localUserauthxDAO.getId() != null) && (getId().equals(localUserauthxDAO.getId())))) && ((getUser() == localUserauthxDAO.getUser()) || ((getUser() != null) && (localUserauthxDAO.getUser() != null) && (getUser().equals(localUserauthxDAO.getUser())))) && ((getProgramname() == localUserauthxDAO.getProgramname()) || ((getProgramname() != null) && (localUserauthxDAO.getProgramname() != null) && (getProgramname().equals(localUserauthxDAO.getProgramname())))) && ((getAuthid() == localUserauthxDAO.getAuthid()) || ((getAuthid() != null) && (localUserauthxDAO.getAuthid() != null) && (getAuthid().equals(localUserauthxDAO.getAuthid())))) && ((getGrantbyuser() == localUserauthxDAO.getGrantbyuser()) || ((getGrantbyuser() != null) && (localUserauthxDAO.getGrantbyuser() != null) && (getGrantbyuser().equals(localUserauthxDAO.getGrantbyuser())))) && ((getPart() == localUserauthxDAO.getPart()) || ((getPart() != null) && (localUserauthxDAO.getPart() != null) && (getPart().equals(localUserauthxDAO.getPart())))) && ((getPubtime() == localUserauthxDAO.getPubtime()) || ((getPubtime() != null) && (localUserauthxDAO.getPubtime() != null) && (getPubtime().equals(localUserauthxDAO.getPubtime()))));
  }

  public int hashCode()
  {
    int i = 17;
    i = 37 * i + (getId() == null ? 0 : getId().hashCode());
    i = 37 * i + (getUser() == null ? 0 : getUser().hashCode());
    i = 37 * i + (getProgramname() == null ? 0 : getProgramname().hashCode());
    i = 37 * i + (getAuthid() == null ? 0 : getAuthid().hashCode());
    i = 37 * i + (getGrantbyuser() == null ? 0 : getGrantbyuser().hashCode());
    i = 37 * i + (getPart() == null ? 0 : getPart().hashCode());
    i = 37 * i + (getPubtime() == null ? 0 : getPubtime().hashCode());
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.userauthxDAO.UserauthxDAO
 * JD-Core Version:    0.6.0
 */