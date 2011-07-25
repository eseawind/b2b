<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="comParam" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%@ page import="com.saas.biz.productMgr.*"%>
<html>
	<head>
		<title>查看产品属性</title>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AddProductAttrInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<style type="text/css">
	.line6 {
		width: 72spx;
		width: 70spx !important;
		border: #ffcb99 1px solid;
		background-color: #fff8ee;
		text-align: left;
		padding-left: 20px;
		padding-top: 10px;
		padding-bottom: 10px;
		color: #000000;
		margin-top: 13px;
	}  /*横栏样式6---- 头部提醒1*/
	.line6 .img {
		width: 53px;
		height: 53px;
		float: left;
		margin-right: 20px;
	}
	
	.line6 .title {
		font-size: 14px;
		font-weight: bold;
		color: #ff5400;
	}
	
	.line1 {
		border-left: #ff7300 3px solid;
		background-color: #e2e2e2;
		color: #333333;
		text-align: left;
		font-size: 12px;
	} /*横栏样式1*/
	</style>
	</head>
	<body>
		<%
			HttpSession logsession = request.getSession();
			String cust_id = "", class_id = "";
			if (logsession.getAttribute("SESSION_CUST_ID") != null) {
				cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
			}
			if (request.getParameter("class_id") != null) {
				class_id = request.getParameter("class_id");
			}
			ProductInfo group = new ProductInfo();
			ArrayList tableList = group.getProductInfoById(cust_id, class_id);
		%>

					<table width=800 border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
						<tr>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								产品名称
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="40%">
								产品简介
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								产地
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="10%">
								审核日期
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="5%">
								修改
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="5%">
								删除
							</td>
						</tr>
						<%
								if (tableList != null && tableList.size() > 0) {
								for (int i = 0; i < tableList.size(); i++) {
									HashMap map = (HashMap) tableList.get(i);
									String product_id = "", product_class = "", product_name = "", product_abstract = "", product_desc = "", product_site = "", audit_date = "";
									if (map.get("product_id") != null) {
										product_id = map.get("product_id").toString();
									}
									if (map.get("product_class") != null) {
										product_class = map.get("product_class").toString();
									}
									if (map.get("product_name") != null) {
										product_name = map.get("product_name").toString();
									}
									if (map.get("product_abstract") != null) {
										product_abstract = map.get("product_abstract").toString();
										if(product_abstract.length()>50){
											product_abstract = product_abstract.substring(0,50)+"...";
										}
									}
									if (map.get("product_desc") != null) {
										product_desc = map.get("product_desc").toString();
										
									}
									if (map.get("product_site") != null) {
										product_site = map.get("product_site").toString();
									}
									if (map.get("audit_date") != null) {
										audit_date = map.get("audit_date").toString();
									}
									if(audit_date.length()>10){
						      			audit_date=audit_date.substring(0,10);
						     		}
						%>
						<tr style="background-color: #f9f9f9;" id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">
							<td style="color: #000000;" align="left"><%=product_name%></td>
							<td style="color: #000000;" align="center"><%=product_abstract%></td>
							<td style="color: #000000;" align="center"><%=product_site%></td>
							<td style="color: #000000;" align="center"><%=audit_date%></td>
							<td style="color: #000000;" align="center">
								<a href="modi_product_attr.jsp?product_id=<%=product_id%>" target="_blank"><img src=/images/edit.gif width=16 height=16 border=0 alt="修改产品属性"> </a>
							</td>
							<td style="color: #000000;" align="center">
								<a href="/doTradeReg.do?trade_type_code=1227&product_id=<%=product_id%>" target="_self"><img src=/images/del.gif width=16 height=16 border=0 alt="删除产品属性"> </a>
							</td>
						</tr>
						<%
						}
						%>

						<%
						}
						%>
					</table>
	</body>
</html>




