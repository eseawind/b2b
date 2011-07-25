<%@ page pageEncoding="GBK"%>
<%
	String sub_code = "";
	if (request.getParameter("sub_code") != null) {
		sub_code = request.getParameter("sub_code");
	}
%>
<html>
	<head>
		<title>B2B电子商务后台管理系统</title>
		<link href="/style/layout.css" rel="stylesheet" type="text/css">
		<style type="text/css">
		.Tree-Img {
		    background-image:url(/images/org.png) !important;
		}
		.root-Img {
		    background-image:url(/images/home.png) !important;
		}
		</style>
		<link rel="stylesheet" type="text/css" href="../ext/resources/css/ext-all.css" />
		<script type="text/javascript" src="../ext/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../ext/ext-all.js"></script>
		<script type="text/javascript" src="../ext/build/locale/ext-lang-zh_CN.js"></script>
		<script language="javascript" src="/js/prototype.js"></script>
		<script type="text/javascript">
	 Ext.onReady(
	 function() {
	  var data = Math.round(Math.random() * 10000);
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
    var sub_code=$F('sub_code');
    var tree = new Ext.tree.TreePanel({   
   	el:"tree-div",   
       autoScroll:false,
       animate:true,
       autoWidth:true,
       height:'300px',
       enableDD:false,
       rootVisible:true,
       containerScroll: true, 
       loader: new Ext.tree.TreeLoader({
           dataUrl:'r_json.jsp?data='+data+'&sub_code='+sub_code            
       })
   });
	tree.on("click",function(node,event){
	 document.getElementById("r_menu_id").value=node.id;
   });
    var root = new Ext.tree.AsyncTreeNode({
        text: '回收菜单权限',
        draggable:false,
        iconCls:'root-Img',
        id:'000000000000000'
    });
    tree.setRootNode(root);
   	tree.render();
   	root.expand();
   //tree.expandAll();
   });
		</script>
	</head>
	<body>
	<input type="hidden" name="sub_code" id="sub_code" value="<%=sub_code%>">
	<input type="text" name="r_menu_id" id="s_menu_id" value="">
	<div id="tree-div"></div>
	</body>
</html>



