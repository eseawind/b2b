package com.saas.biz.commen;

import com.saas.biz.dao.commenDAO.ConfigurationExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ConfigurationMgr
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();
  commMethodMgr comm = new commMethodMgr();

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

  public ArrayList getConfiguration(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ConfigurationExt localConfigurationExt = new ConfigurationExt();
    localConfigurationExt.setParam(":VPARAM_ATTR", paramString);
    localArrayList = localConfigurationExt.selByList("SEL_BY_ATTR_AND_CODE");
    return localArrayList;
  }

  public String getConfigurationForNews(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList = getConfiguration(paramString);
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("para_code1") != null)
        str = localHashMap.get("para_code1").toString();
    }
    return str;
  }

  public ArrayList getConfigurationOne(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ConfigurationExt localConfigurationExt = new ConfigurationExt();
    localConfigurationExt.setParam(":VPARAM_ATTR", paramString1);
    localConfigurationExt.setParam(":VPARAM_CODE1", paramString2);
    localArrayList = localConfigurationExt.selByList("SEL_BY_ATTR_AND_CODE_ONE");
    return localArrayList;
  }

  public void updateConf(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_ATTR");
    String str2 = paramBuffers.getString("PARA_CODE1");
    i = updateConf(str1, str2);
  }

  public int updateConf(String paramString1, String paramString2)
  {
    ConfigurationExt localConfigurationExt = new ConfigurationExt();
    localConfigurationExt.setParam(":VPARAM_ATTR", paramString1);
    localConfigurationExt.setParam(":VPARAM_CODE1", paramString2);
    this.tradeQuery.executeBy(localConfigurationExt.insBy("UPDATE_CONFIG_ONE"));
    return 0;
  }

  public void updateConfAll(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateConfAll方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_ATTR");
    String str2 = paramBuffers.getString("PARA_CODE1");
    String str3 = paramBuffers.getString("PARA_CODE3");
    try
    {
      StringTokenizer localStringTokenizer1 = new StringTokenizer(str2, "|");
      StringTokenizer localStringTokenizer2 = new StringTokenizer(str3, "|");
      String str4 = "";
      String str5 = "";
      while ((localStringTokenizer1.hasMoreTokens()) && (localStringTokenizer2.hasMoreTokens()))
      {
        str4 = localStringTokenizer1.nextToken();
        str5 = localStringTokenizer2.nextToken();
        i = updateConfAll(str1, str4, str5);
      }
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
    this.log.LOG_INFO("退出DupdateConfAll方法...");
  }

  public int updateConfAll(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ConfigurationExt localConfigurationExt = new ConfigurationExt();
    localConfigurationExt.setParam(":VPARAM_ATTR", paramString1);
    localConfigurationExt.setParam(":VPARAM_CODE1", paramString2);
    localConfigurationExt.setParam(":VPARAM_CODE3", paramString3);
    this.tradeQuery.executeBy(localConfigurationExt.insBy("UPDATE_CONFIG_ONE_PARAM"));
    return 0;
  }

  public void updateConfForOne(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateConfForOne方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_ATTR");
    String str2 = paramBuffers.getString("PARA_CODE1");
    String str3 = paramBuffers.getString("PARA_CODE2");
    String str4 = paramBuffers.getString("PARA_CODE3");
    String str5 = paramBuffers.getString("REMARK");
    try
    {
      i = updateConfForOne(str1, str2, str3, str4, str5);
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
    this.log.LOG_INFO("退出DupdateConfAll方法...");
  }

  public int updateConfForOne(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ConfigurationExt localConfigurationExt = new ConfigurationExt();
    localConfigurationExt.setParam(":VPARAM_ATTR", paramString1);
    localConfigurationExt.setParam(":VPARAM_CODE1", paramString2);
    localConfigurationExt.setParam(":VPARAM_CODE2", paramString3);
    localConfigurationExt.setParam(":VPARAM_CODE3", paramString4);
    localConfigurationExt.setParam(":VREMARK", paramString5);
    this.tradeQuery.executeBy(localConfigurationExt.insBy("UPDATE_CONFIG_ONE_ALL_PARAM"));
    return 0;
  }

  public void InsConfForOne(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateConfForOne方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_ATTR");
    String str2 = paramBuffers.getString("PARA_CODE1");
    String str3 = paramBuffers.getString("SUBSYS_CODE");
    String str4 = paramBuffers.getString("PARAM_CODE");
    String str5 = paramBuffers.getString("PARAM_NAME");
    String str6 = paramBuffers.getString("PARA_CODE2");
    String str7 = paramBuffers.getString("PARA_CODE3");
    String str8 = paramBuffers.getString("REMARK");
    try
    {
      i = InsConfForOne(str1, str2, str6, str7, str8, str5, str4, str3);
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
    this.log.LOG_INFO("退出DupdateConfAll方法...");
  }

  public int InsConfForOne(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws SaasApplicationException
  {
    ConfigurationExt localConfigurationExt = new ConfigurationExt();
    localConfigurationExt.setParam(":VPARAM_ATTR", paramString1);
    localConfigurationExt.setParam(":VPARA_CODE1", paramString2);
    localConfigurationExt.setParam(":VPARA_CODE2", paramString3);
    localConfigurationExt.setParam(":VSUBSYS_CODE", paramString8);
    localConfigurationExt.setParam(":VPARAM_NAME", paramString6);
    localConfigurationExt.setParam(":VPARAM_CODE", paramString7);
    localConfigurationExt.setParam(":VPARA_CODE3", paramString4);
    localConfigurationExt.setParam(":VREMARK", paramString5);
    this.tradeQuery.executeBy(localConfigurationExt.insBy("INS_CONFIG_ONE_ALL_PARAM"));
    return 0;
  }

  public void deleteConfAll(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入updateConfAll方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PARAM_ATTR");
    String str2 = paramBuffers.getString("PARA_CODE1");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str2, "|");
      String str3 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str3 = localStringTokenizer.nextToken();
        i = deleteConfAll(str1, str3);
      }
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
    this.log.LOG_INFO("退出DupdateConfAll方法...");
  }

  public int deleteConfAll(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ConfigurationExt localConfigurationExt = new ConfigurationExt();
    localConfigurationExt.setParam(":VPARAM_ATTR", paramString1);
    localConfigurationExt.setParam(":VPARAM_CODE1", paramString2);
    this.tradeQuery.executeBy(localConfigurationExt.insBy("DELETE_CONFIG_ONE_PARAM"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.ConfigurationMgr
 * JD-Core Version:    0.6.0
 */