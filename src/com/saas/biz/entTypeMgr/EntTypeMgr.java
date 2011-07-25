package com.saas.biz.entTypeMgr;

import com.saas.biz.dao.commenDAO.EnttypeExt;
import com.saas.sys.exp.SaasApplicationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EntTypeMgr
{
  public ArrayList EntArrayList()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    String str1 = "";
    int i = 1;
    str1 = "<div class=liebiao1>";
    localArrayList2 = GetArrayList2("2");
    if (localArrayList2 != null)
    {
      Iterator localIterator1 = localArrayList2.iterator();
      while (localIterator1.hasNext())
      {
        HashMap localHashMap2 = (HashMap)localIterator1.next();
        String str2 = "";
        String str3 = "";
        str2 = localHashMap2.get("ent_id").toString();
        str3 = localHashMap2.get("ent_name").toString();
        str1 = str1 + "<div id=leftSortBody><h1><img src=images/chinannn_f.gif>" + str3 + "</h1>";
        localArrayList3 = GetArrayList("3", str2);
        if (localArrayList3 != null)
        {
          Iterator localIterator2 = localArrayList3.iterator();
          while (localIterator2.hasNext())
          {
            HashMap localHashMap3 = (HashMap)localIterator2.next();
            String str4 = "";
            String str5 = "";
            str4 = localHashMap3.get("ent_id").toString();
            str5 = localHashMap3.get("ent_name").toString();
            str1 = str1 + str5 + "|";
          }
        }
        str1 = str1 + "</div>";
        if (i == 3)
        {
          str1 = str1 + "</div>";
          str1 = str1 + "<div class=liebiao1>";
          i = 1;
        }
        else if ((i < 3) && (!localIterator1.hasNext()))
        {
          str1 = str1 + "</div>";
          i = 1;
        }
        else
        {
          i += 1;
        }
      }
    }
    localArrayList4.add(str1);
    return localArrayList4;
  }

  public ArrayList GetArrayList2(String paramString)
    throws SaasApplicationException
  {
    EnttypeExt localEnttypeExt = new EnttypeExt();
    ArrayList localArrayList = new ArrayList();
    localEnttypeExt.setParam(":VENT_LEVEL", paramString);
    localEnttypeExt.setParam(":VENT_TYPE", "0");
    localArrayList = localEnttypeExt.selByList("SEL_BY_LEVEL2");
    return localArrayList;
  }

  public ArrayList GetArrayList(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    EnttypeExt localEnttypeExt = new EnttypeExt();
    ArrayList localArrayList = new ArrayList();
    localEnttypeExt.setParam(":VENT_LEVEL", paramString1);
    localEnttypeExt.setParam(":VUP_ENT_ID", paramString2);
    localEnttypeExt.setParam(":VENT_TYPE", "0");
    localArrayList = localEnttypeExt.selByList("SEL_BY_LEVEL");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.entTypeMgr.EntTypeMgr
 * JD-Core Version:    0.6.0
 */