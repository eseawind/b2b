<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<%@ page import="com.buildhtml.CustCreateArticle"%>
<%@ page import="com.buildhtml.CustCreateChannel"%>
<%@ page import="com.buildhtml.CustCreateIndex"%>

<html>
	<head>
		<title>更新主页</title>
	</head>
	<body>						
		<%
					String cust_id = session.getAttribute("SESSION_CUST_ID").toString();	
					String index_temp = "temp"; 
					try {
						CustCreateIndex createIndex = new CustCreateIndex();
						String indexTemp = "company/enterprise/customer/"+cust_id+"/default/index.html";
						String save_dir = "company/web/"+cust_id;
						String default_page = "index.html" ;
						createIndex.CreateIndex(cust_id,indexTemp,save_dir,default_page);
						
						CustCreateChannel createChannel = new CustCreateChannel();
						createChannel.CreateChannelIndexList("0000000000",cust_id);	
					
						CustCreateArticle createArticle = new CustCreateArticle();
						createArticle.CreateArticleList("0000000000",cust_id);
						
					}catch(Exception e) {
						
					}
				index_temp = "";
		%>
		
		<%
			if(!index_temp.equals("")){//显示提示文字范围
		%>
			<font size="3"><nobr>企业站生成结束<nobr></font>
		<!--	<a href="/" target="_blank"><font size="3">预览...</font></a><br> -->
		<%
			}
		%>
	</body>
</html>



