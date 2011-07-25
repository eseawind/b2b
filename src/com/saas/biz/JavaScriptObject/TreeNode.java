package com.saas.biz.JavaScriptObject;

import java.io.Serializable;
import net.sf.json.JSONArray;

public class TreeNode
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private boolean leaf = true;
  private JSONArray children;

  public JSONArray getChildren()
  {
    return this.children;
  }

  public void setChildren(JSONArray paramJSONArray)
  {
    this.children = paramJSONArray;
  }

  public boolean isLeaf()
  {
    return this.leaf;
  }

  public void setLeaf(boolean paramBoolean)
  {
    this.leaf = paramBoolean;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.JavaScriptObject.TreeNode
 * JD-Core Version:    0.6.0
 */