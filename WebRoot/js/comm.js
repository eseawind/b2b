//resumeInfo.jsp
    	function autoSubmit(){
    		if(document.getElementById('user_id').value==''){
    				alert('ÇëµÇÂ½£¡');
    				window.open('/member/index.jsp','_self','');
    				//window.close();
    		}else{
    	document.resumeForm.submit();}
    	}