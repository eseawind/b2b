package com.buildhtml;

import com.saas.biz.channelMgr.ChannelInfo;
import com.saas.biz.commen.ConfigurationMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.intf.ChannelIntf;
import com.saas.intf.InfoIntf;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.FileIO;

public class CreateArticle
{
  public static Logger log;
  public static FileAndString FileString;
  public static Config config;
  public static commMethodMgr comm;
  Buffers inBuffer;
  Buffers outBuffer;
  Dbtable tradeQuery;
  ArrayList queryResult = new ArrayList();
  public static String ecms_path;
  public static String user_templates_path;
  public static String baseurl;
  public static String cache_path;
  public static String cache_file;
  public static String html_file;
  public static String ch_path;
  public static String cache_file_path;
  public static String copy_cache_file_path;

  public CreateArticle()
  {
    log = new Logger(this);
    this.tradeQuery = new Dbtable();
    this.outBuffer = new Buffers();
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public static void main(String[] paramArrayOfString)
    throws SaasApplicationException
  {
    try
    {
      if ((paramArrayOfString[0].equals("")) || (paramArrayOfString[0] == null))
        CreateArticleList("0000000000", "1");
      else
        CreateArticleList(paramArrayOfString[0], "1");
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public static void CreateArticleList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelInfo localChannelInfo = new ChannelInfo();
    if (!paramString1.equals("0000000000"))
      CreateArticle(paramString1, paramString2);
    ArrayList localArrayList = localChannelInfo.getChSon(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("ch_id") == null)
          continue;
        if (paramString1.equals("3070785011"))
          paramString1 = "2263836050";
        CreateArticleList(localHashMap.get("ch_id").toString(), paramString2);
      }
  }

  public static void CreateArticle(String paramString1, String paramString2)
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap = localChannelIntf.getChInfo(paramString1);
      localHashMap.put("born_type", paramString2);
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
      localHashMap.put("ecms_path", ecms_path);
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
      ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
      try
      {
        System.out.println("正在解析[" + str1 + "]详细页面模板，请稍后...");
        str7 = parseContent(str7, cache_file_path, localHashMap, 0, 0);
        System.out.println("正在生成[" + str1 + "]详细页面，请稍后...");
        buildArticle(localHashMap, str8, localParseNoneLoop, str7);
        ClearCache();
        System.out.println("生成[" + str1 + "]详细页面结束");
      }
      catch (Exception localException2)
      {
        throw new RuntimeException(localException2);
      }
    }
  }

  public static String parseContent(String paramString1, String paramString2, HashMap paramHashMap, int paramInt1, int paramInt2)
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
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return paramString1;
  }

  public static void buildArticle(HashMap paramHashMap, String paramString1, ParseNoneLoop paramParseNoneLoop, String paramString2)
    throws SaasApplicationException
  {
    InfoIntf localInfoIntf = new InfoIntf();
    ArrayList localArrayList1 = new ArrayList();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    ArrayList localArrayList2 = new ArrayList();
    if (paramHashMap.get("ch_id") != null)
      str1 = paramHashMap.get("ch_id").toString();
    if (paramHashMap.get("born_type") != null)
      str3 = paramHashMap.get("born_type").toString();
    if (paramHashMap.get("cont_mod") != null)
      str2 = paramHashMap.get("cont_mod").toString();
    if (paramHashMap.get("ecms_path") != null)
      str4 = paramHashMap.get("ecms_path").toString();
    if (paramHashMap.get("save_dir") != null)
      str5 = paramHashMap.get("save_dir").toString();
    try
    {
      localArrayList1 = localInfoIntf.getInfoListByContmod(str1, str2);
    }
    catch (Exception localException1)
    {
      throw new RuntimeException(localException1);
    }
    if (localArrayList1 != null)
    {
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap = (HashMap)localIterator.next();
        String str8 = "";
        String str9 = "";
        if (localHashMap.get("info_id") != null)
          str8 = localHashMap.get("info_id").toString();
        if (localHashMap.get("in_date") != null)
          str9 = localHashMap.get("in_date").toString();
        if (str3.equals("2"))
        {
          str6 = str4 + str5 + "/d/" + getInDate(str9);
          File localFile = new File(str6);
          String[] arrayOfString = localFile.list();
          if (arrayOfString != null)
            for (int i = 0; i < arrayOfString.length; i++)
              localArrayList2.add(arrayOfString[i].substring(arrayOfString[i].indexOf("-") + 1, arrayOfString[i].indexOf(".")));
          localFile = null;
        }
        html_file = paramString1 + "/" + getInDate(str9) + "/content-" + str8 + ".html";
        try
        {
          if ((str3.equals("2")) && (localArrayList2.contains(str8)))
            continue;
          str7 = paramParseNoneLoop.buildArticleInfo(localHashMap, paramHashMap, paramString2);
          buildHtml(str7, str9);
          System.out.println("[" + str8 + "]详细文档生成完毕！");
        }
        catch (Exception localException2)
        {
          throw new RuntimeException(localException2);
        }
      }
    }
  }

  public void createOneArticle(Buffers paramBuffers)
    throws SaasApplicationException
  {
    log.LOG_INFO("进入createOneArticle方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CH_ID");
    String str2 = paramBuffers.getString("TRADE_TYPE_CODE");
    String str3 = paramBuffers.getString("INFO_ID");
    try
    {
      if ((str2.equals("0213")) || (str2.equals("0233")) || (str2.equals("1226")) || (str2.equals("1600")) || (str2.equals("0260")) || (str2.equals("0265")) || (str2.equals("2225")) || (str2.equals("3690")) || (str2.equals("0347")) || (str2.equals("0343")) || (str2.equals("1228")) || (str2.equals("0387")) || (str2.equals("0341")) || (str2.equals("0289")) || (str2.equals("2228")) || (str2.equals("0021")))
        CreateSingleArticle(str1, str3);
      i = 0;
    }
    catch (Exception localException)
    {
      log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    log.LOG_INFO("退出createOneArticle方法...");
  }

  public void CreateSingleArticle(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    InfoIntf localInfoIntf = new InfoIntf();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localHashMap1 = localChannelIntf.getChInfo(paramString1);
    }
    catch (Exception localException1)
    {
      throw new RuntimeException(localException1);
    }
    FileString = new FileAndString();
    config = new Config();
    comm = new commMethodMgr();
    Config localConfig = new Config();
    if (localHashMap1 != null)
    {
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      String str6 = "";
      if (localHashMap1.get("ch_id") != null)
        str2 = localHashMap1.get("ch_id").toString();
      if (localHashMap1.get("cont_mod") != null)
        str4 = localHashMap1.get("cont_mod").toString();
      if (localHashMap1.get("ch_name") != null)
        str1 = localHashMap1.get("ch_name").toString();
      if (localHashMap1.get("save_dir") != null)
        str6 = localHashMap1.get("save_dir").toString();
      if (localHashMap1.get("article_temp") != null)
        str5 = localHashMap1.get("article_temp").toString();
      localArrayList = localInfoIntf.getInfoListByInfoIdContMod(paramString2, str4);
      System.out.println(localArrayList + "=================");
      if (localArrayList != null)
        localHashMap2 = (HashMap)localArrayList.get(0);
      ecms_path = localConfig.ecms_path;
      localHashMap1.put("ecms_path", ecms_path);
      baseurl = localConfig.baseurl;
      user_templates_path = localConfig.ecms_path + str5;
      String str7 = localConfig.ecms_path + "Cache/" + str6 + "/";
      cache_file = "";
      cache_file_path = "";
      String str8 = "";
      String str9 = localConfig.ecms_path + str6 + "/d/";
      ch_path = localConfig.ecms_path + str6 + "/d/";
      CacheFiles(str7);
      str8 = FileIO.LoadFile(cache_file_path);
      ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
      try
      {
        System.out.println("正在解析[" + str1 + "]详细页面模板，请稍后...");
        str8 = parseContent(str8, cache_file_path, localHashMap1, 0, 0);
        System.out.println("正在生成[" + str1 + "]详细页面，请稍后...");
        buildSingleArticle(localHashMap1, localHashMap2, str9, localParseNoneLoop, str8);
        ClearCache();
        System.out.println("生成[" + str1 + "]详细页面结束");
      }
      catch (Exception localException2)
      {
        throw new RuntimeException(localException2);
      }
    }
  }

  public void buildSingleArticle(HashMap paramHashMap1, HashMap paramHashMap2, String paramString1, ParseNoneLoop paramParseNoneLoop, String paramString2)
    throws SaasApplicationException
  {
    InfoIntf localInfoIntf = new InfoIntf();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    if (paramHashMap1.get("ch_id") != null)
      str1 = paramHashMap1.get("ch_id").toString();
    if (paramHashMap1.get("cont_mod") != null)
      str2 = paramHashMap1.get("cont_mod").toString();
    if (paramHashMap1.get("ecms_path") != null)
      str3 = paramHashMap1.get("ecms_path").toString();
    if (paramHashMap1.get("save_dir") != null)
      str4 = paramHashMap1.get("save_dir").toString();
    String str7 = "";
    String str8 = "";
    if (paramHashMap2.get("info_id") != null)
      str7 = paramHashMap2.get("info_id").toString();
    if (paramHashMap2.get("in_date") != null)
      str8 = paramHashMap2.get("in_date").toString();
    html_file = paramString1 + "/" + getInDate(str8) + "/content-" + str7 + ".html";
    try
    {
      str6 = paramParseNoneLoop.buildArticleInfo(paramHashMap2, paramHashMap1, paramString2);
      buildHtml(str6, str8);
      System.out.println("[" + str7 + "]详细文档生成完毕！");
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
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

  public static void buildHtml(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramString2 = getInDate(paramString2);
    if (FileIO.ExistFloder(ch_path + "/" + paramString2))
    {
      FileIO.SaveToFile(paramString1, html_file);
    }
    else
    {
      FileIO.CreateFloder(ch_path + "/" + paramString2);
      FileIO.SaveToFile(paramString1, html_file);
    }
    paramString1 = null;
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

  public static String getInDate(String paramString)
    throws SaasApplicationException
  {
    ConfigurationMgr localConfigurationMgr = new ConfigurationMgr();
    ArrayList localArrayList = localConfigurationMgr.getConfiguration("2");
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code1") != null)
        str = localHashMap.get("para_code1").toString();
    }
    if (!str.equals("1"))
      if (str.equals("2"))
        paramString = paramString.substring(0, 7);
      else if (str.equals("3"))
        paramString = paramString.substring(0, 4);
    return paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.CreateArticle
 * JD-Core Version:    0.6.0
 */