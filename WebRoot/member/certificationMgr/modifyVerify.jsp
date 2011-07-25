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
<%
	String verify_id = "";
	String req_desc = "";
	String remark = "";
	String verify_type = "",cust_id="";
	if (request.getParameter("verify_id") != null) {
		verify_id = request.getParameter("verify_id");
	}
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String req_date = date;
    String verify_name="";
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
			<table width=727 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#e7e7e7">
				<tr>
					<td colspan="2" style="background-color:#f6f6f6; color:#000000;  font-size:12px;">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td width="100" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						认证类型：
						<input name=verify_id type=hidden value="<%=verify_id%>">
						<input name=verify_type type=hidden value="<%=verify_type%>">
					</td>
					<td width="604" align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=verify_type%>
						</div>
					</td>
				</tr>
				<tr>
					<td width="100" align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
						认证证件：
						<input name=verify_id type=hidden value="<%=verify_id%>">
						<input name=verify_type type=hidden value="<%=verify_type%>">
					</td>
					<td width="604" align=left style="background-color:#ffffff; color:#000000;  font-size:12px;">
						<div class="ping1">
							<%=verify_name%>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align="right" valign="middle">
						申请原由：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
						<bean:define id="des" value="<%=req_desc%>"/>
						<bean:write name="des" filter="false"/>
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
						审核结果：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
							<select name=verify_status>
								<option value="1">
									审核通过
								</option>
								<option value="2">
									审核不通过
								</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
						备注：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left>
						<div class="ping1">
							<input name="remark" type="text" size=35 maxlength=100 value="<%=remark%>">
						</div>
					</td>
				</tr>
				<input name="cust_id" type="hidden" size=35 maxlength=100 value="<%=cust_id%>">
				<input name=trade_type_code type=hidden value=0948>
				<tr>
					<td height="30" colspan="2" align="center" style="background-color:#f6f6f6; color:#000000;  font-size:12px;">
						<input class="tjan" type="submit" value="" onclick="return modifyVerifycheckValue()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




