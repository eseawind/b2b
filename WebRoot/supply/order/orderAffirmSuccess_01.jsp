<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional/EN"
"http:/www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="com.saas.biz.shoppingcartMgr.*"%>
<%@ page import="com.saas.biz.shoppingorderMgr.ShoppingOrderInfo"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
	String  user_id = "";

	HttpSession logsession = request.getSession();
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}
	
	String sum_money = "";
	if (request.getParameter("sum_money") != null) {
		sum_money = request.getParameter("sum_money");
	} 
	String trade_id = bean.GenTradeId();
	String deliver_type = comm.getSelectItems("111"); 
	String pay_type = comm.getSelectItems("112");
	
	AreaInfo arae = new AreaInfo();
	Map country_Map = new HashMap();
	country_Map = arae.getAreaByParent("5J2mc0X0G85BH");
	
	String trade_ids = "",sale_id = "",discount = "",price = "",cust_id = "",num="";
	String all_trade_id = "",all_sale_id = "",all_discount = "",all_price = "",all_cust_id= "",all_num="";
	ShoppingCartInfo cartinfo = new ShoppingCartInfo();
	ArrayList list = cartinfo.getMerchandiseByCart(user_id);
	if ( list!=null && list.size()>0 ){
		for ( int i=0 ; i<list.size() ; i++ ){
			HashMap map = (HashMap)list.get(i);
			if (map.get("trade_id") != null) {trade_ids = map.get("trade_id").toString();}
			if (map.get("sale_id")!=null){sale_id = map.get("sale_id").toString();}
			if (map.get("discount") != null) {discount = map.get("discount").toString();}
			if (map.get("price") != null) {price = map.get("price").toString();}
			if (map.get("cust_id") != null) {cust_id = map.get("cust_id").toString();
			out.println("------------------------------------------------>"+cust_id);
			
			}
			if (map.get("num") != null) {num = map.get("num").toString();}
			all_trade_id += trade_ids+"|";
			all_sale_id += sale_id+"|";
			all_discount +=discount+"|";
			all_price +=price+"|";
			all_cust_id += cust_id+"|";
			all_num += num+"|";
		}
	}
	ShoppingOrderInfo orderinfo = new ShoppingOrderInfo();
	ArrayList orderlist = orderinfo.getOrderInfoByUser(user_id);
