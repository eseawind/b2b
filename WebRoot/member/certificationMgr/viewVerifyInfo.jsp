<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<jsp:useBean id="param" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="custObj" class="com.saas.biz.custMgr.Custinfo" scope="page" />
<%
	String verify_id = "";
	String req_desc = "";
	String remark = "";
	String verify_type = "", cust_id = "";
	if (request.getParameter("verify_id") != null) {
		verify_id = request.getParameter("verify_id");
	}
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String req_date = date;
	String verify_name = "";
	VerifyInfo adverObj = new VerifyInfo();
	ArrayList advertList = adverObj.genOneVerify(verify_id);
	if (advertList != null && advertList.size() > 0) {
		HashMap map = (HashMap) advertList.get(0);
		if (map.get("req_desc") != null) {
			req_desc = map.get("req_desc").toString();
		}
		if (map.get("cust_id") != null) {
			cust_id = map.get("cust_id").toString();
		}
		if (map.get("remark") != null) {
			remark = map.get("remark").toString();
		}
		if (map.get("verify_type") != null) {
			verify_type = map.get("verify_type").toString();
			verify_type = param.getParamNameByValue("100", verify_type);
		}
		if (map.get("verify_name") != null) {
			verify_name = map.get("verify_name").toString();
		}
		if (map.get("req_date") != null) {
			req_date = map.get("req_date").toString();
			if (req_date.length() > 10) {
		req_date = req_date.substring(0, 10);
			}
		}
	}
	String cust_name=custObj.getCustNameById(cust_id);
%>

<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<style type="text/css">
		 form {padding:0px; margin:0px;}
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:13px; font-weight:bold; padding-left: 20px; padding-top: 5px;padding-bottom: 5px; }  /*横栏样式1*/
		</style>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/certificationMgr.js"></script>
	</head>
	<body>
		<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post" target="_self">
			<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#e7e7e7">
				<tr>
					<td colspan="2" style="background-color:#f6f6f6; color:#000000;  font-size:12px;text-align: left;font-weight: bold; ">
						<div class="ping">
							查看申请认证详细信息
						</div>
					</td>
				</tr>
				<tr>
					<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						认证类型：
					</td>
					<td width="604" align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=verify_type%>
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						认证证件：
					</td>
					<td width="604" align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=verify_name%>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" valign="middle">
						申请客户：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
						 <a href="/customerMgr/Custinfo.jsp?obj_cust_id=<%=cust_id%>&user_id=" TARGET=appwin onclick="mydefss()"><%=cust_name%></a>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" valign="middle">
						申请原由：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
							<bean:define id="des" value="<%=req_desc%>" />
							<bean:write name="des" filter="false" />
					</td>
				</tr>
				<tr>
					<td align="right" style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						申请时间：
					</td>
					<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=req_date%>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						备注：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
							<%=remark%>
						</div>
					</td>
				</tr>
				<tr>
					<td height="30" colspan="2" align="center" style="background-color:#f6f6f6; color:#000000;  font-size:12px;">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




