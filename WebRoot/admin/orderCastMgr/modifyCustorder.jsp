<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.ordercastMgr.OrderCast"%>
<%
	HttpSession  logsession = request.getSession(); 
	String cust_id = "",session_cust_id="";
    if (logsession.getAttribute("SESSION_CUST_ID") != null){
        session_cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    if (request.getParameter("cust_id") != null){
        cust_id = request.getParameter("cust_id");
    }
    
    Calendar cal = Calendar.getInstance();
	String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String end_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    
    Custinfo info = new Custinfo();
    String cust_name = info.getCustName(cust_id);
    
    OrderCast cast = new OrderCast();
    HashMap map = cast.getCastById(cust_id);
    String info_no = "",remark="";
    if (map.get("info_no")!=null)
    	info_no = map.get("info_no").toString() ;
    if (map.get("remark")!=null)
    	remark  =  map.get("remark").toString();
%>
<html>
	<head>
		<title>中国石油信息网</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style type="text/css" media="screen">
		form {padding:0px; margin:0px;}
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
		</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript">
		 function confirmsub(){
		     if( document.getElementById("info_no").value=="" || document.getElementById("info_no").value==null){
		       alert("请填写排名！");
		       document.getElementById("info_no").focus();
		       return false;
		     }
		     if( document.getElementById("start_date").value=="" || document.getElementById("start_date").value==null){
		       alert("请选择开始时间！");
		       document.getElementById("start_date").focus();
		       return false;
		     }
		     if( document.getElementById("info_no").value=="" || document.getElementById("info_no").value==null){
		       alert("请选择结束时间！");
		       document.getElementById("info_no").focus();
		       return false;
		     }
		     document.resumeForm.submit();
		 }
		</script>
	</head>
	<body>
	
		<center>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
					<td height="30"> 
					</td>
			</tr>
		  <tr>
				<td background="/admin/images/content_03.gif" height="43" width="156" align="center"><font size="2"><b>企业会员排名</b></font></td>
				<td background="/admin/images/content_04.gif" align="right">&nbsp;
				</td>
				<td width="8"><img src="/admin/images/content_06.gif"></td>
		  </tr>
	  </table>
						<table width=800 border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
							<tr>
								<td class="u1">
									会员名称：
								</td>
								<td class="u2">
									<div class="ping1">
										<%=cust_name%>
										<input type="hidden" id="info_title" name="info_title" value="<%=cust_name%>">
									</div>
								</td>
								<td class="u1">
									排名：
								</td>
								<td class="u2">
									<div class="ping1">
										<input name="info_no" id="info_no" type="text" size="25" maxlength="25" value="<%=info_no%>">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									开始时间：
								</td>
								<td class="u2">
									<div class="ping1">
										<input name="start_date" type="text" id="start_date" size=10 maxlength=15 value="<%=start_Date%>" onfocus="setday(this);">
									</div>
								</td>
								<td class="u1">
									结束时间：
								</td>
								<td class="u2">
									<div class="ping1">
										<input name="end_date" type="text" id="end_date" size=10 maxlength=15 value="<%=end_Date%>" onfocus="setday(this);">
									</div>
								</td>
							</tr>							
							<tr>
								<td class="u1">
									备注：
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<input name="remark" id="remark" size="52" maxlength="50" value="<%=remark%>">
										<input name="trade_type_code" type="hidden" value="1206">
										<input name="info_id" type="hidden" id="info_id" value="<%=cust_id%>">
										<input name="publish_user_id" type="hidden" id="publish_user_id" value="">
										<input name="publish_date" type="hidden" id="publish_date" value="">
										<input name="info_type" type="hidden" id="info_type" value="9">
										<input name="cust_class" type="hidden" id="cust_class" value="">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u3" colspan=4>
									<img src="/admin/images/tj.gif" onclick="return confirmsub()" style="width:78px;height: 32px;border:0;cursor:hand">
								</td>
							</tr>
						</table>
					
		</form>
		</center>
	</body>
</html>



