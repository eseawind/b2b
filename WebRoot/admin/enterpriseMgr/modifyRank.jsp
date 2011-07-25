<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="tools.util.FileIO"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileOutputStream"%>
<%@ page import="java.io.FileReader"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.Reader"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.base.config.ProjectConfig"%>
<html>
	<head>
		<title>修改模板代码</title>
		<link href="/style/css.css" rel="stylesheet" type="text/css">
	</head>
<body>
	<br><br><br>
	<table width="600" border="0" cellpadding="2" cellspacing="1" align="center" bgcolor="#e7e7e7">
		<tr>
				<td class="line1"
					style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"
				  align="center" width="50%">
					模板文件名
				</td> 
				<td
					style="background-color:#e2e2e2; color:#000000;  font-weight:bold; font-size:13px;"
					align="center" width="50%">
					修改模板代码
				</td>
		</tr>		
	<%
	  String cust_id="";
	  if (request.getParameter("cust_id") != null)
    {
        cust_id = request.getParameter("cust_id");
    }
    
    String savePath = "/usr/www/b2b.bizoss.com/templates/enterprise/"+cust_id+"/";
		String readPath = "/usr/www/b2b.bizoss.com/enterprise/d/"+cust_id;		
		 
		File file = new File(readPath);
		File[] files = file.listFiles();
			
		for (int i = 0; i < files.length; i++)
		{
			File file1 = files[i];
			Reader fileName = new FileReader(file1);
		%>	
		<tr style="background-color:#f9f9f9; " >
				<td style=" color:#000000;" align="center"">
					<%=file1.getName()%>
				</td> 
				<td style=" color:#000000;" align="center">
					<a href="modify.jsp?cust_id=<%=cust_id%>&cust_name=<%=file1.getName()%>">
						<img src="/img/edit.gif" border="0"  width="16" height="16"> </a>
				</td>
		</tr>			
		<%	
			BufferedReader re = new BufferedReader(fileName);
			
			File writeFile = new File(savePath);
			if (!writeFile.exists()) 
			{
				writeFile.mkdirs();
			}
			
			FileOutputStream fileoutputstream = new FileOutputStream(savePath + file1.getName());
			while (re.ready()) {
				String strbody = re.readLine() + "\n";
				byte abyte0[] = strbody.getBytes();
				fileoutputstream.write(abyte0);
			}
			fileoutputstream.close();
		}
	%>
			
	</table>
</body>
</html>
			



