<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="menu" class="com.saas.biz.rightMgr.RightMenu" scope="page" />
<%
	String user_id = "";
	HttpSession logsession = request.getSession();
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	String up_menu_id = "", menu_class = "";
	if (request.getParameter("up_menu_id") != null) {
		up_menu_id = request.getParameter("up_menu_id");
	}
	String menu_id = bean.GenTradeId();
	String module_id = bean.GenTradeId();
	String up_menu_name = menu.getMenuNameById(up_menu_id);
	String subsys_code = menu.getSeviceNameById(up_menu_id);

	if (request.getParameter("menu_class") != null) {
		menu_class = request.getParameter("menu_class");
	}
	int a = Integer.parseInt(menu_class) + 1;
	String b = String.valueOf(a);
%>
<html>
	<head>
		<title>菜单管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
		function submitInfo(){
			if ($F('menu_name') == ''){
			 	alert("请填写菜单名!"); 
				document.getElementById('menu_name').focus();
				return false;
			}
			if ($F('rsrv_str4') == ''){
			 	alert("请填写菜单说明!"); 
				document.getElementById('rsrv_str4').focus();
				return false;
			}
			if ($F('module_file') == ''){
			 	alert("请填写文件名!"); 
				document.getElementById('module_file').focus();
				return false;
			}
			if ($F('module_dir') == ''){
			 	alert("请填写文件路径!"); 
				document.getElementById('module_dir').focus();
				return false;
			}
			document.menuForm.submit();
		}
		</script>
	</head>
	<body>
		<form name="menuForm" id="menuForm" action="/doTradeReg.do" method="post" target="_self">
			<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
				<tr>
					<td height="36" valign="middle" bgcolor="#FFFFFF">
					</td>
				</tr>
				<tr>
					<td valign="middle" background="/admin/images/bg_0.gif" align="center">
						<b>MenuInfo</b>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
				<tr>
					<td colspan="4">
					</td>
				</tr>
				<tr>
					<td width="15%" bgcolor="#ffffff">
						<div style=" text-align:right; font-weight:bold;">
							服务名：
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="subsys_code" type="text" id="subsys_code" value="<%=subsys_code%>" maxlength="8" readonly="readonly">
						</div>
					</td>

					<td width="15%" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							菜单名：
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="menu_id" type="hidden" id="menu_id" value="<%=menu_id%>">
							<input name="menu_name" type="text" id="menu_name" value="" size="18" maxlength="30" onblur="javascript:document.getElementById('module_name').value=this.value;">
							<img src="/admin/images/hot_l.gif" border="0">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							上级菜单标识：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="up_menu_id" type="text" id="up_menu_id" value="<%=up_menu_id%>" size="20" maxlength="20" readonly="readonly">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							上级菜单名：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="up_menu_name" type="text" id="up_menu_name" value="<%=up_menu_name%>" size="15" maxlength="20" readonly="readonly">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							menu_type：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="menu_type" type="text" id="menu_type" value="0" size="15" maxlength="20">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							菜单级别：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="menu_class" type="text" id="menu_class" value="<%=b%>" size="5" maxlength="1" readonly="readonly">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							module_id：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="module_id" type="text" id="module_id" value="<%=module_id%>" size="15" maxlength="20">
							<img src="/admin/images/hot_l.gif" border="0">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							in_param_code1：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_param_code1" type="text" id="in_param_code1" value="info_type" size="20" maxlength="50">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							in_param_value1：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_param_value1" type="text" id="in_param_value1" value="2" size="15" maxlength="50">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							in_param_code2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_param_code2" type="text" id="in_param_code2" value="" size="20" maxlength="50">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							in_param_value2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_param_value2" type="text" id="in_param_value2" value="" size="30" maxlength="50">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							in_param_code3：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_param_code3" type="text" id="in_param_code3" value="" size="30" maxlength="50">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							in_param_value3：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_param_value3" type="text" id="in_param_value3" value="" size="15" maxlength="50">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							remove_tag：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="remove_tag" type="text" id="remove_tag" value="0" size="10" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str1：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str1" type="text" id="rsrv_str1" value="" size="20" maxlength="20">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str2" type="text" id="rsrv_str2" value="" size="20" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str3：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str3" type="text" id="rsrv_str3" value="" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str4：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str4" type="text" id="rsrv_str4" value="" size="30" maxlength="100">
							<img src="/admin/images/hot_l.gif" border="0" alt="菜单说明">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str5：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str5" type="text" id="rsrv_str5" value="" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str6：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str6" type="text" id="rsrv_str6" value="" size="10" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str7：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str7" type="text" id="rsrv_str7" value="" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str8：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str8" type="text" id="rsrv_str8" value="" size="10" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str9：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str9" type="text" id="rsrv_str9" value="" size="30" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str0：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str0" type="text" id="rsrv_str0" value="6" size="30" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							remark：
						</div>
					</td>
					<td bgcolor="#FFFFFF" colspan="3">
						<div class="ping1">
							<input name="remark" type="text" id="remark" value="" size="52" maxlength="50">
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
				<tr>
					<td height="36" valign="middle" bgcolor="#FFFFFF">
					</td>
				</tr>
				<tr>
					<td valign="middle" background="/admin/images/bg_0.gif" align="center">
						<b>ModuleInfo</b>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
				<tr>
					<td colspan="4">
					</td>
				</tr>
				<tr>
					<td width="15%" bgcolor="#ffffff">
						<div style=" text-align:right; font-weight:bold;">
							module_name：
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="module_name" type="text" id="module_name" value="" maxlength="100" size="20">
							<img src="/admin/images/hot_l.gif" border="0">
						</div>
					</td>

					<td width="15%" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							文件名：
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="module_file" type="text" id="module_file" value="" size="30" maxlength="100">
							<img src="/admin/images/hot_l.gif" border="0">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							文件路径：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="module_dir" type="text" id="module_dir" value="" size="30" maxlength="100">
							<img src="/admin/images/hot_l.gif" border="0">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							module_type：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="module_type" type="text" id="module_type" value="0" size="10" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str1：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str1" type="text" id="rsrv_str1" value="" size="20" maxlength="20">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str2" type="text" id="rsrv_str2" value="" size="20" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str3：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str3" type="text" id="rsrv_str3" value="" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str4：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str4" type="text" id="rsrv_str4" value="" size="20" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str5：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str5" type="text" id="rsrv_str5" value="2" size="15" maxlength="1">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str6：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str6" type="text" id="rsrv_str6" value="" size="15" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str7：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str7" type="text" id="rsrv_str7" value="" size="15" maxlength="1">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str8：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str8" type="text" id="rsrv_str8" value="" size="15" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str9：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str9" type="text" id="rsrv_str9" value="" size="30" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str0：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str0" type="text" id="rsrv_str0" value="0" size="30" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							remark：
						</div>
					</td>
					<td bgcolor="#FFFFFF" colspan="3">
						<div class="ping1">
							<input name="remark" type="text" id="remark" value="" size="52" maxlength="50">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" align="center" height="50" colspan="4">
						<input name="trade_type_code" type="hidden" id="trade_type_code" value="6102">
						<input name="in_staff_id" type="hidden" id="in_staff_id" value="<%=user_id%>">
						<img src="/admin/images/submit_0.gif" onclick="return submitInfo()" style="cursor: hand;">
							<img src="/admin/images/submit_1.gif" onClick="location.href='index.jsp?up_menu_id=3d4jA8ip0uU35ax&menu_class=<%=menu_class%>'" style="cursor:hand;" align="absmiddle">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



