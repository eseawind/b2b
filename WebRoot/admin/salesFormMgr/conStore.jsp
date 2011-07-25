<%@ page contentType="text/xml; charset=gbk" language="java" errorPage=""%>
<%@ page language="java" import="java.io.PrintWriter"%>
<%@ page import="com.saas.biz.relationUuMgr.RelationUUInfo" %>
<%
    HttpSession logsession = request.getSession();
	String user_id = "";
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	response.setHeader("Cache-Control", "no-cache");
	PrintWriter xmlout = response.getWriter();
	int start = 0;
	if(request.getParameter("start")!=null){
	  start=Integer.parseInt(request.getParameter("start"));
	}
	RelationUUInfo store=new RelationUUInfo();
	String json=store.getJsonStore(user_id,"1",10,start);
	
	xmlout.write(json);
%>




