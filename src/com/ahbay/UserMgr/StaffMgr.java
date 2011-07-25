package com.ahbay.UserMgr;

import com.ahbay.commenMgr.DataBaseCommMgr;
import com.ahbay.commenMgr.commMethodMgr;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.struts.action.Action;

public class StaffMgr extends Action
{
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();
  commMethodMgr comm = new commMethodMgr();
  private String staff_id;
  private String depart_id;
  private String staff_name;
  private String passwd;
  private String job_info;
  private String manager_info;
  private String sex;
  private String email;
  private String user_pid;
  private String serial_number;
  private String cust_id;
  private String dimission_tag;
  private String birthday;
  private String staff_group_id;
  private String cust_hobyy;
  private String remark;
  private String rsvalue1;
  private String rsvalue2;
  private String update_time;
  private String update_staff_id;
  private String update_depart_id;
  private String caseid;
  private String contractId;

  public String getStaff_id()
  {
    return this.staff_id;
  }

  public String getDepart_id()
  {
    return this.depart_id;
  }

  public String getStaff_name()
  {
    return this.staff_name;
  }

  public String getPasswd()
  {
    return this.passwd;
  }

  public String getJob_info()
  {
    return this.job_info;
  }

  public String getManager_info()
  {
    return this.manager_info;
  }

  public String getSex()
  {
    return this.sex;
  }

  public String getEmail()
  {
    return this.email;
  }

  public String getUser_pid()
  {
    return this.user_pid;
  }

  public String getSerial_number()
  {
    return this.serial_number;
  }

  public String getCust_id()
  {
    return this.cust_id;
  }

  public String getDimission_tag()
  {
    return this.dimission_tag;
  }

  public String getBirthday()
  {
    return this.birthday;
  }

  public String getStaff_group_id()
  {
    return this.staff_group_id;
  }

