package tools.util;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class StringComparator
  implements Comparator
{
  private int takeEqual = 0;
  private boolean desc = false;

  public StringComparator(boolean paramBoolean)
  {
  }

  public StringComparator(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.desc = paramBoolean2;
  }

  public int compare(Object paramObject1, Object paramObject2)
  {
    String str1 = ((String)paramObject1).toUpperCase();
    String str2 = ((String)paramObject2).toUpperCase();
    if (!this.desc)
    {
      if (str1.compareTo(str2) < 0)
        return -1;
      if (str1.compareTo(str2) > 0)
        return 1;
    }
    else
    {
      if (str1.compareTo(str2) < 0)
        return 1;
      if (str1.compareTo(str2) > 0)
        return -1;
    }
    return this.takeEqual;
  }

  public boolean equals(Object paramObject)
  {
    return false;
  }

  public static void main(String[] paramArrayOfString)
  {
    test(true);
    test(false);
  }

  private static void test(boolean paramBoolean)
  {
    System.out.println("\nflag: " + paramBoolean);
    TreeMap localTreeMap = new TreeMap(new StringComparator(paramBoolean));
    String str1 = "string #1";
    String str2 = "string #2";
    String str3 = "string #2";
    String str4 = "string #4";
    localTreeMap.put(str1, str1);
    localTreeMap.put(str2, str2);
    localTreeMap.put(str3, str3);
    localTreeMap.put(str4, str4);
    Iterator localIterator = localTreeMap.values().iterator();
    while (localIterator.hasNext())
    {
      String str5 = (String)localIterator.next();
      System.out.println("str: " + str5);
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.StringComparator
 * JD-Core Version:    0.6.0
 */