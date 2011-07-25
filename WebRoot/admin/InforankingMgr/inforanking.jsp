<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
	String cust_classs = bean.getSelectItems("14");
	String info_types = bean.getSelectItems("106");
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
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
		 	if (document.serverForm.cust_class.value == ""||document.serverForm.cust_class.value == null)
			{
				alert("客户级别不可以为空！");
				document.serverForm.cust_class.focus(); 
				return false;
			}
			if (document.serverForm.info_type.value == ""||document.serverForm.info_type.value == null)
			{
				alert("信息类型不可以为空！");
				document.serverForm.info_type.focus(); 
				return false;
			}
			return true;
		   }
		</script>
	</head>
	<body>
		
		<form name="serverForm" id="serverForm" action="rankindex.jsp" method="post" TARGET=appwin>
			<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="newc4n2mB092X0GOOOO" />
		</jsp:include>
			<table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td style="margin-top: 20px">
									<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
										<tr>
											<td class="u1" align=right >
												客户级别：
											</td>
											<td class="u2" >
												<div class="ping1">
													<select name="cust_class" id="cust_class">
														<option value="">
															请选择...
														</option>
														<%=cust_classs%>
													</select>
												</div>
											</td>
											<td class="u1" >
												信息类型：
											</td>
											<td class="u2" >
												<div class="ping1">
													<select name="info_type" id="info_type">
														<option value="">
															请选择...
														</option>
														<%=info_types%>
													</select>
												</div>
											</td>
										</tr>
										<tr>
											<td class="u3" align=center colspan="4">
												<input class="tjan" name="submit" type="submit" value="" onclick="return check_Value()">
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


