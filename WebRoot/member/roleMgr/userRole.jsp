<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="roleBean" class="com.saas.biz.roleMgr.RoleInfo" scope="page"></jsp:useBean>
<%
   String user_id="",cust_id="";
   if(request.getParameter("user_id")!=null){
      user_id=request.getParameter("user_id");
   }
   if(request.getParameter("cust_id")!=null){
      cust_id=request.getParameter("cust_id");
   }
   String role_name=roleBean.getRoleNameByUser_id(cust_id,user_id);
   if(role_name.equals("")){
   	role_name = "此用户暂未分配角色！";
   }
   out.print(role_name);
%>
	


