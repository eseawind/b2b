package com.saas.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoginForm extends ActionForm
{
  private String user_name;
  private String passwd;

  public ActionErrors validate(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
    return null;
  }

  public void reset(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
  }

  public String getPasswd()
  {
    return this.passwd;
  }

  public void setPasswd(String paramString)
  {
    this.passwd = paramString;
  }

  public String getUser_name()
  {
    return this.user_name;
  }

  public void setUser_name(String paramString)
  {
    this.user_name = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.form.LoginForm
 * JD-Core Version:    0.6.0
 */