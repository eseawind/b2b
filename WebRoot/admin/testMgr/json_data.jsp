<%@ page pageEncoding="GBK"%>
<jsp:useBean id="vbean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%
	String class_type="10";
	String json = vbean.getJsonDataForTree(class_type,"000000000000000", "Tree-Img");
	out.print(json);
%>




