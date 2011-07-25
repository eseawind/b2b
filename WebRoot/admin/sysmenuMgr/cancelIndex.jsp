<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%
//    commMethodMgr commen = new commMethodMgr();
    String id ="";// commen.GenTradeId();
     String menu_id = "";
    if (request.getParameter("menu_id") != null)
    {
        menu_id = request.getParameter("menu_id");
    }
%>
<html>
<head>
<title>×¢Ïú»áÔ±</title> 
    <link href="/style/layout.css" rel="stylesheet" type="text/css">
    <link href="/style/daohang.css" rel="stylesheet" type="text/css">
    <link href="/style/manager.css" rel="stylesheet" type="text/css">
    <script src="/www/fuction/calendar.js" type="text/javascript"></script>
    <script language="JavaScript" src="/www/fuction/public.js"></script>
</head>
<body>	

      <%@ include file="cancelCustomer.jsp"%>

</body>
</html>


