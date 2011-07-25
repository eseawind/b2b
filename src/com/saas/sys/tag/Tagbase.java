package com.saas.sys.tag;

import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.StringUtil;

public class Tagbase
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  private String namespace = "ecms";
  private String tagname = "base";
  private String instr;
  private String start_word = "{";
  private String end_word = "/}";

  public void setNameSpace(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.namespace = paramString1;
    this.tagname = paramString2;
    this.start_word = paramString3;
    this.end_word = paramString4;
  }

  public void setInstr(String paramString)
  {
    this.instr = paramString;
  }

  public ArrayList getNoneLoopList()
  {
    String str1 = this.instr;
    if (str1 == null)
      return null;
    if (str1.equals(""))
      return null;
    StringUtil localStringUtil = new StringUtil();
    str1 = StringUtil.replace(str1, "\n", "");
    String str2 = this.start_word;
    String str3 = this.end_word;
    String str4 = this.namespace;
    String str5 = str4 + ":" + this.tagname;
    String str6 = "";
    String str7 = "";
    String str8 = str3;
    str1 = str1.toLowerCase().trim();
    ArrayList localArrayList = new ArrayList();
    try
    {
      String[] arrayOfString = str1.split("\\" + str2);
      for (int i = 0; i < arrayOfString.length; i++)
      {
        if ((arrayOfString[i].length() <= 0) || (arrayOfString[i].indexOf(str4 + ":" + this.tagname) < 0) || (arrayOfString[i].indexOf(str3) < 0) || (arrayOfString[i].indexOf(this.tagname) < 0))
          continue;
        str6 = arrayOfString[i].substring(arrayOfString[i].indexOf(str5) + str5.length() + 1, arrayOfString[i].indexOf(str3)).trim();
        String str9 = str2 + arrayOfString[i].substring(arrayOfString[i].indexOf(str4), arrayOfString[i].indexOf(str3) + 2).trim();
        str6 = str6.substring(0, str6.length()).trim();
        HashMap localHashMap = new HashMap();
        localHashMap.put("tagname", this.tagname);
        localHashMap.put("tagstr", str6);
        localHashMap.put("tagstring", str9);
        localArrayList.add(localHashMap);
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException + "『" + str1 + "』");
    }
    return localArrayList;
  }

  public ArrayList getAttrList(String paramString)
  {
    if (paramString == null)
      return null;
    if (paramString.equals(""))
      return null;
    String str1 = "";
    String str2 = "";
    paramString = paramString.replaceAll("\"", "").trim();
    paramString = paramString.replaceAll("'", "").trim() + " ";
    String[] arrayOfString = paramString.split("=");
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (arrayOfString != null)
      {
        HashMap localHashMap1;
        if (arrayOfString.length == 1)
        {
          str1 = arrayOfString[0].trim();
          str2 = "";
          localHashMap1 = new HashMap();
          localHashMap1.put("attrname", str1);
          localHashMap1.put("attrvalue", str2);
          localArrayList.add(localHashMap1);
        }
        else if (arrayOfString.length == 2)
        {
          str1 = arrayOfString[0].trim();
          str2 = arrayOfString[1].trim();
          localHashMap1 = new HashMap();
          localHashMap1.put("attrname", str1);
          localHashMap1.put("attrvalue", str2);
          localArrayList.add(localHashMap1);
        }
        else
        {
          for (int i = 1; i < arrayOfString.length; i++)
          {
            if (arrayOfString[(i - 1)].trim().indexOf(" ") < 0)
              str1 = arrayOfString[(i - 1)].trim();
            else
              str1 = arrayOfString[(i - 1)].trim().substring(arrayOfString[(i - 1)].trim().indexOf(" "), arrayOfString[(i - 1)].trim().length()).trim();
            arrayOfString[i] = (arrayOfString[i] + " ");
            if ((arrayOfString[i].trim().indexOf(" ") < 0) && (i != arrayOfString.length - 1))
              str2 = "";
            else if ((arrayOfString[i].trim().indexOf(" ") < 0) && (i == arrayOfString.length - 1))
              str2 = arrayOfString[i].trim();
            else
              str2 = arrayOfString[i].trim().substring(0, arrayOfString[i].trim().indexOf(" ")).trim();
            HashMap localHashMap2 = new HashMap();
            localHashMap2.put("attrname", str1);
            localHashMap2.put("attrvalue", str2);
            localArrayList.add(localHashMap2);
          }
        }
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException + "『" + paramString + "』");
    }
    return localArrayList;
  }

  public String getAttrValue(String paramString1, String paramString2)
  {
    ArrayList localArrayList = getAttrList(paramString1);
    paramString2 = paramString2.replaceAll(" ", "").trim();
    String str1 = "";
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      if (localHashMap.get("attrname") != null)
        str2 = localHashMap.get("attrname").toString();
      if (str2.equals(paramString2))
      {
        str1 = localHashMap.get("attrvalue").toString();
        break;
      }
    }
    return str1;
  }

  public ArrayList getSpecTagList(String paramString)
  {
    this.log.LOG_INFO("tagstrs= " + paramString);
    ArrayList localArrayList1 = getNoneLoopList();
    this.log.LOG_INFO("AllList= " + localArrayList1);
    paramString = paramString.replaceAll(" ", "").trim();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      if (localHashMap.get("tagname") != null)
        str1 = localHashMap.get("tagname").toString();
      if (str1.equals(paramString))
        localArrayList2.add(localHashMap);
    }
    return localArrayList2;
  }

  public ArrayList getSpecTagList()
  {
    ArrayList localArrayList1 = getNoneLoopList();
    String str1 = this.tagname.replaceAll(" ", "").trim();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      String str3 = "";
      if (localHashMap.get("tagname") != null)
        str2 = localHashMap.get("tagname").toString();
      if (str2.equals(str1))
        localArrayList2.add(localHashMap);
    }
    if (localArrayList2 != null)
      return localArrayList2;
    return null;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.tag.Tagbase
 * JD-Core Version:    0.6.0
 */