<%@ page pageEncoding="GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.entityclassMgr.EntityClassInfo" scope="page" />
<%
	HttpSession htSe = request.getSession();
	String cust_id = (String) htSe.getAttribute("SESSION_CUST_ID");
	String type="";
	if(request.getParameter("type")!=null){
	 type=request.getParameter("type");
	}
	String json = bean.getJsonDataForTree(cust_id, "000000000000000", "Tree-Img",type);
	out.print(json);
%>





