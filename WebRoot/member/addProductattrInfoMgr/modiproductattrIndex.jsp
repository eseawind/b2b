<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="proInfo"
	class="com.saas.biz.addproductMgr.AddProductInfo" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr"
	scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<%
	//String class_type=bean.getSelectItems("64");
	String class_id = comm.GenTradeId();
	HttpSession httpSess = request.getSession();
	String cust_id = (String) httpSess.getAttribute("SESSION_CUST_ID");

	String up_id = "000000000000000";
	if (request.getParameter("up_class_id") != null) {
		up_id = request.getParameter("up_class_id").toString();
	}
	ArrayList json = proInfo.getproductByUpId(cust_id, up_id);
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<link rel="stylesheet" type="text/css"
			href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="modichannal.js"></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/AddProductAttrInfo.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/AddProductInfo.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/util.js'></script>

	</head>
	<body>
		<form name=productForm method=post action=/doTradeReg.do
			target="_self">
			<table width="100%" border="0" cellspacing="1" cellpadding="1"
				align=center>
				<tr class="u1">
					<td align="left" class="head">
						<a href="addproattrIndex.jsp">新增产品规格</a>
					</td>
				</tr>
				<tr>
					<td valign="top">
						<table width=100% border=0 cellpadding=1 cellspacing=1
							align=center bgcolor="#98D9A2">
							<tr>
								<td class="u1" width="15%">
									选择产品型号：
								</td>
								<td class="u2" width="85%">
									<!--<div class="ping1">
										<div id="tree-div"></div>
									</div>-->
									<table align=left width="100%" border="0" cellspacing="1"
										cellpadding="1" style="margin-top: 1px; margin-bottom: 0px;"
										bgcolor="#98D9A2">
										<tr class="u4" height="25">
											<td width="20%" align="center">
												选择型号
											</td>
											<td width="20%" align="left">
												型号名称
											</td>
											<td width="40%" align="left">
												型号描述
											</td>
										</tr>
										<%
											if (json != null && json.size() > 0) {
												HashMap map = null;
												for (int i = 0; i < json.size(); i++) {
													String class_name = "";
													String class_id_up = "";
													String class_desc = "";
													String enable_tag = "";
													ArrayList list = null;
													map = (HashMap) json.get(i);
													if (map.get("class_name") != null) {
														class_name = map.get("class_name").toString();
													}
													if (map.get("class_id") != null) {
														class_id_up = map.get("class_id").toString();
														list = proInfo.getproductByUpId(cust_id, class_id_up);
													}
													if (map.get("class_desc") != null) {
														class_desc = map.get("class_desc").toString();
														if (class_desc.equals("")) {
															class_desc = "无";
														}
													}
													if (map.get("enable_tag") != null) {
														enable_tag = map.get("enable_tag").toString();
														if (enable_tag.equals("0")) {
															enable_tag = "有效";
														} else {
															enable_tag = "无效";
														}
													}
										%>
										<tr>
											<td width="20%" align="center"
												style="background-color: #ffffff; color: #000000; font-size: 12px;">
												<input type="radio" id="radio" name="up_class_id"
													value="<%=class_id_up%>" title="<%=class_name%>"
													onclick="javaScript:AddProductInfo.getproductById('<%=cust_id%>','<%=class_id_up%>',setData);setProductDiv('<%=class_id_up%>');">
											</td>
											<td width="20%" align="left"
												style="background-color: #ffffff; color: #000000; font-size: 12px;">
												<%
													if (list != null) {
												%>
												<a
													href="/member/addProductattrInfoMgr/modiproductattrIndex.jsp?up_class_id=<%=class_id_up%>"
													title="查看下级分类"><%=class_name%></a>
												<%
													} else {
												%>
												<%=class_name%>
												<%
													}
												%>

											</td>
											<td width="40%" align="left"
												style="background-color: #ffffff; color: #000000; font-size: 12px;">
												<%=class_desc%>
											</td>

										</tr>
										<%
											}
											} else {
										%>
										<tr>
											<td width="20%" align="center"
												style="background-color: #ffffff; color: #000000; font-size: 12px;"
												colspan="4">
												暂无分类！
											</td>
										</tr>
										<%
											}
										%>
										<tr>
											<td width="20%" align="center"
												style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;"
												colspan="4"></td>
										</tr>

									</table>
								</td>
							</tr>
							<div id="div-win"></div>
							<input type="hidden" name="trade_type_code" value="1222" />
							<input name="cust_id" id="cust_id" type="hidden"
								value="<%=cust_id%>">
							<input name="class_id" id="class_id" type="hidden"
								value="<%=class_id%>">
							<input name="class_name" id="class_name" type="hidden" value="0">
							<input name="up_class_id" id="up_class_id" type="hidden"
								value="000000000000000">
							<input name="class_level" id="class_level" type="hidden"
								value="0">
							<input name="class_type" id="class_type" type="hidden" value="0">
							<input name="class_desc" id="class_desc" type="hidden" value="0">
							<input name="enable_tag" id="enable_tag" type="hidden" value="0">
							<input name="remark" id="remark" type="hidden" value="0">
							<tr>
								<td width="100%" class="u2" colspan="2">
									<div class="ping1">
										<div id="loading" style="display: none">
											<img src="/images/wait.gif" border="0">
											正在获取数据，请稍等...
										</div>
										<div id="product-div"></div>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>






