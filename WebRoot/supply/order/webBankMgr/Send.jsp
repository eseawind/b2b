<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

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
	  if(request.getParameter("v_md5info")!=null){
		  v_md5info=request.getParameter("v_md5info");
	  }
		if(request.getParameter("remark1")!=null){
		  remark1=request.getParameter("remark1");
	  }

%>

<!--以下信息为标准的 HTML 格式 + ASP 语言 拼凑而成的 网银在线 支付接口标准演示页面 无需修改-->

<html>

<body onLoad="javascript:document.E_FORM.submit()">
<form action="https://pay3.chinabank.com.cn/PayGate"   name="E_FORM">
  
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
</body>
</html>




