<% 
	HttpSession logsession = request.getSession();
	if(logsession.getAttribute("SESSION_CUST_TYPE")!=null){		 
			if(logsession.getAttribute("SESSION_CUST_TYPE").equals("1")){
%>
	<script>
	top.location.href="/admin/mainMenu/default.jsp";
	</script>
<%		
	}else{
%>
	<script>
	top.location.href="/member/mainMenu/default.jsp";
	</script>	
<%
			}
	 
	}	
%>








