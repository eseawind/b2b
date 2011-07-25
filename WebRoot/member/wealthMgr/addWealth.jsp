<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="comparam" class="com.saas.biz.commen.ParamethodMgr" scope="page"></jsp:useBean>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<style>
		 .l_td{background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;text-align:right;width: 15%}
		 .r_td{background-color:#ffffff; color:#000000;  font-size:12px;width: 85%}
		</style>
		<script type="text/javascript" src="/js/wealthMgr.js">
		<%
			String start_date = "";
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			start_date = formate.format(new Date());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, 50);
			String end_date = formate.format(cal.getTime());
			String cust_class = comparam.getSelectItems("14");
			String param_attr = comparam.getParam_attrMax("B2B");
			String para_code1 = comparam.getParam_CodeMax("B2B","101");
			String para_code6 = comparam.getSelectItems("102");
		%>
	</head>
	<body>
	<form name=resumeForm action=/doTradeReg.do method=post target="_self">
<jsp:include page="/inc/jspTop.jsp">
			<jsp:param name="menu_id" value="f0c4n2mMM080X0G85Be9" />
		</jsp:include>
										<table width=800 border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#dddddd">
											<tr>
												<td class="l_td">
													会员动作：
												</td>
												<td align="left" class="r_td">
													<div>
													<select name="para_code6" id="para_code6">
													  <%=para_code6%>
													</select>
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													会员级别：
												</td>
												<td align="left" class="r_td">
													<div>
														<select name="para_code4" id="para_code4">
															<%=cust_class%>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													奖励黄金量：
												</td>
												<td align="left" class="r_td">
													<div>
														<input type="text" id="para_code3" name="para_code3" size="5" maxlength="50" onkeyup="if(isNaN(this.value))this.value=''">
														(两)
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													开始日期：
												</td>
												<td align="left" class="r_td">
													<div>
														<input name="start_date" type="text" id="start_date" size=10 maxlength=15 value="<%=start_date%>" onfocus="setday(this);" readonly>
														(yyyy-MM-dd)
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													结束日期：
												</td>
												<td align="left" class="r_td">
													<div>
														<input name="end_date" type="text" id="end_date" size=10 maxlength=15 value="<%=end_date%>" onfocus="setday(this);" readonly>
														(yyyy-MM-dd)
													</div>
												</td>
											</tr>
											<tr>
												<td class="l_td">
													备注：
												</td>
												<td align="left" class="r_td">
													<div class="ping1">
														<input name="remark" type="text" id="remark" size=50 maxlength=100>
													</div>
												</td>
											</tr>
											<tr>
												<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;text-align:center;" align="center" colspan="2">
													<input class="tjan" name="submit" type="submit" value="" onclick="return check_Value()">
												</td>
											</tr>
											<input type="hidden" name="xtype" id="xtype" value="0">
											<input type="hidden" name="param_code" id="param_code" value="action">
											<input type="hidden" name="param_name" id="param_name" value="设置会员财富">
											<input type="hidden" name="subsys_code" id="subsys_code" value="B2B" />
											<input type="hidden" name="param_attr" id="param_attr" value="101" />
											<input type="hidden" name="para_code1" value="<%=para_code1%>">
											<input type="hidden" name="para_code5">
											<input type="hidden" name="para_code2">
											<input type="hidden" name="para_code7">
											<input type="hidden" name="para_code8">
											<input type="hidden" name="para_code9">
											<input type="hidden" name="para_code10">
											<input type="hidden" name="para_code11">
											<input type="hidden" name="para_code12">
											<input type="hidden" name="para_code13">
											<input type="hidden" name="para_code14">
											<input type="hidden" name="para_code15">
											<input type="hidden" name="para_code16">
											<input type="hidden" name="para_code17">
											<input type="hidden" name="para_code18">
											<input type="hidden" name="para_code19">
											<input type="hidden" name="para_code20">
											<input type="hidden" name="para_code21">
											<input type="hidden" name="para_code22">
											<input type="hidden" name="para_code23">
											<input type="hidden" name="para_code24">
											<input type="hidden" name="para_code25">
											<input type="hidden" name="para_code26">
											<input type="hidden" name="para_code27">
											<input type="hidden" name="para_code28">
											<input type="hidden" name="para_code29">
											<input type="hidden" name="para_code30">
											<input type="hidden" name="trade_type_code" value="1188">
										</table>

	</form>
	</body>
</html>




