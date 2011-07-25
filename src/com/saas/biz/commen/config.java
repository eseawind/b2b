package com.saas.biz.commen;

import com.saas.sys.log.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class config
{
  Logger log = new Logger(this);
  ArrayList config_cont = new ArrayList();
  public static final String HTTP = "http://soft.bizoss.com";

  public void init()
  {
    String str1 = Thread.currentThread().getContextClassLoader().getResource("").toString();
    String str2 = str1.substring(5, str1.length()) + "login.properties";
    try
    {
      FileReader localFileReader = new FileReader(str2);
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      for (String str3 = localBufferedReader.readLine(); str3 != null; str3 = localBufferedReader.readLine())
      {
        if ((str3.trim().equalsIgnoreCase("")) || (str3.substring(0, 1).equalsIgnoreCase("#")))
          continue;
        String[] arrayOfString = str3.split("=");
        HashMap localHashMap = new HashMap();
        localHashMap.put("name", arrayOfString[0].toUpperCase());
        localHashMap.put("value", arrayOfString[1]);
        this.config_cont.add(localHashMap);
      }
      localBufferedReader.close();
      localBufferedReader = null;
      localFileReader.close();
      localFileReader = null;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("[init]读取配置文件出错!" + str2);
    }
  }

  public String getLogPath()
  {
    String str1 = Thread.currentThread().getContextClassLoader().getResource("").toString();
    String str2 = str1.substring(5, str1.length()) + "login.properties";
    return str2;
  }

  public ArrayList getLogProperties()
  {
    String str1 = Thread.currentThread().getContextClassLoader().getResource("").toString();
    String str2 = str1.substring(5, str1.length()) + "login.properties";
    try
    {
      FileReader localFileReader = new FileReader(str2);
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      for (String str3 = localBufferedReader.readLine(); str3 != null; str3 = localBufferedReader.readLine())
      {
        if (str3.trim().equalsIgnoreCase(""))
          continue;
        HashMap localHashMap = new HashMap();
        String[] arrayOfString;
        if (!str3.substring(0, 1).equalsIgnoreCase("#"))
        {
          arrayOfString = str3.split("=");
          localHashMap.put("name", arrayOfString[0]);
          localHashMap.put("value", arrayOfString[1]);
        }
        if (str3.substring(0, 1).equalsIgnoreCase("#"))
        {
          arrayOfString = str3.split("#");
          localHashMap.put("help", arrayOfString[1]);
        }
        this.config_cont.add(localHashMap);
      }
      localBufferedReader.close();
      localBufferedReader = null;
      localFileReader.close();
      localFileReader = null;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("[init]读取配置文件出错!" + str2);
    }
    return this.config_cont;
  }

  public String getString(String paramString)
  {
    if (this.config_cont.isEmpty())
      throw new RuntimeException("配置文件没有初始化,[getString]操作失败!");
    String str = "";
    Iterator localIterator = this.config_cont.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if ((localHashMap.get("name") != null) && (localHashMap.get("name").toString().equalsIgnoreCase(paramString)))
      {
        str = localHashMap.get("value").toString();
        break;
      }
      if (!localIterator.hasNext())
        return null;
    }
    return str;
  }

  public int getConfigSize()
  {
    if (this.config_cont.isEmpty())
      throw new RuntimeException("配置文件没有初始化,[getString]操作失败!");
    return this.config_cont.size();
  }

  public void WriteToFile(String paramString)
  {
    String str1 = Thread.currentThread().getContextClassLoader().getResource("").toString();
    String str2 = str1.substring(5, str1.length()) + "login.properties";
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str2)));
      localBufferedWriter.write(paramString);
      localBufferedWriter.flush();
      localBufferedWriter.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.config
 * JD-Core Version:    0.6.0
 */