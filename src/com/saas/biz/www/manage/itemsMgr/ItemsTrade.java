package com.saas.biz.www.manage.itemsMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.itemsDAO.LmxxbExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;

public class ItemsTrade
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  commMethodMgr commen = new commMethodMgr();

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

  public void AddItemsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入AddItemsInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    String str1 = paramBuffers.getString("LMJB");
    String str2 = paramBuffers.getString("LMMC");
    String str3 = paramBuffers.getString("MODELFILE");
    String str4 = paramBuffers.getString("SJLMBS");
    String str5 = paramBuffers.getString("DISPLAYRAGE");
    String str6 = paramBuffers.getString("SHOWFIRST");
    String str7 = paramBuffers.getString("STAFF_ID");
    String str8 = paramBuffers.getString("REALPATH");
    String str9 = paramBuffers.getString("UPLOADFILEDIR");
    int i = -1;
    try
    {
      i = AddItemsInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
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
    this.log.LOG_INFO("退出AddItemsInfo方法...");
  }

  private int AddItemsInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    throws SaasApplicationException
  {
    LmxxbExt localLmxxbExt = new LmxxbExt();
    String str1 = this.commen.GenTradeId();
    String str2 = paramString8 + "\\www\\web\\" + paramString3;
    String str3 = "./www/web/";
    if ((paramString3 != null) && (paramString3 != ""))
      this.commen.copyFile(paramString9 + paramString3, str2);
    try
    {
      localLmxxbExt.setParam(":VLMBS", str1);
      localLmxxbExt.setParam(":VLMJB", paramString1);
      localLmxxbExt.setParam(":VLMMC", paramString2);
      localLmxxbExt.setParam(":VMBWJM", paramString3);
      localLmxxbExt.setParam(":VMBWJLJ", str3);
      localLmxxbExt.setParam(":VSJLMBS", paramString4);
      localLmxxbExt.setParam(":VXSSX", paramString5);
      localLmxxbExt.setParam(":VCZYGH", paramString7);
      localLmxxbExt.setParam(":VBZ", paramString6);
      this.tradeQuery.executeBy(localLmxxbExt.insBy("INS_BY_ALL"));
    }
    catch (Exception localException)
    {
      throw new RuntimeException("新增栏目信息出错！" + localException);
    }
    int i = new Integer(paramString1).intValue() - 1;
    paramString1 = String.valueOf(i);
    this.outBuffer.setString("LMJB", paramString1);
    return 0;
  }

  public void ModifyItemsInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入ModifyItemsInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    String str1 = paramBuffers.getString("LMMC");
    String str2 = paramBuffers.getString("LMJB");
    String str3 = paramBuffers.getString("LMBS");
    String str4 = paramBuffers.getString("MODELFILE");
    String str5 = paramBuffers.getString("DISPLAYRAGE");
    String str6 = paramBuffers.getString("SHOWFIRST");
    String str7 = paramBuffers.getString("STAFF_ID");
    String str8 = paramBuffers.getString("REALPATH");
    String str9 = paramBuffers.getString("UPLOADFILEDIR");
    int i = -1;
    try
    {
      i = ModifyItemsInfo(str3, str1, str4, str5, str6, str7, str8, str9);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
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
    int j = new Integer(str2).intValue() - 1;
    str2 = String.valueOf(j);
    this.outBuffer.setString("LMJB", str2);
    this.log.LOG_INFO("退出ModifyItemsInfo方法...");
  }

  private int ModifyItemsInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws SaasApplicationException
  {
    LmxxbExt localLmxxbExt = new LmxxbExt();
    String str1 = paramString7 + "\\www\\web\\" + paramString3;
    String str2 = "./www/web/";
    try
    {
      if (!paramString3.equalsIgnoreCase(""))
      {
        this.commen.copyFile(paramString8 + paramString3, str1);
        localLmxxbExt.setParam(":VLMBS", paramString1);
        localLmxxbExt.setParam(":VLMMC", paramString2);
        localLmxxbExt.setParam(":VMBWJM", paramString3);
        localLmxxbExt.setParam(":VMBWJLJ", str2);
        localLmxxbExt.setParam(":VXSSX", paramString4);
        localLmxxbExt.setParam(":VBZ", paramString5);
        this.tradeQuery.executeBy(localLmxxbExt.insBy("UP_BY_PK1"));
      }
      else
      {
        localLmxxbExt.setParam(":VLMBS", paramString1);
        localLmxxbExt.setParam(":VLMMC", paramString2);
        localLmxxbExt.setParam(":VXSSX", paramString4);
        localLmxxbExt.setParam(":VBZ", paramString5);
        this.tradeQuery.executeBy(localLmxxbExt.insBy("UP_BY_PK2"));
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException("修改栏目信息出错！" + localException);
    }
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.www.manage.itemsMgr.ItemsTrade
 * JD-Core Version:    0.6.0
 */