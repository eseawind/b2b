package com.buildhtml;

import com.saas.biz.channelColumnMgr.ChannelColumnInfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.intf.AreaIntf;
import com.saas.intf.CustChannelIntf;
import com.saas.intf.InfoIntf;
import com.saas.intf.ProductClassIntf;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.FileIO;

public class CustCreateChannel
{
  public static Logger log;
  public static FileAndString FileString;
  public static Config config;
  public static commMethodMgr comm;
  public static String ecms_path;
  public static String user_templates_path;
  public static String baseurl;
  public static String cache_path;
  public static String cache_file;
  public static String html_file;
  public static String ch_path;
  public static String cache_file_path;

  public CustCreateChannel()
  {
    log = new Logger(this);
  }

  public static void main(String[] paramArrayOfString)
  {
    try
    {
      CreateChannelIndexList("0000000000", "cmq0BFnEjh674s6");
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public static void CreateChannelIndexList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelColumnInfo localChannelColumnInfo = new ChannelColumnInfo();
    CreateChannelIndex(paramString1, paramString2);
    CreateChannelList(paramString1, paramString2);
    ArrayList localArrayList = localChannelColumnInfo.getChSon(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("ch_id") == null)
          continue;
        CreateChannelIndexList(localHashMap.get("ch_id").toString(), paramString2);
        CreateChannelList(localHashMap.get("ch_id").toString(), paramString2);
      }
  }

