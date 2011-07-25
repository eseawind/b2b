<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<html>
	<head>
		<title>新客户注册</title>
		<link rel="stylesheet" type="text/css" href="/templates/default/style/login.css" />
</head>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.commen.config"%>
<%@ page import="java.util.*"%>
<body>
	
<%
		String cust_id = "",cust_name="";
		
		
		config configFile = new config();
		configFile.init();
		String seo = configFile.getString("seo");
		String logourl = configFile.getString("logourl");
		String webtitle = configFile.getString("webtitle");
		String logolink = configFile.getString("logolink");
		
		Custinfo custInfo=new Custinfo();
		if(request.getParameter("cust_id")!=null){
			cust_id = request.getParameter("cust_id");
			cust_name=custInfo.getCustomerNameById(cust_id);
		}
    
		
		
%>	

<div id="login_top">
	<div class="logo" style="background:url(<%=logourl%>) no-repeat left top !important; background:none; _filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, sizingMethod=image, src='<%=logourl%>'">
	<h1><a href="<%=logolink%>" title="<%=webtitle%>"><%=webtitle%></a></h1>
	</div>
	<div class="top_right lin4">
		<A title=将本站设为你的首页 onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://'+window.location.host);return false;" href="javascript:;">设为首页</a> | <a href=javascript:window.external.AddFavorite(top.location.href)>收藏本页</a></br>
		如遇注册问题请拨打，<span>0551-5310317</span>
  </div>
</div>
<div id="login_body">
	<div id="login_box" style="height:264px;">
		<div class="login_lmt">
			<div class="lmt1">注册成功</div>
		</div>
		<div class="regsuccess_two_text">
		<span class="span">恭喜您 <%=cust_name%> 注册成功</span><br />
		<span class="span_text">为确保真实性，须管理员验证通过才能正常使用！请稍后关注！</span>
		</div>
		
		<div class="reg_mail">
			<div class="reg_two_img"><img src="/templates/default/images/reg_07.gif"></div>
	 	  <div class="reg_two_right lin3 link_xian">	
<span>现在，您可以进行如下操作：<br />
			  <a href="/">返回网站首页</a>,<a href="/default/supply">浏览供应信息</a>,<a href="/default/stock">浏览求购信息</a>,				</span>	
			</div>
		</div>
	</div>
	
	<div class="tel lin3 link_xian"><span>升级为<a href="#">高级会员</a>,享受更多特权 优先赢得买家信任！</span><img src="/templates/default/images/reg_14.gif" align="absmiddle"> 咨询热线：0551-5310317</div>
	
</div>

<jsp:include page="/footer/jsp/bottom.jsp"/>
</body>
</html>




