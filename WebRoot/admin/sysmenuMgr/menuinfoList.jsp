<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.ahbay.RightMgr.*" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="com.saas.biz.rightMgr.*" %>
<%@ page import="com.saas.biz.moduleMgr.ModuleInfo" %>
<html> 
	<head>
		<title>菜单管理</title>
		<script language="javascript" src="/js/center_nav.js"></script>
	</head>
<script language="javascript">
		function showSysTable(){
			document.menuForm.submit();
		}
		function showOneMenu(){
			document.getElementById('code').value='2';
			document.menuForm.submit();
		}
</script>
<%
		RightMenu rightMenu = new RightMenu();
		ModuleInfo moduleInfo = new ModuleInfo();
		ArrayList moduleList = new ArrayList();
		ArrayList syslist = new ArrayList();
		ArrayList oneMenuList = new ArrayList();
		HashMap sysMap = new HashMap();
    String code="",sysTable="none",subsys_code="",oneMenuTable="none";
    if(request.getParameter("code")!=null){
    	code = request.getParameter("code");
    }
    if(request.getParameter("subsys_code")!=null){
    	subsys_code = request.getParameter("subsys_code");
    }
    if(code.equals("1")){
    	sysTable = "block";//让服务的TABLE显示
    	syslist = rightMenu.genSysServ("SYS");
    }
    if(code.equals("2")){
    	sysTable = "block";
    	oneMenuTable="block";
    	syslist = rightMenu.genSysServ("SYS");
    	oneMenuList = rightMenu.getNoExistMenuByCustClass("",subsys_code,"");
    }
%>
	<body>  
		<form name="menuForm" action="sysMenuList.jsp" method="post">
		<%
				String top_menu_id="";
				if (request.getParameter("menu_id") != null){
		        top_menu_id = request.getParameter("menu_id");
		    }
			%>
					<jsp:include page="/inc/jspTop.jsp">
						<jsp:param name="menu_id" value="<%=top_menu_id%>" />
					</jsp:include>	
				<table width="800" cellspacing="1" cellpadding="1" bgcolor="#dddddd">
						<tr bgcolor="white">
							<td align="left">
									<input type="button" name="oneMenu" id="oneMenu" value="添加一级菜单" onclick="showSysTable()"/>
									
									<input type="hidden" name="code" id="code" value="1"><!--依靠这个参数来决定执行哪个方法-->
									
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" name="oneMenu" id="oneMenu" value="添加二级菜单" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" name="oneMenu" id="oneMenu" value="添加三级菜单" />
							</td>
						</tr>
				</table>
				<table width="800" cellspacing="1" cellpadding="1" bgcolor="#dddddd" style="display:<%=sysTable%>;">
						<tr bgcolor="white">
							<td align="left">
								请选择服务：
									<%
										String sysname = "",syscode = "",addOneMenuContent="";
//addOneMenuContent = "<form method=post name=addOneMenuForm action=/doTradeReg.do target=_self>"+
//										"	<table width=100% cellpadding=1 cellspacing=1 bgcolor=#efefef>          "+ 
//										"		<tr bgcolor=white>                                                    "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					服务名：                                                        "+ 
//										"			</td>                                                               "+ 
//										"			<td>                                                                "+ 	                                                                 
//										"			</td>                                                               "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					菜单名：                                                        "+
//										"			</td>                                                               "+ 
//										"			<td>                                                                "+ 
//										"					<input type=text name=menu_name >                               "+ 
//										"			</td>                                                               "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					模块ID：                                                        "+ 
//										"			</td>                                                               "+ 
//										"			<td>                                                                "+ 
//										"					<input type=text name=module_id >                               "+ 
//										"			</td>                                                               "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					模块文件夹：                                                    "+ 
//										"			</td>                                                               "+ 
//										"			<td>                                                                "+ 
//										"					<input type=text name=module_dir >                              "+ 
//										"			</td>                                                               "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					模块JSP名称：                                                   "+ 
//										"			</td>                                                               "+ 
//										"			<td>                                                                "+ 
//										"					<input type=text name=module_file >                             "+ 
//										"			</td>                                                               "+                                                                     
//										"		</tr>                                                                 "+ 
//										"	</table>                                                                "+ 
//										"</form>                                                                  ";
										
										
										if(syslist!=null && syslist.size()>0){
											for(int i=0;i<syslist.size();i++){
			            			sysMap = (HashMap)syslist.get(i);
			            			if (sysMap.get("para_code1") != null) syscode =sysMap.get("para_code1").toString();
			            			if (sysMap.get("para_code2") != null) sysname =sysMap.get("para_code2").toString();
			            			if(i==6){
			            				out.print("<br>");
            						}
            			%>
            				<input type="radio" name="subsys_code" value="<%=syscode%>" onclick="showOneMenu()"><%=sysname%>
            			<%
            					}
										}
									%>
							</td>
							<td align="center" width="15%">
								<img src="/admin/images/newAdd.gif" style="cursor:hand;" onclick="testMessageBox(event,<%=addOneMenuContent%>,'添加一级菜单','400')"/>
							</td>
						</tr>
				</table>
				<table width="800" cellspacing="1" cellpadding="1" bgcolor="#dddddd" style="display:<%=oneMenuTable%>;">
						<tr bgcolor="white">
							<td>
								<b>菜单名称</b>
							</td>
							<td>
								<b>修改</b>
							</td>
							<td>
								<b>删除</b>
							</td>
							<td>
								<b>查看详细</b>
							</td>
						</tr>
									<%
										String one_menu_id = "",one_menu_name = "",menu_content="",one_menu_desc="",one_module_id="",one_in_date="";
										String module_file="",module_dir="";
										if(oneMenuList!=null && oneMenuList.size()>0){
											for(int i=0;i<oneMenuList.size();i++){
			            			sysMap = (HashMap)oneMenuList.get(i);
			            			if (sysMap.get("menu_id") != null) one_menu_id =sysMap.get("menu_id").toString();
			            			if (sysMap.get("menu_name") != null) one_menu_name =sysMap.get("menu_name").toString();
			            			if (sysMap.get("rsrv_str4") != null) one_menu_desc =sysMap.get("rsrv_str4").toString();
			            			if (sysMap.get("module_id") != null) one_module_id =sysMap.get("module_id").toString();
			            			if (sysMap.get("in_date") != null) one_in_date =sysMap.get("in_date").toString();
			            			moduleList = moduleInfo.getModuleInfoById(one_module_id);
			            			if(moduleList!=null && moduleList.size()>0){
			            				sysMap = (HashMap)moduleList.get(0);
			            				if (sysMap.get("module_dir") != null) module_dir =sysMap.get("module_dir").toString();
			            				if (sysMap.get("module_file") != null) module_file =sysMap.get("module_file").toString();
			            			}
			            			menu_content="菜单标识："+one_menu_id+"<br>菜单描述："+one_menu_desc+"<br>加入日期："+one_in_date;//+"<br>模块标识："+one_module_id+"<br>模块文件夹："+module_dir+"<br>模块JSP文件："+module_file;
            			%>
            				<tr bgcolor="white" height="50">
											<td>
            						<%=one_menu_name%>
            					</td>
            					<td>
            						<img src="/admin/images/xiugai.gif" />
            					</td>
            					<td>
            						<img src="/admin/images/delete.gif" />
            					</td>
            					<td>
            						<img src="/img/icon8.jpg" width="16" height="16" style="cursor:hand;" onclick="testMessageBox(event,'<%=menu_content%>','<%=one_menu_name%>','250')"/>
            					</td>
										</tr>
            			<%
            					}
										}
									%>
				</table>
		</form>
	<body>
</html>



