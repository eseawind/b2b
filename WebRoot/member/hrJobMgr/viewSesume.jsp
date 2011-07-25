<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.JobMgr.JobInfo"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<%@ page import="com.saas.biz.resumeMgr.*"%>

<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String resume_id = "";
	String title = "";
	String req = "";
	String publish_user_id="";
	String cust_id="";
	String cust_name="";
	String job_addr = "";
	String cop_name="";
	String job_unit="";
	OrganizeInfo organ = new OrganizeInfo();
	if (request.getParameter("resume_id") != null)
	{
		resume_id = request.getParameter("resume_id");
	}

%>

<html>

	<head>

		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>

	</head>

	<body>
  <form  name="classForm" method="post" action="/doTradeReg.do" target="_bank">
  		
		<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
						<tr>
							<td class="u1" width="15%">
								职位标题
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width="35%">
								<%=title%>
							</td>
							<td class="u1" width="15%">
								公司名称
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width="35%">
							<%
							if(cop_name!=null && !cop_name.equals("")){%>
									<a href="/member/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=job_unit%>" target=""><%=cop_name%></a>
									<%}else{%>
									没有对应的公司
									<%}%>
							</td>
						</tr>
	
						<tr>
							<td class="u1" width="15%">
								工作地点
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=leftcolspan="3"">
								<%=job_addr%>
							</td><td class="u1" width="15%">
								职位要求
							</td>
							<td style="background-color:#ffffff; color:#000000;  font-size:12px;" align=left width="35%">
									<%=req%>
							</td>
						</tr>
						<tr>
	          	<td height="30" colspan="4" align="center" style="background-color:#ffffff; color:#000000;  font-size:12px;">
								
			       	 		<img src="/admin/images/comeback.JPG" onclick="javascript:history.go(-1)" style=" border: 0;cursor: hand; text-align: center;">
								
	          	</td>
         	 </tr>
	</table>
	</form>
	</body>

</html>





