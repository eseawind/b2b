var xmlHttp = null;
var nanShanMilk = false;
var custAim = false;
function  SubmitReg()
{   
		
	  var userName = document.NewRegisterForm.user_name.value;
	  if(null == userName || userName == "")
	  {
	  	alert("��½������Ϊ��!");
	  	document.NewRegisterForm.user_name.focus();
	  	return false;
	  }
	  if(custAim==false)
	  {
	  	alert("��˾�����Ѿ��������û�ռ��!");
	  	//document.NewRegisterForm.cust_aim.focus();
	  	return false;
	  }
	  var realname = document.NewRegisterForm.cust_name.value;
	  if(null == realname || realname == "")
	  {
	  	alert("��ʵ��������Ϊ��!");
	  	document.NewRegisterForm.cust_name.focus();
	  	return false;
	  }
	  
	   var q=document.getElementsByName("sex1");
   	 for(j=0;j<q.length;j++)
      if(q[j].checked){
     document.getElementById("sex").value = q[j].value; 	
     }
    
		var class_idSM = document.getElementById("sort1").value;
		var class_id2 = document.getElementById("class_id").value;
		if((null == class_id2 || class_id2 == "") && class_idSM!="E2WE2R3cjxJ13g5"){
			alert("��ѡ����ҵ����");
			return false;
		}
	  
	   var pd0 = document.NewRegisterForm.passwd[0].value;
	  
	  if(null == pd0 || pd0 == "")
	  {
	  	alert("�����趨����Ϊ��!");
	  	document.NewRegisterForm.passwd[0].focus();
	  	return false;
	  }
	   var pd1 = document.NewRegisterForm.passwd[1].value;
	  
	  if(null == pd1 || pd1 == "")
	  {
	  	alert("ȷ�����벻��Ϊ��!");
	  	document.NewRegisterForm.passwd[1].focus();
	  	return false;
	  }
	    var custName = document.NewRegisterForm.cust_aim.value;
	    custName = document.getElementById("cust_aim").value;
	  
	  if(null == custName || custName == "")
	  {
	  	alert("��˾������Ϊ��!");
	  	document.getElementById("cust_aim").focus();
	  	return false;
	  }
	  var a_b = document.getElementById("group_a").value+document.getElementById("group_b").value;
	  if(null == a_b || a_b == ""){
	  	alert("��Ӫ������Ϊ�գ�");
	  	document.getElementById("group_a").focus();
	  	return false;	
	  }
	  
	  
	if (document.getElementById("company_address").value == ""||document.getElementById("company_address").value == null)
	{
		alert("��Ӫ��ַ������Ϊ��!");
		document.getElementById("company_address").focus(); 
		return false;
	}
	if (document.getElementById("province").value == "��ѡ��"||document.getElementById("province").value == null)
	{
		alert("��˾���ڵز���Ϊ��!");
		return false;
	}
    var Email = document.NewRegisterForm.email.value;
	  if(null == Email || Email == "")
	  {
	  	alert("Email����Ϊ��!");
	  	document.NewRegisterForm.email.focus();
	  	return false;
	  }
	
	var group_contact_phone = document.NewRegisterForm.group_contact_phone.value;
	  if(null == Email || Email == "")
	  {
	  	alert("��ϵ�绰����Ϊ��!");
	  	document.NewRegisterForm.group_contact_phone.focus();
	  	return false;
	  }
	
		var div = document.getElementById("divUsername");
		var pic1 = div.innerHTML;
		var div = document.getElementById("divPassword1");
		var pic2 = div.innerHTML;
		var div = document.getElementById("divPassword2");
		var pic3 = div.innerHTML;
		var div = document.getElementById("divCustName");
		var pic4 = div.innerHTML;
		var div = document.getElementById("divQues");
		var pic5 = div.innerHTML;
		var div = document.getElementById("teleDiv");
		var pic6 = div.innerHTML;

		if(pic1.indexOf("icon_error_small.gif") >= 0)
		{
			alert("��½����д����!��������д!");
		  document.NewRegisterForm.user_name.focus();
			return false;
		}else if(pic2.indexOf("icon_error_small.gif") >= 0){
			alert("�����趨����!��������д!");
		  document.NewRegisterForm.passwd[0].focus();
			return false;
		}else if(pic3.indexOf("icon_error_small.gif")>=0){
			alert("ȷ���������!��������д!");
		  document.NewRegisterForm.passwd[1].focus();
			return false;
		}else if(pic4.indexOf("icon_error_small.gif")>=0){
			alert("��˾����д����!��������д!");
		  document.NewRegisterForm.cust_aim.focus();
			return false;
		}else if(pic5.indexOf("icon_error_small.gif")>=0){
			alert("Email��д����!��������д!");
		  document.NewRegisterForm.email.focus();
			return false;
		}else if(pic6.indexOf("icon_error_small.gif")>=0){
				alert("��ϵ�绰��д����!��������д!");
				document.NewRegisterForm.group_contact_phone.focus();
				return false;
		}
		if( window.frames["randomcode"].document.getElementById("reg").style.display != "")
		{
				var loguserrand = window.frames["randomcode"].document.getElementById("reguserrand").value;
				 
				document.NewRegisterForm.userrand.value=loguserrand;
				 
				if( loguserrand == "" )
				{
					alert('��֤�벻����Ϊ�գ�');
					window.frames["randomcode"].document.getElementById("reguserrand").focus();
					return false;
				}
				
			}	
			
	if(document.getElementById('agreement').checked==false){
		alert('��ѡ��ͬ��������');
		return false;
	}
	document.getElementById("group_memo").value = document.getElementById("group_a").value+"|"+document.getElementById("group_b").value;
	document.getElementById("city").value = document.getElementById("city_code").value;
	
	if (document.getElementById("province").value != "��ѡ��"&&document.getElementById("province").value != null){
			if(document.getElementById("eparchy_code").value == "��ѡ��"||document.getElementById("eparchy_code").value == null){
					document.getElementById("eparchy_code").value='0';
				}
			if(document.getElementById("city_code").value == "��ѡ��"||document.getElementById("city_code").value == null){
					document.getElementById("city_code").value='0';
				}
		}
		
		
		if(nanShanMilk)  
   	{  
      return false;  
   	}  
   	else  
   	{  
      nanShanMilk  =  true;  
      return true;
  	}
  	
}


  
  
