package com.saas.biz.pleaseItemMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.tableitemDAO.TableitemDAO;
import com.saas.biz.dao.tableitemDAO.TableitemExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class PleaseItemInfo
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

  public void addPleaseItemInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addPleaseItemInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TABLE_ID");
    String str3 = paramBuffers.getString("TABLE_NAME");
    String str4 = paramBuffers.getString("ITEMS_ID");
    String str5 = paramBuffers.getString("ITEM_NAME");
    String str6 = paramBuffers.getString("ITEM_ID");
    String str7 = paramBuffers.getString("D_VALUE");
    String str8 = paramBuffers.getString("ENABLE_TAG");
    String str9 = paramBuffers.getString("NUM_VALUE");
    String str10 = paramBuffers.getString("REMARK2");
    try
    {
      TableitemDAO localTableitemDAO = new TableitemDAO();
      localTableitemDAO.setCust_id(str1);
      localTableitemDAO.setTable_id(str2);
      localTableitemDAO.setTable_name(str3);
      localTableitemDAO.setItem_id(str6);
      localTableitemDAO.setItems_id(str4);
      localTableitemDAO.setItem_name(str5);
      localTableitemDAO.setD_value(str7);
      localTableitemDAO.setEnable_tag(str8);
      localTableitemDAO.setNum_value(str9);
      localTableitemDAO.setRemark2(str10);
      i = addPleaseItemInfo(localTableitemDAO);
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
    this.log.LOG_INFO("退出addPleaseItemInfo方法...");
  }

  public int addPleaseItemInfo(TableitemDAO paramTableitemDAO)
    throws SaasApplicationException
  {
    TableitemExt localTableitemExt = new TableitemExt();
    localTableitemExt.setParam(":VCUST_ID", paramTableitemDAO.getCust_id());
    localTableitemExt.setParam(":VTABLE_ID", paramTableitemDAO.getTable_id());
    localTableitemExt.setParam(":VTABLE_NAME", paramTableitemDAO.getTable_name());
    localTableitemExt.setParam(":VITEM_ID", paramTableitemDAO.getItem_id());
    localTableitemExt.setParam(":VITEMS_ID", paramTableitemDAO.getItems_id());
    localTableitemExt.setParam(":VITEM_NAME", paramTableitemDAO.getItem_name());
    localTableitemExt.setParam(":VD_VALUE", paramTableitemDAO.getD_value());
    localTableitemExt.setParam(":VENABLE_TAG", paramTableitemDAO.getEnable_tag());
    localTableitemExt.setParam(":VNUM_VALUE", paramTableitemDAO.getNum_value());
    localTableitemExt.setParam(":VREMARK2", paramTableitemDAO.getRemark2());
    this.tradeQuery.executeBy(localTableitemExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void delPleaseItemInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delPleaseItemInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TABLE_ID");
    String str3 = paramBuffers.getString("ITEM_ID");
    try
    {
      TableitemDAO localTableitemDAO = new TableitemDAO();
      localTableitemDAO.setCust_id(str1);
      localTableitemDAO.setTable_id(str2);
      localTableitemDAO.setItem_id(str3);
      i = delPleaseItemInfo(localTableitemDAO);
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
    this.log.LOG_INFO("退出delPleaseItemInfo方法...");
  }

  public int delPleaseItemInfo(TableitemDAO paramTableitemDAO)
    throws SaasApplicationException
  {
    TableitemExt localTableitemExt = new TableitemExt();
    localTableitemExt.setParam(":VCUST_ID", paramTableitemDAO.getCust_id());
    localTableitemExt.setParam(":VTABLE_ID", paramTableitemDAO.getTable_id());
    localTableitemExt.setParam(":VITEM_ID", paramTableitemDAO.getItem_id());
    this.tradeQuery.executeBy(localTableitemExt.insBy("DEL_BY_ALL"));
    return 0;
  }

  public ArrayList getPleaseItemByItems(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    TableitemExt localTableitemExt = new TableitemExt();
    localTableitemExt.setParam(":VTABLE_ID", paramString1);
    localTableitemExt.setParam(":VITEMS_ID", paramString2);
    localTableitemExt.setParam(":VENABLE_TAG", paramString3);
    ArrayList localArrayList = localTableitemExt.selByList("SEL_BY_ITEMS");
    return localArrayList;
  }

  public ArrayList getPleaseItemByTable(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    TableitemExt localTableitemExt = new TableitemExt();
    localTableitemExt.setParam(":VTABLE_ID", paramString2);
    localTableitemExt.setParam(":VCUST_ID", paramString1);
    localTableitemExt.setParam(":VENABLE_TAG", paramString3);
    ArrayList localArrayList = localTableitemExt.selByList("SEL_BY_TABLE");
    return localArrayList;
  }

  public String getItemStrngByItems(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    String str1 = "";
    this.log.LOG_INFO("table_id==" + paramString1 + "items_id=" + paramString2);
    ArrayList localArrayList = getPleaseItemByItems(paramString1, paramString2, paramString3);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("item_name").toString();
        String str3 = localHashMap.get("item_id").toString();
        str1 = str1 + str2 + "<a href=/doTradeReg.do?trade_type_code=1059&table_id=" + paramString1 + "&item_id=" + str3 + " target=_self>【删除】</a><br>";
      }
    return str1;
  }

  public String getItemHtmlStrngByItems(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("table_id=" + paramString1 + "items_id=" + paramString2);
    String str1 = "<table width=100% border=0 cellspacing=1 cellpadding=0>";
    String str2 = "</table>";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    TableitemExt localTableitemExt = new TableitemExt();
    localTableitemExt.setParam(":VTABLE_ID", paramString1);
    localTableitemExt.setParam(":VITEMS_ID", paramString2);
    localTableitemExt.setParam(":VENABLE_TAG", "0");
    ArrayList localArrayList = localTableitemExt.selByList("SEL_BY_HTML");
    str4 = "<tr><td width=14% bgcolor=FFF9F3><div style=text-align:right; font-weight:bold;>条目名称 ：</div></td>";
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str7 = localHashMap.get("item_name").toString();
        String str8 = localHashMap.get("item_id").toString();
        String str9 = localHashMap.get("num_value").toString();
        str6 = localHashMap.get("p_type").toString();
        if ((str6 == "0") || (str6.equals("0")))
          str5 = str7 + "<input type=text name=re_value" + i + " id=re_value" + i + " ><br>" + str5;
        else if ((str6 == "1") || (str6.equals("1")))
          str5 = str5 + str7 + "<input type=radio name=re_value" + i + " id=re_value" + i + "  value=" + str8 + ">";
        else
          str5 = str5 + str7 + "<input type=checkbox name=re_value" + i + " id=re_value" + i + " value=" + str8 + ">";
        str5 = str5 + "<br>分值<input type=text readonly name=item_v id=item_v value=" + str9 + ">";
      }
    str4 = str4 + "<td width=14% bgcolor=FFF9F3><div style=text-align:right; font-weight:bold;>" + str5 + "</div></td></tr>";
    str3 = str1 + str4 + str2;
    return str3;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.pleaseItemMgr.PleaseItemInfo
 * JD-Core Version:    0.6.0
 */