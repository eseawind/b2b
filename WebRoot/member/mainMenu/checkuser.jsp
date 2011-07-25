<% 
	HttpSession logsession = request.getSession();
	if(logsession.getAttribute("SESSION_USER_ID")!=null){
		if(!logsession.getAttribute("SESSION_USER_ID").equals("")){
%>
<script>
	top.open("/admin/mainMenu/reg.jsp");
	</script>
<%		
		}
	}	
%>







