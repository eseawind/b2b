<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="menu" class="com.saas.biz.rightMgr.RightMenu" scope="page" />
<jsp:useBean id="module" class="com.saas.biz.moduleMgr.ModuleInfo" scope="page" />
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
	
	String module_name="",module_file="",module_dir="",module_type="",m_rsrv_str1="",m_rsrv_str2="",m_rsrv_str3="",
	m_rsrv_str4="",m_rsrv_str5="",m_rsrv_str6="",m_rsrv_str7="",m_rsrv_str8="",m_rsrv_str9="",m_rsrv_str0="",m_remark="";
	
	ArrayList lists = module.getModuleInfo(module_id);
	if (lists != null && lists.size()>0){
		HashMap map = (HashMap)lists.get(0);
		if (map.get("module_name") != null){module_name = map.get("module_name").toString(); }                  
		if (map.get("module_file") != null){module_file = map.get("module_file").toString(); }               
		if (map.get("module_dir") != null){module_dir = map.get("module_dir").toString(); }               
		if (map.get("module_type") != null){module_type = map.get("module_type").toString(); }                  
		if (map.get("rsrv_str1") != null){m_rsrv_str1 = map.get("rsrv_str1").toString(); }                  
		if (map.get("rsrv_str2") != null){m_rsrv_str2 = map.get("rsrv_str2").toString(); }   
		if (map.get("rsrv_str3") != null){m_rsrv_str3 = map.get("rsrv_str3").toString(); }
		if (map.get("rsrv_str4") != null){m_rsrv_str4 = map.get("rsrv_str4").toString(); }   
		if (map.get("rsrv_str5") != null){m_rsrv_str5 = map.get("rsrv_str5").toString(); }
		if (map.get("rsrv_str6") != null){m_rsrv_str6 = map.get("rsrv_str6").toString(); }   
		if (map.get("rsrv_str7") != null){m_rsrv_str7 = map.get("rsrv_str7").toString(); }
		if (map.get("rsrv_str8") != null){m_rsrv_str8 = map.get("rsrv_str8").toString(); }               
		if (map.get("rsrv_str9") != null){m_rsrv_str9 = map.get("rsrv_str9").toString(); }                  
		if (map.get("rsrv_str0") != null){m_rsrv_str0 = map.get("rsrv_str0").toString(); }                  
		if (map.get("remark") != null){m_remark = map.get("remark").toString(); }                  
	}
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
			<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td height="50" colspan="3">
					</td>
				</tr>
				<tr>
					<td background="/admin/images/content_03.gif" height="43" width="156" align="center">
						<font size="2"><b>菜单信息</b> </font>
					</td>
					<td background="/admin/images/content_04.gif" align="right">
						&nbsp;
					</td>
					<td width="8">
						<img src="/admin/images/content_06.gif">
					</td>
				</tr>
			</table>
			<table width="800" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
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
			<table width="800" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
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
							<%=subsys_code%>
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
							<%=menu_name%>
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
							<%=up_menu_id%>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							上级菜单名：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=up_menu_name%>
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
							<%=menu_type%>
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							菜单级别：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=menu_class%>
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
							<%=module_id%>
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
							<%=in_param_code1%>
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
							<%=in_param_value1%>
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							in_param_code2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=in_param_code2%>
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
							<%=in_param_value2%>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							in_param_code3：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=in_param_code3%>
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
							<%=in_param_value3%>
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							remove_tag：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=remove_tag%>
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
							<%=rsrv_str1%>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=rsrv_str2%>
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
							<%=rsrv_str3%>
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str4：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=rsrv_str4%>
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
							<%=rsrv_str5%>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str6：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=rsrv_str6%>
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
							<%=rsrv_str7%>
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str8：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=rsrv_str8%>
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
							<%=rsrv_str9%>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str0：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=rsrv_str0%>
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
							<%=remark%>
						</div>
					</td>
				</tr>
			</table>
			<table width="800" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
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
			<table width="800" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
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
							<%=module_name%>
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
							<%=module_file%>
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
							<%=module_dir%>
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
							<%=module_type%>
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
							<%=m_rsrv_str1%>
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=m_rsrv_str2%>
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
							<%=m_rsrv_str3%>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str4：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=m_rsrv_str4%>
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
							<%=m_rsrv_str5%>
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str6：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=m_rsrv_str6%>
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
							<%=m_rsrv_str7%>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str8：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=m_rsrv_str8%>
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
							<%=m_rsrv_str9%>
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str0：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<%=m_rsrv_str0%>
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
							<%=m_remark%>
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" align="center" height="50" colspan="4">
						<input name="trade_type_code" type="hidden" id="trade_type_code" value="6102">
						<input name="in_staff_id" type="hidden" id="in_staff_id" value="<%=user_id%>">
<%--						<img src="/admin/images/submit_0.gif" onclick="return submitInfo()" style="cursor: hand;">--%>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



