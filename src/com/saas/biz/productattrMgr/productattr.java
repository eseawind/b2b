package com.saas.biz.productattrMgr;

import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.productattrDAO.ProductattrDAO;
import com.saas.biz.dao.productattrDAO.ProductattrExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;

public class productattr
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

  public void addProductAttr(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addClassInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    ProductattrDAO localProductattrDAO = new ProductattrDAO();
    localProductattrDAO.setClass_id(paramBuffers.getString("CLASS_ID"));
    localProductattrDAO.setAttr_name(paramBuffers.getString("ATTR_NAME"));
    localProductattrDAO.setAttr_no(paramBuffers.getString("ATTR_NO"));
    localProductattrDAO.setEnable_tag(paramBuffers.getString("ENABLE_TAG"));
    localProductattrDAO.setAttr_desc(paramBuffers.getString("ATTR_DESC"));
    localProductattrDAO.setDefault_tag(paramBuffers.getString("DEFAULT_TAG"));
    localProductattrDAO.setDefault_value(paramBuffers.getString("DEFAULT_VALUE"));
    localProductattrDAO.setRsrv_str3(paramBuffers.getString("RSRV_STR3"));
    try
    {
      i = addProductAttr(localProductattrDAO);
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
    this.log.LOG_INFO("退出addClassInfo方法...");
  }

  public int addProductAttr(ProductattrDAO paramProductattrDAO)
    throws SaasApplicationException
  {
    ProductattrExt localProductattrExt = new ProductattrExt();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str1 = localcommMethodMgr.GenTradeId();
    String str2 = localcommMethodMgr.GenShortTradeId();
    localProductattrExt.setParam(":VCLASS_ID", paramProductattrDAO.getClass_id());
    localProductattrExt.setParam(":VATTR_NAME", paramProductattrDAO.getAttr_name());
    localProductattrExt.setParam(":VATTR_DESC", paramProductattrDAO.getAttr_desc());
    localProductattrExt.setParam(":VATTR_NO", paramProductattrDAO.getAttr_no());
    localProductattrExt.setParam(":VENABLE_TAG", paramProductattrDAO.getEnable_tag());
    localProductattrExt.setParam(":VATTR_ID", str1);
    localProductattrExt.setParam(":VDEFAULT_TAG", paramProductattrDAO.getDefault_tag());
    localProductattrExt.setParam(":VDEFAULT_VALUE", paramProductattrDAO.getDefault_value());
    localProductattrExt.setParam(":VRSRV_STR1", "");
    localProductattrExt.setParam(":VRSRV_STR2", "");
    localProductattrExt.setParam(":VRSRV_STR3", paramProductattrDAO.getRsrv_str3());
    localProductattrExt.setParam(":VRSRV_STR4", str2);
    localProductattrExt.setParam(":VRSRV_STR5", "");
    localProductattrExt.setParam(":VRSRV_STR6", "");
    localProductattrExt.setParam(":VRSRV_STR7", "");
    localProductattrExt.setParam(":VRSRV_STR8", "");
    localProductattrExt.setParam(":VRSRV_STR9", "");
    localProductattrExt.setParam(":VRSRV_STR10", "");
    localProductattrExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localProductattrExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void delByAttrId(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delByAttrId方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("ATTR_ID");
    try
    {
      i = delByAttrId(str);
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
    this.log.LOG_INFO("退出delByAttrId方法...");
  }

  public int delByAttrId(String paramString)
    throws SaasApplicationException
  {
    ProductattrExt localProductattrExt = new ProductattrExt();
    localProductattrExt.setParam(":VATTR_ID", paramString);
    this.tradeQuery.executeBy(localProductattrExt.insBy("DEL_BY_ATTRID"));
    return 0;
  }

  public ArrayList getProductAttrByClassId(String paramString)
    throws SaasApplicationException
  {
    ProductattrExt localProductattrExt = new ProductattrExt();
    ArrayList localArrayList = new ArrayList();
    localProductattrExt.setParam(":VCLASS_ID", paramString);
    localProductattrExt.setParam(":VENABLE_TAG", "0");
    localArrayList = localProductattrExt.selByList("SEL_BY_CLASSID");
    return localArrayList;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.productattrMgr.productattr
 * JD-Core Version:    0.6.0
 */