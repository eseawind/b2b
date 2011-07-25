<%@ page pageEncoding="GBK"%>
<%@ page import="com.saas.biz.organizeMgr.OrganizeInfo"%>
<%
	HttpSession htSe = request.getSession();
	String cust_id = (String) htSe.getAttribute("SESSION_CUST_ID");
	OrganizeInfo org=new OrganizeInfo();
	String json = org.getJsonDataForTree(cust_id, "000000000000000", "Tree-Img");
	out.print(json);
%>




