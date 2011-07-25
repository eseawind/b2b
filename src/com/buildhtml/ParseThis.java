package com.buildhtml;

import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import com.saas.sys.tag.Tagbase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.StrReplace;

public class ParseThis
{
  public Logger log = new Logger(this);
  public String cache_file_path = "";

  public void setCacheFile(String paramString)
  {
    this.cache_file_path = paramString;
  }

  public String buildthis(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    Tagbase localTagbase = new Tagbase();
    ArrayList localArrayList = new ArrayList();
    localTagbase.setNameSpace("ecms", "this", "{", "/}");
    localTagbase.setInstr(paramString);
    localArrayList = localTagbase.getSpecTagList();
    if (localArrayList == null)
      return paramString;
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      if (localHashMap.get("tagname") != null)
        str1 = localHashMap.get("tagname").toString();
      if (localHashMap.get("tagstr") != null)
        str2 = localHashMap.get("tagstr").toString();
      if (localHashMap.get("tagstring") != null)
        str3 = localHashMap.get("tagstring").toString();
      str4 = localTagbase.getAttrValue(str2, "name");
      if (paramHashMap.get(str4) != null)
        paramString = StrReplace.replace(paramString, str3, paramHashMap.get(str4).toString());
      else
        paramString = StrReplace.replace(paramString, str3, "字段不存在");
    }
    return paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.ParseThis
 * JD-Core Version:    0.6.0
 */