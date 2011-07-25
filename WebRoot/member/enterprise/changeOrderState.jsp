<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="com.saas.biz.shoppingorderMgr.ShoppingOrderInfo"%>
<%
	String trade_id = "";
	if (request.getParameter("trade_id") != null) {
		trade_id = request.getParameter("trade_id");
	}
	String 	order_type = bean.getSelectItems("113");
	
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
		<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>修改订单状态</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
					
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
		<table width="800" border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
			<%
				if (list != null || list.size() > 0) {
						HashMap map = (HashMap) list.get(0);
						if (map.get("order_type") != null) {
							order_type = map.get("order_type").toString();
						}
						order_type=bean.getItemsBySelected("113",order_type);
					
			%>
			<tr>
				<td
					style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;"
					align=right width=15%>
					订单状态
				</td>
				<td
					style="background-color:#ffffff; color:#000000;  font-size:12px;"
					align=left width=85%>
					<select id="order_type" name="order_type">
						<%=order_type%>
					</select>
					<input type="hidden" id="trade_type_code" name="trade_type_code" value="6005">
					<input type="hidden" id="trade_id" name="trade_id" value="<%=trade_id%>">
					<input type="hidden" id="oper_user_id" name="oper_user_id" value="">
					<input type="hidden" id="in_date" name="in_date" value="">
				</td>
			</tr>
			<tr>
				<td align="center"
					style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;"
					colspan="2">
					<img src="/admin/images/tj.gif" onclick="changeOrderStatechick()" style="cursor: hand;"> 
					
				</td>
			</tr>
			<%
				}  
			%>
		</table>
	  </form>
	</body>
</html>