function Check_Reg_Value()
{	
	var reg = /[^a-z0-9]/g; 
	var chemkName = new RegExp("^[a-z0-9]+$");
	var user_name = document.NewRegisterForm.user_name.value;
	if (user_name == ""|| user_name == null)
	{
		alert("�˺Ų�����Ϊ��!");
		document.NewRegisterForm.user_name.focus(); 
		return false;
	}else if (!chemkName.test(user_name)){
		alert("��ʽ����,��������д!");	
		return false;
	}else if(user_name.length<6){
		alert("��½��������6��дӢ����ĸ�������ַ����!");	
		return false;
	}else {
		//CheckRegUsername();	
	}
	
	
	if (document.getElementById("passwd[0]").value == ""||document.getElementById("passwd[0]").value == null)
	{
		alert("���벻����Ϊ��!");
		document.getElementById("passwd[0]").focus(); 
		return false;
	}else if(document.getElementById("passwd[0]").value.length<6){
		alert("���볤�Ȳ���С��6λ������������!");
		document.getElementById("passwd[0]").focus(); 
		return false;
	}
	if (document.getElementById("passwd[1]").value == ""||document.getElementById("passwd[1]").value == null)
	{
		alert("ȷ�����벻����Ϊ��!");
		document.getElementById("passwd[1]").focus(); 
		return false;
	}else if(document.getElementById("passwd[1]").value.length<6){
		alert("ȷ�����볤�Ȳ���С��6λ������������!");
		document.getElementById("passwd[1]").focus(); 
		return false;
	}
	if (document.getElementById("passwd[0]").value != document.getElementById("passwd[1]").value)
	{
		alert("�����������벻һ��!");
		document.getElementById("passwd[0]").value=''; 
		document.getElementById("passwd[1]").value=''; 
		document.getElementById("passwd[0]").focus(); 
		return false;
	}
	
	if (document.getElementById("cust_aim").value == ""||document.getElementById("cust_aim").value == null)
	{
		alert("��˾��������Ϊ��!");
		document.getElementById("cust_aim").focus(); 
		return false;
	}
	
	if ( document.getElementById("agreement").checked == false )
	{
		alert("����û���Ķ�����ע���������!");
		
		return false;
	}
	
	var chemEmail1=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
	if (document.getElementById("email").value == ""||document.getElementById("email").value == null)
	{
		alert("�����ַ����Ϊ��!");
		document.getElementById("email").focus(); 
		return false;
	}else if(!chemEmail1.test(document.getElementById("email").value)){
		alert("Email�ĸ�ʽ�����_!");
		document.getElementById("email").focus(); 
		return false;
	}
	
	var chckTele2=/^(((13[0-9]{1})|158|159|153)+\d{8})$/;
	var chckTele1=/^(((\()?\d{2,4}(\))?[-(\s)*]){0,2})?(\d{7,8})$/;//024-258963
	var chckTele3=/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
	var chckTele4=/^(((\()?\d{2,4}(\))?[-(\s)*]){0,2})?(\d{7,8})$/;
	var group_contact_phone = document.NewRegisterForm.group_contact_phone.value;
  if(null == group_contact_phone || group_contact_phone == "")
  {
  	alert("��ϵ�绰����Ϊ��!");
  	document.NewRegisterForm.group_contact_phone.focus();
  	return false;
  }else if(!chckTele1.test(group_contact_phone)&&!chckTele2.test(group_contact_phone)&&!chckTele3.test(group_contact_phone))
	{
	 	alert("�绰��ʽ��,����д!��:�ֻ��Ż�0551-5310317!");
  	document.NewRegisterForm.group_contact_phone.focus();
  	return false;
	}
	
	var userrand = window.frames["randomcode"].document.getElementById("reguserrand").value;
  if( userrand != "" )
  {
  	document.getElementById( "userrand" ).value=userrand;
  	
	}
}

