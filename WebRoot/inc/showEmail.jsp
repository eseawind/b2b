<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="com.saas.biz.addMyInternetMgr.AddMyInternetInfo"%>
<%@ page import="java.util.*"%>
<html>
	
<head>
	<title>显示邮箱</title>
</head>

<body>
	  
	<table width=100% border="1" cellspacing="0" cellpadding="0" align="center">
	<tr >
		<td width=50%>	
	<%
		String type = "";
		if (request.getParameter("number") != null)
    {
        type = request.getParameter("number");
    }
		HttpSession  logsession = request.getSession(); 
    String cust_id="",user_id="";
    String email="",blog="",qq="",msn="",custwww="",userwww="";
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }	
		if (logsession.getAttribute("SESSION_USER_ID") != null)
    {
        user_id = logsession.getAttribute("SESSION_USER_ID").toString();
    }			
		//out.print("cust_id:" + cust_id + "user_id:" + user_id + "<br>");
		
		
		AddMyInternetInfo myInternet = new AddMyInternetInfo();
		HashMap map = myInternet.getattrById( cust_id, user_id );
		
		if( map.get("email") != null )
		{
		  email = map.get("email").toString();
		  //email = email.replaceAll("\\|", " ");
		  //out.print( "<p>我的邮箱:" + "<a href=''>" + email + "</a>" + "<br>");
		  out.print("<p>我的邮箱:" + "<br>");		  
			StringTokenizer st = new StringTokenizer( email,"|");
			while( st.hasMoreTokens() )
			{
			out.print( "<a href=''>" + st.nextToken().toString() + "</a>" + "<br>");
			}
	
		}
		%>
	</td>
	<td width=50%>wwwwwwwwwwwwwww<%=type%>
		<%
		if(map.get("blog")!= null )
		{
			blog = map.get("blog").toString();
			//blog = blog.replaceAll("\\|"," ");
			//out.print("<div>我的博客:" + blog + "</div>");
			out.print("<div>我的博客:" + "</div>");		  
			StringTokenizer st = new StringTokenizer( blog,"|");
			while( st.hasMoreTokens() )
			{
				out.print( "<div><a href=''>" + st.nextToken().toString() + "</a>" + "</div>");
			}
		}
		%>
	</td>
</tr>
<tr>
	<td width=50%>
	<%
		if(map.get("qq")!= null )
		{
			qq = map.get("qq").toString();
			//qq = qq.replaceAll("\\|"," ");
			//out.print( "<p>我的QQ:" + qq + "<br>");
			out.print("<p>我的QQ:" + "<br>");		  
			StringTokenizer st = new StringTokenizer( qq,"|");
			while( st.hasMoreTokens() )
			{
				out.print( "<a href=''>" + st.nextToken().toString() + "</a>" + "<br>");
			}
		}
		%>
	</td>
	<td width=50% >
		<%
		if(map.get("msn")!= null )
		{
			msn = map.get("msn").toString();
			//msn = msn.replaceAll("\\|"," ");
			//out.print("<p>我的MSN:" + msn +"<br>");
			out.print("<p>我的MSN:" + "<br>");		  
			StringTokenizer st = new StringTokenizer( msn,"|");
			while( st.hasMoreTokens() )
			{
				out.print( "<a href=''>" + st.nextToken().toString() + "</a>" + "<br>");
			}
		}
		%>
	</td>
</tr>
<tr>
	<td width=50%>
		<%
		if(map.get("custwww")!= null )
		{
			custwww = map.get("custwww").toString();
			//custwww = custwww.replaceAll("\\|"," ");
			//out.print("<p>公司网站:" + custwww + "<br>");
			out.print("<p>公司网站:" + "<br>");		  
			StringTokenizer st = new StringTokenizer( custwww,"|");
			while( st.hasMoreTokens() )
			{
				out.print( "<a href=''>" + st.nextToken().toString() + "</a>" + "<br>");
			}
		}
		%>
		</td>
		<td width=50%>
			<%
		if(map.get("userwww")!= null )
		{
			userwww = map.get("userwww").toString();
			//userwww = userwww.replaceAll("\\|"," ");
			//out.print("<p>我的收藏:" + userwww + "<br>");
			out.print("<p>我的收藏:" + "<br>");		  
			StringTokenizer st = new StringTokenizer( userwww,"|");
			while( st.hasMoreTokens() )
			{
				out.print( "<a href=''>" + st.nextToken().toString() + "</a>" + "<br>");
			}
		}
	else 
		out.print("*********************");
	%>
</td>
</tr>

</table>
<body>			
	
</html>



