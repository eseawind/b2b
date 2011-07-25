//addUserInfo.jsp
function addUserInfoCheck_Value()
{
    if(document.getElementById("user_name").value==""){
      alert("用户名不能为空！");
      document.getElementById("user_name").focus();
      return false;  
    }
	if (cTrim(document.Userform.passwd.value,0) == "" || document.Userform.passwd.value == null) 
	{                                                                                         
		alert("密码不可以为空！");                                                             
		document.Userform.passwd.focus();                                                    
		return false;                                                                            
	} 
	if (cTrim(document.Userform.passwd1.value,0) == "" || document.Userform.passwd1.value == null) 
	{                                                                                         
		alert("确认密码不可以为空！");                                                             
		document.Userform.passwd1.focus();                                                    
		return false;                                                                            
	}    
	if (document.Userform.passwd.value !=document.Userform.passwd1.value) 
	{                                                                                         
		alert("输入密码不一致！");                                                             
		document.Userform.passwd.focus();                                                    
		return false;                                                                            
	}
	if(document.getElementById("depart_name").value==""){
      alert("请选择归属部门！");
      document.getElementById("depart_name").focus();
       return false;  
    } 
       
	if (document.Userform.role_code.value =="") 
	{                                                                                         
		alert("请选择该用户所属角色，这决定了该用户可以使用系统哪些功能！");                                                             
		document.Userform.role_code.focus();                                                    
		return false;                                                                            
	}               
	document.getElementById("group_contact_phone").value=document.getElementById("phone").value;                                                                 
 	return true;
}


function setProvience(country){
    var country_id=country;
	AreaInfo.getAreaByParent(country_id,function(data){
	 DWRUtil.removeAllOptions("city_code");
	 DWRUtil.removeAllOptions("eparchy_code");
	 DWRUtil.addOptions("eparchy_code",data);
	});
}
function setCitys(prov){
   var provence=prov;
	 AreaInfo.getAreaByParent(provence,function(data){
	 DWRUtil.removeAllOptions("city_code");
	 DWRUtil.addOptions("city_code",data);
	});
}

   
		  Ext.onReady(function(){ 
	      var resizeable = new Ext.Resizable('tree-div', {
	            pinned:true,
	            autoWidth:true,
	            autoHeight:true,
	            handles: 'e',
	            widthIncrement:50,
	            minWidth: 50,
				maxWidth:450,
	            dynamic: true
	        });
	     var tree = new Ext.tree.TreePanel({   
		    	el:"tree-div",   
		        autoScroll:false,
		        animate:true,
		        width:'35%',
		        autoHeight:true,
		        enableDD:false,
		        containerScroll: true, 
		        loader: new Ext.tree.TreeLoader({
		            dataUrl:'/member/organizeMgr/organize_tree.jsp'            
		        })
		    });
		var root_name=document.getElementById("cust_name").value;
	    var root = new Ext.tree.AsyncTreeNode({
	        text: root_name,
	        draggable:false,
	        iconCls:'root-Img',
	        id:'000000000000000'
	    });
	    tree.setRootNode(root);
	    tree.render();
	   	root.expand();
	   	tree.on("click",function(node,event){
	   	 document.getElementById("org_depart_code").value=node.id;
	   	 document.getElementById("depart_name").value=node.text;
	   	});
	   	tree.expandAll();
	   });
   
   //三级节点
   function callBackFunction(obj,node){
      var cust=document.getElementById("cust_id").value;
			for(var org_id in obj){ 
		         var org_name=obj[org_id];
		         if(org_id!='extend'){
		         var nodex = new Ext.tree.TreeNode({text:org_name,draggable:false,iconCls:'Tree-Img',id:org_id});
		         node.appendChild(nodex);
		         OrganizeInfo.getOrganizeByUpIdMap(cust,org_id,function(data){
			      for(var i=0;i<data.length;i++){ 
					var objx=data[i];
					for(var orgid in objx){ 
				         var orgname=objx[orgid];
				         if(orgid!='extend'){
				         var tree_nodex= new Ext.tree.TreeNode({text:orgname,draggable:false,iconCls:'Tree-Img',id:orgid});
				         nodex.appendChild(tree_nodex);
				         OrganizeInfo.getOrganizeByUpIdMap(cust,orgid,function(data){
				          for(var i=0;i<data.length;i++){ 
                            var obj=data[i];
                             callBackFunction(obj,tree_nodex);
                          }
				         });
				         }
			         }
			      }
			   });
			   }
		     }
   }
   //检测用户名是否重复
   function checkUserName(name){
     if(name !=null && name !=""){
        UserInfo.getUserNameCount(name,function(data){
           if(data!=0){
             alert("此用户名已存在,请重新填写！");
             document.getElementById("user_name").value="";
             document.getElementById("user_name").focus();
           }
        });
     }
   }
