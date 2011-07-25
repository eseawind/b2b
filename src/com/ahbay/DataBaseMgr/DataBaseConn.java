package com.ahbay.DataBaseMgr;

import com.saas.biz.commen.config;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConn
{
  public Connection GetConnection()
  {
    config localconfig = new config();
    localconfig.init();
    String str1 = localconfig.getString("mysqlbase.user");
    String str2 = localconfig.getString("mysqlbase.password");
    String str3 = "org.gjt.mm.mysql.Driver";
    String str4 = "jdbc:mysql://" + localconfig.getString("mysqlbase.host") + ":" + localconfig.getString("mysqlbase.port") + "/" + localconfig.getString("mysqlbase.sid") + "?useUnicode=true&characterEncoding=GBK";
    Connection localConnection = null;
    try
    {
      Class.forName(str3).newInstance();
      localConnection = DriverManager.getConnection(str4, str1, str2);
      localConnection.setAutoCommit(false);
    }
    catch (Exception localException)
    {
      System.out.println("insert Edit error message :" + localException.getMessage());
    }
    return localConnection;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.DataBaseMgr.DataBaseConn
 * JD-Core Version:    0.6.0
 */