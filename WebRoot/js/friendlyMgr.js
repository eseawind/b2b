//indexLinkListDel.jsp
function indexLinkListDelconfirmremove()
{
	if(confirm('�Ƿ�ȷ��ɾ��������¼���¼���¼��')) 
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
			   if(confirm('�Ƿ�ȷ��ɾ��������¼��')) 
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
						alert("�������Ʋ�����Ϊ�գ�");                                                             
						document.formQuery.link_name.focus();                                                    
						return false;     
			    }

				 if(	document.formQuery.link_url.value.replace(/\s*/g,"") == "" || document.formQuery.link_url.value.replace(/\s*/g,"") == null)
				 {
						alert("���ӵ�ַ������Ϊ�գ�");                                                             
						document.formQuery.link_url.focus();                                                    
						return false;     
				 }
				 
	    	 var str=rsrv_str3.getText();
					str=str.replace(/\s*/g,""); 
					if(	str == ""  )
					{
						alert("����˵��������Ϊ�գ�");
						return false;
					}
					if( str.length > 4000)
					{
						 alert( "����˵������Ӧ����4000��" );
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
					alert("�������Ʋ�����Ϊ�գ�");                                                             
					document.formQuery.link_name.focus();                                                    
					return false;     
			    }
                var link_url=$F("link_url");
				 if(link_url == "http://" )
				 {
					alert("���ӵ�ַ������Ϊ�գ�");                                                             
					document.formQuery.link_url.focus();                                                    
					return false;     
				 }
				
	 
       var strRegex = "^((https|http|ftp|rtsp|mms)?://)"  
  + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp��user@  
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP��ʽ��URL- 199.194.52.184  
        + "|" 
        + "([0-9a-z_!~*'()-]+\.)*" 
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." 
        + "[a-z]{2,6})" // first level domain- .com or .museum  
        + "(:[0-9]{1,4})?" // �˿�- :80  
        + "((/?)|" // a slash isn't required if there is no file name  
        + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        var re=new RegExp(strRegex);    
  			if(re.test(document.getElementById("link_url").value)){   
 
			}else{   
				 Ext.MessageBox.alert("bizoss ��ʾ","���ӵ�ַ��ʽ����ȷ��"); 
			
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
			   	      alert("���������Ѵ��ڣ���������ӣ�");
			   	      return false;
			   	}
    	}
    	function addLinkInfocheckUrl(data){
    	result=data;
    	 if(data>0){
   	      alert("���������Ѵ��ڣ���������ӣ�");
   	      document.formQuery.link_name.focus();  
   	      return false;
   	     }else{
   	      return true;
   	     }
    	}
    	
//deleteLinkList.jsp
		  function deleteLinkListchechIfo()
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