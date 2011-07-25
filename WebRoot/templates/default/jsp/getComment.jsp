
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.newsMgr.*"%>
<jsp:useBean id="newsInfo" class="com.saas.biz.newsMgr.NewsInfo" scope="page"></jsp:useBean>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
	<jsp:useBean id="userInfo" class="com.saas.biz.userMgr.UserInfo" scope="page" />
<%
	String condition = "",commentText = "",iStart="1" ,pageTools ="";
	String news_id="", title="", content="", audit_user_id="", audit_date="",audit_user="",save_dir="";
	if(request.getParameter("condition")!=null){
		condition = request.getParameter("condition");
	}
	if(request.getParameter("commentText")!=null){
		commentText=new String (request.getParameter("commentText").getBytes("ISO_8859_1"),"GBK");
	}
	if(request.getParameter("iStart")!=null){
		iStart = request.getParameter("iStart");
	}
	
	ArrayList bookList = newsInfo.getCommentByText(Integer.parseInt(iStart),10,commentText,condition);
	int counter = newsInfo.getCommentByText(commentText,condition);
	
  pageTools = tools.getGoogleToolsBar(counter,"/templates/default/jsp/commentSearch.html?condition=" + condition + "&commentText=" + commentText + "&iStart=", Integer.parseInt(iStart) ,10);

%>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="/templates/default/style/bookstore.css" />
	<link rel="stylesheet" type="text/css" href="/templates/default/style/distest.css" />
   <link rel="stylesheet" type="text/css" href="/templates/default/style/cn-b2b.css" />
		</head>
		<body>
<div id="main"><div class="path" style="margin-top:10px;">您所在的位置 > <a href="/">首页</a> > <a href="/default/pingCe/">评测</a> > 搜索列表</div></div>
	<table align="center" cellpadding="1" cellspacing="1" bgcolor="#BEDABA" width="950">
			
		<%
			if(bookList!=null){
		%>
		
			<tr style="background:url(/templates/default/images/book_search_lmt_bg.gif) repeat-x top left; line-height:24px; color:558D55; text-align:left; text-indent:1em;">
				<th>标题</th>
				<th>内容</th>
				<th>评测人</th>
				<th>评测日期<%=iStart%></th>
			</tr>
		
		<%
				for(int i = 0;i<bookList.size();i++){
					HashMap bookMap = (HashMap)bookList.get(i);
					if(bookMap.get("news_id")!=null)
					{ 
					news_id = bookMap.get("news_id").toString();
					 }
					if(bookMap.get("title")!=null)
					{ 
					title = bookMap.get("title").toString();
					if(title.length()>15){
							title = title.substring(0,15)+"...";
						} 
					}
					if(bookMap.get("content")!=null){
					 content = bookMap.get("content").toString();
					 	if(content.length()>15){
							content = content.substring(0,15)+"...";
						}
					  }
					  if(bookMap.get("save_dir")!=null){
					  save_dir = bookMap.get("save_dir").toString();
			      save_dir="/"+save_dir+"/";
					  }
					if(bookMap.get("audit_user_id")!=null){ 
					audit_user_id = bookMap.get("audit_user_id").toString();
			    audit_user=userInfo.getUserNameById(audit_user_id);;
					 }
					if(bookMap.get("audit_date")!=null){ 
						audit_date = bookMap.get("audit_date").toString(); 
						if(audit_date.length()>10){
							audit_date = audit_date.substring(0,10);
						}
					}
		%>
			<tr bgcolor="white" style="line-height:24px; color:555; font-family:Arial, Helvetica, sans-serif; text-align:left; text-indent:1em;">
				<td><a href=" <%=save_dir%>d/content-<%=news_id%>.html"><%=title%></a></td>
				<td><%=content%></td>
				<td><%=audit_user%></td>
				<td><%=audit_date%></td>
			</tr>
	
		<%

				}
			}else{
		%>
			<tr bgcolor="#DEEBDE">
				<td colspan="4" align="center">
					<b>无您要查询的记录！<%=counter%></b>
				</td>
			</tr>
		<%	
			}
		%>
	<tr bgcolor="#DEEBDE" align="center" style="line-height:24px; color:555; font-size:14px; font-weight:bold;">
			<td colspan=4><%=pageTools%>
			</td>
	   </tr>
	</table>
	</br>
	</body>
	</html>
	<script src="/templates/default/js/footer.js"></script>
 
 



