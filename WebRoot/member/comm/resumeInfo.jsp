<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ผ๒ภ๚ฯ๊ฯธาณ</title>
    <script type="text/javascript" src="/js/comm.js"></script>
  </head>
  
  <body onload="autoSubmit()">
    <% 
    	String resume_id = "";
    	if(session.getAttribute("SESSION_USER_ID")!=null){
    		resume_id = session.getAttribute("SESSION_USER_ID").toString();
    	}
    %>
    <form action="/resume/resume_content.jsp?resume_id=<%=resume_id%>" method="post" name="resumeForm">
    	<input type="hidden" name="user_id" value="<%=resume_id%>" id="user_id">
    </form>
  </body>
</html>





