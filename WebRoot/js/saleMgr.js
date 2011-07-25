	  function Check_Value(){
	       if(document.getElementById("start_time").value ==null || document.getElementById("start_time").value ==""){
	        alert("请选择开始时间！");
	        return false;
	       }
	       if(document.getElementById("end_time").value ==null || document.getElementById("end_time").value ==""){
	        alert("请选择结束时间！");
	        return false;
	       }
	    document.indexdateform.submit();
	  }
	 function search(){
	 	document.getElementById("code").value="1";
	 	document.indexdateform.submit();
	 }