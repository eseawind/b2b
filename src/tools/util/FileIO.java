package tools.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class FileIO
{
  public static String LoadFile(String paramString)
  {
    String str1 = "";
    try
    {
      FileReader localFileReader = new FileReader(paramString);
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      for (String str2 = localBufferedReader.readLine(); str2 != null; str2 = localBufferedReader.readLine())
        str1 = str1 + str2 + "\n";
      localBufferedReader.close();
      localFileReader.close();
    }
    catch (IOException localIOException)
    {
      System.out.println("下列文件不存在：" + paramString);
    }
    return str1;
  }

  public static synchronized void SaveToFile(String paramString1, String paramString2)
  {
    try
    {
      PrintWriter localPrintWriter = new PrintWriter(new FileOutputStream(paramString2));
      localPrintWriter.println(paramString1);
      localPrintWriter.close();
    }
    catch (IOException localIOException)
    {
      System.out.println("写入文件失败！" + paramString2);
      localIOException.printStackTrace();
    }
  }

  public static synchronized void SaveToFile(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      CheckFloder(paramString3);
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString3 + paramString2);
      byte[] arrayOfByte = paramString1.getBytes();
      localFileOutputStream.write(arrayOfByte);
      localFileOutputStream.close();
    }
    catch (IOException localIOException)
    {
      System.out.println("写入文件失败！" + localIOException.getMessage());
    }
  }

  public static boolean DelFile(String paramString)
  {
	  boolean i = false;
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      localFile.delete();
      i = true;
    }
    return i;
  }

  public static boolean ExistFloder(String paramString)
  {
	  boolean i = false;
    File localFile = new File(paramString);
    if (localFile.isDirectory())
      i = true;
    return i;
  }

  public static boolean CreateFloder(String paramString)
  {
	  boolean i = true;
    File localFile = new File(paramString);
    if (!localFile.exists())
      try
      {
        localFile.mkdirs();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i = false;
      }
    return i;
  }

  public static boolean RemoveFloder(String paramString)
  {
	  boolean i = true;
    File localFile = new File(paramString);
    if (localFile.exists())
      try
      {
        localFile.delete();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i = false;
      }
    return i;
  }

  public static boolean RemoveFloders(String paramString)
  {
	  boolean i = true;
    File localFile = new File(paramString);
    try
    {
      DeleteFolds(localFile);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      i=false;
    }
    return i;
  }

  public static boolean DeleteFolds(File paramFile)
    throws IOException
  {
    boolean bool = true;
    if (!paramFile.exists())
      System.out.println("指定目录不存在:" + paramFile.getName());
    if (!(bool = paramFile.delete()))
    {
      File[] arrayOfFile = paramFile.listFiles();
      for (int i = 0; i <= arrayOfFile.length - 1; i++)
      {
        if (arrayOfFile[i].isDirectory())
          DeleteFolds(arrayOfFile[i]);
        bool = arrayOfFile[i].delete();
      }
      bool = paramFile.delete();
    }
    if (!bool)
      System.out.println("无法删除:" + paramFile.getName());
    return bool;
  }

  public static void CheckFloder(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
      try
      {
        localFile.mkdirs();
      }
      catch (Exception localException)
      {
        System.out.println("创建文件夹失败！" + paramString);
        localException.printStackTrace();
      }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.FileIO
 * JD-Core Version:    0.6.0
 */