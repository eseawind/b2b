function Check_Value() {
	if (confirm("确定要删除产品分类资料？")) {
		var name = document.getElementById("class_name").value;
		if (name == "" || name == null) {
			Ext.MessageBox.alert("产品管理", "请选择要删除的产品分类！");
			return false;
		} else {
			var class_id = document.getElementById("class_id").value;
			var cust_id = document.getElementById("cust_id").value;
			AddProductInfo.checkChildren(cust_id, class_id, function(child) {
				if (child == "0") {
					document.productForm.submit();
				} else {
					Ext.MessageBox.alert("产品管理", "请先删除产品子分类！");
				}
			});
		}
		return true;
	} else {
		return false;
	}
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
		if(node.id !="000000000000000"){
		document.getElementById("class_id").value = node.id;
		var cust_id = document.getElementById("cust_id").value;
		AddProductInfo.getproductById(cust_id, node.id, setData);
		}else{
			alert("根节点不能删除！");
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