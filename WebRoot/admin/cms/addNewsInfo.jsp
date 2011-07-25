<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="proInfo" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%
	String news_id = bean.GenTradeId();
	String trade_id = bean.GenTradeId();
	
	ChannelInfo channel = new ChannelInfo();
	String class_id = "";
	if (request.getParameter("class_id") != null) {
		class_id = request.getParameter("class_id").toString();
	}
	
	String class_name = channel.getChName(class_id);//proInfo.getClassNameById(class_id);
	
	String cust_id = "";
	if(session.getAttribute("SESSION_CUST_ID") != null){
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	
%>
<html>
	<head>
		<title>发布信息</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			.c4 {
				CURSOR: hand;background:url(/admin/images/di_03.jpg);COLOR:#0066CC;font-size: 14px; font-weight:bold; line-height:28px; padding-left:26px;
			}
			.c3 {CURSOR: hand; background:url(/admin/images/di_04.jpg); COLOR: #0066CC;font-size: 14px; line-height:28px; padding-left:26px;}
			
		</style>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
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
				document.getElementById('title').focus();
				return false;
			}
		 	var str=content.getText();
			str=str.replace(/\s*/g,''); 
			if(str == ''  ){
				alert('请填写信息的内容！');
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
			var fcolor=showModalDialog("color.htm?ok",false,"dialogWidth:106px;dialogHeight:110px;status:0;dialogTop:"+(window.event.clientY+120)+";dialogLeft:"+(window.event.clientX));
			if(fcolor!=null && fcolor!="undefined") document.newform.title_color.value = fcolor;
		}
	</script>
	</head>
	<body>
		<form name="newform" action=/doTradeReg.do method="post" target="_self">

			<table width=100% border="0" cellspacing="1" cellpadding="1" align="center">
				<tr>
					<td>
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0" onclick="javascript:secBoard(0)">
									资讯内容
								</td>
								<td width="76" height="28" align="left" class=c3 id="d1" onclick="javascript:secBoard(1)">
									高级参数
								</td>
								<td>&nbsp;
									
								</td>
							</tr>
						</table>
						<!--01-->
						<jsp:include  flush="true" page="/admin/cms/infolistNews2.jsp">
							<jsp:param name="news_id" value="<%=news_id%>"/>
							<jsp:param name="class_id" value="<%=class_id%>"/>
						</jsp:include>
						<!--02-->
						<table width="100%" border=0 align="center" cellpadding=1 cellspacing=1 bgcolor="#DEEDFD" id="bo0" >
							<tr>
								<td class="u1" width="111">
									资讯标题:
								</td>
								<td class="u2" colspan="3">
									<div>
										<input name="title" type="text" id="title" >
									</div>
								</td>
							</tr>
							<tr>
								<tr>
								<td class="u1" width="111">
									频道名称:
								</td>
								<td class="u2" colspan="3">
									<div>
										<input name="class_type" type="text" id="class_type" value="<%=class_name%>" readonly>
									</div>
								</td>
							</tr>
							
							<tr>
								<td class="u1">
									缩略图：
								</td>
								<td class="u2" colspan="3">
									<input name="mini_img" id="mini_img" type="hidden">
									<div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
										<iframe src="/inc/uploadImg.jsp?root_id=<%=news_id%>" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
									</div>
								</td>
							</tr>		
							
							<tr>
								<td class="u1">
									信息内容：
								</td>
								<td class="u2" colspan="3">
									<textarea name="content" id="content" style=display:none></textarea>
									<iframe ID="content" src="/www/ewebeditor/ewebeditor.htm?id=content&style=coolblue&root_id=<%=news_id%>" frameborder="0" scrolling="no" width="680" HEIGHT="350"></iframe>
									<br>
									输入范围(汉字应少于4000字)
								</td>
							</tr>
						</table>
						<!--选项结束-->
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
			</table>
			<table width="100%" border=0 align="center" cellpadding=1 cellspacing=1 bgcolor="#DEEDFD">
				<tr>
					<td colspan=4 class="u3">
						<input name="news_id" type="hidden" id="news_id" value="<%=news_id%>">
						<input name="info_id" type="hidden" id="info_id" value="<%=news_id%>">
						<input name="remark" type="hidden" id="remark" value="">
						<input name="subject_tag" type="hidden" value=0>
						<input name="news_type" type="hidden" value="<%=class_id%>" id="news_type">
						<input type="hidden" name="class_id" id="class_id" value="" />
						<input type="hidden" name="in_date" id="in_date" value="" />
						<input name="trade_type_code" type="hidden" value="0265" />
						
						<!-- 新增点击量表开始 -->
						<input name="cust_id" type="hidden" value="<%=cust_id%>" />
						<input name="root_id" type="hidden" value="<%=news_id%>" />
						<input name="click_type" type="hidden" value="1" /><!--1:资讯 -->
						<!-- 点击量表参数结束 -->
						
						<input name="trade_id" type="hidden" value="<%=trade_id%>" />
						<input name="user_temp" type="hidden" value="" />
						<input name="quo_id" type="hidden" value="<%=news_id%>" />
						<input name="info_type" type="hidden" value="1" />
						<input name="info_state" type="hidden" value="0" />
						<input class="tjan" name="bnt" type="submit" value="" onclick="return Check_Value()">
						&nbsp;&nbsp;&nbsp;
						<img src="/admin/images/comeback.JPG" align="absmiddle" onClick="location.href='viewClassNewsInfo.jsp?class_id=<%=class_id%>'" style="cursor:hand;">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


