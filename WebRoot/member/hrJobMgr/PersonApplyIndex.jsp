<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.JobMgr.JobInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
request.setCharacterEncoding("GBK");
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "1";
	String keyword="";
	
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (request.getParameter("keyword") != null) {
		keyword = request.getParameter("keyword");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	
	JobInfo jobObj = new JobInfo();
	ArrayList jobList =jobObj.getOtherJob(cust_id,Integer.valueOf( iStart ).intValue(),30 );
	int counter = jobObj.getCountOtherJob(cust_id);
	if(keyword!=null && !keyword.equals("")){
		jobList = jobObj.getOtherJobBykey(cust_id,keyword,Integer.valueOf( iStart ).intValue(),30 );
		counter = jobObj.getOtherJobBykey(cust_id,keyword);
	}
	String pageTools =tools.getPageTools(String.valueOf(counter),
			"30", "PersonApplyIndex.jsp?iStart=", Integer.parseInt(iStart));
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css"  href="../style/mg.css"/>
		<style type="text/css">
	.chaxun{
			background:url(/admin/images/chaxun.gif) left center no-repeat;
			width:50px;
		 	height:26px;
			border:0px; 
		 	cursor:hand;
		}
</style>
	</head>
	<script language="javascript">
					  function Check_Value(){
					  	if(document.getElementById("keyword").value ==null || document.getElementById("keyword").value ==""){
					  		alert('请输入职位标题');
					  			return false;
					  	}
					  	 document.stockdateform.submit();
					  }
					 
	</script>
	<body>
		<%
		String top_menu_id="";
		if (request.getParameter("menu_id") != null){
        top_menu_id = request.getParameter("menu_id");
    }
	%>
			<form action="PersonApplyIndex.jsp" method="post" name="stockdateform">
				<table width=100% border=0 cellpadding=1 cellspacing=1 bgcolor="#98D9A2">		
			<tr class="u2">
				<td>
				输入您要查询的职位:<input type="text" id="keyword" name="keyword"  value=""">
					<input class="chaxun" type="button" name="comit" value="" onclick="return Check_Value();" style="cursor: hand;">
				</td>
			</tr>
		</table>
		<table width=100% border="0" cellpadding="1" cellspacing="1" align=center bgcolor="#98D9A2">
			<tr class="u4" height="25">
				<td align=left width="20%">
					职位标题
				</td>
				<td align=left width="30%">
					工作地址
				</td>
				<td align=left width="20%">
					发布日期
				</td>
				<td align=center width="10%">
					应聘
				</td>
			</tr>
			<%
			       // out.println(jobList.size());
					if (jobList != null && jobList.size() > 0) {
					for (Iterator it = jobList.iterator(); it.hasNext();) {
						HashMap map = (HashMap) it.next();
						String job_id = map.get("job_id").toString();
						String title = "";
						String req = "";
						String job_addr = "";
						String publish_date = "";
					if (map.get("title") != null) {
					title = map.get("title").toString();
						}

						if (map.get("job_addr") != null) {
					job_addr = map.get("job_addr").toString();
						}

						if (map.get("publish_date") != null) {
					publish_date = map.get("publish_date").toString();
					if (publish_date.length() > 10) {
						publish_date = publish_date.substring(0, 10);
					}
				}
			%>
			<tr class="u2">
				<td align=left>
					<a href="viewjobinfo.jsp?job_id=<%=job_id%>" title=<%=title%> target="_self"><%=title%> </a>
				</td>

				<td align=left>
					<%=job_addr%>
				</td>
				<td align=left>
					<%=publish_date%>
				</td>

				<td align=center>
					<a href=viewJobinfo2.jsp?job_id=<%=job_id%> TARGET="_self"><img src=/images/edit.gif width=16 height=16 border=0 alt="应聘信息"> </a>
				</td>

			</tr>

			<%
			}
			%>
			<tr class="u1">
				<%=pageTools%>
			</tr>
			<%
			}else{
						%>
						<tr align=center ><td colspan="4">暂无记录!</td></tr>
						<%}%>

		
		</table>
	</form>
	</body>
</html>




