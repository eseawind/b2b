package com.saas.biz.pricerankMgr;

import java.util.ArrayList;
import java.util.HashMap;

public class JoinListTool
{
  public static ArrayList joinList(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((null != paramArrayList1) && (paramArrayList1.size() > 0))
    {
      if ((null != paramArrayList2) && (paramArrayList2.size() > 0))
      {
        for (int i = 0; i < paramArrayList2.size(); i++)
        {
          HashMap localHashMap = (HashMap)paramArrayList2.get(i);
          paramArrayList1.add(localHashMap);
        }
        return paramArrayList1;
      }
      return paramArrayList1;
    }
    return paramArrayList2;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.pricerankMgr.JoinListTool
 * JD-Core Version:    0.6.0
 */