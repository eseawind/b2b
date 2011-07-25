<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.organizeMgr.OrganizeInfo" scope="page" />
<%
	String cust_id="",user_id="";
	HttpSession http_Ses=request.getSession();
	if(http_Ses.getAttribute("SESSION_CUST_ID")!=null){
	  cust_id=String.valueOf(http_Ses.getAttribute("SESSION_CUST_ID"));
	}
	if(http_Ses.getAttribute("SESSION_USER_ID")!=null) {
		user_id=String.valueOf(http_Ses.getAttribute("SESSION_USER_ID"));
	}
	String cust_name=bean.getCustNameById(cust_id);
	
	UserInfo userinfo = new UserInfo();
	String user_name = "";
	user_name = userinfo.getUserNameById(user_id);
	String sale_id = "";
	if (request.getParameter("info_id") != null) {
		sale_id = request.getParameter("info_id");
	}
%>

 <html>
	<head>
		<title>成员管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		

</head>
	<body onload="startP()">
		<form name=Userform action=/doTradeReg.do method=post target="_self">
			<%
				String top_menu_id="";
				if (request.getParameter("menu_id") != null){
		        top_menu_id = request.getParameter("menu_id");
		    }
			%>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
		</table>
			<table width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#DEEDFD" align="center">
							<tr class="u4" height="27">
 								<td colspan="4" class="u2">&nbsp;&nbsp;<img src="/admin/images/newbt.gif" align="absmiddle">&nbsp;&nbsp;<font size="2"><b>举报信息</b></font></td>
							</tr>						
							<tr>
								<td width="17%" class="u1">
									用户名：								</td>
								<td colspan="3" class="u2">
								<div>&nbsp;&nbsp;&nbsp;&nbsp;<%=user_name%>	</div>							</td>
							</tr>
							<tr>
								<td width="17%" class="u1">
									标题：								</td>
								<td colspan="3" class="u2">
								<div><input type="text" name="rsrv_str3" id="rsrv_str3" value="" maxlength="20">	</div>							</td>
							</tr>
							<tr>
								<td width="17%" class="u1">
									内容：								</td>
								<td colspan="3" class="u2">
									<div>
										<textarea rows="5" cols="50" name="content" id="content">
										
										</textarea>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan=4 class="u3">
									<input class="tjan" name="submit1" type="submit" value=""  onclick="return checkValue()">&nbsp;&nbsp;
								</td>
							</tr>
						</table>
						<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>">
						<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>">
						<input type="hidden" name="session_user_id" id="session_user_id" value="<%=user_id%>">
						<input type="hidden" name="sale_id" id="sale_id" value="<%=sale_id%>">
						<input type="hidden" name="deal_tag" id="deal_tag" value="8">
						<input type=hidden name=trade_type_code value="1132" >
		</form>
	</body>
</html>
<script type="text/javascript">
		function checkValue() {			
			if(document.getElementById("rsrv_str3").value == '') {
				alert("请填写举报标题");
				return false;
			}
			if(document.getElementById("content").value == '') {
				alert("请填写举报内容");                                                  
				return false;
			}
		}
</script>
<script type="text/javascript">
		if(document.getElementById("cust_id").value == '') {
			window.location.href = "/login.html";
		}
</script>



