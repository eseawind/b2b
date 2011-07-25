<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*,tools.util.StringUtil;"%>

<%
  HttpSession logsession = request.getSession();
	String user_name = "游客",user_idx="", cust_id = "";
	if (logsession.getAttribute("SESSION_USER_NAME") != null) {
		user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
	}
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_idx = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}

%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<title>留言</title>
<style type="text/css">
<!--
P,td,tr,table,text{word-break:break-all;}
-->
</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
	</head>
	<body>

<form action="/doTradeReg.do" name="loginForm" method="post" target="_self">
	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
		 
	  <tr>
	    <td>对网站的服务提建议?</td>
	    </tr>
	  <tr>
	    <td><textarea name="content" rows="4" cols="14" class="0" style="width:120; height:90;"></textarea></td>
	    </tr>
	  <tr>
	    <td><input name="textfield" type="text" class="0" size="15" /></td>
	  </tr>
	  <input type="hidden" name="rsrv_str3" id="rsrv_str3">
	  <input type="hidden" name="rsrv_str4" id="rsrv_str4">
	  <input type="hidden" name="rsrv_str5" id="rsrv_str5">
		<input type="hidden" name="session_user_id" name="session_user_id" value="<%=user_idx%>">
		<input type="hidden" name="session_cust_id" name="session_cust_id" value="<%=cust_id%>">
		<input type="hidden" name="cust_id" name="cust_id" value="<%=cust_id%>">
		<input type="hidden" name="user_id" name="user_id" value="<%=cust_id%>">
		<input type="hidden" name="sale_id" name="sale_id" value="<%=cust_id%>">
		<input type="hidden" name="deal_tag" name="deal_tag" value="5">
	  <input type="hidden" name="trade_type_code" name="trade_type_code" value="1308">
	  <tr>
	    <td><img src="/images/ly.gif" width="66" height="18" onclick="loginForm.submit()" /></td>
	  </tr>
	</table>
</form>
</body>
</html>



