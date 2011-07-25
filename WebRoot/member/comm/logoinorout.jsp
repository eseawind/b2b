<%@ page contentType="text/html;charset=GBK"%>
<%
  String cust_id="";
  HttpSession  logsession = request.getSession(); 
  if( logsession.getAttribute("SESSION_CUST_ID")!= null )
  {
      cust_id=logsession.getAttribute("SESSION_CUST_ID").toString();
  }
  if( cust_id != "" || !cust_id.equals( "" ) ) 
  {
  	 out.print( "<a href=\"/member/out.jsp\"> <img src=\"/admin/images/logout.gif\" alt=\"ÍË³ö\" border=\"0\"/></a>" );
  }
  else if( cust_id == "" || cust_id.equals("") )
  {
     out.print( "<a href=\"/member/b2b_ht.html\"> <img src=\"/admin/images/a_1.gif\" alt=\"µÇÂ¼\" border=\"0\"/></a>" );
  }
%>
 





