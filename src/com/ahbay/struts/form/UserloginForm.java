package com.ahbay.struts.form;

import org.apache.struts.action.ActionForm;

public class UserloginForm extends ActionForm
{
  private String password;
  private String uid;

  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String paramString)
  {
    this.password = paramString;
  }

  public String getUid()
  {
    return this.uid;
  }

  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.form.UserloginForm
 * JD-Core Version:    0.6.0
 */