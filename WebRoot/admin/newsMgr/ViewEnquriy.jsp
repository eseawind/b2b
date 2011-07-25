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
	String user_id1="";
	if(request.getParameter("user_id")!=null){
	   user_id1=request.getParameter("user_id");
	}
	String user_id="",cust_name="";
	HashMap map=enquiry.getEnquriyByIdAdmin(enquiry_id,user_id1);
	String deal_tag="";
	String title="",user_name="",enquiry_content="",enquiry_date="",attprice = "",mount = "",cust_id="",commenter= "";
	if(map.get("deal_tag")!=null)
	{
	  deal_tag=map.get("deal_tag").toString();
	}
	if(map.get("rsrv_str3")!=null){
	  title=map.get("rsrv_str3").toString();
	}
	if(map.get("rsrv_str5") != null )
	{
		commenter = map.get("rsrv_str5").toString();
	}
	if(map.get("cust_name")!=null){ 
	  cust_name=map.get("cust_name").toString();
	}
	if(map.get("cust_id")!=null){
	  cust_id=map.get("cust_id").toString();
	  cust_name = custInfo.getCustomerTrueNameById(cust_id);
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
	if(map.get("enquiry_content")!=null)
	{
	  enquiry_content=map.get("enquiry_content").toString();
	  enquiry_content = enquiry_content.replace( "<xmp>","" );
	  enquiry_content = enquiry_content.replace( "</xmp>","" );
	}
	if(map.get("enquiry_date")!=null){
	  enquiry_date=map.get("enquiry_date").toString();
	}
%>
<html>
	<head>
		<title>销售询盘信息</title>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/saleInquiryMgr.js"></script>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<form name="resumeForm" action="/doTradeReg.do" method="post" target="_self">
		<table width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#DEEDFD">
			<tr>
				<td class="u1" width="20%" align="right">评论标题：</td>
				<td class="u2" width="30%" align="left"><%=title%></td>
				<td class="u1" width="20%" align="right">公司名称：</td>
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
				<td class="u2" width="30%" align="left">
					<div class="ping1">
						<a href="/admin/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=cust_id%>"><%=cust_name%></a>
					</div>
				</td>
				
			</tr>
			<tr>
				<td class="u1">评论人：</td>
				<td class="u2" colspan="3"><%=commenter%></td>
			</tr>		
			<tr>
				<td class="u1" width="20%">
					评论内容：
				</td>
				<td class="u2" width="80%" colspan="3">
					<textarea rows="10" cols="150"><%=enquiry_content%></textarea>
				</td>
			</tr>		
			<tr>
				<td class="u1">
					发表日期：
				</td>
				<td class="u2" colspan="3">
					<div class="ping1">
					<%=enquiry_date%>
					</div>
				</td>
			</tr>			
			<tr>
          	  <td class="u3" height="30" colspan="4" align="center">
          	   <a href="javascript:history.go(-1)">
          	 	<img src="/admin/images/comeback.JPG"  style=" border: 0;cursor: hand; text-align: center;">
          	 	</a>
          </td>
          </tr>		
		</table>
	</form>
	</body>
</html>




