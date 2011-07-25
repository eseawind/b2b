package com.saas.biz.commen;

import com.saas.biz.dao.commenDAO.CommparaExt;
import com.saas.biz.mysite.RandomStrg;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.struts.upload.FormFile;

public class commMethodMgr
{
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

  public String GenShortTradeId()
  {
    String str = "";
    RandomStrg.setCharset("a-zA-Z0-9");
    RandomStrg.setLength("10");
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

  public String GenNumTradeId()
  {
    String str = "";
    RandomStrg.setCharset("0-9");
    RandomStrg.setLength("10");
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
    if ((paramString == null) || (paramString == ""))
      str = "";
    else
      try
      {
        str = new String(paramString.getBytes("GB2312"), "ISO8859_1");
      }
      catch (Exception localException)
      {
        throw new RuntimeException("编码转换错误" + localException);
      }
    if ((paramString == null) || (paramString == ""))
      str = "";
    return str;
  }

  public String convetStrToDb(String paramString)
  {
    String str = "";
    if ((paramString == null) || (paramString == ""))
      str = "";
    else
      try
      {
        str = new String(paramString.getBytes("ISO8859_1"), "GB2312");
      }
      catch (Exception localException)
      {
        throw new RuntimeException("编码转换错误" + localException);
      }
    if ((paramString == null) || (paramString == ""))
      str = "";
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
    else if (paramString1.equalsIgnoreCase("repository_type"))
    {
      str2 = " select para_code2 from td_s_commpara t where t.param_code='" + paramString2 + "'";
      str1 = GetNameForCode(str2);
    }
    try
    {
      str1 = new String(str1.getBytes("GB2312"), "ISO8859_1");
    }
    catch (Exception localException)
    {
      System.out.println("SQLERROR:" + localException.getMessage());
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

  public String getUserNameByUserId(String paramString)
  {
    String str1 = "";
    String str2 = "select user_name from tf_f_user where user_id='" + paramString + "'";
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

  public String genOption(String paramString)
  {
    String str1 = "";
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VSUBSYS_CODE", "CRM");
    localCommparaExt.setParam(":VPARAM_CODE", paramString);
    localArrayList = localCommparaExt.selByList("SEL_BY_CODE");
    if (localArrayList == null)
    {
      str1 = "<option value=0>无数据</option>";
      return str1;
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      String str3 = "";
      if (localHashMap.get("para_code1") != null)
        str2 = localHashMap.get("para_code1").toString();
      if (localHashMap.get("para_code2") != null)
        str3 = localHashMap.get("para_code2").toString();
      str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>\r\n";
    }
    return str1;
  }

  public String GetNameForCode(String paramString)
  {
    Object localObject = null;
    String str = "";
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

  public void copyFile(String paramString1, String paramString2)
  {
    try
    {
      int i = 0;
      int j = 0;
      File localFile = new File(paramString1);
      if (localFile.exists())
      {
        FileInputStream localFileInputStream = new FileInputStream(paramString1);
        FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
        byte[] arrayOfByte = new byte[1444];
        while ((j = localFileInputStream.read(arrayOfByte)) != -1)
        {
          i += j;
          System.out.println(i);
          localFileOutputStream.write(arrayOfByte, 0, j);
        }
        localFileInputStream.close();
      }
    }
    catch (Exception localException)
    {
      System.out.println("复制单个文件操作出错");
      localException.printStackTrace();
    }
  }

  private static String[] strToStrArrayManager(String paramString1, String paramString2)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, paramString2);
    String[] arrayOfString = new String[localStringTokenizer.countTokens()];
    for (int i = 0; localStringTokenizer.hasMoreTokens(); i++)
      arrayOfString[i] = localStringTokenizer.nextToken().trim();
    return arrayOfString;
  }

  public String setTextYin(String paramString)
  {
    String str1 = paramString;
    String str2 = "";
    str1 = str1.replaceAll("\n", str2 + "\n");
    return str1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.commMethodMgr
 * JD-Core Version:    0.6.0
 */