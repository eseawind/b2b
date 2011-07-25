package com.saas.biz.procurformMgr;

import com.saas.biz.dao.procurformDAO.ProcurformDAO;
import com.saas.biz.dao.procurformDAO.ProcurformExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ProcurformInfo
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

  public void addProcurForm(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addProcurForm方法...");
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
      ProcurformDAO localProcurformDAO = new ProcurformDAO();
      localProcurformDAO.setCust_id(str1);
      localProcurformDAO.setForm_id(str2);
      localProcurformDAO.setQuo_name(str3);
      localProcurformDAO.setQuo_id(str4);
      localProcurformDAO.setObj_cust_id(str5);
      localProcurformDAO.setQuo_code(str6);
      localProcurformDAO.setSale_obj_id(str7);
      localProcurformDAO.setContact_man(str8);
      localProcurformDAO.setContact(str9);
      localProcurformDAO.setGive_date(str10);
      localProcurformDAO.setGive_addr(str11);
      localProcurformDAO.setShip_type(str12);
      localProcurformDAO.setDoc_date(str13);
      localProcurformDAO.setCurrency_code(str14);
      localProcurformDAO.setSale_user_id(str15);
      localProcurformDAO.setOwn_user_id(str16);
      localProcurformDAO.setOff_count(str17);
      localProcurformDAO.setOff_rate(str18);
      localProcurformDAO.setShip_fee(str19);
      localProcurformDAO.setTax(str20);
      localProcurformDAO.setAll_fee(str21);
      localProcurformDAO.setOrder_count(str22);
      localProcurformDAO.setPart_delivery_tag(str23);
      localProcurformDAO.setDelivery_num(str24);
      localProcurformDAO.setOper_user_id(str25);
      localProcurformDAO.setRsrv_str3(str26);
      localProcurformDAO.setRsrv_str4(str27);
      localProcurformDAO.setRsrv_str5(str28);
      localProcurformDAO.setRsrv_str6(str29);
      localProcurformDAO.setRemark2(str30);
      i = addProcurForm(localProcurformDAO);
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

  public int addProcurForm(ProcurformDAO paramProcurformDAO)
    throws SaasApplicationException
  {
    ProcurformExt localProcurformExt = new ProcurformExt();
    localProcurformExt.setParam(":VCUST_ID", paramProcurformDAO.getCust_id());
    localProcurformExt.setParam(":VFORM_ID", paramProcurformDAO.getForm_id());
    localProcurformExt.setParam(":VQUO_NAME", paramProcurformDAO.getQuo_name());
    localProcurformExt.setParam(":VQUO_ID", paramProcurformDAO.getQuo_id());
    localProcurformExt.setParam(":VOBJ_CUST_ID", paramProcurformDAO.getObj_cust_id());
    localProcurformExt.setParam(":VQUO_CODE", paramProcurformDAO.getQuo_code());
    localProcurformExt.setParam(":VSALE_OBJ_ID", paramProcurformDAO.getSale_obj_id());
    localProcurformExt.setParam(":VCONTACT_MAN", paramProcurformDAO.getContact_man());
    localProcurformExt.setParam(":VCONTACT", paramProcurformDAO.getContact());
    localProcurformExt.setParam(":VGIVE_DATE", paramProcurformDAO.getGive_date());
    localProcurformExt.setParam(":VGIVE_ADDR", paramProcurformDAO.getGive_addr());
    localProcurformExt.setParam(":VSHIP_TYPE", paramProcurformDAO.getShip_type());
    localProcurformExt.setParam(":VDOC_DATE", paramProcurformDAO.getDoc_date());
    localProcurformExt.setParam(":VCURRENCY_CODE", paramProcurformDAO.getCurrency_code());
    localProcurformExt.setParam(":VSALE_USER_ID", paramProcurformDAO.getSale_user_id());
    localProcurformExt.setParam(":VOWN_USER_ID", paramProcurformDAO.getOwn_user_id());
    localProcurformExt.setParam(":VOFF_COUNT", paramProcurformDAO.getOff_count());
    localProcurformExt.setParam(":VOFF_RATE", paramProcurformDAO.getOff_rate());
    localProcurformExt.setParam(":VSHIP_FEE", paramProcurformDAO.getShip_fee());
    localProcurformExt.setParam(":VTAX", paramProcurformDAO.getTax());
    localProcurformExt.setParam(":VALL_FEE", paramProcurformDAO.getAll_fee());
    localProcurformExt.setParam(":VORDER_COUNT", paramProcurformDAO.getOrder_count());
    localProcurformExt.setParam(":VPART_DELIVERY_TAG", paramProcurformDAO.getPart_delivery_tag());
    localProcurformExt.setParam(":VDELIVERY_NUM", paramProcurformDAO.getDelivery_num());
    localProcurformExt.setParam(":VOPER_USER_ID", paramProcurformDAO.getOper_user_id());
    localProcurformExt.setParam(":VREMARK2", paramProcurformDAO.getRemark2());
    localProcurformExt.setParam(":VRSRV_STR3", paramProcurformDAO.getRsrv_str3());
    localProcurformExt.setParam(":VRSRV_STR4", paramProcurformDAO.getRsrv_str4());
    localProcurformExt.setParam(":VRSRV_STR5", paramProcurformDAO.getRsrv_str5());
    localProcurformExt.setParam(":VRSRV_STR6", paramProcurformDAO.getRsrv_str6());
    this.tradeQuery.executeBy(localProcurformExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList getAllProcurform(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProcurformExt localProcurformExt = new ProcurformExt();
    localProcurformExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProcurformExt.selByList("SEL_BY_CUST_ID");
    return localArrayList;
  }

  public int getProcurforSize(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ProcurformExt localProcurformExt = new ProcurformExt();
    localProcurformExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProcurformExt.selByList("SEL_BY_CUST_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void delProcurform(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delProcurform方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      String str1 = paramBuffers.getString("SESSION_CUST_ID");
      String str2 = paramBuffers.getString("QUO_ID");
      i = delProcurform(str1, str2);
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
    this.log.LOG_INFO("退出delProcurform方法...");
  }

  public int delProcurform(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProcurformExt localProcurformExt = new ProcurformExt();
    localProcurformExt.setParam(":VCUST_ID", paramString1);
    localProcurformExt.setParam(":VQUO_ID", paramString2);
    this.tradeQuery.executeBy(localProcurformExt.insBy("DEL_PROCURFORM_BY_QUO_ID"));
    return 0;
  }

  public void updateProcurForm(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateProcurForm方法...");
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
      ProcurformDAO localProcurformDAO = new ProcurformDAO();
      localProcurformDAO.setCust_id(str1);
      localProcurformDAO.setForm_id(str2);
      localProcurformDAO.setQuo_name(str3);
      localProcurformDAO.setQuo_id(str4);
      localProcurformDAO.setObj_cust_id(str5);
      localProcurformDAO.setQuo_code(str6);
      localProcurformDAO.setSale_obj_id(str7);
      localProcurformDAO.setContact_man(str8);
      localProcurformDAO.setContact(str9);
      localProcurformDAO.setGive_date(str10);
      localProcurformDAO.setGive_addr(str11);
      localProcurformDAO.setShip_type(str12);
      localProcurformDAO.setDoc_date(str13);
      localProcurformDAO.setCurrency_code(str14);
      localProcurformDAO.setSale_user_id(str15);
      localProcurformDAO.setOwn_user_id(str16);
      localProcurformDAO.setOff_count(str17);
      localProcurformDAO.setOff_rate(str18);
      localProcurformDAO.setShip_fee(str19);
      localProcurformDAO.setTax(str20);
      localProcurformDAO.setAll_fee(str21);
      localProcurformDAO.setOrder_count(str22);
      localProcurformDAO.setPart_delivery_tag(str23);
      localProcurformDAO.setDelivery_num(str24);
      localProcurformDAO.setOper_user_id(str25);
      localProcurformDAO.setRsrv_str3(str26);
      localProcurformDAO.setRsrv_str4(str27);
      localProcurformDAO.setRsrv_str5(str28);
      localProcurformDAO.setRsrv_str6(str29);
      localProcurformDAO.setRemark2(str30);
      i = updateProcurForm(localProcurformDAO);
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

  public int updateProcurForm(ProcurformDAO paramProcurformDAO)
    throws SaasApplicationException
  {
    ProcurformExt localProcurformExt = new ProcurformExt();
    localProcurformExt.setParam(":VCUST_ID", paramProcurformDAO.getCust_id());
    localProcurformExt.setParam(":VFORM_ID", paramProcurformDAO.getForm_id());
    localProcurformExt.setParam(":VQUO_NAME", paramProcurformDAO.getQuo_name());
    localProcurformExt.setParam(":VQUO_ID", paramProcurformDAO.getQuo_id());
    localProcurformExt.setParam(":VOBJ_CUST_ID", paramProcurformDAO.getObj_cust_id());
    localProcurformExt.setParam(":VQUO_CODE", paramProcurformDAO.getQuo_code());
    localProcurformExt.setParam(":VSALE_OBJ_ID", paramProcurformDAO.getSale_obj_id());
    localProcurformExt.setParam(":VCONTACT_MAN", paramProcurformDAO.getContact_man());
    localProcurformExt.setParam(":VCONTACT", paramProcurformDAO.getContact());
    localProcurformExt.setParam(":VGIVE_DATE", paramProcurformDAO.getGive_date());
    localProcurformExt.setParam(":VGIVE_ADDR", paramProcurformDAO.getGive_addr());
    localProcurformExt.setParam(":VSHIP_TYPE", paramProcurformDAO.getShip_type());
    localProcurformExt.setParam(":VDOC_DATE", paramProcurformDAO.getDoc_date());
    localProcurformExt.setParam(":VCURRENCY_CODE", paramProcurformDAO.getCurrency_code());
    localProcurformExt.setParam(":VSALE_USER_ID", paramProcurformDAO.getSale_user_id());
    localProcurformExt.setParam(":VOWN_USER_ID", paramProcurformDAO.getOwn_user_id());
    localProcurformExt.setParam(":VOFF_COUNT", paramProcurformDAO.getOff_count());
    localProcurformExt.setParam(":VOFF_RATE", paramProcurformDAO.getOff_rate());
    localProcurformExt.setParam(":VSHIP_FEE", paramProcurformDAO.getShip_fee());
    localProcurformExt.setParam(":VTAX", paramProcurformDAO.getTax());
    localProcurformExt.setParam(":VALL_FEE", paramProcurformDAO.getAll_fee());
    localProcurformExt.setParam(":VORDER_COUNT", paramProcurformDAO.getOrder_count());
    localProcurformExt.setParam(":VPART_DELIVERY_TAG", paramProcurformDAO.getPart_delivery_tag());
    localProcurformExt.setParam(":VDELIVERY_NUM", paramProcurformDAO.getDelivery_num());
    localProcurformExt.setParam(":VOPER_USER_ID", paramProcurformDAO.getOper_user_id());
    localProcurformExt.setParam(":VREMARK2", paramProcurformDAO.getRemark2());
    localProcurformExt.setParam(":VRSRV_STR3", paramProcurformDAO.getRsrv_str3());
    localProcurformExt.setParam(":VRSRV_STR4", paramProcurformDAO.getRsrv_str4());
    localProcurformExt.setParam(":VRSRV_STR5", paramProcurformDAO.getRsrv_str5());
    localProcurformExt.setParam(":VRSRV_STR6", paramProcurformDAO.getRsrv_str6());
    this.tradeQuery.executeBy(localProcurformExt.insBy("UPDATE_PROCURFORM"));
    return 0;
  }

  public ArrayList getOneProcurform(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    ProcurformExt localProcurformExt = new ProcurformExt();
    localProcurformExt.setParam(":VCUST_ID", paramString1);
    localProcurformExt.setParam(":VQUO_ID", paramString2);
    localArrayList = localProcurformExt.selByList("SEL_ONE_BY_QUO_ID");
    return localArrayList;
  }

  public ArrayList getProcurList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ProcurformExt localProcurformExt = new ProcurformExt();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramInt *= 20;
      localProcurformExt.setParam(":VCUST_ID", paramString);
      localArrayList = localProcurformExt.selByList("SEL_ALL_PROCUR", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getProcurList(String paramString)
    throws SaasApplicationException
  {
    ProcurformExt localProcurformExt = new ProcurformExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localProcurformExt.setParam(":VCUST_ID", paramString);
      localArrayList = localProcurformExt.selByList("SEL_ALL_PROCUR");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.procurformMgr.ProcurformInfo
 * JD-Core Version:    0.6.0
 */