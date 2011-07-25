package com.saas.intf;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.newsMgr.NewsInfo;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class NewsIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  NewsInfo newsMgr = new NewsInfo();

  public ArrayList getNewsInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.newsMgr.getNewsById(paramString);
    return localArrayList;
  }

  public HashMap getNewsDetail(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    localArrayList = this.newsMgr.getNewsById(paramString);
    if (localArrayList != null)
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getNewsList(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.newsMgr.getNewsByPage(paramInt1, paramInt2, paramString);
    return localArrayList;
  }

  public int getNewsCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    i = this.newsMgr.getNewsCountByTypeCount(paramString);
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.NewsIntf
 * JD-Core Version:    0.6.0
 */