package tools.util;

import java.util.Comparator;
import java.util.Date;

public class SequenceComparator
  implements Comparator
{
  private int takeEqual = 0;
  private boolean seq = true;

  public SequenceComparator()
  {
  }

  public SequenceComparator(boolean paramBoolean)
  {
    this.takeEqual = (paramBoolean == true ? 1 : 0);
  }

  public SequenceComparator(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.takeEqual = (paramBoolean1 == true ? 1 : 0);
    this.seq = paramBoolean2;
  }

  public int compare(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof String)) && ((paramObject2 instanceof String)))
      return compareString(paramObject1, paramObject2);
    if (((paramObject1 instanceof Integer)) && ((paramObject2 instanceof Integer)))
      return compareInteger(paramObject1, paramObject2);
    if (((paramObject1 instanceof Date)) && ((paramObject2 instanceof Date)))
      return compareDate(paramObject1, paramObject2);
    return this.seq ? 1 : -1;
  }

  public int compareString(Object paramObject1, Object paramObject2)
  {
    String str1 = (String)paramObject1;
    String str2 = (String)paramObject2;
    if (!str1.equals(str2))
      return this.seq ? 1 : -1;
    return this.takeEqual;
  }

  public int compareInteger(Object paramObject1, Object paramObject2)
  {
    int i = ((Integer)paramObject1).intValue();
    int j = ((Integer)paramObject2).intValue();
    if (i != j)
      return this.seq ? 1 : -1;
    return this.takeEqual;
  }

  public int compareDate(Object paramObject1, Object paramObject2)
  {
    Date localDate1 = (Date)paramObject1;
    Date localDate2 = (Date)paramObject2;
    if (!localDate1.equals(localDate2))
      return this.seq ? 1 : -1;
    return this.takeEqual;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.SequenceComparator
 * JD-Core Version:    0.6.0
 */