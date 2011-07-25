package com.saas.biz.ClassMgr;

import com.ahbay.commenMgr.DataBaseCommMgr;
import com.ahbay.commenMgr.commMethodMgr;
import com.saas.sys.log.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.struts.action.Action;

public class ClassinfoMgr extends Action
{
  Logger log = new Logger(this);
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();
  commMethodMgr commen = new commMethodMgr();
  private String class_id;
  private String class_name;
  private String up_class_id;
  private String class_level;
  private String class_type;
  private String class_desc;
  private String enable_tag;
  private String rsrv_str1;
  private String rsrv_str2;
  private String rsrv_str3;
  private String rsrv_str4;
  private String rsrv_str5;
  private String rsrv_str6;
  private String rsrv_str7;
  private String rsrv_str8;
  private String rsrv_str9;
  private String rsrv_str10;
  private String remark;

  public String getClass_desc()
  {
    return this.class_desc;
  }

  public void setClass_desc(String paramString)
  {
    this.class_desc = paramString;
  }

  public String getClass_id()
  {
    return this.class_id;
  }

  public void setClass_id(String paramString)
  {
    this.class_id = paramString;
  }

  public String getClass_level()
  {
    return this.class_level;
  }

  public void setClass_level(String paramString)
  {
    this.class_level = paramString;
  }

  public String getClass_name()
  {
    return this.class_name;
  }

  public void setClass_name(String paramString)
  {
    this.class_name = paramString;
  }

  public String getClass_type()
  {
    return this.class_type;
  }

  public void setClass_type(String paramString)
  {
    this.class_type = paramString;
  }

  public String getEnable_tag()
  {
    return this.enable_tag;
  }

