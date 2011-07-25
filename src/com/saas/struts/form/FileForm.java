package com.saas.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class FileForm extends ActionForm
{
  private String attach_root_id;
  private FormFile files;

  public String getAttach_root_id()
  {
    return this.attach_root_id;
  }

  public void setAttach_root_id(String paramString)
  {
    this.attach_root_id = paramString;
  }

  public FormFile getFiles()
  {
    return this.files;
  }

  public void setFiles(FormFile paramFormFile)
  {
    this.files = paramFormFile;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.form.FileForm
 * JD-Core Version:    0.6.0
 */