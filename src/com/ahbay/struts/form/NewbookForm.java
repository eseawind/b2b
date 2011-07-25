package com.ahbay.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class NewbookForm extends ActionForm
{
  private String phone;
  private String corpname;
  private String job;
  private String address;
  private String content;
  private String myname;
  private String email;
  private String zip;
  private String sfcode;

  public ActionErrors validate(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
    throw new UnsupportedOperationException("Generated method 'validate(...)' not implemented.");
  }

  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }

  public String getCorpname()
  {
    return this.corpname;
  }

  public void setCorpname(String paramString)
  {
    this.corpname = paramString;
  }

  public String getJob()
  {
    return this.job;
  }

  public void setJob(String paramString)
  {
    this.job = paramString;
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String paramString)
  {
    this.address = paramString;
  }

  public String getContent()
  {
    return this.content;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public String getMyname()
  {
    return this.myname;
  }

  public void setMyname(String paramString)
  {
    this.myname = paramString;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String paramString)
  {
    this.email = paramString;
  }

  public String getZip()
  {
    return this.zip;
  }

  public void setZip(String paramString)
  {
    this.zip = paramString;
  }

  public String getSfcode()
  {
    return this.sfcode;
  }

  public void setSfcode(String paramString)
  {
    this.sfcode = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.form.NewbookForm
 * JD-Core Version:    0.6.0
 */