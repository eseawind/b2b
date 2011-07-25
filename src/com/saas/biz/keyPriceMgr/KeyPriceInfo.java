package com.saas.biz.keyPriceMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.keyPriceDAO.KeyPriceDAO;
import com.saas.biz.dao.keyPriceDAO.KeyPriceExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class KeyPriceInfo
{
  Dbtable tradeQuery = new Dbtable();
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

  public void addkeyPriceInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("KEY_LOCATION");
    String str2 = paramBuffers.getString("KEY_PRICE");
    String str3 = paramBuffers.getString("REMARK");
    KeyPriceDAO localKeyPriceDAO = new KeyPriceDAO();
    localKeyPriceDAO.setKey_location(str1);
    localKeyPriceDAO.setKey_price(str2);
    localKeyPriceDAO.setRemark(str3);
    try
    {
      i = addkeyPriceInfo(localKeyPriceDAO);
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
  }

  public int addkeyPriceInfo(KeyPriceDAO paramKeyPriceDAO)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str = localcommMethodMgr.GenTradeId();
    KeyPriceExt localKeyPriceExt = new KeyPriceExt();
    localKeyPriceExt.setParam(":VTRADE_ID", str);
    localKeyPriceExt.setParam(":VKEY_LOCATION", paramKeyPriceDAO.getKey_location());
    localKeyPriceExt.setParam(":VKEY_PRICE", paramKeyPriceDAO.getKey_price());
    localKeyPriceExt.setParam(":VREMARK", paramKeyPriceDAO.getRemark());
    this.tradeQuery.executeBy(localKeyPriceExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void modkeyPriceInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    String str2 = paramBuffers.getString("KEY_LOCATION");
    String str3 = paramBuffers.getString("KEY_PRICE");
    String str4 = paramBuffers.getString("REMARK");
    KeyPriceDAO localKeyPriceDAO = new KeyPriceDAO();
    localKeyPriceDAO.setTrade_id(str1);
    localKeyPriceDAO.setKey_location(str2);
    localKeyPriceDAO.setKey_price(str3);
    localKeyPriceDAO.setRemark(str4);
    try
    {
      i = modkeyPriceInfo(localKeyPriceDAO);
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
  }

  public int modkeyPriceInfo(KeyPriceDAO paramKeyPriceDAO)
    throws SaasApplicationException
  {
    KeyPriceExt localKeyPriceExt = new KeyPriceExt();
    localKeyPriceExt.setParam(":VTRADE_ID", paramKeyPriceDAO.getTrade_id());
    localKeyPriceExt.setParam(":VKEY_LOCATION", paramKeyPriceDAO.getKey_location());
    localKeyPriceExt.setParam(":VKEY_PRICE", paramKeyPriceDAO.getKey_price());
    localKeyPriceExt.setParam(":VREMARK", paramKeyPriceDAO.getRemark());
    this.tradeQuery.executeBy(localKeyPriceExt.insBy("MOD_BY_TRADE_ID"));
    return 0;
  }

  public void delkeyPriceInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("TRADE_ID");
    KeyPriceDAO localKeyPriceDAO = new KeyPriceDAO();
    localKeyPriceDAO.setTrade_id(str);
    try
    {
      i = delkeyPriceInfo(localKeyPriceDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "删除处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "删除处理成功！");
    }
  }

  public void DeletePriceInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeletePriceInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        KeyPriceDAO localKeyPriceDAO = new KeyPriceDAO();
        localKeyPriceDAO.setTrade_id(str2);
        i = delkeyPriceInfo(localKeyPriceDAO);
      }
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
    this.log.LOG_INFO("退出DeletePriceInfo方法...");
  }

  public int delkeyPriceInfo(KeyPriceDAO paramKeyPriceDAO)
    throws SaasApplicationException
  {
    KeyPriceExt localKeyPriceExt = new KeyPriceExt();
    localKeyPriceExt.setParam(":VTRADE_ID", paramKeyPriceDAO.getTrade_id());
    this.tradeQuery.executeBy(localKeyPriceExt.insBy("DEL_BY_TRADE_ID"));
    return 0;
  }

  public ArrayList getAllKeyPriceList()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    KeyPriceExt localKeyPriceExt = new KeyPriceExt();
    localArrayList = localKeyPriceExt.selByList("SEL_BY_ALL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getKeyPriceInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    KeyPriceExt localKeyPriceExt = new KeyPriceExt();
    localKeyPriceExt.setParam(":VKEY_LOCATION", paramString);
    localArrayList = localKeyPriceExt.selByList("SEL_BY_KEY_LOCATION");
    return localArrayList;
  }

  public String getKeylocationPrice(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    KeyPriceExt localKeyPriceExt = new KeyPriceExt();
    localKeyPriceExt.setParam(":VKEY_LOCATION", paramString);
    localArrayList = localKeyPriceExt.selByList("SEL_BY_KEY_LOCATION");
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("key_price") != null)
        str = localHashMap.get("key_price").toString();
    }
    return str;
  }

  public String getKeyPriceList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    KeyPriceExt localKeyPriceExt = new KeyPriceExt();
    localKeyPriceExt.setParam(":VKEY_LOCATION", paramString);
    localArrayList = localKeyPriceExt.selByList("SEL_BY_KEY_LOCATION");
    if (localArrayList != null)
      return "Is not empty!";
    return "";
  }

  public ArrayList getKeyPriceInfoById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    KeyPriceExt localKeyPriceExt = new KeyPriceExt();
    localKeyPriceExt.setParam(":VTRADE_ID", paramString);
    localArrayList = localKeyPriceExt.selByList("SEL_INFO_BY_TRADE_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.keyPriceMgr.KeyPriceInfo
 * JD-Core Version:    0.6.0
 */