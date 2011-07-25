package com.saas.biz.channelColumnMgr;

import com.buildhtml.Config;
import com.saas.biz.commen.FileOperate;
import com.saas.biz.commen.ParamethodMgr;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.channelColumnDAO.ChannelColumnDAO;
import com.saas.biz.dao.channelColumnDAO.ChannelColumnExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import tools.util.FileIO;

public class ChannelColumnInfo
{
  Logger log = new Logger(this);
  Buffers inBuffer;
  Config config = new Config();
  Buffers outBuffer = new Buffers();
  private String ecms_path = this.config.ecms_path;
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

  public void addChannel(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addChannel方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("CH_ID");
    String str3 = paramBuffers.getString("CH_NAME");
    String str4 = paramBuffers.getString("UP_CH_ID");
    String str5 = paramBuffers.getString("CH_LEVEL");
    String str6 = paramBuffers.getString("STATE_CODE");
    String str7 = paramBuffers.getString("STATE_CODE_DATE");
    String str8 = paramBuffers.getString("SHOW_NO");
    String str9 = paramBuffers.getString("RIGHT_TAG");
    String str10 = paramBuffers.getString("SAVE_DIR");
    String str11 = paramBuffers.getString("DIR_POS");
    String str12 = paramBuffers.getString("CONT_MOD");
    String str13 = paramBuffers.getString("DEFAULT_PAGE");
    String str14 = paramBuffers.getString("CH_ATTR");
    String str15 = paramBuffers.getString("INDEX_TEMP");
    String str16 = paramBuffers.getString("LIST_TEMP");
    String str17 = paramBuffers.getString("ARTICLE_TEMP");
    String str18 = paramBuffers.getString("CH_IMG");
    String str19 = paramBuffers.getString("LIST_TYPE");
    String str20 = paramBuffers.getString("CH_KEY");
    String str21 = paramBuffers.getString("CH_DESC");
    String str22 = paramBuffers.getString("INDEX_VIEW");
    String str23 = paramBuffers.getString("IN_DATE");
    String str24 = paramBuffers.getString("REMARK");
    try
    {
      ChannelColumnDAO localChannelColumnDAO = new ChannelColumnDAO();
      localChannelColumnDAO.setCust_id(str1);
      localChannelColumnDAO.setCh_id(str2);
      localChannelColumnDAO.setCh_name(str3);
      localChannelColumnDAO.setUp_ch_id(str4);
      localChannelColumnDAO.setCh_level(str5);
      localChannelColumnDAO.setState_code(str6);
      localChannelColumnDAO.setState_code_date(str7);
      localChannelColumnDAO.setShow_no(str8);
      localChannelColumnDAO.setRight_tag(str9);
      localChannelColumnDAO.setSave_dir(str10);
      localChannelColumnDAO.setDir_pos(str11);
      localChannelColumnDAO.setCont_mod(str12);
      localChannelColumnDAO.setDefault_page(str13);
      localChannelColumnDAO.setCh_attr(str14);
      localChannelColumnDAO.setIndex_temp(str15);
      localChannelColumnDAO.setList_temp(str16);
      localChannelColumnDAO.setArticle_temp(str17);
      localChannelColumnDAO.setCh_img(str18);
      localChannelColumnDAO.setList_type(str19);
      localChannelColumnDAO.setCh_key(str20);
      localChannelColumnDAO.setCh_desc(str21);
      localChannelColumnDAO.setIndex_view(str22);
      localChannelColumnDAO.setIn_date(str23);
      localChannelColumnDAO.setRemark(str24);
      i = addChannel(localChannelColumnDAO);
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
    this.log.LOG_INFO("退出addChannel方法...");
  }

  public int addChannel(ChannelColumnDAO paramChannelColumnDAO)
    throws SaasApplicationException
  {
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramChannelColumnDAO.getCust_id());
    localChannelColumnExt.setParam(":VCH_ID", paramChannelColumnDAO.getCh_id());
    localChannelColumnExt.setParam(":VCH_NAME", paramChannelColumnDAO.getCh_name());
    localChannelColumnExt.setParam(":VUP_CH_ID", paramChannelColumnDAO.getUp_ch_id());
    localChannelColumnExt.setParam(":VCH_LEVEL", paramChannelColumnDAO.getCh_level());
    localChannelColumnExt.setParam(":VSTATE_CODE", paramChannelColumnDAO.getState_code());
    localChannelColumnExt.setParam(":VSTATE_CODE_DATE", paramChannelColumnDAO.getState_code_date());
    localChannelColumnExt.setParam(":VSHOW_NO", paramChannelColumnDAO.getShow_no());
    localChannelColumnExt.setParam(":VRIGHT_TAG", paramChannelColumnDAO.getRight_tag());
    localChannelColumnExt.setParam(":VSAVE_DIR", paramChannelColumnDAO.getSave_dir());
    localChannelColumnExt.setParam(":VDIR_POS", paramChannelColumnDAO.getDir_pos());
    localChannelColumnExt.setParam(":VCONT_MOD", paramChannelColumnDAO.getCont_mod());
    localChannelColumnExt.setParam(":VDEFAULT_PAGE", paramChannelColumnDAO.getDefault_page());
    localChannelColumnExt.setParam(":VCH_ATTR", paramChannelColumnDAO.getCh_attr());
    localChannelColumnExt.setParam(":VINDEX_TEMP", paramChannelColumnDAO.getIndex_temp());
    localChannelColumnExt.setParam(":VLIST_TEMP", paramChannelColumnDAO.getList_temp());
    localChannelColumnExt.setParam(":VARTICLE_TEMP", paramChannelColumnDAO.getArticle_temp());
    localChannelColumnExt.setParam(":VCH_IMG", paramChannelColumnDAO.getCh_img());
    localChannelColumnExt.setParam(":VLIST_TYPE", paramChannelColumnDAO.getList_type());
    localChannelColumnExt.setParam(":VCH_KEY", paramChannelColumnDAO.getCh_key());
    localChannelColumnExt.setParam(":VCH_DESC", paramChannelColumnDAO.getCh_desc());
    localChannelColumnExt.setParam(":VINDEX_VIEW", paramChannelColumnDAO.getIndex_view());
    localChannelColumnExt.setParam(":VIN_DATE", paramChannelColumnDAO.getIn_date());
    localChannelColumnExt.setParam(":VREMARK", paramChannelColumnDAO.getRemark());
    this.tradeQuery.executeBy(localChannelColumnExt.insBy("INS_BY_CHANNEL"));
    return 0;
  }

