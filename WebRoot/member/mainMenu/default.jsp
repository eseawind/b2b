<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<%@ page contentType="text/html;charset=GBK"%>

<%
	String subsys_code = "B2B";
	if (request.getParameter("subsys_code") != null) {
		subsys_code = request.getParameter("subsys_code");
		if(subsys_code=="out" || subsys_code.equals("out")){
		 %>
		  <jsp:forward page="/member/out.jsp"/>
		 <%
		 return;
		}
	}
%>
<% 
	HttpSession logsession = request.getSession();
	String se_cust_id = "";
	if(logsession.getAttribute("SESSION_CUST_ID")!=null){
		se_cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if(se_cust_id.equals("")){
		 
%>

<%		
		 
	}	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>电子商务室</title>
	<LINK href="/member/mainMenu/images/admin.css" type="text/css" rel="stylesheet">
</head>
	<frameset rows="103,*" cols="*" frameborder="no" border="0" framespacing="0">
		<frame src="/member/mainMenu/top.jsp" name="top" scrolling="no" noresize>
		<frameset id="frame" cols="13%,68%" frameborder="no" framespacing="0" border="false">
			<frame src="/member/mainMenu/left.jsp?subsys_code=<%=subsys_code%>" name="_left" scrolling="no" noresize="noresize">
			<frame src="/member/mainMenu/home.jsp" name="main" scrolling="auto" frameBorder="0">

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



