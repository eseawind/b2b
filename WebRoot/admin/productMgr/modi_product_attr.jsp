<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.productMgr.*"%>
<%@ page import="com.saas.biz.newproductattrMgr.*"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="att" class="com.saas.biz.attachMgr.Attachinfo" scope="page" />
<%
	HttpSession logsession = request.getSession();
	String product_id = "", cust_id = "";
	product_id = bean.GenTradeId();
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("product_id") != null) {
		product_id = request.getParameter("product_id");
	}
	String file_path="";
	ArrayList listatt = att.getAttachInfoByList(product_id);
	if(null != listatt){
		HashMap mp = (HashMap)listatt.get(0);
		if(mp.get("file_path")!=null){
			file_path = mp.get("file_path").toString();
		}		
	}
	if(file_path==null || file_path.equals("")){
		file_path="/images/cpwu.gif";
		}
	
	NewProductAttrInfo group = new NewProductAttrInfo();
	ArrayList tableList = group.getProductById(product_id);
	
  String product_name = "",product_type="", product_abstract = "", product_desc = "", product_site = "", product_unit = "", validity = "", remark = "";
  String product_unit_value="";
	ProductInfo groups = new ProductInfo();
	ArrayList list = groups.getProductInfo( product_id);
	String productType = ""; comm.getSelectItems("84");	
	String cust_name="";
	HashMap maps = new HashMap();
	if(list!=null && list.size()>0)
	{
		maps = (HashMap) list.get(0);		
		
		if(maps.get( "cust_name" ) != null)
		{
			cust_name = maps.get( "cust_name" ).toString();
		}
		
		if( maps.get( "product_name" ) != null )
		{
			product_name = maps.get( "product_name" ).toString();
		}
		if( maps.get( "product_type" ) != null )
		{
			product_type = maps.get( "product_type" ).toString();
			productType = comm.getItemsBySelected("84",product_type);
		}
		if( maps.get( "product_abstract" ) != null )
		{
			product_abstract = maps.get( "product_abstract" ).toString();
		}
		if( maps.get( "product_desc" ) != null )
		{
			product_desc = maps.get( "product_desc" ).toString();
		}
		if( maps.get( "product_site" ) != null )
		{
			product_site = maps.get( "product_site" ).toString();
		}
		if( maps.get( "product_unit" ) != null )
		{
			product_unit = maps.get( "product_unit" ).toString();
			product_unit_value = comm.getParaCode2ByParaCode1("91", product_unit);
		}
		if( maps.get( "validity" ) != null )
		{
			validity = maps.get( "validity" ).toString();
			if( validity.length() > 10 )
			{
				validity = validity.substring( 0,10 );
			}
		}
		if( maps.get( "remark" ) != null )
		{
			remark = maps.get( "remark" ).toString();
		}
	}
	String unit = comm.getSelectItems("91");
	int size = 0;
	
	String class_id = "";
	if (request.getParameter("class_id") != null) {
		class_id = request.getParameter("class_id").toString();
	}
	
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script src="/www/fuction/calendar.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="modi_productInfo.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductAttrInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script src="/js/productMgr.js" type="text/javascript"></script>
		<style type="text/css">
.Tree-Img {
	background-image: url(/images/org.png) !important;
}

.root-Img {
	background-image: url(/images/home.png) !important;
}
</style>
	</head>
	<body>
	  <table width=100% border="0" cellpadding="5" cellspacing="1" align="center" bgcolor="#dddddd" >
							<tr>
								<td width="20%" align=right style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
									产品名称：</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" colspan="3">
								<%=product_name%>
								</td>
							</tr>
							
							<tr>
								<td align=right style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
									公司名称：								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" colspan="3">
									<div ><a href="/member/customerMgr/companyIntroduction.jsp?obj_cust_id=<%=cust_id%>"><%=cust_name%></a></div>
								</td>
							</tr>
							<tr>
								<td align=right style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
									产品描述：								</td>
								<td align="left" bgcolor="#FFFFFF" colspan="3">
									<div ><%=product_desc%></div>
								</td>
							</tr>
							<tr>
								<td align=right style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
									产品生产地：								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;">
									<div><%=product_site%></div>
								</td>
							</tr>
							<tr>
								<td align=right style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
									有效时间：								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" colspan="3">
									<div ><%=validity%></div>
								</td>
							</tr>
							<tr>
								<td align=right style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
									图片：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;">
									<img src="<%=file_path%>" border=0 width="100" height="100">
								</td>
							</tr>
							
							<tr>
								<td align=right style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
									备注：	</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;"  >
									<div><%=remark%></div>
								</td>
							</tr>
							
						<tr bgcolor="white">
							<td colspan="4" align="center">
								<img src="/admin/images/comeback.JPG" onclick="javascript:history.go(-1);" style="cursor:hand">
								</td>
							</tr>
		</table>
	</body>
</html>




