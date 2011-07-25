package com.saas.biz.commen;

import com.saas.sys.exp.SaasApplicationException;
import java.io.PrintStream;

public class PageTools
{
  public String getPageTools(String paramString1, String paramString2, String paramString3, int paramInt)
    throws SaasApplicationException
  {
    int i = 0;
    int j = 1;
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    if (Integer.parseInt(paramString1) % Integer.parseInt(paramString2) == 0)
      i = Integer.parseInt(paramString1) / Integer.parseInt(paramString2);
    else
      i = Integer.parseInt(paramString1) / Integer.parseInt(paramString2) + 1;
    if (paramInt > i)
      paramInt = i;
    if (Integer.parseInt(paramString1) == 0)
    {
      str1 = "首页";
      str3 = "上一页";
      str4 = "下一页";
      str2 = "尾页";
    }
    else if (paramInt == 1)
    {
      if (i > 1)
      {
        j = paramInt + 1;
        str1 = "首页";
        str3 = "上一页";
        str4 = new StringBuilder().append("<a href='").append(paramString3).append(j).append("' style=color:#3300FF>下一页</a>").toString();
        str2 = new StringBuilder().append("<a href='").append(paramString3).append(i).append("' style=color:#3300FF>尾页</a>").toString();
      }
      else
      {
        str1 = "首页";
        str3 = "上一页";
        str4 = "下一页";
        str2 = "尾页";
      }
    }
    else if (paramInt == i)
    {
      str1 = new StringBuilder().append("<a href='").append(paramString3).append("1' style=color:#3300FF>").append("首页</a>").toString();
      str3 = new StringBuilder().append("<a href='").append(paramString3).append(paramInt - 1).append("' style=color:#3300FF>上一页</a>").toString();
      str4 = "下一页";
      str2 = "尾页";
    }
    else
    {
      str1 = new StringBuilder().append("<a href='").append(paramString3).append("1' style=color:#3300FF>").append("首页</a>").toString();
      str3 = new StringBuilder().append("<a href='").append(paramString3).append(paramInt - 1).append("' style=color:#3300FF>上一页</a>").toString();
      str4 = new StringBuilder().append("<a href='").append(paramString3).append(paramInt + 1).append("' style=color:#3300FF>下一页</a>").toString();
      str2 = new StringBuilder().append("<a href='").append(paramString3).append(i).append("' style=color:#3300FF>尾页</a>").toString();
    }
    String str5 = new StringBuilder().append("<td align='left' colspan='2' style='font-weight:bold; padding:2px 5px;'>共<span style=color:#3300FF>").append(paramString1).append("</span>条 &nbsp;共<span style=color:#3300FF>").append(i).append("</span>页").append("&nbsp;第<span style=color:#FF0000>").append(paramInt).append("</span>页").append("</td>").append("<td align='right' colspan='5' style='padding:2px 5px;font-weight: bold;'>").append(str1).append("&nbsp; &nbsp;").append(str3).append(" &nbsp;").append(str4).append("&nbsp; ").append(str2).append("</td>").toString();
    return str5;
  }

  public static void main(String[] paramArrayOfString)
    throws SaasApplicationException
  {
    System.out.println(new PageTools().getGoogleToolsBar(137, "page", 4, 5));
  }

