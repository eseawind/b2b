package com.saas.biz.dao.logsDAO;

import java.io.Serializable;

public class LogsDAO
  implements Serializable
{
  private static final long serialVersionUID = 5951668827209806768L;
  private Integer id;
  private String endpage;
  private String querystring;
  private String frompage;
  private String useragent;
  private String ip;
  private String vtime;
  private String username;

  public LogsDAO()
  {
  }

  public LogsDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.endpage = paramString1;
    this.querystring = paramString2;
    this.frompage = paramString3;
    this.useragent = paramString4;
    this.ip = paramString5;
    this.vtime = paramString6;
    this.username = paramString7;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getEndpage()
  {
    return this.endpage;
  }

  public void setEndpage(String paramString)
  {
    this.endpage = paramString;
  }

  public String getQuerystring()
  {
    return this.querystring;
  }

  public void setQuerystring(String paramString)
  {
    this.querystring = paramString;
  }

  public String getFrompage()
  {
    return this.frompage;
  }

  public void setFrompage(String paramString)
  {
    this.frompage = paramString;
  }

  public String getUseragent()
  {
    return this.useragent;
  }

  public void setUseragent(String paramString)
  {
    this.useragent = paramString;
  }

  public String getIp()
  {
    return this.ip;
  }

  public void setIp(String paramString)
  {
    this.ip = paramString;
  }

  public String getVtime()
  {
    return this.vtime;
  }

  public void setVtime(String paramString)
  {
    this.vtime = paramString;
  }

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.logsDAO.LogsDAO
 * JD-Core Version:    0.6.0
 */