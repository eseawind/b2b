package com.ahbay.RightMgr;

import com.ahbay.commenMgr.DataBaseCommMgr;
import com.ahbay.commenMgr.commMethodMgr;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.struts.action.Action;

public class RightinfoMgr extends Action
{
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();
  commMethodMgr commen = new commMethodMgr();
  private String staff_id;
  private String menu_id;
  private String start_date;
  private String end_date;
  private String right_attr;
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

  public String getStaff_id()
  {
    return this.staff_id;
  }

  public String getMenu_id()
  {
    return this.menu_id;
  }

  public String getStart_date()
  {
    return this.start_date;
  }

  public String getEnd_date()
  {
    return this.end_date;
  }

  public String getRight_attr()
  {
    return this.right_attr;
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

  public void setStaff_id(String paramString)
  {
    this.staff_id = paramString;
  }

  public void setMenu_id(String paramString)
  {
    this.menu_id = paramString;
  }

  public void setStart_date(String paramString)
  {
    this.start_date = paramString;
  }

  public void setEnd_date(String paramString)
  {
    this.end_date = paramString;
  }

  public void setRight_attr(String paramString)
  {
    this.right_attr = paramString;
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

  public String AddRightInfo()
  {
    String str1 = "";
    str1 = "insert into rightinfo values('" + this.commen.convetStrToDb(this.staff_id) + "'," + "'" + this.commen.convetStrToDb(this.menu_id) + "'," + "TO_DATE('" + this.commen.convetStrToDb(this.start_date) + " 00:00:00', 'YYYY-MM-DD HH24:MI:SS')," + "TO_DATE('" + this.commen.convetStrToDb(this.end_date) + " 00:00:00', 'YYYY-MM-DD HH24:MI:SS')," + "'" + this.commen.convetStrToDb(this.right_attr) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str1) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str2) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str3) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str4) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str5) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str6) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str7) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str8) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str9) + "'," + "'" + this.commen.convetStrToDb(this.rsrv_str0) + "'," + "'" + this.commen.convetStrToDb(this.in_staff_id) + "'," + "sysdate," + "'" + this.commen.convetStrToDb(this.remark) + "'" + ")";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }

  public ArrayList GetRightList(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_STAFF_SYS"))
      str = "select * from rightinfo where staff_id='" + this.staff_id + "' and end_date>sysdate and right_attr='0'";
    else if (paramString.equalsIgnoreCase("SEL_BY_STAFF_WEB"))
      str = "select * from rightinfo where staff_id='" + this.staff_id + "' and end_date>sysdate  and right_attr='1'";
    else
      str = "select * from rightinfo where end_date>sysdate";
    ResultSet localResultSet = null;
    ArrayList localArrayList = new ArrayList();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        RightinfoMgr localRightinfoMgr = new RightinfoMgr();
        localRightinfoMgr.setStaff_id(this.commen.convetStrToWeb(localResultSet.getString("staff_id")));
        localRightinfoMgr.setMenu_id(this.commen.convetStrToWeb(localResultSet.getString("menu_id")));
        localRightinfoMgr.setStart_date(this.commen.convetStrToWeb(localResultSet.getString("start_date")));
        localRightinfoMgr.setEnd_date(this.commen.convetStrToWeb(localResultSet.getString("end_date")));
        localRightinfoMgr.setRight_attr(this.commen.convetStrToWeb(localResultSet.getString("right_attr")));
        localRightinfoMgr.setRsrv_str1(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str1")));
        localRightinfoMgr.setRsrv_str2(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str2")));
        localRightinfoMgr.setRsrv_str3(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str3")));
        localRightinfoMgr.setRsrv_str4(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str4")));
        localRightinfoMgr.setRsrv_str5(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str5")));
        localRightinfoMgr.setRsrv_str6(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str6")));
        localRightinfoMgr.setRsrv_str7(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str7")));
        localRightinfoMgr.setRsrv_str8(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str8")));
        localRightinfoMgr.setRsrv_str9(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str9")));
        localRightinfoMgr.setRsrv_str0(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str0")));
        localRightinfoMgr.setIn_staff_id(this.commen.convetStrToWeb(localResultSet.getString("in_staff_id")));
        localRightinfoMgr.setIn_date(this.commen.convetStrToWeb(localResultSet.getString("in_date")));
        localRightinfoMgr.setRemark(this.commen.convetStrToWeb(localResultSet.getString("remark")));
        localArrayList.add(localRightinfoMgr);
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localArrayList;
  }

  public RightinfoMgr[] GetList(ArrayList paramArrayList)
  {
    RightinfoMgr[] arrayOfRightinfoMgr = new RightinfoMgr[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      RightinfoMgr localRightinfoMgr = (RightinfoMgr)paramArrayList.get(i);
      arrayOfRightinfoMgr[i] = localRightinfoMgr;
    }
    return arrayOfRightinfoMgr;
  }

  public RightinfoMgr GetRightInfo(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_CUST"));
    ResultSet localResultSet = null;
    RightinfoMgr localRightinfoMgr = new RightinfoMgr();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        localRightinfoMgr.setStaff_id(this.commen.convetStrToWeb(localResultSet.getString("staff_id")));
        localRightinfoMgr.setMenu_id(this.commen.convetStrToWeb(localResultSet.getString("menu_id")));
        localRightinfoMgr.setStart_date(this.commen.convetStrToWeb(localResultSet.getString("start_date")));
        localRightinfoMgr.setEnd_date(this.commen.convetStrToWeb(localResultSet.getString("end_date")));
        localRightinfoMgr.setRight_attr(this.commen.convetStrToWeb(localResultSet.getString("right_attr")));
        localRightinfoMgr.setRsrv_str1(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str1")));
        localRightinfoMgr.setRsrv_str2(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str2")));
        localRightinfoMgr.setRsrv_str3(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str3")));
        localRightinfoMgr.setRsrv_str4(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str4")));
        localRightinfoMgr.setRsrv_str5(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str5")));
        localRightinfoMgr.setRsrv_str6(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str6")));
        localRightinfoMgr.setRsrv_str7(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str7")));
        localRightinfoMgr.setRsrv_str8(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str8")));
        localRightinfoMgr.setRsrv_str9(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str9")));
        localRightinfoMgr.setRsrv_str0(this.commen.convetStrToWeb(localResultSet.getString("rsrv_str0")));
        localRightinfoMgr.setIn_staff_id(this.commen.convetStrToWeb(localResultSet.getString("in_staff_id")));
        localRightinfoMgr.setIn_date(this.commen.convetStrToWeb(localResultSet.getString("in_date")));
        localRightinfoMgr.setRemark(this.commen.convetStrToWeb(localResultSet.getString("remark")));
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localRightinfoMgr;
  }

  public String EndUserRight()
  {
    String str1 = "";
    str1 = "delete from  rightinfo where staff_id='" + this.staff_id + "' and menu_id='" + this.menu_id + "'";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.RightMgr.RightinfoMgr
 * JD-Core Version:    0.6.0
 */