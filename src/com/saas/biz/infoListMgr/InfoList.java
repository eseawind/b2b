package com.saas.biz.infoListMgr;

import com.buildhtml.CreateArticle;
import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.channelMgr.ChannelInfo;
import com.saas.biz.commen.config;
import com.saas.biz.custMgr.Custinfo;
import com.saas.biz.dao.infoListDAO.InfoListDAO;
import com.saas.biz.dao.infoListDAO.InfoListExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class InfoList
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

  public void addInfoCreateArticle(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addInfoCreateArticle方法...");
    this.outBuffer = paramBuffers;
    CreateArticle localCreateArticle = new CreateArticle();
    String str1 = paramBuffers.getString("CH_CONT_MOD");
    String str2 = paramBuffers.getString("CH_CH_ID");
    ChannelInfo localChannelInfo = new ChannelInfo();
    String str3 = str2;
    ArrayList localArrayList = new ArrayList();
    if (!str1.equals(""))
    {
      localArrayList = localChannelInfo.getSaveDirByChLevelAndContMod("1", str1);
      if (localArrayList != null)
      {
       HashMap localObject = (HashMap)localArrayList.get(0);
        if (((HashMap)localObject).get("ch_id") != null)
          str3 = ((HashMap)localObject).get("ch_id").toString();
      }
    }
    Object localObject = new CreateArticle();
    CreateArticle.CreateArticle(str3, "2");
    int i = 0;
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
    this.log.LOG_INFO("退出addInfoCreateArticle方法...");
  }

  public void AddInfoListReg(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入AddInfoListReg方法...");
    this.outBuffer = paramBuffers;
    InfoListDAO localInfoListDAO = new InfoListDAO();
    String str = "";
    localInfoListDAO.setInfo_id(paramBuffers.getString("CUST_ID"));
    localInfoListDAO.setTitle(paramBuffers.getString("TITLE"));
    localInfoListDAO.setContents(paramBuffers.getString("CONTENTS"));
    localInfoListDAO.setTag(paramBuffers.getString("TAG"));
    localInfoListDAO.setSrc(paramBuffers.getString("SRC"));
    localInfoListDAO.setAuthor(paramBuffers.getString("AUTHOR"));
    localInfoListDAO.setMini_img(paramBuffers.getString("MINI_IMG"));
    localInfoListDAO.setCh_id(paramBuffers.getString("CH_ID"));
    localInfoListDAO.setMimi_title(paramBuffers.getString("MIMI_TITLE"));
    localInfoListDAO.setUser_temp(paramBuffers.getString("USER_TEMP"));
    localInfoListDAO.setPub_date(paramBuffers.getString("PUB_DATE"));
    localInfoListDAO.setTitle_color(paramBuffers.getString("TITLE_COLOR"));
    localInfoListDAO.setRead_right(paramBuffers.getString("READ_RIGHT"));
    localInfoListDAO.setCreate_tag(paramBuffers.getString("CREATE_TAG"));
    localInfoListDAO.setInfo_dsec(paramBuffers.getString("INFO_DSEC"));
    localInfoListDAO.setInfo_key(paramBuffers.getString("INFO_KEY"));
    localInfoListDAO.setMessage_tag(paramBuffers.getString("MESSAGE_TAG"));
    localInfoListDAO.setLog_tag(paramBuffers.getString("LOG_TAG"));
    localInfoListDAO.setOther_tag(paramBuffers.getString("OTHER_TAG"));
    localInfoListDAO.setIn_date(paramBuffers.getString("IN_DATE"));
    localInfoListDAO.setRemark(paramBuffers.getString("REMARK"));
    localInfoListDAO.setRsrv_str1(paramBuffers.getString("RSRV_STR1"));
    localInfoListDAO.setRsrv_str2(paramBuffers.getString("RSRV_STR2"));
    int i = -1;
    try
    {
      i = AddInfoList(localInfoListDAO, str);
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
    this.log.LOG_INFO("退出AddInfoList方法...");
  }

  public void AddInfoList(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入AddInfoList方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = "";
    Custinfo localCustinfo = new Custinfo();
    InfoListDAO localInfoListDAO = new InfoListDAO();
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    localInfoListDAO.setInfo_id(paramBuffers.getString("INFO_ID"));
    localInfoListDAO.setTitle(paramBuffers.getString("TITLE"));
    localInfoListDAO.setContents(paramBuffers.getString("CONTENTS"));
    localInfoListDAO.setTag(paramBuffers.getString("TAG"));
    localInfoListDAO.setSrc(paramBuffers.getString("SRC"));
    localInfoListDAO.setAuthor(paramBuffers.getString("AUTHOR"));
    str1 = localCustinfo.getCustTypeById(str2);
    String str3 = paramBuffers.getString("INFO_ID");
    Attachinfo localAttachinfo = new Attachinfo();
    String str4 = localAttachinfo.getAttachAddr(str3);
    localInfoListDAO.setMini_img(str4);
    localInfoListDAO.setMimi_title(paramBuffers.getString("MIMI_TITLE"));
    localInfoListDAO.setUser_temp(paramBuffers.getString("USER_TEMP"));
    localInfoListDAO.setPub_date(paramBuffers.getString("PUB_DATE"));
    localInfoListDAO.setTitle_color(paramBuffers.getString("TITLE_COLOR"));
    localInfoListDAO.setRead_right(paramBuffers.getString("READ_RIGHT"));
    localInfoListDAO.setCreate_tag(paramBuffers.getString("CREATE_TAG"));
    localInfoListDAO.setInfo_dsec(paramBuffers.getString("INFO_DSEC"));
    localInfoListDAO.setInfo_key(paramBuffers.getString("INFO_KEY"));
    localInfoListDAO.setMessage_tag(paramBuffers.getString("MESSAGE_TAG"));
    localInfoListDAO.setLog_tag(paramBuffers.getString("LOG_TAG"));
    localInfoListDAO.setOther_tag(paramBuffers.getString("OTHER_TAG"));
    localInfoListDAO.setIn_date(paramBuffers.getString("IN_DATE"));
    localInfoListDAO.setRemark(paramBuffers.getString("REMARK"));
    try
    {
      localInfoListDAO.setCh_id(paramBuffers.getString("CH_ID"));
      i = AddInfoList(localInfoListDAO, str2);
      if ((!str1.equals("1")) && ((paramBuffers.getString("CUST_CH_ID") != "") || (!paramBuffers.getString("CUST_CH_ID").equals(""))))
      {
        localInfoListDAO.setCh_id(paramBuffers.getString("CUST_CH_ID"));
        i = AddInfoList(localInfoListDAO, str2);
      }
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败2222222222222！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出AddInfoList方法...");
  }

  public int AddInfoList(InfoListDAO paramInfoListDAO, String paramString)
    throws SaasApplicationException
  {
    InfoListExt localInfoListExt = new InfoListExt();
    String str = paramInfoListDAO.getInfo_id();
    localInfoListExt.setParam(":VCUST_ID", paramString);
    localInfoListExt.setParam(":VINFO_ID", paramInfoListDAO.getInfo_id());
    localInfoListExt.setParam(":VTITLE", paramInfoListDAO.getTitle());
    localInfoListExt.setParam(":VCONTENTS", paramInfoListDAO.getContents());
    localInfoListExt.setParam(":VTAG", paramInfoListDAO.getTag());
    localInfoListExt.setParam(":VSRC", paramInfoListDAO.getSrc());
    localInfoListExt.setParam(":VAUTHOR", paramInfoListDAO.getAuthor());
    localInfoListExt.setParam(":VMINI_IMG", paramInfoListDAO.getMini_img());
    localInfoListExt.setParam(":VCH_ID", paramInfoListDAO.getCh_id());
    localInfoListExt.setParam(":VMIMI_TITLE", paramInfoListDAO.getMimi_title());
    localInfoListExt.setParam(":VUSER_TEMP", paramInfoListDAO.getUser_temp());
    localInfoListExt.setParam(":VPUB_DATE", paramInfoListDAO.getPub_date());
    localInfoListExt.setParam(":VTITLE_COLOR", paramInfoListDAO.getTitle_color());
    localInfoListExt.setParam(":VREAD_RIGHT", paramInfoListDAO.getRead_right());
    localInfoListExt.setParam(":VCREATE_TAG", paramInfoListDAO.getCreate_tag());
    localInfoListExt.setParam(":VINFO_DSEC", paramInfoListDAO.getInfo_dsec());
    localInfoListExt.setParam(":VINFO_KEY", paramInfoListDAO.getInfo_key());
    localInfoListExt.setParam(":VMESSAGE_TAG", paramInfoListDAO.getMessage_tag());
    localInfoListExt.setParam(":VLOG_TAG", paramInfoListDAO.getLog_tag());
    localInfoListExt.setParam(":VOTHER_TAG", paramInfoListDAO.getOther_tag());
    localInfoListExt.setParam(":VIN_DATE", paramInfoListDAO.getIn_date());
    localInfoListExt.setParam(":VREMARK", paramInfoListDAO.getRemark());
    HashMap localHashMap = getCastById(str);
    if ((localHashMap != null) && (localHashMap.size() > 0))
    {
      this.log.LOG_INFO("开始执行updateSQL:" + localInfoListExt.insBy("UP_INFO_BY_IT"));
      this.tradeQuery.executeBy(localInfoListExt.insBy("UP_INFO_BY_IT"));
    }
    else
    {
      this.log.LOG_INFO("开始执行insertSQL:" + localInfoListExt.insBy("IN_INFO_BY_ALL"));
      this.tradeQuery.executeBy(localInfoListExt.insBy("IN_INFO_BY_ALL"));
    }
    return 0;
  }

  public void AddInfoListNew(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入AddInfoListnew方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    config localconfig = new config();
    localconfig.init();
    String str1 = localconfig.getString("checkregimage");
    String str2 = "";
    String str3 = "";
    InfoListDAO localInfoListDAO = new InfoListDAO();
    String str4 = paramBuffers.getString("CUST_ID");
    String str5 = paramBuffers.getString("CH_ID");
    localInfoListDAO.setTitle(paramBuffers.getString("CUST_AIM"));
    localInfoListDAO.setInfo_id(paramBuffers.getString("CUST_ID"));
    if (str1.equals("1"))
    {
      str2 = paramBuffers.getString("USERRAND").trim();
      str3 = paramBuffers.getString("RANDOMCODE").trim();
      this.log.LOG_INFO("userrand=" + str2 + "********randomcode=" + str3);
      if (str2.equalsIgnoreCase(str3))
      {
        try
        {
          i = AddInfoListNew(localInfoListDAO, str4, str5);
        }
        catch (SaasApplicationException localSaasApplicationException1)
        {
          this.log.LOG_INFO(localSaasApplicationException1.getMessage());
        }
        if (i != 0)
        {
          this.outBuffer.setInt("RESULT_CODE", -1);
          this.outBuffer.setString("RESULT_INFO", "11业务处理失败！");
        }
        else
        {
          this.outBuffer.setInt("RESULT_CODE", 0);
          this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
        }
      }
      else
      {
        this.outBuffer.setInt("RESULT_CODE", -1);
        this.outBuffer.setString("RESULT_INFO", "校验码输入错误，请返回重新输入！");
      }
    }
    else
    {
      try
      {
        i = AddInfoListNew(localInfoListDAO, str4, str5);
      }
      catch (SaasApplicationException localSaasApplicationException2)
      {
        this.log.LOG_INFO(localSaasApplicationException2.getMessage());
      }
      if (i != 0)
      {
        this.outBuffer.setInt("RESULT_CODE", -1);
        this.outBuffer.setString("RESULT_INFO", "11业务处理失败！");
      }
      else
      {
        this.outBuffer.setInt("RESULT_CODE", 0);
        this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
      }
    }
    this.log.LOG_INFO("退出AddInfoList方法...");
  }

  public int AddInfoListNew(InfoListDAO paramInfoListDAO, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    InfoListExt localInfoListExt = new InfoListExt();
    String str = paramInfoListDAO.getInfo_id();
    localInfoListExt.setParam(":VCUST_ID", "");
    localInfoListExt.setParam(":VCH_ID", paramString2);
    localInfoListExt.setParam(":VINFO_ID", paramInfoListDAO.getInfo_id());
    localInfoListExt.setParam(":VTITLE", paramInfoListDAO.getTitle());
    this.log.LOG_INFO("开始执行insertSQL:" + localInfoListExt.insBy("IN_INFO_BY_ALL_NEW"));
    this.tradeQuery.executeBy(localInfoListExt.insBy("IN_INFO_BY_ALL_NEW"));
    return 0;
  }

  public void UpdateInfoListByCustLogo(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入UpdateInfoListByCustLogo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    Attachinfo localAttachinfo = new Attachinfo();
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = localAttachinfo.getAttachAddr(str1);
    try
    {
      i = UpdateInfoListByCustLogo(str1, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "11业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出AddInfoList方法...");
  }

  public int UpdateInfoListByCustLogo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramString1);
    localInfoListExt.setParam(":VMINI_IMG", paramString2);
    this.tradeQuery.executeBy(localInfoListExt.insBy("UPDATE_INFO_BY_CUST_LOGO"));
    return 0;
  }

  public HashMap getCastById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap = new HashMap();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramString);
    ArrayList localArrayList = localInfoListExt.selByList("SEL_INFO_BY_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      localHashMap = (HashMap)localArrayList.get(0);
    return localHashMap;
  }

  public ArrayList getInfoListById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramString);
    localArrayList = localInfoListExt.selByList("SEL_INFO_BY_ID");
    return localArrayList;
  }

  public String getClassInfoNumByClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VCLASS_ID", paramString1);
    localInfoListExt.setParam(":VCONT_MOD", paramString2);
    localArrayList = localInfoListExt.selByList("SEL_CLASS_INFONUM_BY_CLASSID");
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ct") != null)
        str = "(" + localHashMap.get("ct").toString() + ")";
      else
        str = "";
    }
    return str;
  }

  public ArrayList getCustClassByCustId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VCUST_ID", paramString1);
    localInfoListExt.setParam(":VCONT_MOD", paramString2);
    localArrayList = localInfoListExt.selByList("SEL_CONTMOD_CLASS_CMODE_BY_CUST_ID");
    return localArrayList;
  }

  public ArrayList getCustClassByCustIdClassId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VCUST_ID", paramString1);
    localInfoListExt.setParam(":VCONT_MOD", paramString2);
    localInfoListExt.setParam(":VCLASS_ID", paramString3);
    localArrayList = localInfoListExt.selByList("SEL_CONTMOD_CLASS_CMODE_BY_CUST_ID_CLASSID");
    return localArrayList;
  }

  public ArrayList getInfoListByAreaCode(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VAREA_CODE", paramString2);
    localInfoListExt.setParam(":VCHANNLE_ID", paramString1);
    localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_AREA_CODE", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getInfoListByAreaCode(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VAREA_CODE", paramString2);
    localInfoListExt.setParam(":VCHANNLE_ID", paramString1);
    if ((paramString3.equals("0")) || (paramString3.equals("5")))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_AREA_CODE_BY_NEWS", paramInt1, paramInt2);
    if (paramString3.equals("1"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_AREA_CODE_BY_SUPPLY", paramInt1, paramInt2);
    if (paramString3.equals("7"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_AREA_CODE_BY_TWOHAND", paramInt1, paramInt2);
    if (paramString3.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_AREA_CODE_BY_STOCK", paramInt1, paramInt2);
    if (paramString3.equals("3"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_AREA_CODE_BY_PRODUCT", paramInt1, paramInt2);
    if ((paramString3.equals("4")) || (paramString3.equals("9")))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_AREA_CODE_BY_ENTERPRISE", paramInt1, paramInt2);
    if (paramString3.equals("6"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_AREA_CODE_ZHANHUI", paramInt1, paramInt2);
    if (paramString3.equals("8"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_AREA_CODE_BY_AIWEN", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getInfoListByClassId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VCLASS_ID", paramString2);
    localInfoListExt.setParam(":VCHANNLE_ID", paramString1);
    if (paramString3.equals("1"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_SUPPLY");
    if (paramString3.equals("7"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_TWOHAND");
    if (paramString3.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_STOCK");
    if (paramString3.equals("3"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_PRODUCT");
    if ((paramString3.equals("4")) || (paramString3.equals("9")))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_ENTERPRISE");
    if (paramString3.equals("15"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_BOOK");
    return localArrayList;
  }

  public ArrayList getInfoListByClassIdByLimit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VCLASS_ID", paramString2);
    localInfoListExt.setParam(":VCHANNLE_ID", paramString1);
    if (paramString3.equals("1"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_SUPPLY", paramInt1, paramInt2);
    if (paramString3.equals("7"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_TWOHAND", paramInt1, paramInt2);
    if (paramString3.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_STOCK", paramInt1, paramInt2);
    if (paramString3.equals("3"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_PRODUCT", paramInt1, paramInt2);
    if ((paramString3.equals("4")) || (paramString3.equals("9")))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_ENTERPRISE", paramInt1, paramInt2);
    if (paramString3.equals("15"))
      localArrayList = localInfoListExt.selByList("SEL_INFOLIST_BY_CLASSID_BY_BOOK", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getCustInfoLists()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localArrayList = localInfoListExt.selByList("SEL_CUSTINFO_BY_CHID");
    return localArrayList;
  }

  public ArrayList getSelInfoLists()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localArrayList = localInfoListExt.selByList("SEL_SELINFO_BY_CHID");
    return localArrayList;
  }

  public ArrayList getInfoList(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VICH_ID", paramString);
    localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getInfoListByContmod(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    String str = "0";
    if (paramString2.equals("1"))
      str = "0";
    else if (paramString2.equals("7"))
      str = "1";
    else if (paramString2.equals("16"))
      str = "2";
    else if (paramString2.equals("17"))
      str = "3";
    localInfoListExt.setParam(":VICH_ID", paramString1);
    localInfoListExt.setParam(":VSALE_TYPE", str);
    if (paramString2.equals("0"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_NEWS");
    if ((paramString2.equals("1")) || (paramString2.equals("7")) || (paramString2.equals("16")) || (paramString2.equals("17")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_SUPPLY");
    if (paramString2.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_STOCK");
    if (paramString2.equals("3"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_PRODUCT");
    if (paramString2.equals("5"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_AND_JOB");
    if (paramString2.equals("6"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_SHOW");
    if (paramString2.equals("11"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_RESUME");
    if (paramString2.equals("12"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_ENQUIRY");
    if (paramString2.equals("15"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_BOOK");
    return localArrayList;
  }

  public ArrayList getInfoListByContmodByLimit(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    String str = "0";
    if (paramString2.equals("1"))
      str = "0";
    else if (paramString2.equals("7"))
      str = "1";
    else if (str.equals("16"))
      str = "2";
    else if (str.equals("17"))
      str = "3";
    localInfoListExt.setParam(":VICH_ID", paramString1);
    localInfoListExt.setParam(":VSALE_TYPE", str);
    if (paramString2.equals("0"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_NEWS", paramInt1, paramInt2);
    if ((paramString2.equals("1")) || (paramString2.equals("7")) || (paramString2.equals("16")) || (paramString2.equals("17")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_SUPPLY", paramInt1, paramInt2);
    if (paramString2.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_STOCK", paramInt1, paramInt2);
    if (paramString2.equals("3"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_PRODUCT", paramInt1, paramInt2);
    if (paramString2.equals("5"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_AND_JOB", paramInt1, paramInt2);
    if (paramString2.equals("6"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_SHOW", paramInt1, paramInt2);
    if (paramString2.equals("11"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_RESUME", paramInt1, paramInt2);
    if (paramString2.equals("12"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_ENQUIRY", paramInt1, paramInt2);
    if (paramString2.equals("15"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_BOOK", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getInfoListByContmod(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VICH_ID", paramString1);
    localInfoListExt.setParam(":VCUST_ID", paramString3);
    if (paramString2.equals("0"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_AND_CUST_INDATE_COMDEL_NEWS");
    if (paramString2.equals("1"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_AND_CUST_INDATE_COMDEL_SUPPLY");
    if (paramString2.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_AND_CUST_INDATE_COMDEL_STOCK");
    if (paramString2.equals("3"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_AND_CUST_INDATE_COMDEL_PRODUCT");
    if (paramString2.equals("4"))
      localArrayList = localInfoListExt.selByList("SEL_ENTERPRISEINFOLIST_BY_CH_ID_AND_CUST_ID");
    if (paramString2.equals("5"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_AND_CUST_INDATE_COMDEL_AND_JOB");
    if (paramString2.equals("6"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_AND_CUST_INDATE_COMDEL_AND_CREDIT");
    if (paramString2.equals("7"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_AND_CUST_INDATE_COMDEL_AND_REPOSITORY");
    return localArrayList;
  }

  public ArrayList getInfoListByInfoIdContMod(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramString1);
    localInfoListExt.setParam(":VCUST_ID", paramString3);
    if (paramString2.equals("0"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_CUSTID_INDATE_COMDEL_NEWS");
    if (paramString2.equals("1"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_CUSTID_INDATE_COMDEL_SUPPLY");
    if (paramString2.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_CUSTID_INDATE_COMDEL_STOCK");
    if (paramString2.equals("3"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_CUSTID_INDATE_COMDEL_PRODUCT");
    if (paramString2.equals("4"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_CUSTID_INDATE_COMDEL_ENTERPRISE");
    if (paramString2.equals("5"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_CUSTID_INDATE_COMDEL_JOB");
    if (paramString2.equals("6"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_CUSTID_INDATE_COMDEL_CREDIT");
    if (paramString2.equals("7"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_CUSTID_INDATE_COMDEL_REPOSITORY");
    return localArrayList;
  }

  public ArrayList getInfoListByInfoIdContMod(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramString1);
    if (paramString2.equals("0"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_NEWS");
    if (paramString2.equals("1"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_SUPPLY");
    if (paramString2.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_STOCK");
    if (paramString2.equals("3"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_PRODUCT");
    if (paramString2.equals("5"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_AND_JOB");
    if (paramString2.equals("6"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_SHOW");
    if (paramString2.equals("7"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_TWOHAND");
    if (paramString2.equals("11"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_RESUME");
    if (paramString2.equals("12"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_ENQUIRY");
    if (paramString2.equals("15"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_INFOID_INDATE_COMDEL_BOOK");
    return localArrayList;
  }

  public ArrayList getInfoListByAllNews(int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localArrayList = localInfoListExt.selByList("SEL_INFO_BY_ALL_NEWS", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getCustInfoListByAllNews(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VCUST_ID", paramString);
    localArrayList = localInfoListExt.selByList("SEL_CUST_INFO_BY_ALL_NEWS", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getCustInfoListByIndex(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    if (paramString1.equals("product"))
    {
      localInfoListExt.setParam(":VCUST_ID", paramString2);
      localArrayList = localInfoListExt.selByList("SEL_CUST_INFO_BY_PRODUCT", paramInt1, paramInt2);
    }
    return localArrayList;
  }

  public int getInfoListCount(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VICH_ID", paramString);
    localArrayList = localInfoListExt.selByList("SEL_BY_CHID_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public ArrayList getChannelStringByInfoId(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramString);
    localArrayList = localInfoListExt.selByList("SEL_CHANNEL_STRING_BY_INFO_ID");
    return localArrayList;
  }

  public String getChannelCh_idByInfo(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramString);
    localArrayList = localInfoListExt.selByList("SEL_CH_ID_BY_INFO_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ch_id") != null)
        str = localHashMap.get("ch_id").toString();
    }
    return str;
  }

  public String getChannelSaveDirByInfoId(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramString);
    localArrayList = localInfoListExt.selByList("SEL_CH_ID_SAVE_DIR_BY_INFOID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("save_dir") != null)
        str = localHashMap.get("save_dir").toString();
    }
    return str;
  }

  public void DelInfoList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DelInfoList方法...");
    this.outBuffer = paramBuffers;
    InfoListDAO localInfoListDAO = new InfoListDAO();
    localInfoListDAO.setInfo_id(paramBuffers.getString("INFO_ID"));
    int i = -1;
    try
    {
      i = DelInfoList(localInfoListDAO);
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
    this.log.LOG_INFO("退出DelInfoList方法...");
  }

  public int DelInfoList(InfoListDAO paramInfoListDAO)
    throws SaasApplicationException
  {
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramInfoListDAO.getInfo_id());
    this.tradeQuery.executeBy(localInfoListExt.insBy("DEL_INFO_BY_IT"));
    return 0;
  }

  public ArrayList getInfoListByIndate(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    String str = "0";
    if (paramString4.equals("supply"))
      str = "0";
    else if (paramString4.equals("twohand"))
      str = "1";
    else if (paramString4.equals("daili"))
      str = "2";
    else if (paramString4.equals("hezuo"))
      str = "3";
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VICH_ID", paramString1);
    localInfoListExt.setParam(":VSALE_TYPE", str);
    localInfoListExt.setParam(":VCUST_ID", paramString2);
    localInfoListExt.setParam(":VKEYWORD", "%" + paramString3 + "%");
    localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_BY_INDATE", paramInt1, paramInt2);
    if (!paramString5.equals(""))
    {
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_BY_INDATE_RECOMMEND", paramInt1, paramInt2);
      if (paramString4.equals("show"))
        localArrayList = localInfoListExt.selByList("SEL_INFO_BY_SHOW_BY_INDATE_RECOMMEND", paramInt1, paramInt2);
      if (paramString4.equals("resume"))
        localArrayList = localInfoListExt.selByList("SEL_INFO_BY_COMDEL_RESUME_RECOMMEND", paramInt1, paramInt2);
      if ((paramString4.equals("supply")) || (paramString4.equals("twohand")) || (paramString4.equals("daili")) || (paramString4.equals("hezuo")))
        localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_SUPPLY_RECOMMEND", paramInt1, paramInt2);
      if (paramString4.equals("stock"))
        localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_STOCK_RECOMMEND", paramInt1, paramInt2);
      if (paramString4.equals("product"))
        localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_PRODUCT_RECOMMEND", paramInt1, paramInt2);
    }
    if ((!paramString2.equals("")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_CUST", paramInt1, paramInt2);
    if ((!paramString2.equals("")) && (paramString4.equals("news")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_NEWS", paramInt1, paramInt2);
    if ((!paramString2.equals("")) && (paramString4.equals("product")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_PRODUCT", paramInt1, paramInt2);
    if ((!paramString2.equals("")) && (paramString4.equals("supply")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_SUPPLY", paramInt1, paramInt2);
    if ((!paramString2.equals("")) && (paramString4.equals("credit")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_AND_CREDIT", paramInt1, paramInt2);
    if ((!paramString2.equals("")) && (paramString4.equals("stock")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_STOCK", paramInt1, paramInt2);
    if ((!paramString2.equals("")) && (paramString4.equals("custjob")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_JOB", paramInt1, paramInt2);
    if ((!paramString2.equals("")) && (paramString4.equals("knowledges")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_KNOWLEDGE", paramInt1, paramInt2);
    if ((!paramString2.equals("")) && (!paramString3.equals("")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_CUST_KEYWORD", paramInt1, paramInt2);
    if ((!paramString3.equals("")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_KEYWORD", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("news")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_NEWS", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("product")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_PRODUCT", paramInt1, paramInt2);
    if ((paramString4.equals("supply")) || (paramString4.equals("twohand")) || (paramString4.equals("daili")) || (paramString4.equals("hezuo")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_SUPPLY", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("stock")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_STOCK", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("resume")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_RESUME", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("job")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_JOB", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("knowledge")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_KNOWLEDGE", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("show")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_SHOW", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("book")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_BOOK", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("enterprise")) && (paramString5.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_ENTERPRISE", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getInfoListCountByChId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    String str = "0";
    if (paramString2.equals("1"))
      str = "0";
    else if (paramString2.equals("7"))
      str = "1";
    else if (paramString2.equals("16"))
      str = "2";
    else if (paramString2.equals("17"))
      str = "3";
    localInfoListExt.setParam(":VICH_ID", paramString1);
    localInfoListExt.setParam(":VSALE_TYPE", str);
    if ((paramString2.equals("1")) || (paramString2.equals("7")) || (paramString2.equals("16")) || (paramString2.equals("17")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_SUPPLY");
    else if (paramString2.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_STOCK");
    else if (paramString2.equals("6"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_INDATE_COMDEL_SHOW");
    else
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public int getCustInfoListCountByChId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VCUST_ID", paramString1);
    localInfoListExt.setParam(":VICH_ID", paramString2);
    if (paramString3.equals("0"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_NEWS");
    else if (paramString3.equals("1"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_PRODUCT");
    else if (paramString3.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_STOCK");
    else if (paramString3.equals("3"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_PRODUCT");
    else if (paramString3.equals("5"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_JOB");
    else if (paramString3.equals("6"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_AND_CREDIT");
    else if (paramString3.equals("7"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CUST_ID_CHID_INDATE_COMDEL_KNOWLEDGE");
    else
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getInfoListByHot(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VICH_ID", paramString1);
    localInfoListExt.setParam(":VCUST_ID", paramString2);
    localInfoListExt.setParam(":VKEYWORD", "%" + paramString3 + "%");
    localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_BY_HOT", paramInt1, paramInt2);
    if (!paramString5.equals(""))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_BY_HOT_RECOMMEND", paramInt1, paramInt2);
    if (!paramString2.equals(""))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_CUST", paramInt1, paramInt2);
    if ((!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_CUST_KEYWORD", paramInt1, paramInt2);
    if (!paramString3.equals(""))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_KEYWORD", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("news")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_COMDEL_NEWS", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("product")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_COMDEL_PRODUCT", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("supply")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_COMDEL_SUPPLY", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("stock")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_COMDEL_STOCK", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("resume")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_COMDEL_RESUME", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("job")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_COMDEL_JOB", paramInt1, paramInt2);
    if ((!paramString4.equals("")) && (paramString4.equals("knowledge")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_HOT_COMDEL_KNOWLEDGE", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getInfoListByPublevel(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VICH_ID", paramString1);
    localInfoListExt.setParam(":VKEYWORD", "%" + paramString2 + "%");
    localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_BY_PUBLEVEL", paramInt1, paramInt2);
    if (!paramString4.equals(""))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_BY_PUBLEVEL_RECOMMEND", paramInt1, paramInt2);
    if (!paramString2.equals(""))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_PUBLEVEL_KEYWORD", paramInt1, paramInt2);
    if ((!paramString3.equals("")) && (paramString3.equals("news")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_PUBLEVEL_COMDEL_NEWS", paramInt1, paramInt2);
    if ((!paramString3.equals("")) && (paramString3.equals("product")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_PUBLEVEL_COMDEL_PRODUCT", paramInt1, paramInt2);
    if ((!paramString3.equals("")) && (paramString3.equals("supply")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_PUBLEVEL_COMDEL_SUPPLY", paramInt1, paramInt2);
    if ((!paramString3.equals("")) && (paramString3.equals("stock")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_PUBLEVEL_COMDEL_STOCK", paramInt1, paramInt2);
    if ((!paramString3.equals("")) && (paramString3.equals("resume")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_PUBLEVEL_COMDEL_RESUME", paramInt1, paramInt2);
    if ((!paramString3.equals("")) && (paramString3.equals("job")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_PUBLEVEL_COMDEL_JOB", paramInt1, paramInt2);
    if ((!paramString3.equals("")) && (paramString3.equals("knowledge")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_PUBLEVEL_COMDEL_KNOWLEDGE", paramInt1, paramInt2);
    if ((!paramString3.equals("")) && (paramString3.equals("twohand")))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CHID_PUBLEVEL_COMDEL_TWOHAND", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getInfoListByClasstype(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    if (paramString.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CLASS_TYPE", paramInt1, paramInt2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public String getInfoNumByClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VCLASS_ID", paramString1);
    if (paramString2.equals("1"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CLASS_SUPPLY");
    if (paramString2.equals("2"))
      localArrayList = localInfoListExt.selByList("SEL_INFO_BY_CLASS_STOCK");
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("class_count") != null)
        str = localHashMap.get("class_count").toString();
    }
    return str;
  }

  public ArrayList getInfoListMarqueen(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VICH_ID", paramString);
    localArrayList1 = localInfoListExt.selByList("SEL_INFO_BY_CHID_MARQUEEN");
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    if (localArrayList1 != null)
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList1.get(i);
        if (localHashMap.get("title") != null)
        {
          str1 = localHashMap.get("title").toString();
          if (str1.length() > 4)
            str1 = str1.substring(0, 4);
        }
        if (localHashMap.get("in_date") != null)
        {
          str2 = localHashMap.get("in_date").toString();
          if (str2.length() > 10)
            str2 = str2.substring(5, 5);
        }
        if (localHashMap.get("cust_id") != null)
          str3 = localHashMap.get("cust_id").toString();
        if (localHashMap.get("cust_name") != null)
          str4 = localHashMap.get("cust_name").toString();
        if (localHashMap.get("info_id") != null)
          str5 = localHashMap.get("info_id").toString();
        if (localHashMap.get("save_dir") != null)
          str6 = localHashMap.get("save_dir").toString();
        str7 = "<a href=/" + str6 + "/d/content-" + str5 + ".html >" + str1 + "</a>&nbsp;" + str2 + "&nbsp;<a href=/inc/include/InterimPages.jsp?cust_id=" + str3 + ">" + str4 + "</a>";
        localArrayList2.add(str7);
      }
    return localArrayList2;
  }

  public ArrayList getInfoListMarqueenByStockSupply()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localArrayList1 = localInfoListExt.selByList("SEL_INFO_BY_CHID_MARQUEEN_BY_SS");
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    if (localArrayList1 != null)
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList1.get(i);
        if (localHashMap.get("title") != null)
        {
          str1 = localHashMap.get("title").toString();
          if (str1.length() > 4)
            str1 = str1.substring(0, 4);
        }
        if (localHashMap.get("in_date") != null)
        {
          str2 = localHashMap.get("in_date").toString();
          if (str2.length() > 10)
            str2 = str2.substring(5, 5);
        }
        if (localHashMap.get("cust_id") != null)
          str3 = localHashMap.get("cust_id").toString();
        if (localHashMap.get("cust_name") != null)
          str4 = localHashMap.get("cust_name").toString();
        if (localHashMap.get("info_id") != null)
          str5 = localHashMap.get("info_id").toString();
        if (localHashMap.get("save_dir") != null)
          str6 = localHashMap.get("save_dir").toString();
        if (str6.equals("default/supply"))
          str7 = "[供应]<a href=/" + str6 + "/d/content-" + str5 + ".html >" + str1 + "</a>&nbsp;" + str2 + "&nbsp;<a href=/inc/include/InterimPages.jsp?cust_id=" + str3 + ">" + str4 + "</a>";
        else
          str7 = "[求购]<a href=/" + str6 + "/d/content-" + str5 + ".html >" + str1 + "</a>&nbsp;" + str2 + "&nbsp;<a href=/inc/include/InterimPages.jsp?cust_id=" + str3 + ">" + str4 + "</a>";
        localArrayList2.add(str7);
      }
    return localArrayList2;
  }

  public void DeleteInfolist(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteInfolist方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("INFO_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = DelInfoList2(str2);
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
    this.log.LOG_INFO("退出DeleteInfolist方法...");
  }

  public int DelInfoList2(String paramString)
    throws SaasApplicationException
  {
    InfoListExt localInfoListExt = new InfoListExt();
    localInfoListExt.setParam(":VINFO_ID", paramString);
    this.tradeQuery.executeBy(localInfoListExt.insBy("DEL_INFO_BY_IT"));
    return 0;
  }

  public ArrayList getInfoListMarqueenByGG()
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    InfoListExt localInfoListExt = new InfoListExt();
    localArrayList1 = localInfoListExt.selByList("SEL_INFO_BY_CHID_MARQUEEN_BY_GGAO");
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    if (localArrayList1 != null)
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList1.get(i);
        if (localHashMap.get("title") != null)
        {
          str1 = localHashMap.get("title").toString();
          if (str1.length() > 15)
            str1 = str1.substring(0, 15);
        }
        if (localHashMap.get("info_id") != null)
          str3 = localHashMap.get("info_id").toString();
        if (localHashMap.get("save_dir") != null)
          str4 = localHashMap.get("save_dir").toString();
        str5 = "<a href=/" + str4 + "/d/content-" + str3 + ".html >" + str1;
        localArrayList2.add(str5);
      }
    return localArrayList2;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.infoListMgr.InfoList
 * JD-Core Version:    0.6.0
 */