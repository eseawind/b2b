package com.saas.biz.JavaScriptObject;

import java.io.Serializable;
import net.sf.json.JSONArray;

public class TreeObject
  implements Serializable
{
  private static final long serialVersionUID = 8545237906978957680L;
  private String text;
  private String id;
  private String iconCls = "Tree-Img";
  private boolean leaf;
  private JSONArray children;

  public JSONArray getChildren()
  {
    return this.children;
  }

  public void setChildren(JSONArray paramJSONArray)
  {
    this.children = paramJSONArray;
  }

  public String getId()
  {
    return this.id;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public boolean isLeaf()
  {
    return this.leaf;
  }

  public void setLeaf(boolean paramBoolean)
  {
    this.leaf = paramBoolean;
  }

  public String getText()
  {
    return this.text;
  }

  public void setText(String paramString)
  {
    this.text = paramString;
  }

  public String getIconCls()
  {
    return this.iconCls;
  }

  public void setIconCls(String paramString)
  {
    this.iconCls = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.JavaScriptObject.TreeObject
 * JD-Core Version:    0.6.0
 */