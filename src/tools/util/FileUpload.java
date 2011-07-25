package tools.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

public class FileUpload
{
  public String saveName = "";
  private static final int DEFAULT_MAX_POST_SIZE = 1048576;
  private static final String NO_FILE = "unknown";
  private static HttpServletRequest req;
  private static File dir;
  private static int encodedir;
  private static int maxSize;
  private static Hashtable parameters = new Hashtable();
  private static Hashtable files = new Hashtable();

  public static void main(String[] paramArrayOfString)
  {
  }

  public FileUpload()
  {
    req = null;
  }

  public void uploadFile(HttpServletRequest paramHttpServletRequest, int paramInt)
    throws IOException
  {
    uploadFile(paramHttpServletRequest, 1048576, paramInt);
  }

  public void uploadFile(HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2)
    throws IOException
  {
    req = paramHttpServletRequest;
    maxSize = paramInt1;
    encodedir = paramInt2;
    readRequest();
  }

  public static void clearFiles()
  {
    files.clear();
  }

  public static void clearParameters()
  {
    parameters.clear();
  }

  public Enumeration getParameterNames()
  {
    return parameters.keys();
  }

  public Enumeration getFileNames()
  {
    return files.keys();
  }

  public String getParameter(String paramString)
  {
    try
    {
      Vector localVector = (Vector)parameters.get(paramString);
      if ((localVector == null) || (localVector.size() == 0))
        return null;
      String str = (String)localVector.elementAt(localVector.size() - 1);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String[] getParameterValues(String paramString)
  {
    try
    {
      Vector localVector = (Vector)parameters.get(paramString);
      if ((localVector == null) || (localVector.size() == 0))
        return null;
      String[] arrayOfString = new String[localVector.size()];
      localVector.copyInto(arrayOfString);
      return arrayOfString;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String getFilesystemName(String paramString)
  {
    try
    {
      UploadedFile localUploadedFile = (UploadedFile)files.get(paramString);
      return localUploadedFile.getFilesystemName();
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String getContentType(String paramString)
  {
    try
    {
      UploadedFile localUploadedFile = (UploadedFile)files.get(paramString);
      return localUploadedFile.getContentType();
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public File getFile(String paramString)
  {
    try
    {
      UploadedFile localUploadedFile = (UploadedFile)files.get(paramString);
      return localUploadedFile.getFile();
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  protected void readRequest()
    throws IOException
  {
    int i = req.getContentLength();
    if (i > maxSize)
      throw new IOException("Posted content length of " + i + " exceeds limit of " + maxSize);
    String localObject = null;
    String str1 = req.getHeader("Content-Type");
    String str2 = req.getContentType();
    if ((str1 == null) && (str2 != null))
      localObject = str2;
    else if ((str2 == null) && (str1 != null))
      localObject = str1;
    else if ((str1 != null) && (str2 != null))
        localObject = str1.length() > str2.length() ? str1 : str2;
    if ((localObject == null) || (!localObject.toLowerCase().startsWith("multipart/form-data")))
      throw new IOException("Posted content type isn't multipart/form-data");
    String str3 = extractBoundary(localObject);
    if (str3 == null)
      throw new IOException("Separation boundary was not specified");
    MultipartInputStreamHandler localMultipartInputStreamHandler = new MultipartInputStreamHandler(req.getInputStream(), i);
    String str4 = localMultipartInputStreamHandler.readLine();
    if (str4 == null)
      throw new IOException("Corrupt form data: premature ending");
    if (!str4.startsWith(str3))
      throw new IOException("Corrupt form data: no leading boundary");
    for (boolean bool = false; !bool; bool = readNextPart(localMultipartInputStreamHandler, str3));
  }

  protected boolean readNextPart(MultipartInputStreamHandler paramMultipartInputStreamHandler, String paramString)
    throws IOException
  {
    String str1 = paramMultipartInputStreamHandler.readLine();
    if (str1 == null)
      return true;
    if (str1.length() == 0)
      return true;
    String[] arrayOfString = extractDispositionInfo(str1);
    String str2 = arrayOfString[0];
    String str3 = arrayOfString[1];
    String str4 = arrayOfString[2];
    str1 = paramMultipartInputStreamHandler.readLine();
    if (str1 == null)
      return true;
    String str5 = extractContentType(str1);
    if (str5 != null)
    {
      str1 = paramMultipartInputStreamHandler.readLine();
      if ((str1 == null) || (str1.length() > 0))
        throw new IOException("Malformed line after content type: " + str1);
    }
    else
    {
      str5 = "application/octet-stream";
    }
    String str6;
    if (str4 == null)
    {
      str6 = readParameter(paramMultipartInputStreamHandler, paramString);
      if (str6.equals(""))
        str6 = null;
      if (str6 != null)
        str6 = new String(str6.getBytes("iso-8859-1"));
      if ((str3 != null) && (str3.equalsIgnoreCase("filepath")) && (str6 != null))
      {
        Object localObject = null;
        if (encodedir == 1)
          localObject = Decode.Decrypt(str6);
        else
          localObject = str6;
        makeAbsoluteDir((String)localObject);
      }
      Object localObject = (Vector)parameters.get(str3);
      if (localObject == null)
      {
        localObject = new Vector();
        parameters.put(str3, localObject);
      }
      ((Vector)localObject).addElement(str6);
    }
    else if (str4.equals("unknown"))
    {
      files.put(str3, new UploadedFile(null, null, null));
    }
    else
    {
      str6 = new String(str4.getBytes("iso-8859-1"));
      readAndSaveFile(paramMultipartInputStreamHandler, paramString, this.saveName + str6.substring(str6.lastIndexOf("."), str6.length()), str5);
      files.put(str3, new UploadedFile(dir.toString(), str4, str5));
    }
    return false;
  }

  protected String readParameter(MultipartInputStreamHandler paramMultipartInputStreamHandler, String paramString)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    while (((str = paramMultipartInputStreamHandler.readLine()) != null) && (!str.startsWith(paramString)))
      localStringBuffer.append(str + "\r\n");
    if (localStringBuffer.length() == 0)
      return null;
    localStringBuffer.setLength(localStringBuffer.length() - 2);
    return localStringBuffer.toString();
  }

  protected void readAndSaveFile(MultipartInputStreamHandler paramMultipartInputStreamHandler, String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    Object localObject1 = null;
    if (paramString2.equals("unknown"))
      localObject1 = new ByteArrayOutputStream();
    if (dir == null)
    {
      dir = new File("/uploadfile");
    }
    else if (paramString3.equals("application/x-macbinary"))
    {
     Object localObject2 = new File(dir + File.separator + paramString2);
      localObject1 = new MacBinaryDecoderOutputStream(new BufferedOutputStream(new FileOutputStream((File)localObject2), 8192));
    }
    else
    {
    Object  localObject2 = new File(dir + File.separator + paramString2);
      localObject1 = new BufferedOutputStream(new FileOutputStream((File)localObject2), 8192);
    }
    Object localObject2 = new byte[102400];
    int j = 0;
    int i;
    while ((i = paramMultipartInputStreamHandler.readLine(localObject2, 0, localObject2.length)) != -1)
    {
      if ((i > 2) && (localObject2[0] == 45) && (localObject2[1] == 45))
      {
        String str = new String(localObject2, 0, i, "ISO-8859-1");
        if (str.startsWith(paramString1))
          break;
      }
      if (j != 0)
      {
        ((OutputStream)localObject1).write(13);
        ((OutputStream)localObject1).write(10);
        j = 0;
      }
      if ((i >= 2) && (localObject2[(i - 2)] == 13) && (localObject2[(i - 1)] == 10))
      {
        ((OutputStream)localObject1).write(localObject2, 0, i - 2);
        j = 1;
        continue;
      }
      ((OutputStream)localObject1).write(localObject2, 0, i);
    }
    ((OutputStream)localObject1).flush();
    ((OutputStream)localObject1).close();
  }

  private String extractBoundary(String paramString)
  {
    int i = paramString.lastIndexOf("boundary=");
    if (i == -1)
      return null;
    String str = paramString.substring(i + 9);
    str = "--" + str;
    return str;
  }

  private String[] extractDispositionInfo(String paramString)
    throws IOException
  {
    String[] arrayOfString = new String[3];
    String str1 = paramString;
    paramString = str1.toLowerCase();
    int i = paramString.indexOf("content-disposition: ");
    int j = paramString.indexOf(";");
    if ((i == -1) || (j == -1))
      throw new IOException("Content disposition corrupt: " + str1);
    String str2 = paramString.substring(i + 21, j);
    if (!str2.equals("form-data"))
      throw new IOException("Invalid content disposition: " + str2);
    i = paramString.indexOf("name=\"", j);
    j = paramString.indexOf("\"", i + 7);
    if ((i == -1) || (j == -1))
      throw new IOException("Content disposition corrupt: " + str1);
    String str3 = str1.substring(i + 6, j);
    String str4 = null;
    i = paramString.indexOf("filename=\"", j + 2);
    j = paramString.indexOf("\"", i + 10);
    if ((i != -1) && (j != -1))
    {
      str4 = str1.substring(i + 10, j);
      int k = Math.max(str4.lastIndexOf(47), str4.lastIndexOf(92));
      if (k > -1)
        str4 = str4.substring(k + 1);
      if (str4.equals(""))
        str4 = "unknown";
    }
    arrayOfString[0] = str2;
    arrayOfString[1] = str3;
    arrayOfString[2] = str4;
    return arrayOfString;
  }

  private String extractContentType(String paramString)
    throws IOException
  {
    String str1 = null;
    String str2 = paramString;
    paramString = str2.toLowerCase();
    if (paramString.startsWith("content-type"))
    {
      int i = paramString.indexOf(" ");
      if (i == -1)
        throw new IOException("Content type corrupt: " + str2);
      str1 = paramString.substring(i + 1);
    }
    else if (paramString.length() != 0)
    {
      throw new IOException("Malformed line after disposition: " + str2);
    }
    return str1;
  }

  public String getServletPath()
    throws IOException
  {
    File localFile = new File(".");
    String str = localFile.getAbsolutePath();
    str = str.substring(0, str.length() - 2);
    return str;
  }

  public String getDirectory(String paramString)
    throws IOException
  {
    if (paramString.compareTo(".") == 0)
      paramString = "";
    String str = getServletPath() + paramString;
    str = EscapePathString(str);
    return str;
  }

  public boolean makeRelativeDir(String paramString)
    throws IOException
  {
    String str = getDirectory(paramString);
    dir = new File(str);
    if ((!dir.exists()) || (dir.isFile()))
      dir.mkdirs();
    if (!dir.canWrite())
    {
      System.out.println("Please check directory " + dir + " exists and is writable");
      return false;
    }
    return true;
  }

  public boolean makeAbsoluteDir(String paramString)
    throws IOException
  {
    dir = new File(paramString);
    if ((!dir.exists()) || (dir.isFile()))
      dir.mkdirs();
    if (!dir.canWrite())
    {
      System.out.println("Please check directory " + dir + " exists and is writable");
      return false;
    }
    return true;
  }

  public String EscapePathString(String paramString)
    throws IOException
  {
    int i = paramString.length();
    String str1 = "";
    char[] arrayOfChar = paramString.toCharArray();
    String str2 = "";
    for (int j = 0; j < i; j++)
    {
      str2 = String.valueOf(arrayOfChar[j]);
      if ((str2.equals("\\") == true) || (str2.equals("/") == true))
        str1 = str1 + File.separator;
      else
        str1 = str1 + arrayOfChar[j];
    }
    return str1;
  }

  public File getFilebyName(String paramString)
    throws IOException
  {
    String str = getDirectory(paramString);
    File localFile = null;
    localFile = new File(str);
    if (localFile.exists())
      return localFile;
    return null;
  }

  public File getFilebyPath(String paramString)
    throws IOException
  {
    File localFile = null;
    localFile = new File(paramString);
    if (localFile.exists())
      return localFile;
    return null;
  }

  public boolean deleteFile(File paramFile)
    throws IOException
  {
    if (paramFile == null)
      return false;
    paramFile.delete();
    return true;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.FileUpload
 * JD-Core Version:    0.6.0
 */