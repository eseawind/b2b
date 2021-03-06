<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.shoppingorderMgr.ShoppingOrderInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "1";
	String start_date ="",end_date ="",code="";
	if (request.getParameter("iStart") != null) 
	{
		iStart = request.getParameter("iStart");
	}
	Custinfo custInfo = new Custinfo();
	Calendar cal = Calendar.getInstance();
	end_date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	cal.add(Calendar.DAY_OF_MONTH, -3); 
	start_date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	if (request.getParameter("start_date") != null) 
	{
		start_date = request.getParameter("start_date");
	}
	if (request.getParameter("end_date") != null) 
	{
		end_date = request.getParameter("end_date");
	}
	if (request.getParameter("code") != null) 
	{
		code = request.getParameter("code");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) 
	{
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	ParamethodMgr param = new ParamethodMgr();
	ShoppingOrderInfo orderinfo = new ShoppingOrderInfo();
	ArrayList orderList = new ArrayList();
	int counter = 0;
	if (code == "1" || code.equals("1"))
	{
		orderList = orderinfo.getAllOrderListByDate(Integer.valueOf(iStart).intValue(),cust_id ,start_date , end_date);
		counter = orderinfo.getAllOrderListByDate(cust_id ,start_date , end_date);
	}
	else
	{
		  
	  orderList = orderinfo.getAllOrderList(Integer.valueOf(iStart).intValue(),cust_id );
	  counter = orderinfo.getAllOrderList(cust_id);
	}
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "totalOrder.jsp?iStart=", Integer.parseInt(iStart));
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
		<form action="totalOrder.jsp" method="post" name="orderform">
		<table width="800" border="0" cellspacing="0" cellpadding="0">
			<%
				String top_menu_id="";
				if (request.getParameter("menu_id") != null){
		        top_menu_id = request.getParameter("menu_id");
		    }
			%>
				
				<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
					<tr class="u2">
						<td>
							开始时间:<input type="text" id="start_date" name="start_date" onfocus="setday(this);" value="<%=start_date%>">
							结束时间:<input type="text" id="end_date" name="end_date" onfocus="setday(this);" value="<%=end_date%>">
							<input class="chaxun" type="button" name="comit" value="" onclick="return otherTotalOrderCheck_Value()" style="cursor: hand;">
							<input type="hidden" name="code" id="code" value="1">
						</td>
					</tr>
				</table>
			
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
						<tr class="u4" height="25">
							<td align=left width="10%">
								订单编号
							</td>
							<td align=left width="10%">
								商品名
							</td>
							<td align=left width="10%">
								联系电话
							</td>
							<td align=left width="20%">
								配送地区
							</td>
							<td align=left width="10%">
								配送时间
							</td>
							<td align=left width="10%">
								配送方式
							</td>
							<td align=left width="10%">
								总金额
							</td>
							
							<td align=left width="10%">
								订单状态
							</td>
						</tr>
						<%
								SaleInfo saleinfo = new SaleInfo();
								if (orderList != null && orderList.size() > 0) {
								for (Iterator it = orderList.iterator(); it.hasNext();) {
									HashMap map = (HashMap) it.next();
									String user_id = "",carriage_pay="";
									String trade_id = "",order_cust_id="",order_cust_name="";
									String phone = "",sum_money="",deliver_type="";
									String province="", eparchy_code="", city="",sale_id="",title="";
									String order_type= "";
									String oper_date = "";
									if (map.get("phone") != null) {phone = map.get("phone").toString();}
									if (map.get("sale_id") != null) {
										sale_id = map.get("sale_id").toString();
										title = saleinfo.getProName(sale_id);
									}
									if (map.get("user_id") != null) {user_id = map.get("user_id").toString();}
									if (map.get("cust_id") != null) {
										order_cust_id = map.get("cust_id").toString();
										order_cust_name = custInfo.getCustNameById(order_cust_id);
									}
									UserInfo userinfo = new UserInfo();
									String user_name = userinfo.getUserNameById(user_id);
									if (map.get("trade_id") != null) {trade_id = map.get("trade_id").toString();}
									if (map.get("sum_money") != null) {sum_money = map.get("sum_money").toString();}
									if (map.get("carriage_pay") != null) {carriage_pay = map.get("carriage_pay").toString();}
									if (map.get("deliver_type") != null) {deliver_type = map.get("deliver_type").toString();}
									if (deliver_type == "1" || deliver_type.equals("1")){
										deliver_type = "普通快递送货上门";
									}else if (deliver_type == "2" || deliver_type.equals("2")){
										deliver_type = "普通邮递";
									}else if (deliver_type == "3" || deliver_type.equals("3")){
										deliver_type = "邮政特快专递 EMS";
									}
									
									if (map.get("order_type") != null) {
										order_type = map.get("order_type").toString();
										order_type = param.getParaCode2ByParaCode1("113",order_type);
									}
									
									if (map.get("oper_date") != null) {oper_date = map.get("oper_date").toString();}
									AreaInfo areainfo = new AreaInfo();
									if (map.get("province")!=null){province = map.get("province").toString();}
									String province_name = areainfo.getProvinceList(province);
									if (map.get("eparchy_code")!=null){eparchy_code = map.get("eparchy_code").toString();}
									String eparchy_code_name = areainfo.getProvinceList(eparchy_code);
									if (map.get("city")!=null){city = map.get("city").toString();}
									String city_name = areainfo.getProvinceList(city);
						%>
						<tr class="u2">
							<td align=left><a href="/member/enterprise/orderList.jsp?trade_id=<%=trade_id%>" target="_blank"><%=trade_id%></a></td>
							<td align=left><a href="/supply/saleInquiry.jsp?sale_id=<%=sale_id%>" target="_blank"><%=title%></a></td>
							<td align=left><%=phone%></td>
							<td align=left><%=province_name%>&nbsp;&nbsp;<%=eparchy_code_name%>&nbsp;&nbsp;<%=city_name%></td>
							<td align=left><%=oper_date%></td>
							<td align=left><%=deliver_type%></td>
							<td align=left><%=sum_money%></td>							
							<td align=left><a href="changeOrderState.jsp?trade_id=<%=trade_id%>" target="_blank"><%=order_type%></a></td>
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
						<tr align=center ><td colspan="5">暂无记录!</td></tr>
						<%}%>
					</table>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>


