<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=GBK"%>

<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />

<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />

<%

	ArrayList list=bean.getCompareInfoByAttr("45");

	String role_code=comm.GenTradeId();

%>

<html>
	<head>
		<title>添加角色参数</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="/ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="role_wind.js"></script>
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
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				
				<tr>
					<td valign="top">
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
							<tr>
								<td class="u1" width=15%>
									角色名称:
								</td>
								<td width=85% class="u2">
									<div class="ping1">
										<input name="role_name" type="text" id="role_name" size=30 maxlength=30>
									</div>
								</td>
							</tr>
							<input name="role_code" id="role_code" type="hidden" value="<%=role_code%>">
							<input type="hidden" name="role_type" id="role_type" value="1">
							<input type="hidden" name="enable_tag" id="enable_tag" value="0">
							<div id="role_div"></div>
							<tr>
								<td class="u1">备注：
								</td>
								<td class="u2"><div class="ping1">
										<input name="remark" id="remark" type="text" size=30 maxlength="500" />
									</div>
								</td>
							</tr>
							<input name="trade_type_code" type="hidden" value="1029" />
							
							<tr>
								<td class="u3" colspan=2>
									<input class="tjan" name="submit1" type="button" value="" onclick="addRoleInfoconfirmsub(resumeForm)">
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




