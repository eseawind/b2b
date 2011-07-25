<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.lastOilMgr.LastOilInfo"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
	HttpSession  logsession = request.getSession(); 
	String cust_id = "",commerce_id = "";
    if (logsession.getAttribute("SESSION_CUST_ID") != null){
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    if (request.getParameter("commerce_id")!=null){
    	commerce_id = request.getParameter("commerce_id");
    }
    
    String ud_type = bean.getSelectItems("114");
    
    String commerce_name = "",get_date = "",last_price = "",ud_price = "",remark = "";
    LastOilInfo oilinfo = new LastOilInfo();
    ArrayList list = oilinfo.getOilInfoById(cust_id,commerce_id);
    if (list!=null && list.size()>0){
    	HashMap map = (HashMap)list.get(0);
    	if (map.get("commerce_name")!=null){commerce_name = map.get("commerce_name").toString();}
    	if (map.get("get_date")!=null){get_date = map.get("get_date").toString();}
    	if (map.get("last_price")!=null){last_price = map.get("last_price").toString();}
    	if (map.get("ud_price")!=null){ud_price = map.get("ud_price").toString();}
    	if (map.get("ud_type")!=null){
    		ud_type = map.get("ud_type").toString();
    		ud_type = bean.getItemsBySelected("114",ud_type);
    	}
    	if (map.get("remark")!=null){remark = map.get("remark").toString();}
    }
    
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/oilMgr.js"></script>
		<style type="text/css" media="screen">
		form {padding:0px; margin:0px;}
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
		</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
	</head>
	<body>
	<jsp:include page="/inc/linkMenuInclude.jsp">
<jsp:param name="menu_id" value="KKK32FFF45HHH47" />
</jsp:include>
		<center>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<table width="727" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="30"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width=727 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									市场名称：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input name="commerce_name" id="commerce_name" type="text" size="25" maxlength="25" value="<%=commerce_name%>"><font color="red">(例:OPEC,WTI等！)</font>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									采集时间：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input name="get_date" type="text" id="get_date" size=10 maxlength=15 value="<%=get_date%>" onfocus="setday(this);">
										<span style="color:red">(yyyy-MM-dd)</span>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									最新价格：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input name="last_price" id="last_price" type="text" size="15" maxlength="15" value="<%=last_price%>"><font color="red">(注:/桶/美元)</font>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									浮动类型：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<select name="ud_type" id="ud_type">
										 	<option value="">请选择..</option>
										 	<%=ud_type%>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									浮动价格：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input name="ud_price" id="ud_price" type="text" size="15" maxlength="15" value="<%=ud_price%>">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									备注：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="remark" id="remark" size="52" maxlength="50" value="<%=remark%>">
										<input name="trade_type_code" type="hidden" value="6002">
										<input name="commerce_id" type="hidden" id="commerce_id" value="<%=commerce_id%>">
										<input name="cust_id" type="hidden" id="cust_id" value="<%=cust_id%>">
										<input name="publish_user_id" type="hidden" id="publish_user_id" value="">
										<input name="publish_date" type="hidden" id="publish_date" value="">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;" align="center" colspan=2>
									<input name="comit" type="submit" value="" onclick="return modifyoilconfirmsub()" style="background-image: url('/images/tj.gif');width:70px;height: 26px;border:0;cursor:hand">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="13"></td>
				</tr>
			</table>
		</form>
		</center>
	</body>
</html>



