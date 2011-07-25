package com.saas.intf;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.infoClassMgr.InfoClassinfo;
import com.saas.biz.infoListMgr.InfoList;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class InfoIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  InfoList InfoMgr = new InfoList();

  public HashMap getInfoDetail(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    localHashMap = this.InfoMgr.getCastById(paramString);
    return localHashMap;
  }

  public ArrayList getInfoList(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoList(paramInt1, paramInt2, paramString);
    return localArrayList;
  }

  public ArrayList getInfoListByClassIdByLimit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByClassIdByLimit(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    return localArrayList;
  }

  public ArrayList getCustClassByCustId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getCustClassByCustId(paramString1, paramString2);
    return localArrayList;
  }

  public ArrayList getCustClassByCustIdClassId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getCustClassByCustIdClassId(paramString1, paramString2, paramString3);
    return localArrayList;
  }

  public int getInfoCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    i = this.InfoMgr.getInfoListCount(paramString);
    return i;
  }

  public int getInfoCountByChId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    i = this.InfoMgr.getInfoListCountByChId(paramString1, paramString2);
    return i;
  }

  public int getCustInfoCountByChId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    i = this.InfoMgr.getCustInfoListCountByChId(paramString1, paramString2, paramString3);
    return i;
  }

  public ArrayList getInfoListByIndate(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByIndate(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5);
    return localArrayList;
  }

  public ArrayList getInfoListByHot(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByHot(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5);
    return localArrayList;
  }

  public ArrayList getInfoListByPublevel(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByPublevel(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4);
    return localArrayList;
  }

  public ArrayList getInfoListByAreaCode(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByAreaCode(paramInt1, paramInt2, paramString1, paramString2);
    return localArrayList;
  }

  public ArrayList getInfoListByAreaCode(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByAreaCode(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    return localArrayList;
  }

  public int getInfoListByClassId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByClassId(paramString1, paramString2, paramString3);
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getInfoListByClassIdByList(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByClassId(paramString1, paramString2, paramString3);
    return localArrayList;
  }

  public String getChannelSaveDirByInfoId(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    str = this.InfoMgr.getChannelSaveDirByInfoId(paramString);
    return str;
  }

  public ArrayList getInfoListByAllNews(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByAllNews(paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getCustInfoListByAllNews(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getCustInfoListByAllNews(paramInt1, paramInt2, paramString);
    return localArrayList;
  }

  public ArrayList getCustInfoListByIndex(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getCustInfoListByIndex(paramInt1, paramInt2, paramString1, paramString2);
    return localArrayList;
  }

  public ArrayList getInfoListByContmod(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByContmod(paramString1, paramString2);
    return localArrayList;
  }

  public ArrayList getInfoListByInfoIdContMod(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByInfoIdContMod(paramString1, paramString2);
    return localArrayList;
  }

  public ArrayList getInfoListByInfoIdContMod(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByInfoIdContMod(paramString1, paramString2, paramString3);
    return localArrayList;
  }

  public ArrayList getInfoListByContmod(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.InfoMgr.getInfoListByContmod(paramString1, paramString2, paramString3);
    return localArrayList;
  }

  public String getChannelStringByInfoId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ChannelIntf localChannelIntf = new ChannelIntf();
    String str1 = "";
    String str2 = "";
    HashMap localHashMap = getInfoDetail(paramString1);
    if (localHashMap.get("ch_id") != null)
    {
      str1 = localHashMap.get("ch_id").toString();
      str2 = localChannelIntf.getChStringInfo(str1, paramString2);
    }
    return str2;
  }

  public String getClassStringByInfoId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    InfoClassinfo localInfoClassinfo = new InfoClassinfo();
    String str1 = "";
    String str2 = localInfoClassinfo.getInfoClassByInfoId(paramString1);
    String[] arrayOfString = str2.split("\\|");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if ((arrayOfString[i].equals("000000000000000")) || (arrayOfString[i].equals("")))
        continue;
      if (paramString3.equals("0"))
        str1 = str1 + localInfoClassinfo.getProductNameByIdx(arrayOfString[i]) + "--";
      else
        str1 = str1 + "&nbsp;<a href=/" + paramString2 + "/class/" + arrayOfString[i] + ">" + localInfoClassinfo.getProductNameByIdx(arrayOfString[i]) + "</a>&nbsp;&gt;";
    }
    return str1;
  }

  public String getAreaStringByCustId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    CustIntf localCustIntf = new CustIntf();
    return localCustIntf.getAreaStringByCustId(paramString1, paramString2, paramString3);
  }

  public String getClassInfoNumByClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str = "";
    str = this.InfoMgr.getClassInfoNumByClassId(paramString1, paramString2);
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.InfoIntf
 * JD-Core Version:    0.6.0
 */