	var panel;
    function showPanel(){
     panel = new Ext.FormPanel({
        labelWidth: 75, // label settings here cascade unless overridden
        frame:true,
        title: '�˵�Info�޸�',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',

        items: [{
                fieldLabel: '�˵�����',
                name: 'menu_id',
                width:'150',
                allowBlank:false
               // blankText:'����д��������!'
            },{
                fieldLabel: '�˵���',
                name: 'menu_name',
                xtype:'numberfield',
                width:'150',
                allowBlank:false,
                maxValue:1000,
                blankText:'����д�˵�����!'
                //invalidText:'����˳��ֻ��Ϊ��������!'
            },{
                fieldLabel: '�ļ�·��',
                width:'100',
                name: 'module_dir',
                allowBlank:false
                //blankText:'����д����Ĭ��ֵ!'
            },{
                fieldLabel: '�ļ���',
                width:'100',
                name: 'module_file',
                allowBlank:false
                //blankText:'����д����Ĭ��ֵ!'
            },{
	            xtype: 'textarea',
	            fieldLabel: '��������',
	            hideLabel: false,
	            name: 'rsrv_str4',
	            height:'75',
	            width: '220'  // anchor width by percentage and height by raw adjustment
        	}, {
                fieldLabel: '��ע',
                name: 'remark',
                vtype:'textfield'
            }
        ]
    });
    }
        
	function showWin(){
		var menu_id = document.getElementById('menu_id').value;
		var menu_class = document.getElementById('menu_class').value;
		var win='true';
		 
        // create the window on the first click and reuse on subsequent clicks
        if(win){
            win = new Ext.Window({
                el:'div-win',
                layout:'fit',
                width:370,
                maximizable :true,
                minimizable :true,
                height:320,
                closeAction:'hide',
                plain: true,
                items:panel,
		        buttons: [{
		            text: '�ύ',
		            handler:function(){
		            	var menu_name = panel.form.getValues().menu_name;
		            	if ( menu_name=="" || menu_name==null ){
		            		Ext.MessageBox.alert("bizoss��ʾ","�������Ʋ���Ϊ�գ�");
		            		return false;
		            	}else{
		            		document.getElementById("attr_name").value=attr_name;
		            	}
						var attr_no = panel.form.getValues().attr_no;
						if ( attr_no =="" || attr_no==null ){
		            		Ext.MessageBox.alert("bizoss��ʾ","����˳����Ϊ�գ�");
		            		return false;
		            	}else{
		            		document.getElementById("attr_no").value=attr_no;
		            	}
						var default_value = panel.form.getValues().default_value;
						if ( default_value=="" || default_value==null){
		            		Ext.MessageBox.alert("bizoss��ʾ","Ĭ��ֵ����Ϊ�գ�");
		            		return false;
		            	}else{
		            		document.getElementById("default_value").value=default_value;
		            	}
		            	var attr_desc=panel.form.getValues().attr_desc;
						document.getElementById("attr_desc").value=attr_desc;
		            	var remark=panel.form.getValues().remark;
						document.getElementById("remark").value=remark;
		            	
		            	document.productForm.submit();
		            }
			        },{
			            text: 'ȡ��',
			            handler:function(){
			             win.hide();
			            }
			        }]
	            });
	        }
	        showPanel();
        win.show(this);
    };
		
    
  