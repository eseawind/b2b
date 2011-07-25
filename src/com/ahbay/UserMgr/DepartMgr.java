package com.ahbay.UserMgr;

import org.apache.struts.action.Action;

public class DepartMgr extends Action
{
  private String depart_id;
  private String depart_name;
  private String depart_kind_code;
  private String parent_depart_id;
  private int order_no;
  private int depart_level;
  private String remark;
  private String rsvalue1;
  private String rsvalue2;
  private String rsvalue3;
  private String rsvalue4;
  private String update_time;
  private String update_staff_id;
  private String update_depart_id;

  public String getDepart_id()
  {
    return this.depart_id;
  }

  public String getDepart_name()
  {
    return this.depart_name;
  }

  public String getDepart_kind_code()
  {
    return this.depart_kind_code;
  }

  public String getParent_depart_id()
  {
    return this.parent_depart_id;
  }

  public int getOrder_no()
  {
    return this.order_no;
  }

  public int getDepart_level()
  {
    return this.depart_level;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public String getRsvalue1()
  {
    return this.rsvalue1;
  }

  public String getRsvalue2()
  {
    return this.rsvalue2;
  }

  public String getRsvalue3()
  {
    return this.rsvalue3;
  }

  public String getRsvalue4()
  {
    return this.rsvalue4;
  }

  public String getUpdate_time()
  {
    return this.update_time;
  }

  public String getUpdate_staff_id()
  {
    return this.update_staff_id;
  }

  public String getUpdate_depart_id()
  {
    return this.update_depart_id;
  }

  public void setDepart_id(String paramString)
  {
    this.depart_id = paramString;
  }

  public void setDepart_name(String paramString)
  {
    this.depart_name = paramString;
  }

  public void setDepart_kind_code(String paramString)
  {
    this.depart_kind_code = paramString;
  }

  public void setParent_depart_id(String paramString)
  {
    this.parent_depart_id = paramString;
  }

  public void setOrder_no(int paramInt)
  {
    this.order_no = paramInt;
  }

  public void setDepart_level(int paramInt)
  {
    this.depart_level = paramInt;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public void setRsvalue1(String paramString)
  {
    this.rsvalue1 = paramString;
  }

  public void setRsvalue2(String paramString)
  {
    this.rsvalue2 = paramString;
  }

  public void setRsvalue3(String paramString)
  {
    this.rsvalue3 = paramString;
  }

  public void setRsvalue4(String paramString)
  {
    this.rsvalue4 = paramString;
  }

  public void setUpdate_time(String paramString)
  {
    this.update_time = paramString;
  }

  public void setUpdate_staff_id(String paramString)
  {
    this.update_staff_id = paramString;
  }

  public void setUpdate_depart_id(String paramString)
  {
    this.update_depart_id = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.UserMgr.DepartMgr
 * JD-Core Version:    0.6.0
 */