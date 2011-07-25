<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.resumeMgr.ResumeInfo"%>
<%
    HttpSession  logsessions = request.getSession(); 
     String user_id="";
     if (logsessions.getAttribute("SESSION_USER_ID") != null)
     {
        user_id = logsessions.getAttribute("SESSION_USER_ID").toString();
     }
     String menu_id = "";
    if (request.getParameter("menu_id") != null)
    {
        menu_id = request.getParameter("menu_id");
    }
    ResumeInfo resume=new ResumeInfo();
    ArrayList resumeList=resume.genResumeByUser_Id(user_id);
    boolean isShow=true;
    if(resumeList!=null && resumeList.size()>0)
    {
        isShow=false;
    }
%>
<html>
<head>
<title>B2B电子商务后台管理系统</title> 
    <link href="/style/layout.css" rel="stylesheet" type="text/css">

    <script src="/www/fuction/calendar.js" type="text/javascript"></script>
    <script language="JavaScript" src="/www/fuction/public.js"></script>
</head>
<body>	
     <%
         if(isShow)
         {
     %>
         <%@ include file="resumeIsEmpty.jsp"%>
    <%}
        else
        {
         %>
         <%@ include file="updateResumeInfo.jsp"%>
         <%
        }	
    %>
                          
</body>
</html>





