package com.ahbay.commenMgr;

import com.ahbay.RightMgr.MenuinfoMgr;
import com.ahbay.RightMgr.ModuleMgr;
import com.ahbay.UserMgr.DepartMgr;
import com.ahbay.UserMgr.StaffMgr;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommParaMgr
{
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();
  commMethodMgr commen = new commMethodMgr();
  private String subsys_code;
  private String param_attr;
  private String param_code;
  private String param_name;
  private String para_code1;
  private String para_code2;
  private String para_code3;
  private String para_code4;
  private String para_code5;
  private String para_code6;
  private String para_code7;
  private String para_code8;
  private String para_code9;
  private String para_code10;
  private String para_code11;
  private String para_code12;
  private String para_code13;
  private String para_code14;
  private String para_code15;
  private String para_code16;
  private String para_code17;
  private String para_code18;
  private String para_code19;
  private String para_code20;
  private String para_code21;
  private String para_code22;
  private String para_code23;
  private String para_code24;
  private String para_code25;
  private String para_code26;
  private String para_code27;
  private String para_code28;
  private String para_code29;
  private String para_code30;
  private String start_date;
  private String end_date;
  private String remark;
  private String update_staff_id;
  private String update_depart_id;
  private String update_time;

  public String getSubsys_code()
  {
    return this.subsys_code;
  }

  public String getParam_attr()
  {
    return this.param_attr;
  }

  public String getParam_code()
  {
    return this.param_code;
  }

  public String getParam_name()
  {
    return this.param_name;
  }

  public String getPara_code1()
  {
    return this.para_code1;
  }

  public String getPara_code2()
  {
    return this.para_code2;
  }

  public String getPara_code3()
  {
    return this.para_code3;
  }

  public String getPara_code4()
  {
    return this.para_code4;
  }

  public String getPara_code5()
  {
    return this.para_code5;
  }

  public String getPara_code6()
  {
    return this.para_code6;
  }

  public String getPara_code7()
  {
    return this.para_code7;
  }

  public String getPara_code8()
  {
    return this.para_code8;
  }

  public String getPara_code9()
  {
    return this.para_code9;
  }

  public String getPara_code10()
  {
    return this.para_code10;
  }

  public String getPara_code11()
  {
    return this.para_code11;
  }

  public String getPara_code12()
  {
    return this.para_code12;
  }

  public String getPara_code13()
  {
    return this.para_code13;
  }

  public String getPara_code14()
  {
    return this.para_code14;
  }

  public String getPara_code15()
  {
    return this.para_code15;
  }

  public String getPara_code16()
  {
    return this.para_code16;
  }

  public String getPara_code17()
  {
    return this.para_code17;
  }

  public String getPara_code18()
  {
    return this.para_code18;
  }

  public String getPara_code19()
  {
    return this.para_code19;
  }

  public String getPara_code20()
  {
    return this.para_code20;
  }

  public String getPara_code21()
  {
    return this.para_code21;
  }

  public String getPara_code22()
  {
    return this.para_code22;
  }

  public String getPara_code23()
  {
    return this.para_code23;
  }

  public String getPara_code24()
  {
    return this.para_code24;
  }

  public String getPara_code25()
  {
    return this.para_code25;
  }

  public String getPara_code26()
  {
    return this.para_code26;
  }

  public String getPara_code27()
  {
    return this.para_code27;
  }

  public String getPara_code28()
  {
    return this.para_code28;
  }

  public String getPara_code29()
  {
    return this.para_code29;
  }

  public String getPara_code30()
  {
    return this.para_code30;
  }

  public String getStart_date()
  {
    return this.start_date;
  }

  public String getEnd_date()
  {
    return this.end_date;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public String getUpdate_staff_id()
  {
    return this.update_staff_id;
  }

  public String getUpdate_depart_id()
  {
    return this.update_depart_id;
  }

  public String getUpdate_time()
  {
    return this.update_time;
  }

  public void setSubsys_code(String paramString)
  {
    this.subsys_code = paramString;
  }

  public void setParam_attr(String paramString)
  {
    this.param_attr = paramString;
  }

  public void setParam_code(String paramString)
  {
    this.param_code = paramString;
  }

  public void setParam_name(String paramString)
  {
    this.param_name = paramString;
  }

  public void setPara_code1(String paramString)
  {
    this.para_code1 = paramString;
  }

  public void setPara_code2(String paramString)
  {
    this.para_code2 = paramString;
  }

  public void setPara_code3(String paramString)
  {
    this.para_code3 = paramString;
  }

  public void setPara_code4(String paramString)
  {
    this.para_code4 = paramString;
  }

  public void setPara_code5(String paramString)
  {
    this.para_code5 = paramString;
  }

  public void setPara_code6(String paramString)
  {
    this.para_code6 = paramString;
  }

  public void setPara_code7(String paramString)
  {
    this.para_code7 = paramString;
  }

  public void setPara_code8(String paramString)
  {
    this.para_code8 = paramString;
  }

  public void setPara_code9(String paramString)
  {
    this.para_code9 = paramString;
  }

  public void setPara_code10(String paramString)
  {
    this.para_code10 = paramString;
  }

  public void setPara_code11(String paramString)
  {
    this.para_code11 = paramString;
  }

  public void setPara_code12(String paramString)
  {
    this.para_code12 = paramString;
  }

  public void setPara_code13(String paramString)
  {
    this.para_code13 = paramString;
  }

  public void setPara_code14(String paramString)
  {
    this.para_code14 = paramString;
  }

  public void setPara_code15(String paramString)
  {
    this.para_code15 = paramString;
  }

  public void setPara_code16(String paramString)
  {
    this.para_code16 = paramString;
  }

  public void setPara_code17(String paramString)
  {
    this.para_code17 = paramString;
  }

  public void setPara_code18(String paramString)
  {
    this.para_code18 = paramString;
  }

  public void setPara_code19(String paramString)
  {
    this.para_code19 = paramString;
  }

  public void setPara_code20(String paramString)
  {
    this.para_code20 = paramString;
  }

  public void setPara_code21(String paramString)
  {
    this.para_code21 = paramString;
  }

  public void setPara_code22(String paramString)
  {
    this.para_code22 = paramString;
  }

  public void setPara_code23(String paramString)
  {
    this.para_code23 = paramString;
  }

  public void setPara_code24(String paramString)
  {
    this.para_code24 = paramString;
  }

  public void setPara_code25(String paramString)
  {
    this.para_code25 = paramString;
  }

  public void setPara_code26(String paramString)
  {
    this.para_code26 = paramString;
  }

  public void setPara_code27(String paramString)
  {
    this.para_code27 = paramString;
  }

  public void setPara_code28(String paramString)
  {
    this.para_code28 = paramString;
  }

  public void setPara_code29(String paramString)
  {
    this.para_code29 = paramString;
  }

  public void setPara_code30(String paramString)
  {
    this.para_code30 = paramString;
  }

  public void setStart_date(String paramString)
  {
    this.start_date = paramString;
  }

  public void setEnd_date(String paramString)
  {
    this.end_date = paramString;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public void setUpdate_staff_id(String paramString)
  {
    this.update_staff_id = paramString;
  }

  public void setUpdate_depart_id(String paramString)
  {
    this.update_depart_id = paramString;
  }

  public void setUpdate_time(String paramString)
  {
    this.update_time = paramString;
  }

  public ArrayList GetParaList(String paramString)
  {
    ResultSet localResultSet = null;
    String str = "";
    ArrayList localArrayList = new ArrayList();
    if (paramString.equalsIgnoreCase("SEL_BY_ATTR"))
      str = "select * from commpara where subsys_code='WEB' and param_attr='" + this.param_attr + "'" + "and (sysdate between start_date and end_date) order by param_code asc";
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        CommParaMgr localCommParaMgr = new CommParaMgr();
        localCommParaMgr.setSubsys_code(this.commen.convetStrToWeb(localResultSet.getString("subsys_code")));
        localCommParaMgr.setParam_attr(this.commen.convetStrToWeb(localResultSet.getString("param_attr")));
        localCommParaMgr.setParam_code(this.commen.convetStrToWeb(localResultSet.getString("param_code")));
        localCommParaMgr.setParam_name(this.commen.convetStrToWeb(localResultSet.getString("param_name")));
        localCommParaMgr.setPara_code1(this.commen.convetStrToWeb(localResultSet.getString("para_code1")));
        localCommParaMgr.setPara_code2(this.commen.convetStrToWeb(localResultSet.getString("para_code2")));
        localCommParaMgr.setPara_code3(this.commen.convetStrToWeb(localResultSet.getString("para_code3")));
        localCommParaMgr.setPara_code4(this.commen.convetStrToWeb(localResultSet.getString("para_code4")));
        localCommParaMgr.setPara_code5(this.commen.convetStrToWeb(localResultSet.getString("para_code5")));
        localCommParaMgr.setPara_code6(this.commen.convetStrToWeb(localResultSet.getString("para_code6")));
        localCommParaMgr.setPara_code7(this.commen.convetStrToWeb(localResultSet.getString("para_code7")));
        localCommParaMgr.setPara_code8(this.commen.convetStrToWeb(localResultSet.getString("para_code8")));
        localCommParaMgr.setPara_code9(this.commen.convetStrToWeb(localResultSet.getString("para_code9")));
        localCommParaMgr.setPara_code10(this.commen.convetStrToWeb(localResultSet.getString("para_code10")));
        localCommParaMgr.setPara_code11(this.commen.convetStrToWeb(localResultSet.getString("para_code11")));
        localCommParaMgr.setPara_code12(this.commen.convetStrToWeb(localResultSet.getString("para_code12")));
        localCommParaMgr.setPara_code13(this.commen.convetStrToWeb(localResultSet.getString("para_code13")));
        localCommParaMgr.setPara_code14(this.commen.convetStrToWeb(localResultSet.getString("para_code14")));
        localCommParaMgr.setPara_code15(this.commen.convetStrToWeb(localResultSet.getString("para_code15")));
        localCommParaMgr.setPara_code16(this.commen.convetStrToWeb(localResultSet.getString("para_code16")));
        localCommParaMgr.setPara_code17(this.commen.convetStrToWeb(localResultSet.getString("para_code17")));
        localCommParaMgr.setPara_code18(this.commen.convetStrToWeb(localResultSet.getString("para_code18")));
        localCommParaMgr.setPara_code19(this.commen.convetStrToWeb(localResultSet.getString("para_code19")));
        localCommParaMgr.setPara_code20(this.commen.convetStrToWeb(localResultSet.getString("para_code20")));
        localCommParaMgr.setPara_code21(this.commen.convetStrToWeb(localResultSet.getString("para_code21")));
        localCommParaMgr.setPara_code22(this.commen.convetStrToWeb(localResultSet.getString("para_code22")));
        localCommParaMgr.setPara_code23(this.commen.convetStrToWeb(localResultSet.getString("para_code23")));
        localCommParaMgr.setPara_code24(this.commen.convetStrToWeb(localResultSet.getString("para_code24")));
        localCommParaMgr.setPara_code25(this.commen.convetStrToWeb(localResultSet.getString("para_code25")));
        localCommParaMgr.setPara_code26(this.commen.convetStrToWeb(localResultSet.getString("para_code26")));
        localCommParaMgr.setPara_code27(this.commen.convetStrToWeb(localResultSet.getString("para_code27")));
        localCommParaMgr.setPara_code28(this.commen.convetStrToWeb(localResultSet.getString("para_code28")));
        localCommParaMgr.setPara_code29(this.commen.convetStrToWeb(localResultSet.getString("para_code29")));
        localCommParaMgr.setPara_code30(this.commen.convetStrToWeb(localResultSet.getString("para_code30")));
        localCommParaMgr.setStart_date(this.commen.convetStrToWeb(localResultSet.getString("start_date")));
        localCommParaMgr.setEnd_date(this.commen.convetStrToWeb(localResultSet.getString("end_date")));
        localCommParaMgr.setRemark(this.commen.convetStrToWeb(localResultSet.getString("remark")));
        localCommParaMgr.setUpdate_staff_id(this.commen.convetStrToWeb(localResultSet.getString("update_staff_id")));
        localCommParaMgr.setUpdate_depart_id(this.commen.convetStrToWeb(localResultSet.getString("update_depart_id")));
        localCommParaMgr.setUpdate_time(this.commen.convetStrToWeb(localResultSet.getString("update_time")));
        localArrayList.add(localCommParaMgr);
      }
    }
    catch (SQLException localSQLException)
    {
      System.out.println("SQLERROR:" + localSQLException.getMessage());
    }
    catch (Exception localException)
    {
      System.out.println("ERROR:" + localException.getMessage());
    }
    return localArrayList;
  }

  public CommParaMgr[] GetList(ArrayList paramArrayList)
  {
    CommParaMgr[] arrayOfCommParaMgr = new CommParaMgr[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      CommParaMgr localCommParaMgr = (CommParaMgr)paramArrayList.get(i);
      arrayOfCommParaMgr[i] = localCommParaMgr;
    }
    return arrayOfCommParaMgr;
  }

  public String GenSelectOption(String paramString)
  {
    String str = "";
    this.param_attr = paramString;
    ArrayList localArrayList = GetParaList("SEL_BY_ATTR");
    CommParaMgr[] arrayOfCommParaMgr = GetList(localArrayList);
    for (int i = 0; i < arrayOfCommParaMgr.length; i++)
      str = str + "<option value=" + arrayOfCommParaMgr[i].getParam_code() + " >" + "[" + arrayOfCommParaMgr[i].getParam_code() + "]->" + "" + arrayOfCommParaMgr[i].getPara_code1() + "</option> ";
    return str;
  }

  public ArrayList GetDepartListArray(String paramString)
  {
    ResultSet localResultSet = null;
    String str = "";
    ArrayList localArrayList = new ArrayList();
    if (paramString.equalsIgnoreCase("SEL_BY_ALL"))
      str = "select * from departinfo order by order_no asc";
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        DepartMgr localDepartMgr = new DepartMgr();
        localDepartMgr.setDepart_id(this.commen.convetStrToWeb(localResultSet.getString("depart_id")));
        localDepartMgr.setDepart_name(this.commen.convetStrToWeb(localResultSet.getString("depart_name")));
        localDepartMgr.setDepart_kind_code(this.commen.convetStrToWeb(localResultSet.getString("depart_kind_code")));
        localDepartMgr.setParent_depart_id(this.commen.convetStrToWeb(localResultSet.getString("parent_depart_id")));
        localDepartMgr.setOrder_no(localResultSet.getInt("order_no"));
        localDepartMgr.setDepart_level(localResultSet.getInt("depart_level"));
        localDepartMgr.setRemark(this.commen.convetStrToWeb(localResultSet.getString("remark")));
        localDepartMgr.setRsvalue1(this.commen.convetStrToWeb(localResultSet.getString("rsvalue1")));
        localDepartMgr.setRsvalue2(this.commen.convetStrToWeb(localResultSet.getString("rsvalue2")));
        localDepartMgr.setRsvalue3(this.commen.convetStrToWeb(localResultSet.getString("rsvalue3")));
        localDepartMgr.setRsvalue4(this.commen.convetStrToWeb(localResultSet.getString("rsvalue4")));
        localDepartMgr.setUpdate_time(this.commen.convetStrToWeb(localResultSet.getString("update_time")));
        localDepartMgr.setUpdate_staff_id(this.commen.convetStrToWeb(localResultSet.getString("update_staff_id")));
        localDepartMgr.setUpdate_depart_id(this.commen.convetStrToWeb(localResultSet.getString("update_depart_id")));
        localArrayList.add(localDepartMgr);
      }
    }
    catch (SQLException localSQLException)
    {
      System.out.println("SQLERROR:" + localSQLException.getMessage());
    }
    catch (Exception localException)
    {
      System.out.println("ERROR:" + localException.getMessage());
    }
    return localArrayList;
  }

  public DepartMgr[] GetDepartList(ArrayList paramArrayList)
  {
    DepartMgr[] arrayOfDepartMgr = new DepartMgr[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      DepartMgr localDepartMgr = (DepartMgr)paramArrayList.get(i);
      arrayOfDepartMgr[i] = localDepartMgr;
    }
    return arrayOfDepartMgr;
  }

  public String GenDepartOption(String paramString)
  {
    String str = "";
    ArrayList localArrayList = GetDepartListArray("SEL_BY_ALL");
    DepartMgr[] arrayOfDepartMgr = GetDepartList(localArrayList);
    for (int i = 0; i < arrayOfDepartMgr.length; i++)
      str = str + "<option value=" + arrayOfDepartMgr[i].getDepart_id() + " >" + "[" + arrayOfDepartMgr[i].getDepart_id() + "]->" + "" + arrayOfDepartMgr[i].getDepart_name() + "</option> ";
    return str;
  }

  public String GenMenuOption(String paramString)
  {
    String str = "";
    MenuinfoMgr localMenuinfoMgr = new MenuinfoMgr();
    localMenuinfoMgr.setMenu_class(paramString);
    ArrayList localArrayList = localMenuinfoMgr.GetMenuList("SEL_BY_CLASS");
    MenuinfoMgr[] arrayOfMenuinfoMgr = localMenuinfoMgr.GetList(localArrayList);
    for (int i = 0; i < arrayOfMenuinfoMgr.length; i++)
      str = str + "<option value=" + arrayOfMenuinfoMgr[i].getMenu_id() + " >" + "[" + arrayOfMenuinfoMgr[i].getMenu_id() + "]->" + "" + arrayOfMenuinfoMgr[i].getMenu_name() + "</option> ";
    return str;
  }

  public String GenModuleOption()
  {
    String str = "";
    ModuleMgr localModuleMgr = new ModuleMgr();
    ArrayList localArrayList = localModuleMgr.GetModuleList("SEL_BY_ALL");
    ModuleMgr[] arrayOfModuleMgr = localModuleMgr.GetList(localArrayList);
    for (int i = 0; i < arrayOfModuleMgr.length; i++)
      str = str + "<option value=" + arrayOfModuleMgr[i].getModule_id() + " >" + "[" + arrayOfModuleMgr[i].getModule_id() + "]->" + "" + arrayOfModuleMgr[i].getModule_name() + "[" + arrayOfModuleMgr[i].getModule_file() + "]</option> ";
    return str;
  }

  public String GenRightOption(String paramString)
  {
    String str = "";
    MenuinfoMgr localMenuinfoMgr = new MenuinfoMgr();
    localMenuinfoMgr.setRsrv_str0(paramString);
    ArrayList localArrayList = localMenuinfoMgr.GetMenuList("SEL_BY_RIGHT");
    MenuinfoMgr[] arrayOfMenuinfoMgr = localMenuinfoMgr.GetList(localArrayList);
    for (int i = 0; i < arrayOfMenuinfoMgr.length; i++)
      str = str + "<option value=" + arrayOfMenuinfoMgr[i].getMenu_id() + " >" + "[" + this.commen.ConvertCodeToName("menuname", arrayOfMenuinfoMgr[i].getUp_menu_id()) + "]->" + "" + arrayOfMenuinfoMgr[i].getMenu_name() + "</option> ";
    return str;
  }

  public String GenStaffOption(String paramString)
  {
    String str = "";
    StaffMgr localStaffMgr = new StaffMgr();
    ArrayList localArrayList = localStaffMgr.GetUserList("SEL_BY_ALL");
    StaffMgr[] arrayOfStaffMgr = localStaffMgr.GetList(localArrayList);
    for (int i = 0; i < arrayOfStaffMgr.length; i++)
      str = str + "<option value=" + arrayOfStaffMgr[i].getStaff_id() + " >" + "[" + this.commen.ConvertCodeToName("staffname", arrayOfStaffMgr[i].getStaff_id()) + "]->" + "" + arrayOfStaffMgr[i].getStaff_name() + "</option> ";
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.commenMgr.CommParaMgr
 * JD-Core Version:    0.6.0
 */