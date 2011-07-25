<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.custMgr.*"%>
<%@ page import="java.util.*"%>
<%
	String cust_id = "";
	HttpSession LOGSESSION = request.getSession();
	if(LOGSESSION.getAttribute("SESSION_CUST_ID")!=null){
		cust_id = LOGSESSION.getAttribute("SESSION_CUST_ID").toString();
	}
	CustClass classes = new CustClass();
	String cust_class  = "";
	if(cust_id.equals("")) {
		cust_class = "0";
	}
	cust_class = classes.getCustClassById(cust_id);
	String in_cust_id = "<input type=hidden name=custClass id=custClass value="+cust_class+">";
	out.print("document.write('"+in_cust_id+"');");
%>



