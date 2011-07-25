package tools.util;

import java.util.Vector;

public class PageTools
{
  private Vector data = null;
  private int curPage;
  private int pageSize;
  private int rowsCount;
  private int pageCount;
  private int pageRoll;

  public PageTools(Vector paramVector)
  {
    this.data = paramVector;
    this.curPage = 1;
    this.pageSize = 10;
    this.rowsCount = paramVector.size();
    this.pageCount = (int)Math.ceil(this.rowsCount / this.pageSize);
  }

  public PageTools(Vector paramVector, int paramInt)
  {
    this.data = paramVector;
    this.curPage = paramInt;
    this.pageSize = 10;
    this.rowsCount = paramVector.size();
    this.pageCount = (int)Math.ceil(this.rowsCount / this.pageSize);
  }

  public PageTools(Vector paramVector, int paramInt1, int paramInt2, int paramInt3)
  {
    this.data = paramVector;
    this.curPage = paramInt1;
    this.pageSize = paramInt2;
    this.pageRoll = paramInt3;
    this.rowsCount = paramVector.size();
    this.pageCount = (int)Math.ceil(this.rowsCount / paramInt2);
  }

  public int getCurPage()
  {
    return this.curPage;
  }

  public int getPageSize()
  {
    return this.pageSize;
  }

  public int getPageRoll()
  {
    return this.pageRoll;
  }

  public int getRowsCount()
  {
    return this.rowsCount;
  }

  public int getPageCount()
  {
    return this.pageCount;
  }

  public int first()
  {
    return 1;
  }

  public int last()
  {
    return this.pageCount;
  }

  public int previous()
  {
    return this.curPage - 1 < 1 ? 1 : this.curPage - 1;
  }

  public int next()
  {
    return this.curPage + 1 > this.pageCount ? this.pageCount : this.curPage + 1;
  }

  public boolean isFirst()
  {
    return this.curPage == 1;
  }

  public boolean isLast()
  {
    return this.curPage == this.pageCount;
  }

  public Vector getData()
  {
    Object localObject = null;
    if (this.data != null)
    {
      int i = (this.curPage - 1) * this.pageSize;
      int j = 0;
      if (i + this.pageSize > this.rowsCount)
        j = this.rowsCount;
      else
        j = i + this.pageSize;
      Vector localVector1 = new Vector();
      Vector localVector2 = this.data;
      for (int k = i; k < j; k++)
        localVector1.add(localVector2.elementAt(k));
      localObject = localVector1;
    }
    return (Vector) localObject;
  }

  public String getToolBar(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = this.pageRoll / 2 + 1;
    String str1 = "";
    if (paramString1.indexOf("?") == -1)
      str1 = "?";
    else
      str1 = "&";
    if (!paramString2.trim().equals(""))
      paramString2 = "&" + paramString2;
    String str2 = "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"" + paramString3 + "\">";
    str2 = str2 + "<tr><td> <table cellpadding=\"0\" cellspacing=\"1\"><tr align=\"center\">";
    str2 = str2 + "<td height=\"19\" bgcolor=\"" + paramString4 + "\">&nbsp;" + this.rowsCount + "&nbsp;</td>";
    str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;" + this.pageSize + "&nbsp;</td>";
    str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;" + this.curPage + "/" + this.pageCount + "页&nbsp;</td>";
    str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=1" + paramString2 + "\"><img src=\"/images/First.gif\" alt=\"首页\" width=\"9\" height=\"8\" border=\"0\"></a>&nbsp;</td>";
    int j;
    if (this.pageCount <= this.pageRoll)
      for (j = 1; j <= this.pageCount; j++)
        if (j == this.curPage)
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
        else
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
    else if (this.curPage <= i)
      for (j = 1; j <= this.pageRoll; j++)
        if (j == this.curPage)
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
        else
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
    else if (this.curPage + this.pageRoll >= this.pageCount)
    {
      if (this.curPage < this.pageCount - i)
        for (j = this.curPage - i + 2; j <= this.curPage - i + 2 + this.pageRoll; j++)
          if (j == this.curPage)
            str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
          else
            str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
      else
        for (j = this.pageCount - this.pageRoll; j <= this.pageCount; j++)
          if (j == this.curPage)
            str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
          else
            str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
    }
    else
      for (j = this.curPage - i; j <= this.curPage - i + this.pageRoll - 1; j++)
        if (j == this.curPage)
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
        else
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
    str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + this.pageCount + paramString2 + "\"><img src=\"/images/Last.gif\" alt=\"尾页\" width=\"9\" height=\"8\" border=\"0\"></a>&nbsp;</td>";
    str2 = str2 + "<td height=22 align=right>";
    str2 = str2 + "</tr></table></td><td align=\"center\" bgcolor=\"" + paramString4 + "\" width=\"100\"> ";
    str2 = str2 + "<table cellpadding=\"0\" cellspacing=\"1\">";
    str2 = str2 + "<form action=\"" + paramString1 + "\" method=\"post\">";
    str2 = str2 + "<tr align=\"center\"><td >";
    str2 = str2 + "<input type=\"text\" name=\"curPage\" size=\"2\" value=\"" + this.curPage + "\"> <input type=\"submit\" value=\"转到\" name=\"pageSubmit\">";
    str2 = str2 + "</td></tr>";
    str2 = str2 + "</form>";
    str2 = str2 + "</table></td></tr></table>";
    return str2;
  }

  public String getSimpleToolBar(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = this.pageRoll / 2 + 1;
    String str1 = "";
    if (paramString1.indexOf("?") == -1)
      str1 = "?";
    else
      str1 = "&";
    if (!paramString2.trim().equals(""))
      paramString2 = "&" + paramString2;
    String str2 = "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"" + paramString3 + "\">";
    str2 = str2 + "<tr><td> <table cellpadding=\"0\" cellspacing=\"1\"><tr align=\"center\">";
    str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=1" + paramString2 + "\"><img src=\"/images/First.gif\" alt=\"首页\" width=\"9\" height=\"8\" border=\"0\"></a>&nbsp;</td>";
    int j;
    if (this.pageCount <= this.pageRoll)
      for (j = 1; j <= this.pageCount; j++)
        if (j == this.curPage)
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
        else
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
    else if (this.curPage <= i)
      for (j = 1; j <= this.pageRoll; j++)
        if (j == this.curPage)
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
        else
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
    else if (this.curPage + this.pageRoll >= this.pageCount)
    {
      if (this.curPage < this.pageCount - i)
        for (j = this.curPage - i + 2; j <= this.curPage - i + 2 + this.pageRoll; j++)
          if (j == this.curPage)
            str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
          else
            str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
      else
        for (j = this.pageCount - this.pageRoll; j <= this.pageCount; j++)
          if (j == this.curPage)
            str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
          else
            str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
    }
    else
      for (j = this.curPage - i; j <= this.curPage - i + this.pageRoll - 1; j++)
        if (j == this.curPage)
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<u><b>" + j + "</b></u>&nbsp;</td>";
        else
          str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + j + paramString2 + "\">" + j + "</a>&nbsp;</td>";
    str2 = str2 + "<td bgcolor=\"" + paramString4 + "\">&nbsp;<a href=\"" + paramString1 + str1 + "curPage=" + this.pageCount + paramString2 + "\"><img src=\"/images/Last.gif\" alt=\"尾页\" width=\"9\" height=\"8\" border=\"0\"></a>&nbsp;</td>";
    str2 = str2 + "<td height=22 align=right>";
    str2 = str2 + "</tr></table></td> ";
    str2 = str2 + "</tr></table>";
    return str2;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.PageTools
 * JD-Core Version:    0.6.0
 */