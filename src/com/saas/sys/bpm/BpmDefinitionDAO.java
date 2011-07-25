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

public class BpmDefinitionDAO
{
  private Dbexecute exec;
  private commMethodMgr commen;
  Logger log = new Logger(this);
  ArrayList paramArray = new ArrayList();
  private String trade_type_code;
  private String bpm_id;
  private String node_id;
  private String node_type;
  private int node_sequence;
  private String node_class;
  private String node_method;
  private String out_query;
  private String out_buffer;
  private String undo_tag;
  private String unde_class;
  private String undo_method;
  private String undo_out_query;
  private String undo_out_buffer;
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

  public String getBpm_id()
  {
    return this.bpm_id;
  }

  public String getNode_id()
  {
    return this.node_id;
  }

  public String getNode_type()
  {
    return this.node_type;
  }

  public int getNode_sequence()
  {
    return this.node_sequence;
  }

  public String getNode_class()
  {
    return this.node_class;
  }

  public String getNode_method()
  {
    return this.node_method;
  }

  public String getOut_query()
  {
    return this.out_query;
  }

  public String getOut_buffer()
  {
    return this.out_buffer;
  }

  public String getUndo_tag()
  {
    return this.undo_tag;
  }

  public String getUnde_class()
  {
    return this.unde_class;
  }

  public String getUndo_method()
  {
    return this.undo_method;
  }

  public String getUndo_out_query()
  {
    return this.undo_out_query;
  }

  public String getUndo_out_buffer()
  {
    return this.undo_out_buffer;
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

  public void setBpm_id(String paramString)
  {
    this.bpm_id = paramString;
  }

  public void setNode_id(String paramString)
  {
    this.node_id = paramString;
  }

  public void setNode_type(String paramString)
  {
    this.node_type = paramString;
  }

  public void setNode_sequence(int paramInt)
  {
    this.node_sequence = paramInt;
  }

  public void setNode_class(String paramString)
  {
    this.node_class = paramString;
  }

  public void setNode_method(String paramString)
  {
    this.node_method = paramString;
  }

  public void setOut_query(String paramString)
  {
    this.out_query = paramString;
  }

  public void setOut_buffer(String paramString)
  {
    this.out_buffer = paramString;
  }

  public void setUndo_tag(String paramString)
  {
    this.undo_tag = paramString;
  }

  public void setUnde_class(String paramString)
  {
    this.unde_class = paramString;
  }

  public void setUndo_method(String paramString)
  {
    this.undo_method = paramString;
  }

  public void setUndo_out_query(String paramString)
  {
    this.undo_out_query = paramString;
  }

  public void setUndo_out_buffer(String paramString)
  {
    this.undo_out_buffer = paramString;
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
    this.exec.setStrTable("bpmdefinition");
    this.exec.setStrQuery(paramString);
    this.exec.setParamList(this.paramArray);
    localArrayList = this.exec.selBizQuery();
    if (localArrayList.size() <= 0)
      return null;
    return localArrayList;
  }

  public BpmDefinitionDAO selByInfo(String paramString)
  {
    this.exec = new Dbexecute();
    this.commen = new commMethodMgr();
    BpmDefinitionDAO localBpmDefinitionDAO = new BpmDefinitionDAO();
    ArrayList localArrayList = new ArrayList();
    this.exec.setStrTable("bpmdefinition");
    this.exec.setStrQuery(paramString);
    this.exec.setParamList(this.paramArray);
    localArrayList = this.exec.selBizQuery();
    if (localArrayList.size() <= 0)
      return null;
    Field[] arrayOfField = localBpmDefinitionDAO.getClass().getDeclaredFields();
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
          PropertyUtils.setProperty(localBpmDefinitionDAO, arrayOfField[i].getName(), localHashMap.get(arrayOfField[i].getName()));
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
    return localBpmDefinitionDAO;
  }

  public int selCount(String paramString)
  {
    this.exec = new Dbexecute();
    return 0;
  }

  public String insert()
  {
    String str = "";
    str = "insert into bpmdefinition values ('" + this.commen.convetStrToDb(getTrade_type_code()) + "'," + "'" + this.commen.convetStrToDb(getBpm_id()) + "'," + "'" + this.commen.convetStrToDb(getNode_id()) + "'," + "'" + this.commen.convetStrToDb(getNode_type()) + "'," + getNode_sequence() + "," + "'" + this.commen.convetStrToDb(getNode_class()) + "'," + "'" + this.commen.convetStrToDb(getNode_method()) + "'," + "'" + this.commen.convetStrToDb(getOut_query()) + "'," + "'" + this.commen.convetStrToDb(getOut_buffer()) + "'," + "'" + this.commen.convetStrToDb(getUndo_tag()) + "'," + "'" + this.commen.convetStrToDb(getUnde_class()) + "'," + "'" + this.commen.convetStrToDb(getUndo_method()) + "'," + "'" + this.commen.convetStrToDb(getUndo_out_query()) + "'," + "'" + this.commen.convetStrToDb(getUndo_out_buffer()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str1()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str2()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str3()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str4()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str5()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str6()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str7()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str8()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str9()) + "'," + "'" + this.commen.convetStrToDb(getRsrv_str0()) + "'," + "'" + this.commen.convetStrToDb(getIn_date()) + "'," + "'" + this.commen.convetStrToDb(getRemark()) + "'" + ")";
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
 * Qualified Name:     com.saas.sys.bpm.BpmDefinitionDAO
 * JD-Core Version:    0.6.0
 */