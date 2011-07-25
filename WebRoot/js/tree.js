/*
 * EasyJF开源示例程序
 * Copyright(c) 2006-2008, EasyJF.com.
 * easyjf @ 163.com
 * 该程序代码归EasyJF开源所有
 * http://www.easyjf.com
 */
Ext.BLANK_IMAGE_URL = 'images/s.gif';
Ext.onReady(function(){ 
    var tree = new Ext.tree.TreePanel({   
    	el:"tree-div",   
        autoScroll:true,
        animate:true,
        width:'100px',
        height:'300px',
        enableDD:true,
        containerScroll: true, 
        loader: new Ext.tree.TreeLoader({
            dataUrl:'region.ejf?cmd=getRegion'            
        })
    });
	tree.on("click",function(node,event){alert(node.id);});
	tree.on('beforeload',function(node){		
            tree.loader.dataUrl = 'region.ejf?cmd=getRegion&id='+(node.id!='root'?node.id:"");
        });        
    var root = new Ext.tree.AsyncTreeNode({
        text: '地区信息',
        draggable:false,
        id:'root'
    });
    tree.setRootNode(root);
    tree.render();
   	root.expand();
	var node1 = new Ext.tree.TreeNode({text:'偶是根的第一个枝子'});
	var node2 = new Ext.tree.TreeNode({text:'偶是根的第一个枝子的第一个叶子'});
	var node3 = new Ext.tree.TreeNode({text:'偶是根的第一个叶子'});
	node1.appendChild(node2);
	root.appendChild(node1);
	root.appendChild(node3);
});