  public String getCust_hobyy()
  {
    return this.cust_hobyy;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public String getRsvalue1()
  {
    return this.rsvalue1;
  }

  public String getRsvalue2()
  {
    return this.rsvalue2;
  }

  public String getUpdate_time()
  {
    return this.update_time;
  }

  public String getUpdate_staff_id()
  {
    return this.update_staff_id;
  }

  public String getUpdate_depart_id()
  {
    return this.update_depart_id;
  }

  public String GetContractId()
  {
    return this.contractId;
  }

  public String GetCaseid()
  {
    return this.caseid;
  }

  public void setStaff_id(String paramString)
  {
    this.staff_id = paramString;
  }

  public void setDepart_id(String paramString)
  {
    this.depart_id = paramString;
  }

  public void setStaff_name(String paramString)
  {
    this.staff_name = paramString;
  }

  public void setPasswd(String paramString)
  {
    this.passwd = paramString;
  }

  public void setJob_info(String paramString)
  {
    this.job_info = paramString;
  }

  public void setManager_info(String paramString)
  {
    this.manager_info = paramString;
  }

  public void setSex(String paramString)
  {
    this.sex = paramString;
  }

  public void setEmail(String paramString)
  {
    this.email = paramString;
  }

  public void setUser_pid(String paramString)
  {
    this.user_pid = paramString;
  }

  public void setSerial_number(String paramString)
  {
    this.serial_number = paramString;
  }

  public void setCust_id(String paramString)
  {
    this.cust_id = paramString;
  }

  public void setDimission_tag(String paramString)
  {
    this.dimission_tag = paramString;
  }

  public void setBirthday(String paramString)
  {
    this.birthday = paramString;
  }

  public void setStaff_group_id(String paramString)
  {
    this.staff_group_id = paramString;
  }

  public void setCust_hobyy(String paramString)
  {
    this.cust_hobyy = paramString;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public void setRsvalue1(String paramString)
  {
    this.rsvalue1 = paramString;
  }

  public void setRsvalue2(String paramString)
  {
    this.rsvalue2 = paramString;
  }

  public void setUpdate_time(String paramString)
  {
    this.update_time = paramString;
  }

  public void setUpdate_staff_id(String paramString)
  {
    this.update_staff_id = paramString;
  }

  public void setUpdate_depart_id(String paramString)
  {
    this.update_depart_id = paramString;
  }

  public void setContractId(String paramString)
  {
    this.contractId = paramString;
  }

  public void setCaseid(String paramString)
  {
    this.caseid = paramString;
  }

  public String AddStaff()
  {
    String str1 = "";
    str1 = "insert into staffinfo values('" + this.comm.convetStrToDb(this.staff_id) + "'," + "'" + this.comm.convetStrToDb(this.depart_id) + "'," + "'" + this.comm.convetStrToDb(this.staff_name) + "'," + "'" + this.comm.convetStrToDb(this.passwd) + "'," + "'" + this.comm.convetStrToDb(this.job_info) + "'," + "'" + this.comm.convetStrToDb(this.manager_info) + "'," + "'" + this.comm.convetStrToDb(this.sex) + "'," + "'" + this.comm.convetStrToDb(this.email) + "'," + "'" + this.comm.convetStrToDb(this.user_pid) + "'," + "'" + this.comm.convetStrToDb(this.serial_number) + "'," + "'" + this.comm.convetStrToDb(this.cust_id) + "'," + "'" + this.comm.convetStrToDb(this.dimission_tag) + "'," + "TO_DATE('" + this.comm.convetStrToDb(this.birthday) + " 00:00:00', 'YYYY-MM-DD HH24:MI:SS')," + "'" + this.comm.convetStrToDb(this.staff_group_id) + "'," + "'" + this.comm.convetStrToDb(this.cust_hobyy) + "'," + "'" + this.comm.convetStrToDb(this.remark) + "'," + "'" + this.comm.convetStrToDb(this.rsvalue1) + "'," + "'" + this.comm.convetStrToDb(this.rsvalue2) + "'," + "sysdate," + "'" + this.comm.convetStrToDb(this.update_staff_id) + "'," + "'" + this.comm.convetStrToDb(this.update_depart_id) + "'" + ")";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }

  public StaffMgr GetUserInfo(String paramString)
  {
    String str1 = "";
    String str2 = "0";
    int i = 0;
    if (paramString.equalsIgnoreCase("SEL_BY_PWD"))
      str1 = "select * from staffinfo where staff_id='" + this.staff_id + "' and passwd='" + this.passwd + "'";
    else if (paramString.equalsIgnoreCase("SEL_BY_ID"))
      str1 = "select * from staffinfo where staff_id='" + this.staff_id + "'";
    ResultSet localResultSet = null;
    StaffMgr localStaffMgr = new StaffMgr();
    this.DBQuery.setStrQuery(str1);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        localStaffMgr.setStaff_id(this.comm.convetStrToWeb(localResultSet.getString("staff_id")));
        localStaffMgr.setDepart_id(this.comm.convetStrToWeb(localResultSet.getString("depart_id")));
        localStaffMgr.setStaff_name(this.comm.convetStrToWeb(localResultSet.getString("staff_name")));
        localStaffMgr.setPasswd(this.comm.convetStrToWeb(localResultSet.getString("passwd")));
        localStaffMgr.setJob_info(this.comm.convetStrToWeb(localResultSet.getString("job_info")));
        localStaffMgr.setManager_info(this.comm.convetStrToWeb(localResultSet.getString("manager_info")));
        localStaffMgr.setSex(this.comm.convetStrToWeb(localResultSet.getString("sex")));
        localStaffMgr.setEmail(this.comm.convetStrToWeb(localResultSet.getString("email")));
        localStaffMgr.setUser_pid(this.comm.convetStrToWeb(localResultSet.getString("user_pid")));
        localStaffMgr.setSerial_number(this.comm.convetStrToWeb(localResultSet.getString("serial_number")));
        localStaffMgr.setCust_id(this.comm.convetStrToWeb(localResultSet.getString("cust_id")));
        localStaffMgr.setDimission_tag(this.comm.convetStrToWeb(localResultSet.getString("dimission_tag")));
        localStaffMgr.setBirthday(this.comm.convetStrToWeb(localResultSet.getString("birthday")));
        localStaffMgr.setStaff_group_id(this.comm.convetStrToWeb(localResultSet.getString("staff_group_id")));
        localStaffMgr.setCust_hobyy(this.comm.convetStrToWeb(localResultSet.getString("cust_hobyy")));
        localStaffMgr.setRemark(this.comm.convetStrToWeb(localResultSet.getString("remark")));
        localStaffMgr.setRsvalue1(this.comm.convetStrToWeb(localResultSet.getString("rsvalue1")));
        localStaffMgr.setRsvalue2(this.comm.convetStrToWeb(localResultSet.getString("rsvalue2")));
        localStaffMgr.setUpdate_time(this.comm.convetStrToWeb(localResultSet.getString("update_time")));
        localStaffMgr.setUpdate_staff_id(this.comm.convetStrToWeb(localResultSet.getString("update_staff_id")));
        localStaffMgr.setUpdate_depart_id(this.comm.convetStrToWeb(localResultSet.getString("update_depart_id")));
      }
    }
    catch (Exception localException)
    {
      System.out.println("ERROR:" + localException.getMessage());
    }
    this.DBQuery.CloseConn();
    return localStaffMgr;
  }

