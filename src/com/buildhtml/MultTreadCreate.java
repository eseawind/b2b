package com.buildhtml;

import java.util.HashMap;

public class MultTreadCreate extends Thread
{
  public static String ttag;
  public static CreateChannel createchannel;
  public static CreateArticle createarticle;
  public static CreateIndex createindex;

  public MultTreadCreate(String paramString)
  {
    ttag = paramString;
  }

  public static void main(String[] paramArrayOfString)
  {
    createchannel = new CreateChannel();
    createarticle = new CreateArticle();
    createindex = new CreateIndex();
    MultTreadCreate localMultTreadCreate1 = new MultTreadCreate("1");
    MultTreadCreate localMultTreadCreate2 = new MultTreadCreate("2");
    MultTreadCreate localMultTreadCreate3 = new MultTreadCreate("3");
    Thread localThread1 = new Thread(localMultTreadCreate1);
    Thread localThread2 = new Thread(localMultTreadCreate2);
    Thread localThread3 = new Thread(localMultTreadCreate3);
    localThread1.start();
    localThread2.start();
    localThread3.start();
  }

  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (ttag.equals("1"))
      CreateIndex.CreateIndex("11", "templates/wood/templates/index.html", "/", "index.html");
    else if (ttag.equals("2"))
      try
      {
        CreateChannel.CreateChannelIndexList("0000000000");
      }
      catch (Exception localException1)
      {
        throw new RuntimeException(localException1);
      }
    else if (ttag.equals("3"))
      try
      {
        CreateArticle.CreateArticleList("0000000000", "1");
      }
      catch (Exception localException2)
      {
        throw new RuntimeException(localException2);
      }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.MultTreadCreate
 * JD-Core Version:    0.6.0
 */