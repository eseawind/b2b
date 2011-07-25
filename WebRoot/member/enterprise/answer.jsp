<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.enquirydealMgr.EnquirydInfo"%>
<%	
	String user_id = "";
	HttpSession logsession = request.getSession();
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	String trade_id = "";
	if (request.getParameter("trade_id") != null) {
		trade_id = request.getParameter("trade_id");
	}

	EnquirydInfo enqrinfo = new EnquirydInfo();
	HashMap map = enqrinfo.getEnquiryInfoById(trade_id ,"7");
%>

<html>
	<head>
		<title>B2B电子商务</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/enterprise.js"></script>
		<style type="text/css">
.chaxun{
		background:url(/images/chaxun.gif) left center no-repeat;
		width:70px;
	 	height:26px;
		border:0px; 
	 	cursor:hand;
	}
</style>
	</head>
	<body>
	<form action="/doTradeReg.do" method="post" name="answerform">
		<table width="100%" border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
			<tr>
				<td class="line1" align="left" colspan="2">
					<table width="100%" border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
						<tr>
							<td>
								评论详细信息
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<%
				String rsrv_str3 = "",enquiry_content = "" ,rsrv_str5 = "",enquiry_date = "";
				if (map.get("rsrv_str3") != null) {
					rsrv_str3 = map.get("rsrv_str3").toString();
				}
				if (map.get("enquiry_content") != null) {
					enquiry_content = map.get("enquiry_content").toString();
				}
				if (map.get("rsrv_str5") != null) {
					rsrv_str5 = map.get("rsrv_str5").toString();
				}
				if (map.get("enquiry_date") != null) {
					enquiry_date = map.get("enquiry_date").toString();
				}
			%>
			<tr>
				<td
					style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;"
					align=right width=15%>
					标题	
				</td>
				<td
					style="background-color:#ffffff; color:#000000;  font-size:12px;"
					align=left width=85%>
					<span style="color: red"><%=rsrv_str3%></span>
				</td>
			</tr>
			<tr>
				<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right width=15%>
					内容
				</td>
				<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width=85%>
					<%=enquiry_content%>
				</td>
			</tr>
			<tr>
				<td
					style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;"
					align=right valign="top">
					评论人
				</td>
				<td
					style="background-color:#ffffff; color:#000000;  font-size:12px;"
					align=left>
					<%=rsrv_str5%>
				</td>
			</tr>
			<tr>
				<td
					style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;"
					align=right valign="top">
					评论时间
				</td>
				<td
					style="background-color:#ffffff; color:#000000;  font-size:12px;"
					align=left>
					<%=enquiry_date%>
				</td>
			</tr>
			<tr>
				<td
					style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;"
					align=right valign="middle">
					您的回复
				</td>
				<td
					style="background-color:#ffffff; color:#000000;  font-size:12px;"
					align=left>
					<textarea rows="6" cols="50" id="content" name="content"></textarea>
					<input type="hidden" id="trade_type_code" name="trade_type_code" value="1309">
					<input type="hidden" id="enquiry_id" name="enquiry_id" value="<%=trade_id%>">
					<input type="hidden" id="rsrv_str1" name="rsrv_str1" value="1">
					<input type="hidden" id="trade_id" name="trade_id" value="<%=trade_id%>">
					<input type="hidden" id="deal_tag" name="deal_tag" value="7">
					<input type="hidden" id="session_user_id" name="session_user_id" value="<%=user_id%>">
				</td>
			</tr>
			<tr>
				<td align="center"
					style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;padding-top:10px;padding-bottom:10px;"
					colspan="2">
					<img src="/admin/images/tj.gif" onclick="answerchick()" style="cursor: hand;"> 
				</td>
			</tr>
		</table>
	  </form>
	</body>
</html>



