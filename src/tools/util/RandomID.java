package tools.util;

import java.io.PrintStream;

public class RandomID
{
  public static String GenTradeId()
  {
    String str = "";
    RandomStrg.setCharset("a-zA-Z0-9");
    RandomStrg.setLength("15");
    try
    {
      RandomStrg.generateRandomObject();
      str = RandomStrg.getRandom();
    }
    catch (Exception localException)
    {
      System.out.println("e = " + localException.toString());
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.RandomID
 * JD-Core Version:    0.6.0
 */