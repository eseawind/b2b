package com.saas.biz.dao.userclassDAO;

public class UserclassDAO
{
  private String user_type;
  private String class_name;
  private String class_code;
  private String enable_tag;
  private String remark;
  private String update_staff_id;
  private String update_depart_id;
  private String update_time;

  public void UserclassDAO()
  {
  }

  public String getClass_code()
  {
    return this.class_code;
  }

  public void setClass_code(String paramString)
  {
    this.class_code = paramString;
  }

  public String getClass_name()
  {
    return this.class_name;
  }

  public void setClass_name(String paramString)
  {
    this.class_name = paramString;
  }

  public String getEnable_tag()
  {
    return this.enable_tag;
  }

  public void setEnable_tag(String paramString)
  {
    this.enable_tag = paramString;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public String getUpdate_depart_id()
  {
    return this.update_depart_id;
  }

  public void setUpdate_depart_id(String paramString)
  {
    this.update_depart_id = paramString;
  }

  public String getUpdate_staff_id()
  {
    return this.update_staff_id;
  }

  public void setUpdate_staff_id(String paramString)
  {
    this.update_staff_id = paramString;
  }

  public String getUpdate_time()
  {
    return this.update_time;
  }

  public void setUpdate_time(String paramString)
  {
    this.update_time = paramString;
  }

  public String getUser_type()
  {
    return this.user_type;
  }

  public void setUser_type(String paramString)
  {
    this.user_type = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.dao.userclassDAO.UserclassDAO
 * JD-Core Version:    0.6.0
 */