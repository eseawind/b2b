	function modiproductCheck_Value()
	{
			if(document.getElementById('class_id').value==''){
		  		alert('请选择产品型号！');
		  		return false;
		  }
		  if(document.getElementById('class_name').value==''){
		  		alert('产品型号名称不能为空！');
		  		return false;
		  }
	}
	
	function delCheck_Value()
	{
			if(document.getElementById('class_id').value==''){
		  		alert('请选择产品型号！');
		  		return false;
		  }
		  if(document.getElementById('class_name').value==''){
		  		alert('产品型号名称不能为空！');
		  		return false;
		  }
		  document.getElementById('trade_type_code').value = '1223';
	}