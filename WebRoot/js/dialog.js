//addOk.jsp
    function redirectit()
    { 
      alert("ҵ������ɹ���");        
       setTimeout("window.close()",  10);
     }
    function redirectit1()
    { 
                

        window.location.href(""); 
    }
    
//modifyRank.jsp
 function Check_Value()
{
    if (cTrim(document.form1.cust_class.value,0) == "" || document.form1.cust_class.value == null) 
	{                                                                                         
		alert("�ͻ����𲻿���Ϊ�գ�");                                                             
		document.form1.cust_class.focus();                                                    
		return false;                                                                            
	}
	if (cTrim(document.form1.start_date.value,0) == "" || document.form1.start_date.value == null) 
	{                                                                                         
		alert("��Ч��ʼʱ�䲻����Ϊ�գ�");                                                             
		document.form1.start_date.focus();                                                    
		return false;                                                                            
	}                                                                                        
	if (cTrim(document.form1.end_date.value,0) == "" || document.form1.end_date.value == null) 
	{                                                                                         
		alert("��Ч��ֹʱ�䲻����Ϊ�գ�");                                                             
		document.form1.end_date.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (cTrim(document.form1.remark.value,0) == "" || document.form1.remark.value == null) 
	{                                                                                         
		alert("����˵��������Ϊ�գ�");                                                             
		document.form1.remark.focus();                                                    
		return false;                                                                            
	}                                                                                      
 	    return true;
}
function check_none(current_obj)
{
    if (current_obj.advshow.checked)
    {
	    current_obj.submit1.disabled=false;        	     
	}
	else
	{
	    current_obj.submit1.disabled=true;
	}
}
function exit()
{
  window.close();
}
function confirmsub(formobj)
{
  if(window.confirm('��ȷ��Ҫ�ύ��')) 
  {
      if (!Check_Value())
      {
           return;
      }    	            	           
      formobj.submit();    	         
  }
  else
  {
      return;
  }
}

//orderAffirmSuccess.jsp

function paySelect(st){
			   if(st!=''){
				    if(st == 1){
				    	document.getElementById('carriage_pay').value = '15.0';
				    	document.getElementById('carriage_pay_p').innerHTML = '�˷�:15.0Ԫ';
				    }else if(st == 2){
				    	document.getElementById('carriage_pay').value = '6.0';
				    	document.getElementById('carriage_pay_p').innerHTML = '�˷�:6.0Ԫ';
				    }else if(st == 3){
				    	document.getElementById('carriage_pay').value = '25.0';
				    	document.getElementById('carriage_pay_p').innerHTML="�˷�:25.0Ԫ";
				    }
			  	}
			}
			function chickNone(){
				if (document.getElementById('consignee').value == '' || document.getElementById('consignee').value == null){
					alert ('�ջ��˲���Ϊ��!');
					return false;
				}
				if (document.getElementById('addr').value == '' || document.getElementById('addr').value == null){
					alert ('�ջ���ַ����Ϊ��!');
					return false;
				}
				if (document.getElementById('post_code').value == '' || document.getElementById('post_code').value == null){
					alert ('�ʱ಻��Ϊ��!');
					return false;
				}
				if (document.getElementById('phone').value == '' || document.getElementById('phone').value == null){
					alert ('�绰����Ϊ��!');
					return false;
				}
				
				return true;
			}
			
//regInfo.jsp
			function exit(){
		   window.close();
		 }
		 function autoComit(){
		 		//setTimeout(200);
			 //document.index.submit();
		 }
		 
//regsuccess.jsp
	function closeit() 
	{ 	 
		setTimeout("reds()",   2000);   
	}
	function reds() 
	{ 
		URLs="/index.jsp";		 
		window.location.href(URLs);
	}
	
//success.jsp
    function redirectit3()
    { 
       window.opener.location.href = window.opener.location.href;
      if (window.opener.progressWindow) 
       window.opener.progressWindow.close();
       setTimeout("window.opener=null;window.close();",  2000);
     }

    
//uploadOk.jsp
	function closeit() 
	{ 
		setTimeout("window.opener=null;window.close();",   4000);   
	}
	
//upSuccess.jsp
   function redirectit4()
    { 
       window.opener.location.href = window.opener.location.href;
      if (window.opener.progressWindow) 
       window.opener.progressWindow.close();
       setTimeout("window.opener=null;window.close();",  2000);
     }
    function upSuccessredirectit()
    { 
        alert("ҵ������ɹ���");         

        window.location.href("<%=from%>"); 
    }
    
//WealthChangesuccess.jsp
    function WealthChangesuccessredirectit()
    { 
        alert("ҵ������ɹ���");         

        //window.location.href("/custWebMgr/custWebDev.jsp");
        window.open("/wealthMgr/indexMgr.jsp","newwidow");
        window.open('','_self','');
        window.close();
    }
    
//changeWealthSuccess.jsp
  function changeWealthSuccessredirectit()
    { 
        alert("ҵ������ɹ���");       
        //setTimeout("window.close()",  1000);
        window.open("/wealthMgr/manageWealth.jsp","newwidow");
        window.open('','_self','');
        window.close();
       // window.location.href("/zone_b2c/orderAffirmSuccess.jsp"); 
    }
    
//conWebSuccess.jsp

    function conWebSuccessredirectit()
    { 
        alert("ҵ������ɹ���");         

        window.location.href("/actionMgr/contactWebList.jsp"); 
    }
    
//customerWebSuccess.jsp
    function customerWebSuccessredirectit()
    { 
        alert("ҵ������ɹ���");
        window.location.href("/custWebMgr/custWebDev.jsp"); 
    }
    
//custWebSuccess.jsp   
 function custWebSuccessredirectit()
    { 
        alert("ҵ������ɹ���");         

        window.location.href("http://aaa.bizoss.com/searchIndex.jsp"); 
    }
    
//fails.jsp
	function failscloseit()
	{ 
		setTimeout("window.opener=null;window.close();",   2000);   
	}
	
//loginInfo.jsp
	function loginInfocloseit() 
	{
		document.regform.submit();
	}
	
//oppWebSuccess.jsp
		function oppWebSuccessredirectit()
    { 
        alert("ҵ������ɹ���");         

        window.location.href("/oppWebMgr/oppList.jsp"); 
    }
