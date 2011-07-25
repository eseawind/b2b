package com.saas.biz.commen;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Charset
{
  private String gb = "GBK";

  public String to_ISO(String paramString)
  {
    Object localObject = paramString;
    try
    {
      String str = new String(paramString.getBytes(), "ISO-8859-1");
      localObject = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    if (((String)localObject).compareTo("") == 0);
    return (String)localObject;
  }

  public String to_UTF(String paramString)
  {
    Object localObject = paramString;
    try
    {
      String str = new String(paramString.getBytes(), "UTF-8");
      localObject = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    if (((String)localObject).compareTo("") == 0);
    return (String)localObject;
  }

  public String to_GB(String paramString)
  {
    Object localObject = paramString;
    try
    {
      String str = new String(paramString.getBytes(), "gb2312");
      localObject = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return (String)localObject;
  }

  public String enCode(String paramString)
  {
    String str = paramString;
    try
    {
      str = URLEncoder.encode(paramString, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return str;
  }

  public String enCode(String paramString1, String paramString2)
  {
    String str = paramString1;
    try
    {
      str = URLEncoder.encode(paramString1, paramString2);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return str;
  }

  public String ISO_2_GBK(String paramString)
  {
    String str2;
    try
    {
      String str1 = new String(paramString.getBytes("iso-8859-1"), this.gb);
      return str1;
    }
    catch (Exception localException)
    {
      str2 = "";
    }
    return str2;
  }

  public String GBK_2_ISO(String paramString)
  {
    String str2;
    try
    {
      String str1 = new String(paramString.getBytes(this.gb), "iso-8859-1");
      return str1;
    }
    catch (Exception localException)
    {
      str2 = "";
    }
    return str2;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.Charset
 * JD-Core Version:    0.6.0
 */