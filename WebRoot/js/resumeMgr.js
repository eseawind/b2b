			var flag=true;;
			function check(){
				var val=document.getElementById("info_no").value;
				var info_type=document.getElementById("info_type").value;
				OrderCast.checkInfo_no(val,info_type,rezl);
				if(!window.confirm("你确定推荐吗?")){
					return false;
					};
				if(!flag){
					alert('推荐值已存在,请重新输入');
					window.location.reload();
					}
			return flag;
			}
			
			
			
			function rezl(val){
				if(!val){
					flag=false;
				}
			}
			
	//function checkNews(){
		//alert("你好");
		//var val=document.getElementById("info_no").value;
		//var info_type=document.getElementById("info_type").value;
		//var news_type=document.getElementById("news_type").value;
		//alert(news_type);
		//OrderCast.checkNewsInfo_no(val,info_type,news_type,rezl);
		//if(!window.confirm("你确定推荐吗?")){
		//	return false;
		//	};
		//if(!flag){
		//	alert('推荐值已存在,请重新输入');
		//	}
	//return flag;
//	}