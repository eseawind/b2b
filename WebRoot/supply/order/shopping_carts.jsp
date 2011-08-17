<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional/EN"
"http:/www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.saleMgr.*"%>
<%@ page import="com.saas.biz.shoppingcartMgr.*"%>
<%@ page import="java.math.*"%>
<%
	String  user_id = "";

	HttpSession logsession = request.getSession();
	if (logsession.getAttribute("SESSION_USER_ID") != null) {
		user_id = logsession.getAttribute("SESSION_USER_ID").toString();
	}

	String sale_id = "", discount = "",num="";
	String name = "",trade_id = "",all_trade_id="",all_num ="";
	ShoppingCartInfo cartinfo = new ShoppingCartInfo();
	ArrayList list = cartinfo.getMerchandiseByCart(user_id);
	//out.println(list+"===");
   int cartsize=0;
	 if(list !=null)
	 {
	 cartsize=list.size();
	 }
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title> 中国生产商信息科技有限责任公司(http://www.huipoo.com)</title>
		<link href="/style/css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/templates/default/style/cn-b2b.css" />	
		<link href="/zone_b2b/css/b2c.css" rel="stylesheet" type="text/css" />
		<link href="/style/b2c_css.css" rel="stylesheet" type="text/css" />
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/ShoppingCartInfo.js'></script> 
        <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>  
        <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script> 
        <script type="text/javascript">
        	function updateNum(){
        		var cartsize = document.getElementById('cartsize').value;
        		var a = '';
        		for(var i=0;i<cartsize;i++){
        			a +=document.getElementById('num'+i).value+'|';
        		}
        		document.getElementById('nums').value = a;
        		document.updateNumForm.submit();
        	}
        		function cheknum(){
	        		var carsize = document.getElementById('cartsize').value;
	        		for(var i=0;i<carsize;i++){
			        		if(document.getElementById('num'+i).value*1>document.getElementById('sale_num'+i).value*1){
			        		alert("超过库存的数量"+document.getElementById('sale_num'+i).value);
			        		document.getElementById('num'+i).value='';
			        		document.getElementById("num"+i).focus();
			        		return false;
			        	  } 
        		  
        			}
        		}
        	
        </script>
	</head>
	<body>
		
		
	
<!--头部-->
<div id="top"  width=100%>
	  <div class="width link_xian">
		<div class="left"><A title=将本站设为你的首页 onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://'+window.location.host);return false;" href="javascript:;">设为首页</a> | <a href=javascript:window.external.AddFavorite(top.location.href)>添加到收藏夹</a></div>
		<div class="right">
		
		 <a href="/member/index.html">登录</a> | <a href="/admin/index.jsp">运营商</a> | <a href="/member/Newcregister.html">免费注册</a> | <a href="/member/mainMenu/default.jsp">发布信息</a></div>
	  </div>
<!--//logo-->
<div id="logo">
		<div class="logo_img" style=" background:url(/templates/default/images/ad/logo1.jpg) no-repeat top center !important; background:none; _filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, sizingMethod=image, src='/templates/default/images/ad/logo1.jpg'">
			<h1>
				<a href="http://www.huipoo.com"></a>
			</h1>
		</div>
</div>
<!--logo//-->
	
	  <div class="nav_search_box">
			<div class="search_list"><span><input type="radio" name="search" checked onclick="tradeType('8855381456')">产品</span> | <span><input type="radio" name="search" onclick="tradeType('7830633062')">供应</span> | <span><input type="radio" name="search" onclick="tradeType('6871426767')">求购</span> | <span><input type="radio" name="search" onclick="tradeType('5563378845')">企业</span> | <span><input type="radio" name="search" onclick="tradeType('1455415210')">新闻</span> | <!--span>more</span--></div>
			<div class="search_box">
			<strong style=" float:left; font-size:14px;">商品搜索</strong> <div class="search_box_bg"><span>
			 <input name="keyword" id="keyword" type="text" style="font-size:14px; width:300px; color:#666; line-height:18px; height:18px;" value="请输入您想查找的关键字"  onclick="this.value=''",size="42" /><input type="submit" name="Submit" value="全站搜索" onClick="Search()" class="search_button"/></span></div> 
			</div>
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

      	<li id="dis5"><span><a href="/default/news/index.html">资讯</a></span> |</li>
   
      <li><span><a href="http://www.bizoss.com">中国生产商</a></span> |</li>
    </ul>
  </div>
</div>
<script type="text/javascript" src="/templates/default/js/setClassName.js"></script>
<script type="text/javascript" src="/templates/default/js/topSearch.js"></script>
<script type="text/javascript" src="/js/prototype.js"></script>
		
		
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
</table>
</td>
          </tr>
        </table>
		<table cellspacing="0" cellpadding="0" width="980" align="center" border="0">
			<tr>
				<td class="gome_bg_07" valign="top">
					<table cellspacing="0" cellpadding="0" width="100%" border="0">
						<tr>
							<td valign="top" height="300">
								<table cellspacing="1" cellpadding="0" width="100%" border="0">
									<tr>
										<td valign="bottom" width="195" height="50">
										<img height="33" alt="" width="195" src="/images/car_img2_01.gif" /></td>
										<td valign="bottom" align="left" width="195">
										<img height="33" alt="" width="195" src="/images/car_img_02.gif" /></td>
										<td valign="bottom" align="left" width="195">
										<img height="33" alt="" width="195" src="/images/car_img_03.gif" /></td>
										<td valign="bottom" align="left" width="195">
										<img height="33" alt="" width="195" src="/images/car_img_04.gif" /></td>
										<td valign="bottom">
										<img height="33" alt="" width="195" src="/images/car_img_05.gif" /></td>
									</tr>
								</table>
								<br />
								<DIV class="gome_big_orange gome_pad_left15 gome_line_height35">
									商品订单
								</DIV>
								<DIV class=gome_bor_ebebeb>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-size:12px">
													<tr class="gome_bg_47 gome_bor_bott_ebebeb">
														<td class="gome_pad_left30 gome_bor_bott_ebebeb" width="34%" height=31>
															&nbsp;&nbsp;商品名称
														</td>
														<td width="16%" class="gome_bor_bott_ebebeb">
															价格
														</td>
														<td width="10%" class="gome_bor_bott_ebebeb">
															数量
														</td>
														<td width="10%" class="gome_bor_bott_ebebeb">
															小计
														</td>
														<td width="9%" height="25" class="gome_bor_bott_ebebeb">
															删除
														</td>
													</tr>
													<%	double b4 =0.00;
														SaleInfo info = new SaleInfo();
														if (list != null && list.size() > 0) {
															for (int i = 0; i < list.size(); i++) {
																HashMap map = (HashMap) list.get(i);
																if (map.get("trade_id") != null) {
																	trade_id = map.get("trade_id").toString();
																}
																if (map.get("sale_id") != null) {
																	sale_id = map.get("sale_id").toString();
																}
																//out.println(sale_id);
																if (map.get("discount") != null && !map.get("discount").equals("")) {
																	discount = map.get("discount").toString();
																}else{
																	discount = "0";		
																}
																if (map.get("num") != null) {
																	num = map.get("num").toString();
																}
																 BigDecimal b1 = new BigDecimal(discount);
																 BigDecimal b2 = new BigDecimal(num);
																 
																 double b3 = b1.multiply(b2).doubleValue();
																 b4+= b3;
																 
																name = info.getProName(sale_id);
																all_trade_id += trade_id + "|";
																all_num +=num + "|";											
																
													%>
													    <%														
																ArrayList saleList=info.genOneSale(sale_id);	
																int sale_num = 0;	
																if (saleList!= null){							
															    HashMap salemap=(HashMap) saleList.get(0);
															    //out.println(!salemap.get("sale_num").toString().equals(""));
															    if (salemap.get("sale_num") != null && !salemap.get("sale_num").toString().equals("")){
															       sale_num=Integer.valueOf(salemap.get("sale_num").toString()).intValue();
															    }
																}
															%>
															<input name="sale_num<%=i%>" type="hidden" id="sale_num<%=i%>" value="<%=sale_num%>">
													<tr>
														<td class="gome_line_height20 gome_bor_bott_ebebeb">
															&nbsp;&nbsp;
															<%=name%>
														</td>
														<td class="gome_bor_bott_ebebeb gome_str_red">
															<span style="color: red;">￥<%=discount%></span>
														</td>
														<td class=gome_bor_bott_ebebeb>
															<input name="num" type="text" id="num<%=i%>" value="<%=num%>" size="8" maxlength="8" onBlur="cheknum()"/>	
															<input name="cartsize" type="hidden" id="cartsize" value="<%=cartsize%>"/>
														</td>
														<td class="gome_bor_bott_ebebeb gome_str_red">
															<span style="color: red;">￥<%=b1.multiply(b2).doubleValue()%>
															</span>&nbsp;
														</td>
														<td height="35" class=gome_bor_bott_ebebeb>
														  <a class=gome_keyword href="/doShoppingCartTradeReg.do?trade_type_code=5556&trade_id=<%=trade_id%>">
														  <IMG height=16 src="/images/z_img09.gif" width=16 border="0" style="cursor: hand;">
														  </a>
														</td>
													</tr>
													<%
														}
													}
													%>
												</table>
											</td>
										</tr>
										<tr>
											<td
												style="background-color:#FFFFFF; border-top:#a1a1a1 1px solid; height:53px; width:980px;">
												<TABLE class=gome_bg_fafafa cellSpacing=0 cellPadding=0
													width="100%" border=0>
													<TBODY>
														<TR vAlign=top>
															<TD class="gome_pad_left10 gome_pad_top10" width="50%">
																<TABLE cellSpacing=3 cellPadding=3 width="100%"
																	border=0>
																	<TBODY>
																		<TR>
																			<TD>
																				限量特价商品每位顾客限购一台！
																			</TD>
																		</TR>
																		<TR>
																			<TD>
																				普通商品可修改订购数量，修改后务必点击"修改数量"按钮，方可生效！
																			</TD>
																		</TR>
																		<TR>
																			<TD>
																				若不想购买清单中的商品，请点这种商品后面的"取消"按钮。
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
															</TD>
															<TD width="50%">
																<TABLE cellSpacing=0 cellPadding=0 width="100%"
																	border=0>
																	<TR>
																		<TD style="PADDING-RIGHT: 70px" align=right height=40>
																			<span style="font-size:14px; font-weight:bold; color:#333333">商品金额总计：</span>
																			<span style="color:#cc3300; font-size:14px; font-weight:bold">￥<%=b4%></span>
																		</TD>
																	</TR>
																</TABLE>
																<TABLE cellSpacing=0 cellPadding=0 width="100%"
																	border=0>
																	<TR>
																		<TD width="2%" height=60>&nbsp;
																			
																	  </TD>
																		<TD class=gome_pad_top10 vAlign=top width="30%">
																			<form action="/doShoppingCartTradeReg.do" method="post" name="updateNumForm">
																				<img src="/images/z_img17.gif" height=29 width=104 style="cursor: hand;" border=0 onClick="updateNum()">
																				<input type="hidden" name="trade_type_code" value="5558">
																				<input type="hidden" name="trade_id" value="<%=all_trade_id%>">
																				<input type="hidden" name="num" id="nums" value="<%=all_num%>">
																				<input type="hidden" name="sum_money" id="sum_money" value="<%=b4%>">
																			</form>
																		</TD>
																		<TD class=gome_pad_top10 vAlign=top width="30%">
																			<a onclick=javascript:window.close(); href="#">
																				<IMG height=29 src="/images/z_img10.gif"
																					width=104 border=0>
																			</A>
																		</TD>
																		<TD class=gome_pad_top10 vAlign=top width="30%">
																			<a href="/supply/order/verify_addr.jsp?sum_money=<%=b4%>">
																			<IMG height=29 src="/images/z_img11.gif" width=104 border=0>
																			</A>
																		</TD>
																		<TD width="8%" height=60>&nbsp;
																			
																	  </TD>
																	</TR>
																</TABLE>
															</TD>
														</TR>
												</TABLE>
											</td>
										</tr>
									</table>
								</DIV>
								<br />
								<table cellspacing="0" cellpadding="0" width="100%" border="0">
									<tr>
										<td class="gome_pad_top3" valign="top" width="2%">
											<img height="14" alt="" width="14" src="/images/z_img12.gif" />
										</td>
										<td class="gome_line_height22 gome_w_gray" width="97%">
											注意：如果您点击&ldquo;到收银台&rdquo;进行下一步操作，网站视为：您已经接受以下服务条款：
											<br />
											1、《网站服务条款》中的所有条款；
											<br />
											2、您接受选购商品的订购价格，并愿意按照您所选择的付款方式支付商品货款；
											<br />
											3、您知晓所在地网上商城《配送信息》规定的服务范围，并接受由购买商品而产生的相关服务费用；
											<br />
											4、由于市场竞争较为激烈，当出现网站资料及价格等相关信息与实际情况不符时，以实际情况为准；
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="10"></td>
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
	</body>
</html>



