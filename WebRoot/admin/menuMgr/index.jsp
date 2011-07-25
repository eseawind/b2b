<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.rightMgr.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	String sel_sys_code= "",menu_class="",up_menu_id="";
	String iStart = "1";
	if (request.getParameter("sel_sys")!= null)
	{
	    sel_sys_code  = request.getParameter("sel_sys");
	}	
	if (request.getParameter("menu_class")!= null)
	{
	    menu_class  = request.getParameter("menu_class");
	}
	if (request.getParameter("up_menu_id")!= null)
	{
	    up_menu_id  = request.getParameter("up_menu_id");
	}	
	if (request.getParameter("iStart")!= null)
	{
	    iStart  = request.getParameter("iStart");
	}	 
 	int counter = 0;
 	String pageTools = "";
 	RightMenu menu = new RightMenu();
 	ArrayList menulist = new ArrayList();
 	ArrayList syslist = menu.genSysServ();
 	
 	if (menu_class.equals("1")){
 		
 		menulist = menu.getMenuRight(Integer.valueOf(iStart).intValue(),sel_sys_code,menu_class);
 		counter = menu.getMenuRight(sel_sys_code,menu_class);
 		pageTools = tools.getPageTools(String.valueOf(counter),"9", "index.jsp?sel_sys="+sel_sys_code+"&menu_class="+menu_class+"&iStart=", Integer.parseInt(iStart));
 	}
 	else if (menu_class.equals("2")){
 		
 		menulist = menu.getDownMenuRight(Integer.valueOf(iStart).intValue(),up_menu_id);
 		counter = menu.getDownMenuRight(up_menu_id);
 		pageTools = tools.getPageTools(String.valueOf(counter),"9", "index.jsp?up_menu_id="+up_menu_id+"&menu_class="+menu_class+"&iStart=", Integer.parseInt(iStart));
 	}
 	else if (menu_class.equals("3")){
 		
 		menulist = menu.getDownMenu(Integer.valueOf(iStart).intValue(),up_menu_id);
 		counter = menu.getDownMenu(up_menu_id);
 		pageTools = tools.getPageTools(String.valueOf(counter),"9", "index.jsp?up_menu_id="+up_menu_id+"&menu_class="+menu_class+"&iStart=", Integer.parseInt(iStart));
 	}
	
