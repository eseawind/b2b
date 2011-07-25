//addJobInfo.jsp
    function addJobInfoCheck_Value()
	{
			if (document.getElementById("title").value == "" || document.getElementById("title").value == null)
		{                                                                                         
			alert("标题不可以为空！");                                                             
			document.resumeForm.title.focus();                                                    
			return false;                                                                            
		}  
		if (document.getElementById("job_type").value == "" || document.getElementById("job_type").value == null)
		{                                                                                         
			alert("职位类型不可以为空！");                                                             
			document.resumeForm.job_type.focus();                                                    
			return false;                                                                            
		}
		if(document.getElementById('cust_ch_id').value!='7830633062'){
			alert(document.getElementById('cust_ch_id').value);
				alert('请选择供应栏目！');
				return false;
			}                                                                                                                                                                  
		if (request.getText()=="" || document.resumeForm.request.value == null)  
		{                                                                                        
			alert("招聘要求不可以为空！");                                                             
			document.resumeForm.request.focus();                                                    
			return false;                                                                            
		}                                                                                       
		if (cTrim(document.resumeForm.job_addr.value,0) == "" || document.resumeForm.job_addr.value == null)
		{                                                                                         
			alert("工作地址不可以为空！");                                                             
			document.resumeForm.job_addr.focus();                                                    
			return false;                                                                            
		}                                                                                      
		 return true;
   }

       function  addJobInfoaddparm(formobj)
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
   
//deletejobList.jsp
  function deletejobListchechIfo()
  {
	   if(confirm('是否确认删除本条记录？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }
  
//modifyjobInfo.jsp
    function modifyjobInfoCheck_Value()
	{
		       
		   if(document.getElementById("title").value.replace(/\s*/g,"")=="" || document.getElementById("title").value.replace(/\s*/g,"")==null)
				{
					alert("职位标题不能为空");
					document.getElementById("title").focus();
					return false;
					
				}
				 if(document.getElementById("request").value.replace(/\s*/g,"")=="" || document.getElementById("request").value.replace(/\s*/g,"")==null)
				{
					alert("职位要求不能为空");
					document.getElementById("request").focus();
					return false;
					
				}
 	    return true;
	}
     function modifyjobInfocheck_none(current_obj)
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
  	
//revertFeedbackInfo.jsp
		function revertFeedbackInfoformCheckout()
		{
				if(document.getElementById("title").value=="")
				{
						alert("标题不能为空");
						return false;	
						document.getElementById("title").focus();
				}
				if(document.getElementById("content").value=="")
				{
						alert("内容不能为空");
						return false;	
						document.getElementById("content").focus();
				}
				return true;
			}