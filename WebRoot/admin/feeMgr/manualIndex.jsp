<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<html>
	<head>
		<title>人工缴费</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style type="text/css">
		.ping_1{
		 color: #003399;
		}
		</style>
		<script type="text/javascript" src="/js/prototype.js"></script>
		
		<script type="text/javascript">
		  function check_Value(){
		    var cust_name=$F("cust_name");
		    if(cust_name =="" || cust_name==null){
		      alert("请输入客户名称！");
		      $("cust_name").focus();
		      return false;
		    }
		    var id=$F("obj_cust_id");
		    if(id=="" || id==null){
		      alert("请输入客户不存在或输入有误！\n请重新输入正确的客户名！");
		      $("cust_name").focus();
		       return false;
		    }
		     getCheckBox();
		    var value_num=$F("value_num");
		    if(value_num<1){
		      alert("请输选择要订购的服务名称！");
		      return false;
		    }
		    return true;
		  }
		  function chechCustName() {
			var data = Math.round(Math.random() * 10000);
			var name=$F('cust_name');
			 if(name =="" || name==null){
		      alert("请输入客户名称！");
		      $("cust_name").focus();
		      return false;
		    }else{
			   var myAjax = new Ajax.Updater('cust-div', 
					'serverList.jsp?cust_name=' + name + "&data=" + data, 
					{
						method : 'get',
						evalScripts: true
					});
		   }
		}
		function setCustId(id){
		  $("obj_cust_id").value=id;
		}
		//判断客户订购的服务类型
		function setServerInfo(s_name,s_value){
		 if($(s_name).checked){
		   $(s_value).focus();
		 }else{
		   var num=$F(s_value);
		   if(num!="" && num !=null){
		   var sum=parseFloat(parseFloat($F("value_num"))-parseFloat(num)*50);
		   $("value_num").value=sum;
		   }
		   $(s_value).value="";
		 }
		}
		function setSumServer(s_name,s_value){
		  if($(s_name).checked){
		   var num=$F(s_value);
		   if(num !="" && num!=null){
		    var sum=parseFloat(parseFloat($F("value_num"))+parseFloat(num)*50);
		    $("value_num").value=sum;
		   }else{
		     alert("请输入服务期限！");
		     $(s_name).checked=false;
		   }
		 }else{
		  var val=$F(s_value);
		  if(val>0){
		    alert("是否要订购服务，如果要订购服务请先选择服务名称！");
		  }else{
		   val=0;
		   var sum=parseFloat(parseFloat($F("value_num"))-parseFloat(val*50));
		   $("value_num").value=sum;
		  }
		 }
		}
		function getCheckBox(){
			
		  var value_id="";//存放服务名称和期限 oa&5#50|
		  var chkbox = document.getElementsByName('sev');
	      var size=chkbox.length;
	      for(var i=0;i<size;i++){
	        var obj=chkbox[i];
	        if(obj.checked){
	          var id=obj.id;
	          var val="f_"+id;
	          var month=parseFloat(parseFloat($F(val))*parseFloat(obj.value));
	          value_id=value_id+id+"&"+month+"|";
	        }
	      }
	      $("value_id").value=value_id;
	      return true;
         }
		</script>
	</head>
	<%
	 String account_id=comm.GenTradeId();
	%>
	<body>
	<form name="serverForm" id="serverForm" action=/doTradeReg.do method=post target="_self">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
											<tr>
												<td>
													<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#DEEDFD">
														<tr>
															<td class="u1" width="15%">
																客户名称：
															</td>
															<td class="u2" width="85%">
																<div class="ping1">
																	<input type="text" name="cust_name" id="cust_name" maxlength="100" title="请输入缴费客户名称。">&nbsp;<input type="button" name="bnt" id="bnt" value="" onclick="chechCustName()"  style="background-image: url('/admin/images/chaxun.gif');width:49px;height: 22px;border:0;cursor:hand;text-align:center;"><span style="margin-bottom:2px;color:red;">(检测客户名是否正确)</span>
																</div>
																<div id="cust-div"></div>
															</td>
														</tr>
														
														<tr>
															<td class="u1" width="15%">
																服务名称：
															</td>
															<td class="u2" width="85%">
																<div class="ping1">
																	<table width=100% border=0 cellpadding=2 cellspacing=1 align=center>
																		<tr>
																			<td class="u5"><div class="ping_1">
																					〖电子商务〗<input type="checkbox" name="sev" id="b2b" value="3" onclick="setServerInfo('b2b','f_b2b')">订购<input type="text" name="f_b2b" id="f_b2b" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('b2b','f_b2b')">季度(50￥/季度)
																				</div>
																			</td>
																			<td  class="u5"><div class="ping_1">
																				    〖行政〗<input type="checkbox" name="sev" id="oa" value="3" onclick="setServerInfo('oa','f_oa')">订购<input type="text" size="3" name="f_oa" id="f_oa" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('oa','f_oa')">季度(50￥/季度)
																				</div>
																			</td>
																		</tr>
																		<tr>
																		  <td class="u5"><div class="ping_1">
																					〖客户〗<input type="checkbox" name="sev" id="crm" value="3" onclick="setServerInfo('crm','f_crm')">订购<input type="text" name="f_crm" id="f_crm" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('crm','f_crm')">季度(50￥/季度)
																				</div>
																			</td>
																			<td class="u5"><div class="ping_1">
																					〖库存〗<input type="checkbox" name="sev" id="mrp" value="12" onclick="setServerInfo('mrp','f_mrp')">订购<input type="text" name="f_mrp" id="f_mrp" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('mrp','f_mrp')">年(50￥/年)
																				</div>
																			</td>
																		</tr>
																		<tr>
																		  <td class="u5"><div class="ping_1">
																					〖销售〗<input type="checkbox" name="sev" id="sale" value="12" onclick="setServerInfo('sale','f_sale')">订购<input type="text" name="f_sale" id="f_sale" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('sale','f_sale')">年(50￥/年)
																				</div>
																			</td>
																			<td class="u5"><div class="ping_1">
																					〖采购〗<input type="checkbox" name="sev" id="buy" value="12" onclick="setServerInfo('buy','f_buy')">订购<input type="text" name="f_buy" id="f_buy" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('buy','f_buy')">年(50￥/年)
																				</div>
																			</td>
																		</tr>
																		<tr>
																		  <td class="u5"><div class="ping_1">
																					〖计划〗<input type="checkbox" name="sev" id="proj" value="12" onclick="setServerInfo('proj','f_proj')">订购<input type="text" name="f_proj" id="f_proj" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('proj','f_proj')">年(50￥/年)
																				</div>
																			</td>
																			<td class="u5"><div class="ping_1">
																					〖订单〗<input type="checkbox" name="sev" id="form" value="12" onclick="setServerInfo('form','f_form')">订购<input type="text" name="f_form" id="f_form" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('form','f_form')">年(50￥/年)
																				</div>
																			</td>
																		</tr>
																		<tr>
																		  <td class="u5"><div class="ping_1">
																					〖产品〗<input type="checkbox" name="sev" id="prod" value="12" onclick="setServerInfo('prod','f_prod')">订购<input type="text" name="f_prod" id="f_prod" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('prod','f_prod')">年(50￥/年)
																				</div>
																			</td>
																			<td class="u5"><div class="ping_1">
																					〖运输〗<input type="checkbox" name="sev" id="trans" value="12" onclick="setServerInfo('trans','f_trans')">订购<input type="text" name="f_trans" id="f_trans" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('trans','f_trans')">年(50￥/年)
																				</div>
																			</td>
																		</tr>
																		<tr>
																		  <td class="u5"><div class="ping_1">
																					〖合同〗<input type="checkbox" name="sev" id="cont" value="12" onclick="setServerInfo('cont','f_cont')">订购<input type="text" name="f_cont" id="f_cont" size="3" maxlength="2" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''" onblur="setSumServer('cont','f_cont')">年(50￥/年)
																				</div>
																			</td>
																			<td class="u5"><div class="ping_1">服务费用：<input type="text" name="value_num" id="value_num" size="15" maxlength="20" value="0" style="height: 12px" readonly></div>
																			</td>
																		</tr>
																	</table>
																</div>
															</td>
														</tr>
														<tr>
															<td class="u3"  colspan="2">
																<input class="tjan" name="submit" type="submit" value="" onclick="return check_Value()">
															</td>
														</tr>
														<input type="hidden" id="obj_cust_id" name="obj_cust_id">
														<input type="hidden" id="value_id" name="value_id">
														<input type="hidden" id="account_id" name="account_id" value="<%=account_id%>">
														<input type="hidden" id="trade_type_code" name="trade_type_code" value="1185">
													</table>
												</td>
											</tr>
										</table>
	</form>
	</body>
</html>




