<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<html>
	<head>
		<title>�¿ͻ�ע��</title>
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
		<A title=����վ��Ϊ�����ҳ onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://'+window.location.host);return false;" href="javascript:;">��Ϊ��ҳ</a> | <a href=javascript:window.external.AddFavorite(top.location.href)>�ղر�ҳ</a></br>
		����ע�������벦��<span>0551-5310317</span>
  </div>
</div>
<div id="login_body">
	<div id="login_box" style="height:264px;">
		<div class="login_lmt">
			<div class="lmt1">ע��ɹ�</div>
		</div>
		<div class="regsuccess_two_text">
		<span class="span">��ϲ�� <%=cust_name%> ע��ɹ�</span><br />
		<span class="span_text">Ϊȷ����ʵ�ԣ������Ա��֤ͨ����������ʹ�ã����Ժ��ע��</span>
		</div>
		
		<div class="reg_mail">
			<div class="reg_two_img"><img src="/templates/default/images/reg_07.gif"></div>
	 	  <div class="reg_two_right lin3 link_xian">	
<span>���ڣ������Խ������²�����<br />
			  <a href="/">������վ��ҳ</a>,<a href="/default/supply">�����Ӧ��Ϣ</a>,<a href="/default/stock">�������Ϣ</a>,				</span>	
			</div>
		</div>
	</div>
	
	<div class="tel lin3 link_xian"><span>����Ϊ<a href="#">�߼���Ա</a>,���ܸ�����Ȩ ����Ӯ��������Σ�</span><img src="/templates/default/images/reg_14.gif" align="absmiddle"> ��ѯ���ߣ�0551-5310317</div>
	
</div>

<jsp:include page="/footer/jsp/bottom.jsp"/>
</body>
</html>




