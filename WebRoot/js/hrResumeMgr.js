//addResumeInfo.jsp
    function addResumeInfoCheck_Value()
	{
		if (cTrim(document.resumeForm.name.value,0) == "" || document.resumeForm.name.value == null) 
		{                                                                                         
			alert("姓名不可以为空！");                                                             
			document.resumeForm.name.focus();                                                    
			return false;                                                                            
		}   
		
		if (cTrim(document.resumeForm.grad_from.value,0) == "" || document.resumeForm.grad_from.value == null) 
		{                                                                                         
			alert("毕业学校不可以为空！");                                                             
			document.resumeForm.grad_from.focus();                                                    
			return false;                                                                            
		}                                                                                       
		if (cTrim(document.resumeForm.profession.value,0) == "" || document.resumeForm.profession.value == null) 
		{                                                                                         
			alert("专业不可以为空！");                                                             
			document.resumeForm.profession.focus();                                                    
			return false;                                                                            
		}      
		if (cTrim(document.resumeForm.wish.value,0) == "" || document.resumeForm.wish.value == null) 
		{                                                                                         
			alert("期望薪资不可以为空！");                                                             
			document.resumeForm.wish.focus();                                                    
			return false;                                                                            
		}
		else if(! isNum(document.resumeForm.wish.value))
	     {
			alert("期望薪资有误，请输入正确的数字！");
			document.resumeForm.wish.focus(); 
			return false;
	     }                                                                                     
		if (cTrim(document.resumeForm.born_date.value,0) == "" || document.resumeForm.born_date.value == null) 
		{                                                                                         
			alert("出生年月不可以为空！");                                                             
			document.resumeForm.born_date.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (cTrim(document.resumeForm.born_site.value,0) == "" || document.resumeForm.born_site.value == null) 
		{                                                                                         
			alert("籍贯不可以为空！");                                                             
			document.resumeForm.born_site.focus();                                                    
			return false;                                                                            
		}                                                                                      
		        
		var chckTele2=/^(((13[0-9]{1})|158|159|153)+\d{8})$/;
		var chckTele1=/^(((\()?\d{2,4}(\))?[-(\s)*]){0,2})?(\d{7,8})$/;//024-258963
		var chckTele3=/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
		var chckTele4=/^(((\()?\d{2,4}(\))?[-(\s)*]){0,2})?(\d{7,8})$/; 
		var teltmp=document.resumeForm.phone.value;                                                                     
		if (cTrim(document.resumeForm.phone.value,0) == "" || document.resumeForm.phone.value == null) 
		{                                                                                         
			alert("联系电话不可以为空！");                                                             
			document.resumeForm.phone.focus();                                                    
			return false;                                                                            
		}else if(!chckTele1.test(teltmp)&&!chckTele2.test(teltmp)&&!chckTele3.test(teltmp)){
		 	alert("电话格式错,请重写!如:手机号或0551-5310317!");
	  	document.resumeForm.phone.focus();
	  	return false;
		} 
		var chemEmail1=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;                                                                                      
		if (cTrim(document.resumeForm.email.value,0) == "" || document.resumeForm.email.value == null) 
		{                                                                                         
			alert("电子邮件不可以为空！");                                                             
			document.resumeForm.email.focus();                                                    
			return false;                                                                            
		}else if(!chemEmail1.test(document.getElementById("email").value)){
			alert("Email的格式不正確!");
			document.getElementById("email").focus(); 
			return false;
		}                                                                                      
		if (cTrim(document.resumeForm.tel.value,0) == "" || document.resumeForm.tel.value == null) 
		{                                                                                         
			alert("固定电话不可以为空！");                                                             
			document.resumeForm.tel.focus();                                                    
			return false;                                                                            
		}else if(!chckTele1.test(document.resumeForm.tel.value)&&!chckTele2.test(document.resumeForm.tel.value)&&!chckTele3.test(document.resumeForm.tel.value)){
		 	alert("电话格式错,请重写!如:0551-5310317!");
	  	document.resumeForm.tel.focus();
	  	return false;
		}                                                                                      
		if (cTrim(document.resumeForm.addr.value,0) == "" || document.resumeForm.addr.value == null) 
		{                                                                                         
			alert("联系地址不可以为空！");                                                             
			document.resumeForm.addr.focus();                                                    
			return false;                                                                            
		}                                                                                       
		if (cTrim(document.resumeForm.position.value,0) == "" || document.resumeForm.position.value == null) 
		{                                                                                         
			alert("当前职位不可以为空！");                                                             
			document.resumeForm.position.focus();                                                    
			return false;                                                                            
		}                                                                                       
		if (cTrim(document.resumeForm.age.value,0) == "" || document.resumeForm.age.value == null) 
		{                                                                                         
			alert("年龄不可以为空！");                                                             
			document.resumeForm.age.focus();                                                    
			return false;                                                                            
		}
		else if(! isNum(document.resumeForm.age.value))
	     {
			alert("年龄有误，请输入正确的数字！");
			document.resumeForm.age.focus(); 
			return false;
	     }                                                                                       
		if (cTrim(document.resumeForm.degree.value,0) == "" || document.resumeForm.degree.value == null) 
		{                                                                                         
			alert("学历不可以为空！");                                                             
			document.resumeForm.degree.focus();                                                    
			return false;                                                                            
		}                                                                                     
		if (cTrim(document.resumeForm.job_age.value,0) == "" || document.resumeForm.job_age.value == null) 
		{                                                                                         
			alert("工作年限不可以为空！");                                                             
			document.resumeForm.job_age.focus();                                                    
			return false;                                                                            
		}                                                                                       
		if (cTrim(document.resumeForm.grad_date.value,0) == "" || document.resumeForm.grad_date.value == null) 
		{                                                                                         
			alert("毕业年份不可以为空！");                                                             
			document.resumeForm.grad_date.focus();                                                    
			return false;                                                                            
		}                                                                                       
		if (work_history.getText()=="" || document.resumeForm.work_history.value == null) 
		{                                                                                         
			alert("工作经历不可以为空！");                                                             
			document.resumeForm.work_history.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (spec.getText()=="" || document.resumeForm.spec.value == null) 
		{                                                                                         
			alert("特殊技能不可以为空！");                                                             
			document.resumeForm.spec.focus();                                                    
			return false;                                                                            
		}                                                                                        
		if (cTrim(document.resumeForm.cert.value,0) == "" || document.resumeForm.cert.value == null) 
		{                                                                                         
			alert("所获证书不可以为空！");                                                             
			document.resumeForm.cert.focus();                                                    
			return false;                                                                            
		}                                                                                       
 	    return true;
	}

    	function addResumeInfoconfirmsub(formobj)
    	{
    	    if(window.confirm('你确定要提交吗？')) 
    	    {  	    	
    	        if (!addResumeInfoCheck_Value())
    	        {
    	             return;
    	        }
    	     	addResumeInfoaddparm(formobj);
    	         formobj.submit();   	         
    	    }
    	    else
    	    {
    	        return;
    	    }
    	}
     function  addResumeInfoaddparm(formobj)
     {
        if(formobj.str_attr)
        {
       		var attr_str="";
       		formobj.str_attr.value="";
			for(var i=0;i<formobj.length;i++)
			{
				if(formobj[i].getAttribute("name").substring(0,4)=="attr")
				{
			 	  attr_str =attr_str + formobj[i].getAttribute("name").substring(4, formobj[i].getAttribute("name").length)+":";
			 	  attr_str = attr_str +formobj[i].getAttribute("value")+"|";
				}
			}
			formobj.str_attr.value=attr_str;
	    }
     }    	
     function   isNum(str)
    {   
      return   (str.search(/^\d+(\.\d+)?$/)!=-1);   
    }   	
    
//updateResumeInfo.jsp
    function updateResumeInfoCheck_Value()

	{

		if (cTrim(document.resumeForm.grad_from.value,0) == "" || document.resumeForm.grad_from.value == null) 

		{                                                                                         

			alert("毕业学校不可以为空！");                                                             

			document.resumeForm.grad_from.focus();                                                    

			return false;                                                                            

		}                                                                                       

		if (cTrim(document.resumeForm.profession.value,0) == "" || document.resumeForm.profession.value == null) 

		{                                                                                         

			alert("专业不可以为空！");                                                             

			document.resumeForm.profession.focus();                                                    

			return false;                                                                            

		}      

		if (cTrim(document.resumeForm.wish.value,0) == "" || document.resumeForm.wish.value == null) 

		{                                                                                         

			alert("期望薪资不可以为空！");                                                             

			document.resumeForm.wish.focus();                                                    

			return false;                                                                            

		}

		else if(! isNum(document.resumeForm.wish.value))

	     {

			alert("期望薪资有误，请输入正确的数字！");

			document.resumeForm.wish.focus(); 

			return false;

	     }                                                                                     

		if (cTrim(document.resumeForm.born_date.value,0) == "" || document.resumeForm.born_date.value == null) 

		{                                                                                         

			alert("出生年月不可以为空！");                                                             

			document.resumeForm.born_date.focus();                                                    

			return false;                                                                            

		}                                                                                      

		if (cTrim(document.resumeForm.born_site.value,0) == "" || document.resumeForm.born_site.value == null) 

		{                                                                                         

			alert("籍贯不可以为空！");                                                             

			document.resumeForm.born_site.focus();                                                    

			return false;                                                                            

		}                                                                                      

		                                                                                  

		if (cTrim(document.resumeForm.phone.value,0) == "" || document.resumeForm.phone.value == null) 

		{                                                                                         
			alert("联系电话不可以为空！");                                                             

			document.resumeForm.phone.focus();                                                    

			return false;                                                                            

		}                                                                                       

		if (cTrim(document.resumeForm.email.value,0) == "" || document.resumeForm.email.value == null) 

		{                                                                                         

			alert("电子邮件不可以为空！");                                                             

			document.resumeForm.email.focus();                                                    

			return false;                                                                            

		}                                                                                       

		if (cTrim(document.resumeForm.tel.value,0) == "" || document.resumeForm.tel.value == null) 

		{                                                                                         

			alert("固定电话不可以为空！");                                                             

			document.resumeForm.tel.focus();                                                    

			return false;                                                                            

		}                                                                                      

		if (cTrim(document.resumeForm.addr.value,0) == "" || document.resumeForm.addr.value == null) 

		{                                                                                         

			alert("联系地址不可以为空！");                                                             

			document.resumeForm.addr.focus();                                                    

			return false;                                                                            

		}                                                                                       

		if (cTrim(document.resumeForm.position.value,0) == "" || document.resumeForm.position.value == null) 

		{                                                                                         

			alert("当前职位不可以为空！");                                                             

			document.resumeForm.position.focus();                                                    

			return false;                                                                            

		}                                                                                       

		if (cTrim(document.resumeForm.age.value,0) == "" || document.resumeForm.age.value == null) 

		{                                                                                         

			alert("年龄不可以为空！");                                                             

			document.resumeForm.age.focus();                                                    

			return false;                                                                            

		}

		else if(! isNum(document.resumeForm.age.value))

	     {

			alert("年龄有误，请输入正确的数字！");

			document.resumeForm.age.focus(); 

			return false;

	     }                                                                                       

		if (cTrim(document.resumeForm.degree.value,0) == "" || document.resumeForm.degree.value == null) 

		{                                                                                         

			alert("学历不可以为空！");                                                             

			document.resumeForm.degree.focus();                                                    

			return false;                                                                            

		}                                                                                     

		if (cTrim(document.resumeForm.job_age.value,0) == "" || document.resumeForm.job_age.value == null) 

		{                                                                                         

			alert("工作年限不可以为空！");                                                             

			document.resumeForm.job_age.focus();                                                    

			return false;                                                                            

		}                                                                                       

		if (cTrim(document.resumeForm.grad_date.value,0) == "" || document.resumeForm.grad_date.value == null) 

		{                                                                                         

			alert("毕业年份不可以为空！");                                                             

			document.resumeForm.grad_date.focus();                                                    

			return false;                                                                            

		}                                                                                       

		if (work_history.getText()=="" || document.resumeForm.work_history.value == null) 

		{                                                                                         

			alert("工作经历不可以为空！");                                                             

			document.resumeForm.work_history.focus();                                                    

			return false;                                                                            

		}                                                                                      

		if (spec.getText()=="" || document.resumeForm.spec.value == null) 

		{                                                                                         

			alert("特殊技能不可以为空！");                                                             

			document.resumeForm.spec.focus();                                                    

			return false;                                                                            

		}                                                                                        

		if (cTrim(document.resumeForm.cert.value,0) == "" || document.resumeForm.cert.value == null) 

		{                                                                                         

			alert("所获证书不可以为空！");                                                             

			document.resumeForm.cert.focus();                                                    

			return false;                                                                            

		}                                                                                       

 	    return true;

	}

    	function updateResumeInfoconfirmsub(formobj)

    	{

    	    if(window.confirm('你确定要提交吗？')) 

    	    {  	    	

    	        if (!addResumeInfoCheck_Value())

    	        {

    	             return false;

    	        }

    	     	updateResumeInfoaddparm(formobj);

    	         formobj.submit();   	         

    	    }

    	    else

    	    {

    	        return false;

    	    }

    	}

     function  updateResumeInfoaddparm(formobj)

     {

        if(formobj.str_attr)

        {

       		var attr_str="";

       		formobj.str_attr.value="";

			for(var i=0;i<formobj.length;i++)

			{

				if(formobj[i].getAttribute("name").substring(0,4)=="attr")

				{

			 	  attr_str =attr_str + formobj[i].getAttribute("name").substring(4, formobj[i].getAttribute("name").length)+":";

			 	  attr_str = attr_str +formobj[i].getAttribute("value")+"|";

				}

			}

			formobj.str_attr.value=attr_str;

	    }

     }    	

     function   isNum(str)

    {   

      return   (str.search(/^\d+(\.\d+)?$/)!=-1);   

    }   	