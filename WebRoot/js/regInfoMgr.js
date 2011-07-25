    	function confirmsub()
    	{
    	    if(document.formQuery.credit_title.value.replace(/\s*/g,"")=="" )
    	    {
	    	   alert("证书名称不能为空！");
	    	   document.formQuery.credit_title.focus();
	    	   return false;
    	    }
    	      
					var desc=credit_desc.getText();
					desc=desc.replace(/\s*/g,""); 
					if(desc == ""  )
					{
						alert("请填写证书的说明！");
						return false;
					}
					if( desc.length > 4000)
					{
						 alert( "证书说明字数应少于4000字" );
						 return false;	
					}
					if ( document.formQuery.start_date.value.replace(/\s*/g,"") == ""  ) 
					{                                                                                         
						alert("有效开始时间不可以为空！");                                                             
						document.formQuery.start_date.focus();                                                    
						return false;                                                                            
					}                                                                                        
					if ( document.formQuery.end_date.value.replace(/\s*/g,"") == "" ) 
					{                                                                                         
						alert("有效截止时间不可以为空！");                                                             
						document.formQuery.end_date.focus();                                                    
						return false;                                                                            
					}   
				//////////////////判断时间是否合理////////////////
			  if(!checkDate(document.formQuery.start_date.value,document.formQuery.end_date.value)){
				 return false;
			   }
			   ///////////////////////////////////////////////
    	   return true;
    	}
    	
    	
    function chechIfo()
		  {
			   if(confirm('是否确认注销本条记录？')) 
			{
				return true;
			}
			else
			{
				return false;
			}
		  }