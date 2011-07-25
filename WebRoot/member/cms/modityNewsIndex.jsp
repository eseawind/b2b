<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelColumnMgr.ChannelColumnInfo"%>
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
	if (request.getParameter("iStart") != null) 
	{
		iStart = request.getParameter("iStart");
	}
	if (logsession.getAttribute("SESSION_CUST_ID") != null) 
	{
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (request.getParameter("up_class_id") != null) {
		up_class_id = request.getParameter("up_class_id");
	}
	

	ChannelColumnInfo channel = new ChannelColumnInfo();
	String upp_ch_id="0000000000";
	if ( request.getParameter("up_ch_id") != null ) 
	{
		upp_ch_id = request.getParameter( "up_ch_id" );
	}
	ArrayList classlist = channel.getChSon( Integer.parseInt( iStart ),20,upp_ch_id, cust_id );
	ArrayList counterList = channel.getChSon(upp_ch_id, cust_id );
	int counter = counterList.size();
	 
	//ArrayList classlist = bean.getClassByUpClassId(Integer.parseInt(iStart),up_class_id,"1");
	//int counter = bean.getClassByUpClassId(up_class_id,"1");
	
	//NewsInfo newsObj = new NewsInfo();
	//ArrayList newsList = newsObj.getNewsListByCustId(Integer.valueOf(iStart).intValue(), cust_id ,news_types);
	//int counter = newsObj.getNewsListByCustId(cust_id,news_types);
	String pageTools = tools.getPageTools(String.valueOf(counter),"20", "modityNewsIndex.jsp?cust_id="+cust_id+"&news_type="+news_types+"&iStart=", Integer.parseInt(iStart));
	
	
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
		<script language="javascript">
			function showDown(val){
				var ch_img = document.getElementById('img'+val);
				if(ch_img.src=='http://b2b.bizoss.com/admin/images/addP.gif'){
					ch_img.src = '/admin/images/delP.gif';
				}else{
					ch_img.src='/admin/images/addP.gif'	
				}
				var ch_tr = document.getElementById('tr'+val);
				if(ch_tr.style.display=='block'){
					ch_tr.style.display = 'none';
				}else{
					ch_tr.style.display = 'block';
				}
			}
		</script>
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
								频道名称
							</td>
							<td width="10%">
								频道级别
							</td>
							<td width="20%">
								上级频道
							</td>
							<td width="30%">
								频道描述
							</td>
							<td width="10%" align=center>
								查看资讯
							</td>
							<td width="10%" align="center">
								新增资讯
							</td>
						</tr>
						<%	
								String ch_id = "", ch_name = "",ch_desc="",up_ch_id="",ch_level="",up_ch_name="",ch_attr="";
								ArrayList downList = new ArrayList();
								if (classlist != null && classlist.size() > 0) 
								{
									for (int a = 0; a < classlist.size(); a++) 
									{
										HashMap class_map = (HashMap) classlist.get(a);
										if (class_map.get("ch_name") != null) {
											ch_name = class_map.get("ch_name").toString();
										}
										if (class_map.get("ch_desc") != null) {
											ch_desc = class_map.get("ch_desc").toString();
										}
										if (class_map.get("up_ch_id") != null) {
											up_ch_id = class_map.get("up_ch_id").toString();
											up_ch_name = channel.getChName(up_ch_id);
										}
										if(up_ch_name.equals("")){
											up_ch_name = "无上级频道";
										}
										if (class_map.get("ch_level") != null) {
											ch_level = class_map.get("ch_level").toString();
										}
										
										if(ch_desc.equals("")){
											ch_desc = "无频道描述";
										}
										if (class_map.get("ch_id") != null) {
											ch_id = class_map.get("ch_id").toString();
										}
										if (class_map.get("ch_attr") != null) {
											ch_attr = class_map.get("ch_attr").toString();
										}
										downList = channel.getChSon (ch_id,cust_id);
										
						%>
						<tr class="u2">
							<td align=left>
								<%
									if(downList!=null && downList.size()>0){
								%>
									<a href="modityNewsIndex.jsp?up_ch_id=<%=ch_id%>&menu_id=<%=top_menu_id%>">&nbsp;<%=ch_name%></a>
									
								<%
									}else{
								%>
									 &nbsp;<font color="black"><%=ch_name%></font>
								<%
									}
								%>
							</td>
							<td align=left>
								<%=ch_level%>
							</td>
							<td align=left>
								<%=up_ch_name%>
							</td>
							<td align=left>
								<%=ch_desc%>
							</td>
							<td align=center>
								<a href="viewClassNewsInfo.jsp?class_id=<%=ch_id%>" target="_blank"><img src="/images/view.gif" border="0"></a>
							</td>
							<td align=center>
								<%
									if(ch_attr.equals("1")){
								%>
									<img src="/admin/images/xinzeng.png" border="0" alt="此频道为频道封面（栏目本身不可以发布信息）" style="cursor:hand;" onclick="javascript:alert('此频道为频道封面（栏目本身不可以发布信息）');">
								<%
									}else{
								%>
										<a href="addNewsIndex.jsp?class_id=<%=ch_id%>" target="_blank"><img src="/admin/images/xinzeng.png" border="0"></a>
								<%
									}
								%>
							</td>
						</tr>
						
						
						<%
						}
						%>
						<tr class="u3">
								<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
								<td align="right" colspan="4"  style=" padding:2px 5px;">
								<a href="modityNewsIndex.jsp?iStart=0&menu_id=<%=top_menu_id%>">首页 </a>&nbsp; &nbsp;
								<% 
									if(Integer.parseInt(iStart)>0){
								%>
									<a href="modityNewsIndex.jsp?iStart=<%=pageUp%>&menu_id=<%=top_menu_id%>">上一页</a> &nbsp;
								<%
									}
									if(Integer.parseInt(iStart)<pages-1){
								%>
									<a href="modityNewsIndex.jsp?iStart=<%=pageDown%>&menu_id=<%=top_menu_id%>">下一页 </a>&nbsp; 
								<%
									}
								%>
								<a  href="modityNewsIndex.jsp?iStart=<%=pages-1%>&menu_id=<%=top_menu_id%>">尾页</a></td>
			
						</tr>
						<%
						}else{
						%>
						<tr align=center ><td colspan="5">暂无记录!</td></tr>
						<%
						}
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



