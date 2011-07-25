package com.saas.biz.ClassMgr;

import com.ahbay.commenMgr.DataBaseCommMgr;
import com.ahbay.commenMgr.commMethodMgr;
import com.saas.sys.log.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.struts.action.Action;

public class AttrMgr extends Action
{
  Logger log = new Logger(this);
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();
  commMethodMgr commen = new commMethodMgr();
  private String class_id;
  private String attr_id;
  private String attr_name;
  private String attr_desc;
  private String attr_no;
  private String default_tag;
  private String default_value;
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

  public String Addattrinfo()
  {
    String str1 = "";
    str1 = "insert into menuinfo values('" + this.commen.convetStrToDb(this.class_id) + "'," + "'" + this.commen.convetStrToDb(this.attr_name) + "'," + "'" + this.commen.convetStrToDb(this.attr_id) + "'," + "'" + this.commen.convetStrToDb(this.attr_desc) + "'," + "'" + this.commen.convetStrToDb(this.attr_no) + "'," + "'" + this.commen.convetStrToDb(this.default_tag) + "'," + "'" + this.commen.convetStrToDb(this.default_value) + "'," + "'" + this.commen.convetStrToDb(this.enable_tag) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str1) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str2) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str3) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str4) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str5) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str6) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str7) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str8) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str9) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str10) + "'," + "'" + this.commen.convetStrToDb(this.remark) + "'" + ")";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }

  public ArrayList GetClassList(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_CLASS_ID"))
      str = "select * from td_b_productattr  where class_id='" + this.class_id + "'";
    ResultSet localResultSet = null;
    ArrayList localArrayList = new ArrayList();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        AttrMgr localAttrMgr = new AttrMgr();
        localAttrMgr.setAttr_desc(localResultSet.getString("attr_desc"));
        localAttrMgr.setAttr_id(localResultSet.getString("attr_id"));
        localAttrMgr.setClass_id(localResultSet.getString("class_id"));
        localAttrMgr.setAttr_name(localResultSet.getString("attr_name"));
        localAttrMgr.setAttr_no(localResultSet.getString("attr_no"));
        localAttrMgr.setDefault_tag(localResultSet.getString("default_tag"));
        localAttrMgr.setDefault_value(localResultSet.getString("default_value"));
        localAttrMgr.setEnable_tag(localResultSet.getString("enable_tag"));
        localAttrMgr.setRsrv_str1(localResultSet.getString("rsrv_str1"));
        localAttrMgr.setRsrv_str2(localResultSet.getString("rsrv_str2"));
        localAttrMgr.setRsrv_str3(localResultSet.getString("rsrv_str3"));
        localAttrMgr.setRsrv_str4(localResultSet.getString("rsrv_str4"));
        localAttrMgr.setRsrv_str5(localResultSet.getString("rsrv_str5"));
        localAttrMgr.setRsrv_str6(localResultSet.getString("rsrv_str6"));
        localAttrMgr.setRsrv_str7(localResultSet.getString("rsrv_str7"));
        localAttrMgr.setRsrv_str8(localResultSet.getString("rsrv_str8"));
        localAttrMgr.setRsrv_str9(localResultSet.getString("rsrv_str9"));
        localAttrMgr.setRsrv_str10(localResultSet.getString("rsrv_str10"));
        localAttrMgr.setRemark(localResultSet.getString("remark"));
        localArrayList.add(localAttrMgr);
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localArrayList;
  }

  public AttrMgr[] GetList(ArrayList paramArrayList)
  {
    AttrMgr[] arrayOfAttrMgr = new AttrMgr[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      AttrMgr localAttrMgr = (AttrMgr)paramArrayList.get(i);
      arrayOfAttrMgr[i] = localAttrMgr;
    }
    return arrayOfAttrMgr;
  }

  public AttrMgr GetAttrInfo(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_CUST"));
    ResultSet localResultSet = null;
    AttrMgr localAttrMgr = new AttrMgr();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        localAttrMgr.setAttr_desc(localResultSet.getString("attr_desc"));
        localAttrMgr.setAttr_id(localResultSet.getString("attr_id"));
        localAttrMgr.setClass_id(localResultSet.getString("class_id"));
        localAttrMgr.setAttr_name(localResultSet.getString("attr_name"));
        localAttrMgr.setAttr_no(localResultSet.getString("attr_no"));
        localAttrMgr.setDefault_tag(localResultSet.getString("default_tag"));
        localAttrMgr.setDefault_value(localResultSet.getString("default_value"));
        localAttrMgr.setEnable_tag(localResultSet.getString("enable_tag"));
        localAttrMgr.setRsrv_str1(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str1")));
        localAttrMgr.setRsrv_str2(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str2")));
        localAttrMgr.setRsrv_str3(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str3")));
        localAttrMgr.setRsrv_str4(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str4")));
        localAttrMgr.setRsrv_str5(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str5")));
        localAttrMgr.setRsrv_str6(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str6")));
        localAttrMgr.setRsrv_str7(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str7")));
        localAttrMgr.setRsrv_str8(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str8")));
        localAttrMgr.setRsrv_str9(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str9")));
        localAttrMgr.setRsrv_str10(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str10")));
        localAttrMgr.setRemark(this.commen.convetStrToWeb(localResultSet.getString("remark")));
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localAttrMgr;
  }

  public String DelClass()
  {
    String str1 = "";
    str1 = "delete td_b_productclass where class_id='" + this.class_id + "'";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }

  public String getAttr_desc()
  {
    return this.attr_desc;
  }

  public void setAttr_desc(String paramString)
  {
    this.attr_desc = paramString;
  }

  public String getAttr_id()
  {
    return this.attr_id;
  }

  public void setAttr_id(String paramString)
  {
    this.attr_id = paramString;
  }

  public String getAttr_name()
  {
    return this.attr_name;
  }

  public void setAttr_name(String paramString)
  {
    this.attr_name = paramString;
  }

  public String getAttr_no()
  {
    return this.attr_no;
  }

  public void setAttr_no(String paramString)
  {
    this.attr_no = paramString;
  }

  public String getClass_id()
  {
    return this.class_id;
  }

  public void setClass_id(String paramString)
  {
    this.class_id = paramString;
  }

  public commMethodMgr getCommen()
  {
    return this.commen;
  }

  public void setCommen(commMethodMgr paramcommMethodMgr)
  {
    this.commen = paramcommMethodMgr;
  }

  public DataBaseCommMgr getDBQuery()
  {
    return this.DBQuery;
  }

  public void setDBQuery(DataBaseCommMgr paramDataBaseCommMgr)
  {
    this.DBQuery = paramDataBaseCommMgr;
  }

  public String getDefault_tag()
  {
    return this.default_tag;
  }

  public void setDefault_tag(String paramString)
  {
    this.default_tag = paramString;
  }

  public String getDefault_value()
  {
    return this.default_value;
  }

  public void setDefault_value(String paramString)
  {
    this.default_value = paramString;
  }

  public String getEnable_tag()
  {
    return this.enable_tag;
  }

  public void setEnable_tag(String paramString)
  {
    this.enable_tag = paramString;
  }

  public Logger getLog()
  {
    return this.log;
  }

  public void setLog(Logger paramLogger)
  {
    this.log = paramLogger;
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
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.ClassMgr.AttrMgr
 * JD-Core Version:    0.6.0
 */