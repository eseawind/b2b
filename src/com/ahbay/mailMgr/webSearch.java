package com.ahbay.mailMgr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class webSearch
{
  public String StartSearch(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
      localHttpURLConnection.connect();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
      String str2 = "C:\\Tomcat 5.0\\webapps\\WebManager\\web_it\\searchResult.htm";
      File localFile = new File(str2);
      if (localFile.exists())
        localFile.delete();
      FileWriter localFileWriter = new FileWriter(str2);
      String str1;
      while ((str1 = localBufferedReader.readLine()) != null)
        try
        {
          localFileWriter.write(str1);
          localFileWriter.write("\n");
        }
        catch (IOException localIOException)
        {
          return localIOException.getMessage();
        }
      localFileWriter.close();
    }
    catch (Exception localException)
    {
      return localException.getMessage();
    }
    return "1";
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.mailMgr.webSearch
 * JD-Core Version:    0.6.0
 */