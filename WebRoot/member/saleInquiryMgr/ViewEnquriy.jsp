<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="enquiry" class="com.saas.biz.enquirydealMgr.EnquirydInfo" scope="page"/>
<%
Custinfo custInfo =new Custinfo();
String enquiry_id="";
if(request.getParameter("trade_id")!=null){
   enquiry_id=request.getParameter("trade_id");
}
String user_id="",cust_name="";
HashMap map=enquiry.getEnquriyById(enquiry_id);
String deal_tag=map.get("deal_tag").toString();
String title="",user_name="",enquiry_content="",enquiry_date="",attprice = "",mount = "";
if(map.get("rsrv_str3")!=null){
  title=map.get("rsrv_str3").toString();
}
if(map.get("cust_name")!=null){ 
  cust_name=map.get("cust_name").toString();
  //custInfo.getCustNameByUserId(user_id);
}
if(map.get("user_name")!=null){
  user_name=map.get("user_name").toString();
}
if(map.get("attprice")!=null){
  attprice=map.get("attprice").toString();
}
if(map.get("mount")!=null){
  mount=map.get("mount").toString();
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
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/saleInquiryMgr.js"></script>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			
										<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
										
											<tr>
												<td class="u1" width="20%">
													询价标题：
												</td>
												<td class="u2" width="30%">
													<div class="ping1">
													<%=title%>
													</div>
												</td>
												<td class="u1" width="20%">
													客户名称：
												</td>
												<td class="u2" width="30%">
													<div class="ping1">
														<%=cust_name%>
													</div>
												</td>
											</tr>
											<tr>
												<td class="u1">
													期望价格：
												</td>
												<td class="u2">
													<div class="ping1">
													<%=attprice%>
													</div>
												</td>
												<td class="u1">
													订货总量：
												</td>
												<td class="u2">
													<div class="ping1">
														<%=mount%>
													</div>
												</td>
											</tr>	
											<tr>
											<td class="u1">
													询价内容：
												</td>
												<td class="u2" colspan="3">
													<div class="ping1">
														<%=enquiry_content%>
													</div>
												</td>
											</tr>		
											<tr>
												<td class="u1">
													询价日期：
												</td>
												<td class="u2" colspan="3">
													<div class="ping1">
													<%=enquiry_date%>
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




