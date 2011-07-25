<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<jsp:directive.page import="com.saas.biz.jobAnswerMgr.JobAnswerInfo "/>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.acceptMgr.AcceptInfo"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<%
	HttpSession logsession = request.getSession();
	String session_user_id = "";
	String iStart = "1";
	String deal_tag= "-1";
	String session_cust_id="";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if(null != session.getAttribute("SESSION_USER_ID")){
		session_user_id = session.getAttribute("SESSION_USER_ID").toString();
	}
	if (request.getParameter("deal_tag") != null && !"".equals(request.getParameter("deal_tag"))) {
		deal_tag = request.getParameter("deal_tag");
	}
	
	AcceptInfo info = new AcceptInfo();
	ArrayList acceptList = new ArrayList();
	acceptList = info.getMyAcceptJob(session_user_id, deal_tag, Integer.parseInt(iStart), 30);
	int count = info.getCountMyAcceptJob(session_user_id, deal_tag);
	Custinfo custInfo = new Custinfo();

	String href = "jobAnswerIndex.jsp?deal_tag=" + deal_tag + "&iStart=";
	String pageTools = tools.getPageTools(String.valueOf(count), "30", href , Integer.parseInt(iStart));
	
%>
<html>
	<head>
		<title>B2B���������̨����ϵͳ</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/js/jobAnswerMgr.js"></script>
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
}  /*������ʽ6---- ͷ������1*/
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
} /*������ʽ1*/
</style>
	</head>
	<body onLoad="selectInit('job_type','<%=deal_tag%>')">
			<%
		String top_menu_id="";
		if (request.getParameter("menu_id") != null){
        top_menu_id = request.getParameter("menu_id");
    }
	%>
			<form name="relationForm" id="relationForm" action="jobAnswerIndex.jsp" method="post">
					
		<table width=100% border="0" cellspacing="1" cellpadding="1" align="center" bgcolor="#98D9A2">
			<tr class="u2"> 
				<td height="13">										
						<b>���Ѿ�����ĸ�λ</b>:
				</td>
			</tr>
		</table>
		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
                <tr class="u4" height="25">
                  <td align=left width="21%"> ְλ </td>
                  <td align=left width="29%">��˾����</td>
                  <td align=left width="20%"> �������� </td>
                  <td align=center width="15%">�鿴��˾�ظ� </td>
                </tr>
                <%
						 if (acceptList != null && acceptList.size() > 0) {
						 	String indate="";
							String title="";
							String job_unit="";
							String cust_name = "";
							String cust_id = "";
							String trade_id = "";
							String job_type = "";
							String job_id = "";
						 	Iterator iterator = acceptList.iterator();
							while(iterator.hasNext()){
								HashMap map = (HashMap) iterator.next();
								if (map.get("title") != null) {
									title = map.get("title").toString();
								}
								if (map.get("cust_id") != null) {
									cust_id = map.get("cust_id").toString();
								}
								if (map.get("job_unit") != null) {
									job_unit = map.get("job_unit").toString();	
									cust_name = custInfo.getCustomerTrueNameById(job_unit);	
								}		
								if (map.get("indate") != null) {
									indate = map.get("indate").toString();
									indate = indate.substring(0,10);
								}		
								if (map.get("job_id") != null) {
									job_id = map.get("job_id").toString();
								}
								trade_id = map.get("trade_id").toString();
						 %>
                <tr class="u2">
                  <td align=left><a href="http://www.huipoo.com/member/hrJobMgr/viewjobinfo.jsp?job_id=<%=job_id%>" ><%=title%></a> </td>
                  <td align=left><a href="/member/customerMgr/viewCustinfo.jsp?obj_cust_id=<%=job_unit%>" ><%=cust_name%></a></td>
                  <td align=left><%=indate%></td>
                  <td align=center ><a href="/member/hrJobMgr/viewFeedbackInfo.jsp?trade_id=<%=trade_id%>&job_id=<%=job_id%>" >
                  	<img src=/images/edit.gif 	width=16 height=16 border=0 alt="�鿴��Ϣ"> </a></td>
                </tr>
                <%
						}
						}else{
						%>
						<tr align=center ><td colspan="4">���޼�¼!</td></tr>
						<%}%>
                <tr class="u1">
                  <%=pageTools%>
                </tr>
              </table>
		</form>
	</body>
</html>


