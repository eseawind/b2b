<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="roleBean" class="com.saas.biz.roleMgr.RoleInfo" scope="page"></jsp:useBean>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="/ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/js/userGird.js"></script>
		<script type="text/javascript" src="/js/roleMgr.js"></script>
		<style>
		</style>
		<script type="text/javascript">

		</script>
		<%
			  HttpSession  logsession = request.getSession(); 
			  String cust_id = "";
			  if(logsession.getAttribute("SESSION_CUST_ID") != null)
			  {
					cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
			  }
			  String roles=roleBean.getRoleSelectByType(cust_id,"1");
		%>
	</head>
	<body>
	<form name=resumeForm action=/doTradeReg.do method=post target="_self">
		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#dddddd">
			<tr>
				<td class="u1" width="15%">
					请选择角色：
				</td>
				<td align="left" class="u2" width="85%">
					<div>
					<select name="code" id="code">
						 <option value="a">请选择...</option>
						 <%=roles%>
					</select>
					</div>
				</td>
			</tr>
			<tr>
				<td class="u1">
					请选择帐号：
				</td>
				<td align="left" class="u2">
					<div style="float: left">
					  <input type="text" name="user_name" id="sale_user_name" size="15" readonly onchange="grantRolecheckUserRole()">
					  <input type="hidden" name="user_id" id="sale_user_id">
					  <input type="button" name="bnt" id="bnt" value="请选择" onclick="grantRoleshowUserList()">
					  <input type="button" style="display: none" value="检测用户角色" name="check" id="check" onclick="grantRolecheckUserRole()">
					  <div id="grid5"></div>
					</div>
				</td>
			</tr>
			<tr id="role" style="display: none">
				<td class="u1">
					用户已有角色：
				</td>
				<td align="left" class="u2">
				   <div class="ping1">
					<div id="role-div"></div>
					</div>
				</td>
			</tr>
			<tr>
				<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;text-align:center;" align="center" colspan="2">
					<input class="tjan" name="submit" type="submit" value="" onclick="return grantRolecheck_Value()">
				</td>
			</tr>
			<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>">
			<input type="hidden" name="trade_type_code" value="1190">
		</table>
	</form>
	</body>
</html>



