<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.config"%> 
<%
	config configFile = new config();
	configFile.init();
	String value = configFile.getString("newsearch");
	
	String in_cust_id = "<input type=hidden name=new_Search id=new_Search value="+value+">";
	out.print( "document.write('"+in_cust_id+"');");
%>



