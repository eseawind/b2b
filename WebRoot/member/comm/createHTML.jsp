<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.buildhtml.CreateCustomerWeb"%>
<%
    HttpSession logsession = request.getSession();
	String cust_id = "";
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	String rootpath = "",company="";
	if(request.getParameter("rootpath")!=null){
	   rootpath=request.getParameter("rootpath");
	}
	if(request.getParameter("company")!=null){
	   company=request.getParameter("company");
	}
	//开始判断用户请求
	try {
		CreateCustomerWeb custWeb = new CreateCustomerWeb();
		custWeb.createCustomerWeb( rootpath, cust_id, company );
	}
	catch (NumberFormatException e) {
		out.println("e = " + e.toString());
	}
%>




