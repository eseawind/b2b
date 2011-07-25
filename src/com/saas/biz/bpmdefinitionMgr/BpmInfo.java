package com.saas.biz.bpmdefinitionMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.bpm.BpmExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class BpmInfo
{
  Logger log = new Logger(this);
  commMethodMgr commen = new commMethodMgr();
  ArrayList queryResult = new ArrayList();
  Buffers inBuffer;
  Buffers outBuffer;
  Dbtable tradeQuery = new Dbtable();

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

  public ArrayList getBpmAll(int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    BpmExt localBpmExt = new BpmExt();
    localArrayList = localBpmExt.selByList("SEL_ALL_BPM", paramInt, 30);
    return localArrayList;
  }

  public int getBpmAll()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    BpmExt localBpmExt = new BpmExt();
    localArrayList = localBpmExt.selByList("SEL_ALL_BPM");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void delBpmInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delBpmInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_TYPE_CODE1");
    String str2 = paramBuffers.getString("BPM_ID");
    String str3 = paramBuffers.getString("NODE_CLASS");
    String str4 = paramBuffers.getString("NODE_METHOD");
    try
    {
      i = delBpmInfo(str1, str2, str3, str4);
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
    this.log.LOG_INFO("退出delBpmInfo方法...");
  }

  public int delBpmInfo(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    BpmExt localBpmExt = new BpmExt();
    localBpmExt.setParam(":VTRADE_TYPE_CODE", paramString1);
    localBpmExt.setParam(":VBPM_ID", paramString2);
    localBpmExt.setParam(":VNODE_CLASS", paramString3);
    localBpmExt.setParam(":VUNDO_METHOD", paramString4);
    this.tradeQuery.executeBy(localBpmExt.insBy("DEL_BPM_BY_TRADE_TYPE_CODE"));
    return 0;
  }

  public void addBpmInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addBpmInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_TYPE_CODE2");
    String str2 = paramBuffers.getString("BPM_ID");
    String str3 = paramBuffers.getString("NODE_ID");
    String str4 = paramBuffers.getString("NODE_TYPE");
    String str5 = paramBuffers.getString("NODE_SEQUENCE");
    String str6 = paramBuffers.getString("NODE_CLASS");
    String str7 = paramBuffers.getString("NODE_METHOD");
    String str8 = paramBuffers.getString("OUT_QUERY");
    String str9 = paramBuffers.getString("OUT_BUFFER");
    String str10 = paramBuffers.getString("UNDO_TAG");
    String str11 = paramBuffers.getString("UNDE_CLASS");
    String str12 = paramBuffers.getString("UNDO_METHOD");
    String str13 = paramBuffers.getString("UNDO_OUT_QUERY");
    String str14 = paramBuffers.getString("UNDO_OUT_BUFFER");
    String str15 = paramBuffers.getString("RSRV_STR1");
    String str16 = paramBuffers.getString("RSRV_STR2");
    String str17 = paramBuffers.getString("RSRV_STR3");
    String str18 = paramBuffers.getString("RSRV_STR4");
    String str19 = paramBuffers.getString("RSRV_STR5");
    String str20 = paramBuffers.getString("RSRV_STR6");
    String str21 = paramBuffers.getString("RSRV_STR7");
    String str22 = paramBuffers.getString("RSRV_STR8");
    String str23 = paramBuffers.getString("RSRV_STR9");
    String str24 = paramBuffers.getString("RSRV_STR0");
    String str25 = paramBuffers.getString("REMARK");
    try
    {
      i = addBpmInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25);
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
    this.log.LOG_INFO("退出addBpmInfo方法...");
  }

  public int addBpmInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25)
    throws SaasApplicationException
  {
    BpmExt localBpmExt = new BpmExt();
    localBpmExt.setParam(":VTRADE_TYPE_CODE", paramString1);
    localBpmExt.setParam(":VBPM_ID", paramString2);
    localBpmExt.setParam(":VNODE_ID", paramString3);
    localBpmExt.setParam(":VNODE_TYPE", paramString4);
    localBpmExt.setParam(":VNODE_SEQUENCE", paramString5);
    localBpmExt.setParam(":VNODE_CLASS", paramString6);
    localBpmExt.setParam(":VNODE_METHOD", paramString7);
    localBpmExt.setParam(":VOUT_QUERY", paramString8);
    localBpmExt.setParam(":VOUT_BUFFER", paramString9);
    localBpmExt.setParam(":VUNDO_TAG", paramString10);
    localBpmExt.setParam(":VUNDE_CLASS", paramString11);
    localBpmExt.setParam(":VUNDO_METHOD", paramString12);
    localBpmExt.setParam(":VUNDO_OUT_QUERY", paramString13);
    localBpmExt.setParam(":VUNDO_OUT_BUFFER", paramString14);
    localBpmExt.setParam(":VRSRV_STR1", paramString15);
    localBpmExt.setParam(":VRSRV_STR2", paramString16);
    localBpmExt.setParam(":VRSRV_STR3", paramString17);
    localBpmExt.setParam(":VRSRV_STR4", paramString18);
    localBpmExt.setParam(":VRSRV_STR5", paramString19);
    localBpmExt.setParam(":VRSRV_STR6", paramString20);
    localBpmExt.setParam(":VRSRV_STR7", paramString21);
    localBpmExt.setParam(":VRSRV_STR8", paramString22);
    localBpmExt.setParam(":VRSRV_STR9", paramString23);
    localBpmExt.setParam(":VRSRV_STR0", paramString24);
    localBpmExt.setParam(":VREMARK", paramString25);
    ArrayList localArrayList = new ArrayList();
    localArrayList = getOneBpm(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      this.tradeQuery.executeBy(localBpmExt.insBy("UPDATE_BPM_INFO"));
    else
      this.tradeQuery.executeBy(localBpmExt.insBy("INS_BPM_INFO"));
    return 0;
  }

  public ArrayList getOneBpm(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    BpmExt localBpmExt = new BpmExt();
    localBpmExt.setParam(":VTRADETYPECODE", paramString);
    localArrayList = localBpmExt.selByList("SEL_BY_PK");
    return localArrayList;
  }

  public int getOneBpmByCt(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    BpmExt localBpmExt = new BpmExt();
    localBpmExt.setParam(":VTRADETYPECODE", paramString);
    localArrayList = localBpmExt.selByList("SEL_BY_PK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 1;
    return 0;
  }

  public ArrayList getOneBpmNode(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 30;
    ArrayList localArrayList = new ArrayList();
    BpmExt localBpmExt = new BpmExt();
    localBpmExt.setParam(":VNODE_CLASS", "%" + paramString + "%");
    localArrayList = localBpmExt.selByList("SEL_BY_PK_1", paramInt, 30);
    return localArrayList;
  }

  public int getOneBpmNode(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    BpmExt localBpmExt = new BpmExt();
    localBpmExt.setParam(":VNODE_CLASS", "%" + paramString + "%");
    localArrayList = localBpmExt.selByList("SEL_BY_PK_1");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void updateBpmInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addBpmInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("TRADE_TYPE_CODE2");
    String str2 = paramBuffers.getString("BPM_ID");
    String str3 = paramBuffers.getString("NODE_ID");
    String str4 = paramBuffers.getString("NODE_TYPE");
    String str5 = paramBuffers.getString("NODE_SEQUENCE");
    String str6 = paramBuffers.getString("NODE_CLASS");
    String str7 = paramBuffers.getString("NODE_METHOD");
    String str8 = paramBuffers.getString("OUT_QUERY");
    String str9 = paramBuffers.getString("OUT_BUFFER");
    String str10 = paramBuffers.getString("UNDO_TAG");
    String str11 = paramBuffers.getString("UNDE_CLASS");
    String str12 = paramBuffers.getString("UNDO_METHOD");
    String str13 = paramBuffers.getString("UNDO_OUT_QUERY");
    String str14 = paramBuffers.getString("UNDO_OUT_BUFFER");
    String str15 = paramBuffers.getString("RSRV_STR1");
    String str16 = paramBuffers.getString("RSRV_STR2");
    String str17 = paramBuffers.getString("RSRV_STR3");
    String str18 = paramBuffers.getString("RSRV_STR4");
    String str19 = paramBuffers.getString("RSRV_STR5");
    String str20 = paramBuffers.getString("RSRV_STR6");
    String str21 = paramBuffers.getString("RSRV_STR7");
    String str22 = paramBuffers.getString("RSRV_STR8");
    String str23 = paramBuffers.getString("RSRV_STR9");
    String str24 = paramBuffers.getString("RSRV_STR0");
    String str25 = paramBuffers.getString("REMARK");
    try
    {
      i = updateBpmInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25);
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
    this.log.LOG_INFO("退出addBpmInfo方法...");
  }

  public int updateBpmInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25)
    throws SaasApplicationException
  {
    BpmExt localBpmExt = new BpmExt();
    localBpmExt.setParam(":VTRADE_TYPE_CODE", paramString1);
    localBpmExt.setParam(":VBPM_ID", paramString2);
    localBpmExt.setParam(":VNODE_ID", paramString3);
    localBpmExt.setParam(":VNODE_TYPE", paramString4);
    localBpmExt.setParam(":VNODE_SEQUENCE", paramString5);
    localBpmExt.setParam(":VNODE_CLASS", paramString6);
    localBpmExt.setParam(":VNODE_METHOD", paramString7);
    localBpmExt.setParam(":VOUT_QUERY", paramString8);
    localBpmExt.setParam(":VOUT_BUFFER", paramString9);
    localBpmExt.setParam(":VUNDO_TAG", paramString10);
    localBpmExt.setParam(":VUNDE_CLASS", paramString11);
    localBpmExt.setParam(":VUNDO_METHOD", paramString12);
    localBpmExt.setParam(":VUNDO_OUT_QUERY", paramString13);
    localBpmExt.setParam(":VUNDO_OUT_BUFFER", paramString14);
    localBpmExt.setParam(":VRSRV_STR1", paramString15);
    localBpmExt.setParam(":VRSRV_STR2", paramString16);
    localBpmExt.setParam(":VRSRV_STR3", paramString17);
    localBpmExt.setParam(":VRSRV_STR4", paramString18);
    localBpmExt.setParam(":VRSRV_STR5", paramString19);
    localBpmExt.setParam(":VRSRV_STR6", paramString20);
    localBpmExt.setParam(":VRSRV_STR7", paramString21);
    localBpmExt.setParam(":VRSRV_STR8", paramString22);
    localBpmExt.setParam(":VRSRV_STR9", paramString23);
    localBpmExt.setParam(":VRSRV_STR0", paramString24);
    localBpmExt.setParam(":VREMARK", paramString25);
    ArrayList localArrayList = new ArrayList();
    localArrayList = getOneBpm(paramString1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      this.tradeQuery.executeBy(localBpmExt.insBy("UPDATE_BPM_INFO_1"));
    else
      this.tradeQuery.executeBy(localBpmExt.insBy("INS_BPM_INFO"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.bpmdefinitionMgr.BpmInfo
 * JD-Core Version:    0.6.0
 */