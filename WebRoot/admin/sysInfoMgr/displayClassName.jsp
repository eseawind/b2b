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
	String up_class_type = "";
	if (request.getParameter("class_type") != null) {
		up_class_type = request.getParameter("class_type");
	}
	ArrayList classlist = bean.getClassByUpClassId(Integer.parseInt(iStart),up_class_id,up_class_type);
	int counter = bean.getClassByUpClassId(up_class_id,up_class_type);
	
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
								选择分类
							</td>
							<td width="30%">
								资讯分类
							</td>
							<td width="50%">
								分类描述
							</td>
						</tr>
						<%	
								int size = 0;
								String class_name = "", class_id = "",class_desc="";
								ArrayList downList = new ArrayList();
								if (classlist != null && classlist.size() > 0) {
									size = classlist.size();
									for (int a = 0; a < classlist.size(); a++) {
										HashMap class_map = (HashMap) classlist.get(a);
										if (class_map.get("class_name") != null) {
											class_name = class_map.get("class_name").toString();
										}
										if (class_map.get("class_desc") != null) {
											class_desc = class_map.get("class_desc").toString();
										}
										if (class_map.get("class_id") != null) {
											class_id = class_map.get("class_id").toString();
										}
										downList = bean.getClassInfoByUpClassId("1",class_id);
										
						%>
						<tr class="u2">
							<td align=left>
								<input type="radio" name="up_class_id" id="up_class_id<%=a%>" value="<%=class_id%>" onclick="setClassValue('<%=a%>')">
								<input type="hidden" name="up_class_name" id="up_class_name<%=a%>" value="<%=class_name%>">
							</td>
							<td align=left>
								<%
									if(downList!=null && downList.size()>0){
								%>
									<a href="modityNewsIndex.jsp?up_class_id=<%=class_id%>"><%=class_name%></a>
								<%
									}else{
								%>
									<%=class_name%>
								<%
									}
								%>
								<input type="hidden" name="size" id="size" value="<%=size%>">
							</td>
							<td align=left>
								<%=class_desc%>
							</td>
						
						</tr>
						<%
						}
						%>
						<tr class="u3">
								<td align="left" colspan="2" style="font-weight:normal; padding:2px 5px;">共<%=counter%>条 &nbsp;第<%=Integer.parseInt(iStart)+1 %>页&nbsp;&nbsp;共<%=pages%>页</td>
								<td align="right"   style="padding:2px 5px;">
								<a href="displayClassName.jsp?iStart=0&up_class_id=<%=up_class_id%>&class_type=<%=up_class_type%>">首页 </a>&nbsp; &nbsp;
								<% 
									if(Integer.parseInt(iStart)>0){
								%>
									<a href="displayClassName.jsp?iStart=<%=pageUp%>&up_class_id=<%=up_class_id%>&class_type=<%=up_class_type%>">上一页</a> &nbsp;
								<%
									}
									if(Integer.parseInt(iStart)<pages-1){
								%>
									<a href="displayClassName.jsp?iStart=<%=pageDown%>&up_class_id=<%=up_class_id%>&class_type=<%=up_class_type%>">下一页 </a>&nbsp; 
								<%
									}
								%>
								<a  href="displayClassName.jsp?iStart=<%=pages-1%>&up_class_id=<%=up_class_id%>&class_type=<%=up_class_type%>">尾页</a></td>
			
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


