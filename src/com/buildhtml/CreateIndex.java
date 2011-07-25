package com.buildhtml;

import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.HashMap;
import tools.util.FileIO;

public class CreateIndex
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

  public CreateIndex()
  {
    log = new Logger(this);
  }

  public static void main(String[] paramArrayOfString)
  {
    CreateIndex("3fwMjTy8m0V4w45", "templates/default/templates/index.html", "/", "index.html");
  }

  public static void CreateIndex(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    FileString = new FileAndString();
    config = new Config();
    comm = new commMethodMgr();
    Config localConfig = new Config();
    ecms_path = localConfig.ecms_path;
    baseurl = localConfig.baseurl;
    user_templates_path = localConfig.ecms_path + paramString2;
    String str1 = localConfig.ecms_path + "Cache/" + paramString3 + "/";
    cache_file = "";
    cache_file_path = "";
    String str2 = "";
    html_file = localConfig.ecms_path + "/" + paramString3 + "/" + paramString4;
    ch_path = localConfig.ecms_path + "/" + paramString3 + "/";
    CacheFiles(str1);
    str2 = FileIO.LoadFile(cache_file_path);
    HashMap localHashMap = new HashMap();
    parseContent(str2, cache_file_path, localHashMap, 0, 0);
  }

  public static void parseContent(String paramString1, String paramString2, HashMap paramHashMap, int paramInt1, int paramInt2)
  {
    ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
    ParseLoop localParseLoop = new ParseLoop();
    ParseThis localParseThis = new ParseThis();
    try
    {
      if (CheckTag("this", paramString1))
      {
        localParseThis.setCacheFile(paramString2);
        paramString1 = localParseThis.buildthis(paramString1, paramHashMap);
      }
      localParseNoneLoop.setCacheFile(paramString2);
      paramString1 = localParseNoneLoop.buildInclude(paramString1);
      paramString1 = localParseNoneLoop.buildAdv(paramString1);
      paramString1 = localParseNoneLoop.buildSearchBase(paramString1);
      paramString1 = localParseNoneLoop.buildBase(paramString1);
      if (CheckTag("infofield", paramString1))
        paramString1 = localParseNoneLoop.buildInfoSingle(paramString1);
      if (CheckTag("listpage", paramString1))
        paramString1 = localParseNoneLoop.buildListpage(paramString1, paramHashMap);
      localParseLoop.setCacheFile(paramString2);
      if (CheckTag("friendlink", paramString1))
        paramString1 = localParseLoop.buildLink(paramString1, paramHashMap);
      if (CheckTag("hotkey", paramString1))
        paramString1 = localParseLoop.buildHotKey(paramString1, paramHashMap);
      if (CheckTag("classlist", paramString1))
        paramString1 = localParseLoop.buildClass(paramString1, paramHashMap);
      if (CheckTag("smallclasslist", paramString1))
        paramString1 = localParseLoop.buildSmallClass(paramString1, paramHashMap);
      if (CheckTag("channel", paramString1))
        paramString1 = localParseLoop.buildChannel(paramString1, paramHashMap);
      if (CheckTag("arealist", paramString1))
        paramString1 = localParseLoop.buildArea(paramString1, paramHashMap);
      if (CheckTag("articlelist", paramString1))
        paramString1 = localParseLoop.buildArticleList(paramString1, paramHashMap);
      FileIO.SaveToFile(paramString1, paramString2);
      buildHtml();
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

  public static void buildHtml()
    throws SaasApplicationException
  {
    String str = FileIO.LoadFile(cache_file_path);
    if (FileIO.ExistFloder(ch_path))
    {
      FileIO.SaveToFile(str, html_file);
    }
    else
    {
      FileIO.CreateFloder(ch_path);
      FileIO.SaveToFile(str, html_file);
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
 * Qualified Name:     com.buildhtml.CreateIndex
 * JD-Core Version:    0.6.0
 */