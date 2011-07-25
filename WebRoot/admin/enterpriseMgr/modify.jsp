<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="tools.util.FileIO"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileReader"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.Reader"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>

<%
	String cust_name = "", cust_id = "";
	if (request.getParameter("cust_name") != null) 
	{
		cust_name = request.getParameter("cust_name");
	}
	if (request.getParameter("cust_id") != null) 
	{
		cust_id = request.getParameter("cust_id");
	}
	String filePath = "", output = "", htmlcode = "";
	filePath = "/usr/www/b2b.bizoss.com/templates/enterprise/" + cust_id + "/" + cust_name;
	File file = new File(filePath);
	Reader fileName = new FileReader(file);
	BufferedReader re = new BufferedReader(fileName);
	while (re.ready()) 
	{
		output = re.readLine();
		htmlcode = htmlcode + "\n" + output;
	}
%>


<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<style type="text/css">
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:13px; font-weight:bold; padding-left: 20px; padding-top: 5px;padding-bottom: 5px; }  /*横栏样式1*/
		</style>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<SCRIPT language=javascript src="/js/enterpriseMgr.js" type=text/javascript></SCRIPT>
	</head>
	<body>
		<form name=formQuery action=/doTradeReg.do method=post target="_self">
			<bean:define id="cnt" value="<%=htmlcode%>" />
			<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td height="13px">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
							<tr>
								<td class="line1" align="left" colspan="2">
									修改模板代码

								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right width="15%">
									网页标题
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width="85%">
									<input name="file_name" id="file_name" value=<%=cust_name%> readonly>
									&nbsp; [文件名不能修改]

								</td>

							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px;" align=right valign=top>
									网页代码编辑区
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
									<textarea name="content" id="content" style="display:none">
									<bean:write name="cnt" />
								</textarea>
									<iframe ID=content src="/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=11111111" frameborder=0 scrolling=no width=100% HEIGHT=550></iframe>
								</td>
							</tr>
							<tr>
								<input type="hidden" name="path" value="<%=filePath%>">
								<input name="trade_type_code" type="hidden" value="1150" />
								<td align=center style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px; padding-top:10px;padding-bottom:10px;" colspan=2>
									<input class="tjan" name="submit" type="submit" value="提 交" onclick="return confirmsub()">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="12px">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