function ContactVisabled(visabled)
{
	for(var index = 1; index <= 17; index++)
		document.getElementById("trContact" + index).style.display = (visabled ? "block" : "none");
}

function CompanyVisabled(visabled)
{
	document.getElementById("tabCompany").style.display = (visabled ? "block" : "none");
	document.getElementById("spnCompany").style.display = (visabled ? "block" : "none");
}

function showSalebuy(sale, buy)
{
	document.getElementById("trSale").style.display = (sale ? "block" : "none");
	document.getElementById("trBuy").style.display = (buy ? "block" : "none");
}
function checkTele(state) 
{
var div = document.getElementById("teleDiv");
var tele=document.NewRegisterForm.group_contact_phone.value;
//var chckTele1=new RegExp("^1\d{10}$");
//var chckTele1 =/^[1][3][0-9]{9}$/; 
var chckTele2=/^(((13[0-9]{1})|158|159|153)+\d{8})$/;
var chckTele1=/^(((\()?\d{2,4}(\))?[-(\s)*]){0,2})?(\d{7,8})$/;//024-258963
var chckTele3=/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
var chckTele4=/^(((\()?\d{2,4}(\))?[-(\s)*]){0,2})?(\d{7,8})$/;
if(state)
  {
	div.className="green";
	div.innerHTML="��������д�����˵���ϵ�绰���Է�������������ͨ! ";
	return false;
  }else if(null==tele||tele.length<=0)
	   {
	   	div.className="orange";
			div.innerHTML="<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;�绰����Ϊ��!";
			return false;
		}else if(!chckTele1.test(tele)&&!chckTele2.test(tele)&&!chckTele3.test(tele))
		 {
		 	 	div.className="orange";
				div.innerHTML="<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;�绰��ʽ��,����д!��:�ֻ��Ż�0551-5310317!";
				return false;
			}
     else
     	{
     		div.className="";
				div.innerHTML="<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��д��ȷ!";
				return false;
     		
     		}
	
}
function checkEmail(state){
var mail=document.NewRegisterForm.email.value;
var div = document.getElementById("divQues");
var chemEmail=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
if(state)
{
	div.className="green";
	div.innerHTML="����д�����ַ,ϵͳ�����ʼ������͵��������!";
	var mail=document.NewRegisterForm.email.value="";
	return false;
}
if(mail.length<=0)
{
  div.className="orange";
	div.innerHTML="<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;Email����Ϊ��!";
	return false;
}
 else if (!chemEmail.test(mail)){
					div.className="orange";
					div.innerHTML="<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;Email�ĸ�ʽ�����_!";
					return false;
}
if(mail.length>0){
      UserInfo.getEmailAddrExist(mail,function(data){
      if(false){
      	div.className="orange";
		    div.innerHTML="<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;���ʼ���ַ�ѱ�ʹ�ã���������д�����ʼ���ַ!";
       }
       else
       	{
       		div.className = "";
		      div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��д��ȷ!"
       		}
     });
    }
}
function user_name_focus(state)
{
	var user_name = document.NewRegisterForm.user_name.value;
	var chemkName = new RegExp("^[a-z0-9]+$");
	var div = document.getElementById("divUsername");

	if(state){
		div.className = "green";
		div.innerHTML = "��½����6~20��СдӢ����ĸ�������ַ����!";
		return false;
	}else if(user_name=="" || user_name==null){
		div.className = "orange";
		div.innerHTML = "<img   src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��½������Ϊ��!";
    return false;
  }else if(!chemkName.test(user_name)){
		div.className = "orange";
		div.innerHTML ="<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��ʽ����,��������д!";
		return false;
	}else if(user_name.length<6){
		div.className = "orange";
		div.innerHTML ="<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��½��������6��дӢ����ĸ�������ַ����!";
	  return false;
	}else{
		div.className = "";
		div.innerHTML = "<img src=\"/admin/images/server.gif\" align=\"absmiddle\">&nbsp;���ڷ�������У���½��!";
		CheckUsername();
	}
}

