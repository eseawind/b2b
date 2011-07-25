<%@ page pageEncoding="GBK"%>
<html>
	<head>
		<title>text---tree</title>
		<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="/ext/ext-all.js"></script>
		<script type="text/javascript" src="window.js"></script>
		<style type="text/css">
		.Tree-Img {
		    background-image:url(/images/org.png) !important;
		}
		.root-Img {
		    background-image:url(/images/home.png) !important;
		}
      </style>
		<script type="text/javascript">
         function createTree(){
	      
      }
      function createComBoxTree(){
      
      Ext.QuickTips.init();
       var comboWithTooltip = new Ext.form.ComboBox({
        store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	    editable:false,   
	    mode: 'local',   
	    triggerAction:'all',   
	    maxHeight: 200,   
	    tpl: '<div style="height:200px"><div id="tree"></div></div>',   
	    selectedClass:'',   
	    onSelect:Ext.emptyFn,
	    emptyText:'请选择竞争对手分类管理...',
	    applyTo: 'local-states-with-qtip'  
     });
      comboWithTooltip.render('comboWithTooltip');  
      
      var tree = new Ext.tree.TreePanel({   
	    	border:false,   
	        autoScroll:true,
	        animate:true,
	        width:'100px',
	        autoHeight:true,
	        checkModel: 'cascade',
	        onlyLeafCheckable: false,
	        enableDD:true,
	        containerScroll: true, 
	        loader: new Ext.tree.TreeLoader({
	            dataUrl:'/tree/jsonClass_data.jsp?type=2'            
	        })
	    });
		tree.on("click",function(node,event)
		{
		   comboWithTooltip.setValue(node.text); 
		   document.getElementById('conValue').value=node.id;
           comboWithTooltip.collapse();   

		});
	          
	    var root = new Ext.tree.AsyncTreeNode({
	        text: '竞争对手分类管理',
	        draggable:false,
	        iconCls:'root-Img',
	        id:'root'
	    });
	    
	    tree.setRootNode(root);
	    
        comboWithTooltip.on('expand',function(){   
         tree.render('tree');  
         tree.expandAll(); 
        });   
       
      }
      
      function getComboxValue(){
        alert('name=='+document.getElementById('local-states-with-qtip').value);
        alert('value=='+document.getElementById('conValue').value);
      }
      </script>
	</head>
	<body onload="createTree()">
		<div id="tree-div"></div>
		<input type="button" value="弹出窗体" name="wind" onclick="createComBoxTree()">
		<div style="height:200px;background-color:red;width: 250"><div id="panel"></div></div>
  ==============
  <input type="text" id="local-states-with-qtip" style="margin-left: 50px"/>
  <input type="text" id="conValue" style="margin-left: 50px" size="20"/>
  ==================
  <input type="button" value="输出值" name="wind" onclick="getComboxValue()">
	</body>
</html>