%>
<html>
	<head>
		<title>菜单管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script src="/www/fuction/calendar.js" type="text/javascript"></script>
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<style type="text/css">
			.chaxun{
					background:url(/admin/images/chaxun.gif) left center no-repeat;
					width:70px;
				 	height:26px;
					border:0px; 
				 	cursor:hand;
				}
		</style>
		<script language="javascript">
	  function checkBeforeDel(){
	    if(confirm('是否确认删除当前菜单？')) {
	    	if(confirm('真的要删除？')) {
	    		if(confirm('不后悔吗？')) {
	    			if(confirm('删错了别怪我哦？')) {
	    				return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	  }
	 </script>
	</head>
	<body>
		<form action="index.jsp" method="post" name="orderform">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		 
	  </table>
			<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#DEEDFD">
				<tr>
					<td height="36" valign="middle" class="u2">
						请选择服务： 
						<%
                                
                                if (syslist != null && syslist.size() > 0)
                                {
                                    for(Iterator it = syslist.iterator(); it.hasNext();)
                        		    {
                            			HashMap sysInfo = (HashMap)it.next();
                            			String sysname = "";
                            			String syscode = "";
                            			if (sysInfo.get("para_code1") != null) syscode =sysInfo.get("para_code1").toString();
                            			if (sysInfo.get("para_code2") != null) sysname =sysInfo.get("para_code2").toString();
                        %>
                                    『<a href ="index.jsp?sel_sys=<%=syscode%>&menu_class=1"><%=sysname%></a>』
                		<%			
                                    }
                            			
                                }
                		%>
					</td>
				</tr>
				<tr>
					<td valign="middle" class="u2">
<%--						菜单ID:--%>
<%--						<input type="text" id="start_date" name="start_date value="">--%>
<%--						菜单名:--%>
<%--						<input type="text" id="end_date" name="end_date value="">--%>
<%--						&nbsp;--%>
<%--						<input class="chaxun" type="button" name="comit" value="" onclick="return Check_Value()" style="cursor: hand;">--%>
						<%
							if(!sel_sys_code.equals("")){
						%>
							<a href="addNewMenu.jsp?&menu_class=0&subsys_code=<%=sel_sys_code%>" >
								<img src="/admin/images/new_0.gif" width="80" height="26" align="right" border="0" alt="新增一级"></a>
						<%
							}
						%>
					</td>
				</tr>
			</table>
		</form>
		
		<form action="index.jsp" method="post" name="menuform">
		<table bgcolor="#DEEDFD" width=100% border=0 cellpadding=1 cellspacing=1 align="center">
			<tr>
				<td height="10">
				</td>
			</tr>
			<tr>
				<td>
				<%
				   String menu_id ="",menu_name ="",module_dir="",module_file="",rsrv_str4 ="";
				 	if (menulist != null && menulist.size() > 0){
				 		for (int i = 0; i < menulist.size(); i++){
				 		HashMap map = (HashMap)menulist.get(i);
				 		if (map.get("menu_id")!= null){menu_id = map.get("menu_id").toString();}
				 		if (map.get("menu_name")!= null){menu_name = map.get("menu_name").toString();}
				 		if (map.get("module_dir")!= null){module_dir = map.get("module_dir").toString();}
				 		if (map.get("module_file")!= null){module_file = map.get("module_file").toString();}
				 		if (map.get("rsrv_str4")!= null){rsrv_str4 = map.get("rsrv_str4").toString();}
				 		if (map.get("menu_id")!= null){menu_id = map.get("menu_id").toString();}
				 		String menu_classs = menu.getMenuClassLevel(menu_id);
				 		int a = Integer.parseInt(menu_classs) + 1;
				 		String b = String.valueOf(a);
				%>
					<!--重复区-->
					<table width="280" height="190" border="0" align="center" cellpadding="1" cellspacing="0" bgcolor="white" style="float:left; margin-left:30px; margin-top:20px;  display:inline;">
						<tr>
							<td valign="top">
								<table width="260" border="0" align="center" cellpadding="0" cellspacing="0" style="borber-bottom:1px dashed CDD4DA;">
									<tr>
										<td width="125" height="30" align="left">
										<%=menu_classs%>级菜单
<%--											<img src="/admin/images/new_0.gif" width="80" height="26">--%>
										</td>
										<td width="135" align="right">
										<%
											if (menu_classs.equals("1")){ 
										%>
											<a href="addNewMenu.jsp?up_menu_id=<%=menu_id%>&menu_class=<%=menu_classs%>"><img src="/admin/images/add.gif" width="16" height="16" border="0" alt="新增下级"></a>
										<%
											}else if(menu_classs.equals("2")){ 
										%>	
											<a href="addThreeMenu.jsp?up_menu_id=<%=menu_id%>&menu_class=<%=menu_classs%>"><img src="/admin/images/add.gif" width="16" height="16" border="0" alt="新增三级"></a>
										<%
											} else{}
										%>
										
										
										<%
											if (!menu_classs.equals("3")){ 
										%>
											<a href="modifyMenu.jsp?menu_id=<%=menu_id%>"><img src="/admin/images/details.gif" width="16" height="16" border="0" alt="修改菜单"></a>
										<%
											}else { 
										%>
											<a href="modifyThreeMenu.jsp?menu_id=<%=menu_id%>" target=""><img src="/admin/images/details.gif" width="16" height="16" border="0" alt="修改菜单"></a>
										<%
											} 
										%>		
											<a href="/doTradeReg.do?menu_id=<%=menu_id%>&trade_type_code=6101" target="_self" onclick="return checkBeforeDel()"><img src="/admin/images/delete.gif" width="16" height="16" border="0" alt="删除菜单"></a>
										</td>
									</tr>
								</table>
								
								<table width="260" border="0" align="center" cellpadding="5" cellspacing="0">
									<tr>
										<td align="left">
											菜单标识：<%=menu_id%>
											<br>
											菜单名：
											<%
												if ( !menu_classs.equals("3")) {
											%>
												<strong><a href="seeMenuInfo.jsp?menu_id=<%=menu_id%>" target=""><%=menu_name%></a></strong>
												<a href="index.jsp?up_menu_id=<%=menu_id%>&menu_class=<%=b%>"><img src="/admin/images/01.01.gif" height="7" width="14" border="0" alt="点击进入下级菜单"></a>
											<%
												}else {
											%>
												<strong><a href="seeThreeMenu.jsp?menu_id=<%=menu_id%>" target=""><%=menu_name%></a></strong>
											<% 
												}
											%>
											<br>
											文件路径: <%=module_dir%>
											<br>
											文件名：<%=module_file%>
											<br>
											功能描述：<%=rsrv_str4%>
											<br>
											<input type="hidden" id="menu_id" name="menu_id" value="<%=menu_id%>">
											<input type="hidden" id="menu_class" name="menu_class" value="<%=menu_classs%>">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!--重复区//-->
				<%
						}
				    }
				%>

				</td>
			</tr>
			<tr>
				<td height="10">
				</td>
			</tr>
		</table>
		<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr class="bfoot">
			<%=pageTools%>
			</tr>
		</table>
		</form>
	</body>
</html>



