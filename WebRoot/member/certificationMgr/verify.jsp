<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%@ page import="java.text.SimpleDateFormat"%>
<%
	String verify_id = comm.GenTradeId();
	Calendar cal = Calendar.getInstance();
	String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
	String verify_type = param.getSelectItems("100");
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/certificationMgr.js"></script>
	</head>
	<body>
		<form name=parentForm action=/doTradeReg.do method=post target="_self">		
			<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
				<tr>
					<td class="u1">
						验证类型：
					</td>
					<td class="u2"><div >
							<select name="verify_type" maxlength="25">
								<%=verify_type%>
							</select>
						</div>
					</td>
						<td class="u1">
						验证证件名称：
					</td>
					<td class="u2">
						<div >
							<input type="text" name="verify_name" id="verify_name" maxlength="50" size="30">
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">申请时间：
					</td>
					<td class="u2"><div >
							<input type="text" name="req_date" id="req_date" size="10" value="<%=start%>" onfocus="setday(this);">
						</div>
					</td>
					<td class="u1">备注：
					</td>
					<td class="u2"><div class="ping1">
							<input name="remark" id="remark" size="35" maxlength="50" value="">
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						申请原由：
					</td>
					<td class="u2" colspan="3">
					<div class="ping1">
						<textarea name=req_desc style="display:none"></textarea></div>
						<iframe id="req_desc" src="/www/ewebeditor/ewebeditor.htm?id=req_desc&style=coolblue" frameborder="0" scrolling="no" width="720" height="350"></iframe>
					</td>
				</tr>
				
				<tr>
					<td class="u3" colspan="4">
						<input class="tjan" name="submit" type="submit" value="" onclick="return verifyCheck_Value()">
					</td>
				</tr>
				<input type="hidden" name="oper_date" id="oper_date" value="<%=start%>">
				<input type="hidden" name="oper_user" id="oper_user" value="">
				<input type="hidden" name="verify_status" id="verify_status" value="0">
				<input type="hidden" name="verify_id" id="verify_id" value="<%=verify_id%>">
				<input type="hidden" name="trade_type_code" id="trade_type_code" value="012">
			</table>
		</form>
	</body>
</html>




