<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="java.lang.Integer"%>
<%@ page import="com.saas.biz.commen.config"%>
<%@ page contentType="text/html;charset=GBK"%>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>配置文件管理</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
</head>
<%
	request.setCharacterEncoding("gbk");
	String listsize = "";
	if (request.getParameter("listsize") != null){
		listsize = request.getParameter("listsize");
	}
	String help2="";
	String str = "";
	int val = 0;
	for(int i=0;i<listsize.length();i++)
		val = val*10 + listsize.charAt(i)-'0';
	for(int i=0;i<val;i++){
		if (request.getParameter("help"+i)!= null){
				if(!request.getParameter("help"+i).equals(help2)){
					str = str+"#"+request.getParameter("help"+i)+"\n";
				}
				help2 = request.getParameter("help"+i);
		
		}
		if (request.getParameter("name"+i)!= null){
			str =str+ request.getParameter("name"+i).toString()+"=";
		}
		if (request.getParameter("value"+i)!= null){
			str = str+request.getParameter("value"+i).toString()+"\n";
		}
	}
	config con = new config();
	con.WriteToFile(str);
%>

<script language="javascript">
	alert('修改成功');
	history.go(-1);
</script>
</html>



