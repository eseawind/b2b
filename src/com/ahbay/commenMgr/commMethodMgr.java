package com.ahbay.commenMgr;

import com.ahbay.mysite.RandomStrg;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.struts.upload.FormFile;

public class commMethodMgr
{
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();

  public String GenTradeId()
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
    }
    return str;
  }

  public String GenSysdate(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = null;
    String str = "";
    if (paramString.equalsIgnoreCase("1"))
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    else if (paramString.equalsIgnoreCase("2"))
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    else
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    str = localSimpleDateFormat.format(localCalendar.getTime());
    return str;
  }

  public String splitStr(String paramString, int paramInt)
  {
    int i = paramString.length();
    if (paramInt >= i)
      return paramString;
    int j = 0;
    int k = 0;
    while (j < paramInt)
    {
      int m = paramString.charAt(j);
      j++;
      if (m < 128)
      {
        k++;
      }
      else if (j < paramInt)
      {
        j++;
        k += 2;
      }
    }
    return paramString.substring(0, k);
  }

  public String convetStrToWeb(String paramString)
  {
    String str = "";
    if (paramString == null)
      str = "";
    else
      try
      {
        str = new String(paramString.getBytes("GB2312"), "ISO8859_1");
      }
      catch (Exception localException)
      {
        System.out.println("SQLERROR:" + localException.getMessage());
      }
    return str;
  }

  public String convetStrToDb(String paramString)
  {
    String str = "";
    if (paramString == null)
      str = "";
    else
      try
      {
        str = new String(paramString.getBytes("ISO8859_1"), "GB2312");
      }
      catch (Exception localException)
      {
        System.out.println("SQLERROR:" + localException.getMessage());
      }
    return str;
  }

  public String ConvertCodeToName(String paramString1, String paramString2)
  {
    String str1 = "";
    String str2 = "";
    if (paramString1.equalsIgnoreCase("sex"))
    {
      if (paramString2.equalsIgnoreCase("0"))
        str1 = "男性";
      if (paramString2.equalsIgnoreCase("1"))
        str1 = "女性";
    }
    if (paramString1.equalsIgnoreCase("bookstate"))
    {
      if (paramString2.equalsIgnoreCase("0"))
        str1 = "正常库存";
      if (paramString2.equalsIgnoreCase("1"))
        str1 = "已经借出";
    }
    else if (paramString1.equalsIgnoreCase("custname"))
    {
      str2 = "select cust_name from custperson where cust_id='" + paramString2 + "' union all " + "select cust_name from custgroup where cust_id='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("staffname"))
    {
      str2 = "select staff_name from staffinfo where staff_id='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("casetype"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='casetype'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("querytype"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='querytype'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("custrole"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='custrole'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("agentstage"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='agentstage'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("agenttype"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='agenttype'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("filestype"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='filestype'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("booktype"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='booktype'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("booksize"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='booksize'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("itemstate"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='itemstate'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("secretlevel"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='secretlevel'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("itemkind"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='itemkind'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("itemmedia"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='itemmedia'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("goodsstate"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='goodsstate'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("docustate"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='docustate'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("infotype"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='infotype'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("mailtype"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='mailtype'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("warntype"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='warntype'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("opentype"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='opentype'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("proofunit"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='proofunit'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("proofmedia"))
    {
      str2 = "select para_code1 from commpara where subsys_code='WEB' and param_attr='proofmedia'and param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("itemowndepart"))
    {
      str2 = "select depart_name from departinfo where depart_id='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("casersrvstr2"))
    {
      str2 = "select rsrv_str2 from caseinfo where case_id='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("modulename"))
    {
      str2 = "select module_name from moduleinfo where module_id='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("menuname"))
    {
      str2 = "select menu_name from menuinfo where menu_id='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    else if (paramString1.equalsIgnoreCase("webname"))
    {
      str2 = "select lmmc from lmxxb where lmbs='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    return str1;
  }

  public String getClassNameByClassId(String paramString)
  {
    String str1 = "";
    String str2 = "select class_name from td_b_productclass where class_id='" + paramString + "'";
    try
    {
      str1 = GetNameForCode(str2);
    }
    catch (Exception localException)
    {
      return "";
    }
    return str1;
  }

  public String getMenuNameById(String paramString)
  {
    String str1 = "";
    String str2 = "select menu_name from menuinfo where menu_id='" + paramString + "'";
    try
    {
      str1 = GetNameForCode(str2);
    }
    catch (Exception localException)
    {
      return "";
    }
    return str1;
  }

  public String GetNameForCode(String paramString)
  {
    ResultSet localResultSet = null;
    String str = "";
    this.DBQuery.setStrQuery(paramString);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        str = localResultSet.getString(1);
        if (!localResultSet.wasNull())
          continue;
        str = "null";
      }
    }
    catch (Exception localException)
    {
    }
    return str;
  }

  public String Savefiles(FormFile paramFormFile, String paramString)
  {
    String str1 = paramFormFile.getFileName();
    String str2 = paramFormFile.getContentType();
    String str3 = paramFormFile.getFileSize() + " bytes";
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      InputStream localInputStream = paramFormFile.getInputStream();
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString + str1);
      int i = 0;
      byte[] arrayOfByte = new byte[8192];
      while ((i = localInputStream.read(arrayOfByte, 0, 8192)) != -1)
        localFileOutputStream.write(arrayOfByte, 0, i);
      localFileOutputStream.close();
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      return localIOException.getMessage();
    }
    return "1";
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.commenMgr.commMethodMgr
 * JD-Core Version:    0.6.0
 */