<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="java.util.*"%>
<html>
<head>
<script language="JavaScript" src="/js/dialog.js"></script>
<%
	HttpSession logsession = request.getSession();
	if(logsession.getAttribute("SESSION_CUST_TYPE").equals("1")){
%>
		<script language="javascript">
    	function successredirectit(){         
         window.location.href("/admin/mainMenu/default.jsp"); 
    	}
    </script>
<%
	}else {
%>
	<script language="javascript">
    	function successredirectit(){         
        window.location.href("/member/mainMenu/default.jsp");
    	}
    </script>
<%
	}
%>
</head>    
<body onload="successredirectit()">

</body>
</html>



