<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ page import="com.buildhtml.*"%>
<html>
	<HEAD>
		<TITLE>系统内容管理</TITLE>
	</HEAD>
	<BODY>
		<center>
			<h4>
				<%
					String createType = "";
					if (request.getParameter("createType") != null) 
					{
						createType = request.getParameter("createType");
					}
					
					//开始判断用户请求
					
				
					 if (createType.equals("1")) 
					 {
					
						CreateAllCust cindex = new CreateAllCust();
						
						cindex.CreateIndex();
						
					
				%>
					<font size="3">企业站生成成功............</font>
				<%
					 }else{
				%>
					<font size="3">企业站生成失败............</font>
				<%
				 	}
				 	
				 	
				%>
			</h4>
			<center>
	</BODY>
</HTML>




