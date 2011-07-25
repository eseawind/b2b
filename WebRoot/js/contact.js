var grid_con = null;
function createContactGrid(){
	var sm = null;
	var cm = null;
	var ds = null;
	var data = null;
	var isReady = false;
	if(!grid_con){
    sm = new Ext.grid.CheckboxSelectionModel();
    cm = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
         sm,
        {header:'编号',dataIndex:'id',width: 100,hidden:true},
        {header:'联系人姓名',dataIndex:'name',width: 150},
        {header:'邮件地址',dataIndex:'email',width: 150},
        {header:'联系电话',dataIndex:'phone',width: 100},
        {header:'联系地址',dataIndex:'addr',width: 150}
    ]);
    cm.defaultSortable = true;
    ds = new Ext.data.Store({
        proxy: new Ext.data.HttpProxy({url:'conStore.jsp'}),
        reader: new Ext.data.JsonReader({
            root: 'root',
            totalProperty: 'totalCount'
         }, [
            {name: 'id'},
            {name: 'name'},
            {name: 'email'},
            {name: 'phone'},
            {name: 'addr'}
        ])
    });
	
    ds.load({params:{start:0, limit:10}});

    grid_con = new Ext.grid.GridPanel({
        el: 'grid4',
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
        width:600
    });
    grid_con.render();
    grid_con.getSelectionModel().selectFirstRow();
    isReady = true;
	}else{
		grid_con.show();
	}
}



///
function showContactWind(){
///////////
	//document.getElementById("bnt").disabled=true;
  createContactGrid();
  var contactWind;
  if(!contactWind){
        contactWind=new Ext.Window({
        title:'联系人列表',
        width:610,
        modal:true,
        autoHeight:true,
        maximizable :true,
        minimizable :true,
        iconCls :'user-Img',
		items: grid_con,
		 buttons:[
		 { 
		   text:'提交',
           disabled:false,
           handler:function(){
			var record = grid_con.getSelectionModel().getSelected();// 返回值为 Record 类型
			if(!record){
				Ext.MessageBox.alert("提示","请先选择联系人!");
				return;
			}
			// 弹出对话框警告
			if(record) {
			 document.getElementById("contact_man").value=record.get("name");
			 contactWind.hide();
			}
           }
         },
         {
         	text:'取消',
         	handler: function(){
            contactWind.hide();
            grid_con.hide();
           }
         }
		 ]   
	    });
	      contactWind.show();
        }else{
	      contactWind.show();
 }
///////////
}


