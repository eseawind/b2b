package com.saas.biz.sortMgr;

import com.saas.biz.dao.productclassDAO.ProductclassExt;
import com.saas.sys.exp.SaasApplicationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class custSortMgr
{
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
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ProductclassExt localProductclassExt = new ProductclassExt();
    localProductclassExt.setParam(":VUP_CLASS_ID", paramString1);
    localProductclassExt.setParam(":VCLASS_TYPE", paramString2);
    localProductclassExt.setParam(":VNUM", Integer.valueOf(paramInt));
    localArrayList2 = localProductclassExt.selByList("SEL_BY_UP_TYPE", 0, paramInt);
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)localArrayList2.get(i);
        HashMap localHashMap2 = new HashMap();
        String str1 = localHashMap1.get("class_id").toString();
        String str2 = localHashMap1.get("class_name").toString();
        localHashMap2.put("id", str1);
        localHashMap2.put("name", str2);
        localArrayList1.add(localHashMap2);
      }
    return localArrayList1;
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

  public List createHtmlTemplate(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    str2 = "<a href=" + paramString3 + ">" + paramString2 + "</a>";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = getClassInfoByUpType(paramString1, paramString4);
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      int i = localArrayList2.size();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      if (i % 2 == 0)
      {
        localArrayList3.addAll(localArrayList2.subList(0, i / 2));
        localArrayList4.addAll(localArrayList2.subList(i / 2, i));
      }
      else
      {
        int j = i / 2;
        localArrayList3.addAll(localArrayList2.subList(0, j));
        localArrayList4.addAll(localArrayList2.subList(j, i - 1));
        localArrayList5.addAll(localArrayList2.subList(i - 1, i));
      }
      str1 = cteateHtmlClassInfo(localArrayList3, paramString3, paramString4);
      str1 = str1 + cteateHtmlClassInfo(localArrayList4, paramString3, paramString4);
      str1 = str1 + cteateHtmlClassInfo(localArrayList5, paramString3, paramString4);
    }
    localArrayList1.add(str2);
    localArrayList1.add(str1);
    return localArrayList1;
  }

  public String cteateHtmlClassInfo(List paramList, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    if ((paramList != null) && (paramList.size() > 0))
      for (int i = 0; i < paramList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramList.get(i);
        String str5 = localHashMap.get("class_id").toString();
        String str6 = localHashMap.get("class_name").toString();
        if ((i > 0) && (i % 3 == 0))
        {
          str2 = str2 + str3 + str4;
          str3 = "";
          str4 = "";
        }
        str3 = str3 + "<a href=" + paramString1 + str5 + "><strong>" + str6 + "</strong></a>";
        str4 = str4 + createThreeClassInfo(str5, paramString1, paramString2);
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
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.sortMgr.custSortMgr
 * JD-Core Version:    0.6.0
 */