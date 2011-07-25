<%@ page contentType="text/html;charset=GBK" %> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
 
<html>
<head>
	<title><bean:message key="system.tittle"/></title>
		<script language="JavaScript" src="/js/dialog.js"></script>
</head>

<body onload="failscloseit()"> 
	<%
		 ArrayList resultlist = (ArrayList) request.getAttribute("backQ");
		 String backInfo = "";
		 for (Iterator it = resultlist.iterator(); it.hasNext();)
	     {
	        HashMap infoMaps = (HashMap)it.next();
	        if (infoMaps.get("RESULT_INFO")!= null)
	        {
	            backInfo = backInfo + infoMaps.get("RESULT_INFO").toString()+"\n";
	        }
	     }
	%>
	<%=backInfo%>
</body>
</html>




