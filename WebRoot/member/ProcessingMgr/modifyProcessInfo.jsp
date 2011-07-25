<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="com.saas.biz.ProcessMgr.ProcessInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>

<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
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
		   		
		  		function ShowColor(){
					var fcolor=showModalDialog("color.htm?ok",false,"dialogWidth:106px;dialogHeight:110px;status:0;dialogTop:"+(window.event.clientY+120)+";dialogLeft:"+(window.event.clientX));
					if(fcolor!=null && fcolor!="undefined") document.newform.title_color.value = fcolor;
				}
		</script>
		<script language="JavaScript">
		function clickSel(val,valId){
			var tt = document.getElementById("contents").value;
			if(document.getElementById('one').checked ==true && document.getElementById('two').checked==false){
					tt='10'
				}
			if(document.getElementById('one').checked ==false && document.getElementById('two').checked==true){
					tt='01'
				}
			if(document.getElementById('one').checked ==false && document.getElementById('two').checked==false){
					tt='00'
				}
			if(document.getElementById('one').checked ==true && document.getElementById('two').checked==true){
					tt='11'
				}
			document.getElementById("contents").value = tt;
		}
		</script>
	</head>
	<body>
		<%
			String class_id = "5260677638"; //代理信息
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String cust_id = "";
			String category_id = "";
			String category_title = "";
			String category_abstract = "";
			String category_desc = "";
			String category_addr = "";
			String category_unit = "";
			String category_type = "";
			String start_date = date;
			String end_date = date;
			String user_id = "", remark = "", class_name = "";
			commMethodMgr commen = new commMethodMgr();
			String idx = commen.GenTradeId();

			if (request.getParameter("category_id") != null) {
				category_id = request.getParameter("category_id");
			}
			if (request.getParameter("cust_id") != null) {
				cust_id = request.getParameter("cust_id");
			}
			ProcessInfo processObj = new ProcessInfo();
			ArrayList processList = new ArrayList();
			if (category_id != null && !category_id.equals("")) {
				processList = processObj.genOneProcess(category_id);
				if (processList != null && processList.size() > 0) {
					HashMap map = (HashMap) processList.get(0);
					category_id = map.get("category_id").toString();
					if (map.get("category_title") != null) {
						category_title = map.get("category_title").toString();
					}
					if (map.get("class_name") != null) {
						class_name = map.get("class_name").toString();
					}
					if (map.get("category_abstract") != null) {
						category_abstract = map.get("category_abstract")
								.toString();
					}
					if (map.get("category_desc") != null) {
						category_desc = map.get("category_desc").toString();
					}
					if (map.get("category_unit") != null) {
						category_unit = map.get("category_unit").toString();
					}
					if (map.get("category_addr") != null) {
						category_addr = map.get("category_addr").toString();
					}
					if (map.get("category_type") != null) {
						category_type = map.get("category_type").toString();
					}
					if (map.get("remark") != null) {
						remark = map.get("remark").toString();
					}
					if (map.get("start_date") != null) {
						start_date = map.get("start_date").toString();
						if (start_date.length() > 10) {
							start_date = start_date.substring(0, 10);
						}
					}
					if (map.get("end_date") != null) {
						end_date = map.get("end_date").toString();
						if (end_date.length() > 10) {
							end_date = end_date.substring(0, 10);
						}
					}

				}
			}
			ParamethodMgr paramCom = new ParamethodMgr();
			category_type = paramCom.getItemsBySelected("105", category_type);
		%>
		<form name="classForm" method="post" action="/doTradeReg.do"
			target="_self">
			<table width=100% border="0" cellspacing="1" cellpadding="1"
				align="center">
				<tr>
					<td>
						<table width="100%" border="0" align="center" cellpadding="0"
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
						<!--1-->
						<jsp:include flush="true" page="infolistNews.jsp">
							<jsp:param name="news_id" value="<%=category_id%>" />
							<jsp:param name="class_id" value="<%=class_id%>" />
						</jsp:include>

						<!--2-->
						<table width="100%" border="0" cellpadding="1" cellspacing="1"
							align="center" bgcolor="#dddddd" style="margin-top: 1px;"
							id="bo1" style="display: none">
							<tr>
								<td class="u1">
									分类信息类型:
								</td>
								<td align="left"
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									colspan="3">
									<div class="ping1">
										<select name="category_type" maxlength="25">
											<%=category_type%>
										</select>
									</div>
								</td>
								<td class="u1" style="display: none">
									标题:
								</td>
								<td align="left"
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									style="display:none">
									<div>
										<input name="category_title" type="text" maxlength="100"
											value="<%=category_title%>">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									请选择分类
								</td>
								<td align="left"
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									colspan="3">
									<div>
										<table border="0" cellpadding="0" cellspacing="0"
											style="margin-left: 0px">
											<tr>
												<td
													style="background-color: #ffffff; color: #000000; font-size: 12px;">
													<select name="sort1" size="10" style="width: 130px"
														onChange="setSecondClass(this.value);"
														onclick="setTypeName(this)">
														<option selected value="0">
															请选择...
														</option>
													</select>
												</td>
												<td
													style="background-color: #ffffff; color: #000000; font-size: 12px;">
													<select name="sort2" size="10"
														style="width: 130px; display: none"
														onChange="setTherdClass(this.value);"
														onclick="setTypeName(this)">
														<option value="0">
															请选择...
														</option>
													</select>
												</td>
												<td
													style="background-color: #ffffff; color: #000000; font-size: 12px;">
													<select name="sort3" size="10"
														style="width: 130px; display: none"
														onclick="setTypeName(this)"
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
								<td align="left"
									style="background-color: #ffffff; color: #000000; font-size: 12px;">
									<div>
										<input name="start_date" type="text" id="start_date"
											value="<%=start_date%>" onfocus="setday(this);" size="10" />
										(yyyy-mm-dd)
									</div>
								</td>
								<td class="u1">
									结束日期：
								</td>
								<td align="left"
									style="background-color: #ffffff; color: #000000; font-size: 12px;">
									<div>
										<input name="end_date" type="text" id="end_date"
											value="<%=end_date%>" onfocus="setday(this);" size="10" />
										(yyyy-mm-dd)
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									分类产品信息的地址:
								</td>
								<td align="left"
									style="background-color: #ffffff; color: #000000; font-size: 12px;">
									<div class="ping1">
										<input name="category_addr" type="text"
											value=<%=category_addr%> size="50">
									</div>
								</td>
								<td class="u1">
									计量单位:
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;">
									<div class="ping1">
										<input name="category_unit" type="text" size="10"
											value="<%=category_unit%>">
										(如平方米、只、件、台等 )
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									备注:
								</td>
								<td align="left"
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									colspan="3">
									<div class="ping1">
										<input name="remark" type="text" value="<%=remark%>" size="50">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									分类产品信息介绍:
								</td>

								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									colspan="3">
									<div>
										<textarea name="category_abstract" style="display: none"><%=category_abstract%></textarea>
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
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									colspan="3">
									<div>
										<textarea name="category_desc" style="display: none"><%=category_desc%></textarea>
										<iframe ID=category_desc
											src=/www/ewebeditor/ewebeditor.htm?id=category_desc&style=coolblue
											frameborder=0 scrolling=no width=680 HEIGHT=350></iframe>
									</div>
								</td>
							</tr>
						</table>
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
						<table width="100%" border="0" cellpadding="1" cellspacing="1"
							align="center" bgcolor="#dddddd" style="margin-top: 1px;">

							<input name="category_id" type="hidden" value="<%=category_id%>">
							<input name="cust_id" type="hidden" value="<%=cust_id%>">
							<input name="user_id" type="hidden" value="<%=user_id%>">
							<input name="trade_type_code" type="hidden" value="0887">
							<input name="rsrv_str1" id="rsrv_str1" type="hidden" value="0">
							<input name="info_id" type="hidden" id="info_id"
								value="<%=category_id%>">
							<input name="remark" type="hidden" value="">
							<tr>
								<td height="30" colspan="4" align="center"
									style="background-color: #f6f6f6; color: #000000; font-size: 12px;">
									<input class="tjan" type="submit" value=""
										onClick=" return modifyProcessInfocheckInfo()">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>





