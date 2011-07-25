package tools.util;

public class CommentFilter
{
  public static String filterWord(String paramString)
  {
    if (paramString == null)
    {
      paramString = "";
      return paramString;
    }
    paramString = Replace(paramString, "\"", "&#34;");
    paramString = Replace(paramString, "'", "&#39;");
    paramString = Replace(paramString, "\n", "<br>");
    paramString = Replace(paramString, "\r", "");
    paramString = Replace(paramString, "  ", " &nbsp;");
    paramString = Replace(paramString, "<P>", "");
    paramString = Replace(paramString, "</P>", "");
    paramString = Replace(paramString, "<p>", "");
    paramString = Replace(paramString, "</p>", "");
    paramString = Replace(paramString, "法轮功", "***");
    paramString = Replace(paramString, "毴", "*");
    paramString = Replace(paramString, "逼", "*");
    paramString = Replace(paramString, "屄", "*");
    paramString = Replace(paramString, "屌", "*");
    paramString = Replace(paramString, "操", "*");
    paramString = Replace(paramString, "妈的", "**");
    paramString = Replace(paramString, "狗日的", "***");
    paramString = Replace(paramString, "操你娘", "***");
    paramString = Replace(paramString, "操你妈", "***");
    paramString = Replace(paramString, "干你娘", "***");
    paramString = Replace(paramString, "干你妈", "***");
    paramString = Replace(paramString, "老子", "**");
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
    int k = 0;
    for (  k = 0; (m = paramString1.indexOf(paramString2, k)) >= 0; k = m + j)
    {
      localStringBuffer.append(paramString1.substring(k, m));
      localStringBuffer.append(paramString3);
    }
    if (k < i)
      localStringBuffer.append(paramString1.substring(k));
    return localStringBuffer.toString();
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.CommentFilter
 * JD-Core Version:    0.6.0
 */