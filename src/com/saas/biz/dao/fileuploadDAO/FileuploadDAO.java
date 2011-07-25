package com.saas.biz.dao.fileuploadDAO;

import java.io.Serializable;

public class FileuploadDAO
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private Integer userid;
  private String dir;
  private Integer custid;
  private String filename;
  private String filepath;
  private String hostip;
  private Integer filenum;
  private String filetype;
  private String pubdate;

  public FileuploadDAO()
  {
  }

  public FileuploadDAO(Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, String paramString3, String paramString4, Integer paramInteger3, String paramString5, String paramString6)
  {
    this.userid = paramInteger1;
    this.dir = paramString1;
    this.custid = paramInteger2;
    this.filename = paramString2;
    this.filepath = paramString3;
    this.hostip = paramString4;
    this.filenum = paramInteger3;
    this.filetype = paramString5;
    this.pubdate = paramString6;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public Integer getUserid()
  {
    return this.userid;
  }

  public void setUserid(Integer paramInteger)
  {
    this.userid = paramInteger;
  }

  public String getDir()
  {
    return this.dir;
  }

  public void setDir(String paramString)
  {
    this.dir = paramString;
  }

  public Integer getCustid()
  {
    return this.custid;
  }

  public void setCustid(Integer paramInteger)
  {
    this.custid = paramInteger;
  }

  public String getFilename()
  {
    return this.filename;
  }

  public void setFilename(String paramString)
  {
    this.filename = paramString;
  }

  public String getFilepath()
  {
    return this.filepath;
  }

  public void setFilepath(String paramString)
  {
    this.filepath = paramString;
  }

  public String getHostip()
  {
    return this.hostip;
  }

  public void setHostip(String paramString)
  {
    this.hostip = paramString;
  }

  public Integer getFilenum()
  {
    return this.filenum;
  }

  public void setFilenum(Integer paramInteger)
  {
    this.filenum = paramInteger;
  }

  public String getFiletype()
  {
    return this.filetype;
  }

  public void setFiletype(String paramString)
  {
    this.filetype = paramString;
  }

  public String getPubdate()
  {
    return this.pubdate;
  }

  public void setPubdate(String paramString)
  {
    this.pubdate = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.fileuploadDAO.FileuploadDAO
 * JD-Core Version:    0.6.0
 */