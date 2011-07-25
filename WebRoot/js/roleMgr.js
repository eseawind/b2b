//grantRole.jsp
		 function grantRolecheck_Value(){
		  var role_code=$F("code");
		  if(role_code=="a"){
		    alert("请选择要分配的角色！");
		    return false;
		  }else if(role_code=="n"){
		    alert("你还没有设置角色,请再设置角色!");
		    return false;
		  }
		  var user_name=$F("user_name");
		  if(user_name=="" || user_name==null){
		    alert("请选择用户！");
		    return false;
		  }
		  return true;
		 }
		 
		 /***查看用户已有角色****/
		 function grantRolecheckUserRole(){
		   $("role").style.display="block";
		   $("bnt").style.display="block";
		   $("check").style.display="none";
		   var cust_id=$F("cust_id");
		   var user_id=$F("sale_user_id");
		   var data = Math.round(Math.random() * 10000);
	       var myAjax = new Ajax.Updater('role-div', 
			'userRole.jsp?&user_id=' + user_id + "&cust_id="+cust_id+"&data=" + data, 
			{
				method : 'get',
				evalScripts: true
			});
		 }
		 
		 /****列出用户清单***********/
		 function grantRoleshowUserList(){
		   window.open('modifyUserList.jsp','file','height=400,width=800,toolbar=0,status=0,scroll=yes')
		   $("bnt").style.display="none";
		   $("check").style.display="block";
		   $("role").style.display="none";
		 }
		 
//roleList.jsp
  function roleListchechIfo(){
		if(confirm('是否确认删除角色？')) {
			return true;
		}
		else{
			return false;
		}
  }
  
//updateRoleInfo.jsp
	    function updateRoleInfoCheck_Value()
		{
		    var role_name=$F("role_name");
		    role_name=delAllSpace(role_name);
		    if(role_name==""|| role_name==null){
		      alert("角色名称不能为空！");
		      $("role_name").focus();
		      return false;
		    }
	 	    return true;
		}
   
    	function updateRoleInfoconfirmsub(formobj)
    	{
    	    if(window.confirm('你确定要提交吗？')) 
    	    {  	    	
    	        if (updateRoleInfoCheck_Value())
    	        {
    	            formobj.submit();   	
    	        }
    	    }
    	    else
    	    {
    	        return;
    	    }
    	}
	  //删除所有空格
	 function delAllSpace(str) {
		return str.replace(/^\s+|\s+$/g, "")
	 }
	 
//addRoleInfo.jsp
	    function addRoleInfoCheck_Value()
		{
		    if(document.getElementById("role_name").value==""){
		      alert("角色名称不能为空！");
		      document.getElementById("role_name").focus();
		      return false;
		    }
	 	    return true;
		}
		
    	function addRoleInfoconfirmsub(formobj)
    	{
   	
    	        if (addRoleInfoCheck_Value())
    	        {
    	            formobj.submit();   	
    	        }
    	}