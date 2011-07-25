<!DOCTYPE HTML PUBLIC "-/W3C/DTD HTML 4.01 Transitional/EN"
"http:/www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.saleMgr.*"%>
<%@ page import="com.saas.biz.attachMgr.*"%>
<%@ page import="com.saas.biz.enquirydealMgr.EnquirydInfo"%>
<jsp:useBean id="comm" class="com.saas.biz.commen.commMethodMgr" scope="page" />
 <%
	String sale_id = "";
	if (request.getParameter("sale_id") != null) {
		sale_id = request.getParameter("sale_id");
	  } 
	String session_cust_id="",session_user_id="",session_user_name="";
	    HttpSession logsession = request.getSession();
	if (logsession.getAttribute("SESSION_CUST_ID") != null) {
		session_cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
		session_user_id = logsession.getAttribute("SESSION_USER_ID").toString();
		session_user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
	}
	
	
	String trade_id = comm.GenTradeId();
	String title = "",commodity_price = "",sale_price = "",sale_unit = "";
	
	  SaleInfo info = new SaleInfo ();
	  ArrayList list = info.getProductInfoList(sale_id);
	  EnquirydInfo enquiryd=new EnquirydInfo();	  
	if ( list!=null && list.size() > 0 ){
		HashMap map = (HashMap)list.get(0);
		if (map.get("title")!=null){title = map.get("title").toString();}
		if (map.get("sale_price")!=null){sale_price = map.get("sale_price").toString();}
		if (map.get("commodity_price")!=null){commodity_price = map.get("commodity_price").toString();}
		if (map.get("sale_unit")!=null){sale_unit = map.get("sale_unit").toString();}
	}
    String file_path= "/images/b2c_picx_03.gif";
       Attachinfo attinfo = new Attachinfo();
      ArrayList lists = attinfo.getFilePath(sale_id);
    if ( lists!=null && lists.size() > 0 ){
	    HashMap maps = (HashMap)lists.get(0);
	    if(maps.get("file_path")!=null){
	    	file_path=maps.get("file_path").toString();
		}
	}
    int  price = 0;
    String p = "";
	if(sale_price!=null && commodity_price!=null)
		if(!sale_price.equals("") && !commodity_price.equals("")){
			if(sale_price.indexOf('/')!=-1){
				sale_price = sale_price.substring(0,sale_price.indexOf('/'));
				if(sale_price==null || sale_price.equals("")){
					sale_price="0";
				}
			}
			if(commodity_price.indexOf('/')!=-1){
				commodity_price = commodity_price.substring(0,commodity_price.indexOf('/'));
				if(commodity_price==null || commodity_price.equals("")){
					commodity_price="0";
				}
			}
	    price =Integer.parseInt(sale_price)-Integer.parseInt(commodity_price);
	    p=String.valueOf(Double.parseDouble(sale_price)/Double.parseDouble(commodity_price)).substring(0,3);
	    if(p.equals("NaN")){
	    	p = "0";
	    }
	}
    
    ArrayList enquiryList=enquiryd.getEnquriyInfoBySaleId(sale_id); //求对商品评论的
    int counter = enquiryd.getNumEnquriyInfoBySaleId( sale_id );//求对商品评论的的总数
    
    
  ArrayList custList = new ArrayList();
	Custinfo custInfo = new Custinfo();
	String cust_phone="",cust_fax="",contact_man="",cust_email="",cust_addr="",cust_aim="";
	custList = custInfo.getCustomerInfo(sale_unit);
	if(custList!=null && custList.size()>0){
		HashMap custMap = (HashMap)custList.get(0);
		if(custMap.get("cust_name")!=null){contact_man = custMap.get("cust_name").toString();}
		if(custMap.get("group_contact_phone")!=null){cust_phone = custMap.get("group_contact_phone").toString();}
		if(custMap.get("fax_nbr")!=null){cust_fax = custMap.get("fax_nbr").toString();}
		if(custMap.get("email")!=null){cust_email = custMap.get("email").toString();}
		if(custMap.get("pspt_addr")!=null){cust_addr = custMap.get("pspt_addr").toString();}
		if(custMap.get("cust_aim")!=null){cust_aim = custMap.get("cust_aim").toString();}
	}
	
	SaleInfo saleinfo=new SaleInfo();
	ArrayList saleList=saleinfo.genOneSale(sale_id);	
   String content="",title_1="";
   if(saleList!=null){								
        HashMap salemap=(HashMap) saleList.get(0);
         if( salemap.get( "content" ) != null )
    {
       content = salemap.get( "content" ).toString();					          
    }
         if( salemap.get( "title" ) != null )
    {
       title_1 = salemap.get( "title" ).toString();					          
    }
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>安徽制造业信息化商务平台(http://www.huipoo.com)</title>
<link href="/style/css.css" rel="stylesheet" type="text/css" />
<link href="/style/b2c.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/templates/default/style/cn-b2b.css" />
<script type="text/javascript" src="/supply/inquiry.js"></script>
<script type="text/javascript">
	function clickValue(){
		
		if(document.getElementById('user_id').value=='' || document.getElementById('user_id').value==null){
				alert('请登陆！');
				return false;
  	}
		if (document.getElementById('rsrv_str3').value == '' || document.getElementById('rsrv_str3').value == null){
			alert('请填写标题');
			return false;
		}
		if (document.getElementById('content').value == '' || document.getElementById('content').value == null){
			alert('请填写内容');
			return false;
		}
		document.enquiryform.submit();
	}
	
  	function cartFormSub(){
  		if(document.getElementById('user_id').value=='' || document.getElementById('user_id').value==null){
  				alert('请登陆！');
					return false;
  		}
  		document.cartForm.submit();
  	}
		       
</script>
<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	#login{
     position: relative;
     display: none;
         top: 20px;
         left: 30px;
         background-color: #ffffff;
         text-align: center;
         border: solid 1px;
         padding: 10px;
         z-index: 1;
   }
	-->
	</style>
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
		<div class="logo_img" style=" background:url(/templates/default/images/logo.png) no-repeat top center !important; background:none; _filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, sizingMethod=image, src='/templates/default/images/logo.png'">
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

      	<li id="dis5"><span><a href="/default/news/index.html">资讯</a></span> |</li>
   
      <li><span><a href="http://www.bizoss.com">贞龙</a></span> |</li>
    </ul>
  </div>
</div>
<script type="text/javascript" src="/templates/default/js/setClassName.js"></script>
<script type="text/javascript" src="/templates/default/js/topSearch.js"></script>
<script type="text/javascript" src="/js/prototype.js"></script>
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="16"></td>
  </tr>
</table>
<table width="980" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="980" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td><span style="color:#333333;font-size:14px;font-weight:bold;"><%=title%></span>&nbsp;&nbsp;<a href="/admin/enquiryMgr/enquiryList.jsp?sale_id=<%=sale_id%>">(对该产品共有<%=counter%>评论)</a></td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="5">
        <tr>
          <td width="28%" valign="top" align="center"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
  <tr>
    <td align="center" bgcolor="#FFFFFF"><img src="<%=file_path%>" width="238" height="206" style="border:1px;"></td>
  </tr>
</table> <a href="javascript:window.external.AddFavorite(top.location.href)"><img src="/images/xiang_07.gif" width="94" height="20" style="margin:5px;"></a></td>
          <td width="72%" valign="top"><table width="84%" border="0" cellspacing="0" cellpadding="2">
              <tr>
                <td>价&nbsp;&nbsp;格：<span class="jianqian">￥<%=sale_price%>元</span></td>
              </tr>
              <tr>
                <td>批发价：<span class="jianq">￥<%=commodity_price%>元</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#666666;">节省：<%=price%>元(<%=p%>折)</span></td>
              </tr>
			  <tr>
          <td>
              <form name="cartForm" method="post" action="/doCartTradeReg.do">
                <img src="/images/b2c-_17.gif" width="77" height="22" border="0" onClick="cartFormSub()" style="cursor: hand;">
                <input type="hidden" name="trade_type_code" id="trade_type_code" value="5555">
          			<input type="hidden" name="trade_id" id="trade_id" value="<%=trade_id%>">
	            	<input type="hidden" name="cust_id" id="cust_id" value="<%=sale_unit%>">
	            	<input type="hidden" name="sale_id" id="sale_id" value="<%=sale_id%>">
	            	<input type="hidden" name="price" id="price" value="<%=sale_price%>">
	            	<input type="hidden" name="discount" id="discount" value="<%=sale_price%>">
	            	<input type="hidden" name="user_id" id="user_id" value="<%=session_user_id%>">
	            	<input type="hidden" name="oper_user_id" id="oper_user_id" value="<%=session_user_id%>">
	            	<input type="hidden" name="oper_date" id="oper_date" value="">
	            	<input type="hidden" name="in_date" id="in_date" value="">
	            	<input type="hidden" name="num" id="num" value="1">
	            	<input type="hidden" name="remark" id="remark" value="新加购物车">
              </form></td>
        </tr>
			  <tr>
           <td>
					<img src="/images/gw.gif" border="0" onClick="cartFormSub()" style="cursor: hand;">此商品售完为止，售完后将不再补货暂无用户评分				</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
          </table></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="33"width="85" align="center" class="b2c_a1" id="d0" onClick="javascript:secBoard(0)">产品详情</td>
		  <td width="85" align="center" class="b2c_a2" id="d1" onClick="javascript:secBoard(1)">联系方式</td>
		  <td width="85" align="center" class="b2c_a2" id="d2" onClick="javascript:secBoard(2)">支付方式</td><td background="/images/xiang_14.gif" >&nbsp;</td>
          <td width="2"><img src="/images/xiang_16.gif" width="2" height="33" border="0"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="5"></td>
        </tr>
      </table>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr id="bo0">
    <td><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="DFDFDF">
       <tr>
        <td width="84%" bgcolor="#FFFFFF"><%=content%></td>
      </tr>
    </table>
    
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="5"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="10">
       <%
       %>
      </table></td>
  </tr>
  <tr id="bo1" style="display: none">
    <td><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="DFDFDF">
      <tr>
        <td width="15%" align="right" bgcolor="#F0F0F0">联系电话：</td>
        <td width="35%" bgcolor="#FFFFFF">&nbsp;<%=cust_phone%></td>
        <td width="15%" align="right" bgcolor="#F0F0F0">传真：</td>
        <td width="35%" bgcolor="#FFFFFF">&nbsp;<%=cust_fax%></td>
      </tr>
      <tr>
        <td align="right" bgcolor="#F0F0F0">联系人：</td>
        <td bgcolor="#FFFFFF">&nbsp;<%=contact_man%></td>
        <td align="right" bgcolor="#F0F0F0">E-mail：</td>
        <td bgcolor="#FFFFFF">&nbsp;<%=cust_email%></td>
      </tr>
      <tr>
        <td align="right" bgcolor="#F0F0F0">地址：</td>
        <td colspan="3" bgcolor="#FFFFFF">&nbsp;<%=cust_addr%></td>
        </tr>
      <tr>
        <td align="right" bgcolor="#F0F0F0">主营业务：</td>
        <td colspan="3" bgcolor="#FFFFFF">&nbsp;<%=cust_aim%></td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="5"></td>
        </tr>
      </table></td>
  </tr>
  <tr id="bo2" style="display: none">
    <td><table width="100%" border="0" cellspacing="0" cellpadding="5">
     <tr>
        <td><img src="/images/bao.gif" width="63" height="21" align="absmiddle"> &nbsp; 淘宝商城统一支持支付宝支付，让您购物更安全!</td>
      </tr>
      <tr>
        <td><img src="/images/fangshi.jpg" width="727" height="88" align="absmiddle"></td>
      </tr>
      <tr>
        <td><b>最方便的四种付款方式:</b></td>
      </tr>
      <tr>
        <td><b>1.银行卡支付</b><br>
        &nbsp;&nbsp;&nbsp;网卡银行:拥有以下银行卡，并目开涌网卜古什阴尾冬，即可对古什牢讲行什款。</td>
      </tr>
	  
      <tr id->
        <td><table width="96%" border="0" align="center" cellpadding="3" cellspacing="0">
          <tr>
            <td width="25%" align="center"><img src="/images/bank_ico/abc-bank.gif" width="165" height="28" align="absmiddle"></td>
            <td width="25%" align="center"><img src="/images/bank_ico/cbc-bank.gif" width="165" height="28" align="absmiddle"></td>
            <td width="25%" align="center"><img src="/images/bank_ico/ccb-bank.gif" width="165" height="28" align="absmiddle"></td>
            <td width="25%" align="center"><img src="/images/bank_ico/ccbx-bank.gif" width="165" height="28" align="absmiddle"></td>
          </tr>
          <tr>
             <td width="25%" align="center"><img src="/images/bank_ico/ceb-bank.gif" width="165" height="28" align="absmiddle"></td>
            <td width="25%" align="center"><img src="/images/bank_ico/cib-bank.gif" width="165" height="28" align="absmiddle"></td>
            <td width="25%" align="center"><img src="/images/bank_ico/cmb-bank.gif" width="165" height="28" align="absmiddle"></td>
            <td width="25%" align="center"><img src="/images/bank_ico/cmbc-bank.gif" width="165" height="28" align="absmiddle"></td>
          </tr>
          <tr>
             <td width="25%" align="center"><img src="/images/bank_ico/comm-bank.gif" width="165" height="28" align="absmiddle"></td>
            <td width="25%" align="center"><img src="/images/bank_ico/gdb-bank.gif" width="165" height="28" align="absmiddle"></td>
            <td width="25%" align="center"><img src="/images/bank_ico/sdb-bank.gif" width="165" height="28" align="absmiddle"></td>
            <td width="25%" align="center"><img src="/images/bank_ico/spdb-bank.gif" width="165" height="28" align="absmiddle"></td>
          </tr>
        </table></td>
      </tr>
    </table>	</td>
  </tr>
</table>
								<!--选项结束-->
<script language=javascript>
function secBoard(n)
{
	for(i=0;i<3;i++) {
		if (i==n) {
			document.all('d' + n).className="b2c_a1";
		} else {
		document.all('d' + i).className="b2c_a2";}
	}
	
	for(i=0;i<3;i++) {
		if (i==n) {
			document.all('bo' + n).style.display="";
		} else {
		document.all('bo' + i).style.display="none";}
	}
	
}
</script>
	  
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="10"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="33"width="118" align="center" background="/images/xiang_21.gif"><B>对产品的评论</B></td>
          <td background="/images/xiang_14.gif" >&nbsp;</td>
          <td width="2"><img src="/images/xiang_16.gif" width="2" height="33" border="0"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table>
      <form action="/doTradeReg.do" method="post" name="enquiryform">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="70%" valign="top">
  <%
        if( enquiryList != null && enquiryList.size()>0){    
		        	for (Iterator it = enquiryList.iterator(); it.hasNext();){
			            HashMap map = (HashMap) it.next();
			            String rsrv_str3="";String enquiry_content="";
					        if( map.get( "enquiry_content" ) != null ){
					           enquiry_content = map.get( "enquiry_content" ).toString();					          
					        }
					        if( map.get( "rsrv_str3" ) != null ){
					           rsrv_str3 = map.get( "rsrv_str3" ).toString();					          
					        }
  %>
		 		 <div class="ly-list">
					 <b><%=rsrv_str3%></b><br>
						<%=enquiry_content%></div>
						<%
							}
				}
						%>
						</td>
          <td width="30%" align="right" valign="top"><table width="96%" border="0" cellpadding="3" cellspacing="1" bgcolor="f4f4f4" class="ly-list0">
            <tr>
              <td align="right" valign="top">标题:</td>
              <td align="left"><input type="text" id="rsrv_str3" name="rsrv_str3" class="box"></td>
            </tr>
            <tr>
              <td align="right" valign="top">内容:</td>
              <td align="left"><textarea id="content" name="content" rows="5" cols="26"></textarea></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td align="left"><input type="hidden" id="trade_type_code" name="trade_type_code" value="1308">
                  <input type="hidden" id="sale_id" name="sale_id" value="<%=sale_id%>">
                  <input type="hidden" id="cust_id" name="cust_id" value="<%=sale_unit%>">
                  <input type="hidden" id="deal_tag" name="deal_tag" value="7">
                  <input type="hidden" id="rsrv_str4" name="rsrv_str4" value="0">
                  <input type="hidden" id="rsrv_str5" name="rsrv_str5" value="<%=session_user_name%>">
                <input type="hidden" id="user_id" name="user_id" value="<%=session_user_id%>"><input name="comit" type="button" id="comit" style="cursor: hand;" onClick="clickValue()" value="提&nbsp;交"></td>
            </tr>
          </table></td>
        </tr>
      </table>
      </form></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="10"></td>
  </tr>
</table>
		<script language="javascript">
		function ResizeImages()
		{
		   var myimg,oldwidth;
		   var maxwidth=200;
		   for(i=0;i<document.images.length;i++){
		     myimg = document.images[i];
		     if(myimg.width > maxwidth)
		     {
		        oldwidth = myimg.width;
		        myimg.style.width = maxwidth;
		        myimg.style.height = "auto";
		     }
		   }
		}
		ResizeImages();
	   </script>
	   
	 
<!--footer-->
<!--bottom-->
<div class="footernew">
	<a href="/templates/default/jsp/about_us.jsp">关于我们</a> | <a href="/templates/default/jsp/service.jsp">服务条款</a> | <a href="/templates/default/jsp/recruitment.jsp">企业招聘</a> | <a href="/templates/default/jsp/customer_service.jsp">客服中心</a> | <a href="/templates/default/jsp/site_navigation.jsp">网站导航</a> | <a href="/templates/default/jsp/copyright.jsp">版权所有</a><br />
<img src="/templates/default/images/ucs2.gif" align="absmiddle"/>&nbsp;产品购买咨询：肖先生
    (QQ)<a href="http://wpa.qq.com/msgrd?V=1&Uin=31688721&Site=a-hai.net&Menu=yes tencent://message/?uin=31688721" target=_blank class="lanse">31688721</a> 
    (MSN)<a href=msnim:chat?contact=xiaobo68@gmail.com>xiaobo68@gmail.com</a>  <a href="http://www.wanglong.cc" target="_blank" class="lanse">合肥贞龙信息技术有限公司</a> 版权所有 &copy;  2008  保留所有权利 <a href="http://www.miibeian.gov.cn/" target=_blank>皖ICP备07039386号</a><br />
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



