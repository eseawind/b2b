package tools.util;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class IntegerComparator
  implements Comparator
{
  private int takeEqual = 0;
  private boolean desc = false;

  public IntegerComparator(boolean paramBoolean)
  {
  }

  public IntegerComparator(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.desc = paramBoolean2;
  }

  public int compare(Object paramObject1, Object paramObject2)
  {
    int i = ((Integer)paramObject1).intValue();
    int j = ((Integer)paramObject2).intValue();
    if (!this.desc)
    {
      if (i < j)
        return -1;
      if (i > j)
        return 1;
    }
    else
    {
      if (i < j)
        return 1;
      if (i > j)
        return -1;
    }
    return this.takeEqual;
  }

  public static void main(String[] paramArrayOfString)
  {
    test(true);
    test(false);
    test(true, true);
    test(true, false);
    test(false, true);
    test(false, false);
  }

  private static void test(boolean paramBoolean)
  {
    System.out.println("\nflag: " + paramBoolean);
    TreeMap localTreeMap = new TreeMap(new IntegerComparator(paramBoolean));
    Integer localInteger1 = new Integer(1);
    Integer localInteger2 = new Integer(2);
    Integer localInteger3 = new Integer(2);
    Integer localInteger4 = new Integer(4);
    localTreeMap.put(localInteger1, localInteger1);
    localTreeMap.put(localInteger2, localInteger2);
    localTreeMap.put(localInteger3, localInteger3);
    localTreeMap.put(localInteger4, localInteger4);
    Iterator localIterator = localTreeMap.values().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger5 = (Integer)localIterator.next();
      System.out.println("i: " + localInteger5.intValue());
    }
  }

  private static void test(boolean paramBoolean1, boolean paramBoolean2)
  {
    System.out.println("\nflag: " + paramBoolean1 + " desc: " + paramBoolean2);
    TreeMap localTreeMap = new TreeMap(new IntegerComparator(paramBoolean1, paramBoolean2));
    Integer localInteger1 = new Integer(1);
    Integer localInteger2 = new Integer(2);
    Integer localInteger3 = new Integer(2);
    Integer localInteger4 = new Integer(4);
    localTreeMap.put(localInteger1, localInteger1);
    localTreeMap.put(localInteger2, localInteger2);
    localTreeMap.put(localInteger3, localInteger3);
    localTreeMap.put(localInteger4, localInteger4);
    Iterator localIterator = localTreeMap.values().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger5 = (Integer)localIterator.next();
      System.out.println("i: " + localInteger5.intValue());
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.IntegerComparator
 * JD-Core Version:    0.6.0
 */