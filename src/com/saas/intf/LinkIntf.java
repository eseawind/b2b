package com.saas.intf;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.indexLinkMgr.IndexlinkInfo;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class LinkIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  IndexlinkInfo linkInfo = new IndexlinkInfo();

  public ArrayList getLinkListByPage(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.linkInfo.getLinkListByPage(paramInt1, paramInt2);
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.LinkIntf
 * JD-Core Version:    0.6.0
 */