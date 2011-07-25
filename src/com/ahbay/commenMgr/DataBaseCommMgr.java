package com.ahbay.commenMgr;

import com.ahbay.DataBaseMgr.DataBaseConn;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseCommMgr
{
  private String strQuery;
  private Connection ConnectionHandle;

  public String getStrQuery()
  {
    return this.strQuery;
  }

  public void setStrQuery(String paramString)
  {
    this.strQuery = paramString;
  }

  public String ExecBizQuery()
  {
    this.ConnectionHandle = null;
    DataBaseConn localDataBaseConn = new DataBaseConn();
    this.ConnectionHandle = localDataBaseConn.GetConnection();
    try
    {
      Statement localStatement = this.ConnectionHandle.createStatement();
      localStatement.executeUpdate(this.strQuery);
      this.ConnectionHandle.commit();
    }
    catch (SQLException localSQLException)
    {
      return localSQLException.getMessage() + "||" + this.strQuery;
    }
    catch (Exception localException)
    {
      return localException.getMessage() + "||" + this.strQuery;
    }
    CloseConn();
    return "1";
  }

  public void CloseConn()
  {
    try
    {
      this.ConnectionHandle.close();
    }
    catch (SQLException localSQLException)
    {
      System.out.println("SQLERROR:" + localSQLException.getMessage());
    }
  }

  public ResultSet SelBizQuery()
  {
    this.ConnectionHandle = null;
    DataBaseConn localDataBaseConn = new DataBaseConn();
    this.ConnectionHandle = localDataBaseConn.GetConnection();
    ResultSet localResultSet = null;
    try
    {
      Statement localStatement = this.ConnectionHandle.createStatement();
      localResultSet = localStatement.executeQuery(this.strQuery);
    }
    catch (SQLException localSQLException)
    {
      System.out.println("SQLERROR:" + localSQLException.getMessage());
    }
    return localResultSet;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.commenMgr.DataBaseCommMgr
 * JD-Core Version:    0.6.0
 */