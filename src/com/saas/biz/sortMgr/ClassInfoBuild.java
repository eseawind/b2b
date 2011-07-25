package com.saas.biz.sortMgr;

import com.saas.biz.dao.productclassDAO.ProductclassExt;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tools.util.StringUtil;

public class ClassInfoBuild
{
  Logger log = new Logger(this);

  public ArrayList getSortItems()
  {
    return getSortItems("000000000000000");
  }

  public ArrayList getSortItems(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      paramString = "000000000000000";
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", "0");
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_CHILD_CLASS");
    return localArrayList;
  }

  public Map getClassByParentId(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", "3");
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_BY_PARENTID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str1 = localHashMap.get("class_id").toString();
        String str2 = localHashMap.get("class_name").toString();
        localLinkedHashMap.put(str1, str2);
      }
    return localLinkedHashMap;
  }

  public boolean hasSubItems(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      paramString = "000000000000000";
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", "0");
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString);
    ArrayList localArrayList = localProductclassExt.selByList("SEL_HASCHILD_CLASS");
    return (localArrayList != null) && (localArrayList.get(0) != null) && (!"0".equals(((HashMap)localArrayList.get(0)).get("class_total").toString()));
  }

  public List getClassInfoByLimit(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_TYPE", paramString2);
    localArrayList = localProductclassExt.selByList("SEL_BY_UP_TYPE", 0, paramInt);
    return localArrayList;
  }

  public ArrayList getClassInfoByUpType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VCLASS_TYPE", paramString2);
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localArrayList = localProductclassExt.selByList("SEL_BY_PARENTID");
    return localArrayList;
  }

  public List getHtmlTemplateInfo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    localArrayList = getClassInfoByUpType(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localObject = getHTMLCodeByHead(localArrayList, paramString3, paramString2);
    return (List)localObject;
  }

  public List getHTMLCodeByHead(List paramList, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
      for (int i = 0; i < paramList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramList.get(i);
        String str1 = localHashMap.get("class_id").toString();
        String str2 = localHashMap.get("class_name").toString();
        localArrayList.add(createHtmlTemplate(str1, str2, paramString1, paramString2));
      }
    return localArrayList;
  }

  public String cteateHtmlClassInfo(List paramList, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if ((paramList != null) && (paramList.size() > 0))
      for (int i = 0; i < paramList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramList.get(i);
        String str4 = localHashMap.get("class_id").toString();
        String str5 = localHashMap.get("class_name").toString();
        if ((i > 0) && (i % 3 == 0))
        {
          str1 = str1 + str2 + str3;
          str2 = "";
          str3 = "";
        }
        str2 = str2 + "<a href=" + paramString1 + str4 + "><strong>" + str5 + "</strong></a>";
        str3 = str3 + createThreeClassInfo(str4, paramString1, paramString2);
      }
    return str1;
  }

  public String createThreeClassInfo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = getClassInfoByUpType(paramString1, paramString3);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; (i < localArrayList.size()) && (i < 10); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("class_id").toString();
        String str3 = localHashMap.get("class_name").toString();
        str1 = str1 + "<a href=" + paramString2 + str2 + ">" + str3 + "</a>&nbsp;|&nbsp;";
      }
    return str1;
  }

  public String getHtmlTemplateStr(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = getClassInfoByUpType(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int i = 0;
      for (int j = 0; (i < 12) && (j < 6) && (i < localArrayList.size()); j++)
      {
        String str2 = "";
        String str3 = "";
        HashMap localHashMap1 = (HashMap)localArrayList.get(i);
        String str4 = localHashMap1.get("class_id").toString();
        String str5 = localHashMap1.get("class_name").toString();
        HashMap localHashMap2 = (HashMap)localArrayList.get(i + 1);
        String str6 = localHashMap2.get("class_id").toString();
        String str7 = localHashMap2.get("class_name").toString();
        if (j % 2 == 0)
          str3 = replaceTop1(str4, str5, str6, str7, paramString3, paramString2);
        else
          str3 = replaceTop2(str4, str5, str6, str7, paramString3, paramString2);
        str1 = str1 + str3;
        i += 2;
      }
    }
    return str1;
  }

  public String replaceTop1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    String str = "<tr>                                                   <td width=\"50%\" valign=\"top\" bgcolor=\"EDF2F8\">                <a href=\"" + paramString5 + paramString6 + "&class_id=" + paramString1 + "\"  class=\"cpbt\">" + paramString2 + "</a><br>" + createHtmlTemplate(paramString1, paramString2, paramString5, paramString6) + "</td>                                                            " + "<td width=\"50%\" valign=\"top\">                                " + "   <a href=\"" + paramString5 + paramString6 + "&class_id=" + paramString3 + "\" class=\"cpbt\">" + paramString4 + "</a><br> " + createHtmlTemplate(paramString3, paramString4, paramString5, paramString6) + "</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  " + "</tr>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ";
    return str;
  }

  public String replaceTop2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    String str = "<tr>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td valign=\"top\">                                                 <a href=\"" + paramString5 + paramString6 + "&class_id=" + paramString1 + "\" class=\"cpbt\">" + paramString2 + "</a><br>" + createHtmlTemplate(paramString1, paramString2, paramString5, paramString6) + "</td>                                                            " + "<td valign=\"top\" bgcolor=\"EDF2F8\">                           " + "   <a href=\"" + paramString5 + paramString6 + "&class_id=" + paramString3 + "\" class=\"cpbt\">" + paramString4 + "</a><br>" + createHtmlTemplate(paramString3, paramString4, paramString5, paramString6) + "</td>                                                            " + "</tr>                                                            ";
    return str;
  }

  public String createHtmlTemplate(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getClassInfoByUpType(paramString1, paramString4);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      str = str + replaceTwo(localArrayList, paramString3, paramString4);
    return str;
  }

  public String replaceTwo(ArrayList paramArrayList, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; (i < paramArrayList.size()) && (i < 24); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        String str2 = localHashMap.get("class_id").toString();
        Object localObject = "";
        String str3 = "";
        if (localHashMap.get("class_name") != null)
        {
          str3 = localHashMap.get("class_name").toString();
          if (str3.length() > 4)
          {
            localObject = StringUtil.getLimitLengthString(str3, "", 9);
          }
          else
          {
            localObject = str3;
            for (int j = 0; j < 6 - ((String)localObject).length(); j++)
              localObject = (String)localObject + "&nbsp";
          }
        }
        str1 = str1 + "<a href=\"" + paramString1 + paramString2 + "&class_id=" + str2 + "\" title=\"" + str3 + "\"class=\"news\">" + (String)localObject + " |</a> ";
      }
    return (String)str1;
  }

  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    int i = paramString2.length();
    int j;
    while ((j = paramString1.indexOf(paramString2)) != -1)
    {
      str = str + paramString1.substring(0, j);
      str = str + paramString3;
      paramString1 = paramString1.substring(j + i);
    }
    str = str + paramString1;
    return str;
  }

  public static ArrayList getList()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < 10; i++)
    {
      HashMap localHashMap = new HashMap();
      String str1 = "name" + i;
      String str2 = "idx" + i;
      localHashMap.put("class_id", str2);
      localHashMap.put("class_name", str1);
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.sortMgr.ClassInfoBuild
 * JD-Core Version:    0.6.0
 */