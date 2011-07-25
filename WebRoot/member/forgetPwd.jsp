<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../ext/ext-all.js"></script>
		<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/ParamethodMgr.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/UserInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
    <script language="javascript" src="/js/member.js"></script>
	</head>
	<body>
		<jsp:include flush="true" page="/include/top.jsp" />
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<table width="727" border="0" cellspacing="0" cellpadding="0" align="center" style="margin-top: 25px">
				<tr>
					<td height="2"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width=727 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=center width="100%" colspan="2">
									找回密码
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right width="25%">
									系统帐号：
								</td>
								<td align=left bgcolor="#FFFFFF" width="75%">
									<div class="ping">
										<input type="text" name="user_name" id="user_name" size="25" maxlength="100">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									客户名称：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input name="cust_name" id="cust_name" size="25" type="text" maxlength="100">
									</div>
								</td>
							</tr>
							<tr id="hide0" style="display:none">
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=left colspan="2">
									密码提示问题
								</td>
							</tr>
							<tr id="hide4" style="display:none">
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									<div id="request"></div>
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input name="passwd_answer" id="passwd_answer" size="15" type="text" maxlength="100" onblur="checkAnswer(this.value)">
									</div>
								</td>
							</tr>
							<tr id="hide3" style="display:none">
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									邮件地址：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input name="email" id="email" size="25" type="text" maxlength="100">(接收系统发送的密码信箱！)
									</div>
								</td>
							</tr>
							<tr id="hide1">
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;" align="center" colspan="2">
									<input name="comit" type="button" value="" onclick="confirmsub()" style="background-image: url('/admin/images/xyb.gif');width:70px;height: 26px;border:0;cursor:hand">
								</td>
							</tr>
							<input type="hidden" name="trade_type_code" value="1160">
							<tr id="hide2" style="display:none">
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;" align="center" colspan="2">
									<input name="commit" type="submit" value="" onclick=" return check()" style="background-image: url('/admin/images/tj.gif');width:70px;height: 26px;border:0;cursor:hand">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="13"></td>
				</tr>
			</table>
		</form>
		<jsp:include flush="true" page="/include/footer.jsp" />
	</body>
</html>





