<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "0";
	String news_types = "";
	String up_class_id="000000000000000";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("up_class_id") != null) {
		up_class_id = request.getParameter("up_class_id");
	}
	
	ArrayList classlist = bean.getClassByUpClassId(Integer.parseInt(iStart),up_class_id,"10");
	int counter = bean.getClassByUpClassId(up_class_id,"10");
	
	NewsInfo newsObj = new NewsInfo();
	ArrayList newsList = newsObj.getNewsListByCustId(Integer.valueOf(iStart).intValue(), cust_id ,news_types);
	//int counter = newsObj.getNewsListByCustId(cust_id,news_types);
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "modifyTestInfo.jsp?cust_id="+cust_id+"&news_type="+news_types+"&iStart=", Integer.parseInt(iStart));
	
	
	int pages = counter / 20 + 1;
	int pageUp = 0, pageDown = 0;
	int currenPage = Integer.valueOf(iStart).intValue();
	if (pages > currenPage) {
		if (currenPage > 0) {
			pageUp = currenPage - 1;
		}
		pageDown = currenPage + 1;
	} else if (pages == currenPage) {
		pageUp = currenPage - 1;
		pageDown = currenPage;
	}
	
	
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<%
			String top_menu_id="";
			if(request.getParameter("menu_id")!=null){
				top_menu_id = request.getParameter("menu_id");
			}
		%>
		<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="<%=top_menu_id%>" />
		</jsp:include>	
		<table width="800" border="0" bgcolor="#DEEDFD" cellspacing="1" cellpadding="1" align="center">
			<tr>
				<td>
					<table width="800" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr class="u4" height="25">
							<td width="20%">
								评测分类
							</td>
							<td width="60%">
								分类描述
							</td>
							<td width="10%" align=center>
								查看评测
							</td>
							<td width="10%" align="center">
								新增评测
							</td>
						</tr>
						<%	
								String class_name = "", class_id = "",class_desc="";
								ArrayList downList = new ArrayList();
								if (classlist != null && classlist.size() > 0) {
									for (int a = 0; a < classlist.size(); a++) {
										HashMap class_map = (HashMap) classlist.get(a);
										if (class_map.get("class_name") != null) {
											class_name = class_map.get("class_name").toString();
										}
										if (class_map.get("class_desc") != null) {
											class_desc = class_map.get("class_desc").toString();
										}
										if(class_desc.equals("")){
											class_desc="无分类描述";
										}
										if (class_map.get("class_id") != null) {
											class_id = class_map.get("class_id").toString();
										}
										downList = bean.getClassInfoByUpClassId("10",class_id);
										
						%>
						<tr class="u2">
							<td align=left>
								<%
									if(downList!=null && downList.size()>0){
								%>
									<a href="modifyTestInfo.jsp?up_class_id=<%=class_id%>&menu_id=<%=top_menu_id%>"><%=class_name%></a>
								<%
									}else{
								%>
									<%=class_name%>
								<%
									}
								%>
								
							</td>
							<td align=left>
								<%=class_desc%>
							</td>
							<td align=center>
								<a href="/admin/sysInfoMgr/viewClassNewsInfo.jsp?class_id=<%=class_id%>&class_type=10" target="_blank"><img src="/images/view.gif" border="0"></a>
							</td>
							<td align=center>
								<a href="/admin/testMgr/addNewsIndex.jsp?class_id=<%=class_id%>" target="_blank"><img src="/admin/images/xinzeng.png" border="0"></a>
							</td>
						</tr>
						<%
						}
						%>
						<tr class="u3">
								<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
								<td align="right" colspan="2"  style=" padding:2px 5px;">
								<a href="modifyTestInfo.jsp?iStart=0&menu_id=<%=top_menu_id%>&up_class_id=<%=up_class_id%>">首页 </a>&nbsp; &nbsp;
								<% 
									if(Integer.parseInt(iStart)>0){
								%>
									<a href="modifyTestInfo.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>&up_class_id=<%=up_class_id%>">上一页</a> &nbsp;
								<%
									}
									if(Integer.parseInt(iStart)<pages-1){
								%>
									<a href="modifyTestInfo.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>&up_class_id=<%=up_class_id%>">下一页 </a>&nbsp; 
								<%
									}
								%>
								<a  href="modifyTestInfo.jsp?iStart=<%=pages-1%>&menu_id=<%=top_menu_id%>&up_class_id=<%=up_class_id%>">尾页</a></td>
			
						</tr>
						<%
						}else{
						%>
						<tr align=center ><td colspan="5">暂无记录!</td></tr>
									  	<%}
						%>
					</table>
				</td>
			</tr>
			<tr>
				<td height="13">&nbsp;
					
				</td>
			</tr>
		</table>
	</body>
</html>


