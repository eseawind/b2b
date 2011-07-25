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
<%@ page import="com.saas.biz.verifyMgr.VerifyInfo"%>
<%@ page import="com.saas.biz.commen.config"%>
<html>
	<head>
		<title>帐号绑定</title>
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
		<%
			VerifyInfo ver=new VerifyInfo();
		  String ifexsit= ver.getVerifyIdByCustId(cust_id);
		  
		  config configFile = new config();
			configFile.init();
			String examine = configFile.getString("examine");
		%>
<link rel="stylesheet" href="images/style.css" type="text/css" />
<input type="hidden" name="ifexits" id="ifexits" value="<%=ifexsit%>">
<input type="hidden" name="examines" id="examines" value="<%=examine%>">
		<script language="JavaScript" src="/js/linkAccount.js"></script>
		<script language="JavaScript">
			function confirmsub()
			{
				var vl=document.getElementById("para_code23").value;
			if(null==vl||vl==""){
			alert("请输入账号！");
			return false;
		  }
		  document.resumeForm.submit();
			}
			if(document.getElementById("ifexits").value == "" && document.getElementById("examines").value == "0") {	
				//document.getElementById("proDiv").innerHTML='<img src=/images/wait.gif border=0><font size=3>您好,企业站正在生成...</font>';
				
				var ch_id = document.getElementById("custIds").value;
				
				var data = Math.round(Math.random() * 10000);
				var myAjax = new Ajax.Updater('proDiv',
				'CreateCust.jsp?ch_id='+ch_id,{
					method : 'get',
					evalScripts : true
				});
			}
			</script>
	</head>
	<body>
		
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<%
				String menu_id="";
				if(request.getParameter("menu_id")!=null){
					menu_id = request.getParameter("menu_id");
				}
			%>
    <table width="100%" border="0" cellpadding="1" cellspacing="1" bgcolor="#ffffff">
<tr><td width="20%"></td><td bgcolor="#ffffff" width="80%" align="right"><img src="images/now1.gif" border="0" align="absbottom"/></td></tr>
                        <tr>
                        	<td class="u4" valign="top">
                        		绑定网银
                        	</td>
                        	<td>
                        		
                        	</td>
                        </tr>
				<tr><td bgcolor="#ffffff" colspan="2">
						<table width=100% border=0 cellpadding=0 cellspacing=0 align=center bgcolor="#ffffff">
							<tr>
								<td class="u1" >
									帐号名称：
								</td>
								<td class="u2">
										网银帐户
								</td>
							</tr>
							<tr>
								<td class="u1">网银帐号：
								</td>
								<td class="u2">
										<input name="para_code23" id="para_code23" value="<%=bank_id%>" type="text" size="10" maxlength="50" onkeyup="if(isNaN(value))execCommand('undo')">
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
									<input name="comit" type="button" style="cursor:hand;" class="button"  value="提 交" onclick="return confirmsub()" >
								</td>
							</tr>
						</table>
        </td></tr></table>
		</form>
	</body>
</html>





