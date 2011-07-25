
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="property" class="com.saas.biz.propertyuMgr.PropertyuInfo" scope="page"></jsp:useBean>
<%
	String user_id="";
	if(request.getParameter("user_id")!=null){
		user_id = request.getParameter("user_id");
	}
	String menoy=property.getUserPropertyValue(user_id,"0");
	
	out.print( "document.write('"+menoy+"');");
%>

 
 



