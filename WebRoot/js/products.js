		  function checkContent(){
		     var content=document.getElementById("content").value;
		     var rsrv_str5=document.getElementById("rsrv_str5").value;
		     if(content==null || content==""){
		        alert("����д�������,��վ��ӭ����������ۣ�");
		        return false;
		     }else if(content.length>250){
		       alert("�������ݲ���̫�������Զ�η���������ۣ�");
		       return false;
		     }
		    return true;
		  }
		  
		  		  function saleCompare() {
			var compara = "";
			var size = $F("s_size");
			if (size > 0) {
				for (var i = 0; i < size; i++) {
					var obj = "sale_" + i;
					var product = $(obj);
					if (product.checked) {
						compara = compara + $F(obj) + "|";
					}
				}
				if (compara == null || compara == "") {
					alert("��ѡ��Ҫ���жԱȵ���Ϣ��");
					return false;
				}else{
					$("idx").value=compara
					$("commpara").submit();
				}
			} else {
				alert("û��Ҫ���жԱȵ���Ϣ!");
				return false;
			}
		}