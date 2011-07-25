package com.saas.biz.formStateMgr;

import java.io.Serializable;
import java.util.ArrayList;

public class FormAreaEnity
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String area_id;
  private String area_name;
  private ArrayList<FormFieldEntity> field;

  public String getArea_id()
  {
    return this.area_id;
  }

  public void setArea_id(String paramString)
  {
    this.area_id = paramString;
  }

  public String getArea_name()
  {
    return this.area_name;
  }

  public void setArea_name(String paramString)
  {
    this.area_name = paramString;
  }

  public ArrayList<FormFieldEntity> getField()
  {
    return this.field;
  }

  public void setField(ArrayList<FormFieldEntity> paramArrayList)
  {
    this.field = paramArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.formStateMgr.FormAreaEnity
 * JD-Core Version:    0.6.0
 */