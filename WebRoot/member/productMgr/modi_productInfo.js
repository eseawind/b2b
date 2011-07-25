 function Check_Value()
 { 
        var name=document.getElementById("product_name").value;
	   if(name=="" || name==null){
	      Ext.MessageBox.alert("bizoss","产品名称不能为空！");
	      return false;
	   }
	 
	    var size=document.getElementById("size").value;
	    var values="";
	    for(var i=0;i<size;i++){
	      var obj="attr_value"+i;
	      values=values+document.getElementById(obj).name+"#"+document.getElementById(obj).value+"|";
	    }
	    document.getElementById("rsrv_str1").value=values;
 	    return true;
}
function selectLevel(val){
	  if(val=="2"){
	    document.getElementById("upShow").style.display="block";
		document.getElementById("class_level").value="1";
	  }else{
	    document.getElementById("upShow").style.display="none";
	    document.getElementById("up_class_id").value="000000000000000";
		document.getElementById("class_level").value="0";
	  }
}
Ext.onReady(function(){ 

     var tree = new Ext.tree.TreePanel({   
    	el:"tree-div",   
        autoScroll:false,
        animate:true,
        width:'30%',
        height:'300px',
        enableDD:true,
        containerScroll: true, 
        loader: new Ext.tree.TreeLoader({
            dataUrl:'json_data.jsp'            
        })
    });
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
	tree.on("click",function(node,event){
	    document.getElementById("product_class").value=node.id;
		setProductDiv(node.id);
		});
    var root = new Ext.tree.AsyncTreeNode({
        text:'产品分类',
        draggable:false,
        iconCls:'root-Img',
        id:'000000000000000'
    });
    tree.setRootNode(root);
   	tree.render();
   	root.expand();
   	tree.expandAll();
   });
   
   function setProductDiv(class_id){
   	document.getElementById('loading').style.display="block";
	document.getElementById('product-div').innerHTML="";
	var data=Math.round(Math.random()*10000);
   	var custAjax=new Ajax.Request(
	 'modi_del_productInfo.jsp?class_id='+class_id+"&datas="+data,{
	  method:'get',
	  onComplete:showResponse
	 }
	);
   }
   
   function showResponse(response){
   	 document.getElementById('loading').style.display="none";
   	 document.getElementById('product-div').innerHTML=response.responseText;
   }
   