<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@ page import="com.saas.biz.rightMgr.*"%>
<%@ page import="com.saas.biz.pricerankMgr.*"%>

<%
	String cust_id = "";
	if(request.getParameter("cust_id") != null) {
		cust_id = request.getParameter("cust_id");
	}
	out.println("cust_id === "+cust_id);
	
	PriceRankInfo price = new PriceRankInfo();
	cust_id = price.getBiaoW("½ø¼Û","8855381456");
	out.println("cut_a === " + cust_id );
	
%>






