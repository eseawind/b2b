<%@ page contentType="text/html;charset=gb2312" %> 
<%@page import="java.util.*,com.saas.biz.onlineUserMgr.OnLineUser"%>
<%@page import="com.saas.biz.onlinehistoryMgr.OnlinehistoryInfo"%>
<jsp:useBean id="onlineuser" class="com.saas.biz.onlineUserMgr.OnLineUser" scope="application"/>
 
<html> 
<head> 
<title>�㶨JSP��������</title>
</head>
<body> 
<center> 
  <h1>��½�ɹ�����ӭ������!</h1>
</center>
<%   session = request.getSession(false); %> 
<% 
   String username=request.getParameter("username");
   if (onlineuser.existUser(username)){
       out.println("�û�<font color=red>"+username+"</font>�Ѿ���½��");
   }else{
       session.setMaxInactiveInterval(600);//Sesion��Чʱ��������Ϊ��λ
       session.setAttribute(username,onlineuser); 
       out.println("��ӭ���û�:<font color=red>"+username+"</font>��½��ϵͳ��");
   }
   out.println("<br>��ǰ�����û�����:<font color=red>"+onlineuser.getCount()+"</font><br>");
   Vector vt=onlineuser.getOnLineUser();
   Enumeration e = vt.elements();
   out.println("�����û��б�");
   out.println("<table border=1>");
   out.println("<tr><td>�û���</td></tr>");
   /*while(e.hasMoreElements()){
       out.println("<tr><td>");
       out.println((String)e.nextElement()+"<br>");
       out.println("</td></tr>");
   }
   ����ķ���Ҳ�ǿ��Եģ������ַ������ǿ��еģ���ʵIterator��Enumeration������
   */
   for(Iterator it=vt.iterator();it.hasNext();){
       out.println("<tr><td>");
       out.println((String)it.next()+"<br>");
       out.println("</td></tr>");
   }
   out.println("</table>");
     
%> 
<center> 
  <p>elapsed����</p>
  <p> </p>
<%
   out.println("<p>�˳�ϵͳ</p>");
%>
</center> 
</body> 
</html> 



