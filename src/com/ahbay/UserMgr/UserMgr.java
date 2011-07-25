package com.ahbay.UserMgr;

import com.ahbay.commenMgr.DataBaseCommMgr;
import com.ahbay.commenMgr.commMethodMgr;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.struts.action.Action;

public class UserMgr extends Action
{
  private String staffId;
  private String staffName;
  private String staffLevel;
  private String staffPwd;
  private String caseid;
  private String contractId;
  DataBaseCommMgr DBQuery = new DataBaseCommMgr();
  commMethodMgr comm = new commMethodMgr();

  public String GetContractId()
  {
    return this.contractId;
  }

  public String GetCaseid()
  {
    return this.caseid;
  }

  public String GetStaffId()
  {
    return this.staffId;
  }

  public String GetStaffName()
  {
    return this.staffName;
  }

  public String GetStaffLevel()
  {
    return this.staffLevel;
  }

  public String GetStaffPwd()
  {
    return this.staffPwd;
  }

  public void setContractId(String paramString)
  {
    this.contractId = paramString;
  }

  public void setCaseid(String paramString)
  {
    this.caseid = paramString;
  }

  public void setStaffId(String paramString)
  {
    this.staffId = paramString;
  }

  public void setStaffName(String paramString)
  {
    this.staffName = paramString;
  }

  public void setStaffLevel(String paramString)
  {
    this.staffLevel = paramString;
  }

  public void setStaffPwd(String paramString)
  {
    this.staffPwd = paramString;
  }

  public UserMgr GetUserInfo()
  {
    String str1 = "";
    String str2 = "0";
    int i = 0;
    str1 = "select * from czyxxb where czygh='" + this.staffId + "' and mm='" + this.staffPwd + "'";
    ResultSet localResultSet = null;
    UserMgr localUserMgr = new UserMgr();
    this.DBQuery.setStrQuery(str1);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        localUserMgr.setStaffId(this.comm.convetStrToWeb(localResultSet.getString("czygh")));
        localUserMgr.setStaffName(this.comm.convetStrToWeb(localResultSet.getString("czymc")));
        localUserMgr.setStaffLevel(this.comm.convetStrToWeb(localResultSet.getString("czyjb")));
        localUserMgr.setStaffPwd(this.comm.convetStrToWeb(localResultSet.getString("mm")));
      }
    }
    catch (Exception localException)
    {
      System.out.println("ERROR:" + localException.getMessage());
    }
    this.DBQuery.CloseConn();
    return localUserMgr;
  }

  public ArrayList GetUserList(String paramString)
  {
    String str = "";
    if (paramString.equalsIgnoreCase("SEL_BY_DEPART"))
      str = "";
    else if (paramString.equalsIgnoreCase("SEL_BY_CASE"))
      str = "select * from czyxxb a where a.czygh!='" + this.staffId + "' and a.czygh not in " + "(select b.staff_id from workstaffinfo b where b.case_id='" + this.caseid + "' and b.remove_tag='0')";
    else if (paramString.equalsIgnoreCase("SEL_BY_ALL"))
      str = "select * from czyxxb";
    else
      str = "select * from czyxxb where czygh='" + this.staffId + "'";
    ResultSet localResultSet = null;
    ArrayList localArrayList = new ArrayList();
    this.DBQuery.setStrQuery(str);
    localResultSet = this.DBQuery.SelBizQuery();
    try
    {
      while (localResultSet.next())
      {
        UserMgr localUserMgr = new UserMgr();
        localUserMgr.setStaffId(this.comm.convetStrToWeb(localResultSet.getString("czygh")));
        localUserMgr.setStaffName(this.comm.convetStrToWeb(localResultSet.getString("czymc")));
        localUserMgr.setStaffLevel(this.comm.convetStrToWeb(localResultSet.getString("czyjb")));
        localUserMgr.setStaffPwd(this.comm.convetStrToWeb(localResultSet.getString("mm")));
        localArrayList.add(localUserMgr);
      }
    }
    catch (Exception localException)
    {
    }
    this.DBQuery.CloseConn();
    return localArrayList;
  }

  public UserMgr[] GetList(ArrayList paramArrayList)
  {
    UserMgr[] arrayOfUserMgr = new UserMgr[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      UserMgr localUserMgr = (UserMgr)paramArrayList.get(i);
      arrayOfUserMgr[i] = localUserMgr;
    }
    return arrayOfUserMgr;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.UserMgr.UserMgr
 * JD-Core Version:    0.6.0
 */