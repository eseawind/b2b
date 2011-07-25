package com.saas.intf;

import com.saas.biz.advertiseMgr.AdvertiseInfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class AdvertiseIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  AdvertiseInfo advMgr = new AdvertiseInfo();

  public HashMap getInfoByCustAdvId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.advMgr.getInfoByCustAdvId(paramString);
    HashMap localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.AdvertiseIntf
 * JD-Core Version:    0.6.0
 */