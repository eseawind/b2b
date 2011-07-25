package com.saas.biz.rightMgr;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String subsys_code = "B2B";
  private String menu_name;
  private String menu_id;
  private String menu_class = "1";
  private String up_menu_id;
  private ArrayList<MenuInfo> children;
  private String menu_desc;

  public String getMenu_class()
  {
    return this.menu_class;
  }

  public void setMenu_class(String paramString)
  {
    this.menu_class = paramString;
  }

  public String getMenu_id()
  {
    return this.menu_id;
  }

  public void setMenu_id(String paramString)
  {
    this.menu_id = paramString;
  }

  public String getMenu_name()
  {
    return this.menu_name;
  }

  public void setMenu_name(String paramString)
  {
    this.menu_name = paramString;
  }

  public String getSubsys_code()
  {
    return this.subsys_code;
  }

  public void setSubsys_code(String paramString)
  {
    this.subsys_code = paramString;
  }

  public String getUp_menu_id()
  {
    return this.up_menu_id;
  }

  public void setUp_menu_id(String paramString)
  {
    this.up_menu_id = paramString;
  }

  public String getMenu_desc()
  {
    return this.menu_desc;
  }

  public void setMenu_desc(String paramString)
  {
    this.menu_desc = paramString;
  }

  public ArrayList<MenuInfo> getChildren()
  {
    return this.children;
  }

  public void setChildren(ArrayList<MenuInfo> paramArrayList)
  {
    this.children = paramArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.rightMgr.MenuInfo
 * JD-Core Version:    0.6.0
 */