%>
<html>
	<head>
		<title>安徽制造业信息化商务平台(http://www.huipoo.com)</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="/zone_b2b/css/b2c.css" rel="stylesheet" type="text/css" />
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AreaInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<link href="/style/login.css" rel="stylesheet" type="text/css">
		<link href="/style/css_layout.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/js/newRreg.js"></script>
		<script type="text/javascript">
			function paySelect(st){
			   if(st!=''){
				    if(st == 1){
				    	document.getElementById('carriage_pay').value = '15.0';
				    	document.getElementById('carriage_pay_p').innerHTML = '运费:15.0元';
				    }else if(st == 2){
				    	document.getElementById('carriage_pay').value = '6.0';
				    	document.getElementById('carriage_pay_p').innerHTML = '运费:6.0元';
				    }else if(st == 3){
				    	document.getElementById('carriage_pay').value = '25.0';
				    	document.getElementById('carriage_pay_p').innerHTML="运费:25.0元";
				    }
			  	}
			}
			function chickNone(){
				if (document.getElementById('consignee').value == '' || document.getElementById('consignee').value == null){
					alert ('收货人不能为空!');
					return false;
				}
				if (document.getElementById('addr').value == '' || document.getElementById('addr').value == null){
					alert ('收货地址不能为空!');
					return false;
				}
				if (document.getElementById('post_code').value == '' || document.getElementById('post_code').value == null){
					alert ('邮编不能为空!');
					return false;
				}
				if (document.getElementById('phone').value == '' || document.getElementById('phone').value == null){
					alert ('电话不能为空!');
					return false;
				}
				
				return true;
			}
		</script>
	</head>
	<body>
		<jsp:include flush="true" page="/supply/order/top.jsp"></jsp:include>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="38">&nbsp;首页 &gt; 购物车管理 &gt; 我的购物车</td>
          </tr>
        </table>
		<table width="980" border="0" align="center" cellpadding="0" cellspacing="0" height="37">
          <tr>
            <td class="gw_dh" valign="top"><table width="980" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="28" width="115" align="center"><span style=" font-size:14px; font-weight:bold; color:#fff;">购物车(1)</span></td>
                  <td width="180" align="center"><span style=" font-size:14px; font-weight:bold;">收藏夹</span>（商品0/店铺0）</td>
                  <td width="180" align="center"><span style=" font-size:14px; font-weight:bold;">订单</span>（未付款/待确认）</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
            </table></td>
          </tr>
        </table>
		<table cellspacing="0" cellpadding="0" width="980" align="center"
			border="0">
			<tr>
				<td valign="top">
					<table cellspacing="0" cellpadding="0" width="100%" border="0">
						<tr>
							<td valign="top"><table cellspacing="1" cellpadding="0" width="100%" border="0">
                              <tr>
                                <td valign="bottom" width="195" height="50"><img height="33" alt="" width="195" src="/images/car_img2_01_0.gif" /></td>
                                <td valign="bottom" align="left" width="195"><img height="33" alt="" width="195" src="/images/car_img_02.gif" /></td>
                                <td valign="bottom" align="left" width="195"><img height="33" alt="" width="195" src="/images/car_img_03.gif" /></td>
                                <td valign="bottom" align="left" width="195"><img height="33" alt="" width="195" src="/images/car_img_04_0.gif" /></td>
                                <td valign="bottom"><img height="33" alt="" width="195" src="/images/car_img_05_01.gif" /></td>
                              </tr>
                            </table>
							  <br />
							  <table width="980" border="0" cellspacing="0" cellpadding="0">
									  <tr>
										<td width="6"><img height="36" alt="" width="6" src="/images/dd_07.gif" /></td>
										<td background="/images/dd_08.gif">&nbsp;<span style="font-size:14px; color:#545454; font-weight:bold;">买家信息提交成功提示！</span></td>
										<td width="6"><img height="36" alt="" width="6" src="/images/dd_10.gif" /></td>
									  </tr>
									</table>
								<table cellspacing="1" cellpadding="0" width="100%" border="0" bgcolor="#EFEFEF">
									<tr>
										<td valign="top" bgcolor="#FFFFFF">
											
											<table cellspacing="0" cellpadding="0" width="100%" border="0">
												<tr>
													<td align="center">
													<div style="width:740px; padding:15px; border:1px dashed #ccc; margin:10px; font-size:14px; color:#FF7800;">
													      你的定单已经提交成功!!!
													</div>
													<div style="width:760px; padding-left:10px; padding-top:20px; height:18px; border-bottom:1px dashed #ccc; text-align:left;font-size:14px; color:#545454; font-weight:bold;">
													      请按照选定的方式付款!
													</div>
													<div style="width:760px; padding-top:20px;padding-bottom:20px; height:18px; border-bottom:1px dashed #ccc; text-align:left;font-size:14px; color:#545454; font-weight:bold; text-align:center;">
													    <img src="/images/zfb.gif" alt="" align="absmiddle" />&nbsp;&nbsp;<img src="/images/wangy.gif" alt="" align="absmiddle" />&nbsp;&nbsp;<img src="/images/hdao.gif"  alt="" align="absmiddle" />&nbsp;&nbsp;<img src="/images/wangy.gif"  alt="" align="absmiddle" /></div>
														<div style="width:760px;height:36px; text-align:right;"><img src="/images/return.gif" alt="" align="absmiddle" /></div>
														</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<br />
						  </td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	<jsp:include flush="true" page="/supply/order/footer.jsp"></jsp:include>
</html>



