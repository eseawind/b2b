package com.saas.intf;

import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class AttachIntf
{
  Logger log = new Logger(this);
  commMethodMgr comm = new commMethodMgr();
  Attachinfo attachMgr = new Attachinfo();

  public String getFilePathInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = this.attachMgr.getFilePath(paramString);
    String str1 = "";
    String str2 = "";
    if (localArrayList != null)
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("file_path") != null)
        {
          str2 = localHashMap.get("file_path").toString();
          str1 = str1 + "<img src=" + str2 + " width=50 height=40 style=\"filter:alpha(opacity=70)\" onclick=changeImg(this) onMouseOver=makevisible(this,0) onMouseOut=makevisible(this,1) style=\"cursor:hand;\">&nbsp;";
        }
        if (i == 4)
          break;
      }
    return str1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.intf.AttachIntf
 * JD-Core Version:    0.6.0
 */