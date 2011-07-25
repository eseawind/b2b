<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="tools.util.FileIO,com.saas.biz.commen.config"%>
<%
	String cust_id = "";
	if( request.getParameter( "cust_id" ) != null )
 	{
  		cust_id = request.getParameter( "cust_id" );
  }
%>

<html>
	<head>
		<title>B2B电子商务平台</title>
</head>
<body>
	<%
		config configFile = new config();
		configFile.init();
		String dirpat = configFile.getString("ecms_path");
		String filepath = dirpat + "company/web/"+ cust_id;
		if ( !FileIO.ExistFloder(filepath) ) 
		{
	%>
		<script language="javascript">
			alert('对不起，用户未生成企业站！');
			history.go(-1);
		</script>
	<%
		}else{
	%>
			<script language="javascript">
					window.location.href='/company/web/<%=cust_id%>/';
			</script>
	<%		 
		}
	%>
</body>
</html>




