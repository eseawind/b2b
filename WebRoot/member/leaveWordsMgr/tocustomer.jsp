<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<jsp:useBean id="info" class="com.saas.biz.custMgr.Custinfo"
	scope="page" />
<%
	String custOption = "", user_id = "", cust_id = "";
	HttpSession logsession = request.getSession();
	custOption = info.getAllCustList();
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	String trade_id = bean.GenTradeId();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>B2B���������̨����ϵͳ</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/js/hrJobMgr.js"></script>
		<script language="JavaScript">
				function checkValue(){
					
					if($("title").value=="")
					 {
					 	alert("����д�����⣡");
					 	return false;
					 	
					 	}
					 	if($("content").value=="")
					 {
					 	alert("����д��Ϣ���ݣ�");
					 	 	return false;
					 	}
					 	document.classForm.submit();
					}
				function changeTarget(val){
					
					document.getElementById("word_type").value="a";
					}
					function dselect(){
						var dd=document.getElementById("all");
						dd.checked=false;
						document.getElementById("word_type").value="b";
						}
				</script>
	</head>
	<body>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30">
				</td>
			</tr>
			<tr>
				<td background="/admin/images/content_03.gif" height="43"
					width="156" align="center">
					<font size="2"><b>������Ϣ</b>
					</font>
				</td>
				<td background="/admin/images/content_04.gif" align="right">
					&nbsp;
				</td>
				<td width="8">
					<img src="/admin/images/content_06.gif">
				</td>
			</tr>
		</table>
		<form name="classForm" method="post" action="/doTradeReg.do"
			target="_self">
			<table width=800 border=0 cellpadding=5 cellspacing=1 align=center
				bgcolor="#DEEDFD">
				<tr>
					<td class="u1" height="20">
						��ϢĿ��ͻ�
					</td>
					<td height="20">
						<select id="cust_id" name="cust_id" onclick="dselect();">
							<%=custOption%>
						</select>
						��ȫ���û�����
						<input type="radio" name="all" id="all" value="a"
							onclick="changeTarget(this.checked)">
						</radio>
					</td>
				</tr>
				<tr>
					<td class="u1" width="13%">
						��Ϣ���⣺
					</td>
					<td class="u2" width="87%">
						<input type="text" maxlength="200" size="48" name="title"
							id="title" />
					</td>
				</tr>
				<tr>
					<td class="u1" width="15%">
						��Ϣ���ݣ�
					</td>
					<td class="u2" width="35%">
						<textarea type="text" name="content" id="content" rows="5"
							cols="60"></textarea>
					</td>
				</tr>
				<tr>
					<td class="u1" width="15%">
						�ظ�ʱ�䣺
					</td>
					<td class="u2" width="35%">

					</td>
				</tr>
				<input type="hidden" name="trade_id" value="<%=trade_id%>">
				<input type="hidden" name="user_id" value="<%=user_id%>">
				<input type="hidden" name="word_type" value="b">
				<input type="hidden" name="root_id" value="">
				<input type="hidden" name="user_name" value="">
				<input type="hidden" name="trade_type_code" value="0066">
				<input type="hidden" name="phone" value="">
				<input type="hidden" name="email" value="">
				<input type="hidden" name="word_status" value="0">
			</table>
			<table cellspacing="1" cellpadding="3" width=800 bgcolor="#efefef"
				border="0" align="center">
				<tr>
					<td bgcolor="white" colspan="2" align="center">
						<input class="tjan" name=submit1 type=button value=""
							onclick="checkValue();">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>





