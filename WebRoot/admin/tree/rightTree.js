
/*******************************************************************************
 * 软件在线组装
 * 
 * @B2B软件平台
 */
Ext.BLANK_IMAGE_URL = "../ext/resources/images/default/s.gif"
Ext.onReady(function() {
	var sub_code=$F('s_sub_code');       
    var cust_class=$F('s_cust_class');
    var data = Math.round(Math.random() * 10000);
	var resizeable = new Ext.Resizable('tree-send', {
		pinned : true,
		autoWidth : true,
		autoHeight : true,
		handles : 'e',
		widthIncrement : 50,
		minWidth : 50,
		maxWidth : 450,
		dynamic : true
	});
	var tree = null;
	var Tree = Ext.tree;
	tree = new Tree.TreePanel({
		el : 'tree-send',
		autoScroll : false,
		animate : true,
		enableDD : false,
		width : '35%',
		autoHeight : true,
		containerScroll : true,
		loader : new Tree.TreeLoader({
			  dataUrl:'s_json.jsp?cust_class='+cust_class+'&data='+data+'&sub_code='+sub_code
		}),
		rootVisible : true
		
	});
	
	var obj=tree.getChecked();
	if(obj.length>0){
		var menu_idex="";
	    for(var i=0;i<obj.length;i++){
	    	menu_idex =menu_idex + checkedNodes[i].id + "|";
	    }
	   $("menu_id").value=menu_idex;
	}
	
	tree.on('checkchange', function(node, checked) {
		var obj=tree.getChecked();
	    alert(obj.length);
		node.expand();
		node.attributes.checked = checked;
		if (checked) {
			var org_idx = $F("depart_group");
			if (org_idx.indexOf(node.id) == -1) {
				$("depart_group").value = $F("depart_group") + node.id + "|";
			}
		} else {
			var st = $F("depart_group");
			st = st.replace(node.id + "|", '');
			$("depart_group").value = st;
		}
		node.eachChild(function(child) {
			child.ui.toggleCheck(checked);
			child.attributes.checked = checked;
			child.fireEvent('checkchange', child, checked);
		});
	}, tree);
	var root = new Tree.AsyncTreeNode({
		text : '服务菜单权限结构',
		draggable : false,
		iconCls : 'root-Img',
		id : 'root'
	});
	tree.setRootNode(root);
	tree.render();
	root.expand();
	//tree.expandAll();
});