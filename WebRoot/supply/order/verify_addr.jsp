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
			if (map.get("discount") != null) {
				discount = map.get("discount").toString();
				if(discount.indexOf('/')!=-1){
					discount = discount.substring(0,discount.indexOf('/'));
					if(discount.equals("")){
						discount = "0";
					}
				}
			}
			if (map.get("price") != null) {
				price = map.get("price").toString();
				if(price.indexOf('/')!=-1){
					price = price.substring(0,price.indexOf('/'));
					if(price.equals("")){
						price = "0";
					}
				}
			}
			if (map.get("cust_id") != null) {cust_id = map.get("cust_id").toString();		
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
		<title>安徽制造业信息化商务平台</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="/zone_b2b/css/b2c.css" rel="stylesheet" type="text/css" />
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/AreaInfo.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<link href="/style/login.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="/templates/default/style/cn-b2b.css" />
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
		
		
<!--头部-->
<div id="top">
	  <div class="width link_xian">
		<div class="left"><A title=将本站设为你的首页 onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://'+window.location.host);return false;" href="javascript:;">设为首页</a> | <a href=javascript:window.external.AddFavorite(top.location.href)>添加到收藏夹</a></div>
		<div class="right">
		
		 <a href="/member/index.html">登录</a> | <a href="/admin/index.jsp">运营商</a> | <a href="/member/Newcregister.html">免费注册</a> | <a href="/member/mainMenu/default.jsp">发布信息</a></div>
	  </div>
<!--//logo-->
<div id="logo">
		<div class="logo_img" style=" background:url(/templates/default/images/logo.png) no-repeat top center !important; background:none; _filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, sizingMethod=image, src='/templates/default/images/logo.png'">
			<h1>
				<a href="http://www.huipoo.com">
				</a>
			</h1>
		</div>
</div>
<!--logo//-->
	  <div class="nav_search_box">
			<div class="search_list"><span><input type="radio" name="search" checked onclick="tradeType('8855381456')">产品</span> | <span><input type="radio" name="search" onclick="tradeType('7830633062')">供应</span> | <span><input type="radio" name="search" onclick="tradeType('6871426767')">求购</span> | <span><input type="radio" name="search" onclick="tradeType('5563378845')">企业</span> | <span><input type="radio" name="search" onclick="tradeType('1455415210')">新闻</span> | <!--span>more</span--></div>
			<div class="search_box">
			<strong style=" float:left; font-size:14px;">商品搜索</strong> <div class="search_box_bg"><span>
			 <input name="keyword" id="keyword" type="text" style="font-size:14px; width:300px; color:#666; line-height:18px; height:18px;" value="请输入您想查找的关键字"  onclick="this.value=''",size="42" /><input type="submit" name="Submit" value="全站搜索" onClick="Search()" class="search_button"/></span></div> 
		<!--img src="/templates/default/images/king_button.gif" /--> </div>
			<input type="hidden" name="tradeTypecode" id="tradeTypecode" value="8855381456" />
	</div>
</div>

<div id="nav">
  <div class="nav_menu">
    <ul>
      <li id="dis0"><span><a href="/">首页</a></span></li>
      	<li  class="nav_menu_bg"  id="dis12"><span><a href="/default/supply/index.html">供应信息</a></span> |</li>
      	<li id="dis11"><span><a href="/default/stock/index.html">求购信息</a></span> |</li>
      	<li id="dis10"><span><a href="/default/product/index.html">产品库</a></span> |</li>
      	<li id="dis9"><span><a href="/default/enterprise/index.html">企业库</a></span> |</li>
      	<li id="dis8"><span><a href="/default/changyeJiaMeng/index.html">创业加盟</a></span> |</li>
      	<li id="dis7"><span><a href="/default/pingCe/index.html">评测</a></span> |</li>
      	<li id="dis6"><span><a href="/default/myzh/index.html">市场展会</a></span> |</li>
      	<li id="dis5"><span><a href="/default/news/index.html">资讯</a></span> |</li>
      	<li id="dis4"><span><a href="/default/aiwen/index.html">问答</a></span> |</li>
      	<li id="dis3"><span><a href="/default/job/index.html">人才</a></span> |</li>
      	<li id="dis2"><span><a href="/default/book/index.html">图书</a></span> |</li>
      	<li id="dis1"><span><a href="/default/price/index.html">价格行情</a></span> |</li>
      <li><span><a href="http://www.wanglong.cc/bbs">论坛</a></span> |</li>
    </ul>
  </div>
</div>
<script type="text/javascript" src="/templates/default/js/setClassName.js"></script>
<script type="text/javascript" src="/templates/default/js/topSearch.js"></script>
<script type="text/javascript" src="/js/prototype.js"></script>
		
		
		<table cellspacing="0" cellpadding="0" width="970" align="center"	border="0">
			<tr>
				<td valign="top">
					<table cellspacing="0" cellpadding="0" width="100%" border="0">
						<tr>
							<td style="PADDING-RIGHT: 42px; PADDING-LEFT: 42px" valign="top">
								<table cellspacing="1" cellpadding="0" width="100%" border="0">
									<tr>
										<td valign="bottom" width="176" height="76">
											<img height="33" alt="" width="176" src="/images/car_img2_01.gif" />
										</td>
										<td valign="bottom" align="left" width="176">
											<img height="33" alt="" width="176" src="/images/car_img_02.gif" />
										</td>
										<td valign="bottom" align="left" width="176">
											<img height="33" alt="" width="176" src="/images/car_img_03.gif" />
										</td>
										<td valign="bottom" align="left" width="176">
											<img height="33" alt="" width="176" src="/images/car_img_04.gif" />
										</td>
										<td valign="bottom">
											<img height="33" alt="" width="176" src="/images/car_img_05.gif" />
										</td>
									</tr>
								</table>
								<br />
								<br />
								<table cellspacing="0" cellpadding="0" width="100%" border="0"
									class="z_topbg01">
									<tr>
										<td width="12">
											<img height="46" alt="" width="12" src="/images/z_td_tl01.gif" />
										</td>
										<td class="gome_str_666_14" align="center" width="211">
											填写收货人地址
										</td>
										<td class="gome_str_666_14" width="683">
											请认真填写收货人地址！
										</td>
										<td width="14">
											<img height="46" alt="" width="12" src="/images/z_td_tr01.gif" />
										</td>
									</tr>
								</table>
								<table cellspacing="0" cellpadding="0" width="100%" border="0">
									<tr>
										<td class="gome_d6d6d6_lr gome_pad_left15 gome_pad_right45" valign="top">
											<table cellspacing="0" cellpadding="0" width="100%"
												border="0">
												<tr>
													<td class="gome_str_red gome_pad_left35" height="40">
														*
														<span class="gome_str_666_14">&nbsp;为必填信息</span>
													</td>
												</tr>
											</table>
											<table cellspacing="0" cellpadding="0" width="100%" border="0">
												<tr>
													<td align="center">
														<div id="loginstyle" style="PADDING-RIGHT: 6px; PADDING-LEFT: 6px; PADDING-BOTTOM: 6px; MARGIN: 3px; WIDTH: 700px; PADDING-TOP: 6px">
															<div>
																<form name="orderform" action="/doOrderAffirmTradeReg.do" method="post" target="_self">
																	<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#eeeeee" style="font-size:14px">
																		<%	
																			String province = "",province1="",eparchy_code = "",eparchy_code1="",city = "",city1="",
																			consignee="",addr="",post_code="",phone="",cellphone="";
																		 	if ( orderlist != null && orderlist.size()>0 ){
																		 		HashMap map = (HashMap) orderlist.get(0);
																		 		if(map.get("consignee")!=null){consignee=map.get("consignee").toString();}
																		 		if(map.get("addr")!=null){addr=map.get("addr").toString();}
																		 		if(map.get("phone")!=null){phone=map.get("phone").toString();}
																		 		if(map.get("post_code")!=null){post_code=map.get("post_code").toString();}
																		 		if(map.get("cellphone")!=null){cellphone=map.get("cellphone").toString();}
																		 		if(map.get("province")!=null){
																		 		   province=map.get("province").toString();
																		 		   province1 = arae.getAreaNameByCode(province);
																		 		   if(province1=="未选地区"||province1.equals("未选地区"))  
																		 		     province1="请选择...";        
																		 		 }
																		 		if(map.get("eparchy_code")!=null){
																		 		   eparchy_code=map.get("eparchy_code").toString();																		 		
                                           eparchy_code1 = arae.getAreaNameByCode(eparchy_code);
                                           //out.println("---------------------------------->"+eparchy_code+"---------------------------->"+eparchy_code1);
                                          //  if(eparchy_code1=="未选地区"||eparchy_code1.equals("未选地区"))  
                                          // eparchy_code1="请选择...";        
                                     		 }
																		 		if(map.get("city")!=null){
                                         city=map.get("city").toString();
                                         city1=arae.getAreaNameByCode(city);
                                         // if(city1=="未选地区"||city1.equals("未选地区"))  
                                                //  city1="请选择..."; 
                                      	 }
																		 	}
																		%>
																		<tr>
																			<td width="26%" height="45" align="right" bgcolor="#F6F6F6" style="font-weight:bold; color:#666666; font-size:14px">
																				<font color="#FF0000">*</font>
																				<span id="name_goce_territory">配送地址</span>:
																			</td>
																			<td align="left">省份：
																				<select name="province" id="province" onclick="setCitys(this.value)">
																					<option value="0">
																						<%=province1%>
																					</option>
																					<%
																						if (country_Map != null && country_Map.size() > 0) {
																						Iterator it = country_Map.entrySet().iterator();
																						while (it.hasNext()) {
																							Map.Entry entry = (Map.Entry) it.next();
																							Object key = entry.getKey();
																							Object value = entry.getValue();
																					%>
																					<option value=<%=key%>>
																						<%=value%>
																					</option>
																						
																					<%
																							}
																						}
																					%>
																				</select>
																				归属城市：
																				<select name="eparchy_code" id="eparchy_code" style="display:inline" onclick="setAreas(this.value)">
																					<option value="0">
																						<%=eparchy_code1%>
																					</option>
																					
																				</select>
																				区/县：
																				<select name="city" id="city" style="display:inline">
																					<option value="0">
																						<%=city1%>
																					</option>
																					
																				</select>
																			</td>
																		</tr>
																		<tr>
																			<td width="26%" height="45" align="right" bgcolor="#F6F6F6" style="font-weight:bold; color:#666666; font-size:14px">
																				<font color="#FF0000">*</font>
																				<span id="name_goce_name">收货人姓名</span>:
																			</td>
																			<td width="74%" height="25" class="boxcontentbg" align="left">
																				<input type="text" maxlength="50" size="30" name="consignee" id="consignee" value="<%=consignee%>"/>
																			</td>
																		</tr>
																		<tr>
																			<td width="26%" height="45" align="right" bgcolor="#F6F6F6" style="font-weight:bold; color:#666666; font-size:14px">
																				<font color="#FF0000">*</font>
																				<span id="name_goce_address">详细地址</span>:
																			</td>
																			<td width="74%" height="25" class="boxcontentbg" align="left">
																				<input type="text" maxlength="120" size="30" name="addr" id="addr" value="<%=addr%>"/>
																			</td>
																		</tr>
																		<tr>
																			<td width="26%" height="45" align="right" bgcolor="#F6F6F6" style="font-weight:bold; color:#666666; font-size:14px">
																				<font color="#FF0000">*</font>
																				<span id="name_goce_postcode">邮政编码</span>:
																			</td>
																			<td width="74%" height="25" class="boxcontentbg" align="left">
																				<input type="text" maxlength="10" size="15" name="post_code" id="post_code" value="<%=post_code%>"/>
																			</td>
																		</tr>
																		<tr>
																			<td width="26%" height="45" align="right" bgcolor="#F6F6F6" style="font-weight:bold; color:#666666; font-size:14px">
																				<font color="#FF0000">*</font>
																				<span id="name_goce_tel">电话</span>:
																			</td>
																			<td width="74%" height="25" class="boxcontentbg" align="left">
																				<input type="text" maxlength="60" size="20" name="phone" id="phone" value="<%=phone%>" />
																			</td>
																		</tr>
																		<tr>
																			<td width="26%" height="45" align="right" bgcolor="#F6F6F6" style="font-weight:bold; color:#666666; font-size:14px">
																				<span id="name_goce_mobile">手机</span>:
																			</td>
																			<td width="74%" height="25" class="boxcontentbg" align="left">
																				<input type="text" maxlength="60" size="20" name="cellphone" id="cellphone" value="<%=cellphone%>"/>
																			</td>
																		</tr>
																		<%
																		 
																		%>
																		<tr>
																			<td width="26%" height="45" align="right" bgcolor="#F6F6F6" style="font-weight:bold; color:#666666; font-size:14px">
																				<font color="#FF0000">*</font>
																				<span id="name_goce_email">送货方式</span>:
																			</td>
																			<td width="74%" height="25" class="boxcontentbg" align="left">
																				<select name="deliver_type" id="deliver_type" onchange="paySelect(this.value)">
																					<%=deliver_type%>
																				</select>
																				<input type="hidden" id="carriage_pay" name="carriage_pay" value="15.0">
																				<span id="carriage_pay_p">运费:15.0元</span>
																			</td>
																		</tr>
																		<tr>
																			<td width="26%" height="45" align="right" bgcolor="#F6F6F6" style="font-weight:bold; color:#666666; font-size:14px">
																				<span id="name_goce_signbuilding">付款方式</span>:
																			</td>
																			<td width="74%" height="25" class="boxcontentbg" align="left">
																				<select name="pay_type" id="pay_type">
																					<%=pay_type%>
																				</select>
																			</td>
																		</tr>
																		<tr>
																			<td>
																				<input type="hidden" id="trade_type_code" name="trade_type_code" value="5557">
																				<input type="hidden" id="trade_id" name="trade_id" value="<%=trade_id%>">
																				<input type="hidden" id="trade_ids" name="trade_ids" value="<%=all_trade_id%>"><!--all-->
																				<input type="hidden" id="order_type" name="order_type" value="1">
																				<input type="hidden" id="price" name="price" value="<%=all_price%>"><!--all-->
																				<input type="hidden" id="num" name="num" value="<%=all_num%>"><!--all-->
																				<input type="hidden" id="money" name="money" value="">
																				<input type="hidden" id="discount" name="discount" value="<%=all_discount%>"><!--all-->
																				<input type="hidden" id="user_id" name="user_id" value="<%=user_id%>">
																				<input type="hidden" id="oper_date" name="oper_date" value="">
																				<input type="hidden" id="in_date" name="in_date" value="">
																				<input type="hidden" id="cust_id" name="cust_id" value="<%=all_cust_id%>"><!--all-->
																				<input type="hidden" id="sale_id" name="sale_id" value="<%=all_sale_id%>"><!--all-->
																				<input type="hidden" id="sum_money" name="sum_money" value="<%=sum_money%>">
																			</td>
																		</tr>
																	</table>
																	<div align="center" style="text-align:center; height:30px; padding-top:10px">
																		<input name="button" type="submit" value="" onclick="return chickNone()" style="background-image: url('/admin/images/tj.gif');width:78px;height: 32px;border:0;cursor:hand;text-align:center;">
																	</div>
																</form>
															</div>
														</div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<table cellspacing="0" cellpadding="0" width="100%" border="0">
									<tr>
										<td width="10" height="10">
											<img height="10" alt="" width="10" src="/images/z_td_bl01.gif" />
										</td>
										<td class="gome_d6d6d6_bott" height="10">
											<img height="1" alt="" width="1" src="/images/spacer.gif" />
										</td>
										<td width="10" height="10">
											<img height="10" alt="" width="10" src="/images/z_td_br01.gif" />
										</td>
									</tr>
								</table>
								<br />
								<br />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	
<!--footer-->
<!--bottom-->
<div class="footernew">
	<a href="/templates/default/jsp/about_us.jsp">关于我们</a> | <a href="/templates/default/jsp/service.jsp">服务条款</a> | <a href="/templates/default/jsp/recruitment.jsp">企业招聘</a> | <a href="/templates/default/jsp/customer_service.jsp">客服中心</a> | <a href="/templates/default/jsp/site_navigation.jsp">网站导航</a> | <a href="/templates/default/jsp/copyright.jsp">版权所有</a><br />
<img src="/templates/default/images/ucs2.gif" align="absmiddle"/>&nbsp;产品购买咨询：肖先生
    (QQ)<a href="http://wpa.qq.com/msgrd?V=1&Uin=31688721&Site=a-hai.net&Menu=yes tencent://message/?uin=31688721" target=_blank class="lanse">31688721</a> 
    (MSN)<a href=msnim:chat?contact=xiaobo68@gmail.com>xiaobo68@gmail.com</a>  <a href="http://www.wanglong.cc" target="_blank" class="lanse"> 中国生产商信息技术有限公司</a> 版权所有 &copy;  2008  保留所有权利 <a href="http://www.miibeian.gov.cn/" target=_blank>皖ICP备07039386号</a><br />
    <div class="lx">服务热线：0551-5310317 | 传真：0551-5310317 | 销售支持论坛：http://www.wanglong.cc/bbs/forumdisplay.php?fid=4</div>
	<div style="width:570px;">
	<p>
		<span class="fl"><a href="http://www.sznet110.gov.cn/index.jsp" target="_blank"><img src="/templates/default/images/816587.gif" width="36" height="43" border="0"></a></span>
		<span class="fr"><a href="http://www.sznet110.gov.cn/index.jsp" target="_blank">网络警察<br />
		报警平台</a></span>
	</p>
	<p>
		<span class="fl"><a href="http://www.sznet110.gov.cn/webrecord/innernet/Welcome.jsp?bano=4403101010155" target="_blank"><img src="/templates/default/images/6743671.jpg" width="36" height="42" border="0"></a></span>
		<span class="fr"><a href="http://www.sznet110.gov.cn/webrecord/innernet/Welcome.jsp?bano=4403101010155" target="_blank">公共信息安<br />
		全网络监察</a></span>
	</p>
	
	<p>
		<span class="fl" style="width:44px;"><a href="http://net.china.com.cn/index.htm" target="_blank"><img src="/templates/default/images/home_b.gif" width="44" height="44" border="0"></a></span>
		<span class="fr" style="width:64px;"><a href="http://net.china.com.cn/index.htm" class="lcblack" target="_blank">不良信息<br>
		举报中心</a></span>
	</p>
	<p>
		<span class="fl" style="width:44px;"><a href="http://www.wenming.cn/" target="_blank"><img src="/templates/default/images/wmlogo.gif" width="44" height="42" border="0"></a></span>
		<span class="fr" style="width:64px;"><a href="http://www.wenming.cn/" class="lcblack" target="_blank">中国文明网<br>传播文明</a></span>
	</p>
	</div>	
</div>
</html>



