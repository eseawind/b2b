package com.saas.intf;

import com.saas.biz.AreaInfoMgr.AreaInfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.custMgr.Custinfo;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class CustIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  Custinfo custInfo = new Custinfo();

  public HashMap getCustInfo(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = this.custInfo.getCustInfoLinkInfoList(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public String getAreaStringByCustId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    AreaInfo localAreaInfo = new AreaInfo();
    ArrayList localArrayList = this.custInfo.getCustInfo(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("province") != null)
      {
        str2 = localHashMap.get("province").toString();
        str5 = localAreaInfo.getAreaName(str2);
      }
      if (localHashMap.get("eparchy_code") != null)
      {
        str3 = localHashMap.get("eparchy_code").toString();
        str6 = localAreaInfo.getAreaName(str3);
      }
      if (localHashMap.get("city") != null)
      {
        str4 = localHashMap.get("city").toString();
        str7 = localAreaInfo.getAreaName(str4);
      }
    }
    if (!str5.equals(""))
      if (paramString3.equals("0"))
        str1 = str1 + str5 + "--";
      else
        str1 = str1 + "&nbsp;<a href=/" + paramString2 + "/area/" + str2 + ">" + str5 + "</a>&nbsp;&gt;";
    if (!str6.equals(""))
      if (paramString3.equals("0"))
        str1 = str1 + str6 + "--";
      else
        str1 = str1 + "&nbsp;<a href=/" + paramString2 + "/area/" + str3 + ">" + str6 + "</a>&nbsp;&gt;";
    if (!str7.equals(""))
      if (paramString3.equals("0"))
        str1 = str1 + str7 + "--";
      else
        str1 = str1 + "&nbsp;<a href=/" + paramString2 + "/area/" + str4 + ">" + str7 + "</a>&nbsp;&gt;";
    return str1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.CustIntf
 * JD-Core Version:    0.6.0
 */