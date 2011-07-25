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
   HttpSession  logsession = request.getSession(); 
 //	String fbtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

	String user_name = "";
	String cust_name = "";
  String account_id="";

  String cmoney="";

	 String v_mid="",v_url="",v_oid="",v_amount="",v_moneytype="",v_md5info="",remark1="",key="";
	 String money="";String days=""; 	String epireday="";					     												

	  if(request.getParameter("money")!=null){
		  money=request.getParameter("money");
	  }
	  if(request.getParameter("key")!=null){
		  key=request.getParameter("key");
	  }
	  if(request.getParameter("buyfordays")!=null){
		  days=request.getParameter("buyfordays");
	  }
	  if(request.getParameter("expire_date")!=null){
		  epireday=request.getParameter("expire_date");
	  }
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
	  }                                    //费用类型 0:人民币 1:美元 	
 	//key = "wanglonglongwang";
 //	out.println(key);
 	String oid="";
 	Date currTime = new Date();
 	for(int j=0;j<v_oid.length();j++){
 		if(v_oid.charAt(j)>='0' && v_oid.charAt(j)<='9'){
 			oid = oid + v_oid.charAt(j);
 		}
 	}
 	oid = oid + "-";
 	//out.println(oid+"********");
  SimpleDateFormat sf = new SimpleDateFormat(oid+v_mid+"-hhmmss",Locale.US);
  v_oid=sf.format(currTime);
 	//out.println(v_oid);
	String text = v_amount+v_moneytype+v_oid+v_mid+v_url+key;
	v_md5info = MD5.getMD5ofStr(text);
%>
<html>
	<head>
		<title>会员缴费</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type='text/javascript'src='<%=request.getContextPath()%>/dwr/interface/ChargeInfo.js'></script>
		<script type='text/javascript'src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript'src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="charge.js"></script>
	</head>
	<body >
			<form method="post" name="NewRegisterForm" id="NewRegisterForm" action="/member/charge/webBankMgr/Send.jsp" onsubmit="return Check_Value() ">		
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#DEEDFD">

															
									<tr>
										<td class="u1" width="25%">
											定购时长：
										</td>
										<td class="u2" >
												<div class="ping1">
												<input type="text" name="buyfordays" id="moneyId" v readOnly  maxlength="20" value="<%=days%>">
										 <span>(天)</span>
										 </div>
										</td>
									</tr>
										<tr>
										<td class="u1" width="25%" >
											需要金额：
										</td>
										<td class="u2">
											<div>
											<input type="text" name="money" id="moneyId" readOnly  maxlength="20" value="<%=money%>"  >
										 <span>(元)</span>
										</div>
										</td>
									  </tr>
										<tr>
										<td  class="u1" width="25%">
											会费过期日：
										</td>
										<td  class="u2" >
											<input type="text" name="expire_date" id="expire_date"  readOnly  maxlength="20" value="<%=epireday%>" >
										</td>
									</tr>									
									 <tr>
									 	<table width="100%" border="0" id="tab0" cellspacing="0" cellpadding="0" align="center" style="display:none">
										<tr>
										<td height="30" align="center">
												<div>联系运营商</div>
										</td>
									   </tr>
									  </table>
									 </tr>																	 							
									<tr>
										<table width="100%" border="0"  id="tab1" cellspacing="0" cellpadding="0" align="center" style="disp1lay:none" >
										<tr>
										<td height="30" align="center">
							    	<input type="hidden" name="v_md5info"    value="<%=v_md5info%>" size="100">
										<input type="hidden" name="v_mid"        value="<%=v_mid%>">
										<input type="hidden" name="v_oid"        value="<%=v_oid%>">
										<input type="hidden" name="v_amount"     value="<%=v_amount%>">
										<input type="hidden" name="v_moneytype"  value="<%=v_moneytype%>">
										<input type="hidden" name="v_url"        value="<%=v_url%>">
										<input type="hidden" name="remark1"      value="<%=remark1%>"> 
										<img src="/images/wangy.gif" alt="" align="absmiddle" style="cursor:hand;" onclick="javascript:document.NewRegisterForm.submit();"/>									
										</td>
									   </tr>
									  </table>
										  <input type="hidden" name="trade_type_code" value="3118">
									  </tr>																	
								</table>																			
          </form>
	</body>
</html>



