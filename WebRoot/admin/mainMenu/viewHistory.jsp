<%@ page contentType="text/html;charset=gb2312" %> 
<%@page import="java.util.*"%>
<%@page import="com.saas.biz.onlinehistoryMgr.OnlinehistoryInfo"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<html> 
<head> 
<title>��������</title>
</head>
<body> 
<center> 
   

 <%
    String username = "";
	String iStart = "1";
	if (request.getParameter("iStart") != null ) 
	{
		iStart = request.getParameter("iStart");
	}
	if( request.getParameter( "username" ) != null )
	{	
   		username = request.getParameter( "username" );
    }
	int counter = 0;
	OnlinehistoryInfo history = new OnlinehistoryInfo();
	ArrayList historyList = new ArrayList();
   	historyList = history.getUserHistory( 0,20,username );
	counter = history.getUserHistoryCounter( username );
	String pageTools=tools.getPageTools(String.valueOf(counter),"20","viewHistory.jsp?username="+username+"&iStart=",Integer.parseInt(iStart) );
	
 %>
    
   <table border="1">
   	<tr>
		<td>�û���</td>
		<td>IP��ַ</td>
		<td>��¼ʱ��</td>
		 
	</tr>
   <%
   		
	   String user_name = "",ip_address = "",logoin_date = ""; 
	    
			
	   		if( historyList != null )
			{
				for( int i = 0; i < historyList.size(); i++  )
				{
					HashMap hismap = ( HashMap )historyList.get( i );
					if( hismap.get( "user_name" ) != null )
					{
						user_name = hismap.get( "user_name" ).toString();
					}
					if( hismap.get( "ip_address" ) != null )
					{
						ip_address = hismap.get( "ip_address" ).toString();
					}
					if( hismap.get( "logoin_date" ) != null )
					{
						logoin_date = hismap.get( "logoin_date" ).toString();
					}
		%>			
				<tr>
					<td><%=user_name%></td>
					<td><%=ip_address%></td>
					<td><%=logoin_date%></td>
					 
				</tr>	
		<%			
				}
			}    
		%>
		<tr><%=pageTools%></tr>
	</table>
 </center>
 <center> 
	<p><a href="/admin/mainMenu/onlineUser.jsp?username=<%=username%>">����</a> </p>
  	<p> �й���������Ϣ�������޹�˾ ����</p>
 	<p><a href="/admin/out.jsp?username=<%=username%>">�˳�ϵͳ</a> 
 </center> 
</body> 
</html> 


