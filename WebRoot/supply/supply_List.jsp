<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="areaBean" class="com.saas.biz.AreaInfoMgr.AreaInfo" scope="page" />
<jsp:useBean id="classBean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%
	String country = areaBean.getCountrySelect("5J2mc0X0G85BH");
	String start_Page = "1", sys_code = "0";
	if (request.getParameter("page") != null) {
		start_Page = request.getParameter("page");
	}
	if (request.getParameter("sys_code") != null) {
		sys_code = request.getParameter("sys_code");
	}
	String saleClassInfo = classBean.getSelectedByComm("5", "1");
%>
<html>
	<head>
		<title>中国建材市场-供应信息</title>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AreaInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript" src="supply.js"></script>
		<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		-->
		</style>
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
	</head>
	<body onload="autoLoad('<%=start_Page%>','<%=sys_code%>')">
		<input type="hidden" name="s_start" id="s_start" value="<%=start_Page%>">
		<input type="hidden" name="s_code" id="s_code" value="<%=sys_code%>">
		<jsp:include flush="true" page="/include/top.jsp" />
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="5"></td>
			</tr>
			<tr>
				<td>
					<img src="/images/ba_41.gif" width="980" height="50" alt="" />
				</td>
			</tr>
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td width="740" valign="top">
					<table border=0 cellpadding=0 cellspacing=0 width="100%">
						<tr>
							<td width="115" height="29" align="center" background="/images/wl_03.jpg" class="wl_btlanse">
								供应信息列表
							</td>
							<td align="right" background="/images/wl_04.jpg" valign="bottom">
								<img src="/images/wl_07.jpg"> 
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="10" cellspacing="1" bgcolor="90ABDF">
						<tr>
							<td valign="top" bgcolor="FFFFFF">
								<jsp:include flush="true" page="/include/catalog.jsp">
									<jsp:param name="type" value="5" />
									<jsp:param name="level" value="1" />
								</jsp:include>
							</td>
						</tr>
					</table>
					<table width="50%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="10"></td>
						</tr>
					</table>
					<!--选项开始-->
					<!--JavaScript部分-->
					<style type=text/css>
					.ec4 {
						CURSOR: hand;
						background:url(/images/wl_03.jpg);
						COLOR: #20539E;
						font-weight:bold;
						font-size: 14px;
					}
					.ec3 {
						CURSOR: hand; 
						background:url(/images/wl_02.gif); 
						COLOR: #DA6326; 
						font-weight:bold;
						font-size: 14px;
					}
						  </style>
					<!--HTML部分-->
					<table border=0 cellpadding=0 cellspacing=0 width="100%">
						<tr align=middle>
							<td width="115" height="29" align="center" id="td0" class=ec4 onClick="javascript:secBoard(0)" style="padding-top:2">
								供应列表
							</td>
							<td width="2" align="middle" background="/images/wl_04.jpg"></td>
							<td width="115" height="29" align="center" id="td1" class=ec3 onClick="javascript:secBoard(1)" style="padding-top:2;cursor: hand;display: none;">
								最新供应							</td>
							<td align="right" background="/images/wl_04.jpg" valign="bottom">
								<img src="/images/wl_07.jpg"> 
							</td>
						</tr>
					</table>

					<!--供应列表-->
					<div id="sale-list">
						<jsp:include flush="true" page="saleList.jsp">
							<jsp:param name="sys_code" value="<%=sys_code%>"></jsp:param>
							<jsp:param name="page" value="<%=start_Page%>"></jsp:param>
						</jsp:include>
					</div>
					
				</td>
				<td valign="top">&nbsp;
					
				</td>
				<td width="228" valign="top">
					<jsp:include flush="true" page="sale_right.jsp" />
				</td>
		</table>
		<form action="supplyComparam.jsp" method="post" name="commpara" id="commpara" target="_blank">
			<input type="hidden" name="idx" id="idx">
		</form>
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>




