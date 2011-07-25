<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custlinkMgr.CustlinkInfo" %>
<%
  CustlinkInfo link=new CustlinkInfo();
  String cust_id="",link_name="",link_url="";
  if(request.getParameter("cust_id")!=null){
    cust_id=request.getParameter("cust_id");
  }
  if(request.getParameter("link_name")!=null){
    link_name=request.getParameter("link_name");
  }
  if(request.getParameter("link_url")!=null){
    link_url=request.getParameter("link_url");
  }
  int result=link.getCustFriendlyExists(cust_id,link_name,link_url);
  out.print(result);
%>


