<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%@ page import="com.saas.biz.shoppingorderMgr.ShoppingOrderInfo;"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
	HttpSession logsession = request.getSession();
	String user_id = "";
	String iStart = "1";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}

	ShoppingOrderInfo orderinfo = new ShoppingOrderInfo();
	ArrayList orderList = orderinfo.getOrderList(Integer.valueOf(iStart).intValue(), user_id);
	int counter = orderinfo.getOrderList(user_id);
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "myorder.jsp?iStart=", Integer.parseInt(iStart));
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type='text/javascript' src='/js/stockMgr.js'></script>
		<style type="text/css">
.line6 {
	width: 72spx;
	width: 70spx !important;
	border: #ffcb99 1px solid;
	background-color: #fff8ee;
	text-align: left;
	padding-left: 20px;
	padding-top: 10px;
	padding-bottom: 10px;
	color: #000000;
	margin-top: 13px;
}  /*横栏样式6---- 头部提醒1*/
.line6 .img {
	width: 53px;
	height: 53px;
	float: left;
	margin-right: 20px;
}

.line6 .title {
	font-size: 14px;
	font-weight: bold;
	color: #ff5400;
}

.line1 {
	border-left: #ff7300 3px solid;
	background-color: #e2e2e2;
	color: #333333;
	text-align: left;
	font-size: 12px;
} /*横栏样式1*/
</style>

	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="13"></td>
			</tr>
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
							<td class="line1" style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								编号
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								商品名
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								价格
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								数量
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								时间
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								商家
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								状态
							</td>
						</tr>
						<%
								if (orderList != null && orderList.size() > 0) {
								for (Iterator it = orderList.iterator(); it.hasNext();) {
									HashMap map = (HashMap) it.next();
									String cust_id = "";
									String trade_id = "";
									String sale_id = "";
									String discount = "";
									String num = "";
									String order_type= "";
									String oper_date = "";
									if (map.get("cust_id") != null) {cust_id = map.get("cust_id").toString();}
									Custinfo custinfo = new Custinfo();
									String cust_name = custinfo.getCustName(cust_id);
									if (map.get("trade_id") != null) {trade_id = map.get("trade_id").toString();}
									if (map.get("sale_id") != null) {sale_id = map.get("sale_id").toString();}
									SaleInfo saleinfo = new SaleInfo();
									String title = saleinfo.getProName(sale_id);
									if (map.get("discount") != null) {discount = map.get("discount").toString();}
									if (map.get("num") != null) {num = map.get("num").toString();}
									if (map.get("order_type") != null) {
										order_type = map.get("order_type").toString();
									}
									
									if (order_type == "1" || order_type.equals("1")){
										order_type = "未付款";
									}else if (order_type == "2" || order_type.equals("2")){
										order_type = "已付款,送货中";
									}else if (order_type == "3" || order_type.equals("3")){
										order_type = "已付款,已送货";
									}else if (order_type == "4" || order_type.equals("4")){
										order_type = "未付款,送货中";
									}
									
									if (map.get("oper_date") != null) {oper_date = map.get("oper_date").toString();}
						%>
						<tr style="background-color: #f9f9f9;">
							<td style="color: #000000;" align=left><%=trade_id%></td>
							<td style="color: #000000;" align=center><%=title%></td>
							<td style="color: #000000;" align=center><%=discount%></td>
							<td style="color: #000000;" align=center><%=num%></td>
							<td style="color: #000000;" align=center><%=oper_date%></td>
							<td style="color: #000000;" align=center><%=cust_name%></td>
							<td style="color: #000000;" align=center><%=order_type%></td>
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



