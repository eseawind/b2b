package com.buildhtml;

import com.saas.biz.channelMgr.ChannelInfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.intf.AreaIntf;
import com.saas.intf.ChannelIntf;
import com.saas.intf.InfoIntf;
import com.saas.intf.ProductClassIntf;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.FileIO;

public class CreateChannel
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

  public CreateChannel()
  {
    log = new Logger(this);
  }

  public static void main(String[] paramArrayOfString)
  {
    try
    {
      if ((paramArrayOfString[0].equals("")) || (paramArrayOfString[0] == null))
        CreateChannelIndexList("0000000000");
      else
        CreateChannelIndexList(paramArrayOfString[0]);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public static void CreateChannelIndexList(String paramString)
    throws SaasApplicationException
  {
    ChannelInfo localChannelInfo = new ChannelInfo();
    CreateChannelIndex(paramString);
    CreateChannelList(paramString);
    ArrayList localArrayList = localChannelInfo.getChSon(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("ch_id") == null)
          continue;
        CreateChannelIndexList(localHashMap.get("ch_id").toString());
        CreateChannelList(localHashMap.get("ch_id").toString());
      }
  }

  public static void CreateChannelIndexSingel(String paramString)
    throws SaasApplicationException
  {
    ChannelInfo localChannelInfo = new ChannelInfo();
    CreateChannelIndex(paramString);
    CreateChannelList(paramString);
  }

  public static void CreateChannelIndexOne(String paramString)
    throws SaasApplicationException
  {
    CreateChannelIndexSelf(paramString);
  }

  public static void CreateChannelListAll(String paramString)
    throws SaasApplicationException
  {
    CreateChannelList(paramString);
  }

  public static void CreateChannelListClass(String paramString)
    throws SaasApplicationException
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    ArrayList localArrayList1 = new ArrayList();
    Config localConfig = new Config();
    try
    {
      localArrayList1 = localChannelIntf.getChannelList(paramString);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if (localArrayList1 != null)
    {
      localHashMap1 = (HashMap)localArrayList1.get(0);
      if (localHashMap1.get("cont_mod") != null)
        str1 = localHashMap1.get("cont_mod").toString();
      if (localHashMap1.get("list_temp") != null)
        str2 = localHashMap1.get("list_temp").toString();
    }
    str3 = FileIO.LoadFile(localConfig.ecms_path + str2);
    ProductClassIntf localProductClassIntf = new ProductClassIntf();
    ArrayList localArrayList2 = new ArrayList();
    String str4 = "";
    if ((str1.equals("1")) || (str1.equals("7")))
    {
      str4 = "5";
      localArrayList2 = localProductClassIntf.getClassInfoByClassType(str4);
    }
    if (str1.equals("2"))
    {
      str4 = "4";
      localArrayList2 = localProductClassIntf.getClassInfoByClassType(str4);
    }
    if (str1.equals("3"))
    {
      str4 = "2";
      localArrayList2 = localProductClassIntf.getClassInfoByClassType(str4);
    }
    if (str1.equals("4"))
    {
      str4 = "3";
      localArrayList2 = localProductClassIntf.getClassInfoByClassType(str4);
    }
    if (str1.equals("15"))
    {
      str4 = "11";
      localArrayList2 = localProductClassIntf.getClassInfoByClassType(str4);
    }
    if (str1.equals("10"))
    {
      str4 = "10";
      localArrayList2 = localProductClassIntf.getClassInfoByClassType(str4);
    }
    if (localArrayList2 != null)
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList2.get(i);
        String str5 = "";
        if (localHashMap2.get("class_id") != null)
          str5 = localHashMap2.get("class_id").toString();
        localHashMap1.put("class_id", str5);
        localHashMap1.put("class_type", str4);
        localHashMap1.put("area_code", "5J2mc0X0G85BH");
        CreateAreaInfoList(str3, localHashMap1, "2");
      }
    str3 = null;
  }

  public static void CreateChannelListArea(String paramString)
    throws SaasApplicationException
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      localArrayList1 = localChannelIntf.getChannelList(paramString);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if (localArrayList1 != null)
    {
      localHashMap1 = (HashMap)localArrayList1.get(0);
      if (localHashMap1.get("cont_mod") != null)
        str1 = localHashMap1.get("cont_mod").toString();
      if (localHashMap1.get("list_temp") != null)
        str2 = localHashMap1.get("list_temp").toString();
    }
    str3 = FileIO.LoadFile(config.ecms_path + str2);
    AreaIntf localAreaIntf = new AreaIntf();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2 = localAreaIntf.getAreaExistCustomer();
    if (localArrayList2 != null)
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList2.get(i);
        String str4 = "";
        if (localHashMap2.get("area_code") != null)
          str4 = localHashMap2.get("area_code").toString();
        localHashMap1.put("area_code", str4);
        localHashMap1.put("class_id", "000000000000000");
        CreateAreaInfoList(str3, localHashMap1, "1");
      }
    str3 = null;
  }

  public static void CreateChannelIndexSelf(String paramString)
    throws SaasApplicationException
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList = localChannelIntf.getChannelList(paramString);
    }
    catch (Exception localException1)
    {
      throw new RuntimeException(localException1);
    }
    FileString = new FileAndString();
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
        String str8 = "";
        if (localHashMap.get("ch_id") != null)
          str2 = localHashMap.get("ch_id").toString();
        if (localHashMap.get("cont_mod") != null)
          str8 = localHashMap.get("cont_mod").toString();
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
        platform_path = localConfig.platform_path;
        baseurl = localConfig.baseurl;
        user_templates_path = localConfig.ecms_path + str4;
        String str9 = localConfig.ecms_path + "Cache/" + str7 + "/";
        cache_file = "";
        cache_file_path = "";
        String str10 = "";
        html_file = localConfig.ecms_path + "/" + str7 + "/" + str6;
        ch_path = localConfig.ecms_path + "/" + str7 + "/";
        str10 = FileIO.LoadFile(user_templates_path);
        ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
        ParseLoop localParseLoop = new ParseLoop();
        ParseThis localParseThis = new ParseThis();
        try
        {
          System.out.println("正在解析[" + str1 + "]模板，请稍后...");
          parseContent(str10, cache_file_path, localHashMap, 0, 100);
          str10 = null;
          System.out.println("生成[" + str1 + "]频道首页结束");
        }
        catch (Exception localException2)
        {
          throw new RuntimeException(localException2);
        }
      }
    }
  }

  public static void CreateChannelIndex(String paramString)
    throws SaasApplicationException
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      localArrayList1 = localChannelIntf.getChannelList(paramString);
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
        String str9 = "";
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
        ecms_path = localConfig.ecms_path;
        platform_path = localConfig.platform_path;
        baseurl = localConfig.baseurl;
        str4 = localConfig.ecms_path + str4;
        str5 = localConfig.ecms_path + str5;
        String str10 = localConfig.ecms_path + "Cache/" + str7 + "/";
        cache_file = "";
        cache_file_path = "";
        String str11 = "";
        String str12 = "";
        html_file = localConfig.ecms_path + "/" + str7 + "/" + str6;
        ch_path = localConfig.ecms_path + "/" + str7 + "/";
        str11 = FileIO.LoadFile(str4);
        str9 = FileIO.LoadFile(str5);
        ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
        ParseLoop localParseLoop = new ParseLoop();
        ParseThis localParseThis = new ParseThis();
        System.out.println("save_dir = " + str7);
        try
        {
          System.out.println("正在解析[" + str1 + "]模板，请稍后...");
          str12 = parseContent(str11, cache_file_path, localHashMap1, 0, 100);
          System.out.println("正在生成[" + str1 + "]频道分页首页，请稍后...");
          if ((CheckTag("listpage", str11)) && (!str5.equals("")))
            CreateInfoIndexList(localHashMap1, str12);
          System.out.println("生成[" + str1 + "]频道分页首页结束");
          System.out.println("正在生成[" + str1 + "]分类列表，请稍后...");
          Object localObject1;
          ArrayList localArrayList2;
          Object localObject2;
          if ((CheckTag("classlist", str11)) && (!str5.equals("")))
          {
            localObject1 = new ProductClassIntf();
            localArrayList2 = new ArrayList();
            String str13 = "";
            if ((str8.equals("1")) || (str8.equals("7")))
            {
              str13 = "5";
              localArrayList2 = ((ProductClassIntf)localObject1).getClassInfoByClassType(str13);
            }
            if (str8.equals("2"))
            {
              str13 = "4";
              localArrayList2 = ((ProductClassIntf)localObject1).getClassInfoByClassType(str13);
            }
            if (str8.equals("3"))
            {
              str13 = "2";
              localArrayList2 = ((ProductClassIntf)localObject1).getClassInfoByClassType(str13);
            }
            if (str8.equals("4"))
            {
              str13 = "3";
              localArrayList2 = ((ProductClassIntf)localObject1).getClassInfoByClassType(str13);
            }
            if (str8.equals("15"))
            {
              str13 = "11";
              localArrayList2 = ((ProductClassIntf)localObject1).getClassInfoByClassType(str13);
            }
            if (str8.equals("10"))
            {
              str13 = "10";
              localArrayList2 = ((ProductClassIntf)localObject1).getClassInfoByClassType(str13);
            }
            if (localArrayList2 != null)
              for (int j = 0; j < localArrayList2.size(); j++)
              {
                localObject2 = (HashMap)localArrayList2.get(j);
                String str14 = "";
                String str15 = "";
                if (((HashMap)localObject2).get("class_id") != null)
                  str14 = ((HashMap)localObject2).get("class_id").toString();
                if (((HashMap)localObject2).get("class_name") != null)
                  str15 = ((HashMap)localObject2).get("class_name").toString();
                localHashMap1.put("class_id", str14);
                localHashMap1.put("class_name", str15);
                localHashMap1.put("class_type", str13);
                localHashMap1.put("area_code", "5J2mc0X0G85BH");
                CreateAreaInfoList(str9, localHashMap1, "2");
                System.out.println("分类" + str15 + "：" + str14 + "处理完毕");
              }
          }
          System.out.println("生成[" + str1 + "]分类列表结束");
          System.out.println("正在生成[" + str1 + "]地区列表，请稍后...");
          if ((CheckTag("arealist", str11)) && (!str5.equals("")))
          {
            localObject1 = new AreaIntf();
            localArrayList2 = new ArrayList();
            localArrayList2 = ((AreaIntf)localObject1).getAreaExistCustomer();
            if (localArrayList2 != null)
              for (int i = 0; i < localArrayList2.size(); i++)
              {
                HashMap localHashMap2 = (HashMap)localArrayList2.get(i);
                localObject2 = "";
                if (localHashMap2.get("area_code") != null)
                  localObject2 = localHashMap2.get("area_code").toString();
                localHashMap1.put("area_code", localObject2);
                localHashMap1.put("class_id", "000000000000000");
                CreateAreaInfoList(str9, localHashMap1, "1");
              }
          }
          System.out.println("生成[" + str1 + "]地区列表结束");
        }
        catch (Exception localException2)
        {
          throw new RuntimeException(localException2);
        }
      }
    }
  }

  public static void CreateChannelList(String paramString)
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList = localChannelIntf.getChannelList(paramString);
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
        platform_path = localConfig.platform_path;
        baseurl = localConfig.baseurl;
        str5 = localConfig.ecms_path + str5;
        String str8 = localConfig.ecms_path + "Cache/" + str7 + "/";
        cache_file = "";
        cache_file_path = "";
        String str9 = "";
        String str10 = "";
        html_file = localConfig.ecms_path + "/" + str7 + "/list/" + str6;
        ch_path = localConfig.ecms_path + "/" + str7 + "/list/";
        str9 = FileIO.LoadFile(str5);
        ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
        ParseLoop localParseLoop = new ParseLoop();
        ParseThis localParseThis = new ParseThis();
        try
        {
          System.out.println("正在解析[" + str1 + "]模板，请稍后...");
          str10 = parseContent(str9, cache_file_path, localHashMap, 0, 100);
          System.out.println("生成[" + str1 + "]栏目首页结束");
          System.out.println("生成[" + str1 + "]栏目列表分页开始");
          if ((CheckTag("listpage", str9)) && (!str5.equals("")))
            CreateInfoList(str10, localHashMap);
          System.out.println("生成[" + str1 + "]栏目列表分页结束");
        }
        catch (Exception localException2)
        {
          throw new RuntimeException(localException2);
        }
      }
    }
  }

  public static void CreateInfoList(String paramString, HashMap paramHashMap)
  {
    if (paramHashMap == null)
      return;
    InfoIntf localInfoIntf = new InfoIntf();
    Config localConfig = new Config();
    String str1 = "";
    String str2 = "";
    if (paramHashMap.get("cont_mod") != null)
      str2 = paramHashMap.get("cont_mod").toString();
    ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
    String str3 = localParseNoneLoop.getListpage(paramString);
    String str4 = "";
    String str5 = str3;
    int i = 0;
    int j = 1;
    int k = 0;
    if (paramHashMap.get("ch_id") != null)
      str4 = paramHashMap.get("ch_id").toString();
    try
    {
      k = localInfoIntf.getInfoCountByChId(str4, str2);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    while (i < k)
    {
      BuildInfoList(paramString, paramHashMap, i, Integer.parseInt(str5), j, "0");
      i += Integer.parseInt(str5);
      j += 1;
      if (j <= 10)
        continue;
    }
  }

  public static void CreateInfoIndexList(HashMap paramHashMap, String paramString)
  {
    if (paramHashMap == null)
      return;
    InfoIntf localInfoIntf = new InfoIntf();
    Config localConfig = new Config();
    String str1 = "";
    if (paramHashMap.get("index_temp") != null)
      str1 = paramHashMap.get("index_temp").toString();
    ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
    String str2 = localParseNoneLoop.getListpage(paramString);
    String str3 = "";
    String str4 = "";
    String str5 = str2;
    int i = 0;
    int j = 1;
    int k = 0;
    if (paramHashMap.get("ch_id") != null)
      str3 = paramHashMap.get("ch_id").toString();
    if (paramHashMap.get("cont_mod") != null)
      str4 = paramHashMap.get("cont_mod").toString();
    try
    {
      k = localInfoIntf.getInfoCountByChId(str3, str4);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    while (i < k)
    {
      BuildInfoList(paramString, paramHashMap, i, Integer.parseInt(str5), j, "1");
      i += Integer.parseInt(str5);
      j += 1;
      if (j <= 10)
        continue;
    }
  }

  public static void CreateAreaInfoList(String paramString1, HashMap paramHashMap, String paramString2)
  {
    if (paramHashMap == null)
      return;
    InfoIntf localInfoIntf = new InfoIntf();
    Config localConfig = new Config();
    String str1 = "";
    String str2 = "";
    if (paramHashMap.get("list_temp") != null)
      str1 = paramHashMap.get("list_temp").toString();
    ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
    String str3 = localParseNoneLoop.getListpage(paramString1);
    String str4 = "";
    String str5 = str3;
    int i = 0;
    int j = 1;
    int k = 0;
    int m = 0;
    int n = 100;
    String str6 = "";
    String str7 = "";
    String str8 = "";
    if (paramHashMap.get("area_code") != null)
      str6 = paramHashMap.get("area_code").toString();
    if (paramHashMap.get("class_id") != null)
      str7 = paramHashMap.get("class_id").toString();
    if (paramHashMap.get("cont_mod") != null)
      str2 = paramHashMap.get("cont_mod").toString();
    if (paramHashMap.get("ch_id") != null)
      str4 = paramHashMap.get("ch_id").toString();
    try
    {
      if ((!str6.equals("")) && (!str2.equals("")) && (paramString2.equals("1")))
      {
        ArrayList localArrayList = localInfoIntf.getInfoListByAreaCode(m, n, str4, str6, str2);
        if (localArrayList != null)
          k = localArrayList.size();
        else
          k = 0;
        str8 = "2";
      }
      if ((!str7.equals("")) && (!str2.equals("")) && (paramString2.equals("2")))
      {
        k = localInfoIntf.getInfoListByClassId(str4, str7, str2);
        str8 = "3";
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    while (i < k)
    {
      BuildInfoList(paramString1, paramHashMap, i, Integer.parseInt(str5), j, str8);
      i += Integer.parseInt(str5);
      j += 1;
      if (j <= 10)
        continue;
    }
  }

  public static void BuildInfoList(String paramString1, HashMap paramHashMap, int paramInt1, int paramInt2, int paramInt3, String paramString2)
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
      if ((paramString2.equals("0")) || (paramString2.equals("2")) || (paramString2.equals("3")))
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
      else if (paramString2.equals("1"))
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
      if (paramHashMap.get("default_page") != null)
        str6 = paramHashMap.get("default_page").toString();
      ecms_path = localConfig.ecms_path;
      platform_path = localConfig.platform_path;
      baseurl = localConfig.baseurl;
      user_templates_path = localConfig.ecms_path + str5;
      String str10 = localConfig.ecms_path + "Cache/" + str7 + "/";
      cache_file = "";
      cache_file_path = "";
      if (paramString2.equals("0"))
      {
        if (paramInt3 == 1)
          html_file = localConfig.ecms_path + "/" + str7 + "/list/" + str6;
        else if (paramInt3 < 10)
          html_file = localConfig.ecms_path + "/" + str7 + "/list/" + paramInt3 + ".html";
        else
          html_file = localConfig.ecms_path + "/" + str7 + "/list/list.html";
        ch_path = localConfig.ecms_path + "/" + str7 + "/list/";
      }
      else if (paramString2.equals("1"))
      {
        if (paramInt3 == 1)
          html_file = localConfig.ecms_path + "/" + str7 + "/" + str6;
        else if (paramInt3 < 10)
          html_file = localConfig.ecms_path + "/" + str7 + "/" + paramInt3 + ".html";
        else
          html_file = localConfig.ecms_path + "/" + str7 + "/list.html";
        ch_path = localConfig.ecms_path + "/" + str7 + "/";
      }
      else if (paramString2.equals("2"))
      {
        if (paramInt3 == 1)
          html_file = localConfig.ecms_path + "/" + str7 + "/area/" + str8 + "/" + str6;
        else if (paramInt3 < 10)
          html_file = localConfig.ecms_path + "/" + str7 + "/area/" + str8 + "/" + paramInt3 + ".html";
        else
          html_file = localConfig.ecms_path + "/" + str7 + "/area/" + str8 + "/list.html";
        ch_path = localConfig.ecms_path + "/" + str7 + "/area/" + str8 + "/";
      }
      else if (paramString2.equals("3"))
      {
        if (paramInt3 == 1)
          html_file = localConfig.ecms_path + "/" + str7 + "/class/" + str9 + "/" + str6;
        else if (paramInt3 < 10)
          html_file = localConfig.ecms_path + "/" + str7 + "/class/" + str9 + "/" + paramInt3 + ".html";
        else
          html_file = localConfig.ecms_path + "/" + str7 + "/class/" + str9 + "/list.html";
        ch_path = localConfig.ecms_path + "/" + str7 + "/class/" + str9 + "/";
      }
      parseContent(paramString1, cache_file_path, paramHashMap, paramInt1, paramInt2);
    }
  }

  public static String parseContent(String paramString1, String paramString2, HashMap paramHashMap, int paramInt1, int paramInt2)
  {
    ParseNoneLoop localParseNoneLoop = new ParseNoneLoop();
    ParseLoop localParseLoop = new ParseLoop();
    ParseThis localParseThis = new ParseThis();
    String str = paramString1;
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
      str = paramString1;
      if (CheckTag("listpage", paramString1))
        paramString1 = localParseNoneLoop.buildListpage(paramString1, paramHashMap);
      ReplaceBuild(localParseLoop, paramInt1, paramInt2, paramString1, paramHashMap);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return str;
  }

  public static void ReplaceBuild(ParseLoop paramParseLoop, int paramInt1, int paramInt2, String paramString, HashMap paramHashMap)
  {
    try
    {
      if (CheckTag("articlelist", paramString))
      {
        paramHashMap.put("start_row", Integer.valueOf(paramInt1));
        paramHashMap.put("page_size", Integer.valueOf(paramInt2));
        paramString = paramParseLoop.buildArticleList(paramString, paramHashMap);
      }
      buildHtml(paramString);
      paramString = null;
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
      System.out.println("下列文件不存在：" + str1);
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
    cache_file_path = "";
  }

  public static boolean CheckTag(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    return paramString2.indexOf("ecms:" + paramString1) >= 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.CreateChannel
 * JD-Core Version:    0.6.0
 */