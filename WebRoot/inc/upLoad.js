function checkImage() {
	var imag = document.getElementById('files').value;
	if (imag == null || imag == "") {
		alert("请选择要上传的附件！");
		return false;
	} else {
		var pos = imag.lastIndexOf(".");
		var lastname = imag.substring(pos, imag.length)
		if (lastname.toLowerCase() == ".exe"
				|| lastname.toLowerCase() == ".bat"
				|| lastname.toLowerCase() == ".sh"
				|| lastname.toLowerCase() == ".so"
				|| lastname.toLowerCase() == ".dll") {
			alert("您上传的文件类型为" + lastname + "，附件格式类型不正确！");
			return false;
		}
	}
	 return true;
}

  function createCustomer(imag,idx){
	var data=Math.round(Math.random()*10000);
   	var custAjax=new Ajax.Request(
	 '/inc/uploadAttr.jsp?idx='+idx+"&file="+imag+"&datas="+data,{
	  method:'post',
	  onSuccess:showResponse,
	  onFailure: function(){ alert('上传失败...') } 
	 }
	);
   }

   Ext.onReady(function(){
    var win;
    var button = Ext.get('up_laod');
    button.on('click', function(){
     var data=Math.round(Math.random()*10000);
    	var idx=document.getElementById("attach_root_id").value;
        if(!win){
            win = new Ext.Window({
                el:'hello-win',
                layout:'fit',
                width:450,
                autoScroll:true,
                title:'上传附件资料',
                maximizable :true,
                height:220,
                frame:true,
                closeAction:'hide',
                plain: true,
                items:[{
                    autoLoad: {url: '/inc/uploadAttr.jsp', params: "idx="+idx+"&data="+data}               	
                }],
                buttons: [{
			            text: '上传完毕',
			             handler:function(){
			             win.hide();
			             showUpLoadFile(idx);
			            }
			        }]
	            });
	           win.show();
	        }else{
              win.show();
	        }
    });
   });
   function showUpLoadFile(root_id){
   	 var data=Math.round(Math.random()*10000);
     var custAjax=new Ajax.Request(
	 '/inc/attachInfo.jsp?idx='+root_id+"&datas="+data,{
	  method:'post',
	  onSuccess:showResponse,
	  onFailure: function(){document.getElementById("attr-div").innerHTML="读取附件信息失败！";} 
	 }
	);
   }
  function showResponse(response){
    document.getElementById("attr-div").innerHTML=response.responseText;
   }