function user_name_real(state)
{
	var cust_name = document.NewRegisterForm.cust_name.value;
	var div = document.getElementById("realname");
	if(state){
	if(cust_name=="" || cust_name==null){
		div.className = "orange";
		div.innerHTML = "<img   src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��ʵ��������Ϊ��!";
   		 return false;
  		}
	 else if(cust_name != "" || cust_name!=null)
		{
			div.className = "";
			div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��д��ȷ!";
		}
	}
}
function companyaddress(state)
{
	var cust_name = document.NewRegisterForm.company_address.value;
	var div = document.getElementById("company_address11");
	if(state){
	if(cust_name=="" || cust_name==null){
		div.className = "orange";
		div.innerHTML = "<img   src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��Ӫ��ַ����Ϊ��!";
   		 return false;
  		}
	 else if(cust_name != "" || cust_name!=null)
		{
			div.className = "";
			div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��д��ȷ!";
		}
	}
}
function selecttypeInfo(state,val)
{
	var cust_name = val;
	//alert(val);
	document.getElementById("text2").value = val;
	var div = document.getElementById("index_s4");
	if(state){
		if(cust_name=="" || cust_name==null ){
			div.className = "orange";
			div.innerHTML = "<img   src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��ҵ���ͱ���ѡ��!";
	   		 return false;
	  }
	 else if(cust_name != "" && cust_name!=null)
		{
			div.className = "";
			div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;ѡ��������ȷ!";
			}
		}
}
function selectarea(state)
{
	var cust_name = document.NewRegisterForm.province.value+document.NewRegisterForm.eparchy_code.value+document.NewRegisterForm.city_code.value;
	var div = document.getElementById("cityname");
	if(state){
	if(cust_name=="" || cust_name==null){
		div.className = "orange";
		div.innerHTML = "<img   src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��˾���ڵر���ѡ��!";
   		 return false;
  		}
	 else if(cust_name != "" || cust_name!=null)
		{
			div.className = "";
			div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;ѡ�������ȷ!";
		}
	}
}


function selectcall(state)
{
	var cust_name = document.NewRegisterForm.calling_type_code.value;
	var div = document.getElementById("calltype1");
	if(state){
	if(cust_name=="" || cust_name==null){
		div.className = "orange";
		div.innerHTML = "<img   src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��ҵ���ͱ���ѡ��!";
   		 return false;
  		}
	 else if(cust_name != "" || cust_name!=null)
		{
			div.className = "";
			div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;ѡ����ҵ������ȷ!";
		}
	}
}



