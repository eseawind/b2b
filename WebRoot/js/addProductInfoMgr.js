	function modiproductCheck_Value()
	{
			if(document.getElementById('class_id').value==''){
		  		alert('��ѡ���Ʒ�ͺţ�');
		  		return false;
		  }
		  if(document.getElementById('class_name').value==''){
		  		alert('��Ʒ�ͺ����Ʋ���Ϊ�գ�');
		  		return false;
		  }
	}
	
	function delCheck_Value()
	{
			if(document.getElementById('class_id').value==''){
		  		alert('��ѡ���Ʒ�ͺţ�');
		  		return false;
		  }
		  if(document.getElementById('class_name').value==''){
		  		alert('��Ʒ�ͺ����Ʋ���Ϊ�գ�');
		  		return false;
		  }
		  document.getElementById('trade_type_code').value = '1223';
	}