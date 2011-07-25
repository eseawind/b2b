<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.File"%>
<%@ page import="com.saas.biz.commen.config,tools.util.FileIO"%>
<%
	String cust_id="";
	if (session.getAttribute("SESSION_CUST_ID") != null) 
	{
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	String templateFolder = "";
	if( request.getParameter( "templateFolder" ) != null )
	{
		templateFolder = request.getParameter( "templateFolder" );
	}
	 File file = null;
	config configFile = new config();
	configFile.init();
	String webpath = configFile.getString("templates_path");
	//文件路径
	 
	webpath = webpath + cust_id;

	if( FileIO.ExistFloder( webpath ) )
	{  
		webpath = webpath + "/" + templateFolder;
		
		file = new File(webpath);
	}
	else
	{
	%>
		<script>
			window.alert("您还没有选择企业站模板!");
		</script>
	<%	
	}	
	 
   
 
 %>

<html>
	<head>
		<title>文件</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css">
	 	/*#name_list{height:310px;width:370px;overflow:auto;overflow-x:hidden;border:1px solid #dddddd;padding:0 5px;}
	 	#name_list ul{margin-left:15px; padding:0px; list-style-image:url(/admin/images/file.gif);}
		#name_list ul li{ padding-left:5px; margin-top:0px;margin-bottom:5px;}
		#name_list ul li ul{margin-left:15px; padding:0px; list-style-image:url(/admin/images/text.gif);}
		#name_list ul li ul li{ padding-left:5px; margin-top:0px;margin-bottom:5px;}*/
	</style>
	</head>
	 
	<body>
		<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
			<tr class="u4" height="25">
				<td align=center width="30%">文件名</td>
				<td align=center width="25%">文件大小</td>
				<td align=center width="25%">编辑</td>
			</tr>
			<%
				if(file!=null){
				if (file.isDirectory()) 
				{
					String[] filelist = file.list();
					
					for (int i = 0; i < filelist.length; i++) 
					{
					  	File readfile = new File(webpath + "//" + filelist[i]);
						 
						if (!readfile.isDirectory()) 
          				{
			%>
			<tr class="u2">
				<td align=center><%=readfile.getName()%></td>
				<td align=center><%=readfile.getName().length()%>&nbsp;K</td>
				<td align=center><a href="/member/comm/modifyCode.jsp?dirpath=<%=webpath%>&file_name=<%=readfile.getName()%>"><img src=/images/edit.gif width=16 height=16 border=0 alt="修改模板内容"></a></td>
			</tr>	
			 <%
			 			}
						 
					}
				}
				}
				
			 %>
  		</table>
  	</body>
</html>



