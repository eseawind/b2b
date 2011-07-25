package com.saas.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class StaffLoginForm extends ActionForm
{
  private String staff_id;
  private String staff_pwd;

  public ActionErrors validate(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
    return null;
  }

  public void reset(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
  }

  public String getStaff_id()
  {
    return this.staff_id;
  }

  public void setStaff_id(String paramString)
  {
    this.staff_id = paramString;
  }

  public String getStaff_pwd()
  {
    return this.staff_pwd;
  }

  public void setStaff_pwd(String paramString)
  {
    this.staff_pwd = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.form.StaffLoginForm
 * JD-Core Version:    0.6.0
 */