package com.buildhtml;

import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.commen.ConfigurationMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.custMgr.Custinfo;
import com.saas.biz.infoClassMgr.CalalogInfo;
import com.saas.intf.AreaIntf;
import com.saas.intf.ChannelIntf;
import com.saas.intf.InfoIntf;
import com.saas.intf.LinkIntf;
import com.saas.intf.PriceRankIntf;
import com.saas.intf.ProductClassIntf;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import com.saas.sys.tag.Loopbase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.StrReplace;

public class ParseLoop
{
  Logger log = new Logger(this);
  Config config = new Config();
  commMethodMgr comm = new commMethodMgr();
  CalalogInfo calalogInfo = new CalalogInfo();
  private String ecms_path = this.config.ecms_path;
  private String default_img = this.config.default_img;
  private String cache_file_path = "";
  private String logolink = this.config.logolink;
  PriceRankIntf priceIntf = new PriceRankIntf();

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
    ArrayList localArrayList1 = localLoopbase.getLoopList();
    if (localArrayList1 == null)
      return paramString1;
    Iterator localIterator = localArrayList1.iterator();
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
      if (paramString3.equals("hotkey"))
      {
        try
        {
          str5 = buildHotKeyContent(paramHashMap, str4, str3);
        }
        catch (SaasApplicationException localSaasApplicationException2)
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
        catch (SaasApplicationException localSaasApplicationException3)
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
        catch (SaasApplicationException localSaasApplicationException4)
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
        catch (SaasApplicationException localSaasApplicationException5)
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
        catch (SaasApplicationException localSaasApplicationException6)
        {
        }
        paramString1 = paramString1.substring(0, paramString1.indexOf(str6)) + str5 + paramString1.substring(paramString1.indexOf(new StringBuilder().append(paramString6).append(paramString2).append(":").append(paramString3).toString()) + paramString6.length() + paramString2.length() + 2 + paramString3.length(), paramString1.length());
      }
      if (paramString3.equals("articlelist"))
      {
        try
        {
          String str7 = "";
          String str8 = "";
          String str9 = "";
          ArrayList localArrayList2 = localLoopbase.getAttrList(str4);
          if ((localLoopbase.getAttrValue(localArrayList2, "recommend") != null) && (!localLoopbase.getAttrValue(localArrayList2, "recommend").equals("")))
            str8 = localLoopbase.getAttrValue(localArrayList2, "recommend");
          if (paramHashMap.get("start_row") != null)
            str7 = paramHashMap.get("start_row").toString();
          if (paramHashMap.get("page_size") != null)
            str9 = paramHashMap.get("page_size").toString();
          if ((!str7.equals("")) && (Integer.parseInt(str7) / Integer.parseInt(str9) > 8) && (!str8.equals("1")) && (!str8.equals("2")))
            str5 = "";
          else
            str5 = buildArticleListContent(paramHashMap, str4, str3);
        }
        catch (SaasApplicationException localSaasApplicationException7)
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
    HashMap localHashMap = new HashMap();
    String str2 = localLoopbase.getAttrValue(paramString1, "row");
    if (str2.equals(""))
      str2 = "10";
    localHashMap.put("row", str2);
    LinkIntf localLinkIntf = new LinkIntf();
    ArrayList localArrayList = localLinkIntf.getLinkListByPage(0, Integer.parseInt(str2));
    str1 = replaceFieldValue(paramString2, localArrayList, localHashMap);
    return str1;
  }

