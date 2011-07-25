package tools.util;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

public class PropertyConfig
{
  private static PropertyConfig _config = null;
  private static Properties dbProps = null;

  protected static PropertyConfig getInstance(String paramString)
  {
    if (_config == null)
      _config = new PropertyConfig(paramString);
    return _config;
  }

  protected PropertyConfig(String paramString)
  {
    InputStream localInputStream = getClass().getClassLoader().getResourceAsStream(paramString);
    dbProps = new Properties();
    try
    {
      dbProps.load(localInputStream);
    }
    catch (Exception localException)
    {
      System.err.println("Can't read the properties file. Make sure " + paramString + " is in the CLASSPATH");
      return;
    }
  }

  public static String getProperty(String paramString1, String paramString2)
  {
    return getProperty(paramString1, paramString2, null);
  }

  public static String getProperty(String paramString1, String paramString2, String paramString3)
  {
    getInstance(paramString1);
    if (dbProps == null)
      return paramString3;
    return dbProps.getProperty(paramString2, paramString3);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.PropertyConfig
 * JD-Core Version:    0.6.0
 */