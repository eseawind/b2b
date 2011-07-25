

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
			DWRUtil.removeAllOptions("city_l");
			var fectureArray = new Array();
			fectureArray = ['������Ϣ..'];
			DWRUtil.addOptions("city_l", fectureArray);
			DWRUtil.addOptions("city_l", data);
		});
	} else {
		DWRUtil.removeAllOptions("city_l");
		var fectureArray = new Array();
		fectureArray = ['������Ϣ..'];
		DWRUtil.addOptions("city_l", fectureArray);
	}
}

// ������Ӧ��Ϣ
function searchSupply() {
	var prov = DWRUtil.getText('prov');
	var city = DWRUtil.getText('city');
	var part = document.getElementById('part').value;
	if(prov=='ʡ����Ϣ'){
		prov='';
		alert('��ѡ��ʡ��!');
		return false;
	}
	if(city=='������Ϣ'||city=='������Ϣ..'){
		city='';
	}
	if(part=='0'){
		alert('��ѡ����Ϣ���࣡');
		return false;
	}
	var key = document.getElementById('key').value;
	if(key=='�������Ʒ���ƻ�ؼ���'){
		key='';
	}
	window.open('/supply/selectSupplyList.jsp?prov='+prov+'&city='+city+'&key='+key+'&part='+part+'');
	return true;
}

// �����ı������ֵ
function setTextValue() {
	var key = $F("key");
	key = delAllSpace(key);
	if (key == '' || key == null) {
		$('key').value = '�������Ʒ���ƻ�ؼ���';
	}
}
// �Զ�����ҳ��
function autoLoad(page, type) {
	if (type == "0") {
		saleList(page);
	} else {
		saleNewList(page);
	}
}

// ��Ӧ��Ϣ�б�ҳ��
function saleList(page) {
	changeShow(0);
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater('sale-list', 'saleList.jsp?sys_code=0&page='
			+ page + "&data=" + data, {
		method : 'get',
		evalScripts : true
	});
}

// ���¹�Ӧ��Ϣ�б�ҳ��
function saleNewList(page) {
	changeShow(1);
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater('sale-new-list',
			'saleOrderList.jsp?sys_code=1&page=' + page + "&data=" + data, {
				method : 'get',
				evalScripts : true
			});
}

// ��Ӧ��Ϣ�����¹�Ӧ��Ϣ�б�֮���ת��
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

// �ı���ʾ��ʽ
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
// ���¹�Ӧ��Ϣ�Ƚ�
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
// ��Ӧ��Ϣ�Ƚ�
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
/**
 * ɾ�����пո�
 */
function delAllSpace(str) {
	return str.replace(/^\s+|\s+$/g, "")
}

//���ùؼ���

function setProductKey(){
	var product=$F("product_name");
	product=delAllSpace(product);
	if(product=="" || product==null){
		$("product_name").value="�����빩Ӧ�����ؼ��֣�";
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
	if(product_name=='�����빩Ӧ�����ؼ��֣�'){
		product_name='';
	}
	if(pro=='ȫʡ��Ϣ'){
		pro='';
	}
	if(city=='��ѡ��'){
		city='';
	}
	if(city=='������Ϣ..'){
		city='';
	}
	if(date_scope=='0'){
		date_scope='365';
	}

	window.open('/supply/searchSupplyList.jsp?product_name='+product_name+'&pro='+pro+'&city='+city+'&date='+date_scope);
}


 function checkValue(){
	 	 if(document.getElementById("session_user_id").value==''){
	 	 		alert('���½��');
	 	 		return false;
	 	 }
	   var rsrv_str3=$F("rsrv_str3");
	   rsrv_str3=delAllSpace(rsrv_str3);
	   if(rsrv_str3=="" || rsrv_str3==null){
	    alert("������ѯ�۱��⣡");
	    $("rsrv_str3").focus();
	    return false;
	   }
	   var content=$F("content");
	   content=delAllSpace(content);
	   if(content=="" || content==null){
	    alert("������ѯ�۲�����Ϣ��");
	    $("content").focus();
	     return false;
	   }
	   return true;
	 }
	
	function delAllSpace(str) {
		return str.replace(/^\s+|\s+$/g, "")
	}
	
			 function remove(obj){
		  if(window.confirm("��ȷ��Ҫ�Ƴ�����Ϣ��")){
		    $(obj).style.display="none";
		  }
		 }