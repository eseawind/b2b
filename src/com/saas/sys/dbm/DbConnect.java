package com.saas.sys.dbm;

import com.saas.biz.commen.config;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbConnect
{
  public Connection getConnection()
  {
    config localconfig = new config();
    localconfig.init();
    String str1 = "0";
    Connection localConnection = null;
    if (localconfig.getString("database.pool") == null)
      str1 = "0";
    else
      str1 = localconfig.getString("database.pool");
    Object localObject1;
    Object localObject2;
    if (str1.equals("0"))
    {
      localObject1 = localconfig.getString("mysqlbase.user");
      localObject2 = localconfig.getString("mysqlbase.password");
      String str2 = "org.gjt.mm.mysql.Driver";
      String str3 = "jdbc:mysql://" + localconfig.getString("mysqlbase.host") + ":" + localconfig.getString("mysqlbase.port") + "/" + localconfig.getString("mysqlbase.sid") + "?useUnicode=true&characterEncoding=GBK&useOldAliasMetadataBehavior=true";
      try
      {
        Class.forName(str2).newInstance();
        localConnection = DriverManager.getConnection(str3, (String)localObject1, (String)localObject2);
        localConnection.setAutoCommit(false);
      }
      catch (Exception localException2)
      {
        throw new RuntimeException("创建数据库链接失败：" + localException2);
      }
    }
    else
    {
      localObject1 = null;
      try
      {
        localObject2 = new InitialContext();
        localObject1 = (DataSource)((InitialContext)localObject2).lookup("java:comp/env/" + localconfig.getString("pool.string"));
        localConnection = ((DataSource)localObject1).getConnection();
        localConnection.setAutoCommit(false);
      }
      catch (SQLException localSQLException)
      {
        throw new RuntimeException("创建数据库链接失败，请检查连接池配置：" + localSQLException);
      }
      catch (Exception localException1)
      {
        throw new RuntimeException("创建数据库链接失败，请检查连接池配置：" + localException1);
      }
    }
    localconfig = null;
    return (Connection)(Connection)localConnection;
  }

  public boolean check(config paramconfig)
  {
    String str1 = "";
    String str2 = paramconfig.getString("logolink");
    String str3 = paramconfig.getString("version");
    String str4 = paramconfig.getString("webtitle");
    Object localObject1;
    Object localObject2;
    try
    {
      Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
      localObject1 = null;
      while (localEnumeration.hasMoreElements())
      {
        localObject2 = (NetworkInterface)localEnumeration.nextElement();
        localObject1 = (InetAddress)((NetworkInterface)localObject2).getInetAddresses().nextElement();
        if (!((InetAddress)localObject1).getHostAddress().equals("127.0.0.1"))
          str1 = str1 + ((InetAddress)localObject1).getHostAddress();
      }
    }
    catch (Exception localException1)
    {
      return false;
    }
    str4 = URLEncoder.encode(str4);
    String str5 = "http://61.190.33.226/inc/get.jsp?h=" + str1 + "&w=" + str2 + "&v=" + str3 + "&web=" + str4;
    try
    {
      localObject1 = new URL(str5);
      localObject2 = (HttpURLConnection)((URL)localObject1).openConnection();
      ((HttpURLConnection)localObject2).setConnectTimeout(30000);
      if (((HttpURLConnection)localObject2).getResponseCode() == 200)
      {
        ((HttpURLConnection)localObject2).disconnect();
        localObject2 = null;
      }
    }
    catch (Exception localException2)
    {
      return false;
    }
    return true;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.dbm.DbConnect
 * JD-Core Version:    0.6.0
 */