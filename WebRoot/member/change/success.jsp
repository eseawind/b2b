<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="tools.util.DateUtils"%>
<html>
	<head>
		<title>信息完整</title>
<link rel="stylesheet" href="images/style.css" type="text/css" />
		<script language="JavaScript">
			</script>
	</head>
	<body>
		<%
			 String cust_id = "";String tabn="",class_name="",cust_name="";
			    Custinfo custInfo=new Custinfo();
			if(session.getAttribute("SESSION_CUST_ID")!=null){
				cust_id = session.getAttribute("SESSION_CUST_ID").toString();
			}
			  class_name=custInfo.getCustClassName(cust_id);
        cust_name=custInfo.getCustomerNameById(cust_id);
			%>
    <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#ffffff">
<tr><td width="20%"></td></tr>
                        <tr><td class="u4">用户信息</td><td></td></tr>
<tr><td bgcolor="#ffffff" colspan="2">
						<table width=100% border=0 cellpadding=0 cellspacing=0 align=center bgcolor="#ffffff">
							<tr>
								<td align="center" valign="middle" height="100">
								<span style=" color:#003399; font-size:14px; font-weight:bold; font-family:"宋体";">你好<%=cust_name%>！	</span>	</td>
							</tr>
						</table>
        </td></tr></table>
	</body>
</html>




