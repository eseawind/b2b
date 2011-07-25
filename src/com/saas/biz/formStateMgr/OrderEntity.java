package com.saas.biz.formStateMgr;

import java.io.Serializable;

public class OrderEntity
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String form_name;
  private String form_id;
  private FormAreaEnity areaEntity;

  public FormAreaEnity getAreaEntity()
  {
    return this.areaEntity;
  }

  public void setAreaEntity(FormAreaEnity paramFormAreaEnity)
  {
    this.areaEntity = paramFormAreaEnity;
  }

  public String getForm_id()
  {
    return this.form_id;
  }

  public void setForm_id(String paramString)
  {
    this.form_id = paramString;
  }

  public String getForm_name()
  {
    return this.form_name;
  }

  public void setForm_name(String paramString)
  {
    this.form_name = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.formStateMgr.OrderEntity
 * JD-Core Version:    0.6.0
 */