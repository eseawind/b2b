<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%@ page import="com.saas.biz.enquirydealMgr.EnquirydInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "1";
	String keyword ="",code="";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("keyword") != null) {
		keyword = request.getParameter("keyword");
	}
	if (request.getParameter("code") != null) {
		code = request.getParameter("code");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	
	
	EnquirydInfo enqinfo = new EnquirydInfo();
	ArrayList enqList = new ArrayList();
	int counter = 0;
	if (code == "1" && code.equals("1")){
		enqList = enqinfo.getEnquiryByCartAndSale(Integer.valueOf(iStart).intValue(),cust_id ,keyword);
		counter = enqinfo.getEnquiryByCartAndSale(cust_id , keyword);
	}else{
		enqList = enqinfo.getEnquiryByCart(Integer.valueOf(iStart).intValue(),cust_id);
		counter = enqinfo.getEnquiryByCart(cust_id);
	}
	
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "enquiry.jsp?iStart=", Integer.parseInt(iStart));
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/enterprise.js"></script>
<style type="text/css">
	.chaxun{
			background:url(/images/chaxun.gif) left center no-repeat;
			width:70px;
		 	height:26px;
			border:0px; 
		 	cursor:hand;
		}
</style>

	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="13"></td>
			</tr>
			<div>
			<form action="watchUserOrder.jsp" method="post" name="orderform">
				<table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
					<tr>
						<td>
							商品名:<input type="text" id="keyword" name="keyword" >
							<input class="chaxun" type="button" name="comit" value="" onclick="return enquiryCheck_Value()" style="cursor: hand;">
							<input type="hidden" name="code" id="code" value="1">
						</td>
					</tr>
				</table>
			</form>
			</div>
			<div>
			<table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
				<tr>
					<td width="2" background="/images/kehu_list_03.gif" height="8"></td>
					<td width="704" background="/images/kehu_list_04.gif" height="8"></td>
					<td width="2" background="/images/kehu_list_06.gif" height="8"></td>
				</tr>
			</table>
			</div>
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
						<tr>
							<td class="line1" style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="30%">
								商品名	
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								标题
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								发布人
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								发布时间
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								操作
							</td>
						</tr>
						<%
								if (enqList != null && enqList.size() > 0) {
								for (Iterator it = enqList.iterator(); it.hasNext();) {
									HashMap map = (HashMap) it.next();
									String trade_id = "";
									String sale_id = "",enquiry_date="";
									String rsrv_str3="",rsrv_str5="";
									if (map.get("trade_id") != null) {trade_id = map.get("trade_id").toString();}
									if (map.get("sale_id") != null) {sale_id = map.get("sale_id").toString();}
									SaleInfo info = new SaleInfo();
						 			String title = info.getProName(sale_id);
									if (map.get("enquiry_date") != null) {enquiry_date = map.get("enquiry_date").toString();}
									if (map.get("rsrv_str3") != null) {rsrv_str3 = map.get("rsrv_str3").toString();}
									if (map.get("rsrv_str5") != null) {rsrv_str5 = map.get("rsrv_str5").toString();}
									
						%>
						<tr style="background-color: #f9f9f9;">
							<td style="color: #000000;" align=left><%=title%></td>
							<td style="color: #000000;" align=center><a href="/zone_b2c/enterprise/enqInfo.jsp?trade_id=<%=trade_id%>" target="_blank"><%=rsrv_str3%></a></td>
							<td style="color: #000000;" align=center><%=rsrv_str5%></td>
							<td style="color: #000000;" align=center><%=enquiry_date%></td>
							<td style="color: #000000;" align=center>
								<a href="/zone_b2c/enterprise/answer.jsp?trade_id=<%=trade_id%>" target="_blank"><img src="/admin/images/add.gif" height="16" width="16" border="0" alt="回复"></a>&nbsp;&nbsp;
								<a href="/doTradeReg.do?trade_type_code=1321&trade_id=<%=trade_id%>"><img src="/admin/images/delete.gif" height="16" width="16" border="0" alt="删除"></a>
							</td>
						</tr>
						<%
						}
						%>
						<tr>
							<%=pageTools%>
						</tr>
						<%
						}
						%>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>


