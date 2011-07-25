<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="com.saas.biz.userMgr.UserDetailInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>

<%
	String cust_name = "", cust_id = "";
	HttpSession logsessionres = request.getSession();
	if (logsessionres.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsessionres.getAttribute("SESSION_CUST_ID")
				.toString();
		ArrayList list = new ArrayList();
		list = new Custinfo().getCustInfo(cust_id);
		if (list != null && list.size() > 0) {
			HashMap map1 = (HashMap) list.get(0);
			if (map1.get("cust_name") != null) {
				cust_name = map1.get("cust_name").toString();
			}
		}
	}
	commMethodMgr commen = new commMethodMgr();
	String trade_id = commen.GenTradeId();
	String root_id = "";

	if (request.getParameter("root_id") != null
			&& request.getParameter("root_id") != "") {
		root_id = request.getParameter("root_id");
	} else {
		root_id = "BO8SJKa0Iqg8iix";
	}
	HttpSession logsession = request.getSession();
	String user_id = "", user_name = "";
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	if (logsession.getAttribute("SESSION_USER_NAME") != null) {
		user_name = logsession.getAttribute("SESSION_USER_NAME")
				.toString();
	}
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/serviceMgr.js"></script>
	</head>
	<body>
		<%
			String top_menu_id = "";
			if (request.getParameter("menu_id") != null) {
				top_menu_id = request.getParameter("menu_id");
			}
		%>
<form method="post" name="trustpass" id="trustpass"
								action="/doTradeReg.do">
		<table width=100% border="0" align="center" cellpadding="0"
			cellspacing="0" class="mainwz">
			<tr>
				<td>
					<table scellspacing="1" cellpadding="1" width=800 bgcolor="#98D9A2"
						border="0">
						<tbody>
							
							<tr>
								<td valign="bottom" class="u1">
									<div align="right">
										类型：
									</div>
								</td>
								<td valign="bottom" nowrap="nowrap" height="26" class="u2"
									colspan="3">
									<input language="javascript" type="radio" checked="checked"
										value="4" name="word_type" />
									求助
									<input language="javascript" type="radio" value="8"
										name="word_type" />
									建议
									<input language="javascript" type="radio" value="6"
										name="word_type" />
									投诉
									<input language="javascript" type="radio" value="7"
										name="word_type" />
									表扬
									<input language="javascript" type="radio" value="5"
										name="word_type" />
									业务联系
								</td>
							</tr>
							<tr>
								<td valign="bottom" class="u1">
									<div align="right">
										主题：
									</div>
								</td>
								<td valign="bottom" class="u2">
									<input type="text" name="title" id="title" />
									<span class="STYLE1">*</span>
								</td>
								<td valign="bottom" class="u1">
									用户名：
								</td>
								<td valign="bottom" class="u2">
									<input type="text" name="user_name" id="user_name"
										value="<%=cust_name%>" />
									<span class="STYLE1">*</span>
								</td>
							</tr>
							<tr>
								<td valign="bottom" class="u1">
									电话：
								</td>
								<td valign="bottom" class="u2">
									<input type="text" name="phone" id="phone"/ >
									<span class="STYLE1">*</span>（格式如：0551-9999999）
								</td>
								<td valign="bottom" class="u1">
									E-Mail：
								</td>
								<td valign="bottom" class="u2">
									<div>
										<input type="text" name="email" id="email" />
									</div>
								</td>
							</tr>
							<tr>
								<td valign="top" rowspan="2" class="u1">
									内容：
								</td>
								<td class="u2" colspan="3">
									<textarea type="text" name="content" id="content" rows="5"
										cols="60"></textarea>
									<span class="STYLE1">*</span>
								</td>
							</tr>
							<input name="trade_id" type="hidden" value="<%=trade_id%>" />
							<input name="root_id" type="hidden" value="<%=root_id%>" />
							<input name="cust_id" type="hidden" value="<%=cust_id%>" />
							<input name="user_id" type="hidden" value="<%=user_id%>" />
							<input name="word_status" type="hidden" value="0">
							<input name="rsrv_str1" id="rsrv_str1" type="hidden" value="0">
							<input name="trade_type_code" type="hidden" value="1455">
							<tr>
								<td class="u3" colspan="3">
									<input class="tjan" name=submit1 type=submit value=""
										onclick="return formCheckout()">

								</td>
							</tr>
						</tbody>
				 </table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
	</table>
	</table></form>
	</body>
</html>




