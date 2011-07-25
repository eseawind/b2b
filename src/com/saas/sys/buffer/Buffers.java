package com.saas.sys.buffer;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.commen.config;
import com.saas.biz.interfaceMgr.InterfaceMgr;
import com.saas.sys.log.Logger;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class Buffers
  implements BufferIntf
{
  Buffer httpBuffer = new Buffer();
  Buffer saasBuffer = new Buffer();
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();

  public void setHttpBuffer(Buffer paramBuffer)
  {
    this.httpBuffer = paramBuffer;
  }

  public Buffer getHttpBuffer()
  {
    return this.httpBuffer;
  }

  public Buffer convert(HttpServletRequest paramHttpServletRequest, ActionForm paramActionForm, HttpSession paramHttpSession)
  {
    init(paramHttpServletRequest);
    setCommenFields(this.saasBuffer, this.httpBuffer);
    setString("REALPATH", paramHttpServletRequest.getRealPath(""));
    Iterator localIterator = this.saasBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if (localHashMap.get("name") != null)
      {
        if (paramHttpServletRequest.getParameter(localHashMap.get("name").toString().toLowerCase()) != null)
        {
          addField(localHashMap.get("name").toString(), this.saasBuffer, this.httpBuffer);
          setString(localHashMap.get("name").toString().toUpperCase(), paramHttpServletRequest.getParameter(localHashMap.get("name").toString().toLowerCase()).toString());
        }
        Object localObject1;
        if ((paramHttpSession != null) && (paramHttpSession.getAttribute(localHashMap.get("name").toString()) != null))
        {
          addField(localHashMap.get("name").toString(), this.saasBuffer, this.httpBuffer);
          localObject1 = (String)paramHttpSession.getAttribute(localHashMap.get("name").toString());
          setString(localHashMap.get("name").toString().toUpperCase(), (String)localObject1);
        }
        try
        {
        	Method[] localObject2 = paramActionForm.getClass().getDeclaredMethods();
          for (int i = 0; i < localObject2.length; i++)
          {
            if ((!localObject2[i].getName().startsWith("get")) || (localObject2[i].getName().equals("getMap")) || (localObject2[i].getName().equals("getServletWrapper")) || (localObject2[i].getName().equals("getLog")) || (localObject2[i].getName().equals("getMultipartRequestHandler")) || (localObject2[i].getName().equals("getClass")))
              continue;
            String str1 = "";
            if (paramActionForm.getClass().getDeclaredField(localHashMap.get("name").toString().toLowerCase()) != null)
            {
              str1 = paramActionForm.getClass().getDeclaredField(localHashMap.get("name").toString().toLowerCase()).getName();
              Object   localObject3 = PropertyUtils.getProperty(paramActionForm, str1);
              if ((localHashMap.get("name").toString().toUpperCase().equalsIgnoreCase(str1.toUpperCase())) && (localObject3 != null))
              {
                addField(localHashMap.get("name").toString(), this.saasBuffer, this.httpBuffer);
                setString(localHashMap.get("name").toString().toUpperCase(), localObject3.toString());
              }
            }
            if ((paramActionForm.getClass().getDeclaredField(localHashMap.get("name").toString().toLowerCase()) == null) || (paramActionForm.getClass().getDeclaredField(localHashMap.get("name").toString().toLowerCase()).getType().getName() != "org.apache.struts.upload.FormFile"))
              break;
            str1 = paramActionForm.getClass().getDeclaredField(localHashMap.get("name").toString().toLowerCase()).getName();
            Object localObject4 = (FormFile)PropertyUtils.getProperty(paramActionForm, str1);
            if (((FormFile)localObject4).getFileSize() > 0)
            {
              String str2 = this.comm.GenTradeId();
              String str3 = saveUploadFile((FormFile)localObject4, paramHttpServletRequest, paramHttpSession, str2);
              String str4 = paramHttpServletRequest.getRealPath("");
              String str5 = ((FormFile)localObject4).getFileName();
              try
              {
                this.log.LOG_INFO("file_name===" + ((FormFile)localObject4).getFileName() + "|===>");
                this.log.LOG_INFO("filePath===" + str3 + "|===>");
              }
              catch (Exception localException)
              {
                this.log.LOG_INFO("FormFormate::::" + localException.getMessage());
              }
              setString("UPLOADFILEDIR", str3);
              setString("FILE_NAME", str5);
              setString(localHashMap.get("name").toString().toUpperCase(), localObject2.toString());
              this.log.LOG_INFO("FormFile::::" + localObject2.toString());
            }
            else
            {
              setString("UPLOADFILEDIR", "");
              setString(localHashMap.get("name").toString().toUpperCase(), localObject2.toString());
            }
            break;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new RuntimeException(localIllegalAccessException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          throw new RuntimeException(localInvocationTargetException);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          throw new RuntimeException(localNoSuchMethodException);
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
        }
      }
    }
    this.log.LOG_INFO("********本次业务提交初始化域字段列表开始************************");
    list();
    this.log.LOG_INFO("********本次业务提交初始化域字段列表结束************************");
    return (Buffer)(Buffer)null;
  }

  public void clear()
  {
  }

  public void setString(String paramString1, String paramString2)
  {
    if (this.httpBuffer.isEmpty())
      throw new RuntimeException(" in Buffer is Empty");
    if (checkContainsKey(paramString1, this.httpBuffer) == 0)
      addField(paramString1, this.saasBuffer, this.httpBuffer);
    Iterator localIterator = this.httpBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if ((localHashMap.get("name") != null) && (localHashMap.get("name").toString().toUpperCase().equalsIgnoreCase(paramString1.toUpperCase())))
      {
        localHashMap.put("value", paramString2);
        break;
      }
      if (!localIterator.hasNext())
        throw new RuntimeException("[" + paramString1 + "]域字段不存在,[setString]操作失败!");
    }
  }

  public void setInt(String paramString, int paramInt)
  {
    if (this.httpBuffer.isEmpty())
      throw new RuntimeException("Buffer is Empty");
    if (checkContainsKey(paramString, this.httpBuffer) == 0)
      addField(paramString, this.saasBuffer, this.httpBuffer);
    String str = String.valueOf(paramInt);
    Iterator localIterator = this.httpBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if ((localHashMap.get("name") != null) && (localHashMap.get("name").toString().toUpperCase().equalsIgnoreCase(paramString.toUpperCase())))
      {
        localHashMap.put("value", str);
        break;
      }
      if (!localIterator.hasNext())
        throw new RuntimeException("[" + paramString + "]域字段不存在,[setInt]赋值操作失败!");
    }
  }

  public String getString(String paramString)
  {
    if (this.httpBuffer.isEmpty())
      throw new RuntimeException("缓存还没有初始化,[getString]操作失败!");
    String str = "";
    Iterator localIterator = this.httpBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if ((localHashMap.get("name") != null) && (localHashMap.get("name").toString().toUpperCase().equalsIgnoreCase(paramString.toUpperCase())))
      {
        if (localHashMap.get("type").toString().equalsIgnoreCase("string"))
        {
          if (localHashMap.get("value") == null)
            break;
          if (localHashMap.get("value").equals(""))
          {
            str = "";
            break;
          }
          str = localHashMap.get("value").toString();
          break;
        }
        throw new RuntimeException("类型不匹配,字段[" + paramString + "]不是字符串类型,[getString]操作失败!");
      }
      if (localIterator.hasNext());
    }
    return convetStrToDb(str);
  }

  public String getStringWeb(String paramString)
  {
    if (this.httpBuffer.isEmpty())
      throw new RuntimeException("缓存还没有初始化,[getString]操作失败!");
    String str = "";
    Iterator localIterator = this.httpBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if ((localHashMap.get("name") != null) && (localHashMap.get("name").toString().toUpperCase().equalsIgnoreCase(paramString.toUpperCase())))
      {
        if (localHashMap.get("type").toString().trim().equalsIgnoreCase("string"))
        {
          if (localHashMap.get("value") == null)
            break;
          if (localHashMap.get("value").equals(""))
          {
            str = "";
            break;
          }
          str = localHashMap.get("value").toString();
          break;
        }
        throw new RuntimeException("类型不匹配,字段[" + paramString + "]不是字符串类型,[getString]操作失败!");
      }
      if (!localIterator.hasNext())
        throw new RuntimeException("[" + paramString + "]域字段不存在,[getString]操作失败!");
    }
    return str;
  }

  public int getInt(String paramString)
  {
    if (this.httpBuffer.isEmpty())
      throw new RuntimeException("缓存还没有初始化,[getInt]操作失败!");
    String str = "";
    Iterator localIterator = this.httpBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if ((localHashMap.get("name") != null) && (localHashMap.get("name").toString().toUpperCase().equalsIgnoreCase(paramString.toUpperCase())))
      {
        if (localHashMap.get("type").toString().equalsIgnoreCase("int"))
        {
          if (localHashMap.get("value") == null)
            break;
          if (localHashMap.get("value").equals(""))
          {
            str = "0";
            break;
          }
          str = localHashMap.get("value").toString();
          break;
        }
        throw new RuntimeException("类型不匹配,字段[" + paramString + "]不是字符串类型,[getInt]操作失败!");
      }
      if (!localIterator.hasNext())
        throw new RuntimeException("[" + paramString + "]域字段不存在,[getInt]操作失败!");
    }
    return new Integer(str).intValue();
  }

  public Buffer copyFrom(Buffer paramBuffer)
  {
    return null;
  }

  public void init(HttpServletRequest paramHttpServletRequest)
  {
    String str1 = paramHttpServletRequest.getRealPath("");
    Buffer localBuffer = new Buffer();
    String str2 = str1 + "/WEB-INF/saas.flds";
    this.log.LOG_INFO(str2);
    try
    {
      FileReader localFileReader = new FileReader(str2);
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      for (String str3 = localBufferedReader.readLine(); str3 != null; str3 = localBufferedReader.readLine())
      {
        if ((str3.trim().equalsIgnoreCase("")) || (str3.substring(0, 1).equalsIgnoreCase("#")))
          continue;
        String[] arrayOfString = str3.split(",");
        HashMap localHashMap = new HashMap();
        localHashMap.put("name", arrayOfString[0].toUpperCase());
        localHashMap.put("type", arrayOfString[1]);
        if (arrayOfString[1].equalsIgnoreCase("string"))
          localHashMap.put("value", "");
        else if (arrayOfString[1].equalsIgnoreCase("int"))
          localHashMap.put("value", "0");
        this.saasBuffer.add(localHashMap);
      }
      localBufferedReader.close();
      localFileReader.close();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("[init]缓存域初始化失败!");
    }
  }

  public void addField(String paramString, Buffer paramBuffer1, Buffer paramBuffer2)
  {
    Iterator localIterator = paramBuffer1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if ((localHashMap.get("name") != null) && (localHashMap.get("name").toString().equalsIgnoreCase(paramString)))
      {
        if (checkContainsKey(localHashMap.get("name").toString(), paramBuffer2) < 0)
          break;
        paramBuffer2.add(localHashMap);
        break;
      }
    }
  }

  public void addFieldSting(String paramString1, String paramString2, Buffer paramBuffer)
  {
    Iterator localIterator = paramBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      if ((localHashMap1.get("name") != null) && (!localHashMap1.get("name").toString().equalsIgnoreCase(paramString1)) && (!localIterator.hasNext()))
      {
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("name", paramString1.toUpperCase());
        localHashMap2.put("type", paramString2);
        if (paramString2.equalsIgnoreCase("string"))
          localHashMap2.put("value", "");
        else if (paramString2.equalsIgnoreCase("int"))
          localHashMap2.put("value", "0");
        paramBuffer.add(localHashMap2);
      }
    }
  }

  public int checkContainsKey(String paramString, Buffer paramBuffer)
  {
    Iterator localIterator = paramBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if ((localHashMap.get("name") != null) && (localHashMap.get("name").toString().equalsIgnoreCase(paramString)))
        return -1;
    }
    return 0;
  }

  public void list()
  {
    if (this.httpBuffer.isEmpty())
      throw new RuntimeException("缓存还没有初始化,操作失败!");
    Iterator localIterator = this.httpBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if (localHashMap.get("name") != null)
        if (localHashMap.get("value") != null)
          this.log.LOG_INFO(localHashMap.get("name") + ":" + convetStrToDb(localHashMap.get("value").toString()));
        else
          this.log.LOG_INFO(localHashMap.get("name") + ":" + localHashMap.get("value"));
    }
  }

  public String convetStrToDb(String paramString)
  {
    String str = "";
    if ((paramString == null) || (paramString == ""))
      str = "";
    else
      try
      {
        str = new String(paramString.getBytes("ISO8859_1"), "GBK");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    if ((paramString == null) || (paramString == ""))
      str = "";
    return str;
  }

  public String convetStrToWeb(String paramString)
  {
    String str = "";
    if ((paramString == null) || (paramString == ""))
      str = "";
    else
      try
      {
        str = new String(paramString.getBytes("GBK"), "ISO8859_1");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    if ((paramString == null) || (paramString == ""))
      str = "";
    return str;
  }

  public void setSessionField(String paramString)
  {
    String str = "SESSION";
    if (paramString == "")
      return;
    if (getString("SESSION_STR") != "")
      str = getString("SESSION_STR") + "," + paramString;
    else
      str = str + "," + paramString;
    setString("SESSION_STR", str);
  }

  public int removeSessionField(String paramString)
  {
    return 0;
  }

  public ArrayList getSessionList()
  {
    ArrayList localArrayList = new ArrayList();
    String str = getString("SESSION_STR");
    String[] arrayOfString = str.split(",");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (arrayOfString[i].equalsIgnoreCase("SESSION_STR"))
        continue;
      HashMap localHashMap = new HashMap();
      localHashMap.put("name", arrayOfString[i]);
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }

  public String getSessionField(String paramString)
  {
    String str1 = "";
    String str2 = getString("SESSION_STR");
    if (str2.indexOf(paramString) > 0)
      str1 = paramString;
    return str1;
  }

  public void setCommenFields(Buffer paramBuffer1, Buffer paramBuffer2)
  {
    addField("SUCCEED_FWD", paramBuffer1, paramBuffer2);
    addField("ERROR_FWD", paramBuffer1, paramBuffer2);
    addField("SESSION_STR", paramBuffer1, paramBuffer2);
    addField("RESULT_CODE", paramBuffer1, paramBuffer2);
    addField("RESULT_INFO", paramBuffer1, paramBuffer2);
    addField("OUT_QUERY", paramBuffer1, paramBuffer2);
    addField("OUT_BUFFER", paramBuffer1, paramBuffer2);
    addField("SESSION", paramBuffer1, paramBuffer2);
    addField("REALPATH", paramBuffer1, paramBuffer2);
  }

  public String saveUploadFile(FormFile paramFormFile, HttpServletRequest paramHttpServletRequest, HttpSession paramHttpSession, String paramString)
  {
    String str1 = paramHttpServletRequest.getRealPath("");
    String str2 = paramFormFile.getFileName();
    str2 = str2.substring(str2.length() - 4);
    String str3 = paramFormFile.getContentType();
    String str4 = paramFormFile.getFileSize() + " bytes";
    config localconfig = new config();
    localconfig.init();
    String str5 = localconfig.getString("ecms_path");
    String str6 = String.valueOf(paramHttpSession.getAttribute("SESSION_CUST_ID"));
    String str7 = str5 + "/upload/" + str6 + "/" + paramString + str2;
    String str8 = "/upload/" + str6 + "/" + paramString + str2;
    try
    {
      File localFile = new File(str5 + "/upload/" + str6);
      if (!localFile.exists())
        try
        {
          localFile.mkdirs();
        }
        catch (Exception localException)
        {
          this.log.LOG_INFO("创建文件夹失败！");
        }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      InputStream localInputStream = paramFormFile.getInputStream();
      FileOutputStream localFileOutputStream = new FileOutputStream(str7);
      int i = 0;
      byte[] arrayOfByte = new byte[8192];
      while ((i = localInputStream.read(arrayOfByte, 0, 8192)) != -1)
        localFileOutputStream.write(arrayOfByte, 0, i);
      localFileOutputStream.close();
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
    return str8;
  }

  public ArrayList BuffersToBuffer(Buffers paramBuffers)
  {
    Buffer localBuffer = new Buffer();
    Iterator localIterator = this.httpBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      if (localHashMap1.get("name") != null)
      {
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put(localHashMap1.get("name").toString(), localHashMap1.get("value"));
        localBuffer.add(localHashMap2);
      }
    }
    return localBuffer;
  }

  public ArrayList BuffersToArrayList(Buffers paramBuffers)
  {
    Buffer localBuffer = new Buffer();
    Iterator localIterator = this.httpBuffer.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      if (localHashMap1.get("name") != null)
      {
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("type", localHashMap1.get("type").toString());
        localHashMap2.put("name", localHashMap1.get("name").toString());
        localHashMap2.put("value", localHashMap1.get("value"));
        localBuffer.add(localHashMap2);
      }
    }
    return localBuffer;
  }

  public boolean isFieldExist(String paramString)
  {
    return getString(paramString) != null;
  }

  public void convertInterfceData(HttpServletRequest paramHttpServletRequest)
  {
    init(paramHttpServletRequest);
    InterfaceMgr localInterfaceMgr = new InterfaceMgr();
    String str1 = paramHttpServletRequest.getRealPath("");
    Buffer localBuffer = new Buffer();
    String str2 = str1 + "/WEB-INF/interface.flds";
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList = localInterfaceMgr.getInterfaceData(paramHttpServletRequest);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    try
    {
      FileReader localFileReader = new FileReader(str2);
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      for (String str3 = localBufferedReader.readLine(); str3 != null; str3 = localBufferedReader.readLine())
      {
        if ((str3.trim().equalsIgnoreCase("")) || (str3.substring(0, 1).equalsIgnoreCase("#")))
          continue;
        String[] arrayOfString = str3.split(",");
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          if (localHashMap.get(arrayOfString[0].toLowerCase()) != null)
          {
            addField(arrayOfString[1], this.httpBuffer, this.httpBuffer);
            setString(arrayOfString[1], convetStrToWeb(localHashMap.get(arrayOfString[0].toLowerCase()).toString()));
            break;
          }
        }
      }
      localBufferedReader.close();
      localFileReader.close();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("[init]缓存域初始化失败!");
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.buffer.Buffers
 * JD-Core Version:    0.6.0
 */