//addOrgInfo.jsp
  function Check_Value()
	{
	    if(document.getElementById("up_org_id").value==""){
	      alert("请选择上级部门！");
	      return false;
	    }

	    if(document.getElementById("org_name").value==""){
	      alert("部门名称不能为空！");
	      document.getElementById("org_name").focus();
	      return false;
	    }

	    if(document.getElementById("org_desc").value==""){
	      alert("部门描述不能为空！");
	      document.getElementById("org_desc").focus();
	      return false;
	    }
 	    return true;
	}
    function check_none(current_obj)
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
    	function confirmsub(formobj)
    	{  	
    	        if (Check_Value())
    	        {
    	            formobj.submit();   	
    	        }
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
       width:'30%',
       height:'300px',
       enableDD:false,
       containerScroll: true, 
       loader: new Ext.tree.TreeLoader({
           dataUrl:'organize_tree.jsp'            
       })
   });
    var cust=document.getElementById("cust_id").value;
    var org_idx=document.getElementById("org_idx").value;
    var root_name=document.getElementById("cust_name").value;
	tree.on("click",function(node,event){
		document.getElementById("up_org_id").value=node.id;
		document.getElementById("org_name").value=node.text;
		OrganizeInfo.getOrgnaizeByOrg_id(node.id,setOrgData);
		});
    var root = new Ext.tree.AsyncTreeNode({
        text: root_name,
        draggable:false,
        iconCls:'root-Img',
        id:'000000000000000'
    });
    tree.setRootNode(root);
   	tree.render();
   	root.expand();
   	tree.expandAll();
   });
 function setOrgData(Map) 
 {
 	var org_desc=Map['org_desc'];
 	var remark=Map['remark'];
 	document.getElementById('org_desc').value = org_desc;
 	document.getElementById('remark').value = remark;	
 	}
   
     	function delOrUpdateupdate(formobj)
   	{
   	    if(window.confirm('你确定要提交吗？')) 
   	    {  	    	
   	        if (Check_Value())
   	        {
   	            document.getElementById("trade_type_code").value="1036";
   	            formobj.submit();   	
   	        }
   	    }
   	    else
   	    {
   	        return;
   	    }
   	}
   	function delOrUpdatedelet(formobj)
    	{
    	    if(window.confirm('你确定要删除吗？')) 
    	    {  	    
    	       if(Check_Value()){
	    	        if(checkChildren())
	    	        {
	    	        }
    	        }
    	    }
    	    else
    	    {
    	        return;
    	    }
    	}
    	
    	  //设置详细信息
   function setInfo(id){
     if(id!="" && id!="0"){
       OrganizeInfo.getOrganizeByOrgId(id,setOrgName);
     }else{
        document.getElementById("org_name").value="";
        document.getElementById("org_desc").value="";
        document.getElementById("remark").value="";
        document.getElementById("org_id").value="1";
     }
   }
   function setOrgName(orgMap){
    var o_org=orgMap['org_id'];
    var o_Name=orgMap['org_name'];
    var o_desc=orgMap['org_desc'];
    var o_remark=orgMap['remark'];
    document.getElementById("org_name").value=o_Name;
    document.getElementById("org_desc").value=o_desc;
    document.getElementById("remark").value=o_remark;
    document.getElementById("org_id").value=o_org;
   }
   function createSelect(num,id){
     setInfo(id);
     var div="next"+num;
     var next=parseInt(1)+parseInt(num);
     var nextDiv="next"+num;
     var cust=document.getElementById("cust_id").value;
     document.getElementById(nextDiv).innerHTML="<select name=org"+num+" id=org"+num+" onclick=createSelect("+next+",this.value)></select><div id=next"+next+"></div>"; 
     document.getElementById("active").value=num;
     OrganizeInfo.getOrganizeByUpId(cust,id,setActiveDown);
   }
   function setActiveDown(data){
      var obj="org"+document.getElementById("active").value;
      var objDiv="next"+document.getElementById("active").value;
      DWRUtil.removeAllOptions(obj);
	  DWRUtil.addOptions(obj,data);
	   var item=document.getElementById(obj).length;
	    if(item==0)
	    {
	    	document.getElementById(objDiv).style.display="none"; 
	    }
	     else
	   	{
	   		document.getElementById(objDiv).style.display="block";
	   	}
   }
   function checkChildren(){
     var cust=document.getElementById("cust_id").value;
     var org_id=document.getElementById("org_id").value;
     OrganizeInfo.checkChildren(cust,org_id,hasChildren);
   }

   function hasChildren(data){
    document.getElementById("del").value=data;
	 if(document.getElementById("del").value=="0"){
        document.getElementById("trade_type_code").value="1037";
	   document.resumeForm.submit();   	
     }else{
       alert("不能删除该部门，如果要删除，请先删除下级部门！");
       return false;
     }
   }
