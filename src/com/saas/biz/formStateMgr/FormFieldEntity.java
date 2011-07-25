package com.saas.biz.formStateMgr;

import java.io.Serializable;
import java.util.ArrayList;

public class FormFieldEntity
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String field_id;
  private String field_name;
  private String field_type;
  private String filed_value;
  private ArrayList list;

  public String getField_id()
  {
    return this.field_id;
  }

  public void setField_id(String paramString)
  {
    this.field_id = paramString;
  }

  public String getField_name()
  {
    return this.field_name;
  }

  public void setField_name(String paramString)
  {
    this.field_name = paramString;
  }

  public String getField_type()
  {
    return this.field_type;
  }

  public void setField_type(String paramString)
  {
    this.field_type = paramString;
  }

  public String getFiled_value()
  {
    return this.filed_value;
  }

  public void setFiled_value(String paramString)
  {
    this.filed_value = paramString;
  }

  public ArrayList getList()
  {
    return this.list;
  }

  public void setList(ArrayList paramArrayList)
  {
    this.list = paramArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.formStateMgr.FormFieldEntity
 * JD-Core Version:    0.6.0
 */