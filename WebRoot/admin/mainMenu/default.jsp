<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<%@ page contentType="text/html;charset=GBK"%>
<%
      String path=request.getContextPath();

	HttpSession logsession = request.getSession();
	String user_id = "";
	user_id = (String)logsession.getAttribute("SESSION_USER_ID");

	String subsys_code = "SYS";
	if (request.getParameter("subsys_code") != null) {
		subsys_code = request.getParameter("subsys_code");
	}
%>
<% 	
	if(logsession.getAttribute("SESSION_USER_ID")==null){
		 
%>
			<script language="javascript">
				alert(111);
        window.location.href='/admin/index.jsp'; 
    </script>
<%		
		 
	}	
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<style type="text/css">
		.style2 { FONT-WEIGHT: bold; FONT-SIZE: x-small; COLOR: #376392; FONT-FAMILY: Arial, Helvetica, sans-serif }
	    .style3 { FONT-WEIGHT: bold; COLOR: #ffffff }
		</style>
		<!--  link href="/style/new_layout.css" rel="stylesheet" type="text/css" />-->
	</head>
		<frameset rows="103,*" cols="*" frameborder="no" border="0" framespacing="0">
			<frame src="/admin/mainMenu/top.jsp" name="top" scrolling="no" noresize>
			<frameset id="frame" cols="180,*" frameborder="no" framespacing="0" border="false">
			<frame src="/admin/mainMenu/left.jsp?subsys_code=<%=subsys_code%>" name="_left" scrolling="auto" noresize>
			<frame src="/admin/mainMenu/home.jsp" name="main" scrolling="yes" frameBorder="0">			
		</frameset>
		<noframes>
			<body bgcolor="#FFFFFF">
				<table width="100" border="4" align="center" cellpadding="10" cellspacing="2" height="100%" id="Table1">
					<tr>
						<td>&nbsp;
							
						</td>
					</tr>
				</table>
			</body>
		</noframes>
	</frameset>
</html>



