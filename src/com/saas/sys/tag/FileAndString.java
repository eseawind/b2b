package com.saas.sys.tag;

import com.base.config.ProjectConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import tools.util.StrReplace;

public class FileAndString
{
  public String f2s(String paramString)
  {
    String str1 = "";
    try
    {
      FileReader localFileReader = new FileReader(paramString);
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      String str2 = "";
      while ((str2 = localBufferedReader.readLine()) != null)
      {
        str2 = StrReplace.replace(str2, "{#comm:webtitle#}", ProjectConfig.WEBTITLE);
        str2 = StrReplace.replace(str2, "{#comm:bottom#}", ProjectConfig.BOTTOM);
        str2 = StrReplace.replace(str2, "{#comm:logopath#}", ProjectConfig.LOGOPATH);
        str2 = StrReplace.replace(str2, "{#comm:webname#}", ProjectConfig.WEBNAME);
        str2 = StrReplace.replace(str2, "{#comm:webadd#}", ProjectConfig.WEBADD);
        str2 = StrReplace.replace(str2, "{#comm:webdesc#}", ProjectConfig.WEBDESC);
        str2 = str2 + "\n";
        str1 = str1 + str2;
      }
    }
    catch (Exception localException)
    {
      System.out.print(localException.getMessage());
    }
    return str1;
  }

  public int s2f(String paramString1, String paramString2)
  {
    return s2f(paramString1, paramString2, -1);
  }

  public int s2f(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    try
    {
      FileWriter localFileWriter = null;
      File localFile = new File(paramString2);
      localFile.getParentFile().mkdir();
      if (paramInt > 0)
        localFileWriter = new FileWriter(localFile, true);
      else
        localFileWriter = new FileWriter(localFile, false);
      localFileWriter.write(paramString1);
      localFileWriter.close();
      i = 1;
    }
    catch (Exception localException)
    {
      i = 0;
      System.out.println("s2f error : " + localException.getMessage() + " , " + paramString2);
    }
    return i;
  }

  public String url2string(String paramString)
  {
    try
    {
      InputStream localInputStream = null;
      URL localURL = new URL(paramString);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
      localHttpURLConnection.connect();
      StringBuffer localStringBuffer = new StringBuffer(" ");
      localInputStream = localHttpURLConnection.getInputStream();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
      String str;
      while ((str = localBufferedReader.readLine()) != null)
        localStringBuffer.append(str);
      localHttpURLConnection.disconnect();
      localInputStream.close();
      return localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      System.out.println(" get web page error message :" + localException.getMessage());
      return " get web page error message :" + localException.getMessage();
    }
   
  }

  public void linkedlist2file(LinkedList paramLinkedList, String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(" ");
    for (int i = 0; i < paramLinkedList.size(); i++)
      localStringBuffer.append((String)paramLinkedList.get(i) + "\n");
    if (paramBoolean == true)
      s2f(localStringBuffer.toString(), paramString, 1);
    else
      s2f(localStringBuffer.toString(), paramString, -1);
  }

  public void linkedlist2file(LinkedList paramLinkedList, String paramString)
  {
    linkedlist2file(paramLinkedList, paramString, false);
  }

  public LinkedList file2linkedlist(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      FileReader localFileReader = new FileReader(paramString);
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      String str = "";
      while ((str = localBufferedReader.readLine()) != null)
        localLinkedList.add(str);
    }
    catch (Exception localException)
    {
      System.out.println(localException.getMessage());
    }
    return localLinkedList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.tag.FileAndString
 * JD-Core Version:    0.6.0
 */