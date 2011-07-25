<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="tools" class="com.saas.biz.commen.PageTools" scope="page" />
<%@ page import="com.saas.biz.keyPriceMgr.KeyPriceInfo"%>
<%
	String key_location="";
	String key_price="";
	if (request.getParameter("key_location") != null) {
		key_location = request.getParameter("key_location");
	}
	
	KeyPriceInfo priceInfo = new KeyPriceInfo();
	ArrayList priceList = priceInfo.getKeyPriceInfo(key_location);
	if(priceList!=null && priceList.size()>0){
		HashMap map = (HashMap)priceList.get(0);
		if(map.get("key_price")!=null){
			key_price=map.get("key_price").toString();
		}
	}
%>
<html>
	<body>
		<%=key_price%>
	</body>
</html>



