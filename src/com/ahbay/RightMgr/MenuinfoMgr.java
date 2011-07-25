package com.ahbay.RightMgr;

import com.ahbay.commenMgr.DataBaseCommMgr;
import com.ahbay.commenMgr.commMethodMgr;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.struts.action.Action;

public class MenuinfoMgr extends Action
{
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();
  commMethodMgr commen = new commMethodMgr();
  private String subsys_code;
  private String menu_id;
  private String menu_name;
  private String up_menu_id;
  private String menu_class;
  private String menu_type;
  private String module_id;
  private String in_param_code1;
  private String in_param_value1;
  private String in_param_code2;
  private String in_param_value2;
  private String in_param_code3;
  private String in_param_value3;
  private String remove_tag;
  private String rsrv_str1;
  private String rsrv_str2;
  private String rsrv_str3;
  private String rsrv_str4;
  private String rsrv_str5;
  private String rsrv_str6;
  private String rsrv_str7;
  private String rsrv_str8;
  private String rsrv_str9;
  private String rsrv_str0;
  private String in_staff_id;
  private String in_date;
  private String remark;

  public String getSubsys_code()
  {
    return this.subsys_code;
  }

  public String getMenu_id()
  {
    return this.menu_id;
  }

  public String getMenu_name()
  {
    return this.menu_name;
  }

  public String getUp_menu_id()
  {
    return this.up_menu_id;
  }

  public String getMenu_class()
  {
    return this.menu_class;
  }

  public String getMenu_type()
  {
    return this.menu_type;
  }

  public String getModule_id()
  {
    return this.module_id;
  }

  public String getIn_param_code1()
  {
    return this.in_param_code1;
  }

  public String getIn_param_value1()
  {
    return this.in_param_value1;
  }

  public String getIn_param_code2()
  {
    return this.in_param_code2;
  }

  public String getIn_param_value2()
  {
    return this.in_param_value2;
  }

  public String getIn_param_code3()
  {
    return this.in_param_code3;
  }

  public String getIn_param_value3()
  {
    return this.in_param_value3;
  }

  public String getRemove_tag()
  {
    return this.remove_tag;
  }

  public String getRsrv_str1()
  {
    return this.rsrv_str1;
  }

  public String getRsrv_str2()
  {
    return this.rsrv_str2;
  }

  public String getRsrv_str3()
  {
    return this.rsrv_str3;
  }

  public String getRsrv_str4()
  {
    return this.rsrv_str4;
  }

  public String getRsrv_str5()
  {
    return this.rsrv_str5;
  }

  public String getRsrv_str6()
  {
    return this.rsrv_str6;
  }

  public String getRsrv_str7()
  {
    return this.rsrv_str7;
  }

  public String getRsrv_str8()
  {
    return this.rsrv_str8;
  }

  public String getRsrv_str9()
  {
    return this.rsrv_str9;
  }

  public String getRsrv_str0()
  {
    return this.rsrv_str0;
  }

  public String getIn_staff_id()
  {
    return this.in_staff_id;
  }

