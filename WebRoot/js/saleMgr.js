	  function Check_Value(){
	       if(document.getElementById("start_time").value ==null || document.getElementById("start_time").value ==""){
	        alert("��ѡ��ʼʱ�䣡");
	        return false;
	       }
	       if(document.getElementById("end_time").value ==null || document.getElementById("end_time").value ==""){
	        alert("��ѡ�����ʱ�䣡");
	        return false;
	       }
	    document.indexdateform.submit();
	  }
	 function search(){
	 	document.getElementById("code").value="1";
	 	document.indexdateform.submit();
	 }