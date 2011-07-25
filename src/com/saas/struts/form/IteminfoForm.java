package com.saas.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class IteminfoForm extends ActionForm
{
  private String lmjb;
  private FormFile modelfile;
  private String modelfilepath;
  private String displayrage;
  private String lmmc;
  private String showfirst;

  public String getLmjb()
  {
    return this.lmjb;
  }

  public void setLmjb(String paramString)
  {
    this.lmjb = paramString;
  }

  public FormFile getModelfile()
  {
    return this.modelfile;
  }

  public void setModelfile(FormFile paramFormFile)
  {
    this.modelfile = paramFormFile;
  }

  public String getModelfilepath()
  {
    return this.modelfilepath;
  }

  public void setModelfilepath(String paramString)
  {
    this.modelfilepath = paramString;
  }

  public String getDisplayrage()
  {
    return this.displayrage;
  }

  public void setDisplayrage(String paramString)
  {
    this.displayrage = paramString;
  }

  public String getLmmc()
  {
    return this.lmmc;
  }

  public void setLmmc(String paramString)
  {
    this.lmmc = paramString;
  }

  public String getShowfirst()
  {
    return this.showfirst;
  }

  public void setShowfirst(String paramString)
  {
    this.showfirst = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.form.IteminfoForm
 * JD-Core Version:    0.6.0
 */