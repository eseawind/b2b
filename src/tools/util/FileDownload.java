package tools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownload extends HttpServlet
{
  public void init(ServletConfig paramServletConfig)
    throws ServletException
  {
    super.init(paramServletConfig);
  }

  public void destroy()
  {
  }

  public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    int i = 0;
    if (paramHttpServletRequest.getParameter("FileDecode") != null)
      i = Integer.parseInt(paramHttpServletRequest.getParameter("FileDecode").toString());
    else
      i = 1;
    String str1 = null;
    if (paramHttpServletRequest.getParameter("FullFileName") != null)
      str1 = paramHttpServletRequest.getParameter("FullFileName").toString();
    else
      return;
    if (i == 1)
      str1 = Decode.Decrypt(str1);
    String str2 = str1.substring(str1.lastIndexOf(File.separator) + 1, str1.length());
    int j = 6000;
    File localFile = new File(str1);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      long l = localFile.length();
      int k = 0;
      int m = 0;
      byte[] arrayOfByte = new byte[j];
      paramHttpServletResponse.setContentType("application/x-something");
      paramHttpServletResponse.setContentLength((int)l);
      paramHttpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + str2);
      while (m < l)
      {
        k = localFileInputStream.read(arrayOfByte, 0, j);
        m += k;
        paramHttpServletResponse.getOutputStream().write(arrayOfByte, 0, k);
      }
      localFileInputStream.close();
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.FileDownload
 * JD-Core Version:    0.6.0
 */