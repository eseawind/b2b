package com.ahbay.commenMgr;

import com.ahbay.DataBaseMgr.InterfDataBaseConn;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class InterfDataBaseCommMgr
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
    InterfDataBaseConn localInterfDataBaseConn = new InterfDataBaseConn();
    this.ConnectionHandle = (Connection) localInterfDataBaseConn.GetConnection();
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

  public ArrayList SelBizQuery()
  {
    this.ConnectionHandle = null;
    InterfDataBaseConn localInterfDataBaseConn = new InterfDataBaseConn();
    this.ConnectionHandle = (Connection) localInterfDataBaseConn.getInterfConnection();
    ResultSet localResultSet = null;
    ResultSetMetaData localResultSetMetaData = null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      Statement localStatement = this.ConnectionHandle.createStatement();
      localResultSet = localStatement.executeQuery(this.strQuery);
      localResultSetMetaData = localResultSet.getMetaData();
      i = localResultSetMetaData.getColumnCount();
    }
    catch (SQLException localSQLException1)
    {
      System.out.println("SQLERROR:" + localSQLException1.getMessage());
    }
    try
    {
      while (localResultSet.next())
      {
        HashMap localHashMap = new HashMap();
        for (int j = 1; j <= i; j++)
        {
          String str = localResultSetMetaData.getColumnName(j).toLowerCase();
          if ((localResultSetMetaData.getColumnTypeName(j) == "VARCHAR2") || (localResultSetMetaData.getColumnTypeName(j) == "CHAR") || (localResultSetMetaData.getColumnTypeName(j) == "DATE"))
          {
            if (localResultSet.getObject(j) != null)
              localHashMap.put(str, localResultSet.getObject(j).toString());
            else
              localHashMap.put(str, localResultSet.getObject(j));
          }
          else
            localHashMap.put(str, localResultSet.getObject(j));
        }
        localArrayList.add(localHashMap);
      }
    }
    catch (SQLException localSQLException2)
    {
      CloseConn();
      throw new RuntimeException(localSQLException2);
    }
    CloseConn();
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.commenMgr.InterfDataBaseCommMgr
 * JD-Core Version:    0.6.0
 */