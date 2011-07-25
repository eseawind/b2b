<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="enquiry" class="com.saas.biz.enquirydealMgr.EnquirydInfo" scope="page"/>
<%
Custinfo custInfo =new Custinfo();

String cust_id="",cust_name="";
String enquiry_id="";
if(request.getParameter("trade_id")!=null){
   enquiry_id=request.getParameter("trade_id");
}
String user_id="";
if(request.getParameter("user_id")!=null){
   user_id=request.getParameter("user_id");
}
HashMap map=enquiry.getEnquriyByIdAdmin(enquiry_id,user_id);
String deal_tag="";
String title="",user_name="",enquiry_content="",enquiry_date="";
if(map.get("deal_tag")!=null){
  deal_tag=map.get("deal_tag").toString();
}
if(map.get("rsrv_str5")!=null){
  title=map.get("rsrv_str5").toString();
}
if(map.get("cust_id")!=null){
  cust_id=map.get("cust_id").toString();
  cust_name=custInfo.getCustomerTrueNameById(cust_id);
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
		<script language="javascript" src="/js/saleInquiryMgr.js"></script>
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
							<tr class=u1>
								<td align='left' colspan='5'>
									<a href="index.jsp">留言管理</a>
								</td>
								<tr>
							<tr>
								<td class="u1" width="15%">
									标题：
								</td>
								<td class="u2" width="35%">
									<div class="ping1">
									<%=title%>
									</div>
								</td>
								<td class="u1" width="15%">
									公司名称：
								</td>
								<%
									 com.saas.biz.userMgr.UserInfo userinfo = new com.saas.biz.userMgr.UserInfo();
									 ArrayList comName = new ArrayList();
									 String ccomName = "";
									 comName = userinfo.getcomName(user_name);
									 	if (comName != null && comName.size() > 0) {
										HashMap map1 = (HashMap) comName.get(0);
										ccomName = map1.get("cust_name").toString();
										}
								%>
								<td class="u2" width="35%">
									<div class="ping1">
									<a href="/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=cust_id%>"><%=cust_name%></a>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									留言日期：
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
									<%=enquiry_date%>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									留言内容：
								</td>
								<td class="u2" colspan="3" style="word-break:break-all;">
									<div class="ping1">
										<%=enquiry_content%>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									回复内容：
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<textarea name="content" id="content" cols="45" rows="6"></textarea><span style="color:red">*</span>
									</div>
									<input type="hidden" name="trade_type_code" value="1309">
									<input type="hidden" name="rsrv_str1" value="1">
									<input type="hidden" name="trade_id" value="<%=enquiry_id%>">
									<input type="hidden" name="deal_tag" value="<%=deal_tag%>">
									<input type="hidden" name="enquiry_id" value="<%=enquiry_id%>">
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;text-align:center;" align="center" colspan="4">
									<input class="tjan" name=submit1 type=submit value=""onclick="return replyEnquriycheck_Value()">
								</td>
							</tr>
						</table>
	</form>
	</body>
</html>



