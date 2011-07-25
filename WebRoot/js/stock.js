
/**
 * 采购信息主页
 */

function secBoard(n) {
	if (n == 0) {
		$("tbo0").style.display = 'block'
		$("tbo1").style.display = 'none'
		$("td0").className = 'ec4';
		$("td1").className = 'ec3';
	} else {
		$("tbo0").style.display = 'none'
		$("tbo1").style.display = 'block'
		$("td0").className = 'ec3'
		$("td1").className = 'ec4'
	}
}

/**
 * 采购信息搜索
 */
function searchStock() {
	var stock_key = document.getElementById('stock_key').value;
	var date=document.getElementById('date').value;
	var pro = DWRUtil.getText('prov');
	var city= DWRUtil.getText('city');
	if(pro=='全省信息'){
		pro='';
	}
	if(city=='请选择'){
		city='';
	}
	if(city=='地市信息..'){
		city='';
	}
	if(stock_key=='请输入求购主题或关键字！'){
	    stock_key='';
	}
	if(date=='请选择' || date=='0'){
		date='';
	}
	window.open('/stock/searchStockList.jsp?stock_key='+stock_key+'&pro='+pro+'&city='+city+'&date='+date+'');
	return true;
}

/**
 * 检测关键字
 */
function checkStockKeyWord(){
	var stock_key=$F("stock_key");
	if(stock_key=="" || stock_key==null){
		$("stock_key").value="请输入产品名称";
	}
}

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
