<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.feeSetMgr.*"%>
<%
		String trade_id = "";
		if (request.getParameter("trade_id") != null)
		{
			trade_id = request.getParameter("trade_id");
		}
		FeeSetInfo feeset = new FeeSetInfo();
		ArrayList feeList = new ArrayList();
		feeList = feeset.GetOneById(trade_id);
		String level_id="",limit_time="",fee="";
		if(null!=feeList){
			HashMap feeMap = (HashMap)feeList.get(0);
			if(feeMap.get("level_id")!=null){
				level_id = feeMap.get("level_id").toString();
			}
			if(feeMap.get("fee")!=null){
				fee = feeMap.get("fee").toString();
			}
			if(feeMap.get("limit_time")!=null){
				limit_time = feeMap.get("limit_time").toString();
			}
		}
		int timelength = limit_time.length();
		int t = 0;
		String time = "";//limit_time.substring(0,timelength-1);
		for(int j=0;j<timelength;j++){
			if(limit_time.charAt(j)>='0' && limit_time.charAt(j)<='9'){
				time = time + limit_time.charAt(j);
				t++;
			}
		}
		String timeD=limit_time.substring(t,timelength);
		ParamethodMgr paramCom = new ParamethodMgr();
		String customer_class = paramCom.getSelectItems("14");
		ArrayList list = new ArrayList();
		list = paramCom.getCompareInfoByAttr("14");
		ArrayList listTime = new ArrayList();
		listTime = paramCom.getCompareInfoByAttr("126");
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<script>
			function formSub(){
				var ip = '';
				var bool = 0;
			　var rPort = document.getElementsByName("level_id_T");
		　　for(i=0;i<rPort.length;i++)
		　　{
		    　　 if(rPort[i].checked)
		       　　ip=rPort[i].value;
		　　}
				document.getElementById("level_id").value = ip;
				
				var limit = document.getElementById("limit_time1").value;
				var time = '';
			　var rPortT = document.getElementsByName("time");
		　　for(i=0;i<rPortT.length;i++)
		　　{
		    　　 if(rPortT[i].checked){
		      		 time=rPortT[i].value;
		      		 bool = 1;
		      		}
		　　}
				if(time==2){
						limit = limit+"个月";
					}
				if(time==3){
						limit = limit+"个季度";
					}
				if(time==4){
						limit = limit+"年";
					}
				if(time==1){
					limit = limit+"天";
				}
				document.getElementById("limit_time").value = limit;
				if(document.getElementById("level_id").value == '' || document.getElementById("level_id").value == null)
				{                                                                                         
					alert("请选择客户级别！");                                            
					return false;                                                                            
				}
				if(document.getElementById("fee").value=="" || document.getElementById("fee")==null){
					alert("所缴费用不可以为空！");                                                             
					document.resumeForm.fee.focus();                                                    
					return false;          
				}
				if(document.getElementById("limit_time1").value=="" || document.getElementById("limit_time1")==null){
					alert("时间不可以为空！");                                                             
					document.resumeForm.limit_time1.focus();                                                    
					return false;          
				}
				if(bool==0){
					alert("请选择时间单位！");                                                
					return false;          
				}
				
				//document.getElementById("limit_time").value = limit;
			}
		</script>
	</head>
	<body>
			<form name=resumeForm action="/doTradeReg.do" method="post"	target="_self">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr class="u1">
				<td colspan=3 align="left" class="head">
					<a href=ViewSetFee.jsp><b>查看费用设置</b></a>
				</td>
			</tr>
		</table>
		<table width=100% border=0 cellpadding=0 cellspacing=1 align=center bgcolor="#dddddd">
				<tr>
					<td class="u1" width="15%">
						客户级别：
					</td>
					<td class="u2" colspan="3">
						<%
							if(null!=list){
							String para_code1="",para_code2="";
								for(int i=0;i<list.size();i++){
									HashMap map = (HashMap)list.get(i);
									if(map.get("para_code1")!=null){
										para_code1 = map.get("para_code1").toString();
									}
									if(map.get("para_code2")!=null){
										para_code2 = map.get("para_code2").toString();
									}
									if(level_id.equals(para_code1)){
						%>
						<input type="radio" name="level_id_T" id="level_id_T" checked value="<%=para_code1%>"><%=para_code2%>
						<%}else{%>
						<input type="radio" name="level_id_T" id="level_id_T" value="<%=para_code1%>"><%=para_code2%>
						<%}
						}
						}%>
							<!--select name="level_id" id="level_id">
							    <option value="0">请选择...</option>
								<%=customer_class%>
							</select-->
					</td>
				</tr>
				<tr>
					<td class="u1" width="15%">
						时间：
					</td>
					<td class="u2" >
						<input type="text" id="limit_time1" name="limit_time1"  value="<%=time%>" onkeyup="if(isNaN(value))execCommand('undo')">
							<%
							if(null!=listTime){
							String para1="",para2="";
								for(int i=0;i<listTime.size();i++){
									HashMap mapT = (HashMap)listTime.get(i);
									if(mapT.get("para_code1")!=null){
										para1 = mapT.get("para_code1").toString();
									}
									if(mapT.get("para_code2")!=null){
										para2 = mapT.get("para_code2").toString();
									}
									if(timeD.indexOf(para2)!=-1){
						%>
						<input type="radio" name="time" id="time" checked value="<%=para1%>"><%=para2%>
						<%}else{%>
						<input type="radio" name="time" id="time" value="<%=para1%>"><%=para2%>
						<%}
						}
						}%>
					</td>
					
					<td class="u1" width="15%">
						所缴费用：
					</td>
					<td class="u2" >
						<input type="text" id="fee" name="fee" value="<%=fee%>" onkeyup="if(isNaN(value))execCommand('undo')">
					</td>
				</tr>
				<input type="hidden" id="trade_id" name="trade_id" value="<%=trade_id%>">
				<input type="hidden" id="trade_type_code" name="trade_type_code" value="0244">
				<input type="hidden" id="limit_time" name="limit_time">
				<input type="hidden" name="level_id" id="level_id" value="">
				<tr>
					<td colspan=4 class="u3">
						<input class="tjan" name="submit1" type="submit" value=""	onclick="return formSub()">
					</td>
				</tr>
			</table>
			</form>
	</body>
</html>



