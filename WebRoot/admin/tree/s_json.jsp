<%@ page pageEncoding="GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.rightMgr.RightTreeMenu" scope="page" />
<%
	String sub_code="",cust_class="";
	if(request.getParameter("sub_code")!=null){
	  sub_code=request.getParameter("sub_code");
	}
	if(request.getParameter("cust_class")!=null){
	  cust_class=request.getParameter("cust_class");
	}
	String json = bean.getJSONCheckBoxTreeData(cust_class,sub_code,"Tree-Img");
	out.print(json);
%>




