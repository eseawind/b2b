//modiattr.jsp
	function modiattrCheck_Value()
	{
			if(document.getElementById("class_id").value=='')
		  {
		  	alert( "��ѡ���ͺ�!" );
			  document.getElementById("radio").checked;
			  return false;
		  }
		  if(document.getElementById("attr_name").value== "" )
		  {
		  	alert( "������������!" );
			  document.getElementById("attr_name").focus();
			  return false;
		  }
		  if(document.getElementById("default_value").value== "" )
		  {
		  	alert( "������Ĭ��ֵ!" );
			  document.getElementById("default_value").focus();
			  return false;
		  }
		  return true;
	}