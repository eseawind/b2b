<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.channelMgr.*"%>
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />

<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String start_date = date;
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MONTH, 1);
	Date e_end_date = cal.getTime();
  	String end_date = new SimpleDateFormat("yyyy-MM-dd").format(e_end_date);
	ChannelInfo info = new ChannelInfo();
	
	String adv_id = bean.GenTradeId();
	String chselect = info.getChannelItems("0000000000");
%>

<html>
	<head>
		<title>录入广告</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AdvertiseInfo.js'></script> 
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script> 
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="/js/public_b2b.js"></script>
		<script language="JavaScript">
    	function confirmsub(){
	    	if($("cust_adv_id").value.replace(/\s*/g,"")=="" || $("cust_adv_id").value.replace(/\s*/g,"")==null)
				{
					alert("广告位标识不能为空!");
					$("cust_adv_id").focus();
					return false;
				}
				if($("adv_name").value.replace(/\s*/g,"")=="" || $("adv_name").value.replace(/\s*/g,"")==null)
				{
					alert("广告位名称不能为空");
					$("adv_name").focus();
					return false;
				}
			    if($("start_date").value.replace(/\s*/g,"")=="" || $("start_date").value.replace(/\s*/g,"")==null)
				{
					alert("开始日期不能为空!!!");
					$("start_date").focus();
					return false;
				}
			    if($("end_date").value.replace(/\s*/g,"")=="" || $("end_date").value.replace(/\s*/g,"")==null)
				{
					alert("结束日期不能为空!!!");
					$("end_date").focus();
					return false;
				}
		    if(!checkDate($("start_date").value,$("end_date").value)){
				   return false;
				}
				var str=n_content.getHTML();
				str=str.replace(/\s*/g,""); 
				if(str == ""  )
				{
					alert("请填写正常显示内容！");
					return false;
				}
				var str_p=p_content.getHTML();
				str_p=str_p.replace(/\s*/g,""); 
				if(str_p == ""  )
				{
					alert("请填写过期显示内容！");
					return false;
				}
	     return true;         
    }
    
    function checkCustAdv(val){
    	AdvertiseInfo.checkCustAdvId(val,setData);
    }
    function setData(val){
    	if(val==1){
    		alert('广告位标识已存在，请重新输入！');
    		document.getElementById('cust_adv_id').value='';
    	}else{
    		
    	}
    }
        
  </script>
	</head>
	<body>
		<form name="formQuery" id="formQuery" action=/doTradeReg.do method="post" target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="modifyAdvertIndex.jsp"><b>广告管理</b></a>
				</td>
			</tr>
		</table>
			<table width=100% border=0 cellpadding=1 cellspacing=1 align="center" bgcolor="#DEEDFD">
				<tr>
					<td class="u1" valign="middle">
						广告位标识：
					</td>
					<td class="u2" colspan="3">
							<input type="text" name="cust_adv_id" id="cust_adv_id" size="20" maxlength="20" onblur="checkCustAdv(this.value)">*广告位标识为唯一标识，请使用英文字母或数字组合
							<input type="hidden" name="ch_id" value="">
					</td>
				</tr>
				<tr>
					<td class="u1" valign="middle">
						广告位名称：
					</td>
					<td class="u2">
							<input type="text" name="adv_name" id="adv_name" size="20" maxlength="20">
					</td>
					<td class="u1" valign="middle">
						时间限制：
					</td>
					<td class="u2" colspan="3">
							<input type="radio" name="time_limit" value="0" checked>永不过期 &nbsp;<input type="radio" value="1" name="time_limit">在设内时间内有效 
					</td>
				</tr>
				<tr>
					<td class="u1">开始时间：
					</td>
					<td class="u2"><div>
							<input name="start_date" id="start_date" type="text" value="<%=start_date%>" onfocus="setday(this);" style="width:93px">
							(yyyy-mm-dd)
						</div>
					</td>
					<td class="u1">结束时间：
					</td>
					<td class="u2"><div>
							<input name="end_date" id="end_date" type="text" value="<%=end_date%>" onfocus="setday(this);" style="width:93px">
							(yyyy-mm-dd)
						</div>
					</td>
				</tr>						
				<tr>
					<td class="u1" valign="middle">
						正常显示内容：
					</td>
					<td class="u2" colspan="3">
							<textarea name=n_content style=display:none></textarea>
							<iframe id="n_content" src="/www/ewebeditor/ewebeditor.htm?id=n_content&style=coolblue&root_id=<%=adv_id%>" frameborder=0 scrolling=no width=680 height=350></iframe>
					</td>
				</tr>
				<tr>
					<td class="u1" valign="middle">
						过期显示内容：
					</td>
					<td class="u2" colspan="3">
							<textarea name=p_content style=display:none></textarea>
							<iframe id="p_content" src="/www/ewebeditor/ewebeditor.htm?id=p_content&style=coolblue&root_id=<%=adv_id%>" frameborder=0 scrolling=no width=680 height=350></iframe>
					</td>
				</tr>
				
			
				<tr>
					<td height="30" colspan="4" class="u3">
						<input class="tjan" type="submit" value="" onClick=" return confirmsub()">
						&nbsp;&nbsp;&nbsp;
						<img src="/admin/images/comeback.JPG" onClick="location.href='modifyAdvertIndex.jsp'" style="cursor:hand;" align="absmiddle">
						<input name=adv_id type=hidden value="<%=adv_id%>">
						<input name=trade_type_code type=hidden value=1302>
						<input name="info_type" id="info_type" type=hidden value="2">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



