	function back_message()
	{
		  document.getElementById("trade_type_code").value="2124";
		  document.classForm.submit();
		  window.location='receiveFeedbackInfo.jsp';
			return true;
	}
	function reSend_message()
	{
		  var rid = document.getElementById( "root_id" ).value;
			document.getElementById("trade_type_code").value="2124";
			document.classForm.submit();
			window.location='feedbackInfo.jsp?root_id='+rid;
			return true;
	}
  function del_message()
	{
		 document.getElementById("trade_type_code").value="2123";
		 document.classForm.submit();
		 window.location='receiveFeedbackInfo.jsp'; 
		 
	   return true;
	}
	
			function formCheckout()
		{
			if(document.getElementById("title").value.replace(/\s*/g,"")=="" || document.getElementById("title").value.replace(/\s*/g,"")==null)
	  	{
						alert("���ⲻ��Ϊ��!");
						document.getElementById("title").focus();
						return false;
		  }
		  
		  if(document.getElementById("phone").value.replace(/\s*/g,"")=="" || document.getElementById("phone").value.replace(/\s*/g,"")==null)
	  	{
						alert("�绰����Ϊ��!");
						document.getElementById("phone").focus();
						return false;
		  }
		  var phone = document.getElementById("phone").value;
		  var str=phone;
			var Expression=/(\d{3}-)?\d{8}|(\d{4}-)(\d{7})/; 
			var objExp=new RegExp(Expression);
			if(objExp.test(str)==true){
			}else{
				alert('�绰��ʽ����ȷ��');
				return false;
			}
		  
			 if(document.getElementById("content").value.replace(/\s*/g,"")=="" || document.getElementById("content").value.replace(/\s*/g,"")==null)
	   	{
					alert("���ݲ���Ϊ��!!!");
					document.getElementById("content").focus();
					return false;
			}
				return true;
			}
			
	
		function fresh()
	{
			window.opener.document.location.reload()
	}