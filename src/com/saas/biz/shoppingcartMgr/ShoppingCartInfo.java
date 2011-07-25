package com.saas.biz.shoppingcartMgr;

import com.saas.biz.dao.shoppingcartDAO.ShoppingCartDAO;
import com.saas.biz.dao.shoppingcartDAO.ShoppingCartExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ShoppingCartInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
  ArrayList queryResult = new ArrayList();

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void addShoppingCartInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addShoppingCartInfo方法....");
    this.outBuffer = paramBuffers;
    ShoppingCartDAO localShoppingCartDAO = new ShoppingCartDAO();
    localShoppingCartDAO.setCust_id(paramBuffers.getString("CUST_ID"));
    localShoppingCartDAO.setTrade_id(paramBuffers.getString("TRADE_ID"));
    localShoppingCartDAO.setSale_id(paramBuffers.getString("SALE_ID"));
    localShoppingCartDAO.setPrice(paramBuffers.getString("PRICE"));
    localShoppingCartDAO.setNum(paramBuffers.getString("NUM"));
    localShoppingCartDAO.setDiscount(paramBuffers.getString("DISCOUNT"));
    localShoppingCartDAO.setUser_id(paramBuffers.getString("USER_ID"));
    localShoppingCartDAO.setOper_date(paramBuffers.getString("OPER_DATE"));
    localShoppingCartDAO.setOper_user_id(paramBuffers.getString("SESSION_USER_ID"));
    localShoppingCartDAO.setIn_date(paramBuffers.getString("IN_DATE"));
    localShoppingCartDAO.setRemark(paramBuffers.getString("REMARK"));
    int i = -1;
    try
    {
      i = addShoppingCartInfo(localShoppingCartDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
      this.outBuffer.setInt("RESULT_CODE", -1);
    else
      this.outBuffer.setInt("RESULT_CODE", 0);
    this.log.LOG_INFO("退出addShoppingCartInfo方法...");
  }

  public int addShoppingCartInfo(ShoppingCartDAO paramShoppingCartDAO)
    throws SaasApplicationException
  {
    ShoppingCartExt localShoppingCartExt = new ShoppingCartExt();
    String str1 = paramShoppingCartDAO.getSale_id();
    String str2 = paramShoppingCartDAO.getUser_id();
    localShoppingCartExt.setParam(":VCUST_ID", paramShoppingCartDAO.getCust_id());
    localShoppingCartExt.setParam(":VTRADE_ID", paramShoppingCartDAO.getTrade_id());
    localShoppingCartExt.setParam(":VSALE_ID", paramShoppingCartDAO.getSale_id());
    localShoppingCartExt.setParam(":VPRICE", paramShoppingCartDAO.getPrice());
    localShoppingCartExt.setParam(":VNUM", paramShoppingCartDAO.getNum());
    localShoppingCartExt.setParam(":VDISCOUNT", paramShoppingCartDAO.getDiscount());
    localShoppingCartExt.setParam(":VUSER_ID", paramShoppingCartDAO.getUser_id());
    localShoppingCartExt.setParam(":VOPER_DATE", paramShoppingCartDAO.getOper_date());
    localShoppingCartExt.setParam(":VOPER_USER_ID", paramShoppingCartDAO.getOper_user_id());
    localShoppingCartExt.setParam(":VIN_DATE", paramShoppingCartDAO.getIn_date());
    localShoppingCartExt.setParam(":VREMARK", paramShoppingCartDAO.getRemark());
    if (checkright(str1, str2) == 0)
      this.tradeQuery.executeBy(localShoppingCartExt.insBy("INS_BY_SHOPPING"));
    else
      this.tradeQuery.executeBy(localShoppingCartExt.insBy("UPDATE_BY_SHOPPING"));
    return 0;
  }

  public int checkright(String paramString1, String paramString2)
  {
    ShoppingCartExt localShoppingCartExt = new ShoppingCartExt();
    ArrayList localArrayList = new ArrayList();
    localShoppingCartExt.setParam(":VSALE_ID", paramString1);
    localShoppingCartExt.setParam(":VUSER_ID", paramString2);
    localArrayList = localShoppingCartExt.selByList("SEL_BY_THREE_ID");
    if (localArrayList == null)
      return 0;
    return 1;
  }

  public ArrayList getMerchandiseByCart(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingCartExt localShoppingCartExt = new ShoppingCartExt();
    localShoppingCartExt.setParam(":VUSER_ID", paramString);
    localArrayList = localShoppingCartExt.selByList("SEL_M_BY_USER_ID");
    return localArrayList;
  }

  public void delshopinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delshopinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("TRADE_ID");
    try
    {
      ShoppingCartDAO localShoppingCartDAO = new ShoppingCartDAO();
      localShoppingCartDAO.setTrade_id(str);
      i = delshopinfo(localShoppingCartDAO);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
      this.outBuffer.setInt("RESULT_CODE", -1);
    else
      this.outBuffer.setInt("RESULT_CODE", 0);
    this.log.LOG_INFO("退出delshopinfo方法...");
  }

  public int delshopinfo(ShoppingCartDAO paramShoppingCartDAO)
    throws SaasApplicationException
  {
    ShoppingCartExt localShoppingCartExt = new ShoppingCartExt();
    localShoppingCartExt.setParam(":VTRADE_ID", paramShoppingCartDAO.getTrade_id());
    this.tradeQuery.executeBy(localShoppingCartExt.insBy("DEL_BY_TRADE_ID"));
    return 0;
  }

  public void deleteshopinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteshopinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("TRADE_IDS");
    try
    {
      i = deleteshopinfo(str);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
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
    this.log.LOG_INFO("退出deleteshopinfo方法...");
  }

  public int deleteshopinfo(String paramString)
    throws SaasApplicationException
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str = localStringTokenizer.nextToken();
      ShoppingCartExt localShoppingCartExt = new ShoppingCartExt();
      localShoppingCartExt.setParam(":VTRADE_ID", str);
      this.log.LOG_INFO("SQL==============" + localShoppingCartExt.insBy("DEL_BY_TRADE_ID"));
      this.tradeQuery.executeBy(localShoppingCartExt.insBy("DEL_BY_TRADE_ID"));
    }
    return 0;
  }

  public void modishopinfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入modishopinfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    String str2 = paramBuffers.getString("NUM");
    StringTokenizer localStringTokenizer1 = new StringTokenizer(str1, "|");
    StringTokenizer localStringTokenizer2 = new StringTokenizer(str2, "|");
    String str3 = "";
    String str4 = "";
    try
    {
      while (localStringTokenizer1.hasMoreTokens())
      {
        str3 = localStringTokenizer1.nextToken();
        str4 = localStringTokenizer2.nextToken();
        i = modishopinfo(str3, str4);
      }
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
      this.outBuffer.setInt("RESULT_CODE", -1);
    else
      this.outBuffer.setInt("RESULT_CODE", 0);
    this.log.LOG_INFO("退出modishopinfo方法...");
  }

  public int modishopinfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ShoppingCartExt localShoppingCartExt = new ShoppingCartExt();
    localShoppingCartExt.setParam(":VTRADE_ID", paramString1);
    localShoppingCartExt.setParam(":VNUM", paramString2);
    this.tradeQuery.executeBy(localShoppingCartExt.insBy("UP_BY_TRADE_ID"));
    return 0;
  }

  public int delShopCart(String paramString)
    throws SaasApplicationException
  {
    ShoppingCartExt localShoppingCartExt = new ShoppingCartExt();
    localShoppingCartExt.setParam(":VTRADE_ID", paramString);
    this.tradeQuery.executeBy(localShoppingCartExt.insBy("DEL_BY_TRADE_ID"));
    return 0;
  }

  public ArrayList getOrderList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ShoppingCartExt localShoppingCartExt = new ShoppingCartExt();
    localShoppingCartExt.setParam(":VUSER_ID", paramString);
    localArrayList = localShoppingCartExt.selByList("SEL_BY_USER_ID", paramInt, 20);
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.shoppingcartMgr.ShoppingCartInfo
 * JD-Core Version:    0.6.0
 */