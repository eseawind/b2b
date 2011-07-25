<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%
      String user_id="",user_name="",web_login_tag="";
      UserInfo userInfo=new UserInfo();
	   if(request.getParameter("u") != null) 
	   {
	   		user_id = request.getParameter("u");
	   		user_name =userInfo.getUserName(user_id);
	   		web_login_tag = userInfo.getUserWebLoginTag(user_id);
	   }
	   
%>
<html>
	<head>
		<title>ÐÂ¿Í»§×¢²á</title>
		<link rel="stylesheet" type="text/css" href="/templates/default/style/layout.css" />
		<link rel="stylesheet" type="text/css" href="/templates/default/style/login.css" />
</head>
<body>
<form  name="userForm" id="userForm" action="/doAutoActTradeReg.do" method="post" target="_self">
		<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>"> 
		<input type="hidden" name="trade_type_code" value="4647"> 
</form>
</body>
</html>


<script language="javascript">
	var user_id = document.getElementById('user_id').value;
	if(user_id!=''){
		document.userForm.submit();
	}
</script>	





