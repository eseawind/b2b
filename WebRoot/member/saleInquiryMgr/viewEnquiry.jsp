 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*,com.saas.intf.InfoIntf"%>
<jsp:useBean id="enquiry" class="com.saas.biz.enquirydealMgr.EnquirydInfo" scope="page" />
<jsp:useBean id="dealBean" class="com.saas.biz.enquirydealMgr.Enquirydealinfo" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	String enquiry_id = "";
	if (request.getParameter("trade_id") != null) {
		enquiry_id = request.getParameter("trade_id");
	}
	HashMap map = enquiry.getEnquriyById(enquiry_id);
	String deal_tag = map.get("deal_tag").toString();
	String title = "", mount = "",attprice="", enquiry_content = "", enquiry_date = "", rsrv_str5 = "", sale_id = "";
	if (map.get("rsrv_str3") != null) {
		title = map.get("rsrv_str3").toString();
	}
	if (map.get("mount") != null) {
		mount = map.get("mount").toString();
	}
	if (map.get("attprice") != null) {
		attprice = map.get("attprice").toString();
	}
	if (map.get("rsrv_str5") != null) {
		rsrv_str5 = map.get("rsrv_str5").toString();
	}
	if (map.get("enquiry_content") != null) {
		enquiry_content = map.get("enquiry_content").toString();
	}
	if (map.get("enquiry_date") != null) {
		enquiry_date = map.get("enquiry_date").toString();
	}
	if (map.get("sale_id") != null) {
		sale_id = map.get("sale_id").toString();
	}
	///////////////////////////////////////////////////
	String iStart = "1", user_id = "";
	HttpSession logsession = request.getSession();
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	ArrayList list = dealBean.getEnquriyDealById(Integer.parseInt(iStart), 5, enquiry_id, user_id, "1");
	int counter = dealBean.getEnquriyDealCountById(enquiry_id, user_id, "1");
	String infopath = "";
	infopath = new InfoIntf().getChannelSaveDirByInfoId( sale_id );
	String pageTools = tools.getPageTools(String.valueOf(counter), "5","viewEnquiry.jsp?trade_id=" + enquiry_id + "&iStart=",Integer.parseInt(iStart));
%>
<html>
	<head>
		<title>销售询价信息</title>
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/saleInquiryMgr.js"></script>
		<style>
		</style>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
				<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
						<tr class=u1>
								<td align='left' colspan='5'>
									<a href="javascript:history.go(-1)">返回</a>
								</td>
						<tr>
				<tr>
					<td class="u1">
						询价标题：
					</td>
					<td align="left" class="u2">
						<div class="ping1">
							<%=title%>
						</div>
						<td class="u1">
						订货总量：
					</td>
					<td align="left" class="u2">
						<div class="ping1">
							<%=mount%>
							(件)
						</div>
					</td>
					 
				</tr>
				<tr>
					<td class="u1">
						期望价格：
					</td>
					<td align="left" class="u2">
						<div class="ping1">
							<%=attprice%>
							元/件 (单价)
						</div>
					</td>
					<td class="u1">
						询价日期：
					</td>
					<td align="left" class="u2">
						<div class="ping1">
							<%=enquiry_date%>
						</div>
					</td>
				</tr>
				<tr>
					<td class="u1">
						询价内容：
					</td>
					<td align="left" class="u2" colspan="3">
						<div class="ping1">
							<%=enquiry_content%>
						</div>
					</td>
				</tr>
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;text-align:left;" align="left" colspan="4">
						回复信息
					</td>
				</tr>
				<%
						if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							HashMap dealMap = (HashMap) list.get(i);
							String deal_content = "", id = "";
							if (dealMap.get("trade_id") != null) {
						id = dealMap.get("trade_id").toString();
							}
							if (dealMap.get("deal_content") != null) {
						deal_content = dealMap.get("deal_content").toString();
							}
				%>
				<tr>
					<td class="u1" style="display: inline;float: left;">
						删除回复
						<<%=i+1%>>
						<a href="/doTradeReg.do?trade_type_code=1322&trade_id=<%=id%>" target="_self" onclick="return delete()"><img src=/images/del.gif width=16 height=16 border=0 alt="删除留言">
						</a>
					</td>
					<td align="left" class="u2" colspan="4">
						<div class="ping1">
							<%=deal_content%>
						</div>
					</td>
				</tr>
				<%
					}
					}
				%>
				<tr>
					<td colspan="4" align="center">
						<table width=100% border=0 cellpadding=0 style="font-size:12px;" cellspacing=0 align=center bgcolor="white">
							<%=pageTools%>
						</table>
					</td>
				</tr>
				<tr>
					<td align="center" class="u2" colspan="4">
						<a href="/<%=infopath%>/d/content-<%=sale_id%>.html" target="_blank">继续询价</a>
					</td>
				</tr>
			</table>

		</form>
	</body>
</html>




