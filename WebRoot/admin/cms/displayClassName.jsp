<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.newsMgr.NewsInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
	<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%@ page contentType="text/html;charset=GBK"%>
<%
	HttpSession logsession = request.getSession();
	ChannelInfo channel = new ChannelInfo();
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
	String up_class_type = "";
	if (request.getParameter("class_type") != null) {
		up_class_type = request.getParameter("class_type");
	}
	String upp_ch_id="0000000000";
	if (request.getParameter("up_ch_id") != null) {
		upp_ch_id = request.getParameter("up_ch_id");
	}
	ArrayList classlist = channel.getChSon (Integer.parseInt(iStart),upp_ch_id);
	ArrayList counterList = channel.getChSon (upp_ch_id);
	int counter = counterList.size();
	
	NewsInfo newsObj = new NewsInfo();
	ArrayList newsList = newsObj.getNewsListByCustId(Integer.valueOf(iStart).intValue(), cust_id ,news_types);
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
			function setClassValue(val){
					var size = document.getElementById('size').value;
					window.parent.newform.class_type.value = document.getElementById('up_class_name'+val).value;
					window.parent.newform.news_type.value = document.getElementById('up_class_id'+val).value;
			}
		</script>
	</head>
	<body>
		<table width="600" border="0" bgcolor="#DEEDFD" cellspacing="1" cellpadding="1" align="center">
			<tr>
				<td>
					<table width="600" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr class="u4" height="25">
							<td width="20%">
								选择频道
							</td>
							<td width="30%">
								频道名称
							</td>
							<td width="50%">
								频道描述
							</td>
						</tr>
						<%	
								int size = 0;
								String ch_id = "", ch_name = "",ch_desc="",up_ch_id="",ch_level="",up_ch_name="";
								ArrayList downList = new ArrayList();
								if (classlist != null && classlist.size() > 0) {
									size = classlist.size();
									for (int a = 0; a < classlist.size(); a++) {
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
										downList = channel.getChSon (ch_id);
										
						%>
						<tr class="u2">
							<td align=left>
								<input type="radio" name="up_class_id" id="up_class_id<%=a%>" value="<%=ch_id%>" onclick="setClassValue('<%=a%>')">
								<input type="hidden" name="up_class_name" id="up_class_name<%=a%>" value="<%=ch_name%>">
							</td>
							<td align=left>
								<%
									if(downList!=null && downList.size()>0){
								%>
									<a href="displayClassName.jsp?up_ch_id=<%=ch_id%>"><%=ch_name%></a>
								<%
									}else{
								%>
									<font color="black"><%=ch_name%></font>
								<%
									}
								%>
								<input type="hidden" name="size" id="size" value="<%=size%>">
							</td>
							<td align=left>
								<%=ch_desc%>
							</td>
						
						</tr>
						<%
						}
						%>
						<tr class="u3">
								<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
								<td align="right"   style=" padding:2px 5px;">
								<a href="displayClassName.jsp?iStart=0&up_ch_id=<%=upp_ch_id%>">首页 </a>&nbsp; &nbsp;
								<% 
									if(Integer.parseInt(iStart)>0){
								%>
									<a href="displayClassName.jsp?iStart=<%=pageUp%>&up_ch_id=<%=upp_ch_id%>">上一页</a> &nbsp;
								<%
									}
									if(Integer.parseInt(iStart)<pages-1){
								%>
									<a href="displayClassName.jsp?iStart=<%=pageDown%>&up_ch_id=<%=upp_ch_id%>">下一页 </a>&nbsp; 
								<%
									}
								%>
								<a  href="displayClassName.jsp?iStart=<%=pages-1%>&up_ch_id=<%=upp_ch_id%>">尾页</a></td>
			
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


