//indexLinkListDel.jsp
function indexLinkListDelconfirmremove()
{
	if(confirm('是否确认删除本条记录及下级记录？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
}

//modifyLinkList.jsp
		  function modifyLinkListchechIfo()
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
		  
//modifyLinkInfo.jsp
      function modifyLinkInfoconfirmsub()
    	{
    	    if(	document.formQuery.link_name.value.replace(/\s*/g,"")== "" || document.formQuery.link_name.value.replace(/\s*/g,"") == null)
			    {
						alert("链接名称不可以为空！");                                                             
						document.formQuery.link_name.focus();                                                    
						return false;     
			    }

				 if(	document.formQuery.link_url.value.replace(/\s*/g,"") == "" || document.formQuery.link_url.value.replace(/\s*/g,"") == null)
				 {
						alert("链接地址不可以为空！");                                                             
						document.formQuery.link_url.focus();                                                    
						return false;     
				 }
				 
	    	 var str=rsrv_str3.getText();
					str=str.replace(/\s*/g,""); 
					if(	str == ""  )
					{
						alert("链接说明不可以为空！");
						return false;
					}
					if( str.length > 4000)
					{
						 alert( "链接说明字数应少于4000字" );
						 return false;	
					}      
	    	   return true;
    	}
    	
//addLinkInfo.jsp
    	function addLinkInfoconfirmsub()
    	{
    	        var link_name=$F("link_name");
    	        if(link_name== "" || link_name == null)
			    {
					alert("链接名称不可以为空！");                                                             
					document.formQuery.link_name.focus();                                                    
					return false;     
			    }
                var link_url=$F("link_url");
				 if(link_url == "http://" )
				 {
					alert("链接地址不可以为空！");                                                             
					document.formQuery.link_url.focus();                                                    
					return false;     
				 }
				
	 
       var strRegex = "^((https|http|ftp|rtsp|mms)?://)"  
  + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184  
        + "|" 
        + "([0-9a-z_!~*'()-]+\.)*" 
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." 
        + "[a-z]{2,6})" // first level domain- .com or .museum  
        + "(:[0-9]{1,4})?" // 端口- :80  
        + "((/?)|" // a slash isn't required if there is no file name  
        + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        var re=new RegExp(strRegex);    
  			if(re.test(document.getElementById("link_url").value)){   
 
			}else{   
				 Ext.MessageBox.alert("bizoss 提示","链接地址格式不正确！"); 
			
				document.getElementById("link_url").focus();
				return false;
	
            }


						
			   	return true;
    	}
    	
    	
    	function addLinkInfourlCheck(){
    	var result="";
    	         var cust_id=$F("cust_id");
    	         var link_name=$F("link_name");
    	         var link_url=$F("link_url");
	    	     CustlinkInfo.getCustFriendlyExists(cust_id,link_name,link_url,addLinkInfocheckUrl);
	    	     if(result==""){
	    	      return false;
	    	     }else if(result>0){
			   	      alert("友情链接已存在，请重新添加！");
			   	      return false;
			   	}
    	}
    	function addLinkInfocheckUrl(data){
    	result=data;
    	 if(data>0){
   	      alert("友情链接已存在，请重新添加！");
   	      document.formQuery.link_name.focus();  
   	      return false;
   	     }else{
   	      return true;
   	     }
    	}
    	
//deleteLinkList.jsp
		  function deleteLinkListchechIfo()
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