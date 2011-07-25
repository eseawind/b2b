<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="enquiry" class="com.saas.biz.enquirydealMgr.EnquirydInfo" scope="page"/>
<%
String enquiry_id="";
Custinfo custInfo =new Custinfo();
if(request.getParameter("trade_id")!=null){
   enquiry_id=request.getParameter("trade_id");
}
HashMap map=enquiry.getEnquriyById(enquiry_id);
String cust_id="",cust_name="";
String deal_tag=map.get("deal_tag").toString();
String title="",user_name="",enquiry_content="",enquiry_date="";
if(map.get("rsrv_str3")!=null){
  title=map.get("rsrv_str3").toString();
}
if(map.get("cust_name")!=null){
  cust_name=map.get("cust_name").toString();
 // cust_name=custInfo.getCustomerNameById(cust_id);
}
if(map.get("user_name")!=null){
  user_name=map.get("user_name").toString();
}
if(map.get("enquiry_content")!=null){
  enquiry_content=map.get("enquiry_content").toString();
}
if(map.get("enquiry_date")!=null){
  enquiry_date=map.get("enquiry_date").toString();
}
%>
<html>
	<head>
		<title>销售询盘信息</title>
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<style>
		 .tjan{
		     background: url(/admin/images/tj.gif) left center no-repeat;
			 width:78px;
			 height:32px;
			 border:0px; 
			 cursor:hand;
	 }
		</style>
	</head>
	<body>
	<form name=resumeForm action=/doTradeReg.do method=post target="_self">
		
			<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">		
						<tr>
								<td class="u1">
										报价标题：
						  </td>
										<td  class="u2" colspan="3">
											<div class="ping1">
												<%=title%>
										  </div>
						  </td>
			  </tr>
											<tr>
												<td class="u1">
													公司名称：
												</td>
												<td  class="u2">
													<div class="ping1">
														<%=cust_name%>
													</div>
												</td>
												<td class="u1">
													报价日期：
												</td>
												<td  class="u2">
													<div class="ping1">
													<%=enquiry_date%>
													</div>
												</td>
											</tr>
											<tr>
												<td class="u1">
													报价内容：
												</td>
												<td  class="u2" colspan="3">
													<div class="ping1">
														<%=enquiry_content%>
													</div>
												</td>
											</tr>	
											<tr>
          	  <td height="30" colspan="4" align="center" style="background-color:#f2f2f2; color:#000000;  font-size:12px;">
          	   <a href="javascript:history.go(-1)">
          	 	<img src="/admin/images/comeback.JPG"  style=" border: 0;cursor: hand; text-align: center;">
          	 	</a>
          </td>
          </tr>											
	  </table>

	</form>
	</body>
</html>




