<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="bean" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<jsp:useBean id="formBean" class="com.saas.biz.templateFormMgr.TempFormInfo" scope="page" />
<%

	Calendar cal = Calendar.getInstance();
	String defaultIdx=comm.GenTradeId();
	String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String currency_code=bean.getSelectItems("62");
	String ship_type=bean.getSelectItems("63");
	String quo_code=comm.GenTradeId();
	String quo_id=comm.GenTradeId();
	String selectStr="",cust_id="";
	HttpSession  logsession = request.getSession(); 
	if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    } 
    selectStr=formBean.getTemplateSelect(cust_id,"2");
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<link href="/style/daohang.css" rel="stylesheet" type="text/css">
		<link href="/style/css.css" rel="stylesheet" type="text/css">
		<link href="/style/manager.css" rel="stylesheet" type="text/css">
		<style type="text/css" media="screen">
		form {padding:0px; margin:0px;}
		.line6 {width:72spx; width:70spx!important;border:#ffcb99 1px solid;  background-color:#fff8ee; text-align:left; padding-left: 20px;padding-top: 10px;padding-bottom: 10px; color:#000000; margin-top:13px; margin-bottom:13px;}   /*横栏样式6---- 头部提醒1*/
		.line6 .img{width:53px; height:53px; float:left; margin-right:20px;}
		.line6 .title {font-size:14px; font-weight:bold; color:#ff5400;}
		.line1 {border-left:#ff7300 3px solid; background-color:#e2e2e2; color:#333333;text-align:left; font-size:12px;}  /*横栏样式1*/
		.user-Img {
		    background-image:url(/images/customer.png) !important;
		}
		.cust-Img {
		    background-image:url(/images/home.png) !important;
		}
		</style>
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../ext/ext-all.js"></script>
		<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript"  src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="customer.js"></script>
		<script type="text/javascript" src="contact.js"></script>
		<script type="text/javascript" src="userGird.js"></script>
		<script language="JavaScript">
		function confirmsub(){
		   if(document.getElementById("quo_name").value=="" ||document.getElementById("quo_name").value==null){
		     alert("请填写销售单名称！");
		     return false;
		   }
		   if(document.getElementById("obj_cust_name").value=="" ||document.getElementById("obj_cust_name").value==null){
		     alert("请填选择销售客户名称！");
		     return false;
		   }
		   if(document.getElementById("sale_obj_name").value=="" || document.getElementById("sale_obj_name").value==null){
		     alert("销售物品名称不能为空！");
		     return false;
		   }
		   if(document.getElementById("sale_user_name").value=="" || document.getElementById("sale_user_name").value==null){
		     alert("请填选择销售人员！");
		     return false;
		   }
		   if(document.getElementById("contact_man").value=="" ||document.getElementById("contact_man").value==null){
		     alert("请填选择联系人！");
		     return false;
		   }
		   if(document.getElementById("contact").value=="" ||document.getElementById("contact").value==null){
		     alert("请填写联系方式！");
		     return false;
		   }
		  return true;
		}
		 Ext.onReady(function(){ 
		 Ext.QuickTips.init();
		});
		
		//选择客户列表
		function selectCustomer(){
		  window.open ("customerList.jsp");
		}
		
		//选择联系人列表
		function selectContact(){
		 window.open ("contactList.jsp");
		}
		
		//选择销售人员列表
		function selectSales(){
		 window.open ("userList.jsp");
		}
		//生成自定义订单
		function selectForm(val){
		  if(val!="0"){
		   var quo_id=document.getElementById("quo_id").value;
		   window.open ("addSaleOrder.jsp?form_id="+val+"&quo_id="+quo_id);
		  }
		}
        </script>
        <SCRIPT>WinLIKEerrorpage='/winlike/winman/hlp-error.html';</SCRIPT>
		<SCRIPT SRC="/winlike/winman/wininit.js"></SCRIPT>
		<SCRIPT SRC="/winlike/winman/winman.js"></SCRIPT>
	    <SCRIPT>
	            WinLIKE.definewindows=mydefss;
	            function mydefss() {
	            	var j=new WinLIKE.window('', 100, 100, '90%', 'WinLIKE.browsersize().Height -Top-30', 2);
	            	j.Vis=false;
	            	j.Nam='appwin';
	            	WinLIKE.addwindow(j);
	            };
	    </SCRIPT>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<table width="750" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="2"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width=727 border=0 cellpadding=5 cellspacing=1 align=center bgcolor="#dddddd">
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									销售单名称：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input type="text" name="quo_name" id="quo_name" size="25" maxlength="100">
									</div>
								</td>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									销售客户：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
									    <input type="text" name="obj_cust_name" id="obj_cust_name" size="15" maxlength="100" readonly><input type="button" name="bnt" id="bnt" value="选择" onclick="showWindow()"><div id="grid3"></div>
										<input type="hidden" name="obj_cust_id" id="obj_cust_id" size="25" maxlength="100">
									</div>
								</td>
							</tr>
							
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									物品名称：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
									    <input type="text" name="sale_obj_name" id="sale_obj_name" maxlength="100" size="15">
										<input type="hidden" name="sale_obj_id" id="sale_obj_id" maxlength="100" size="15">
									</div>
								</td>
							
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									销售人员：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
									    <input type="text" name="sale_user_name" id="sale_user_name" size="15" maxlength="100" readonly><input type="button" name="ubnt" value="选择" onclick="showUserWind()"><div id="grid5"></div>
										<input type="hidden" name="sale_user_id" id="sale_user_id" size="25" maxlength="100">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									归属人：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
									    <input type="text" name="own_user_name" id="own_user_name" size="15" maxlength="100">
										<input type="hidden" name="own_user_id" id="own_user_id" size="25" maxlength="100">
									</div>
								</td>
							
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									联系人：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input type="text" name="contact_man" id="contact_man" maxlength="100" size="15"><input type="button" name="cnt" value="选择" onclick="showContactWind()"><div id="grid4"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									联系方式：
								</td>
								<td align=left bgcolor="#FFFFFF" colspan="3">
									<div class="ping">
										<input type="text" name="contact" id="contact" maxlength="100" size="25">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right width="15%">
									订购数量：
								</td>
								<td align=left bgcolor="#FFFFFF"  width="35%">
									<div class="ping1">
										<input name="order_count"  id="order_count">
									</div>
								</td>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right  width="15%">
									交货日期：
								</td>
								<td align=left bgcolor="#FFFFFF"  width="35%">
									<div class="ping1">
										<input name="give_date" type="text" id="give_date" size=10 maxlength=15 value="<%=start_Date%>" onfocus="setday(this);">
										<span style="color:red">(yyyy-MM-dd)</span>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									交货地点：
								</td>
								<td align=left bgcolor="#FFFFFF" colspan="3">
									<div class="ping1">
										<input name="give_addr" type="text" id="give_addr" size=25 maxlength=100>
										
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right width="15%">
									部分交货：
								</td>
								<td align=left bgcolor="#FFFFFF" width="35%">
									<div class="ping1">
										<select name="part_delivery_tag"  id="part_delivery_tag">
										 <option value="0">是</option>
										 <option value="1">否</option>
										</select>
									</div>
								</td>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right width="15%">
									已交货的数量：
								</td>
								<td align=left bgcolor="#FFFFFF" width="35%">
									<div class="ping1">
										<input name="delivery_num" id="delivery_num" size="15" type="text" value="0" onkeyup="if(isNaN(value))execCommand('undo')">(默认为0)
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									货币代码：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<select name="currency_code"  id="currency_code">
										 <%=currency_code%>
										</select>
									</div>
								</td>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									运输方式：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<select name="ship_type"  id="ship_type">
										 <%=ship_type%>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									运费：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="ship_fee"  id="ship_fee" size="10" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
							
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									税收：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name=tax id="tax" type="text" size="10" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									折扣率：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="off_rate" id="off_rate" type="text"size="5" onkeyup="if(isNaN(value))execCommand('undo')">(按百分比计算)
									</div>
								</td>
							
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									折扣前总计：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="off_count" id="off_count" type="text" size="10" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									总计：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="all_fee" id="all_fee" type="text" size="10" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
								<td style="background-color:#f6f6f6; color:#000000;font-weight:bold; font-size:12px;" align="right">
									选择自定义订单：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
                                     <select name="s_form" id="s_form" onchange="selectForm(this.value);">
                                      <option value="0">请选择..</option>
                                       <%=selectStr%>
                                     </select>									
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									备注：
								</td>
								<td align=left bgcolor="#FFFFFF" colspan="3">
									<div class="ping1">
										<input name="remark2" id="remark2" size="52" maxlength="50" >
									</div>
								</td>
							</tr>
							<input name="trade_type_code" type="hidden" value="1093">
							<input name="form_id" type="hidden" value="<%=defaultIdx%>">
							<input name="quo_id" type="hidden" value="<%=quo_id%>">
							<input name="quo_code" type="hidden" value="<%=quo_code%>">
							<input name="state_code" type="hidden" value="0">
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;" align="center" colspan=4>
									<input name="comit" type="submit" value="" onclick="return confirmsub()" style="background-image: url('/images/tj.gif');width:70px;height: 26px;border:0;cursor:hand">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="13"></td>
				</tr>
			</table>
		</form>
	</body>
</html>




