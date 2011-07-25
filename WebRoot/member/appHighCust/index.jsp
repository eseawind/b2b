<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
 "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.custMgr.CustClass"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<html>
	<head>
		<title>申请会员级别</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
	</head>
<%
	String cust_id="",user_id="";
	if(session.getAttribute("SESSION_CUST_ID")!=null){
				cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	if(session.getAttribute("SESSION_USER_ID")!=null){
				user_id = session.getAttribute("SESSION_USER_ID").toString();
	}
	Custinfo custinfo = new Custinfo();
	ArrayList custArray = new ArrayList();
	custArray = custinfo.getCustInfo(cust_id);
	CustClass level = new CustClass();
	String class_Name = level.cust_Class_Name(cust_id);
	commMethodMgr commen = new commMethodMgr();
	String trade_id = commen.GenTradeId();
	String class_id = level.cust_Class_ID(cust_id);
	ParamethodMgr paramCom = new ParamethodMgr();
	ArrayList customer_class = new ArrayList();
	customer_class = paramCom.getCompareInfoByNotIN("14",class_id);		
%>
	<body>
			<form action="/doTradeReg.do" name="form0" method="post" id="upCustClass">
		<table  width="100%" border=0 cellpadding=1 cellspacing=1 bgcolor="#DEEDFD">
			<tr>
				<td class="u2" colspan=3>
					您当前的级别：<%=class_Name%>
				</td>
			</tr>
			<tr>
				<td class="u2">
			<strong>请选择您想升级的级别：</strong>
	<%
						if(customer_class!=null){
						String cust_class1="",cust_name1="";
							for(int i=0;i<customer_class.size();i++){
								HashMap classMap = (HashMap)customer_class.get(i);
								if(classMap.get("para_code2")!=null){
									cust_name1 = classMap.get("para_code2").toString();							
								}
								if(classMap.get("para_code1")!=null){
									cust_class1 = classMap.get("para_code1").toString();							
								}
								if(cust_class1.equals("1")){
									continue;
								}								
					%>
					<input type="radio" name="cust_class_t" id="cust_class_t" value="<%=cust_class1%>"><%=cust_name1%>
					<%
							}
						}
					%>
						
					</td>
				</tr>
			<tr>
			<td>
				<center>
					<input type="hidden" id="app_level" name="app_level" value="">
					<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>">
					<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>">
					<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>">
					<input type="hidden" name="pass_or_not" id="pass_or_not" value="0">
					<input type="hidden" name="now_class_type" id="now_class_type" value="<%=class_id%>">
					<input type="hidden" name="trade_type_code" id="trade_type_code" value="2569">
					<input type="hidden" name="cust_class" id="cust_class" value="">
					<input type="hidden" name="trade_id" id="trade_id" value="<%=trade_id%>">
					<img src="/images/tj.gif" border="0" onclick="javascript:SendClass();" style="cursor:hand;">
				</center>
				</td>
			</tr></table>
				</form>

</body>
</html>
<script language="javascript">
	function SendClass(){
		var falg= -1 ;
		var val = '';
		//var app_level = document.getElementById("app_level").value;
		var objs = document.getElementsByName("cust_class_t");
		for(var i=0;i<objs.length;i++)   
		 {   
 			if(objs[i].checked)   
  		{
  			val = objs[i].value;
  			falg = 1;
  		}
  	}
  	if(val==''){
  		alert("请选择您想升级的客户级别！");
  		return false;	
  	}
  	else{
	  	document.getElementById("app_level").value = val;
	  	//document.getElementsByID("trade_type_code").value='0567';
			//alert(document.getElementById("cust_class").value);
	  	document.form0.submit();
	  }
	}
</script>




