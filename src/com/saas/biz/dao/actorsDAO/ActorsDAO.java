package com.saas.biz.dao.actorsDAO;

public class ActorsDAO
{
  private Integer id;
  private String actorname;
  private Integer actorid;
  private String modelname;
  private String programname;
  private Integer cid;

  public ActorsDAO()
  {
  }

  public ActorsDAO(String paramString1, Integer paramInteger1, String paramString2, String paramString3, Integer paramInteger2)
  {
    this.actorname = paramString1;
    this.actorid = paramInteger1;
    this.modelname = paramString2;
    this.programname = paramString3;
    this.cid = paramInteger2;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getActorname()
  {
    return this.actorname;
  }

  public void setActorname(String paramString)
  {
    this.actorname = paramString;
  }

  public Integer getActorid()
  {
    return this.actorid;
  }

  public void setActorid(Integer paramInteger)
  {
    this.actorid = paramInteger;
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
 * Qualified Name:     com.saas.biz.dao.actorsDAO.ActorsDAO
 * JD-Core Version:    0.6.0
 */