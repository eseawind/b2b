<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="menu" class="com.saas.biz.rightMgr.RightMenu" scope="page" />
<%
	String user_id = "";
	HttpSession logsession = request.getSession();
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	String menu_id = "";
	if (request.getParameter("menu_id") != null) {
		menu_id = request.getParameter("menu_id");
	}
	
	String subsys_code="",menu_name="",up_menu_id="",menu_class="",menu_type="",module_id="",in_param_code1="",in_param_value1="",in_param_code2="",in_param_value2="",in_param_code3="",in_param_value3="",remove_tag="",rsrv_str1="",rsrv_str2="",rsrv_str3="",rsrv_str4="",rsrv_str5="",rsrv_str6="",rsrv_str7="",rsrv_str8="",rsrv_str9="",rsrv_str0="",remark="";
	
	ArrayList list = menu.getMenuInfo(menu_id);
	if (list != null && list.size()>0){
		HashMap map = (HashMap)list.get(0);
		if (map.get("subsys_code") != null){subsys_code = map.get("subsys_code").toString(); }
		if (map.get("menu_name") != null){menu_name = map.get("menu_name").toString(); }                  
		if (map.get("up_menu_id") != null){up_menu_id = map.get("up_menu_id").toString(); }               
		if (map.get("menu_class") != null){menu_class = map.get("menu_class").toString(); }               
		if (map.get("menu_type") != null){menu_type = map.get("menu_type").toString(); }                  
		if (map.get("module_id") != null){module_id = map.get("module_id").toString(); }                  
		if (map.get("in_param_code1") != null){in_param_code1 = map.get("in_param_code1").toString(); }   
		if (map.get("in_param_value1") != null){in_param_value1 = map.get("in_param_value1").toString(); }
		if (map.get("in_param_code2") != null){in_param_code2 = map.get("in_param_code2").toString(); }   
		if (map.get("in_param_value2") != null){in_param_value2 = map.get("in_param_value2").toString(); }
		if (map.get("in_param_code3") != null){in_param_code3 = map.get("in_param_code3").toString(); }   
		if (map.get("in_param_value3") != null){in_param_value3 = map.get("in_param_value3").toString(); }
		if (map.get("remove_tag") != null){remove_tag = map.get("remove_tag").toString(); }               
		if (map.get("rsrv_str1") != null){rsrv_str1 = map.get("rsrv_str1").toString(); }                  
		if (map.get("rsrv_str2") != null){rsrv_str2 = map.get("rsrv_str2").toString(); }                  
		if (map.get("rsrv_str3") != null){rsrv_str3 = map.get("rsrv_str3").toString(); }                  
		if (map.get("rsrv_str4") != null){rsrv_str4 = map.get("rsrv_str4").toString(); }                  
		if (map.get("rsrv_str5") != null){rsrv_str5 = map.get("rsrv_str5").toString(); }                  
		if (map.get("rsrv_str6") != null){rsrv_str6 = map.get("rsrv_str6").toString(); }                  
		if (map.get("rsrv_str7") != null){rsrv_str7 = map.get("rsrv_str7").toString(); }                  
		if (map.get("rsrv_str8") != null){rsrv_str8 = map.get("rsrv_str8").toString(); }                  
		if (map.get("rsrv_str9") != null){rsrv_str9 = map.get("rsrv_str9").toString(); }                  
		if (map.get("rsrv_str0") != null){rsrv_str0 = map.get("rsrv_str0").toString(); }                  
		if (map.get("remark") != null){remark = map.get("remark").toString(); }                           
	}
	String up_menu_name = menu.getMenuNameById(up_menu_id);

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
			document.menuForm.submit();
		}
		</script>
	</head>
	<body>
		<form name="menuForm" id="menuForm" action="/doTradeReg.do" method="post" target="_self">
			<!--table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td height="50" colspan="3">
					</td>
				</tr>
				<tr>
					<td background="/admin/images/content_03.gif" width="156" align="center">
						<font size="2"><b>菜单管理</b> </font>
					</td>
					<td background="/admin/images/content_04.gif" align="right">
						&nbsp;
					</td>
					<td width="8">
						<img src="/admin/images/content_06.gif">
					</td>
				</tr>
			</table-->
			<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
			
				<tr>
					<td valign="middle" background="/admin/images/bg_0.gif" align="center">
						<b>修改菜单</b>
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
							<input name="menu_name" type="text" id="menu_name" value="<%=menu_name%>" size="18" maxlength="30">
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
							<input name="up_menu_id" type="text" id="up_menu_id" value="<%=up_menu_id%>" size="20" maxlength="20">
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
							<input name="menu_type" type="text" id="menu_type" value="<%=menu_type%>" size="15" maxlength="20">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							菜单级别：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="menu_class" type="text" id="menu_class" value="<%=menu_class%>" size="5" maxlength="1" readonly="readonly">
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
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							in_param_code1：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_param_code1" type="text" id="in_param_code1" value="<%=in_param_code1%>" size="20" maxlength="50">
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
							<input name="in_param_value1" type="text" id="in_param_value1" value="<%=in_param_value1%>" size="15" maxlength="50">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							in_param_code2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_param_code2" type="text" id="in_param_code2" value="<%=in_param_code2%>" size="20" maxlength="50">
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
							<input name="in_param_value2" type="text" id="in_param_value2" value="<%=in_param_value2%>" size="30" maxlength="50">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							in_param_code3：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_param_code3" type="text" id="in_param_code3" value="<%=in_param_code3%>" size="30" maxlength="50">
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
							<input name="in_param_value3" type="text" id="in_param_value3" value="<%=in_param_value3%>" size="15" maxlength="50">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							remove_tag：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="remove_tag" type="text" id="remove_tag" value="<%=remove_tag%>" size="10" maxlength="1">
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
							<input name="rsrv_str1" type="text" id="rsrv_str1" value="<%=rsrv_str1%>" size="20" maxlength="20">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str2" type="text" id="rsrv_str2" value="<%=rsrv_str2%>" size="20" maxlength="100">
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
							<input name="rsrv_str3" type="text" id="rsrv_str3" value="<%=rsrv_str3%>" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str4：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str4" type="text" id="rsrv_str4" value="<%=rsrv_str4%>" size="30" maxlength="100">
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
							<input name="rsrv_str5" type="text" id="rsrv_str5" value="<%=rsrv_str5%>" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str6：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str6" type="text" id="rsrv_str6" value="<%=rsrv_str6%>" size="10" maxlength="1">
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
							<input name="rsrv_str7" type="text" id="rsrv_str7" value="<%=rsrv_str7%>" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str8：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str8" type="text" id="rsrv_str8" value="<%=rsrv_str8%>" size="10" maxlength="1">
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
							<input name="rsrv_str9" type="text" id="rsrv_str9" value="<%=rsrv_str9%>" size="30" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str0：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str0" type="text" id="rsrv_str0" value="<%=rsrv_str0%>" size="30" maxlength="100">
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
							<input name="remark" type="text" id="remark" value="<%=remark%>" size="52" maxlength="50">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" align="center" height="50" colspan="4">
						<input name="in_staff_id" type="hidden" id="in_staff_id" value="<%=user_id%>">
						<input name="trade_type_code" type="hidden" id="trade_type_code" value="6100">
						<img src="/admin/images/submit_0.gif" onclick="return submitInfo()" style="cursor: hand;">
						<img src="/admin/images/submit_1.gif" onClick="location.href='index.jsp?up_menu_id=3d4jA8ip0uU35ax&menu_class=<%=menu_class%>&sel_sys=<%=subsys_code%>'" style="cursor:hand;" align="absmiddle">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



