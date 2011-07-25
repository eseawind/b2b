package com.saas.biz.telbookMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.telbookDAO.TelbookDAO;
import com.saas.biz.dao.telbookDAO.TelbookExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TelBookInfo
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

  public void addTelBookInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addTelBookInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PHONE");
    String str2 = paramBuffers.getString("COMMENT");
    Integer localInteger = Integer.valueOf(Integer.parseInt(paramBuffers.getString("XSHARE")));
    String str3 = paramBuffers.getString("RECORDUSER");
    String str4 = paramBuffers.getString("SESSION_USER_NAME");
    String str5 = paramBuffers.getString("DEPART_CODE");
    try
    {
      TelbookDAO localTelbookDAO = new TelbookDAO(str1, str2, localInteger, str3, str5, str4);
      i = addTelBookInfo(localTelbookDAO);
    }
    catch (Exception localException)
    {
      i = -1;
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
    this.log.LOG_INFO("退出addTelBookInfo方法...");
  }

  public int addTelBookInfo(TelbookDAO paramTelbookDAO)
    throws SaasApplicationException
  {
    TelbookExt localTelbookExt = new TelbookExt();
    localTelbookExt.setParam(":VPHONE", paramTelbookDAO.getPhone());
    localTelbookExt.setParam(":VPART", paramTelbookDAO.getPart());
    localTelbookExt.setParam(":VCOMMENT", paramTelbookDAO.getComment());
    localTelbookExt.setParam(":VXSHARE", paramTelbookDAO.getXshare());
    localTelbookExt.setParam(":VUSER", paramTelbookDAO.getUser());
    localTelbookExt.setParam(":VRECORDUSER", paramTelbookDAO.getRecorduser());
    this.tradeQuery.executeBy(localTelbookExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateTelBookInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入updateTelBookInfo方法...");
    int i = -1;
    String str1 = paramBuffers.getString("ID");
    String str2 = paramBuffers.getString("PHONE");
    String str3 = paramBuffers.getString("COMMENT");
    Integer localInteger = Integer.valueOf(Integer.parseInt(paramBuffers.getString("XSHARE")));
    String str4 = paramBuffers.getString("RECORDUSER");
    try
    {
      TelbookDAO localTelbookDAO = new TelbookDAO();
      localTelbookDAO.setId(Integer.valueOf(Integer.parseInt(str1)));
      localTelbookDAO.setComment(str3);
      localTelbookDAO.setPhone(str2);
      localTelbookDAO.setRecorduser(str4);
      localTelbookDAO.setXshare(localInteger);
      i = updateTelBookInfo(localTelbookDAO);
    }
    catch (Exception localException)
    {
      i = -1;
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
    this.log.LOG_INFO("退出updateTelBookInfo方法...");
  }

  public int updateTelBookInfo(TelbookDAO paramTelbookDAO)
    throws SaasApplicationException
  {
    TelbookExt localTelbookExt = new TelbookExt();
    localTelbookExt.setParam(":VID", paramTelbookDAO.getId());
    localTelbookExt.setParam(":VPHONE", paramTelbookDAO.getPhone());
    localTelbookExt.setParam(":VCOMMENT", paramTelbookDAO.getComment());
    localTelbookExt.setParam(":VXSHARE", paramTelbookDAO.getXshare());
    localTelbookExt.setParam(":VRECORDUSER", paramTelbookDAO.getRecorduser());
    this.tradeQuery.executeBy(localTelbookExt.insBy("UPDATE_BY_ID"));
    return 0;
  }

  public void deleteTelBookInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteTelBookInfo方法...");
    int i = -1;
    String str = paramBuffers.getString("ID");
    try
    {
      i = deleteTelBookInfo(str);
    }
    catch (Exception localException)
    {
      i = -1;
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
    this.log.LOG_INFO("退出deleteTelBookInfo方法...");
  }

  public int deleteTelBookInfo(String paramString)
    throws SaasApplicationException
  {
    TelbookExt localTelbookExt = new TelbookExt();
    localTelbookExt.setParam(":VID", paramString);
    this.tradeQuery.executeBy(localTelbookExt.insBy("DELETE_BY_ID"));
    return 0;
  }

  public ArrayList getTelBookByUser(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TelbookExt localTelbookExt = new TelbookExt();
    localTelbookExt.setParam(":VUSER", paramString);
    localTelbookExt.setParam(":VUSER_NAME", "%" + paramString + "%");
    localArrayList = localTelbookExt.selByList("SEL_BY_USER");
    return localArrayList;
  }

  public ArrayList getTelBookById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    TelbookExt localTelbookExt = new TelbookExt();
    localTelbookExt.setParam(":VID", paramString);
    localArrayList = localTelbookExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public Map getTelBookByMap(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = getTelBookById(paramString);
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      str1 = localHashMap2.get("phone").toString();
      str2 = localHashMap2.get("comment").toString();
      str3 = localHashMap2.get("recorduser").toString();
    }
    localHashMap1.put("phone", str1);
    localHashMap1.put("comment", str2);
    localHashMap1.put("recorduser", str3);
    return localHashMap1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.telbookMgr.TelBookInfo
 * JD-Core Version:    0.6.0
 */