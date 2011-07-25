package com.ahbay.RightMgr;

import com.ahbay.commenMgr.DataBaseCommMgr;
import com.ahbay.commenMgr.commMethodMgr;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.struts.action.Action;

public class ModuleMgr extends Action
{
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();
  commMethodMgr commen = new commMethodMgr();
  private String module_id;
  private String module_name;
  private String module_file;
  private String module_dir;
  private String module_type;
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

  public String getModule_id()
  {
    return this.module_id;
  }

  public String getModule_name()
  {
    return this.module_name;
  }

  public String getModule_file()
  {
    return this.module_file;
  }

  public String getModule_dir()
  {
    return this.module_dir;
  }

  public String getModule_type()
  {
    return this.module_type;
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

  public void setModule_id(String paramString)
  {
    this.module_id = paramString;
  }

  public void setModule_name(String paramString)
  {
    this.module_name = paramString;
  }

  public void setModule_file(String paramString)
  {
    this.module_file = paramString;
  }

  public void setModule_dir(String paramString)
  {
    this.module_dir = paramString;
  }

  public void setModule_type(String paramString)
  {
    this.module_type = paramString;
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

  public ArrayList GetModuleList(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_ALL"))
      str = "select * from moduleinfo order by module_id asc";
    ResultSet localResultSet = null;
    ArrayList localArrayList = new ArrayList();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        ModuleMgr localModuleMgr = new ModuleMgr();
        localModuleMgr.setModule_id(localResultSet.getString("module_id"));
        localModuleMgr.setModule_name(localResultSet.getString("module_name"));
        localModuleMgr.setModule_file(localResultSet.getString("module_file"));
        localModuleMgr.setModule_dir(localResultSet.getString("module_dir"));
        localModuleMgr.setModule_type(localResultSet.getString("module_type"));
        localModuleMgr.setRsrv_str1(localResultSet.getString("rsrv_str1"));
        localModuleMgr.setRsrv_str2(localResultSet.getString("rsrv_str2"));
        localModuleMgr.setRsrv_str3(localResultSet.getString("rsrv_str3"));
        localModuleMgr.setRsrv_str4(localResultSet.getString("rsrv_str4"));
        localModuleMgr.setRsrv_str5(localResultSet.getString("rsrv_str5"));
        localModuleMgr.setRsrv_str6(localResultSet.getString("rsrv_str6"));
        localModuleMgr.setRsrv_str7(localResultSet.getString("rsrv_str7"));
        localModuleMgr.setRsrv_str8(localResultSet.getString("rsrv_str8"));
        localModuleMgr.setRsrv_str9(localResultSet.getString("rsrv_str9"));
        localModuleMgr.setRsrv_str0(localResultSet.getString("rsrv_str0"));
        localModuleMgr.setIn_staff_id(localResultSet.getString("in_staff_id"));
        localModuleMgr.setIn_date(localResultSet.getString("in_date"));
        localModuleMgr.setRemark(localResultSet.getString("remark"));
        localArrayList.add(localModuleMgr);
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localArrayList;
  }

  public ModuleMgr[] GetList(ArrayList paramArrayList)
  {
    ModuleMgr[] arrayOfModuleMgr = new ModuleMgr[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      ModuleMgr localModuleMgr = (ModuleMgr)paramArrayList.get(i);
      arrayOfModuleMgr[i] = localModuleMgr;
    }
    return arrayOfModuleMgr;
  }

  public ModuleMgr GetModuleInfo(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_ID"))
      str = "select * from moduleinfo where module_id='" + this.module_id + "'";
    ResultSet localResultSet = null;
    ModuleMgr localModuleMgr = new ModuleMgr();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        localModuleMgr.setModule_id(this.commen.convetStrToWeb(localResultSet.getString("module_id")));
        localModuleMgr.setModule_name(this.commen.convetStrToWeb(localResultSet.getString("module_name")));
        localModuleMgr.setModule_file(this.commen.convetStrToWeb(localResultSet.getString("module_file")));
        localModuleMgr.setModule_dir(this.commen.convetStrToWeb(localResultSet.getString("module_dir")));
        localModuleMgr.setModule_type(this.commen.convetStrToWeb(localResultSet.getString("module_type")));
        localModuleMgr.setRsrv_str1(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str1")));
        localModuleMgr.setRsrv_str2(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str2")));
        localModuleMgr.setRsrv_str3(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str3")));
        localModuleMgr.setRsrv_str4(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str4")));
        localModuleMgr.setRsrv_str5(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str5")));
        localModuleMgr.setRsrv_str6(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str6")));
        localModuleMgr.setRsrv_str7(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str7")));
        localModuleMgr.setRsrv_str8(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str8")));
        localModuleMgr.setRsrv_str9(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str9")));
        localModuleMgr.setRsrv_str0(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str0")));
        localModuleMgr.setIn_staff_id(this.commen.convetStrToWeb(localResultSet.getString("in_staff_id")));
        localModuleMgr.setIn_date(this.commen.convetStrToWeb(localResultSet.getString("in_date")));
        localModuleMgr.setRemark(this.commen.convetStrToWeb(localResultSet.getString("remark")));
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localModuleMgr;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.RightMgr.ModuleMgr
 * JD-Core Version:    0.6.0
 */