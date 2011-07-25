package com.saas.biz.damageMgr;

import com.saas.biz.dao.damageDAO.DamageDAO;
import com.saas.biz.dao.damageDAO.DamageExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class DamageInfo
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

  public void addDamageInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addDamageInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_ID");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("DAMAGE_ID");
    String str4 = paramBuffers.getString("DAMAGE_NAME");
    String str5 = paramBuffers.getString("GOODS_ID");
    String str6 = paramBuffers.getString("GOODS_NAME");
    String str7 = paramBuffers.getString("DAMAGE_NUM");
    String str8 = paramBuffers.getString("GAMAGE_STATE");
    String str9 = paramBuffers.getString("GAMAGE_DATE");
    String str10 = paramBuffers.getString("GAMAGE_RESEAN");
    String str11 = "";
    String str12 = paramBuffers.getString("SESSION_CUST_ID");
    String str13 = paramBuffers.getString("REMARK");
    try
    {
      DamageDAO localDamageDAO = new DamageDAO();
      localDamageDAO.setTrade_id(str1);
      localDamageDAO.setCust_id(str2);
      localDamageDAO.setDamage_id(str3);
      localDamageDAO.setDamage_name(str4);
      localDamageDAO.setDamage_num(str7);
      localDamageDAO.setGamage_date(str9);
      localDamageDAO.setGamage_resean(str10);
      localDamageDAO.setGamage_state(str8);
      localDamageDAO.setGoods_id(str5);
      localDamageDAO.setGoods_name(str6);
      localDamageDAO.setOper_date(str11);
      localDamageDAO.setOper_user_id(str12);
      localDamageDAO.setRemark(str13);
      i = addDamageInfo(localDamageDAO);
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
    this.log.LOG_INFO("退出addDamageInfo方法...");
  }

  public int addDamageInfo(DamageDAO paramDamageDAO)
    throws SaasApplicationException
  {
    DamageExt localDamageExt = new DamageExt();
    localDamageExt.setParam(":VTRADE_ID", paramDamageDAO.getTrade_id());
    localDamageExt.setParam(":VCUST_ID", paramDamageDAO.getCust_id());
    localDamageExt.setParam(":VGOODS_ID", paramDamageDAO.getGoods_id());
    localDamageExt.setParam(":VDAMAGE_ID", paramDamageDAO.getDamage_id());
    localDamageExt.setParam(":VDAMAGE_NAME", paramDamageDAO.getDamage_name());
    localDamageExt.setParam(":VGOODS_NAME", paramDamageDAO.getGoods_name());
    localDamageExt.setParam(":VDAMAGE_NUM", paramDamageDAO.getDamage_num());
    localDamageExt.setParam(":VGAMAGE_STATE", paramDamageDAO.getGamage_state());
    localDamageExt.setParam(":VGAMAGE_DATE", paramDamageDAO.getGamage_date());
    localDamageExt.setParam(":VGAMAGE_RESEAN", paramDamageDAO.getGamage_resean());
    localDamageExt.setParam(":VOPER_DATE", paramDamageDAO.getOper_date());
    localDamageExt.setParam(":VOPER_USER_ID", paramDamageDAO.getOper_user_id());
    localDamageExt.setParam(":VREMARK", paramDamageDAO.getRemark());
    this.tradeQuery.executeBy(localDamageExt.insBy("INS_BY_DAMAGE"));
    return 0;
  }

  public void modifyDamageInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyDamageInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("DAMAGE_ID");
    String str3 = "1";
    String str4 = paramBuffers.getString("DAMAGE_NUM");
    try
    {
      DamageDAO localDamageDAO = new DamageDAO();
      localDamageDAO.setCust_id(str1);
      localDamageDAO.setDamage_id(str2);
      localDamageDAO.setDamage_num(str4);
      localDamageDAO.setGamage_state(str3);
      i = modifyDamageInfo(localDamageDAO);
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
    this.log.LOG_INFO("退出modifyDamageInfo方法...");
  }

  public int modifyDamageInfo(DamageDAO paramDamageDAO)
    throws SaasApplicationException
  {
    DamageExt localDamageExt = new DamageExt();
    localDamageExt.setParam(":VCUST_ID", paramDamageDAO.getCust_id());
    localDamageExt.setParam(":VDAMAGE_ID", paramDamageDAO.getDamage_id());
    localDamageExt.setParam(":VGAMAGE_STATE", paramDamageDAO.getGamage_state());
    localDamageExt.setParam(":VDAMAGE_NUM", paramDamageDAO.getDamage_num());
    this.tradeQuery.executeBy(localDamageExt.insBy("UP_DAMAGE_BY_ALL_AGAIN"));
    return 0;
  }

  public ArrayList getById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    DamageExt localDamageExt = new DamageExt();
    localDamageExt.setParam(":VCUST_ID", paramString1);
    localDamageExt.setParam(":VGAMAGE_STATE", paramString2);
    localArrayList = localDamageExt.selByList("SEL_BY_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.damageMgr.DamageInfo
 * JD-Core Version:    0.6.0
 */