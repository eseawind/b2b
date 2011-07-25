package com.buildhtml;

import com.saas.biz.commen.config;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class Config
{
  Logger log = new Logger(this);
  public String ecms_path = "";
  public String user_templates_path = "";
  public String platform_path = "";
  public String webtitle = "";
  public String baseurl = "";
  public String webdesc = "";
  public String headseo = "";
  public String webright = "";
  public String countcode = "";
  public String default_img;
  public String regemail;
  public String examine;
  public String logolink = "";
  config configFile = new config();

  public Config()
  {
    this.configFile.init();
    this.examine = this.configFile.getString("EXAMINE");
    this.ecms_path = this.configFile.getString("ECMS_PATH");
    this.default_img = this.configFile.getString("DEFAULT_IMG");
    this.regemail = this.configFile.getString("REGEMAIL");
    this.user_templates_path = this.configFile.getString("USER_TEMPLATES_PATH");
    this.platform_path = this.configFile.getString("PLATFORM_PATH");
    this.webtitle = this.configFile.getString("WEBTITLE");
    this.baseurl = this.configFile.getString("BASEURL");
    this.webdesc = this.configFile.getString("WEBDESC");
    this.headseo = this.configFile.getString("HEADSEO");
    this.webright = this.configFile.getString("WEBRIGHT");
    this.countcode = this.configFile.getString("COUNTCODE");
    this.logolink = this.configFile.getString("LOGOLINK");
  }

  public ArrayList getConfigList()
  {
    config localconfig = new config();
    ArrayList localArrayList = new ArrayList();
    localArrayList = localconfig.getLogProperties();
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.buildhtml.Config
 * JD-Core Version:    0.6.0
 */