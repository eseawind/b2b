var grid_user = null;
function createUserGird(){
	var sm = null;
	var cm = null;
	var ds = null;
	var data = null;
	var isReady = false;
	if(!grid_user){
    sm = new Ext.grid.CheckboxSelectionModel();
    cm = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
         sm,
        {header:'编号',dataIndex:'id',width: 100,hidden:true},
        {header:'员工姓名',dataIndex:'name',width: 150},
        {header:'邮件地址',dataIndex:'email',width: 150},
        {header:'联系电话',dataIndex:'phone',width: 100},
        {header:'联系地址',dataIndex:'addr',width: 150}
    ]);
    cm.defaultSortable = true;
    ds = new Ext.data.Store({
        proxy: new Ext.data.HttpProxy({url:'/admin/salesFormMgr/userStore.jsp'}),
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

    grid_user = new Ext.grid.GridPanel({
        el: 'grid5',
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
    grid_user.render();
    grid_user.getSelectionModel().selectFirstRow();
    isReady = true;
	}else{
		grid_user.show();
	}
}



///
function showUserWind(){
///////////
	//document.getElementById("bnt").disabled=true;
  createUserGird();
  var userWind;
  if(!userWind){
        userWind=new Ext.Window({
        title:'员工列表',
        width:610,
        maximizable :true,
        minimizable :true,
        iconCls :'cust-Img',
        modal:true,
        plain:true,
        autoHeight:true,
		items: grid_user,
		 buttons:[
		 { 
		   text:'提交',
           disabled:false,
           handler:function(){
			var record = grid_user.getSelectionModel().getSelected();// 返回值为 Record 类型
			if(!record){
				Ext.MessageBox.alert("提示","请先选择员工!");
				return;
			}
			// 弹出对话框警告
			if(record) {
			 document.getElementById("sale_user_name").value=record.get("name");
			 document.getElementById("sale_user_id").value=record.get("id");
			 userWind.hide();
			 userWind.hide();
			}
           }
         },
         {
         	text:'取消',
         	handler: function(){
            userWind.hide();
            grid_user.hide();
           }
         }
		 ]   
	    });
	      userWind.show();
        }else{
	      userWind.show();
 }
///////////
}


