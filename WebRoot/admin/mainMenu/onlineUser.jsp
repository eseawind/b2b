<%@ page contentType="text/html;charset=gb2312" %> 
<%@page import="java.util.*,com.saas.biz.onlineUserMgr.OnLineUser"%>
<%@page import="com.saas.biz.onlinehistoryMgr.OnlinehistoryInfo"%>
<jsp:useBean id="onlineuser" class="com.saas.biz.onlineUserMgr.OnLineUser" scope="application"/>
 
<html> 
<head> 
<title>搞定JSP在线人数</title>
</head>
<body> 
<center> 
  <h1>登陆成功，欢迎您访问!</h1>
</center>
<%   session = request.getSession(false); %> 
<% 
   String username=request.getParameter("username");
   if (onlineuser.existUser(username)){
       out.println("用户<font color=red>"+username+"</font>已经登陆！");
   }else{
       session.setMaxInactiveInterval(600);//Sesion有效时长，以秒为单位
       session.setAttribute(username,onlineuser); 
       out.println("欢迎新用户:<font color=red>"+username+"</font>登陆到系统！");
   }
   out.println("<br>当前在线用户人数:<font color=red>"+onlineuser.getCount()+"</font><br>");
   Vector vt=onlineuser.getOnLineUser();
   Enumeration e = vt.elements();
   out.println("在线用户列表");
   out.println("<table border=1>");
   out.println("<tr><td>用户名</td></tr>");
   /*while(e.hasMoreElements()){
       out.println("<tr><td>");
       out.println((String)e.nextElement()+"<br>");
       out.println("</td></tr>");
   }
   下面的方法也是可以的，这两种方法都是可行的，其实Iterator是Enumeration的子类
   */
   for(Iterator it=vt.iterator();it.hasNext();){
       out.println("<tr><td>");
       out.println((String)it.next()+"<br>");
       out.println("</td></tr>");
   }
   out.println("</table>");
     
%> 
<center> 
  <p>elapsed制作</p>
  <p> </p>
<%
   out.println("<p>退出系统</p>");
%>
</center> 
</body> 
</html> 



