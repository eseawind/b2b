package com.saas.biz.commen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class FileOperate
{
  public void newFolder(String paramString)
  {
    try
    {
      String str = paramString;
      str = str.toString();
      File localFile = new File(str);
      if (!localFile.exists())
        localFile.mkdir();
    }
    catch (Exception localException)
    {
      System.out.println("新建目录操作出错");
      localException.printStackTrace();
    }
  }

  public void newFile(String paramString1, String paramString2)
  {
    try
    {
      String str1 = paramString1;
      str1 = str1.toString();
      File localFile = new File(str1);
      if (!localFile.exists())
        localFile.createNewFile();
      FileWriter localFileWriter = new FileWriter(localFile);
      PrintWriter localPrintWriter = new PrintWriter(localFileWriter);
      String str2 = paramString2;
      localPrintWriter.println(str2);
      localFileWriter.close();
    }
    catch (Exception localException)
    {
      System.out.println("新建目录操作出错");
      localException.printStackTrace();
    }
  }

  public void delFile(String paramString)
  {
    try
    {
      String str = paramString;
      str = str.toString();
      File localFile = new File(str);
      localFile.delete();
    }
    catch (Exception localException)
    {
      System.out.println("删除文件操作出错");
      localException.printStackTrace();
    }
  }

  public void delFolder(String paramString)
  {
    try
    {
      delAllFile(paramString);
      String str = paramString;
      str = str.toString();
      File localFile = new File(str);
      localFile.delete();
    }
    catch (Exception localException)
    {
      System.out.println("删除文件夹操作出错");
      localException.printStackTrace();
    }
  }

  public void delAllFile(String paramString)
  {
    File localFile1 = new File(paramString);
    if (!localFile1.exists())
      return;
    if (!localFile1.isDirectory())
      return;
    String[] arrayOfString = localFile1.list();
    File localFile2 = null;
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (paramString.endsWith(File.separator))
        localFile2 = new File(paramString + arrayOfString[i]);
      else
        localFile2 = new File(paramString + File.separator + arrayOfString[i]);
      if (localFile2.isFile())
        localFile2.delete();
      if (!localFile2.isDirectory())
        continue;
      delAllFile(paramString + "/" + arrayOfString[i]);
      delFolder(paramString + "/" + arrayOfString[i]);
    }
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

  public void copyFolder(String paramString1, String paramString2)
  {
    try
    {
      new File(paramString2).mkdirs();
      File localFile1 = new File(paramString1);
      String[] arrayOfString = localFile1.list();
      File localFile2 = null;
      for (int i = 0; i < arrayOfString.length; i++)
      {
        if (paramString1.endsWith(File.separator))
          localFile2 = new File(paramString1 + arrayOfString[i]);
        else
          localFile2 = new File(paramString1 + File.separator + arrayOfString[i]);
        if (localFile2.isFile())
        {
          FileInputStream localFileInputStream = new FileInputStream(localFile2);
          FileOutputStream localFileOutputStream = new FileOutputStream(paramString2 + "/" + localFile2.getName().toString());
          byte[] arrayOfByte = new byte[5120];
          int j;
          while ((j = localFileInputStream.read(arrayOfByte)) != -1)
            localFileOutputStream.write(arrayOfByte, 0, j);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          localFileInputStream.close();
        }
        if (!localFile2.isDirectory())
          continue;
        copyFolder(paramString1 + "/" + arrayOfString[i], paramString2 + "/" + arrayOfString[i]);
      }
    }
    catch (Exception localException)
    {
      System.out.println("复制整个文件夹内容操作出错");
      localException.printStackTrace();
    }
  }

  public void moveFile(String paramString1, String paramString2)
  {
    copyFile(paramString1, paramString2);
    delFile(paramString1);
  }

  public void moveFolder(String paramString1, String paramString2)
  {
    copyFolder(paramString1, paramString2);
    delFolder(paramString1);
  }

  public void renameFolder(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    localFile.renameTo(new File(paramString2));
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.FileOperate
 * JD-Core Version:    0.6.0
 */