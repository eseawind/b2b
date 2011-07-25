package com.saas.sys.dbm;

import com.saas.sys.buffer.Buffers;
import com.saas.sys.log.Logger;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Dbexecute
{
  private Connection connectionHandle = null;
  private ArrayList queryList = new ArrayList();
  private ArrayList paramList = new ArrayList();
  private String strQuery;
  private String strTable;
  private Dbcommit commit;
  Dbtable query = new Dbtable();
  Logger log = new Logger(this);

  public Connection getConnectionHandle()
  {
    return this.connectionHandle;
  }

  public void setConnectionHandle(Connection paramConnection)
  {
    this.connectionHandle = paramConnection;
  }

  public String getStrTable()
  {
    return this.strTable;
  }

  public void setStrTable(String paramString)
  {
    this.strTable = paramString;
  }

  public ArrayList getQueryList()
  {
    return this.queryList;
  }

  public String getStrQuery()
  {
    return this.strQuery;
  }

  public void setStrQuery(String paramString)
  {
    this.strQuery = paramString;
  }

  public void setQueryList(ArrayList paramArrayList)
  {
    this.queryList = paramArrayList;
  }

  public void addStrQuery(String paramString)
  {
    this.queryList.add(paramString);
  }

  public ArrayList getParamList()
  {
    return this.paramList;
  }

  public void setParamList(ArrayList paramArrayList)
  {
    this.paramList = paramArrayList;
  }

  public void execBizQuery()
  {
    PreparedStatement localPreparedStatement = null;
    if (this.queryList.isEmpty())
      return;
    Iterator localIterator1 = this.queryList.iterator();
    while (localIterator1.hasNext())
    {
      ArrayList localArrayList1 = (ArrayList)localIterator1.next();
      Iterator localIterator2 = localArrayList1.iterator();
      while (localIterator2.hasNext())
      {
        HashMap localHashMap = (HashMap)localIterator2.next();
        if (localHashMap.get("queryString") != null)
        {
          String str = localHashMap.get("queryString").toString();
          this.strTable = localHashMap.get("queryTable").toString();
          this.strQuery = localHashMap.get("queryString").toString();
          ArrayList localArrayList2 = (ArrayList)localHashMap.get("queryVarMap");
          try
          {
            this.strQuery = getQuery();
            this.paramList = localArrayList2;
            ArrayList localArrayList3 = replaceQueryParam();
            if (localPreparedStatement != null)
              localPreparedStatement.clearParameters();
            localPreparedStatement = this.connectionHandle.prepareStatement(this.strQuery);
            setQueryParam(localPreparedStatement, localArrayList3);
            localPreparedStatement.executeUpdate();
          }
          catch (SQLException localSQLException)
          {
            localPreparedStatement = null;
            throw new RuntimeException(localSQLException);
          }
          catch (Exception localException)
          {
            localPreparedStatement = null;
            throw new RuntimeException(localException);
          }
        }
      }
    }
    localPreparedStatement = null;
    this.queryList.clear();
  }

  public ArrayList selBizQuery()
  {
    Dbcommit localDbcommit = new Dbcommit();
    localDbcommit.getConnect();
    Connection localConnection = localDbcommit.getConnectionHandle();
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    ResultSetMetaData localResultSetMetaData = null;
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    try
    {
      this.strQuery = getQuery();
      ArrayList localArrayList2 = replaceQueryParam();
      if (localPreparedStatement != null)
        localPreparedStatement.clearParameters();
      localPreparedStatement = localConnection.prepareStatement(this.strQuery);
      setQueryParam(localPreparedStatement, localArrayList2);
      localResultSet = localPreparedStatement.executeQuery();
      localResultSetMetaData = localResultSet.getMetaData();
      i = localResultSetMetaData.getColumnCount();
    }
    catch (SQLException localSQLException1)
    {
      localResultSetMetaData = null;
      localResultSet = null;
      localPreparedStatement = null;
      try
      {
        localConnection.close();
      }
      catch (SQLException localSQLException4)
      {
        throw new RuntimeException(localSQLException4);
      }
      localConnection = null;
      throw new RuntimeException(localSQLException1);
    }
    try
    {
      while (localResultSet.next())
      {
        HashMap localHashMap = new HashMap();
        for (int j = 1; j <= i; j++)
        {
          String str1 = localResultSetMetaData.getColumnName(j).toLowerCase();
          if ((localResultSetMetaData.getColumnTypeName(j) == "VARCHAR2") || (localResultSetMetaData.getColumnTypeName(j) == "CHAR") || (localResultSetMetaData.getColumnTypeName(j) == "DATE"))
          {
            if (localResultSet.getObject(j) != null)
              localHashMap.put(str1, localResultSet.getObject(j).toString());
            else
              localHashMap.put(str1, localResultSet.getObject(j));
          }
          else if (localResultSetMetaData.getColumnTypeName(j) == "LONG")
          {
            if (localResultSet.getCharacterStream(j) != null)
            {
              Reader localReader = localResultSet.getCharacterStream(j);
              String str2 = "";
              try
              {
                str2 = getLargerString(localReader);
                localHashMap.put(str1, str2);
              }
              catch (Exception localException)
              {
                throw new RuntimeException(localException);
              }
            }
            else
            {
              localHashMap.put(str1, "");
            }
          }
          else
            localHashMap.put(str1, localResultSet.getObject(j));
        }
        localArrayList1.add(localHashMap);
      }
    }
    catch (SQLException localSQLException2)
    {
      localResultSetMetaData = null;
      localResultSet = null;
      localPreparedStatement = null;
      try
      {
        localConnection.close();
      }
      catch (SQLException localSQLException5)
      {
        throw new RuntimeException(localSQLException5);
      }
      localConnection = null;
      throw new RuntimeException(localSQLException2);
    }
    localResultSetMetaData = null;
    localResultSet = null;
    localPreparedStatement = null;
    try
    {
      localConnection.close();
    }
    catch (SQLException localSQLException3)
    {
      throw new RuntimeException(localSQLException3);
    }
    localConnection = null;
    return localArrayList1;
  }

  public void addTable(Dbtable paramDbtable)
  {
    setQueryList(paramDbtable.getExecuteBy());
  }

  public String convetStrToWeb(String paramString)
  {
    String str = "";
    if ((paramString == null) || (paramString == ""))
      str = "";
    else
      try
      {
        str = new String(paramString.getBytes("GB2312"), "ISO8859_1");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    if ((paramString == null) || (paramString == ""))
      str = "";
    return str;
  }

  public String convetStrToDb(String paramString)
  {
    String str = "";
    if ((paramString == null) || (paramString == ""))
      str = "";
    else
      try
      {
        str = new String(paramString.getBytes("ISO8859_1"), "GB2312");
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    if ((paramString == null) || (paramString == ""))
      str = "";
    return str;
  }

  public ArrayList replaceQueryParam()
  {
    if (this.paramList.isEmpty())
      return null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    String[] arrayOfString1 = this.strQuery.trim().split(" ");
    for (int j = 0; j < arrayOfString1.length; j++)
    {
      if (arrayOfString1[j].length() <= 0)
        continue;
      String[] arrayOfString2 = arrayOfString1[j].split(",");
      for (int k = 0; k < arrayOfString2.length; k++)
      {
        if (arrayOfString2[k].length() <= 0)
          continue;
        String[] arrayOfString3 = arrayOfString2[k].split(":");
        for (int m = 0; m < arrayOfString3.length; m++)
        {
          if ((arrayOfString3[m].length() <= 0) || (!arrayOfString3[m].substring(0, 1).equals("V")))
            continue;
          i += 1;
          Iterator localIterator = this.paramList.iterator();
          while (localIterator.hasNext())
          {
            HashMap localHashMap1 = (HashMap)localIterator.next();
            HashMap localHashMap2 = new HashMap();
            if (localHashMap1.get("paramName") != null)
            {
              String str = arrayOfString3[m].replaceAll("\\)", "");
              if (localHashMap1.get("paramName").toString().equalsIgnoreCase(":" + str))
              {
                int n = this.strQuery.indexOf(localHashMap1.get("paramName").toString()) + localHashMap1.get("paramName").toString().length();
                if (this.strQuery.length() > n)
                {
                  if ((this.strQuery.substring(n, n + 1).equalsIgnoreCase(",")) || (this.strQuery.substring(n, n + 1).equalsIgnoreCase(" ")) || (this.strQuery.substring(n, n + 1).equalsIgnoreCase(")")) || (this.strQuery.substring(n, n + 1).equalsIgnoreCase("")))
                  {
                    this.strQuery = this.strQuery.replaceFirst(localHashMap1.get("paramName").toString(), "?");
                    localHashMap2.put("paramValue", localHashMap1.get("paramValue").toString());
                    localHashMap2.put("order", new Integer(i));
                    localArrayList.add(localHashMap2);
                  }
                }
                else
                {
                  this.strQuery = this.strQuery.replaceAll(localHashMap1.get("paramName").toString(), "?");
                  localHashMap2.put("paramValue", localHashMap1.get("paramValue").toString());
                  localHashMap2.put("order", new Integer(i));
                  localArrayList.add(localHashMap2);
                }
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }

  public PreparedStatement setQueryParam(PreparedStatement paramPreparedStatement, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
      return paramPreparedStatement;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      int i = new Integer(localHashMap.get("order").toString()).intValue();
      try
      {
        if (localHashMap.get("paramValue").toString().length() > 1000)
          paramPreparedStatement.setCharacterStream(i, new StringReader(localHashMap.get("paramValue").toString()), localHashMap.get("paramValue").toString().length());
        else
          paramPreparedStatement.setObject(i, localHashMap.get("paramValue"));
      }
      catch (SQLException localSQLException)
      {
        throw new RuntimeException(localSQLException);
      }
    }
    return paramPreparedStatement;
  }

  public String getQuery()
  {
    QueryXML localQueryXML = new QueryXML();
    String str1 = Thread.currentThread().getContextClassLoader().getResource("").toString();
    String str2 = str1.substring(0, str1.length() - 8) + "SaasQuery.xml";
    localQueryXML.setXmlFilePath(str2);
    localQueryXML.setTableName(this.strTable);
    localQueryXML.setQueryName(this.strQuery);
    String str3 = localQueryXML.getQueryTableXML();
    localQueryXML = null;
    return str3;
  }

  public ArrayList selBizQuery(int paramInt1, int paramInt2)
  {
    Dbcommit localDbcommit = new Dbcommit();
    localDbcommit.getConnect();
    Connection localConnection = localDbcommit.getConnectionHandle();
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    Object localObject1 = null;
    Object localObject2 = null;
    ResultSetMetaData localResultSetMetaData = null;
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    int j = 0;
    try
    {
      this.strQuery = getQuery();
      ArrayList localArrayList2 = replaceQueryParam();
      if (localPreparedStatement != null)
        localPreparedStatement.clearParameters();
      String str1 = "select count(*) ct from (" + this.strQuery + ") bizoss";
      this.strQuery = (this.strQuery + " limit " + paramInt1 + "," + paramInt2);
      localPreparedStatement = localConnection.prepareStatement(this.strQuery);
      setQueryParam(localPreparedStatement, localArrayList2);
      localResultSet = localPreparedStatement.executeQuery();
      localResultSetMetaData = localResultSet.getMetaData();
      i = localResultSetMetaData.getColumnCount();
    }
    catch (SQLException localSQLException1)
    {
      localResultSetMetaData = null;
      localResultSet = null;
      localPreparedStatement = null;
      localObject1 = null;
      localObject2 = null;
      try
      {
        localConnection.close();
      }
      catch (SQLException localSQLException4)
      {
        throw new RuntimeException(localSQLException4);
      }
      localConnection = null;
      throw new RuntimeException(localSQLException1);
    }
    try
    {
      while (localResultSet.next())
      {
        HashMap localHashMap = new HashMap();
        for (int k = 1; k <= i; k++)
        {
          String str2 = localResultSetMetaData.getColumnName(k).toLowerCase();
          if ((localResultSetMetaData.getColumnTypeName(k) == "VARCHAR2") || (localResultSetMetaData.getColumnTypeName(k) == "CHAR") || (localResultSetMetaData.getColumnTypeName(k) == "VARCHAR") || (localResultSetMetaData.getColumnTypeName(k) == "DATE"))
          {
            if (localResultSet.getObject(k) != null)
              localHashMap.put(str2, localResultSet.getObject(k).toString());
            else
              localHashMap.put(str2, localResultSet.getObject(k));
          }
          else if (localResultSetMetaData.getColumnTypeName(k) == "LONG")
          {
            if (localResultSet.getCharacterStream(k) != null)
            {
              Reader localReader = localResultSet.getCharacterStream(k);
              String str3 = "";
              try
              {
                str3 = getLargerString(localReader);
                localHashMap.put(str2, str3);
              }
              catch (Exception localException)
              {
                throw new RuntimeException(localException);
              }
            }
            else
            {
              localHashMap.put(str2, "");
            }
          }
          else
            localHashMap.put(str2, localResultSet.getObject(k));
        }
        localArrayList1.add(localHashMap);
      }
    }
    catch (SQLException localSQLException2)
    {
      localResultSetMetaData = null;
      localResultSet = null;
      localPreparedStatement = null;
      localObject1 = null;
      localObject2 = null;
      try
      {
        localConnection.close();
      }
      catch (SQLException localSQLException5)
      {
        throw new RuntimeException(localSQLException5);
      }
      localConnection = null;
      throw new RuntimeException(localSQLException2);
    }
    localResultSetMetaData = null;
    localResultSet = null;
    localPreparedStatement = null;
    localObject1 = null;
    localObject2 = null;
    try
    {
      localConnection.close();
    }
    catch (SQLException localSQLException3)
    {
      throw new RuntimeException(localSQLException3);
    }
    localConnection = null;
    return localArrayList1;
  }

  public static String getLargerString(Reader paramReader)
    throws Exception
  {
    Object localObject = new char[1024000];
    char[] arrayOfChar1 = new char[1024];
    int i = 0;
    int j = 0;
    int k = 1024000;
    while (true)
    {
      i = paramReader.read(arrayOfChar1);
      if (i == -1)
        break;
      if (j + i > k)
      {
        char[] arrayOfChar2 = new char[k + 1024000];
        System.arraycopy(localObject, 0, arrayOfChar2, 0, j);
        localObject = arrayOfChar2;
        k += 1024000;
      }
      System.arraycopy(arrayOfChar1, 0, localObject, j, i);
      j += i;
    }
    return (String)new String(localObject, 0, j);
  }

  public Object getFromBuffer(String paramString, Buffers paramBuffers)
  {
    Object localObject = null;
    return localObject;
  }

  public ArrayList selBizQuerySql(String paramString)
  {
    Dbcommit localDbcommit = new Dbcommit();
    localDbcommit.getConnect();
    Connection localConnection = localDbcommit.getConnectionHandle();
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    ResultSetMetaData localResultSetMetaData = null;
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    try
    {
      this.strQuery = getQuery();
      ArrayList localArrayList2 = replaceQueryParam();
      if (localPreparedStatement != null)
        localPreparedStatement.clearParameters();
      localPreparedStatement = localConnection.prepareStatement(paramString);
      localResultSet = localPreparedStatement.executeQuery();
      localResultSetMetaData = localResultSet.getMetaData();
      i = localResultSetMetaData.getColumnCount();
    }
    catch (SQLException localSQLException1)
    {
      localResultSetMetaData = null;
      localResultSet = null;
      localPreparedStatement = null;
      try
      {
        localConnection.close();
      }
      catch (SQLException localSQLException4)
      {
        throw new RuntimeException(localSQLException4);
      }
      localConnection = null;
      throw new RuntimeException(localSQLException1);
    }
    try
    {
      while (localResultSet.next())
      {
        HashMap localHashMap = new HashMap();
        for (int j = 1; j <= i; j++)
        {
          String str1 = localResultSetMetaData.getColumnName(j).toLowerCase();
          if ((localResultSetMetaData.getColumnTypeName(j) == "VARCHAR2") || (localResultSetMetaData.getColumnTypeName(j) == "CHAR") || (localResultSetMetaData.getColumnTypeName(j) == "DATE"))
          {
            if (localResultSet.getObject(j) != null)
              localHashMap.put(str1, localResultSet.getObject(j).toString());
            else
              localHashMap.put(str1, localResultSet.getObject(j));
          }
          else if (localResultSetMetaData.getColumnTypeName(j) == "LONG")
          {
            if (localResultSet.getCharacterStream(j) != null)
            {
              Reader localReader = localResultSet.getCharacterStream(j);
              String str2 = "";
              try
              {
                str2 = getLargerString(localReader);
                localHashMap.put(str1, str2);
              }
              catch (Exception localException)
              {
                throw new RuntimeException(localException);
              }
            }
            else
            {
              localHashMap.put(str1, "");
            }
          }
          else
            localHashMap.put(str1, localResultSet.getObject(j));
        }
        localArrayList1.add(localHashMap);
      }
    }
    catch (SQLException localSQLException2)
    {
      localResultSetMetaData = null;
      localResultSet = null;
      localPreparedStatement = null;
      try
      {
        localConnection.close();
      }
      catch (SQLException localSQLException5)
      {
        throw new RuntimeException(localSQLException5);
      }
      localConnection = null;
      throw new RuntimeException(localSQLException2);
    }
    localResultSetMetaData = null;
    localResultSet = null;
    localPreparedStatement = null;
    try
    {
      localConnection.close();
    }
    catch (SQLException localSQLException3)
    {
      throw new RuntimeException(localSQLException3);
    }
    localConnection = null;
    return localArrayList1;
  }

  public ArrayList selBizQuerySql(int paramInt1, int paramInt2, String paramString)
  {
    Dbcommit localDbcommit = new Dbcommit();
    localDbcommit.getConnect();
    Connection localConnection = localDbcommit.getConnectionHandle();
    PreparedStatement localPreparedStatement = null;
    ResultSet localResultSet = null;
    ResultSetMetaData localResultSetMetaData = null;
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    try
    {
      ArrayList localArrayList2 = replaceQueryParam();
      if (localPreparedStatement != null)
        localPreparedStatement.clearParameters();
      paramString = paramString + " limit " + paramInt1 + "," + paramInt2;
      localPreparedStatement = localConnection.prepareStatement(paramString);
      localResultSet = localPreparedStatement.executeQuery();
      localResultSetMetaData = localResultSet.getMetaData();
      i = localResultSetMetaData.getColumnCount();
    }
    catch (SQLException localSQLException1)
    {
      localResultSetMetaData = null;
      localResultSet = null;
      localPreparedStatement = null;
      try
      {
        localConnection.close();
      }
      catch (SQLException localSQLException4)
      {
        throw new RuntimeException(localSQLException4);
      }
      localConnection = null;
      throw new RuntimeException(localSQLException1);
    }
    try
    {
      while (localResultSet.next())
      {
        HashMap localHashMap = new HashMap();
        for (int j = 1; j <= i; j++)
        {
          String str1 = localResultSetMetaData.getColumnName(j).toLowerCase();
          if ((localResultSetMetaData.getColumnTypeName(j) == "VARCHAR2") || (localResultSetMetaData.getColumnTypeName(j) == "CHAR") || (localResultSetMetaData.getColumnTypeName(j) == "VARCHAR") || (localResultSetMetaData.getColumnTypeName(j) == "DATE"))
          {
            if (localResultSet.getObject(j) != null)
              localHashMap.put(str1, localResultSet.getObject(j).toString());
            else
              localHashMap.put(str1, localResultSet.getObject(j));
          }
          else if (localResultSetMetaData.getColumnTypeName(j) == "LONG")
          {
            if (localResultSet.getCharacterStream(j) != null)
            {
              Reader localReader = localResultSet.getCharacterStream(j);
              String str2 = "";
              try
              {
                str2 = getLargerString(localReader);
                localHashMap.put(str1, str2);
              }
              catch (Exception localException)
              {
                throw new RuntimeException(localException);
              }
            }
            else
            {
              localHashMap.put(str1, "");
            }
          }
          else
            localHashMap.put(str1, localResultSet.getObject(j));
        }
        localArrayList1.add(localHashMap);
      }
    }
    catch (SQLException localSQLException2)
    {
      localResultSetMetaData = null;
      localResultSet = null;
      localPreparedStatement = null;
      try
      {
        localConnection.close();
      }
      catch (SQLException localSQLException5)
      {
        throw new RuntimeException(localSQLException5);
      }
      localConnection = null;
      throw new RuntimeException(localSQLException2);
    }
    localResultSetMetaData = null;
    localResultSet = null;
    localPreparedStatement = null;
    try
    {
      localConnection.close();
    }
    catch (SQLException localSQLException3)
    {
      throw new RuntimeException(localSQLException3);
    }
    localConnection = null;
    return localArrayList1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.dbm.Dbexecute
 * JD-Core Version:    0.6.0
 */