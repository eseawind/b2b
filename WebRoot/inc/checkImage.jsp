
<%@ page contentType="text/html;charset=GBK"%>

<%@ page import="com.saas.biz.commen.config"%>
<%

	config configFile = new config();
	configFile.init();
	String checkregimage = configFile.getString("checkloginimage");
	String check_img = "<input type=hidden name=checkregimage id=checkregimage value="+checkregimage+">";
		out.print( "document.write('"+check_img+"');");
%>





