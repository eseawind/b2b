<%@ page pageEncoding="GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.rightMgr.RightMenu" scope="page" />
<%
	HttpSession htSe = request.getSession();
	String cust_class = (String) htSe.getAttribute("SESSION_CUST_CLASS");
	String sub_code="";
	if(request.getParameter("sub_code")!=null){
	  sub_code=request.getParameter("sub_code");
	}
	String json = bean.getSendMenuJson(cust_class,sub_code,"Tree-Img");
	out.print(json);
%>



