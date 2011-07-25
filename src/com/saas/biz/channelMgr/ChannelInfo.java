package com.saas.biz.channelMgr;

import com.saas.biz.dao.channelDAO.ChannelDAO;
import com.saas.biz.dao.channelDAO.ChannelExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class ChannelInfo
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

  public void addChannel(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addChannel方法...");
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
      ChannelDAO localChannelDAO = new ChannelDAO();
      localChannelDAO.setCh_id(str1);
      localChannelDAO.setCh_name(str2);
      localChannelDAO.setUp_ch_id(str3);
      localChannelDAO.setCh_level(str4);
      localChannelDAO.setState_code(str5);
      localChannelDAO.setState_code_date(str6);
      localChannelDAO.setShow_no(str7);
      localChannelDAO.setRight_tag(str8);
      localChannelDAO.setSave_dir(str9);
      localChannelDAO.setDir_pos(str10);
      localChannelDAO.setCont_mod(str11);
      localChannelDAO.setDefault_page(str12);
      localChannelDAO.setCh_attr(str13);
      localChannelDAO.setIndex_temp(str14);
      localChannelDAO.setList_temp(str15);
      localChannelDAO.setArticle_temp(str16);
      localChannelDAO.setCh_img(str17);
      localChannelDAO.setList_type(str18);
      localChannelDAO.setCh_key(str19);
      localChannelDAO.setCh_desc(str20);
      localChannelDAO.setIndex_view(str21);
      localChannelDAO.setIn_date(str22);
      localChannelDAO.setRemark(str23);
      i = addChannel(localChannelDAO);
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

  public int addChannel(ChannelDAO paramChannelDAO)
    throws SaasApplicationException
  {
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramChannelDAO.getCh_id());
    localChannelExt.setParam(":VCH_NAME", paramChannelDAO.getCh_name());
    localChannelExt.setParam(":VUP_CH_ID", paramChannelDAO.getUp_ch_id());
    localChannelExt.setParam(":VCH_LEVEL", paramChannelDAO.getCh_level());
    localChannelExt.setParam(":VSTATE_CODE", paramChannelDAO.getState_code());
    localChannelExt.setParam(":VSTATE_CODE_DATE", paramChannelDAO.getState_code_date());
    localChannelExt.setParam(":VSHOW_NO", paramChannelDAO.getShow_no());
    localChannelExt.setParam(":VRIGHT_TAG", paramChannelDAO.getRight_tag());
    localChannelExt.setParam(":VSAVE_DIR", paramChannelDAO.getSave_dir());
    localChannelExt.setParam(":VDIR_POS", paramChannelDAO.getDir_pos());
    localChannelExt.setParam(":VCONT_MOD", paramChannelDAO.getCont_mod());
    localChannelExt.setParam(":VDEFAULT_PAGE", paramChannelDAO.getDefault_page());
    localChannelExt.setParam(":VCH_ATTR", paramChannelDAO.getCh_attr());
    localChannelExt.setParam(":VINDEX_TEMP", paramChannelDAO.getIndex_temp());
    localChannelExt.setParam(":VLIST_TEMP", paramChannelDAO.getList_temp());
    localChannelExt.setParam(":VARTICLE_TEMP", paramChannelDAO.getArticle_temp());
    localChannelExt.setParam(":VCH_IMG", paramChannelDAO.getCh_img());
    localChannelExt.setParam(":VLIST_TYPE", paramChannelDAO.getList_type());
    localChannelExt.setParam(":VCH_KEY", paramChannelDAO.getCh_key());
    localChannelExt.setParam(":VCH_DESC", paramChannelDAO.getCh_desc());
    localChannelExt.setParam(":VINDEX_VIEW", paramChannelDAO.getIndex_view());
    localChannelExt.setParam(":VIN_DATE", paramChannelDAO.getIn_date());
    localChannelExt.setParam(":VREMARK", paramChannelDAO.getRemark());
    this.tradeQuery.executeBy(localChannelExt.insBy("INS_BY_CHANNEL"));
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
      ChannelDAO localChannelDAO = new ChannelDAO();
      localChannelDAO.setCh_id(str1);
      localChannelDAO.setCh_name(str2);
      localChannelDAO.setUp_ch_id(str3);
      localChannelDAO.setCh_level(str4);
      localChannelDAO.setState_code(str5);
      localChannelDAO.setState_code_date(str6);
      localChannelDAO.setShow_no(str7);
      localChannelDAO.setRight_tag(str8);
      localChannelDAO.setSave_dir(str9);
      localChannelDAO.setDir_pos(str10);
      localChannelDAO.setCont_mod(str11);
      localChannelDAO.setDefault_page(str12);
      localChannelDAO.setCh_attr(str13);
      localChannelDAO.setIndex_temp(str14);
      localChannelDAO.setList_temp(str15);
      localChannelDAO.setArticle_temp(str16);
      localChannelDAO.setCh_img(str17);
      localChannelDAO.setList_type(str18);
      localChannelDAO.setCh_key(str19);
      localChannelDAO.setCh_desc(str20);
      localChannelDAO.setIndex_view(str21);
      localChannelDAO.setIn_date(str22);
      localChannelDAO.setRemark(str23);
      i = modifyChannel(localChannelDAO);
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

  public int modifyChannel(ChannelDAO paramChannelDAO)
    throws SaasApplicationException
  {
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramChannelDAO.getCh_id());
    localChannelExt.setParam(":VCH_NAME", paramChannelDAO.getCh_name());
    localChannelExt.setParam(":VUP_CH_ID", paramChannelDAO.getUp_ch_id());
    localChannelExt.setParam(":VCH_LEVEL", paramChannelDAO.getCh_level());
    localChannelExt.setParam(":VSTATE_CODE", paramChannelDAO.getState_code());
    localChannelExt.setParam(":VSTATE_CODE_DATE", paramChannelDAO.getState_code_date());
    localChannelExt.setParam(":VSHOW_NO", paramChannelDAO.getShow_no());
    localChannelExt.setParam(":VRIGHT_TAG", paramChannelDAO.getRight_tag());
    localChannelExt.setParam(":VSAVE_DIR", paramChannelDAO.getSave_dir());
    localChannelExt.setParam(":VDIR_POS", paramChannelDAO.getDir_pos());
    localChannelExt.setParam(":VCONT_MOD", paramChannelDAO.getCont_mod());
    localChannelExt.setParam(":VDEFAULT_PAGE", paramChannelDAO.getDefault_page());
    localChannelExt.setParam(":VCH_ATTR", paramChannelDAO.getCh_attr());
    localChannelExt.setParam(":VINDEX_TEMP", paramChannelDAO.getIndex_temp());
    localChannelExt.setParam(":VLIST_TEMP", paramChannelDAO.getList_temp());
    localChannelExt.setParam(":VARTICLE_TEMP", paramChannelDAO.getArticle_temp());
    localChannelExt.setParam(":VCH_IMG", paramChannelDAO.getCh_img());
    localChannelExt.setParam(":VLIST_TYPE", paramChannelDAO.getList_type());
    localChannelExt.setParam(":VCH_KEY", paramChannelDAO.getCh_key());
    localChannelExt.setParam(":VCH_DESC", paramChannelDAO.getCh_desc());
    localChannelExt.setParam(":VINDEX_VIEW", paramChannelDAO.getIndex_view());
    localChannelExt.setParam(":VIN_DATE", paramChannelDAO.getIn_date());
    localChannelExt.setParam(":VREMARK", paramChannelDAO.getRemark());
    this.tradeQuery.executeBy(localChannelExt.insBy("UP_BY_CHANNEL"));
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
      ChannelDAO localChannelDAO = new ChannelDAO();
      localChannelDAO.setCh_id(str);
      i = DelChannel(localChannelDAO);
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

  public int DelChannel(ChannelDAO paramChannelDAO)
    throws SaasApplicationException
  {
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramChannelDAO.getCh_id());
    this.tradeQuery.executeBy(localChannelExt.insBy("DEL_BY_CHANNEL"));
    return 0;
  }

  public ArrayList getChannelInfos(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_LIST", paramInt, 30);
    return localArrayList;
  }

  public int getChannelInfos(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_LIST");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getChannelList()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_INFO");
    return localArrayList;
  }

  public int getChannelInfo()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_INFO");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getChannel(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_BY_CH_ID");
    return localArrayList;
  }

  public ArrayList getChannelBySaveDir(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VSAVE_DIR", paramString);
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_BY_SAVE_DIR");
    return localArrayList;
  }

  public ArrayList getSaveDirByChLevelAndContMod(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_LEVEL", paramString1);
    localChannelExt.setParam(":VCONT_MOD", paramString2);
    localArrayList = localChannelExt.selByList("SEL_SAVE_DIR_BY_CHLEVEL_CONTMOD");
    return localArrayList;
  }

  public String getChIdByContMod(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCONT_MOD", paramString);
    localArrayList = localChannelExt.selByList("SEL_CH_ID_BY_CONTMOD");
    String str = "";
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ch_id") != null)
        str = localHashMap.get("ch_id").toString();
    }
    return str;
  }

  public ArrayList getChInfoSelf(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramString1);
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_BY_CH_ID", paramInt1, paramInt2);
    if (paramString2.equals("in_date"))
      localArrayList = localChannelExt.selByList("SEL_CHSELF_BY_DATE", paramInt1, paramInt2);
    else if (paramString2.equals("show_no"))
      localArrayList = localChannelExt.selByList("SEL_CHSELF_BY_NO", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getChInfoSon(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString1);
    localArrayList = localChannelExt.selByList("SEL_CHSESON_BY_DATE", paramInt1, paramInt2);
    if (paramString2.equals("in_date"))
      localArrayList = localChannelExt.selByList("SEL_CHSESON_BY_DATE", paramInt1, paramInt2);
    else if (paramString2.equals("show_no"))
      localArrayList = localChannelExt.selByList("SEL_CHSESON_BY_NO", paramInt1, paramInt2);
    return localArrayList;
  }

  public ArrayList getChInfoNext(String paramString1, String paramString2, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramString1);
    if (paramString2.equals("in_date"))
      localArrayList = localChannelExt.selByList("SEL_CH_ALL_BY_DATE", 0, paramInt);
    else if (paramString2.equals("show_no"))
      localArrayList = localChannelExt.selByList("SEL_CH_ALL_BY_SHOW", 0, paramInt);
    return localArrayList;
  }

  public int getBooChSon(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CH_SON");
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
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CH_SON", 0, 30);
    return localArrayList;
  }

  public int getChSonList(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CH_SON");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public String getChName(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CH_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ch_name") != null)
        str = localHashMap.get("ch_name").toString();
    }
    return str;
  }

  public String getSaveDir(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CHANNEL_BY_CH_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("save_dir") != null)
        str = localHashMap.get("save_dir").toString();
    }
    return str;
  }

  public String getUpFilePath(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramString);
    ArrayList localArrayList = localChannelExt.selByList("SEL_SAVE_DIR");
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
    String str = "";
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString);
    ArrayList localArrayList = localChannelExt.selByList("SEL_CH_LEVEL");
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
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_ID", paramString);
    ArrayList localArrayList = localChannelExt.selByList("SEL_CHANNEL_BY_CH_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("ch_level") != null)
        str = localHashMap.get("ch_level").toString();
    }
    return str;
  }

  public ArrayList getChSon(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CH_SON");
    return localArrayList;
  }

  public ArrayList getChSon(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString);
    localArrayList = localChannelExt.selByList("SEL_CH_SON", paramInt, 20);
    return localArrayList;
  }

  public String getChannelItems(String paramString)
    throws SaasApplicationException
  {
    String str1 = "";
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VUP_CH_ID", paramString);
    ArrayList localArrayList = localChannelExt.selByList("SEL_CH_SON");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (localHashMap.get("ch_id") != null)
          str2 = localHashMap.get("ch_id").toString();
        if (localHashMap.get("ch_name") != null)
          str3 = localHashMap.get("ch_name").toString();
        if (localHashMap.get("ch_level") != null)
          str4 = localHashMap.get("ch_level").toString();
        String str5 = "";
        for (int j = 1; j < Integer.parseInt(str4); j++)
          str5 = str5 + "-";
        if (getBooChSon(str2) == 0)
        {
          str1 = str1 + "<option value=" + str2 + ">" + str5 + str3 + "</option>";
        }
        else
        {
          str1 = str1 + "<option value=" + str2 + ">" + str5 + str3 + "</option>";
          str1 = str1 + getChannelItems(str2);
        }
      }
    return str1;
  }

  public ArrayList getChNameAndPath(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ChannelExt localChannelExt = new ChannelExt();
    localChannelExt.setParam(":VCH_LEVEL", paramString);
    localArrayList = localChannelExt.selByList("SEL_BY_LEVEL_FOR_PATH");
    return localArrayList;
  }

  public static void main(String[] paramArrayOfString)
  {
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.channelMgr.ChannelInfo
 * JD-Core Version:    0.6.0
 */