package tools.util;

import java.io.PrintStream;

public class BrandingUtil
{
  private static String CONFIGFILE = PropertyConfig.getProperty("config.properties", "BRANDING_CONFIG");
  private static XMLProperties prop = null;

  public static String PageHeader(String paramString)
  {
    return PageHeader("default", paramString);
  }

  public static String PageHeader(String paramString1, String paramString2)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return StringUtil.replace(prop.getProperty(paramString1 + ".pageheader"), "[?]", paramString2);
  }

  public static String MenuHeader()
  {
    return MenuHeader("default");
  }

  public static String MenuHeader(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".menuheader");
  }

  public static String PageFooter()
  {
    return PageFooter("default");
  }

  public static String PageFooter(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".pagefooter");
  }

  public static String MenuFooter()
  {
    return MenuFooter("default");
  }

  public static String MenuFooter(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".menufooter");
  }

  public static String pgc()
  {
    return pgc("default");
  }

  public static String pgc(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".pgc");
  }

  public static String tbc()
  {
    return tbc("default");
  }

  public static String tbc(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tbc");
  }

  public static String tth()
  {
    return tth("default");
  }

  public static String tth(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tth");
  }

  public static String thh()
  {
    return thh("default");
  }

  public static String thh(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".thh");
  }

  public static String tch()
  {
    return tch("default");
  }

  public static String tch(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tch");
  }

  public static String tfh()
  {
    return tfh("default");
  }

  public static String tfh(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tfh");
  }

  public static String ttc()
  {
    return ttc("default");
  }

  public static String ttc(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".ttc");
  }

  public static String thc()
  {
    return thc("default");
  }

  public static String thc(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".thc");
  }

  public static String tcc()
  {
    return tcc("default");
  }

  public static String tcc(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tcc");
  }

  public static String tfc()
  {
    return tfc("default");
  }

  public static String tfc(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tfc");
  }

  public static String tlc()
  {
    return tlc("default");
  }

  public static String tlc(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tlc");
  }

  public static String TableLine(int paramInt)
  {
    return TableLine(paramInt, "default");
  }

  public static String TableLine(int paramInt, String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return StringUtil.replace(prop.getProperty(paramString + ".tableline"), "[?]", "" + paramInt);
  }

  public static String ttf()
  {
    return ttf("default");
  }

  public static String ttf(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".ttf");
  }

  public static String ttfend()
  {
    return ttfend("default");
  }

  public static String ttfend(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".ttfend");
  }

  public static String thf()
  {
    return thf("default");
  }

  public static String thf(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".thf");
  }

  public static String thfend()
  {
    return thfend("default");
  }

  public static String thfend(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".thfend");
  }

  public static String tcf()
  {
    return tcf("default");
  }

  public static String tcf(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tcf");
  }

  public static String tcfend()
  {
    return tcfend("default");
  }

  public static String tcfend(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tcfend");
  }

  public static String tff()
  {
    return tff("default");
  }

  public static String tff(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tff");
  }

  public static String tffend()
  {
    return tffend("default");
  }

  public static String tffend(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tffend");
  }

  public static String hf()
  {
    return hf("default");
  }

  public static String hf(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".hf");
  }

  public static String hfend()
  {
    return hfend("default");
  }

  public static String hfend(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".hfend");
  }

  public static String tbs()
  {
    return tbs("default");
  }

  public static String tbs(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tbs");
  }

  public static String tbsend()
  {
    return tbsend("default");
  }

  public static String tbsend(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tbsend");
  }

  public static String bs()
  {
    return bs("default");
  }

  public static String bs(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".bs");
  }

  public static String ts()
  {
    return ts("default");
  }

  public static String ts1()
  {
    return ts1("default");
  }

  public static String ts(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".ts");
  }

  public static String ts1(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".ts1");
  }

  public static String tas()
  {
    return tas("default");
  }

  public static String tas(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tas");
  }

  public static String ss()
  {
    return ss("default");
  }

  public static String ss(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".ss");
  }

  public static String cs()
  {
    return cs("default");
  }

  public static String cs(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".cs");
  }

  public static String rs()
  {
    return rs("default");
  }

  public static String rs(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".rs");
  }

  public static String mbc()
  {
    return mbc("default");
  }

  public static String mbc(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".mbc");
  }

  public static String mhf()
  {
    return mhf("default");
  }

  public static String mhf(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".mhf");
  }

  public static String mhfend()
  {
    return mhfend("default");
  }

  public static String mhfend(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".mhfend");
  }

  public static String mf()
  {
    return mf("default");
  }

  public static String mf(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".mf");
  }

  public static String mfend()
  {
    return mfend("default");
  }

  public static String mfend(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".mfend");
  }

  public static int linenum()
  {
    return linenum("default");
  }

  public static int linenum(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return StringUtil.StringToInt(prop.getProperty(paramString + ".linenum"));
  }

  public static String tbp1()
  {
    return tbp1("default");
  }

  public static String tbp1(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tbp1");
  }

  public static String tbp2()
  {
    return tbp2("default");
  }

  public static String tbp2(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tbp2");
  }

  public static String tbp3()
  {
    return tbp3("default");
  }

  public static String tbp3(String paramString)
  {
    if (prop == null)
      prop = new XMLProperties(CONFIGFILE);
    return prop.getProperty(paramString + ".tbp3");
  }

  public static void main(String[] paramArrayOfString)
  {
    System.out.println(TableLine(8));
    System.out.println(ts());
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.BrandingUtil
 * JD-Core Version:    0.6.0
 */