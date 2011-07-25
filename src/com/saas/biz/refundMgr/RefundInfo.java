package com.saas.biz.refundMgr;

import com.saas.biz.dao.refundDAO.RefundDAO;
import com.saas.biz.dao.refundDAO.RefundExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RefundInfo
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

  public void addRefundInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addRefundInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_NAME");
    String str4 = paramBuffers.getString("QUO_ID");
    String str5 = paramBuffers.getString("SALE_QUO_ID");
    String str6 = paramBuffers.getString("BACK_TYPE");
    String str7 = paramBuffers.getString("BACK_DESC");
    String str8 = paramBuffers.getString("GIVE_DATE");
    String str9 = paramBuffers.getString("GIVE_ADDR");
    String str10 = paramBuffers.getString("SHIP_TYPE");
    String str11 = paramBuffers.getString("DOC_DATE");
    String str12 = paramBuffers.getString("CURRENCY_CODE");
    String str13 = paramBuffers.getString("OFF_COUNT");
    String str14 = paramBuffers.getString("OFF_RATE");
    String str15 = paramBuffers.getString("SHIP_FEE");
    String str16 = paramBuffers.getString("TAX");
    String str17 = paramBuffers.getString("ALL_FEE");
    String str18 = paramBuffers.getString("ALL_TAG");
    String str19 = paramBuffers.getString("BACK_NUM");
    String str20 = paramBuffers.getString("SURPLUS_NUM");
    String str21 = paramBuffers.getString("SESSION_USER_ID");
    String str22 = paramBuffers.getString("REMARK2");
    try
    {
      RefundDAO localRefundDAO = new RefundDAO();
      localRefundDAO.setCust_id(str1);
      localRefundDAO.setForm_id(str2);
      localRefundDAO.setQuo_name(str3);
      localRefundDAO.setQuo_id(str4);
      localRefundDAO.setSale_quo_id(str5);
      localRefundDAO.setBack_type(str6);
      localRefundDAO.setBack_desc(str7);
      localRefundDAO.setGive_date(str8);
      localRefundDAO.setGive_addr(str9);
      localRefundDAO.setShip_type(str10);
      localRefundDAO.setDoc_date(str11);
      localRefundDAO.setCurrency_code(str12);
      localRefundDAO.setOff_count(str13);
      localRefundDAO.setOff_rate(str14);
      localRefundDAO.setShip_fee(str15);
      localRefundDAO.setTax(str16);
      localRefundDAO.setAll_fee(str17);
      localRefundDAO.setAll_tag(str18);
      localRefundDAO.setBack_num(str19);
      localRefundDAO.setSurplus_num(str20);
      localRefundDAO.setOper_user_id(str21);
      localRefundDAO.setRemark2(str22);
      i = addRefundInfo(localRefundDAO);
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
    this.log.LOG_INFO("退出addRefundInfo方法...");
  }

  public int addRefundInfo(RefundDAO paramRefundDAO)
    throws SaasApplicationException
  {
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramRefundDAO.getCust_id());
    localRefundExt.setParam(":VFORM_ID", paramRefundDAO.getForm_id());
    localRefundExt.setParam(":VQUO_NAME", paramRefundDAO.getQuo_name());
    localRefundExt.setParam(":VQUO_ID", paramRefundDAO.getQuo_id());
    localRefundExt.setParam(":VSALE_QUO_ID", paramRefundDAO.getSale_quo_id());
    localRefundExt.setParam(":VBACK_TYPE", paramRefundDAO.getBack_type());
    localRefundExt.setParam(":VBACK_DESC", paramRefundDAO.getBack_desc());
    localRefundExt.setParam(":VGIVE_DATE", paramRefundDAO.getGive_date());
    localRefundExt.setParam(":VGIVE_ADDR", paramRefundDAO.getGive_addr());
    localRefundExt.setParam(":VSHIP_TYPE", paramRefundDAO.getShip_type());
    localRefundExt.setParam(":VDOC_DATE", paramRefundDAO.getDoc_date());
    localRefundExt.setParam(":VCURRENCY_CODE", paramRefundDAO.getCurrency_code());
    localRefundExt.setParam(":VOFF_COUNT", paramRefundDAO.getOff_count());
    localRefundExt.setParam(":VOFF_RATE", paramRefundDAO.getOff_rate());
    localRefundExt.setParam(":VSHIP_FEE", paramRefundDAO.getShip_fee());
    localRefundExt.setParam(":VTAX", paramRefundDAO.getTax());
    localRefundExt.setParam(":VALL_FEE", paramRefundDAO.getAll_fee());
    localRefundExt.setParam(":VALL_TAG", paramRefundDAO.getAll_tag());
    localRefundExt.setParam(":VBACK_NUM", paramRefundDAO.getBack_num());
    localRefundExt.setParam(":VSURPLUS_NUM", paramRefundDAO.getSurplus_num());
    localRefundExt.setParam(":VOPER_USER_ID", paramRefundDAO.getOper_user_id());
    localRefundExt.setParam(":VREMARK2", paramRefundDAO.getRemark2());
    this.tradeQuery.executeBy(localRefundExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void editRefundInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入editRefundInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_NAME");
    String str4 = paramBuffers.getString("QUO_ID");
    String str5 = paramBuffers.getString("SALE_QUO_ID");
    String str6 = paramBuffers.getString("BACK_TYPE");
    String str7 = paramBuffers.getString("BACK_DESC");
    String str8 = paramBuffers.getString("GIVE_DATE");
    String str9 = paramBuffers.getString("GIVE_ADDR");
    String str10 = paramBuffers.getString("SHIP_TYPE");
    String str11 = paramBuffers.getString("DOC_DATE");
    String str12 = paramBuffers.getString("CURRENCY_CODE");
    String str13 = paramBuffers.getString("OFF_COUNT");
    String str14 = paramBuffers.getString("OFF_RATE");
    String str15 = paramBuffers.getString("SHIP_FEE");
    String str16 = paramBuffers.getString("TAX");
    String str17 = paramBuffers.getString("ALL_FEE");
    String str18 = paramBuffers.getString("ALL_TAG");
    String str19 = paramBuffers.getString("BACK_NUM");
    String str20 = paramBuffers.getString("SURPLUS_NUM");
    String str21 = paramBuffers.getString("SESSION_USER_ID");
    String str22 = paramBuffers.getString("REMARK2");
    try
    {
      RefundDAO localRefundDAO = new RefundDAO();
      localRefundDAO.setCust_id(str1);
      localRefundDAO.setForm_id(str2);
      localRefundDAO.setQuo_name(str3);
      localRefundDAO.setQuo_id(str4);
      localRefundDAO.setSale_quo_id(str5);
      localRefundDAO.setBack_type(str6);
      localRefundDAO.setBack_desc(str7);
      localRefundDAO.setGive_date(str8);
      localRefundDAO.setGive_addr(str9);
      localRefundDAO.setShip_type(str10);
      localRefundDAO.setDoc_date(str11);
      localRefundDAO.setCurrency_code(str12);
      localRefundDAO.setOff_count(str13);
      localRefundDAO.setOff_rate(str14);
      localRefundDAO.setShip_fee(str15);
      localRefundDAO.setTax(str16);
      localRefundDAO.setAll_fee(str17);
      localRefundDAO.setAll_tag(str18);
      localRefundDAO.setBack_num(str19);
      localRefundDAO.setSurplus_num(str20);
      localRefundDAO.setOper_user_id(str21);
      localRefundDAO.setRemark2(str22);
      i = editRefundInfo(localRefundDAO);
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
    this.log.LOG_INFO("退出addRefundInfo方法...");
  }

  public int editRefundInfo(RefundDAO paramRefundDAO)
    throws SaasApplicationException
  {
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramRefundDAO.getCust_id());
    localRefundExt.setParam(":VFORM_ID", paramRefundDAO.getForm_id());
    localRefundExt.setParam(":VQUO_NAME", paramRefundDAO.getQuo_name());
    localRefundExt.setParam(":VQUO_ID", paramRefundDAO.getQuo_id());
    localRefundExt.setParam(":VSALE_QUO_ID", paramRefundDAO.getSale_quo_id());
    localRefundExt.setParam(":VBACK_TYPE", paramRefundDAO.getBack_type());
    localRefundExt.setParam(":VBACK_DESC", paramRefundDAO.getBack_desc());
    localRefundExt.setParam(":VGIVE_DATE", paramRefundDAO.getGive_date());
    localRefundExt.setParam(":VGIVE_ADDR", paramRefundDAO.getGive_addr());
    localRefundExt.setParam(":VSHIP_TYPE", paramRefundDAO.getShip_type());
    localRefundExt.setParam(":VDOC_DATE", paramRefundDAO.getDoc_date());
    localRefundExt.setParam(":VCURRENCY_CODE", paramRefundDAO.getCurrency_code());
    localRefundExt.setParam(":VOFF_COUNT", paramRefundDAO.getOff_count());
    localRefundExt.setParam(":VOFF_RATE", paramRefundDAO.getOff_rate());
    localRefundExt.setParam(":VSHIP_FEE", paramRefundDAO.getShip_fee());
    localRefundExt.setParam(":VTAX", paramRefundDAO.getTax());
    localRefundExt.setParam(":VALL_FEE", paramRefundDAO.getAll_fee());
    localRefundExt.setParam(":VALL_TAG", paramRefundDAO.getAll_tag());
    localRefundExt.setParam(":VBACK_NUM", paramRefundDAO.getBack_num());
    localRefundExt.setParam(":VSURPLUS_NUM", paramRefundDAO.getSurplus_num());
    localRefundExt.setParam(":VOPER_USER_ID", paramRefundDAO.getOper_user_id());
    localRefundExt.setParam(":VREMARK2", paramRefundDAO.getRemark2());
    this.tradeQuery.executeBy(localRefundExt.insBy("UPDATE_BY_ALL"));
    return 0;
  }

  public void delRefundInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delRefundInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("FORM_ID");
    String str3 = paramBuffers.getString("QUO_ID");
    String str4 = paramBuffers.getString("SALE_QUO_ID");
    try
    {
      RefundDAO localRefundDAO = new RefundDAO();
      localRefundDAO.setCust_id(str1);
      localRefundDAO.setForm_id(str2);
      localRefundDAO.setQuo_id(str3);
      localRefundDAO.setSale_quo_id(str4);
      i = delRefundInfo(localRefundDAO);
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
    this.log.LOG_INFO("退出addRefundInfo方法...");
  }

  public int delRefundInfo(RefundDAO paramRefundDAO)
    throws SaasApplicationException
  {
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramRefundDAO.getCust_id());
    localRefundExt.setParam(":VFORM_ID", paramRefundDAO.getForm_id());
    localRefundExt.setParam(":VQUO_ID", paramRefundDAO.getQuo_id());
    localRefundExt.setParam(":VSALE_QUO_ID", paramRefundDAO.getSale_quo_id());
    this.tradeQuery.executeBy(localRefundExt.insBy("DEL_BY_ALL"));
    return 0;
  }

  public ArrayList getRefundList(String paramString, int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localRefundExt.selByList("SEL_BY_CUST", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getProcurRefundList(String paramString, int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localRefundExt.selByList("SEL_BACKFROM_BY_PROCUR", paramInt, 20);
    return localArrayList;
  }

  public int getProcurRefundList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localRefundExt.selByList("SEL_BACKFROM_BY_PROCUR");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getGoodsGetuseRefundList(String paramString, int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localRefundExt.selByList("SEL_BACKFROM_BY_GOODS_GETUSE", paramInt, 20);
    return localArrayList;
  }

  public int getGoodsGetuseRefundList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localRefundExt.selByList("SEL_BACKFROM_BY_GOODS_GETUSE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public int getRefundSize(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localRefundExt.selByList("SEL_SIZE_BY_CUST");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int j = 0; j < localArrayList.size(); j++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(j);
        i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    return i;
  }

  public int getRefundTypeSize(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VBACK_TYPE", paramString2);
    localRefundExt.setParam(":VCUST_ID", paramString1);
    ArrayList localArrayList = localRefundExt.selByList("SEL_CT_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int j = 0; j < localArrayList.size(); j++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(j);
        i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    return i;
  }

  public HashMap getRefundInfoById(String paramString)
    throws SaasApplicationException
  {
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VQUO_ID", paramString);
    ArrayList localArrayList = localRefundExt.selByList("SEL_BY_ID");
    HashMap localHashMap = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public String getJsonDataByCust(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString1);
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    ArrayList localArrayList = localRefundExt.selByList("SEL_BY_CUST", paramInt, 10);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("quo_id").toString();
        String str3 = localHashMap.get("quo_name").toString();
        String str4 = "";
        String str5 = "";
        if (localHashMap.get("form_id") != null)
          str5 = localHashMap.get("form_id").toString();
        if (localHashMap.get("back_type") != null)
          str4 = localHashMap.get("back_type").toString();
        String str6 = "";
        if (localHashMap.get("give_date") != null)
        {
          str6 = localHashMap.get("give_date").toString();
          if (str6.length() > 10)
            str6 = str6.substring(0, 10);
        }
        String str7 = "";
        if (localHashMap.get("give_addr") != null)
          str7 = localHashMap.get("give_addr").toString();
        String str8 = "";
        if (localHashMap.get("sale_quo_id") != null)
          str8 = localHashMap.get("sale_quo_id").toString();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("sale_quo_id", str8);
        localJSONObject2.put("give_addr", str7);
        localJSONObject2.put("give_date", str6);
        localJSONObject2.put("form_id", str5);
        localJSONObject2.put("back_type", str4);
        localJSONObject2.put("quo_name", str3);
        localJSONObject2.put("id", str2);
        localJSONArray.add(localJSONObject2);
      }
    int i = getRefundSize(paramString1);
    localJSONObject1.put("root", localJSONArray);
    localJSONObject1.put("total", Integer.valueOf(i));
    str1 = localJSONObject1.toString();
    this.log.LOG_INFO(str1);
    return str1;
  }

  public ArrayList getChangeInByProcur(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString1);
    localRefundExt.setParam(":VBACK_TYPE", paramString2);
    ArrayList localArrayList = localRefundExt.selByList("SEL_CHANGIN_BY_PROCUR", paramInt, 20);
    return localArrayList;
  }

  public int getChangeInByProcur(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString1);
    localRefundExt.setParam(":VBACK_TYPE", paramString2);
    ArrayList localArrayList = localRefundExt.selByList("SEL_CHANGIN_BY_PROCUR");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getChangeInByGoodsGetuse(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString1);
    localRefundExt.setParam(":VBACK_TYPE", paramString2);
    ArrayList localArrayList = localRefundExt.selByList("SEL_CHANGIN_BY_GOODS_GETUSE", paramInt, 20);
    return localArrayList;
  }

  public int getChangeInByGoodsGetuse(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString1);
    localRefundExt.setParam(":VBACK_TYPE", paramString2);
    ArrayList localArrayList = localRefundExt.selByList("SEL_CHANGIN_BY_GOODS_GETUSE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public String getProcurByBackType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString1);
    localRefundExt.setParam(":VBACK_TYPE", paramString2);
    ArrayList localArrayList = localRefundExt.selByList("SEL_PROCUR_BY_BACK_TYPE");
    HashMap localHashMap = new HashMap();
    String str1 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("quo_name").toString();
        String str3 = localHashMap.get("quo_id").toString();
        str1 = str1 + "<option quo_id=" + str3 + ">" + str2 + "</option>";
      }
    return str1;
  }

  public ArrayList getChangeInById(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString1);
    localRefundExt.setParam(":VBACK_TYPE", paramString2);
    ArrayList localArrayList = localRefundExt.selByList("SEL_CHANGIN_BY_PRO", paramInt, 20);
    return localArrayList;
  }

  public int getChangeInById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    int i = 0;
    RefundExt localRefundExt = new RefundExt();
    localRefundExt.setParam(":VCUST_ID", paramString1);
    localRefundExt.setParam(":VBACK_TYPE", paramString2);
    ArrayList localArrayList = localRefundExt.selByList("SEL_CHANGIN_BY_PRO");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.refundMgr.RefundInfo
 * JD-Core Version:    0.6.0
 */