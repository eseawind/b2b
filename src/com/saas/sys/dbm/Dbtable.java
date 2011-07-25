package com.saas.sys.dbm;

import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class Dbtable
{
  private ArrayList tradeQueryList = new ArrayList();
  private String strSelQuery;
  Logger log = new Logger(this);

  public ArrayList getExecuteBy()
  {
    return this.tradeQueryList;
  }

  public void executeBy(ArrayList paramArrayList)
  {
    this.tradeQueryList.add(paramArrayList);
  }

  public String getSelectBy()
  {
    return this.strSelQuery;
  }

  public void selectBy(String paramString)
  {
    this.strSelQuery = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.dbm.Dbtable
 * JD-Core Version:    0.6.0
 */