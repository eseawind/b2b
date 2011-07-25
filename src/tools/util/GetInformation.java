package tools.util;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class GetInformation
{
  public Properties prop;

  public GetInformation(String paramString)
  {
    String str = paramString.trim();
    init(str);
  }

  private void init(String paramString)
  {
    InputStream localInputStream = getClass().getClassLoader().getResourceAsStream(paramString);
    this.prop = new Properties();
    try
    {
      this.prop.load(localInputStream);
    }
    catch (Exception localException)
    {
      System.err.println("Can't read from property file: " + paramString + ".Make sure that the file is under proper path");
      return;
    }
  }

  public String getProperty(String paramString)
  {
    String str = "";
    str = this.prop.getProperty(paramString);
    if (str == null)
    {
      System.out.println("Please check the property name '" + paramString + "' and try it again");
      str = "";
    }
    return str;
  }

  public static String getPropFromBundle(String paramString1, String paramString2)
  {
    try
    {
      ResourceBundle localResourceBundle = ResourceBundle.getBundle(paramString1);
      return localResourceBundle.getString(paramString2);
    }
    catch (MissingResourceException localMissingResourceException)
    {
      localMissingResourceException.printStackTrace();
    }
    return "";
  }

  public static void main(String[] paramArrayOfString)
  {
    System.out.println(getPropFromBundle("db", paramArrayOfString[0]));
    System.out.println("This is a test");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.GetInformation
 * JD-Core Version:    0.6.0
 */