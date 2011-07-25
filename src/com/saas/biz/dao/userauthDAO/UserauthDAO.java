package com.saas.biz.dao.userauthDAO;

import java.io.Serializable;

public class UserauthDAO
  implements Serializable
{
  private static final long serialVersionUID = 6178337848525143198L;
  private Integer id;
  private String user;
  private String programname;
  private Integer authid;
  private String grantbyuser;
  private Integer part;
  private String pubtime;
  private Integer cid;
  private String modelname;

  public UserauthDAO()
  {
  }

  public UserauthDAO(String paramString1, String paramString2, Integer paramInteger1, String paramString3, Integer paramInteger2, String paramString4, Integer paramInteger3, String paramString5)
  {
    this.user = paramString1;
    this.programname = paramString2;
    this.authid = paramInteger1;
    this.grantbyuser = paramString3;
    this.part = paramInteger2;
    this.pubtime = paramString4;
    this.cid = paramInteger3;
    this.modelname = paramString5;
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

  public Integer getCid()
  {
    return this.cid;
  }

  public void setCid(Integer paramInteger)
  {
    this.cid = paramInteger;
  }

  public String getModelname()
  {
    return this.modelname;
  }

  public void setModelname(String paramString)
  {
    this.modelname = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.userauthDAO.UserauthDAO
 * JD-Core Version:    0.6.0
 */