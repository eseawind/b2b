
/**
 * �ɹ���Ϣ��ҳ
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
 * �ɹ���Ϣ����
 */
function searchStock() {
	var stock_key = document.getElementById('stock_key').value;
	var date=document.getElementById('date').value;
	var pro = DWRUtil.getText('prov');
	var city= DWRUtil.getText('city');
	if(pro=='ȫʡ��Ϣ'){
		pro='';
	}
	if(city=='��ѡ��'){
		city='';
	}
	if(city=='������Ϣ..'){
		city='';
	}
	if(stock_key=='�������������ؼ��֣�'){
	    stock_key='';
	}
	if(date=='��ѡ��' || date=='0'){
		date='';
	}
	window.open('/stock/searchStockList.jsp?stock_key='+stock_key+'&pro='+pro+'&city='+city+'&date='+date+'');
	return true;
}

/**
 * ���ؼ���
 */
function checkStockKeyWord(){
	var stock_key=$F("stock_key");
	if(stock_key=="" || stock_key==null){
		$("stock_key").value="�������Ʒ����";
	}
}

// ���ó�����Ϣ
function setCityInfo(prov_id) {
	if (prov_id != "0") {
		AreaInfo.getAreaByParent(prov_id, function(data) {
			DWRUtil.removeAllOptions("city");
			var fectureArray = new Array();
			fectureArray = ['������Ϣ..'];
			DWRUtil.addOptions("city", fectureArray);
			DWRUtil.addOptions("city", data);
		});
	} else {
		DWRUtil.removeAllOptions("city");
		var fectureArray = new Array();
		fectureArray = ['������Ϣ..'];
		DWRUtil.addOptions("city", fectureArray);
	}
}
function setCityInfo_left(prov_id) {
	if (prov_id != "0") {
		AreaInfo.getAreaByParent(prov_id, function(data) {
			DWRUtil.removeAllOptions("city");
			var fectureArray = new Array();
			fectureArray = ['������Ϣ..'];
			DWRUtil.addOptions("city", fectureArray);
			DWRUtil.addOptions("city", data);
		});
	} else {
		DWRUtil.removeAllOptions("city");
		var fectureArray = new Array();
		fectureArray = ['������Ϣ..'];
		DWRUtil.addOptions("city", fectureArray);
	}
}
