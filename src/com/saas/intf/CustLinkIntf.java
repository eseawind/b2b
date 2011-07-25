package com.saas.intf;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.custlinkMgr.CustlinkInfo;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class CustLinkIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  CustlinkInfo linkInfo = new CustlinkInfo();

  public ArrayList getLinkListByPage(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.linkInfo.getLinkListByPage(paramInt1, paramInt2, paramString);
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.CustLinkIntf
 * JD-Core Version:    0.6.0
 */