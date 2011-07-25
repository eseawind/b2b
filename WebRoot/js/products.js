		  function checkContent(){
		     var content=document.getElementById("content").value;
		     var rsrv_str5=document.getElementById("rsrv_str5").value;
		     if(content==null || content==""){
		        alert("请填写你的评论,本站欢迎发表你的评论！");
		        return false;
		     }else if(content.length>250){
		       alert("评论内容不能太长！可以多次发表你的评论！");
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
					alert("请选中要进行对比的信息！");
					return false;
				}else{
					$("idx").value=compara
					$("commpara").submit();
				}
			} else {
				alert("没有要进行对比的信息!");
				return false;
			}
		}