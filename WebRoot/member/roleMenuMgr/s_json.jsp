<%@ page pageEncoding="GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.roleMgr.RoleMenu" scope="page" />
<%
	String sys_code = "", role_code = "";
	if (request.getParameter("sub_code") != null) {
		sys_code = request.getParameter("sub_code");
	}
	if (request.getParameter("code") != null) {
		role_code = request.getParameter("code");
	}
	HttpSession sesson = request.getSession();
	String cust_id = (String) sesson.getAttribute("SESSION_CUST_ID");
	String cust_class = (String) sesson.getAttribute("SESSION_CUST_CLASS");
	String json = bean.getJSONCheckBoxTreeData(cust_id, cust_class, sys_code, role_code, "Tree-Img");
	out.print(json);
%>




