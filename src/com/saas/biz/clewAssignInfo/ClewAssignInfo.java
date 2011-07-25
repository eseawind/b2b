package com.saas.biz.clewAssignInfo;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.clewAssignDAO.ClewAssignExt;
import com.saas.biz.dao.clewAssignDAO.ClewAssignkDAO;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ClewAssignInfo
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

  public void addClewAssignInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addClewAssignInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CLEW_ID");
    String str3 = paramBuffers.getString("OWN_USER_ID");
    String str4 = paramBuffers.getString("OWN_USER_NAME");
    String str5 = paramBuffers.getString("MAN_TAG");
    String str6 = paramBuffers.getString("REMARK2");
    String str7 = paramBuffers.getString("SESSION_USER_ID");
    String str8 = paramBuffers.getString("USER");
    try
    {
      Object localObject;
      if ((str8 != null) && (!str8.equals("")))
      {
        localObject = new StringTokenizer(str8, "|");
        while (((StringTokenizer)localObject).hasMoreTokens())
        {
          String str9 = ((StringTokenizer)localObject).nextToken();
          String str10 = str9.substring(0, str9.indexOf(","));
          String str11 = str9.substring(str9.indexOf(",") + 1);
          ClewAssignkDAO localClewAssignkDAO = new ClewAssignkDAO();
          localClewAssignkDAO.setClew_id(str2);
          localClewAssignkDAO.setCust_id(str1);
          localClewAssignkDAO.setOwn_user_id(str11);
          localClewAssignkDAO.setOwn_user_name(str10);
          localClewAssignkDAO.setMan_tag(str5);
          localClewAssignkDAO.setRemark2(str6);
          localClewAssignkDAO.setOper_user_id(str7);
          i = addClewAssignInfo(localClewAssignkDAO);
        }
      }
      else
      {
        localObject = new ClewAssignkDAO();
        ((ClewAssignkDAO)localObject).setClew_id(str2);
        ((ClewAssignkDAO)localObject).setCust_id(str1);
        ((ClewAssignkDAO)localObject).setOwn_user_id(str3);
        ((ClewAssignkDAO)localObject).setOwn_user_name(str4);
        ((ClewAssignkDAO)localObject).setMan_tag(str5);
        ((ClewAssignkDAO)localObject).setRemark2(str6);
        ((ClewAssignkDAO)localObject).setOper_user_id(str7);
        i = addClewAssignInfo((ClewAssignkDAO)localObject);
      }
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
    this.log.LOG_INFO("退出addClewAssignInfo方法...");
  }

  public int addClewAssignInfo(ClewAssignkDAO paramClewAssignkDAO)
    throws SaasApplicationException
  {
    String str1 = paramClewAssignkDAO.getCust_id();
    String str2 = paramClewAssignkDAO.getOwn_user_name();
    String str3 = paramClewAssignkDAO.getClew_id();
    int i = checkAssignInfo(str1, str2, str3);
    if (i == 0)
    {
      ClewAssignExt localClewAssignExt = new ClewAssignExt();
      localClewAssignExt.setParam(":VCUST_ID", paramClewAssignkDAO.getCust_id());
      localClewAssignExt.setParam(":VCLEW_ID", paramClewAssignkDAO.getClew_id());
      localClewAssignExt.setParam(":VOWN_USER_ID", paramClewAssignkDAO.getOwn_user_id());
      localClewAssignExt.setParam(":VOWN_USER_NAME", paramClewAssignkDAO.getOwn_user_name());
      localClewAssignExt.setParam(":VMAN_TAG", paramClewAssignkDAO.getMan_tag());
      localClewAssignExt.setParam(":VREMARK2", paramClewAssignkDAO.getRemark2());
      localClewAssignExt.setParam(":VOPER_USER_ID", paramClewAssignkDAO.getOper_user_id());
      this.tradeQuery.executeBy(localClewAssignExt.insBy("INS_BY_ALL"));
    }
    return 0;
  }

  public int checkAssignInfo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = 0;
    ClewAssignExt localClewAssignExt = new ClewAssignExt();
    localClewAssignExt.setParam(":VCUST_ID", paramString1);
    localClewAssignExt.setParam(":VCLEW_ID", paramString3);
    localClewAssignExt.setParam(":VOWN_USER_NAME", paramString2);
    ArrayList localArrayList = localClewAssignExt.selByList("SEL_BY_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = 1;
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.clewAssignInfo.ClewAssignInfo
 * JD-Core Version:    0.6.0
 */