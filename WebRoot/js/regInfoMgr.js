    	function confirmsub()
    	{
    	    if(document.formQuery.credit_title.value.replace(/\s*/g,"")=="" )
    	    {
	    	   alert("֤�����Ʋ���Ϊ�գ�");
	    	   document.formQuery.credit_title.focus();
	    	   return false;
    	    }
    	      
					var desc=credit_desc.getText();
					desc=desc.replace(/\s*/g,""); 
					if(desc == ""  )
					{
						alert("����д֤���˵����");
						return false;
					}
					if( desc.length > 4000)
					{
						 alert( "֤��˵������Ӧ����4000��" );
						 return false;	
					}
					if ( document.formQuery.start_date.value.replace(/\s*/g,"") == ""  ) 
					{                                                                                         
						alert("��Ч��ʼʱ�䲻����Ϊ�գ�");                                                             
						document.formQuery.start_date.focus();                                                    
						return false;                                                                            
					}                                                                                        
					if ( document.formQuery.end_date.value.replace(/\s*/g,"") == "" ) 
					{                                                                                         
						alert("��Ч��ֹʱ�䲻����Ϊ�գ�");                                                             
						document.formQuery.end_date.focus();                                                    
						return false;                                                                            
					}   
				//////////////////�ж�ʱ���Ƿ����////////////////
			  if(!checkDate(document.formQuery.start_date.value,document.formQuery.end_date.value)){
				 return false;
			   }
			   ///////////////////////////////////////////////
    	   return true;
    	}
    	
    	
    function chechIfo()
		  {
			   if(confirm('�Ƿ�ȷ��ע��������¼��')) 
			{
				return true;
			}
			else
			{
				return false;
			}
		  }