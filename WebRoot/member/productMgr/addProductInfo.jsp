<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
	HttpSession logsession = request.getSession();
	String product_id = "", cust_id = "";
	String commodity_id = bean.GenTradeId();
	if (request.getParameter("product_id") != null) {
		product_id = request.getParameter("product_id");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	ParamethodMgr paramCom = new ParamethodMgr();
	ArrayList webList = paramCom.getCompareInfo("CRM", "web_id");
	ArrayList comTypeList = paramCom.getCompareInfo("CRM",
			"commodity_type");
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">

		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script src="/www/fuction/calendar.js" type="text/javascript"></script>
		<script src="/js/productMgr.js" type="text/javascript"></script>
	</head>
	<body>
		<form name=form1 action=/doTradeReg.do method=post target="blank">
			<table width="818" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td height="26" background="/img/bg-1.gif">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td background="/img/bg-2.gif">
						<table width="93%" border="0" cellpadding="5" cellspacing="1" align="center" bgcolor="#dddddd">

							<tr>
								<td class="line1" align="left" colspan="2">
									新增商品
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									商品名称：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<input type=text name=commodity_name>
								</td>
							</tr>
							<input name=commodity_id type=hidden value="<%=commodity_id%>">
							<input type=hidden name=cust_id value="<%=cust_id%>">
							<input type=hidden name=product_id value="<%=product_id%>">
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									计价单位：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<input type=text name=commodity_unit>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									销售地点：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<input type=text name=sale_market>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									选择子网：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<select name=web_id>
										<%
												if (webList != null && webList.size() > 0) {
												for (int i = 0; i < webList.size(); i++) {
													HashMap map = (HashMap) webList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
										<option value="<%=value%>"><%=name%></option>
										<%
											}
											}
										%>
									</select>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									商品分类：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<select name=commodity_type>
										<%
												if (comTypeList != null && comTypeList.size() > 0) {
												for (int i = 0; i < comTypeList.size(); i++) {
													HashMap map = (HashMap) comTypeList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
										<option value="<%=value%>"><%=name%></option>
										<%
											}
											}
										%>
									</select>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									商品说明：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<textarea name=content style="display: none"></textarea>
									<iframe id="content" src="/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=commodity_id%>" frameborder=0 scrolling=no width=600 height=350></iframe>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									品牌：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<input type=text name=commodity_brand>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									原价：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<input type=text name=commodity_price>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									价格：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<input type=text name=sale_price>
									<input type=hidden name=trade_type_code value=0264>
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px;" align=right>
									价格类型：
								</td>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" align=left>
									<select name=price_type>
										<option value=0>
											正常价格
										</option>
										<option value=1>
											打折价格
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<input type=hidden name=rsrv_num1 value=0>
								<td style="background-color: #ffffff; color: #000000; font-size: 12px;" colspan=2 align="center">
									<INPUT id=advcheck name=advshow type=checkbox value=0 onclick=addProductInfocheck_none(form1)>
									以上资料正确无误。
								</td>
							</tr>
							<tr>
								<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 13px; padding-top: 10px; padding-bottom: 10px;" align=center colspan=2>
									<input class="tjan" name=submit1 type=button value="" disabled=true onclick=addProductInfoconfirmsub(form1)>
									<input name=button1 class="qxan" type=button value="" onclick=exit()>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="46" background="/img/bg-3.gif">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



