package com.saas.biz.templateFormMgr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class TemplateOject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  String area_name;
  String area_id;
  HashMap<HashMap, ArrayList> map;

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

  public HashMap<HashMap, ArrayList> getMap()
  {
    return this.map;
  }

  public void setMap(HashMap<HashMap, ArrayList> paramHashMap)
  {
    this.map = paramHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.templateFormMgr.TemplateOject
 * JD-Core Version:    0.6.0
 */