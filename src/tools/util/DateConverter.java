package tools.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter
{
  public static SimpleDateFormat MM_dd_yy = new SimpleDateFormat("MM-dd-yy");
  public static SimpleDateFormat h_mm_a = new SimpleDateFormat("h:mm a");
  public static SimpleDateFormat MM_DD_YYYY_HH_MM_SS = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
  public static SimpleDateFormat MMddyyyy = new SimpleDateFormat("MM/dd/yyyy");
  public static SimpleDateFormat MM_DD_YY = new SimpleDateFormat("MM_dd_yy");
  public static SimpleDateFormat MMddyy = new SimpleDateFormat("MM/dd/yy");
  public static SimpleDateFormat HHmmss = new SimpleDateFormat("HH:mm:ss");
  public static SimpleDateFormat HHmm = new SimpleDateFormat("HH:mm");
  public static SimpleDateFormat MMdotDDdotYYYY = new SimpleDateFormat("MM.dd.yyyy");
  public static SimpleDateFormat MMddYYYY_HHmmss = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
  public static SimpleDateFormat YYYYMMdd_HHmmss = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
  public static SimpleDateFormat YYYYMMdd = new SimpleDateFormat("yyyy.MM.dd");
  public static SimpleDateFormat YYYY_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
  static String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

  public static String getSimpleMonthName(int paramInt)
  {
    return months[paramInt];
  }

  public static String get_MM_dd_yy(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return MM_dd_yy.format(paramDate);
  }

  public static String get_h_mm_a(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return h_mm_a.format(paramDate);
  }

  public static String get_MM_DD_YYYY_HH_MM_SS(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return MM_DD_YYYY_HH_MM_SS.format(paramDate);
  }

  public static String get_MMddyyyy(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return MMddyyyy.format(paramDate);
  }

  public static Date parse_MM_DD_YYYY(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      return MMddyyyy.parse(paramString);
    }
    catch (ParseException localParseException)
    {
    }
    return null;
  }

  public static String get_MM_DD_YY(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return MM_DD_YY.format(paramDate);
  }

  public static String get_MMddyy(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return MMddyy.format(paramDate);
  }

  public static String get_YYYYMMdd(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return YYYYMMdd.format(paramDate);
  }

  public static String get_YYYY_MM_dd(Date paramDate)
  {
    if (paramDate == null)
      return "N/A";
    return YYYY_MM_dd.format(paramDate);
  }

  public static String get_YYYYMMdd_HHmmss(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return YYYYMMdd_HHmmss.format(paramDate);
  }

  public static String get_MMddYYYY_HHmmss(Date paramDate)
  {
    if (paramDate == null)
      return "NULL";
    return MMddYYYY_HHmmss.format(paramDate);
  }

  public static String get_MMdotDDdotYYYY(Date paramDate)
  {
    if (paramDate == null)
      return "NULL";
    return MMdotDDdotYYYY.format(paramDate);
  }

  public static String get_HHmmss(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return HHmmss.format(paramDate);
  }

  public static String get_HHmm(Date paramDate)
  {
    if (paramDate == null)
      return "null";
    return HHmm.format(paramDate);
  }

  public static Date getPrevMonthDate(Date paramDate, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = paramInt * -1;
    localCalendar.add(2, i);
    return localCalendar.getTime();
  }

  public static Date getNextMonthDate(Date paramDate, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(2, paramInt);
    return localCalendar.getTime();
  }

  public static Date getPrevDay(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(5, -1);
    return localCalendar.getTime();
  }

  public static Date getNextDay(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(5, 1);
    return localCalendar.getTime();
  }

  public static Date getNextDays(Date paramDate, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(5, paramInt);
    return localCalendar.getTime();
  }

  public static Date getMidnight(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTime();
  }

  public static Date getNextHour(Date paramDate, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(11, paramInt);
    return localCalendar.getTime();
  }

  public static Date getNext15Min(Date paramDate, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(12, paramInt * 15);
    return localCalendar.getTime();
  }

  public static Date getNext5Min(Date paramDate, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(12, paramInt * 5);
    return localCalendar.getTime();
  }

  public static Date getNextSecond(Date paramDate, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(13, paramInt);
    return localCalendar.getTime();
  }

  public static int getHourOfDay(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(11);
  }

  public static int get15MinOfDay(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    return i * 4 + j / 15;
  }

  public static int get5MinOfDay(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    return i * 12 + j / 5;
  }

  public static int getMonths(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(paramDate1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(paramDate2);
    if (localCalendar1.before(localCalendar2))
      return 0;
    int i = 0;
    for (int j = 0; ; j++)
    {
      if (localCalendar2.after(localCalendar1))
        return j;
      localCalendar2.add(2, 1);
    }
  }

  public static int getDays(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(paramDate1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(paramDate2);
    if (localCalendar1.before(localCalendar2))
      return 0;
    int i = 0;
    for (int j = 0; ; j++)
    {
      if ((localCalendar2.after(localCalendar1)) || (localCalendar2.equals(localCalendar1)))
        return j;
      localCalendar2.add(5, 1);
    }
  }

  public static Date getLastWeekDate(int paramInt, Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(5, -7 - (localCalendar.get(7) - 2) + (paramInt - 1));
    return localCalendar.getTime();
  }

  public static boolean isDateEqualToDay(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(paramDate1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(paramDate2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5));
  }

  public static boolean isWeekDay(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = localCalendar.get(7);
    return (i != 7) && (i != 1);
  }

  public static Date getDateByNumeric(long paramLong)
  {
    return new Date(paramLong);
  }

  public static long getNumericByDate(Date paramDate)
  {
    return paramDate.getTime();
  }

  public static Date getEndDayOfTheMonth(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(2, 1);
    localCalendar.set(5, 1);
    localCalendar.add(5, -1);
    return localCalendar.getTime();
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.DateConverter
 * JD-Core Version:    0.6.0
 */