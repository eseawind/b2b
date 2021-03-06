<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.rightMgr.RightMenu"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="java.util.*"%>
<html>
	<head>
		<title>关联菜单管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/RightMenu.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type="text/javascript">	
			var fectureArray=new Array();
	 		fectureArray=['请选择..'];
			function setOneMenu(val){
				 RightMenu.getAreaByParent(val,function(data){
				 DWRUtil.removeAllOptions("oneMenu");
				 DWRUtil.addOptions("oneMenu",fectureArray);
				 DWRUtil.addOptions("oneMenu",data);
				 DWRUtil.removeAllOptions("twoMenu");
				 DWRUtil.addOptions("twoMenu",fectureArray);
				});
			}
			function setTwoMenu(oneMenu){
				 RightMenu.getAreaByParentById(oneMenu,function(data){
				 DWRUtil.removeAllOptions("twoMenu");
			     DWRUtil.addOptions("twoMenu",fectureArray);
				 DWRUtil.addOptions("twoMenu",data);
				});
			}
			
			function formSubmit(){
				document.linkForm.submit();
			}
		</script>
	</head>
	<body>
		<%
			String serSel = bean.getSelectItems("41");
			String code = "", twoMenu = "";
			ArrayList list = new ArrayList();
			RightMenu rightMenu = new RightMenu();
			if (request.getParameter("code") != null) {
				code = request.getParameter("code");
			}
			if (request.getParameter("twoMenu") != null) {
				twoMenu = request.getParameter("twoMenu");
			}
			if (code.equals("1")) {
				list = rightMenu.getMenuInfoByUpMenuId(twoMenu);
			}
		%>
		<form action="linkmenuMgr.jsp" method="post" name="linkForm">
		<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/wl_content_03.gif" height="43" width="200" align="center"><font size="2"><b>关联菜单管理</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
					
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
			<table align="center" width="800" cellpadding="1" cellspacing="1" border="0" bgcolor="#DEEDFD">
				<tr>
					<td width="18%" class="u1">
						请选择服务名称:
					</td>
					<td width="18%" class="u2">
						<select onchange="setOneMenu(this.value)">
							<option value="0">
								请选择..
							</option>
							<%=serSel%>
						</select>
					</td>
					<td width="18%" class="u1">
						请选择一级菜单:
					</td>
					<td width="18%" class="u2">
						<select name="oneMenu" id="oneMenu" onchange="setTwoMenu(this.value)">
							<option value="">
								请选择..
							</option>
						</select>
					</td>
					<td width="18%" class="u1">
						请选择二级菜单:
					</td>
					<td class="u2">
						<select name="twoMenu" id="twoMenu" onchange="formSubmit()">
							<option value="">
								请选择..
							</option>
						</select>
					</td>
				</tr>
			</table>
			<input type="hidden" name="code" id="code" value="1">
			</form>
			<%
			if (list != null && list.size() > 0) {
			%>
			<table align="center" width="800" bgcolor="#DEEDFD" border="0" cellpadding="1" cellspacing="1">
				<tr class="u4" height="25">
					<td width="33%">
						菜单名称
					</td>
					<td width="33%">
						加入时间
					</td>
					<td width="33%">
						菜单关联操作
					</td>
				</tr>


				<%
							for (int i = 0; i < list.size(); i++) {
							HashMap map = (HashMap) list.get(i);
							String menu_id = "", menu_name = "", in_date = "";
							if (map.get("menu_id") != null) {
						menu_id = map.get("menu_id").toString();
							}
							if (map.get("menu_name") != null) {
						menu_name = map.get("menu_name").toString();
							}
							if (map.get("in_date") != null) {
						in_date = map.get("in_date").toString();
							}
							if (in_date.length() > 10) {
						in_date = in_date.substring(0, 10);
							}
				%>

				<tr class="u2">
					<td align=center>
						<%=menu_name%>
					</td>
					<td align=center>
						<%=in_date%>
					</td>
					<td align=center>
						<a href="linkmenuMgrExp.jsp?menu_id=<%=menu_id%>"><img src=/images/edit.png width=16 height=16 border=0> </a>
					</td>
				</tr>
				<%
				}
				%>
				<tr class="u2">
					<td align=center colspan=3>
						<a href="javascript:window.history.go(-1);">[返回]</a>
					</td>
				</tr>
			</table>
			<%
			}
			%>
		
	</body>
</html>



