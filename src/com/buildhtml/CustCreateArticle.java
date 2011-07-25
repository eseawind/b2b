package com.buildhtml;

import com.saas.biz.channelColumnMgr.ChannelColumnInfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.intf.CustChannelIntf;
import com.saas.intf.InfoIntf;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.FileIO;

public class CustCreateArticle
{
  public static Logger log;
  public static FileAndString FileString;
  public static Config config;
  public static commMethodMgr comm;
  public static String ecms_path;
  public static String user_templates_path;
  public static String platform_path;
  public static String baseurl;
  public static String cache_path;
  public static String cache_file;
  public static String html_file;
  public static String ch_path;
  public static String cache_file_path;
  public static String copy_cache_file_path;

  public CustCreateArticle()
  {
    log = new Logger(this);
  }

  public static void main(String[] paramArrayOfString)
  {
    try
    {
      CreateArticleList("0000000000", "cmq0BFnEjh674s6");
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public static void CreateArticleList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelColumnInfo localChannelColumnInfo = new ChannelColumnInfo();
    if ((paramString1 != "0000000000") || (!paramString1.equals("0000000000")))
      CreateArticle(paramString1, paramString2);
    ArrayList localArrayList = localChannelColumnInfo.getChSon(paramString1, paramString2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("ch_id") == null)
          continue;
        CreateArticleList(localHashMap.get("ch_id").toString(), paramString2);
      }
  }

  public static void CreateArticle(String paramString1, String paramString2)
  {
    CustChannelIntf localCustChannelIntf = new CustChannelIntf();
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap = localCustChannelIntf.getChInfo(paramString1, paramString2);
    }
    catch (Exception localException1)
    {
      throw new RuntimeException(localException1);
    }
    FileString = new FileAndString();
    config = new Config();
    comm = new commMethodMgr();
    Config localConfig = new Config();
    if (localHashMap != null)
    {
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      if (localHashMap.get("ch_id") != null)
        str2 = localHashMap.get("ch_id").toString();
      if (localHashMap.get("ch_name") != null)
        str1 = localHashMap.get("ch_name").toString();
      if (localHashMap.get("save_dir") != null)
        str5 = localHashMap.get("save_dir").toString();
      if (localHashMap.get("article_temp") != null)
        str4 = localHashMap.get("article_temp").toString();
      ecms_path = localConfig.ecms_path;
      platform_path = localConfig.platform_path;
      baseurl = localConfig.baseurl;
      user_templates_path = localConfig.ecms_path + str4;
      String str6 = localConfig.ecms_path + "Cache/" + str5 + "/";
      cache_file = "";
      cache_file_path = "";
      String str7 = "";
      String str8 = localConfig.ecms_path + str5 + "/d/";
      ch_path = localConfig.ecms_path + str5 + "/d/";
      CacheFiles(str6);
      str7 = FileIO.LoadFile(cache_file_path);
      CustParseNoneLoop localCustParseNoneLoop = new CustParseNoneLoop();
      try
      {
        System.out.println("正在解析[" + str1 + "]详细页面模板，请稍后...");
        str7 = parseContent(str7, cache_file_path, localHashMap, 0, 0);
        System.out.println("正在生成[" + str1 + "]详细页面，请稍后...");
        buildArticle(localHashMap, str8, localCustParseNoneLoop, str7);
        ClearCache();
        System.out.println("生成[" + str1 + "]详细页面结束\n");
      }
      catch (Exception localException2)
      {
        throw new RuntimeException(localException2);
      }
    }
  }

  public static String parseContent(String paramString1, String paramString2, HashMap paramHashMap, int paramInt1, int paramInt2)
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
      if (CheckTag("classlist", paramString1))
        paramString1 = localCustParseLoop.buildClass(paramString1, paramHashMap);
      if (CheckTag("smallclasslist", paramString1))
        paramString1 = localCustParseLoop.buildSmallClass(paramString1, paramHashMap);
      if (CheckTag("channel", paramString1))
        paramString1 = localCustParseLoop.buildChannel(paramString1, paramHashMap);
      if (CheckTag("arealist", paramString1))
        paramString1 = localCustParseLoop.buildArea(paramString1, paramHashMap);
      if (CheckTag("articlelist", paramString1))
        paramString1 = localCustParseLoop.buildArticleList(paramString1, paramHashMap);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return paramString1;
  }

  public static void buildArticle(HashMap paramHashMap, String paramString1, CustParseNoneLoop paramCustParseNoneLoop, String paramString2)
  {
    InfoIntf localInfoIntf = new InfoIntf();
    ArrayList localArrayList = new ArrayList();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    if (paramHashMap.get("cust_id") != null)
      str1 = paramHashMap.get("cust_id").toString();
    if (paramHashMap.get("ch_id") != null)
      str2 = paramHashMap.get("ch_id").toString();
    if (paramHashMap.get("cont_mod") != null)
      str3 = paramHashMap.get("cont_mod").toString();
    try
    {
      localArrayList = localInfoIntf.getInfoListByContmod(str2, str3, str1);
      System.out.println("newslist =" + localArrayList);
    }
    catch (Exception localException1)
    {
      throw new RuntimeException(localException1);
    }
    if (localArrayList == null)
      return;
    if (localArrayList != null)
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap = (HashMap)localIterator.next();
        String str5 = "";
        if (localHashMap.get("info_id") != null)
          str5 = localHashMap.get("info_id").toString();
        html_file = paramString1 + "content-" + str5 + ".html";
        try
        {
          str4 = paramCustParseNoneLoop.CustbuildArticleInfo(localHashMap, paramHashMap, paramString2);
          buildHtml(str4);
          System.out.println("[" + str5 + "]详细文档生成完毕！");
        }
        catch (Exception localException2)
        {
          throw new RuntimeException(localException2);
        }
      }
    }
  }

  public static String CopyCacheFiles(String paramString)
  {
    String str = FileIO.LoadFile(cache_file_path);
    return str;
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
    str2 = null;
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
    paramString = null;
  }

  public static void ClearCache()
    throws SaasApplicationException
  {
    FileIO.DelFile(cache_file_path);
  }

  public static void ClearCopyCache()
    throws SaasApplicationException
  {
    FileIO.DelFile(copy_cache_file_path);
  }

  public static boolean CheckTag(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    return paramString2.indexOf("ecms:" + paramString1) >= 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.CustCreateArticle
 * JD-Core Version:    0.6.0
 */