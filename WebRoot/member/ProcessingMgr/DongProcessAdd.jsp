<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	String ch_id = "";

	if (request.getParameter("ch_id") != null) {
		ch_id = request.getParameter("ch_id");
	}
	String news_id = bean.GenTradeId();
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script src="/js/UrlEncode.js" language="jscript" type="text/jscript"></script>
		<script src="/js/sale.js" language="jscript" type="text/jscript"></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/Hello.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='/js/hello.js'></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type="text/javascript" src="/js/ProcessingMgr.js"></script>
		<script language="JavaScript">		
    function Check_Value(){
			if(document.getElementById('title').value==''){
				alert('请填写信息的标题！');
				return false;
			}
			
				
		   if(document.getElementById('start_date').value=='' )
			 {
				alert('开始日期不能为空!');
				return false;
			 }
			  if(document.getElementById('cust_ch_id').value=='0' )
			 {
				alert('所属栏目不能为空!');
				return false;
			 }
			 if(document.getElementById('end_date').value=='' )
			 {
				alert('结束日期不能为空');
				return false;
			 } 
				if(!checkDate(document.classForm.start_date.value,document.classForm.end_date.value)){
				   return false;
				}
			  return true;
			
		}
	</script>

	</head>
	<body>
		<%
			HttpSession logsession = request.getSession();
			String cust_id = "", user_id = "", user_name = "";
			if (logsession.getAttribute("SESSION_CUST_ID") != null) {
				cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
			}
			if (logsession.getAttribute("SESSION_USER_ID") != null) {
				user_id = logsession.getAttribute("SESSION_USER_ID").toString();
			}
			String fbtime = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());
			String start_date = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 3);
			String end_date = new SimpleDateFormat("yyyy-MM-dd").format(cal
					.getTime());
		%>
		<form name="classForm" method="post" action="/doTradeReg.do">
			<table width=100% border="0" cellspacing="1" cellpadding="1"
				align="center">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="1" cellspacing="1"
							id="bo1" align="center" bgcolor="#DEEDFD">
							<tr>
								<td>
							<tr>
								<td class="u1" width="10%">
									动态标题：
								</td>
								<td class="u2" colspan="3">
									<input name="title" id="title" type="text" size=30 maxlength=70>
								</td>
							</tr>
						</table>
						<!--01-->
						<jsp:include flush="true" page="infolistNews2.jsp">
							<jsp:param name="cont_mod" value="8" />
							<jsp:param name="ch_id" value="<%=ch_id%>" />
							<jsp:param name="repository_id" value="<%=news_id%>" />
							<jsp:param name="cust_id" value="<%=cust_id%>" />
						</jsp:include>
						<!--02-->
						<table width="100%" border="0" cellpadding="1" cellspacing="1"
							id="bo1" align="center" bgcolor="#DEEDFD">
							<tr>
								<td class="u1" width="10%">
									时间:
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<input name="publist_date" type="text" id="publist_date"
											onfocus="setday(this);" size="10" value="<%=start_date%>" />
										(四位年-两位月-两位日)
								</td>
							</tr>
							<tr>
								<td class="u1" width="10%">
									内容:
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<textarea name="content" id="content" style="display: none"></textarea>
										<iframe ID="content"
											src=/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue
											frameborder=0 scrolling=no width=680 HEIGHT=350></iframe>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<input type="hidden" id="news_id" name="news_id"
										value="<%=news_id%>">
									<input type="hidden" id="news_type" name="news_type" value="0">
									<input type="hidden" id="cust_id" name="cust_id"
										value="<%=cust_id%>">
									<input name="info_id" type="hidden" id="info_id"
										value="<%=news_id%>">
									<input name="subject_tag" type="hidden" id="subject_tag"
										value="0">
									<input type="hidden" id="publish_user_id"
										name="publish_user_id" value="<%=user_id%>">
									<input type="hidden" id="affix_number" name="affix_number"
										value="0">
									<input type="hidden" id="validity" name="validity" value="0">
									<input type="hidden" id="repository_class"
										name="repository_class" value="0">
									<input type="hidden" id="audit_user_id" name="audit_user_id"
										value="">
									<input type="hidden" id="audit_date" name="audit_date"
										value="<%=start_date%>">
									<input type="hidden" id="trade_type_code"
										name="trade_type_code" value="8184">
								</td>
							</tr>
						</table>
						<table width="100%" border=0 align="center" cellpadding=1
							cellspacing=1 bgcolor="#DEEDFD">
							<tr>
								<td height="30" colspan="4" class="u3">
									<input class="tjan" type="submit" value=""
										onClick="return Check_Value();">
									<img src="/admin/images/comeback.JPG"
										onClick="location.href='newsList.jsp?ch_id=<%=ch_id%>'"
										style="cursor: hand;" align="absmiddle">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>





