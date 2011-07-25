<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page  import="java.util.*"%>
<%@ page import="com.ahbay.commenMgr.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.saas.biz.bpmdefinitionMgr.BpmInfo"%>
<%@ page import="java.text.SimpleDateFormat"%>

<jsp:useBean id="menu" class="com.saas.biz.rightMgr.RightMenu" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />



<html>
	<head>
		<title>新增BPM</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/BpmInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<%
	 request.setCharacterEncoding("gbk");
     String start_time1 ="",end_time1 ="",code="",key_word="";
     Calendar cal = Calendar.getInstance();
     if (request.getParameter("start_time") != null) {
		start_time1 = request.getParameter("start_time");
	}
	if (request.getParameter("end_time") != null) {
		end_time1 = request.getParameter("end_time");
	}
	if (request.getParameter("code") != null) {
		code = request.getParameter("code");
	}
	if (request.getParameter("key_word") != null) {
		key_word = request.getParameter("key_word").trim();
	}
	String start_time = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
%>
		<script type="text/javascript">
			function check_ty_code(){}
			function checkTradeTypeCode(val){
				if(val!=''){
					BpmInfo.getOneBpmByCt(val,setData);	
				}
			}
			function setData(val){
				if(val==1){
					alert('trade_type_code已存在,请重新输入!');
					document.getElementById('trade_type_code').value='';
					document.getElementById('bpm_id').value='';
					document.getElementById('bpm_id1').value='';
					document.getElementById('trade_type_code1').value='';
				}else if(document.getElementById('trade_type_code2').value.length!=4){
					alert('trade_type_code的值必需为四位数!');
					
					}
				else{
					document.getElementById('bpm_id').value=document.getElementById('trade_type_code2').value;
					document.getElementById('bpm_id1').value=document.getElementById('trade_type_code2').value;
					document.getElementById('trade_type_code1').value=document.getElementById('trade_type_code2').value;
				   
				}
				
			}
						
			function checkNodeClass(){
				if(document.getElementById('trade_type_code2').value==''){
					alert('请输入trade_type_code的值!');
					document.getElementById('trade_type_code2').focus();
					return false;
				}
				
				if(document.getElementById('node_class').value==''){
					alert('请输入node_class的值!');
					document.getElementById('node_class').focus();
					return false;
				}
				if(document.getElementById('node_method').value==''){
					alert('请输入node_method的值!');
					document.getElementById('node_method').focus();
					return false;
				}
				if(document.getElementById('trade_name').value==''){
					alert('请输入trade_name的值!');
					document.getElementById('trade_name').focus();
					return false;
				}
				document.addBpm.submit();
			}
		</script>
	</head>
	<body>
		<form name="addBpm" id="addBpm" action="/doTradeReg.do" method="post" target="_self">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href="modelIndex.jsp">查看业务流程</a>
				</td>
			</tr>
		</table>
			<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
				<tr>
					<td valign="middle" background="/admin/images/bg_0.gif" align="center">
						<b>新增BPM</b>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
				<tr>
					<td width="15%" bgcolor="#ffffff">
						<div style=" text-align:right; font-weight:bold;">
						trade_type_code:
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="trade_type_code2" type="text" id="trade_type_code2"  value="" onblur="checkTradeTypeCode(this.value)"  maxlength="20"><font color="red">*</font>
						</div>
					</td>

					<td width="15%" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							bpm_id：
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
						
							<input name="bpm_id" type="text" id="bpm_id" value="" size="20" maxlength="20" readonly>
							<font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							node_id：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="node_id" type="text" id="node_id" value="12345678901234567890" size="20" maxlength="20" readonly="readonly">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							node_type：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="node_type" type="text" id="node_type" value="0" size="20" maxlength="20" readonly="readonly">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							node_sequence：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="node_sequence" type="text" id="node_sequence" value="0" size="15" maxlength="12">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							node_class：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="node_class" type="text" id="node_class"  size="30" maxlength="100" ><font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							node_method：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="node_method" type="text" id="node_method" value="" size="30" maxlength="100"><font color="red">*</font>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							out_query：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="out_query" type="text" id="out_query" value="tradeQuery" size="20" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							out_buffer：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="out_buffer" type="text" id="out_buffer" value="outBuffer" size="15" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							undo_tag：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="undo_tag" type="text" id="undo_tag" value="0" size="20" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							unde_class：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="unde_class" type="text" id="unde_class" value="" size="30" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							undo_method：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="undo_method" type="text" id="undo_method" value="" size="30" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							undo_out_query：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="undo_out_query" type="text" id="undo_out_query" value="" size="15" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							undo_out_buffer:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="undo_out_buffer" type="text" id="undo_out_buffer" value="" size="10" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str1：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str1" type="text" id="rsrv_str1" value="" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str2" type="text" id="rsrv_str2" value="" size="20" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str3：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str3" type="text" id="rsrv_str3" value="" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str4：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str4" type="text" id="rsrv_str4" value="" size="30" maxlength="100">
							
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str5：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str5" type="text" id="rsrv_str5" value="0" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str6：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str6" type="text" id="rsrv_str6" value="0" size="10" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str7：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str7" type="text" id="rsrv_str7" value="" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str8：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str8" type="text" id="rsrv_str8" value="" size="10" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str9：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str9" type="text" id="rsrv_str9" value="" size="10" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str0：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str0" type="text" id="rsrv_str0" value="" size="30" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
						in_date：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_date" type="text" id="in_date" value=""  maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							remark：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="remark" type="text" id="remark" value="" size="30" maxlength="30">
						</div>
					</td>
				</tr>	
				
				<tr>
					<td bgcolor="#FFFFFF" align="center" height="30" colspan="4">
					   <input name="in_staff_id" type="hidden" id="in_staff_id" value="">					
					</td>
				</tr>
			</table>	
				<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#BED9E1">
				<tr>
					<td valign="middle" background="/admin/images/bg_0.gif" align="center">
						<b>新增TRADETYPE</b>
					</td>
				</tr>
			  </table>
			  <table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#dddddd">
				<tr>
					<td width="15%" bgcolor="#ffffff">
						<div style=" text-align:right; font-weight:bold;">
						trade_type_code:
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="trade_type_code1" type="text" id="trade_type_code1"  value=""   maxlength="20" readonly><font color="red">*</font>
						</div>
					</td>

					<td width="15%" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							bpm_id：
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
						
							<input name="bpm_id1" type="text" id="bpm_id1" value="" size="20" maxlength="20" readonly>
							<font color="red">*</font>
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							trade_name:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="trade_name" type="text" id="trade_name" value="" size="20" maxlength="20" ><font color="red">*</font>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							judge_rights：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="judge_rights" type="text" id="judge_rights" value="0" size="20" maxlength="20" readonly="readonly">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							trade_kind:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="trade_kind" type="text" id="trade_kind" value="0" size="15" maxlength="12">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							cancel_tag:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="cancel_tag" type="text" id="cancel_tag"  size="30" maxlength="100" >
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							transe_type:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="transe_type" type="text" id="transe_type" value="" size="30" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							succeed_fwd:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="succeed_fwd" type="text" id="succeed_fwd" value="succeed" size="20" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
						error_fwd：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="error_fwd" type="text" id="error_fwd" value="fail" size="15" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							enable_tag：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="enable_tag" type="text" id="enable_tag" value="" size="20" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							start_date：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="start_date" type="text" id="start_date" size="30" maxlength="100" onfocus="setday(this);" value="<%=start_time%>">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							end_date:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="end_date" type="text" id="end_date"  size="30" maxlength="100" onfocus="setday(this);" value="2050-05-05">
						</div>
					</td>
				</tr>
				
				<tr>
					<td align="right" bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str1：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str1_a" type="text" id="rsrv_str1" value="" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str2_a" type="text" id="rsrv_str2" value="" size="20" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str3：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str3_a" type="text" id="rsrv_str3" value="" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str4：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str4_a" type="text" id="rsrv_str4" value="" size="30" maxlength="100">
							
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str5：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str5_a" type="text" id="rsrv_str5" value="" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str6：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str6_a" type="text" id="rsrv_str6" value="" size="10" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str7：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str7_a" type="text" id="rsrv_str7" value="" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str8：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str8_a" type="text" id="rsrv_str8" value="" size="10" maxlength="1">
						</div>
					</td>
				</tr>
				<tr>
					<td align="right" bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str9：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str9_a" type="text" id="rsrv_str9" value="" size="10" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str0：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str0_a" type="text" id="rsrv_str0" value="" size="30" maxlength="100">
						</div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
						in_date：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="in_date" type="text" id="in_date" value=""  maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							remark：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="remark_a" type="text" id="remark_a" value="" size="30" maxlength="30">
						</div>
					</td>
				</tr>	
		
				<tr>
					<td bgcolor="#FFFFFF" align="center" height="50" colspan="4">
					   <input name="in_staff_id" type="hidden" id="in_staff_id" value="">
						<input name="trade_type_code" type="hidden" id="trade_type_code" value="9967">
						<img src="/admin/images/submit_0.gif" onclick="return checkNodeClass()" style="cursor: hand;">
							<img src="/admin/images/submit_1.gif" onClick="location.href='modelIndex.jsp'" style="cursor:hand;" align="absmiddle">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


