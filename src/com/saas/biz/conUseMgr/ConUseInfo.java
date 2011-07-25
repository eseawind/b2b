package com.saas.biz.conUseMgr;

import com.saas.biz.dao.conuseDAO.ConUseDAO;
import com.saas.biz.dao.conuseDAO.ConUseExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

public class ConUseInfo
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

  public void addConuseInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addConuseInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = paramBuffers.getString("CON_NUM");
    String str4 = paramBuffers.getString("CO_CLASS");
    String str5 = paramBuffers.getString("OBJ_CUST_ID");
    String str6 = paramBuffers.getString("CON_DATE");
    String str7 = paramBuffers.getString("CON_CLASS");
    String str8 = paramBuffers.getString("CON_DEPT");
    String str9 = paramBuffers.getString("REASON");
    String str10 = paramBuffers.getString("PUBLISH_DATE");
    String str11 = paramBuffers.getString("SESSION_USER_ID");
    String str12 = paramBuffers.getString("REMARK");
    String str13 = paramBuffers.getString("CON_NO");
    try
    {
      i = addConuseInfo(str9, str1, str2, str13, str5, str6, str7, str8, str10, str11, str12);
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
    this.log.LOG_INFO("退出addConuseInfo方法...");
  }

  public static String getConNo(String paramString1, String paramString2)
  {
    Calendar localCalendar = Calendar.getInstance();
    String str1 = new SimpleDateFormat("yyyyMMdd").format(localCalendar.getTime());
    String str2 = "";
    for (int i = 1; i <= Integer.parseInt(paramString2); i++)
      str2 = str2 + paramString1 + "-" + str1 + "-" + i + "|";
    return str2;
  }

  public void addConuseByBackInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addConuseByBackInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = paramBuffers.getString("CON_NO");
    String str4 = paramBuffers.getString("OBJ_CUST_ID");
    String str5 = paramBuffers.getString("CON_DATE");
    String str6 = "";
    String str7 = paramBuffers.getString("CON_DEPT");
    String str8 = paramBuffers.getString("REASON");
    String str9 = paramBuffers.getString("PUBLISH_DATE");
    String str10 = paramBuffers.getString("SESSION_USER_ID");
    String str11 = paramBuffers.getString("REMARK");
    String str12 = "";
    String str13 = "[-]";
    String str14 = "";
    String str15 = "";
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str3, "|");
      while (localStringTokenizer.hasMoreTokens())
      {
        str12 = localStringTokenizer.nextToken();
        String[] arrayOfString = str12.split(str13);
        if (arrayOfString[0].equals("HR"))
          str6 = "0";
        else if (arrayOfString[0].equals("SALE"))
          str6 = "1";
        else if (arrayOfString[0].equals("PRO"))
          str6 = "2";
        else if (arrayOfString[0].equals("TRAS"))
          str6 = "3";
        i = addConuseInfo(str8, str1, str2, str12, str4, str5, str6, str7, str9, str10, str11);
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
    this.log.LOG_INFO("退出addConuseByBackInfo方法...");
  }

  public int addConuseInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
    throws SaasApplicationException
  {
    ConUseExt localConUseExt = new ConUseExt();
    localConUseExt.setParam(":VREASON", paramString1);
    localConUseExt.setParam(":VCUST_ID", paramString2);
    localConUseExt.setParam(":VCON_ID", paramString3);
    localConUseExt.setParam(":VCON_NO", paramString4);
    localConUseExt.setParam(":VOBJ_CUST_ID", paramString5);
    localConUseExt.setParam(":VCON_DATE", paramString6);
    localConUseExt.setParam(":VCON_CLASS", paramString7);
    localConUseExt.setParam(":VCON_DEPT", paramString8);
    localConUseExt.setParam(":VPUBLISH_DATE", paramString9);
    localConUseExt.setParam(":VUSER_ID", paramString10);
    localConUseExt.setParam(":VREMARK", paramString11);
    this.tradeQuery.executeBy(localConUseExt.insBy("INS_BY_CON_USE"));
    return 0;
  }

  public ArrayList getAllConuse(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ConUseExt localConUseExt = new ConUseExt();
    localConUseExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localConUseExt.selByList("SEL_ALL_CONUSE", paramInt, 20);
    return localArrayList;
  }

  public int getAllConuse(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ConUseExt localConUseExt = new ConUseExt();
    localConUseExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localConUseExt.selByList("SEL_ALL_CONUSE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getOneConuse(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ConUseExt localConUseExt = new ConUseExt();
    localConUseExt.setParam(":VCUST_ID", paramString1);
    localConUseExt.setParam(":VCON_ID", paramString2);
    ArrayList localArrayList = localConUseExt.selByList("SEL_ONE_CONUSE");
    return localArrayList;
  }

  public ArrayList getAllConuseConNo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ConUseExt localConUseExt = new ConUseExt();
    localConUseExt.setParam(":VCUST_ID", paramString1);
    localConUseExt.setParam(":VOBJ_CUST_ID", paramString2);
    ArrayList localArrayList = localConUseExt.selByList("SEL_ALL_CONUSE_CON_NO");
    return localArrayList;
  }

  public void modifyConUse(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入modifyConUse方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = paramBuffers.getString("CON_NO");
    String str4 = paramBuffers.getString("OBJ_CUST_ID");
    String str5 = paramBuffers.getString("CON_DATE");
    String str6 = paramBuffers.getString("CON_CLASS");
    String str7 = paramBuffers.getString("CON_DEPT");
    String str8 = paramBuffers.getString("PUBLISH_DATE");
    String str9 = paramBuffers.getString("SESSION_USER_ID");
    String str10 = paramBuffers.getString("REMARK");
    try
    {
      ConUseDAO localConUseDAO = new ConUseDAO();
      localConUseDAO.setCust_id(str1);
      localConUseDAO.setCon_id(str2);
      localConUseDAO.setCon_no(str3);
      localConUseDAO.setObj_cust_id(str4);
      localConUseDAO.setCon_date(str5);
      localConUseDAO.setCon_class(str6);
      localConUseDAO.setCon_dept(str7);
      localConUseDAO.setPublish_date(str8);
      localConUseDAO.setUser_id(str9);
      localConUseDAO.setRemark(str10);
      i = modifyConUse(localConUseDAO);
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
    this.log.LOG_INFO("退出modifyConUseList方法...");
  }

  public int modifyConUse(ConUseDAO paramConUseDAO)
    throws SaasApplicationException
  {
    ConUseExt localConUseExt = new ConUseExt();
    localConUseExt.setParam(":VCUST_ID", paramConUseDAO.getCust_id());
    localConUseExt.setParam(":VCON_ID", paramConUseDAO.getCon_id());
    localConUseExt.setParam(":VCON_NO", paramConUseDAO.getCon_no());
    localConUseExt.setParam(":VOBJ_CUST_ID", paramConUseDAO.getObj_cust_id());
    localConUseExt.setParam(":VCON_DATE", paramConUseDAO.getCon_date());
    localConUseExt.setParam(":VCON_CLASS", paramConUseDAO.getCon_class());
    localConUseExt.setParam(":VCON_DEPT", paramConUseDAO.getCon_dept());
    localConUseExt.setParam(":VPUBLISH_DATE", paramConUseDAO.getPublish_date());
    localConUseExt.setParam(":VUSER_ID", paramConUseDAO.getUser_id());
    localConUseExt.setParam(":VREMARK", paramConUseDAO.getRemark());
    this.tradeQuery.executeBy(localConUseExt.insBy("UPDATE_CONUSE"));
    return 0;
  }

  public void DelConuse(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入DelConuse方法...");
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("CON_ID");
    String str3 = "";
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str2, "|");
      while (localStringTokenizer.hasMoreTokens())
      {
        str3 = localStringTokenizer.nextToken();
        i = DelConuse(str1, str3);
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
    this.log.LOG_INFO("退出DelConList方法...");
  }

  public int DelConuse(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ConUseExt localConUseExt = new ConUseExt();
    localConUseExt.setParam(":VCUST_ID", paramString1);
    localConUseExt.setParam(":VCON_ID", paramString2);
    this.tradeQuery.executeBy(localConUseExt.insBy("DEL_CON_USE_CON_ID"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.conUseMgr.ConUseInfo
 * JD-Core Version:    0.6.0
 */