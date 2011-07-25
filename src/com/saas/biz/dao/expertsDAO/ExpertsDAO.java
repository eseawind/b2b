package com.saas.biz.dao.expertsDAO;

public class ExpertsDAO
{
  private Integer id;
  private String name;
  private String grad;
  private String age;
  private String field;
  private String unit;
  private Integer sex;
  private String address;
  private String tel;
  private String comment;
  private String recorduser;
  private Integer part;
  private String pubtime;

  public ExpertsDAO()
  {
  }

  public ExpertsDAO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Integer paramInteger1, String paramString6, String paramString7, String paramString8, String paramString9, Integer paramInteger2, String paramString10)
  {
    this.name = paramString1;
    this.grad = paramString2;
    this.age = paramString3;
    this.field = paramString4;
    this.unit = paramString5;
    this.sex = paramInteger1;
    this.address = paramString6;
    this.tel = paramString7;
    this.comment = paramString8;
    this.recorduser = paramString9;
    this.part = paramInteger2;
    this.pubtime = paramString10;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public String getGrad()
  {
    return this.grad;
  }

  public void setGrad(String paramString)
  {
    this.grad = paramString;
  }

  public String getAge()
  {
    return this.age;
  }

  public void setAge(String paramString)
  {
    this.age = paramString;
  }

  public String getField()
  {
    return this.field;
  }

  public void setField(String paramString)
  {
    this.field = paramString;
  }

  public String getUnit()
  {
    return this.unit;
  }

  public void setUnit(String paramString)
  {
    this.unit = paramString;
  }

  public Integer getSex()
  {
    return this.sex;
  }

  public void setSex(Integer paramInteger)
  {
    this.sex = paramInteger;
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public String getTel()
  {
    return this.tel;
  }

  public void setTel(String paramString)
  {
    this.tel = paramString;
  }

  public String getComment()
  {
    return this.comment;
  }

  public void setComment(String paramString)
  {
    this.comment = paramString;
  }

  public String getRecorduser()
  {
    return this.recorduser;
  }

  public void setRecorduser(String paramString)
  {
    this.recorduser = paramString;
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
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.expertsDAO.ExpertsDAO
 * JD-Core Version:    0.6.0
 */