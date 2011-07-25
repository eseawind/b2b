package tools.util;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class StringUtil
{
  public static boolean blnTextBox = true;

  public static String getGBKFromISO(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("iso-8859-1");
      paramString = new String(arrayOfByte, "gb2312");
      return paramString;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return "";
  }

  public static String getISO(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("iso-8859-1");
      paramString = new String(arrayOfByte);
      return paramString;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return "";
  }

  public static Vector explode(String paramString1, String paramString2)
  {
    Vector localVector = new Vector();
    try
    {
      if (paramString1.length() > 0)
      {
        int i = paramString1.indexOf(paramString2);
        int j = 0;
        while (i != -1)
        {
          localVector.addElement(paramString1.substring(j, i));
          j = i + paramString2.length();
          i = paramString1.indexOf(paramString2, j);
        }
        localVector.addElement(paramString1.substring(j));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localVector;
  }

  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    String str = new String();
    try
    {
      if (paramString1.length() > 0)
      {
        int i = paramString1.indexOf(paramString2);
        int j = 0;
        while (i != -1)
        {
          str = str + paramString1.substring(j, i);
          str = str + paramString3;
          j = i + paramString2.length();
          i = paramString1.indexOf(paramString2, j);
        }
        str = str + paramString1.substring(j);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }

  public static void setReturn(boolean paramBoolean)
  {
    blnTextBox = paramBoolean;
  }

  public static String htmlSpecialChars(String paramString)
  {
    return htmlSpecialChars(paramString, true);
  }

  public static String htmlSpecialChars(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramBoolean)
    {
      str = replace(str, "&", "&amp;");
      str = replace(str, "\"", "&quot;");
      str = replace(str, "<", "&lt;");
      str = replace(str, ">", "&gt;");
    }
    else
    {
      str = replace(str, "&amp;", "&");
      str = replace(str, "&quot;", "\"");
      str = replace(str, "&lt;", "<");
      str = replace(str, "&gt;", ">");
    }
    if (!blnTextBox)
      if (paramBoolean)
        str = replace(str, "\n", "</br>");
      else
        str = replace(str, "</br>", "\n");
    return str;
  }

  public static String trim(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    paramString = paramString.trim();
    String[] arrayOfString = paramString.split(" ");
    for (int i = 0; i < arrayOfString.length; i++)
      localStringBuffer.append(arrayOfString[i]);
    return localStringBuffer.toString();
  }

  public static String returnChar2BR(String paramString)
  {
    String str = paramString;
    str = replace(str, "\n", "</br>&nbsp;&nbsp;");
    return str;
  }

  public static String implode(Vector paramVector, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      if (!paramVector.isEmpty())
      {
        int i = paramVector.size();
        for (int j = 0; j < i; j++)
        {
          localStringBuffer.append((String)paramVector.get(j));
          if (j == i - 1)
            continue;
          localStringBuffer.append(paramString);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localStringBuffer.toString();
  }

  public static String getField(Vector paramVector, int paramInt, boolean paramBoolean)
  {
    String str = "";
    try
    {
      str = (String)paramVector.get(paramInt);
      if ((str != null) && (str.length() > 2) && (paramBoolean) && (str.substring(0, 1).compareTo("\"") == 0))
      {
        str = str.substring(1, str.length() - 1);
        str = replace(str, "\"\"", "\"");
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      System.out.println("Exceed the length of array, Please check the field number");
      return "";
    }
    return str;
  }

  public static String insStr(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    int i = paramString1.length();
    StringBuffer localStringBuffer = new StringBuffer(paramString1);
    if (i < paramInt2)
    {
      int j = paramInt2 - i;
      for (int k = 0; k < j; k++)
        if (paramInt1 == 1)
        {
          paramString1 = paramString1.concat(paramString2);
        }
        else
        {
          if (paramInt1 != 0)
            continue;
          localStringBuffer.insert(0, paramString2);
          paramString1 = localStringBuffer.toString();
        }
    }
    return paramString1;
  }

  public static int searchDiv(String paramString1, String paramString2)
  {
    String str = new String();
    str = paramString1;
    paramString2 = paramString2.trim();
    int i = -1;
    if (str != "")
    {
      i = str.indexOf(paramString2);
      return i;
    }
    return 0;
  }

  public static String extractStr(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString2.length();
    paramString1 = paramString1.trim();
    int j = -1;
    int k = -1;
    paramString2 = paramString2.trim();
    paramString3 = paramString3.trim();
    j = searchDiv(paramString1, paramString2);
    if (paramString1 != "")
    {
      if (j >= 0)
      {
        paramString1 = paramString1.substring(j + i);
        paramString1 = paramString1.trim();
      }
      k = searchDiv(paramString1, paramString3);
      if (k == -1)
        return "";
      paramString1 = paramString1.substring(0, k);
      paramString1 = paramString1.trim();
    }
    return paramString1;
  }

  public static String isNull(String paramString)
  {
    return isNull(paramString, "&nbsp;");
  }

  public static String isNull(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return paramString2;
    if (paramString1.length() == 0)
      return paramString2;
    return paramString1;
  }

  public static int StringToInt(String paramString)
  {
    return StringToInt(paramString, 0);
  }

  public static int StringToInt(String paramString, int paramInt)
  {
    int i = paramInt;
    try
    {
      i = Integer.parseInt(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return i;
  }

  public static float StringToFloat(String paramString)
  {
    return StringToFloat(paramString, 0.0F);
  }

  public static float StringToFloat(String paramString, float paramFloat)
  {
    float f = paramFloat;
    try
    {
      f = Float.parseFloat(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return f;
  }

  public static double StringToDouble(String paramString)
  {
    return StringToDouble(paramString, 0.0D);
  }

  public static double StringToDouble(String paramString, double paramDouble)
  {
    double d = paramDouble;
    try
    {
      d = Double.parseDouble(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return d;
  }

  public static String getSafeString(String paramString)
  {
    if (paramString == null)
      return "";
    return paramString.trim();
  }

  public static String substr(String paramString, int paramInt)
  {
    if (paramString == null)
      return "";
    if ((paramInt > 3) && (paramString.length() > paramInt - 3))
      paramString = paramString.substring(0, paramInt - 3) + "...";
    return paramString;
  }

  public static String UnicodeToChinese(String paramString)
  {
    try
    {
      if ((paramString == null) || (paramString.equals("")))
        return "";
      String str = null;
      str = new String(paramString.getBytes("ISO-8859-1"), "GBK");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return paramString;
  }

  public static String substr2(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
      return "";
    if ((paramInt2 > 3) && (paramString.length() > paramInt2 - 3))
      paramString = paramString.substring(paramInt1, paramInt2 - 3) + "...";
    return paramString;
  }

  public static String getLimitLengthString(String paramString1, String paramString2, int paramInt)
  {
    String str = "";
    if ((paramString1 == null) || (paramString1.trim().equals("")))
      return str;
    try
    {
      int i = 0;
      byte[] arrayOfByte = paramString1.getBytes("GBK");
      if (arrayOfByte.length <= paramInt)
        return paramString1;
      for (int j = 0; j < paramInt; j++)
      {
        if (arrayOfByte[j] >= 0)
          continue;
        i++;
      }
      if (i % 2 == 0)
        str = new String(arrayOfByte, 0, paramInt, "gb2312") + paramString2;
      else
        str = new String(arrayOfByte, 0, paramInt - 1, "gb2312") + paramString2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      System.out.println("UnsupportedEncodingException = " + localUnsupportedEncodingException);
    }
    str = FilterHtmlCode(str);
    return str;
  }

  public static String toHtml(String paramString)
  {
    if (paramString == null)
    {
      paramString = " ";
      return paramString;
    }
    paramString = Replace(paramString, "'", "''");
    return paramString;
  }

  public static String toHtml2(String paramString)
  {
    if (paramString == null)
    {
      paramString = "";
      return paramString;
    }
    paramString = Replace(paramString, "&", "&amp;");
    paramString = Replace(paramString, "<", "&lt;");
    paramString = Replace(paramString, ">", "&gt;");
    paramString = Replace(paramString, "\t", "    ");
    paramString = Replace(paramString, "\r\n", "\n");
    paramString = Replace(paramString, "\n", "</br>");
    paramString = Replace(paramString, "  ", " &nbsp;");
    paramString = Replace(paramString, "'", "&#39;");
    paramString = Replace(paramString, "\\", "&#92;");
    paramString = Replace(paramString, "\"", "&#34;");
    return paramString;
  }

  public static String toHtml3(String paramString)
  {
    if (paramString == null)
    {
      paramString = "";
      return paramString;
    }
    paramString = Replace(paramString, "\"", "&#34;");
    paramString = Replace(paramString, "'", "&#39;");
    return paramString;
  }

  public static String toHtml4(String paramString)
  {
    if (paramString == null)
    {
      paramString = "";
      return paramString;
    }
    paramString = Replace(paramString, "\n", "</br>");
    paramString = Replace(paramString, "\r", "");
    return paramString;
  }

  public static String unHtml(String paramString)
  {
    paramString = Replace(paramString, "</br>", "\n");
    paramString = Replace(paramString, "&nbsp;", " ");
    return paramString;
  }

  public static String Replace(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null)
      return null;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString1.length();
    int j = paramString2.length();
    int m;
    int k =0;
    for (  k = 0; (m = paramString1.indexOf(paramString2, k)) >= 0; k = m + j)
    {
      localStringBuffer.append(paramString1.substring(k, m));
      localStringBuffer.append(paramString3);
    }
    if (k < i)
      localStringBuffer.append(paramString1.substring(k));
    return localStringBuffer.toString();
  }

  public static String ConvertIn(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals("")))
    {
      paramString = " ";
      return paramString;
    }
    String str = null;
    try
    {
      str = new String(paramString.getBytes("UTF-8"), "gb2312");
    }
    catch (Exception localException)
    {
    }
    return str;
  }

  public static String CommentFilter(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals("")))
    {
      paramString = " ";
      return paramString;
    }
    try
    {
      paramString = Replace(paramString, "<P>", "");
      paramString = Replace(paramString, "</P>", "");
      paramString = Replace(paramString, "<p>", "");
      paramString = Replace(paramString, "</p>", "");
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }

  public static String FilterHtmlCode(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals("")))
    {
      paramString = " ";
      return paramString;
    }
    try
    {
      paramString = paramString.replaceAll("<[^<>]+>", "");
      paramString = Replace(paramString, " ", "");
      paramString = Replace(paramString, "&nbsp;", "");
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.StringUtil
 * JD-Core Version:    0.6.0
 */