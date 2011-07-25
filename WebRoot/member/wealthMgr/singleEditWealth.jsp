<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type="text/javascript" src="/js/wealthMgr.js">
		<style>
		 .l_td{background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;text-align:right;width: 15%}
		 .r_td{background-color:#ffffff; color:#000000;  font-size:12px;width: 85%}
		</style>
		<%
		
		   String user_name="";
		   String cust_type="";
		   String cust_id="";
		   String property_value="";
		   String acct_id="";
		if(request.getParameter("cust_id")!=null){
			  cust_id=request.getParameter("cust_id");
			}
		   if(request.getParameter("user_name")!=null){
			  user_name=request.getParameter("user_name");
			}
			if(request.getParameter("cust_type")!=null){
			  cust_type=request.getParameter("cust_type");
			}
				if(request.getParameter("property_value")!=null){
			  property_value=request.getParameter("property_value");
			}
				if(request.getParameter("acct_id")!=null){
			  acct_id=request.getParameter("acct_id");
			}	
		%>
	</head>
	<body>
	<form name=resumeForm action=/doChWealthTradeReg.do method=post target="_self">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding: 10px">
			<tr>
				
				<td align="center" height="27px">
					<div id="manager_body">
						<div id="manager_body_right">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<table width=725 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
										<tr>
												<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;text-align:left;" align="left" colspan="2">
												 <div class="ping"> 
												   设置会员财富
												 </div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													用户名称：
												</td>
												<td align="left" class="r_td">
													<div class="ping">
													 <input type="text" size="25" name="action" value="<%=user_name%>"  readonly>
                                                             <input type="hidden" name="acct_id" value="<%=acct_id%>">
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													用户级别：
												</td>
												<td align="left" class="r_td">
													<div class="ping">
													    <input type="text" size="25" name="class_anem" value="<%=cust_type%>" readonly>
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													黄金数量：
												</td>
												<td align="left" class="r_td">
													<div class="ping">
														<input type="text" name="property_value" name="property_value" size="5" maxlength="50" value="<%=property_value%>" onkeyup="if(isNaN(value))execCommand('undo')">
														(两) &nbsp; &nbsp; &nbsp;<font color="red">注:仅限数字</font>
													</div>
												</td>
											</tr>
											<tr>
												<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;text-align:center;" align="center" colspan="2">
													<input class="xgan" name="submit" type="submit" value="" >
												</td>
											</tr>
											<input type="hidden" name="trade_type_code" value="9527">
										</table>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>




