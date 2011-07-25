<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="MD5" scope="request" class="beartool.MD5"/>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<jsp:useBean id="classBean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
   String v_mid="",v_url="",v_oid="",v_amount="",v_moneytype="",v_md5info="",remark1=""; 						     												

	  if(request.getParameter("v_mid")!=null){
		  v_mid=request.getParameter("v_mid");
	  }
	 	if(request.getParameter("v_url")!=null){
		  v_url=request.getParameter("v_url");
	  }
	  if(request.getParameter("v_oid")!=null){
		  v_oid=request.getParameter("v_oid");
	  }
	  if(request.getParameter("v_amount")!=null){
		  v_amount=request.getParameter("v_amount");
	  }
	  if(request.getParameter("v_moneytype")!=null){
		  v_moneytype=request.getParameter("v_moneytype");
	  }
		if(request.getParameter("remark1")!=null){
		  remark1=request.getParameter("remark1");
	  }
	  	
	  String text = v_amount+v_moneytype+v_oid+v_mid+v_url+key;   	
	  v_md5info = MD5.getMD5ofStr(text); 
    
%>
<html>
	<head>
		<title>会员缴费</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<!-- 中间 -->
				<td align="center">
				<form action="/supply/order/webBankMgr/Send.jsp" >
  
	<input type="hidden" name="v_md5info"    value="<%=v_md5info%>" size="100">
	<input type="hidden" name="v_mid"        value="<%=v_mid%>">
	<input type="hidden" name="v_oid"        value="<%=v_oid%>">
	<input type="hidden" name="v_amount"     value="<%=v_amount%>">
	<input type="hidden" name="v_moneytype"  value="<%=v_moneytype%>">
	<input type="hidden" name="v_url"        value="<%=v_url%>"> 
	
 
	<input type="hidden" name="remark1"      value="<%=remark1%>"> 
	<input type="hidden"  name="remark2" value="">
	
	<input type="hidden"  name="v_rcvname"      value="">   <!--收货人姓名-->
	<input type="hidden"  name="v_rcvaddr"      value="">   <!--收货人地址-->
	<input type="hidden"  name="v_rcvtel"       value="">   <!--收货人电话-->
	<input type="hidden"  name="v_rcvpost"      value="">   <!--收货人邮编-->
	<input type="hidden"  name="v_rcvemail"     value="">   <!--收货人Email-->
	<input type="hidden"  name="v_rcvmobile"    value="">   <!--收货人手机号-->
	<input type="hidden"  name="v_ordername"    value="">   <!--订货人姓名-->
	<input type="hidden"  name="v_orderaddr"    value="">   <!--订货人地址-->
	<input type="hidden"  name="v_ordertel"     value="">   <!--订货人电话-->
	<input type="hidden"  name="v_orderpost"    value="">   <!--订货人邮编-->
	<input type="hidden"  name="v_orderemail"   value="">   <!--订货人Email-->
	<input type="hidden"  name="v_ordermobile"  value="">   <!--订货人手机号-->


</form>
				</td>
			</tr>
		</table>
	</body>
</html>



