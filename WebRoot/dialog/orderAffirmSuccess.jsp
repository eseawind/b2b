<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional/EN"
"http:/www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="com.saas.biz.AreaInfoMgr.AreaInfo"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.shoppingcartMgr.*"%>
<jsp:useBean id="MD5" scope="request" class="beartool.MD5"/>
<%@ page import="com.saas.biz.shoppingorderMgr.ShoppingOrderInfo"%>
<%@ page import="com.saas.biz.acctMgr.CustAccount"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.ParamethodMgr" scope="page" />
<jsp:useBean id="bean" class="com.saas.biz.commen.commMethodMgr" scope="page" />
<%
	String  user_id = "",cust_id="";

	if (session.getAttribute("SESSION_USER_ID") != null) {
		user_id = session.getAttribute("SESSION_USER_ID").toString();
	}
	if (session.getAttribute("SESSION_CUST_ID") != null) {
		cust_id = session.getAttribute("SESSION_CUST_ID").toString();
	}
	ParamethodMgr param = new ParamethodMgr();
	ArrayList commList = comm.getCompareInfoByAttr("115");
	String para_code1="";
	if(commList!=null && commList.size()>0){
		HashMap commMap = (HashMap)commList.get(0);
		if(commMap.get("para_code1")!=null){
			para_code1=commMap.get("para_code1").toString();
		}
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
	
	String trade_ids = "",sale_id = "",discount = "",price = "",num="";
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
	String sum_all_money = "",remark1_trade_id="";
	ShoppingOrderInfo orderinfo = new ShoppingOrderInfo();
	ArrayList orderlist = orderinfo.getOrderInfoByUser(user_id);
 
	if(orderlist!=null && orderlist.size()>0){
		HashMap orderMap = (HashMap)orderlist.get(0);
		if(orderMap.get("sum_money")!=null){
			sum_all_money = orderMap.get("sum_money").toString();
		}
		if(orderMap.get("trade_id")!=null){
			remark1_trade_id = orderMap.get("trade_id").toString();
		}
	}
	
	
	String v_mid="",key="",v_url="",v_oid="",v_amount="",v_moneytype="",v_md5info="";  //定义必须传递的参数变量
	ParamethodMgr acct = new ParamethodMgr();
	v_mid = acct.getBankAccouId(cust_id);
	if(v_mid.equals("")){
		v_mid = "20563236";                                       // 商户号，
	}         	                    
	v_url = "http://www.b2b-pub.cn/webBankMgr/Receive.jsp";     // 商户自定义返回接收支付结果的页面
	key = "wanglonglongwang";                                     //十六位秘钥
	v_amount = sum_all_money;                   									//交易总金额
	
	Date currTime = new Date();
  SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd-"+v_mid+"-hhmmss",Locale.US);
  
  v_oid=sf.format(currTime); 																		//推荐订单号构成格式为 年月日-商户号-小时分钟秒
	v_moneytype="CNY";                                              //费用类型 0:人民币 1:美元 	
 
	String text = v_amount+v_moneytype+v_oid+v_mid+v_url+key;   	
	v_md5info = MD5.getMD5ofStr(text);    										// 拼凑加密串
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
<link rel="stylesheet" type="text/css" href="/templates/default/style/cn-b2b.css" />
		<script language="JavaScript" src="/js/dialog.js"></script>
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
                                <td valign="bottom" width="195" height="50"><img height="33" alt="" width="195" src="/images/car_img2_01.gif" /></td>
                                <td valign="bottom" align="left" width="195"><img height="33" alt="" width="195" src="/images/car_img_02.gif" /></td>
                                <td valign="bottom" align="left" width="195"><img height="33" alt="" width="195" src="/images/car_img_03.gif" /></td>
                                <td valign="bottom" align="left" width="195"><img height="33" alt="" width="195" src="/images/car_img_04.gif" /></td>
                                <td valign="bottom"><img height="33" alt="" width="195" src="/images/car_img_05.gif" /></td>
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
													<%
														if(para_code1.equals("1")){
													%>
													<div style="width:760px; padding-left:10px; padding-top:20px; height:18px; border-bottom:1px dashed #ccc; text-align:left;font-size:14px; color:#545454; font-weight:bold;">
													      请按照选定的方式付款!
													</div>
													<div style="width:760px; padding-top:20px;padding-bottom:20px; height:18px; border-bottom:1px dashed #ccc; text-align:left;font-size:14px; color:#545454; font-weight:bold; text-align:center;">
															    <form name="wangyForm" method="post" action="/supply/order/webBankMgr/Send.jsp">
															    	<input type="hidden" name="v_md5info"    value="<%=v_md5info%>" size="100">
																		<input type="hidden" name="v_mid"        value="<%=v_mid%>">
																		<input type="hidden" name="v_oid"        value="<%=v_oid%>">
																		<input type="hidden" name="v_amount"     value="<%=v_amount%>">
																		<input type="hidden" name="v_moneytype"  value="<%=v_moneytype%>">
																		<input type="hidden" name="v_url"        value="<%=v_url%>">
																		<input type="hidden" name="remark1"        value="<%=remark1_trade_id%>"> 
															    	<img src="/images/wangy.gif" alt="" align="absmiddle" style="cursor:hand;" onclick="javascript:document.wangyForm.submit();"/>
															  	</form>
													   </div>
													<%
													}else{
															out.println("<b>对不起，网上支付通道已关！</b>");
														}
													%>
													
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



