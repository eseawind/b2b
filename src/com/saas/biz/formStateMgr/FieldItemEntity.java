package com.saas.biz.formStateMgr;

import java.io.Serializable;
import java.util.ArrayList;

public class FieldItemEntity
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String field_value;
  private String item_id;
  private String item_value;
  private ArrayList valueList;

  public String getField_value()
  {
    return this.field_value;
  }

  public void setField_value(String paramString)
  {
    this.field_value = paramString;
  }

  public String getItem_id()
  {
    return this.item_id;
  }

  public void setItem_id(String paramString)
  {
    this.item_id = paramString;
  }

  public String getItem_value()
  {
    return this.item_value;
  }

  public void setItem_value(String paramString)
  {
    this.item_value = paramString;
  }

  public ArrayList getValueList()
  {
    return this.valueList;
  }

  public void setValueList(ArrayList paramArrayList)
  {
    this.valueList = paramArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.formStateMgr.FieldItemEntity
 * JD-Core Version:    0.6.0
 */