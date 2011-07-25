<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.acctMgr.CustAccount"%>
<%
	HttpSession logsession = request.getSession();
	String user_id = "", cust_id = "";
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	ParamethodMgr para = new ParamethodMgr();
	ArrayList paraList = new ArrayList();
	paraList = para.getallCompareInfoByCodeForPara("acc_out");
	CustAccount custA = new CustAccount();
	ArrayList custlist = new ArrayList();
	custlist = custA.getBankAllByCustId(cust_id);
	String account_name = "", bank_code = "", bank_id = "";
	int tt = 0;
	if (custlist != null) {
		tt = 1;
		HashMap custMap = (HashMap) custlist.get(0);
		if (custMap.get("account_name") != null) {
			account_name = custMap.get("account_name").toString();
		}
		if (custMap.get("bank_code") != null) {
			bank_code = custMap.get("bank_code").toString();
		}
		if (custMap.get("bank_id") != null) {
			bank_id = custMap.get("bank_id").toString();
		}
	}
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="JavaScript">
		function clickSel(){
			if(document.getElementById("account_name").value==''||document.getElementById("account_name").value==null){
					alert("请输入银行名称");
					document.getElementById('account_name').focus();
					return false
				}
			if(document.getElementById("bank_code").value==''||document.getElementById("bank_code").value==null){
					alert("请输入银行账号");
					document.getElementById('bank_code').focus();
					return false;
				}
			if(document.getElementById("bank_id").value==''||document.getElementById("bank_id").value==null){
					alert("请输入密码");
					document.getElementById('bank_id').focus();
					return false;
				}
		}
		</script>
	</head>
	<body>
		<form name="newform" action=/doTradeReg.do method="post"
			target="_self">
			<table width="100%" border="0" cellpadding="1" cellspacing="1"
				bgcolor="#DEEDFD">

				<tr>
					<td class="u1">
						银行名称：
					</td>
					<td class="u2" colspan="3">
						<div>
							<input name="account_name" id="account_name" type="text"
								size="30" value="<%=account_name%>">
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						账号：
					</td>
					<td class="u2">
						<input name="bank_code" id="bank_code" type="text" size="30"
							maxlength="100" onKeyUp="if(isNaN(value))execCommand('undo')"
							value="<%=bank_code%>">
					</td>
					<td class="u1">
						密码：
					</td>
					<td class="u2">
						<div>
							<input name="bank_id" id="bank_id" type="text" size="30"
								maxlength="100" value="<%=bank_id%>">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="u2">
						<center>
							<%
								if (tt == 0) {
							%>
							<input type="hidden" id="rsrv_str1" name="rsrv_str1" value="0">
							<%
								} else {
							%>
							<input type="hidden" id="rsrv_str1" name="rsrv_str1" value="1">
							<%
								}
							%>
							<input type="hidden" id="contract_no" name="contract_no" value="">
							<input type="hidden" id="user_id" name="user_id"
								value="<%=user_id%>">
							<input type="hidden" id="cust_id" name="cust_id"
								value="<%=cust_id%>">
							<input type="hidden" id="trade_type_code" name="trade_type_code"
								value="0127">
							<input class="tjan" name="bnt" type="submit" value=""
								onClick="return clickSel()">
						</center>
					</td>
				</tr>

			</table>
		</form>
		<table width="100%" border="0" cellpadding="5" cellspacing="1">
			<tr>
				<td>
					<font Color="#F98080">如果您还没有开通网上银行，选择以下银行申请您的网银账号</font>
				</td>
			</tr>
			<tr class="u1">
				<td align="left">
					<%
						if (null != paraList) {
							String bankName = "", bankUrl = "";
							for (int i = 0; i < paraList.size(); i++) {
								HashMap bankMap = (HashMap) paraList.get(i);
								if (bankMap.get("para_code2") != null) {
									bankName = bankMap.get("para_code2").toString();
								}
								if (bankMap.get("para_code1") != null) {
									bankUrl = bankMap.get("para_code1").toString();
								}
					%>
					<a href="<%=bankUrl%>" target="_blank"><%=bankName%></a>
					<%
						if ((i + 1) % 4 == 0) {
									out.println("<br>");
								}
							}
						}
					%>
				</td>
			</tr>
		</table>
	</body>
</html>




