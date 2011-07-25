<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.shoppingorderMgr.ShoppingOrderInfo"%>
<%
	String trade_id = "";
	if (request.getParameter("trade_id") != null) {
		trade_id = request.getParameter("trade_id");
	}

	String  carriage_pay = "";

	ShoppingOrderInfo orderinfo = new ShoppingOrderInfo();
	ArrayList list = orderinfo.getOrderInfoById(trade_id);
		
%>
<html>
	<head>
		<title>B2B电子商务</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/enterprise.js"></script>
	</head>
	<body>
	<form method="post" action="/doTradeReg.do" name="payform">
		<table width="100%" border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
			<tr>
				<td class="line1" align="left" colspan="2">
					修改订单信息
				</td>
			</tr>
			<%
				if (list != null || list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						HashMap map = (HashMap) list.get(i);
						
						if (map.get("carriage_pay") != null) {
							carriage_pay = map.get("carriage_pay").toString();
						}
					
			%>
			<tr>
				<td
					style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;"
					align=right width=15%>
					运费
				</td>
				<td
					style="background-color:#ffffff; color:#000000;  font-size:12px;"
					align=left width=85%>
					<input type="text" id="carriage_pay" name="carriage_pay" value="<%=carriage_pay%>">
					<input type="hidden" id="trade_type_code" name="trade_type_code" value="6004">
					<input type="hidden" id="trade_id" name="trade_id" value="<%=trade_id%>">
					<input type="hidden" id="oper_user_id" name="oper_user_id" value="">
					<input type="hidden" id="in_date" name="in_date" value="">
				</td>
			</tr>
			<tr>
				<td align="center"
					style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;"
					colspan="2">
					<img src="/admin/images/tj.gif" onclick="modiOrderMoneychick()" style="cursor: hand;"> 
					
				</td>
			</tr>
			<%
					}
				}  
			%>
		</table>
	  </form>
	</body>
</html>



