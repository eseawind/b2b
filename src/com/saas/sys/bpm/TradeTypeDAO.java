package com.saas.sys.bpm;

import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.dbm.Dbexecute;
import com.saas.sys.log.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;

public class TradeTypeDAO
{
  private Dbexecute exec;
  private commMethodMgr commen;
  ArrayList paramArray = new ArrayList();
  Logger log = new Logger(this);
  private String trade_type_code;
  private String trade_name;
  private String bpm_id;
  private String judge_rights;
  private String trade_kind;
  private String cancel_tag;
  private String transe_type;
  private String enable_tag;
  private String succeed_fwd;
  private String error_fwd;
  private String start_date;
  private String end_date;
  private String rsrv_str1;
  private String rsrv_str2;
  private String rsrv_str3;
  private String rsrv_str4;
  private String rsrv_str5;
  private String rsrv_str6;
  private String rsrv_str7;
  private String rsrv_str8;
  private String rsrv_str9;
  private String rsrv_str0;
  private String in_date;
  private String remark;

  public String getTrade_type_code()
  {
    return this.trade_type_code;
  }

  public String getTrade_name()
  {
    return this.trade_name;
  }

  public String getBpm_id()
  {
    return this.bpm_id;
  }

  public String getJudge_rights()
  {
    return this.judge_rights;
  }

  public String getTrade_kind()
  {
    return this.trade_kind;
  }

  public String getCancel_tag()
  {
    return this.cancel_tag;
  }

  public String getTranse_type()
  {
    return this.transe_type;
  }

  public String getSucceed_fwd()
  {
    return this.succeed_fwd;
  }

  public String getError_fwd()
  {
    return this.error_fwd;
  }

  public String getEnable_tag()
  {
    return this.enable_tag;
  }

  public String getStart_date()
  {
    return this.start_date;
  }

  public String getEnd_date()
  {
    return this.end_date;
  }

  public String getRsrv_str1()
  {
    return this.rsrv_str1;
  }

  public String getRsrv_str2()
  {
    return this.rsrv_str2;
  }

  public String getRsrv_str3()
  {
    return this.rsrv_str3;
  }

  public String getRsrv_str4()
  {
    return this.rsrv_str4;
  }

  public String getRsrv_str5()
  {
    return this.rsrv_str5;
  }

  public String getRsrv_str6()
  {
    return this.rsrv_str6;
  }

  public String getRsrv_str7()
  {
    return this.rsrv_str7;
  }

  public String getRsrv_str8()
  {
    return this.rsrv_str8;
  }

  public String getRsrv_str9()
  {
    return this.rsrv_str9;
  }

  public String getRsrv_str0()
  {
    return this.rsrv_str0;
  }

