package com.saas.biz.clewTrackMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.clewTrackDAO.ClewTrackDAO;
import com.saas.biz.dao.clewTrackDAO.ClewTrackExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ClewTrackInfo
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

  public void addClewTrackInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addClewTrackInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("TRADE_ID");
    String str3 = paramBuffers.getString("ENTITY_TYPE");
    String str4 = paramBuffers.getString("OBJ_ID");
    String str5 = paramBuffers.getString("TITLE");
    String str6 = paramBuffers.getString("CONTENT");
    String str7 = paramBuffers.getString("START_DATE");
    String str8 = paramBuffers.getString("END_DATE");
    String str9 = paramBuffers.getString("DO_TAG");
    String str10 = paramBuffers.getString("CARE_RESULT");
    String str11 = paramBuffers.getString("USER_NAME");
    String str12 = paramBuffers.getString("USER_ID");
    String str13 = paramBuffers.getString("ACT_CARE_TYPE");
    String str14 = paramBuffers.getString("END_TAG");
    String str15 = paramBuffers.getString("ROUND_NUM");
    String str16 = paramBuffers.getString("SESSION_USER_ID");
    String str17 = paramBuffers.getString("REMARK");
    try
    {
      ClewTrackDAO localClewTrackDAO = new ClewTrackDAO();
      localClewTrackDAO.setCust_id(str1);
      localClewTrackDAO.setTrade_id(str2);
      localClewTrackDAO.setEntity_type(str3);
      localClewTrackDAO.setObj_id(str4);
      localClewTrackDAO.setTitle(str5);
      localClewTrackDAO.setContent(str6);
      localClewTrackDAO.setStart_date(str7);
      localClewTrackDAO.setEnd_date(str8);
      localClewTrackDAO.setDo_tag(str9);
      localClewTrackDAO.setCare_result(str10);
      localClewTrackDAO.setUser_id(str12);
      localClewTrackDAO.setUser_name(str11);
      localClewTrackDAO.setAct_care_type(str13);
      localClewTrackDAO.setEnd_tag(str14);
      localClewTrackDAO.setRound_num(str15);
      localClewTrackDAO.setOper_user_id(str16);
      localClewTrackDAO.setRemark(str17);
      i = addClewTrackInfo(localClewTrackDAO);
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
    this.log.LOG_INFO("退出addClewTrackInfo方法...");
  }

  public int addClewTrackInfo(ClewTrackDAO paramClewTrackDAO)
    throws SaasApplicationException
  {
    ClewTrackExt localClewTrackExt = new ClewTrackExt();
    localClewTrackExt.setParam(":VCUST_ID", paramClewTrackDAO.getCust_id());
    localClewTrackExt.setParam(":VTRADE_ID", paramClewTrackDAO.getTrade_id());
    localClewTrackExt.setParam(":VENTITY_TYPE", paramClewTrackDAO.getEntity_type());
    localClewTrackExt.setParam(":VOBJ_ID", paramClewTrackDAO.getObj_id());
    localClewTrackExt.setParam(":VTITLE", paramClewTrackDAO.getTitle());
    localClewTrackExt.setParam(":VCONTENT", paramClewTrackDAO.getContent());
    localClewTrackExt.setParam(":VSTART_DATE", paramClewTrackDAO.getStart_date());
    localClewTrackExt.setParam(":VEND_DATE", paramClewTrackDAO.getEnd_date());
    localClewTrackExt.setParam(":VDO_TAG", paramClewTrackDAO.getDo_tag());
    localClewTrackExt.setParam(":VCARE_RESULT", paramClewTrackDAO.getCare_result());
    localClewTrackExt.setParam(":VUSER_NAME", paramClewTrackDAO.getUser_name());
    localClewTrackExt.setParam(":VUSER_ID", paramClewTrackDAO.getUser_id());
    localClewTrackExt.setParam(":VACT_CARE_TYPE", paramClewTrackDAO.getAct_care_type());
    localClewTrackExt.setParam(":VDO_DATE", paramClewTrackDAO.getDo_date());
    localClewTrackExt.setParam(":VEND_TAG", paramClewTrackDAO.getEnd_tag());
    localClewTrackExt.setParam(":VROUND_NUM", paramClewTrackDAO.getRound_num());
    localClewTrackExt.setParam(":VOPER_USER_ID", paramClewTrackDAO.getOper_user_id());
    localClewTrackExt.setParam(":VREMARK", paramClewTrackDAO.getRemark());
    this.tradeQuery.executeBy(localClewTrackExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList getTrackInfoByClew(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 20;
    ArrayList localArrayList = new ArrayList();
    ClewTrackExt localClewTrackExt = new ClewTrackExt();
    localClewTrackExt.setParam(":VOBJ_ID", paramString);
    localArrayList = localClewTrackExt.selByList("SEL_BY_CLEW", paramInt, 20);
    return localArrayList;
  }

  public int getTrackPagaSize(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    ClewTrackExt localClewTrackExt = new ClewTrackExt();
    localClewTrackExt.setParam(":VOBJ_ID", paramString);
    localArrayList = localClewTrackExt.selByList("SEL_PAGE_CLEW");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getTrackInfoById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ClewTrackExt localClewTrackExt = new ClewTrackExt();
    localClewTrackExt.setParam(":VTRADE_ID", paramString);
    localArrayList = localClewTrackExt.selByList("SEL_BY_ID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.clewTrackMgr.ClewTrackInfo
 * JD-Core Version:    0.6.0
 */