package com.saas.sys.dbm;

import com.saas.sys.log.Logger;
import java.sql.Connection;
import java.sql.SQLException;

public class Dbcommit
{
  private Connection connectionHandle = null;
  private DbConnect thisConn = new DbConnect();
  private Logger log = new Logger(this);

  public void setThisConn(DbConnect paramDbConnect)
  {
    this.thisConn = paramDbConnect;
  }

  public DbConnect getThisConn()
  {
    return this.thisConn;
  }

  public Connection getConnectionHandle()
  {
    return this.connectionHandle;
  }

  public void setConnectionHandle(Connection paramConnection)
  {
    this.connectionHandle = paramConnection;
  }

  public void getConnect()
  {
    try
    {
      this.connectionHandle = this.thisConn.getConnection();
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public void tradeCommit()
  {
    try
    {
      this.connectionHandle.commit();
      closeConn();
    }
    catch (Exception localException2)
    {
      try
      {
        this.connectionHandle.rollback();
        closeConn();
      }
      catch (SQLException localSQLException)
      {
        closeConn();
        throw new RuntimeException(localSQLException);
      }
      throw new RuntimeException(localException2);
    }
    finally
    {
      try
      {
        closeConn();
      }
      catch (Exception localException3)
      {
        throw new RuntimeException(localException3);
      }
    }
  }

  public void closeConn()
  {
    try
    {
      if (!isConnClosed())
        this.connectionHandle.close();
    }
    catch (SQLException localSQLException1)
    {
      try
      {
        if (!isConnClosed())
          this.connectionHandle.close();
      }
      catch (SQLException localSQLException2)
      {
        this.log.LOG_ERROR("关闭指定数据库连接失败");
      }
    }
  }

  private boolean isConnClosed()
    throws SQLException
  {
    return (null == this.connectionHandle) || (this.connectionHandle.isClosed());
  }

  public void closeConn_old()
  {
    try
    {
      if (this.connectionHandle != null)
      {
        this.connectionHandle.close();
        this.connectionHandle = null;
      }
    }
    catch (SQLException localSQLException)
    {
      throw new RuntimeException(localSQLException);
    }
  }

  public void rollback()
  {
    try
    {
      this.connectionHandle.rollback();
      try
      {
        closeConn();
      }
      catch (Exception localException)
      {
        this.connectionHandle.close();
      }
    }
    catch (SQLException localSQLException)
    {
      throw new RuntimeException(localSQLException);
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.dbm.Dbcommit
 * JD-Core Version:    0.6.0
 */