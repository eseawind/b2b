package com.saas.biz.commen;

import com.saas.sys.log.Logger;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DwindlePic
{
  Logger log = new Logger(this);

  public boolean doZoom(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws Exception
  {
    File localFile1 = new File(paramString1);
    BufferedImage localBufferedImage1 = ImageIO.read(localFile1);
    BufferedImage localBufferedImage2 = new BufferedImage(paramInt1, paramInt2, 4);
    localBufferedImage2.getGraphics().drawImage(localBufferedImage1, 0, 0, paramInt1, paramInt2, null);
    File localFile2 = new File(paramString2);
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
    JPEGImageEncoder localJPEGImageEncoder = JPEGCodec.createJPEGEncoder(localFileOutputStream);
    localJPEGImageEncoder.encode(localBufferedImage2);
    localFileOutputStream.close();
    return true;
  }

  public void ImgYin(String paramString1, String paramString2)
  {
    config localconfig = new config();
    localconfig.init();
    String str = localconfig.getString("yinroot_path");
    try
    {
      paramString2 = str + paramString2;
      File localFile1 = new File(paramString2);
      BufferedImage localBufferedImage1 = ImageIO.read(localFile1);
      int i = localBufferedImage1.getWidth(null);
      int j = localBufferedImage1.getHeight(null);
      BufferedImage localBufferedImage2 = new BufferedImage(i, j, 1);
      Graphics2D localGraphics2D = localBufferedImage2.createGraphics();
      localGraphics2D.drawImage(localBufferedImage1, 0, 0, i, j, null);
      File localFile2 = new File(paramString1);
      BufferedImage localBufferedImage3 = ImageIO.read(localFile2);
      int k = localBufferedImage3.getWidth(null);
      int m = localBufferedImage3.getHeight(null);
      localGraphics2D.drawImage(localBufferedImage3, i - 150, j - 45, k, m, null);
      localGraphics2D.dispose();
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
      JPEGImageEncoder localJPEGImageEncoder = JPEGCodec.createJPEGEncoder(localFileOutputStream);
      localJPEGImageEncoder.encode(localBufferedImage2);
      localFileOutputStream.close();
    }
    catch (Exception localException)
    {
      System.out.println(localException);
    }
  }

  public class RandomCodeServlet extends HttpServlet
  {
    private int width = 60;
    private int height = 20;

    public RandomCodeServlet()
    {
    }

    protected void service(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
      throws ServletException, IOException
    {
      BufferedImage localBufferedImage = new BufferedImage(this.width, this.height, 1);
      Graphics2D localGraphics2D = localBufferedImage.createGraphics();
      Random localRandom = new Random();
      localGraphics2D.setColor(Color.WHITE);
      localGraphics2D.fillRect(0, 0, this.width, this.height);
      Font localFont = new Font("Times New Roman", 0, 18);
      localGraphics2D.setFont(localFont);
      localGraphics2D.setColor(Color.BLACK);
      localGraphics2D.drawRect(0, 0, this.width - 1, this.height - 1);
      localGraphics2D.setColor(Color.GRAY);
      for (int i = 0; i < 160; i++)
      {
        int j = localRandom.nextInt(this.width);
        int k = localRandom.nextInt(this.height);
        int m = localRandom.nextInt(12);
        int n = localRandom.nextInt(12);
        localGraphics2D.drawLine(j, k, j + m, k + n);
      }
      StringBuffer localStringBuffer = new StringBuffer();
      int j = 0;
      int k = 0;
      int m = 0;
      for (int n = 0; n < 4; n++)
      {
        Object localObject = String.valueOf(localRandom.nextInt(10));
        j = localRandom.nextInt(110);
        k = localRandom.nextInt(50);
        m = localRandom.nextInt(50);
        localGraphics2D.setColor(new Color(j, k, m));
        localGraphics2D.drawString((String)localObject, 13 * n + 6, 16);
        localStringBuffer.append((String)localObject);
      }
      HttpSession localHttpSession = paramHttpServletRequest.getSession();
      localHttpSession.setAttribute("randomCode", localStringBuffer.toString());
      paramHttpServletResponse.setHeader("Pragma", "no-cache");
      paramHttpServletResponse.setHeader("Cache-Control", "no-cache");
      paramHttpServletResponse.setDateHeader("Expires", 0L);
      paramHttpServletResponse.setContentType("image/jpeg");
      Object localObject = paramHttpServletResponse.getOutputStream();
      ImageIO.write(localBufferedImage, "jpeg", (OutputStream)localObject);
      ((ServletOutputStream)localObject).close();
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.DwindlePic
 * JD-Core Version:    0.6.0
 */