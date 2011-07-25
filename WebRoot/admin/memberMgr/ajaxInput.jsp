<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.config"%>
<%@ page import="com.saas.biz.attachMgr.Attachinfo"%>
<%@ page import="com.saas.biz.commen.ReadExcel"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.io.*" %>
<html>
	<head>
		<title>更新主页</title>
		
	</head>
	<body>						
		<%	
				
				config configFile = new config();
				configFile.init();
				String rootpath = configFile.getString("mysqlbase.rootpath");
				ArrayList attachList = new Attachinfo().getFilePath("excel");
				String exlPath = "";
				if(attachList!=null){
					HashMap attMap = (HashMap)attachList.get(0);
					if(attMap.get("file_path")!=null){
						exlPath = attMap.get("file_path").toString();
					}
				}
				if(!exlPath.equals("")){
				
				ReadExcel excel = new ReadExcel();
				ArrayList alList = excel.readExcel(rootpath+exlPath); 
				
				//out.println(alList);
				
				excel.insertDB(alList);
				
			
		 

		
		%>
			<font size="3">数据插入成功............</font>
			
		<%
			}else{
		%>
		
			<font size="3">数据文件不存在............</font>
		
		<%		
			}
		%>
		
			
		
	</body>
</html>



