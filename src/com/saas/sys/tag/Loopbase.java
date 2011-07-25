package com.saas.sys.tag;

import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.StringUtil;

public class Loopbase
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  private String namespace = "ecms";
  private String tagname = "channel";
  private String instr;
  private String start_word_start = "{";
  private String start_word_end = "}";
  private String end_word_start = "{/";
  private String end_word_end = "}";

  public void setNameSpace(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.namespace = paramString1;
    this.tagname = paramString2;
    this.start_word_start = paramString3;
    this.start_word_end = paramString4;
    this.end_word_start = paramString5;
    this.end_word_end = paramString6;
  }

  public void setInstr(String paramString)
  {
    this.instr = paramString;
  }

  public ArrayList getLoopList()
  {
    String str1 = this.instr;
    if (str1 == null)
      return null;
    if (str1.equals(""))
      return null;
    StringUtil localStringUtil = new StringUtil();
    str1 = StringUtil.replace(str1, "\n", "");
    String str2 = this.start_word_start;
    String str3 = this.end_word_start;
    String str4 = this.end_word_end;
    String str5 = this.namespace;
    String str6 = this.namespace + ":" + this.tagname;
    String str7 = "";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String[] arrayOfString = str1.split("\\" + str3 + str6);
    try
    {
      for (int i = 0; i < arrayOfString.length; i++)
      {
        if ((arrayOfString[i].length() <= 0) || (arrayOfString[i].trim().indexOf(str2 + str6) < 0))
          continue;
        HashMap localHashMap = new HashMap();
        str7 = arrayOfString[i].substring(arrayOfString[i].indexOf(new StringBuilder().append(str2).append(str6).toString()) - 1, arrayOfString[i].length()) + str3 + str6 + str4;
        String str8 = str7.substring(0, str7.indexOf(str4) + 2);
        localHashMap.put("endtag", str6);
        localHashMap.put("tagstrings", str8);
        localHashMap.put("content", str7);
        localArrayList1.add(localHashMap);
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return localArrayList1;
  }

  public String getLoopContent(String paramString)
  {
    String str = "";
    if (paramString == null)
      return "";
    if (paramString.equals(""))
      return "";
    str = paramString.substring(paramString.trim().indexOf(this.start_word_end) + 2, paramString.trim().indexOf(this.end_word_start + this.namespace + ":" + this.tagname + this.end_word_end));
    return str;
  }

  public ArrayList getLoopAttrList(String paramString)
  {
    if (paramString == null)
      return null;
    if (paramString.equals(""))
      return null;
    StringUtil localStringUtil = new StringUtil();
    paramString = StringUtil.replace(paramString, "\n", "");
    paramString = StringUtil.replace(paramString, this.end_word_start + this.namespace + ":" + this.tagname + this.end_word_end, "");
    String str1 = this.start_word_start;
    String str2 = this.start_word_end;
    String str3 = this.namespace;
    String str4 = str3 + ":" + this.tagname;
    String str5 = "";
    String str6 = "";
    String str7 = str2;
    ArrayList localArrayList = new ArrayList();
    try
    {
      String[] arrayOfString = paramString.split("\\" + str1 + str3);
      for (int i = 0; i < arrayOfString.length; i++)
      {
        if ((arrayOfString[i].length() <= 0) || (arrayOfString[i].indexOf(str2) < 0) || (arrayOfString[i].indexOf(this.tagname) < 0))
          continue;
        str5 = arrayOfString[i].substring(1, arrayOfString[i].indexOf(str2)).trim();
        String str8 = str1 + str3 + arrayOfString[i].substring(0, arrayOfString[i].indexOf(str2) + 1).trim();
        str5 = str5.substring(0, str5.length()).trim();
        HashMap localHashMap = new HashMap();
        localHashMap.put("tagname", this.tagname);
        localHashMap.put("tagstr", str5);
        localHashMap.put("tagstring", str8);
        localArrayList.add(localHashMap);
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException + "『" + paramString + "』");
    }
    return localArrayList;
  }

  public String getLoopAttr(String paramString)
  {
    if (paramString == null)
      return null;
    if (paramString.equals(""))
      return null;
    StringUtil localStringUtil = new StringUtil();
    paramString = StringUtil.replace(paramString, "\n", "");
    paramString = StringUtil.replace(paramString, this.end_word_start + this.namespace + ":" + this.tagname + this.end_word_end, "");
    String str1 = this.start_word_start;
    String str2 = this.start_word_end;
    String str3 = this.namespace;
    String str4 = str3 + ":" + this.tagname;
    String str5 = "";
    String str6 = "";
    String str7 = str2;
    try
    {
      String[] arrayOfString = paramString.split("\\" + str1 + str3);
      for (int i = 0; i < arrayOfString.length; i++)
      {
        if ((arrayOfString[i].length() <= 0) || (arrayOfString[i].indexOf(str2) < 0) || (arrayOfString[i].indexOf(this.tagname) < 0))
          continue;
        str5 = arrayOfString[i].substring(1, arrayOfString[i].indexOf(str2)).trim();
        String str8 = str1 + str3 + arrayOfString[i].substring(0, arrayOfString[i].indexOf(str2) + 1).trim();
        str5 = str5.substring(0, str5.length()).trim();
        break;
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException + "『" + paramString + "』");
    }
    return str5;
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
          str1 = arrayOfString[0].trim().substring(arrayOfString[0].trim().indexOf(" "), arrayOfString[0].trim().length()).trim();
          str2 = "";
          localHashMap1 = new HashMap();
          localHashMap1.put("attrname", str1);
          localHashMap1.put("attrvalue", str2);
          localArrayList.add(localHashMap1);
        }
        else if (arrayOfString.length == 2)
        {
          str1 = arrayOfString[0].trim().substring(arrayOfString[0].trim().indexOf(" "), arrayOfString[0].trim().length()).trim();
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

  public String getAttrValue(ArrayList paramArrayList, String paramString)
  {
    paramString = paramString.replaceAll(" ", "").trim();
    String str1 = "";
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      if (localHashMap.get("attrname") != null)
        str2 = localHashMap.get("attrname").toString();
      if (str2.equals(paramString))
      {
        str1 = localHashMap.get("attrvalue").toString();
        break;
      }
    }
    return str1;
  }

  public ArrayList getFieldList(String paramString)
  {
    if (paramString == null)
      return null;
    if (paramString.equals(""))
      return null;
    StringUtil localStringUtil = new StringUtil();
    paramString = StringUtil.replace(paramString, "\n", "");
    String str1 = "[";
    String str2 = "/]";
    String str3 = "field";
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split("\\" + str1);
    try
    {
      for (int i = 0; i < arrayOfString.length; i++)
      {
        if (arrayOfString[i].length() <= 0)
          continue;
        String str4 = "";
        if (arrayOfString[i].indexOf(str2) < 0)
          continue;
        str4 = arrayOfString[i].substring(arrayOfString[i].indexOf(str3 + ":") + str3.length() + 1, arrayOfString[i].indexOf(str2)).trim();
        HashMap localHashMap = new HashMap();
        localHashMap.put("tagname", str3);
        localHashMap.put("fieldname", str4);
        localHashMap.put("tagstr", str1 + str3 + ":" + str4 + str2);
        localArrayList.add(localHashMap);
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException + "『" + paramString + "』");
    }
    return localArrayList;
  }

  public HashMap getFieldname(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = getFieldList(paramString1);
    paramString2 = paramString2.replaceAll(" ", "").trim();
    HashMap localHashMap1 = new HashMap();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap2 = (HashMap)localIterator.next();
      String str = "";
      if (localHashMap2.containsValue(paramString2))
        return localHashMap2;
    }
    return localHashMap1;
  }

  public HashMap getFieldname(ArrayList paramArrayList, String paramString)
  {
    paramString = paramString.replaceAll(" ", "").trim();
    HashMap localHashMap1 = new HashMap();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap2 = (HashMap)localIterator.next();
      String str = "";
      if (localHashMap2.containsValue(paramString))
        return localHashMap2;
    }
    return localHashMap1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.tag.Loopbase
 * JD-Core Version:    0.6.0
 */