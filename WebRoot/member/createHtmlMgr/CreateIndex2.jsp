<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.CustCreateChannel"%>
<%@ page import="com.saas.biz.channelColumnMgr.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.config"%>

<html>
	<head>
		<title>更新栏目</title>
	</head>
	<body>						
									
									<%
											config configFile = new config();
											configFile.init();
											String savepath = configFile.getString("templates_save_path");
											
											String cust_id = session.getAttribute("SESSION_CUST_ID").toString();
											save_dir = savepath + cust_id;											
											
											if (request.getParameter("index_temp") != null){
													index_temp = request.getParameter("index_temp");
											}
											if( !index_temp.equals("")) {
												CustCreateIndex cindex = new CustCreateIndex();
												cindex.CreateIndex( cust_id, index_temp, save_dir, "index.html" );												 
											}
									%>
									
		
									<font size="3">生成首页结束.....</font>
									
										
		
	</body>
</html>


