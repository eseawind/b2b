<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr"
	scope="page" />
<%
	HttpSession logsession = request.getSession();
	String cust_id = "";
	String show_id = bean.GenTradeId();
	String user_id = "";
	String class_id = "2263836050"; //展会信息
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
	}
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	Calendar cal = Calendar.getInstance();
	String start_time = new SimpleDateFormat("yyyy-MM-dd").format(cal
			.getTime());
	cal.add(Calendar.MONTH, 3);
	String end_time = new SimpleDateFormat("yyyy-MM-dd").format(cal
			.getTime());
	String ch_id = "2263836050";
%>

<html>
	<head>
		<title>展会管理</title>
		<script type="text/javascript" src="/inc/upLoad.js"></script>
		<script language="JavaScript">
			function Check_Value_My()
			{
				if(document.getElementById('title').value=='')
				{
					alert('请填写展会标题！');
					return false;
				}
				if(document.getElementById('show_addr').value=='')
				{
					alert('请填写展会地点！');
					return false;
				}
				if(document.getElementById('show_pos').value=='')
				{
					alert('请填写展会场所！');
					return false;
				}
				if(document.getElementById('mg_unit').value=='')
				{
					alert('请填写展会主办单位！');
					return false;
				}
			 	if(document.getElementById('start_date').value=='' )
			 	{
					alert('开始日期不能为空!');
					return false;
			 	}
			 	if(document.getElementById('end_date').value=='' )
			 	{
					alert('结束日期不能为空');
					return false;
			 	} 
				var reg=/[^\x00-\x80]/;
		    	var a=document.getElementById("contact_phone").value;
		    	if(reg.test(a))
		    	{
		        	alert("电话号码录入错误！");
		        	return false;
		    	}
				if(!checkDate(document.classForm.start_date.value,document.classForm.end_date.value))
				{
			   		return false;
				}
				document.getElementById('contents').value = document.getElementById('one').value + document.getElementById('two').value;  //+ document.getElementById('three').value;
			 	return true;
			}
		</script>
		<script language="javascript">
				window.onload=setOneClass;
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
		function ShowColor(){
			var fcolor=showModalDialog("/admin/cms/color.htm?ok",false,"dialogWidth:106px;dialogHeight:110px;status:0;dialogTop:"+(window.event.clientY+120)+";dialogLeft:"+(window.event.clientX));
			if(fcolor!=null && fcolor!="undefined") document.classForm.title_color.value = fcolor;
		}
	</script>

	</head>
	<body>
		<form name="newproductform" action="/doTradeReg.do" method="post"
			target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr class="u1">
					<td colspan=3 align="left" class="head">
						<a href="showMgr.jsp"><b>展会管理</b>
						</a>
					</td>
				</tr>
			</table>
			<table width=100% border="0" cellspacing="0" cellpadding="0"
				align="center">
				<tr>
					<td>
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0"
									onclick="javascript:secBoard(0)">
									展会内容
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
						<!--01-->
						<jsp:include flush="true" page="infolist1.jsp">
							<jsp:param name="news_id" value="<%=show_id%>" />
							<jsp:param name="class_id" value="<%=class_id%>" />
						</jsp:include>
						<!--02-->
						<table width=100% border=0 cellpadding=5 cellspacing=1
							align=center bgcolor="#e7e7e7" id="bo0">
							<tr>
								<td width="20%" class="u1">

									展会标题：
								</td>
								<td class="u2" colspan=3>
									<div class="ping1">
										<input name="title" id="title" type="text" size=30
											maxlength=70>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="20%">
									展会地点：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<input type=text name="show_addr" id="show_addr" size=20
											value="">
									</div>
								</td>
								<td class="u1" width="20%">
									举办场馆：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<input type=text name="show_pos" id="show_pos" size=20
											value="">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="20%">
									开始时间：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<input type=text name="start_date" id="start_date"
											value="<%=start_time%>" onfocus="setday(this);">
									</div>
								</td>
								<td class="u1" width="20%">
									结束时间：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<input type=text name="end_date" id="end_date" size=20
											value=<%=end_time%> onfocus="setday(this);">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="20%">
									报名开始日期：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<input type=text name="open_start_date" id="open_start_date"
											size=20 value=<%=start_time%> onfocus="setday(this);">
									</div>
								</td>
								<td class="u1" width="20%">
									报名截止日期：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<input type=text name="open_end_date" id="open_end_date"
											size=20 value=<%=end_time%> onfocus="setday(this);">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="20%">
									主办单位：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<textarea name="mg_unit" id="mg_unit" rows="6" cols="26"></textarea>
									</div>
								</td>
								<td class="u1" width="20%">
									承办单位：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<textarea name="do_unit" id="do_unit" rows="6" cols="26"></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="20%">
									支持协办单位：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<textarea name="help_unit" id="help_unit" rows="6" cols="26"></textarea>
									</div>
								</td>
								<td class="u1" width="20%">
									参展范围：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<textarea name="in_rage" id="in_rage" rows="6" cols="26"></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="20%">
									收费标准：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<textarea name="fee" id="fee" rows="6" cols="26"></textarea>
									</div>
								</td>
								<td class="u1" width="20%">
									备注：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<textarea name="remark" id="remark" rows="6" cols="26"></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1" width="20%">
									联系电话：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<input type=text name="contact_phone" id="contact_phone"
											size=20 value="">
									</div>
								</td>
								<td class="u1" width="20%">
									联系人：
								</td>
								<td align=left
									style="background-color: #ffffff; color: #000000; font-size: 12px;"
									width="30%">
									<div class="ping1">
										<input type=text name="contact_man" id="contact_man" size=20
											value="">
									</div>
								</td>
							</tr>
							<tr>
								<td class="u1">
									展会简介：
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
						<table width="100%" border=0 align="center" cellpadding=1
							cellspacing=1 bgcolor="#DEEDFD">
							<tr>
								<td class="u3" colspan=4>
									<input class="tjan" type=submit value=""
										onclick="return Check_Value_My();">
									&nbsp;&nbsp;&nbsp;
									<img src="/admin/images/comeback.JPG"
										onClick="location.href='showMgr.jsp'" style="cursor: hand;"
										align="absmiddle">
									<input type=hidden name="user_id" id="user_id" size=20
										value="<%=user_id%>">
									<input type=hidden name="trade_type_code" id="trade_type_code"
										value="3690">
									<input type=hidden name="cust_id" id="cust_id"
										value="<%=cust_id%>">
									<input type=hidden name="audit_date" id="audit_date"
										value="<%=start_time%>">
									<input type=hidden name="show_id" id="show_id"
										value="<%=show_id%>">
									<input type="hidden" name="info_id" id="info_id"
										value=<%=show_id%>>
									<input type=hidden name="show_type" id="show_type" size=20
										value="1">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>




