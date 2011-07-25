package com.saas.biz.commen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckImage extends HttpServlet
{
  private int width = 60;
  private int height = 20;

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
    int j = 0;
    int k = 0;
    int m = 0;
    for (int i = 0; i < 160; i++)
    {
      j = localRandom.nextInt(this.width);
      k = localRandom.nextInt(this.height);
      m = localRandom.nextInt(12);
      int n = localRandom.nextInt(12);
      localGraphics2D.drawLine(j, k, j + m, k + n);
    }
    StringBuffer localStringBuffer = new StringBuffer();
   
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
    localHttpSession.setAttribute("RANDOMCODE", localStringBuffer.toString());
    paramHttpServletResponse.setHeader("Pragma", "no-cache");
    paramHttpServletResponse.setHeader("Cache-Control", "no-cache");
    paramHttpServletResponse.setDateHeader("Expires", 0L);
    paramHttpServletResponse.setContentType("image/jpeg");
    Object localObject = paramHttpServletResponse.getOutputStream();
    ImageIO.write(localBufferedImage, "jpeg", (OutputStream)localObject);
    ((ServletOutputStream)localObject).close();
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.CheckImage
 * JD-Core Version:    0.6.0
 */