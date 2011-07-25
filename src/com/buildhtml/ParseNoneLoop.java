package com.buildhtml;

import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.commen.config;
import com.saas.intf.AdvertiseIntf;
import com.saas.intf.AttachIntf;
import com.saas.intf.ChannelIntf;
import com.saas.intf.CustIntf;
import com.saas.intf.InfoIntf;
import com.saas.intf.NewsIntf;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import com.saas.sys.tag.Tagbase;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import tools.util.FileIO;
import tools.util.StrReplace;

public class ParseNoneLoop
{
  Logger log = new Logger(this);
  Config config = new Config();
  commMethodMgr comm = new commMethodMgr();
  public String ecms_path = this.config.ecms_path;
  public String cache_file_path = "";
  private String default_img = this.config.default_img;

  public void setCacheFile(String paramString)
  {
    this.cache_file_path = paramString;
  }

  public String buildBase(String paramString)
    throws SaasApplicationException
  {
    Tagbase localTagbase = new Tagbase();
    ArrayList localArrayList1 = new ArrayList();
    localTagbase.setNameSpace("ecms", "base", "{", "/}");
    localTagbase.setInstr(paramString);
    localArrayList1 = localTagbase.getSpecTagList();
    ArrayList localArrayList2 = this.config.getConfigList();
    if (localArrayList1 == null)
      return paramString;
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      if (localHashMap1.get("tagname") != null)
        str1 = localHashMap1.get("tagname").toString();
      if (localHashMap1.get("tagstr") != null)
        str2 = localHashMap1.get("tagstr").toString();
      if (localHashMap1.get("tagstring") != null)
        str3 = localHashMap1.get("tagstring").toString();
      str4 = localTagbase.getAttrValue(str2, "name");
      if (localArrayList2 == null)
        break;
      for (int i = 0; i < localArrayList2.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList2.get(i);
        String str5 = "";
        String str6 = "";
        if (localHashMap2.get("name") != null)
          str5 = localHashMap2.get("name").toString();
        if (localHashMap2.get("value") != null)
          str6 = localHashMap2.get("value").toString();
        if (!str5.equals(str4))
          continue;
        paramString = StrReplace.replace(paramString, str3, str6);
        break;
      }
    }
    return paramString;
  }

  public void buildCustBase(String paramString)
    throws SaasApplicationException
  {
    Tagbase localTagbase = new Tagbase();
    CustIntf localCustIntf = new CustIntf();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = localCustIntf.getCustInfo(paramString);
    String str1 = FileIO.LoadFile(this.cache_file_path);
    localTagbase.setNameSpace("ecms", "custbase", "{", "/}");
    localTagbase.setInstr(str1);
    localArrayList = localTagbase.getSpecTagList();
    if (localArrayList == null)
      return;
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap2 = (HashMap)localIterator.next();
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      String str6 = "";
      if (localHashMap2.get("tagname") != null)
        str2 = localHashMap2.get("tagname").toString();
      if (localHashMap2.get("tagstr") != null)
        str3 = localHashMap2.get("tagstr").toString();
      if (localHashMap2.get("tagstring") != null)
        str4 = localHashMap2.get("tagstring").toString();
      str6 = localTagbase.getAttrValue(str3, "name");
      if (localHashMap1.get(str6) != null)
        str1 = StrReplace.replace(str1, str4, localHashMap1.get(str6).toString());
    }
    FileIO.SaveToFile(str1, this.cache_file_path);
  }

  public String buildSearchBase(String paramString)
    throws SaasApplicationException
  {
    Tagbase localTagbase = new Tagbase();
    CustIntf localCustIntf = new CustIntf();
    ArrayList localArrayList = new ArrayList();
    localTagbase.setNameSpace("ecms", "searchintf", "{", "/}");
    localTagbase.setInstr(paramString);
    localArrayList = localTagbase.getSpecTagList();
    if (localArrayList == null)
      return paramString;
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      if (localHashMap.get("tagname") != null)
        str1 = localHashMap.get("tagname").toString();
      if (localHashMap.get("tagstr") != null)
        str2 = localHashMap.get("tagstr").toString();
      if (localHashMap.get("tagstring") != null)
        str3 = localHashMap.get("tagstring").toString();
      str5 = localTagbase.getAttrValue(str2, "cont_mod");
      String str6 = "";
      if (str5.equals("1"))
        str6 = "8855381456";
      if (str5.equals("2"))
        str6 = "7830633062";
      if (str5.equals("3"))
        str6 = "6871426767";
      if (str5.equals("4"))
        str6 = "5563378845";
      if (str5.equals("5"))
        str6 = "1455415210";
      FileAndString localFileAndString = new FileAndString();
      String str7 = "";
      config localconfig = new config();
      localconfig.init();
      str7 = localconfig.getString("searchtemp");
      String str8 = localFileAndString.f2sSearch(str7, str6);
      if (!str8.equals(""))
        paramString = StrReplace.replace(paramString, str3, str8);
    }
    return paramString;
  }

  public String buildInfoSingle(String paramString)
    throws SaasApplicationException
  {
    Tagbase localTagbase = new Tagbase();
    ArrayList localArrayList1 = new ArrayList();
    localTagbase.setNameSpace("ecms", "infofield", "{", "/}");
    localTagbase.setInstr(paramString);
    localArrayList1 = localTagbase.getSpecTagList();
    if (localArrayList1 == null)
      return paramString;
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
      if (localHashMap.get("tagname") != null)
        str1 = localHashMap.get("tagname").toString();
      if (localHashMap.get("tagstr") != null)
        str2 = localHashMap.get("tagstr").toString();
      if (localHashMap.get("tagstring") != null)
        str3 = localHashMap.get("tagstring").toString();
      str4 = localTagbase.getAttrValue(str2, "id");
      str5 = localTagbase.getAttrValue(str2, "cmodel");
      str5 = StrReplace.replace(str5, " ", "");
      str6 = localTagbase.getAttrValue(str2, "name");
      if (str5.equals("news"))
      {
        NewsIntf localNewsIntf = new NewsIntf();
        ArrayList localArrayList2 = new ArrayList();
        try
        {
          localArrayList2 = localNewsIntf.getNewsInfo(str4);
          paramString = replaceInfoStr(localArrayList2, paramString, str6, str3);
        }
        catch (SaasApplicationException localSaasApplicationException)
        {
          System.out.println(localSaasApplicationException);
        }
      }
    }
    return paramString;
  }

  public String buildAdv(String paramString)
    throws SaasApplicationException
  {
    Tagbase localTagbase = new Tagbase();
    AdvertiseIntf localAdvertiseIntf = new AdvertiseIntf();
    ArrayList localArrayList = new ArrayList();
    localTagbase.setNameSpace("ecms", "myad", "{", "/}");
    localTagbase.setInstr(paramString);
    localArrayList = localTagbase.getSpecTagList();
    if (localArrayList == null)
      return paramString;
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      if (localHashMap1.get("tagname") != null)
        str1 = localHashMap1.get("tagname").toString();
      if (localHashMap1.get("tagstr") != null)
        str2 = localHashMap1.get("tagstr").toString();
      if (localHashMap1.get("tagstring") != null)
        str3 = localHashMap1.get("tagstring").toString();
      str4 = localTagbase.getAttrValue(str2, "name");
      HashMap localHashMap2 = localAdvertiseIntf.getInfoByCustAdvId(str4);
      String str5 = "";
      String str6 = "";
      String str7 = "";
      String str8 = "";
      if (localHashMap2 != null)
      {
        if (localHashMap2.get("n_content") != null)
          str5 = localHashMap2.get("n_content").toString();
        if (localHashMap2.get("p_content") != null)
          str6 = localHashMap2.get("p_content").toString();
        if (localHashMap2.get("time_limit") != null)
          str7 = localHashMap2.get("time_limit").toString();
        if (localHashMap2.get("end_date") != null)
          str8 = localHashMap2.get("end_date").toString();
      }
      String str9 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      if ((!str7.equals("")) && (str7.equals("0")))
        paramString = StrReplace.replace(paramString, str3, str5);
      if ((!str7.equals("")) && (str7.equals("1")))
        if (str9.compareTo(str8) > 0)
          paramString = StrReplace.replace(paramString, str3, str6);
        else
          paramString = StrReplace.replace(paramString, str3, str5);
    }
    return paramString;
  }

  public String replaceInfoStr(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if (paramArrayList != null)
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        if (localHashMap.get(paramString2) == null)
          continue;
        paramString1 = StrReplace.replace(paramString1, paramString3, localHashMap.get(paramString2).toString());
        break;
      }
    return paramString1;
  }

  public String buildArticleInfo(HashMap paramHashMap1, HashMap paramHashMap2, String paramString)
    throws SaasApplicationException
  {
    Tagbase localTagbase = new Tagbase();
    ArrayList localArrayList1 = new ArrayList();
    localTagbase.setNameSpace("ecms", "field", "{", "/}");
    localTagbase.setInstr(paramString);
    localArrayList1 = localTagbase.getSpecTagList();
    if (localArrayList1 == null)
      return paramString;
    if (paramHashMap1 == null)
      return paramString;
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    if (paramHashMap1.get("ch_id") != null)
      str1 = paramHashMap1.get("ch_id").toString();
    if (paramHashMap1.get("info_id") != null)
      str2 = paramHashMap1.get("info_id").toString();
    if (paramHashMap1.get("cust_id") != null)
      str4 = paramHashMap1.get("cust_id").toString();
    if (paramHashMap1.get("contents") != null)
      str5 = paramHashMap1.get("contents").toString();
    ChannelIntf localChannelIntf = new ChannelIntf();
    AttachIntf localAttachIntf = new AttachIntf();
    ArrayList localArrayList2 = new ArrayList();
    InfoIntf localInfoIntf = new InfoIntf();
    String str6 = localAttachIntf.getFilePathInfo(str2);
    String str7 = "";
    if (paramHashMap2.get("cont_mod") != null)
      str3 = paramHashMap2.get("cont_mod").toString();
    if (paramHashMap2.get("save_dir") != null)
      str7 = paramHashMap2.get("save_dir").toString();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str8 = "";
      String str9 = "";
      String str10 = "";
      String str11 = "";
      String str12 = "";
      if (localHashMap.get("tagname") != null)
        str8 = localHashMap.get("tagname").toString();
      if (localHashMap.get("tagstr") != null)
        str9 = localHashMap.get("tagstr").toString();
      if (localHashMap.get("tagstring") != null)
        str10 = localHashMap.get("tagstring").toString();
      str11 = localTagbase.getAttrValue(str9, "name");
      str12 = localTagbase.getAttrValue(str9, "type");
      if ((str11.equals("title")) && ((str5.equals("11")) || (str5.equals("01"))))
        paramString = StrReplace.replace(paramString, str10, "<b>" + paramHashMap1.get(str11).toString() + "</b>");
      if ((str11.equals("src")) && (paramHashMap1.get("src") != null) && (!paramHashMap1.get("src").toString().equals("")))
        paramString = StrReplace.replace(paramString, str10, "转载来源：" + paramHashMap1.get(str11).toString());
      if (str11.equals("all_img"))
        paramString = StrReplace.replace(paramString, str10, str6);
      if (str11.equals("mini_img"))
        if (paramHashMap1.get(str11) != null)
        {
          if (paramHashMap1.get(str11).toString().equals(""))
            paramString = StrReplace.replace(paramString, str10, this.default_img);
          else
            paramString = StrReplace.replace(paramString, str10, paramHashMap1.get(str11).toString());
        }
        else
          paramString = StrReplace.replace(paramString, str10, this.default_img);
      if ((str11.equals("qq")) && (paramHashMap1.get(str11) == null))
        paramString = StrReplace.replace(paramString, str10, "");
      if (str11.equals("video_obj"))
        if (paramHashMap1.get(str11) == null)
        {
          paramString = StrReplace.replace(paramString, str10, "");
        }
        else
        {
          String str13 = new Attachinfo().getVideoFilePath(str2);
          paramString = StrReplace.replace(paramString, str10, str13);
        }
      if (str11.equals("infoarea"))
        paramString = StrReplace.replace(paramString, str10, localInfoIntf.getAreaStringByCustId(str4, str7, str12));
      if (str11.equals("infoclass"))
        paramString = StrReplace.replace(paramString, str10, localInfoIntf.getClassStringByInfoId(str2, str7, str12));
      if (str11.equals("infochannel"))
        paramString = StrReplace.replace(paramString, str10, localInfoIntf.getChannelStringByInfoId(str2, str12));
      if (paramHashMap1.get(str11) != null)
        paramString = StrReplace.replace(paramString, str10, paramHashMap1.get(str11).toString());
      else
        paramString = StrReplace.replace(paramString, str10, "");
    }
    return paramString;
  }

  public String buildInclude(String paramString)
    throws SaasApplicationException
  {
    Tagbase localTagbase = new Tagbase();
    ArrayList localArrayList = new ArrayList();
    localTagbase.setNameSpace("ecms", "include", "{", "/}");
    localTagbase.setInstr(paramString);
    localArrayList = localTagbase.getSpecTagList();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      if (localHashMap.get("tagname") != null)
        str1 = localHashMap.get("tagname").toString();
      if (localHashMap.get("tagstr") != null)
        str2 = localHashMap.get("tagstr").toString();
      if (localHashMap.get("tagstring") != null)
        str3 = localHashMap.get("tagstring").toString();
      str4 = localTagbase.getAttrValue(str2, "file");
      String str5 = FileIO.LoadFile(this.ecms_path + str4);
      paramString = StrReplace.replace(paramString, str3, str5);
    }
    return paramString;
  }

  public String buildListpage(String paramString, HashMap paramHashMap)
    throws SaasApplicationException
  {
    Tagbase localTagbase = new Tagbase();
    ArrayList localArrayList1 = new ArrayList();
    localTagbase.setNameSpace("ecms", "listpage", "{", "/}");
    String str1 = "index.html";
    localTagbase.setInstr(paramString);
    localArrayList1 = localTagbase.getSpecTagList();
    InfoIntf localInfoIntf = new InfoIntf();
    int i = 0;
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    int j = 0;
    int k = 1000;
    if (paramHashMap.get("area_code") != null)
      str2 = paramHashMap.get("area_code").toString();
    if ((str2.equals("")) || (str2.equals("5J2mc0X0G85BH")))
      str2 = "0";
    if (paramHashMap.get("class_id") != null)
      str4 = paramHashMap.get("class_id").toString();
    if (str4.equals(""))
      str4 = "0";
    if (paramHashMap.get("cont_mod") != null)
      str3 = paramHashMap.get("cont_mod").toString();
    if (paramHashMap.get("ch_id") != null)
    {
      str5 = paramHashMap.get("ch_id").toString();
      try
      {
        if (str5.equals("3070785011"))
          str5 = "2263836050";
        i = localInfoIntf.getInfoCountByChId(str5, str3);
        if (!str2.equals("0"))
        {
          ArrayList localArrayList2 = localInfoIntf.getInfoListByAreaCode(j, k, str5, str2, str3);
          if (localArrayList2 != null)
            i = localArrayList2.size();
        }
        if (!str4.equals("0"))
          i = localInfoIntf.getInfoListByClassId(str5, str4, str3);
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    if (paramHashMap.get("default_page") != null)
      str1 = paramHashMap.get("default_page").toString();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str6 = "";
      String str7 = "";
      String str8 = "";
      String str9 = "";
      String str10 = "0";
      if (localHashMap.get("tagname") != null)
        str6 = localHashMap.get("tagname").toString();
      if (localHashMap.get("tagstr") != null)
        str7 = localHashMap.get("tagstr").toString();
      if (localHashMap.get("tagstring") != null)
        str8 = localHashMap.get("tagstring").toString();
      int m = 0;
      int n = 1;
      String str11 = "";
      str9 = localTagbase.getAttrValue(str7, "row");
      str10 = localTagbase.getAttrValue(str7, "type");
      if (i > 0)
      {
        int i1 = (i - 1) / Integer.parseInt(str9) + 1;
        while (m < i)
        {
          m += Integer.parseInt(str9);
          if (i1 == 1)
          {
            str11 = "<span>共" + i + "页</span>";
            break;
          }
          if (i1 == 2)
          {
            str11 = "<span id=fenye1><a href=./" + str1 + ">[首页]</a>第1页<a href=2.html>[下一页]</a>共2页&nbsp;共" + i + "条<a href=2.html>[最后]</a></span>" + "<span id=fenye2 style=\"display:none;\">第2页<a href=" + str1 + ">[上一页]</a>共2页&nbsp;共" + i + "条<a href=2.html>[最后]</a></span>" + "<script language=\"javascript\">" + "var urlhref = window.location.href;" + "var pageNum = urlhref.substring(urlhref.lastIndexOf(\"/\")+1,urlhref.lastIndexOf(\".\"));" + "if(isNaN(pageNum)){" + "document.getElementById(\"fenye1\").style.display=\"block\";" + "}else{" + "document.getElementById(\"fenye2\").style.display=\"block\";" + "document.getElementById(\"fenye1\").style.display=\"none\";" + "}" + "</script>";
            break;
          }
          String str12;
          if ((i1 >= 3) && (i1 < 10))
          {
            str12 = "<script language=\"javascript\">var totalPage = " + i1 + ";" + "var urlhref = window.location.href;" + "var pageNum = urlhref.substring(urlhref.lastIndexOf(\"/\")+1,urlhref.lastIndexOf(\".\"));" + "for(var i=1;i<=totalPage;i++){" + "if(pageNum==i){" + "document.getElementById(\"fenye\"+i).style.display=\"block\";" + "}else{" + "document.getElementById(\"fenye\"+i).style.display=\"none\";" + "}" + "}" + "if(isNaN(pageNum)){" + "document.getElementById(\"fenye1\").style.display=\"block\";" + "}" + "</script>";
            if (n == 1)
            {
              str11 = str11 + "<span id=fenye1><a href=./" + str1 + ">[首页]</a>第1页<a href=2.html>[下一页]</a><a href=" + i1 + ".html>[最后]</a>共" + i1 + "页&nbsp;共" + i + "条</span>";
              str11 = str11 + str12;
            }
            else if (n == 2)
            {
              str11 = str11 + "<span id=fenye2 style=\"display:none;\"><a href=./" + str1 + ">[首页]</a>第2页<a href=" + str1 + ">[上一页]</a><a href=3.html>[下一页]</a><a href=" + i1 + ".html>[最后]</a>共" + i1 + "页&nbsp;共" + i + "条</span>";
              str11 = str11 + str12;
            }
            else if ((n >= 3) && (n <= 9))
            {
              if (n == i1)
                str11 = str11 + "<span id=fenye" + n + " style=\"display:none;\"><a href=./" + str1 + ">[首页]</a>第" + n + "页<a href=" + (n - 1) + ".html>[上一页]</a><a href=" + i1 + ".html>[最后]</a>共" + i1 + "页&nbsp;共" + i + "条</span>";
              else
                str11 = str11 + "<span id=fenye" + n + " style=\"display:none;\"><a href=./" + str1 + ">[首页]</a>第" + n + "页<a href=" + (n - 1) + ".html>[上一页]</a><a href=" + (n + 1) + ".html>[下一页]</a><a href=" + i1 + ".html>[最后]</a>共" + i1 + "页&nbsp;共" + i + "条</span>";
              str11 = str11 + str12;
            }
          }
          if (i1 >= 10)
          {
            str12 = "<script language=\"javascript\">var totalPage = 9;var urlhref = window.location.href;var pageNum = urlhref.substring(urlhref.indexOf(\"=\")+1,urlhref.lastIndexOf(\"&\"));if(pageNum==''){pageNum = urlhref.substring(urlhref.lastIndexOf(\"/\")+1,urlhref.lastIndexOf(\".\"));}for(var i=1;i<=totalPage;i++){if(pageNum==i){document.getElementById(\"fenye\"+i).style.display=\"block\";}else{document.getElementById(\"fenye\"+i).style.display=\"none\";}}if(isNaN(pageNum)){document.getElementById(\"fenye1\").style.display=\"block\";}if(pageNum>=10){var data = Math.round(Math.random() * 10000);var myAjax = new Ajax.Updater('list_left_box','/member/comm/getArticleList.jsp?area_code=" + str2 + "&class_id=" + str4 + "&ch_id=" + str5 + "&now_page='+pageNum+'&cont_mod=" + str3 + "&total_page=" + i1 + "&total_num=" + i + "&row=" + str9 + "&data=' + data, {" + "method : 'post'," + "evalScripts : true" + "});" + "}" + "</script>";
            if (n == 1)
            {
              str11 = str11 + "<span id=fenye1><a href=./" + str1 + ">[首页]</a>第1页<a href=2.html>[下一页]</a><a href=list.html?page=" + i1 + "&row=" + str9 + ">[最后]</a>共" + i1 + "页&nbsp;共" + i + "条</span>";
              str11 = str11 + str12;
            }
            else if (n == 2)
            {
              str11 = str11 + "<span id=fenye2 style=\"display:none;\"><a href=./" + str1 + ">[首页]</a>第2页<a href=" + str1 + ">[上一页]</a><a href=3.html>[下一页]</a><a href=list.html?page=" + i1 + "&row=" + str9 + ">[最后]</a>共" + i1 + "页&nbsp;共" + i + "条</span>";
              str11 = str11 + str12;
            }
            else if ((n >= 3) && (n < 9))
            {
              str11 = str11 + "<span id=fenye" + n + " style=\"display:none;\"><a href=./" + str1 + ">[首页]</a>第" + n + "页<a href=" + (n - 1) + ".html>[上一页]</a><a href=" + (n + 1) + ".html>[下一页]</a><a href=list.html?page=" + i1 + "&row=" + str9 + ">[最后]</a>共" + i1 + "页&nbsp;共" + i + "条</span>";
              str11 = str11 + str12;
            }
            else if (n == 9)
            {
              str11 = str11 + "<span id=fenye" + n + " style=\"display:none;\"><a href=./" + str1 + ">[首页]</a>第" + n + "页<a href=" + (n - 1) + ".html>[上一页]</a><a href=list.html?page=" + (n + 1) + "&row=" + str9 + ">[下一页]</a><a href=list.html?page=" + i1 + "&row=" + str9 + ">[最后]</a>共" + i1 + "页&nbsp;共" + i + "条</span>";
              str11 = str11 + str12;
            }
          }
          n += 1;
        }
        paramString = StrReplace.replace(paramString, str8, str11);
      }
      else
      {
        paramString = StrReplace.replace(paramString, str8, "");
      }
    }
    return paramString;
  }

  public String getListpage(String paramString)
  {
    Tagbase localTagbase = new Tagbase();
    ArrayList localArrayList = new ArrayList();
    localTagbase.setNameSpace("ecms", "listpage", "{", "/}");
    localTagbase.setInstr(paramString);
    localArrayList = localTagbase.getSpecTagList();
    String str1 = "";
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      String str3 = "";
      String str4 = "";
      if (localHashMap.get("tagname") != null)
        str2 = localHashMap.get("tagname").toString();
      if (localHashMap.get("tagstr") != null)
        str3 = localHashMap.get("tagstr").toString();
      if (localHashMap.get("tagstring") != null)
        str4 = localHashMap.get("tagstring").toString();
      str1 = localTagbase.getAttrValue(str3, "row");
    }
    return str1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.ParseNoneLoop
 * JD-Core Version:    0.6.0
 */