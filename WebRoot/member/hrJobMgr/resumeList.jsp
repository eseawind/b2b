<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.acceptMgr.AcceptInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>

<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%
	HttpSession logsession = request.getSession();
	String session_user_id = "";
	String iStart = "1";String cust_name="";
	
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		session_user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	String session_cust_id = "",cust_id="";
	if(null != session.getAttribute("SESSION_CUST_ID")){
		session_cust_id = session.getAttribute("SESSION_CUST_ID").toString();
		ArrayList list=new ArrayList();
        list=new Custinfo().getCustInfo(session_cust_id);   
        if(list!=null&&list.size()>0){
        HashMap map1=(HashMap)list.get(0);
        if(map1.get("cust_name")!=null)
        {
        cust_name=map1.get("cust_name").toString();
        }
        

     }
	}
	AcceptInfo info = new AcceptInfo();
	ArrayList list = new ArrayList();
	//得到应聘我发布招牌
	list = info.getAcceptedJobByCustId(session_cust_id, Integer.parseInt(iStart), 30);
	//统计应聘我发布招牌
	int counter = info.getCountAcceptedJobByCustId(session_cust_id);
	String pageTools = tools.getPageTools(String.valueOf(counter), "30", "jobResumeIndex.jsp?iStart=", Integer.parseInt(iStart));
	UserInfo userInfo = new UserInfo();
%>
<html>
	<head>
		<meta name="Generator"
			content="Easy Struts Xslt generator for Eclipse (http://easystruts.sf.net).">
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<%
		String top_menu_id="";
		if (request.getParameter("menu_id") != null){
        top_menu_id = request.getParameter("menu_id");
    }
	%>
			
		<table width=100% border="0" cellspacing="0" cellpadding="0">	
			<tr class="u1">
				<td align="left" colspan="5"> 
					<a href="/member/hrResumeMgr/updateResumeIndex.jsp">个人简历修改</a>
				</td>
		</tr>	
			<tr>
				<td>
					<table width=100% border=0 cellpadding=1 cellspacing=1
						align=center bgcolor="#DEEDFD">
						<tr class="u4" height="25">
							<td align="center" width="25%">
								应聘职位
							</td>
							<td align="center" width="25%">
								用户名
							</td>
			
							<td align="center" width="25%">
								发布日期 
							</td>
							<td align="center" width="25%">
								回复
							</td>
						</tr>
						 <%
							if(list != null && list.size() > 0){
								String trade_id = "";
								String job_id="";
								String title="";
								String in_date="";
								String name="";
								String user_id="";
								String cust="";
								String cust_id1="";
								String cust_name2="";
								Iterator iterator = list.iterator();
								while(iterator.hasNext()){
									HashMap map = (HashMap) iterator.next();
									user_id = map.get("user_id").toString();
									title = map.get("title").toString();
									job_id= map.get("job_id").toString();
									in_date = map.get("indate").toString();
									trade_id = map.get("trade_id").toString();
									cust_id1 = map.get("cust_id").toString();
									ArrayList custlist = new ArrayList();
									custlist = info.getCustList(cust_id1);
									if(custlist!=null){
									HashMap nmap = (HashMap)custlist.get(0);
										cust_name2=nmap.get("cust_name").toString();
									}
									if (in_date.length() > 10){ 
										in_date = in_date.substring(0, 10); 
									}
						%>
							      
										  <tr class="u2">
											<td >
										   <%=title%>
											</td>
											<td >
												<%=cust_name2%>
										</td>
											<td align="center" >
												<%=in_date%>
											</td>
											<td align=center >
											  <a href=revertFeedbackInfo.jsp?job_id=<%=job_id%>&resume_id=<%=trade_id%>
												 ><img src=/images/edit.gif
													width=16 height=16 border=0> </a>
							       </td>
											
											
											<td align=center >
												
											</td>
					   	</tr>
						<%
									}
								}else{
						%>
						<tr align=center ><td colspan="4">暂无记录!</td></tr>
						<%}%>
					   	<tr class="u1">
							<%=pageTools%>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="46">&nbsp;
					
				</td>
			</tr>
		</table>
	</body>
</html>




