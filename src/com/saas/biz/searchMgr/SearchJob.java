package com.saas.biz.searchMgr;

import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.channelMgr.ChannelInfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.commen.config;
import com.saas.biz.infoListMgr.InfoList;
import com.saas.biz.pricerankMgr.JoinListTool;
import com.saas.biz.pricerankMgr.PriceRankInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;

public class SearchJob
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  commMethodMgr commen = new commMethodMgr();
  ArrayList queryResult = new ArrayList();

  public static void main(String[] paramArrayOfString)
  {
    SearchJob localSearchJob = new SearchJob();
    try
    {
      localSearchJob.queryResult = localSearchJob.doSearchoil("0139", 0, "通信", "");
      System.out.println(localSearchJob.queryResult);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      localSearchJob.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
  }

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void doSearchoil(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入doSearchoil方法...");
    String str1 = paramBuffers.getStringWeb("RSRV_STR1");
    String str2 = paramBuffers.getStringWeb("RSRV_STR4");
    int i = paramBuffers.getInt("START");
    String str3 = "";
    if (str2.equalsIgnoreCase("1"))
      str3 = paramBuffers.getStringWeb("RSRV_STR2");
    else
      str3 = paramBuffers.getString("RSRV_STR2");
    try
    {
      this.queryResult = doSearchoil(str1, i, str3, "");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.outBuffer.setString("DISPALY_STYLE", "0");
    this.log.LOG_INFO("退出doSearchoil方法...");
  }

  public String getImge(String paramString)
    throws SaasApplicationException
  {
    Attachinfo localAttachinfo = new Attachinfo();
    ArrayList localArrayList = localAttachinfo.getAttachInfoByList(paramString);
    String str = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("file_path") != null)
        str = localHashMap.get("file_path").toString();
    }
    return str;
  }

  public String getSearshRusult(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    int i = paramInt;
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 5;
    StringBuffer localStringBuffer = new StringBuffer("");
    PriceRankInfo localPriceRankInfo = new PriceRankInfo();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localArrayList2 = localPriceRankInfo.getSearchRank(paramString2, paramString1);
    try
    {
      localArrayList1 = doSearchoil(paramString1, 1, paramString2, paramString3);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      localSaasApplicationException.printStackTrace();
    }
    localArrayList3 = JoinListTool.joinList(localArrayList2, localArrayList1);
    if ((null != localArrayList3) && (localArrayList3.size() > 0))
    {
      j = (int)Math.ceil(localArrayList3.size() / 5.0D);
      for (int k = paramInt; (k < paramInt + 5) && (k < localArrayList3.size()); k++)
      {
        HashMap localHashMap = (HashMap)localArrayList3.get(k);
        if (localHashMap.get("title") != null)
          str1 = localHashMap.get("title").toString();
        if (localHashMap.get("link") != null)
          str2 = localHashMap.get("link").toString();
        if (localHashMap.get("publish_date") != null)
          str4 = localHashMap.get("publish_date").toString();
        if (localHashMap.get("content") != null)
          str3 = localHashMap.get("content").toString();
        localStringBuffer.append("<div id=\"" + k + "\" class=\"search_body\"><h3><a href=\"" + str2 + "\" target=\"_blank\" >" + str1 + "</a></h3><p>" + str3 + "</p><span>" + str2 + "-发布于" + str4 + "</span></div>");
      }
    }
    else
    {
      localStringBuffer.append("<div><ul><li>没有相匹配的结果！</li></ul></div>");
    }
    localStringBuffer.append("<div align=\"center\">");
    for (int k = 1; k <= j; k++)
      if (k == i)
        localStringBuffer.append(" <a style=\"color:#FF0000\" href=javascript:dopage(" + k + ");>" + k + "</a>");
      else
        localStringBuffer.append(" <a href=javascript:dopage(" + k + ");>" + k + "</a>");
    localStringBuffer.append("</div>");
    return localStringBuffer.toString();
  }

  public ArrayList doSearchoil(String paramString1, int paramInt, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入doSearchoil方法...");
    ArrayList localArrayList = new ArrayList();
    config localconfig = new config();
    localconfig.init();
    String str1 = localconfig.getString("mysqlbase.rootpath");
    String str2 = str1 + "index/";
    IndexReader localIndexReader = null;
    int i = 0;
    String str3 = "";
    String str4 = paramString2;
    InfoList localInfoList = new InfoList();
    ChannelInfo localChannelInfo = new ChannelInfo();
    String str5 = "";
    String str6 = "";
    this.log.LOG_INFO("你到哪了？11" + str2);
    try
    {
      localIndexReader = IndexReader.open(str2);
      IndexSearcher localIndexSearcher = new IndexSearcher(localIndexReader);
      StandardAnalyzer localStandardAnalyzer = new StandardAnalyzer();
      Object localObject = null;
      Query localQuery1 = null;
      Query localQuery2 = null;
      QueryParser localQueryParser = null;
      if (paramString1.equalsIgnoreCase("5563378845"))
      {
        paramString2 = "rage:customerRage AND contents:" + paramString2 + " OR title:" + paramString2;
        str3 = "/wood/enterprise/d/content-";
        localQueryParser = new QueryParser("rage", localStandardAnalyzer);
        localQuery1 = localQueryParser.parse("customerRage");
      }
      else if (paramString1.equalsIgnoreCase("7830633062"))
      {
        paramString2 = "rage:saleRage AND contents:" + paramString2 + " OR title:" + paramString2;
        str3 = "/wood/supply/d/content-";
        localQueryParser = new QueryParser("rage", localStandardAnalyzer);
        localQuery1 = localQueryParser.parse("saleRage");
      }
      else if (paramString1.equalsIgnoreCase("6871426767"))
      {
        paramString2 = "rage:stockRage AND contents:" + paramString2 + " OR title:" + paramString2;
        str3 = "/wood/stock/d/content-";
        localQueryParser = new QueryParser("rage", localStandardAnalyzer);
        localQuery1 = localQueryParser.parse("stockRage");
      }
      else if (paramString1.equalsIgnoreCase("0156"))
      {
        paramString2 = "rage:jobRage AND contents:" + paramString2 + " OR title:" + paramString2;
        str3 = "../hr/r/d/hr_r_";
      }
      else if (paramString1.equalsIgnoreCase("0140"))
      {
        paramString2 = "rage:commodityRage AND contents:" + paramString2 + " OR title:" + paramString2;
        str3 = "../product/detail/product";
      }
      else if (paramString1.equalsIgnoreCase("0411"))
      {
        paramString2 = "rage:infoRage AND contents:" + paramString2 + " OR title:" + paramString2;
        str3 = "/wood/supply/d/content-";
      }
      else if (paramString1.equalsIgnoreCase("1455415210"))
      {
        paramString2 = "rage:infoRage AND contents:" + paramString2 + " OR title:" + paramString2;
        str3 = "/wood/news/d/content-";
        localQueryParser = new QueryParser("rage", localStandardAnalyzer);
        localQuery1 = localQueryParser.parse("infoRage");
      }
      else if (paramString1.equalsIgnoreCase("8855381456"))
      {
        paramString2 = "rage:productRage AND contents:" + paramString2 + " OR title:" + paramString2;
        str3 = "/wood/product/d/content-";
        localQueryParser = new QueryParser("rage", localStandardAnalyzer);
        localQuery1 = localQueryParser.parse("productRage");
      }
      BooleanClause.Occur[] arrayOfOccur = { BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD };
      localQuery2 = MultiFieldQueryParser.parse(str4, new String[] { "title", "contents" }, arrayOfOccur, localStandardAnalyzer);
      BooleanQuery localBooleanQuery = new BooleanQuery();
      localBooleanQuery.add(localQuery1, BooleanClause.Occur.MUST);
      localBooleanQuery.add(localQuery2, BooleanClause.Occur.MUST);
      Hits localHits = localIndexSearcher.search(localBooleanQuery);
      String str7 = String.valueOf(localHits.length());
      int j = localHits.length();
      for (int k = i; k < j; k++)
      {
        Document localDocument = localHits.doc(k);
        String str8 = localDocument.get("id");
        String str9 = localDocument.get("title");
        String str10 = localDocument.get("contents");
        String str11 = localDocument.get("publisher");
        String str12 = localDocument.get("publish_date");
        str10 = str10.replaceAll("&nbsp;", "");
        str10 = str10.replaceAll("<[^<>]+>", "");
        if (str10.length() > 80)
          str10 = "    " + this.commen.splitStr(str10, 160) + "...";
        str10 = str10.replaceAll("<A", "");
        str10 = str10.replaceAll("<a", "");
        if (str12.length() > 10)
          str12 = str12.substring(0, 10);
        HashMap localHashMap = new HashMap();
        str5 = localInfoList.getChannelCh_idByInfo(str8);
        if (!str5.equals(""))
          str6 = localChannelInfo.getSaveDir(str5);
        String str13 = "http://" + paramString3 + "/" + str6 + "/d/content-" + str8 + ".html";
        if (paramString1.equalsIgnoreCase("0161"))
          str13 = str3 + str8;
        String str14 = "";
        str14 = getImge(str8);
        localHashMap.put("id", str8);
        localHashMap.put("title", str9);
        localHashMap.put("content", str10);
        localHashMap.put("link", str13);
        localHashMap.put("pic_path", str14);
        localHashMap.put("count", str7);
        localHashMap.put("publisher", str11);
        localHashMap.put("publish_date", str12);
        localArrayList.add(localHashMap);
      }
      localIndexReader.close();
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.searchMgr.SearchJob
 * JD-Core Version:    0.6.0
 */