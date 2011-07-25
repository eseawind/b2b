package com.saas.biz.dao.xmodelDAO;

import java.io.Serializable;

public class XmodelDAO
  implements Serializable
{
  private static final long serialVersionUID = -1254801740456336913L;
  private Integer id;
  private String modelname;
  private String programname;
  private String xdesc;
  private Integer cid;

  public XmodelDAO()
  {
  }

  public XmodelDAO(String paramString1, String paramString2, String paramString3, Integer paramInteger)
  {
    this.modelname = paramString1;
    this.programname = paramString2;
    this.xdesc = paramString3;
    this.cid = paramInteger;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getModelname()
  {
    return this.modelname;
  }

  public void setModelname(String paramString)
  {
    this.modelname = paramString;
  }

  public String getProgramname()
  {
    return this.programname;
  }

  public void setProgramname(String paramString)
  {
    this.programname = paramString;
  }

  public String getXdesc()
  {
    return this.xdesc;
  }

  public void setXdesc(String paramString)
  {
    this.xdesc = paramString;
  }

  public Integer getCid()
  {
    return this.cid;
  }

  public void setCid(Integer paramInteger)
  {
    this.cid = paramInteger;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.xmodelDAO.XmodelDAO
 * JD-Core Version:    0.6.0
 */