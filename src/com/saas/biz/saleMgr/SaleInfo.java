package com.saas.biz.saleMgr;

import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.saleDAO.SaleDAO;
import com.saas.biz.dao.saleDAO.SaleExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SaleInfo
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

  public void addsaleinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入addsaleinfo方法...");
    SaleDAO localSaleDAO = new SaleDAO();
    localSaleDAO.setSale_id(paramBuffers.getString("SALE_ID"));
    localSaleDAO.setTitle(paramBuffers.getString("TITLE"));
    localSaleDAO.setContent(paramBuffers.getString("CONTENT"));
    localSaleDAO.setSale_addr(paramBuffers.getString("SALE_ADDR"));
    localSaleDAO.setCommodity_price(paramBuffers.getString("COMMODITY_PRICE"));
    localSaleDAO.setPrice_type(paramBuffers.getString("PRICE_TYPE"));
    localSaleDAO.setSale_price(paramBuffers.getString("SALE_PRICE"));
    localSaleDAO.setSale_num(paramBuffers.getString("SALE_NUM"));
    localSaleDAO.setCarriage_pay(paramBuffers.getString("CARRIAGE_PAY"));
    localSaleDAO.setStart_date(paramBuffers.getString("START_DATE"));
    localSaleDAO.setEnd_date(paramBuffers.getString("END_DATE"));
    localSaleDAO.setSale_unit(paramBuffers.getString("SESSION_CUST_ID"));
    localSaleDAO.setPublish_user_id(paramBuffers.getString("SESSION_USER_ID"));
    localSaleDAO.setAudit_user_id(paramBuffers.getString("SESSION_USER_ID"));
    String str = paramBuffers.getString("SALE_TYPE");
    int i = -1;
    try
    {
      i = addsaleinfo(localSaleDAO, str);
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
    this.log.LOG_INFO("退出addsaleInfo方法...");
  }

  public int addsaleinfo(SaleDAO paramSaleDAO, String paramString)
    throws SaasApplicationException
  {
    SaleExt localSaleExt = new SaleExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    localSaleExt.setParam(":VSALE_ID", paramSaleDAO.getSale_id());
    localSaleExt.setParam(":VSALE_UNIT", paramSaleDAO.getSale_unit());
    localSaleExt.setParam(":VTITLE", paramSaleDAO.getTitle());
    localSaleExt.setParam(":VCONTENT", paramSaleDAO.getContent());
    localSaleExt.setParam(":VSALE_ADDR", paramSaleDAO.getSale_addr());
    localSaleExt.setParam(":VCOMMODITY_PRICE", paramSaleDAO.getCommodity_price());
    localSaleExt.setParam(":VSTART_DATE", paramSaleDAO.getStart_date());
    localSaleExt.setParam(":VEND_DATE", paramSaleDAO.getEnd_date());
    localSaleExt.setParam(":VATTACH_TAG", "0");
    localSaleExt.setParam(":VSALE_PRICE", paramSaleDAO.getSale_price());
    localSaleExt.setParam(":VSALE_NUM", paramSaleDAO.getSale_num());
    localSaleExt.setParam(":VCARRIAGE_pay", paramSaleDAO.getCarriage_pay());
    localSaleExt.setParam(":VPUBLISH_USER_ID", paramSaleDAO.getPublish_user_id());
    localSaleExt.setParam(":VAUDIT_USER_ID", paramSaleDAO.getAudit_user_id());
    localSaleExt.setParam(":VREMARK", "");
    localSaleExt.setParam(":VVALIDITY", "0");
    localSaleExt.setParam(":VSALE_CLASS", "0");
    localSaleExt.setParam(":VSALE_TYPE", paramString);
    localSaleExt.setParam(":VPRICE_TYPE", "0");
    this.tradeQuery.executeBy(localSaleExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("ROOT_ID", paramSaleDAO.getSale_id());
    return 0;
  }

  public void genSale(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genSale方法...");
    try
    {
      this.queryResult = genSale();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genSale方法...");
  }

  public ArrayList genSale()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList1 = localSaleExt.selByList("SEL_BY_ALL");
    return localArrayList1;
  }

  public void genSpecSale(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genSpecSale方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = genSpecSale(str1);
      else
        this.queryResult = searchSale(str2, str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genSpecSale方法...");
  }

  public ArrayList genSpecSale(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString);
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE");
    return localArrayList;
  }

  public ArrayList enterpCommend(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 == 0)
      paramInt1 = 0;
    else
      paramInt1 = (paramInt1 - 1) * paramInt2;
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend", paramInt1, paramInt2);
    return localArrayList;
  }

  public int enterpCommend()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList supplyCommend(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 == 0)
      paramInt1 = 0;
    else
      paramInt1 = (paramInt1 - 1) * paramInt2;
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend_supp", paramInt1, paramInt2);
    return localArrayList;
  }

  public int supplyCommend()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend_supp");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList twohandCommend(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 == 0)
      paramInt1 = 0;
    else
      paramInt1 = (paramInt1 - 1) * paramInt2;
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend_twohand", paramInt1, paramInt2);
    return localArrayList;
  }

  public int twohandCommend()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend_twohand");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList stockCommend(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 == 0)
      paramInt1 = 0;
    else
      paramInt1 = (paramInt1 - 1) * paramInt2;
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend_stock", paramInt1, paramInt2);
    return localArrayList;
  }

  public int stockCommend()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend_stock");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList productCommend(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 == 0)
      paramInt1 = 0;
    else
      paramInt1 = (paramInt1 - 1) * paramInt2;
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend_product", paramInt1, paramInt2);
    return localArrayList;
  }

  public int productCommend()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend_product");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void genOneSale(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入genOneSale方法...");
    String str = paramBuffers.getString("SALE_ID");
    try
    {
      this.queryResult = genOneSale(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genOneSale方法...");
  }

  public ArrayList genOneSale(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_ONE_SALE");
    return localArrayList;
  }

  public void updateContentinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateContentinfo方法...");
    String str1 = "";
    str1 = paramBuffers.getString("CUST_ID");
    String str2 = "";
    str2 = getContent(str1);
    int i = -1;
    try
    {
      i = updateContentinfo(str1, str2);
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
    this.log.LOG_INFO("退出updateContentinfo方法...");
  }

  public void DEleteContentinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入DEleteContentinfo方法...");
    String str1 = "";
    String str2 = "";
    str1 = paramBuffers.getString("CUST_ID");
    str2 = paramBuffers.getString("CONTENTS");
    int i = -1;
    try
    {
      i = updateContentinfo(str1, str2);
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
    this.log.LOG_INFO("退出DEleteContentinfo方法...");
  }

  public int updateContentinfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VCUST_ID", paramString1);
    localSaleExt.setParam(":VCONTENTS", paramString2);
    this.tradeQuery.executeBy(localSaleExt.insBy("UPDATE_SALE_commend_CUST_ID"));
    return 0;
  }

  public String getContent(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    HashMap localHashMap = new HashMap();
    String str = "";
    localSaleExt.setParam(":VCUST_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_commend_CUST_ID");
    if ((null != localArrayList) && (localArrayList.size() > 0))
    {
      localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("contents") != null)
        str = localHashMap.get("contents").toString();
    }
    if (str.equals(""))
      return "10";
    if (str.substring(0, 1).equals("0"))
      str = str.replaceFirst("0", "1");
    return str;
  }

  public void changsaleinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入changsaleinfo方法...");
    SaleDAO localSaleDAO = new SaleDAO();
    localSaleDAO.setSale_id(paramBuffers.getString("SALE_ID"));
    localSaleDAO.setTitle(paramBuffers.getString("TITLE"));
    localSaleDAO.setContent(paramBuffers.getString("CONTENT"));
    localSaleDAO.setSale_addr(paramBuffers.getString("SALE_ADDR"));
    localSaleDAO.setCommodity_price(paramBuffers.getString("COMMODITY_PRICE"));
    localSaleDAO.setPrice_type(paramBuffers.getString("PRICE_TYPE"));
    localSaleDAO.setSale_price(paramBuffers.getString("SALE_PRICE"));
    localSaleDAO.setSale_num(paramBuffers.getString("SALE_NUM"));
    localSaleDAO.setCarriage_pay(paramBuffers.getString("CARRIAGE_PAY"));
    localSaleDAO.setStart_date(paramBuffers.getString("START_DATE"));
    localSaleDAO.setEnd_date(paramBuffers.getString("END_DATE"));
    localSaleDAO.setAudit_user_id(paramBuffers.getString("SESSION_USER_ID"));
    int i = -1;
    try
    {
      i = changsaleinfo(localSaleDAO);
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
    this.log.LOG_INFO("退出addsaleInfo方法...");
  }

  public int changsaleinfo(SaleDAO paramSaleDAO)
    throws SaasApplicationException
  {
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramSaleDAO.getSale_id());
    localSaleExt.setParam(":VTITLE", paramSaleDAO.getTitle());
    localSaleExt.setParam(":VCONTENT", paramSaleDAO.getContent());
    localSaleExt.setParam(":VSALE_ADDR", paramSaleDAO.getSale_addr());
    localSaleExt.setParam(":VCOMMODITY_PRICE", paramSaleDAO.getCommodity_price());
    localSaleExt.setParam(":VSTART_DATE", paramSaleDAO.getStart_date());
    localSaleExt.setParam(":VEND_DATE", paramSaleDAO.getEnd_date());
    localSaleExt.setParam(":VSALE_PRICE", paramSaleDAO.getSale_price());
    localSaleExt.setParam(":VSALE_NUM", paramSaleDAO.getSale_num());
    localSaleExt.setParam(":VCARRIAGE_PAY", paramSaleDAO.getCarriage_pay());
    localSaleExt.setParam(":VAUDIT_USER_ID", paramSaleDAO.getAudit_user_id());
    localSaleExt.setParam(":VPRICE_TYPE", paramSaleDAO.getPrice_type());
    this.tradeQuery.executeBy(localSaleExt.insBy("UPDATE_BY_ONE"));
    return 0;
  }

  public void updateSaleNum(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateSaleNum方法...");
    SaleDAO localSaleDAO = new SaleDAO();
    String str1 = paramBuffers.getString("SALE_ID");
    String str2 = paramBuffers.getString("SALE_NUM");
    String str3 = paramBuffers.getString("CARRIAGE_PAY");
    int i = -1;
    try
    {
      i = updateSaleNum(str1, str2, str3);
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
    this.log.LOG_INFO("退出updateSaleNum方法...");
  }

  public int updateSaleNum(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramString1);
    localSaleExt.setParam(":VSALE_NUM", paramString2);
    localSaleExt.setParam(":VCARRIAGE_PAY", paramString3);
    this.tradeQuery.executeBy(localSaleExt.insBy("UPDATE_BY_SALE_NUM"));
    return 0;
  }

  public void delsaleinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入changsaleinfo方法...");
    int i = -1;
    try
    {
      i = delsaleinfo(paramBuffers.getString("SALE_ID"));
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
    this.log.LOG_INFO("退出delsaleinfo方法...");
  }

  public int delsaleinfo(String paramString)
    throws SaasApplicationException
  {
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramString);
    this.tradeQuery.executeBy(localSaleExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public void deletesaleinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入changsaleinfo方法...");
    int i = -1;
    try
    {
      i = deletesaleinfo(paramBuffers.getString("SALE_UNIT"));
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
    this.log.LOG_INFO("退出delsaleinfo方法...");
  }

  public void DeleteSaleInfoTW(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SALE_UNIT");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = deletesaleinfo(str2);
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
    this.log.LOG_INFO("退出DeleteSaleInfo方法...");
  }

  public int deletesaleinfo(String paramString)
    throws SaasApplicationException
  {
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString);
    this.tradeQuery.executeBy(localSaleExt.insBy("STATE_DELETE_SALE"));
    return 0;
  }

  public void searchCust(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入searchCust方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("SALER_NAME");
    try
    {
      this.queryResult = searchCust(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出searchCust方法...");
  }

  public ArrayList searchCust(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VCUST_NAME", paramString);
    localArrayList = localSaleExt.selByList("SEL_BY_SALER");
    return localArrayList;
  }

  public ArrayList searchSale(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VTITLE", "%" + paramString1 + "%");
    localSaleExt.setParam(":VSALE_UNIT", paramString2);
    localArrayList = localSaleExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public String searchfj(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Attachinfo localAttachinfo = new Attachinfo();
    String str = localAttachinfo.getAttachPath(paramString1, paramString2, "0");
    return str;
  }

  public ArrayList gentSalesByCust_id(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localSaleExt.setParam(":VSALE_TYPE", paramString2);
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE", paramInt, 30);
    return localArrayList;
  }

  public ArrayList gentSalesByMemeberCust_id(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localSaleExt.setParam(":VSALE_TYPE", paramString2);
    localArrayList = localSaleExt.selByList("SEL_MEMBER_SPEC_SALE", paramInt, 30);
    return localArrayList;
  }

  public int gentSalesByMemeberCust_id(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localSaleExt.setParam(":VSALE_TYPE", paramString2);
    localArrayList = localSaleExt.selByList("SEL_MEMBER_SPEC_SALE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList gentSalesByCust_idDate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localSaleExt.setParam(":VSTART_DATE", paramString2);
    localSaleExt.setParam(":VEND_DATE", paramString3);
    localSaleExt.setParam(":VSALE_TYPE", paramString4);
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_DATE", paramInt, 30);
    return localArrayList;
  }

  public int getSaleListNumberByDate(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localSaleExt.setParam(":VSTART_DATE", paramString2);
    localSaleExt.setParam(":VEND_DATE", paramString3);
    localSaleExt.setParam(":VSALE_TYPE", paramString4);
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_DATE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList gentSalesByCust_idDate_T(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSTART_DATE", paramString2);
    localSaleExt.setParam(":VEND_DATE", paramString3);
    localSaleExt.setParam(":VSALE_TYPE", paramString4);
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_DATE_T", paramInt, 30);
    return localArrayList;
  }

  public int getSaleListNumberByDate_T(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localSaleExt.setParam(":VSTART_DATE", paramString2);
    localSaleExt.setParam(":VEND_DATE", paramString3);
    localSaleExt.setParam(":VSALE_TYPE", paramString4);
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_DATE_T");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList gentSalesByCust_idKey(int paramInt, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localSaleExt.setParam(":VSALE_TYPE", paramString3);
    localSaleExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_KEY", paramInt, 30);
    return localArrayList;
  }

  public int getSaleListNumberByKey(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localSaleExt.setParam(":VSALE_TYPE", paramString3);
    localSaleExt.setParam(":VKEY_WORD", "%" + paramString2 + "%");
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE_KEY");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getSaleListNumber(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString1);
    localSaleExt.setParam(":VSALE_TYPE", paramString2);
    localArrayList = localSaleExt.selByList("SEL_SPEC_SALE");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getSaleListBySearch(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    try
    {
      localArrayList = localSaleExt.selByList("SEL_BY_KEYS", paramInt, 30);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    return localArrayList;
  }

  public int getSaleSearch(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localSaleExt.selByList("SEL_BY_KEYS");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList genSaleList(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_BY_ALL", 0, paramInt);
    return localArrayList;
  }

  public ArrayList genSaleListByCust_ID(String paramString, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_UNIT", paramString);
    localArrayList = localSaleExt.selByList("SEL_BY_CUSTID", 0, paramInt);
    return localArrayList;
  }

  public int getSaleListNum(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    int i = 0;
    localSaleExt.setParam(":VSALE_UNIT", paramString);
    localArrayList = localSaleExt.selByList("SEL_COUNT_SALE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("counter").toString());
    }
    return i;
  }

  public int getOffSaleListNum(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VCUST_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_OFF_SPEC_CUST_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getProductInfoList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_BY_SALE_ID");
    return localArrayList;
  }

  public String getProName(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_BY_SALE_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("title") != null)
        str = localHashMap.get("title").toString();
    }
    return str;
  }

  public ArrayList genSaleorderLimit(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_BY_LIMIT", 0, paramInt);
    if (localArrayList == null)
      return null;
    return localArrayList;
  }

  public ArrayList genOneSaleByTitle(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VTITLE", "%" + paramString2 + "%");
    localSaleExt.setParam(":VCUST_ID", paramString1);
    localArrayList = localSaleExt.selByList("SEL_ONE_SALE_BY_TITLE", paramInt, 20);
    return localArrayList;
  }

  public int genOneSaleByTitle(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VTITLE", "%" + paramString2 + "%");
    localSaleExt.setParam(":VCUST_ID", paramString1);
    localArrayList = localSaleExt.selByList("SEL_ONE_SALE_BY_TITLE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList genSalebyCart(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VCUST_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_ONE_SALE_BY_", paramInt, 20);
    return localArrayList;
  }

  public int genSalebyCart(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VCUST_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_ONE_SALE_BY_");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public String getCustNameBySaleId(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramString);
    localArrayList = localSaleExt.selByList("SEL_BY_SALE_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("sale_unit") != null)
        str = localHashMap.get("sale_unit").toString();
    }
    return str;
  }

  public void reloadSaleInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入reloadSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SALE_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = reloadSaleInfo(str2);
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
    this.log.LOG_INFO("退出reloadSaleInfo方法...");
  }

  public int reloadSaleInfo(String paramString)
    throws SaasApplicationException
  {
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VSALE_ID", paramString);
    this.tradeQuery.executeBy(localSaleExt.insBy("RELOAD_SALE_BY_SALE_ID"));
    return 0;
  }

  public void DeleteSaleInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SALE_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = delsaleinfo(str2);
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
    this.log.LOG_INFO("退出DeleteSaleInfo方法...");
  }

  public ArrayList getSaleListBy()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localArrayList = localSaleExt.selByList("SEL_ALL_SALE_FOR_HOME");
    return localArrayList;
  }

  public ArrayList getListByKeyAndChid(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SaleExt localSaleExt = new SaleExt();
    localSaleExt.setParam(":VTITLE", "%" + paramString + "%");
    localArrayList = localSaleExt.selByList("SEL_LIST_BY_KEY_AND_CHID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.saleMgr.SaleInfo
 * JD-Core Version:    0.6.0
 */