//addOk.jsp
    function redirectit()
    { 
      alert("业务受理成功！");        
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
		alert("客户级别不可以为空！");                                                             
		document.form1.cust_class.focus();                                                    
		return false;                                                                            
	}
	if (cTrim(document.form1.start_date.value,0) == "" || document.form1.start_date.value == null) 
	{                                                                                         
		alert("有效开始时间不可以为空！");                                                             
		document.form1.start_date.focus();                                                    
		return false;                                                                            
	}                                                                                        
	if (cTrim(document.form1.end_date.value,0) == "" || document.form1.end_date.value == null) 
	{                                                                                         
		alert("有效截止时间不可以为空！");                                                             
		document.form1.end_date.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (cTrim(document.form1.remark.value,0) == "" || document.form1.remark.value == null) 
	{                                                                                         
		alert("操作说明不可以为空！");                                                             
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
  if(window.confirm('你确定要提交吗？')) 
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
        alert("业务受理成功！");         

        window.location.href("<%=from%>"); 
    }
    
//WealthChangesuccess.jsp
    function WealthChangesuccessredirectit()
    { 
        alert("业务受理成功！");         

        //window.location.href("/custWebMgr/custWebDev.jsp");
        window.open("/wealthMgr/indexMgr.jsp","newwidow");
        window.open('','_self','');
        window.close();
    }
    
//changeWealthSuccess.jsp
  function changeWealthSuccessredirectit()
    { 
        alert("业务受理成功！");       
        //setTimeout("window.close()",  1000);
        window.open("/wealthMgr/manageWealth.jsp","newwidow");
        window.open('','_self','');
        window.close();
       // window.location.href("/zone_b2c/orderAffirmSuccess.jsp"); 
    }
    
//conWebSuccess.jsp

    function conWebSuccessredirectit()
    { 
        alert("业务受理成功！");         

        window.location.href("/actionMgr/contactWebList.jsp"); 
    }
    
//customerWebSuccess.jsp
    function customerWebSuccessredirectit()
    { 
        alert("业务受理成功！");
        window.location.href("/custWebMgr/custWebDev.jsp"); 
    }
    
//custWebSuccess.jsp   
 function custWebSuccessredirectit()
    { 
        alert("业务受理成功！");         

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
        alert("业务受理成功！");         

        window.location.href("/oppWebMgr/oppList.jsp"); 
    }
