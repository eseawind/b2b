<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%
	String user_id = "", cust_id = "";

	HttpSession logsession = request.getSession();

	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	String passwd ="";
	if(request.getParameter("passwd")!=null){
		passwd = request.getParameter("passwd");
	}   
	UserInfo user = new UserInfo();
	int i = 2;
	if(!passwd.equals("")){
		i = user.getUserName(user_id,passwd);
	}
	String dis="block",dis1="none";
	if(i == 1){
		dis="none";
		dis1="block";
	}else if(i!=2){
	%>
	<script>
		alert('密码输入不正确，请重新输入！');	
	</script>
	<%
			
	}
	
	
%>
<html>
	<head>
		<title>用户密码修改</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script language="JavaScript">

			function checkPW(){
				var pass = document.getElementById('passwd').value;
				var pass1 = document.getElementById('passwd1').value;
				if(pass != pass1){
					alert('两次密码输入不正确！');
					document.getElementById('passwd1').value='';
					document.getElementById('passwd').value='';
					document.getElementById('passwd').focus();
					return false;
				}
				//alert(document.getElementById('user_id').value);
				//alert(pass);
				//UserInfo.getUserName(document.getElementById('user_id').value,pass,checkResult);
			}
			function checkPWS(){
				var pass = document.getElementById('password').value;
				var pass1 = document.getElementById('password1').value;
				if(pass != pass1){
					alert('两次密码输入不正确！');
					document.getElementById('password1').value='';
					document.getElementById('password').value='';
					document.getElementById('password').focus();
					return false;
				}
			}
			function checkResult(val){
				if(val=='1'){
					document.getElementById('oldPass').style.display=='none';
					document.getElementById('newPass').style.display=='block';
				}else{
					alert('对不起，您输入的密码不正确！');
				}
			}

		</script>
	</head>
	<body>
		<%
				String top_menu_id="";
				if (request.getParameter("menu_id") != null){
		        top_menu_id = request.getParameter("menu_id");
		    }
			%>
	<form action="modifyPW.jsp" method="post" name="modifyPWForm" target="_self">
				<div id="oldPass" style="display: <%=dis%>">
						<table width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#98D9A2" align="center">
							<tr>
								<td class="u1">
									请输入旧密码：
								</td>
								<td class="u2">
									<input name="passwd" type=password id="passwd" size="30">
								</td>
							</tr>
							<tr>
								<td class="u1">
									请确认旧密码：
								</td>
								<td class="u2">
									<input name="passwd1" type=password id="passwd1" size="30">
								</td>
							</tr>
							<tr>
								<td class="u3" colspan=2>
									<input class="tjan" name="tjan" type=submit value="" onclick="return checkPW()">
									<input name="user_id" type=hidden id="user_id" value="<%=user_id%>">
									<input name="cust_id" id="cust_id" type=hidden value="<%=cust_id%>">
									
								</td>
							</tr>
						</table>
		</div>
		</form>
		<form action="/doTradeReg.do" method="post" name="modifyPwsForm" target="_self">
		<div id="newPass" style="display: <%=dis1%>">
						<table width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#98D9A2" align="center">
							<tr>
								<td class="u1">
									请输入新密码：
								</td>
								<td class="u2">
									<input name="password" type=password id="password" size="30">
								</td>
							</tr>
							<tr>
								<td class="u1">
									请确认新密码：
								</td>
								<td class="u2">
									<input name="password1" type=password id="password1" size="30">
								</td>
							</tr>
							<tr>
								<td class="u3" colspan=2>
									<input class="tjan" name="tjan" type=submit value="" onclick="return checkPWS()">
									<input name="user_id" id="user_id" type=hidden value="<%=user_id%>">
									<input name="cust_id" id="cust_id" type=hidden value="<%=cust_id%>">
									<input name="menu_id"  type=hidden value="<%=top_menu_id%>">
									<input name="trade_type_code" id="trade_type_code" type=hidden value="6010">
								</td>
							</tr>
						</table>
					
		</div>
		</form>
	</body>
</html>


