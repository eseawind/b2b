package com.saas.biz.shopCommandMgr;

import com.saas.biz.dao.shopCommandDAO.ShopCommandDAO;
import com.saas.biz.dao.shopCommandDAO.ShopCommandExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class ShopCommandInfo
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

  public void addCommandList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addCommandList方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TASK_ID");
    String str3 = paramBuffers.getString("CMD_ID");
    String str4 = paramBuffers.getString("CMD_ORDER");
    String str5 = paramBuffers.getString("CMD_OBJ_ID");
    String str6 = paramBuffers.getString("CMD_OBJ_NAME");
    String str7 = paramBuffers.getString("PRE_DATE");
    String str8 = paramBuffers.getString("ACT_DATE");
    String str9 = paramBuffers.getString("FROM_ADDR");
    String str10 = paramBuffers.getString("TO_ADDR");
    String str11 = paramBuffers.getString("SHIP_TYPE");
    String str12 = paramBuffers.getString("CMD_NUM");
    String str13 = paramBuffers.getString("UNIT");
    String str14 = paramBuffers.getString("STATE_CODE");
    String str15 = paramBuffers.getString("STATE_CODE_DATE");
    String str16 = paramBuffers.getString("SESSION_USER_ID");
    String str17 = paramBuffers.getString("PUBLISH_DATE");
    String str18 = paramBuffers.getString("REMARK");
    try
    {
      ShopCommandDAO localShopCommandDAO = new ShopCommandDAO();
      localShopCommandDAO.setCust_id(str1);
      localShopCommandDAO.setTask_id(str2);
      localShopCommandDAO.setCmd_id(str3);
      localShopCommandDAO.setCmd_order(str4);
      localShopCommandDAO.setCmd_obj_id(str5);
      localShopCommandDAO.setCmd_obj_name(str6);
      localShopCommandDAO.setPre_date(str7);
      localShopCommandDAO.setAct_date(str8);
      localShopCommandDAO.setFrom_addr(str9);
      localShopCommandDAO.setTo_addr(str10);
      localShopCommandDAO.setShip_type(str11);
      localShopCommandDAO.setCmd_num(str12);
      localShopCommandDAO.setUnit(str13);
      localShopCommandDAO.setState_code(str14);
      localShopCommandDAO.setState_code_date(str15);
      localShopCommandDAO.setUser_id(str16);
      localShopCommandDAO.setPublish_date(str17);
      localShopCommandDAO.setRemark(str18);
      i = addCommandList(localShopCommandDAO);
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
    this.log.LOG_INFO("退出addCommandList方法...");
  }

  public int addCommandList(ShopCommandDAO paramShopCommandDAO)
    throws SaasApplicationException
  {
    ShopCommandExt localShopCommandExt = new ShopCommandExt();
    localShopCommandExt.setParam(":VCUST_ID", paramShopCommandDAO.getCust_id());
    localShopCommandExt.setParam(":VTASK_ID", paramShopCommandDAO.getTask_id());
    localShopCommandExt.setParam(":VCMD_ID", paramShopCommandDAO.getCmd_id());
    localShopCommandExt.setParam(":VCMD_ORDER", paramShopCommandDAO.getCmd_order());
    localShopCommandExt.setParam(":VCMD_OBJ_ID", paramShopCommandDAO.getCmd_obj_id());
    localShopCommandExt.setParam(":VCMD_OBJ_NAME", paramShopCommandDAO.getCmd_obj_name());
    localShopCommandExt.setParam(":VPRE_DATE", paramShopCommandDAO.getPre_date());
    localShopCommandExt.setParam(":VACT_DATE", paramShopCommandDAO.getAct_date());
    localShopCommandExt.setParam(":VFROM_ADDR", paramShopCommandDAO.getFrom_addr());
    localShopCommandExt.setParam(":VTO_ADDR", paramShopCommandDAO.getTo_addr());
    localShopCommandExt.setParam(":VSHIP_TYPE", paramShopCommandDAO.getShip_type());
    localShopCommandExt.setParam(":VCMD_NUM", paramShopCommandDAO.getCmd_num());
    localShopCommandExt.setParam(":VUNIT", paramShopCommandDAO.getUnit());
    localShopCommandExt.setParam(":VSTATE_CODE", paramShopCommandDAO.getState_code());
    localShopCommandExt.setParam(":VSTATE_CODE_DATE", paramShopCommandDAO.getState_code_date());
    localShopCommandExt.setParam(":VUSER_ID", paramShopCommandDAO.getUser_id());
    localShopCommandExt.setParam(":VPUBLISH_DATE", paramShopCommandDAO.getPublish_date());
    localShopCommandExt.setParam(":VREMARK", paramShopCommandDAO.getRemark());
    this.tradeQuery.executeBy(localShopCommandExt.insBy("INS_BY_SHOP"));
    return 0;
  }

  public ArrayList getCommandList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ShopCommandExt localShopCommandExt = new ShopCommandExt();
    localShopCommandExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localShopCommandExt.selByList("SEL_BY_COMM", paramInt, 20);
    return localArrayList;
  }

  public int getCommandList(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ShopCommandExt localShopCommandExt = new ShopCommandExt();
    localShopCommandExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localShopCommandExt.selByList("SEL_BY_COMM");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public void modifyCommandList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyCommandList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CMD_ID");
    String str3 = paramBuffers.getString("CMD_ORDER");
    String str4 = paramBuffers.getString("CMD_OBJ_ID");
    String str5 = paramBuffers.getString("CMD_OBJ_NAME");
    String str6 = paramBuffers.getString("PRE_DATE");
    String str7 = paramBuffers.getString("ACT_DATE");
    String str8 = paramBuffers.getString("FROM_ADDR");
    String str9 = paramBuffers.getString("TO_ADDR");
    String str10 = paramBuffers.getString("SHIP_TYPE");
    String str11 = paramBuffers.getString("CMD_NUM");
    String str12 = paramBuffers.getString("UNIT");
    String str13 = paramBuffers.getString("STATE_CODE");
    String str14 = paramBuffers.getString("STATE_CODE_DATE");
    String str15 = paramBuffers.getString("SESSION_USER_ID");
    String str16 = paramBuffers.getString("PUBLISH_DATE");
    String str17 = paramBuffers.getString("REMARK");
    try
    {
      ShopCommandDAO localShopCommandDAO = new ShopCommandDAO();
      localShopCommandDAO.setCust_id(str1);
      localShopCommandDAO.setCmd_id(str2);
      localShopCommandDAO.setCmd_order(str3);
      localShopCommandDAO.setCmd_obj_id(str4);
      localShopCommandDAO.setCmd_obj_name(str5);
      localShopCommandDAO.setPre_date(str6);
      localShopCommandDAO.setAct_date(str7);
      localShopCommandDAO.setFrom_addr(str8);
      localShopCommandDAO.setTo_addr(str9);
      localShopCommandDAO.setShip_type(str10);
      localShopCommandDAO.setCmd_num(str11);
      localShopCommandDAO.setUnit(str12);
      localShopCommandDAO.setState_code(str13);
      localShopCommandDAO.setState_code_date(str14);
      localShopCommandDAO.setUser_id(str15);
      localShopCommandDAO.setPublish_date(str16);
      localShopCommandDAO.setRemark(str17);
      i = modifyCommandList(localShopCommandDAO);
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
    this.log.LOG_INFO("退出modifyCommandList方法...");
  }

  public int modifyCommandList(ShopCommandDAO paramShopCommandDAO)
    throws SaasApplicationException
  {
    ShopCommandExt localShopCommandExt = new ShopCommandExt();
    localShopCommandExt.setParam(":VCUST_ID", paramShopCommandDAO.getCust_id());
    localShopCommandExt.setParam(":VCMD_ID", paramShopCommandDAO.getCmd_id());
    localShopCommandExt.setParam(":VCMD_ORDER", paramShopCommandDAO.getCmd_order());
    localShopCommandExt.setParam(":VCMD_OBJ_ID", paramShopCommandDAO.getCmd_obj_id());
    localShopCommandExt.setParam(":VCMD_OBJ_NAME", paramShopCommandDAO.getCmd_obj_name());
    localShopCommandExt.setParam(":VPRE_DATE", paramShopCommandDAO.getPre_date());
    localShopCommandExt.setParam(":VACT_DATE", paramShopCommandDAO.getAct_date());
    localShopCommandExt.setParam(":VFROM_ADDR", paramShopCommandDAO.getFrom_addr());
    localShopCommandExt.setParam(":VTO_ADDR", paramShopCommandDAO.getTo_addr());
    localShopCommandExt.setParam(":VSHIP_TYPE", paramShopCommandDAO.getShip_type());
    localShopCommandExt.setParam(":VCMD_NUM", paramShopCommandDAO.getCmd_num());
    localShopCommandExt.setParam(":VUNIT", paramShopCommandDAO.getUnit());
    localShopCommandExt.setParam(":VSTATE_CODE", paramShopCommandDAO.getState_code());
    localShopCommandExt.setParam(":VSTATE_CODE_DATE", paramShopCommandDAO.getState_code_date());
    localShopCommandExt.setParam(":VUSER_ID", paramShopCommandDAO.getUser_id());
    localShopCommandExt.setParam(":VPUBLISH_DATE", paramShopCommandDAO.getPublish_date());
    localShopCommandExt.setParam(":VREMARK", paramShopCommandDAO.getRemark());
    this.tradeQuery.executeBy(localShopCommandExt.insBy("UP_COMM_BY_ALL"));
    return 0;
  }

  public ArrayList getListByValueId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ShopCommandExt localShopCommandExt = new ShopCommandExt();
    localShopCommandExt.setParam(":VCUST_ID", paramString1);
    localShopCommandExt.setParam(":VTEST_ID", paramString2);
    ArrayList localArrayList = localShopCommandExt.selByList("SEL_BY_VALUE_ID");
    return localArrayList;
  }

  public ArrayList getValueById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShopCommandExt localShopCommandExt = new ShopCommandExt();
    localShopCommandExt.setParam(":VCUST_ID", paramString);
    localArrayList = localShopCommandExt.selByList("SEL_BY_KKK");
    return localArrayList;
  }

  public ArrayList getOneValue(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ShopCommandExt localShopCommandExt = new ShopCommandExt();
    localShopCommandExt.setParam(":VCUST_ID", paramString1);
    localShopCommandExt.setParam(":VTEST_ID", paramString2);
    localArrayList = localShopCommandExt.selByList("SEL_ONE_BY_TEST_ID");
    return localArrayList;
  }

  public void delCommandList(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delCommandList方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CMD_ID");
    try
    {
      ShopCommandDAO localShopCommandDAO = new ShopCommandDAO();
      localShopCommandDAO.setCust_id(str1);
      localShopCommandDAO.setCmd_id(str2);
      i = delCommandList(localShopCommandDAO);
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
    this.log.LOG_INFO("退出delCommandList方法...");
  }

  public int delCommandList(ShopCommandDAO paramShopCommandDAO)
    throws SaasApplicationException
  {
    ShopCommandExt localShopCommandExt = new ShopCommandExt();
    localShopCommandExt.setParam(":VCUST_ID", paramShopCommandDAO.getCust_id());
    localShopCommandExt.setParam(":VCMD_ID", paramShopCommandDAO.getCmd_id());
    this.tradeQuery.executeBy(localShopCommandExt.insBy("DEL_COMM_BY_ALL"));
    return 0;
  }

  public ArrayList getListByTradeId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ShopCommandExt localShopCommandExt = new ShopCommandExt();
    localShopCommandExt.setParam(":VCUST_ID", paramString1);
    localShopCommandExt.setParam(":VCMD_ID", paramString2);
    ArrayList localArrayList = localShopCommandExt.selByList("SEL_BY_CMD_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.shopCommandMgr.ShopCommandInfo
 * JD-Core Version:    0.6.0
 */