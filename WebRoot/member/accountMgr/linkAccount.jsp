<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.acctMgr.CustAccount"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="tools.util.DateUtils"%>
<html>
	<head>
		<title>’ ∫≈∞Û∂®</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/js/linkAccount.js"></script>
	</head>
	<body>
		<%
		   Date date1=new Date();
		   String today=DateUtils.formatDateToString(date1);
			ParamethodMgr acct = new ParamethodMgr();
			String cust_id="";
			if(session.getAttribute("SESSION_CUST_ID")!=null){
				cust_id = session.getAttribute("SESSION_CUST_ID").toString();
			}
			String bank_id = acct.getBankAccouId(cust_id);
			String flag="";
			if(bank_id.equals(""))
			flag="newone";
		  else
			flag="oldone";
		%>
		<center>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<%
				String menu_id="";
				if(request.getParameter("menu_id")!=null){
					menu_id = request.getParameter("menu_id");
				}
			%>
			
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td valign="top">
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2">
							<tr>
								<td class="u1" width="25%">
									’ ∫≈√˚≥∆£∫
								</td>
								<td class="u2">
									<div class="ping1">
										Õ¯“¯’ ªß
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">Õ¯“¯’ ∫≈£∫
								</td>
								<td class="u2"><div>
										<input name="para_code23" id="para_code23" value="<%=bank_id%>" type="text" size="10" maxlength="50" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
							</tr>
							<input name="trade_type_code" type="hidden" value="0097">
							<input name="para_code24" type="hidden" value="<%=cust_id%>">
							<input name="xtype" type="hidden" value="0">
							<input name="subsys_code" type="hidden" value="CRM">
							<input name="param_attr" type="hidden" value="0">
							<input name="param_code" type="hidden" value="000">
							<input name="param_name" type="hidden" value="">
							<input name="para_code1" type="hidden" value="000">
							<input name="para_code2" type="hidden" value="">
							<input name="para_code3" type="hidden" value="">
							<input name="para_code4" type="hidden" value="">
							<input name="para_code5" type="hidden" value="">
							<input name="para_code6" type="hidden" value="">
							<input name="para_code7" type="hidden" value="">
							<input name="para_code8" type="hidden" value="">
							<input name="para_code9" type="hidden" value="">
							<input name="para_code10" type="hidden" value="<%=flag%>">
							<input name="para_code11" type="hidden" value="">
							<input name="para_code12" type="hidden" value="">
							<input name="para_code13" type="hidden" value="">
							<input name="para_code14" type="hidden" value="">
							<input name="para_code15" type="hidden" value="">
							<input name="para_code16" type="hidden" value="">
							<input name="para_code17" type="hidden" value="">
							<input name="para_code18" type="hidden" value="">
							<input name="para_code19" type="hidden" value="">
							<input name="para_code20" type="hidden" value="">
							<input name="para_code21" type="hidden" value="">
							<input name="para_code22" type="hidden" value="">
							<input name="para_code25" type="hidden" value="">
							<input name="para_code26" type="hidden" value="">
							<input name="para_code27" type="hidden" value="">
							<input name="para_code28" type="hidden" value="">
							<input name="para_code29" type="hidden" value="">
							<input name="para_code30" type="hidden" value="">
							<input name="start_date" type="hidden" value="<%=today%>">
							<input name="end_date" type="hidden" value="<%=today%>">
							<input name="remark" type="hidden" value="">									
							<tr>
								<td class="u3"" colspan=2>
									<input name="comit" type="submit" value="" onclick="return confirmsub()" style="background-image: url('/admin/images/tj.gif');width:78px;height: 32px;border:0;cursor:hand">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
		</center>
	</body>
</html>




