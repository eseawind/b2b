<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="proInfo" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%
	String news_id = bean.GenTradeId();
	String trade_id = bean.GenTradeId();
	
	String class_id = "";
	if (request.getParameter("class_id") != null) {
		class_id = request.getParameter("class_id").toString();
	}
	String parent_area_code = "";
	if (request.getParameter("area_code") != null) {
		parent_area_code = request.getParameter("area_code").toString();
	}
	AreaInfo area = new AreaInfo();
	String parent_area_name = area.getAreaName(parent_area_code);
	
	String cust_id = "";
	if(session.getAttribute("SESSION_CUST_ID") != null){
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	
%>
<html>
	<head>
		<title>添加地区</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			.c4 {
				CURSOR: hand;background:url(/admin/images/di_03.jpg);COLOR:#0066CC;font-size: 14px; font-weight:bold; line-height:28px; padding-left:26px;
			}
			.c3 {CURSOR: hand; background:url(/admin/images/di_04.jpg); COLOR: #0066CC;font-size: 14px; line-height:28px; padding-left:26px;}
			
		</style>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script language="JavaScript">
			function checkValue(){
				if(document.getElementById('area_name').value==''){
						alert('请输入地区名!');
						return false;
				}
			}
	</script>
	</head>
	<body>
		<form name=Userform action=/doTradeReg.do method=post target="_self">
		  <table width=100% border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<table width=100% border=0 cellpadding=0 cellspacing=1 bgcolor="#dddddd" align="center">
							<tr>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									所属地区：					
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name="parent_area_name"  type=text value="<%=parent_area_name%>" size="30" maxlength="3" readonly>
								</td>
								<td align=right style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;">
									地区名：
								</td>
								<td style="background-color:#ffffff; color:#000000;  font-size:12px;padding:5px;" align=left>
									<input name="area_name" type="text" id="area_name" value="" ><font color="red">*</font>
								</td>
							</tr>
					</table>
				</td>
			</tr>
		</table>
		  <table width=100% border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td align=center>
		<input type="hidden" name="trade_type_code" id="trade_type_code" value="1110" />
		<input type="hidden" name="parent_area_code" id="parent_area_code" value="<%=parent_area_code%>" />
		<input class="tjan" type="submit" name="Submit" value="" onclick="return checkValue()">
		&nbsp;&nbsp;&nbsp;&nbsp;<img src="/admin/images/comeback.JPG" onClick="location.href='areaMgr.jsp'" style="cursor:hand;" align="absmiddle">
	</td>
</tr>
</table>
		</form>
	</body>
</html>