  public void modifyChannel(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入modifyChannel方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CH_ID");
    String str2 = paramBuffers.getString("CH_NAME");
    String str3 = paramBuffers.getString("UP_CH_ID");
    String str4 = paramBuffers.getString("CH_LEVEL");
    String str5 = paramBuffers.getString("STATE_CODE");
    String str6 = paramBuffers.getString("STATE_CODE_DATE");
    String str7 = paramBuffers.getString("SHOW_NO");
    String str8 = paramBuffers.getString("RIGHT_TAG");
    String str9 = paramBuffers.getString("SAVE_DIR");
    String str10 = paramBuffers.getString("DIR_POS");
    String str11 = paramBuffers.getString("CONT_MOD");
    String str12 = paramBuffers.getString("DEFAULT_PAGE");
    String str13 = paramBuffers.getString("CH_ATTR");
    String str14 = paramBuffers.getString("INDEX_TEMP");
    String str15 = paramBuffers.getString("LIST_TEMP");
    String str16 = paramBuffers.getString("ARTICLE_TEMP");
    String str17 = paramBuffers.getString("CH_IMG");
    String str18 = paramBuffers.getString("LIST_TYPE");
    String str19 = paramBuffers.getString("CH_KEY");
    String str20 = paramBuffers.getString("CH_DESC");
    String str21 = paramBuffers.getString("INDEX_VIEW");
    String str22 = paramBuffers.getString("IN_DATE");
    String str23 = paramBuffers.getString("REMARK");
    try
    {
      ChannelColumnDAO localChannelColumnDAO = new ChannelColumnDAO();
      localChannelColumnDAO.setCh_id(str1);
      localChannelColumnDAO.setCh_name(str2);
      localChannelColumnDAO.setUp_ch_id(str3);
      localChannelColumnDAO.setCh_level(str4);
      localChannelColumnDAO.setState_code(str5);
      localChannelColumnDAO.setState_code_date(str6);
      localChannelColumnDAO.setShow_no(str7);
      localChannelColumnDAO.setRight_tag(str8);
      localChannelColumnDAO.setSave_dir(str9);
      localChannelColumnDAO.setDir_pos(str10);
      localChannelColumnDAO.setCont_mod(str11);
      localChannelColumnDAO.setDefault_page(str12);
      localChannelColumnDAO.setCh_attr(str13);
      localChannelColumnDAO.setIndex_temp(str14);
      localChannelColumnDAO.setList_temp(str15);
      localChannelColumnDAO.setArticle_temp(str16);
      localChannelColumnDAO.setCh_img(str17);
      localChannelColumnDAO.setList_type(str18);
      localChannelColumnDAO.setCh_key(str19);
      localChannelColumnDAO.setCh_desc(str20);
      localChannelColumnDAO.setIndex_view(str21);
      localChannelColumnDAO.setIn_date(str22);
      localChannelColumnDAO.setRemark(str23);
      i = modifyChannel(localChannelColumnDAO);
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
    this.log.LOG_INFO("退出addChannel方法...");
  }

  public int modifyChannel(ChannelColumnDAO paramChannelColumnDAO)
    throws SaasApplicationException
  {
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCH_ID", paramChannelColumnDAO.getCh_id());
    localChannelColumnExt.setParam(":VCH_NAME", paramChannelColumnDAO.getCh_name());
    localChannelColumnExt.setParam(":VUP_CH_ID", paramChannelColumnDAO.getUp_ch_id());
    localChannelColumnExt.setParam(":VCH_LEVEL", paramChannelColumnDAO.getCh_level());
    localChannelColumnExt.setParam(":VSTATE_CODE", paramChannelColumnDAO.getState_code());
    localChannelColumnExt.setParam(":VSTATE_CODE_DATE", paramChannelColumnDAO.getState_code_date());
    localChannelColumnExt.setParam(":VSHOW_NO", paramChannelColumnDAO.getShow_no());
    localChannelColumnExt.setParam(":VRIGHT_TAG", paramChannelColumnDAO.getRight_tag());
    localChannelColumnExt.setParam(":VSAVE_DIR", paramChannelColumnDAO.getSave_dir());
    localChannelColumnExt.setParam(":VDIR_POS", paramChannelColumnDAO.getDir_pos());
    localChannelColumnExt.setParam(":VCONT_MOD", paramChannelColumnDAO.getCont_mod());
    localChannelColumnExt.setParam(":VDEFAULT_PAGE", paramChannelColumnDAO.getDefault_page());
    localChannelColumnExt.setParam(":VCH_ATTR", paramChannelColumnDAO.getCh_attr());
    localChannelColumnExt.setParam(":VINDEX_TEMP", paramChannelColumnDAO.getIndex_temp());
    localChannelColumnExt.setParam(":VLIST_TEMP", paramChannelColumnDAO.getList_temp());
    localChannelColumnExt.setParam(":VARTICLE_TEMP", paramChannelColumnDAO.getArticle_temp());
    localChannelColumnExt.setParam(":VCH_IMG", paramChannelColumnDAO.getCh_img());
    localChannelColumnExt.setParam(":VLIST_TYPE", paramChannelColumnDAO.getList_type());
    localChannelColumnExt.setParam(":VCH_KEY", paramChannelColumnDAO.getCh_key());
    localChannelColumnExt.setParam(":VCH_DESC", paramChannelColumnDAO.getCh_desc());
    localChannelColumnExt.setParam(":VINDEX_VIEW", paramChannelColumnDAO.getIndex_view());
    localChannelColumnExt.setParam(":VIN_DATE", paramChannelColumnDAO.getIn_date());
    localChannelColumnExt.setParam(":VREMARK", paramChannelColumnDAO.getRemark());
    this.tradeQuery.executeBy(localChannelColumnExt.insBy("UP_BY_CHANNEL"));
    return 0;
  }

  public void DelChannel(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DelChannel方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("CH_ID");
    try
    {
      ChannelColumnDAO localChannelColumnDAO = new ChannelColumnDAO();
      localChannelColumnDAO.setCh_id(str);
      i = DelChannel(localChannelColumnDAO);
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
    this.log.LOG_INFO("退出DelChannel方法...");
  }

  public int DelChannel(ChannelColumnDAO paramChannelColumnDAO)
    throws SaasApplicationException
  {
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCH_ID", paramChannelColumnDAO.getCh_id());
    this.tradeQuery.executeBy(localChannelColumnExt.insBy("DEL_BY_CHANNEL"));
    return 0;
  }

  public ArrayList getChannelInfos(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString2);
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString1);
    localArrayList = localChannelColumnExt.selByList("SEL_CHANNEL_LIST", paramInt, 30);
    return localArrayList;
  }

