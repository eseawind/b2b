/*
 * Ext JS Library 2.0.2
 * Copyright(c) 2006-2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

function showWindow() {
	 Ext.QuickTips.init(); 
	 Ext.form.Field.prototype.msgTarget = 'side';
	 var window;
	 var form;
	 if(!window){
	 	form = new Ext.form.FormPanel({
	        baseCls: 'x-plain',
	        labelWidth: 55,
			height:200,
			autoHeight:true,
	        url:'save-form.php',
	        defaultType: 'textfield',
	
	        items: [{
	            fieldLabel: '地址',
	            name: 'to',
				allowBlank:false,
				blankText:'请输入地址！',
	            anchor:'50%'  
	        },{
	            fieldLabel: '标题',
	            name: 'subject',
				allowBlank:false,
				blankText:'请输入标题！',
	            anchor: '80%'  
	        }, {
				fieldLabel: '内容',
	            xtype: 'textarea',
	            hideLabel: false,
				allowBlank:false,
				blankText:'请输入内容！',
	            name: 'msg',
				autoHeight:false,
				maxLength:50,
	            anchor: '100%'  
	        },{
			xtype:'fieldset',
            title: 'Phone Number',
            collapsible: true,
            autoHeight:true,
            defaults: {width: 210},
            defaultType: 'textfield',
            items :[{
                    fieldLabel: 'Home',
                    name: 'home',
                    value: '(888) 555-1212'
                },{
                    fieldLabel: 'Business',
                    name: 'business'
                },{
                    fieldLabel: 'Mobile',
                    name: 'mobile'
                },{
                    fieldLabel: 'Fax',
                    name: 'fax'
                }
            ]
         }
			]
       });
	var comboxWithPanel = new Ext.form.ComboBox({   
	    store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	    editable:false,   
	    mode: 'local',   
	    triggerAction:'all',   
	    maxHeight: 200,   
	    tpl: '<div style="height:200px"><div id="panel"></div></div>',   
	    selectedClass:'',   
	    onSelect:Ext.emptyFn   
	});   
	comboxWithPanel.render('comboxWithPanel');   
	var tree2 = new Ext.tree.TreePanel({   
	    loader: new Ext.tree.DWRTreeLoader({dwrCall:Tmplt.getTmpltTree}),   
	    border:false,   
	    autoScroll:true,   
	    root:new Ext.tree.AsyncTreeNode({text: '模板根目录',id:'0'})   
	    });   
	var border = new Ext.Panel({   
	    title:'面板title',   
	    layout:'fit',   
	    border:false,   
	    height :200,   
	    tbar:[{text:'确定一'},'-',new Ext.form.TextField({id: 'paramCnName',width:60}),{text:'查找一'}],   
	    bbar:[{text:'确定二'},'-',new Ext.form.TextField({id: 'aa',width:60}),{text:'查找二'}],   
	    items: tree2   
	    });   
	comboxWithPanel.on('expand',function(){   
	    border.render('panel');   
	    });  

	     window = new Ext.Window({
	        title: '社会公德',
	        width: 500,
			iconCls:'root-Img',
	        autoHeight:true,
	        minWidth: 300,
	        minHeight: 200,
	        layout: 'fit',
	        plain:true,
	        bodyStyle:'padding:5px;',
	        buttonAlign:'center',
	        items: form,
	        buttons: [{
	            text: '发送',
				handler:saveInfo
	        },{
	            text: '关闭',
				handler:closeWind
	        }]
	    });
		window.show();
	}else{
		window.show();
	}
	function closeWind(){
		window.hide();
	}
	function saveInfo(){
		var addr=form.form.getValues().to;
		var title=form.form.getValues().subject;
		var content=form.form.getValues().msg;
		Ext.MessageBox.alert('saas',addr+"  "+title+"  "+content);	
	}
}