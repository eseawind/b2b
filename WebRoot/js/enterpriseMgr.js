//queryListInfo.jsp
		function checkInfo()
		{
			 var keys=document.getElementById("keyword").value;
			 if(keys==""||keys=="."||keys==",")
			 {
			  alert("��������д�ͻ����ƣ�");
			  return false;
			 }
		 return true;
		}
		
//InterimPages.jsp
			function init(){
				welcome('welcome');
			    loginOrLogoout('logoinOrOut');
			}
			
//modify.jsp
    	function confirmsub()
    	{
    	    if(window.confirm('��ȷ��Ҫ�ύ��')) 
    	    {
    	    	 var content=document.getElementById("content").value;
						if(content=="" || content==null)
						{
							alert("���ݲ�����Ϊ�գ�");                                                             
							return false;     
						}					     					       						 
    	       return true; 	         
    	    }
    	    else
    	    {
    	        return false;
    	    }
    	}