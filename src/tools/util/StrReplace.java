package tools.util;

public class StrReplace
{
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if (paramString2.equals(""))
      return "";
    int i = paramString2.length();
    int j;
    while ((j = paramString1.indexOf(paramString2)) != -1)
    {
      str = str + paramString1.substring(0, j);
      str = str + paramString3;
      paramString1 = paramString1.substring(j + i);
    }
    str = str + paramString1;
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.StrReplace
 * JD-Core Version:    0.6.0
 */