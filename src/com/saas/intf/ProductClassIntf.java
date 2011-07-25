package com.saas.intf;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.productclassMgr.Productclass;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class ProductClassIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  Productclass productclassMgr = new Productclass();

  public ArrayList getProductClassList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.productclassMgr.getClassInfoByUpClassId(paramString1, "000000000000000");
    return localArrayList;
  }

  public ArrayList getProductClassByUpId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.productclassMgr.getClassInfoByUpClassId(paramString);
    return localArrayList;
  }

  public ArrayList getProductClassByUpIdPage(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.productclassMgr.getClassInfoByUpClassIdPage(paramInt1, paramInt2, paramString);
    return localArrayList;
  }

  public ArrayList getProductClassList(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.productclassMgr.getClassInfoByUpClassId(paramInt1, paramInt2, paramString1, paramString2);
    return localArrayList;
  }

  public ArrayList getProductAllClassIdByUp(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.productclassMgr.getClassInfoByUpClassId(paramString2, paramString1);
    return localArrayList;
  }

  public ArrayList getClassInfoByClassType(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.productclassMgr.getClassInfoByClassType(paramString);
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.ProductClassIntf
 * JD-Core Version:    0.6.0
 */