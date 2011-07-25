package com.buildhtml;

import com.saas.biz.commen.commMethodMgr;
import com.saas.intf.AreaIntf;
import com.saas.intf.CustChannelIntf;
import com.saas.intf.CustLinkIntf;
import com.saas.intf.InfoIntf;
import com.saas.intf.ProductClassIntf;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import com.saas.sys.tag.Loopbase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.StrReplace;

public class CustParseLoop
{
  Logger log = new Logger(this);
  Config config = new Config();
  commMethodMgr comm = new commMethodMgr();
  public String ecms_path = this.config.ecms_path;
  private String default_img = this.config.default_img;
  public String cache_file_path = "";

  public void setCacheFile(String paramString)
  {
    this.cache_file_path = paramString;
  }

  public String buildChannel(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    try
    {
      paramString = buildLoop(paramString, paramHashMap, "ecms", "channel", "{", "}", "{/", "}");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
    }
    return paramString;
  }

  public String buildHotKey(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    try
    {
      paramString = buildLoop(paramString, paramHashMap, "ecms", "hotkey", "{", "}", "{/", "}");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
    }
    return paramString;
  }

  public String buildLink(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    try
    {
      paramString = buildLoop(paramString, paramHashMap, "ecms", "friendlink", "{", "}", "{/", "}");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
    }
    return paramString;
  }

  public String buildArticleList(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    try
    {
      paramString = buildLoop(paramString, paramHashMap, "ecms", "articlelist", "{", "}", "{/", "}");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
    }
    return paramString;
  }

  public String buildClass(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    try
    {
      paramString = buildLoop(paramString, paramHashMap, "ecms", "classlist", "{", "}", "{/", "}");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
    }
    return paramString;
  }

  public String buildSmallClass(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    try
    {
      paramString = buildLoop(paramString, paramHashMap, "ecms", "smallclasslist", "{", "}", "{/", "}");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
    }
    return paramString;
  }

  public String buildArea(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    try
    {
      paramString = buildLoop(paramString, paramHashMap, "ecms", "arealist", "{", "}", "{/", "}");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
    }
    return paramString;
  }

