<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.userMgr.UserInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<html>
	<head>
		<title>电子商务平台</title>
<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css" media="screen">
.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
</style>
		
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script src="/js/UrlEncode.js" language="jscript" type="text/jscript"></script>
		<script src="/js/product.js" language="jscript" type="text/jscript"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script language="javascript">
function checkInfo(){

	if(document.classForm.password.value.replace(/\s*/g,"") =="" || document.classForm.password==null){
		alert("新密码不能为空！");
		return false;
		document.classForm.class_name.focus();
	}
	
	
}
</script>
	</head>
	<body>
		<%
		  request.setCharacterEncoding("gbk");
			String fbtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String class_id = bean.GenTradeId();
			String user_name = "",  passwd = "",user_id = "",cust_id="";	
			if(request.getParameter("user_id")!=null)
	    {
	     user_id = request.getParameter("user_id");
	    }
	    if(request.getParameter("cust_id")!=null){
	    	cust_id = request.getParameter("cust_id");
	    }
			UserInfo userObj=new UserInfo();
			ArrayList onelist = userObj.genOneUserInfo(user_id);
			if(onelist!=null && onelist.size()>0){
			 	HashMap map = (HashMap) onelist.get(0);
		        if(map.get("user_name") != null)
		        {
		           user_name=map.get("user_name").toString();
		        }
			 }
			
		%>
		<form name="classForm" method="post" action="/doTradeReg.do" target="_self">
			<table width="100%" border="0" cellpadding="1" cellspacing="1" align="center" bgcolor="#DEEDFD">
				
				<center>
				<tr>
					<td class="u1">
						 账号:
					</td>
					<td class="u2">
						<%=user_name%>
					</td>
				</tr>
				
					<td class="u1">新密码:
					</td>
					<td class="u2">
					<div class="ping1"><input name="password" type="password" maxlength="100"></div>
					</td>
			 
				<center>
						<input name="user_id" type="hidden" value="<%=user_id%>">					
						<input name="trade_type_code" type="hidden" value="6011">
					
				<tr>
					<td height="30" colspan="2" class="u3">
						<input class="tjan" type="submit" value="" onClick=" return checkInfo()">
						&nbsp;&nbsp;&nbsp;
						<img src="/admin/images/comeback.JPG" onClick="location.href='resetUserPsw.jsp?cust_id=<%=cust_id%>'" style="cursor:hand;" align="absmiddle">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