function group_a_b(state)
{
	var temp=document.getElementsByName("develope_channel");
	var cust_name;
	//for (i=0;i<temp.length;i++){
	if(temp[0].checked){
      	cust_name = document.NewRegisterForm.group_a.value;
	}
	if(temp[1].checked){
      	cust_name = document.NewRegisterForm.group_b.value;
	}
	if(temp[2].checked){
      	cust_name = document.NewRegisterForm.group_a.value+document.NewRegisterForm.group_b.value;
	}
	var div = document.getElementById("groubab");
	if(state){
	if(cust_name=="" || cust_name==null){
		div.className = "orange";
		div.innerHTML = "<img   src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��Ӫ���������д!";
   		 return false;
  		}
	 else if(cust_name != "" || cust_name!=null)
		{
			div.className = "";
			div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��Ӫ������д��ȷ!";
		}
	}
}



function password_focus(state, value)
{
	var pwd = document.NewRegisterForm.passwd[value];
	var div = document.getElementById("divPassword" + (value + 1));
	
	if(state)
	{
		div.className = "green";
		div.innerHTML = value ? "��������һ����������д������!" : "������6-20��Ӣ����ĸ(���ִ�Сд)���������!";
	}
	else
	{  
		div.className = "orange";
		div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��д��ȷ!"
		
		if(pwd.value.length == 0)
			div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;" + (value ? "��������һ����������д������!" : "���벻��Ϊ��!");
		else if(!/\w/.test(pwd.value))
			div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;" + (value ? "" : "ȷ��") + "������6-20��Ӣ����ĸ(���ִ�Сд)��������� !";
		else if(value == 1 && pwd.value != document.NewRegisterForm.passwd[0].value)
			div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;�����������벻һ��!";
		else	if(pwd.value.length < 6)
			div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;" + ("���볤�Ȳ���С��6λ������������!");
		else
			div.className = "";
		
	}
}

function passwd_ques_focus(state)
{
	var ques = document.NewRegisterForm.passwd_answer;
	var div = document.getElementById("divQues");
	
}

function CustName_focus(state,val)
{
	var checkCusNme=new RegExp("^[a-z0-9]+$");
	var cust = document.NewRegisterForm.cust_aim.value;
	cust  = document.getElementById("cust_aim").value;
	var div = document.getElementById("divCustName");
	
	//cust.value = cust.value.replace(/\s/, "");

	if(state)
	{
		div.className = "green";
		div.innerHTML = "����ע����ҵ��������������д�ڹ��̾�ע���ȫ��!";
		return false;
	}else if(null==cust||cust=="") {
			div.className = "orange";
			div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��˾���Ʋ���Ϊ��!";
			return false;
	}else{
			div.className = "";
			div.innerHTML = "<img src=\"/admin/images/server.gif\" align=\"absmiddle\">&nbsp;���ڷ�������У�鹫˾��!";
			CheckCustname();
	}
}

function CCCName_focus(state)
{
	var cust = document.NewRegisterForm.cust_aim;
	var div = document.getElementById("divCCCName");
	
	cust.value = cust.value.replace(/\s/, "");
	
	if(state)
	{
		div.className = "green";
		div.innerHTML = "СдӢ����ĸ�����ġ�������ɣ�����4��20���ַ�!";
	}
	else
	{
		if(/\S+/.test(cust.value))
		{
			div.className = "";
			div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��д��ȷ!"
		}
		else
		{
			div.className = "orange";
			div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��˾���Ʋ�����Ϊ��!";
		}
	}
}

function salebuy_service_focus(state, element)
{
	var div = document.getElementById(element);
	
	if(state)
		div.className = "orange";
	else
		div.className = "";
}

function CheckCustname()
{
	var custName =  document.NewRegisterForm.cust_aim;
	custName = document.getElementById("cust_aim");
	if(xmlHttp == null)
		xmlHttp = createXmlHttp();
	
	if(xmlHttp == null)
	{
		div.className = "";
		div.innerHTML = "���������̫�ɻ�ֻ֧�� AJAX �������޷����е�½�����!";
		return;
	}
	xmlHttp.abort();
	xmlHttp.onreadystatechange = readyStateChangeCust;
	xmlHttp.open("GET", "/member/chkcust.jsp?c=" + UrlEncode(custName.value));
	xmlHttp.send(null);
}