  public String buildLoop(String paramString1, HashMap paramHashMap, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    localLoopbase.setNameSpace(paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localLoopbase.setInstr(paramString1);
    ArrayList localArrayList = localLoopbase.getLoopList();
    if (localArrayList == null)
      return paramString1;
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      String str6 = "";
      if (localHashMap.get("endtag") != null)
        str1 = localHashMap.get("endtag").toString();
      if (localHashMap.get("content") != null)
        str2 = localHashMap.get("content").toString();
      if (localHashMap.get("tagstrings") != null)
        str6 = localHashMap.get("tagstrings").toString();
      str6 = str6.trim();
      str4 = localLoopbase.getLoopAttr(str2);
      str3 = localLoopbase.getLoopContent(str2);
      if (paramString3.equals("friendlink"))
      {
        try
        {
          str5 = buildLinkContent(paramHashMap, str4, str3);
        }
        catch (SaasApplicationException localSaasApplicationException1)
        {
        }
        paramString1 = paramString1.substring(0, paramString1.indexOf(new StringBuilder().append(paramString4).append(paramString2).append(":").append(paramString3).toString())) + str5 + paramString1.substring(paramString1.indexOf(new StringBuilder().append(paramString6).append(paramString2).append(":").append(paramString3).toString()) + paramString6.length() + paramString2.length() + 2 + paramString3.length(), paramString1.length());
      }
      if (paramString3.equals("classlist"))
      {
        try
        {
          str5 = buildClassContent(paramHashMap, str4, str3);
        }
        catch (SaasApplicationException localSaasApplicationException2)
        {
        }
        paramString1 = paramString1.substring(0, paramString1.indexOf(new StringBuilder().append(paramString4).append(paramString2).append(":").append(paramString3).toString())) + str5 + paramString1.substring(paramString1.indexOf(new StringBuilder().append(paramString6).append(paramString2).append(":").append(paramString3).toString()) + paramString6.length() + paramString2.length() + 2 + paramString3.length(), paramString1.length());
      }
      if (paramString3.equals("smallclasslist"))
      {
        try
        {
          str5 = buildSmallClassContent(paramHashMap, str4, str3);
        }
        catch (SaasApplicationException localSaasApplicationException3)
        {
        }
        paramString1 = paramString1.substring(0, paramString1.indexOf(new StringBuilder().append(paramString4).append(paramString2).append(":").append(paramString3).toString())) + str5 + paramString1.substring(paramString1.indexOf(new StringBuilder().append(paramString6).append(paramString2).append(":").append(paramString3).toString()) + paramString6.length() + paramString2.length() + 2 + paramString3.length(), paramString1.length());
      }
      if (paramString3.equals("arealist"))
      {
        try
        {
          str5 = buildAreaContent(paramHashMap, str4, str3);
        }
        catch (SaasApplicationException localSaasApplicationException4)
        {
        }
        paramString1 = paramString1.substring(0, paramString1.indexOf(new StringBuilder().append(paramString4).append(paramString2).append(":").append(paramString3).toString())) + str5 + paramString1.substring(paramString1.indexOf(new StringBuilder().append(paramString6).append(paramString2).append(":").append(paramString3).toString()) + paramString6.length() + paramString2.length() + 2 + paramString3.length(), paramString1.length());
      }
      if (paramString3.equals("channel"))
      {
        try
        {
          str5 = buildChannelContent(paramHashMap, str4, str3);
        }
        catch (SaasApplicationException localSaasApplicationException5)
        {
        }
        paramString1 = paramString1.substring(0, paramString1.indexOf(str6)) + str5 + paramString1.substring(paramString1.indexOf(new StringBuilder().append(paramString6).append(paramString2).append(":").append(paramString3).toString()) + paramString6.length() + paramString2.length() + 2 + paramString3.length(), paramString1.length());
      }
      if (paramString3.equals("articlelist"))
      {
        try
        {
          str5 = buildArticleListContent(paramHashMap, str4, str3);
        }
        catch (SaasApplicationException localSaasApplicationException6)
        {
        }
        paramString1 = paramString1.substring(0, paramString1.indexOf(str6)) + str5 + paramString1.substring(paramString1.indexOf(new StringBuilder().append(paramString6).append(paramString2).append(":").append(paramString3).toString()) + paramString6.length() + paramString2.length() + 2 + paramString3.length(), paramString1.length());
      }
    }
    return paramString1;
  }

