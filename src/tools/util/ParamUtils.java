package tools.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ParamUtils
{
  public static String getParameter(HttpServletRequest paramHttpServletRequest, String paramString)
  {
    return getParameter(paramHttpServletRequest, paramString, false);
  }

  public static String getParameter(HttpServletRequest paramHttpServletRequest, String paramString, boolean paramBoolean)
  {
    gbEncoding(paramHttpServletRequest);
    String str = paramHttpServletRequest.getParameter(paramString);
    if (str != null)
    {
      if ((str.equals("")) && (!paramBoolean))
        return null;
      return str;
    }
    return null;
  }

  private static void gbEncoding(HttpServletRequest paramHttpServletRequest)
  {
    try
    {
      paramHttpServletRequest.setCharacterEncoding("gb2312");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
  }

  public static String[] getParameters(HttpServletRequest paramHttpServletRequest, String paramString)
  {
    gbEncoding(paramHttpServletRequest);
    if (paramString == null)
      return new String[0];
    String[] arrayOfString = paramHttpServletRequest.getParameterValues(paramString);
    if ((arrayOfString == null) || (arrayOfString.length == 0))
      return new String[0];
    ArrayList localArrayList = new ArrayList(arrayOfString.length);
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if ((arrayOfString[i] == null) || ("".equals(arrayOfString[i])))
        continue;
      localArrayList.add(arrayOfString[i]);
    }
    return (String[])(String[])localArrayList.toArray(new String[0]);
  }

  public static boolean getBooleanParameter(HttpServletRequest paramHttpServletRequest, String paramString)
  {
    return getBooleanParameter(paramHttpServletRequest, paramString, false);
  }

  public static boolean getBooleanParameter(HttpServletRequest paramHttpServletRequest, String paramString, boolean paramBoolean)
  {
    gbEncoding(paramHttpServletRequest);
    String str = paramHttpServletRequest.getParameter(paramString);
    if (("true".equals(str)) || ("on".equals(str)))
      return true;
    if (("false".equals(str)) || ("off".equals(str)))
      return false;
    return paramBoolean;
  }

  public static int getIntParameter(HttpServletRequest paramHttpServletRequest, String paramString, int paramInt)
  {
    gbEncoding(paramHttpServletRequest);
    String str = paramHttpServletRequest.getParameter(paramString);
    if ((str != null) && (!str.equals("")))
    {
      int i = paramInt;
      try
      {
        i = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
      }
      return i;
    }
    return paramInt;
  }

  public static int[] getIntParameters(HttpServletRequest paramHttpServletRequest, String paramString, int paramInt)
  {
    gbEncoding(paramHttpServletRequest);
    String[] arrayOfString = paramHttpServletRequest.getParameterValues(paramString);
    if ((arrayOfString == null) || (arrayOfString.length == 0))
      return new int[0];
    int[] arrayOfInt = new int[arrayOfString.length];
    for (int i = 0; i < arrayOfString.length; i++)
      try
      {
        arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
      }
      catch (Exception localException)
      {
        arrayOfInt[i] = paramInt;
      }
    return arrayOfInt;
  }

  public static double getDoubleParameter(HttpServletRequest paramHttpServletRequest, String paramString, double paramDouble)
  {
    gbEncoding(paramHttpServletRequest);
    String str = paramHttpServletRequest.getParameter(paramString);
    if ((str != null) && (!str.equals("")))
    {
      double d = paramDouble;
      try
      {
        d = Double.parseDouble(str);
      }
      catch (Exception localException)
      {
      }
      return d;
    }
    return paramDouble;
  }

  public static long getLongParameter(HttpServletRequest paramHttpServletRequest, String paramString, long paramLong)
  {
    gbEncoding(paramHttpServletRequest);
    String str = paramHttpServletRequest.getParameter(paramString);
    if ((str != null) && (!str.equals("")))
    {
      long l = paramLong;
      try
      {
        l = Long.parseLong(str);
      }
      catch (Exception localException)
      {
      }
      return l;
    }
    return paramLong;
  }

  public static long[] getLongParameters(HttpServletRequest paramHttpServletRequest, String paramString, long paramLong)
  {
    gbEncoding(paramHttpServletRequest);
    String[] arrayOfString = paramHttpServletRequest.getParameterValues(paramString);
    if ((arrayOfString == null) || (arrayOfString.length == 0))
      return new long[0];
    long[] arrayOfLong = new long[arrayOfString.length];
    for (int i = 0; i < arrayOfString.length; i++)
      try
      {
        arrayOfLong[i] = Long.parseLong(arrayOfString[i]);
      }
      catch (Exception localException)
      {
        arrayOfLong[i] = paramLong;
      }
    return arrayOfLong;
  }

  public static String getAttribute(HttpServletRequest paramHttpServletRequest, String paramString)
  {
    return getAttribute(paramHttpServletRequest, paramString, false);
  }

  public static String getAttribute(HttpServletRequest paramHttpServletRequest, String paramString, boolean paramBoolean)
  {
    gbEncoding(paramHttpServletRequest);
    String str = (String)paramHttpServletRequest.getAttribute(paramString);
    if (str != null)
    {
      if ((str.equals("")) && (!paramBoolean))
        return null;
      return str;
    }
    return null;
  }

  public static boolean getBooleanAttribute(HttpServletRequest paramHttpServletRequest, String paramString)
  {
    gbEncoding(paramHttpServletRequest);
    String str = (String)paramHttpServletRequest.getAttribute(paramString);
    return (str != null) && (str.equals("true"));
  }

  public static int getIntAttribute(HttpServletRequest paramHttpServletRequest, String paramString, int paramInt)
  {
    gbEncoding(paramHttpServletRequest);
    String str = (String)paramHttpServletRequest.getAttribute(paramString);
    if ((str != null) && (!str.equals("")))
    {
      int i = paramInt;
      try
      {
        i = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
      }
      return i;
    }
    return paramInt;
  }

  public static long getLongAttribute(HttpServletRequest paramHttpServletRequest, String paramString, long paramLong)
  {
    gbEncoding(paramHttpServletRequest);
    String str = (String)paramHttpServletRequest.getAttribute(paramString);
    if ((str != null) && (!str.equals("")))
    {
      long l = paramLong;
      try
      {
        l = Long.parseLong(str);
      }
      catch (Exception localException)
      {
      }
      return l;
    }
    return paramLong;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.ParamUtils
 * JD-Core Version:    0.6.0
 */