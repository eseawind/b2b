 function Check_Value()
 { 
        var name=document.getElementById("class_name").value;
	    if(name=="" || name==null){
	      Ext.MessageBox.alert("bizoss","产品名称不能为空！");
	      return false;
	    }
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
     Ext.QuickTips.init();
     Ext.form.Field.prototype.msgTarget = 'side';
     var win;
     var tree = new Ext.tree.TreePanel({   
    	el:"tree-div",   
        autoScroll:false,
        animate:true,
        width:"40%",
        height:'300px',
        enableDD:true,
        containerScroll: true, 
        loader: new Ext.tree.TreeLoader({
            dataUrl:'json_data.jsp'            
        })
    });
    
     var panel = new Ext.FormPanel({
        labelWidth: 75, // label settings here cascade unless overridden
        frame:true,
        title: '产品属性录入',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',

        items: [{
                fieldLabel: '属性名称',
                name: 'attr_name',
                width:'150',
                allowBlank:false,
                blankText:'请填写属性名称！'
            },{
                fieldLabel: '属性顺序',
                name: 'attr_no',
                xtype:'numberfield',
                width:'50',
                allowBlank:false,
                maxValue:1000,
                blankText:'请填写属性顺序!只能为数字类型！',
                invalidText:'属性顺序只能为数字类型!'
            },{
                fieldLabel: '默认值',
                width:'100',
                name: 'default_value',
                allowBlank:false,
                blankText:'请填写属性默认值!'
            },{
	            xtype: 'textarea',
	            fieldLabel: '属性描述',
	            hideLabel: false,
	            name: 'attr_desc',
	            height:'75',
	            width: '220'  // anchor width by percentage and height by raw adjustment
        	}, {
                fieldLabel: '备注',
                name: 'remark',
                vtype:'textfield'
            }
        ]
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
		document.getElementById("class_id").value=node.id;
		var cust_id = document.getElementById("cust_id").value;
		 
        // create the window on the first click and reuse on subsequent clicks
        if(!win){
            win = new Ext.Window({
                el:'div-win',
                layout:'fit',
                width:370,
                maximizable :true,
                minimizable :true,
                height:320,
                closeAction:'hide',
                plain: true,
                items:panel,
		        buttons: [{
		            text: '提交',
		            handler:function(){
		            	var attr_name = panel.form.getValues().attr_name;
		            	if ( attr_name=="" || attr_name==null ){
		            		Ext.MessageBox.alert("bizoss提示","属性名称不能为空！");
		            		return false;
		            	}else{
		            		document.getElementById("attr_name").value=attr_name;
		            	}
						var attr_no = panel.form.getValues().attr_no;
						if ( attr_no =="" || attr_no==null ){
		            		Ext.MessageBox.alert("bizoss提示","属性顺序不能为空！");
		            		return false;
		            	}else{
		            		document.getElementById("attr_no").value=attr_no;
		            	}
						var default_value = panel.form.getValues().default_value;
						if ( default_value=="" || default_value==null){
		            		Ext.MessageBox.alert("bizoss提示","默认值不能为空！");
		            		return false;
		            	}else{
		            		document.getElementById("default_value").value=default_value;
		            	}
		            	var attr_desc=panel.form.getValues().attr_desc;
						document.getElementById("attr_desc").value=attr_desc;
		            	var remark=panel.form.getValues().remark;
						document.getElementById("remark").value=remark;
		            	
		            	document.productForm.submit();
		            }
			        },{
			            text: '取消',
			            handler:function(){
			             win.hide();
			            }
			        }]
	            });
	        }
        win.show(this);
    
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
 
   function validateNumber(value){
   	alert(value);
   }
  