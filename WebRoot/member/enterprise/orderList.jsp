<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.shoppingorderMgr.ShoppingOrderInfo"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%
	String trade_id = "";
	if (request.getParameter("trade_id") != null) {
		trade_id = request.getParameter("trade_id");
	}

	String  sale_id = "", discount = "", order_type = "", price = "", num = "", money = "",
	  deliver_type = "", pay_type = "", phone = "", cellphone = "",addr = "", consignee = "", province = "",
	  eparchy_code = "", city = "", post_code = "", oper_date = "", carriage_pay = "", sum_money = "";

	ShoppingOrderInfo orderinfo = new ShoppingOrderInfo();
	ArrayList list = orderinfo.getOrderInfoById(trade_id);
		
%>
<html>
	<head>
		<title>B2B��������</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>�鿴������Ϣ</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
		<table width="800" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#dddddd">
			<%
				if (list != null || list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						HashMap map = (HashMap) list.get(i);
						if (map.get("trade_id") != null) {
							trade_id = map.get("trade_id").toString();
						}
						if (map.get("sale_id") != null) {
							sale_id = map.get("sale_id").toString();
						}
						SaleInfo info = new SaleInfo();
						String title = info.getProName(sale_id);
						if (map.get("discount") != null) {
							discount = map.get("discount").toString();
						}
						if (map.get("order_type") != null) {
							order_type = map.get("order_type").toString();
						}
						if (map.get("price") != null) {
							price = map.get("price").toString();
						}
						if (map.get("num") != null) {
							num = map.get("num").toString();
						}
						if (map.get("money") != null) {
							money = map.get("money").toString();
						}
						if (map.get("deliver_type") != null) {
							deliver_type = map.get("deliver_type").toString();
						}
						if (map.get("pay_type") != null) {
							pay_type = map.get("pay_type").toString();
						}
						if (map.get("phone") != null) {
							phone = map.get("phone").toString();
						}
						if (map.get("cellphone") != null) {
							cellphone = map.get("cellphone").toString();
						}
						if (map.get("addr") != null) {
							addr = map.get("addr").toString();
						}
						if (map.get("consignee") != null) {
							consignee = map.get("consignee").toString();
						}
						if (map.get("province") != null) {
							province = map.get("province").toString();
						}
						if (map.get("eparchy_code") != null) {
							eparchy_code = map.get("eparchy_code").toString();
						}
						if (map.get("city") != null) {
							city = map.get("city").toString();
						}
						if (map.get("post_code") != null) {
							post_code = map.get("post_code").toString();
						}
						if (map.get("oper_date") != null) {
							oper_date = map.get("oper_date").toString();
						}
						if (map.get("carriage_pay") != null) {
							carriage_pay = map.get("carriage_pay").toString();
						}
						if (map.get("sum_money") != null) {
							sum_money = map.get("sum_money").toString();
						}
						AreaInfo areainfo = new AreaInfo();
						String province_name = areainfo.getProvinceList(province);
						String eparchy_code_name = areainfo.getProvinceList(eparchy_code);
						String city_name = areainfo.getProvinceList(city);
						if (deliver_type == "1" || deliver_type.equals("1")){
							deliver_type = "��ͨ����ͻ�����";
						}else if (deliver_type == "2" || deliver_type.equals("2")){
							deliver_type = "��ͨ�ʵ�";
						}else if (deliver_type == "3" || deliver_type.equals("3")){
							deliver_type = "�����ؿ�ר�� EMS";
						}
						
						if (pay_type == "1" || pay_type.equals("1")){
							pay_type = "����֧��";
						}else if (pay_type == "2" || pay_type.equals("2")){
							pay_type = "֧����";
						}else if (pay_type == "3" || pay_type.equals("3")){
							pay_type = "��������";
						}else if (pay_type == "4" || pay_type.equals("4")){
							pay_type = "�ʾֻ��";
						}
						
						if (order_type == "1" || order_type.equals("1")){
							order_type = "δ����";
						}else if (order_type == "2" || order_type.equals("2")){
							order_type = "δ����,�ͻ���";
						}else if (order_type == "3" || order_type.equals("3")){
							order_type = "�Ѹ���,�ͻ���";
						}else if (order_type == "4" || order_type.equals("4")){
							order_type = "�Ѹ���,���ͻ�";
						}
			%>
			<tr>
				<td class="u1">
					<div class="ping1">
					�������
				</div>
				</td>
				<td
					class="u2" colspan="3">
					<span style="color: red"><%=trade_id%></span>
				</td>
			</tr>
			<tr>
				<td class="u1">
					<div class="ping1">
					��Ʒ��Ϣ
					<div>
				</td>
				<td class="u2"colspan="3">
					<table width="100%" border=0 cellpadding=2 cellspacing=1 align=left bgcolor="#e7e7e7">
						<tr>
							<td class="u1">
								��Ʒ��
							</td>
							<td class="u1">
								����
							</td>
							<td class="u1">
								����
							</td>
							<td class="u1">
								����
							</td>
							<td class="u1">
								�ܼ�
							</td>
							<td class="u1">
								�˷�
							</td>
						</tr>
						<tr style="background-color: #f9f9f9;">
							<td style="color: #000000;" align=left><%=title%></td>
							<td style="color: #000000;" align=center><%=price%>Ԫ</td>
							<td style="color: #000000;" align=center><%=discount%>Ԫ</td>
							<td style="color: #000000;" align=center><%=num%></td>
							<td style="color: #000000;" align=center><%=money%>Ԫ</td>
							<td style="color: #000000;" align=center><%=carriage_pay%></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td
					class="u1">
					<div class="ping1">
					��������
					<div>
				</td>
				<td
					class="u2">
					<%=deliver_type%>
				</td>
				<td
					class="u1">
					<div class="ping1">
					���ʽ
					<div>
				</td>
				<td
				class="u2">
					<%=pay_type%>
				</td>
			</tr>
			<tr>
				<td
					class="u1">
					<div class="ping1">
					�ջ���
					<div>
				</td>
				<td
					class="u2">
					<%=consignee%>
				</td>
				<td
					class="u1">
					<div class="ping1">
					���͵���
					<div>
				</td>
				<td
					class="u2">
					<%=province_name%>&nbsp;&nbsp;<%=eparchy_code_name%>&nbsp;&nbsp;<%=city_name%>
				</td>
			</tr>
			<tr>
				<td
					class="u1">
					<div class="ping1">
					��ϸ��ַ
					<div>
				</td>
				<td
					class="u2">
					<%=addr%>
				</td>
				<td class="u1">
					<div class="ping1">
					�绰
					<div>
				</td>
				<td
					class="u2">
					<%=phone%>
				</td>
			</tr>
			<tr>
				<td
					class="u1">
					<div class="ping1">
					�ֻ�
					<div>
				</td>
				<td
					class="u2">
					<%=cellphone%>
				</td>
				<td
					class="u1">
					<div class="ping1">
					�ʱ�
					<div>
				</td>
				<td
					class="u2">
					<%=post_code%>
				</td>
			</tr>
			<tr>
				<td
					class="u1">
					<div class="ping1">
					�µ�ʱ��
					<div>
				</td>
				<td
					class="u2">
					<%=oper_date%>
				</td>
				<td
					class="u1">
					<div class="ping1">
					�ܽ��
					<div>
				</td>
				<td
				class="u2">
					<%=sum_money%>Ԫ
				</td>
			</tr>
			<tr>
				<td
					class="u1">
					<div class="ping1">
					����״̬
					<div>
				</td>
				<td
					class="u2" colspan="3">
					<span style="color: red"><%=order_type%></span>
				</td>
			</tr>
			<tr>
				<td align="center"
					class="u2"
					colspan="4">
				</td>
			</tr>
			<%
					}
				}  
			%>
			 <tr>
		<td align="center" height="50" bgcolor="#FFFFFF" colspan="6">

				<img src="/admin/images/gb.gif" onclick="javascript:window.open('','_self','');window.close();" style="cursor:hand;">
	  </td>
	</tr>
		</table>
	</body>
</html>



