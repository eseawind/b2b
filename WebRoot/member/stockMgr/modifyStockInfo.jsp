<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="com.saas.biz.stockorderMgr.Stockorderinfo"%>
<jsp:useBean id="classBean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String stock_id = "";
	String title = "";
	String content = "";
	String stock_addr = "",class_name="",class_id="",class_id_grp="";
	String start_date = date;
	String end_date = date;
	if (request.getParameter("stock_id") != null) {
		stock_id = request.getParameter("stock_id");
	}
	Stockorderinfo stockObj = new Stockorderinfo();
	ArrayList stockList = new ArrayList();
	if (stock_id != null && !stock_id.equals("")) {
		stockList = stockObj.genOneStockorder(stock_id);
		if (stockList != null && stockList.size() > 0) {
			HashMap map = (HashMap) stockList.get(0);
			stock_id = map.get("stock_id").toString();
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
			if (map.get("content") != null) {
				content = map.get("content").toString();
			}
			if (map.get("stock_addr") != null) {
				stock_addr = map.get("stock_addr").toString();
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
	HttpSession sesion = request.getSession();
	String user_id = (String) sesion.getAttribute("SESSION_USER_ID");
	String select = classBean.getSelectedByComm("4", "1");
%>
<html>
	<head>
		<title>采购信息修改</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='/js/hello.js'></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type='text/javascript' src='/js/stockmgr.js'></script>
		<script language="javascript" src="/js/stock_stockMgr.js"></script>
		<script language="javascript">
		
    	function Check_Value_My(){
			if(document.getElementById('title').value==''){
				alert('请填写信息的标题！');
				document.getElementById('title').focus();
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
		   document.getElementById('contents').value = document.getElementById('one').value + document.getElementById('two').value;  //+ document.getElementById('three').value;

	     return true;
		}
		function ShowColor(){
			var fcolor=showModalDialog("/admin/cms/color.htm?ok",false,"dialogWidth:106px;dialogHeight:110px;status:0;dialogTop:"+(window.event.clientY+120)+";dialogLeft:"+(window.event.clientX));
			if(fcolor!=null && fcolor!="undefined") document.newform.title_color.value = fcolor;
		}

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
	</head>
	<body onload="setOneClass()">
		<form name=form1 action=/doTradeReg.do method=post target="_self">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
				<a href="modifyIndex.jsp">管理求购信息</a>
				</td>
			</tr>
		</table>
	  <table width=100% border="0" cellspacing="0" cellpadding="0" align="center">
	  		<tr>
					<td>
						<!--
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0" onclick="javascript:secBoard(1)">
									采购信息
								</td>
								<td width="76" height="28" align="left" class=c3 id="d1" onclick="javascript:secBoard(0)">
									高级设置
								</td>
								<td>&nbsp;
									
								</td>
							</tr>
						</table>
						<!--1-->
						<jsp:include  flush="true" page="/member/custcms/infolist.jsp">
							<jsp:param name="cont_mod" value="2"/>
							<jsp:param name="ch_id" value="6871426767"/>
							<jsp:param name="news_id" value="<%=stock_id%>"/>
							<jsp:param name="class_id" value="<%=class_id%>"/>
						</jsp:include>
			
			<!--2-->
			<table width=100% border=0 cellpadding=0 cellspacing=0 align=center bgcolor="#dddddd"  id="bo1" >	
				
				<tr>
					<td class="u1">
						采购标题：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left colspan="3">
						<div >
							<input type=text name=title value=<%=title%> maxlength="100">
						</div>
				</tr>

				<tr>
					<td class="u1">
						请选择分类
					</td>
					<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;" colspan="3">
						<div >
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td style="background-color:#ffffff; color:#000000;  font-size:12px;" colspan="3">
										<input type="text" name="class_name" id="class_name" value="<%=class_name%>">
									</td>
								</tr>
								<tr>
									<td style="background-color:#ffffff; color:#000000;  font-size:12px;">
										<select name="sort1" id="sort1" size="10" style="width: 130px" onChange="setSecondClass(this.value);" onclick="setTypeName(this)">
										<%=select%>
										</select>
									</td>
									<td >
										<select name="sort2" id="srot2" size="10" style="width: 130px; display: none" onChange="setTherdClass(this.value);" onclick="setTypeName(this)">
											<option value="0">
												请选择...
											</option>
										</select>
									</td>
									<td style="background-color:#ffffff; color:#000000;  font-size:12px;">
										<select name="sort3" size="10" style="width: 130px; display: none" onclick="setTypeName(this)" onchange="cretateSelect('4',this.value)">
											<option value="0">
												请选择...
											</option>
										</select>
									</td>
									<td>
										<div id="nextElement">
											<div id="4" style="width;100px; float:left;display:inline;white-space:nowrap"></div>
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
					<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left>
						<div >
							<input name="start_date" id="start_date" type="text" size="10" value="<%=start_date%>" onfocus="setday(this);">
							(四位年-二位月-二位日)
						</div>
					</td>
					<td class="u1">
						结束日期：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left>
						<div >
							<input name="end_date" id="end_date" type="text" size="10" value="<%=end_date%>" onfocus="setday(this);">
							(四位年-二位月-二位日)
						</div>
					</td>
				</tr>
				<tr>
						<td class="u1">
						采购地点：
					</td>
					<td style="background-color:#ffffff; color:#000000;  font-size:12px; padding:3px 5px;" align=left colspan="3">
						<div >
							<input type="text" name="stock_addr" value="<%=stock_addr%>" size="30" maxlength="100">(如:中国-上海)
						</div>
					</td>
				</tr>
				
				<tr>
					<td class="u1">
						上传图片：
					</td>
					<td align=left style="background-color:#ffffff; color:#000000;  font-size:12px;" colspan="3">
						<div class="ping1">
							<iframe src="/inc/uploadImg.jsp?root_id=<%=stock_id%>" width="100%" height="180px" marginwidth="0"  frameborder=0 marginheight="0" scrolling="no"></iframe>
						</div>
					</td>
				</tr>
				
				<tr>
					<td class="u1">
						采购说明：
					</td>
					<td align="left" style="background-color:#ffffff; color:#000000;  font-size:12px;" colspan="3">
						<div >
							<textarea name="content" style=display:none>
								<%=content%>
							</textarea>
							<iframe ID=content src=/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=stock_id%> frameborder=0 scrolling=no width=685 HEIGHT=350></iframe>
						</div>
					</td>
				</tr>
				
				

				
						<input name="rsrv_str1" id="rsrv_str1" type="hidden" value="0">
						<input name="root_id" id="root_id" type="hidden" value="<%=stock_id%>">
						<input name="user_id" id="user_id" type="hidden" value="<%=user_id%>">
						<input name="stock_id" id="stock_id" type="hidden" value="<%=stock_id%>">
						<input name="trade_type_code" type="hidden" value="0343">
						<input name="class_id" id="class_id" type="hidden" value="<%=class_id%>">
						<input name="class_name_grp" id="class_name_grp" type="hidden" value="">
						<input name="class_id_grp" id="class_id_grp" type="hidden" value="<%=class_id_grp%>">
						<input name="count" id="count" type="hidden" value="sort1">
						<input name="remark" id="remark" type="hidden" value="0000">
						<input name="info_id" id="info_id" type="hidden" value="<%=stock_id%>">
				</table>
				<table width=100% border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd" >	
				<tr>
					<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:13px; padding-top:10px;padding-bottom:10px;" align="center" colspan="4">
						<input class="xgan" name=submit1 type=submit value="" onclick="return Check_Value_My()">
						&nbsp;&nbsp;&nbsp;
						<img src="/admin/images/comeback.JPG" onClick="location.href='modifyIndex.jsp'" style="cursor:hand;" align="absmiddle">
					</td>
				</tr>
			</table>
	</body>
</html>




