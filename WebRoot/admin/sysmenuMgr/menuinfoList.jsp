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
		<title>�˵�����</title>
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
    	sysTable = "block";//�÷����TABLE��ʾ
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
									<input type="button" name="oneMenu" id="oneMenu" value="���һ���˵�" onclick="showSysTable()"/>
									
									<input type="hidden" name="code" id="code" value="1"><!--�����������������ִ���ĸ�����-->
									
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" name="oneMenu" id="oneMenu" value="��Ӷ����˵�" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" name="oneMenu" id="oneMenu" value="��������˵�" />
							</td>
						</tr>
				</table>
				<table width="800" cellspacing="1" cellpadding="1" bgcolor="#dddddd" style="display:<%=sysTable%>;">
						<tr bgcolor="white">
							<td align="left">
								��ѡ�����
									<%
										String sysname = "",syscode = "",addOneMenuContent="";
//addOneMenuContent = "<form method=post name=addOneMenuForm action=/doTradeReg.do target=_self>"+
//										"	<table width=100% cellpadding=1 cellspacing=1 bgcolor=#efefef>          "+ 
//										"		<tr bgcolor=white>                                                    "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					��������                                                        "+ 
//										"			</td>                                                               "+ 
//										"			<td>                                                                "+ 	                                                                 
//										"			</td>                                                               "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					�˵�����                                                        "+
//										"			</td>                                                               "+ 
//										"			<td>                                                                "+ 
//										"					<input type=text name=menu_name >                               "+ 
//										"			</td>                                                               "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					ģ��ID��                                                        "+ 
//										"			</td>                                                               "+ 
//										"			<td>                                                                "+ 
//										"					<input type=text name=module_id >                               "+ 
//										"			</td>                                                               "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					ģ���ļ��У�                                                    "+ 
//										"			</td>                                                               "+ 
//										"			<td>                                                                "+ 
//										"					<input type=text name=module_dir >                              "+ 
//										"			</td>                                                               "+ 
//										"			<td width=\"20%\">                                                      "+ 
//										"					ģ��JSP���ƣ�                                                   "+ 
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
								<img src="/admin/images/newAdd.gif" style="cursor:hand;" onclick="testMessageBox(event,<%=addOneMenuContent%>,'���һ���˵�','400')"/>
							</td>
						</tr>
				</table>
				<table width="800" cellspacing="1" cellpadding="1" bgcolor="#dddddd" style="display:<%=oneMenuTable%>;">
						<tr bgcolor="white">
							<td>
								<b>�˵�����</b>
							</td>
							<td>
								<b>�޸�</b>
							</td>
							<td>
								<b>ɾ��</b>
							</td>
							<td>
								<b>�鿴��ϸ</b>
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
			            			menu_content="�˵���ʶ��"+one_menu_id+"<br>�˵�������"+one_menu_desc+"<br>�������ڣ�"+one_in_date;//+"<br>ģ���ʶ��"+one_module_id+"<br>ģ���ļ��У�"+module_dir+"<br>ģ��JSP�ļ���"+module_file;
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



