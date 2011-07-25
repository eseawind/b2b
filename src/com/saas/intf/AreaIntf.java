package com.saas.intf;

import com.saas.biz.AreaInfoMgr.AreaInfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.PrintStream;
import java.util.ArrayList;

public class AreaIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  AreaInfo areaInfo = new AreaInfo();

  public ArrayList getAreaByParentTag(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.areaInfo.getAreaByParentByCMS(paramString1);
    return localArrayList;
  }

  public ArrayList getAreaExistCustomer()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.areaInfo.getAreaExistCustomer();
    return localArrayList;
  }

  public static void main(String[] paramArrayOfString)
    throws SaasApplicationException
  {
    AreaIntf localAreaIntf = new AreaIntf();
    ArrayList localArrayList = localAreaIntf.getAreaByParentTag("5J2mc0X0G85BH", "");
    System.out.println("----" + localArrayList);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.AreaIntf
 * JD-Core Version:    0.6.0
 */