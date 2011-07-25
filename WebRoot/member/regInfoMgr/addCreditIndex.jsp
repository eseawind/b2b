<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="proInfo" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<jsp:useBean id="classBean" class="com.saas.biz.productclassMgr.Productclass" scope="page" />
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.channelMgr.ChannelInfo"%>
<%
	 
	String credit_id = bean.GenTradeId();
	String info_id=credit_id;
	ChannelInfo channel = new ChannelInfo();
	ParamethodMgr paramCom = new ParamethodMgr();
	String price_type = paramCom.getSelectItems("3");
	String start_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	Calendar cal = Calendar.getInstance();
	cal.add( Calendar.MONTH, 3 );
	String end_date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String class_id = "";
	if (request.getParameter("class_id") != null) 
	{
		class_id = request.getParameter("class_id").toString();
	}
//	String class_name = channel.getChName(class_id);//proInfo.getClassNameById(class_id);
	String select = classBean.getSelectedByComm("5", "1");
	

	String credit_type = paramCom.getSelectItems("7");
	/*
	String credit_id = bean.GenTradeId();
	out.println("credit_id = " + credit_id "<br>");
	*/
	String credit_department = paramCom.getSelectItems("32");
	//String chanal_id = "1857133626";
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
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/Productclass.js'></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="supply.js"></script>
		<script language="JavaScript">
			function Check_Value_My() {
				if(document.getElementById('credit_title').value.replace(/\s*/g,'')=='' || document.getElementById('credit_title').value.replace(/\s*/g,'')==null) {
					alert('请填写标题！');
					
					return false;
				}
				if(document.getElementById('start_date').value.replace(/\s*/g,'')=='' || document.getElementById('start_date').value.replace(/\s*/g,'')==null) {
					alert('请填写开始时间！');
					
					return false;
				}							
				var str=credit_desc.getText();
				str=str.replace(/\s*/g,''); 
				if(str == ''  ){
					alert('请填写证书说明！');
					return false;
				}
				if( str.length > 4000){
					 alert( '字数应少于4000字!' );
					 return false;	
				}
				
				if(document.getElementById('end_date').value.replace(/\s*/g,'')=='' || document.getElementById('end_date').value.replace(/\s*/g,'')==null) {
					alert('请填写结束时间！');
				
					return false;
				}
				if(document.getElementById('cust_ch_id').value=='0' ){
					alert('请选择所属栏目-资质荣誉！');
					return false;
				}			
				document.getElementById('title').value = document.getElementById('credit_title').value;
				return true;
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
			
			function formSub(){
				if(Check_Value_My()){
					alert('提交后请重新生成资质证书栏目页面！');
					return true;
				}else{
					return false;
				}
			}
		</script>
		
	</head>
	<body>
		<form name="newform" action=/doTradeReg.do method="post" target="_self">
			
			<table width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
				<tr class="u1">
					<td class="head" align="left">
						<a href="modifyCreditIndex.jsp">企业资质证书</a>
					</td>
			 </tr>
				<tr>
					<td>
						<!--
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr class="u4">
								<td width="76" height="28" align="left" class=c4 id="d0" onclick="javascript:secBoard(0)">
									证书内容
								</td>
								<td width="76" height="28" align="left" class=c3 id="d1" onclick="javascript:secBoard(1)">
									常规参数
								</td>
								<td>&nbsp;
									
								</td>
							</tr>
						</table>
						-->
						<!--01-->
						<jsp:include flush="true" page="infolist.jsp">
							<jsp:param name="credit_id" value="<%=credit_id%>"/>
							<jsp:param name="class_id" value="<%=class_id%>"/>
						</jsp:include>
						<!--02-->
						<table width="100%" border=0 align="center" cellpadding=1 cellspacing=1 bgcolor="#DEEDFD" id="bo0" >
						
							<tr>
								<td height="30" class="u1" valign="middle">
									证书类型：
								</td>
								<td class="u2" colspan="3">									
										<select name=credit_type>
											<%=credit_type%>
										</select>									
								</td>
								
							</tr>
							<tr>
								<td height="30" class="u1" valign="middle">
									归属部门：
								</td>
								<td class="u2" colspan="3">									
										<select name=credit_department>
											<%=credit_department%>
										</select>								
								</td>
							</tr>
							<tr>
								<td height="30" class="u1" valign="middle">
									证书名称：
								</td>
								<td class="u2" colspan="3">									
										<input name="credit_title" type="text" size=70 maxlength=70>							
								</td>
							</tr>
							
							<tr>
								<td class="u1">
									缩略图：
								</td>
								<td class="u2" colspan="3">
									<input name="mini_img" id="mini_img" type="hidden">
									<div style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;">
										<iframe src="/inc/uploadImg.jsp?root_id=<%=credit_id%>" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
									</div>
								</td>				
							</tr>
							
							<tr>
								<td class="u1">
									证书说明：
								</td>
								<td class="u2" colspan="3">
									<div>
										<textarea name="credit_desc" style=display:none></textarea>
										<iframe ID="credit_desc" src="/www/ewebeditor/ewebeditor.htm?id=credit_desc&style=coolblue&root_id=<%=credit_id%>" frameborder=0 scrolling=no width=600 HEIGHT=350></iframe>
									</div>
								</td>
							</tr>
							
							<tr>
								<td class="u1">
									开始时间：
								</td>
								<td class="u2">
									<div>
										<input name="credit_start_date" type="text" id="start_date" value="<%=start_date%>" onfocus="setday(this);" size="10" />
										(四位年-二位月-二位日)
									</div>
								</td>
								<td class="u1">
									结束时间：
								</td>
								<td class="u2">
									<div>
										<input name="credit_end_date" type="text" id="end_date" value="<%=end_date%>" onfocus="setday(this);" size="10" />
										(四位年-二位月-二位日)
									</div>
								</td>
							</tr>
							
						</table>
						
					</td>
				</tr>
			</table>
			
			<table width="100%" border=0 align="center" cellpadding=1 cellspacing=1 bgcolor="#DEEDFD">
				<tr>
					<td colspan=4 class="u3">
						<input name=credit_id type=hidden value="<%=credit_id%>">
						<input type="hidden" name="trade_type_code" value="0214">
						
						<input type="hidden" name="web_id" value="000000000000000">					
						<input type="hidden" name="class_id" id="class_id" value="">								
						<input type="hidden" name="remark" id="remark" value="">						
						<!-- <input type="hidden" name="cust_ch_id" id="cust_ch_id" value=""> -->
						<input type="hidden" name="info_id" id="info_id" value=<%=info_id%>>																		
						<input class="tjan" name="bnt" type="submit" value="" onclick="return formSub()">
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>


