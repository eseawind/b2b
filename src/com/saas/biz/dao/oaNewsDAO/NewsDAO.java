package com.saas.biz.dao.oaNewsDAO;

import java.io.Serializable;

public class NewsDAO
  implements Serializable
{
  private static final long serialVersionUID = -2993461286372133967L;
  private Integer id;
  private String xtype;
  private String title;
  private String content;
  private String user;
  private String part;
  private String pubtime;
  private String checked;
  private String xvisible;
  private String zhiding;

  public NewsDAO()
  {
  }

  public NewsDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.xtype = paramString1;
    this.title = paramString2;
    this.content = paramString3;
    this.user = paramString4;
    this.part = paramString5;
    this.xvisible = paramString6;
    this.zhiding = "0";
    this.checked = "0";
  }

  public String getChecked()
  {
    return this.checked;
  }

  public void setChecked(String paramString)
  {
    this.checked = paramString;
  }

  public String getContent()
  {
    return this.content;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
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

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public String getUser()
  {
    return this.user;
  }

  public void setUser(String paramString)
  {
    this.user = paramString;
  }

  public String getXtype()
  {
    return this.xtype;
  }

  public void setXtype(String paramString)
  {
    this.xtype = paramString;
  }

  public String getXvisible()
  {
    return this.xvisible;
  }

  public void setXvisible(String paramString)
  {
    this.xvisible = paramString;
  }

  public String getZhiding()
  {
    return this.zhiding;
  }

  public void setZhiding(String paramString)
  {
    this.zhiding = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.oaNewsDAO.NewsDAO
 * JD-Core Version:    0.6.0
 */