  public String getGoogleToolsBar(int paramInt1, String paramString, int paramInt2, int paramInt3)
    throws SaasApplicationException
  {
    String str = "";
    int i = 0;
    if (paramInt1 % paramInt3 == 0)
      i = paramInt1 / paramInt3;
    else
      i = paramInt1 / paramInt3 + 1;
    if (paramInt2 > i)
      paramInt2 = i;
    int j;
    page localpage;
    if (paramInt2 == 1)
    {
      if (i > 1)
        for (j = 1; (j < 10) && (j <= i); j++)
          if (j == paramInt2)
          {
            localpage = new page();
            localpage.setNum(new StringBuilder().append(j).append("").toString());
            localpage.setLink(new StringBuilder().append("<a href=").append(paramString).append(j).append(" style='font-weight:bold;color:#FF3300'>").toString());
            str = new StringBuilder().append(str).append(localpage.toString()).append("&nbsp;").toString();
          }
          else
          {
            localpage = new page();
            localpage.setNum(new StringBuilder().append(j).append("").toString());
            localpage.setLink(new StringBuilder().append("<a href=").append(paramString).append(j).append(">").toString());
            str = new StringBuilder().append(str).append(localpage.toString()).append("&nbsp;").toString();
          }
    }
    else if (paramInt2 == i)
      for (j = i; (j > i - 10) && (j != 0); j--)
        if (j == paramInt2)
        {
          localpage = new page();
          localpage.setNum(new StringBuilder().append(j).append("").toString());
          localpage.setLink(new StringBuilder().append("<a href=").append(paramString).append(j).append(" style='font-weight:bold;color:#FF3300'>").toString());
          str = new StringBuilder().append(localpage.toString()).append("&nbsp;").append(str).toString();
        }
        else
        {
          localpage = new page();
          localpage.setNum(new StringBuilder().append(j).append("").toString());
          localpage.setLink(new StringBuilder().append("<a href=").append(paramString).append(j).append(">").toString());
          str = new StringBuilder().append(localpage.toString()).append("&nbsp;").append(str).toString();
        }
    else
      return pagination(paramInt1, paramInt3, paramInt2, paramString);
    str = new StringBuilder().append("共").append(paramInt1).append("条 &nbsp;").append(i).append("页&nbsp;&nbsp;").append(str).toString();
    return str;
  }

  public String pagination(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    String str = "";
    if (paramInt3 < 1)
      paramInt3 = 1;
    if (paramInt2 != 0)
    {
      i = paramInt1 / paramInt2;
      i = paramInt1 % paramInt2 != 0 ? i + 1 : i;
      i = i == 0 ? 1 : i;
    }
    j = paramInt3 + 1;
    k = paramInt3 - 1;
    m = paramInt3 + 5 > i ? i - 9 : paramInt3 - 4;
    n = paramInt3 < 5 ? 10 : paramInt3 + 5;
    if (m < 1)
      m = 1;
    if (i < n)
      n = i;
    str = new StringBuilder().append("共").append(i).append("页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").toString();
    str = new StringBuilder().append(str).append(paramInt3 > 1 ? new StringBuilder().append("<a href=\"").append(paramString).append("1\">首页</a>&nbsp;&nbsp;<a href=\"").append(paramString).append("").append(k).append("\">上一页</a>").toString() : "首页 上一页").toString();
    for (int i1 = m; i1 <= n; i1++)
      str = new StringBuilder().append(str).append(paramInt3 == i1 ? new StringBuilder().append("&nbsp;&nbsp;<font color=\"#ff0000\">[").append(i1).append("]</font>").toString() : new StringBuilder().append("&nbsp;&nbsp;<a href=\"").append(paramString).append(i1).append("\">[").append(i1).append("]</a>").toString()).toString();
    str = new StringBuilder().append(str).append(paramInt3 != i ? new StringBuilder().append("&nbsp;&nbsp;<a href=\"").append(paramString).append(j).append("\">下一页</a>&nbsp;&nbsp;<a href=\"").append(paramString).append(i).append("\">末页</a>").toString() : " 下一页 末页").toString();
    return str;
  }

  class page
  {
    private String head = "[";
    private String bottom = "]";
    private String num;
    private String link;

    public page()
    {
    }

    public String getNum()
    {
      return this.num;
    }

    public void setNum(String paramString)
    {
      this.num = paramString;
    }

    public String toString()
    {
      return this.link + this.head + this.num + this.bottom + "</a>";
    }

    public String getHead()
    {
      return this.head;
    }

    public void setHead(String paramString)
    {
      this.head = paramString;
    }

    public String getBottom()
    {
      return this.bottom;
    }

    public void setBottom(String paramString)
    {
      this.bottom = paramString;
    }

    public String getLink()
    {
      return this.link;
    }

    public void setLink(String paramString)
    {
      this.link = paramString;
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.PageTools
 * JD-Core Version:    0.6.0
 */