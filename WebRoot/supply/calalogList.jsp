<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="classInfo" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%
	String class_id = "", class_type = "", paran = "", info_msg = "", includePage = "", iStart = "1", infoClass = "";
	//class_type=0 企业分类 class_type=4 采购分类  class_type=5 销售分类  
	if (request.getParameter("type") != null) {
		class_type = request.getParameter("type").toString();
	}
	if(class_type == "2" || class_type.equals("2")){
		paran = "产品信息列表";
		infoClass = "产品分类";
		info_msg = "&class_id=";
		includePage = "/product/includeProduct.jsp";
	
	}else if (class_type == "3" || class_type.equals("3")) {
		paran = "企业信息列表";
		infoClass = "企业分类";
		info_msg = "&enterprise=1&class_id=";
		includePage = "/enterprise/includeEnterprise.jsp";
	}
	else if (class_type == "4" || class_type.equals("4")) {
		paran = "采购信息列表";
		infoClass = "求购分类";
		info_msg = "&stock=1&class_id=";
		includePage = "/stock/includeStockList.jsp";
	}
	else if (class_type == "5" || class_type.equals("5")) {
		paran = "销售信息列表";
		infoClass = "销售分类";
		info_msg = "&supply=1&class_id=";
		includePage = "/supply/includeSaleList.jsp";
	}
	else {
		includePage = "/inc/left.jsp";
	}
	if (request.getParameter("class_id") != null) {
		class_id = request.getParameter("class_id").toString();
	}
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart").toString();
	}	
	String calalogInfo = classInfo.getCalalogInfo(class_type, class_id, "/supply/calalogList.jsp?type=" + class_type + info_msg);

%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<title> 中国生产商 电子商务平台--<%=paran%>
		</title>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		#login{
			 position: relative;
			 display: none;
	         top: 20px;
	         left: 30px;
	         background-color: #ffffff;
	         text-align: center;
	         border: solid 1px;
	         padding: 10px;
	         z-index: 1;
	   }
		-->
	</style>
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/js/products.js"></script>

	</head>
	<body>
		<jsp:include flush="true" page="/include/top.html" />
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="10"></td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="DCDCDC">
			<tr>
				<td height="25" background="/images/Content_03.gif" bgcolor="#FFFFFF">
					&nbsp;&nbsp;<span style="font-size: 14px;">您当前位置：</span>
					<a href="/" class="lanse">首页</a> > <a href="/supply/calalogList.jsp?type=<%=class_type%><%=info_msg%>000000000000000" class="lanse"><%=infoClass%></a> > <%=calalogInfo%>
				</td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="10"></td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td width="740" valign="top">
					<table border=0 cellpadding=0 cellspacing=0 width="100%">
						<tr>
							<td width="115" height="29" align="center" background="/images/wl_03.jpg" class="wl_btlanse">
								<%=infoClass%>
							</td>
							<td align="right" background="/images/wl_04.jpg" valign="bottom">
								<img src="/images/wl_07.jpg"> 
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="10" cellspacing="1" bgcolor="90ABDF">
						<tr>
							<td bgcolor="FFFFFF">
										<jsp:include flush="true" page="/supply/catalogInclude.jsp">
                    	<jsp:param name="type" value="<%=class_type%>" />                            
                    	<jsp:param name="id" value="<%=class_id%>" />                            
										</jsp:include>
							</td>
						</tr>
					</table>
					<div style="width:740px; margin-top:10px;">
						<jsp:include flush="true" page="<%=includePage%>">
							<jsp:param name="iStart" value="<%=iStart%>" />
							<jsp:param name="class_id" value="<%=class_id%>" />
						</jsp:include>
					</div>
				</td>
				<td valign="top">&nbsp;
					
				</td>
				<td width="228" valign="top">
					<jsp:include flush="true" page="/supply/sale_right.jsp" />
				</td>
			</tr>
		</table>
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>




