//addUserInfo.jsp
function addUserInfoCheck_Value()
{
    if(document.getElementById("user_name").value==""){
      alert("�û�������Ϊ�գ�");
      document.getElementById("user_name").focus();
      return false;  
    }
	if (cTrim(document.Userform.passwd.value,0) == "" || document.Userform.passwd.value == null) 
	{                                                                                         
		alert("���벻����Ϊ�գ�");                                                             
		document.Userform.passwd.focus();                                                    
		return false;                                                                            
	} 
	if (cTrim(document.Userform.passwd1.value,0) == "" || document.Userform.passwd1.value == null) 
	{                                                                                         
		alert("ȷ�����벻����Ϊ�գ�");                                                             
		document.Userform.passwd1.focus();                                                    
		return false;                                                                            
	}    
	if (document.Userform.passwd.value !=document.Userform.passwd1.value) 
	{                                                                                         
		alert("�������벻һ�£�");                                                             
		document.Userform.passwd.focus();                                                    
		return false;                                                                            
	}
	if(document.getElementById("depart_name").value==""){
      alert("��ѡ��������ţ�");
      document.getElementById("depart_name").focus();
       return false;  
    } 
       
	if (document.Userform.role_code.value =="") 
	{                                                                                         
		alert("��ѡ����û�������ɫ��������˸��û�����ʹ��ϵͳ��Щ���ܣ�");                                                             
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
   
   //�����ڵ�
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
   //����û����Ƿ��ظ�
   function checkUserName(name){
     if(name !=null && name !=""){
        UserInfo.getUserNameCount(name,function(data){
           if(data!=0){
             alert("���û����Ѵ���,��������д��");
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

		alert("���벻����Ϊ�գ�");                                                             

		document.Userform.passwd.focus();                                                    

		return false;                                                                            

	} 

	if (cTrim(document.Userform.passwd1.value,0) == "" || document.Userform.passwd1.value == null) 

	{                                                                                         

		alert("ȷ�����벻����Ϊ�գ�");                                                             

		document.Userform.passwd1.focus();                                                    

		return false;                                                                            

	}    

	if (document.Userform.passwd.value !=document.Userform.passwd1.value) 

	{                                                                                         

		alert("�������벻һ�£�");                                                             

		document.Userform.passwd.focus();                                                    

		return false;                                                                            

	}                                                                                             

	if (cTrim(document.Userform.passwd_answer.value,0) == "" || document.Userform.passwd_answer.value == null) 

	{                                                                                         

		alert("������ʾ����𰸲�����Ϊ�գ�");                                                             

		document.Userform.passwd_answer.focus();                                                    

		return false;                                                                            

	}                                                                                        

	if (cTrim(document.Userform.pspt_id.value,0) == "" || document.Userform.pspt_id.value == null) 

	{                                                                                         

		alert("֤�����벻����Ϊ�գ�");                                                             

		document.Userform.pspt_id.focus();                                                    

		return false;                                                                            

	}                                                                                      

	if (cTrim(document.Userform.local_native_code.value,0) == "" || document.Userform.local_native_code.value == null) 

	{                                                                                         

		alert("���᲻����Ϊ�գ�");                                                             

		document.Userform.local_native_code.focus();                                                    

		return false;                                                                            

	}                                                                                        

	if (cTrim(document.Userform.phone.value,0) == "" || document.Userform.phone.value == null) 

	{                                                                                         

		alert("��ϵ�绰������Ϊ�գ�");                                                             

		document.Userform.phone.focus();                                                    

		return false;                                                                            

	}                                                                                        

	if (cTrim(document.Userform.job.value,0) == "" || document.Userform.job.value == null) 

	{                                                                                         

		alert("ְλ������Ϊ�գ�");                                                             

		document.Userform.job.focus();                                                    

		return false;                                                                            

	}                                                                                   

	if (cTrim(document.Userform.community_id.value,0) == "" || document.Userform.community_id.value == null) 

	{                                                                                         

		alert("��ᱣ�ϺŲ�����Ϊ�գ�");                                                             

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

  if(window.confirm('��ȷ��Ҫ�ύ��')) 

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

	   if(confirm('�Ƿ�ȷ�϶���û�Ա��')) 

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
	   if(confirm('�Ƿ�ȷ�Ͻ�����᣿')) 
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
	   if(confirm('�Ƿ�ȷ��ע��������¼��')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }
  