  public String getIn_date()
  {
    return this.in_date;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setSubsys_code(String paramString)
  {
    this.subsys_code = paramString;
  }

  public void setMenu_id(String paramString)
  {
    this.menu_id = paramString;
  }

  public void setMenu_name(String paramString)
  {
    this.menu_name = paramString;
  }

  public void setUp_menu_id(String paramString)
  {
    this.up_menu_id = paramString;
  }

  public void setMenu_class(String paramString)
  {
    this.menu_class = paramString;
  }

  public void setMenu_type(String paramString)
  {
    this.menu_type = paramString;
  }

  public void setModule_id(String paramString)
  {
    this.module_id = paramString;
  }

  public void setIn_param_code1(String paramString)
  {
    this.in_param_code1 = paramString;
  }

  public void setIn_param_value1(String paramString)
  {
    this.in_param_value1 = paramString;
  }

  public void setIn_param_code2(String paramString)
  {
    this.in_param_code2 = paramString;
  }

  public void setIn_param_value2(String paramString)
  {
    this.in_param_value2 = paramString;
  }

  public void setIn_param_code3(String paramString)
  {
    this.in_param_code3 = paramString;
  }

  public void setIn_param_value3(String paramString)
  {
    this.in_param_value3 = paramString;
  }

  public void setRemove_tag(String paramString)
  {
    this.remove_tag = paramString;
  }

  public void setRsrv_str1(String paramString)
  {
    this.rsrv_str1 = paramString;
  }

  public void setRsrv_str2(String paramString)
  {
    this.rsrv_str2 = paramString;
  }

  public void setRsrv_str3(String paramString)
  {
    this.rsrv_str3 = paramString;
  }

  public void setRsrv_str4(String paramString)
  {
    this.rsrv_str4 = paramString;
  }

  public void setRsrv_str5(String paramString)
  {
    this.rsrv_str5 = paramString;
  }

  public void setRsrv_str6(String paramString)
  {
    this.rsrv_str6 = paramString;
  }

  public void setRsrv_str7(String paramString)
  {
    this.rsrv_str7 = paramString;
  }

  public void setRsrv_str8(String paramString)
  {
    this.rsrv_str8 = paramString;
  }

  public void setRsrv_str9(String paramString)
  {
    this.rsrv_str9 = paramString;
  }

  public void setRsrv_str0(String paramString)
  {
    this.rsrv_str0 = paramString;
  }

  public void setIn_staff_id(String paramString)
  {
    this.in_staff_id = paramString;
  }

  public void setIn_date(String paramString)
  {
    this.in_date = paramString;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public String AddMenuinfo()
  {
    String str1 = "";
    str1 = "insert into menuinfo values('" + this.commen.convetStrToDb(this.subsys_code) + "'," + "'" + this.commen.convetStrToDb(this.menu_id) + "'," + "'" + this.commen.convetStrToDb(this.menu_name) + "'," + "'" + this.commen.convetStrToDb(this.up_menu_id) + "'," + "'" + this.commen.convetStrToDb(this.menu_class) + "'," + "'" + this.commen.convetStrToDb(this.menu_type) + "'," + "'" + this.commen.convetStrToDb(this.module_id) + "'," + "'" + this.commen.convetStrToDb(this.in_param_code1) + "'," + "'" + this.commen.convetStrToDb(this.in_param_value1) + "'," + "'" + this.commen.convetStrToDb(this.in_param_code2) + "'," + "'" + this.commen.convetStrToDb(this.in_param_value2) + "'," + "'" + this.commen.convetStrToDb(this.in_param_code3) + "'," + "'" + this.commen.convetStrToDb(this.in_param_value3) + "'," + "'" + this.commen.convetStrToDb(this.remove_tag) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str1) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str2) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str3) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str4) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str5) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str6) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str7) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str8) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str9) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str0) + "'," + "'" + this.commen.convetStrToDb(this.in_staff_id) + "'," + "now()," + "'" + this.commen.convetStrToDb(this.remark) + "'" + ")";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }

  public ArrayList GetMenuList(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_CLASS_1"))
      str = "select * from menuinfo where menu_class='1' and remove_tag='0' and subsys_code='" + this.subsys_code + "' order by subsys_code desc";
    else if (paramString.equalsIgnoreCase("SEL_BY_UP"))
      str = "select * from menuinfo where up_menu_id='" + this.up_menu_id + "' and remove_tag='0' and subsys_code='" + this.subsys_code + "' order by subsys_code desc";
    else if (paramString.equalsIgnoreCase("SEL_BY_RIGHT"))
      str = "select * from menuinfo where menu_id not in (select menu_id from rightinfo where staff_id='" + this.rsrv_str0 + "' and end_date>=now() and right_attr='0')" + " order by up_menu_id";
    else if (paramString.equalsIgnoreCase("SEL_BY_STAFF_RIGHT_1"))
      str = "select * from menuinfo where ((menu_id  in (select menu_id from rightinfo where staff_id='" + this.rsrv_str0 + "' and end_date>=now()  and right_attr='0')) or " + "('admin'='" + this.rsrv_str0 + "'))" + "and menu_class=1 order by in_date";
    else if (paramString.equalsIgnoreCase("SEL_BY_STAFF_RIGHT_UP"))
      str = "select * from menuinfo where ((menu_id  in (select menu_id from rightinfo where staff_id='" + this.rsrv_str0 + "' and end_date>=now() and right_attr='0' )) or " + "('admin'='" + this.rsrv_str0 + "'))" + "and menu_class=2 and up_menu_id='" + this.up_menu_id + "' order by in_date";
    ResultSet localResultSet = null;
    ArrayList localArrayList = new ArrayList();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        MenuinfoMgr localMenuinfoMgr = new MenuinfoMgr();
        localMenuinfoMgr.setSubsys_code(localResultSet.getString("subsys_code"));
        localMenuinfoMgr.setMenu_id(localResultSet.getString("menu_id"));
        localMenuinfoMgr.setMenu_name(localResultSet.getString("menu_name"));
        localMenuinfoMgr.setUp_menu_id(localResultSet.getString("up_menu_id"));
        localMenuinfoMgr.setMenu_class(localResultSet.getString("menu_class"));
        localMenuinfoMgr.setMenu_type(localResultSet.getString("menu_type"));
        localMenuinfoMgr.setModule_id(localResultSet.getString("module_id"));
        localMenuinfoMgr.setIn_param_code1(localResultSet.getString("in_param_code1"));
        localMenuinfoMgr.setIn_param_value1(localResultSet.getString("in_param_value1"));
        localMenuinfoMgr.setIn_param_code2(localResultSet.getString("in_param_code2"));
        localMenuinfoMgr.setIn_param_value2(localResultSet.getString("in_param_value2"));
        localMenuinfoMgr.setIn_param_code3(localResultSet.getString("in_param_code3"));
        localMenuinfoMgr.setIn_param_value3(localResultSet.getString("in_param_value3"));
        localMenuinfoMgr.setRemove_tag(localResultSet.getString("remove_tag"));
        localMenuinfoMgr.setRsrv_str1(localResultSet.getString("rsrv_str1"));
        localMenuinfoMgr.setRsrv_str2(localResultSet.getString("rsrv_str2"));
        localMenuinfoMgr.setRsrv_str3(localResultSet.getString("rsrv_str3"));
        localMenuinfoMgr.setRsrv_str4(localResultSet.getString("rsrv_str4"));
        localMenuinfoMgr.setRsrv_str5(localResultSet.getString("rsrv_str5"));
        localMenuinfoMgr.setRsrv_str6(localResultSet.getString("rsrv_str6"));
        localMenuinfoMgr.setRsrv_str7(localResultSet.getString("rsrv_str7"));
        localMenuinfoMgr.setRsrv_str8(localResultSet.getString("rsrv_str8"));
        localMenuinfoMgr.setRsrv_str9(localResultSet.getString("rsrv_str9"));
        localMenuinfoMgr.setRsrv_str0(localResultSet.getString("rsrv_str0"));
        localMenuinfoMgr.setIn_staff_id(localResultSet.getString("in_staff_id"));
        localMenuinfoMgr.setIn_date(localResultSet.getString("in_date"));
        localMenuinfoMgr.setRemark(localResultSet.getString("remark"));
        localArrayList.add(localMenuinfoMgr);
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localArrayList;
  }

  public MenuinfoMgr[] GetList(ArrayList paramArrayList)
  {
    MenuinfoMgr[] arrayOfMenuinfoMgr = new MenuinfoMgr[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      MenuinfoMgr localMenuinfoMgr = (MenuinfoMgr)paramArrayList.get(i);
      arrayOfMenuinfoMgr[i] = localMenuinfoMgr;
    }
    return arrayOfMenuinfoMgr;
  }

  public MenuinfoMgr GetMenuInfo(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_CUST"));
    ResultSet localResultSet = null;
    MenuinfoMgr localMenuinfoMgr = new MenuinfoMgr();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        localMenuinfoMgr.setSubsys_code(this.commen.convetStrToWeb(localResultSet.getString("subsys_code")));
        localMenuinfoMgr.setMenu_id(this.commen.convetStrToWeb(localResultSet.getString("menu_id")));
        localMenuinfoMgr.setMenu_name(this.commen.convetStrToWeb(localResultSet.getString("menu_name")));
        localMenuinfoMgr.setUp_menu_id(this.commen.convetStrToWeb(localResultSet.getString("up_menu_id")));
        localMenuinfoMgr.setMenu_class(this.commen.convetStrToWeb(localResultSet.getString("menu_class")));
        localMenuinfoMgr.setMenu_type(this.commen.convetStrToWeb(localResultSet.getString("menu_type")));
        localMenuinfoMgr.setModule_id(this.commen.convetStrToWeb(localResultSet.getString("module_id")));
        localMenuinfoMgr.setIn_param_code1(this.commen.convetStrToWeb(localResultSet.getString("in_param_code1")));
        localMenuinfoMgr.setIn_param_value1(this.commen.convetStrToWeb(localResultSet.getString("in_param_value1")));
        localMenuinfoMgr.setIn_param_code2(this.commen.convetStrToWeb(localResultSet.getString("in_param_code2")));
        localMenuinfoMgr.setIn_param_value2(this.commen.convetStrToWeb(localResultSet.getString("in_param_value2")));
        localMenuinfoMgr.setIn_param_code3(this.commen.convetStrToWeb(localResultSet.getString("in_param_code3")));
        localMenuinfoMgr.setIn_param_value3(this.commen.convetStrToWeb(localResultSet.getString("in_param_value3")));
        localMenuinfoMgr.setRemove_tag(this.commen.convetStrToWeb(localResultSet.getString("remove_tag")));
        localMenuinfoMgr.setRsrv_str1(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str1")));
        localMenuinfoMgr.setRsrv_str2(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str2")));
        localMenuinfoMgr.setRsrv_str3(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str3")));
        localMenuinfoMgr.setRsrv_str4(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str4")));
        localMenuinfoMgr.setRsrv_str5(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str5")));
        localMenuinfoMgr.setRsrv_str6(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str6")));
        localMenuinfoMgr.setRsrv_str7(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str7")));
        localMenuinfoMgr.setRsrv_str8(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str8")));
        localMenuinfoMgr.setRsrv_str9(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str9")));
        localMenuinfoMgr.setRsrv_str0(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str0")));
        localMenuinfoMgr.setIn_staff_id(this.commen.convetStrToWeb(localResultSet.getString("in_staff_id")));
        localMenuinfoMgr.setIn_date(this.commen.convetStrToWeb(localResultSet.getString("in_date")));
        localMenuinfoMgr.setRemark(this.commen.convetStrToWeb(localResultSet.getString("remark")));
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localMenuinfoMgr;
  }

  public String DelMenu()
  {
    String str1 = "";
    str1 = "delete from menuinfo where menu_id='" + this.menu_id + "'";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.RightMgr.MenuinfoMgr
 * JD-Core Version:    0.6.0
 */