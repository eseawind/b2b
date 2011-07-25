<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%@ page contentType="text/html;charset=GBK"%>
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String iStart = "0";
	if (request.getParameter("iStart") != null) {
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	
	ArrayList classlist = new ArrayList();
	int counter = 0;	
	NewsInfo newsObj = new NewsInfo();
	
	classlist = newsObj.getMemberNewsList(Integer.parseInt(iStart),cust_id);
	counter = newsObj.getMemberNewsList(cust_id);	
	
	
	int pages = (counter-1) / 20 + 1;
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
		<table width="100%" border="0" bgcolor="#DEEDFD" cellspacing="1" cellpadding="1" align="center">
			<tr>
				<td>
					<table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr class="u4" height="25">
							<td width="50%">
								资讯标题
							</td>
							<td width="30%">
								资讯类型
							</td>
							<td width="10%" align=center>
								修改资讯
							</td>
							<td width="10%" align="center">
								删除资讯
							</td>
						</tr>
						<%	
								String news_id="",title = "", news_type = "",class_desc="",news_name="";
								ChannelInfo chInfo = new ChannelInfo();
								if (classlist != null && classlist.size() > 0) {
									for (int a = 0; a < classlist.size(); a++) {
										HashMap class_map = (HashMap) classlist.get(a);
										if (class_map.get("news_id") != null) {
											news_id = class_map.get("news_id").toString();
										}
										if (class_map.get("title") != null) {
											title = class_map.get("title").toString();
										}
										if (class_map.get("news_type") != null) {
											news_type = class_map.get("news_type").toString();
											news_name = chInfo.getChName(news_type);
										}
										
										
						%>
						<tr class="u2">
							<td align=left>
								<%=title%>
							</td>
							<td align=left>
								<%=news_name%>
							</td>
							<td align=center>
								<a href="modifyNewsInfo.jsp?news_id=<%=news_id%>&class_type=<%=news_type%>" TARGET="">
									<img src=/images/edit.gif width=16 height=16 border=0 alt="修改资讯信息">
								</a>
							</td>
							<td align=center>
								<a href="/doTradeReg.do?news_id=<%=news_id%>&info_id=<%=news_id%>&trade_type_code=6584" target="_self">
									<img src="/images/del.gif" width="21" height="20" border="0" alt="删除栏目">
								</a>
							</td>
						</tr>
						<%
						}
						%>
						<tr class="u3">
								<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
								<td align="right" colspan="2"  style=" padding:2px 5px;">
								<a href="viewClassNewsInfo.jsp?iStart=0">首页 </a>&nbsp; &nbsp;
								<% 
									if(Integer.parseInt(iStart)>0){
								%>
									<a href="viewClassNewsInfo.jsp?iStart=<%=pageUp%>">上一页</a> &nbsp;
								<%
									}
									if(Integer.parseInt(iStart)<pages-1){
								%>
									<a href="viewClassNewsInfo.jsp?iStart=<%=pageDown%>">下一页 </a>&nbsp; 
								<%
									}
								%>
								<a  href="viewClassNewsInfo.jsp?iStart=<%=pages-1%>">尾页</a></td>
			
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
			
		</table>
	</body>
</html>


