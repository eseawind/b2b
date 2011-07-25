
var TreeTest = function(){
    var Tree = Ext.tree;
    return {
        init : function(){
            var tree = new Tree.TreePanel({
                el:'tree',
                animate:true, 
                autoScroll:true,
                loader: new Tree.TreeLoader({dataUrl:'get-nodes.php'}),
                enableDD:true,
                containerScroll: true,
                dropConfig: {appendOnly:true}
            });
            new Tree.TreeSorter(tree, {folderSort:true});
            var cust=document.getElementById("cust_id").value;
    var org_idx=document.getElementById("org_idx").value;
    var root_name=document.getElementById("cust_name").value;
	tree.on("click",function(node,event){document.getElementById("up_org_id").value=node.id;setInfo(node.id);});
    var root = new Ext.tree.AsyncTreeNode({
        text: root_name,
        draggable:false,
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
            root.expand(false, /*no anim*/ false);
			tree2.expandAll();
        }
    };
}();

Ext.EventManager.onDocumentReady(TreeTest.init, TreeTest, true);