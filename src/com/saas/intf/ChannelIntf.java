package com.saas.intf;

import com.saas.biz.channelMgr.ChannelInfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ChannelIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  ChannelInfo channelinfo = new ChannelInfo();
  String ch_str = "";

  public ArrayList getChannelInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.channelinfo.getChannelList();
    return localArrayList;
  }

  public ArrayList getChInfoSelf(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.channelinfo.getChInfoSelf(paramString1, paramString2, paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getChInfoSon(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.channelinfo.getChInfoSon(paramString1, paramString2, paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getChannelList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.channelinfo.getChannel(paramString);
    return localArrayList;
  }

  public ArrayList getChInfoNext(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.channelinfo.getChInfoNext(paramString1, paramString2, Integer.parseInt(paramString3));
    return localArrayList;
  }

  public HashMap getChInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    localArrayList = this.channelinfo.getChannel(paramString);
    if (localArrayList != null)
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public String getSaveDirByChLevelAndContMod(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.channelinfo.getSaveDirByChLevelAndContMod(paramString1, paramString2);
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("save_dir") != null)
        str = localHashMap.get("save_dir").toString();
    }
    return str;
  }

  public String getChStringInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    String str1 = "";
    String str2 = "";
    localArrayList = this.channelinfo.getChannel(paramString1);
    if (localArrayList != null)
    {
      localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ch_level") != null)
        str2 = localHashMap.get("ch_level").toString();
      if (localHashMap.get("ch_name") != null)
      {
        if (str2.equals("1"))
        {
          if (paramString2.equals("0"))
            str1 = localHashMap.get("ch_name").toString() + "--";
          else
            str1 = "<a href=/" + localHashMap.get("save_dir").toString() + "/ >" + localHashMap.get("ch_name").toString() + "</a> &gt; ";
        }
        else if (paramString2.equals("0"))
          str1 = localHashMap.get("ch_name").toString() + "--";
        else
          str1 = "<a href=/" + localHashMap.get("save_dir").toString() + "/list/ >" + localHashMap.get("ch_name").toString() + "</a> &gt; ";
        this.ch_str = (str1 + this.ch_str);
      }
      if (localHashMap.get("up_ch_id") != null)
        getChStringInfo(localHashMap.get("up_ch_id").toString(), paramString2);
    }
    return this.ch_str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.ChannelIntf
 * JD-Core Version:    0.6.0
 */