<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<html xmlns="http://www.w3.org/1999/xhtml">
 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>运营商登录页</title>
		<link href="css/yun.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="../js/member.js"></script>
		<style type="text/css">
<!--
body {
	background-image: url(image/yun_01.jpg);
}
-->
</style>
		<script language="javascript">
    function reset_Value()
    {
    document.loginForm.reset();
     }
    
    function Check_Value()
    	{
    		if (document.getElementById("user_name").value == ""||document.getElementById("user_name").value == null)
    		{
    			alert('用户名不可以为空！');
    			document.getElementById("user_name").focus();
    			return false;
    		}
    		if (document.getElementById("passwd").value == ""||document.getElementById("passwd").value == null)
    		{
    			alert("密码不可以为空！");
    			document.getElementById("passwd").focus();
    			return false;
    		}
            if (document.getElementById("userrand").value == ""||document.getElementById("userrand").value == null)
    		{
    			alert("请输入验证码！");
    			document.getElementById("userrand").focus();
    			return false;
    		}
    		document.loginForm.submit();
    	}
    	function keysubmit(obj)
		  	{
				 if(event.keyCode != "13") return;
				if (obj.user_name.value == ""||obj.user_name.value == null)
				{
					alert("用户名不可以为空！");
					return false;
				}
				if (obj.passwd.value == ""||obj.passwd.value == null)
				{
					alert("密码不可以为空！");
					return false;
				}
		        if (obj.userrand.value == ""||obj.userrand.value == null)
				{
					alert("请输入验证码！");
					return false;
				}
				obj.submit();
		 }
    	</script>
	</head>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				String tempuid_1 = cookies[i].getName();

				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	%>
	<body>
		<table width="1003" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="670" valign="top">
					<table width="100%" height="605" border="0" align="right"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="37%" height="105">
								&nbsp;
							</td>
							<td width="41%">
								&nbsp;
							</td>
							<td width="22%">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="46%" height="18">
											&nbsp;
										</td>
										<td width="54%">
											&nbsp;
										</td>
									</tr>
									<tr>
										<td height="26">
											&nbsp;
										</td>
										<td>
											<img src="image/zi1.gif" width="160" height="55">
										</td>
									</tr>
								</table>
								<table width="100%" border="0" cellspacing="2" cellpadding="0">
									<tr>
										<td width="42%">
											&nbsp;
										</td>
										<td width="58%">
											<img src="image/zi2.gif" width="135" height="55">
										</td>
									</tr>
								</table>
								<table width="100%" border="0" cellspacing="2" cellpadding="0">
									<tr>
										<td width="34%">
											&nbsp;
										</td>
										<td width="66%">
											<img src="image/zi3.gif" width="164" height="54">
										</td>
									</tr>
								</table>
								<table width="100%" border="0" cellspacing="2" cellpadding="0">
									<tr>
										<td width="51%">
											&nbsp;
										</td>
										<td width="49%">
											<img src="image/zi4.gif" width="135" height="50">
										</td>
									</tr>
								</table>
							</td>
							<td width="41%" height="369" valign="top"
								background="image/yun_02.jpg">
								<form action="../newstafflogin.do" name="loginForm" method="post">
									<table width="100%" height="248" border="0" cellpadding="0"
										cellspacing="3">
										<tr>
											<td width="144" height="90">
												&nbsp;
											</td>
											<td width="66">
												&nbsp;
											</td>
											<td width="189">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
											<td height="26" class="css2">
												用户名：
											</td>
											<td>
												<div align="left">
													<input name="user_name" id="user_name" type="text"
														class="login_form">
												</div>
											</td>
										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
											<td height="26" class="css2">
												密码：
											</td>
											<td>
												<div align="left">
													<input name="passwd" id="passwd" type="password"
														class="login_form">
												</div>
											</td>
										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
											<td height="26" class="css2">
												验证码：
											</td>
											<td>
												<div align="left">

													<input name="userrand" id="userrand" type="text" size="4"
														maxlength="4" class="0" onKeyDown="keysubmit(loginForm)"
														class="login_form">
													<img src="../checkImage" id="rc" onClick="changeCode2()">
												</div>
											</td>
										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
											<td height="26" class="css2">
												记录登录：
											</td>
											<td>
												<div align="left">

													<select name="cookietime" id="cookietime">
														<option value="315360000">
															永久
														</option>
														<option value="315360000">
															一年
														</option>
														<option value="2592000">
															一个月
														</option>
														<option value="86400">
															一天
														</option>
														<option value="3600">
															一小时
														</option>
														<option value="1">
															浏览器进程
														</option>
													</select>
												</div>
										</tr>
										<tr>
											<td height="44" colspan="3">
												<div align="center">

													<a href="javascript:Check_Value()"> <img
															src="image/ban1.gif" width="67" height="23" border="0"
															align="top" style="cursor: hand;"
															onClick="return Check_Value()">
													</a> &nbsp;&nbsp;&nbsp;&nbsp;
													<img src="image/ban2.gif" width="67" height="23"
														style="cursor: hand;" onClick="return reset_Value()">
												</div>
											</td>
										</tr>
									</table>
									<input name="trade_type_code" type="hidden" value="0123">
								</form>
							</td>
							<td>
								&nbsp;
							</td>
						</tr>
						<tr valign="bottom">
							<td height="131" colspan="3">
								<table width="85%" height="1" border="0" align="center"
									cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
									<tr>
										<td></td>
									</tr>
								</table>
								<br>
								<table width="100%" height="57" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td>
											<div align="center" style="font-size: 12px">
												<a href="http://www.bizoss.com/html/b2b/2009/0619/9.html">系统概述
												</a> |
												<a href="http://www.bizoss.com/html/b2b/2009/0619/10.html">功能概要
												</a> |
												<a href="http://www.bizoss.com/html/b2b/2009/0619/11.html">功能和特点
												</a> |
												<a href="http://www.bizoss.com/html/b2b/2009/0619/12.html">报价方案
												</a> |
												<a href="http://www.bizoss.com/html/b2b/2009/0619/12.html">报价方案
												</a> |
												<a
													href="http://www.bizoss.com/html/customer/2009/0619/7.html">客户与合作伙伴
												</a>
												<br>
												<img src="../templates/default/images/ucs2.gif">
												销售咨询：
												<a
													href="http://wpa.qq.com/msgrd?V=1&Uin=923462250&Site=a-hai.net&Menu=yes tencent://message/?uin=923462250">923462250
												</a>
												<a
													href="http://wpa.qq.com/msgrd?V=1&Uin=1182350564&Site=a-hai.net&Menu=yes tencent://message/?uin=1182350564">1182350564
												</a>
												<a href="http://www.bizoss.com">合肥贞龙信息科技有限责任公司 </a> 版权所有 @
												2008 保留所有权利
												<a href="http://www.miibeian.gov.cn/">皖ICP备05015140号 </a>
												<br>
												服务热线：0551-5310317 | 传真：0551-5310317
												<img src="../favicon.gif"/>
												Powered by
												<a href="http://www.bizoss.com">BizOss </a>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<br>
					<br>
				</td>
			</tr>
		</table>
	</body>
</html>
