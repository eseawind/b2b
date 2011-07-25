package com.saas.biz.dao.reportcommentsDAO;

import java.io.Serializable;

public class ReportcommentsDAO
  implements Serializable
{
  private static final long serialVersionUID = 4885130058437210168L;
  private Integer id;
  private String reportid;
  private String comments;
  private String user;
  private String part;
  private String pubtime;

  public ReportcommentsDAO()
  {
  }

  public ReportcommentsDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.reportid = paramString1;
    this.comments = paramString2;
    this.user = paramString3;
    this.part = paramString4;
    this.pubtime = paramString5;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getComments()
  {
    return this.comments;
  }

  public void setComments(String paramString)
  {
    this.comments = paramString;
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

  public String getReportid()
  {
    return this.reportid;
  }

  public void setReportid(String paramString)
  {
    this.reportid = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.reportcommentsDAO.ReportcommentsDAO
 * JD-Core Version:    0.6.0
 */