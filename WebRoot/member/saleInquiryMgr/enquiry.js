
//删除数据
function setDelete(checkbox,del,drop){
	var checkBoxes=document.getElementsByName("chek");
	for(var i=0;i<checkBoxes.length;i++){
	  var obj=checkBoxes[i];
	  if(obj.checked){
	  	obj.checked=false;
	  }
	}
	$(checkbox).checked=true;
	if($(checkbox).checked){
		$(del).style.display="none";
		$(drop).style.display="block";
	}else{
		$(del).style.display="block";
		$(drop).style.display="none";
	}
}

//删除信息
function deleteInfo(){
	if(window.confirm("你确定要删除本条记录？")){
		return true;
	}else{
		return false;
	}
}