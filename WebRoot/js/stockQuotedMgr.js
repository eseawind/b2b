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
	 	document.getElementById('code').value='1';
	 	document.indexdateform.submit();
	 }
	 
	 		 function check_Value(){
		   var content=$F("content");
		   content=delAllSpace(content);
		   if(content=="" || content==null){
		    alert("������ظ����ݣ�");
		    $("content").focus();
		     return false;
		   }
		   return true;
		 }
		 //ɾ�����пո�
		 function delAllSpace(str) {
			return str.replace(/^\s+|\s+$/g, "")
		 }