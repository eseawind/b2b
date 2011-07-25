<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		
		<script type="text/javascript">
		 function check_Value(){
		   var para_code6=$F("para_code6");
		   para_code6=delAllSpace(para_code6);
		   if(para_code6 =="" || para_code6==null){
		    alert("请填写会员动作！");
		    $("para_code6").focus();
		    return false;
		   }
		   $("para_code2").value=DWRUtil.getText("para_code6");
		   var para_code4=$F("para_code4");
		   para_code4=delAllSpace(para_code4);
		   if(para_code4=="" || para_code4==null){
		    alert("请选择会员级别！");
		    $("para_code4").focus();
		    return false;
		   }
		   var para_code3=$F("para_code3");
		   para_code3=delAllSpace(para_code3);
		   if(para_code3 =="" || para_code3==null){
		    alert("请输入奖励黄金数量！");
		    $("para_code3").focus();
		    return false;
		   }
		   var start_date=$F("start_date");
		   start_date=delAllSpace(start_date);
		   if(start_date =="" || start_date==null){
		    alert("开始时间不能为空！");
		    $("start_date").focus();
		    return false;
		   }
		   var end_date=$F("end_date");
		   end_date=delAllSpace(end_date);
		   if(end_date =="" || end_date==null){
		    alert("结束时间不能为空！");
		    $("end_date").focus();
		    return false;
		   }
		   return true;
		 }
		 //删除所有空格
		 function delAllSpace(str) {
			return str.replace(/^\s+|\s+$/g, "")
		 }
		</script>
		<%
		
		   String user_name="";
		   String cust_type="";
		   String cust_id="";
		   String property_value="";
		   String acct_id="";
		if(request.getParameter("cust_id")!=null){
			  cust_id=request.getParameter("cust_id");
			}
		   if(request.getParameter("user_name")!=null){
			  user_name=request.getParameter("user_name");
			}
			if(request.getParameter("cust_type")!=null){
			  cust_type=request.getParameter("cust_type");
			}
				if(request.getParameter("property_value")!=null){
			  property_value=request.getParameter("property_value");
			}
				if(request.getParameter("acct_id")!=null){
			  acct_id=request.getParameter("acct_id");
			}	
		%>
	</head>
	<body>
	<form name=resumeForm action=/doChWealthTradeReg.do method=post target="_self">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding: 10px">
			<tr>
				
				<td align="center" height="27px">
					<div id="manager_body">
						<div id="manager_body_right">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<table width=725 border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
										<tr class="u4" height="25">
												<td colspan="2">
												 <div class="ping1"> 
												   设置会员财富
												 </div>
												</td>
											</tr>
											<tr>
												<td class="u1">
													用户名称：
												</td>
												<td class="u2">
													<div class="ping1">
													 <input type="text" size="25" name="action" value="<%=user_name%>"  readonly>
                                                             <input type="hidden" name="acct_id" value="<%=acct_id%>">
													</div>
												</td>
											</tr>
											<tr>
												<td class="u1">
													用户级别：
												</td>
												<td class="u2">
													<div class="ping1">
													    <input type="text" size="25" name="class_anem" value="<%=cust_type%>" readonly>
													</div>
												</td>
											</tr>
											<tr>
												<td class="u1">
													黄金数量：
												</td>
												<td class="u2">
													<div class="ping1">
														<input type="text" name="property_value" size="5" maxlength="50" value="<%=property_value%>" onkeyup="if(isNaN(value))execCommand('undo')">
														(两) &nbsp; &nbsp; &nbsp;<font color="red">注:仅限数字</font>
													</div>
												</td>
											</tr>
											<tr>
												<td class="u3" colspan="2">
													<input class="xgan" name="submit" type="submit" value="" >
												</td>
											</tr>
											<input type="hidden" name="trade_type_code" value="9527">
										</table>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>



