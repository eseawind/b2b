//queryListInfo.jsp
		function checkInfo()
		{
			 var keys=document.getElementById("keyword").value;
			 if(keys==""||keys=="."||keys==",")
			 {
			  alert("请认真填写客户名称！");
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
    	    if(window.confirm('你确定要提交吗？')) 
    	    {
    	    	 var content=document.getElementById("content").value;
						if(content=="" || content==null)
						{
							alert("内容不可以为空！");                                                             
							return false;     
						}					     					       						 
    	       return true; 	         
    	    }
    	    else
    	    {
    	        return false;
    	    }
    	}