<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<html>
	<head>
		<title>�¿ͻ�ע��</title>
		<link rel="stylesheet" type="text/css" href="/templates/default/style/layout.css" />
		<link rel="stylesheet" type="text/css" href="/templates/default/style/login.css" />
</head>
<%@ page import="com.saas.biz.custMgr.Custinfo"%>
<%@ page import="com.saas.biz.commen.config"%>
<%@ page import="com.saas.biz.commen.ParamethodMgr"%>
<%@ page import="com.saas.biz.custMgr.CustClass"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.saas.biz.commen.commMethodMgr"%>
<%@ page import="java.util.*"%>
<body>
	
	<%
		String cust_id = "",cust_name="",user_id="";
		
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
    if(request.getParameter("user_id")!=null){
			user_id = request.getParameter("user_id");
		}
		
    ArrayList custList = custInfo.getCustInfo(cust_id);
    String email = "";
    if(custList!=null){
    	for(int i =0;i<custList.size();i++){
    		HashMap custMap = (HashMap)custList.get(0);
    		if(custMap.get("email")!=null){
    			email = custMap.get("email").toString();
    		}
    	}
    }
    
    String reg_email="";
    if(!email.equals("")){
    	reg_email = "mail."+email.substring(email.indexOf("@")+1,email.length());
    }
    
	%>
	
	
<div id="login_top">
	<div class="logo" style="background:url(<%=logourl%>) no-repeat left top !important; background:none; _filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, sizingMethod=image, src='<%=logourl%>'">
	<h1><a href="<%=logolink%>" title="<%=webtitle%>"><%=webtitle%></a></h1>
	</div>
	<div class="top_right lin4"> 
		<A title=����վ��Ϊ�����ҳ onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://'+window.location.host);return false;" href="javascript:;">��Ϊ��ҳ</a> | <a href=javascript:window.external.AddFavorite(top.location.href)>�ղر�ҳ</a><br>
		����ע�������벦��<span>0551-5310317</span>
  </div>
