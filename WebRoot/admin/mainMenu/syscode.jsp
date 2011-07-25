<%@ page contentType="text/html;charset=GBK"%>
<%
  String subsys_code="B2B";
  if(request.getParameter("subsys_code")!=null){
    subsys_code=request.getParameter("subsys_code");
    session.setAttribute("subsys_code",subsys_code);
  }
%>




