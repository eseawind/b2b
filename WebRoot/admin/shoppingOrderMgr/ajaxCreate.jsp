<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.infoListMgr.InfoList"%>
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
      if (request.getParameter("chanel") != null) {				
        chanel = request.getParameter("chanel");
      }
      
      String counts1="",counts2="",counts3="",counts4="";
      int counts5 = 1000;
      InfoList infoList = new InfoList();
			if(chanel.equals("1")) {
				if(TimeRadio.equals("0")) {
					counts = infoList.getInfoListCountInfo("1");
				}else {
					counts = infoList.getInfoListCountTime(Integer.parseInt(TimeRadio),"1");
				}
			}else if(chanel.equals("2")) {
				if(TimeRadio.equals("0")) {
					counts = infoList.getInfoListCountInfo("2");
				}else {
					counts = infoList.getInfoListCountTime(Integer.parseInt(TimeRadio),"2");
				}
			}else if(chanel.equals("3")) {
				if(TimeRadio.equals("0")) {
					counts = infoList.getInfoListCountInfo("7");
				}else {
					counts = infoList.getInfoListCountTime(Integer.parseInt(TimeRadio),"7");
				}
			}else if(chanel.equals("4")) {
				if(TimeRadio.equals("0")) {
					counts = infoList.getInfoListCountInfo("3");
				}else {
					counts = infoList.getInfoListCountTime(Integer.parseInt(TimeRadio),"3");
				}
			}else if(chanel.equals("5")) {
				if(TimeRadio.equals("0")) {
					counts1 = infoList.getInfoListCountInfo("1");
					counts2 = infoList.getInfoListCountInfo("2");
					counts3 = infoList.getInfoListCountInfo("7");
					counts4 = infoList.getInfoListCountInfo("3");
					counts5 = Integer.parseInt(counts1)+Integer.parseInt(counts2)+Integer.parseInt(counts3)+Integer.parseInt(counts4);
					
				}else {
					counts1 = infoList.getInfoListCountTime(Integer.parseInt(TimeRadio),"1");
					counts2 = infoList.getInfoListCountTime(Integer.parseInt(TimeRadio),"2");
					counts3 = infoList.getInfoListCountTime(Integer.parseInt(TimeRadio),"7");
					counts4 = infoList.getInfoListCountTime(Integer.parseInt(TimeRadio),"3");
					counts5 = Integer.parseInt(counts1)+Integer.parseInt(counts2)+Integer.parseInt(counts3)+Integer.parseInt(counts4);
					
				}
			}
		%>
		<% if(!chanel.equals("5")) {%>
			<%=counts%>
		<% } else { %>
			<%=counts5%>
		<% } %>
		
	</body>
</html>


