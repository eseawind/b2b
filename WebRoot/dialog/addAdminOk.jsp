<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="java.util.*"%>
 
<html>
<head>

<script language="javascript">
    function successredirectit(){         
        window.location.href='<%=request.getContextPath()%>/admin/mainMenu/default.jsp';                  
    }
</script>
</head>    
<body onload="successredirectit()">

</body>
</html>



