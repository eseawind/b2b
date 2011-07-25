<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="com.ahbay.commenMgr.*" %>
<%
	loggerMgr logger = new loggerMgr(); 
	String xxuser = (String)session.getAttribute("SESSION_USER_NAME");
	if(xxuser==null)
	xxuser="-guest-";
	String tag="";
	tag = logger.AddLoggerinfo(request.getRequestURI(),request.getQueryString(),request.getHeader("referer"),request.getHeader("user-agent"),request.getRemoteHost(),xxuser);	
	//out.print(tag);
%>




