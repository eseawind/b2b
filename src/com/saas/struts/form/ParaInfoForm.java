package com.saas.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ParaInfoForm extends ActionForm
{
  private String cust_id;
  private String user_state;
  private String user_type;
  private String user_class;
  private String depart_code;
  private String passwd_ques;
  private String reg_type;
  private String credit_class;
  private String table_flag;

  public ActionErrors validate(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
    return null;
  }

  public void reset(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
  }

  public String getTable_flag()
  {
    return this.table_flag;
  }

  public void setTable_flag(String paramString)
  {
    this.table_flag = paramString;
  }

  public String getCredit_class()
  {
    return this.credit_class;
  }

  public void setCredit_class(String paramString)
  {
    this.credit_class = paramString;
  }

  public String getCust_id()
  {
    return this.cust_id;
  }

  public void setCust_id(String paramString)
  {
    this.cust_id = paramString;
  }

  public String getDepart_code()
  {
    return this.depart_code;
  }

  public void setDepart_code(String paramString)
  {
    this.depart_code = paramString;
  }

  public String getPasswd_ques()
  {
    return this.passwd_ques;
  }

  public void setPasswd_ques(String paramString)
  {
    this.passwd_ques = paramString;
  }

  public String getReg_type()
  {
    return this.reg_type;
  }

  public void setReg_type(String paramString)
  {
    this.reg_type = paramString;
  }

  public String getUser_class()
  {
    return this.user_class;
  }

  public void setUser_class(String paramString)
  {
    this.user_class = paramString;
  }

  public String getUser_state()
  {
    return this.user_state;
  }

  public void setUser_state(String paramString)
  {
    this.user_state = paramString;
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
 * Qualified Name:     com.saas.struts.form.ParaInfoForm
 * JD-Core Version:    0.6.0
 */