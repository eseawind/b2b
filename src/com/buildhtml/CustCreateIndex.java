package com.buildhtml;

import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.HashMap;
import tools.util.FileIO;

public class CustCreateIndex
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

  public CustCreateIndex()
  {
    log = new Logger(this);
  }

  public static void main(String[] paramArrayOfString)
  {
    CreateIndex("N7Dn670143476l4", "company/enterprise/customer/N7Dn670143476l4/default/index.html", "company/web/N7Dn670143476l4", "index.html");
  }

  public static void CreateIndex(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    System.out.println("进入CreateIndex方法....index_temp=" + paramString2);
    System.out.println("进入CreateIndex方法....save_dir=" + paramString3);
    System.out.println("进入CreateIndex方法....default_page=" + paramString4);
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
    html_file = localConfig.ecms_path + paramString3 + "/" + paramString4;
    ch_path = localConfig.ecms_path + paramString3 + "/";
    CacheFiles(str1);
    str2 = FileIO.LoadFile(cache_file_path);
    CustParseNoneLoop localCustParseNoneLoop = new CustParseNoneLoop();
    CustParseLoop localCustParseLoop = new CustParseLoop();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cust_id", paramString1);
    localHashMap.put("save_dir", paramString3);
    parseContent(str2, cache_file_path, localHashMap, 0, 0);
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
        paramString1 = localCustParseLoop.buildArticleList(paramString1, paramHashMap);
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
    System.out.println("进入CacheFiles方法...");
    String str1 = user_templates_path;
    String str2 = FileIO.LoadFile(str1);
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
    System.out.println("退出CacheFiles方法...");
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
 * Qualified Name:     com.buildhtml.CustCreateIndex
 * JD-Core Version:    0.6.0
 */