  public String getIn_date()
  {
    return this.in_date;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setTrade_type_code(String paramString)
  {
    this.trade_type_code = paramString;
  }

  public void setTrade_name(String paramString)
  {
    this.trade_name = paramString;
  }

  public void setBpm_id(String paramString)
  {
    this.bpm_id = paramString;
  }

  public void setJudge_rights(String paramString)
  {
    this.judge_rights = paramString;
  }

  public void setTrade_kind(String paramString)
  {
    this.trade_kind = paramString;
  }

  public void setCancel_tag(String paramString)
  {
    this.cancel_tag = paramString;
  }

  public void setTranse_type(String paramString)
  {
    this.transe_type = paramString;
  }

  public void setEnable_tag(String paramString)
  {
    this.enable_tag = paramString;
  }

  public void setSucceed_fwd(String paramString)
  {
    this.succeed_fwd = paramString;
  }

  public void setError_fwd(String paramString)
  {
    this.error_fwd = paramString;
  }

  public void setStart_date(String paramString)
  {
    this.start_date = paramString;
  }

  public void setEnd_date(String paramString)
  {
    this.end_date = paramString;
  }

  public void setRsrv_str1(String paramString)
  {
    this.rsrv_str1 = paramString;
  }

  public void setRsrv_str2(String paramString)
  {
    this.rsrv_str2 = paramString;
  }

  public void setRsrv_str3(String paramString)
  {
    this.rsrv_str3 = paramString;
  }

  public void setRsrv_str4(String paramString)
  {
    this.rsrv_str4 = paramString;
  }

  public void setRsrv_str5(String paramString)
  {
    this.rsrv_str5 = paramString;
  }

  public void setRsrv_str6(String paramString)
  {
    this.rsrv_str6 = paramString;
  }

  public void setRsrv_str7(String paramString)
  {
    this.rsrv_str7 = paramString;
  }

  public void setRsrv_str8(String paramString)
  {
    this.rsrv_str8 = paramString;
  }

  public void setRsrv_str9(String paramString)
  {
    this.rsrv_str9 = paramString;
  }

  public void setRsrv_str0(String paramString)
  {
    this.rsrv_str0 = paramString;
  }

  public void setIn_date(String paramString)
  {
    this.in_date = paramString;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public ArrayList selByList(String paramString)
  {
    this.exec = new Dbexecute();
    ArrayList localArrayList = new ArrayList();
    this.exec.setStrTable("tradetype");
    this.exec.setStrQuery(paramString);
    this.exec.setParamList(this.paramArray);
    localArrayList = this.exec.selBizQuery();
    if (localArrayList.size() <= 0)
      return null;
    return localArrayList;
  }

  public TradeTypeDAO selByInfo(String paramString)
  {
    this.exec = new Dbexecute();
    this.commen = new commMethodMgr();
    TradeTypeDAO localTradeTypeDAO = new TradeTypeDAO();
    ArrayList localArrayList = new ArrayList();
    this.exec.setStrTable("tradetype");
    this.exec.setStrQuery(paramString);
    this.exec.setParamList(this.paramArray);
    localArrayList = this.exec.selBizQuery();
    if (localArrayList.size() <= 0)
      return null;
    Field[] arrayOfField = localTradeTypeDAO.getClass().getDeclaredFields();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      for (int i = 0; i <= arrayOfField.length - 1; i++)
      {
        if (!localHashMap.containsKey(arrayOfField[i].getName()))
          continue;
        try
        {
          PropertyUtils.setProperty(localTradeTypeDAO, arrayOfField[i].getName(), localHashMap.get(arrayOfField[i].getName()));
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          throw new RuntimeException(localInvocationTargetException);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          throw new RuntimeException(localNoSuchMethodException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new RuntimeException(localIllegalAccessException);
        }
      }
    }
    return localTradeTypeDAO;
  }

  public int selCount(String paramString)
  {
    this.exec = new Dbexecute();
    return 0;
  }

  public String insert()
  {
    String str = "";
    str = "insert into tradetype values ('" + this.commen.convetStrToDb(getTrade_type_code()) + "'," + "'" + this.commen.convetStrToDb(getTrade_name()) + "'," + "'" + this.commen.convetStrToDb(getBpm_id()) + "'," + "'" + this.commen.convetStrToDb(getJudge_rights()) + "'," + "'" + this.commen.convetStrToDb(getTrade_kind()) + "'," + "'" + this.commen.convetStrToDb(getCancel_tag()) + "'," + "'" + this.commen.convetStrToDb(getTranse_type()) + "'," + "'" + this.commen.convetStrToDb(getSucceed_fwd()) + "'," + "'" + this.commen.convetStrToDb(getError_fwd()) + "'," + "'" + this.commen.convetStrToDb(getEnable_tag()) + "'," + "'" + this.commen.convetStrToDb(getStart_date()) + "'," + "'" + this.commen.convetStrToDb(getEnd_date()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str1()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str2()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str3()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str4()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str5()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str6()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str7()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str8()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str9()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str0()) + "'," + "'" + this.commen.convetStrToDb(getIn_date()) + "'," + "'" + this.commen.convetStrToDb(getRemark()) + "'" + ")";
    return str;
  }

  public void setParam(String paramString, Object paramObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("paramName", paramString);
    localHashMap.put("paramValue", paramObject);
    this.paramArray.add(localHashMap);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.bpm.TradeTypeDAO
 * JD-Core Version:    0.6.0
 */