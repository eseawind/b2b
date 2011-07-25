<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%
	String news_id = bean.GenTradeId();
	String trade_id = bean.GenTradeId();
	String class_id = "5260677638"; //代理信息
	if (request.getParameter("class_id") != null) {
		class_id = request.getParameter("class_id").toString();
	}
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
		<script language="javascript">
				window.onload=setOneClass;
		</script>
		<script language="JavaScript">
		function clickSel(val,valId){
			if(val=='0'){
				document.getElementById(valId).value = '1';
			}else{
				document.getElementById(valId).value = '0';
			}
		}
		
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
				document.getElementById("category_title").value=document.getElementById('title').value;
				document.getElementById('contents').value = document.getElementById('one').value + document.getElementById('two').value;  //+ document.getElementById('three').value;
			  return true;
			
		}
		function ShowColor(){
			var fcolor=showModalDialog("/admin/cms/color.htm?ok",false,"dialogWidth:106px;dialogHeight:110px;status:0;dialogTop:"+(window.event.clientY+120)+";dialogLeft:"+(window.event.clientX));
			if(fcolor!=null && fcolor!="undefined") document.classForm.title_color.value = fcolor;
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
			String sale_id = bean.GenTradeId();
			ParamethodMgr paramCom = new ParamethodMgr();
			ArrayList webList = paramCom.getCompareInfo("CRM", "web_id");
			commMethodMgr commen = new commMethodMgr();
			String idx = commen.GenTradeId();
			String category_id = commen.GenTradeId();
			String category_type = paramCom.getSelectItems("105");

			String start_date = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 3);
			String end_date = new SimpleDateFormat("yyyy-MM-dd").format(cal
					.getTime());
		%>
		<form name="classForm" method="post" action="/doTradeReg.do"
			target="_self">
			<jsp:include page="/inc/jspTop.jsp">
				<jsp:param name="menu_id" value="n34cdy430G85Be2" />
			</jsp:include>
			<table width=800 border="0" cellspacing="1" cellpadding="1"
				align="center">
				<tr>
					<td>
						<table width="796" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0"
									onclick="javascript:secBoard(0)">
									常规参数
								</td>
								<td width="76" height="28" align="left" class=c3 id="d1"
									onclick="javascript:secBoard(1)">
									文章内容
								</td>
								<td>
									&nbsp;

								</td>
							</tr>
						</table>
						<!--01-->
						<jsp:include flush="true" page="/admin/cms/infolistNews.jsp">
							<jsp:param name="news_id" value="<%=category_id%>" />
							<jsp:param name="class_id" value="<%=class_id%>" />
							<jsp:param name="ch_id" value="<%=class_id%>" />
						</jsp:include>
						<!--02-->
						<table width="100%" border="0" cellpadding="1" cellspacing="1"
							id="bo1" align="center" bgcolor="#DEEDFD" style="display: none">
							<tr>
								<td class="u1">
									分类信息类型:
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<select name="category_type" maxlength="25">
											<%=category_type%>
										</select>
									</div>
								</td>
							</tr>

							<tr style="display: none">
								<td height="30" class="u1">
									分类信息类型:
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<select name="web_id" maxlength="25">
											<%
												if (webList != null && webList.size() > 0) {
													for (int i = 0; i < webList.size(); i++) {
														HashMap map = (HashMap) webList.get(i);
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
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" class="u1" valign="top">
									请选择分类
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<table border="0" cellpadding="0" cellspacing="0"
											style="margin-left: 15px">
											<tr>
												<td>
													<select name="sort1" size="10" style="width: 130px"
														onChange="setSecondClass(this.value);">
														<option selected value="0">
															请选择...
														</option>
													</select>
												</td>
												<td>
													<select name="sort2" size="10"
														style="width: 130px; display: none"
														onChange="setTherdClass(this.value);"">
														<option value="0">
															请选择...
														</option>
													</select>
												</td>
												<td>
													<select name="sort3" size="10"
														style="width: 130px; display: none"
														onchange="cretateSelect('4',this.value)">
														<option value="0">
															请选择...
														</option>
													</select>
												</td>
												<td>
													<div id="nextElement">
														<div id="4"
															style="float: left; display: inline; white-space: nowrap"></div>
														<input type="hidden" name="index_s" id="index_s" value="4">
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									开始日期：
								</td>
								<td class="u2">
									<div class="ping1">
										<input name="start_date" type="text" id="start_date"
											onfocus="setday(this);" size="10" value="<%=start_date%>" />
										(yyyy-mm-dd)
									</div>
								</td>
								<td class="u1">
									结束日期：
								</td>
								<td class="u2">
									<div class="ping1">
										<input name="end_date" type="text" id="end_date"
											onfocus="setday(this);" size="10" value="<%=end_date%>" />
										(yyyy-mm-dd)
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									分类产品信息的地址:
								</td>
								<td class="u2">
									<div class="ping1">
										<input name="category_addr" id="category_addr" type="text"
											size="50">
									</div>
								</td>
								<td class="u1">
									计量单位:
								</td>
								<td class="u2">
									<div class="ping1">
										<!--<input name="category_unit" type="text" size="10" onkeyup="if(isNaN(value))execCommand('undo')">-->
										<input name="category_unit" type="text" size="10"
											maxlenth="10">
										(如平方米、只、件、台等 )
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									分类产品信息介绍:
								</td>

								<td class="u2" colspan="3">
									<div class="ping1">
										<textarea name="category_abstract" id="category_abstract"
											style="display: none"></textarea>
										<iframe ID=category_abstract
											src=/www/ewebeditor/ewebeditor.htm?id=category_abstract&style=coolblue
											frameborder=0 scrolling=no width=680 HEIGHT=350></iframe>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									分类产品信息描述:
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<textarea name="category_desc" style="display: none"></textarea>
										<iframe ID=category_desc
											src=/www/ewebeditor/ewebeditor.htm?id=category_desc&style=coolblue
											frameborder=0 scrolling=no width=680 HEIGHT=350></iframe>
									</div>
								</td>
							</tr>
							<script language=javascript>
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
					</script>
							<table width="796" border=0 align="center" cellpadding=1
								cellspacing=1 bgcolor="#DEEDFD">
								<tr>
									<td height="30" colspan="4" class="u3">
										<input class="tjan" type="submit" value=""
											onClick="return Check_Value();">
									</td>
								</tr>
							</table>
							<input name="category_id" type="hidden" value="<%=category_id%>">
							<input name="cust_id" type="hidden" value="<%=cust_id%>">
							<input name="user_id" type="hidden" value="<%=user_id%>">
							<input name="info_id" type="hidden" id="info_id"
								value="<%=category_id%>">
							<input name="news_id" type="hidden" id="news_id"
								value="<%=news_id%>">
							<!--input name="publish_date" type="hidden" value=""-->
							<input name="category_title" id="category_title" type="hidden"
								value="">
							<input name="user_temp" type="hidden" value="">
							<input name="remark" type="hidden" value="">
							<input name="trade_type_code" type="hidden" value="2103">
							<input name="rsrv_str1" id="rsrv_str1" type="hidden" value="0">

						</table>
					</td>
				</tr>
			</table>
		</form>
		<script language="jscript" type="text/jscript">
	getSubitems(document.classForm.bigsort, "", "请选择...", "");
	getSubitems(document.classForm.sort1, "");
</script>
	</body>
</html>





