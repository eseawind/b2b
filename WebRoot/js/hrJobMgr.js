//addJobInfo.jsp
    function addJobInfoCheck_Value()
	{
			if (document.getElementById("title").value == "" || document.getElementById("title").value == null)
		{                                                                                         
			alert("���ⲻ����Ϊ�գ�");                                                             
			document.resumeForm.title.focus();                                                    
			return false;                                                                            
		}  
		if (document.getElementById("job_type").value == "" || document.getElementById("job_type").value == null)
		{                                                                                         
			alert("ְλ���Ͳ�����Ϊ�գ�");                                                             
			document.resumeForm.job_type.focus();                                                    
			return false;                                                                            
		}
		if(document.getElementById('cust_ch_id').value!='7830633062'){
			alert(document.getElementById('cust_ch_id').value);
				alert('��ѡ��Ӧ��Ŀ��');
				return false;
			}                                                                                                                                                                  
		if (request.getText()=="" || document.resumeForm.request.value == null)  
		{                                                                                        
			alert("��ƸҪ�󲻿���Ϊ�գ�");                                                             
			document.resumeForm.request.focus();                                                    
			return false;                                                                            
		}                                                                                       
		if (cTrim(document.resumeForm.job_addr.value,0) == "" || document.resumeForm.job_addr.value == null)
		{                                                                                         
			alert("������ַ������Ϊ�գ�");                                                             
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
	   if(confirm('�Ƿ�ȷ��ɾ��������¼��')) 
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
					alert("ְλ���ⲻ��Ϊ��");
					document.getElementById("title").focus();
					return false;
					
				}
				 if(document.getElementById("request").value.replace(/\s*/g,"")=="" || document.getElementById("request").value.replace(/\s*/g,"")==null)
				{
					alert("ְλҪ����Ϊ��");
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
						alert("���ⲻ��Ϊ��");
						return false;	
						document.getElementById("title").focus();
				}
				if(document.getElementById("content").value=="")
				{
						alert("���ݲ���Ϊ��");
						return false;	
						document.getElementById("content").focus();
				}
				return true;
			}