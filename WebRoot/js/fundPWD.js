/*
 * Ext JS Library 2.1
 * Copyright(c) 2006-2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.onReady(function(){
    var win;
    Ext.QuickTips.init();
    Ext.form.Field.prototype.msgTarget = 'side';
    var button = Ext.get('show-btn');
    var form1 = new Ext.FormPanel({
        labelWidth: 75, // label settings here cascade unless overridden
        url:'/doTradeReg.do?trade_type_code=1160',
        frame:true,
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        items: [{
            xtype:'fieldset',
            title: '请填写相关信息！',
            collapsible: true,
            autoHeight:true,
            defaults: {width: 210},
            defaultType: 'textfield',
            items :[{
                    fieldLabel: '系统帐号',
                    name: 'user_name',
                    allowBlank:false,
                    blankText:'请填写系统帐号！'
                },{
                    fieldLabel: '客户名称',
                    name: 'cust_name',
                    allowBlank:false,
                    blankText:'请填写客户名称！'
                },{
                    fieldLabel: '电子邮箱',
                    allowBlank:false,
				    blankText:'请输入邮箱地址，系统将密码发送到你的信箱！',
                    name: 'email',
                    vtype:'email'
                }
            ]
        }]
    });
    button.on('click', function(){
        if(!win){
            win = new Ext.Window({
                el:'hello-win',
                layout:'fit',
                width:370,
                autoScroll:true,
                title:'找回密码',
                maximizable :true,
                height:210,
                frame:true,
                closeAction:'hide',
                plain: true,
                items:form1,
		        buttons: [{
		            text: '提交',
		            handler:submitform
			        },{
			            text: '取消',
			            handler:function(){
			             win.hide();
			            }
			        }]
	            });
	        }
        win.show(this);
    });
    function submitform(){
    	var user_name=form1.form.getValues().user_name;
    	if(user_name =="" || user_name==null){
    	 Ext.MessageBox.alert("bizoss 提示","请填写系统帐号！");
    	 form1.form.user_name.focus();
    	 return;
    	}
    	var cust_name=form1.form.getValues().cust_name;
    	if(cust_name =="" || cust_name==null){
    	 Ext.MessageBox.alert("bizoss 提示","请填写客户名称！");
    	 return;
    	}
    	var email=form1.form.getValues().email;
    	if(email =="" || email==null){
    	 Ext.MessageBox.alert("bizoss 提示","请填写注册时用的邮箱地址，系统将正确定的密码发送到该邮箱！！");
    	 return;
    	}
    	form1.form.submit();
    }
});