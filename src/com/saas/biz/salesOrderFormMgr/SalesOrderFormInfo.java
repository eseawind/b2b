package com.saas.biz.salesOrderFormMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.salesOrderFormDAO.SalesOrderDao;
import com.saas.biz.dao.salesOrderFormDAO.SalesOrderExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class SalesOrderFormInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr commen = new commMethodMgr();
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

  public void addSaleOrderForm(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addSaleOrderForm方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_NAME");
    String str4 = paramBuffers.getString("QUO_ID");
    String str5 = paramBuffers.getString("OBJ_CUST_ID");
    String str6 = paramBuffers.getString("QUO_CODE");
    String str7 = paramBuffers.getString("SALE_OBJ_ID");
    String str8 = paramBuffers.getString("CONTACT_MAN");
    String str9 = paramBuffers.getString("CONTACT");
    String str10 = paramBuffers.getString("GIVE_DATE");
    String str11 = paramBuffers.getString("GIVE_ADDR");
    String str12 = paramBuffers.getString("SHIP_TYPE");
    String str13 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    String str14 = paramBuffers.getString("CURRENCY_CODE");
    String str15 = paramBuffers.getString("SALE_USER_ID");
    String str16 = paramBuffers.getString("OWN_USER_ID");
    String str17 = paramBuffers.getString("OFF_COUNT");
    String str18 = paramBuffers.getString("OFF_RATE");
    String str19 = paramBuffers.getString("SHIP_FEE");
    String str20 = paramBuffers.getString("TAX");
    String str21 = paramBuffers.getString("ALL_FEE");
    String str22 = paramBuffers.getString("ORDER_COUNT");
    String str23 = paramBuffers.getString("PART_DELIVERY_TAG");
    String str24 = paramBuffers.getString("DELIVERY_NUM");
    String str25 = paramBuffers.getString("SESSION_USER_ID");
    String str26 = paramBuffers.getString("OBJ_CUST_NAME");
    String str27 = paramBuffers.getString("SALE_OBJ_NAME");
    String str28 = paramBuffers.getString("SALE_USER_NAME");
    String str29 = paramBuffers.getString("OWN_USER_NAME");
    String str30 = paramBuffers.getString("REMARK2");
    try
    {
      SalesOrderDao localSalesOrderDao = new SalesOrderDao();
      localSalesOrderDao.setCust_id(str1);
      localSalesOrderDao.setForm_id(str2);
      localSalesOrderDao.setQuo_name(str3);
      localSalesOrderDao.setQuo_id(str4);
      localSalesOrderDao.setObj_cust_id(str5);
      localSalesOrderDao.setQuo_code(str6);
      localSalesOrderDao.setSale_obj_id(str7);
      localSalesOrderDao.setContact_man(str8);
      localSalesOrderDao.setContact(str9);
      localSalesOrderDao.setGive_date(str10);
      localSalesOrderDao.setGive_addr(str11);
      localSalesOrderDao.setShip_type(str12);
      localSalesOrderDao.setDoc_date(str13);
      localSalesOrderDao.setCurrency_code(str14);
      localSalesOrderDao.setSale_user_id(str15);
      localSalesOrderDao.setOwn_user_id(str16);
      localSalesOrderDao.setOff_count(str17);
      localSalesOrderDao.setOff_rate(str18);
      localSalesOrderDao.setShip_fee(str19);
      localSalesOrderDao.setTax(str20);
      localSalesOrderDao.setAll_fee(str21);
      localSalesOrderDao.setOrder_count(str22);
      localSalesOrderDao.setPart_delivery_tag(str23);
      localSalesOrderDao.setDelivery_num(str24);
      localSalesOrderDao.setOper_user_id(str25);
      localSalesOrderDao.setRsrv_str3(str26);
      localSalesOrderDao.setRsrv_str4(str27);
      localSalesOrderDao.setRsrv_str5(str28);
      localSalesOrderDao.setRsrv_str6(str29);
      localSalesOrderDao.setRemark2(str30);
      i = addSaleOrderForm(localSalesOrderDao);
    }
    catch (Exception localException)
    {
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
    this.log.LOG_INFO("退出addSaleOrderForm方法...");
  }

  public int addSaleOrderForm(SalesOrderDao paramSalesOrderDao)
    throws SaasApplicationException
  {
    SalesOrderExt localSalesOrderExt = new SalesOrderExt();
    localSalesOrderExt.setParam(":VCUST_ID", paramSalesOrderDao.getCust_id());
    localSalesOrderExt.setParam(":VFORM_ID", paramSalesOrderDao.getForm_id());
    localSalesOrderExt.setParam(":VQUO_NAME", paramSalesOrderDao.getQuo_name());
    localSalesOrderExt.setParam(":VQUO_ID", paramSalesOrderDao.getQuo_id());
    localSalesOrderExt.setParam(":VOBJ_CUST_ID", paramSalesOrderDao.getObj_cust_id());
    localSalesOrderExt.setParam(":VQUO_CODE", paramSalesOrderDao.getQuo_code());
    localSalesOrderExt.setParam(":VSALE_OBJ_ID", paramSalesOrderDao.getSale_obj_id());
    localSalesOrderExt.setParam(":VCONTACT_MAN", paramSalesOrderDao.getContact_man());
    localSalesOrderExt.setParam(":VCONTACT", paramSalesOrderDao.getContact());
    localSalesOrderExt.setParam(":VGIVE_DATE", paramSalesOrderDao.getGive_date());
    localSalesOrderExt.setParam(":VGIVE_ADDR", paramSalesOrderDao.getGive_addr());
    localSalesOrderExt.setParam(":VSHIP_TYPE", paramSalesOrderDao.getShip_type());
    localSalesOrderExt.setParam(":VDOC_DATE", paramSalesOrderDao.getDoc_date());
    localSalesOrderExt.setParam(":VCURRENCY_CODE", paramSalesOrderDao.getCurrency_code());
    localSalesOrderExt.setParam(":VSALE_USER_ID", paramSalesOrderDao.getSale_user_id());
    localSalesOrderExt.setParam(":VOWN_USER_ID", paramSalesOrderDao.getOwn_user_id());
    localSalesOrderExt.setParam(":VOFF_COUNT", paramSalesOrderDao.getOff_count());
    localSalesOrderExt.setParam(":VOFF_RATE", paramSalesOrderDao.getOff_rate());
    localSalesOrderExt.setParam(":VSHIP_FEE", paramSalesOrderDao.getShip_fee());
    localSalesOrderExt.setParam(":VTAX", paramSalesOrderDao.getTax());
    localSalesOrderExt.setParam(":VALL_FEE", paramSalesOrderDao.getAll_fee());
    localSalesOrderExt.setParam(":VORDER_COUNT", paramSalesOrderDao.getOrder_count());
    localSalesOrderExt.setParam(":VPART_DELIVERY_TAG", paramSalesOrderDao.getPart_delivery_tag());
    localSalesOrderExt.setParam(":VDELIVERY_NUM", paramSalesOrderDao.getDelivery_num());
    localSalesOrderExt.setParam(":VOPER_USER_ID", paramSalesOrderDao.getOper_user_id());
    localSalesOrderExt.setParam(":VREMARK2", paramSalesOrderDao.getRemark2());
    localSalesOrderExt.setParam(":VRSRV_STR3", paramSalesOrderDao.getRsrv_str3());
    localSalesOrderExt.setParam(":VRSRV_STR4", paramSalesOrderDao.getRsrv_str4());
    localSalesOrderExt.setParam(":VRSRV_STR5", paramSalesOrderDao.getRsrv_str5());
    localSalesOrderExt.setParam(":VRSRV_STR6", paramSalesOrderDao.getRsrv_str6());
    this.tradeQuery.executeBy(localSalesOrderExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void editSaleOrderForm(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入editSaleOrderForm方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_NAME");
    String str4 = paramBuffers.getString("QUO_ID");
    String str5 = paramBuffers.getString("OBJ_CUST_ID");
    String str6 = paramBuffers.getString("QUO_CODE");
    String str7 = paramBuffers.getString("SALE_OBJ_ID");
    String str8 = paramBuffers.getString("CONTACT_MAN");
    String str9 = paramBuffers.getString("CONTACT");
    String str10 = paramBuffers.getString("GIVE_DATE");
    String str11 = paramBuffers.getString("GIVE_ADDR");
    String str12 = paramBuffers.getString("SHIP_TYPE");
    String str13 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    String str14 = paramBuffers.getString("CURRENCY_CODE");
    String str15 = paramBuffers.getString("SALE_USER_ID");
    String str16 = paramBuffers.getString("OWN_USER_ID");
    String str17 = paramBuffers.getString("OFF_COUNT");
    String str18 = paramBuffers.getString("OFF_RATE");
    String str19 = paramBuffers.getString("SHIP_FEE");
    String str20 = paramBuffers.getString("TAX");
    String str21 = paramBuffers.getString("ALL_FEE");
    String str22 = paramBuffers.getString("ORDER_COUNT");
    String str23 = paramBuffers.getString("PART_DELIVERY_TAG");
    String str24 = paramBuffers.getString("DELIVERY_NUM");
    String str25 = paramBuffers.getString("SESSION_USER_ID");
    String str26 = paramBuffers.getString("OBJ_CUST_NAME");
    String str27 = paramBuffers.getString("SALE_OBJ_NAME");
    String str28 = paramBuffers.getString("SALE_USER_NAME");
    String str29 = paramBuffers.getString("OWN_USER_NAME");
    String str30 = paramBuffers.getString("REMARK2");
    try
    {
      SalesOrderDao localSalesOrderDao = new SalesOrderDao();
      localSalesOrderDao.setCust_id(str1);
      localSalesOrderDao.setForm_id(str2);
      localSalesOrderDao.setQuo_name(str3);
      localSalesOrderDao.setQuo_id(str4);
      localSalesOrderDao.setObj_cust_id(str5);
      localSalesOrderDao.setQuo_code(str6);
      localSalesOrderDao.setSale_obj_id(str7);
      localSalesOrderDao.setContact_man(str8);
      localSalesOrderDao.setContact(str9);
      localSalesOrderDao.setGive_date(str10);
      localSalesOrderDao.setGive_addr(str11);
      localSalesOrderDao.setShip_type(str12);
      localSalesOrderDao.setDoc_date(str13);
      localSalesOrderDao.setCurrency_code(str14);
      localSalesOrderDao.setSale_user_id(str15);
      localSalesOrderDao.setOwn_user_id(str16);
      localSalesOrderDao.setOff_count(str17);
      localSalesOrderDao.setOff_rate(str18);
      localSalesOrderDao.setShip_fee(str19);
      localSalesOrderDao.setTax(str20);
      localSalesOrderDao.setAll_fee(str21);
      localSalesOrderDao.setOrder_count(str22);
      localSalesOrderDao.setPart_delivery_tag(str23);
      localSalesOrderDao.setDelivery_num(str24);
      localSalesOrderDao.setOper_user_id(str25);
      localSalesOrderDao.setRsrv_str3(str26);
      localSalesOrderDao.setRsrv_str4(str27);
      localSalesOrderDao.setRsrv_str5(str28);
      localSalesOrderDao.setRsrv_str6(str29);
      localSalesOrderDao.setRemark2(str30);
      i = editSaleOrderForm(localSalesOrderDao);
    }
    catch (Exception localException)
    {
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
    this.log.LOG_INFO("退出editSaleOrderForm方法...");
  }

  public int editSaleOrderForm(SalesOrderDao paramSalesOrderDao)
    throws SaasApplicationException
  {
    SalesOrderExt localSalesOrderExt = new SalesOrderExt();
    localSalesOrderExt.setParam(":VCUST_ID", paramSalesOrderDao.getCust_id());
    localSalesOrderExt.setParam(":VFORM_ID", paramSalesOrderDao.getForm_id());
    localSalesOrderExt.setParam(":VQUO_NAME", paramSalesOrderDao.getQuo_name());
    localSalesOrderExt.setParam(":VQUO_ID", paramSalesOrderDao.getQuo_id());
    localSalesOrderExt.setParam(":VOBJ_CUST_ID", paramSalesOrderDao.getObj_cust_id());
    localSalesOrderExt.setParam(":VQUO_CODE", paramSalesOrderDao.getQuo_code());
    localSalesOrderExt.setParam(":VSALE_OBJ_ID", paramSalesOrderDao.getSale_obj_id());
    localSalesOrderExt.setParam(":VCONTACT_MAN", paramSalesOrderDao.getContact_man());
    localSalesOrderExt.setParam(":VCONTACT", paramSalesOrderDao.getContact());
    localSalesOrderExt.setParam(":VGIVE_DATE", paramSalesOrderDao.getGive_date());
    localSalesOrderExt.setParam(":VGIVE_ADDR", paramSalesOrderDao.getGive_addr());
    localSalesOrderExt.setParam(":VSHIP_TYPE", paramSalesOrderDao.getShip_type());
    localSalesOrderExt.setParam(":VDOC_DATE", paramSalesOrderDao.getDoc_date());
    localSalesOrderExt.setParam(":VCURRENCY_CODE", paramSalesOrderDao.getCurrency_code());
    localSalesOrderExt.setParam(":VSALE_USER_ID", paramSalesOrderDao.getSale_user_id());
    localSalesOrderExt.setParam(":VOWN_USER_ID", paramSalesOrderDao.getOwn_user_id());
    localSalesOrderExt.setParam(":VOFF_COUNT", paramSalesOrderDao.getOff_count());
    localSalesOrderExt.setParam(":VOFF_RATE", paramSalesOrderDao.getOff_rate());
    localSalesOrderExt.setParam(":VSHIP_FEE", paramSalesOrderDao.getShip_fee());
    localSalesOrderExt.setParam(":VTAX", paramSalesOrderDao.getTax());
    localSalesOrderExt.setParam(":VALL_FEE", paramSalesOrderDao.getAll_fee());
    localSalesOrderExt.setParam(":VORDER_COUNT", paramSalesOrderDao.getOrder_count());
    localSalesOrderExt.setParam(":VPART_DELIVERY_TAG", paramSalesOrderDao.getPart_delivery_tag());
    localSalesOrderExt.setParam(":VDELIVERY_NUM", paramSalesOrderDao.getDelivery_num());
    localSalesOrderExt.setParam(":VOPER_USER_ID", paramSalesOrderDao.getOper_user_id());
    localSalesOrderExt.setParam(":VREMARK2", paramSalesOrderDao.getRemark2());
    localSalesOrderExt.setParam(":VRSRV_STR3", paramSalesOrderDao.getRsrv_str3());
    localSalesOrderExt.setParam(":VRSRV_STR4", paramSalesOrderDao.getRsrv_str4());
    localSalesOrderExt.setParam(":VRSRV_STR5", paramSalesOrderDao.getRsrv_str5());
    localSalesOrderExt.setParam(":VRSRV_STR6", paramSalesOrderDao.getRsrv_str6());
    this.tradeQuery.executeBy(localSalesOrderExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public void deleteSaleOrderForm(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteSaleOrderForm方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUO_ID");
    try
    {
      i = deleteSaleOrderForm(str1, str2);
    }
    catch (Exception localException)
    {
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
    this.log.LOG_INFO("退出deleteSaleOrderForm方法...");
  }

  public int deleteSaleOrderForm(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    SalesOrderExt localSalesOrderExt = new SalesOrderExt();
    localSalesOrderExt.setParam(":VCUST_ID", paramString1);
    localSalesOrderExt.setParam(":VQUO_ID", paramString2);
    this.tradeQuery.executeBy(localSalesOrderExt.insBy("DEL_BY_ID"));
    return 0;
  }

  public ArrayList getSalseOrderByCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SalesOrderExt localSalesOrderExt = new SalesOrderExt();
    paramInt *= 20;
    localSalesOrderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localSalesOrderExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getSalseOrderByCust(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    SalesOrderExt localSalesOrderExt = new SalesOrderExt();
    localSalesOrderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localSalesOrderExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public int getSalesOrderCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    SalesOrderExt localSalesOrderExt = new SalesOrderExt();
    localSalesOrderExt.setParam(":VCUST_ID", paramString);
    localArrayList = localSalesOrderExt.selByList("SEL_SIZE_BY_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public HashMap getSaleOrderById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    SalesOrderExt localSalesOrderExt = new SalesOrderExt();
    localSalesOrderExt.setParam(":VCUST_ID", paramString1);
    localSalesOrderExt.setParam(":VQUO_ID", paramString2);
    localArrayList = localSalesOrderExt.selByList("SEL_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getConStateList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    SalesOrderExt localSalesOrderExt = new SalesOrderExt();
    localSalesOrderExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localSalesOrderExt.selByList("SEL_BY_CON_STATE", paramInt, 20);
    return localArrayList;
  }

  public int getConStateList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    SalesOrderExt localSalesOrderExt = new SalesOrderExt();
    localSalesOrderExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localSalesOrderExt.selByList("SEL_BY_CON_STATE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.salesOrderFormMgr.SalesOrderFormInfo
 * JD-Core Version:    0.6.0
 */