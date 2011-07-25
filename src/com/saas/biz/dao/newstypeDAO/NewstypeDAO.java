package com.saas.biz.dao.newstypeDAO;

import java.io.Serializable;

public class NewstypeDAO
  implements Serializable
{
  private static final long serialVersionUID = 7489784582795540705L;
  private String id;
  private String xType;
  private String remark;

  public String getId()
  {
    return this.id;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public String getXType()
  {
    return this.xType;
  }

  public void setXType(String paramString)
  {
    this.xType = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.newstypeDAO.NewstypeDAO
 * JD-Core Version:    0.6.0
 */