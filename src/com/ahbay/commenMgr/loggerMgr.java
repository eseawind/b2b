package com.ahbay.commenMgr;

import java.sql.ResultSet;

public class loggerMgr
{
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();

  public String AddLoggerinfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    String str1 = "";
    str1 = "insert into logs (endpage,querystring,frompage,useragent,ip,vtime,username) values('" + paramString1 + "'," + "'" + paramString2 + "'," + "'" + paramString3 + "'," + "'" + paramString4 + "'," + "'" + paramString5 + "'," + "now()," + "'" + paramString6 + "'" + ")";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }

  public void AddRunnfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str1 = "";
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    ResultSet localResultSet = null;
    int i = 0;
    String str2 = "select count(www) from myuser where www='" + paramString2 + "'";
    this.DBQuery.setStrQuery(str2);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
        i = localResultSet.getInt(1);
      if (i > 0)
      {
        localResultSet = null;
        return;
      }
    }
    catch (Exception localException)
    {
      localResultSet = null;
    }
    localResultSet = null;
    str1 = "insert into myuser (host,www,ver,web,in_date) values ('" + paramString1 + "'," + "'" + paramString2 + "'," + "'" + paramString3 + "'," + "'" + paramString4 + "'," + "now() " + ")";
    this.DBQuery.setStrQuery(str1);
    String str3 = this.DBQuery.ExecBizQuery();
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.commenMgr.loggerMgr
 * JD-Core Version:    0.6.0
 */