  public int getChannelcount(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString2);
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString1);
    localArrayList = localChannelColumnExt.selByList("SEL_CHANNEL_LIST");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getChannelList()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localArrayList = localChannelColumnExt.selByList("SEL_CHANNEL_INFO");
    return localArrayList;
  }

  public int getChannelInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localArrayList = localChannelColumnExt.selByList("SEL_CHANNEL_INFO");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getChannel(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCH_ID", paramString1);
    localChannelColumnExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localChannelColumnExt.selByList("SEL_CHANNEL_BY_CHANNEL_ID");
    return localArrayList;
  }

  public ArrayList getChannelBySaveDir(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VSAVE_DIR", paramString);
    localArrayList = localChannelColumnExt.selByList("SEL_CHANNEL_BY_SAVE_DIR");
    return localArrayList;
  }

  public ArrayList getSaveDirByChLevelAndContMod(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCH_LEVEL", paramString1);
    localChannelColumnExt.setParam(":VCONT_MOD", paramString2);
    localArrayList = localChannelColumnExt.selByList("SEL_SAVE_DIR_BY_CHLEVEL_CONTMOD");
    return localArrayList;
  }

  public ArrayList getChInfoSelf(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCH_ID", paramString1);
    localChannelColumnExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localChannelColumnExt.selByList("SEL_CHANNEL_BY_CH_ID", paramInt1, paramInt2);
    if (paramString3.equals("in_date"))
      localArrayList = localChannelColumnExt.selByList("SEL_CHSELF_BY_DATE", paramInt1, paramInt2);
    else if (paramString3.equals("show_no"))
      localArrayList = localChannelColumnExt.selByList("SEL_CHSELF_BY_NO", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getChInfoSon(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString1);
    localChannelColumnExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localChannelColumnExt.selByList("SEL_CHSESON_BY_DATE", paramInt1, paramInt2);
    if (paramString3.equals("in_date"))
      localArrayList = localChannelColumnExt.selByList("SEL_CHSESON_BY_DATE", paramInt1, paramInt2);
    else if (paramString3.equals("show_no"))
      localArrayList = localChannelColumnExt.selByList("SEL_CHSESON_BY_NO", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getChInfoNext(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCH_ID", paramString1);
    if (paramString2.equals("in_date"))
      localArrayList = localChannelColumnExt.selByList("SEL_CH_ALL_BY_DATE", 0, paramInt);
    else if (paramString2.equals("show_no"))
      localArrayList = localChannelColumnExt.selByList("SEL_CH_ALL_BY_SHOW", 0, paramInt);
    return localArrayList;
  }

  public String getChIdByCustIdContMod(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString1);
    localChannelColumnExt.setParam(":VCONT_MOD", paramString2);
    localArrayList = localChannelColumnExt.selByList("SEL_CHID_BY_CUSTID_CONTMOD");
    String str = "";
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ch_id") != null)
        str = localHashMap.get("ch_id").toString();
    }
    return str;
  }

  public int getBooChSon(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString2);
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString1);
    localArrayList = localChannelColumnExt.selByList("SEL_CH_SON");
    if (localArrayList != null)
      return 1;
    return 0;
  }

  public ArrayList getChSonList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString);
    localArrayList = localChannelColumnExt.selByList("SEL_CH_SON", 0, 30);
    return localArrayList;
  }

  public int getChSonList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString);
    localArrayList = localChannelColumnExt.selByList("SEL_CH_SON");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public String getChName(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCH_ID", paramString);
    localArrayList = localChannelColumnExt.selByList("SEL_CH_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ch_name") != null)
        str = localHashMap.get("ch_name").toString();
    }
    return str;
  }

  public String getUpFilePath(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCH_ID", paramString);
    ArrayList localArrayList = localChannelColumnExt.selByList("SEL_SAVE_DIR");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("save_dir") != null)
        str = localHashMap.get("save_dir").toString();
    }
    return str;
  }

  public String getUpChannelLevel(String paramString)
    throws SaasApplicationException
  {
    String str = "1";
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString);
    ArrayList localArrayList = localChannelColumnExt.selByList("SEL_CH_LEVEL");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ch_level") != null)
        str = localHashMap.get("ch_level").toString();
    }
    return str;
  }

  public String getSelfChannelLevel(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCH_ID", paramString);
    ArrayList localArrayList = localChannelColumnExt.selByList("SEL_CHANNEL_BY_CH_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ch_level") != null)
        str = localHashMap.get("ch_level").toString();
    }
    return str;
  }

  public ArrayList getChSon(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString2);
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString1);
    localArrayList = localChannelColumnExt.selByList("SEL_CH_SON");
    return localArrayList;
  }

  public ArrayList getChSon(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt1 *= paramInt2;
    ArrayList localArrayList = new ArrayList();
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString2);
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString1);
    localArrayList = localChannelColumnExt.selByList("SEL_CH_SON", paramInt1, paramInt2);
    return localArrayList;
  }

  public String getChannelItems(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "";
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString2);
    localChannelColumnExt.setParam(":VUP_CH_ID", paramString1);
    ArrayList localArrayList = localChannelColumnExt.selByList("SEL_CH_SON");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (localHashMap.get("cust_id") != null)
          str2 = localHashMap.get("cust_id").toString();
        if (localHashMap.get("ch_id") != null)
          str3 = localHashMap.get("ch_id").toString();
        if (localHashMap.get("ch_name") != null)
          str4 = localHashMap.get("ch_name").toString();
        if (localHashMap.get("ch_level") != null)
          str5 = localHashMap.get("ch_level").toString();
        String str6 = "";
        for (int j = 1; j < Integer.parseInt(str5); j++)
          str6 = str6 + "-";
        if (getBooChSon(str3, str2) == 0)
        {
          str1 = str1 + "<option value=" + str3 + ">" + str6 + str4 + "</option>";
        }
        else
        {
          str1 = str1 + "<option value=" + str3 + ">" + str6 + str4 + "</option>";
          str1 = str1 + getChannelItems(str3, str2);
        }
      }
    return str1;
  }

  public void addNation(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addNation方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    try
    {
      ChannelColumnDAO localChannelColumnDAO = new ChannelColumnDAO();
      localChannelColumnDAO.setCust_id(str1);
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      String str6 = "";
      ParamethodMgr localParamethodMgr = new ParamethodMgr();
      ArrayList localArrayList = localParamethodMgr.getCompareInfoByAttr("124");
      if ((localArrayList != null) && (localArrayList.size() > 0))
        for (int j = 0; j < localArrayList.size(); j++)
        {
          HashMap localHashMap = (HashMap)localArrayList.get(j);
          String str7 = "";
          if (localHashMap.get("para_code1") != null)
            str7 = localHashMap.get("para_code1").toString();
          if (localHashMap.get("para_code2") != null)
            str2 = localHashMap.get("para_code2").toString();
          if (localHashMap.get("para_code4") != null)
            str3 = localHashMap.get("para_code4").toString();
          if (localHashMap.get("para_code5") != null)
            str4 = localHashMap.get("para_code5").toString();
          if (localHashMap.get("para_code6") != null)
            str5 = localHashMap.get("para_code6").toString();
          if (localHashMap.get("para_code7") != null)
            str6 = localHashMap.get("para_code7").toString();
          String str8 = localcommMethodMgr.GenNumTradeId();
          i = addNation(str1, str8, str2, str7, str4, str5, str6, str3);
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
    this.log.LOG_INFO("退出addNation方法...");
  }

  public int addNation(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws SaasApplicationException
  {
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString1);
    localChannelColumnExt.setParam(":VCH_ID", paramString2);
    localChannelColumnExt.setParam(":VCH_NAME", paramString3);
    localChannelColumnExt.setParam(":VUP_CH_ID", "0000000000");
    localChannelColumnExt.setParam(":VCH_LEVEL", "1");
    localChannelColumnExt.setParam(":VSTATE_CODE", Integer.valueOf(0));
    localChannelColumnExt.setParam(":VSTATE_CODE_DATE", "");
    localChannelColumnExt.setParam(":VSHOW_NO", paramString4);
    localChannelColumnExt.setParam(":VRIGHT_TAG", Integer.valueOf(0));
    localChannelColumnExt.setParam(":VSAVE_DIR", "company/web/" + paramString1);
    localChannelColumnExt.setParam(":VDIR_POS", Integer.valueOf(0));
    localChannelColumnExt.setParam(":VCONT_MOD", paramString8);
    localChannelColumnExt.setParam(":VDEFAULT_PAGE", paramString5);
    localChannelColumnExt.setParam(":VCH_ATTR", Integer.valueOf(0));
    localChannelColumnExt.setParam(":VINDEX_TEMP", "company/enterprise/customer/" + paramString1 + "/default/" + paramString5);
    localChannelColumnExt.setParam(":VLIST_TEMP", "company/enterprise/customer/" + paramString1 + "/default/" + paramString6);
    localChannelColumnExt.setParam(":VARTICLE_TEMP", "company/enterprise/customer/" + paramString1 + "/default/" + paramString7);
    localChannelColumnExt.setParam(":VCH_IMG", "");
    localChannelColumnExt.setParam(":VLIST_TYPE", Integer.valueOf(0));
    localChannelColumnExt.setParam(":VCH_KEY", "");
    localChannelColumnExt.setParam(":VCH_DESC", "");
    localChannelColumnExt.setParam(":VINDEX_VIEW", Integer.valueOf(0));
    localChannelColumnExt.setParam(":VIN_DATE", "");
    localChannelColumnExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localChannelColumnExt.insBy("INS_BY_CHANNEL"));
    return 0;
  }

  public void UpdateNation(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入UpdateNation方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = "";
    String str2 = "";
    str1 = paramBuffers.getString("CUST_ID");
    str2 = paramBuffers.getString("MODE_NAME");
    FileOperate localFileOperate = new FileOperate();
    String str3 = "company/enterprise/customer/" + str1;
    String str4 = "company/enterprise/public/" + str2;
    String str5 = this.ecms_path + str4;
    String str6 = this.ecms_path + str3;
    if (FileIO.ExistFloder(str6))
      localFileOperate.delFolder(str6);
    if (!str2.equals(""))
    {
      localFileOperate.newFolder(str6);
      localFileOperate.copyFolder(str5, str6 + "/" + str2);
    }
    this.log.LOG_INFO("cust_id=" + str1 + "modename=" + str2);
    String str7 = "";
    String str8 = "";
    String str9 = "";
    try
    {
      ParamethodMgr localParamethodMgr = new ParamethodMgr();
      ArrayList localArrayList = localParamethodMgr.getCompareInfoByAttr("124");
      if ((localArrayList != null) && (localArrayList.size() > 0))
        for (int j = 0; j < localArrayList.size(); j++)
        {
          HashMap localHashMap = (HashMap)localArrayList.get(j);
          if (localHashMap.get("para_code5") != null)
            str7 = localHashMap.get("para_code5").toString();
          if (localHashMap.get("para_code6") != null)
            str8 = localHashMap.get("para_code6").toString();
          if (localHashMap.get("para_code7") != null)
            str9 = localHashMap.get("para_code7").toString();
          this.log.LOG_INFO("default_page=" + str7 + "list_page=" + str8 + "article_page=" + str9);
          i = UpdateNation(str1, str2, str7, str8, str9);
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
    this.log.LOG_INFO("退出UpdateNation方法...");
  }

  public int UpdateNation(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString1);
    localChannelColumnExt.setParam(":VDEFAULT_PAGE", paramString3);
    localChannelColumnExt.setParam(":VINDEX_TEMP", "company/enterprise/customer/" + paramString1 + "/" + paramString2 + "/" + paramString3);
    localChannelColumnExt.setParam(":VLIST_TEMP", "company/enterprise/customer/" + paramString1 + "/" + paramString2 + "/" + paramString4);
    localChannelColumnExt.setParam(":VARTICLE_TEMP", "company/enterprise/customer/" + paramString1 + "/" + paramString2 + "/" + paramString5);
    this.log.LOG_INFO("开始执行SQL:===:" + localChannelColumnExt.insBy("UPDATE_BY_CHANNEL"));
    this.tradeQuery.executeBy(localChannelColumnExt.insBy("UPDATE_BY_CHANNEL"));
    return 0;
  }

  public String getTemplateFolder(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ChannelColumnExt localChannelColumnExt = new ChannelColumnExt();
    localChannelColumnExt.setParam(":VCUST_ID", paramString);
    ArrayList localArrayList = localChannelColumnExt.selByList("SEL_CHANNEL_BY_CUST_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localObject = (HashMap)localArrayList.get(0);
      if (((HashMap)localObject).get("index_temp") != null)
        str = ((HashMap)localObject).get("index_temp").toString();
    }
    Object localObject = str.split("/");
    return (String)localObject[4];
  }

  public static void main(String[] paramArrayOfString)
  {
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.channelColumnMgr.ChannelColumnInfo
 * JD-Core Version:    0.6.0
 */