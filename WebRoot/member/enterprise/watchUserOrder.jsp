<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.shoppingorderMgr.ShoppingOrderInfo;"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
       request.setCharacterEncoding("gbk");
        String code1="",keyword="";
        if (request.getParameter("code1") != null) {
		code1 = request.getParameter("code1");
	}
	out.println("------------------------------>"+code1);
	if (request.getParameter("keyword") != null) {
		keyword = request.getParameter("keyword");
	}
	out.println(keyword);
%>
<%
  
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "1";
	String start_date ="",end_date ="",code="";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("start_date") != null) {
		start_date = request.getParameter("start_date");
	}
	if (request.getParameter("end_date") != null) {
		end_date = request.getParameter("end_date");
	}
	if (request.getParameter("code") != null) {
		code = request.getParameter("code");
	}
	
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
		
	Calendar cal = Calendar.getInstance();
	String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String end_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	
	ShoppingOrderInfo orderinfo = new ShoppingOrderInfo();
	ArrayList orderList = new ArrayList();
	int counter = 0;
	/********
	*
	*      
	*******/
	if(code1=="1"||code1.equals("1"))
	{
	       //orderList=orderinfo.getLikeListByKey(cust_id,keyword);
     }else{
	if (code == "1" || code.equals("1")){
		orderList = orderinfo.getAllOrderListByDate(Integer.valueOf(iStart).intValue(),cust_id ,start_date , end_date);
		counter = orderinfo.getAllOrderListByDate(cust_id , start_date , end_date);
	}else{
		orderList = orderinfo.getAllOrderList(Integer.valueOf(iStart).intValue(),cust_id);
		counter = orderinfo.getAllOrderList(cust_id);
	}
	}
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "watchUserOrder.jsp?iStart=", Integer.parseInt(iStart));
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
							开始时间:<input type="text" id="start_date" name="start_date" onfocus="setday(this);" value="<%=start_Date%>">
							结束时间:<input type="text" id="end_date" name="end_date" onfocus="setday(this);" value="<%=end_Date%>">
							<input class="chaxun" type="button" name="comit" value="" onclick="return otherTotalOrderCheck_Value()" style="cursor: hand;">
							<input type="hidden" name="code" id="code" value="1">
						</td>
					</tr>
				</table>
			</form>
			</div>
			<div>
			<form action="watchUserOrder.jsp" method="post" name="orderform1">
				<table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
					<tr>
						<td>
							关键字:<input type="text" id="keyword" name="keyword"  value="请输入关键字">
							<input class="chaxun" type="button" name="comit" value="" onclick="return watchUserOrderCheck_Key()" style="cursor: hand;">
							<input type="text" name="code1" id="code1" value="1">
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
							<td class="line1" style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								订单编号asdasdfasdfadfaf
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								购买用户
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								联系电话
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								配送地区
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								配送时间
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								配送方式
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								总金额
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								运输费用
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								订单状态
							</td>
						</tr>
						<%
								if (orderList != null && orderList.size() > 0) {
								for (Iterator it = orderList.iterator(); it.hasNext();) {
									HashMap map = (HashMap) it.next();
									String user_id = "",carriage_pay="";
									String trade_id = "";
									String phone = "",sum_money="",deliver_type="";
									String province="", eparchy_code="", city="";
									String order_type= "";
									String oper_date = "";
									if (map.get("phone") != null) {phone = map.get("phone").toString();}
									if (map.get("user_id") != null) {user_id = map.get("user_id").toString();}
									UserInfo userinfo = new UserInfo();
									String user_name = userinfo.getUserName(user_id);
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
									}
									if (order_type == "1" || order_type.equals("1")){
										order_type = "未付款";
									}else if (order_type == "2" || order_type.equals("2")){
										order_type = "未付款,送货中";
									}else if (order_type == "3" || order_type.equals("3")){
										order_type = "已付款,送货中";
									}else if (order_type == "4" || order_type.equals("4")){
										order_type = "已付款,已送货";
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
						<tr style="background-color: #f9f9f9;">
							<td style="color: #000000;" align=left><a href="/zone_b2c/enterprise/orderList.jsp?trade_id=<%=trade_id%>" target="_blank"><%=trade_id%></a></td>
							<td style="color: #000000;" align=center><%=user_name%></td>
							<td style="color: #000000;" align=center><%=phone%></td>
							<td style="color: #000000;" align=center><%=province_name%>&nbsp;&nbsp;<%=eparchy_code_name%>&nbsp;&nbsp;<%=city_name%></td>
							<td style="color: #000000;" align=center><%=oper_date%></td>
							<td style="color: #000000;" align=center><%=deliver_type%></td>
							<td style="color: #000000;" align=center><%=sum_money%></td>
							<td style="color: #000000;" align=center><%=carriage_pay%>
							<a href="modiOrderMoney.jsp?trade_id=<%=trade_id%>" target="_blank">
							<img src="/admin/images/mid-03.gif" border="0" height="15" width="16" alt="修改运费"></a></td>
							<td style="color: #000000;" align=center><a href="changeOrderState.jsp?trade_id=<%=trade_id%>" target="_blank"><%=order_type%></a></td>
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


