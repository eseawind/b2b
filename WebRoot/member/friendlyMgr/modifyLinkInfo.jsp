<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custlinkMgr.*"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	if (logsession.getAttribute("SESSION_CUST_ID") != null)
	{
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	String link_no = "", link_name = "", link_type = "", rsrv_str3 = "", link_url = "";
	if (request.getParameter("link_no") != null) 
	{
		link_no = request.getParameter("link_no");
		CustlinkInfo linkInof = new CustlinkInfo();
		ArrayList inofList = linkInof.genOneCustlink(link_no, cust_id);
		if (inofList != null && inofList.size() > 0) 
		{
			HashMap map = (HashMap) inofList.get(0);
			if (map.get("link_name") != null) 
			{
		     link_name = map.get("link_name").toString();
			}
			if (map.get("link_no") != null) 
			{
		      link_no = map.get("link_no").toString();
			}
			if (map.get("link_type") != null) 
			{
		       link_type = map.get("link_type").toString();
			}
			if (map.get("rsrv_str3") != null) 
			{
		     rsrv_str3 = map.get("rsrv_str3").toString();
			}
			if (map.get("link_url") != null) 
			{
		      link_url = map.get("link_url").toString();
			}
		}
	}
	ParamethodMgr paramCom = new ParamethodMgr();
	link_type = paramCom.getItemsBySelected("29",link_type);
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/friendlyMgr.js"></script>
		
		<style type="text/css">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:13px; font-weight:bold; padding-left: 20px; padding-top: 5px;padding-bottom: 5px; }  /*横栏样式1*/
</style>
	</head>
	<body>
		<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post" target="_self">
			
			<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#dddddd">
				<input name=link_no type=hidden value="<%=link_no%>">
				<input name=trade_type_code type=hidden value=0917>
				<tr class="u1">
						<td align="left" colspan="5" bgcolor="white" class="head"> 
							<a href="modifyIndex.jsp">友情链接管理</a>
						</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right">
						链接名称：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left >
						<div class="ping">
							<input type=text name="link_name" value="<%=link_name%>">
					  </div>
					</td>
					<input type="hidden" name="link_type" value="1">

				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						链接地址：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" colspan="3">
					  <div class="ping">
							<input type=text name=link_url maxlength=50 size=50 value="<%=link_url%>">
							( http://www.xxxx.com)
					  </div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						链接说明：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left colspan="3">
					  <div class="ping">
							<textarea name=rsrv_str3 style=display:none><%=rsrv_str3%></textarea>
							<iframe id="rsrv_str3" src="/www/ewebeditor/ewebeditor.htm?id=rsrv_str3&style=coolblue&root_id=<%=link_no%>" frameborder=0 scrolling=no width=600 height=350></iframe>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px; padding-top:10px;padding-bottom:10px;" align=center colspan=4>
						<input class="xgan" name="submit" type="submit" value="" onclick="return modifyLinkInfoconfirmsub()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



