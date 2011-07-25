<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%@page pageEncoding="gbk"%>
<%
	request.setCharacterEncoding("gbk");
%>
<%
	HttpSession logsession = request.getSession();

	String cust_id = "";
	String iStart = "1";
	String keyword = "", code = "";
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

	SaleInfo saleInfo = new SaleInfo();
	ArrayList enqList = new ArrayList();
	int counter = 0;

	if (code.equals("1")){
		enqList = saleInfo.genOneSaleByTitle(Integer.valueOf(iStart).intValue(), cust_id, keyword);
		counter = saleInfo.genOneSaleByTitle(cust_id,keyword);
	}else{
		enqList = saleInfo.gentSalesByMemeberCust_id(Integer.valueOf(iStart).intValue(), cust_id,"0");
		counter = saleInfo.gentSalesByMemeberCust_id(cust_id,"0");
	}

	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "findWareHouesMgr.jsp?keyword="+keyword+"&iStart=", Integer.parseInt(iStart));
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/enterprise.js"></script>
		<style type="text/css">
	.chaxun{
			background:url(/admin/images/chaxun.gif) left center no-repeat;
			width:70px;
		 	height:26px;
			border:0px; 
		 	cursor:hand;
		}
</style>

	</head>
	<body>


		<form action="findWareHouesMgr.jsp" method="post" name="orderform">
			<%
				String top_menu_id = "";
				if (request.getParameter("menu_id") != null) {
					top_menu_id = request.getParameter("menu_id");
				}
			%>
		
			<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
				<tr class="u2">
					<td>
						请输入要查找的商品名:
						<input type="text" id="keyword" name="keyword">
						<input class="chaxun" type="button" name="comit" value="" onclick="return enquiryCheck_Value()" style="cursor: hand;">
						<input type="hidden" name="code" id="code" value="1">
					</td>
				</tr>
			</table>
		</form>


		<table width=100% align="center" cellpadding="1" cellspacing="1" border="0" bgcolor="#E6F6E9">
			<tr class="u4" height="25">
				<td align=left width="25%">
					供应商品
				</td>
				<td  align=left width="15%">
					地址
				</td>
				<td  align=left width="10%">
					售价
				</td>
				<td align=left width="10%">
					数量
				</td>
				<td  align=left width="9%">
					运费
				</td>
				<td   align=center width="15%">
					修改库存量
				</td>

			</tr>
			<%
					if (enqList != null && enqList.size() > 0) {
					for (Iterator it = enqList.iterator(); it.hasNext();) {
						HashMap map = (HashMap) it.next();
						String title11 = "";
						String sale_addr = "";
						String sale_price = "";
						String sale_num = "";
						String start_time = "";
						String end_time = "";
						String carriage_pay = "";
						String sale_id="";
						if (map.get("sale_id") != null) {
							sale_id = map.get("sale_id").toString();
						}
						if (map.get("title") != null) {
							title11 = map.get("title").toString();
						}
						if (map.get("sale_addr") != null) {
							sale_addr = map.get("sale_addr").toString();
						}
						if (map.get("sale_price") != null) {
							sale_price = map.get("sale_price").toString();
						}
						if (map.get("sale_num") != null) {
							sale_num = map.get("sale_num").toString();
						}
						if(sale_num.equals("")){
							sale_num = "0";
						}
						if (map.get("start_date") != null) {
							start_time = map.get("start_date").toString();
							start_time = start_time.substring(0, 10);
						}
						if (map.get("end_date") != null) {
							end_time = map.get("end_date").toString();
							end_time = end_time.substring(0, 10);
						}
						if (map.get("carriage_pay") != null) {
							carriage_pay = map.get("carriage_pay").toString();
						}
						if(carriage_pay.equals("")){
							carriage_pay = "0";
						}
			%>
			<tr class="u2">
				<td align="left">
					<a href="/member/enterprise/viewsaleinfo1.jsp?sale_id=<%=sale_id%>"><%=title11%></a>
				</td>
				<td align="left">
					<%=sale_addr%>
				</td>
				<td  align=left>
					<%=sale_price%>
				</td>
				<td  align=left>
					<%=sale_num%>
				</td>
				<td align=left>
					<%=carriage_pay%>
				</td>
				<td align=center>
					<a href="/member/enterprise/updateSaleNum.jsp?sale_id=<%=sale_id%>"><img src="/images/edit.png" border="0"/></a>
				</td>
			</tr>
			<%
			}
			%>
			<tr class="u1">
				<%=pageTools%>
			</tr>
			<%
			}else{
						%>
						<tr align=center ><td colspan="7">暂无记录!</td></tr>
						<%}%>
		</table>
	</body>
</html>



