package tools.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils
{
  public static String formatDate(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }

  public static String formatDateToString(Date paramDate)
    throws Exception
  {
    String str = null;
    if (paramDate == null)
      return "";
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    str = localSimpleDateFormat.format(paramDate);
    return str;
  }

  public static String formatDateToString2(Date paramDate)
    throws Exception
  {
    String str = null;
    if (paramDate == null)
      return "";
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HHyyyymmddMMss");
    str = localSimpleDateFormat.format(paramDate);
    return str;
  }

  public static String formatDateToHour(Date paramDate)
    throws Exception
  {
    String str = null;
    if (paramDate == null)
      return "";
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH");
    str = localSimpleDateFormat.format(paramDate);
    return str;
  }

  public static String formatDateToStringNoTime(Date paramDate)
    throws Exception
  {
    String str = null;
    if (paramDate == null)
      return "";
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    str = localSimpleDateFormat.format(paramDate);
    return str;
  }

  public static String formateDateToChinese(Calendar paramCalendar)
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      return localSimpleDateFormat.format(paramCalendar.getTime());
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String formateDateToChineseWK(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 EE");
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }

  public static String formateDateToNumber(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }

  public static Calendar paserStringToCalendar(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date localDate = null;
      localDate = localSimpleDateFormat.parse(paramString);
      localCalendar.setTime(localDate);
    }
    catch (Exception localException)
    {
      return null;
    }
    return localCalendar;
  }

  public static Date parseFromString(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    try
    {
      return localSimpleDateFormat.parse(paramString);
    }
    catch (ParseException localParseException)
    {
    }
    return null;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.DateUtils
 * JD-Core Version:    0.6.0
 */