<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.leavewordsMgr.LeavewordsInfo"%>
<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String message_id = "";
	String title = "";
	String content = "";
	String person = "";
	String message_date = date;
	 
	if (request.getParameter("trade_id") != null) {
		message_id = request.getParameter("trade_id");
	}
	
	LeavewordsInfo wordsObj = new LeavewordsInfo();///////////////////////
	ArrayList wordsList = new ArrayList();
	if (message_id != null && !message_id.equals("")) 
	{
		wordsList = wordsObj.genOneleavewords(message_id);
		if (wordsList != null && wordsList.size() > 0)
		 {
			HashMap map = (HashMap) wordsList.get(0);
			message_id = map.get("trade_id").toString();
			if (map.get("title") != null) {
				title = map.get("title").toString();
			}
			if (map.get("content") != null) {
				content = map.get("content").toString();
			}
			if (map.get("user_name") != null) {
				person = map.get("user_name").toString();
			}
			if (map.get("in_date") != null) {
				message_date = map.get("in_date").toString();
				if (message_date.length() > 10) {
					message_date = message_date.substring(0, 10);
				}	
			}
			 
		}
	}
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script language="JavaScript">
    	function exit()
    	{
    	    window.close();
    	}
      </script>
	</head>
	<body>
		<table width="818" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td height="26" background="/img/bg-1.gif">&nbsp;</td>
			</tr>
			<tr>
				<td background="/img/bg-2.gif">
					<table width=93% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
						<tr>
							<td class="line1" align="left" colspan="2">
								查看留言
							</td>
						</tr>
						<tr>
						</tr>
				<!-- 	<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right width=15%>
								留言标题：
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width=85%>
								<%=title%>
							</td>
						</tr>
				 -->			
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right valign="top">
								留言内容：
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<%=content%>
							</td>
						</tr>
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
								留言人：
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<%=person%>
							</td>
						</tr>
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
								留言日期：
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
								<%=message_date%>
							</td>
						</tr>
						 
						<tr>
							<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px; padding-top:10px;padding-bottom:10px;" align="center" colspan="2">
								<input class="gban" name=button1 type=button value="" onclick=exit()>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="46" background="/img/bg-3.gif">&nbsp;</td>
			</tr>
		</table>
	</body>
</html>





