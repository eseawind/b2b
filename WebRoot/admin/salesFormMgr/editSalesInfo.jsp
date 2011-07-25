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
<jsp:useBean id="orderBean" class="com.saas.biz.salesOrderFormMgr.SalesOrderFormInfo" scope="page" />
<%

	Calendar cal = Calendar.getInstance();
	String start_Date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String cust_id="",quo_id="",menu_idx="";
	HttpSession  logsession = request.getSession(); 
	if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    if (request.getParameter("menu_id") != null)
    {
        menu_idx = request.getParameter("menu_id");
    }
    if (request.getParameter("id") != null)
    {
        quo_id = request.getParameter("id");
    }
    HashMap map=orderBean.getSaleOrderById(cust_id,quo_id);
    String currency_code="",ship_type="",quo_code="",form_id="",
    quo_name="",obj_cust_name="",obj_cust_id="",sale_obj_id="",sale_obj_name="",
    sale_user_id="",sale_user_name="",own_user_name="",own_user_id="",contact_man="",
    order_count="",contact="",give_addr="",delivery_num="",ship_fee="",tax="",remark2="",
    all_fee="",off_count="",off_rate="";
    if(map !=null && map.size()>0){
         if(map.get("currency_code")!=null){
          currency_code=map.get("currency_code").toString();
          currency_code=bean.getItemsBySelected("62",currency_code);
         }
         if(map.get("ship_type")!=null){
          ship_type=map.get("ship_type").toString();
          ship_type=bean.getItemsBySelected("63",ship_type);
         }
         if(map.get("quo_code")!=null){quo_code=map.get("quo_code").toString();}
         if(map.get("form_id")!=null){form_id=map.get("form_id").toString();}
         if(map.get("quo_name")!=null){quo_name=map.get("quo_name").toString();}
         if(map.get("obj_cust_id")!=null){obj_cust_id=map.get("obj_cust_id").toString();}
         if(map.get("rsrv_str3")!=null){obj_cust_name=map.get("rsrv_str3").toString();}
         if(map.get("rsrv_str4")!=null){sale_obj_name=map.get("rsrv_str4").toString();}
         if(map.get("rsrv_str5")!=null){sale_user_name=map.get("rsrv_str5").toString();}
         if(map.get("sale_obj_id")!=null){sale_obj_id=map.get("sale_obj_id").toString();}
         if(map.get("sale_user_id")!=null){sale_user_id=map.get("sale_user_id").toString();}
         if(map.get("own_user_id")!=null){own_user_id=map.get("own_user_id").toString();}
         if(map.get("rsrv_str6")!=null){own_user_name=map.get("rsrv_str6").toString();}
         if(map.get("contact_man")!=null){contact_man=map.get("contact_man").toString();}
         if(map.get("order_count")!=null){order_count=map.get("order_count").toString();}
         if(map.get("contact")!=null){contact=map.get("contact").toString();}
         if(map.get("give_date")!=null){start_Date=map.get("give_date").toString();
           if(start_Date.length()>10){start_Date=start_Date.substring(0,10);}
         }
         if(map.get("give_addr")!=null){give_addr=map.get("give_addr").toString();}
         if(map.get("delivery_num")!=null){delivery_num=map.get("delivery_num").toString();}
         if(map.get("ship_fee")!=null){ship_fee=map.get("ship_fee").toString();}
         if(map.get("tax")!=null){tax=map.get("tax").toString();}
         if(map.get("remark2")!=null){remark2=map.get("remark2").toString();}
         if(map.get("all_fee")!=null){all_fee=map.get("all_fee").toString();}
         if(map.get("off_count")!=null){off_count=map.get("off_count").toString();}
         if(map.get("off_rate")!=null){off_rate=map.get("off_rate").toString();}
    }
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
		</style>
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../ext/ext-all.js"></script>
		<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="/js/prototype.js"></script>
		<script language="javascript" src="/js/Calendar_Ly.js"></script>
		<script type="text/javascript" src="customer.js"></script>
		<script type="text/javascript" src="contact.js"></script>
		<script type="text/javascript" src="userGird.js"></script>
		<script language="JavaScript">
		function confirmsub(){
		   if(document.getElementById("quo_name").value=="" ||document.getElementById("quo_name").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填写销售单名称！");
		     return false;
		   }
		   if(document.getElementById("obj_cust_name").value=="" ||document.getElementById("obj_cust_name").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填选择销售客户名称！");
		     return false;
		   }
		   if(document.getElementById("sale_obj_name").value=="" || document.getElementById("sale_obj_name").value==null){
		     Ext.MessageBox.alert("bizoss 提示","销售物品名称不能为空！");
		     return false;
		   }
		   if(document.getElementById("sale_user_name").value=="" || document.getElementById("sale_user_name").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填选择销售人员！");
		     return false;
		   }
		   if(document.getElementById("contact_man").value=="" ||document.getElementById("contact_man").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填选择联系人！");
		     return false;
		   }
		   if(document.getElementById("contact").value=="" ||document.getElementById("contact").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填写联系方式！");
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
        </script>
	</head>
	<body>
		<form name=resumeForm action=/doTradeReg.do method=post target="_self">
			<table width="727" border="0" cellspacing="0" cellpadding="0">
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
										<input type="text" name="quo_name" id="quo_name" size="25" maxlength="100" value="<%=quo_name%>">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									销售客户：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
									    <input type="text" name="obj_cust_name" id="obj_cust_name" size="15" maxlength="100" value="<%=obj_cust_name%>" readonly><input type="button" name="bnt" id="bnt" value="选择" onclick="showWindow()"><div id="grid3"></div>
										<input type="hidden" name="obj_cust_id" id="obj_cust_id" size="25" maxlength="100" value="<%=obj_cust_id%>">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									物品名称：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
									    <input type="text" name="sale_obj_name" id="sale_obj_name" maxlength="100" size="15" value="<%=sale_obj_name%>">
										<input type="hidden" name="sale_obj_id" id="sale_obj_id" maxlength="100" size="15"  value="<%=sale_obj_id%>">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									销售人员：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
									    <input type="text" name="sale_user_name" id="sale_user_name" size="15" value="<%=sale_user_name%>" maxlength="100" readonly><input type="button" name="ubnt" value="选择" onclick="showUserWind()"><div id="grid5"></div>
										<input type="hidden" name="sale_user_id" id="sale_user_id" size="25" value="<%=sale_user_id%>" maxlength="100">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									归属人：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
									    <input type="text" name="own_user_name" id="own_user_name" size="15" value="<%=own_user_name%>" maxlength="100">
										<input type="hidden" name="own_user_id" id="own_user_id" size="25" value="<%=own_user_id%>" maxlength="100">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									联系人：
								</td>
								<td align=left bgcolor="#FFFFFF" >
									<div class="ping">
										<input type="text" name="contact_man" id="contact_man" value="<%=contact_man%>" maxlength="100" size="15"><input type="button" name="cnt" value="选择" onclick="showContactWind()"><div id="grid4"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									联系方式：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping">
										<input type="text" name="contact" id="contact" value="<%=contact%>" maxlength="100" size="25">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									订购数量：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="order_count"  id="order_count" value="<%=order_count%>">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									交货日期：
								</td>
								<td align=left bgcolor="#FFFFFF">
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
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="give_addr" type="text" id="give_addr" size=35 maxlength=100 value="<%=give_addr%>">
										
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									部分交货：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<select name="part_delivery_tag"  id="part_delivery_tag">
										 <option value="0">是</option>
										 <option value="1">否</option>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									已交货的数量：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="delivery_num" id="delivery_num" size="15" type="text"  value="<%=delivery_num%>" onkeyup="if(isNaN(value))execCommand('undo')">(默认为0)
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
							</tr>
							<tr>
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
										<input name="ship_fee"  id="ship_fee" size="10" value="<%=ship_fee%>" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									税收：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name=tax id="tax" type="text" size="10" value="<%=tax%>" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									折扣率：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="off_rate" id="off_rate" type="text"size="5" value="<%=off_rate%>" onkeyup="if(isNaN(value))execCommand('undo')">(按百分比计算)
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									折扣前总计：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="off_count" id="off_count" type="text" value="<%=off_count%>" size="10" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									总计：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="all_fee" id="all_fee" value="<%=all_fee%>" type="text" size="10" onkeyup="if(isNaN(value))execCommand('undo')">
									</div>
								</td>
							</tr>
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;" align=right>
									备注：
								</td>
								<td align=left bgcolor="#FFFFFF">
									<div class="ping1">
										<input name="remark2" id="remark2" value="<%=remark2%>" size="52" maxlength="50" >
									</div>
								</td>
							</tr>
							<input name="trade_type_code" type="hidden" value="1095">
							<input name="form_id" type="hidden" value="<%=form_id%>">
							<input name="quo_id" type="hidden" value="<%=quo_id%>">
							<input name="quo_code" type="hidden" value="<%=quo_code%>">
							<tr>
								<td style="background-color:#f6f6f6; color:#000000;  font-weight:bold; font-size:12px;padding-top:10px;padding-bottom:10px;" align="center" colspan=2>
									<input name="comit" type="submit" value="" onclick="return confirmsub()" style="background-image: url('/images/xg.gif');width:70px;height: 26px;border:0;cursor:hand">
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





