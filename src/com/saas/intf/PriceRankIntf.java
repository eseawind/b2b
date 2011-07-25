package com.saas.intf;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.pricerankMgr.PriceRankInfo;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class PriceRankIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  PriceRankInfo priceMgr = new PriceRankInfo();

  public ArrayList getPriceRankByChId(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.priceMgr.getPriceRankByChId(paramString, "1", paramInt);
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.PriceRankIntf
 * JD-Core Version:    0.6.0
 */