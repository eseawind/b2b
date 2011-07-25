<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="role" class="com.saas.biz.roleMgr.RoleInfo" scope="page" />
<%
	String cust_id = "", role_code = "", role_name = "", remark = "", role_type = "",role_types="";
	cust_id = request.getParameter("cust");
	role_code = request.getParameter("role");
	ArrayList roleList = role.getRoleInfoByCode(cust_id, role_code);
	if (roleList != null && roleList.size() > 0) {
		HashMap roleMap = (HashMap) roleList.get(0);
		role_name = roleMap.get("role_name").toString();
		remark = roleMap.get("remark").toString();
		role_type = roleMap.get("role_type").toString();
	    role_types = bean.getItemsBySelected("45",role_type);
	}
%>
<html>
	<head>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<title>角色管理</title>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript" src="/js/roleMgr.js"></script>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					 <a href="roleListIndex.jsp">角色管理</a>
			</tr>
		</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">				
				<tr>
					<td valign="top">
						<table width=100% border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#dddddd">
						   <tr>
								<td class="u1">
									角色名称
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width=85% colspan="3">
									<div>
										<input name="role_name" type="text" id="role_name" size=20 maxlength=30 value="<%=role_name%>">
										<input type="hidden" name="role_code" id="role_code" value="<%=role_code%>">
									</div>
								</td>
							</tr>
							<tr>
								<!--<td class="u1">
									角色类型
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
									<select name="role_type" id="role_type">
										<%=role_types%>
									</select>
								</td>-->
							<input type="hidden" name="enable_tag" value="0">
							<tr>
								<td class="u1">
									备注
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left colspan="3">
									<input name="remark" id="remark" type="text" size=50 maxlength="500" value="<%=remark%>" />
									<input name="role_type" id="role_type" type="hidden" size=50 maxlength="500" value="<%=role_type%>" />
								</td>
							</tr>
							<input name="trade_type_code" type="hidden" value="1031" />
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;" align="center" colspan=4>
									<input name="submit1" class="tjan" type="button" value="" onclick="updateRoleInfoconfirmsub(resumeForm)">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="13"></td>
				</tr>
			</table>
		</form>
	</body>
</html>



