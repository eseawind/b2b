//activation.jsp
	function activationautoSubmit(){   
	        var form = document.forms[0];   
	        form.method = 'post';    
	        var trade=document.getElementById("trade").value;
	        if(trade=="0"){
	          form.submit();
	        }else{
	          document.getElementById("isShow").style.display="block";
	        }
	    } 
	    
//	actived.jsp
		 		function activedautoSubmit(){   
	   	     self.location='/index.jsp';
	  	  } 
	    
//addfav.jsp
    function check_none()
     {
          if (document.formQuery.advshow.checked)
          {
      	    document.formQuery.submit1.disabled=false;        	     
      	}
      	else
      	{
      	   document.formQuery.submit1.disabled=true;
      	}
  	}
    	function exit()
    	{
    	    window.close();
    	}
    	function addfavconfirmsub()
    	{
    	    if(window.confirm('��ȷ��Ҫ�ύ��')) 
    	    {	    	 
						if(document.formQuery.link_desc.value== "" || document.formQuery.link_desc.value == null)
						{
							alert("���ݲ�����Ϊ�գ�");                                                             
							return false;     
						}
						                                                                                    
	      		 document.formQuery.submit();    	         
    	    }
    	    else
    	    {
    	        return;
    	    }
    	    
     	}
     	
//forgetPwd.jsp
		 function confirmsub(){
		     var user_name=$F("user_name");
		     if(user_name=="" || user_name==null){
		       Ext.MessageBox.alert("<title>B2B���������̨����ϵͳ</title>��ʾ","����ȷ��дϵͳ�ʺţ�")
		       return;
		     }
		     if($F("cust_name")=="" || $F("cust_name")==null){
		       Ext.MessageBox.alert("<title>B2B���������̨����ϵͳ</title>��ʾ","����ȷ��д�ͻ����ƣ�")
		       return;
		     }
		     UserInfo.getUserInfByName(user_name,checkEmail);
		 }
		 function checkEmail(data){
		   var obj=$H(data);
		   var passwd_answer=obj.get("passwd_answer");
		   if(passwd_answer !="" && passwd_answer!=null){
		     $("hide0").style.display="block";
		     $("hide4").style.display="block";
		    var passwd_ques=obj.get('passwd_ques');
		     ParamethodMgr.getParamNameByValue("28",passwd_ques,function(name){
		       $("request").innerHTML=name+"��";
		     });
		   }else{
		      if(obj.size()==0){
		         Ext.MessageBox.alert("<title>B2B���������̨����ϵͳ</title>��ʾ","�ʺŲ����ڣ�<br>����ȷ��дϵͳ�ʺţ�");
		      }else{
			       Ext.MessageBox.alert("<title>B2B���������̨����ϵͳ</title>��ʾ","��û���������뱣����<br>ϵͳ�����뷢�͵���ҵ���䣬��ע����գ�");
			       $("hide1").style.display="none";
			       $("hide2").style.display="block";
		       }
		   }
		 }
		 
		 //
		 function checkAnswer(value){
		     var user_name=$F("user_name");
		    UserInfo.getUserInfByName(user_name,function(data){
		       var obj=$H(data);
		       var passwd_answer=obj.get("passwd_answer");
		       if(passwd_answer == value){
		         $("hide3").style.display="block";
		         $("hide1").style.display="none";
		         $("hide2").style.display="block";
		       }else{
		         Ext.MessageBox.alert("<title>B2B���������̨����ϵͳ</title>��ʾ","�ش������������д��");
		       }
		    });
		 }
		 //
		 function check(){
		    var mail=$F("email");
		    var type=$("hide3").style.display;
		    if(type=="block"){
			 if (mail.charAt(0)=="." || mail.charAt(0)=="@"|| mail.indexOf('@', 0) == -1 || mail.indexOf('.', 0) == -1 || mail.lastIndexOf("@") ==mail.length-1 || mail.lastIndexOf(".")==mail.length-1)
			 {
				Ext.MessageBox.alert("<title>B2B���������̨����ϵͳ</title>��ʾ","Email�ĸ�ʽ����ȷ��");;
				return false;
			 }
			}else{
			 return true;
			}
		 }
		 
//index.jsp
		function MM_swapImgRestore() { //v3.0
		  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
		}
		
		function MM_preloadImages() { //v3.0
		    loginForm.user_name.focus(); 
		  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
		    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
		    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
		}
		
		function MM_findObj(n, d) { //v4.01
		  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
		    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
		  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
		  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
		  if(!x && d.getElementById) x=d.getElementById(n); return x;
		}
		
		function MM_swapImage() { //v3.0
		  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
		   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
		}
    	function Check_Value()
    	{
    		if (document.getElementById("user_name").value == ""||document.getElementById("user_name").value == null)
    		{
    			alert('�û���������Ϊ�գ�');
    			document.getElementById("user_name").focus();
    			return false;
    		}
    		if (document.getElementById("passwd").value == ""||document.getElementById("passwd").value == null)
    		{
    			alert("���벻����Ϊ�գ�");
    			document.getElementById("passwd").focus();
    			return false;
    		}
            if (document.getElementById("userrand").value == ""||document.getElementById("userrand").value == null)
    		{
    			alert("��������֤�룡");
    			document.getElementById("userrand").focus();
    			return false;
    		}
    		document.loginForm.submit();
    	}
        function changeCode()
          {
          	 var dt = new Date();

           document.getElementById("rc").src= "../checkImage"+'?'+dt;
          
          }
        function changeCode2()
          {
           document.getElementById("rc").src= "../checkImage";
          }
         function keysubmit(obj)
		  	{
				 if(event.keyCode != "13") return;
				if (obj.user_name.value == ""||obj.user_name.value == null)
				{
					alert("�û���������Ϊ�գ�");
					return false;
				}
				if (obj.passwd.value == ""||obj.passwd.value == null)
				{
					alert("���벻����Ϊ�գ�");
					return false;
				}
		        if (obj.userrand.value == ""||obj.userrand.value == null)
				{
					alert("��������֤�룡");
					return false;
				}
				obj.submit();
		 }