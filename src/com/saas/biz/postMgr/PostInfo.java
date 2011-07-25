package com.saas.biz.postMgr;

import com.saas.biz.dao.postDAO.PostDAO;
import com.saas.biz.dao.postDAO.PostExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class PostInfo
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

  public void addPostInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addPostInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("DQ");
    String str2 = paramBuffers.getString("DM");
    String str3 = paramBuffers.getString("YB");
    String str4 = paramBuffers.getString("QH");
    try
    {
      PostDAO localPostDAO = new PostDAO(str1, str2, str3, str4);
      i = addPostInfo(localPostDAO);
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
    this.log.LOG_INFO("退出addPostInfo方法...");
  }

  public int addPostInfo(PostDAO paramPostDAO)
    throws SaasApplicationException
  {
    PostExt localPostExt = new PostExt();
    localPostExt.setParam(":VDQ", paramPostDAO.getDq());
    localPostExt.setParam(":VDM", paramPostDAO.getDm());
    localPostExt.setParam(":VYB", paramPostDAO.getYb());
    localPostExt.setParam(":VQH", paramPostDAO.getQh());
    this.tradeQuery.executeBy(localPostExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public String getPostInfoByQuery(String paramString)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "%" + paramString + "%";
    ArrayList localArrayList = new ArrayList();
    PostExt localPostExt = new PostExt();
    localPostExt.setParam(":VDQ", str2);
    localPostExt.setParam(":VDM", str2);
    localPostExt.setParam(":VYB", str2);
    localPostExt.setParam(":VQH", str2);
    localArrayList = localPostExt.selByList("SEL_BY_KEYS");
    str1 = createHtmlCode(localArrayList);
    return str1;
  }

  public String getPostInfoByArea(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    PostExt localPostExt = new PostExt();
    localPostExt.setParam(":VDQ", paramString);
    localPostExt.setParam(":VDM", paramString);
    localArrayList = localPostExt.selByList("SEL_BY_AREA");
    str = createHtmlCode(localArrayList);
    return str;
  }

  public String createHtmlCode(ArrayList paramArrayList)
    throws SaasApplicationException
  {
    String str1 = "<table width=710 border=1 cellspacing=0 cellpadding=0>";
    String str2 = "";
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        String str3 = localHashMap.get("dq").toString();
        String str4 = localHashMap.get("dm").toString();
        String str5 = localHashMap.get("yb").toString();
        String str6 = localHashMap.get("qh").toString();
        str2 = str2 + "<tr>" + "<td width=27% align=center><div style=text-align:center; margin-left:10px; font-weight:100;>" + str3 + "</div></td>" + "<td width=26% align=center><div style=text-align:center; margin-left:10px; font-weight:100;>" + str4 + "</div></td>" + "<td width=26% align=center><div style=text-align:center; margin-left:10px; font-weight:100;>" + str5 + "</div></td>" + "<td width=21% align=center><div style=text-align:center; margin-left:10px; font-weight:100;>" + str6 + "</div></td></tr>";
      }
      str1 = str1 + str2 + "</table>";
    }
    else
    {
      str1 = str1 + "<tr><td colspan=4><div style=text-align:center; margin-left:10px; font-weight:100;>对不起！未找到你想要的信息！" + "</div></td></tr></table>";
    }
    return str1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.postMgr.PostInfo
 * JD-Core Version:    0.6.0
 */