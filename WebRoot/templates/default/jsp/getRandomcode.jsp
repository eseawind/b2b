
<%@ page contentType="text/html;charset=GBK"%>
 
<%
	String randomcode = "";
	if(session.getAttribute("RANDOMCODE")!=null){
		randomcode = session.getAttribute("RANDOMCODE").toString();
	}
	String in_cust_id = "<input type=hidden name=se_randomcode id=se_randomcode value="+randomcode+">";
	out.print( "document.write('"+in_cust_id+"');");
%>
 
 