  public String buildLinkContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    String str1 = "";
    String str2 = "";
    HashMap localHashMap = new HashMap();
    String str3 = localLoopbase.getAttrValue(paramString1, "row");
    if (str3.equals(""))
      str3 = "10";
    localHashMap.put("row", str3);
    if (paramHashMap.get("cust_id") != null)
      str2 = paramHashMap.get("cust_id").toString();
    CustLinkIntf localCustLinkIntf = new CustLinkIntf();
    ArrayList localArrayList = localCustLinkIntf.getLinkListByPage(0, Integer.parseInt(str3), str2);
    str1 = replaceFieldValue(paramString2, localArrayList, localHashMap);
    return str1;
  }

  public String buildAreaContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    String str1 = "";
    HashMap localHashMap = new HashMap();
    String str2 = localLoopbase.getAttrValue(paramString1, "type");
    String str3 = localLoopbase.getAttrValue(paramString1, "row");
    String str4 = localLoopbase.getAttrValue(paramString1, "ch_id");
    if ((str4.equals("")) && (paramHashMap.get("ch_id") != null))
      str4 = paramHashMap.get("ch_id").toString();
    localHashMap.put("ch_id", str4);
    localHashMap.put("row", str3);
    String str5 = localLoopbase.getAttrValue(paramString1, "showtype");
    String str6 = localLoopbase.getAttrValue(paramString1, "orderby");
    AreaIntf localAreaIntf = new AreaIntf();
    if ((str2.equals("")) && (paramHashMap.get("area_code") != null))
      str2 = paramHashMap.get("area_code").toString();
    ArrayList localArrayList = localAreaIntf.getAreaByParentTag(str2, str6);
    str1 = replaceFieldValue(paramString2, localArrayList, localHashMap);
    return str1;
  }

  public String buildClassContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustChannelIntf localCustChannelIntf = new CustChannelIntf();
    Loopbase localLoopbase = new Loopbase();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = localLoopbase.getAttrValue(paramString1, "type");
    if (paramHashMap.get("cust_id") != null)
      str2 = paramHashMap.get("cust_id").toString();
    if (paramHashMap.get("class_id") != null)
      str3 = paramHashMap.get("class_id").toString();
    HashMap localHashMap1 = new HashMap();
    String str5 = localLoopbase.getAttrValue(paramString1, "row");
    localHashMap1.put("row", str5);
    String str6 = localLoopbase.getAttrValue(paramString1, "cmodel");
    String str7 = "";
    if (str6.equals("product"))
      str7 = "3";
    if (str6.equals("stock"))
      str7 = "2";
    if (str6.equals("supply"))
      str7 = "1";
    InfoIntf localInfoIntf = new InfoIntf();
    ArrayList localArrayList = localInfoIntf.getCustClassByCustId(str2, str7);
    String str8 = "";
    if (localArrayList != null)
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      if (localHashMap2.get("save_dir") != null)
        str8 = localHashMap2.get("save_dir").toString();
      localHashMap1.put("class_save_dir", str8);
    }
    str1 = replaceFieldValue(paramString2, localArrayList, localHashMap1);
    return str1;
  }

  public String buildSmallClassContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CustChannelIntf localCustChannelIntf = new CustChannelIntf();
    Loopbase localLoopbase = new Loopbase();
    String str1 = "";
    HashMap localHashMap = new HashMap();
    String str2 = localLoopbase.getAttrValue(paramString1, "type");
    String str3 = localLoopbase.getAttrValue(paramString1, "row");
    localHashMap.put("row", str3);
    String str4 = localLoopbase.getAttrValue(paramString1, "cmodel");
    String str5 = localLoopbase.getAttrValue(paramString1, "showtype");
    String str6 = localLoopbase.getAttrValue(paramString1, "orderby");
    String str7 = localLoopbase.getAttrValue(paramString1, "up_class_id");
    String str8 = "";
    if (paramHashMap.get("save_dir") != null)
    {
      if (!paramHashMap.get("save_dir").toString().equals(""))
      {
        str8 = paramHashMap.get("save_dir").toString();
      }
      else
      {
        if (str4.equals("supply"))
          str8 = localCustChannelIntf.getSaveDirByChLevelAndContMod("1", "1");
        if (str4.equals("product"))
          str8 = localCustChannelIntf.getSaveDirByChLevelAndContMod("1", "3");
        if (str4.equals("stock"))
          str8 = localCustChannelIntf.getSaveDirByChLevelAndContMod("1", "2");
        if (str4.equals("enterprise"))
          str8 = localCustChannelIntf.getSaveDirByChLevelAndContMod("1", "4");
      }
    }
    else
    {
      if (str4.equals("supply"))
        str8 = localCustChannelIntf.getSaveDirByChLevelAndContMod("1", "1");
      if (str4.equals("product"))
        str8 = localCustChannelIntf.getSaveDirByChLevelAndContMod("1", "3");
      if (str4.equals("stock"))
        str8 = localCustChannelIntf.getSaveDirByChLevelAndContMod("1", "2");
      if (str4.equals("enterprise"))
        str8 = localCustChannelIntf.getSaveDirByChLevelAndContMod("1", "4");
    }
    if (!str8.equals(""))
      localHashMap.put("class_save_dir", str8);
    ProductClassIntf localProductClassIntf = new ProductClassIntf();
    ArrayList localArrayList = localProductClassIntf.getProductClassByUpId(str7);
    str1 = replaceFieldValue(paramString2, localArrayList, localHashMap);
    return str1;
  }

  public String buildChannelContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    HashMap localHashMap = new HashMap();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "top";
    String str5 = "10";
    String str6 = "";
    String str7 = "";
    int i = 0;
    int j = 0;
    if (paramHashMap.get("ch_id") != null)
      str2 = paramHashMap.get("ch_id").toString();
    if (paramHashMap.get("cust_id") != null)
      str3 = paramHashMap.get("cust_id").toString();
    if ((localLoopbase.getAttrValue(paramString1, "type") != null) && (!localLoopbase.getAttrValue(paramString1, "type").equals("")))
      str4 = localLoopbase.getAttrValue(paramString1, "type");
    if ((localLoopbase.getAttrValue(paramString1, "limit") != null) && (!localLoopbase.getAttrValue(paramString1, "limit").equals("")))
      str6 = localLoopbase.getAttrValue(paramString1, "limit");
    if ((localLoopbase.getAttrValue(paramString1, "ch_id") != null) && (!localLoopbase.getAttrValue(paramString1, "ch_id").equals("")))
      str2 = localLoopbase.getAttrValue(paramString1, "ch_id");
    if ((localLoopbase.getAttrValue(paramString1, "row") != null) && (!localLoopbase.getAttrValue(paramString1, "row").equals("")))
      str5 = localLoopbase.getAttrValue(paramString1, "row");
    if ((localLoopbase.getAttrValue(paramString1, "orderby") != null) && (!localLoopbase.getAttrValue(paramString1, "orderby").equals("")))
      str7 = localLoopbase.getAttrValue(paramString1, "orderby");
    ArrayList localArrayList = new ArrayList();
    localHashMap.put("row", str5);
    CustChannelIntf localCustChannelIntf = new CustChannelIntf();
    if (!str6.equals(""))
    {
      String[] arrayOfString = str6.split(",");
      if ((arrayOfString[0].length() > 0) && (arrayOfString[1].length() > 0))
      {
        i = Integer.parseInt(arrayOfString[0]);
        j = Integer.parseInt(arrayOfString[1]);
      }
      else
      {
        i = 0;
        j = Integer.parseInt(str5);
      }
    }
    else
    {
      i = 0;
      j = Integer.parseInt(str5);
    }
    if (str4.equals("top"))
      localArrayList = localCustChannelIntf.getChInfoSon("0000000000", str3, str7, i, j);
    else if (str4.equals("self"))
      localArrayList = localCustChannelIntf.getChInfoSelf(str2, str3, str7, i, j);
    else if (str4.equals("son"))
      localArrayList = localCustChannelIntf.getChInfoSon(str2, str3, str7, i, j);
    str1 = replaceFieldValue(paramString2, localArrayList, localHashMap);
    return str1;
  }

  public String buildArticleListContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "10";
    String str9 = "in_date";
    String str10 = "20";
    String str11 = "7";
    String str12 = "100";
    String str13 = "text";
    String str14 = "";
    int i = 0;
    int j = 100;
    String str15 = "";
    String str16 = "";
    String str17 = "";
    String str18 = "";
    String str19 = "";
    String str20 = "";
    String str21 = "";
    Object localObject = "";
    
    HashMap localHashMap1 = new HashMap();
    if ((localLoopbase.getAttrValue(paramString1, "ch_id") != null) && (!localLoopbase.getAttrValue(paramString1, "ch_id").equals("")))
    {
      str3 = localLoopbase.getAttrValue(paramString1, "ch_id");
      localHashMap1.put("ch_id", str3);
    }
    if ((localLoopbase.getAttrValue(paramString1, "all") != null) && (!localLoopbase.getAttrValue(paramString1, "all").equals("")))
      str19 = localLoopbase.getAttrValue(paramString1, "all");
    if ((localLoopbase.getAttrValue(paramString1, "recommend") != null) && (!localLoopbase.getAttrValue(paramString1, "recommend").equals("")))
      str4 = localLoopbase.getAttrValue(paramString1, "recommend");
    if ((localLoopbase.getAttrValue(paramString1, "keyword") != null) && (!localLoopbase.getAttrValue(paramString1, "keyword").equals("")))
      str5 = localLoopbase.getAttrValue(paramString1, "keyword");
    if ((localLoopbase.getAttrValue(paramString1, "limit") != null) && (!localLoopbase.getAttrValue(paramString1, "limit").equals("")))
      str6 = localLoopbase.getAttrValue(paramString1, "limit");
    if ((localLoopbase.getAttrValue(paramString1, "pub") != null) && (!localLoopbase.getAttrValue(paramString1, "pub").equals("")))
      str7 = localLoopbase.getAttrValue(paramString1, "pub");
    if ((localLoopbase.getAttrValue(paramString1, "row") != null) && (!localLoopbase.getAttrValue(paramString1, "row").equals("")))
    {
      str8 = localLoopbase.getAttrValue(paramString1, "row");
      localHashMap1.put("row", str8);
    }
    if ((localLoopbase.getAttrValue(paramString1, "imgwidth") != null) && (!localLoopbase.getAttrValue(paramString1, "imgwidth").equals("")))
    {
      str15 = localLoopbase.getAttrValue(paramString1, "imgwidth");
      localHashMap1.put("imgwidth", str15);
    }
    if ((localLoopbase.getAttrValue(paramString1, "imgheight") != null) && (!localLoopbase.getAttrValue(paramString1, "imgheight").equals("")))
    {
      str16 = localLoopbase.getAttrValue(paramString1, "imgheight");
      localHashMap1.put("imgheight", str16);
    }
    if ((localLoopbase.getAttrValue(paramString1, "orderby") != null) && (!localLoopbase.getAttrValue(paramString1, "orderby").equals("")))
      str9 = localLoopbase.getAttrValue(paramString1, "orderby");
    if ((localLoopbase.getAttrValue(paramString1, "titlelen") != null) && (!localLoopbase.getAttrValue(paramString1, "titlelen").equals("")))
    {
      str10 = localLoopbase.getAttrValue(paramString1, "titlelen");
      localHashMap1.put("titlelen", str10);
    }
    if ((localLoopbase.getAttrValue(paramString1, "adrlen") != null) && (!localLoopbase.getAttrValue(paramString1, "adrlen").equals("")))
    {
      str11 = localLoopbase.getAttrValue(paramString1, "adrlen");
      localHashMap1.put("adrlen", str11);
    }
    if ((localLoopbase.getAttrValue(paramString1, "infolen") != null) && (!localLoopbase.getAttrValue(paramString1, "infolen").equals("")))
    {
      str12 = localLoopbase.getAttrValue(paramString1, "infolen");
      localHashMap1.put("infolen", str12);
    }
    if ((localLoopbase.getAttrValue(paramString1, "showtype") != null) && (!localLoopbase.getAttrValue(paramString1, "showtype").equals("")))
      str13 = localLoopbase.getAttrValue(paramString1, "showtype");
    if ((localLoopbase.getAttrValue(paramString1, "cmodel") != null) && (!localLoopbase.getAttrValue(paramString1, "cmodel").equals("")))
      str14 = localLoopbase.getAttrValue(paramString1, "cmodel");
    ArrayList localArrayList = new ArrayList();
    InfoIntf localInfoIntf = new InfoIntf();
    if (((str3.equals("")) || (str3 == null)) && (paramHashMap.get("ch_id") != null))
      str3 = paramHashMap.get("ch_id").toString();
    if (paramHashMap.get("cust_id") != null)
      str1 = paramHashMap.get("cust_id").toString();
    localHashMap1.put("cust_id", str1);
    CustChannelIntf localCustChannelIntf = new CustChannelIntf();
    if (!str3.equals(""))
    {
      localObject = localCustChannelIntf.getChInfo(str3, str1);
      if (localObject != null)
      {
        if (((HashMap)localObject).get("save_dir") != null)
          str18 = ((HashMap)localObject).get("save_dir").toString();
        if (((HashMap)localObject).get("cont_mod") != null)
          str20 = ((HashMap)localObject).get("cont_mod").toString();
      }
    }
    else
    {
      str18 = paramHashMap.get("save_dir").toString();
    }
    localHashMap1.put("save_dir", str18);
    if (paramHashMap.get("area_code") != null)
      str17 = paramHashMap.get("area_code").toString();
    if (paramHashMap.get("class_id") != null)
      str21 = paramHashMap.get("class_id").toString();
    localHashMap1.put("area_code", str17);
    if (paramHashMap.get("start_row") != null)
    {
      i = Integer.parseInt(paramHashMap.get("start_row").toString());
      j = Integer.parseInt(paramHashMap.get("page_size").toString());
    }
    else if (!str6.equals(""))
    {
       String[] localObjects=new String[str6.split(",").length];
       localObjects = str6.split(",");
      if ((localObjects[0].length() > 0) && (localObjects[1].length() > 0))
      {
        i = Integer.parseInt(localObjects[0]);
        j = Integer.parseInt(localObjects[1]);
      }
      else
      {
        i = 0;
        j = Integer.parseInt(str8);
      }
    }
    else
    {
      i = 0;
      j = Integer.parseInt(str8);
    }
    if (Integer.parseInt(str8) < j)
      j = Integer.parseInt(str8);
    localHashMap1.put("page", Integer.valueOf(j));
    if ((str9.equals("user")) || (localLoopbase.getAttrValue(paramString1, "orderby").equals("")))
    {
      HashMap localHashMap2 = localCustChannelIntf.getChInfo(str3, str1);
      if ((localHashMap2 != null) && (localHashMap2.get("list_type") != null))
        localObject = localHashMap2.get("list_type").toString();
      if (((String)localObject).equals("0"))
        localArrayList = localInfoIntf.getInfoListByIndate(i, j, str3, str1, str5, str14, str4);
    }
    if (str9.equals("indate"))
      localArrayList = localInfoIntf.getInfoListByIndate(i, j, str3, str1, str5, str14, str4);
    if (str9.equals("hot"))
      localArrayList = localInfoIntf.getInfoListByHot(i, j, str3, str1, str5, str14, str4);
    if (str19.equals("news"))
      localArrayList = localInfoIntf.getCustInfoListByAllNews(i, j, str1);
    if ((str19.equals("index")) && (str21.equals("")))
      localArrayList = localInfoIntf.getCustInfoListByIndex(i, j, str14, str1);
    if ((!str21.equals("")) && (!str19.equals("index")))
      localArrayList = localInfoIntf.getCustClassByCustIdClassId(str1, str20, str21);
    str2 = replaceFieldValue(paramString2, localArrayList, localHashMap1);
    return (String)str2;
  }

  public String replaceFieldValue(String paramString, ArrayList paramArrayList, HashMap paramHashMap)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    CustChannelIntf localCustChannelIntf = new CustChannelIntf();
    InfoIntf localInfoIntf = new InfoIntf();
    String str1 = "";
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 80;
    int i1 = 80;
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3 = "";
    if (paramHashMap != null)
    {
      if (paramHashMap.get("row") != null)
        i = Integer.parseInt(paramHashMap.get("row").toString());
      if (paramHashMap.get("imgwidth") != null)
        n = Integer.parseInt(paramHashMap.get("imgwidth").toString());
      if (paramHashMap.get("imgheight") != null)
        i1 = Integer.parseInt(paramHashMap.get("imgheight").toString());
      if (paramHashMap.get("adrlen") != null)
        k = Integer.parseInt(paramHashMap.get("adrlen").toString());
      if (paramHashMap.get("titlelen") != null)
        j = Integer.parseInt(paramHashMap.get("titlelen").toString());
      if (paramHashMap.get("infolen") != null)
        m = Integer.parseInt(paramHashMap.get("infolen").toString());
      if (paramHashMap.get("area_code") != null)
        str2 = paramHashMap.get("area_code").toString();
      if (paramHashMap.get("save_dir") != null)
        str3 = paramHashMap.get("save_dir").toString();
      if (paramHashMap.get("ch_id") != null)
        str4 = paramHashMap.get("ch_id").toString();
      if (paramHashMap.get("cust_id") != null)
        str5 = paramHashMap.get("cust_id").toString();
      if (paramHashMap.get("class_save_dir") != null)
        str6 = paramHashMap.get("class_save_dir").toString();
    }
    if (paramArrayList == null)
      return "";
    for (int i2 = 0; (i2 < paramArrayList.size()) && (i2 < i); i2++)
    {
      HashMap localHashMap1 = (HashMap)paramArrayList.get(i2);
      str1 = str1 + "\n";
      str1 = str1 + paramString;
      if (localHashMap1 == null)
        continue;
      String str7 = "";
      String str8 = "";
      HashMap localHashMap3=new HashMap();
      for (int i3 = 0; i3 < localHashMap1.size(); i3++)
      {
        localObject1 = getMapKey(localHashMap1, i3);
        localHashMap3 = localLoopbase.getFieldname(paramString, (String)localObject1);
        if (localHashMap3.get("tagstr") != null)
          str7 = localHashMap3.get("tagstr").toString();
        if (!localHashMap3.containsValue(localObject1))
          continue;
        if ((!((String)localObject1).equals("")) && (((String)localObject1).equals("title")) && (j != 0) && (localHashMap1.get(localObject1) != null))
        {
          str8 = localHashMap1.get(localObject1).toString();
          if (str8.length() > j)
            str8 = str8.substring(0, j);
          str1 = StrReplace.replace(str1, str7, str8);
        }
        else
        {
          if (localHashMap1.get(localObject1) != null)
            str8 = localHashMap1.get(localObject1).toString();
          str1 = StrReplace.replace(str1, str7, str8);
        }
      }
      HashMap localHashMap2 = localLoopbase.getFieldname(paramString, "arcurl");
      if ((localHashMap2 != null) && (localHashMap2.containsValue("arcurl")))
      {
        str7 = localHashMap2.get("tagstr").toString();
        if (localHashMap1.get("info_id") != null)
        {
          str8 = "/" + str3 + "/d/content-" + localHashMap1.get("info_id").toString() + ".html";
          if (!str7.equals(""))
            str1 = StrReplace.replace(str1, str7, str8);
        }
      }
       localObject1 = localLoopbase.getFieldname(paramString, "small_class_path");
      if ((localObject1 != null) && (((HashMap)localObject1).containsValue("small_class_path")))
      {
        str7 = ((HashMap)localObject1).get("tagstr").toString();
        if (localHashMap1.get("small_class_id") != null)
        {
          str8 = "/" + str6 + "/class/" + localHashMap1.get("small_class_id").toString() + "/";
          if (!str7.equals(""))
            str1 = StrReplace.replace(str1, str7, str8);
        }
      }
     
       localHashMap3 = localLoopbase.getFieldname(paramString, "class_path");
      if ((localHashMap3 != null) && (localHashMap3.containsValue("class_path")))
      {
        str7 = localHashMap3.get("tagstr").toString();
        if (localHashMap1.get("class_id") != null)
        {
          str8 = "/" + str6 + "/class/" + localHashMap1.get("class_id").toString() + "/" + localHashMap1.get("default_page");
          if (!str7.equals(""))
            str1 = StrReplace.replace(str1, str7, str8);
        }
      }
      HashMap localHashMap4 = localLoopbase.getFieldname(paramString, "newsurl");
      if ((localHashMap4 != null) && (localHashMap4.containsValue("newsurl")))
      {
        str7 = localHashMap4.get("tagstr").toString();
        if (localHashMap1.get("info_id") != null)
        {
           localObject2 = localHashMap1.get("info_id").toString();
          localObject3 = localInfoIntf.getChannelSaveDirByInfoId((String)localObject2);
          str8 = "/" + (String)localObject3 + "/d/content-" + localHashMap1.get("info_id").toString() + ".html";
          if (!str7.equals(""))
            str1 = StrReplace.replace(str1, str7, str8);
        }
      }
       localObject2 = localLoopbase.getFieldname(paramString, "moreurl");
      if ((localObject2 != null) && (((HashMap)localObject2).containsValue("moreurl")))
      {
        str7 = ((HashMap)localObject2).get("tagstr").toString();
        if (localHashMap1.get("save_dir") != null)
        {
          str8 = "/" + localHashMap1.get("save_dir").toString() + "/list";
          if (!str7.equals(""))
            str1 = StrReplace.replace(str1, str7, str8);
        }
      }
        localObject3 = localLoopbase.getFieldname(paramString, "areaurl");
      if ((localObject3 != null) && (((HashMap)localObject3).containsValue("areaurl")))
      {
        str7 = ((HashMap)localObject3).get("tagstr").toString();
        if (!str4.equals(""))
        {
        	 HashMap localHashMap5 = localCustChannelIntf.getChInfo(str4, str5);
          if ((localHashMap5 != null) && (localHashMap5.get("save_dir") != null))
          {
            str3 = localHashMap5.get("save_dir").toString();
            str8 = "/" + str3 + "/area/" + localHashMap1.get("area_code").toString() + "/";
          }
        }
        if (!str7.equals(""))
          str1 = StrReplace.replace(str1, str7, str8);
      }
      HashMap localHashMap5 = localLoopbase.getFieldname(paramString, "imgurl");
      if ((localHashMap5 != null) && (localHashMap5.containsValue("imgurl")))
      {
        str7 = localHashMap5.get("tagstr").toString();
        if (localHashMap1.get("mini_img") != null)
        {
          if (localHashMap1.get("mini_img").toString().equals(""))
            str8 = "<img src=" + this.default_img + " border=0 width=" + n + " height=" + i1 + ">";
          else
            str8 = "<img src=" + localHashMap1.get("mini_img").toString() + " border=0 width=" + n + " height=" + i1 + ">";
        }
        else
          str8 = "<img src=/images/default_wood.gif border=0 width=" + n + " height=" + i1 + ">";
        if (!str7.equals(""))
          str1 = StrReplace.replace(str1, str7, str8);
      }
      HashMap localHashMap6 = localLoopbase.getFieldname(paramString, "churl");
      if ((localHashMap6 == null) || (!localHashMap6.containsValue("churl")))
        continue;
      str7 = localHashMap6.get("tagstr").toString();
      if (localHashMap1.get("ch_attr") != null)
      {
        if ((localHashMap1.get("ch_attr").toString().equals("0")) || (localHashMap1.get("ch_attr").toString().equals("1")))
          str8 = "/" + localHashMap1.get("save_dir").toString() + "/" + localHashMap1.get("default_page").toString();
        if ((localHashMap1.get("ch_attr").toString().equals("2")) || (localHashMap1.get("ch_attr").toString().equals("3")))
          str8 = localHashMap1.get("default_page").toString();
      }
      str1 = StrReplace.replace(str1, str7, str8);
    }
    return (String)(String)(String)str1;
  }

  public String getMapKey(HashMap paramHashMap, int paramInt)
  {
    String str1 = "";
    if (paramHashMap == null)
      return str1;
    String str2 = paramHashMap.keySet().toString();
    str2 = StrReplace.replace(str2, "[", "");
    str2 = StrReplace.replace(str2, "]", "");
    String[] arrayOfString = str2.split(",");
    str1 = arrayOfString[paramInt].trim();
    return str1;
  }

  public void buildList()
    throws SaasApplicationException
  {
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.CustParseLoop
 * JD-Core Version:    0.6.0
 */