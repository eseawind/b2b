<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="tools.util.*"%>
<%@ page import="com.saas.biz.commen.config"%>
<%
	FileIO fileIo = new FileIO();
	config configFile = new config();
	configFile.init();
	String rootpath = configFile.getString("mysqlbase.rootpath");
	String folderPath = rootpath + "install";
	if(fileIo.ExistFloder(folderPath)){
		fileIo.RemoveFloders(folderPath);
	}
%>

<html>
	<head>
		<title>删除文件成功</title>
		<link rel="stylesheet" type="text/css" href="/templates/default/style/wood.css" />
	</head>
	<body >



<div style=" padding-top:50px; padding-bottom:50px; margin:0 auto;">       
   <div style=" width:500px;margin:0 auto; text-align:center; height:139px; line-height:139px; background:url(/images/error_bg.gif); color:#666666; font-size:14px; font-weight:bold; padding-top:30px;"><img src="/images/BlueErrorIcon.gif" align="absmiddle" border="0"/>&nbsp;
    <a href="/admin/index.jsp">文件夹删除成功,请登陆后台！</a>
    </div> 
</div>


	</body>
</html>