function startP(){
opener.location.reload();   
}

//modifyUserInfo.jsp

function modifyUserInfoCheck_Value()

{

	if (cTrim(document.Userform.passwd.value,0) == "" || document.Userform.passwd.value == null) 

	{                                                                                         

		alert("密码不可以为空！");                                                             

		document.Userform.passwd.focus();                                                    

		return false;                                                                            

	} 

	if (cTrim(document.Userform.passwd1.value,0) == "" || document.Userform.passwd1.value == null) 

	{                                                                                         

		alert("确认密码不可以为空！");                                                             

		document.Userform.passwd1.focus();                                                    

		return false;                                                                            

	}    

	if (document.Userform.passwd.value !=document.Userform.passwd1.value) 

	{                                                                                         

		alert("输入密码不一致！");                                                             

		document.Userform.passwd.focus();                                                    

		return false;                                                                            

	}                                                                                             

	if (cTrim(document.Userform.passwd_answer.value,0) == "" || document.Userform.passwd_answer.value == null) 

	{                                                                                         

		alert("密码提示问题答案不可以为空！");                                                             

		document.Userform.passwd_answer.focus();                                                    

		return false;                                                                            

	}                                                                                        

	if (cTrim(document.Userform.pspt_id.value,0) == "" || document.Userform.pspt_id.value == null) 

	{                                                                                         

		alert("证件号码不可以为空！");                                                             

		document.Userform.pspt_id.focus();                                                    

		return false;                                                                            

	}                                                                                      

	if (cTrim(document.Userform.local_native_code.value,0) == "" || document.Userform.local_native_code.value == null) 

	{                                                                                         

		alert("籍贯不可以为空！");                                                             

		document.Userform.local_native_code.focus();                                                    

		return false;                                                                            

	}                                                                                        

	if (cTrim(document.Userform.phone.value,0) == "" || document.Userform.phone.value == null) 

	{                                                                                         

		alert("联系电话不可以为空！");                                                             

		document.Userform.phone.focus();                                                    

		return false;                                                                            

	}                                                                                        

	if (cTrim(document.Userform.job.value,0) == "" || document.Userform.job.value == null) 

	{                                                                                         

		alert("职位不可以为空！");                                                             

		document.Userform.job.focus();                                                    

		return false;                                                                            

	}                                                                                   

	if (cTrim(document.Userform.community_id.value,0) == "" || document.Userform.community_id.value == null) 

	{                                                                                         

		alert("社会保障号不可以为空！");                                                             

		document.Userform.community_id.focus();                                                    

		return false;                                                                            

	}                                                                                      

 	    return true;

}

function modifyUserInfocheck_none(current_obj)

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

function exit()

{

    window.location.reload();

}

function modifyUserInfoconfirmsub(formobj)

{

  if(window.confirm('你确定要提交吗？')) 

  {

      if (!modifyUserInfoCheck_Value())

      {

           return;

      }    	            	           

      formobj.submit();    	         

  }

  else

  {

      return;

  }

}

//frostUserList.jsp

  function frostUserListchechIfo()

  {

	   if(confirm('是否确认冻结该会员？')) 

	{

		return true;

	}

	else

	{

		return false;

	}

  }

//memberMgr.js
  function defrostUserListchechIfo()
  {
	   if(confirm('是否确认解除冻结？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }
  
//cancelUserList.jsp
  function cancelUserListchechIfo()
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
  

