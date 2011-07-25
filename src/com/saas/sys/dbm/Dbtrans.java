package com.saas.sys.dbm;

public class Dbtrans
{
  private DbConnect connect = new DbConnect();
  private Dbexecute execute = new Dbexecute();
  private Dbtable table = new Dbtable();
  private Dbcommit commit = new Dbcommit();

  public void setConnect(DbConnect paramDbConnect)
  {
    this.connect = paramDbConnect;
  }

  public void setExecutet(Dbexecute paramDbexecute)
  {
    this.execute = paramDbexecute;
  }

  public void setTtable(Dbtable paramDbtable)
  {
    this.table = paramDbtable;
  }

  public void setCommite(Dbcommit paramDbcommit)
  {
    this.commit = paramDbcommit;
  }

  public DbConnect getConnect()
  {
    return this.connect;
  }

  public Dbexecute getExecute()
  {
    return this.execute;
  }

  public Dbtable getTable()
  {
    return this.table;
  }

  public Dbcommit getCommit()
  {
    return this.commit;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.dbm.Dbtrans
 * JD-Core Version:    0.6.0
 */