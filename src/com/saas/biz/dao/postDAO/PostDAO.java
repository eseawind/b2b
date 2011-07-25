package com.saas.biz.dao.postDAO;

import java.io.Serializable;

public class PostDAO
  implements Serializable
{
  private static final long serialVersionUID = -425616281276899696L;
  private Integer id;
  private String dq;
  private String dm;
  private String yb;
  private String qh;

  public PostDAO()
  {
  }

  public PostDAO(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.dq = paramString1;
    this.dm = paramString2;
    this.yb = paramString3;
    this.qh = paramString4;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getDq()
  {
    return this.dq;
  }

  public void setDq(String paramString)
  {
    this.dq = paramString;
  }

  public String getDm()
  {
    return this.dm;
  }

  public void setDm(String paramString)
  {
    this.dm = paramString;
  }

  public String getYb()
  {
    return this.yb;
  }

  public void setYb(String paramString)
  {
    this.yb = paramString;
  }

  public String getQh()
  {
    return this.qh;
  }

  public void setQh(String paramString)
  {
    this.qh = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.postDAO.PostDAO
 * JD-Core Version:    0.6.0
 */