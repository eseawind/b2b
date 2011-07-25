<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%	
	String sale_id = "";
	if(request.getParameter("sale_id")!=null){
		sale_id = request.getParameter("sale_id");
	}
	SaleInfo saleInfo = new SaleInfo();
	ArrayList saleList = saleInfo.genOneSale(sale_id);
	String title= "",sale_addr = "",sale_price = "",sale_num = "",start_date = "",end_date = "";
	String carriage_pay = "",content = "",commodity_price="",price_type="";
	if(saleList!=null){
		HashMap saleMap = (HashMap)saleList.get(0);
		if(saleMap.get("title")!=null){title = saleMap.get("title").toString();}
		if(saleMap.get("sale_num")!=null){sale_num = saleMap.get("sale_num").toString();}
		if(saleMap.get("carriage_pay")!=null){carriage_pay = saleMap.get("carriage_pay").toString();}
	}
	
	if(sale_num.equals("")){
		sale_num = "0";
	}
	if(carriage_pay.equals("")){
		carriage_pay = "0";
	}
	
	
%>

<html>
	<head>
		<title>B2B电子商务</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<form action="/doTradeReg.do" method="post" name="answerform" >
		<table width="100%" border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd" >
			
			
			<tr>
				<td class="u1" width="15%">
					<div class="ping1">
					销售标题
					<div>
				</td>
				<td class="u2" colspan="3" width="85%" >
					<%=title%>
					
				</td>
			</tr>
			<tr>
				<td class="u1" width="15%">
					<div class="ping1">
					商品数量
					<div>
				</td>
				<td class="u2" colspan="3" width="85%" >
					<input type="text" name="sale_num" value="<%=sale_num%>"  onkeyup="if(isNaN(value))execCommand('undo')" maxlength="20" size = "20">
				</td>
			</tr>
			<tr>
				<td class="u1" width="15%">
					<div class="ping1">
					运费
					<div>
				</td>
				<td class="u2" colspan="3" width="85%" >
					<input type="text" name="carriage_pay" value="<%=carriage_pay%>"  onkeyup="if(isNaN(value))execCommand('undo')" maxlength="20" size = "20">
					
				</td>
			</tr>
					
			<tr>
					<td colspan=4 class="u3">
						<input class="tjan" name="bnt" type="submit" value="">
						<input type="hidden" name="trade_type_code" value="6542">
						<input type="hidden" name="sale_id" id="sale_id" value="<%=sale_id%>">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img src="/admin/images/comeback.JPG" onClick="location.href='findWareHouesMgr.jsp'" style="cursor:hand;" align="absmiddle">						
					</td>
				</tr>		
					
			
		</table>
	  </form>
	</body>
</html>



