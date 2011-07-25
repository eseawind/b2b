<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.ordercastMgr.OrderCast"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<%
	String cust_class = "" , info_type = "" ,quo_id ="" ,title="";
	 
	if (request.getParameter("quo_id") != null){
		quo_id = request.getParameter("quo_id");
	}

	String titles = new NewsInfo().getNewsTitleById(quo_id);
	String info_no="",startDay="",endDay="",remark="";
	OrderCast cast = new OrderCast ();
	HashMap map = cast.getCastById(quo_id);
	 
		if (map.get("info_no") != null) {info_no = map.get("info_no").toString();}
		if (map.get("start_date") != null) {startDay = map.get("start_date").toString();}
		if (map.get("end_date") != null) {endDay = map.get("end_date").toString();}
		if (map.get("remark") != null) {remark = map.get("remark").toString();}
		if (map.get("info_title") != null) {title = map.get("info_title").toString();}
		
	 
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<style type="text/css">
.ping_1 {
	font-weight: bold;
	color: black;
}

#tr {
	background-color: #f6f6f6;
	color: #000000;
	font-weight: bold;
	font-size: 12px;
	text-align: center;
}

#tr1 {
	background-color: #f6f6f6;
	color: #000000;
	font-size: 12px;
}

#tr2 {
	background-color: #ffffff;
	color: #000000;
	font-size: 12px;
}
</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		  function check_Value(){
		 	if (document.castForm.info_no.value == ""||document.castForm.info_no.value == null)
			{
				alert("信息名次不可以为空！");
				document.castForm.info_no.focus(); 
				return false;
			}
			if (document.castForm.start_date.value == ""||document.castForm.start_date.value == null)
			{
				alert("开始时间不可以为空！");
				document.castForm.start_date.focus(); 
				return false;
			}
			if (document.castForm.end_date.value == ""||document.castForm.end_date.value == null)
			{
				alert("结束时间不可以为空！");
				document.castForm.end_date.focus(); 
				return false;
			}
			if(!checkDate(document.castForm.start_date.value,document.castForm.end_date.value)){
				return false;
			}
			return true;
		   }
		  function checkDate(startDay, endDay) {
			var startD1 = startDay + "   " + "00:00";
			var endD1 = endDay + "   " + "23:59";
			var n1 = new Date(startD1.replace(/-/g, "/"));
			var n2 = new Date(endD1.replace(/-/g, "/"));
			var n = n2.getTime() - n1.getTime();
			if (startDay == "" || endDay == "") {
				alert("请选择完整的开始时间和结束时间!");
				return false;
			}
			if (n <= 0) {
				alert("开始日期必须大于结束日期，请重新选择！");
				return false;
			}
			return true;
		}
		</script>
	</head>
	<body>
		<form name="castForm" id="castForm" action=/doTradeReg.do method=post TARGET=appwin>
			<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>信息排名推荐</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
			<table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td style="margin-top: 20px">
									<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
										<tr>
											<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" align=right width="15%">
												信息标题：
											</td>
											<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left width="85%">
												<div class="ping">
													<%=titles%>
												</div>
											</td>
										</tr>
										<tr>
											<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" align=right width="15%">
												信息名次：
											</td>
											<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left width="85%">
												<div class="ping">
													<input type="text" name="info_no" id="info_no" value="<%=info_no%>" maxlength="5" size="10" onkeyup="if(isNaN(value))execCommand('undo')">
												</div>
											</td>
										</tr>
										<tr>
											<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" align=right width="15%">
												开始时间：
											</td>
											<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left width="85%">
												<div class="ping">
													<input type="text" name="start_date" id="start_date" size="10" value="<%=startDay%>" maxlength="10" onfocus="setday(this);">
												</div>
											</td>
										</tr>
										<tr>
											<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" align=right width="15%">
												结束时间：
											</td>
											<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left width="85%">
												<div class="ping">
													<input type="text" name="end_date" id="end_date" size="10" value="<%=endDay%>" maxlength="10" onfocus="setday(this);">
												</div>
											</td>
										</tr>
										<tr>
											<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; text-align: right" align=right width="15%">
												备注：
											</td>
											<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left width="85%">
												<div class="ping1">
													<input type="text" name="remark" id="remark" maxlength="50" size="52" value="<%=remark%>">
												</div>
											</td>
										</tr>
										<tr>
											<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=center colspan="2">
												<input class="tjan" name="submit" type="submit" value="" onclick="return check_Value()">
											</td>
										</tr>
										<tr>
											<td>
												<input type="hidden" name="trade_type_code" id="trade_type_code" value="1206">
												<input type="hidden" name="cust_class" id="cust_class" value="<%=cust_class%>">
												<input type="hidden" name="info_type" id="info_type" value="<%=info_type%>">
												<input type="hidden" name="info_id" id="info_id" value="<%=quo_id%>">
												<input type="hidden" name="info_title" id="info_title" value="<%=titles%>">
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


