package com.ahbay.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UserregForm extends ActionForm
{
  private String www;
  private String month;
  private String phone;
  private String confirmpwd;
  private String day;
  private String pstcode;
  private String Userid;
  private String pwd;
  private String sex;
  private String workunit;
  private String contact;
  private String year;
  private String mphone;
  private String truename;
  private String email;
  private String qq;
  private String post;

  public ActionErrors validate(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
    throw new UnsupportedOperationException("Generated method 'validate(...)' not implemented.");
  }

  public String getWww()
  {
    return this.www;
  }

  public void setWww(String paramString)
  {
    this.www = paramString;
  }

  public String getMonth()
  {
    return this.month;
  }

  public void setMonth(String paramString)
  {
    this.month = paramString;
  }

  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }

  public String getConfirmpwd()
  {
    return this.confirmpwd;
  }

  public void setConfirmpwd(String paramString)
  {
    this.confirmpwd = paramString;
  }

  public String getDay()
  {
    return this.day;
  }

  public void setDay(String paramString)
  {
    this.day = paramString;
  }

  public String getPstcode()
  {
    return this.pstcode;
  }

  public void setPstcode(String paramString)
  {
    this.pstcode = paramString;
  }

  public String getUserid()
  {
    return this.Userid;
  }

  public void setUserid(String paramString)
  {
    this.Userid = paramString;
  }

  public String getPwd()
  {
    return this.pwd;
  }

  public void setPwd(String paramString)
  {
    this.pwd = paramString;
  }

  public String getSex()
  {
    return this.sex;
  }

  public void setSex(String paramString)
  {
    this.sex = paramString;
  }

  public String getWorkunit()
  {
    return this.workunit;
  }

  public void setWorkunit(String paramString)
  {
    this.workunit = paramString;
  }

  public String getContact()
  {
    return this.contact;
  }

  public void setContact(String paramString)
  {
    this.contact = paramString;
  }

  public String getYear()
  {
    return this.year;
  }

  public void setYear(String paramString)
  {
    this.year = paramString;
  }

  public String getMphone()
  {
    return this.mphone;
  }

  public void setMphone(String paramString)
  {
    this.mphone = paramString;
  }

  public String getTruename()
  {
    return this.truename;
  }

  public void setTruename(String paramString)
  {
    this.truename = paramString;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String paramString)
  {
    this.email = paramString;
  }

  public String getQq()
  {
    return this.qq;
  }

  public void setQq(String paramString)
  {
    this.qq = paramString;
  }

  public String getPost()
  {
    return this.post;
  }

  public void setPost(String paramString)
  {
    this.post = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.form.UserregForm
 * JD-Core Version:    0.6.0
 */