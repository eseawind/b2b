<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<jsp:useBean id="classBean"
	class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout1.css" rel="stylesheet" type="text/css">
		<style type="text/css" media="screen">
.line6 {
	width: 72spx;
	width: 70spx !important;
	border: #ffcb99 1px solid;
	background-color: #fff8ee;
	text-align: left;
	padding-left: 20px;
	padding-top: 10px;
	padding-bottom: 10px;
	color: #000000;
	margin-top: 13px;
	margin-bottom: 13px;
}  /*横栏样式6---- 头部提醒1*/
.line6 .img {
	width: 53px;
	height: 53px;
	float: left;
	margin-right: 20px;
}

.line6 .title {
	font-size: 14px;
	font-weight: bold;
	color: #ff5400;
}

.line1 {
	border-left: #ff7300 3px solid;
	background-color: #e2e2e2;
	color: #333333;
	text-align: left;
	font-size: 12px;
} /*横栏样式1*/
</style>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript'
			src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script language="javascript" src="/js/stock_stockMgr.js"></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script language="javascript">
		function clickSel(val,valId){
			if(val=='0'){
				document.getElementById(valId).value = '1';
			}else{
				document.getElementById(valId).value = '0';
			}
		}
		
    	function Check_Value_My(){
			if(document.getElementById('title').value==''){
				alert('请填写求购标题！');
				document.getElementById('title').focus();
				return false;
			}
			if(document.getElementById('class_id').value==''){
				alert('请选择求购分类！');
				return false;
			}
			if(document.getElementById('cust_ch_id').value=='0' ){
				alert('请选择高级设置--所属栏目--公司求购！');
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
			var fcolor=showModalDialog("/member/custcms/color.htm?ok",false,"dialogWidth:106px;dialogHeight:110px;status:0;dialogTop:"+(window.event.clientY+120)+";dialogLeft:"+(window.event.clientX));
			if(fcolor!=null && fcolor!="undefined") document.newform.title_color.value = fcolor;
		}

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
	function on(){
		if(Check_Value_My()){
				alert('提交后等待运营商重新生成页面！');
				return true;
			}
		else
			return false;
	}
</script>
	</head>
	<body>
		<%
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			String start_date = formate.format(new Date());
			Calendar cal = Calendar.getInstance();
			String news_id = bean.GenTradeId();
			String class_id = "";
			cal.add(Calendar.MONTH, 3);
			String end_date = formate.format(cal.getTime());
			String stock_id = bean.GenTradeId();
			HttpSession sesion = request.getSession();
			String user_id = (String) sesion.getAttribute("SESSION_USER_ID");
			String select = classBean.getSelectedByComm("4", "1");
			ChannelInfo channel = new ChannelInfo();
			String channel_id = channel.getChIdByContMod("2");

			String cust_id = "", cust_type = "";
			if (session.getAttribute("SESSION_CUST_ID") != null) {
				cust_id = session.getAttribute("SESSION_CUST_ID").toString();
			}
			Custinfo custInfo = new Custinfo();
			ArrayList listc = new ArrayList();
			listc = custInfo.getCustomerByCustId(cust_id);
			if (null != listc && listc.size() > 0) {
				HashMap map = (HashMap) listc.get(0);
				if (null != map.get("cust_type"))
					cust_type = map.get("cust_type").toString();
			}
		%>
		<form name="classForm" method="post" action="/doTradeReg.do"
			target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr class="u1">
					<td colspan=3 align="left" class="head">
						<a href="modifyIndex.jsp">管理求购信息</a>
					</td>
				</tr>
			</table>

			<table width=100% border="0" cellspacing="1" cellpadding="1"
				align="center">
				<tr>
					<td>

						<%
							if (cust_type.equals("1")) {
						%>
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">

							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0"
									onclick="javascript:secBoard(0)">
									求购信息
								</td>
								<td width="76" height="28" align="left" class=c3 id="d1"
									onclick="javascript:secBoard(1)">
									高级设置
								</td>
								<td>
									&nbsp;

								</td>
							</tr>
						</table>
						<%
							}
						%>


						<!--01-->
						<jsp:include flush="true" page="/member/custcms/infolist.jsp">
							<jsp:param name="cont_mod" value="2" />
							<jsp:param name="news_id" value="<%=stock_id%>" />
							<jsp:param name="ch_id" value="<%=channel_id%>" />
							<jsp:param name="class_id" value="<%=class_id%>" />
						</jsp:include>
						<!--02-->
						<table width=100% border="0" cellpadding="1" cellspacing="1"
							align="center" bgcolor="#98D9A2" id="bo0">

							<tr>
								<td class="u1">
									求购标题：
								</td>
								<td class="u2" colspan="3">
									<div>
										<input name="title" id="title" type="text" size="30"
											maxlength="100">
									</div>
								</td>
							</tr>

							<tr>
							</tr>
							<tr>
								<td height="30" class="u1" valign="top">
									请选择分类：
								</td>
								<td class="u2" colspan="3">
									<div>
										<table border="0" cellpadding="0" cellspacing="0"
											style="margin-left: 0px">
											<tr>
												<td>
													<select name="sort1" size="10" style="width: 130px"
														onChange="setSecondClass(this.value);"
														onclick="setTypeName(this)">
														<%=select%>
													</select>
												</td>
												<td>
													<select name="sort2" size="10"
														style="width: 130px; display: none"
														onChange="setTherdClass(this.value);"
														onclick="setTypeName(this)">
														<option value="0">
															请选择...
														</option>
													</select>
												</td>
												<td>
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
													<div id="nextElement" style="display: none;">
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
									开始时间：
								</td>
								<td class="u2">
									<div>
										<input name="start_date" type="text" id="start_date"
											value="<%=start_date%>" onfocus="setday(this);" size="15" />
										(四位年-二位月-二位日)
									</div>
								</td>
								<td class="u1">
									结束时间：
								</td>
								<td class="u2">
									<div>
										<input name="end_date" type="text" id="end_date"
											value="<%=end_date%>" onfocus="setday(this);" size="15" />
										(四位年-二位月-二位日)
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									采购地区：
								</td>
								<td class="u2" colspan="3">
									<div>
										<input type="hidden" name="web_id" value="000000000000000">
										<input name="stock_addr" type="text" size="30" maxlength="100">
										(如:江苏-杭州)
									</div>
								</td>
							</tr>

							<tr>
								<td class="u1">
									上传图片：
								</td>
								<td class="u2" colspan="3">
									<div class="ping1">
										<iframe src="/inc/uploadImg.jsp?root_id=<%=stock_id%>"
											width="100%" height="180px" marginwidth="0" frameborder=0
											marginheight="0" scrolling="no"></iframe>
									</div>
								</td>
							</tr>
							<tr>

								<td class="u1" valign="top">
									求购说明：
								</td>
								<td class="u2" colspan="3">
									<div>
										<textarea name="content" style="display: none;"></textarea>
										<iframe ID=content
											src=/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=
											<%=stock_id%> frameborder=0 scrolling=no width=700 HEIGHT=350></iframe>
									</div>
								</td>
							</tr>

						</table>
						<!--02-->
						<table width=100% border="0" cellpadding="1" cellspacing="1"
							align="center" bgcolor="#E6F6E9">
							<input name="rsrv_str1" id="rsrv_str1" type="hidden" value="0">
							<input name="root_id" id="root_id" type="hidden"
								value="<%=stock_id%>">
							<input name="user_id" id="user_id" type="hidden"
								value="<%=user_id%>">
							<input name="stock_id" id="stock_id" type="hidden"
								value="<%=stock_id%>">
							<input name="trade_type_code" type="hidden" value="0233">
							<input name="class_id" id="class_id" type="hidden" value="">
							<input name="class_name" id="class_name" type="hidden" value="">
							<input name="class_name_grp" id="class_name_grp" type="hidden"
								value="">
							<input name="class_id_grp" id="class_id_grp" type="hidden"
								value="">
							<input name="count" id="count" type="hidden" value="sort1">
							<input name="remark" id="remark" type="hidden" value="0000">
							<input name="info_type" id="info_type" type="hidden" value="4">
							<input name="info_id" id="info_id" type="hidden"
								value="<%=stock_id%>">

							<tr>
								<td class="u3" colspan="4">
									<input class="tjan" name=submit1 type=submit value=""
										onclick="return on()">
									&nbsp;&nbsp;&nbsp;
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




