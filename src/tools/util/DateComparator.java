package tools.util;

import java.util.Comparator;
import java.util.Date;

public class DateComparator
  implements Comparator
{
  private int takeEqual = 0;
  private boolean desc = false;

  public DateComparator(boolean paramBoolean)
  {
  }

  public DateComparator(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.desc = paramBoolean2;
  }

  public int compare(Object paramObject1, Object paramObject2)
  {
    Date localDate1 = (Date)paramObject1;
    Date localDate2 = (Date)paramObject2;
    if (!this.desc)
    {
      if (localDate1.before(localDate2))
        return -1;
      if (localDate1.after(localDate2))
        return 1;
    }
    else
    {
      if (localDate1.before(localDate2))
        return 1;
      if (localDate1.after(localDate2))
        return -1;
    }
    return this.takeEqual;
  }

  public boolean equals(Object paramObject)
  {
    return false;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.DateComparator
 * JD-Core Version:    0.6.0
 */