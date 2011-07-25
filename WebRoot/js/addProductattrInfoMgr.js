//modiattr.jsp
	function modiattrCheck_Value()
	{
			if(document.getElementById("class_id").value=='')
		  {
		  	alert( "请选择型号!" );
			  document.getElementById("radio").checked;
			  return false;
		  }
		  if(document.getElementById("attr_name").value== "" )
		  {
		  	alert( "请输入规格名称!" );
			  document.getElementById("attr_name").focus();
			  return false;
		  }
		  if(document.getElementById("default_value").value== "" )
		  {
		  	alert( "请输入默认值!" );
			  document.getElementById("default_value").focus();
			  return false;
		  }
		  return true;
	}