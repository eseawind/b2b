package com.saas.biz.rightMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.commenDAO.CommparaExt;
import com.saas.biz.dao.productattrDAO.ProductattrExt;
import com.saas.biz.dao.productclassDAO.ProductclassExt;
import com.saas.biz.dao.rightsDAO.MenuinfoDAO;
import com.saas.biz.dao.rightsDAO.MenuinfoExt;
import com.saas.biz.dao.rightsDAO.ModuleinfoDAO;
import com.saas.biz.dao.rightsDAO.ModuleinfoExt;
import com.saas.biz.dao.tabelementDAO.TabelementExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class TradeInterface
{
  Logger log = new Logger(this);
  ArrayList queryResult = new ArrayList();
  Buffers outBuffer = new Buffers();
  Buffers inBuffer = new Buffers();
  commMethodMgr commen = new commMethodMgr();
  String date_time = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public void genTradeInterface(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入genTradeInterface方法...");
    String str = paramBuffers.getString("MENU_ID");
    this.log.LOG_INFO("进入genTradeInterface方法..." + str);
    try
    {
      this.queryResult = genTradeInterface(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genTradeInterface方法...");
  }

  public ArrayList genTradeInterface(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    MenuinfoDAO localMenuinfoDAO = new MenuinfoDAO();
    localMenuinfoExt.setParam(":VMENU_ID", paramString);
    localMenuinfoDAO = localMenuinfoExt.selByInfo("SEL_BY_PK");
    if (localMenuinfoDAO == null)
      new SaasApplicationException("该菜单无接口数据，业务无法继续！");
    ModuleinfoDAO localModuleinfoDAO = new ModuleinfoDAO();
    ModuleinfoExt localModuleinfoExt = new ModuleinfoExt();
    localModuleinfoExt.setParam(":VMODULE_ID", localMenuinfoDAO.getModule_id());
    localModuleinfoDAO = localModuleinfoExt.selByInfo("SEL_BY_PK");
    if (localModuleinfoDAO == null)
      new SaasApplicationException("该菜单无接口数据，业务无法继续！");
    String str1 = "?menu_id=" + paramString;
    if (localMenuinfoDAO.getIn_param_code1() != null)
      str1 = str1 + "&" + localMenuinfoDAO.getIn_param_code1() + "=" + localMenuinfoDAO.getIn_param_value1();
    if (localMenuinfoDAO.getIn_param_code2() != null)
      str1 = str1 + "&" + localMenuinfoDAO.getIn_param_code2() + "=" + localMenuinfoDAO.getIn_param_value2();
    if (localMenuinfoDAO.getIn_param_code3() != null)
      str1 = str1 + "&" + localMenuinfoDAO.getIn_param_code3() + "=" + localMenuinfoDAO.getIn_param_value3();
    String str2 = localModuleinfoDAO.getModule_dir() + "/" + localModuleinfoDAO.getModule_file() + str1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfacedir", str2);
    localArrayList.add(localHashMap);
    return localArrayList;
  }

  public void genUserTradeInterface(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genUserTradeInterface方法...");
    String str = paramBuffers.getString("TRADE_TYPE_CODE");
    this.outBuffer = paramBuffers;
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1 = genUserTradeInterface(str);
      localArrayList2 = genUserQueryInterface(str);
      this.queryResult.add(0, localArrayList1);
      this.queryResult.add(1, localArrayList2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genTradeInterface方法...");
  }

  public ArrayList genUserTradeInterface(String paramString)
    throws SaasApplicationException
  {
    this.inBuffer = this.outBuffer;
    TabelementExt localTabelementExt = new TabelementExt();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str1 = "";
    String str2 = "";
    localTabelementExt.setParam(":VTRADE_TYPE_CODE", paramString);
    localArrayList1 = localTabelementExt.selByList("SEL_BY_TRADE");
    if (localArrayList1 == null)
      new SaasApplicationException("该菜单无接口数据，业务无法继续！");
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
    String str13 = "";
    String str14 = "";
    String str15 = "";
    String str16 = "";
    String str17 = "";
    String str18 = "";
    String str19 = "";
    String str20 = "";
    String str21 = "";
    String str22 = "";
    String str23 = "";
    String str24 = "";
    String str25 = "";
    String str26 = "";
    String str27 = "";
    String str28 = "";
    String str29 = "";
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if (localHashMap.get("sys_code") != null)
        str3 = localHashMap.get("sys_code").toString();
      if (localHashMap.get("trade_type_code") != null)
        str4 = localHashMap.get("trade_type_code").toString();
      if (localHashMap.get("element_name") != null)
        str5 = localHashMap.get("element_name").toString();
      if (localHashMap.get("fields_name") != null)
        str6 = localHashMap.get("fields_name").toString();
      if (localHashMap.get("element_type") != null)
        str7 = localHashMap.get("element_type").toString();
      if (localHashMap.get("element_len") != null)
        str8 = localHashMap.get("element_len").toString();
      if (localHashMap.get("element_view") != null)
        str9 = localHashMap.get("element_view").toString();
      if (localHashMap.get("element_no") != null)
        str10 = localHashMap.get("element_no").toString();
      if (localHashMap.get("element_remark") != null)
        str11 = localHashMap.get("element_remark").toString();
      if (localHashMap.get("needed_tag") != null)
        str12 = localHashMap.get("needed_tag").toString();
      if (localHashMap.get("element_label") != null)
        str13 = localHashMap.get("element_label").toString();
      if (localHashMap.get("tab_name") != null)
        str14 = localHashMap.get("tab_name").toString();
      if (localHashMap.get("col_name") != null)
        str15 = localHashMap.get("col_name").toString();
      if (localHashMap.get("col_len") != null)
        str16 = localHashMap.get("col_len").toString();
      if (localHashMap.get("col_type") != null)
        str17 = localHashMap.get("col_type").toString();
      if (localHashMap.get("rsrv_str1") != null)
        str18 = localHashMap.get("rsrv_str1").toString();
      if (localHashMap.get("rsrv_str2") != null)
        str19 = localHashMap.get("rsrv_str2").toString();
      if (localHashMap.get("rsrv_str3") != null)
        str20 = localHashMap.get("rsrv_str3").toString();
      if (localHashMap.get("rsrv_str4") != null)
        str21 = localHashMap.get("rsrv_str4").toString();
      if (localHashMap.get("rsrv_str5") != null)
        str22 = localHashMap.get("rsrv_str5").toString();
      if (localHashMap.get("rsrv_str6") != null)
        str23 = localHashMap.get("rsrv_str6").toString();
      if (localHashMap.get("rsrv_str7") != null)
        str24 = localHashMap.get("rsrv_str7").toString();
      if (localHashMap.get("rsrv_str8") != null)
        str25 = localHashMap.get("rsrv_str8").toString();
      if (localHashMap.get("rsrv_str9") != null)
        str26 = localHashMap.get("rsrv_str9").toString();
      if (localHashMap.get("rsrv_str10") != null)
        str27 = localHashMap.get("rsrv_str10").toString();
      if (localHashMap.get("remark") != null)
        str28 = localHashMap.get("remark").toString();
      if ((str5.equalsIgnoreCase("trade_type_code")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + str4 + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("spec_class_name")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + this.inBuffer.getString("SPEC_CLASS_NAME") + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("spec_class_id")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + this.inBuffer.getString("SPEC_CLASS_ID") + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("spec_class_id_grp")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + this.inBuffer.getString("SPEC_CLASS_ID_GRP") + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("spec_class_name_grp")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + this.inBuffer.getString("SPEC_CLASS_NAME_GRP") + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("spec_class_type")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + this.inBuffer.getString("SPEC_CLASS_TYPE") + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("current_class")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + this.inBuffer.getString("CURRENT_CLASS") + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("up_class_id")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + this.inBuffer.getString("up_class_id") + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("grp_name")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + this.inBuffer.getString("GRP_NAME") + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("grp_id")) && (!str18.equalsIgnoreCase("1")))
      {
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + this.inBuffer.getString("GRP_ID") + "\">\r\n";
      }
      else if ((str5.equalsIgnoreCase("trade_type_code")) && (str18.equalsIgnoreCase("1")))
      {
        str2 = "1";
        str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=\"" + str22 + "\">\r\n";
      }
      if (str7.equalsIgnoreCase("0"))
      {
        int i = new Integer(str8).intValue();
        if (i >= 200)
        {
          str1 = str1 + "<tr><td class=graymn align=right>" + str13 + "：</td>   \r\n";
          str1 = str1 + "<td class=graymn align=left>                  \r\n";
          str1 = str1 + "<textarea name=\"" + str5 + "\" style=display:none></textarea>";
          str1 = str1 + "<iframe ID=" + str5 + " src=www/ewebeditor/ewebeditor.htm?id=" + str5 + "&style=coolblue" + str29 + " frameborder=0 scrolling=no width=500 HEIGHT=350></iframe>";
          str1 = str1 + " </td></tr>                                                  \r\n";
        }
        else
        {
          str1 = str1 + "<tr><td class=graymn align=right>" + str13 + "：</td>   \r\n";
          str1 = str1 + "<td class=graymn align=left>                  \r\n";
          str1 = str1 + "    <input name=\"" + str5 + "\" type=\"text\" size=" + str8 + " maxlength=" + str8 + ">" + str11 + "\r\n";
          str1 = str1 + " </td></tr>                                                  \r\n";
        }
      }
      else if (str7.equalsIgnoreCase("2"))
      {
        str1 = str1 + "<tr><td class=graymn align=right>" + str13 + "：</td>   \r\n";
        str1 = str1 + "<td class=graymn align=left>                  \r\n";
        str1 = str1 + "    <select name=" + str5 + ">";
        str1 = str1 + genOption(str5);
        str1 = str1 + "    </select>";
        str1 = str1 + " </td></tr>                                                  \r\n";
      }
      else if (!str7.equalsIgnoreCase("3"))
      {
        if (str7.equalsIgnoreCase("5"))
        {
          str1 = str1 + "<tr><td class=graymn align=right>" + str13 + "：</td>   \r\n";
          str1 = str1 + "<td class=graymn align=left>                  \r\n";
          str1 = str1 + "    <input name=\"" + str5 + "\" readonly type=\"text\" size=" + str8 + "  value=" + this.date_time + " maxlength=" + str8 + ">" + str11 + "\r\n";
          str1 = str1 + " <A onclick=event.cancelBubble=true;href=\"javascript:showCalendar('" + str5 + "',false,'" + str5 + "',null);\"><IMG\r\n";
          str1 = str1 + "         id=" + str5 + " height=21                                                                               \r\n";
          str1 = str1 + "         src=\"img/button.gif\" width=34                                                                        \r\n";
          str1 = str1 + "         align=absMiddle border=0></A> \r\n";
          str1 = str1 + " </td></tr>                                                  \r\n";
        }
        else if (str7.equalsIgnoreCase("4"))
        {
          str1 = str1 + "<tr><td class=graymn align=right>" + str13 + "：</td>   \r\n";
          str1 = str1 + "<td class=graymn align=left>                  \r\n";
          str1 = str1 + "    <input name=\"" + str5 + "\" type=\"file\" >" + str11 + "\r\n";
          str1 = str1 + " </td></tr>                                                  \r\n";
        }
        else if (str7.equalsIgnoreCase("6"))
        {
          str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\" value=" + this.commen.GenTradeId() + ">\r\n";
          str29 = str29 + "&root_id=" + this.commen.GenTradeId();
        }
        else if (str7.equalsIgnoreCase("7"))
        {
          str1 = str1 + "<tr><td class=graymn align=right>" + str13 + "：</td>   \r\n";
          str1 = str1 + "<td class=graymn align=left>                  \r\n";
          str1 = str1 + "    <select name=" + str5 + ">";
          str1 = str1 + genSpecOption(str5);
          str1 = str1 + "    </select>";
          str1 = str1 + " </td></tr>                                                  \r\n";
        }
        else if (str7.equalsIgnoreCase("8"))
        {
          str1 = str1 + "    <input name=\"" + str5 + "\" type=\"hidden\"  >\r\n";
        }
      }
      str3 = "";
      str4 = "";
      str5 = "";
      str6 = "";
      str7 = "";
      str8 = "";
      str9 = "";
      str10 = "";
      str11 = "";
      str12 = "";
      str13 = "";
      str14 = "";
      str15 = "";
      str16 = "";
      str17 = "";
      str18 = "";
      str19 = "";
      str20 = "";
      str21 = "";
      str22 = "";
      str23 = "";
      str24 = "";
      str25 = "";
      str26 = "";
      str27 = "";
      str28 = "";
    }
    if ((!str2.equalsIgnoreCase("1")) && (this.inBuffer.getString("spec_class_type").equals("2")))
      str1 = str1 + genAllattr(this.inBuffer.getString("spec_class_id"));
    localArrayList2.add(str1);
    return localArrayList2;
  }

  public String genAllattr(String paramString)
  {
    this.log.LOG_INFO("进入genAllattr.................");
    String str1 = "";
    String str2 = paramString;
    ArrayList localArrayList1 = new ArrayList();
    ProductclassExt localProductclassExt1 = new ProductclassExt();
    localProductclassExt1.setParam(":VCLASS_ID", str2);
    localArrayList1 = localProductclassExt1.selByList("SEL_BY_CLASSID");
    Iterator localIterator1 = localArrayList1.iterator();
    HashMap localHashMap1 = (HashMap)localIterator1.next();
    str1 = str1 + genProdattrt(localHashMap1.get("class_id").toString());
    if ((localHashMap1.get("up_class_id") != null) && (!localHashMap1.get("up_class_id").equals("000000000000000")))
      str2 = localHashMap1.get("up_class_id").toString();
    else
      str2 = "000000000000000";
    while ((str2 != null) && (!str2.equals("000000000000000")))
    {
      ArrayList localArrayList2 = new ArrayList();
      ProductclassExt localProductclassExt2 = new ProductclassExt();
      localProductclassExt2.setParam(":VCLASS_ID", str2);
      localArrayList2 = localProductclassExt2.selByList("SEL_BY_CLASSID");
      Iterator localIterator2 = localArrayList2.iterator();
      HashMap localHashMap2 = (HashMap)localIterator2.next();
      str1 = str1 + genDefaultProdattrt(localHashMap2.get("class_id").toString());
      this.log.LOG_INFO("gggggggggggggggggggggggggggg" + localHashMap2.get("up_class_id").toString());
      if ((localHashMap2.get("up_class_id") != null) && (!localHashMap2.get("up_class_id").equals("000000000000000")))
      {
        if (!localHashMap2.get("up_class_id").toString().equals(""))
          str2 = localHashMap2.get("up_class_id").toString();
      }
      else
        str2 = "000000000000000";
    }
    this.log.LOG_INFO("退出genAllattr.................");
    return str1;
  }

  public String genDefaultProdattrt(String paramString)
  {
    this.log.LOG_INFO("进入genDefaultProdattrt.................");
    String str = "";
    ArrayList localArrayList = new ArrayList();
    ProductattrExt localProductattrExt = new ProductattrExt();
    localProductattrExt.setParam(":VCLASS_ID", paramString);
    localProductattrExt.setParam(":VENABLE_TAG", "0");
    localArrayList = localProductattrExt.selByList("SEL_BY_CLASSID");
    if (localArrayList == null)
      return str;
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if (localHashMap.get("default_tag") != null)
        if (localHashMap.get("rsrv_str3").equals("0"))
        {
          if (localHashMap.get("rsrv_str3") != null)
          {
            str = str + "<tr><td class=graymn align=right>" + localHashMap.get("attr_name") + "：</td>   \r\n";
            str = str + "<td class=graymn align=left>                  \r\n";
            str = str + "<input  name= attr" + localHashMap.get("rsrv_str4").toString() + " type=\"text\" >\r\n";
            str = str + " </td></tr> ";
          }
        }
        else if ((localHashMap.get("rsrv_str3") != null) && (!localHashMap.get("rsrv_str3").equals("0")) && (localHashMap.get("rsrv_str3") != null))
        {
          str = str + "<tr><td class=graymn align=right>" + localHashMap.get("attr_name").toString() + "：</td>\r\n";
          str = str + "<td class=graymn align=left>                  \r\n";
          str = str + "<select name=attr" + localHashMap.get("rsrv_str4").toString() + ">";
          str = str + genattrOption(localHashMap.get("rsrv_str3").toString());
          str = str + "</select>";
          str = str + " </td></tr> ";
        }
    }
    this.log.LOG_INFO("退出genDefaultProdattrt.................");
    return str;
  }

  public String genProdattrt(String paramString)
  {
    this.log.LOG_INFO("进入genProdattrt.................");
    String str = "";
    ArrayList localArrayList = new ArrayList();
    ProductattrExt localProductattrExt = new ProductattrExt();
    localProductattrExt.setParam(":VCLASS_ID", paramString);
    localProductattrExt.setParam(":VENABLE_TAG", "0");
    localArrayList = localProductattrExt.selByList("SEL_BY_CLASSID");
    if (localArrayList == null)
      return str;
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if (localHashMap.get("rsrv_str3").equals("0"))
      {
        if (localHashMap.get("rsrv_str3") != null)
        {
          str = str + "<tr><td class=graymn align=right>" + localHashMap.get("attr_name") + "：</td>   \r\n";
          str = str + "<td class=graymn align=left>                  \r\n";
          str = str + "<input  name= attr" + localHashMap.get("rsrv_str4").toString() + " type=\"text\" >\r\n";
          str = str + " </td></tr> ";
        }
      }
      else if ((localHashMap.get("rsrv_str3") != null) && (!localHashMap.get("rsrv_str3").equals("0")) && (localHashMap.get("rsrv_str3") != null))
      {
        str = str + "<tr><td class=graymn align=right>" + localHashMap.get("attr_name").toString() + "：</td>\r\n";
        str = str + "<td class=graymn align=left>                  \r\n";
        str = str + "<select name=attr" + localHashMap.get("rsrv_str4").toString() + ">";
        str = str + genattrOption(localHashMap.get("rsrv_str3").toString());
        str = str + "</select>";
        str = str + " </td></tr> ";
      }
    }
    this.log.LOG_INFO("退出genProdattrt.................");
    return str;
  }

  public String genattrOption(String paramString)
  {
    String str1 = "";
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VSUBSYS_CODE", "CRM");
    localCommparaExt.setParam(":VPARAM_ATTR", paramString);
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR");
    if (localArrayList == null)
    {
      str1 = "<option value=0>无数据</option>";
      return str1;
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      String str3 = "";
      if (localHashMap.get("para_code1") != null)
        str2 = localHashMap.get("para_code1").toString();
      if (localHashMap.get("para_code2") != null)
        str3 = localHashMap.get("para_code2").toString();
      str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>\r\n";
    }
    return str1;
  }

  public String genOption(String paramString)
  {
    String str1 = "";
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VSUBSYS_CODE", "CRM");
    localCommparaExt.setParam(":VPARAM_CODE", paramString);
    localArrayList = localCommparaExt.selByList("SEL_BY_CODE");
    if (localArrayList == null)
    {
      str1 = "<option value=0>无数据</option>";
      return str1;
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      String str3 = "";
      if (localHashMap.get("para_code1") != null)
        str2 = localHashMap.get("para_code1").toString();
      if (localHashMap.get("para_code2") != null)
        str3 = localHashMap.get("para_code2").toString();
      str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>\r\n";
    }
    return str1;
  }

  public void genUserQueryInterface(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genUserQueryInterface方法...");
    this.outBuffer = paramBuffers;
    String str = paramBuffers.getString("TRADE_TYPE_CODE");
    try
    {
      this.queryResult = genUserQueryInterface(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genUserQueryInterface方法...");
  }

  public ArrayList genUserQueryInterface(String paramString)
    throws SaasApplicationException
  {
    TabelementExt localTabelementExt = new TabelementExt();
    ArrayList localArrayList = new ArrayList();
    localTabelementExt.setParam(":VTRADE_TYPE_CODE", paramString);
    localArrayList = localTabelementExt.selByList("SEL_BY_TRADE");
    if (localArrayList == null)
      new SaasApplicationException("该菜单无接口数据，业务无法继续！");
    return localArrayList;
  }

  public String genSpecOption(String paramString)
  {
    String str1 = "";
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localArrayList = localCommparaExt.selByList(paramString);
    if (localArrayList == null)
    {
      str1 = "<option value=0>无数据</option>";
      return str1;
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      String str3 = "";
      if (localHashMap.get("para_code1") != null)
        str2 = localHashMap.get("para_code1").toString();
      if (localHashMap.get("para_code2") != null)
        str3 = localHashMap.get("para_code2").toString();
      str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>\r\n";
    }
    return str1;
  }

  public String codeToName(String paramString1, String paramString2)
  {
    String str1 = "";
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VPARAM_CODE", paramString1);
    localCommparaExt.setParam(":VPARA_CODE1", paramString2);
    localArrayList = localCommparaExt.selByList("SEL_BY_CODE1");
    if (localArrayList == null)
    {
      str1 = "参数未配置[" + paramString1 + "]:[" + paramString2 + "]";
      return str1;
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      String str3 = "";
      if (localHashMap.get("para_code1") != null)
        str2 = localHashMap.get("para_code1").toString();
      if (localHashMap.get("para_code2") != null)
        str3 = localHashMap.get("para_code2").toString();
      str1 = str1 + str2 + ": " + str3;
    }
    return str1;
  }

  public String comCodetoName(String paramString1, String paramString2)
  {
    String str1 = "";
    CommparaExt localCommparaExt = new CommparaExt();
    String str2 = "";
    String str3 = "";
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VSVALUE", paramString2);
    this.log.LOG_INFO("SQL+=======================" + paramString1);
    localArrayList = localCommparaExt.selByList(paramString1);
    if (localArrayList == null)
    {
      str1 = "参数未配置";
      return str1;
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      if (localHashMap.get("para_code2") != null)
        str3 = localHashMap.get("para_code2").toString();
    }
    return str3;
  }

  public String getRealName(String paramString)
  {
    String str1 = "";
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VStrFieldValue", paramString);
    localArrayList = localCommparaExt.selByList("SEL_USER_NAME");
    if (localArrayList == null)
    {
      str1 = "参数未配置";
      return str1;
    }
    Iterator localIterator = localArrayList.iterator();
    String str2 = "";
    HashMap localHashMap = (HashMap)localIterator.next();
    if (localHashMap.get("realname") != null)
      str2 = localHashMap.get("realname").toString();
    str1 = str1 + str2;
    return str1;
  }

  public String getCustSpeOption(String paramString1, String paramString2)
  {
    String str1 = "";
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localCommparaExt.selByList(paramString1);
    if (localArrayList == null)
    {
      str1 = "<option value=0>无数据</option>";
      return str1;
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str2 = "";
      String str3 = "";
      if (localHashMap.get("para_code1") != null)
        str2 = localHashMap.get("para_code1").toString();
      if (localHashMap.get("para_code2") != null)
        str3 = localHashMap.get("para_code2").toString();
      str1 = str1 + "<option value=" + str2 + ">" + str3 + "</option>\r\n";
    }
    return str1;
  }

  public String getMenuInfoType(String paramString)
    throws SaasApplicationException
  {
    String str = "0";
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_ID", paramString);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_PK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("menu_type") != null)
        str = localHashMap.get("menu_type").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.rightMgr.TradeInterface
 * JD-Core Version:    0.6.0
 */