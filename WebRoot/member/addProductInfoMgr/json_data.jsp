<%@ page pageEncoding="GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.addproductMgr.AddProductInfo" scope="page" />
<%
	HttpSession htSe = request.getSession();
	String cust_id = (String) htSe.getAttribute("SESSION_CUST_ID");
	String json = bean.getJsonDataForTree(cust_id, "000000000000000", "Tree-Img");
	out.print(json);
%>





