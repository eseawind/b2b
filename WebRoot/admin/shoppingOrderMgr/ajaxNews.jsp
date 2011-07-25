<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<html>
	<head>
		<title>Í³¼Æ</title>
	</head>
	<body>						
		
		<%
			String TimeRadio = "",chanel = "",counts="";
			if (request.getParameter("TimeRadio") != null) {				
        TimeRadio = request.getParameter("TimeRadio");
      }
		%>
		<%
			ChannelInfo channInfo = new ChannelInfo(); 
			String selectchann = channInfo.getNewsChannelRight("1","0","0000000000",TimeRadio); 
			out.println(selectchann);
		%>		
		
	</body>
</html>


