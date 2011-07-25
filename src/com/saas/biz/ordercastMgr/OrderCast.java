package com.saas.biz.ordercastMgr;

import com.saas.biz.dao.ordercastDAO.OrderCastDAO;
import com.saas.biz.dao.ordercastDAO.OrderCastExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderCast
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

  public void AddCasts(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入AddCasts方法...");
    this.outBuffer = paramBuffers;
    OrderCastDAO localOrderCastDAO = new OrderCastDAO();
    localOrderCastDAO.setInfo_id(paramBuffers.getString("INFO_ID"));
    localOrderCastDAO.setCust_class(paramBuffers.getString("CUST_CLASS"));
    localOrderCastDAO.setInfo_type(paramBuffers.getString("INFO_TYPE"));
    localOrderCastDAO.setInfo_title(paramBuffers.getString("INFO_TITLE"));
    localOrderCastDAO.setInfo_no(paramBuffers.getString("INFO_NO"));
    localOrderCastDAO.setStart_date(paramBuffers.getString("START_DATE"));
    localOrderCastDAO.setEnd_date(paramBuffers.getString("END_DATE"));
    localOrderCastDAO.setOper_user_id(paramBuffers.getString("SESSION_USER_ID"));
    localOrderCastDAO.setRemark(paramBuffers.getString("REMARK"));
    int i = -1;
    try
    {
      i = AddCasts(localOrderCastDAO);
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
    this.log.LOG_INFO("退出AddCasts方法...");
  }

  public int AddCasts(OrderCastDAO paramOrderCastDAO)
    throws SaasApplicationException
  {
    OrderCastExt localOrderCastExt = new OrderCastExt();
    String str1 = paramOrderCastDAO.getInfo_no();
    String str2 = paramOrderCastDAO.getInfo_id();
    String str3 = paramOrderCastDAO.getCust_class();
    String str4 = paramOrderCastDAO.getInfo_type();
    localOrderCastExt.setParam(":VINFO_ID", paramOrderCastDAO.getInfo_id());
    localOrderCastExt.setParam(":VCUST_CLASS", paramOrderCastDAO.getCust_class());
    localOrderCastExt.setParam(":VINFO_TYPE", paramOrderCastDAO.getInfo_type());
    localOrderCastExt.setParam(":VINFO_TITLE", paramOrderCastDAO.getInfo_title());
    localOrderCastExt.setParam(":VINFO_NO", paramOrderCastDAO.getInfo_no());
    localOrderCastExt.setParam(":VSTART_DATE", paramOrderCastDAO.getStart_date());
    localOrderCastExt.setParam(":VEND_DATE", paramOrderCastDAO.getEnd_date());
    localOrderCastExt.setParam(":VOPER_USER_ID", paramOrderCastDAO.getOper_user_id());
    localOrderCastExt.setParam(":VREMARK", paramOrderCastDAO.getRemark());
    HashMap localHashMap = getCastById(str2);
    if ((localHashMap != null) && (localHashMap.size() > 0))
    {
      this.log.LOG_INFO("开始执行updateSQL:" + localOrderCastExt.insBy("UPDATE_BY_IT"));
      this.tradeQuery.executeBy(localOrderCastExt.insBy("UPDATE_BY_IT"));
    }
    else
    {
      this.log.LOG_INFO("开始执行insertSQL:" + localOrderCastExt.insBy("INS_BY_ALL"));
      this.tradeQuery.executeBy(localOrderCastExt.insBy("INS_BY_ALL"));
    }
    return 0;
  }

  public int checkrights(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OrderCastExt localOrderCastExt = new OrderCastExt();
    localOrderCastExt.setParam(":VINFO_ID", paramString1);
    localOrderCastExt.setParam(":VCUST_CLASS", paramString2);
    localOrderCastExt.setParam(":VINFO_TYPE", paramString3);
    localOrderCastExt.setParam(":VINFO_NO", paramString4);
    localArrayList = localOrderCastExt.selByList("SEL_BY_INFO_NO");
    if (localArrayList == null)
      return 0;
    return 1;
  }

  public ArrayList getCastById(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    OrderCastExt localOrderCastExt = new OrderCastExt();
    localOrderCastExt.setParam(":VINFO_ID", paramString3);
    localOrderCastExt.setParam(":VCUST_CLASS", paramString1);
    localOrderCastExt.setParam(":VINFO_TYPE", paramString2);
    localArrayList = localOrderCastExt.selByList("SEL_CAST_BY_TYPE");
    return localArrayList;
  }

  public HashMap getCastById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    OrderCastExt localOrderCastExt = new OrderCastExt();
    localOrderCastExt.setParam(":VINFO_ID", paramString);
    ArrayList localArrayList = localOrderCastExt.selByList("SEL_CAST_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getRecommendJob(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    OrderCastExt localOrderCastExt = new OrderCastExt();
    ArrayList localArrayList = localOrderCastExt.selByList("SEL_BY_JOB", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getRecommendJobAll(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    OrderCastExt localOrderCastExt = new OrderCastExt();
    ArrayList localArrayList = localOrderCastExt.selByList("SEL_BY_JOB_ALL", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getRecommendResume(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    OrderCastExt localOrderCastExt = new OrderCastExt();
    ArrayList localArrayList = localOrderCastExt.selByList("SEL_BY_RESUME", paramInt1, paramInt2);
    return localArrayList;
  }

  public void delOrderCastInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delProductInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("INFO_ID");
    try
    {
      OrderCastDAO localOrderCastDAO = new OrderCastDAO();
      localOrderCastDAO.setInfo_id(paramBuffers.getString("INFO_ID"));
      i = delOrderCastInfo(localOrderCastDAO);
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
    this.log.LOG_INFO("退出delProductInfo方法...");
  }

  public int delOrderCastInfo(OrderCastDAO paramOrderCastDAO)
    throws SaasApplicationException
  {
    OrderCastExt localOrderCastExt = new OrderCastExt();
    localOrderCastExt.setParam(":VINFO_ID", paramOrderCastDAO.getInfo_id());
    this.tradeQuery.executeBy(localOrderCastExt.insBy("DEL_BY_RESUME"));
    return 0;
  }

  public boolean checkInfo_no(String paramString1, String paramString2)
  {
    OrderCastExt localOrderCastExt = new OrderCastExt();
    localOrderCastExt.setParam(":VINFO_TYPE", paramString2);
    localOrderCastExt.setParam(":VINFO_NO", paramString1);
    ArrayList localArrayList = localOrderCastExt.selByList("SEL_BY_NO_TYPE");
    return (localArrayList == null) || (localArrayList.size() <= 0);
  }

  public boolean checkNewsInfo_no(String paramString1, String paramString2, String paramString3)
  {
    OrderCastExt localOrderCastExt1 = new OrderCastExt();
    localOrderCastExt1.setParam(":VINFO_TYPE", paramString2);
    localOrderCastExt1.setParam(":VINFO_NO", paramString1);
    ArrayList localArrayList1 = localOrderCastExt1.selByList("SEL_BY_NO_TYPE");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)localArrayList1.get(i);
        String str = "";
        if ((localHashMap1.get("info_id") == null) || (localHashMap1.get("info_id") == ""))
          continue;
        str = localHashMap1.get("info_id").toString();
        OrderCastExt localOrderCastExt2 = new OrderCastExt();
        localOrderCastExt2.setParam(":VINFO_ID", str);
        this.log.LOG_INFO("第2个之前");
        ArrayList localArrayList2 = localOrderCastExt2.selByList("SEL_BY_NEWS_TYPE");
        this.log.LOG_INFO("第2个之后");
        HashMap localHashMap2 = (HashMap)localArrayList2.get(0);
        if ((localHashMap2.get("NEWS_ID") != null) && (localHashMap2.get("NEWS_ID") != "") && (paramString3.equals(localHashMap2.get("").toString())))
          return false;
      }
    return true;
  }

  public HashMap getCastByIdandType(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    OrderCastExt localOrderCastExt = new OrderCastExt();
    localOrderCastExt.setParam(":VINFO_ID", paramString1);
    localOrderCastExt.setParam(":VINFO_TYPE", paramString2);
    ArrayList localArrayList = localOrderCastExt.selByList("SEL_BY_ID_TYPE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localHashMap = (HashMap)localArrayList.get(0);
      return localHashMap;
    }
    return null;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.ordercastMgr.OrderCast
 * JD-Core Version:    0.6.0
 */