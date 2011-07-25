<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page  import="java.util.*"%>
<%@ page import="com.ahbay.commenMgr.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.saas.biz.bpmdefinitionMgr.BpmInfo"%>
<%@ page import="com.saas.biz.tradeTypeMgr.TradeTypeInfo"%>
<%@ page import="java.text.SimpleDateFormat"%>

<jsp:useBean id="menu" class="com.saas.biz.rightMgr.RightMenu" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />


<html>
	<head>
		<title>修改BPM</title>
		<%
		   String trade_type_code = "";
	  	  if (request.getParameter("trade_type_code") != null) {
			   trade_type_code = request.getParameter("trade_type_code");
	    	}		     
		    
		    String bpm_id="",node_id="",node_type="",node_sequence="",node_class="",out_query="",out_buffer="",undo_tag="",unde_class="",undo_method="",undo_out_query="";
		    String undo_out_buffer="",rsrv_str1="",rsrv_str2="",rsrv_str3="",rsrv_str4="",rsrv_str5="",rsrv_str6="",rsrv_str7="",rsrv_str8="",rsrv_str9="",rsrv_str0="",in_date="",remark="",node_method="";
		   
		    ArrayList bpmList = new ArrayList();
	    	BpmInfo bpmInfo = new BpmInfo();		
		    bpmList = bpmInfo. getOneBpm(trade_type_code);
		    if ( bpmList != null &&  bpmList.size()>0){
		        HashMap bpmMap = (HashMap)bpmList.get(0);
		       
						if (bpmMap.get("bpm_id") != null){bpm_id = bpmMap.get("bpm_id").toString(); }
						if (bpmMap.get("node_type") != null){node_type = bpmMap.get("node_type").toString(); } 
						if (bpmMap.get("node_sequence") != null){node_sequence = bpmMap.get("node_sequence").toString(); }       
						if (bpmMap.get("node_class") != null){node_class = bpmMap.get("node_class").toString(); } 
						if (bpmMap.get("out_query") != null){out_query = bpmMap.get("out_query").toString(); } 
						if (bpmMap.get("out_buffer") != null){out_buffer = bpmMap.get("out_buffer").toString(); } 
						if (bpmMap.get("undo_tag") != null){undo_tag = bpmMap.get("undo_tag").toString(); } 
						if (bpmMap.get("unde_class") != null){unde_class = bpmMap.get("unde_class").toString(); } 
						if (bpmMap.get("undo_method") != null){undo_method = bpmMap.get("undo_method").toString(); } 
						if (bpmMap.get("undo_out_query") != null){undo_out_query = bpmMap.get("undo_out_query").toString(); } 
						if (bpmMap.get("undo_out_buffer") != null){undo_out_buffer = bpmMap.get("undo_out_buffer").toString(); } 
						if (bpmMap.get("rsrv_str1") != null){rsrv_str1 = bpmMap.get("rsrv_str1").toString(); } 
						
						if (bpmMap.get("rsrv_str2") != null){rsrv_str2 = bpmMap.get("rsrv_str2").toString(); } 
						if (bpmMap.get("rsrv_str3") != null){rsrv_str3 = bpmMap.get("rsrv_str3").toString(); } 
						if (bpmMap.get("rsrv_str4") != null){rsrv_str4 = bpmMap.get("rsrv_str4").toString(); } 
						if (bpmMap.get("rsrv_str5") != null){rsrv_str5 = bpmMap.get("rsrv_str5").toString(); } 
						if (bpmMap.get("rsrv_str6") != null){rsrv_str6 = bpmMap.get("rsrv_str6").toString(); } 
						if (bpmMap.get("rsrv_str7") != null){rsrv_str7 = bpmMap.get("rsrv_str7").toString(); } 
						if (bpmMap.get("rsrv_str8") != null){rsrv_str8 = bpmMap.get("rsrv_str8").toString(); } 
						if (bpmMap.get("rsrv_str9") != null){rsrv_str9 = bpmMap.get("rsrv_str9").toString(); } 
						if (bpmMap.get("rsrv_str0") != null){rsrv_str0 = bpmMap.get("rsrv_str0").toString(); } 
						if (bpmMap.get("node_method") != null){node_method = bpmMap.get("node_method").toString(); }
						if (bpmMap.get("in_date") != null){in_date = bpmMap.get("in_date").toString(); } 
						if (bpmMap.get("remark") != null){remark = bpmMap.get("remark").toString(); }
		    }
		    
		      ArrayList tradeList = new ArrayList();
	      	TradeTypeInfo tradeInfo = new TradeTypeInfo();		
		      tradeList = tradeInfo.getOneTradeType(trade_type_code);
		      
		      String trade_name="",judge_rights="",trade_kind="",cancel_tag="",transe_type="",succeed_fwd="",error_fwd="",enable_tag="";
		      String start_date="",end_date="",rsrv_str11="",rsrv_str12="",rsrv_str13="",rsrv_str14="",rsrv_str15="",rsrv_str16="",rsrv_str17="",rsrv_str18="",rsrv_str19="",rsrv_str10="";
		      String in_date1="",remark1="";
		    if ( tradeList != null &&  tradeList.size()>0){
		        HashMap tradeMap = (HashMap)tradeList.get(0);
		        	if (tradeMap.get("trade_name") != null){trade_name = tradeMap.get("trade_name").toString(); }
		        	if (tradeMap.get("judge_rights") != null){judge_rights = tradeMap.get("judge_rights").toString(); }
		        	if (tradeMap.get("trade_kind") != null){trade_kind = tradeMap.get("trade_kind").toString(); }
		        	if (tradeMap.get("cancel_tag") != null){cancel_tag = tradeMap.get("cancel_tag").toString(); }
		        	if (tradeMap.get("transe_type") != null){transe_type = tradeMap.get("transe_type").toString(); }
		        	if (tradeMap.get("succeed_fwd") != null){succeed_fwd = tradeMap.get("succeed_fwd").toString(); }
		        	if (tradeMap.get("error_fwd") != null){error_fwd = tradeMap.get("error_fwd").toString(); }
		        	if (tradeMap.get("enable_tag") != null){enable_tag = tradeMap.get("enable_tag").toString(); }
		        	if (tradeMap.get("start_date") != null){start_date = tradeMap.get("start_date").toString(); }
		        	if (tradeMap.get("end_date") != null){end_date = tradeMap.get("end_date").toString(); }
		        	
		        	if (tradeMap.get("rsrv_str1") != null){rsrv_str11 = tradeMap.get("rsrv_str1").toString(); }
		        	if (tradeMap.get("rsrv_str2") != null){rsrv_str12 = tradeMap.get("rsrv_str2").toString(); }
		        	if (tradeMap.get("rsrv_str3") != null){rsrv_str13 = tradeMap.get("rsrv_str3").toString(); }
		        	if (tradeMap.get("rsrv_str4") != null){rsrv_str14 = tradeMap.get("rsrv_str4").toString(); }
		        	if (tradeMap.get("rsrv_str5") != null){rsrv_str15 = tradeMap.get("rsrv_str5").toString(); }
		        	if (tradeMap.get("rsrv_str6") != null){rsrv_str16 = tradeMap.get("rsrv_str6").toString(); }
		        	if (tradeMap.get("rsrv_str7") != null){rsrv_str17 = tradeMap.get("rsrv_str7").toString(); }
		        	if (tradeMap.get("rsrv_str8") != null){rsrv_str18 = tradeMap.get("rsrv_str8").toString(); }
		        	if (tradeMap.get("rsrv_str9") != null){rsrv_str19 = tradeMap.get("rsrv_str9").toString(); }
		        	if (tradeMap.get("rsrv_str0") != null){rsrv_str10 = tradeMap.get("rsrv_str0").toString(); }
		        	if (tradeMap.get("in_date") != null){in_date1 = tradeMap.get("in_date").toString(); }
		        	if (tradeMap.get("remark") != null){remark1 = tradeMap.get("remark").toString(); }
		        }
		
		%>
		
		
		
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
				}else{
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
						<b>修改BPM</b>
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
							<input name="trade_type_code2" type="text" id="trade_type_code2"  value=<%=trade_type_code%>   maxlength="20"><font color="red">*</font>
						</div>
					</td>

					<td width="15%" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							bpm_id：
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
						
							<input name="bpm_id" type="text" id="bpm_id" value=<%=trade_type_code%> size="20" maxlength="20" readonly>
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
							<input name="node_id" type="text" id="node_id" value="<%=node_id%>" size="20" maxlength="20" >
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
							<input name="node_sequence" type="text" id="node_sequence" value="<%=node_sequence%>" size="15" maxlength="12">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							node_class：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="node_class" type="text" id="node_class" value="<%=node_class%>" size="30" maxlength="100" ><font color="red">*</font>
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
							<input name="node_method" type="text" id="node_method" value="<%=node_method%>" size="30" maxlength="100"><font color="red">*</font>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							out_query：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="out_query" type="text" id="out_query" value="<%=out_query%>" size="20" maxlength="100">
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
							<input name="out_buffer" type="text" id="out_buffer" value="<%=out_buffer%>" size="15" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							undo_tag：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="undo_tag" type="text" id="undo_tag" value="<%=undo_tag%>" size="20" maxlength="1">
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
							<input name="unde_class" type="text" id="unde_class" value="<%=unde_class%>" size="30" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							undo_method：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="undo_method" type="text" id="undo_method" value="<%=undo_method%>" size="30" maxlength="100">
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
							<input name="undo_out_query" type="text" id="undo_out_query" value="<%=undo_out_query%>" size="15" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							undo_out_buffer:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="undo_out_buffer" type="text" id="undo_out_buffer" value="<%=undo_out_buffer%>" size="10" maxlength="100">
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
							<input name="rsrv_str1" type="text" id="rsrv_str1" value="<%=rsrv_str1%>" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str2" type="text" id="rsrv_str2" value="<%=rsrv_str2%>" size="20" maxlength="100">
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
							<input name="rsrv_str3" type="text" id="rsrv_str3" value="<%=rsrv_str3%>" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str4：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str4" type="text" id="rsrv_str4" value="<%=rsrv_str4%>" size="30" maxlength="100">
							
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
							<input name="rsrv_str5" type="text" id="rsrv_str5" value="<%=rsrv_str5%>" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str6：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str6" type="text" id="rsrv_str6" value="<%=rsrv_str6%>" size="10" maxlength="1">
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
							<input name="rsrv_str7" type="text" id="rsrv_str7" value="<%=rsrv_str7%>" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str8：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str8" type="text" id="rsrv_str8" value="<%=rsrv_str8%>" size="10" maxlength="1">
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
							<input name="rsrv_str9" type="text" id="rsrv_str9" value="<%=rsrv_str9%>" size="10" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str0：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str0" type="text" id="rsrv_str0" value="<%=rsrv_str0%>" size="30" maxlength="100">
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
							<input name="in_date" type="text" id="in_date" value="<%=in_date%>"  maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							remark：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="remark" type="text" id="remark" value="<%=remark%>" size="30" maxlength="30">
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
						<b>修改TRADETYPE</b>
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
							<input name="trade_type_code1" type="text" id="trade_type_code1"  value="<%=trade_type_code%>"   maxlength="20" readonly><font color="red">*</font>
						</div>
					</td>

					<td width="15%" bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							bpm_id：
						</div>
					</td>
					<td width="35%" bgcolor="#FFFFFF">
						<div class="ping1">
						
							<input name="bpm_id1" type="text" id="bpm_id1" value="<%=trade_type_code%>" size="20" maxlength="20" readonly>
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
							<input name="trade_name" type="text" id="trade_name" value="<%=trade_name%>" size="20" maxlength="20" ><font color="red">*</font>
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							judge_rights：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="judge_rights" type="text" id="judge_rights" value="<%=judge_rights%>" size="20" maxlength="20" readonly="readonly">
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
							<input name="trade_kind" type="text" id="trade_kind" value="<%=trade_kind%>" size="15" maxlength="12">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							cancel_tag:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="cancel_tag" type="text" id="cancel_tag"  value="<%=cancel_tag%>"size="30" maxlength="100" >
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
							<input name="transe_type" type="text" id="transe_type" value="<%=transe_type%>" size="30" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							succeed_fwd:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="succeed_fwd" type="text" id="succeed_fwd" value="<%=succeed_fwd%>" size="20" maxlength="100">
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
							<input name="error_fwd" type="text" id="error_fwd" value="<%=error_fwd%>" size="15" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							enable_tag：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="enable_tag" type="text" id="enable_tag" value="<%=enable_tag%>" size="20" maxlength="1">
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
							<input name="start_date" type="text" id="start_date" size="30" maxlength="100" onfocus="setday(this);" value="<%=start_date%>">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							end_date:
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="end_date" type="text" id="end_date"  size="30" maxlength="100" onfocus="setday(this);" value="<%=end_date%>">
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
							<input name="rsrv_str1_a" type="text" id="rsrv_str1" value="<%=rsrv_str11%>" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str2：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str2_a" type="text" id="rsrv_str2" value="<%=rsrv_str12%>" size="20" maxlength="100">
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
							<input name="rsrv_str3_a" type="text" id="rsrv_str3" value="<%=rsrv_str13%>" size="20" maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str4：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str4_a" type="text" id="rsrv_str4" value="<%=rsrv_str14%>" size="30" maxlength="100">
							
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
							<input name="rsrv_str5_a" type="text" id="rsrv_str5" value="<%=rsrv_str15%>" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str6：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str6_a" type="text" id="rsrv_str6" value="<%=rsrv_str16%>" size="10" maxlength="1">
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
							<input name="rsrv_str7_a" type="text" id="rsrv_str7" value="<%=rsrv_str17%>" size="10" maxlength="1">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str8：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str8_a" type="text" id="rsrv_str8" value="<%=rsrv_str18%>" size="10" maxlength="1">
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
							<input name="rsrv_str9_a" type="text" id="rsrv_str9" value="<%=rsrv_str19%>" size="10" maxlength="100">
						</div>
					</td>
					<td bgcolor="#efefef">
						<div style="text-align:right; font-weight:bold;">
							rsrv_str0：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="rsrv_str0_a" type="text" id="rsrv_str0" value="<%=rsrv_str10%>" size="30" maxlength="100">
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
							<input name="in_date" type="text" id="in_date" value="<%=in_date1%>"  maxlength="100">
						</div>
					</td>
					<td bgcolor="#ffffff">
						<div style="text-align:right; font-weight:bold;">
							remark：
						</div>
					</td>
					<td bgcolor="#FFFFFF">
						<div class="ping1">
							<input name="remark_a" type="text" id="remark_a" value="<%=remark1%>" size="30" maxlength="30">
						</div>
					</td>
				</tr>	
		
				<tr>
					<td bgcolor="#FFFFFF" align="center" height="50" colspan="4">
					   <input name="in_staff_id" type="hidden" id="in_staff_id" value="">
						<input name="trade_type_code" type="hidden" id="trade_type_code" value="8899">
						<img src="/admin/images/submit_0.gif" onclick="return checkNodeClass()" style="cursor: hand;">
						<img src="/admin/images/submit_1.gif" onClick="location.href='modelIndex.jsp'" style="cursor:hand;" align="absmiddle">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>



