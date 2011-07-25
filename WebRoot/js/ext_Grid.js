
/**************************************************************************/
/**************用Ext生成列表页面的方法**************************************/
/**************************************************************************/
//初始化Ext列表信息:gridInitalize方法为实例
 //调用时用如下写法,
 
 //Ext.onReady(function(){uerSelfFunction();});

//开发人员可按自己的需求进行合理的扩展,
 function uerSelfFunction(){
 	//数据源
 	var data_url='J_data.jsp';
 	
 	//显示位置
 	var div_show="grid";
 	
 	//列表标题
 	var title="表标题";
 	
 	//字段[***************************************************************]
 	//此字段是与表头里出现的列数相对应
 	var fields=new Array({name : 'id'},{name : 'name'},{name : 'descn'});
 	
 	//数据源[其格式固定不变]
 	var dds=new Ext.data.Store({proxy : new Ext.data.HttpProxy({url : data_url}),reader : new Ext.data.JsonReader({totalProperty : 'totalCount',root : 'root',fields:fields })
	
	});
	//列表宽度
	var gridWidth=450;
	
	//是否显示行号
	var rm=new Ext.grid.RowNumberer();
	//是否有复选框
 	var sm=new Ext.grid.CheckboxSelectionModel();
 	
 	//表头,有多少列，就写多个列，按自己的需要，像id等不要显示出来，但要用到其值，可以将[hidden:true]
 	//
 	var headField= new Array();
 	headField.push(rm);
 	headField.push({header : '编号',dataIndex:'id',sortable : true,hidden:false,hideable:true,width:100});
 	headField.push({header : '名称',dataIndex : 'name',sortable : true,width:150});
 	headField.push({header : '描述',dataIndex : 'descn',sortable : true,width:200});
 	var cm = new Ext.grid.ColumnModel(headField);
 	
 	//一页显示多少条
 	var pageSize=10;
 	
 	//工具条[按用户自已的需要进行扩展]
 	
 	var toolsBar;
 	//=new Array();
 	//toolsBar.push({text: '查看用户',iconCls:'details',handler : function(){alert('查看用户')}});
 	//toolsBar.push({text: '修改用户',iconCls:'add',handler : function(){alert('修改用户')}});
 	//toolsBar.push({text: '删除用户',iconCls:'remove',handler : function(){alert('删除用户')}});
 	
 	//开始调用方法
 	CreateGridPanal(toolsBar,cm,sm,div_show,title,dds,gridWidth,pageSize);
 }

var grid;
//生成列表公用方法
function CreateGridPanal(toolsBar,cm,sm,div_show,title_msg,dds,gridWidth,pageSize) {
	
	 grid = new Ext.grid.GridPanel({
		el : div_show,
		ds : dds,
		cm : cm,
		autoWidth:true,
		autoHeight:true,
		frame:true,
		title:title_msg,
		sm:sm,
        clicksToEdit:1,
        selModel: new Ext.grid.RowSelectionModel({singleSelect:false}),
		tbar:toolsBar,
		
		bbar : new Ext.PagingToolbar({
			pageSize : pageSize,
			store : dds,
			displayInfo : true,
			displayMsg : '显示{0}到{1}条记录，总共{2}条记录',
			emptyMsg : '没有记录'
		})
	});
	grid.render();
	dds.load({
		params : {
			start : 0,
			limit : 10
		}
	});
}
