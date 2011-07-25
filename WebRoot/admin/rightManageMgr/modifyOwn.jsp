<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custrightsMgr.RightManage"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<%
	String cust_class = "", right_code = "", limit_type = "";
	if (request.getParameter("cust_class") != null) {
		cust_class = request.getParameter("cust_class");
	}
	if (request.getParameter("right_code") != null) {
		right_code = request.getParameter("right_code");
	}
	if (request.getParameter("limit_type") != null) {
		limit_type = request.getParameter("limit_type");
	}
	
	String limit_value = "", enable_tag1 = "", remark = "";
	String cust_classs="",right_codes="",limit_types="";
	String cust_classly = "",right_codely = "",limit_typely = "";
	RightManage right = new RightManage();
	ArrayList ageList = right.genAllrightsByClass(cust_class, right_code, limit_type);
	if (ageList != null && ageList.size() > 0) {
		HashMap map = (HashMap) ageList.get(0);
		if (map.get("cust_class") != null) {
			cust_classs = map.get("cust_class").toString();
		}
		if (map.get("right_code") != null) {
			right_codes = map.get("right_code").toString();
		}
		if (map.get("limit_type") != null) {
			limit_types = map.get("limit_type").toString();
		}
		if (map.get("limit_value") != null) {
			limit_value = map.get("limit_value").toString();
		}
		if (map.get("remark") != null) {
			remark = map.get("remark").toString();
		}
		if (map.get("enable_tag") != null) {
			enable_tag1 = map.get("enable_tag").toString();
		}
		if (enable_tag1 == "0" || enable_tag1.equals("0")) {
			enable_tag1 = "有效";
		} else if (enable_tag1 == "1" || enable_tag1.equals("1")) {
			enable_tag1 = "无效";
		}
		cust_classly = bean.getParaCode2ByParaCode1("1",cust_classs);

		right_codely = bean.getParaCode2ByParaCode1("41",right_codes);
	
		limit_typely = bean.getParaCode2ByParaCode1("106",limit_types);
	}
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../ext/ext-all.js"></script>
		<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript">
		 function check_Value(){
		 	
			if (document.resumeForm.limit_value.value.replace(/\s*/g,"") == ""||document.resumeForm.limit_value.value.replace(/\s*/g,"") == null)
			{
				alert("限定值不可以为空！");
				document.resumeForm.limit_value.focus(); 
				return false;
			}
			return true;
		  }
		</script>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">

											<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#dddddd">
												<tr>
													<td class="u1">
														客户级别：
													</td>
													<td class="u2">
														<div >
															<%=cust_classly%>
														</div>
													</td>
													<td class="u1">
														权限代码：
													</td>
													<td class="u2">
														<div >
															<%=right_codely%>
														</div>
													</td>
												</tr>
												<tr>
													<td class="u1">
														限定类型：
													</td>
													<td class="u2">
														<div >
															<%=limit_typely%>
														</div>
													</td>
													<td class="u1">
														限定值：
													</td>
													<td class="u2">
														<div >
															<input type="text" name="limit_value" id="limit_value" value="<%=limit_value%>" maxlength="10" size="10" onkeyup="if(isNaN(value))execCommand('undo')">
														</div>
													</td>
												</tr>
												<tr>
													<td class="u1">
														是否有效：
													</td>
													<td class="u2" colspan="3">
														<div class="ping1">
															<%=enable_tag1%>
														</div>
													</td>
												</tr>
												<tr>
													<td class="u1">
														备注：
													</td>
													<td class="u2" colspan="3">
														<div class="ping1">
															<input type="text" name="remark" id="remark" maxlength="50" size="52" value="<%=remark%>">
														</div>
													</td>
												</tr>
												<tr>
													<td style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; padding-top: 10px; padding-bottom: 10px; text-align: center;" align="center" colspan="4">
														<input class="tjan" name="submit" type="submit" value="" onclick="return check_Value()">
														&nbsp;&nbsp;<img src="/admin/images/comeback.JPG" onClick="javascript:window.location.href='model.jsp';" style="cursor:hand;" align="absmiddle">
					       
													</td>
												</tr>
												<tr>
													<td>
														<input type="hidden" name="update_staff_id" id="update_staff_id" value="">
														<input type="hidden" name="cust_class" id="cust_class" value="<%=cust_class%>">
														<input type="hidden" name="right_code" id="right_code" value="<%=right_code%>">
														<input type="hidden" name="limit_type" id="limit_type" value="<%=limit_type%>">
														<input type="hidden" name="enable_tag" id="enable_tag" value="0">
														<input type="hidden" name="update_depart_id" id="update_depart_id" value="">
														<input type="hidden" name="update_time" id="update_time" value="">
														<input type="hidden" name="trade_type_code" value="1203">
													</td>
												</tr>
											</table>
										
		</form>
	</body>
</html>



