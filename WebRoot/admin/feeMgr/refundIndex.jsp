<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<html>
	<head>
		<title>会员退费</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style type="text/css">
		.ping_1{
		 font-weight: bold;color: black;
		}
		#tr{
		 background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;text-align: center;
		}
		#tr1{
		 background-color:#f6f6f6; color:#000000; font-size:12px;
		}
		#tr2{
		 background-color:#ffffff; color:#000000; font-size:12px;
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
		    var value_num=$F("value_num");
		    var sum=$F("sum");
		    if(value_num=="" || value_num==null){
		      alert("请输入退还金额！");
		      $("value_num").focus();
		      return false;
		    }
		    if(parseFloat(value_num)>parseFloat(sum)){
		      alert("退还金额有误！请认真计算退还金额");
		      $("value_num").focus();
		     return false;
		    }
		    return true;
		  }
		  function chechCustName() {
			var data = Math.round(Math.random() * 10000);

			var name=$F('cust_name');
			 if(name =="" || name==null){
		      alert("请输入公司名称！");
		      $("cust_name").focus();
		      return false;
		    }else{
		    $("cust-div").innerHTML="<img src=\"/images/wait.gif\" border=\"0\"><font size=\"3\">正在返回数据............</font>";
			   var myAjax = new Ajax.Updater('cust-div', 
					'refundList.jsp?cust_name=' + name + '&data=' + data, 
					{
						method:'get',
						evalScripts: true
					}
					);
					return true;
		   }
		}
		function setCustId(id){
		var data = Math.round(Math.random() * 10000);
		  $("obj_cust_id").value=id;
		   var myAjax = new Ajax.Updater('sever-div', 
			'useSever.jsp?cust_id=' + id + "&data=" + data, 
			{
				method : 'get',
				evalScripts: true
			});
		}
		</script>
	</head>
	<%
	 String refund_type=bean.getSelectItems("13");
	  String account_id=comm.GenTradeId();
	%>
	<body>
	<form name="serverForm" id="serverForm" action=/doTradeReg.do method=post target="_self">
	
										<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center"> 
											<tr>
												<td>
													<table width=100% border=0 cellpadding=1 cellspacing=1 align=center bgcolor="#FCB0B0">
														<tr>
															<td class="u1" width="15%">
																退费类型：
															</td>
															<td class="u2" width="85%">
																<div class="ping1">
																<select id="reg_type" name=reg_type>
																   <%=refund_type%>
																</select>
																</div>
															</td>
														</tr>
														<tr>
															<td class="u1" width="15%">
																公司名称：
															</td>
															<td class="u2" width="85%">
																<div class="ping1">
																	<input type="text" name="cust_name" id="cust_name" maxlength="100" title="请输入缴费公司名称。">&nbsp;<input type="button" name="bnt" id="bnt" value="" style="background-image: url('/admin/images/chaxun.gif');width:49px;height: 22px;border:0;cursor:hand;text-align:center;" onclick="chechCustName()"><span style="margin-bottom:2px;color:red;">(检测公司名是否正确)</span>
																</div>
															</td>
														</tr>
																<div id="cust-div"></div>
															  <div id="sever-div"> </div>
														<tr>
															<td class="u1" width="15%">
																退还金额：
															</td>
															<td class="u2" width="85%">
																<div class="ping1">
																 <input type="text" name="value_num" id="value_num" size="10" maxlength="15" style="height: 12px" onkeyup="if(isNaN(this.value))this.value=''">
																</div>
															</td>
														</tr>
														<tr>
															<td class="u3" colspan="2">
																<input class="tjan" name="submit" type="submit" value="" onclick="return check_Value()">
															</td>
														</tr>
														<input type="hidden" id="account_id" name="account_id" value="<%=account_id%>">
														<input type="hidden" id="obj_cust_id" name="obj_cust_id">
														<input type="hidden" id="trade_type_code" name="trade_type_code" value="1187">
													</table>
												</td>
											</tr>
										</table>

	</form>
	</body>
</html>




