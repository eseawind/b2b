<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<%
	String job_id = bean.GenShortTradeId();
	ParamethodMgr paramCom = new ParamethodMgr();
	ArrayList jobTypeList = paramCom.getCompareInfo("CRM", "job_type");
	String chanal_id = "0341146200";
%>

<html>
	<head>
		<title>BtoB Platform 1.0</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<script src="/www/fuction/calendar.js" type="text/javascript"></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="supply.js"></script>
		<script language="JavaScript" src="www/fuction/public.js"></script>
		<script language="JavaScript" src="/js/hrJobMgr.js"></script>
		
		<script>
			function secBoard(n)
			{
				for(i=0;i<2;i++) {
					if (i==n) {
						document.all('d' + n).className="c4";
					} else {
					document.all('d' + i).className="c3";}
				}				
				for(i=0;i<2;i++) {
					if (i==n) {
						document.all('bo' + n).style.display="";
					} else {
					document.all('bo' + i).style.display="none";}
				}	
		  }
		   
		   function Check_Value_My() {		  
				if(document.getElementById("title").value == "" || document.getElementById("title").value == null)
				{                                                                                         
					alert("标题不可以为空！");                                                             
					document.resumeForm.title.focus();                                                    
					return false;                                                                            
				}  
				if(document.getElementById("job_type").value == "" || document.getElementById("job_type").value == null)
				{                                                                                         
					alert("职位类型不可以为空！");                                                             
					document.resumeForm.job_type.focus();                                                    
					return false;                                                                            
				}				
				return true;
			}
		   
		   function formSub(){
				if(Check_Value_My()){
					alert('提交后等待运营商重新生成页面！');
					return true;
				}else{
					return false;
				}
			}
			</script>
	</head>
	<body>		
		
			<form name=resumeForm action="/doTradeReg.do" method="post"	target="_self">
			<table width=100% border="0" cellspacing="1" cellpadding="1"
				align="center">
				<tr>
					<td>
						
						<!--01-->
						
						<jsp:include  flush="true" page="/member/custcms/infolist.jsp">
							<jsp:param name="cont_mod" value="5"/>
							<jsp:param name="news_id" value="<%=job_id%>"/>
							<jsp:param name="ch_id" value="<%=chanal_id%>"/>
							<jsp:param name="class_id" value=""/>
						</jsp:include>
						
						<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#98D9A2" id="bo1">
							<tr>
								<td colspan="5" class="head">
									<a href="/member/hrJobMgr/updatejobindex.jsp">管理招聘信息</a>
								</td>	
							</tr>
							<tr>
								<td class="u1">
									招聘职位：
								</td>
								<td class="u2">
									<input name="title" id="title" type="text" size=30 maxlength=70>
								</td>
							</tr>
							<tr>
								<td class="u1">
									职位类型：
									<input name="job_id" type="hidden" value="<%=job_id%>">
								</td>
								<td class="u2">
									<select name=job_type>
										<%
												if (jobTypeList != null && jobTypeList.size() > 0) {
												for (int i = 0; i < jobTypeList.size(); i++) {
													HashMap map = (HashMap) jobTypeList.get(i);
													String value = map.get("para_code1").toString();
													String name = map.get("para_code2").toString();
										%>
										<option value="<%=value%>">
											<%=name%>
										</option>
										<%
											}
											}
										%>
									</select>
								</td>
							</tr>
							<tr>
								<td class="u1">
									工作地址：
								</td>
								<td class="u2">
									<div>
										<input name="job_addr" id="job_addr" type="text" size=50
											maxlength=50>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" valign=top>
									招聘要求：
								</td>
								<td class="u2">
									<div>
										<textarea name="request" id="request" style=display:none></textarea>
										<iframe ID=request src=/www/ewebeditor/ewebeditor.htm?id=request&style=coolblue&root_id=<%=job_id%> frameborder=0 scrolling=no width=720 HEIGHT=350></iframe>
									</div>
								</td>
							</tr>

							<tr>
								<td class="u3" colspan=2>
									<input type="hidden" name="info_id" id="info_id" value=<%=job_id%>>
									<input name="trade_type_code" type="hidden" value="1600">
									<input name="info_type" id="info_type" type="hidden" value="6">
									<input name="remark" id="remark" type="hidden" value="">
								</td>
							</tr>
						</table>
						<table width="100%" border=0 align="center" cellpadding=1
							cellspacing=1 bgcolor="#98D9A2">
							<tr>
								<td colspan=4 class="u3">
									<input class="tjan" name="submit1" type="submit" value=""	onclick="return formSub()">
								</td>
							</tr>
					  </table>
					</td>
				</tr>
			</table>
			</form>
	</body>
</html>





