package com.saas.biz.searchMgr;

import com.ahbay.commenMgr.DataBaseCommMgr;
import com.saas.biz.commen.config;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;

public class IndexFiles
{
  public static void main(String[] paramArrayOfString)
  {
    config localconfig = new config();
    localconfig.init();
    File localFile = new File(localconfig.getString("mysqlbase.rootpath") + "index");
    try
    {
      IndexWriter localIndexWriter = new IndexWriter(localFile, new StandardAnalyzer(), true);
      indexDocs(localIndexWriter);
      System.out.println("Optimizing...");
      localIndexWriter.optimize();
      localIndexWriter.close();
    }
    catch (IOException localIOException)
    {
      System.out.println(" caught a " + localIOException.getClass() + "\n with message: " + localIOException.getMessage());
    }
  }

  public void updateSelect()
  {
    config localconfig = new config();
    localconfig.init();
    File localFile = new File(localconfig.getString("mysqlbase.rootpath") + "index");
    try
    {
      IndexWriter localIndexWriter = new IndexWriter(localFile, new StandardAnalyzer(), true);
      indexDocs(localIndexWriter);
      System.out.println("Optimizing...");
      localIndexWriter.optimize();
      localIndexWriter.close();
    }
    catch (IOException localIOException)
    {
      System.out.println(" caught a " + localIOException.getClass() + "\n with message: " + localIOException.getMessage());
    }
  }

  static void indexDocs(IndexWriter paramIndexWriter)
    throws IOException
  {
    try
    {
      DataBaseCommMgr localDataBaseCommMgr1 = new DataBaseCommMgr();
      ResultSet localResultSet = null;
      ResultSetMetaData localResultSetMetaData = null;
      int i = 0;
      String str1 = "";
      String str2 = "";
      String str3 = "";
      Object localObject = "";
      String str4 = "";
      String str5 = "";
      String str6 = "";
      str6 = str6 + "select 'customerRage' rage,a.cust_id id,a.cust_aim title,a.scope content,a.cust_id publisher,a.publish_date publish_date from tf_f_customer a ,tf_f_infolist z where a.cust_id=z.info_id group by z.info_id                     ";
      str6 = str6 + "union all                                                                                                                                                          ";
      str6 = str6 + "select 'saleRage' rage,b.sale_id id,b.title title,b.content content,b.sale_unit publisher,b.publish_date  publish_date from tf_f_sale b  ,tf_f_infolist z where b.sale_id=z.info_id and b.sale_type='0' group by z.info_id                        ";
      str6 = str6 + "union all                                                                                                                                                          ";
      str6 = str6 + "select 'stockRage' rage,c.stock_id id,c.title title,c.content content ,c.cust_id publisher ,c.publish_date publish_date from tf_f_stockorder c ,tf_f_infolist z where c.stock_id=z.info_id group by z.info_id                     ";
      str6 = str6 + "union all                                                                                                                                                          ";
      str6 = str6 + "select 'productRage' rage,i.product_id id,i.product_name title,i.product_abstract content,i.cust_id publisher,i.publish_date publish_date from tf_f_product i  ,tf_f_infolist z where i.product_id=z.info_id group by z.info_id     ";
      localDataBaseCommMgr1.setStrQuery(str6);
      localResultSet = localDataBaseCommMgr1.SelBizQuery();
      try
      {
        while (localResultSet.next())
        {
          if (localResultSet.getString(1) != null)
            str1 = localResultSet.getString(1);
          else
            str1 = "";
          if (localResultSet.getString(2) != null)
            str2 = localResultSet.getString(2);
          else
            str2 = "";
          if (localResultSet.getString(3) != null)
            str3 = localResultSet.getString(3);
          else
            str3 = "";
          if (localResultSet.getString(4) != null)
            localObject = localResultSet.getString(4);
          else
            localObject = "";
          if (localResultSet.getString(5) != null)
            str4 = localResultSet.getString(5);
          else
            str4 = "";
          if (localResultSet.getString(6) != null)
            str5 = localResultSet.getString(6);
          else
            str5 = "";
          System.out.println("indexing....." + str3);
          paramIndexWriter.addDocument(FileDocument.Document(str1, str2, str3, (String)localObject, str4, str5));
        }
      }
      catch (Exception localException2)
      {
        System.out.println(localException2);
      }
      DataBaseCommMgr localDataBaseCommMgr2 = new DataBaseCommMgr();
      localResultSet = null;
      str6 = "select 'infoRage' rage,g.news_id id,g.title title,g.content content,g.cust_id publisher,g.publish_date publish_date from tf_f_news g ,tf_f_infolist z where g.news_id =z.info_id group by z.info_id ";
      localDataBaseCommMgr2.setStrQuery(str6);
      localResultSet = localDataBaseCommMgr2.SelBizQuery();
      localResultSetMetaData = localResultSet.getMetaData();
      i = localResultSetMetaData.getColumnCount();
      try
      {
        while (localResultSet.next())
        {
          if (localResultSet.getString(1) != null)
            str1 = localResultSet.getString(1);
          else
            str1 = "";
          if (localResultSet.getString(2) != null)
            str2 = localResultSet.getString(2);
          else
            str2 = "";
          if (localResultSet.getString(3) != null)
            str3 = localResultSet.getString(3);
          else
            str3 = "";
          for (int j = 1; j <= i; j++)
          {
            String str7 = localResultSetMetaData.getColumnName(j).toLowerCase();
            if (!str7.equals("content"))
              continue;
            if (localResultSet.getCharacterStream(j) != null)
            {
              Reader localReader = localResultSet.getCharacterStream(j);
              String str8 = "";
              try
              {
                str8 = getLargerString(localReader);
                localObject = str8;
              }
              catch (Exception localException4)
              {
                throw new RuntimeException(localException4);
              }
            }
            localObject = "";
            break;
          }
          if (localResultSet.getString(5) != null)
            str4 = localResultSet.getString(5);
          else
            str4 = "";
          if (localResultSet.getString(6) != null)
            str5 = localResultSet.getString(6);
          else
            str5 = "";
          System.out.println("indexing....." + str3);
          paramIndexWriter.addDocument(FileDocument.Document(str1, str2, str3, (String)localObject, str4, str5));
        }
      }
      catch (Exception localException3)
      {
        System.out.println(localException3);
      }
    }
    catch (Exception localException1)
    {
      System.out.println(localException1);
    }
  }

  public static String getLargerString(Reader paramReader)
    throws Exception
  {
    Object localObject = new char[1024000];
    char[] arrayOfChar1 = new char[1024];
    int i = 0;
    int j = 0;
    int k = 1024000;
    while (true)
    {
      i = paramReader.read(arrayOfChar1);
      if (i == -1)
        break;
      if (j + i > k)
      {
        char[] arrayOfChar2 = new char[k + 1024000];
        System.arraycopy(localObject, 0, arrayOfChar2, 0, j);
        localObject = arrayOfChar2;
        k += 1024000;
      }
      System.arraycopy(arrayOfChar1, 0, localObject, j, i);
      j += i;
    }
    return (String)new String(localObject, 0, j);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.searchMgr.IndexFiles
 * JD-Core Version:    0.6.0
 */