</div>
<div id="login_body">
	<div id="login_box">
		<div class="login_lmt">
			<div class="lmt1">ע��ɹ�</div>
		</div>
		<div class="regsuccess_text">
		<span>��ϲ�� <%=cust_name%> ע��ɹ�</span><br />
		��ӭ����<%=seo%>�����Ѿ������������������ˣ�
		</div>
		
		<div class="reg_mail">
			<div class="reg_mail_img"><img src="/templates/default/images/reg_re_03.gif" width="147" height="166"></div>
		 	<div class="reg_mail_right lin3 link_xian">
				<strong>�������仹ûͨ����֤��</strong>�����ѽ���֤�ŷ������ĵ������䣡<br />
				�뵽<a href="http://<%=reg_email%>"> <%=email%></a> ���ţ�ȷ�Ϻ󼴿���֤�ɹ���<br />
				<span style="line-height:50px;">
					<a href="http://<%=reg_email%>"><img src="/templates/default/images/reg_re_06.gif" align="absmiddle" border="0" /></a>
						���������������<a href="javascript:showForm();">�����޸�</a></span> <br />
				<form action="/doTradeReg.do" name="upEmail" method="post" id="disForm" style="display:none;">
					<input type="hidden" name="cust_id" value="<%=cust_id%>">
					<input type="text" name="email" id="email" value="<%=email%>" maxlength="30" size="20"><img src="/images/amend.gif" border="0" onclick="xiuEmail();" style="cursor:hand;"><br>
					<input type="hidden" name="trade_type_code" id="trade_type_code" value="9954">
				</form>
			<script language="javascript">
				function showForm(){
					if(document.getElementById('disForm').style.display=='none'){
						document.getElementById('disForm').style.display='block';
					}else{
						document.getElementById('disForm').style.display='none';
					}
				}
				function showForm2(){
					if(document.getElementById('upCustClass').style.display=='none'){
						document.getElementById('upCustClass').style.display='block';
					}else{
						document.getElementById('upCustClass').style.display='none';
					}
				}
				
				function xiuEmail(){
					 var email = document.getElementById('email').value;
					 if(email==''){
						 alert('Emial����Ϊ�գ�');
						 return false;
					 }
					 var regemail = /^\s*\w+\@\w+(\.\w+)+\s*$/i;   
					 if(!regemail.test(email)){   
					 		alert('email��ʽ����ȷ��');
					 		document.getElementById('email').focus();
					 		return false;
					 }	
					 document.upEmail.submit();
				}
			</script>
				
			  <span style="color:#FF7E00; font-size:12px;">
			  <strong>�ǳ���Ҫ��</strong>���ǿͻ�������ϵ����ѡ��ʽ���������д��ʵ����ȷ��������õĵ����ʼ���</span>			
			</div>
		</div>
	</div>
	
	<div id="login_box1">
		<div class="text_one">�������������һ����<a href="/member/index.html"><img src="/templates/default/images/reg_re_11.gif" align="absmiddle" border="0"></a> ������Ʒ���ð�����������ҵ�����</div>
		<div class="text_two_lmt">�������� <img src="/templates/default/images/reg_tb.gif" align="absmiddle"></div>
		<div class="text_one link_xian">
			���ƹ�˾��� <a href="javascript:showForm2()">�û�����</a> ��ѿ�ͨ���� ݬȡ�ͻ���������ҵ�ܹ�ע<br />
			�̻�����������! ��Ѷ��Ĺ�����Ϣ  ��©��ÿ������
		</div>
		<form action="/doTradeReg.do" name="form0" method="post" id="upCustClass" style="display:none;">
				<%
					String start_date = "";
					SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
					start_date = formate.format(new Date());
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.YEAR, 50);
					String end_date = formate.format(cal.getTime());
					CustClass level = new CustClass();
					String class_Name = "";
					class_Name = level.cust_Class_ID(cust_id);
					ParamethodMgr paramCom = new ParamethodMgr();
					ArrayList customer_class = new ArrayList();
					customer_class = paramCom.getCompareInfoByNotIN("14",class_Name);
				%>
				 <span style="color:#FF7E00; font-size:14px; padding-left:20px;">&nbsp;&nbsp;
				 	<strong>��ѡ�����������ļ���</strong><br>&nbsp;&nbsp;
					<%
					 commMethodMgr commen = new commMethodMgr();
					 String trade_id = commen.GenTradeId();
						int size=0;
						if(customer_class!=null){
						size = customer_class.size();
						String cust_class1="",cust_name1="";
							for(int i=0;i<customer_class.size();i++){
								HashMap classMap = (HashMap)customer_class.get(i);
								if(classMap.get("para_code2")!=null){
									cust_name1 = classMap.get("para_code2").toString();							
								}
								if(classMap.get("para_code1")!=null){
									cust_class1 = classMap.get("para_code1").toString();							
								}
								if(cust_class1.equals("1")){
									continue;
								}								
					%>
					<input type="radio" name="cust_class_t" id="cust_class_t" value="<%=cust_class1%>"><%=cust_name1%>
					<%
							}
						}
					%>
						<br>
						<input type="hidden" id="app_level" name="app_level" value=""></span><br>
					<%for(int j=0;j<size*2+4;j++){%>
						&nbsp;
						<%}%>
					<input type="hidden" name="cust_id" id="cust_id" value="<%=cust_id%>">
					<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>">
					<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>">
					<input type="hidden" name="pass_or_not" id="pass_or_not" value="0">
					<input type="hidden" name="now_class_type" id="now_class_type" value="<%=class_Name%>">
					<input type="hidden" name="trade_type_code" id="trade_type_code" value="2569">
					<input type="hidden" name="cust_class" id="cust_class" value="">
					<input type="hidden" name="trade_id" id="trade_id" value="<%=trade_id%>">
					<img src="/images/tj.gif" border="0" onclick="javascript:SendClass();" style="cursor:hand;">
				</form>
			</div>
	</div>
	
 

<jsp:include page="/footer/jsp/bottom.jsp"/>
</body>
</html>
<script language="javascript">
	function SendClass(){
		var falg= -1 ;
		var val = '';
		//var app_level = document.getElementById("app_level").value;
		var objs = document.getElementsByName("cust_class_t");
		for(var i=0;i<objs.length;i++)   
		 {   
 			if(objs[i].checked)   
  		{
  			val = objs[i].value;
  			falg = 1;
  		}
  	}
  	if(val==''){
  		alert("��ѡ�����������Ŀͻ�����");
  		return false;	
  	}
  	else{
	  	document.getElementById("app_level").value = val;
	  	//document.getElementsByID("trade_type_code").value='0567';
			//alert(document.getElementById("cust_class").value);
	  	document.form0.submit();
	  }
	}
</script>



