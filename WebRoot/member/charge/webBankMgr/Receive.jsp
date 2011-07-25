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
String charge_id = bean.GenTradeId();	
   String v_mid="",v_url="",v_oid="",v_amount="",v_moneytype="",v_md5info="",remark1="",key=""; 						     												
 HttpSession  logsession = request.getSession(); 
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
		if(request.getParameter("key")!=null){
		  key=request.getParameter("key");
	  }
	  if(v_oid==""){
	  	v_oid="20100104";
	  }
	  String text = v_amount+v_moneytype+v_oid+v_mid+v_url+key;   	
	  v_md5info = MD5.getMD5ofStr(text);
	  //out.println(text+"--------"+v_oid+"*****v_mid="+v_mid);
	  String cust_id="",user_id="",cust_class="";
	if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
	if (logsession.getAttribute("SESSION_USER_ID") != null)
    {
        user_id = logsession.getAttribute("SESSION_USER_ID").toString();
    }
    if (logsession.getAttribute("SESSION_CUST_CLASS") != null)
    {
        cust_class = logsession.getAttribute("SESSION_CUST_CLASS").toString();
    }
   String limit_time = v_oid;
   //out.println("</br>"+v_oid+"*******"+cust_class);
   if(v_oid.length()>7){
   	limit_time = v_oid.substring(0,4)+"-"+v_oid.substring(4,6)+"-"+v_oid.substring(6,8);
   }
   out.println(limit_time);
%>
<html>
	<head>
		<title>会员缴费</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script>
			window.onload=function   openWin(){ 
				document.newform.submit();  
  		  window.location="/member/charge/charge.jsp"   
  } 
		</script>
	</head>
	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<!-- 中间 -->
				<td align="center">
				<form name="newform" action=/doTradeReg.do method="post" target="_self">
  
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
	
	<input type="hidden" name="trade_id" id="trade_id" value="<%=charge_id%>">
	<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>">
	<input type="hidden" name="fee" id="fee" value="<%=v_amount%>">
	<input type="hidden" name="level_id" id="level_id" value="<%=cust_class%>">
	<input type="hidden" name="limit_time" id="limit_time" value="<%=limit_time%>">
	<input type="hidden" name="publish_user_id" id="publish_user_id" value="<%=user_id%>">
	<input type="hidden" name="trade_type_code" id="trade_type_code" value="2689">
</form>
				</td>
			</tr>
		</table>
	</body>
</html>



