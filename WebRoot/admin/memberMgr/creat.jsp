<%@ page contentType="text/html;charset=GBK" language="java"%>
<%@ page import="com.buildhtml.*"%>
<html>
	<HEAD>
		<TITLE>ϵͳ���ݹ���</TITLE>
	</HEAD>
	<BODY>
		<center>
			<h4>
				<%
					String createType = "";
					if (request.getParameter("createType") != null) 
					{
						createType = request.getParameter("createType");
					}
					
					//��ʼ�ж��û�����
					
				
					 if (createType.equals("1")) 
					 {
					
						CreateAllCust cindex = new CreateAllCust();
						
						cindex.CreateIndex();
						
					
				%>
					<font size="3">��ҵվ���ɳɹ�............</font>
				<%
					 }else{
				%>
					<font size="3">��ҵվ����ʧ��............</font>
				<%
				 	}
				 	
				 	
				%>
			</h4>
			<center>
	</BODY>
</HTML>




