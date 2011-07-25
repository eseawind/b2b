package com.saas.biz.dao.partsDAO;

import java.io.Serializable;

public class PartsDAO
  implements Serializable
{
  private static final long serialVersionUID = -7372167926589927516L;
  private Integer id;
  private String partname;
  private String partcomments;
  private Integer parentpart;
  private String partwholename;
  private String partabstract;
  private String partdetail;
  private String user;
  private String part;
  private String pubtime;
  private Integer checked;

  public PartsDAO()
  {
  }

  public PartsDAO(String paramString1, String paramString2, Integer paramInteger1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, Integer paramInteger2)
  {
    this.partname = paramString1;
    this.partcomments = paramString2;
    this.parentpart = paramInteger1;
    this.partwholename = paramString3;
    this.partabstract = paramString4;
    this.partdetail = paramString5;
    this.user = paramString6;
    this.part = paramString7;
    this.pubtime = paramString8;
    this.checked = paramInteger2;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getPartname()
  {
    return this.partname;
  }

  public void setPartname(String paramString)
  {
    this.partname = paramString;
  }

  public String getPartcomments()
  {
    return this.partcomments;
  }

  public void setPartcomments(String paramString)
  {
    this.partcomments = paramString;
  }

  public Integer getParentpart()
  {
    return this.parentpart;
  }

  public void setParentpart(Integer paramInteger)
  {
    this.parentpart = paramInteger;
  }

  public String getPartwholename()
  {
    return this.partwholename;
  }

  public void setPartwholename(String paramString)
  {
    this.partwholename = paramString;
  }

  public String getPartabstract()
  {
    return this.partabstract;
  }

  public void setPartabstract(String paramString)
  {
    this.partabstract = paramString;
  }

  public String getPartdetail()
  {
    return this.partdetail;
  }

  public void setPartdetail(String paramString)
  {
    this.partdetail = paramString;
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
 * Qualified Name:     com.saas.biz.dao.partsDAO.PartsDAO
 * JD-Core Version:    0.6.0
 */