package com.base.config;

import com.saas.biz.commen.config;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

public class ProjectConfig
{
  private static ProjectConfig _config = null;
  private static config configFile;
  public static final int ORACLEDB = 1;
  public static final int SQLSVRDB = 2;
  public static final int MYSQLDB = 3;
  public static final String DBTITLE = getInstance().getMainDB();
  public static String WEBTITLE = configFile.getString("mysqlbase.webtitle");
  public static String BOTTOM = configFile.getString("mysqlbase.bottom");
  public static String LOGOPATH = configFile.getString("mysqlbase.logopath");
  public static String WEBNAME = configFile.getString("mysqlbase.webname");
  public static String WEBADD = configFile.getString("mysqlbase.webadd");
  public static String WEBDESC = configFile.getString("mysqlbase.webdesc");
  private String MainDB = null;

  public static ProjectConfig getInstance()
  {
    configFile = new config();
    configFile.init();
    if (_config == null)
      _config = new ProjectConfig();
    return _config;
  }

  protected ProjectConfig()
  {
    InputStream localInputStream = getClass().getClassLoader().getResourceAsStream("login.properties");
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(localInputStream);
    }
    catch (Exception localException)
    {
      System.err.println("Can't read the properties file. Make sure login.properties is in the CLASSPATH");
      return;
    }
    this.MainDB = localProperties.getProperty("MainDB", "mysqlbase");
  }

  private String getMainDB()
  {
    return this.MainDB;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.base.config.ProjectConfig
 * JD-Core Version:    0.6.0
 */