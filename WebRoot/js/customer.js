var grid = null;
function createGrid(){
	var sm = null;
	var cm = null;
	var ds = null;
	var data = null;
	var isReady = false;
	if(!grid){
    sm = new Ext.grid.CheckboxSelectionModel();
    cm = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
         sm,
        {header:'编号',dataIndex:'id',width: 100,hidden:true},
        {header:'客户名称',dataIndex:'name',width: 150},
        {header:'邮件地址',dataIndex:'email',width: 150},
        {header:'联系电话',dataIndex:'phone',width: 100},
        {header:'建立日期',dataIndex:'date',width: 100}
    ]);
    cm.defaultSortable = true;
    ds = new Ext.data.Store({
        proxy: new Ext.data.HttpProxy({url:'/salesFormMgr/custStore.jsp'}),
        reader: new Ext.data.JsonReader({
            root: 'root',
            totalProperty: 'totalCount'
         }, [
            {name: 'id'},
            {name: 'name'},
            {name: 'email'},
            {name: 'phone'},
            {name: 'date'}
        ])
    });
	
    ds.load({params:{start:0, limit:10}});

    grid = new Ext.grid.GridPanel({
        el: 'grid3',
        ds: ds,
        cm: cm,
        stripeRows: true,
		frame:false,
        sm: sm,
        tbar: new Ext.PagingToolbar({
            pageSize: 10,
            store: ds,
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
            emptyMsg: "没有记录"
        }),
        bbar: new Ext.PagingToolbar({
            pageSize: 10,
            store: ds,
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
            emptyMsg: "没有记录"
        }),
       
        autoHeight:true,
        autoWidth:true//510
    });
    grid.render();
    grid.getSelectionModel().selectFirstRow();
    isReady = true;
	}else{
		grid.show();
	}
}



///
function showWindow(){
///////////
	//document.getElementById("bnt").disabled=true;
  createGrid();
  var scoketNewsWin;
  if(!scoketNewsWin){
        scoketNewsWin=new Ext.Window({
        title:'销售客户列表',
        width:530,
        modal:true,
        autoHeight:true,
        maximizable :true,
        minimizable :true,
        iconCls :'user-Img',
		items: grid,
		 buttons:[
		 { 
		   text:'提交',
           disabled:false,
           handler:function(){
			var record = grid.getSelectionModel().getSelected();// 返回值为 Record 类型
			if(!record){
				Ext.MessageBox.alert("提示","请先选择销售客户!");
				return;
			}
			// 弹出对话框警告
			if(record) {
			 document.getElementById("obj_cust_name").value=record.get("name");
			 document.getElementById("obj_cust_id").value=record.get("id");
			 scoketNewsWin.hide();
			}
           }
         },
         {
         	text:'取消',
         	handler: function(){
            scoketNewsWin.hide();
            grid.hide();
           }
         }
		 ]   
	    });
	      scoketNewsWin.show();
        }else{
	      scoketNewsWin.show();
 }
///////////
}


