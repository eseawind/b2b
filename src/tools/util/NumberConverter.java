package tools.util;

import java.io.PrintStream;
import java.text.DecimalFormat;

public class NumberConverter
{
  public static DecimalFormat S_SS = new DecimalFormat("#.##");

  public static String get_S_SS(double paramDouble)
  {
    return S_SS.format(paramDouble);
  }

  public static void main(String[] paramArrayOfString)
  {
    System.out.println(get_S_SS(StringUtil.StringToDouble(paramArrayOfString[0])));
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.NumberConverter
 * JD-Core Version:    0.6.0
 */