<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.enquirydealMgr.EnquirydInfo"%>
<%
	String trade_id = "";
	if (request.getParameter("trade_id") != null) {
		trade_id = request.getParameter("trade_id");
	}
	String title="",content="";
	EnquirydInfo enquiry = new EnquirydInfo();
	HashMap enMap = enquiry.getEnquiryInfoById(trade_id,"1");
	if(enMap.get("rsrv_str3")!=null){
		title = enMap.get("rsrv_str3").toString();
	}
	if(enMap.get("enquiry_content")!=null){
		content = enMap.get("enquiry_content").toString();
	}
	//out.println(trade_id+"*******");
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<center>
		<!--table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>提问查看</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table-->
		<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
			<tr bgcolor="white">
					<td class="u1" width="15%">
						标题： 
					</td>
					<td align="left" width="85%">
							<%=title%>
					</td>
			</tr>
			<tr bgcolor="white">
					<td class="u1">
						内容： 
					</td>
					<td align="left">
							<%=content%>
					</td>
			</tr>
			<tr bgcolor="white">
					<td align="center" colspan="2" style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">
						<img src="/admin/images/comeback.JPG" onClick="javascript:window.history.go(-1);" style="cursor:hand;">
					</td>
			</tr>
		</table>
	</center>
	</body>
</html>