function readyStateChangeCust()
{
	if(xmlHttp.readyState == 4)
	{
		if(xmlHttp.status == 200)
		{
			var div = document.getElementById("divCustName");
			var result = xmlHttp.responseText;
			if(result == 0)
			{
				div.className = "";
				div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��д��ȷ�����ҿ���ʹ��!";
				custAim = true;
			}
			else
			{
				div.className = "orange";
				div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��˾�����Ѿ��������û�ռ��!";
				
				custAim = false;
			}
		}
		else
		{
			div.className = "";
			div.innerHTML = "���������ش��󣬼���½��ʧ��!";
		}
	} 
}
function CheckUsername()
{

	var user_name = document.NewRegisterForm.user_name;
	var div = document.getElementById("divUsername");
	
	if(xmlHttp == null)
		xmlHttp = createXmlHttp();
	if(xmlHttp == null)
	{
		div.className = "";
		div.innerHTML = "���������̫�ɻ�֧�� AJAX �������޷����е�½�����!";
		return;
	}

	xmlHttp.abort();
	xmlHttp.onreadystatechange = readyStateChange;
	xmlHttp.open("GET", "/member/chkusr.jsp?u=" + UrlEncode(user_name.value));
	xmlHttp.send(null);
}

function readyStateChange()
{	
	if(xmlHttp.readyState == 4)
	{ 
		if(xmlHttp.status == 200)
		{
			var div = document.getElementById("divUsername");
			var result = xmlHttp.responseText;
			if(result ==1)
			{
				div.className = "";
				div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��д��ȷ�����ҿ���ʹ��!";
			}
			else
			{
				div.className = "orange";
				div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��½�����Ѿ��������û�ռ��!";
        
			}
		}
		else
		{
			div.className = "";
			div.innerHTML = "���������ش��󣬼���½��ʧ��!";
		}
	} 
}
/***
 * �ж������ǲ����Ѵ���
 */
function checkUserNameExists(name){
	var div=document.getElementById("divUsername");
	if(name=="" || name==null){
		div.className = "orange";
		div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;�������ʺ�����!";
		document.getElementById("user_name").focus();
	}else{
	UserInfo.getCustIdByUserName(name,function(result){
		if(result == "" || result==null)
		{
			div.className = "";
			div.innerHTML = "<img src=\"/admin/images/icon_yes_small.gif\" align=\"absmiddle\">&nbsp;��д��ȷ�����ҿ���ʹ��!";
		}
		else
		{
			alert(name+":�û��Ѵ��ڣ�������д��д��");
			div.className = "orange";
			div.innerHTML = "<img src=\"/admin/images/icon_error_small.gif\" align=\"absmiddle\">&nbsp;��½�����Ѿ��������û�ռ��!";
			document.getElementById("user_name").value="";
	
		}
	});
  }
}	
function getSubitems(obj, classid, emptyName, emptyValue)
{
	var xmlHttp = createXmlHttp();
	
	if(classid == null)
		return;
	else if(classid == "000000000000000") 
		classid = "";
	xmlHttp.open("GET", "/subsortitems.jsp?classid=" + UrlEncode(classid), false);
	xmlHttp.send(null);
	
	var result = xmlHttp.responseText;
	if(result == null || result.length == 0)
	{
		obj.options.length = 0;
		this.sortDisplay();
		return;	
	}
	else
	{
		obj.options.length = 0;
		
		if(emptyName != null || emptyValue != null)
			obj.options.add(new Option(emptyName, emptyValue));
		
		result = result.split("\n");
		for(var index = 0; index < result.length; index++)
		{
			var columns = result[index].split(",");
			if(columns.length>1)
			{
			var option = new Option(columns[3], columns[0])			
			obj.options.add(option);
			}
		}
		
		this.sortDisplay();
	}
}

function sortDisplay()
{
	if(document.NewRegisterForm.sort2.options.length == 0)
	{
		document.NewRegisterForm.sort2.style.display = "none";
		document.NewRegisterForm.sort3.style.display = "none";
	}
	else
	{
		document.NewRegisterForm.sort2.style.display = "block";
	}
	
	if(document.NewRegisterForm.sort3.options.length == 0)
		document.NewRegisterForm.sort3.style.display = "none";
	else
		document.NewRegisterForm.sort3.style.display = "block";
}

function createXmlHttp()
{
	if (window.ActiveXObject && !window.XMLHttpRequest)
		return new ActiveXObject((navigator.userAgent.toLowerCase().indexOf('msie 5') != -1) ? 'Microsoft.XMLHTTP' : 'Msxml2.XMLHTTP');
	else
		return new window.XMLHttpRequest();
}