  public void setEnable_tag(String paramString)
  {
    this.enable_tag = paramString;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public String getRsrv_str1()
  {
    return this.rsrv_str1;
  }

  public void setRsrv_str1(String paramString)
  {
    this.rsrv_str1 = paramString;
  }

  public String getRsrv_str10()
  {
    return this.rsrv_str10;
  }

  public void setRsrv_str10(String paramString)
  {
    this.rsrv_str10 = paramString;
  }

  public String getRsrv_str2()
  {
    return this.rsrv_str2;
  }

  public void setRsrv_str2(String paramString)
  {
    this.rsrv_str2 = paramString;
  }

  public String getRsrv_str3()
  {
    return this.rsrv_str3;
  }

  public void setRsrv_str3(String paramString)
  {
    this.rsrv_str3 = paramString;
  }

  public String getRsrv_str4()
  {
    return this.rsrv_str4;
  }

  public void setRsrv_str4(String paramString)
  {
    this.rsrv_str4 = paramString;
  }

  public String getRsrv_str5()
  {
    return this.rsrv_str5;
  }

  public void setRsrv_str5(String paramString)
  {
    this.rsrv_str5 = paramString;
  }

  public String getRsrv_str6()
  {
    return this.rsrv_str6;
  }

  public void setRsrv_str6(String paramString)
  {
    this.rsrv_str6 = paramString;
  }

  public String getRsrv_str7()
  {
    return this.rsrv_str7;
  }

  public void setRsrv_str7(String paramString)
  {
    this.rsrv_str7 = paramString;
  }

  public String getRsrv_str8()
  {
    return this.rsrv_str8;
  }

  public void setRsrv_str8(String paramString)
  {
    this.rsrv_str8 = paramString;
  }

  public String getRsrv_str9()
  {
    return this.rsrv_str9;
  }

  public void setRsrv_str9(String paramString)
  {
    this.rsrv_str9 = paramString;
  }

  public String getUp_class_id()
  {
    return this.up_class_id;
  }

  public void setUp_class_id(String paramString)
  {
    this.up_class_id = paramString;
  }

  public String AddClassinfo()
  {
    String str1 = "";
    str1 = "insert into menuinfo values('" + this.commen.convetStrToDb(this.class_id) + "'," + "'" + this.commen.convetStrToDb(this.class_name) + "'," + "'" + this.commen.convetStrToDb(this.up_class_id) + "'," + "'" + this.commen.convetStrToDb(this.class_level) + "'," + "'" + this.commen.convetStrToDb(this.class_type) + "'," + "'" + this.commen.convetStrToDb(this.class_desc) + "'," + "'" + this.commen.convetStrToDb(this.enable_tag) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str1) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str2) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str3) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str4) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str5) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str6) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str7) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str8) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str9) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str10) + "'," + "'" + this.commen.convetStrToDb(this.remark) + "'" + ")";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }

  public ArrayList GetClassList(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_PRO"))
      str = "select * from td_b_productclass where class_level='1' and enable_tag='0' and class_type='2'";
    else if (paramString.equalsIgnoreCase("SEL_BY_CLASS_1"))
      str = "select * from td_b_productclass where class_level='1' and enable_tag='0' and class_type='" + this.class_type + "'";
    else if (paramString.equalsIgnoreCase("SEL_BY_PROUP"))
      str = "select * from td_b_productclass where up_class_id='" + this.up_class_id + "' and enable_tag='0' and class_type='2'";
    else if (paramString.equalsIgnoreCase("SEL_BY_UP"))
      str = "select * from td_b_productclass where up_class_id='" + this.up_class_id + "' and enable_tag='0' and class_type='" + this.class_type + "'";
    ResultSet localResultSet = null;
    ArrayList localArrayList = new ArrayList();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      this.log.LOG_INFO("X_tag................" + paramString);
      this.log.LOG_INFO("sql..........." + str);
      while (localResultSet.next())
      {
        this.log.LOG_INFO("xxxxxxxxxxxxxxxxx");
        ClassinfoMgr localClassinfoMgr = new ClassinfoMgr();
        localClassinfoMgr.setClass_id(localResultSet.getString("class_id"));
        localClassinfoMgr.setClass_name(localResultSet.getString("class_name"));
        localClassinfoMgr.setClass_desc(localResultSet.getString("class_desc"));
        localClassinfoMgr.setClass_level(localResultSet.getString("class_level"));
        localClassinfoMgr.setClass_type(localResultSet.getString("class_type"));
        localClassinfoMgr.setEnable_tag(localResultSet.getString("enable_tag"));
        localClassinfoMgr.setUp_class_id(localResultSet.getString("up_class_id"));
        localClassinfoMgr.setRsrv_str1(localResultSet.getString("rsrv_str1"));
        localClassinfoMgr.setRsrv_str2(localResultSet.getString("rsrv_str2"));
        localClassinfoMgr.setRsrv_str3(localResultSet.getString("rsrv_str3"));
        localClassinfoMgr.setRsrv_str4(localResultSet.getString("rsrv_str4"));
        localClassinfoMgr.setRsrv_str5(localResultSet.getString("rsrv_str5"));
        localClassinfoMgr.setRsrv_str6(localResultSet.getString("rsrv_str6"));
        localClassinfoMgr.setRsrv_str7(localResultSet.getString("rsrv_str7"));
        localClassinfoMgr.setRsrv_str8(localResultSet.getString("rsrv_str8"));
        localClassinfoMgr.setRsrv_str9(localResultSet.getString("rsrv_str9"));
        localClassinfoMgr.setRsrv_str10(localResultSet.getString("rsrv_str10"));
        localClassinfoMgr.setRemark(localResultSet.getString("remark"));
        localArrayList.add(localClassinfoMgr);
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localArrayList;
  }

  public ClassinfoMgr[] GetList(ArrayList paramArrayList)
  {
    ClassinfoMgr[] arrayOfClassinfoMgr = new ClassinfoMgr[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      ClassinfoMgr localClassinfoMgr = (ClassinfoMgr)paramArrayList.get(i);
      arrayOfClassinfoMgr[i] = localClassinfoMgr;
    }
    return arrayOfClassinfoMgr;
  }

  public ClassinfoMgr GetMenuInfo(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_CUST"));
    ResultSet localResultSet = null;
    ClassinfoMgr localClassinfoMgr = new ClassinfoMgr();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        localClassinfoMgr.setClass_id(localResultSet.getString("class_id"));
        localClassinfoMgr.setClass_name(localResultSet.getString("class_name"));
        localClassinfoMgr.setClass_level(localResultSet.getString("class_level"));
        localClassinfoMgr.setClass_type(localResultSet.getString("class_type"));
        localClassinfoMgr.setEnable_tag(localResultSet.getString("enable_tag"));
        localClassinfoMgr.setClass_desc(localResultSet.getString("class_desc"));
        localClassinfoMgr.setUp_class_id(localResultSet.getString("up_class_id"));
        localClassinfoMgr.setRsrv_str1(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str1")));
        localClassinfoMgr.setRsrv_str2(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str2")));
        localClassinfoMgr.setRsrv_str3(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str3")));
        localClassinfoMgr.setRsrv_str4(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str4")));
        localClassinfoMgr.setRsrv_str5(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str5")));
        localClassinfoMgr.setRsrv_str6(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str6")));
        localClassinfoMgr.setRsrv_str7(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str7")));
        localClassinfoMgr.setRsrv_str8(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str8")));
        localClassinfoMgr.setRsrv_str9(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str9")));
        localClassinfoMgr.setRsrv_str10(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str10")));
        localClassinfoMgr.setRemark(this.commen.convetStrToWeb(localResultSet.getString("remark")));
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localClassinfoMgr;
  }

  public String DelClass()
  {
    String str1 = "";
    str1 = "delete td_b_productclass where class_id='" + this.class_id + "'";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.ClassMgr.ClassinfoMgr
 * JD-Core Version:    0.6.0
 */