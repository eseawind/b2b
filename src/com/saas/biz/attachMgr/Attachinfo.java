package com.saas.biz.attachMgr;

import com.saas.biz.commen.DwindlePic;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.commen.config;
import com.saas.biz.dao.attachDAO.AttachDAO;
import com.saas.biz.dao.attachDAO.AttachExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Attachinfo
{
  Logger log = new Logger(this);
  commMethodMgr commen = new commMethodMgr();
  ArrayList queryResult = new ArrayList();
  Buffers inBuffer;
  Buffers outBuffer;
  Dbtable tradeQuery = new Dbtable();

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

  public String getAttachPath(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AttachExt localAttachExt = new AttachExt();
    String str = "";
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramString1);
    localAttachExt.setParam(":VFILE_TYPE", paramString2);
    localAttachExt.setParam(":VVALIDITY", paramString3);
    localArrayList = localAttachExt.selByList("SEL_BY_ROOT");
    if (localArrayList == null)
    {
      str = "/images/default_wood.gif";
      return str;
    }
    Iterator localIterator = localArrayList.iterator();
    HashMap localHashMap = (HashMap)localIterator.next();
    if (localHashMap.get("file_path") != "")
      str = localHashMap.get("file_path").toString();
    else
      str = "/upload/default.gif";
    return str;
  }

  public String getAttachPathByUserFace(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AttachExt localAttachExt = new AttachExt();
    String str = "";
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramString);
    localAttachExt.setParam(":VFILE_TYPE", "U");
    localAttachExt.setParam(":VVALIDITY", "0");
    localArrayList = localAttachExt.selByList("SEL_BY_ROOT");
    if (localArrayList == null)
    {
      str = "/upload/UserDefault.gif";
      return str;
    }
    Iterator localIterator = localArrayList.iterator();
    HashMap localHashMap = (HashMap)localIterator.next();
    if (localHashMap.get("file_path") != "")
      str = localHashMap.get("file_path").toString();
    else
      str = "/upload/UserDefault.gif";
    return str;
  }

  public ArrayList getAttachList(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramString1);
    localAttachExt.setParam(":VFILE_TYPE", paramString2);
    localAttachExt.setParam(":VVALIDITY", paramString3);
    localArrayList = localAttachExt.selByList("SEL_BY_ROOT");
    return localArrayList;
  }

  public ArrayList getAttachInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VATTACH_ID", paramString);
    localArrayList = localAttachExt.selByList("SEL_BY_ID");
    return localArrayList;
  }

  public void addAttachinfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    try
    {
      commMethodMgr localcommMethodMgr = new commMethodMgr();
      String str1 = paramBuffers.getString("ATTACH_ROOT_ID");
      String str2 = paramBuffers.getString("UPLOADFILEDIR");
      AttachDAO localAttachDAO = new AttachDAO();
      localAttachDAO.setAttach_root_id(paramBuffers.getString("ATTACH_ROOT_ID"));
      localAttachDAO.setUser_id(paramBuffers.getString("SESSION_USER_ID"));
      localAttachDAO.setCust_id(paramBuffers.getString("SESSION_CUST_ID"));
      localAttachDAO.setFile_path(str2);
      localAttachDAO.setFile_type(paramBuffers.isFieldExist("FILE_TYPE") ? paramBuffers.getString("FILE_TYPE") : "0");
      String str3 = str2.substring(0, str2.lastIndexOf("/"));
      i = addAttachinfo(localAttachDAO, str3);
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
  }

  public int addAttachinfo(AttachDAO paramAttachDAO, String paramString)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    AttachExt localAttachExt = new AttachExt();
    String[] arrayOfString = paramAttachDAO.getFile_path().trim().split("/");
    String str1 = "";
    String str2 = arrayOfString[(arrayOfString.length - 1)];
    try
    {
      this.log.LOG_INFO("====" + new String(str2.getBytes("GBK"), "ISO-8859-1"));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    if (paramAttachDAO.getFile_type().equals("A"))
    {
    	AttachExt localObject = new AttachExt();
      ((AttachExt)localObject).setParam(":VATTACH_ROOT_ID", paramAttachDAO.getAttach_root_id());
      ((AttachExt)localObject).setParam(":VFILE_TYPE", "A");
      ((AttachExt)localObject).setParam(":VVALIDITY", "1");
      this.tradeQuery.executeBy(((AttachExt)localObject).insBy("UP_BY_TYPE"));
      String str3 = getImagePathByModify(str2, 60, 60, paramString);
      paramAttachDAO.setFile_path("/upload/" + paramAttachDAO.getUser_id() + "/small/" + str2);
    }
    else if (paramAttachDAO.getFile_type().equals("B"))
    {
    	AttachExt localObject = new AttachExt();
      ((AttachExt)localObject).setParam(":VATTACH_ROOT_ID", paramAttachDAO.getAttach_root_id());
      ((AttachExt)localObject).setParam(":VFILE_TYPE", "B");
      ((AttachExt)localObject).setParam(":VVALIDITY", "1");
      this.tradeQuery.executeBy(((AttachExt)localObject).insBy("UP_BY_TYPE"));
      String str3 = getImagePathByModify(str2, 120, 120, paramString);
      paramAttachDAO.setFile_path("/upload/" + paramAttachDAO.getUser_id() + "/small/" + str2);
    }
    else if (paramAttachDAO.getFile_type().equals("C"))
    {
    	AttachExt localObject = new AttachExt();
      ((AttachExt)localObject).setParam(":VATTACH_ROOT_ID", paramAttachDAO.getAttach_root_id());
      ((AttachExt)localObject).setParam(":VFILE_TYPE", "C");
      ((AttachExt)localObject).setParam(":VVALIDITY", "1");
      this.tradeQuery.executeBy(((AttachExt)localObject).insBy("UP_BY_TYPE"));
      String str3 = getImagePathByModify(str2, 120, 160, paramString);
      paramAttachDAO.setFile_path("/upload/" + paramAttachDAO.getUser_id() + "/small/" + str2);
    }
    else if (paramAttachDAO.getFile_type().equals("U"))
    {
    	AttachExt localObject = new AttachExt();
      ((AttachExt)localObject).setParam(":VATTACH_ROOT_ID", paramAttachDAO.getAttach_root_id());
      ((AttachExt)localObject).setParam(":VFILE_TYPE", "U");
      ((AttachExt)localObject).setParam(":VVALIDITY", "0");
      this.tradeQuery.executeBy(((AttachExt)localObject).insBy("DELETE_BY_ROOT_TYPE"));
     String  str3 = getImagePathByModify(str2, 120, 160, paramString);
      paramAttachDAO.setFile_path("/upload/" + paramAttachDAO.getUser_id() + "/small/" + str2);
    }
    else
    {
    	AttachExt localObject = new AttachExt();
      ((AttachExt)localObject).setParam(":VATTACH_ROOT_ID", paramAttachDAO.getAttach_root_id());
      ((AttachExt)localObject).setParam(":VFILE_TYPE", "0");
      ((AttachExt)localObject).setParam(":VVALIDITY", "1");
      this.tradeQuery.executeBy(((AttachExt)localObject).insBy("UP_BY_TYPE"));
      paramAttachDAO.setFile_path("/upload/" + str2);
    }
    Object localObject = localcommMethodMgr.GenTradeId();
    String str3 = "/upload/" + paramAttachDAO.getCust_id() + "/" + str2;
    localAttachExt.setParam(":VATTACH_ID", localObject);
    localAttachExt.setParam(":VUSER_ID", paramAttachDAO.getUser_id());
    localAttachExt.setParam(":VCUST_ID", paramAttachDAO.getCust_id());
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramAttachDAO.getAttach_root_id());
    localAttachExt.setParam(":VATTACH_NAME", str2);
    localAttachExt.setParam(":VFILE_TYPE", paramAttachDAO.getFile_type());
    localAttachExt.setParam(":VFILE_PATH", str3);
    localAttachExt.setParam(":VATTACH_DESC", str1);
    localAttachExt.setParam(":VVALIDITY", "0");
    this.tradeQuery.executeBy(localAttachExt.insBy("INS_BY_ALL"));
    this.outBuffer.setString("FILENAME", "/upload/" + paramAttachDAO.getUser_id() + "/" + str2);
    return 0;
  }

  public String getImagePathByModify(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    DwindlePic localDwindlePic = new DwindlePic();
    String str1 = paramString2 + "/" + paramString1;
    String str2 = paramString2 + "/small/" + paramString1;
    String str3 = paramString2 + "/small/" + paramString1;
    try
    {
      localDwindlePic.doZoom(paramInt1, paramInt2, str1, str2);
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return str3;
  }

  public String getAttachAddr(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    String str = "";
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramString);
    localAttachExt.setParam(":VFILE_TYPE", "0");
    localAttachExt.setParam(":VVALIDITY", "0");
    ArrayList localArrayList = localAttachExt.selByList("SEL_BY_ROOT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("file_path") != null)
        str = localHashMap.get("file_path").toString();
    }
    return str;
  }

  public ArrayList GetArrayList(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramString);
    ArrayList localArrayList = localAttachExt.selByList("SEL_BY_ROOT_FOR_DWR");
    return localArrayList;
  }

  public String getPicFilePath(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getAttachInfoByList(paramString);
    if (localArrayList != null)
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if ((localHashMap.get("file_path") == null) || (checkPicType(localHashMap.get("file_path").toString()) != 0))
          continue;
        str = localHashMap.get("file_path").toString();
      }
    return str;
  }

  public String getVideoFilePath(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getAttachInfoByList(paramString);
    if (localArrayList != null)
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if ((localHashMap.get("file_path") == null) || (checkVedioType(localHashMap.get("file_path").toString()) != 0))
          continue;
        str = localHashMap.get("file_path").toString();
      }
    return str;
  }

  public int checkPicType(String paramString)
  {
    String str = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length()).toLowerCase();
    if (str.equals("gif"))
      return 0;
    if (str.equals("jpeg"))
      return 0;
    if (str.equals("jpg"))
      return 0;
    if (str.equals("bmp"))
      return 0;
    return 1;
  }

  public int checkVedioType(String paramString)
  {
    String str = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length()).toLowerCase();
    if (str.equals("flv"))
      return 0;
    return 1;
  }

  public String Getcompanyaddress(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    String str = "";
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramString);
    ArrayList localArrayList = localAttachExt.selByList("SEL_BY_ROOT_FOR_DWR");
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("company_address") != null)
        str = localHashMap.get("company_address").toString();
      else
        str = "111";
    }
    this.log.LOG_INFO(str + "**************");
    return str;
  }

  public String Getgroup_contact_phone(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    String str = "";
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramString);
    ArrayList localArrayList = localAttachExt.selByList("SEL_BY_ROOT_FOR_DWR");
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("group_contact_phone") != null)
        str = localHashMap.get("group_contact_phone").toString();
    }
    return str;
  }

  public String Getscope(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    String str = "";
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramString);
    ArrayList localArrayList = localAttachExt.selByList("SEL_BY_ROOT_FOR_DWR");
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("scope") != null)
        str = localHashMap.get("scope").toString();
    }
    return str;
  }

  public void addAttachInfo(Buffers paramBuffers)
    throws IOException
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = "";
    if ((paramBuffers.getString("RSRV_STR2") != null) || (paramBuffers.getString("RSRV_STR2") == ""))
      str1 = paramBuffers.getString("RSRV_STR2");
    String str2 = paramBuffers.getString("SESSION_CUST_ID");
    String str3 = paramBuffers.getString("SESSION_USER_ID");
    String str4 = paramBuffers.getString("ATTACH_ROOT_ID");
    String str5 = paramBuffers.getStringWeb("UPLOADFILEDIR");
    String str6 = paramBuffers.getStringWeb("FILE_NAME");
    String str7 = paramBuffers.getStringWeb("RSRV_STR1");
    try
    {
      AttachDAO localAttachDAO = new AttachDAO();
      localAttachDAO.setAttach_root_id(str4);
      localAttachDAO.setUser_id(str3);
      localAttachDAO.setCust_id(str2);
      localAttachDAO.setFile_path(str5);
      localAttachDAO.setAttach_name(str6);
      localAttachDAO.setFile_type("0");
      localAttachDAO.setAttach_desc(str7);
      localAttachDAO.setRsrv_str2(str1);
      i = addAttachInfo(localAttachDAO);
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
  }

  public int addAttachInfo(AttachDAO paramAttachDAO)
    throws SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    config localconfig = new config();
    AttachExt localAttachExt = new AttachExt();
    localconfig.init();
    if ((paramAttachDAO.getRsrv_str2() == "1") || (paramAttachDAO.getRsrv_str2().equals("1")))
    {
      this.log.LOG_INFO("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
      String str = localconfig.getString("yinpath");
      this.log.LOG_INFO("attachDao.getFile_path()============================================" + paramAttachDAO.getFile_path() + "---");
      DwindlePic localDwindlePic = new DwindlePic();
      this.log.LOG_INFO("yinfile============================================" + str + "---");
      localDwindlePic.ImgYin(str, paramAttachDAO.getFile_path());
    }
    String str = paramAttachDAO.getAttach_root_id();
    localAttachExt.setParam(":VATTACH_ID", localcommMethodMgr.GenTradeId());
    localAttachExt.setParam(":VUSER_ID", paramAttachDAO.getUser_id());
    localAttachExt.setParam(":VCUST_ID", paramAttachDAO.getCust_id());
    localAttachExt.setParam(":VATTACH_ROOT_ID", str);
    localAttachExt.setParam(":VATTACH_NAME", paramAttachDAO.getAttach_name());
    localAttachExt.setParam(":VFILE_TYPE", paramAttachDAO.getFile_type());
    localAttachExt.setParam(":VFILE_PATH", paramAttachDAO.getFile_path());
    localAttachExt.setParam(":VATTACH_DESC", paramAttachDAO.getAttach_desc());
    localAttachExt.setParam(":VVALIDITY", "0");
    this.tradeQuery.executeBy(localAttachExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public ArrayList getAttachInfoByList(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VROOT_ID", paramString);
    ArrayList localArrayList = localAttachExt.selByList("SEL_BY_ROOT_ID");
    return localArrayList;
  }

  public ArrayList getAttachInfoByRootId(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VROOT_ID", paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList = localAttachExt.selByList("SEL_ATT_ROOT_ID", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getAttachInfoByRootId(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VROOT_ID", paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList = localAttachExt.selByList("SEL_ATT_ROOT_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAttachInfoByAttachID(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VATTACH_ID", paramString);
    ArrayList localArrayList = localAttachExt.selByList("SEL_BY_ATTACH_ID");
    return localArrayList;
  }

  public ArrayList getAttachInfoByImage(String paramString, int paramInt1, int paramInt2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VROOT_ID", paramString);
    ArrayList localArrayList = localAttachExt.selByList("SEL_BY_IMAGE_ID", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getAttachInfoByImage()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    AttachExt localAttachExt = new AttachExt();
    localArrayList = localAttachExt.selByList("SEL_BY_IMAGE_ID_CT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      i = Integer.parseInt(localHashMap.get("ct").toString());
    }
    return i;
  }

  public void delAttachInfo(Buffers paramBuffers)
    throws IOException
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getStringWeb("ATTACH_ID");
    try
    {
      i = delAttachInfo(str);
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
  }

  public int delAttachInfo(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VATTACH_ID", paramString);
    this.tradeQuery.executeBy(localAttachExt.insBy("DELETE_BY_ID"));
    return 0;
  }

  public void delAttachByRootId(Buffers paramBuffers)
    throws IOException
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getStringWeb("ATTACH_ROOT_ID");
    try
    {
      i = delAttachInfo(str);
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
  }

  public int delAttachByRootId(String paramString)
    throws SaasApplicationException
  {
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VROOT_ID", paramString);
    this.tradeQuery.executeBy(localAttachExt.insBy("DELETE_BY_ROOT"));
    return 0;
  }

  public ArrayList getAttachInfo(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AttachExt localAttachExt = new AttachExt();
    localArrayList = localAttachExt.selByList("SEL_BY_JPG", 0, paramInt);
    return localArrayList;
  }

  public ArrayList getFilePath(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    AttachExt localAttachExt = new AttachExt();
    localAttachExt.setParam(":VATTACH_ROOT_ID", paramString);
    localArrayList = localAttachExt.selByList("SEL_BY_ATTACH_ROOT_ID");
    return localArrayList;
  }

  public String getFilePathClass(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    localArrayList = getFilePath(paramString);
    if (localArrayList != null)
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("file_path") != null)
        str = localHashMap.get("file_path").toString();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.attachMgr.Attachinfo
 * JD-Core Version:    0.6.0
 */