package com.saas.biz.shoppingorderMgr;

import com.saas.biz.dao.shoppingorderDAO.ShoppingOrderDAO;
import com.saas.biz.dao.shoppingorderDAO.ShoppingOrderExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ShoppingOrderInfo
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

  public void addShoppingOrderInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addShoppingOrderInfo方法....");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("SALE_ID");
    String str4 = paramBuffers.getString("DISCOUNT");
    String str5 = paramBuffers.getString("ORDER_TYPE");
    String str6 = paramBuffers.getString("PRICE");
    String str7 = paramBuffers.getString("NUM");
    String str8 = paramBuffers.getString("MONEY");
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("DELIVER_TYPE");
    String str11 = paramBuffers.getString("PAY_TYPE");
    String str12 = paramBuffers.getString("PHONE");
    String str13 = paramBuffers.getString("CELLPHONE");
    String str14 = paramBuffers.getString("ADDR");
    String str15 = paramBuffers.getString("CONSIGNEE");
    String str16 = paramBuffers.getString("PROVINCE");
    String str17 = paramBuffers.getString("EPARCHY_CODE");
    String str18 = paramBuffers.getString("CITY");
    String str19 = paramBuffers.getString("POST_CODE");
    String str20 = paramBuffers.getString("OPER_DATE");
    String str21 = paramBuffers.getString("CARRIAGE_PAY");
    String str22 = paramBuffers.getString("SUM_MONEY");
    String str23 = paramBuffers.getString("SESSION_USER_ID");
    String str24 = paramBuffers.getString("IN_DATE");
    String str25 = "新订单，未付款";
    try
    {
      ShoppingOrderDAO localShoppingOrderDAO = new ShoppingOrderDAO();
      localShoppingOrderDAO.setCust_id(str1);
      localShoppingOrderDAO.setTrade_id(str2);
      localShoppingOrderDAO.setSale_id(str3);
      localShoppingOrderDAO.setDiscount(str4);
      localShoppingOrderDAO.setOrder_type(str5);
      localShoppingOrderDAO.setPrice(str6);
      localShoppingOrderDAO.setNum(str7);
      localShoppingOrderDAO.setMoney(str8);
      localShoppingOrderDAO.setUser_id(str9);
      localShoppingOrderDAO.setDeliver_type(str10);
      localShoppingOrderDAO.setPay_type(str11);
      localShoppingOrderDAO.setPhone(str12);
      localShoppingOrderDAO.setCellphone(str13);
      localShoppingOrderDAO.setAddr(str14);
      localShoppingOrderDAO.setConsignee(str15);
      localShoppingOrderDAO.setProvince(str16);
      localShoppingOrderDAO.setEparchy_code(str17);
      localShoppingOrderDAO.setCity(str18);
      localShoppingOrderDAO.setPost_code(str19);
      localShoppingOrderDAO.setOper_date(str20);
      localShoppingOrderDAO.setCarriage_pay(str21);
      localShoppingOrderDAO.setSum_money(str22);
      localShoppingOrderDAO.setOper_user_id(str23);
      localShoppingOrderDAO.setIn_date(str24);
      localShoppingOrderDAO.setRemark(str25);
      i = addShoppingOrderInfo(localShoppingOrderDAO);
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
    this.log.LOG_INFO("退出addShoppingOrderInfo方法...");
  }

  public int addShoppingOrderInfo(ShoppingOrderDAO paramShoppingOrderDAO)
    throws SaasApplicationException
  {
    String str1 = paramShoppingOrderDAO.getCust_id();
    String str2 = paramShoppingOrderDAO.getSale_id();
    String str3 = paramShoppingOrderDAO.getDiscount();
    String str4 = paramShoppingOrderDAO.getPrice();
    String str5 = paramShoppingOrderDAO.getNum();
    StringTokenizer localStringTokenizer1 = new StringTokenizer(str2, "|");
    StringTokenizer localStringTokenizer2 = new StringTokenizer(str3, "|");
    StringTokenizer localStringTokenizer3 = new StringTokenizer(str4, "|");
    StringTokenizer localStringTokenizer4 = new StringTokenizer(str5, "|");
    while (localStringTokenizer1.hasMoreTokens())
    {
      String str6 = localStringTokenizer1.nextToken();
      String str7 = localStringTokenizer2.nextToken();
      String str8 = localStringTokenizer3.nextToken();
      String str9 = localStringTokenizer4.nextToken();
      BigDecimal localBigDecimal1 = new BigDecimal(str7);
      BigDecimal localBigDecimal2 = new BigDecimal(str9);
      double d = localBigDecimal1.multiply(localBigDecimal2).doubleValue();
      String str10 = Double.toString(d);
      ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
      localShoppingOrderExt.setParam(":VCUST_ID", str1);
      localShoppingOrderExt.setParam(":VTRADE_ID", paramShoppingOrderDAO.getTrade_id());
      localShoppingOrderExt.setParam(":VSALE_ID", str6);
      localShoppingOrderExt.setParam(":VDISCOUNT", str7);
      localShoppingOrderExt.setParam(":VORDER_TYPE", paramShoppingOrderDAO.getOrder_type());
      localShoppingOrderExt.setParam(":VPRICE", str8);
      localShoppingOrderExt.setParam(":VNUM", str9);
      localShoppingOrderExt.setParam(":VMONEY", str10);
      localShoppingOrderExt.setParam(":VUSER_ID", paramShoppingOrderDAO.getUser_id());
      localShoppingOrderExt.setParam(":VDELIVER_TYPE", paramShoppingOrderDAO.getDeliver_type());
      localShoppingOrderExt.setParam(":VPAY_TYPE", paramShoppingOrderDAO.getPay_type());
      localShoppingOrderExt.setParam(":VPHONE", paramShoppingOrderDAO.getPhone());
      localShoppingOrderExt.setParam(":VCELLPHONE", paramShoppingOrderDAO.getCellphone());
      localShoppingOrderExt.setParam(":VADDR", paramShoppingOrderDAO.getAddr());
      localShoppingOrderExt.setParam(":VCONSIGNEE", paramShoppingOrderDAO.getConsignee());
      localShoppingOrderExt.setParam(":VPROVINCE", paramShoppingOrderDAO.getProvince());
      localShoppingOrderExt.setParam(":VEPARCHY_CODE", paramShoppingOrderDAO.getEparchy_code());
      localShoppingOrderExt.setParam(":VCITY", paramShoppingOrderDAO.getCity());
      localShoppingOrderExt.setParam(":VPOST_CODE", paramShoppingOrderDAO.getPost_code());
      localShoppingOrderExt.setParam(":VOPER_DATE", paramShoppingOrderDAO.getOper_date());
      localShoppingOrderExt.setParam(":VCARRIAGE_PAY", paramShoppingOrderDAO.getCarriage_pay());
      localShoppingOrderExt.setParam(":VSUM_MONEY", paramShoppingOrderDAO.getSum_money());
      localShoppingOrderExt.setParam(":VOPER_USER_ID", paramShoppingOrderDAO.getOper_user_id());
      localShoppingOrderExt.setParam(":VIN_DATE", paramShoppingOrderDAO.getIn_date());
      localShoppingOrderExt.setParam(":VREMARK", paramShoppingOrderDAO.getRemark());
      this.tradeQuery.executeBy(localShoppingOrderExt.insBy("ADD_ORDER_BY_ID"));
    }
    this.log.LOG_INFO("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VUSER_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_BY_USER_ID", paramInt, 20);
    this.log.LOG_INFO("退出getOrderList方法...");
    return localArrayList;
  }

  public int getOrderList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VUSER_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_BY_USER_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllOrderList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_BY_ALL_ORDER", paramInt, 20);
    return localArrayList;
  }

  public int getAllOrderList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_BY_ALL_ORDER");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllShopOrder(int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 21;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localArrayList = localShoppingOrderExt.selByList("SEL_BY_ALL", paramInt, 21);
    return localArrayList;
  }

  public int getAllShopOrder()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localArrayList = localShoppingOrderExt.selByList("SEL_BY_ALL");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllOrderListByDate(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE", paramInt, 20);
    this.log.LOG_INFO("退出getAllOrderListByDate方法..." + paramString1 + paramString2 + paramString3 + localArrayList);
    return localArrayList;
  }

  public int getAllOrderListByDate(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getShopOrderByOtherCust(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_OTHER_CUST", paramInt, 20);
    return localArrayList;
  }

  public int getShopOrderByOtherCust(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_OTHER_CUST");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllOrderListByDateNoCust(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 21;
    if (paramInt == 1)
      paramInt = 21;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString1);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString2);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_NO_CUST", paramInt, 21);
    return localArrayList;
  }

  public int getAllOrderListByDateNoCust(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString1);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString2);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_NO_CUST");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllOrderListByDateByOthers(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_BY_OTHERS", paramInt, 20);
    return localArrayList;
  }

  public int getAllOrderListByDateByOthers(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_BY_OTHERS");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllOrderListByDateWithOrderType(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 21;
    if (paramInt == 1)
      paramInt = 21;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VORDER_TYPE", paramString3);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString1);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString2);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_WITH_ORDER_TYPE", paramInt, 21);
    return localArrayList;
  }

  public int getAllOrderListByDateWithOrderType(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VORDER_TYPE", paramString3);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString1);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString2);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_WITH_ORDER_TYPE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllOrderListByDateWithCustName(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 21;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VORDER_TYPE", paramString3);
    localShoppingOrderExt.setParam(":VCUST_NAME", "%" + paramString4 + "%");
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString1);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString2);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_WITH_CUST_NAME", paramInt, 21);
    this.log.LOG_INFO("getAllOrderListByDateWithCustName ..." + paramString4 + paramString1 + localArrayList);
    return localArrayList;
  }

  public int getAllOrderListByDateWithCustName(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VORDER_TYPE", paramString3);
    localShoppingOrderExt.setParam(":VCUST_NAME", "%" + paramString4 + "%");
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString1);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString2);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_WITH_CUST_NAME");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getOrderInfoById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VTRADE_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_ID");
    return localArrayList;
  }

  public ArrayList getOrderListByDate(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("enter into getOrderListByDate ...");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    this.log.LOG_INFO("start_date=" + paramString2 + "end_date=" + paramString3);
    this.log.LOG_INFO("SQL=======" + localShoppingOrderExt.selByList("SEL_ORDERS_BY_DATE", paramInt, 20));
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDERS_BY_DATE", paramInt, 20);
    this.log.LOG_INFO("out off getOrderListByDate ...");
    return localArrayList;
  }

  public int getOrderListByDate(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDERS_BY_DATE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getOrderListById(int paramInt, String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getOrderListById方法...");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDERS_BY_OTHERS_ID", paramInt, 20);
    this.log.LOG_INFO("退出getOrderListById方法...");
    return localArrayList;
  }

  public int getOrderListById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDERS_BY_OTHERS_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public void modiShoppingorderInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入modiShoppingorderInfo方法....");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    String str2 = paramBuffers.getString("CARRIAGE_PAY");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    String str4 = paramBuffers.getString("IN_DATE");
    try
    {
      ShoppingOrderDAO localShoppingOrderDAO = new ShoppingOrderDAO();
      localShoppingOrderDAO.setTrade_id(str1);
      localShoppingOrderDAO.setCarriage_pay(str2);
      localShoppingOrderDAO.setOper_user_id(str3);
      localShoppingOrderDAO.setIn_date(str4);
      i = modiShoppingorderInfo(localShoppingOrderDAO);
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
    this.log.LOG_INFO("退出modiShoppingorderInfo方法...");
  }

  public int modiShoppingorderInfo(ShoppingOrderDAO paramShoppingOrderDAO)
    throws SaasApplicationException
  {
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VTRADE_ID", paramShoppingOrderDAO.getTrade_id());
    localShoppingOrderExt.setParam(":VCARRIAGE_PAY", paramShoppingOrderDAO.getCarriage_pay());
    localShoppingOrderExt.setParam(":VOPER_USER_ID", paramShoppingOrderDAO.getOper_user_id());
    localShoppingOrderExt.setParam(":VIN_DATE", paramShoppingOrderDAO.getIn_date());
    this.tradeQuery.executeBy(localShoppingOrderExt.insBy("UP_ORDER_BY_ID"));
    return 0;
  }

  public void modiOrderState(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入modiOrderState方法....");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    String str2 = paramBuffers.getString("ORDER_TYPE");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    try
    {
      ShoppingOrderDAO localShoppingOrderDAO = new ShoppingOrderDAO();
      localShoppingOrderDAO.setTrade_id(str1);
      localShoppingOrderDAO.setOrder_type(str2);
      localShoppingOrderDAO.setOper_user_id(str3);
      i = modiOrderState(localShoppingOrderDAO);
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
    this.log.LOG_INFO("退出modiOrderState方法...");
  }

  public int modiOrderState(ShoppingOrderDAO paramShoppingOrderDAO)
    throws SaasApplicationException
  {
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VTRADE_ID", paramShoppingOrderDAO.getTrade_id());
    localShoppingOrderExt.setParam(":VORDER_TYPE", paramShoppingOrderDAO.getOrder_type());
    localShoppingOrderExt.setParam(":VOPER_USER_ID", paramShoppingOrderDAO.getOper_user_id());
    this.tradeQuery.executeBy(localShoppingOrderExt.insBy("UP_ORDER_STATE"));
    return 0;
  }

  public ArrayList getOrderInfoByUser(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VUSER_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_BY_USER_ID");
    return localArrayList;
  }

  public ArrayList getAllOrderListByDateSmall(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_SMALL", paramInt, 20);
    return localArrayList;
  }

  public int getAllOrderSmallListByDate(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VSTART_DATE", paramString2);
    localShoppingOrderExt.setParam(":VEND_DATE", paramString3);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDER_BY_DATE_SMALL");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllOrderListSmall(int paramInt, String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getAllOrderList方法...");
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDERS_BY_ID", paramInt, 20);
    this.log.LOG_INFO("退出getAllOrderList方法...");
    return localArrayList;
  }

  public int getAllOrderListSmall(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localShoppingOrderExt.selByList("SEL_ORDERS_BY_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public void addShoppingOrderInfoLast(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addShoppingOrderInfoLast方法....");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("SALE_ID");
    String str4 = paramBuffers.getString("DISCOUNT");
    String str5 = paramBuffers.getString("ORDER_TYPE");
    String str6 = paramBuffers.getString("PRICE");
    String str7 = paramBuffers.getString("NUM");
    String str8 = paramBuffers.getString("MONEY");
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("DELIVER_TYPE");
    String str11 = paramBuffers.getString("PAY_TYPE");
    String str12 = paramBuffers.getString("PHONE");
    String str13 = paramBuffers.getString("CELLPHONE");
    String str14 = paramBuffers.getString("ADDR");
    String str15 = paramBuffers.getString("CONSIGNEE");
    String str16 = paramBuffers.getString("PROVINCE");
    String str17 = paramBuffers.getString("EPARCHY_CODE");
    String str18 = paramBuffers.getString("CITY");
    String str19 = paramBuffers.getString("POST_CODE");
    String str20 = paramBuffers.getString("OPER_DATE");
    String str21 = paramBuffers.getString("CARRIAGE_PAY");
    String str22 = paramBuffers.getString("SUM_MONEY");
    String str23 = paramBuffers.getString("SESSION_USER_ID");
    String str24 = paramBuffers.getString("IN_DATE");
    String str25 = "新订单，未付款";
    double d = Double.parseDouble(str22) + Double.parseDouble(str21);
    String str26 = String.valueOf(d);
    try
    {
      ShoppingOrderDAO localShoppingOrderDAO = new ShoppingOrderDAO();
      localShoppingOrderDAO.setCust_id(str1);
      localShoppingOrderDAO.setTrade_id(str2);
      localShoppingOrderDAO.setSale_id(str3);
      localShoppingOrderDAO.setDiscount(str4);
      localShoppingOrderDAO.setOrder_type(str5);
      localShoppingOrderDAO.setPrice(str6);
      localShoppingOrderDAO.setNum(str7);
      localShoppingOrderDAO.setMoney(str8);
      localShoppingOrderDAO.setUser_id(str9);
      localShoppingOrderDAO.setDeliver_type(str10);
      localShoppingOrderDAO.setPay_type(str11);
      localShoppingOrderDAO.setPhone(str12);
      localShoppingOrderDAO.setCellphone(str13);
      localShoppingOrderDAO.setAddr(str14);
      localShoppingOrderDAO.setConsignee(str15);
      localShoppingOrderDAO.setProvince(str16);
      localShoppingOrderDAO.setEparchy_code(str17);
      localShoppingOrderDAO.setCity(str18);
      localShoppingOrderDAO.setPost_code(str19);
      localShoppingOrderDAO.setOper_date(str20);
      localShoppingOrderDAO.setCarriage_pay(str21);
      localShoppingOrderDAO.setSum_money(str26);
      localShoppingOrderDAO.setOper_user_id(str23);
      localShoppingOrderDAO.setIn_date(str24);
      localShoppingOrderDAO.setRemark(str25);
      i = addShoppingOrderInfoLast(localShoppingOrderDAO);
      this.log.LOG_INFO("=====================================" + i + "------------------------------------");
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
    this.log.LOG_INFO("退出addShoppingOrderInfo方法...");
  }

  public int addShoppingOrderInfoLast(ShoppingOrderDAO paramShoppingOrderDAO)
    throws SaasApplicationException
  {
    String str1 = paramShoppingOrderDAO.getCust_id();
    String str2 = paramShoppingOrderDAO.getSale_id();
    String str3 = paramShoppingOrderDAO.getDiscount();
    String str4 = paramShoppingOrderDAO.getPrice();
    String str5 = paramShoppingOrderDAO.getNum();
    StringTokenizer localStringTokenizer1 = new StringTokenizer(str1, "|");
    StringTokenizer localStringTokenizer2 = new StringTokenizer(str2, "|");
    StringTokenizer localStringTokenizer3 = new StringTokenizer(str3, "|");
    StringTokenizer localStringTokenizer4 = new StringTokenizer(str4, "|");
    StringTokenizer localStringTokenizer5 = new StringTokenizer(str5, "|");
    while (localStringTokenizer1.hasMoreTokens())
    {
      String str6 = localStringTokenizer1.nextToken();
      String str7 = localStringTokenizer2.nextToken();
      String str8 = localStringTokenizer3.nextToken();
      String str9 = localStringTokenizer4.nextToken();
      String str10 = localStringTokenizer5.nextToken();
      BigDecimal localBigDecimal1 = new BigDecimal(str8);
      BigDecimal localBigDecimal2 = new BigDecimal(str10);
      double d = localBigDecimal1.multiply(localBigDecimal2).doubleValue();
      String str11 = Double.toString(d);
      ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
      localShoppingOrderExt.setParam(":VCUST_ID", str6);
      localShoppingOrderExt.setParam(":VTRADE_ID", paramShoppingOrderDAO.getTrade_id());
      localShoppingOrderExt.setParam(":VSALE_ID", str7);
      localShoppingOrderExt.setParam(":VDISCOUNT", str8);
      localShoppingOrderExt.setParam(":VORDER_TYPE", paramShoppingOrderDAO.getOrder_type());
      localShoppingOrderExt.setParam(":VPRICE", str9);
      localShoppingOrderExt.setParam(":VNUM", str10);
      localShoppingOrderExt.setParam(":VMONEY", str11);
      localShoppingOrderExt.setParam(":VUSER_ID", paramShoppingOrderDAO.getUser_id());
      localShoppingOrderExt.setParam(":VDELIVER_TYPE", paramShoppingOrderDAO.getDeliver_type());
      localShoppingOrderExt.setParam(":VPAY_TYPE", paramShoppingOrderDAO.getPay_type());
      localShoppingOrderExt.setParam(":VPHONE", paramShoppingOrderDAO.getPhone());
      localShoppingOrderExt.setParam(":VCELLPHONE", paramShoppingOrderDAO.getCellphone());
      localShoppingOrderExt.setParam(":VADDR", paramShoppingOrderDAO.getAddr());
      localShoppingOrderExt.setParam(":VCONSIGNEE", paramShoppingOrderDAO.getConsignee());
      localShoppingOrderExt.setParam(":VPROVINCE", paramShoppingOrderDAO.getProvince());
      localShoppingOrderExt.setParam(":VEPARCHY_CODE", paramShoppingOrderDAO.getEparchy_code());
      localShoppingOrderExt.setParam(":VCITY", paramShoppingOrderDAO.getCity());
      localShoppingOrderExt.setParam(":VPOST_CODE", paramShoppingOrderDAO.getPost_code());
      localShoppingOrderExt.setParam(":VOPER_DATE", paramShoppingOrderDAO.getOper_date());
      localShoppingOrderExt.setParam(":VCARRIAGE_PAY", paramShoppingOrderDAO.getCarriage_pay());
      localShoppingOrderExt.setParam(":VSUM_MONEY", paramShoppingOrderDAO.getSum_money());
      localShoppingOrderExt.setParam(":VOPER_USER_ID", paramShoppingOrderDAO.getOper_user_id());
      localShoppingOrderExt.setParam(":VIN_DATE", paramShoppingOrderDAO.getIn_date());
      localShoppingOrderExt.setParam(":VREMARK", paramShoppingOrderDAO.getRemark());
      this.log.LOG_INFO("SQL===============" + localShoppingOrderExt.insBy("ADD_ORDER_BY_ID"));
      this.tradeQuery.executeBy(localShoppingOrderExt.insBy("ADD_ORDER_BY_ID"));
    }
    return 0;
  }

  public ArrayList getLikeListByKey(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("===========================================");
    ArrayList localArrayList = new ArrayList();
    ShoppingOrderExt localShoppingOrderExt = new ShoppingOrderExt();
    localShoppingOrderExt.setParam(":VCUST_ID", paramString1);
    localShoppingOrderExt.setParam(":VCONTENT", "%" + paramString2.trim() + "%");
    this.log.LOG_INFO("===========================================");
    localArrayList = localShoppingOrderExt.selByList("SEL_BY_KEYS_BOOK");
    this.log.LOG_INFO(localArrayList + "===========================================");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.shoppingorderMgr.ShoppingOrderInfo
 * JD-Core Version:    0.6.0
 */