<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="orderBean" class="com.saas.biz.salesOrderFormMgr.SalesOrderFormInfo" scope="page" />
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "0";
	String menu_idx = "";

	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("menu_id") != null) {
		menu_idx = request.getParameter("menu_id");
	}

	ArrayList tableList = orderBean.getSalseOrderByCust(Integer.parseInt(iStart), cust_id);
	int counter = orderBean.getSalesOrderCount(cust_id);
	int pages = counter / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
	if (pages > currenPage) {
		if (currenPage > 0) {
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	} else if (pages == currenPage) {
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
%>
<html>
	<head>
		<title>销售单管理</title>
		<link href="/style/css.css" rel="stylesheet" type="text/css">
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
		<script type="text/javascript">
function delet(){
 if(window.confirm('确定要删除本条记录？')){
   return true;
 }else{
   return false;
 }
}
</script>
		<SCRIPT>WinLIKEerrorpage='/winlike/winman/hlp-error.html';</SCRIPT>
		<SCRIPT SRC="/winlike/winman/wininit.js"></SCRIPT>
		<SCRIPT SRC="/winlike/winman/winman.js"></SCRIPT>
		<SCRIPT>
             
            WinLIKE.definewindows=mydefss;
            function mydefss() {
                
            	var j=new WinLIKE.window('', 100, 100, '90%', 'WinLIKE.browsersize().Height -Top-30', 2);
            	j.Vis=false;
            	j.Nam='appwin';
            	WinLIKE.addwindow(j);
            };
    
    </SCRIPT>
	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="13" align="left">
				</td>
			</tr>
			<tr>
				<td>
					<table width=727 border=0 cellpadding=2 cellspacing=1 align=center bgcolor="#e7e7e7">
						<tr>
							<td class="line1" style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="25%">
								销售单名称
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								销售物品
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="20%">
								销售客户名
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="15%">
								交货地点
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="8%">
								修改
							</td>
							<td style="background-color: #e2e2e2; color: #000000; font-weight: bold; font-size: 13px;" align=center width="8%">
								删除
							</td>
						</tr>
						<%
								if (tableList != null && tableList.size() > 0) {
								for (int i = 0; i < tableList.size(); i++) {
									HashMap map = (HashMap) tableList.get(i);
									String idx = "", quo_name = "", cust_name = "", give_addr = "", sale_name = "";
									if (map.get("quo_id") != null) {
								idx = map.get("quo_id").toString();
									}
									if (map.get("quo_name") != null) {
								quo_name = map.get("quo_name").toString();
									}
									if (map.get("rsrv_str3") != null) {
								cust_name = map.get("rsrv_str3").toString();
									}
									if (map.get("rsrv_str4") != null) {
								sale_name = map.get("rsrv_str4").toString();
									}
									if (map.get("give_addr") != null) {
								give_addr = map.get("give_addr").toString();
									}
						%>
						<tr style="background-color: #f9f9f9;" id="changcolor_tr<%=i%>" onmouseover="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#ffffff','DIV')" onmouseout="MM_changeProp('changcolor_tr<%=i%>','','backgroundColor','#f9f9f9','DIV')">
							<td style="color: #000000;" align="left">
								<a href="viewOrderInfo.jsp?quo_id=<%=idx%>" TARGET=appwin onclick="mydefss()" title="查看销售单信息"><%=quo_name%></a>
							</td>
							<td style="color: #000000;" align="left"><%=sale_name%></td>
							<td style="color: #000000;" align="left"><%=cust_name%></td>
							<td style="color: #000000;" align="left"><%=give_addr%></td>
							<td style="color: #000000;" align="center">
								<a href="editOrderIndex.jsp?id=<%=idx%>&menu_id=<%=menu_idx%>" target="_self"><img src=/img/edit.gif width=16 height=16 border=0 alt="修改销售单"> </a>
							</td>
							<td style="color: #000000;" align="center">
								<a href="/doTradeReg.do?trade_type_code=1094&quo_id=<%=idx%>" target="_self" onclick="return delet();"><img src=/img/del.gif width=16 height=16 border=0 style="cursor: hand" alt="删除销售单"> </a>
							</td>
						</tr>
						<%
						}
						%>
						<tr>
							<td align="left" colspan="2">
								共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart) + 1%>页&nbsp;&nbsp;共<%=pages%>页
							</td>
							<td align="right" colspan="3">
								<a href="salesOrderIndex.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
								<%
								if (Integer.parseInt(iStart) > 0) {
								%>
								<a href="salesOrderIndex.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
								<%
										}
										if (Integer.parseInt(iStart) < pages - 1) {
								%>
								<a href="salesOrderIndex.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp;
								<%
								}
								%>
								<a href="salesOrderIndex.jsp?iStart=<%=pages - 1%>">尾页</a>
							</td>
						</tr>
						<%
						}
						%>
					</table>
				</td>
			</tr>
			<tr>
				<td height="13"></td>
			</tr>
		</table>
	</body>
</html>



