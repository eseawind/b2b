package com.saas.biz.commen;

import com.saas.sys.exp.SaasApplicationException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatByString
{
  public String getDateYMDHMSW(String paramString)
    throws ParseException
  {
    Calendar localCalendar = Calendar.getInstance();
    String str1 = "";
    if (paramString.length() > 10)
      str1 = "yyyy-MM-dd HH:mm:ss";
    else
      str1 = "yyyy-MM-dd";
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(str1);
    Date localDate = localSimpleDateFormat.parse(paramString);
    localCalendar.setTime(localDate);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2) + 1;
    int k = localCalendar.get(5);
    int m = localCalendar.get(7) - 1;
    int n = localCalendar.get(11);
    int i1 = localCalendar.get(12);
    int i2 = localCalendar.get(13);
    String str2 = i + "年" + j + "月" + k + "日" + n + "时" + i1 + "分" + i2 + "秒" + getWeek(m);
    return str2;
  }

  public static void main(String[] paramArrayOfString)
    throws SaasApplicationException
  {
    System.out.println(new DateFormatByString().getDateTimeNow());
  }

  public String getDateTimeNow()
    throws SaasApplicationException
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int i = localCalendar.get(7) - 1;
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "  " + getWeek(i);
    return str;
  }

  public String getWeek(int paramInt)
  {
    int i = paramInt;
    String str = "";
    if (i == 1)
      str = "星期一";
    else if (i == 2)
      str = "星期二";
    else if (i == 3)
      str = "星期三";
    else if (i == 4)
      str = "星期四";
    else if (i == 5)
      str = "星期五";
    else if (i == 6)
      str = "星期六";
    else
      str = "星期日";
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.DateFormatByString
 * JD-Core Version:    0.6.0
 */