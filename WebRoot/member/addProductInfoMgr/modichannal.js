function Check_Value() {
	var name = document.getElementById("class_name").value;
	if (name == "" || name == null) {
		Ext.MessageBox.alert("bizoss", "产品名称不能为空！");
		return false;
	}
	return true;
}
function selectLevel(val) {
	if (val == "2") {
		document.getElementById("upShow").style.display = "block";
		document.getElementById("class_level").value = "1";
	} else {
		document.getElementById("upShow").style.display = "none";
		document.getElementById("up_class_id").value = "000000000000000";
		document.getElementById("class_level").value = "0";
	}
}
Ext.onReady(function() {

	var tree = new Ext.tree.TreePanel({
		el : "tree-div",
		autoScroll : false,
		animate : true,
		width : '30%',
		height : '300px',
		enableDD : true,
		containerScroll : true,
		loader : new Ext.tree.TreeLoader({
			dataUrl : 'json_data.jsp'
		})
	});
	var resizeable = new Ext.Resizable('tree-div', {
		pinned : true,
		autoWidth : true,
		autoHeight : true,
		handles : 'e',
		widthIncrement : 50,
		minWidth : 50,
		maxWidth : 450,
		dynamic : true
	});
	tree.on("click", function(node, event) {
		var idex=node.id;
		if(idex!='000000000000000'){
		document.getElementById("class_id").value = node.id;
		var cust_id = document.getElementById("cust_id").value;
		AddProductInfo.getproductById(cust_id, node.id, setData);
		}else{
			alert('根节点不能修改！');
		}
	});
	var root = new Ext.tree.AsyncTreeNode({
		text : '产品分类',
		draggable : false,
		iconCls : 'root-Img',
		id : '000000000000000'
	});
	tree.setRootNode(root);
	tree.render();
	root.expand();
	tree.expandAll();
});
function setData(Map) {
	var class_name = Map['class_name'];
	var class_desc = Map['class_desc'];
	var enable_tag = Map['enable_tag'];
	var remark = Map['remark'];
	document.getElementById("class_name").value = class_name;
	document.getElementById("class_desc").value = class_desc;
	document.getElementById("enable_tag").value = enable_tag;
	document.getElementById("remark").value = remark;
}