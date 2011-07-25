package com.saas.biz.productMgr;

import com.saas.biz.attachMgr.Attachinfo;
import com.saas.biz.dao.productDAO.ProductDAO;
import com.saas.biz.dao.productDAO.ProductExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;
import tools.util.DateUtils;

public class ProductInfo
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

  public void addProduInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addProduInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PRODUCT_ID");
    String str3 = paramBuffers.getString("PRODUCT_TYPE");
    String str4 = paramBuffers.getString("PRODUCT_CLASS");
    String str5 = paramBuffers.getString("PRODUCT_NAME");
    String str6 = paramBuffers.getString("PRODUCT_ABSTRACT");
    String str7 = paramBuffers.getString("PRODUCT_DESC");
    String str8 = paramBuffers.getString("PRODUCT_SITE");
    String str9 = paramBuffers.getString("PRODUCT_UNIT");
    String str10 = paramBuffers.getString("SESSION_USER_ID");
    String str11 = paramBuffers.getString("VALIDITY");
    String str12 = paramBuffers.getString("SESSION_USER_ID");
    String str13 = paramBuffers.getString("REMARK");
    try
    {
      ProductDAO localProductDAO = new ProductDAO();
      localProductDAO.setCust_id(str1);
      localProductDAO.setProduct_id(str2);
      localProductDAO.setProduct_type(str3);
      localProductDAO.setProduct_class(str4);
      localProductDAO.setProduct_name(str5);
      localProductDAO.setProduct_abstract(str6);
      localProductDAO.setProduct_desc(str7);
      localProductDAO.setProduct_site(str8);
      localProductDAO.setProduct_unit(str9);
      localProductDAO.setPublish_user_id(str10);
      localProductDAO.setValidity(str11);
      localProductDAO.setAudit_user_id(str12);
      localProductDAO.setRemark(str13);
      i = addProduInfo(localProductDAO);
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
    this.log.LOG_INFO("退出addProduInfo方法...");
  }

  public int addProduInfo(ProductDAO paramProductDAO)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramProductDAO.getCust_id());
    localProductExt.setParam(":VPRODUCT_ID", paramProductDAO.getProduct_id());
    localProductExt.setParam(":VPRODUCT_TYPE", paramProductDAO.getProduct_type());
    localProductExt.setParam(":VPRODUCT_CLASS", paramProductDAO.getProduct_class());
    localProductExt.setParam(":VPRODUCT_NAME", paramProductDAO.getProduct_name());
    localProductExt.setParam(":VPRODUCT_ABSTRACT", paramProductDAO.getProduct_abstract());
    localProductExt.setParam(":VPRODUCT_DESC", paramProductDAO.getProduct_desc());
    localProductExt.setParam(":VPRODUCT_SITE", paramProductDAO.getProduct_site());
    localProductExt.setParam(":VPRODUCT_UNIT", paramProductDAO.getProduct_unit());
    localProductExt.setParam(":VPUBLISH_USER_ID", paramProductDAO.getPublish_user_id());
    localProductExt.setParam(":VVALIDITY", paramProductDAO.getValidity());
    localProductExt.setParam(":VAUDIT_USER_ID", paramProductDAO.getAudit_user_id());
    localProductExt.setParam(":VREMARK", paramProductDAO.getRemark());
    this.tradeQuery.executeBy(localProductExt.insBy("INS_ONE_PRODUCT"));
    return 0;
  }

  public int selectTest()
  {
    String str1 = "'2008-11-03'";
    String str2 = "select * from tf_f_product where publish_date >= " + str1;
    this.log.LOG_INFO(str2 + "_____________++++++++++++++____________");
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localArrayList = localProductExt.selByListSql(str2);
    if (null != localArrayList)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getProductBySearchf(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("_____________++++++++_______++++++____________");
    Calendar localCalendar = Calendar.getInstance();
    StringBuffer localStringBuffer = null;
    if (!paramString3.equals(""))
      localStringBuffer = new StringBuffer("select * from tf_f_product t  tf_t_custmer c where t.cust_id=c.cust_id and c.cust_name like '%" + paramString3 + "%' and");
    else
      localStringBuffer = new StringBuffer("select * from tf_f_product t where ");
    if (paramString4.equals(""))
      paramString4 = "365";
    localCalendar.add(5, 0 - Integer.valueOf(paramString4).intValue());
    String str = DateUtils.formateDateToNumber(localCalendar);
    localStringBuffer.append(" t.publish_date >='" + str + "'  and  t.publish_date<= now() ");
    if (!paramString1.equals(""))
      localStringBuffer.append(" and t.product_name like '%" + paramString1 + "%' ");
    if (!paramString2.equals(""))
      localStringBuffer.append(" and t.product_site like '%" + paramString2 + "%' ");
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    this.log.LOG_INFO(localStringBuffer.toString() + "_____________++111111++++++_______++++++____________");
    localArrayList = localProductExt.selByListSql(localStringBuffer.toString());
    this.log.LOG_INFO("_____________++22222++++++_______++++++____________");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getProductBySearchf(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuffer localStringBuffer = null;
    if (!paramString3.equals(""))
      localStringBuffer = new StringBuffer("select * from tf_f_product t  tf_t_custmer c where t.cust_id=c.cust_id and c.cust_name like '%" + paramString3 + "%' and");
    else
      localStringBuffer = new StringBuffer("select * from tf_f_product t where ");
    if (paramString4.equals(""))
      paramString4 = "365";
    localCalendar.add(5, 0 - Integer.valueOf(paramString4).intValue());
    String str = DateUtils.formateDateToNumber(localCalendar);
    localStringBuffer.append(" t.publish_date >='" + str + "'  and  t.publish_date<= now() ");
    if (!paramString1.equals(""))
      localStringBuffer.append(" and t.product_name like '%" + paramString1 + "%' ");
    if (!paramString2.equals(""))
      localStringBuffer.append(" and t.product_site like '%" + paramString2 + "%' ");
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localArrayList = localProductExt.selByListSql(localStringBuffer.toString(), paramInt1, paramInt2);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public int getProductBySearchfc(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuffer localStringBuffer = null;
    if (!paramString3.equals(""))
      localStringBuffer = new StringBuffer("select * from tf_f_product t  tf_t_custmer c where t.cust_id=c.cust_id and c.cust_name like '%" + paramString3 + "%' and");
    else
      localStringBuffer = new StringBuffer("select * from tf_f_product t where ");
    if (paramString4.equals(""))
      paramString4 = "365";
    localCalendar.add(5, 0 - Integer.valueOf(paramString4).intValue());
    String str = DateUtils.formateDateToNumber(localCalendar);
    localStringBuffer.append(" t.publish_date >='" + str + "'  and  t.publish_date<= now() ");
    if (!paramString1.equals(""))
      localStringBuffer.append(" and t.product_name like '%" + paramString1 + "%' ");
    if (!paramString2.equals(""))
      localStringBuffer.append(" and t.product_site like '%" + paramString2 + "%' ");
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localArrayList = localProductExt.selByListSql(localStringBuffer.toString());
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void getproductListByCust(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入getproductListByCust方法...");
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("QUERY_PARAM");
    try
    {
      if (str2.equals(""))
        this.queryResult = getproductListByCust(str1);
      else
        this.queryResult = searchProduct(str2, str1);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getproductListByCust方法...");
  }

  public ArrayList getproductListByCust(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_BY_CUST");
    return localArrayList;
  }

  public void getProductInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.log.LOG_INFO("进入getProductInfo方法...");
    String str = paramBuffers.getString("PRODUCT_ID");
    try
    {
      this.queryResult = getProductInfo(str);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出getProductInfo方法...");
  }

  public ArrayList getProductInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_BY_PK");
    return localArrayList;
  }

  public ArrayList getProInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_ID", paramString2);
    localProductExt.setParam(":VCUST_ID", paramString1);
    localArrayList = localProductExt.selByList("SEL_BY_PRO_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList;
    return null;
  }

  public ArrayList getProductInfoById(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_BY_CUST_LIMIT", paramInt, 20);
    return localArrayList;
  }

  public int getProductInfoById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_BY_CUST_LIMIT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllProductInfoByForRe(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_TYPE", paramString);
    localArrayList = localProductExt.selByList("SEL_ALL_BY_CUST_LIMIT_FOR_RE");
    return localArrayList;
  }

  public ArrayList getAllProductInfoById(int paramInt)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localArrayList = localProductExt.selByList("SEL_ALL_BY_CUST_LIMIT", paramInt, 20);
    return localArrayList;
  }

  public int getAllProductInfoById()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localArrayList = localProductExt.selByList("SEL_ALL_BY_CUST_LIMIT");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getProductInfoById(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString1);
    localProductExt.setParam(":VPRO_NAME", "%" + paramString2 + "%");
    localArrayList = localProductExt.selByList("SEL_BY_CUST_LIMIT_PRO_NAME", paramInt, 20);
    return localArrayList;
  }

  public int getProductInfoById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString1);
    localProductExt.setParam(":VPRO_NAME", "%" + paramString2 + "%");
    localArrayList = localProductExt.selByList("SEL_BY_CUST_LIMIT_PRO_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getAllProductInfoById(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRO_NAME", "%" + paramString + "%");
    localArrayList = localProductExt.selByList("SEL_BY_ALL_LIMIT_PRO_NAME", paramInt, 20);
    return localArrayList;
  }

  public int getAllProductInfoById(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRO_NAME", "%" + paramString + "%");
    localArrayList = localProductExt.selByList("SEL_BY_ALL_LIMIT_PRO_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public String searchfj(String paramString)
    throws SaasApplicationException
  {
    return "";
  }

  public ArrayList searchProduct(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_NAME", "%" + paramString1 + "%");
    localProductExt.setParam(":VCUST_ID", paramString2);
    localArrayList = localProductExt.selByList("SEL_BY_SEARCH");
    return localArrayList;
  }

  public void delProductInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delProductInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("PRODUCT_ID");
    try
    {
      ProductDAO localProductDAO = new ProductDAO();
      localProductDAO.setCust_id(str1);
      localProductDAO.setProduct_id(str2);
      i = delProductInfo(localProductDAO);
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
    this.log.LOG_INFO("退出delProductInfo方法...");
  }

  public int delProductInfo(ProductDAO paramProductDAO)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramProductDAO.getCust_id());
    localProductExt.setParam(":VPRODUCT_ID", paramProductDAO.getProduct_id());
    this.tradeQuery.executeBy(localProductExt.insBy("DEL_BY_PRO_ID"));
    return 0;
  }

  public void changProductInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入changProductInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CUST_ID");
    String str2 = paramBuffers.getString("VALIDITY");
    String str3 = paramBuffers.getString("PRODUCT_ID");
    String str4 = paramBuffers.getString("PRODUCT_NAME");
    String str5 = paramBuffers.getString("PRODUCT_ABSTRACT");
    String str6 = paramBuffers.getString("PRODUCT_DESC");
    String str7 = paramBuffers.getString("PRODUCT_SITE");
    String str8 = paramBuffers.getString("PRODUCT_UNIT");
    String str9 = paramBuffers.getString("PRODUCT_CLASS");
    String str10 = paramBuffers.getString("REMARK");
    String str11 = paramBuffers.getString("PRODUCT_TYPE");
    this.log.LOG_INFO("退出changProductInfo方法..." + str4 + "***********");
    try
    {
      ProductDAO localProductDAO = new ProductDAO();
      localProductDAO.setProduct_type(str11);
      localProductDAO.setValidity(str2);
      localProductDAO.setCust_id(str1);
      localProductDAO.setProduct_id(str3);
      localProductDAO.setProduct_name(str4);
      localProductDAO.setProduct_abstract(str5);
      localProductDAO.setProduct_desc(str6);
      localProductDAO.setProduct_site(str7);
      localProductDAO.setProduct_unit(str8);
      localProductDAO.setRemark(str10);
      i = changProductInfo(localProductDAO, str9);
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
    this.log.LOG_INFO("退出changProductInfo方法...");
  }

  public int changProductInfo(ProductDAO paramProductDAO, String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramProductDAO.getCust_id());
    localProductExt.setParam(":VVALIDITY", paramProductDAO.getValidity());
    localProductExt.setParam(":VPRODUCT_ID", paramProductDAO.getProduct_id());
    localProductExt.setParam(":VPRODUCT_NAME", paramProductDAO.getProduct_name());
    localProductExt.setParam(":VPRODUCT_ABSTRACT", paramProductDAO.getProduct_abstract());
    localProductExt.setParam(":VPRODUCT_DESC", paramProductDAO.getProduct_desc());
    localProductExt.setParam(":VPRODUCT_SITE", paramProductDAO.getProduct_site());
    localProductExt.setParam(":VPRODUCT_UNIT", paramProductDAO.getProduct_unit());
    localProductExt.setParam(":VREMARK", paramProductDAO.getRemark());
    localProductExt.setParam(":VPRODUCT_TYPE", paramProductDAO.getProduct_type());
    localProductExt.setParam(":VPRODUCT_CLASS", paramString);
    this.tradeQuery.executeBy(localProductExt.insBy("UPDATE_PRODUCT_BY_IDS"));
    return 0;
  }

  public ArrayList getproductListByCust(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_BY_CUST", paramInt, 30);
    this.log.LOG_INFO("" + localProductExt.insBy("UPDATE_PRODUCT_BY_ID"));
    return localArrayList;
  }

  public int getProductNumber(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_BY_CUST");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getproductListBySearch(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 30;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localProductExt.selByList("SEL_BY_KEYS", paramInt, 30);
    return localArrayList;
  }

  public int getProductSearch(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCONTENT", "%" + paramString.trim() + "%");
    localArrayList = localProductExt.selByList("SEL_BY_KEYS");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getById(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString1);
    localProductExt.setParam(":VPRODUCT_ID", paramString2);
    localArrayList = localProductExt.selByList("SEL_BY_PRODUCT_ID");
    return localArrayList;
  }

  public ArrayList getProList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    ArrayList localArrayList = new ArrayList();
    if (paramInt > 1)
      paramInt = (paramInt - 1) * 20;
    else
      paramInt = 0;
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_ALL_PRO", paramInt, 20);
    return localArrayList;
  }

  public ArrayList getAllProductList(int paramInt, String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    ArrayList localArrayList = new ArrayList();
    paramInt *= 10;
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_ALL_PRODUCTLIST", paramInt, 10);
    return localArrayList;
  }

  public ArrayList getInfoclassByProId(String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    ArrayList localArrayList = new ArrayList();
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_INFOCLASS_BY_PRODUCT_ID");
    return localArrayList;
  }

  public ArrayList getAllProductListByClassId(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    ArrayList localArrayList = new ArrayList();
    paramInt *= 10;
    localProductExt.setParam(":VCUST_ID", paramString1);
    localProductExt.setParam(":VCLASS_ID", paramString2);
    localArrayList = localProductExt.selByList("SEL_PRODUCT_BY_CUST_CLASS_ID", paramInt, 10);
    return localArrayList;
  }

  public int getAllProductListByClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    ArrayList localArrayList = new ArrayList();
    localProductExt.setParam(":VCUST_ID", paramString1);
    localProductExt.setParam(":VCLASS_ID", paramString2);
    localArrayList = localProductExt.selByList("SEL_PRODUCT_BY_CUST_CLASS_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public int getProductList(String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    try
    {
      localProductExt.setParam(":VCUST_ID", paramString);
      localArrayList = localProductExt.selByList("SEL_ALL_PRODUCTLIST");
    }
    catch (RuntimeException localRuntimeException)
    {
      this.log.LOG_INFO(localRuntimeException.getMessage());
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList genProduct()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localArrayList = localProductExt.selByList("SEL_BY_LIMIT_14");
    return localArrayList;
  }

  public String getCustAttachPath(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    Attachinfo localAttachinfo = new Attachinfo();
    String str = localAttachinfo.getAttachPath(paramString1, paramString2, "0");
    return str;
  }

  public ArrayList getproductListByLimit(String paramString, int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_BY_CUST_LIMIT", 0, paramInt);
    return localArrayList;
  }

  public ArrayList getProductByClassId(int paramInt1, int paramInt2, String paramString)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getProductByStock方法");
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCLASS_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_PRODUCT_BY_CLASS_ID", paramInt1, paramInt2);
    this.log.LOG_INFO("退出getProductByStock方法");
    return localArrayList;
  }

  public int getProductByClassId(String paramString)
    throws SaasApplicationException
  {
    int i = 0;
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCLASS_ID", paramString);
    ArrayList localArrayList = localProductExt.selByList("SEL_PRODUCT_BY_CLASS_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = localArrayList.size();
    return i;
  }

  public ArrayList getNewsProductForIndex(int paramInt)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localArrayList = localProductExt.selByList("SEL_NEW_PRODUCT_FOR_INDEX", 0, paramInt);
    return localArrayList;
  }

  public ArrayList getProductInfoByClassId(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString1);
    localProductExt.setParam(":VPRODUCT_CLASS", paramString2);
    if ((paramString2 == "000000000000000") || (paramString2.equals("000000000000000")))
      localArrayList = localProductExt.selByList("SEL_ALL_PRO", paramInt, 10);
    else
      localArrayList = localProductExt.selByList("SEL_BY_CLASS", paramInt, 10);
    return localArrayList;
  }

  public int getProductInfoByClassId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString1);
    localProductExt.setParam(":VPRODUCT_CLASS", paramString2);
    if ((paramString2 == "000000000000000") || (paramString2.equals("000000000000000")))
      localArrayList = localProductExt.selByList("SEL_ALL_PRO");
    else
      localArrayList = localProductExt.selByList("SEL_BY_CLASS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getProductBySearch(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    this.log.LOG_INFO(paramString1 + "==============" + paramString2);
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_NAME", "%" + paramString1 + "%");
    localProductExt.setParam(":VAREA", "%" + paramString2 + "%");
    localArrayList = localProductExt.selByList("SEL_PRODUCT_BY_SEARCH", paramInt1, paramInt2);
    return localArrayList;
  }

  public int getProductBySearch(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_NAME", "%" + paramString1 + "%");
    localProductExt.setParam(":VAREA", "%" + paramString2 + "%");
    localArrayList = localProductExt.selByList("SEL_PRODUCT_BY_SEARCH");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void delProductInfoCUST(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入deleteProductAttrInfo方法...");
    int i = -1;
    String str = paramBuffers.getString("CUST_ID");
    try
    {
      i = delProductInfoCUST(str);
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
    this.log.LOG_INFO("退出deleteProductAttrInfo方法...");
  }

  public void DeleteprodectInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入DeleteSaleInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("cust_id");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = delProductInfoCUST(str2);
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
    this.log.LOG_INFO("退出DeleteSaleInfo方法...");
  }

  public int delProductInfoCUST(String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString);
    this.tradeQuery.executeBy(localProductExt.insBy("STATE_DELETE_PRODUCT"));
    return 0;
  }

  public void reloadProductInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入reloadProductInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PRODUCT_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = reloadProductInfo2(str2);
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
    this.log.LOG_INFO("退出reloadProductInfo方法...");
  }

  public int reloadProductInfo2(String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_ID", paramString);
    this.log.LOG_INFO("product_id==" + paramString + "**5666666666");
    this.tradeQuery.executeBy(localProductExt.insBy("RELOAD_STOCK_BY_PRODUCT_ID"));
    return 0;
  }

  public void deleteProductInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteProductInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PRODUCT_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = deleteProductInfo2(str2);
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
    this.log.LOG_INFO("退出deleteProductInfo方法...");
  }

  public int deleteProductInfo2(String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_ID", paramString);
    this.tradeQuery.executeBy(localProductExt.insBy("DRLETE_STOCK_BY_PRODUCT_ID"));
    return 0;
  }

  public ArrayList getProductInfoByLIKE(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString1);
    localProductExt.setParam(":VPRODUCT_NAME", "%" + paramString2 + "%");
    localArrayList = localProductExt.selByList("SEL_BY_CUST_LIMIT_LIKE_NAME", paramInt, 20);
    return localArrayList;
  }

  public int getProductInfoByLIKE(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString1);
    localProductExt.setParam(":VPRODUCT_NAME", "%" + paramString2 + "%");
    localArrayList = localProductExt.selByList("SEL_BY_CUST_LIMIT_LIKE_NAME");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public ArrayList getSearchProductInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSearchSaleInfo方法");
    if (paramInt1 > 1)
      paramInt1 = (paramInt1 - 1) * paramInt2;
    else
      paramInt1 = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt3);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VKEY", "%" + paramString1 + "%");
    localProductExt.setParam(":VPRO", "%" + paramString2 + "%");
    localProductExt.setParam(":VCITY", "%" + paramString3 + "%");
    localProductExt.setParam(":VDATE", str);
    if ((paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localProductExt.selByList("SEL_NO_PRO_CITY_S", paramInt1, paramInt2);
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt3 != 365))
      localArrayList = localProductExt.selByList("SEL_NO_CITY_S", paramInt1, paramInt2);
    else if ((paramInt3 == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localProductExt.selByList("SEL_NO_DATE_S", paramInt1, paramInt2);
    else
      localArrayList = localProductExt.selByList("SEL_BY_KEY_S", paramInt1, paramInt2);
    this.log.LOG_INFO("getSearchProductInfo方法");
    return localArrayList;
  }

  public int getSearchProductInfo(String paramString1, String paramString2, String paramString3, int paramInt)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getSearchSaleInfo方法");
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -paramInt);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(localCalendar.getTime());
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VKEY", "%" + paramString1 + "%");
    localProductExt.setParam(":VPRO", "%" + paramString2 + "%");
    localProductExt.setParam(":VCITY", "%" + paramString3 + "%");
    localProductExt.setParam(":VDATE", str);
    if ((paramString2.equals("")) && (paramInt != 365))
      localArrayList = localProductExt.selByList("SEL_NO_PRO_CITY_S");
    else if ((paramString3.equals("")) && (!paramString2.equals("")) && (paramInt != 365))
      localArrayList = localProductExt.selByList("SEL_NO_CITY_S");
    else if ((paramInt == 365) && (!paramString2.equals("")) && (!paramString3.equals("")))
      localArrayList = localProductExt.selByList("SEL_NO_DATE_S");
    else
      localArrayList = localProductExt.selByList("SEL_BY_KEY_S");
    if ((null != localArrayList) && (localArrayList.size() > 0))
      i = localArrayList.size();
    this.log.LOG_INFO("退出getSearchProductInfo方法....");
    return i;
  }

  public ArrayList getAllProductInfoByIdForMum(int paramInt, String paramString)
    throws SaasApplicationException
  {
    paramInt *= 20;
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_ALL_BY_CUST_LIMIT_FOR_MUN", paramInt, 20);
    return localArrayList;
  }

  public int getAllProductInfoByIdForMum(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VCUST_ID", paramString);
    localArrayList = localProductExt.selByList("SEL_ALL_BY_CUST_LIMIT_FOR_MUN");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return localArrayList.size();
    return 0;
  }

  public void changProductInfoForReMen(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入changProductInfoForReMen方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("PRODUCT_ID");
    String str2 = paramBuffers.getString("PRODUCT_TYPE");
    try
    {
      i = changProductInfoForReMen(str1, str2);
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
    this.log.LOG_INFO("退出changProductInfoForReMen方法...");
  }

  public int changProductInfoForReMen(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_ID", paramString1);
    localProductExt.setParam(":VPRODUCT_TYPE", paramString2);
    this.tradeQuery.executeBy(localProductExt.insBy("UPDATE_PRODUCT_BY_IDS_FOR_RE_MEN"));
    return 0;
  }

  public void delProductById(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delProductById方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PRODUCT_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = delProductById(str2);
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
    this.log.LOG_INFO("退出delProductById方法...");
  }

  public int delProductById(String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_ID", paramString);
    this.tradeQuery.executeBy(localProductExt.insBy("DELETE_PRODUCT"));
    return 0;
  }

  public void rePublish(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入delProductById方法...");
    int i = -1;
    String str1 = paramBuffers.getString("PRODUCT_ID");
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      String str2 = "";
      while (localStringTokenizer.hasMoreTokens())
      {
        str2 = localStringTokenizer.nextToken();
        i = rePublicsh(str2);
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
    this.log.LOG_INFO("退出delProductById方法...");
  }

  public int rePublicsh(String paramString)
    throws SaasApplicationException
  {
    ProductExt localProductExt = new ProductExt();
    localProductExt.setParam(":VPRODUCT_ID", paramString);
    this.tradeQuery.executeBy(localProductExt.insBy("REPUBLIC_PRODUCT"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.productMgr.ProductInfo
 * JD-Core Version:    0.6.0
 */