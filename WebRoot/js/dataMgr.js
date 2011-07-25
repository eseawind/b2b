//customerIndex.jsp
function checkRelation(){
    if(document.getElementById("keyword").value!=""){
       document.getElementById("code").value="1";
       sumbimtData();
    }else{
      alert('请输入正确的客户名称，否则会影响你的查询结果！');
      document.getElementById("keyword").focus();
    }
  }
  function sumbimtData(){
    document.relationForm.submit();
  }
  
//modfiyUser.jsp
function modfiyUserCheck_Value()
{
	 
	document.getElementById("group_contact_phone").value=document.getElementById("phone").value;                                                                        
 	    return true;
}
function modfiyUsercheck_none(current_obj)
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
function modfiyUserexit()
{
    window.close();
}
function modfiyUserconfirmsub(formobj)
{
 
    if (!modfiyUserCheck_Value())
    {
         return;
    }    	            	           
    formobj.submit();    	         

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
function shwoOrHidden(){
if(document.getElementById("sh").style.display=="block"){
    document.getElementById("sh").style.display="none";
  }else{
    document.getElementById("sh").style.display="block";
  }
}
 var tree = new Ext.tree.TreePanel({   
    	el:"tree-div",   
        autoScroll:false,
        animate:true,
        width:'35%',
        height:'300px',
        enableDD:true,
        containerScroll: true, 
        loader: new Ext.tree.TreeLoader({
            dataUrl:'/member/organizeMgr/organize_tree.jsp'            
        })
    });
 function createTree(){
    var cust=document.getElementById("cust_id").value;
    var org_idx='000000000000000';
    var root_name=document.getElementById("cust_name").value;
	tree.on("click",function(node,event){
	  document.getElementById("org_depart_code").value=node.id;
	  document.getElementById("depart_name").value=node.text;
	});
    var root = new Ext.tree.AsyncTreeNode({
        text: root_name,
        draggable:false,
        iconCls:'root-Img',
        id:org_idx
    });
    tree.setRootNode(root);
   	var id=root.id;
   	OrganizeInfo.getOrganizeByUpIdMap(cust,id,function(data){
	for(var j=0;j<data.length;j++){ 
             var obj=data[j];
              callBackFunction(obj,tree.getNodeById(id));
     }
   	});
   	tree.render();
   	root.expand();
   	tree.expandAll();
   }
   
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
   
   function setAreas(city_id){
	AreaInfo.getAreaByParent(city_id,function(data){
	 DWRUtil.removeAllOptions("city");
     DWRUtil.addOptions("city",fectureArray);
	 DWRUtil.addOptions("city",data);
	});
}
function setCitys(prov){
   var provence=prov;
	 AreaInfo.getAreaByParent(provence,function(data){
	 DWRUtil.removeAllOptions("eparchy_code");
	 DWRUtil.addOptions("eparchy_code",fectureArray);
	 DWRUtil.addOptions("eparchy_code",data);
	 DWRUtil.removeAllOptions("city");
	 DWRUtil.addOptions("city",fectureArray);
	});
}