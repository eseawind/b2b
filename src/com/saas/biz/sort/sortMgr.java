package com.saas.biz.sort;

import com.saas.biz.dao.productclassDAO.ProductclassExt;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class sortMgr
{
  Logger logger = new Logger(this);
  int type;
  String class_id;
  String htmlElement;
  ArrayList<String> list = new ArrayList();

  public sortMgr()
  {
    this.type = -1;
    this.class_id = "";
    this.htmlElement = "";
  }

  public sortMgr(int paramInt, String paramString1, String paramString2)
  {
    GetAt(paramInt, paramString1, paramString2);
  }

  public boolean GetAt(int paramInt, String paramString1, String paramString2)
  {
    if (this.logger == null)
      return false;
    this.type = paramInt;
    if ((this.class_id == null) || (this.class_id.length() == 0))
      this.class_id = "000000000000000";
    else
      this.class_id = paramString1;
    if ((paramString2 == null) || (paramString2.length() == 0))
      this.htmlElement = "";
    else
      this.htmlElement = paramString2;
    if (this.type > -1)
    {
      this.list.clear();
      return GetItems();
    }
    return false;
  }

  private boolean GetItems()
  {
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", String.valueOf(this.type));
    localProductclassExt.setParam(":VUP_CLASS_ID", this.class_id);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CHILD_CLASS");
    if ((localArrayList == null) || (localArrayList.size() == 0))
      return false;
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(j);
      String str1 = localHashMap.get("class_id").toString();
      String str2 = localHashMap.get("class_level").toString();
      String str3 = localHashMap.get("class_name").toString();
      String str4 = this.htmlElement.replace("{0}", str1);
      str4 = str4.replace("{1}", str2);
      str4 = str4.replace("{2}", str3);
      this.list.add(str4);
    }
    return true;
  }

  public String Queue(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = this.list.size() < paramInt ? this.list.size() : paramInt;
    while (paramInt > 0)
    {
      paramInt--;
      if (paramInt > 0)
        localStringBuilder.append(new StringBuilder().append((String)this.list.get(0)).append(paramString).toString());
      else
        localStringBuilder.append((String)this.list.get(0));
      this.list.remove(0);
    }
    return localStringBuilder.toString();
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.sort.sortMgr
 * JD-Core Version:    0.6.0
 */