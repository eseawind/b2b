

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

function setCityInfo_left(prov_id) {
	if (prov_id != "0") {
		AreaInfo.getAreaByParent(prov_id, function(data) {
			DWRUtil.removeAllOptions("city_l");
			var fectureArray = new Array();
			fectureArray = ['地市信息..'];
			DWRUtil.addOptions("city_l", fectureArray);
			DWRUtil.addOptions("city_l", data);
		});
	} else {
		DWRUtil.removeAllOptions("city_l");
		var fectureArray = new Array();
		fectureArray = ['地市信息..'];
		DWRUtil.addOptions("city_l", fectureArray);
	}
}

// 搜索供应信息
function searchSupply() {
	var prov = DWRUtil.getText('prov');
	var city = DWRUtil.getText('city');
	var part = document.getElementById('part').value;
	if(prov=='省份信息'){
		prov='';
		alert('请选择省份!');
		return false;
	}
	if(city=='地市信息'||city=='地市信息..'){
		city='';
	}
	if(part=='0'){
		alert('请选择信息分类！');
		return false;
	}
	var key = document.getElementById('key').value;
	if(key=='请输入产品名称或关键字'){
		key='';
	}
	window.open('/supply/selectSupplyList.jsp?prov='+prov+'&city='+city+'&key='+key+'&part='+part+'');
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
	if (type == "0") {
		saleList(page);
	} else {
		saleNewList(page);
	}
}

// 供应信息列表页面
function saleList(page) {
	changeShow(0);
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater('sale-list', 'saleList.jsp?sys_code=0&page='
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
			'saleOrderList.jsp?sys_code=1&page=' + page + "&data=" + data, {
				method : 'get',
				evalScripts : true
			});
}

// 供应信息和最新供应信息列表之间的转换
function secBoard(n) {
	var page = "1";
	if (n == 0) {
		$("sale-list").style.display = 'block'
		$("sale-new-list").style.display = 'none'
		$("td0").className = 'ec4';
		$("td1").className = 'ec3';
		//saleList(page);
	} else {
		$("sale-list").style.display = 'none'
		$("sale-new-list").style.display = 'block'
		$("td0").className = 'ec3'
		$("td1").className = 'ec4'
		//saleNewList(page);
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

//设置关键字

function setProductKey(){
	var product=$F("product_name");
	product=delAllSpace(product);
	if(product=="" || product==null){
		$("product_name").value="请输入供应主题或关键字！";
	}
}

function searchLeft(){
	var product_name = document.getElementById('product_name').value;
	var pro = DWRUtil.getText('prov_1');
	var city= DWRUtil.getText('city_l');
	var pro_city = pro+city;	
	var date_scope = document.getElementById('date').value;
	if(product_name=='' || product_name==null){
		product_name='a';
	}
	if(product_name=='请输入供应主题或关键字！'){
		product_name='';
	}
	if(pro=='全省信息'){
		pro='';
	}
	if(city=='请选择'){
		city='';
	}
	if(city=='地市信息..'){
		city='';
	}
	if(date_scope=='0'){
		date_scope='365';
	}

	window.open('/supply/searchSupplyList.jsp?product_name='+product_name+'&pro='+pro+'&city='+city+'&date='+date_scope);
}


 function checkValue(){
	 	 if(document.getElementById("session_user_id").value==''){
	 	 		alert('请登陆！');
	 	 		return false;
	 	 }
	   var rsrv_str3=$F("rsrv_str3");
	   rsrv_str3=delAllSpace(rsrv_str3);
	   if(rsrv_str3=="" || rsrv_str3==null){
	    alert("请输入询价标题！");
	    $("rsrv_str3").focus();
	    return false;
	   }
	   var content=$F("content");
	   content=delAllSpace(content);
	   if(content=="" || content==null){
	    alert("请输入询价补充信息！");
	    $("content").focus();
	     return false;
	   }
	   return true;
	 }
	
	function delAllSpace(str) {
		return str.replace(/^\s+|\s+$/g, "")
	}
	
			 function remove(obj){
		  if(window.confirm("您确定要移除该信息吗？")){
		    $(obj).style.display="none";
		  }
		 }