  public ArrayList GetUserList(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_DEPART"))
      str = "";
    else if (paramString.equalsIgnoreCase("SEL_BY_CASE"))
      str = "select * from staffinfo a where a.staff_id!='" + this.staff_id + "' and a.staff_id not in " + "(select b.staff_id from workstaffinfo b where b.case_id='" + this.caseid + "' and b.remove_tag='0')";
    else if (paramString.equalsIgnoreCase("SEL_BY_ALL"))
      str = "select * from staffinfo";
    else if (paramString.equalsIgnoreCase("SEL_BY_EXP_THIS"))
      str = "select * from staffinfo where staff_id!='" + this.staff_id + "'";
    else
      str = "select * from staffinfo where staff_id='" + this.staff_id + "'";
    ResultSet localResultSet = null;
    ArrayList localArrayList = new ArrayList();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        StaffMgr localStaffMgr = new StaffMgr();
        localStaffMgr.setStaff_id(localResultSet.getString("staff_id"));
        localStaffMgr.setDepart_id(this.comm.convetStrToWeb(localResultSet.getString("depart_id")));
        localStaffMgr.setStaff_name(this.comm.convetStrToWeb(localResultSet.getString("staff_name")));
        localStaffMgr.setPasswd(this.comm.convetStrToWeb(localResultSet.getString("passwd")));
        localStaffMgr.setJob_info(this.comm.convetStrToWeb(localResultSet.getString("job_info")));
        localStaffMgr.setManager_info(this.comm.convetStrToWeb(localResultSet.getString("manager_info")));
        localStaffMgr.setSex(this.comm.convetStrToWeb(localResultSet.getString("sex")));
        localStaffMgr.setEmail(this.comm.convetStrToWeb(localResultSet.getString("email")));
        localStaffMgr.setUser_pid(this.comm.convetStrToWeb(localResultSet.getString("user_pid")));
        localStaffMgr.setSerial_number(this.comm.convetStrToWeb(localResultSet.getString("serial_number")));
        localStaffMgr.setCust_id(this.comm.convetStrToWeb(localResultSet.getString("cust_id")));
        localStaffMgr.setDimission_tag(this.comm.convetStrToWeb(localResultSet.getString("dimission_tag")));
        localStaffMgr.setBirthday(this.comm.convetStrToWeb(localResultSet.getString("birthday")));
        localStaffMgr.setStaff_group_id(this.comm.convetStrToWeb(localResultSet.getString("staff_group_id")));
        localStaffMgr.setCust_hobyy(this.comm.convetStrToWeb(localResultSet.getString("cust_hobyy")));
        localStaffMgr.setRemark(this.comm.convetStrToWeb(localResultSet.getString("remark")));
        localStaffMgr.setRsvalue1(this.comm.convetStrToWeb(localResultSet.getString("rsvalue1")));
        localStaffMgr.setRsvalue2(this.comm.convetStrToWeb(localResultSet.getString("rsvalue2")));
        localStaffMgr.setUpdate_time(this.comm.convetStrToWeb(localResultSet.getString("update_time")));
        localStaffMgr.setUpdate_staff_id(this.comm.convetStrToWeb(localResultSet.getString("update_staff_id")));
        localStaffMgr.setUpdate_depart_id(this.comm.convetStrToWeb(localResultSet.getString("update_depart_id")));
        localArrayList.add(localStaffMgr);
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localArrayList;
  }

  public StaffMgr[] GetList(ArrayList paramArrayList)
  {
    StaffMgr[] arrayOfStaffMgr = new StaffMgr[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      StaffMgr localStaffMgr = (StaffMgr)paramArrayList.get(i);
      arrayOfStaffMgr[i] = localStaffMgr;
    }
    return arrayOfStaffMgr;
  }

  public String ModifyPwd()
  {
    String str1 = "";
    str1 = "update staffinfo set passwd='" + this.passwd + "' where staff_id='" + this.staff_id + "'";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }

  public String DelStaff()
  {
    String str1 = "";
    str1 = "delete from staffinfo where staff_id='" + this.staff_id + "'";
    this.DBQuery.setStrQuery(str1);
    String str2 = this.DBQuery.ExecBizQuery();
    return str2;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.UserMgr.StaffMgr
 * JD-Core Version:    0.6.0
 */