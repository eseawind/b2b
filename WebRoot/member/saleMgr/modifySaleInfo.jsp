<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.saleMgr.SaleInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="classBean"
	class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<html>
	<head>
		<title>B2B电子商务平台</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/Hello.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="supply.js"></script>
		<script language="JavaScript">
			
			function Check_Value_My(){
				if(document.getElementById('title').value==''){
					alert('请填写信息标题！');
				return false;
			}
			
		 	var str=content.getText();
			str=str.replace(/\s*/g,''); 
			if(str == ''  ){
				alert('请填写商品描述内容！');
				return false;
			}
			if( str.length > 4000){
				 alert( '字数应少于4000字!' );
				 return false;	
			}
			if(!checkDate(document.classForm.start_date.value,document.classForm.end_date.value)){
			   return false;
			}
			document.getElementById('contents').value = document.getElementById('one').value + document.getElementById('two').value;  //+ document.getElementById('three').value;
			 return true;
		}
		</script>
	</head>
	<body>
		<%
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String sale_id = "", price_type = "";
			String title = "";
			String content = "";
			String sale_addr = "", class_name = "";
			String start_date = date;
			String end_date = date;
			String sale_price = "";
			String commodity_price = "", class_id = "", class_id_grp = "";
			if (request.getParameter("sale_id") != null) {
				sale_id = request.getParameter("sale_id");
			}
			SaleInfo saleObj = new SaleInfo();
			ArrayList saleList = new ArrayList();
			saleList = saleObj.genOneSale(sale_id);
			if (saleList != null && saleList.size() > 0) {
				HashMap map = (HashMap) saleList.get(0);
				if (map.get("sale_id") != null) {
					sale_id = map.get("sale_id").toString();
				}
				if (map.get("title") != null) {
					title = map.get("title").toString();
				}
				if (map.get("class_name") != null) {
					class_name = map.get("class_name").toString();
				}
				if (map.get("class_id") != null) {
					class_id = map.get("class_id").toString();
				}
				if (map.get("class_id_grp") != null) {
					class_id_grp = map.get("class_id_grp").toString();
				}
				if (map.get("price_type") != null) {
					price_type = map.get("price_type").toString();
				}
				if (map.get("start_date") != null) {
					start_date = map.get("start_date").toString();
					if (start_date.length() > 10) {
						start_date = start_date.substring(0, 10);
					}
				}
				if (map.get("content") != null) {
					content = map.get("content").toString();
				}
				if (map.get("sale_addr") != null) {
					sale_addr = map.get("sale_addr").toString();
				}

				if (map.get("end_date") != null) {
					end_date = map.get("end_date").toString();
					if (end_date.length() > 10) {
						end_date = end_date.substring(0, 10);
					}
				}
				if (map.get("sale_price") != null) {
					sale_price = map.get("sale_price").toString();
				}
				if (map.get("commodity_price") != null) {
					commodity_price = map.get("commodity_price").toString();
				}
			}
			ParamethodMgr paramCom = new ParamethodMgr();
			price_type = paramCom.getItemsBySelected("3", price_type);
			String select = classBean.getSelectedByComm("5", "1");
		%>
		<form name=classForm action=/doTradeReg.do method=post target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr class="u1">
					<td colspan=3 align="left" class="head">
						<a href="modifyIndex.jsp">管理供应信息</a>
					</td>
				</tr>
			</table>
			<table width=100% border="0" cellspacing="0" cellpadding="0"
				align="center">
				<tr>
					<td>
						<!--
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0" onclick="javascript:secBoard(1)">
									供应信息
								</td>
								<td width="76" height="28" align="left" class=c3 id="d1" onclick="javascript:secBoard(0)">
									高级设置
								</td>
								<td>&nbsp;
									
								</td>
							</tr>
						</table>
						<!--1-->
						<jsp:include flush="true" page="/member/custcms/infolist.jsp">
							<jsp:param name="cont_mod" value="1" />
							<jsp:param name="news_id" value="<%=sale_id%>" />
							<jsp:param name="ch_id" value="7830633062" />
							<jsp:param name="class_id" value="<%=class_id%>" />
						</jsp:include>

						<!--2-->
						<table width=100% border="0" cellspacing="0" cellpadding="0"
							align="center" id="bo1" style="display: block">
							<tr>
								<td>
									<table width=100% border=0 cellpadding=0 cellspacing=1
										align=center bgcolor="#dddddd">
										<tr>
											<td class="u1">
												销售标题：
											</td>
											<td align=left
												style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;"
												colspan="3">
												<input type=text name="title" id="title" value="<%=title%>"
													maxlength="100">
											</td>
										</tr>
										<tr>
											<td class="u1">
												选择分类
												<span
													style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px;">：</span>
											</td>
											<td align="left"
												style="background-color: #ffffff; color: #000000; font-size: 12px;"
												colspan="3">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td
															style="background-color: #ffffff; color: #000000; font-size: 12px;">
															<input type="text" name="class_name" id="class_name"
																value="<%=class_name%>">
															<input type="hidden" name="class_id" id="class_id"
																value="<%=class_id%>">
														</td>
													</tr>
													<tr>
														<td
															style="background-color: #ffffff; color: #000000; font-size: 12px;">
															<select name="sort1" id="sort1" size="10"
																style="width: 130px"
																onChange="setSecondClass(this.value);"
																onclick="setTypeName(this)">
																<%=select%>
															</select>
														</td>
														<td
															style="background-color: #ffffff; color: #000000; font-size: 12px;">
															<select name="sort2" id="sort2" size="10"
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
															<select name="sort3" id="sort3" size="10"
																style="width: 130px; display: none"
																onclick="setTypeName(this)"
																onchange="cretateSelect('4',this.value)">
																<option value="0">
																	请选择...
																</option>
															</select>
														</td>
														<td>
															<div id="nextElement" style="display: none">
																<div id="4"
																	style="float: left; display: inline; white-space: nowrap"></div>
																<input type="hidden" name="index_s" id="index_s"
																	value="4">
															</div>
														</td>
													</tr>
												</table>

											</td>
										</tr>

										<tr>
											<td class="u1">
												缩略图：
											</td>
											<td class="u2" colspan="3">
												<input name="mini_img" id="mini_img" type="hidden">
												<div
													style="padding-left: 0px; padding-bottom: 0px; padding-right: 0px; padding-top: 0px;">
													<iframe src="/inc/uploadImg.jsp?root_id=<%=sale_id%>"
														width="100%" height="180px" frameborder="0"
														marginwidth="0" marginheight="0" scrolling="no"></iframe>
												</div>
											</td>

										</tr>

										<tr>
											<td class="u1">
												开始日期：
											</td>
											<td
												style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;"
												align=left>
												<input name="start_date" id="start_date" type="text"
													value="<%=start_date%>" onfocus="setday(this);">
												(四位年-二位月-二位日)
											</td>
											<td class="u1">
												结束日期：
											</td>
											<td
												style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;"
												align=left>
												<input name="end_date" id="end_date" type="text"
													value="<%=end_date%>" onfocus="setday(this);">
												(四位年-二位月-二位日)
											</td>
										</tr>

										<tr>
											<td class="u1">
												单格：
											</td>
											<td
												style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;"
												align="left">
												<input name="sale_price" type="text" value="<%=sale_price%>"
													onkeyup="if(isNaN(value))execCommand('undo')">
												(只能输入数字)
											</td>
											<td class="u1">
												批发价：
											</td>
											<td
												style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;"
												align="left">
												<input name="commodity_price" type="text"
													value="<%=commodity_price%>"
													onkeyup="if(isNaN(value))execCommand('undo')">
												(只能输入数字)
											</td>
										</tr>

										<tr>
											<input type="hidden" value="1" name="price_type">
											<td class="u1">
												销售地点：
											</td>
											<td
												style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;"
												align=left colspan="5">
												<input type=text name=sale_addr value="<%=sale_addr%>"
													maxlength="100">
												(如：山东-东营)
											</td>
										</tr>

										<tr>
											<td class="u1">
												销售内容：
											</td>
											<td
												style="background-color: #ffffff; color: #000000; font-size: 12px; padding: 3px 5px;"
												align=left colspan="3">
												<textarea name=content style="display: none">
										<%=content%>
									</textarea>
												<iframe id="content"
													src="/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=sale_id%>"
													frameborder="0" scrolling="no" width="700" height="350"></iframe>
											</td>
										</tr>
									</table>
						</table>
						<script language=javascript>
						function secBoard(n)
						{
							for(i=0;i<2;i++) {
								if (i==n) {
									document.all('d' + n).className="c3";
								} else {
								document.all('d' + i).className="c4";}
							}
							
							for(i=0;i<2;i++) {
								if (i==n) {
									document.all('bo' + n).style.display="";
								} else {
								document.all('bo' + i).style.display="none";}
							}
		
					}
				</script>
						<table width=100% border="0" cellspacing="0" cellpadding="0"
							align="center">

							<input name="rsrv_str1" id="rsrv_str1" type="hidden" value="0">
							<input name="sale_num" type="hidden" value="">
							<input name="carriage_pay" type="hidden" value="">

							<input name="sale_id" type="hidden" value="<%=sale_id%>">
							<input name="root_id" type="hidden" value="<%=sale_id%>">
							<input type=hidden name=trade_type_code value="0347">
							<input type="hidden" name="info_id" id="info_id"
								value=<%=sale_id%>>
							<input type="hidden" name="remark" id="remark" value="">
							<input name="class_id_grp" id="class_id_grp" type="hidden"
								value="<%=class_id_grp%>">


							<tr>
								<td align="center"
									style="background-color: #f6f6f6; color: #000000; font-weight: bold; font-size: 12px; padding-top: 10px; padding-bottom: 10px;"
									colspan="4">
									<input class="tjan" name=submit type=submit value=""
										onclick="return Check_Value_My()">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img src="/admin/images/comeback.JPG"
										onClick="location.href='modifyIndex.jsp'"
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




