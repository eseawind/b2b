// 设置城市信息
function setCityInfo(prov_id) {
	if (prov_id != "0") {
		AreaInfo.getAreaByParent(prov_id, function(data) {
			DWRUtil.removeAllOptions("city");
			var fectureArray = new Array();
			fectureArray = ['地市信息..'];
			DWRUtil.addOptions("city", fectureArray);
			DWRUtil.addOptions("city", data);
		});
	} else {
		DWRUtil.removeAllOptions("city");
		var fectureArray = new Array();
		fectureArray = ['地市信息..'];
		DWRUtil.addOptions("city", fectureArray);
	}
}

// 搜索供应信息
function searchSupply() {
	alert('1111111');
	var prov = $F("prov");
	var city = $F("city");
	alert(prov + "====" + city);
	return true;
}

// 设置文本框里的值
function setTextValue() {
	var key = $F("key");
	key = delAllSpace(key);
	if (key == '' || key == null) {
		$('key').value = '请输入产品名称或关键字';
	}
}
// 自动载入页面
function autoLoad(page, type) {
	secBoard(type);
}

// 供应信息列表页面
function saleList(page) {
	changeShow(0);
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater('sale-list', 'stockList.jsp?sys_code=0&page='
			+ page + "&data=" + data, {
		method : 'get',
		evalScripts : true
	});
}

// 最新供应信息列表页面
function saleNewList(page) {
	changeShow(1);
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater('sale-new-list',
			'stockOrderList.jsp?sys_code=1&page=' + page + "&data=" + data, {
				method : 'get',
				evalScripts : true
			});
}

// 供应信息和最新供应信息列表之间的转换
function secBoard(n) {
	if (n == 0) {
		$("sale-list").style.display = 'block'
		$("sale-new-list").style.display = 'none'
		$("td0").className = 'ec4';
		$("td1").className = 'ec3';
	} else {
		$("sale-list").style.display = 'none'
		$("sale-new-list").style.display = 'block'
		$("td0").className = 'ec3'
		$("td1").className = 'ec4'
	}
}

// 改变显示方式
function changeShow(n) {
	if (n == 0) {
		$("sale-list").style.display = 'block'
		$("sale-new-list").style.display = 'none'
		$("td0").className = 'ec4';
		$("td1").className = 'ec3';
	} else {
		$("sale-list").style.display = 'none'
		$("sale-new-list").style.display = 'block'
		$("td0").className = 'ec3'
		$("td1").className = 'ec4'
	}
}
// 最新供应信息比较
function orderCompare() {
	var compara = "";
	var size = $F("n_size");
	if (size > 0) {
		for (var i = 0; i < size; i++) {
			var obj = "sale_n" + i;
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
// 供应信息比较
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

/**
 * 删除所有空格
 */
function delAllSpace(str) {
	return str.replace(/^\s+|\s+$/g, "")
}

	 function sendStockMsg(){
	   if($F("log_user_id")==""){
	   		alert("请登陆！");
	   		return false;
	   }
	   var rsrv_str3=$F("rsrv_str3");
	   rsrv_str3=delAllSpace(rsrv_str3);
	   if(rsrv_str3=="" || rsrv_str3==null){
	    alert("请输入报价标题！");
	    $("rsrv_str3").focus();
	    return false;
	   }
	   var content=$F("content");
	   content=delAllSpace(content);
	   if(content=="" || content==null){
	    alert("请输入报价补充信息！");
	    $("content").focus();
	     return false;
	   }
	   return true;
	 }
	
	function ResizeImages()
	{
	   var myimg,oldwidth;
	   var maxwidth=600;
	   for(i=0;i<document.images.length;i++){
	     myimg = document.images[i];
	     if(myimg.width > maxwidth)
	     {
	        oldwidth = myimg.width;
	        myimg.style.width = maxwidth;
	        myimg.style.height = "auto";
	     }
	   }
	}
	
			 function remove(obj){
		  if(window.confirm("您确定要移除该信息吗？")){
		    $(obj).style.display="none";
		  }
		 }