<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="tools.util.FileIO"%>
<%@ page contentType="text/html;charset=GBK"%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
	</head>
<body>
	<%
	  String cust_id="";
	  if (request.getParameter("cust_id") != null)
    {
        cust_id = request.getParameter("cust_id");
    }
    String filepath=request.getContextPath()+"/templates/enterprise/"+cust_id+"/";
    String str="1111111111111111111111111111111111111111";
    String filename="index.htm";
     if (FileIO.ExistFloder(filepath))
     {
          FileIO.SaveToFile( str,filepath + filename );
     }
     else
     {
          FileIO.CreateFloder( filepath );
          FileIO.SaveToFile(str,filepath+filename);
     }
      out.print(filepath+filename);
	%>
</body>
</html>
			