  public static void CreateChannelIndex(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    AreaIntf localAreaIntf = new AreaIntf();
    ProductClassIntf localProductClassIntf = new ProductClassIntf();
    InfoIntf localInfoIntf = new InfoIntf();
    CustChannelIntf localCustChannelIntf = new CustChannelIntf();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localArrayList2 = localAreaIntf.getAreaByParentTag("5J2mc0X0G85BH", "");
    try
    {
      localArrayList1 = localCustChannelIntf.getChannelList(paramString1, paramString2);
    }
    catch (Exception localException1)
    {
      throw new RuntimeException(localException1);
    }
    FileString = new FileAndString();
    config = new Config();
    comm = new commMethodMgr();
    Config localConfig = new Config();
    if (localArrayList1 != null)
    {
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap1 = (HashMap)localIterator.next();
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        if (localHashMap1.get("ch_id") != null)
          str2 = localHashMap1.get("ch_id").toString();
        if (localHashMap1.get("cont_mod") != null)
          str8 = localHashMap1.get("cont_mod").toString();
        if (localHashMap1.get("ch_name") != null)
          str1 = localHashMap1.get("ch_name").toString();
        if (localHashMap1.get("save_dir") != null)
          str7 = localHashMap1.get("save_dir").toString();
        if (localHashMap1.get("index_temp") != null)
          str4 = localHashMap1.get("index_temp").toString();
        if (localHashMap1.get("list_temp") != null)
          str5 = localHashMap1.get("list_temp").toString();
        if (localHashMap1.get("default_page") != null)
          str6 = localHashMap1.get("default_page").toString();
        String str9 = "";
        localArrayList3 = localInfoIntf.getCustClassByCustId(paramString2, str8);
        ecms_path = localConfig.ecms_path;
        baseurl = localConfig.baseurl;
        user_templates_path = localConfig.ecms_path + str4;
        String str10 = localConfig.ecms_path + "Cache/" + str7 + "/";
        cache_file = "";
        cache_file_path = "";
        String str11 = "";
        html_file = localConfig.ecms_path + str7 + "/" + str6;
        ch_path = localConfig.ecms_path + str7 + "/";
        CacheFiles(str10);
        str11 = FileIO.LoadFile(cache_file_path);
        try
        {
          System.out.println("正在解析[" + str1 + "]模板，请稍后...");
          localHashMap1.put("cust_id", paramString2);
          parseContent(str11, cache_file_path, localHashMap1, 0, 100);
          System.out.println("正在生成[" + str1 + "]分类列表，请稍后...");
          if ((CheckTag("classlist", str11)) && (!str5.equals("")) && (localArrayList3 != null))
            for (int i = 0; i < localArrayList3.size(); i++)
            {
              HashMap localHashMap2 = (HashMap)localArrayList3.get(i);
              String str12 = "";
              if (localHashMap2.get("class_id") != null)
                str12 = localHashMap2.get("class_id").toString();
              localHashMap1.put("class_id", str12);
              CreateAreaInfoList(localHashMap1, "2");
            }
          System.out.println("生成[" + str1 + "]分类列表结束");
          System.out.println("正在生成[" + str1 + "]频道分页首页，请稍后...");
          if ((CheckTag("listpage", str11)) && (!str5.equals("")))
            CreateInfoIndexList(localHashMap1);
          System.out.println("生成[" + str1 + "]频道分页首页结束");
        }
        catch (Exception localException2)
        {
          throw new RuntimeException(localException2);
        }
      }
    }
  }

  public static void LoopAreaList(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    AreaIntf localAreaIntf = new AreaIntf();
    paramHashMap.put("area_code", paramString);
    paramHashMap.put("class_id", "000000000000000");
    CreateAreaInfoList(paramHashMap, "1");
  }

  public static void LoopClassList(String paramString1, HashMap paramHashMap, String paramString2)
    throws SaasApplicationException
  {
    ProductClassIntf localProductClassIntf = new ProductClassIntf();
    paramHashMap.put("class_id", paramString1);
    paramHashMap.put("class_type", paramString2);
    paramHashMap.put("area_code", "5J2mc0X0G85BH");
    CreateAreaInfoList(paramHashMap, "2");
    ArrayList localArrayList = new ArrayList();
    localArrayList = localProductClassIntf.getProductAllClassIdByUp(paramString1, paramString2);
    if (localArrayList != null)
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("class_id") == null)
          continue;
        LoopClassList(localHashMap.get("class_id").toString(), paramHashMap, paramString2);
      }
  }

  public static void CreateChannelList(String paramString1, String paramString2)
  {
    CustChannelIntf localCustChannelIntf = new CustChannelIntf();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList = localCustChannelIntf.getChannelList(paramString1, paramString2);
    }
    catch (Exception localException1)
    {
      throw new RuntimeException(localException1);
    }
    FileString = new FileAndString();
    config = new Config();
    comm = new commMethodMgr();
    Config localConfig = new Config();
    if (localArrayList != null)
    {
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
        String str7 = "";
        if (localHashMap.get("ch_id") != null)
          str2 = localHashMap.get("ch_id").toString();
        if (localHashMap.get("ch_name") != null)
          str1 = localHashMap.get("ch_name").toString();
        if (localHashMap.get("save_dir") != null)
          str7 = localHashMap.get("save_dir").toString();
        if (localHashMap.get("index_temp") != null)
          str4 = localHashMap.get("index_temp").toString();
        if (localHashMap.get("list_temp") != null)
          str5 = localHashMap.get("list_temp").toString();
        if (localHashMap.get("default_page") != null)
          str6 = localHashMap.get("default_page").toString();
        ecms_path = localConfig.ecms_path;
        baseurl = localConfig.baseurl;
        user_templates_path = localConfig.ecms_path + str5;
        String str8 = localConfig.ecms_path + "Cache/" + str7 + "/";
        cache_file = "";
        cache_file_path = "";
        String str9 = "";
        html_file = localConfig.ecms_path + "/" + str7 + "/list/" + str6;
        ch_path = localConfig.ecms_path + "/" + str7 + "/list/";
        CacheFiles(str8);
        str9 = FileIO.LoadFile(cache_file_path);
        CustParseNoneLoop localCustParseNoneLoop = new CustParseNoneLoop();
        CustParseLoop localCustParseLoop = new CustParseLoop();
        ParseThis localParseThis = new ParseThis();
        try
        {
          System.out.println("正在解析[" + str1 + "]模板，请稍后...");
          parseContent(str9, cache_file_path, localHashMap, 0, 100);
          System.out.println("生成[" + str1 + "]栏目首页结束\n");
          if ((CheckTag("listpage", str9)) && (!str5.equals("")))
            CreateInfoList(localHashMap);
        }
        catch (Exception localException2)
        {
          throw new RuntimeException(localException2);
        }
      }
    }
  }

  public static void CreateInfoList(HashMap paramHashMap)
  {
    if (paramHashMap == null)
      return;
    InfoIntf localInfoIntf = new InfoIntf();
    Config localConfig = new Config();
    String str1 = "";
    if (paramHashMap.get("list_temp") != null)
      str1 = paramHashMap.get("list_temp").toString();
    String str2 = localConfig.ecms_path + str1;
    String str3 = FileIO.LoadFile(str2);
    CustParseNoneLoop localCustParseNoneLoop = new CustParseNoneLoop();
    String str4 = localCustParseNoneLoop.getListpage(str3);
    String str5 = "";
    String str6 = str4;
    int i = 0;
    int j = 1;
    int k = 0;
    if (paramHashMap.get("ch_id") != null)
      str5 = paramHashMap.get("ch_id").toString();
    try
    {
      k = localInfoIntf.getInfoCount(str5);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    while (i < k)
    {
      BuildInfoList(paramHashMap, i, Integer.parseInt(str6), j, "0");
      i += Integer.parseInt(str6);
      j += 1;
    }
  }

  public static void CreateInfoIndexList(HashMap paramHashMap)
  {
    if (paramHashMap == null)
      return;
    paramHashMap.put("class_id", "");
    InfoIntf localInfoIntf = new InfoIntf();
    Config localConfig = new Config();
    String str1 = "";
    if (paramHashMap.get("index_temp") != null)
      str1 = paramHashMap.get("index_temp").toString();
    String str2 = localConfig.ecms_path + str1;
    String str3 = FileIO.LoadFile(str2);
    CustParseNoneLoop localCustParseNoneLoop = new CustParseNoneLoop();
    String str4 = localCustParseNoneLoop.getListpage(str3);
    String str5 = "";
    String str6 = str4;
    int i = 0;
    int j = 1;
    int k = 0;
    if (paramHashMap.get("ch_id") != null)
      str5 = paramHashMap.get("ch_id").toString();
    try
    {
      k = localInfoIntf.getInfoCount(str5);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    while (i < k)
    {
      BuildInfoList(paramHashMap, i, Integer.parseInt(str6), j, "1");
      i += Integer.parseInt(str6);
      j += 1;
    }
  }

  public static void CreateAreaInfoList(HashMap paramHashMap, String paramString)
  {
    if (paramHashMap == null)
      return;
    InfoIntf localInfoIntf = new InfoIntf();
    Config localConfig = new Config();
    String str1 = "";
    String str2 = "";
    if (paramHashMap.get("list_temp") != null)
      str1 = paramHashMap.get("list_temp").toString();
    String str3 = localConfig.ecms_path + str1;
    String str4 = FileIO.LoadFile(str3);
    CustParseNoneLoop localCustParseNoneLoop = new CustParseNoneLoop();
    String str5 = localCustParseNoneLoop.getListpage(str4);
    String str6 = "";
    String str7 = str5;
    int i = 0;
    int j = 1;
    int k = 0;
    int m = 0;
    int n = 100;
    String str8 = "";
    String str9 = "";
    if (paramHashMap.get("area_code") != null)
      str8 = paramHashMap.get("area_code").toString();
    if (paramHashMap.get("class_id") != null)
      str9 = paramHashMap.get("class_id").toString();
    if (paramHashMap.get("cont_mod") != null)
      str2 = paramHashMap.get("cont_mod").toString();
    if (paramHashMap.get("ch_id") != null)
      str6 = paramHashMap.get("ch_id").toString();
    try
    {
      k = localInfoIntf.getInfoCount(str6);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    String str10 = "";
    if (paramString.equals("1"))
      str10 = "2";
    if (paramString.equals("2"))
      str10 = "3";
    while (i < k)
    {
      BuildInfoList(paramHashMap, i, Integer.parseInt(str7), j, str10);
      i += Integer.parseInt(str7);
      j += 1;
    }
  }

  public static void BuildInfoList(HashMap paramHashMap, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    FileString = new FileAndString();
    config = new Config();
    comm = new commMethodMgr();
    Config localConfig = new Config();
    if (paramHashMap != null)
    {
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str7 = "";
      String str8 = "";
      String str9 = "";
      if (paramHashMap.get("ch_id") != null)
        str2 = paramHashMap.get("ch_id").toString();
      if (paramHashMap.get("area_code") != null)
        str8 = paramHashMap.get("area_code").toString();
      if (paramHashMap.get("class_id") != null)
        str9 = paramHashMap.get("class_id").toString();
      if (paramHashMap.get("ch_name") != null)
        str1 = paramHashMap.get("ch_name").toString();
      if (paramHashMap.get("save_dir") != null)
        str7 = paramHashMap.get("save_dir").toString();
      if (paramHashMap.get("index_temp") != null)
        str4 = paramHashMap.get("index_temp").toString();
      if ((paramString.equals("0")) || (paramString.equals("2")))
      {
        if (paramHashMap.get("list_temp") != null)
        {
          str5 = paramHashMap.get("list_temp").toString();
          if (str5.equals(""))
            return;
        }
        else
        {
          return;
        }
      }
      else if (paramString.equals("1"))
      {
        if (paramHashMap.get("index_temp") != null)
        {
          str5 = paramHashMap.get("index_temp").toString();
          if (str5.equals(""))
            return;
        }
        else
        {
          return;
        }
      }
      else if (paramString.equals("3"))
        if (paramHashMap.get("list_temp") != null)
        {
          str5 = paramHashMap.get("list_temp").toString();
          if (str5.equals(""))
            return;
        }
        else
        {
          return;
        }
      if (paramHashMap.get("default_page") != null)
        str6 = paramHashMap.get("default_page").toString();
      ecms_path = localConfig.ecms_path;
      baseurl = localConfig.baseurl;
      user_templates_path = localConfig.ecms_path + str5;
      String str10 = localConfig.ecms_path + "Cache/" + str7 + "/";
      cache_file = "";
      cache_file_path = "";
      String str11 = "";
      if (paramString.equals("0"))
      {
        if (paramInt3 == 1)
          html_file = localConfig.ecms_path + "/" + str7 + "/list/" + str6;
        else
          html_file = localConfig.ecms_path + "/" + str7 + "/list/" + paramInt3 + ".html";
        ch_path = localConfig.ecms_path + "/" + str7 + "/list/";
      }
      else if (paramString.equals("1"))
      {
        if (paramInt3 == 1)
          html_file = localConfig.ecms_path + "/" + str7 + "/" + str6;
        else
          html_file = localConfig.ecms_path + "/" + str7 + "/" + paramInt3 + ".html";
        ch_path = localConfig.ecms_path + "/" + str7 + "/";
      }
      else if (paramString.equals("2"))
      {
        if (paramInt3 == 1)
          html_file = localConfig.ecms_path + "/" + str7 + "/area/" + str8 + "/" + str6;
        else
          html_file = localConfig.ecms_path + "/" + str7 + "/area/" + str8 + "/" + paramInt3 + ".html";
        ch_path = localConfig.ecms_path + "/" + str7 + "/area/" + str8 + "/";
      }
      else if (paramString.equals("3"))
      {
        if (paramInt3 == 1)
          html_file = localConfig.ecms_path + "/" + str7 + "/class/" + str9 + "/" + str6;
        else
          html_file = localConfig.ecms_path + "/" + str7 + "/class/" + str9 + "/" + paramInt3 + ".html";
        ch_path = localConfig.ecms_path + "/" + str7 + "/class/" + str9 + "/";
      }
      CacheFiles(str10);
      str11 = FileIO.LoadFile(cache_file_path);
      parseContent(str11, cache_file_path, paramHashMap, paramInt1, paramInt2);
    }
  }

  public static void parseContent(String paramString1, String paramString2, HashMap paramHashMap, int paramInt1, int paramInt2)
  {
    CustParseNoneLoop localCustParseNoneLoop = new CustParseNoneLoop();
    CustParseLoop localCustParseLoop = new CustParseLoop();
    ParseThis localParseThis = new ParseThis();
    try
    {
      if (CheckTag("this", paramString1))
      {
        localParseThis.setCacheFile(paramString2);
        paramString1 = localParseThis.buildthis(paramString1, paramHashMap);
      }
      localCustParseNoneLoop.setCacheFile(paramString2);
      paramString1 = localCustParseNoneLoop.buildBase(paramString1);
      paramString1 = localCustParseNoneLoop.buildInclude(paramString1);
      if (CheckTag("infofield", paramString1))
        paramString1 = localCustParseNoneLoop.buildInfoSingle(paramString1);
      if (CheckTag("listpage", paramString1))
        paramString1 = localCustParseNoneLoop.buildListpage(paramString1, paramHashMap);
      localCustParseLoop.setCacheFile(paramString2);
      if (CheckTag("friendlink", paramString1))
        paramString1 = localCustParseLoop.buildLink(paramString1, paramHashMap);
      if (CheckTag("classlist", paramString1))
        paramString1 = localCustParseLoop.buildClass(paramString1, paramHashMap);
      if (CheckTag("custbase", paramString1))
      {
        String str = "";
        if (paramHashMap.get("cust_id") != null)
        {
          str = paramHashMap.get("cust_id").toString();
          paramString1 = localCustParseNoneLoop.buildCustBase(paramString1, str);
        }
      }
      if (CheckTag("smallclasslist", paramString1))
        paramString1 = localCustParseLoop.buildSmallClass(paramString1, paramHashMap);
      if (CheckTag("channel", paramString1))
        paramString1 = localCustParseLoop.buildChannel(paramString1, paramHashMap);
      if (CheckTag("arealist", paramString1))
        paramString1 = localCustParseLoop.buildArea(paramString1, paramHashMap);
      if (CheckTag("articlelist", paramString1))
      {
        paramHashMap.put("start_row", Integer.valueOf(paramInt1));
        paramHashMap.put("page_size", Integer.valueOf(paramInt2));
        paramString1 = localCustParseLoop.buildArticleList(paramString1, paramHashMap);
      }
      buildHtml(paramString1);
      ClearCache();
      paramString1 = null;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public static void CacheFiles(String paramString)
  {
    String str1 = user_templates_path;
    String str2 = "";
    try
    {
      str2 = FileIO.LoadFile(str1);
    }
    catch (Exception localException)
    {
      System.out.println("下列文件不存在" + str1);
    }
    cache_file = "cache_" + comm.GenShortTradeId() + ".htm";
    if (FileIO.ExistFloder(paramString))
    {
      FileIO.SaveToFile(str2, paramString + cache_file);
    }
    else
    {
      FileIO.CreateFloder(paramString);
      FileIO.SaveToFile(str2, paramString + cache_file);
    }
    cache_file_path = paramString + cache_file;
  }

  public static void buildHtml(String paramString)
    throws SaasApplicationException
  {
    if (FileIO.ExistFloder(ch_path))
    {
      FileIO.SaveToFile(paramString, html_file);
    }
    else
    {
      FileIO.CreateFloder(ch_path);
      FileIO.SaveToFile(paramString, html_file);
    }
  }

  public static void ClearCache()
    throws SaasApplicationException
  {
    FileIO.DelFile(cache_file_path);
  }

  public static boolean CheckTag(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    return paramString2.indexOf("ecms:" + paramString1) >= 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.CustCreateChannel
 * JD-Core Version:    0.6.0
 */