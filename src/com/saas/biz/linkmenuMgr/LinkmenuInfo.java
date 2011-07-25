package com.saas.biz.linkmenuMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.linkmenuDAO.LinkmenuExt;
import com.saas.biz.rightMgr.TradeInterface;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LinkmenuInfo
{
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr comm = new commMethodMgr();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void addLinkmenuInfo(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addLinkmenuInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("MENU_ID");
    String str2 = paramBuffers.getString("LINK_MENU_ID");
    String str3 = paramBuffers.getString("LINK_NAME");
    String str4 = paramBuffers.getString("LINK_DESC");
    StringTokenizer localStringTokenizer1 = new StringTokenizer(str2, "|");
    StringTokenizer localStringTokenizer2 = new StringTokenizer(str3, "|");
    StringTokenizer localStringTokenizer3 = new StringTokenizer(str4, "|");
    String str5 = "";
    String str6 = "";
    String str7 = "";
    while (localStringTokenizer1.hasMoreTokens())
    {
      str5 = localStringTokenizer1.nextToken();
      str6 = localStringTokenizer2.nextToken();
      str7 = localStringTokenizer3.nextToken();
      i = addLinkmenuInfo(str1, str5, str6, str7);
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addLinkmenuInfo方法...");
  }

  public int addLinkmenuInfo(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    LinkmenuExt localLinkmenuExt = new LinkmenuExt();
    localLinkmenuExt.setParam(":VMENU_ID", paramString1);
    localLinkmenuExt.setParam(":VLINK_MENU_ID", paramString2);
    localLinkmenuExt.setParam(":VLINK_NAME", paramString3);
    localLinkmenuExt.setParam(":VLINK_DESC", paramString4);
    this.tradeQuery.executeBy(localLinkmenuExt.insBy("INS_LINKMENU_INFO"));
    return 0;
  }

  public void delLinkMenu(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delLinkMenu方法...");
    int i = -1;
    String str1 = paramBuffers.getString("MENU_ID");
    String str2 = paramBuffers.getString("LINK_MENU_ID");
    i = delLinkMenu(str1, str2);
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出delLinkMenu方法...");
  }

  public int delLinkMenu(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    LinkmenuExt localLinkmenuExt = new LinkmenuExt();
    localLinkmenuExt.setParam(":VMENU_ID", paramString1);
    localLinkmenuExt.setParam(":VLINK_MENU_ID", paramString2);
    this.tradeQuery.executeBy(localLinkmenuExt.insBy("DEL_LINKMENU_INFO"));
    return 0;
  }

  public String getLinkMenuByMenuId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    LinkmenuExt localLinkmenuExt = new LinkmenuExt();
    localLinkmenuExt.setParam(":VMENU_ID", paramString);
    localArrayList1 = localLinkmenuExt.selByList("SEL_BY_LINKMENU");
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)localArrayList1.get(i);
        if (localHashMap1.get("link_menu_id") != null)
          str2 = localHashMap1.get("link_menu_id").toString();
        if (localHashMap1.get("link_name") != null)
          str3 = localHashMap1.get("link_name").toString();
        if (localHashMap1.get("link_desc") != null)
          str4 = localHashMap1.get("link_desc").toString();
        TradeInterface localTradeInterface = new TradeInterface();
        ArrayList localArrayList2 = localTradeInterface.genTradeInterface(str2);
        HashMap localHashMap2 = (HashMap)localArrayList2.get(0);
        String str5 = "";
        int j = 0;
        if (localHashMap2.get("interfacedir") != null)
          str5 = localHashMap2.get("interfacedir").toString();
        if (!str5.equals(""))
        {
          String[] arrayOfString = str5.split("");
          int k = 0;
          for ( k = 0; (k < arrayOfString.length) && (!arrayOfString[k].equals("?")); k++);
          str5 = str5.substring(0, k - 1);
        }
        str1 = str1 + "&nbsp;&nbsp;<a href=../../" + str5 + " title=" + str4 + " target=_blank>" + str3 + "</a>&nbsp;&nbsp;】【";
      }
    return str1;
  }

  public ArrayList getLinkMenuById(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    LinkmenuExt localLinkmenuExt = new LinkmenuExt();
    localLinkmenuExt.setParam(":VMENU_ID", paramString);
    localArrayList = localLinkmenuExt.selByList("SEL_BY_LINKMENU");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.linkmenuMgr.LinkmenuInfo
 * JD-Core Version:    0.6.0
 */