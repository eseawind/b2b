<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.repositoryMgr.RepositoryInfo"%>
<%
	String repository_id="";
	String title="";
	String publish_date="";
	String content="";
	String mini_img="";
	if(request.getParameter("repository_id") != null)
	{
		repository_id = request.getParameter("repository_id");
	}
	
	RepositoryInfo re = new RepositoryInfo();
	ArrayList alist = new ArrayList();
	alist = re.getAllRepositoryByID(repository_id);
	if(null != alist)
	{
			HashMap map = (HashMap)alist.get(0);
			if(map.get("mini_img") != null)
			{
				mini_img = map.get("mini_img").toString();
			}
			if(mini_img == null || mini_img.equals(""))
			{
				mini_img = "/images/cpwu.gif";
			}
			if(map.get("repository_id")!=null)
			{
				repository_id = map.get("repository_id").toString();
			}
			if(map.get("title")!=null)
			{
				title = map.get("title").toString();
			}
			if(map.get("content")!=null)
			{
				content = map.get("content").toString();
			}
			if(map.get("publish_date")!=null)
			{
				publish_date = map.get("publish_date").toString();
			}
//			if(content.length()>10)
//			{
//				content = content.substring(0,15)+"...";
//			}
			if(publish_date.length()>10)
			{
				publish_date = publish_date.substring(0,10);
			}
	}
%>

<html>
	<head>
		<title>栏目频道管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/www/fuction/public.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
	</head>

	<body>
  <form>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td>
				  <table width="100%" border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
						<tr>
							<td>
								技术标题:
							</td>
							
							<td>
								<%=title %>
							</td>
							<td>
								时间:	
							</td>
							<td>
								<%=publish_date %>
							</td>
						</tr>
						
						<tr>
							<td>
								技术内容:	
							</td>
							<td>
								<%=content %>
							</td>
						</tr>
										
						<tr>
							<td>
								图片:
							</td>
							<td>
									<img src="<%=mini_img%>" border=0 width="100" height="100">
							</td>
						</tr>								
						
					</table>
				</td>
			</tr>
		</table>
	</form>
	</body>

</html>





