			var flag=true;;
			function check(){
				var val=document.getElementById("info_no").value;
				var info_type=document.getElementById("info_type").value;
				OrderCast.checkInfo_no(val,info_type,rezl);
				if(!window.confirm("��ȷ���Ƽ���?")){
					return false;
					};
				if(!flag){
					alert('�Ƽ�ֵ�Ѵ���,����������');
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
		//alert("���");
		//var val=document.getElementById("info_no").value;
		//var info_type=document.getElementById("info_type").value;
		//var news_type=document.getElementById("news_type").value;
		//alert(news_type);
		//OrderCast.checkNewsInfo_no(val,info_type,news_type,rezl);
		//if(!window.confirm("��ȷ���Ƽ���?")){
		//	return false;
		//	};
		//if(!flag){
		//	alert('�Ƽ�ֵ�Ѵ���,����������');
		//	}
	//return flag;
//	}