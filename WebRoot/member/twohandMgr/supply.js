/**
 * ���ݼ��
 */

var type = "5";
 function clickSel(val,valId){
	if(val=="0"){
		document.getElementById(valId).value = "1";
	}else{
		document.getElementById(valId).value = "0";
	}
}
function checkInfo() {
	if (document.getElementById("title").value.replace(/\s*/g, "") == ""
			|| document.getElementById("title").value.replace(/\s*/g, "") == null) {
		alert("������Ϣ���Ʋ���Ϊ��!!!");
		document.getElementById("title").focus();
		return false;
	}
	if (document.getElementById("class_id").value=="" || document.getElementById("class_id").value==null) {
		alert("��ѡ�������Ϣ��");
		return false;
	}

	var str = content.getHTML();
	str = str.replace(/\s*/g, "");
	if (str == "") {
		alert("����д��Ʒ������");
		return false;
	}
	if (document.getElementById("start_date").value == "") {
		alert("��Ч��ʼʱ�䲻����Ϊ�գ�");
		document.getElementById("start_date").focus();
		return false;
	}
	if (document.getElementById("end_date").value == "") {
		alert("��Ч��ֹʱ�䲻����Ϊ�գ�");
		document.getElementById("end_date").focus();
		return false;
	}
	if (document.getElementById("sale_price").value == "" || document.getElementById("sale_price").value == null) {
		alert("���ۼ۸񲻿���Ϊ�գ�");
		document.getElementById("sale_price").focus();
		return false;
	}
	if (document.getElementById("commodity_price").value == "" || document.getElementById("commodity_price").value == null) {
		alert("ԭ�۲�����Ϊ�գ�");
		document.getElementById("commodity_price").focus();
		return false;
	} 
	if (document.getElementById("sale_addr").value == "" || document.getElementById("sale_addr").value == null) {
		alert("���۵�ַ������Ϊ�գ�");
		document.getElementById("sale_addr").focus();
		return false;
	}
	document.getElementById("contents").value = document.getElementById("one").value + document.getElementById("two").value + document.getElementById("three").value;
	alert(document.getElementById("contents").value);
	document.getElementById("class_id_grp").value = "000000000000000|"+document.getElementById("sort1").value+"|"+document.getElementById("sort2").value;
	
	return false;
}
// ����Ƿ�Ϊ�Ϸ�����
function isNum(str) {
	return (str.search(/^\d+(\.\d+)?$/) != -1);
}
// ���ö�������
function setSecondClass(val) {
	var up_class_id = val;
	$("rsrv_str1").value = "2";
	Productclass.getProductClassByUpId(up_class_id, type, setSort2);
}
function setSort2(map_data) {
	DWRUtil.removeAllOptions("sort2");
	DWRUtil.addOptions("sort2", map_data);
	$("sort3").style.display = "none";
	$("nextElement").style.display = "none";
	var item = $("sort2").length;
	if (item == 0) {
		$("sort2").style.display = "none";
	} else {
		$("sort2").style.display = "block";
	}
}
// ������������
function setTherdClass(val) {
	var up_class_id = val;
	$("rsrv_str1").value = "3";
	Productclass.getProductClassByUpId(up_class_id, type, setSort3);
}
function setSort3(map_data) {
	if (map_data != null) {
		DWRUtil.removeAllOptions("sort3");
		DWRUtil.addOptions("sort3", map_data);
		var item = $("sort3").length;
		if (item == 0) {
			$("sort3").style.display = "none";
			$("nextElement").style.display = "none";
		} else {
			$("sort3").style.display = "block";
		}
	}
}
function setTypeName(obj){
	  var idx=obj.value;
		document.getElementById("class_id").value=idx;
		Productclass.getClassNameById(idx,setClassName);
		//document.getElementById("class_name").value=DWRUtil.getText(obj.name);
		//document.getElementById("count").value=obj.name;
}

function setClassName(val) {
	document.getElementById("class_name").value=val;
}

// ��̬�����¼�������Ϣ
function cretateSelect(index, value) {
	$("nextElement").style.display = "block";
	$("rsrv_str1").value = "4";
	var divId = parseInt(index) + parseInt(1);
	$("index_s").value = index;
	$(index).innerHTML = "<select name=sort" + index + " id=sort" + index
			+ " onchange=cretateSelect(" + divId
			+ ",this.value) size=3  style=width:130px></select><div id="
			+ divId + "></div>";
	DWRUtil.removeAllOptions("sort" + index);
	Productclass.getProductClassByUpId(value, type, setNewSelect);
}
// �ص�����
function setNewSelect(map_data) {
	var id = $("index_s").value;
	DWRUtil.addOptions("sort" + id, map_data);
	var item = $("sort" + id).length;
	if (item == 0) {
		$(id).style.display = "none";
	} else {
		$(id).style.display = "block";
	}
}
