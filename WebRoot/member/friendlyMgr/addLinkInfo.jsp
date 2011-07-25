<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%
	ParamethodMgr paramCom = new ParamethodMgr();
	String link_type = paramCom.getSelectItems("29");
	commMethodMgr commen = new commMethodMgr();
	String link_no = commen.GenTradeId();
	HttpSession  logsession = request.getSession();
	String cust_id=""; 
	if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
%>

<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style type="text/css">
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px; font-weight:bold; padding-left: 20px; padding-top: 5px;padding-bottom: 5px; }  /*横栏样式1*/
		</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/CustlinkInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script language="javascript" src="/js/friendlyMgr.js"></script>
	</head>
	<body>
		<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post" target="_self">

	  <table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#dddddd">
				<input name=link_no type=hidden value="<%=link_no%>">
				<input name=trade_type_code type=hidden value=0297>
				<input type=hidden name=trade_type_code value=0343>
				<tr class="u1">
						<td align="left" colspan="5" bgcolor="white" class="head"> 
							<a href="modifyIndex.jsp">友情链接管理</a>
						</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right width="15%">
						链接名称：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width="85%">
					  <div class="ping">
						<input type=text name="link_name" maxlength=50 size=50>
					  </div>
					</td>
				</tr>
				<input type="hidden" name="link_type" value="0">
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						链接地址：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
					  <div class="ping">
						<input type=text name="link_url" id="link_url" maxlength=50 size=50 value="http://" onblur="addLinkInfourlCheck()">
						(如： http://www.bizoss.com)
					    </div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						链接说明：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<textarea name=rsrv_str3 style=display:none></textarea>
						<iframe id="rsrv_str3" src="/www/ewebeditor/ewebeditor.htm?id=rsrv_str3&style=coolblue&root_id=<%=link_no%>" frameborder=0 scrolling=no width=600 height=350></iframe>
					</td>
				</tr>
				<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>"/>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px; padding-top:10px;padding-bottom:10px;" align=center colspan=2>
						<input class="tjan" name="submit" type="submit" value="" onclick="return addLinkInfoconfirmsub()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