  public String buildHotKeyContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    String str1 = "";
    HashMap localHashMap = new HashMap();
    String str2 = localLoopbase.getAttrValue(paramString1, "row");
    String str3 = localLoopbase.getAttrValue(paramString1, "ch_id");
    if ((str3.equals("")) && (paramHashMap.get("ch_id") != null))
      str3 = paramHashMap.get("ch_id").toString();
    if (str2.equals(""))
      str2 = "10";
    localHashMap.put("row", str2);
    ArrayList localArrayList = this.priceIntf.getPriceRankByChId(str3, Integer.parseInt(str2));
    str1 = replaceFieldValue(paramString2, localArrayList, localHashMap);
    return str1;
  }

  public String buildAreaContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    String str1 = "";
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = localLoopbase.getAttrList(paramString1);
    String str2 = localLoopbase.getAttrValue(localArrayList1, "type");
    String str3 = localLoopbase.getAttrValue(localArrayList1, "row");
    String str4 = localLoopbase.getAttrValue(localArrayList1, "ch_id");
    String str5 = "";
    if ((str4.equals("")) && (paramHashMap.get("ch_id") != null))
      str4 = paramHashMap.get("ch_id").toString();
    if (paramHashMap.get("cont_mod") != null)
      str5 = paramHashMap.get("cont_mod").toString();
    localHashMap.put("ch_id", str4);
    localHashMap.put("cont_mod", str5);
    localHashMap.put("row", str3);
    String str6 = localLoopbase.getAttrValue(localArrayList1, "showtype");
    String str7 = localLoopbase.getAttrValue(localArrayList1, "orderby");
    AreaIntf localAreaIntf = new AreaIntf();
    if ((str2.equals("")) && (paramHashMap.get("area_code") != null))
      str2 = paramHashMap.get("area_code").toString();
    ArrayList localArrayList2 = localAreaIntf.getAreaByParentTag(str2, str7);
    str1 = replaceFieldValue(paramString2, localArrayList2, localHashMap);
    return str1;
  }

  public String buildClassContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    Loopbase localLoopbase = new Loopbase();
    ArrayList localArrayList1 = localLoopbase.getAttrList(paramString1);
    String str1 = "";
    String str2 = "";
    String str3 = localLoopbase.getAttrValue(localArrayList1, "type");
    str2 = localLoopbase.getAttrValue(localArrayList1, "up_class_id");
    if (paramHashMap.get("class_id") != null)
      str2 = paramHashMap.get("class_id").toString();
    if (paramHashMap.get("class_type") != null)
      str3 = paramHashMap.get("class_type").toString();
    HashMap localHashMap = new HashMap();
    String str4 = localLoopbase.getAttrValue(localArrayList1, "row");
    localHashMap.put("row", str4);
    String str5 = localLoopbase.getAttrValue(localArrayList1, "cmodel");
    String str6 = localLoopbase.getAttrValue(localArrayList1, "showtype");
    String str7 = localLoopbase.getAttrValue(localArrayList1, "orderby");
    String str8 = localLoopbase.getAttrValue(localArrayList1, "limit");
    int i = 0;
    int j = 0;
    if (!str8.equals(""))
    {
     String[] localObject=new String[str8.split(",").length];	
      localObject = str8.split(",");
      if ((localObject[0].length() > 0) && (localObject[1].length() > 0))
      {
        i = Integer.parseInt(localObject[0]);
        j = Integer.parseInt(localObject[1]);
      }
      else
      {
        i = 0;
        j = 100;
      }
    }
    else
    {
      i = 0;
      j = 100;
    }
    Object localObject = "";
    if (paramHashMap.get("save_dir") != null)
    {
      if (!paramHashMap.get("save_dir").toString().equals(""))
      {
        localObject = paramHashMap.get("save_dir").toString();
      }
      else
      {
        if (str5.equals("supply"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "1");
        if (str5.equals("product"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "3");
        if (str5.equals("stock"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "2");
        if (str5.equals("enterprise"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "4");
        if (str5.equals("book"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "15");
        if (str5.equals("teambuy"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "10");
      }
    }
    else
    {
      if (str5.equals("supply"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "1");
      if (str5.equals("product"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "3");
      if (str5.equals("stock"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "2");
      if (str5.equals("enterprise"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "4");
      if (str5.equals("book"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "15");
      if (str5.equals("teambuy"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "10");
    }
    if (!((String)localObject).equals(""))
      localHashMap.put("class_save_dir", localObject);
    ProductClassIntf localProductClassIntf = new ProductClassIntf();
    ArrayList localArrayList2 = localProductClassIntf.getProductClassList(i, j, str3, str2);
    str1 = replaceFieldValue(paramString2, localArrayList2, localHashMap);
    return (String)str1;
  }

  public String buildSmallClassContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    Loopbase localLoopbase = new Loopbase();
    ArrayList localArrayList1 = localLoopbase.getAttrList(paramString1);
    String str1 = "";
    HashMap localHashMap = new HashMap();
    String str2 = localLoopbase.getAttrValue(localArrayList1, "type");
    String str3 = localLoopbase.getAttrValue(localArrayList1, "row");
    localHashMap.put("row", str3);
    String str4 = localLoopbase.getAttrValue(localArrayList1, "cmodel");
    String str5 = localLoopbase.getAttrValue(localArrayList1, "showtype");
    String str6 = localLoopbase.getAttrValue(localArrayList1, "orderby");
    String str7 = localLoopbase.getAttrValue(localArrayList1, "up_class_id");
    String str8 = localLoopbase.getAttrValue(localArrayList1, "limit");
    int i = 0;
    int j = 0;
    if (!str8.equals(""))
    {
      String[] localObject=new String[str8.split(",").length];
      localObject = str8.split(",");
      if ((localObject[0].length() > 0) && (localObject[1].length() > 0))
      {
        i = Integer.parseInt(localObject[0]);
        j = Integer.parseInt(localObject[1]);
      }
      else
      {
        i = 0;
        j = 100;
      }
    }
    else
    {
      i = 0;
      j = 100;
    }
    Object localObject = "";
    if (paramHashMap.get("save_dir") != null)
    {
      if (!paramHashMap.get("save_dir").toString().equals(""))
      {
        localObject = paramHashMap.get("save_dir").toString();
      }
      else
      {
        if (str4.equals("supply"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "1");
        if (str4.equals("product"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "3");
        if (str4.equals("stock"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "2");
        if (str4.equals("enterprise"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "4");
        if (str4.equals("book"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "15");
        if (str4.equals("teambuy"))
          localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "10");
      }
    }
    else
    {
      if (str4.equals("supply"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "1");
      if (str4.equals("product"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "3");
      if (str4.equals("stock"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "2");
      if (str4.equals("enterprise"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "4");
      if (str4.equals("book"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "15");
      if (str4.equals("teambuy"))
        localObject = localChannelIntf.getSaveDirByChLevelAndContMod("1", "10");
    }
    if (!((String)localObject).equals(""))
      localHashMap.put("class_save_dir", localObject);
    ProductClassIntf localProductClassIntf = new ProductClassIntf();
    ArrayList localArrayList2 = localProductClassIntf.getProductClassByUpIdPage(i, j, str7);
    str1 = replaceFieldValue(paramString2, localArrayList2, localHashMap);
    return (String)str1;
  }

  public String buildChannelContent(HashMap paramHashMap, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = localLoopbase.getAttrList(paramString1);
    String str1 = "";
    String str2 = "";
    String str3 = "top";
    String str4 = "10";
    String str5 = "";
    String str6 = "";
    int i = 0;
    int j = 0;
    if (paramHashMap.get("ch_id") != null)
      str2 = paramHashMap.get("ch_id").toString();
    if ((localLoopbase.getAttrValue(localArrayList1, "type") != null) && (!localLoopbase.getAttrValue(localArrayList1, "type").equals("")))
      str3 = localLoopbase.getAttrValue(localArrayList1, "type");
    if ((localLoopbase.getAttrValue(localArrayList1, "limit") != null) && (!localLoopbase.getAttrValue(localArrayList1, "limit").equals("")))
      str5 = localLoopbase.getAttrValue(localArrayList1, "limit");
    if ((localLoopbase.getAttrValue(localArrayList1, "ch_id") != null) && (!localLoopbase.getAttrValue(localArrayList1, "ch_id").equals("")))
      str2 = localLoopbase.getAttrValue(localArrayList1, "ch_id");
    if ((localLoopbase.getAttrValue(localArrayList1, "row") != null) && (!localLoopbase.getAttrValue(localArrayList1, "row").equals("")))
      str4 = localLoopbase.getAttrValue(localArrayList1, "row");
    if ((localLoopbase.getAttrValue(localArrayList1, "orderby") != null) && (!localLoopbase.getAttrValue(localArrayList1, "orderby").equals("")))
      str6 = localLoopbase.getAttrValue(localArrayList1, "orderby");
    ArrayList localArrayList2 = new ArrayList();
    localHashMap.put("row", str4);
    ChannelIntf localChannelIntf = new ChannelIntf();
    if (!str5.equals(""))
    {
      String[] arrayOfString = str5.split(",");
      if ((arrayOfString[0].length() > 0) && (arrayOfString[1].length() > 0))
      {
        i = Integer.parseInt(arrayOfString[0]);
        j = Integer.parseInt(arrayOfString[1]);
      }
      else
      {
        i = 0;
        j = Integer.parseInt(str4);
      }
    }
    else
    {
      i = 0;
      j = Integer.parseInt(str4);
    }
    if (str3.equals("top"))
      localArrayList2 = localChannelIntf.getChInfoSon("0000000000", str6, i, j);
    else if (str3.equals("self"))
      localArrayList2 = localChannelIntf.getChInfoSelf(str2, str6, i, j);
    else if (str3.equals("son"))
      localArrayList2 = localChannelIntf.getChInfoSon(str2, str6, i, j);
    str1 = replaceFieldValue(paramString2, localArrayList2, localHashMap);
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
    String str7 = "10";
    String str8 = "in_date";
    String str9 = "20";
    String str10 = "7";
    String str11 = "100";
    String str12 = "text";
    String str13 = "";
    int i = 0;
    int j = 100;
    String str14 = "";
    String str15 = "";
    String str16 = "";
    String str17 = "";
    String str18 = "";
    String str19 = "";
    String str20 = "";
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList1 = localLoopbase.getAttrList(paramString1);
    if ((localLoopbase.getAttrValue(localArrayList1, "ch_id") != null) && (!localLoopbase.getAttrValue(localArrayList1, "ch_id").equals("")))
    {
      str2 = localLoopbase.getAttrValue(localArrayList1, "ch_id");
      localHashMap1.put("ch_id", str2);
    }
    if ((localLoopbase.getAttrValue(localArrayList1, "all") != null) && (!localLoopbase.getAttrValue(localArrayList1, "all").equals("")))
      str18 = localLoopbase.getAttrValue(localArrayList1, "all");
    if ((localLoopbase.getAttrValue(localArrayList1, "recommend") != null) && (!localLoopbase.getAttrValue(localArrayList1, "recommend").equals("")))
      str3 = localLoopbase.getAttrValue(localArrayList1, "recommend");
    if ((localLoopbase.getAttrValue(localArrayList1, "keyword") != null) && (!localLoopbase.getAttrValue(localArrayList1, "keyword").equals("")))
      str4 = localLoopbase.getAttrValue(localArrayList1, "keyword");
    if ((localLoopbase.getAttrValue(localArrayList1, "limit") != null) && (!localLoopbase.getAttrValue(localArrayList1, "limit").equals("")))
      str5 = localLoopbase.getAttrValue(localArrayList1, "limit");
    if ((localLoopbase.getAttrValue(localArrayList1, "area_code") != null) && (!localLoopbase.getAttrValue(localArrayList1, "area_code").equals("")))
      str16 = localLoopbase.getAttrValue(localArrayList1, "area_code");
    if ((localLoopbase.getAttrValue(localArrayList1, "class_id") != null) && (!localLoopbase.getAttrValue(localArrayList1, "class_id").equals("")))
      str20 = localLoopbase.getAttrValue(localArrayList1, "class_id");
    if ((localLoopbase.getAttrValue(localArrayList1, "pub") != null) && (!localLoopbase.getAttrValue(localArrayList1, "pub").equals("")))
      str6 = localLoopbase.getAttrValue(localArrayList1, "pub");
    if ((localLoopbase.getAttrValue(localArrayList1, "row") != null) && (!localLoopbase.getAttrValue(localArrayList1, "row").equals("")))
    {
      str7 = localLoopbase.getAttrValue(localArrayList1, "row");
      localHashMap1.put("row", str7);
    }
    if ((localLoopbase.getAttrValue(localArrayList1, "imgwidth") != null) && (!localLoopbase.getAttrValue(localArrayList1, "imgwidth").equals("")))
    {
      str14 = localLoopbase.getAttrValue(localArrayList1, "imgwidth");
      localHashMap1.put("imgwidth", str14);
    }
    if ((localLoopbase.getAttrValue(localArrayList1, "imgheight") != null) && (!localLoopbase.getAttrValue(localArrayList1, "imgheight").equals("")))
    {
      str15 = localLoopbase.getAttrValue(localArrayList1, "imgheight");
      localHashMap1.put("imgheight", str15);
    }
    if ((localLoopbase.getAttrValue(localArrayList1, "orderby") != null) && (!localLoopbase.getAttrValue(localArrayList1, "orderby").equals("")))
      str8 = localLoopbase.getAttrValue(localArrayList1, "orderby");
    if ((localLoopbase.getAttrValue(localArrayList1, "titlelen") != null) && (!localLoopbase.getAttrValue(localArrayList1, "titlelen").equals("")))
    {
      str9 = localLoopbase.getAttrValue(localArrayList1, "titlelen");
      localHashMap1.put("titlelen", str9);
    }
    if ((localLoopbase.getAttrValue(localArrayList1, "adrlen") != null) && (!localLoopbase.getAttrValue(localArrayList1, "adrlen").equals("")))
    {
      str10 = localLoopbase.getAttrValue(localArrayList1, "adrlen");
      localHashMap1.put("adrlen", str10);
    }
    if ((localLoopbase.getAttrValue(localArrayList1, "infolen") != null) && (!localLoopbase.getAttrValue(localArrayList1, "infolen").equals("")))
    {
      str11 = localLoopbase.getAttrValue(localArrayList1, "infolen");
      localHashMap1.put("infolen", str11);
    }
    if ((localLoopbase.getAttrValue(localArrayList1, "showtype") != null) && (!localLoopbase.getAttrValue(localArrayList1, "showtype").equals("")))
      str12 = localLoopbase.getAttrValue(localArrayList1, "showtype");
    if ((localLoopbase.getAttrValue(localArrayList1, "cmodel") != null) && (!localLoopbase.getAttrValue(localArrayList1, "cmodel").equals("")))
      str13 = localLoopbase.getAttrValue(localArrayList1, "cmodel");
    ArrayList localArrayList2 = new ArrayList();
    InfoIntf localInfoIntf = new InfoIntf();
    if (((str2.equals("")) || (str2 == null)) && (paramHashMap.get("ch_id") != null))
      str2 = paramHashMap.get("ch_id").toString();
    ChannelIntf localChannelIntf = new ChannelIntf();
    if (!str2.equals(""))
    {
    	 
      HashMap localObject = localChannelIntf.getChInfo(str2);
      if (localObject != null)
      {
        if (((HashMap)localObject).get("save_dir") != null)
          str17 = ((HashMap)localObject).get("save_dir").toString();
        if (((HashMap)localObject).get("cont_mod") != null)
          str19 = ((HashMap)localObject).get("cont_mod").toString();
      }
    }
    localHashMap1.put("save_dir", str17);
    if (paramHashMap.get("area_code") != null)
      str16 = paramHashMap.get("area_code").toString();
    if (paramHashMap.get("class_id") != null)
      str20 = paramHashMap.get("class_id").toString();
    localHashMap1.put("area_code", str16);
    if ((paramHashMap.get("start_row") != null) && (!paramHashMap.get("start_row").toString().equals("0")))
    {
      i = Integer.parseInt(paramHashMap.get("start_row").toString());
      j = Integer.parseInt(paramHashMap.get("page_size").toString());
    }
    else if (!str5.equals(""))
    {
    String[] localObject=new String[str5.split(",").length];
      localObject = str5.split(",");
      if ((localObject[0].length() > 0) && (localObject[1].length() > 0))
      {
        i = Integer.parseInt(localObject[0]);
        j = Integer.parseInt(localObject[1]);
      }
      else
      {
        i = 0;
        j = Integer.parseInt(str7);
      }
    }
    else
    {
      i = 0;
      j = Integer.parseInt(str7);
    }
    if (Integer.parseInt(str7) < j)
      j = Integer.parseInt(str7);
    localHashMap1.put("page", Integer.valueOf(j));
    Object localObject = "";
    if ((str8.equals("user")) || (localLoopbase.getAttrValue(localArrayList1, "orderby").equals("")))
    {
      HashMap localHashMap2 = localChannelIntf.getChInfo(str2);
      if ((localHashMap2 != null) && (localHashMap2.get("list_type") != null))
        localObject = localHashMap2.get("list_type").toString();
      if (((String)localObject).equals("0"))
        localArrayList2 = localInfoIntf.getInfoListByIndate(i, j, str2, str6, str4, str13, str3);
      if (((String)localObject).equals("1"))
        localArrayList2 = localInfoIntf.getInfoListByPublevel(i, j, str2, str4, str13, str3);
    }
    if (str8.equals("indate"))
      localArrayList2 = localInfoIntf.getInfoListByIndate(i, j, str2, str6, str4, str13, str3);
    if (str8.equals("hot"))
      localArrayList2 = localInfoIntf.getInfoListByHot(i, j, str2, str6, str4, str13, str3);
    if (str8.equals("publevel"))
      localArrayList2 = localInfoIntf.getInfoListByPublevel(i, j, str2, str4, str13, str3);
    if ((!str16.equals("")) && (str20.equals("000000000000000")))
      localArrayList2 = localInfoIntf.getInfoListByAreaCode(i, j, str2, str16, str19);
    if ((str16.equals("5J2mc0X0G85BH")) && (!str20.equals("")))
      localArrayList2 = localInfoIntf.getInfoListByClassIdByLimit(i, j, str2, str20, str19);
    if (str18.equals("news"))
      localArrayList2 = localInfoIntf.getInfoListByAllNews(i, j);
    if (str3.equals("2"))
      localArrayList2 = this.priceIntf.getPriceRankByChId(str2, Integer.parseInt(str7));
    str1 = replaceFieldValue(paramString2, localArrayList2, localHashMap1);
    return (String)str1;
  }

  public String replaceFieldValue(String paramString, ArrayList paramArrayList, HashMap paramHashMap)
    throws SaasApplicationException
  {
    Loopbase localLoopbase = new Loopbase();
    ChannelIntf localChannelIntf = new ChannelIntf();
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
    if (paramHashMap != null)
    {
      if (paramHashMap.get("row") != null)
        i = Integer.parseInt(paramHashMap.get("row").toString());
      if (paramHashMap.get("cont_mod") != null)
        str2 = paramHashMap.get("cont_mod").toString();
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
        str3 = paramHashMap.get("area_code").toString();
      if (paramHashMap.get("save_dir") != null)
        str4 = paramHashMap.get("save_dir").toString();
      if (paramHashMap.get("ch_id") != null)
        str5 = paramHashMap.get("ch_id").toString();
      if (paramHashMap.get("class_save_dir") != null)
        str6 = paramHashMap.get("class_save_dir").toString();
    }
    if (paramArrayList == null)
      return "";
    ConfigurationMgr localConfigurationMgr = new ConfigurationMgr();
    ArrayList localArrayList = localConfigurationMgr.getConfiguration("2");
    String str7 = "";
    if (localArrayList != null)
    {
      Object localObject1 = (HashMap)localArrayList.get(0);
      if (((HashMap)localObject1).get("para_code1") != null)
        str7 = ((HashMap)localObject1).get("para_code1").toString();
    }
    Object localObject1 = new ArrayList();
    localObject1 = localLoopbase.getFieldList(paramString);
    for (int i2 = 0; (i2 < paramArrayList.size()) && (i2 < i); i2++)
    {
      HashMap localHashMap1 = (HashMap)paramArrayList.get(i2);
      str1 = str1 + "\n";
      str1 = str1 + paramString;
      if (localHashMap1 == null)
        continue;
      String str8 = "";
      Object localObject2 = "";
      for (int i3 = 0; i3 < localHashMap1.size(); i3++)
      {
       Object localObject3 = getMapKey(localHashMap1, i3);
       Object localHashMap3 = localLoopbase.getFieldname((ArrayList)localObject1, (String)localObject3);
        if ((HashMap)((HashMap) localHashMap3).get("tagstr") != null)
          str8 =(String) ((HashMap) localHashMap3).get("tagstr").toString();
        if (!((HashMap) localHashMap3).containsValue(localObject3))
          continue;
        if ((!((String)localObject3).equals("")) && (((String)localObject3).equals("title")) && (j != 0) && (localHashMap1.get(localObject3) != null))
        {
          localObject2 = localHashMap1.get(localObject3).toString();
          if (((String)localObject2).length() > j)
            localObject2 = ((String)localObject2).substring(0, j) + "...";
         Object  localObject4 = "";
          if (localHashMap1.get("contents") != null)
            localObject4 = localHashMap1.get("contents").toString();
           Object localObject5 = "";
          if (localHashMap1.get("title_color") != null)
          {
            localObject5 = localHashMap1.get("title_color").toString();
            if (!((String)localObject5).equals(""))
              localObject2 = "<font style=color:" + (String)localObject5 + ">" + (String)localObject2 + "</font>";
          }
          if ((((String)localObject4).equals("01")) || (((String)localObject4).equals("11")))
            localObject2 = "<b>" + (String)localObject2 + "</b>";
          str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
        else if ((!((String)localObject3).equals("")) && (((String)localObject3).equals("content")) && (m != 0) && (localHashMap1.get(localObject3) != null))
        {
          localObject2 = localHashMap1.get(localObject3).toString();
          localObject2 = ((String)localObject2).replaceAll("&nbsp;", "");
          localObject2 = ((String)localObject2).replaceAll("<[^<>]+>", "");
          localObject2 = ((String)localObject2).replaceAll("<A", "");
          localObject2 = ((String)localObject2).replaceAll("<a", "");
          if (((String)localObject2).length() > m)
            localObject2 = ((String)localObject2).substring(0, m) + "...";
          str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
        else
        {
          if (localHashMap1.get(localObject3) != null)
            localObject2 = localHashMap1.get(localObject3).toString();
          str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      HashMap localHashMap2 = localLoopbase.getFieldname((ArrayList)localObject1, "arcurl");
      if ((localHashMap2 != null) && (localHashMap2.containsValue("arcurl")))
      {
        str8 = localHashMap2.get("tagstr").toString();
        if ((localHashMap1.get("info_id") != null) && (localHashMap1.get("in_date") != null))
        {
         Object localObject3 = "";
          if (str7.equals("1"))
          {
            localObject3 = localHashMap1.get("in_date").toString();
          }
          else if (str7.equals("2"))
          {
            localObject3 = localHashMap1.get("in_date").toString();
            if (((String)localObject3).length() > 7)
              localObject3 = ((String)localObject3).substring(0, 7);
          }
          else if (str7.equals("3"))
          {
            localObject3 = localHashMap1.get("in_date").toString();
            if (((String)localObject3).length() > 4)
              localObject3 = ((String)localObject3).substring(0, 4);
          }
          localObject2 = "/" + str4 + "/d/" + (String)localObject3 + "/content-" + localHashMap1.get("info_id").toString() + ".html";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject3 = localLoopbase.getFieldname((ArrayList)localObject1, "small_class_path");
      if ((localObject3 != null) && (((HashMap)localObject3).containsValue("small_class_path")))
      {
        str8 = ((HashMap)localObject3).get("tagstr").toString();
        if (localHashMap1.get("small_class_id") != null)
        {
          localObject2 = "/" + str6 + "/class/" + localHashMap1.get("small_class_id").toString() + "/";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      HashMap localHashMap3 = localLoopbase.getFieldname((ArrayList)localObject1, "class_path");
      if ((localHashMap3 != null) && (localHashMap3.containsValue("class_path")))
      {
        str8 = localHashMap3.get("tagstr").toString();
        if (localHashMap1.get("class_id") != null)
        {
          localObject2 = "/" + str6 + "/class/" + localHashMap1.get("class_id").toString() + "/";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject4 = localLoopbase.getFieldname((ArrayList)localObject1, "class_num");
      if ((localObject4 != null) && (((HashMap)localObject4).containsValue("class_num")))
      {
        str8 = ((HashMap)localObject4).get("tagstr").toString();
        if (localHashMap1.get("class_id") != null)
        {
        Object  localObject5 = this.calalogInfo.getFristClassNum(localHashMap1.get("class_id").toString());
          if (!((String)localObject5).equals(""))
            localObject2 = "(" + (String)localObject5 + ")";
          else
            localObject2 = "(0)";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject5 = new Custinfo();
      HashMap localHashMap4 = localLoopbase.getFieldname((ArrayList)localObject1, "cust_area");
      if ((localHashMap4 != null) && (localHashMap4.containsValue("cust_area")))
      {
        str8 = localHashMap4.get("tagstr").toString();
        if (localHashMap1.get("info_id") != null)
        {
         Object localObject6 = localHashMap1.get("info_id").toString();
          Object localObject7 = ((Custinfo)localObject5).getAreaNameByCustId((String)localObject6);
          if (((String)localObject7).equals(""))
            localObject2 = "[鏈�夊畾鍦板尯]";
          else
            localObject2 = "[" + (String)localObject7 + "]";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject6 = new Attachinfo();
      Object localObject7 = localLoopbase.getFieldname((ArrayList)localObject1, "vedio_img");
      if ((localObject7 != null) && (((HashMap)localObject7).containsValue("vedio_img")))
      {
        str8 = ((HashMap)localObject7).get("tagstr").toString();
        if (localHashMap1.get("info_id") != null)
        {
         Object localObject8 = ((Attachinfo)localObject6).getPicFilePath(localHashMap1.get("info_id").toString());
          if (((String)localObject8).equals(""))
            localObject2 = "<img src=" + this.default_img + " border=0 width=" + n + " height=" + i1 + ">";
          else
            localObject2 = "<img src=" + (String)localObject8 + " border=0 width=" + n + " height=" + i1 + ">";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject8 = localLoopbase.getFieldname((ArrayList)localObject1, "teambuy_enddate");
      if ((localObject8 != null) && (((HashMap)localObject8).containsValue("teambuy_enddate")))
      {
        str8 = ((HashMap)localObject8).get("tagstr").toString();
        if (localHashMap1.get("end_date") != null)
        {
         Object localObject9 = localHashMap1.get("end_date").toString();
         Object localObject10 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
          if (((String)localObject9).compareTo((String)localObject10) > 0)
            localObject2 = "姝ｅ湪鍙泦";
          else
            localObject2 = "娲诲姩宸茬粨鏉�";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject9 = localLoopbase.getFieldname((ArrayList)localObject1, "info_classurl");
      if ((localObject9 != null) && (((HashMap)localObject9).containsValue("info_classurl")))
      {
        str8 = ((HashMap)localObject9).get("tagstr").toString();
        if ((localHashMap1.get("info_id") != null) && (!localHashMap1.get("info_id").toString().equals("")))
        {
         Object localObject10 = localHashMap1.get("info_id").toString();
          localObject2 = this.calalogInfo.getClassNameByRootId((String)localObject10);
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject10 = localLoopbase.getFieldname((ArrayList)localObject1, "newsurl");
      if ((localObject10 != null) && (((HashMap)localObject10).containsValue("newsurl")))
      {
        str8 = ((HashMap)localObject10).get("tagstr").toString();
        if (localHashMap1.get("info_id") != null)
        {
         Object localObject11 = localHashMap1.get("info_id").toString();
         Object localObject12 = localInfoIntf.getChannelSaveDirByInfoId((String)localObject11);
          localObject2 = "/" + (String)localObject12 + "/d/content-" + localHashMap1.get("info_id").toString() + ".html";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject11 = localLoopbase.getFieldname((ArrayList)localObject1, "moreurl");
      if ((localObject11 != null) && (((HashMap)localObject11).containsValue("moreurl")))
      {
        str8 = ((HashMap)localObject11).get("tagstr").toString();
        if (localHashMap1.get("save_dir") != null)
        {
          localObject2 = "/" + localHashMap1.get("save_dir").toString() + "/list";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject12 = localLoopbase.getFieldname((ArrayList)localObject1, "num");
      if ((localObject12 != null) && (((HashMap)localObject12).containsValue("num")))
      {
        str8 = ((HashMap)localObject12).get("tagstr").toString();
        localObject2 = String.valueOf(i2);
        if (!str8.equals(""))
          str1 = StrReplace.replace(str1, str8, (String)localObject2);
      }
      HashMap localHashMap5 = localLoopbase.getFieldname((ArrayList)localObject1, "areaurl");
      if ((localHashMap5 != null) && (localHashMap5.containsValue("areaurl")))
      {
        str8 = localHashMap5.get("tagstr").toString();
        Object localObject13 = localHashMap1.get("save_dir").toString();
        localObject2 = "/" + (String)localObject13 + "/area/" + localHashMap1.get("area_code").toString() + "/";
        if (!str8.equals(""))
          str1 = StrReplace.replace(str1, str8, (String)localObject2);
      }
      Object localObject13 = localLoopbase.getFieldname((ArrayList)localObject1, "imgurl");
      if ((localObject13 != null) && (((HashMap)localObject13).containsValue("imgurl")))
      {
        str8 = ((HashMap)localObject13).get("tagstr").toString();
        if (localHashMap1.get("mini_img") != null)
        {
          if (localHashMap1.get("mini_img").toString().equals(""))
            localObject2 = "<img src=" + this.default_img + " border=0 width=" + n + " height=" + i1 + ">";
          else
            localObject2 = "<img src=" + localHashMap1.get("mini_img").toString() + " border=0 width=" + n + " height=" + i1 + ">";
        }
        else
          localObject2 = "<img src=/images/default_wood.gif border=0 width=" + n + " height=" + i1 + ">";
        if (!str8.equals(""))
          str1 = StrReplace.replace(str1, str8, (String)localObject2);
      }
      HashMap localHashMap6 = localLoopbase.getFieldname((ArrayList)localObject1, "classimg");
      if (localHashMap6 != null)
      {
       Object localObject14 = "";
        if (localHashMap1.get("class_id") != null)
          localObject14 = localHashMap1.get("class_id").toString();
        if (localHashMap6.containsValue("classimg"))
        {
          str8 = localHashMap6.get("tagstr").toString();
        Object  localObject15 = new Attachinfo();
        Object localObject16 = ((Attachinfo)localObject15).getFilePathClass((String)localObject14);
          if (!((String)localObject16).equals(""))
            localObject2 = localObject16;
          else
            localObject2 = "/images/default_wood.gif";
          if (!str8.equals(""))
            str1 = StrReplace.replace(str1, str8, (String)localObject2);
        }
      }
      Object localObject14 = localLoopbase.getFieldname((ArrayList)localObject1, "churl");
      if ((localObject14 == null) || (!((HashMap)localObject14).containsValue("churl")))
        continue;
      str8 = ((HashMap)localObject14).get("tagstr").toString();
      Object localObject15 = localHashMap1.get("save_dir").toString();
      Object localObject16 = ((String)localObject15).split("/");
      String[] arrayOfString = this.logolink.split("\\.");
      if (localHashMap1.get("ch_attr") != null)
      {
        if ((localHashMap1.get("ch_attr").toString().equals("0")) || (localHashMap1.get("ch_attr").toString().equals("1")))
          localObject2 = "/" + localHashMap1.get("save_dir").toString() + "/" + localHashMap1.get("default_page").toString();
        if ((localHashMap1.get("ch_attr").toString().equals("2")) || (localHashMap1.get("ch_attr").toString().equals("3")))
          localObject2 = localHashMap1.get("default_page").toString();
      }
      str1 = StrReplace.replace(str1, str8, (String)localObject2);
    }
    return (String)(String)(String)(String)(String)(String)(String)(String)(String)(String)(String)(String)(String)(String)(String)(String)str1;
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
}

/* Location:           D:\project\浠ｇ爜\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.ParseLoop
 * JD-Core Version:    0.6.0
 */