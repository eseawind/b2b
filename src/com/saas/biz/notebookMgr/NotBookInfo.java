package com.saas.biz.notebookMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.notebookDAO.NotebookDAO;
import com.saas.biz.dao.notebookDAO.NotebookExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotBookInfo
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

  public void addNotBookInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportInfo方法...");
    int i = -1;
    NotebookDAO localNotebookDAO = new NotebookDAO();
    String str1 = paramBuffers.getString("NAME");
    Integer localInteger1 = Integer.valueOf(Integer.parseInt(paramBuffers.getString("SEX")));
    String str2 = paramBuffers.getString("XPHONE");
    String str3 = paramBuffers.getString("HOMETEL");
    String str4 = paramBuffers.getString("OFFICETEL");
    String str5 = paramBuffers.getString("ADDRESS");
    String str6 = paramBuffers.getString("UNIT");
    String str7 = paramBuffers.getString("EMAIL");
    String str8 = paramBuffers.getString("QQ");
    String str9 = paramBuffers.getString("MSN");
    String str10 = paramBuffers.getString("YAHOO");
    Integer localInteger2 = Integer.valueOf(Integer.parseInt(paramBuffers.getString("RELATIONSHIP")));
    String str11 = paramBuffers.getString("SESSION_USER_NAME");
    String str12 = paramBuffers.getString("DEPART_CODE");
    localNotebookDAO.setName(str1);
    localNotebookDAO.setSex(localInteger1);
    localNotebookDAO.setXphone(str2);
    localNotebookDAO.setHometel(str3);
    localNotebookDAO.setOfficetel(str4);
    localNotebookDAO.setAddress(str5);
    localNotebookDAO.setUnit(str6);
    localNotebookDAO.setEmail(str7);
    localNotebookDAO.setQq(str8);
    localNotebookDAO.setMsn(str9);
    localNotebookDAO.setYahoo(str10);
    localNotebookDAO.setRecorduser(str11);
    localNotebookDAO.setRelationship(localInteger2);
    localNotebookDAO.setPart(str12);
    i = addNotBookInfo(localNotebookDAO);
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
    this.log.LOG_INFO("退出addReportInfo方法...");
  }

  public int addNotBookInfo(NotebookDAO paramNotebookDAO)
  {
    NotebookExt localNotebookExt = new NotebookExt();
    localNotebookExt.setParam(":VNAME", paramNotebookDAO.getName());
    localNotebookExt.setParam(":VSEX", paramNotebookDAO.getSex());
    localNotebookExt.setParam(":VXPHONE", paramNotebookDAO.getXphone());
    localNotebookExt.setParam(":VHOMETEL", paramNotebookDAO.getHometel());
    localNotebookExt.setParam(":VOFFICETEL", paramNotebookDAO.getOfficetel());
    localNotebookExt.setParam(":VADDRESS", paramNotebookDAO.getAddress());
    localNotebookExt.setParam(":VUNIT", paramNotebookDAO.getUnit());
    localNotebookExt.setParam(":VEMAIL", paramNotebookDAO.getEmail());
    localNotebookExt.setParam(":VQQ", paramNotebookDAO.getQq());
    localNotebookExt.setParam(":VMSN", paramNotebookDAO.getMsn());
    localNotebookExt.setParam(":VYAHOO", paramNotebookDAO.getYahoo());
    localNotebookExt.setParam(":VRECORDUSER", paramNotebookDAO.getRecorduser());
    localNotebookExt.setParam(":VRELATIONSHIP", paramNotebookDAO.getRelationship());
    localNotebookExt.setParam(":VPART", paramNotebookDAO.getPart());
    this.tradeQuery.executeBy(localNotebookExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void updateNotBookInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportInfo方法...");
    int i = -1;
    NotebookDAO localNotebookDAO = new NotebookDAO();
    String str1 = paramBuffers.getString("IDX");
    String str2 = paramBuffers.getString("NAME");
    Integer localInteger1 = Integer.valueOf(Integer.parseInt(paramBuffers.getString("SEX")));
    String str3 = paramBuffers.getString("XPHONE");
    String str4 = paramBuffers.getString("HOMETEL");
    String str5 = paramBuffers.getString("OFFICETEL");
    String str6 = paramBuffers.getString("ADDRESS");
    String str7 = paramBuffers.getString("UNIT");
    String str8 = paramBuffers.getString("EMAIL");
    String str9 = paramBuffers.getString("QQ");
    String str10 = paramBuffers.getString("MSN");
    String str11 = paramBuffers.getString("YAHOO");
    Integer localInteger2 = Integer.valueOf(Integer.parseInt(paramBuffers.getString("RELATIONSHIP")));
    String str12 = paramBuffers.getString("SESSION_USER_NAME");
    String str13 = paramBuffers.getString("DEPART_CODE");
    localNotebookDAO.setId(Integer.valueOf(Integer.parseInt(str1)));
    localNotebookDAO.setName(str2);
    localNotebookDAO.setSex(localInteger1);
    localNotebookDAO.setXphone(str3);
    localNotebookDAO.setHometel(str4);
    localNotebookDAO.setOfficetel(str5);
    localNotebookDAO.setAddress(str6);
    localNotebookDAO.setUnit(str7);
    localNotebookDAO.setEmail(str8);
    localNotebookDAO.setQq(str9);
    localNotebookDAO.setMsn(str10);
    localNotebookDAO.setYahoo(str11);
    localNotebookDAO.setRecorduser(str12);
    localNotebookDAO.setRelationship(localInteger2);
    localNotebookDAO.setPart(str13);
    i = updateNotBookInfo(localNotebookDAO);
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
    this.log.LOG_INFO("退出addReportInfo方法...");
  }

  public int updateNotBookInfo(NotebookDAO paramNotebookDAO)
  {
    NotebookExt localNotebookExt = new NotebookExt();
    localNotebookExt.setParam(":VID", paramNotebookDAO.getId());
    localNotebookExt.setParam(":VNAME", paramNotebookDAO.getName());
    localNotebookExt.setParam(":VSEX", paramNotebookDAO.getSex());
    localNotebookExt.setParam(":VXPHONE", paramNotebookDAO.getXphone());
    localNotebookExt.setParam(":VHOMETEL", paramNotebookDAO.getHometel());
    localNotebookExt.setParam(":VOFFICETEL", paramNotebookDAO.getOfficetel());
    localNotebookExt.setParam(":VADDRESS", paramNotebookDAO.getAddress());
    localNotebookExt.setParam(":VUNIT", paramNotebookDAO.getUnit());
    localNotebookExt.setParam(":VEMAIL", paramNotebookDAO.getEmail());
    localNotebookExt.setParam(":VQQ", paramNotebookDAO.getQq());
    localNotebookExt.setParam(":VMSN", paramNotebookDAO.getMsn());
    localNotebookExt.setParam(":VYAHOO", paramNotebookDAO.getYahoo());
    localNotebookExt.setParam(":VRECORDUSER", paramNotebookDAO.getRecorduser());
    localNotebookExt.setParam(":VRELATIONSHIP", paramNotebookDAO.getRelationship());
    localNotebookExt.setParam(":VPART", paramNotebookDAO.getPart());
    this.tradeQuery.executeBy(localNotebookExt.insBy("UPDATE_BY_ID"));
    return 0;
  }

  public void delteNotBookInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入addReportInfo方法...");
    int i = -1;
    String str = paramBuffers.getString("IDX");
    i = delteNotBookInfo(str);
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
    this.log.LOG_INFO("退出addReportInfo方法...");
  }

  public int delteNotBookInfo(String paramString)
  {
    NotebookExt localNotebookExt = new NotebookExt();
    localNotebookExt.setParam(":VID", paramString);
    this.tradeQuery.executeBy(localNotebookExt.insBy("DELETE_BY_ID"));
    return 0;
  }

  public ArrayList getNoteBookByUser(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NotebookExt localNotebookExt = new NotebookExt();
    try
    {
      if (paramInt == 0)
        paramInt = 0;
      else
        paramInt = (paramInt - 1) * 20;
      localNotebookExt.setParam(":VRECORDUSER", paramString);
      localNotebookExt.setParam(":VNAME", "%" + paramString + "%");
      localArrayList = localNotebookExt.selByList("SEL_BY_RECORDUSER", paramInt, 20);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return localArrayList;
  }

  public int getNoteBookByUserCT(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    NotebookExt localNotebookExt = new NotebookExt();
    try
    {
      localNotebookExt.setParam(":VRECORDUSER", paramString);
      localNotebookExt.setParam(":VNAME", "%" + paramString + "%");
      localArrayList = localNotebookExt.selByList("SEL_BY_RECORDUSER_CT");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        if (localHashMap.get("ct") != null)
          i = Integer.parseInt(localHashMap.get("ct").toString());
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    return i;
  }

  public ArrayList getNoteBookById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    NotebookExt localNotebookExt = new NotebookExt();
    localNotebookExt.setParam(":VID", paramString);
    localArrayList = localNotebookExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public Map getNoteBookByMap(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList = getNoteBookById(paramString);
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    if ((localArrayList != null) && (localArrayList.size() > 0) && (localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap2 = (HashMap)localArrayList.get(0);
      if (localHashMap2.get("sex") != null)
        str1 = localHashMap2.get("sex").toString();
      if (localHashMap2.get("name") != null)
        str2 = localHashMap2.get("name").toString();
      if (localHashMap2.get("xphone") != null)
        str3 = localHashMap2.get("xphone").toString();
      if (localHashMap2.get("hometel") != null)
        str4 = localHashMap2.get("hometel").toString();
      if (localHashMap2.get("officetel") != null)
        str5 = localHashMap2.get("officetel").toString();
      if (localHashMap2.get("address") != null)
        str6 = localHashMap2.get("address").toString();
      if (localHashMap2.get("relationship") != null)
        str7 = localHashMap2.get("relationship").toString();
      if (localHashMap2.get("unit") != null)
        str8 = localHashMap2.get("unit").toString();
      if (localHashMap2.get("email") != null)
        str9 = localHashMap2.get("email").toString();
      if (localHashMap2.get("qq") != null)
        str10 = localHashMap2.get("qq").toString();
      if (localHashMap2.get("msn") != null)
        str11 = localHashMap2.get("msn").toString();
      if (localHashMap2.get("yahoo") != null)
        str12 = localHashMap2.get("yahoo").toString();
    }
    localHashMap1.put("sex", str1);
    localHashMap1.put("name", str2);
    localHashMap1.put("xphone", str3);
    localHashMap1.put("hometel", str4);
    localHashMap1.put("officetel", str5);
    localHashMap1.put("address", str6);
    localHashMap1.put("relationship", str7);
    localHashMap1.put("unit", str8);
    localHashMap1.put("email", str9);
    localHashMap1.put("qq", str10);
    localHashMap1.put("msn", str11);
    localHashMap1.put("yahoo", str12);
    return localHashMap1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.notebookMgr.NotBookInfo
 * JD-Core Version:    0.6.0
 */